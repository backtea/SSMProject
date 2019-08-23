package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

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

    /**
     * 分页查询
     *
     * @return
     *
     */
    PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject);



}
