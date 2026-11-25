package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class LoginResultBeen implements Serializable {
    private String avatarURL;
    private String phoneNumber;
    private String tokenId;
    private String userId;
    private String userName;

    public String getAvatarURL() {
        return this.avatarURL;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAvatarURL(String str) {
        this.avatarURL = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setTokenId(String str) {
        this.tokenId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
