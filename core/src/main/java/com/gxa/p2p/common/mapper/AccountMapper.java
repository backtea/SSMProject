package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    Account selectByPrimaryKey(Long id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);

    Account getMoneyMsg(@Param("id") Long id);
}