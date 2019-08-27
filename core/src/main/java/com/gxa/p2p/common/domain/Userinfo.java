package com.gxa.p2p.common.domain;

import com.gxa.p2p.common.util.BitStatesUtils;

import static com.gxa.p2p.common.util.SysConstant.CREDIT_BORROW_SCORE;

public class Userinfo {
    private Long id;

    private Integer version=0;

    private Long bitstate=1l;

    private String realname;

    private String idnumber;

    private String phonenumber;

    private Long incomegradeId;

    private Long marriageId;

    private Long kidcountId;

    private Long educationbackgroundId;

    private Integer authscore;

    private Long houseconditionId;

    private Long realauthid;

    private String email;

    private Systemdictionaryitem educationbackgroundItem;

    private Systemdictionaryitem incomegradeItem;

    private Systemdictionaryitem marriageItem;

    private Systemdictionaryitem kidcountItem;

    private Systemdictionaryitem houseconditionItem;

    public int creditBorrowScore=CREDIT_BORROW_SCORE;

    public int getCreditBorrowScore() {
        return creditBorrowScore;
    }

    // 添加绑定的状态码
    public void addState(Long state) {
        bitstate = BitStatesUtils.addState(bitstate, state);
    }

    // 移除状态码
    public void  removeState(Long state) {
        bitstate = BitStatesUtils.removeState(bitstate, state);
    }

    // 判断是否已经绑定了手机
    public boolean getIsBindPhone() {
        return BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_BIND_PHONE);
    }

    //    判断用户是否有正在审理中的投标
    public boolean getIsBindState() {
        return BitStatesUtils.hasState(this.bitstate,
                BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
    }

    public boolean getIsBindEmail() {
        return BitStatesUtils.hasState(this.bitstate,BitStatesUtils.OP_BIND_EMAIL);
    }

    // 判断用户是否已经填写了基本资料
    public boolean getIsBasicInfo() {
        return BitStatesUtils.hasState(bitstate, BitStatesUtils.OP_USER_INFO);
    }

    public Systemdictionaryitem getMarriageItem() {
        return marriageItem;
    }

    public void setMarriageItem(Systemdictionaryitem marriageItem) {
        this.marriageItem = marriageItem;
    }

    public Systemdictionaryitem getKidcountItem() {
        return kidcountItem;
    }

    public void setKidcountItem(Systemdictionaryitem kidcountItem) {
        this.kidcountItem = kidcountItem;
    }

    public Systemdictionaryitem getHouseconditionItem() {
        return houseconditionItem;
    }

    public void setHouseconditionItem(Systemdictionaryitem houseconditionItem) {
        this.houseconditionItem = houseconditionItem;
    }

    public Systemdictionaryitem getIncomegradeItem() {
        return incomegradeItem;
    }

    public void setIncomegradeItem(Systemdictionaryitem incomegradeItem) {
        this.incomegradeItem = incomegradeItem;
    }

    public Systemdictionaryitem getEducationbackgroundItem() {
        return educationbackgroundItem;
    }

    public void setEducationbackgroundItem(Systemdictionaryitem educationbackgroundItem) {
        this.educationbackgroundItem = educationbackgroundItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getBitstate() {
        return bitstate;
    }

    public void setBitstate(Long bitstate) {
        this.bitstate = bitstate;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Long getIncomegradeId() {
        return incomegradeId;
    }

    public void setIncomegradeId(Long incomegradeId) {
        this.incomegradeId = incomegradeId;
    }

    public Long getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Long marriageId) {
        this.marriageId = marriageId;
    }

    public Long getKidcountId() {
        return kidcountId;
    }

    public void setKidcountId(Long kidcountId) {
        this.kidcountId = kidcountId;
    }

    public Long getEducationbackgroundId() {
        return educationbackgroundId;
    }

    public void setEducationbackgroundId(Long educationbackgroundId) {
        this.educationbackgroundId = educationbackgroundId;
    }

    public Integer getAuthscore() {
        return authscore;
    }

    public void setAuthscore(Integer authscore) {
        this.authscore = authscore;
    }

    public Long getHouseconditionId() {
        return houseconditionId;
    }

    public void setHouseconditionId(Long houseconditionId) {
        this.houseconditionId = houseconditionId;
    }

    public Long getRealauthid() {
        return realauthid;
    }

    public void setRealauthid(Long realauthid) {
        this.realauthid = realauthid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}