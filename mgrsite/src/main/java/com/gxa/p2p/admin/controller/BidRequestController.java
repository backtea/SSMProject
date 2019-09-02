package com.gxa.p2p.admin.controller;

import com.gxa.p2p.business.domain.Bidrequest;
import com.gxa.p2p.business.domain.Bidrequestaudithistory;
import com.gxa.p2p.business.mapper.BidrequestMapper;
import com.gxa.p2p.business.service.IBidrequestaudithistoryService;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.query.BidrequestQueryObject;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidRequestController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @Autowired
    private IBidrequestaudithistoryService iBidrequestaudithistoryService;

    @Autowired
    private BidrequestMapper bidrequestMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 显示未评审的借款标
     *
     * */
    @RequestMapping("bidrequest_publishaudit_list")
    public String bidrequestPublishaudit(BidrequestQueryObject bidrequestQueryObject, Model model){
        model.addAttribute("pageResult",iLoginInfoService.queryBidrequestForPage(bidrequestQueryObject));
        return "bidrequest/publish_audit";
    }

    /**
     *显示审评一个标之后，无论成功与否都应该从页面删除
     **/
    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public JSONResult publishaudit(Bidrequestaudithistory bidrequestaudithistory){
        JSONResult jsonResult=new JSONResult();
        try {
            bidrequestaudithistory.setBidrequestid(bidrequestaudithistory.getId());
            bidrequestaudithistory.setId(null);
            iBidrequestaudithistoryService.addHistoryInfo(bidrequestaudithistory);
        }catch (RuntimeException re) {
            jsonResult.setSuccess(false);
            jsonResult.setMsg(re.getMessage());
        }
        return jsonResult;
    }

    /**
     * 查看借标详细信息
     * */
    @RequestMapping("borrow_info")
    public String borrowinfo(Long id,Model model){
        Bidrequest bidrequest=bidrequestMapper.selectByPrimaryKey(id);
        model.addAttribute("bidRequest",bidrequest);
        Userinfo userinfo=userinfoMapper.selectByPrimaryKey(bidrequest.getCreateuserId());
        model.addAttribute("userInfo",userinfo);
        return "bidrequest/borrow_info";
    }
}
