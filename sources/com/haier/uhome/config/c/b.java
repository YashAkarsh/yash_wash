package com.haier.uhome.config.c;

import com.haier.uhome.config.json.notify.BleConfigProcessNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        BleConfigProcessNotify bleConfigProcessNotify = (BleConfigProcessNotify) basicNotify;
        int sn = bleConfigProcessNotify.getSn();
        int state = bleConfigProcessNotify.getState();
        int error = bleConfigProcessNotify.getError();
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "ble notify config process msg %s", bleConfigProcessNotify);
        c.a().a(sn, state, error);
    }
}
