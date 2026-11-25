package com.haier.uhome.account.model;

/* JADX INFO: loaded from: classes2.dex */
public class RequestHeader {
    private String accessToken;
    private String appId;
    private String appVersion;
    private String clientId;
    private String language;
    private String sequenceId;
    private String sign;
    private String timestamp;
    private String timezone;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setSequenceId(String str) {
        this.sequenceId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }
}
