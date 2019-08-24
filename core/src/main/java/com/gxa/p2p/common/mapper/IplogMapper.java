package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.query.IpLogQueryObject;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IplogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Iplog record);

    Iplog selectByPrimaryKey(Long id);

    List<Iplog> selectAll();

    int updateByPrimaryKey(Iplog record);

    int queryLogForCount(IpLogQueryObject ipLogQueryObject);

    List<Iplog> QueryLogForPage(IpLogQueryObject ipLogQueryObject);
}