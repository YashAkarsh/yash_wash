package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicDeviceNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    @b(name = "timestamp")
    private long timestamp;

    protected BasicDeviceNotify() {
    }

    public String getDevId() {
        return this.devId;
    }

    public String getModule() {
        return this.module;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setTimestamp(long j7) {
        this.timestamp = j7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "module=" + this.module + ", devId=" + this.devId + ", timestamp=" + this.timestamp;
    }
}
