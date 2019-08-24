package com.gxa.p2p.common.query;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;

public class IpLogQueryObject extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Byte state = -1;
    private String username;

    Logininfo loginInfo = UserContext.getLoginInfo();

    public String getUsername() {
        return loginInfo.getUsername();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Logininfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(Logininfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
