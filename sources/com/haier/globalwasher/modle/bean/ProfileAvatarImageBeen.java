package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileAvatarImageBeen implements Serializable {
    private String avatar;
    private String avatarURL;
    private String desensitizationMailNumber;
    private String email;
    private String hotLine;
    private boolean isHavepwd;
    private String isReceiveMessage;
    private String phoneNumber;
    private String userId;
    private String userName;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ProfileAvatarImageBeen f24357a = new ProfileAvatarImageBeen();

        private a() {
        }
    }

    public static ProfileAvatarImageBeen getInstance() {
        return a.f24357a;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatarURL() {
        return this.avatarURL;
    }

    public String getDesensitizationMailNumber() {
        return this.desensitizationMailNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHotLine() {
        return this.hotLine;
    }

    public String getIsReceiveMessage() {
        return this.isReceiveMessage;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void initRegisterBeen() {
        this.userId = "";
        this.phoneNumber = "";
        this.avatar = "";
        this.isReceiveMessage = "";
        this.userName = "";
        this.hotLine = "";
        this.avatarURL = "";
    }

    public boolean isHavepwd() {
        return this.isHavepwd;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatarURL(String str) {
        this.avatarURL = str;
    }

    public void setDesensitizationMailNumber(String str) {
        this.desensitizationMailNumber = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setHavepwd(boolean z7) {
        this.isHavepwd = z7;
    }

    public void setHotLine(String str) {
        this.hotLine = str;
    }

    public void setIsReceiveMessage(String str) {
        this.isReceiveMessage = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "ProfileAvatarImageBeen{userId='" + this.userId + "', phoneNumber='" + this.phoneNumber + "', avatar='" + this.avatar + "', avatarURL='" + this.avatarURL + "', isReceiveMessage='" + this.isReceiveMessage + "', userName='" + this.userName + "', hotLine='" + this.hotLine + "', isHavepwd=" + this.isHavepwd + '}';
    }
}
