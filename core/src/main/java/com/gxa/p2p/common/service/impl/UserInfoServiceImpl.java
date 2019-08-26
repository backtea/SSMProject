package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.service.IVerifyCodeService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userInfoMapper;

    @Autowired
    private IVerifyCodeService iVerifyCodeService;

    @Override
    public void add(Userinfo userInfo) {
        int count=userInfoMapper.insert(userInfo);
        if (count==0){
            throw new RuntimeException("新增失败");
        }
    }

    @Override
    public Userinfo getCurrentUserinfo(Long id) {
        Userinfo userinfo=userInfoMapper.selectByPrimaryKey(id);
        return userinfo;
    }

    @Override
    public void updateUserInfo(Userinfo userinfo){
        int count=userInfoMapper.updateByPrimaryKey(userinfo);
        if (count==0){
            throw new RuntimeException("新增失败");
        }
    }
    @Override
    public void updateBasicInfo(Userinfo userInfoVo) {
        try {

            // 获取需要保存userinfo对象（数据库原始对象）
            Logininfo loginInfo = UserContext.getLoginInfo();
            Userinfo userInfo = getCurrentUserinfo(UserContext.getLoginInfo().getId());

            //将页面提交的数据 设置到原有userinfo对象中
            userInfo.setEducationbackgroundItem(userInfoVo.getEducationbackgroundItem());
            userInfo.setKidcountItem(userInfoVo.getKidcountItem());
            userInfo.setIncomegradeItem(userInfoVo.getIncomegradeItem());
            userInfo.setHouseconditionItem(userInfoVo.getHouseconditionItem());
            userInfo.setMarriageItem(userInfoVo.getMarriageItem());

            // 设置状态码
            if ( !userInfo.getIsBasicInfo()) {
                userInfo.addState(BitStatesUtils.OP_USER_INFO);
            }

            // 更新个人资料
            updateUserInfo(userInfo);

        } catch (Exception e) {
            throw new RuntimeException("个人资料保存出错");

        }
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        // 先做验证码的校验 (一般关于验证码的都交给验证码相关服务)
        if (iVerifyCodeService.validate(phoneNumber,verifyCode)) {
            //如果校验成功,给当前用户绑定手机号和状态码
            Userinfo userInfo = getCurrentUserinfo(UserContext.getLoginInfo().getId());
            //先判断当前用户是否已经绑定了手机
            if ( !userInfo.getIsBindPhone()) { //表示当前没有绑定手机
                //给当前用户添加状态码和手机号
                userInfo.setPhonenumber(phoneNumber);
                userInfo.addState(BitStatesUtils.OP_BIND_PHONE);
                updateUserInfo(userInfo);
            }
        }else{
            throw new RuntimeException("绑定失败");
        }
    }


}
