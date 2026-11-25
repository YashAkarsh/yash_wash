package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class SmartBindWindowRsp {
    private String mDevId;
    private int mReqSn;

    public SmartBindWindowRsp(int i7) {
        this.mReqSn = i7;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public int getReqSn() {
        return this.mReqSn;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setReqSn(int i7) {
        this.mReqSn = i7;
    }

    public String toString() {
        return "SmartBindWindowRsp{mReqSn=" + this.mReqSn + ", mDevId=" + this.mDevId + '}';
    }
}
