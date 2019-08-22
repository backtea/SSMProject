package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Logininfo;

import javax.servlet.http.HttpServletRequest;

public interface ILoginInfoService {
    int checkUsername(String username);

    void register(String username, String password);

    int loginCheckUsername(String username);

    /**
     * 用户登录
     *  @param username
     * @param password
     */
    Logininfo login(String username, String password, HttpServletRequest request, Byte usertype);


}
