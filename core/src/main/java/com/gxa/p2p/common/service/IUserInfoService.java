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
    void updateBasicInfo(Userinfo userInfo);

    void updateUserInfo(Userinfo userinfo);

    /**
     *
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     */
    void bindPhone(String phoneNumber, String verifyCode);

    /**
     * 绑定邮箱
     *
     * @param uuid
     */
    void bindEmail(String uuid);

    /**
     * 修改用户状态码
     *
     * */
}
