package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    /*查询用户名是否存在*/
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        int count = iLoginInfoService.checkUsername(username);
        return count <= 0;
    }

    /*注册*/
    @RequestMapping("register")
    @ResponseBody
    public JSONResult register(String username, String password) {

        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.register(username, password);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

    /*登录的时候检查页面*/
    @RequestMapping("loginCheckUsername")
    @ResponseBody
    public boolean loginCheckUsername(String username) {
        int count = iLoginInfoService.loginCheckUsername(username);
        return count > 0;
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpServletRequest request) {

        Logininfo loginInfo = iLoginInfoService.login(username, password, request, Logininfo.USER_WEB);

        JSONResult json = new JSONResult();
        if(null == loginInfo){
            json.setSuccess(false);
            json.setMsg("登录失败,用户名或密码无效");
        }
        return json;
    }

}


