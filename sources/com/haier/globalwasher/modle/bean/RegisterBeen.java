package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterBeen implements Serializable {
    private String androidUserId;
    private String channelId;
    private String deviceType;
    private String email;
    private String osVersion;
    private String password;
    private String phoneNumber;
    private String regionCode;
    private int time = 0;
    private String userName;
    private String verifyCode;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RegisterBeen f24358a = new RegisterBeen();

        private a() {
        }
    }

    public static RegisterBeen getInstance() {
        return a.f24358a;
    }

    public String getAndroidUserId() {
        return this.androidUserId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getEmail() {
        return this.email;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public int getTime() {
        return this.time;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void initRegisterBeen() {
        this.channelId = "";
        this.phoneNumber = "";
        this.userName = "";
        this.deviceType = "";
        this.osVersion = "";
        this.password = "";
        this.verifyCode = "";
        this.email = "";
        this.time = 0;
    }

    public void setAndroidUserId(String str) {
        this.androidUserId = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setTime(int i7) {
        this.time = i7;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVerifyCode(String str) {
        this.verifyCode = str;
    }
}
