package com.gxa.p2p.common.util;


public class JSONResult {

    private Boolean success=true;
    private String msg;
    public JSONResult() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
