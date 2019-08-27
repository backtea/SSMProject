package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.ISystemDictionaryItemService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private ISystemDictionaryItemService iSystemDictionaryItemService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("userInfo")
    public String UserInfo(Model model){
        Logininfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo",loginInfo);
        Userinfo userinfo=userinfoMapper.selectById(loginInfo.getId());
        model.addAttribute("userinfo",userinfo);
        List<Systemdictionaryitem> list=iSystemDictionaryItemService.listByParentSn("educationBackground");
        model.addAttribute("educationBackgrounds",list);
        model.addAttribute("incomeGrades",iSystemDictionaryItemService.listByParentSn("incomeGrade"));
        model.addAttribute("marriages",iSystemDictionaryItemService.listByParentSn("marriage"));
        model.addAttribute("kidCounts",iSystemDictionaryItemService.listByParentSn("kidCount"));
        model.addAttribute("houseConditions",iSystemDictionaryItemService.listByParentSn("houseCondition"));
        return "userInfo";
    }

    @RequestMapping("userInfo_save")
    @ResponseBody
    public JSONResult userInfoSave(Userinfo userInfo) {

        JSONResult json = new JSONResult();
        try {
            iUserInfoService.updateBasicInfo(userInfo);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }

    /**
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public JSONResult bindPhone(String phoneNumber, String verifyCode) {
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    /**
     * 绑定邮件
     */
    @RequestMapping("bindEmail")
    public String bingEmail(String code, Model model) {
        System.out.println(code);
        try {
            iUserInfoService.bindEmail(code);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("success", false);
            model.addAttribute("msg", e.getMessage());
        }
        return "checkmail_result";
    }


}
