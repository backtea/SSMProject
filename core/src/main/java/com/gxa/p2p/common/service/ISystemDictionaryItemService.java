package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Systemdictionaryitem;

import java.util.List;

public interface ISystemDictionaryItemService {
    List<Systemdictionaryitem> listByParentSn(String sn);
}
