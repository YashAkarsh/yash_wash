package com.haier.uhome.config.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleConfigProcessNotify extends BasicNotify {

    @b(name = "error")
    private int error;

    @b(name = "sn")
    private int sn;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    public int getError() {
        return this.error;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.config.c.b();
    }

    public int getSn() {
        return this.sn;
    }

    public int getState() {
        return this.state;
    }

    public void setError(int i7) {
        this.error = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BleConfigProcessNotify{sn=" + this.sn + ", state=" + this.state + ", error=" + this.error + '}';
    }
}
