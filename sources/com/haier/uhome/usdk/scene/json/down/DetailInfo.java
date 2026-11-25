package com.haier.uhome.usdk.scene.json.down;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DetailInfo {

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "execResult")
    private boolean execResult;

    @b(name = "execResultCode")
    private String execResultCode;

    @b(name = "execResultInfo")
    private String execResultInfo;

    @b(name = "resultTime")
    private long resultTime;

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getExecResultCode() {
        return this.execResultCode;
    }

    public String getExecResultInfo() {
        return this.execResultInfo;
    }

    public long getResultTime() {
        return this.resultTime;
    }

    public boolean isExecResult() {
        return this.execResult;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setExecResult(boolean z7) {
        this.execResult = z7;
    }

    public void setExecResultCode(String str) {
        this.execResultCode = str;
    }

    public void setExecResultInfo(String str) {
        this.execResultInfo = str;
    }

    public void setResultTime(long j7) {
        this.resultTime = j7;
    }

    public String toString() {
        return "DetailInfo{deviceId='" + this.deviceId + "', execResult=" + this.execResult + ", execResultCode='" + this.execResultCode + "', execResultInfo='" + this.execResultInfo + "', resultTime=" + this.resultTime + '}';
    }
}
