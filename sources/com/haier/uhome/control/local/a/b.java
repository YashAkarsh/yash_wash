package com.haier.uhome.control.local.a;

import com.haier.uhome.control.local.json.notify.BleOtaModuleProgressNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("Ble ota: ble module progress notify: %s", basicNotify);
        BleOtaModuleProgressNotify bleOtaModuleProgressNotify = (BleOtaModuleProgressNotify) basicNotify;
        e.a().a(bleOtaModuleProgressNotify.getDevId(), bleOtaModuleProgressNotify.getState(), bleOtaModuleProgressNotify.getError(), bleOtaModuleProgressNotify.getSession());
    }
}
