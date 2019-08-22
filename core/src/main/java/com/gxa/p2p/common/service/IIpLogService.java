package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Iplog;

public interface IIpLogService {
    /**
     * 新增登录日志
     *
     * @param iplog
     */
    void add(Iplog iplog);

}
