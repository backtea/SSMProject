package com.gxa.p2p.common.controller;

import com.gxa.p2p.business.domain.Bidrequest;
import com.gxa.p2p.business.mapper.BidrequestMapper;
import com.gxa.p2p.business.service.IBidrequestService;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private IBidrequestService iBidrequestService;

    @Autowired
    private BidrequestMapper bidrequestMapper;

    @RequestMapping("borrow")
    public String borrow(Model model) {
        Logininfo loginInfo = UserContext.getLoginInfo();
        Userinfo userinfo=userinfoMapper.selectById(loginInfo.getId());
        model.addAttribute("userinfo",userinfo);
        /**
         * 获取认证后的可借金额
         * */
        model.addAttribute("account",accountMapper.selectByPrimaryKey(loginInfo.getId()));
        return "borrow";
    }

    @RequestMapping("borrowInfo")
    public String borrowInfo(Model model){
        Logininfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("account",accountMapper.selectByPrimaryKey(loginInfo.getId()));
        return "borrow_apply";
    }

    @RequestMapping("borrow_apply")
    public String borrowApply(Bidrequest bidrequest){
        if (!iBidrequestService.addBorrowInfo(bidrequest)){
            return "borrow_apply_result";
        }else {
            return "name";
        }
    }
}
