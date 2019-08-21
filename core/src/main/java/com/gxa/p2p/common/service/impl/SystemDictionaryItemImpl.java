package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDictionaryItemImpl implements ISystemDictionaryItemService {

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    @Override
    public List<Systemdictionaryitem> listByParentSn(String sn){
        return systemdictionaryitemMapper.listByParentSn(sn);
    }
}
