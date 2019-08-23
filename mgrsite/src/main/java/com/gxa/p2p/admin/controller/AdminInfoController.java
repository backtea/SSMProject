package com.gxa.p2p.admin.controller;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    /*查询用户名是否存在*/
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        int count = iLoginInfoService.checkUsername(username);
        return count <= 0;
    }

    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpServletRequest request) {

        Logininfo loginInfo = iLoginInfoService.login(username, password, request, Logininfo.USER_WMGR);

        JSONResult json = new JSONResult();
        if(null == loginInfo){
            json.setSuccess(false);
            json.setMsg("登录失败,用户名或密码无效");
        }
        return json;
    }

    @RequestMapping("main")
    public String loginAdmin(){
        return "main";
    }
}
