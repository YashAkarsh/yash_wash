package com.haier.globalwasher.modle.bean.share;

import com.google.gson.f;

/* JADX INFO: loaded from: classes2.dex */
public class ShareResultBean {
    private String retCode;
    private String retData;
    private String retInfo;

    public ShareResultBean() {
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetData() {
        return this.retData;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetData(String str) {
        this.retData = str;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public String toJson() {
        return new f().z(this);
    }

    public ShareResultBean(String str, String str2, String str3) {
        this.retCode = str;
        this.retInfo = str2;
        this.retData = str3;
    }
}
