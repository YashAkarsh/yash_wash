package com.haier.uhome.control.base.json.resp;

import com.alipay.sdk.util.m;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudGetDeviceBindResultResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "bindTimeStamp")
    private long mBindTimeStamp;

    @b(name = "protocol")
    private int mProtocol;

    @b(name = m.f13818c)
    private int mResult;

    @b(name = "uplusId")
    private String uplusId;

    public long getBindTimeStamp() {
        return this.mBindTimeStamp;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getProtocol() {
        return this.mProtocol;
    }

    public int getResult() {
        return this.mResult;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setBindTimeStamp(long j7) {
        this.mBindTimeStamp = j7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setProtocol(int i7) {
        this.mProtocol = i7;
    }

    public void setResult(int i7) {
        this.mResult = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "CloudGetDeviceBindResultResp{mBindTimeStamp=" + this.mBindTimeStamp + ", mProtocol=" + this.mProtocol + ", mResult=" + this.mResult + ", devId='" + this.devId + "', uplusId='" + this.uplusId + "'}";
    }
}
