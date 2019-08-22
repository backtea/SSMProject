package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Userinfo;

public interface IUserInfoService {

    /**
     * 新增个人资料
     *
     * @param userInfo
     */
    void add(Userinfo userInfo);

    Userinfo getCurrentUserinfo(Long id);

    /**
     * 用户基本资料的保存
     *
     * @param userInfo
     */
    public void updateBasicInfo(Userinfo userInfo);

    void updateUserInfo(Userinfo userinfo);

}
