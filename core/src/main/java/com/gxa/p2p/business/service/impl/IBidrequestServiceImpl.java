package com.gxa.p2p.business.service.impl;
import com.gxa.p2p.business.domain.Bidrequest;
import com.gxa.p2p.business.mapper.BidrequestMapper;
import com.gxa.p2p.business.service.IBidrequestService;
import com.gxa.p2p.business.util.CalculatetUtil;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.CalendarUtil;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class IBidrequestServiceImpl implements IBidrequestService {

    @Autowired
    private BidrequestMapper bidrequestMapper;

    @Autowired
    private IUserInfoService iUserInfoService;

    @Override
    public Boolean addBorrowInfo(Bidrequest bidrequest) {
//        如果在数据库已经存在就返回true，否则就返回false
        boolean bidState=false;
        Userinfo userInfo = iUserInfoService.getCurrentUserinfo(UserContext.getLoginInfo().getId());
        if (!userInfo.getIsBindState()){
            userInfo.addState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
            iUserInfoService.updateUserInfo(userInfo);
            bidrequest.setApplytime(new Date());
            bidrequest.setCreateuserId(UserContext.getLoginInfo().getId());
            CalendarUtil.getDate(bidrequest.getApplytime(),bidrequest.getDisabledays());
            bidrequest.setDisabledate(CalendarUtil.getDate(bidrequest.getApplytime(),bidrequest.getDisabledays()));
            bidrequestMapper.insert(bidrequest);
            bidState=true;
        }
        System.out.println(bidState);
        return bidState;
    }
}
