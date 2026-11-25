package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CountryCode implements Serializable {
    private String code;
    private String enname;
    private String id;
    private String regexinfo;
    private String regionCode;
    private String zhname;

    public String getCode() {
        return this.code;
    }

    public String getEnname() {
        return this.enname;
    }

    public String getId() {
        return this.id;
    }

    public String getRegexinfo() {
        return this.regexinfo;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public String getZhname() {
        return this.zhname;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setEnname(String str) {
        this.enname = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRegexinfo(String str) {
        this.regexinfo = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public void setZhname(String str) {
        this.zhname = str;
    }
}
