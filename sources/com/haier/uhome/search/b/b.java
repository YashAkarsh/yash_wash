package com.haier.uhome.search.b;

import com.haier.uhome.search.json.notify.DeviceBleEventNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.base.c.e {
    private com.haier.uhome.search.service.entity.d a(DeviceBleEventNotify deviceBleEventNotify) {
        com.haier.uhome.search.service.entity.d dVar = new com.haier.uhome.search.service.entity.d();
        dVar.c(deviceBleEventNotify.getBleDevId());
        dVar.g(deviceBleEventNotify.getBuf());
        dVar.c(deviceBleEventNotify.getBufSize());
        dVar.d(deviceBleEventNotify.getFlags());
        dVar.b(deviceBleEventNotify.getDevId());
        dVar.a(deviceBleEventNotify.getName());
        dVar.e(deviceBleEventNotify.getProtocol());
        dVar.f(deviceBleEventNotify.getProtVers());
        dVar.b(deviceBleEventNotify.getStateCode());
        dVar.a(deviceBleEventNotify.getType());
        dVar.a(System.currentTimeMillis());
        return dVar;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBleEventNotify deviceBleEventNotify = (DeviceBleEventNotify) basicNotify;
        f.a().a(a(deviceBleEventNotify));
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notify ble event: %s", deviceBleEventNotify);
    }
}
