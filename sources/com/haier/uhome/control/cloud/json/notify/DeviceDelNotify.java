package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.m;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceDelNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "errNo")
    private int errNo;

    @b(name = "module")
    private String module;

    @b(name = "reason")
    private int reason;

    public String getDevId() {
        return this.devId;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new m();
    }

    public int getReason() {
        return this.reason;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setReason(int i7) {
        this.reason = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceDelNotify{module='" + this.module + "', devId='" + this.devId + "', errNo=" + this.errNo + ", reason=" + this.reason + '}';
    }
}
