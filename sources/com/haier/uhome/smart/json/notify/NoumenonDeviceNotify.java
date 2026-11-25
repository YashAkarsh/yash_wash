package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.NoumenonDeviceNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NoumenonDeviceNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "sn")
    private int sn;

    @b(name = "type")
    private int type;

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new NoumenonDeviceNotifyHandler();
    }

    public int getSn() {
        return this.sn;
    }

    public int getType() {
        return this.type;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setType(int i7) {
        this.type = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "NoumenonDeviceNotify{devId=" + this.devId + ", sn=" + this.sn + ", type=" + this.type + ", from=" + this.from + '}';
    }
}
