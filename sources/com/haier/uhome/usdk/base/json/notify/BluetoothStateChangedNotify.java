package com.haier.uhome.usdk.base.json.notify;

import com.facebook.internal.ServerProtocol;
import com.haier.uhome.usdk.base.c.a;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothStateChangedNotify extends BasicNotify {

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new a();
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BluetoothStateChangedNotify{state=" + this.state + '}';
    }
}
