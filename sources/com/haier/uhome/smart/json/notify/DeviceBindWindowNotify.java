package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import androidx.core.app.l2;
import com.haier.uhome.smart.handler.DeviceBindWindowNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindWindowNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = l2.f5226y0)
    private int err;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "sn")
    private String sn;

    public String getDevId() {
        return this.devId;
    }

    public int getErr() {
        return this.err;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceBindWindowNotifyHandler();
    }

    public String getSn() {
        return this.sn;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErr(int i7) {
        this.err = i7;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBindWindowNotify{sn=" + this.sn + ", devId='" + this.devId + ", err=" + this.err + ", from=" + this.from + '}';
    }
}
