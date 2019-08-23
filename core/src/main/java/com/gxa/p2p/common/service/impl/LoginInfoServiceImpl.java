package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.LogininfoMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IIpLogService;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IIpLogService iIpLogService;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }

    /**
     * 新用户注册
     *
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        /*
         * 逻辑思路
         * 1. 判断用户名是否存在
         * 2. 如果不存在,设值并保存这个对象
         * 3. 如果存在,直接抛错
         *
         */
        int count = checkUsername(username);

        if (count <= 0) {
            Logininfo li = new Logininfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(Logininfo.STATE_NORMAL);
            li.setUsertype(Logininfo.USER_WEB);
            logininfoMapper.insert(li);
            Long id = li.getId();
            Account account = new Account();
            account.setId(id);
            iAccountService.add(account);

            // 初始化个人资料UserInfo
            Userinfo userInfo = new Userinfo();
            userInfo.setId(id);
            iUserInfoService.add(userInfo);

        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }
    }

    /**
     * 登录的时候检查用户是否存在
     */
    @Override
    public int loginCheckUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     */
    @Override
    public Logininfo login(String username, String password, HttpServletRequest request, Byte usertype) {

        Logininfo loginInfo = logininfoMapper.login(username, password, usertype);

        Iplog iplog = new Iplog();
        iplog.setIp(request.getRemoteAddr());
        iplog.setUsername(username);
        iplog.setUsertype(loginInfo.getUsertype());
        iplog.setLogininfoid(loginInfo.getId());
        iplog.setLogintime(new Date());

        if (loginInfo!=null) {
            /* 将登录用户的数据，通过UserContext工具类，存放至session*/
            UserContext.putLoginInfo(loginInfo);
            iplog.setState(Iplog.LOGIN_SUCCESS);
        } else {
            iplog.setState(Iplog.LOGIN_FAILED);
        }
        iIpLogService.add(iplog);
        return loginInfo;
    }

    /**
     * 用户信息分页查询
     *
     * @param loginInfoQueryObject
     * @return
     */
    @Override
    public PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject) {

        int count = logininfoMapper.queryForCount();

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<Logininfo> list = logininfoMapper.queryForPage(loginInfoQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    loginInfoQueryObject.getCurrentPage(),
                    loginInfoQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(loginInfoQueryObject.getPageSize());
        }

        return pageResultSet;
    }

}