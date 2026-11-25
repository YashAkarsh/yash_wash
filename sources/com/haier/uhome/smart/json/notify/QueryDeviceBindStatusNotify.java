package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import androidx.core.app.l2;
import com.haier.uhome.smart.handler.QueryDeviceBindStatusNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class QueryDeviceBindStatusNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = l2.f5226y0)
    private int errNo;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "sn")
    private int sn;

    @b(name = "status")
    private int status;

    public String getDevId() {
        return this.devId;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new QueryDeviceBindStatusNotifyHandler();
    }

    public int getSn() {
        return this.sn;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "QueryDeviceBindStatusNotify{devId='" + this.devId + "', sn=" + this.sn + ", errNo=" + this.errNo + ", status=" + this.status + ", from=" + this.from + '}';
    }
}
