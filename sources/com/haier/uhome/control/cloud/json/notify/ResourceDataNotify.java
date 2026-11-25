package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.s;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceDataNotify extends BasicNotify {

    @b(name = "data")
    private String data;

    @b(name = "handle")
    private long handle;

    @b(name = "resName")
    private String resName;

    @b(name = "version")
    private int version;

    public String getData() {
        return this.data;
    }

    public long getHandle() {
        return this.handle;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new s();
    }

    public String getResName() {
        return this.resName;
    }

    public int getVersion() {
        return this.version;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setHandle(long j7) {
        this.handle = j7;
    }

    public void setResName(String str) {
        this.resName = str;
    }

    public void setVersion(int i7) {
        this.version = i7;
    }
}
