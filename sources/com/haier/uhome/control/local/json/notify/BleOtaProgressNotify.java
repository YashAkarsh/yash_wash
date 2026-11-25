package com.haier.uhome.control.local.json.notify;

import com.alipay.sdk.util.m;
import com.haier.uhome.control.local.a.c;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleOtaProgressNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "progress")
    private float progress;

    @b(name = "reason")
    private String reason;

    @b(name = m.f13818c)
    private int result;

    @b(name = "bleOTASession")
    private int session;

    public String getDevId() {
        return this.devId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new c();
    }

    public float getProgress() {
        return this.progress;
    }

    public String getReason() {
        return this.reason;
    }

    public int getResult() {
        return this.result;
    }

    public int getSession() {
        return this.session;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setProgress(float f8) {
        this.progress = f8;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setResult(int i7) {
        this.result = i7;
    }

    public void setSession(int i7) {
        this.session = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BleOtaProgressNotify{devId='" + this.devId + "', progress=" + this.progress + ", reason='" + this.reason + "', session=" + this.session + ", result=" + this.result + '}';
    }
}
