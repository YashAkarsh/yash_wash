package com.haier.uhome.control.cloud.json.notify;

import androidx.core.app.l2;
import com.haier.uhome.control.cloud.a.t;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceEventNotify extends BasicNotify {

    @b(name = l2.f5216t0)
    private int event;

    @b(name = "handle")
    private long handle;

    @b(name = "resId")
    private String resId;

    public int getEvent() {
        return this.event;
    }

    public long getHandle() {
        return this.handle;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new t();
    }

    public String getResId() {
        return this.resId;
    }

    public void setEvent(int i7) {
        this.event = i7;
    }

    public void setHandle(long j7) {
        this.handle = j7;
    }

    public void setResId(String str) {
        this.resId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ResourceEventNotify{handle=" + this.handle + ", resId=" + this.resId + ", event=" + this.event + '}';
    }
}
