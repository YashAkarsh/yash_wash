package com.haier.uhome.control.cloud.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.control.cloud.a.f;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class CloudStateNotify extends BasicNotify {

    @b(name = "errNo")
    private int errNo;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private String state;

    protected CloudStateNotify() {
    }

    public int getErrNo() {
        return this.errNo;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new f();
    }

    public String getState() {
        return this.state;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setState(String str) {
        this.state = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "CloudStateNotify{state=" + this.state + ", errNo=" + this.errNo + '}';
    }
}
