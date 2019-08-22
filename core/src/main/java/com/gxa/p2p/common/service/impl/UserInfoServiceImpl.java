package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userInfoMapper;

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

}
