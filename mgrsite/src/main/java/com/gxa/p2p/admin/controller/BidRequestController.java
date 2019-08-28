package com.gxa.p2p.admin.controller;

import com.gxa.p2p.common.query.BidrequestQueryObject;
import com.gxa.p2p.common.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BidRequestController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("bidrequest_publishaudit_list")
    public String bidrequestPublishaudit(BidrequestQueryObject bidrequestQueryObject, Model model){
        model.addAttribute("pageResult",iLoginInfoService.queryBidrequestForPage(bidrequestQueryObject));
        return "bidrequest/publish_audit";
    }
}
