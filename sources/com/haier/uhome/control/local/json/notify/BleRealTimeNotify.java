package com.haier.uhome.control.local.json.notify;

import com.haier.uhome.control.local.a.a;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleRealTimeNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "realTimeData")
    private String realTimeData;

    public String getDevId() {
        return this.devId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new a();
    }

    public String getRealTimeData() {
        return this.realTimeData;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setRealTimeData(String str) {
        this.realTimeData = str;
    }
}
