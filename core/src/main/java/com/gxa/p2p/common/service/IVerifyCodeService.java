package com.gxa.p2p.common.service;

public interface IVerifyCodeService {

    void sendVerifyCode(String phoneNumber);

    boolean validate(String phoneNumber, String verifyCode);

}
