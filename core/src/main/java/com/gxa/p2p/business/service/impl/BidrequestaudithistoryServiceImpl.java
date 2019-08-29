package com.gxa.p2p.business.service.impl;

import com.gxa.p2p.business.domain.Bidrequest;
import com.gxa.p2p.business.domain.Bidrequestaudithistory;
import com.gxa.p2p.business.mapper.BidrequestMapper;
import com.gxa.p2p.business.mapper.BidrequestaudithistoryMapper;
import com.gxa.p2p.business.service.IBidrequestaudithistoryService;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BidrequestaudithistoryServiceImpl implements IBidrequestaudithistoryService {

    @Autowired
    private BidrequestMapper bidrequestMapper;

    @Autowired
    private BidrequestaudithistoryMapper bidrequestaudithistoryMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IUserInfoService iUserInfoService;

    @Override
    public void addHistoryInfo(Bidrequestaudithistory bidrequestaudithistory) {
        try {
            Bidrequest bidrequest=bidrequestMapper.selectByPrimaryKey(bidrequestaudithistory.getBidrequestid());
            bidrequestaudithistory.setAudittime(new Date());
            bidrequestaudithistory.setApplytime(bidrequest.getApplytime());
            bidrequestaudithistory.setAuditorId(UserContext.getLoginInfo().getId());
            bidrequestaudithistory.setApplierId(bidrequest.getCreateuserId());

            if (bidrequestaudithistory.getState()==1){
                bidrequestaudithistory.setAudittype(SysConstant.BIDREQUEST_STATE_BIDDING);
            }
            else{
                bidrequestaudithistory.setAudittype(SysConstant.BIDREQUEST_STATE_PUBLISH_REFUSE);
            }
            bidrequestaudithistoryMapper.insert(bidrequestaudithistory);

            /**
             * 之前判断用户是否存在评审借款时，修改了uerinfo表的bidstate
             * 如果已经存在就会被赋值，所以在审核完成之后，需要把状态码移除
             *
             * */
            System.out.println(bidrequest.getCreateuserId());
            Userinfo userinfo=userinfoMapper.selectByPrimaryKey(bidrequest.getCreateuserId());

            userinfo.removeState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
            iUserInfoService.updateUserInfo(userinfo);
            System.out.println("修改状态成功");

            /**
             * 无论投标审核失败与否，在bidrequest表单里面，都应该有一个状态，类似删除的状态
             * 这样在进行页面展示的时候，不应该再在页面展示出来。
             * 通过设置version状态来表示
             * */
            bidrequest.setVersion(0);
            bidrequestMapper.updateByPrimaryKey(bidrequest);
            System.out.println("修改投标乐观锁成功");
        }catch (Exception e) {
            throw new RuntimeException("审核保存出错");
        }
    }
}
