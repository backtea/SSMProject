package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.service.IIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpLogServiceImpl implements IIpLogService {

    @Autowired
    private IplogMapper iplogMapper;

    @Override
    public void add(Iplog iplog) {
        iplogMapper.insert(iplog);
    }
}
