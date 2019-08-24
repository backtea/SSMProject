package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.query.IpLogQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

public interface IIpLogService {
    /**
     * 新增登录日志
     *
     * @param iplog
     */
    void add(Iplog iplog);

    PageResultSet queryLogForPage(IpLogQueryObject ipLogQueryObject);

}
