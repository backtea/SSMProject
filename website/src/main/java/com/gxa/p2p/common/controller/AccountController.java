package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.*;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.query.IpLogQueryObject;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IIpLogService;
import com.gxa.p2p.common.service.ISystemDictionaryItemService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.service.impl.SystemDictionaryItemImpl;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 个人中心 - 账户信息
 *
 * @author novo
 */
@Controller
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private IIpLogService iIpLogService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("personal")
    public String personalCenter(Model model) {

        Logininfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo", loginInfo);

        Userinfo userinfo=iUserInfoService.getCurrentUserinfo(loginInfo.getId());
        model.addAttribute("userinfo",userinfo);
        Account account= accountMapper.getMoneyMsg(loginInfo.getId());
        model.addAttribute("account", account);

        return "personal";
    }

    @RequestMapping("ipLog")
    public String toIpLog(IpLogQueryObject ipLogQueryObject,Model model){
        model.addAttribute("pageResultSet",iIpLogService.queryLogForPage(ipLogQueryObject));
        model.addAttribute("iplogQueryObject",ipLogQueryObject);
        System.out.println(ipLogQueryObject.getBeginDate());
        return "iplog_list";
    }

    /**
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public JSONResult bindPhone(String phoneNumber, String verifyCode) {
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

}