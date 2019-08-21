package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Account;

public interface IAccountService {
    /**
     * 新增账户信息
     *
     * @param account
     */
    void add(Account account);
}
