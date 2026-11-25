package com.haier.uhome.search.json.notify;

import com.haier.uhome.search.b.c;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceDeleteNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "module")
    private String module;

    @b(name = "onlineVer")
    private String onlineVer;

    @b(name = "reason")
    private int reason;

    public String getDevId() {
        return this.devId;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new c();
    }

    public String getOnlineVer() {
        return this.onlineVer;
    }

    public int getReason() {
        return this.reason;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setOnlineVer(String str) {
        this.onlineVer = str;
    }

    public void setReason(int i7) {
        this.reason = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceDeleteNotify{module=" + this.module + ", devId=" + this.devId + ", reason=" + this.reason + ", onlineVer=" + this.onlineVer + '}';
    }
}
