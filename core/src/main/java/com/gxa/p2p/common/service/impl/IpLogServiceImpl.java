package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.query.IpLogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IIpLogService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpLogServiceImpl implements IIpLogService {

    @Autowired
    private IplogMapper iplogMapper;

    @Override
    public void add(Iplog iplog) {
        iplogMapper.insert(iplog);
    }

    @Override
    public PageResultSet queryLogForPage(IpLogQueryObject ipLogQueryObject) {
        int count = iplogMapper.queryLogForCount(ipLogQueryObject.getUsername());
        PageResultSet pageResultSet;
        if (count > 0) {
            List<Iplog> list = iplogMapper.QueryLogForPage(ipLogQueryObject);
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    ipLogQueryObject.getCurrentPage(),
                    ipLogQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(ipLogQueryObject.getPageSize());
        }
        return pageResultSet;
    }
}
