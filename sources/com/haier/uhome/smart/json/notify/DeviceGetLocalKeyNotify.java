package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import androidx.core.app.l2;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.smart.handler.DeviceGetLocalKeyNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetLocalKeyNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = l2.f5226y0)
    private int err;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = RetInfoContent.BindKEY_ISNULL)
    private String key;

    @b(name = "len")
    private int len;

    @b(name = "sn")
    private int sn;

    public String getDevId() {
        return this.devId;
    }

    public int getErr() {
        return this.err;
    }

    public int getFrom() {
        return this.from;
    }

    public String getKey() {
        return this.key;
    }

    public int getLen() {
        return this.len;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceGetLocalKeyNotifyHandler();
    }

    public int getSn() {
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

    public void setKey(String str) {
        this.key = str;
    }

    public void setLen(int i7) {
        this.len = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceGetLocalKeyNotify{devId=" + this.devId + ", key=" + this.key + ", len=" + this.len + ", err=" + this.err + ", sn=" + this.sn + ", from=" + this.from + '}';
    }
}
