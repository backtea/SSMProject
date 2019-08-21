package com.gxa.p2p.common.domain;

import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;

public class Account {
    private Long id;

    private String tradepassword;

//    可用资金   2
    private BigDecimal usableamount = SysConstant.ZERO;

//    冻结资金   3
    private BigDecimal freezedamount= SysConstant.ZERO;

//最大额度
    private BigDecimal borrowlimit= SysConstant.ZERO;

//版本
    private Integer version=1;

//待收利息    4
    private BigDecimal unreceiveinterest= SysConstant.ZERO;

//待收本金  5
    private BigDecimal unreceiveprincipal= SysConstant.ZERO;

//待还本息    6
    private BigDecimal unreturnamount= SysConstant.ZERO;

//剩余额度
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