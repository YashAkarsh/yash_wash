package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceResChannelStatusNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceResChannelStatusNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "status")
    private int status;

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceResChannelStatusNotifyHandler();
    }

    public int getStatus() {
        return this.status;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceResChannelStatusNotify{devId='" + this.devId + "', status='" + this.status + "', from=" + this.from + '}';
    }
}
