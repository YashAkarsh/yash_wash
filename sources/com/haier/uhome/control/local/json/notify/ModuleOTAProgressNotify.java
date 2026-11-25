package com.haier.uhome.control.local.json.notify;

import com.haier.uhome.control.local.a.f;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ModuleOTAProgressNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "progress")
    private float progress;

    public String getDevId() {
        return this.devId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new f();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setProgress(float f8) {
        this.progress = f8;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ModuleOTAProgressNotify{devId='" + this.devId + "', progress=" + this.progress + '}';
    }
}
