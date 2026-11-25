package com.haier.uhome.account.model;

/* JADX INFO: loaded from: classes2.dex */
public class RespCommonModel {
    private String retCode;
    private String retInfo;

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public String toString() {
        return "RespCommonModel{retCode='" + this.retCode + ", retInfo='" + this.retInfo + '}';
    }
}
