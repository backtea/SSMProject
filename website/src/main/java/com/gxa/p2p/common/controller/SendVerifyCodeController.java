package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.IVerifyCodeService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendVerifyCodeController {

    @Autowired
    private IVerifyCodeService iVerifyCodeService;
    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    @RequestMapping("sendVerifyCode")
    @ResponseBody
    public JSONResult sendVerifyCode(String phoneNumber){
        JSONResult json = new JSONResult();
        try {
            this.iVerifyCodeService.sendVerifyCode(phoneNumber);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json ;
    }

}
