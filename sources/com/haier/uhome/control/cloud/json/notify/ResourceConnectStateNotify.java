package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.r;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceConnectStateNotify extends BasicNotify {

    @b(name = "handle")
    private long handle;

    @b(name = "status")
    private int status;

    @b(name = "transId")
    private String transId;

    public long getHandle() {
        return this.handle;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new r();
    }

    public int getStatus() {
        return this.status;
    }

    public String getTransId() {
        return this.transId;
    }

    public void setHandle(long j7) {
        this.handle = j7;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    public void setTransId(String str) {
        this.transId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ResourceConnectStateNotify{handle=" + this.handle + ", transId=" + this.transId + ", status=" + this.status + '}';
    }
}
