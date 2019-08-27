package com.gxa.p2p.business.mapper;

import com.gxa.p2p.business.domain.Bidrequest;

import java.util.List;

public interface BidrequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bidrequest record);

    Bidrequest selectByPrimaryKey(Long id);

    List<Bidrequest> selectAll();

    int selectState(Bidrequest bidrequest);

    int updateByPrimaryKey(Bidrequest record);
}