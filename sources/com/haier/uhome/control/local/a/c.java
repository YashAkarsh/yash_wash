package com.haier.uhome.control.local.a;

import com.haier.uhome.control.local.json.notify.BleOtaProgressNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("Ble ota: notify: %s", basicNotify);
        BleOtaProgressNotify bleOtaProgressNotify = (BleOtaProgressNotify) basicNotify;
        e.a().a(bleOtaProgressNotify.getDevId(), bleOtaProgressNotify.getSession(), bleOtaProgressNotify.getProgress(), bleOtaProgressNotify.getResult(), bleOtaProgressNotify.getReason());
    }
}
