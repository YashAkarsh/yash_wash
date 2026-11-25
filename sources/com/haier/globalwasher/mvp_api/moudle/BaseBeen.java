package com.haier.globalwasher.mvp_api.moudle;

import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public class BaseBeen {
    private String retCode;
    private String retData;
    private String retInfo;
    private String retSign;
    private long sysTime;

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetData() {
        return this.retData;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public String getRetSign() {
        return this.retSign;
    }

    public long getSysTime() {
        return this.sysTime;
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

    public void setRetSign(String str) {
        this.retSign = str;
    }

    public void setSysTime(long j7) {
        this.sysTime = j7;
    }

    public String toString() {
        return "{\"sysTime\":" + this.sysTime + ", \"retCode\":\"" + this.retCode + h0.f35376b + ", \"retInfo\":\"" + this.retInfo + h0.f35376b + ", \"retData\":\"" + this.retData + h0.f35376b + ", \"retSign\":\"" + this.retSign + h0.f35376b + '}';
    }
}
