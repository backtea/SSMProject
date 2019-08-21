package com.gxa.p2p.common.domain;

import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;

public class Account {
    private Long id;

    private String tradepassword;

    private BigDecimal usableamount = SysConstant.ZERO;

    private BigDecimal freezedamount= SysConstant.ZERO;

    private BigDecimal borrowlimit= SysConstant.ZERO;

    private Integer version=1;

    private BigDecimal unreceiveinterest= SysConstant.ZERO;

    private BigDecimal unreceiveprincipal= SysConstant.ZERO;

    private BigDecimal unreturnamount= SysConstant.ZERO;

    private BigDecimal remainborrowlimit= SysConstant.ZERO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradepassword() {
        return tradepassword;
    }

    public void setTradepassword(String tradepassword) {
        this.tradepassword = tradepassword == null ? null : tradepassword.trim();
    }

    public BigDecimal getUsableamount() {
        return usableamount;
    }

    public void setUsableamount(BigDecimal usableamount) {
        this.usableamount = usableamount;
    }

    public BigDecimal getFreezedamount() {
        return freezedamount;
    }

    public void setFreezedamount(BigDecimal freezedamount) {
        this.freezedamount = freezedamount;
    }

    public BigDecimal getBorrowlimit() {
        return borrowlimit;
    }

    public void setBorrowlimit(BigDecimal borrowlimit) {
        this.borrowlimit = borrowlimit;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getUnreceiveinterest() {
        return unreceiveinterest;
    }

    public void setUnreceiveinterest(BigDecimal unreceiveinterest) {
        this.unreceiveinterest = unreceiveinterest;
    }

    public BigDecimal getUnreceiveprincipal() {
        return unreceiveprincipal;
    }

    public void setUnreceiveprincipal(BigDecimal unreceiveprincipal) {
        this.unreceiveprincipal = unreceiveprincipal;
    }

    public BigDecimal getUnreturnamount() {
        return unreturnamount;
    }

    public void setUnreturnamount(BigDecimal unreturnamount) {
        this.unreturnamount = unreturnamount;
    }

    public BigDecimal getRemainborrowlimit() {
        return remainborrowlimit;
    }

    public void setRemainborrowlimit(BigDecimal remainborrowlimit) {
        this.remainborrowlimit = remainborrowlimit;
    }
}