package com.haier.globalwasher.modle.js_api.device;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfoBean {
    private String country;
    private String language;
    private String timeZone;

    public DeviceInfoBean(String str, String str2, String str3) {
        this.language = str;
        this.country = str2;
        this.timeZone = str3;
    }

    public String getCountry() {
        return this.country;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }
}
