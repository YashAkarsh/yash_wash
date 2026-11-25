package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceReadNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceReadNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "name")
    private String name;

    @b(name = "sn")
    private int sn;

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceReadNotifyHandler();
    }

    public int getSn() {
        return this.sn;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceReadNotify{devId=" + this.devId + ", sn=" + this.sn + ", name=" + this.name + ", from=" + this.from + '}';
    }
}
