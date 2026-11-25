package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceBusinessNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBusinessNotify extends BasicNotify {

    @b(name = "data")
    private String data;

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "len")
    private int len;

    @b(name = "type")
    private String type;

    public String getData() {
        return this.data;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    public int getLen() {
        return this.len;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceBusinessNotifyHandler();
    }

    public String getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setLen(int i7) {
        this.len = i7;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBusinessNotify{devId=" + this.devId + ", type=" + this.type + ", data=" + this.data + ", len=" + this.len + ", from=" + this.from + '}';
    }
}
