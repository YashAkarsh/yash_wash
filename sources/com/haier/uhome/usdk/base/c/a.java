package com.haier.uhome.usdk.base.c;

import com.haier.uhome.usdk.base.json.BasicNotify;
import com.haier.uhome.usdk.base.json.notify.BluetoothStateChangedNotify;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        BluetoothStateChangedNotify bluetoothStateChangedNotify = (BluetoothStateChangedNotify) basicNotify;
        b.a().a(bluetoothStateChangedNotify.getState());
        e3.a.e("notify bt state change %s", bluetoothStateChangedNotify);
    }
}
