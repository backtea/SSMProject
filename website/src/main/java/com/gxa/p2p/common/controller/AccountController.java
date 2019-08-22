package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.ISystemDictionaryItemService;
import com.gxa.p2p.common.service.impl.SystemDictionaryItemImpl;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 个人中心 - 账户信息
 *
 * @author novo
 */
@Controller
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("personal")
    public String personalCenter(Model model) {

        Logininfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo", loginInfo);

        Account account= accountMapper.getMoneyMsg(loginInfo.getId());
        model.addAttribute("account", account);

        return "personal";
    }

}