package com.gxa.p2p.business.domain;

import java.util.Date;

public class Bidrequestaudithistory {
    private Long id;

    private Integer state;/*审核是否成功的状态，1为成功，2为失败，0为没有操作*/

    private String remark;/*管理员审核时的备注*/

    private Date audittime;/*管理员审核时间*/

    private Date applytime;/*用户申请借款时间*/

    private Long auditorId;/*管理员id*/

    private Long applierId;/*用户的id*/

    private Long bidrequestid;/*审评单id*/

    private Integer audittype;/*招标审评是否成功，如果成功则为1，失败则为10*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getApplierId() {
        return applierId;
    }

    public void setApplierId(Long applierId) {
        this.applierId = applierId;
    }

    public Long getBidrequestid() {
        return bidrequestid;
    }

    public void setBidrequestid(Long bidrequestid) {
        this.bidrequestid = bidrequestid;
    }

    public Integer getAudittype() {
        return audittype;
    }

    public void setAudittype(Integer audittype) {
        this.audittype = audittype;
    }
}