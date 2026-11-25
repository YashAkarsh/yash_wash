package com.haier.uhome.control.cloud.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.control.cloud.a.l;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindStateNotify extends BasicNotify {

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    @b(name = "stateCode")
    private int stateCode;

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new l();
    }

    public int getState() {
        return this.state;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBindStateNotifyHandler{state=" + this.state + ", stateCode=" + this.stateCode + '}';
    }
}
