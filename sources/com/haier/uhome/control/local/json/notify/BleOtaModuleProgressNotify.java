package com.haier.uhome.control.local.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleOtaModuleProgressNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "error")
    private int error;

    @b(name = "bleOTASession")
    private int session;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    public String getDevId() {
        return this.devId;
    }

    public int getError() {
        return this.error;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.control.local.a.b();
    }

    public int getSession() {
        return this.session;
    }

    public int getState() {
        return this.state;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setError(int i7) {
        this.error = i7;
    }

    public void setSession(int i7) {
        this.session = i7;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BleOtaModuleProgressNotify{devId='" + this.devId + "', state=" + this.state + ", error=" + this.error + ", session=" + this.session + '}';
    }
}
