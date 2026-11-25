package com.haier.uhome.search.b;

import com.haier.uhome.search.json.notify.DeviceBleAdvUnboundNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.uhome.usdk.base.c.e {
    private com.haier.uhome.search.service.entity.c a(DeviceBleAdvUnboundNotify deviceBleAdvUnboundNotify) {
        com.haier.uhome.search.service.entity.c cVar = new com.haier.uhome.search.service.entity.c();
        cVar.a(deviceBleAdvUnboundNotify.getDupAdv() == 1);
        cVar.a(deviceBleAdvUnboundNotify.getCompanyId());
        cVar.b(deviceBleAdvUnboundNotify.getName());
        cVar.c(deviceBleAdvUnboundNotify.getMachineID());
        cVar.d(deviceBleAdvUnboundNotify.getBleDevId());
        cVar.e(deviceBleAdvUnboundNotify.getProtocol());
        cVar.f(deviceBleAdvUnboundNotify.getProtVers());
        cVar.g(deviceBleAdvUnboundNotify.getProductCode());
        return cVar;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        if (!(basicNotify instanceof DeviceBleAdvUnboundNotify)) {
            e3.a.h("current notify is not DeviceBleAdvUnboundNotify", new Object[0]);
            return;
        }
        DeviceBleAdvUnboundNotify deviceBleAdvUnboundNotify = (DeviceBleAdvUnboundNotify) basicNotify;
        f.a().a(a(deviceBleAdvUnboundNotify));
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notify ble adv unbound: %s", deviceBleAdvUnboundNotify);
    }
}
