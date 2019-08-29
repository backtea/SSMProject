package com.gxa.p2p.business.mapper;

import com.gxa.p2p.business.domain.Bidrequestaudithistory;
import java.util.List;

public interface BidrequestaudithistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bidrequestaudithistory record);

    Bidrequestaudithistory selectByPrimaryKey(Long id);

    List<Bidrequestaudithistory> selectAll();

    int updateByPrimaryKey(Bidrequestaudithistory record);
}