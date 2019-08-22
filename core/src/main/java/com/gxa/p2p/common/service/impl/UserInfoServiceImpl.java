package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserinfoMapper userInfoMapper;

    @Override
    public void add(Userinfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public Userinfo getCurrentUserinfo(Long id) {
        Userinfo userinfo=new Userinfo();

        return null;
    }

}
