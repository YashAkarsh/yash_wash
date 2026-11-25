package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class BaseSmartRsp {
    private int mReqSn;
    private int mResult;

    public BaseSmartRsp(int i7) {
        this.mReqSn = i7;
    }

    public int getReqSn() {
        return this.mReqSn;
    }

    public int getResult() {
        return this.mResult;
    }

    public void setResult(int i7) {
        this.mResult = i7;
    }

    public String toString() {
        return "BaseSmartRsp{, mReqSn=" + this.mReqSn + ", mResult=" + this.mResult + '}';
    }
}
