package com.haier.uhome.search.b;

import com.haier.uhome.search.json.notify.DeviceDeleteNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceDeleteNotify deviceDeleteNotify = (DeviceDeleteNotify) basicNotify;
        if ("v_bind".equals(deviceDeleteNotify.getOnlineVer())) {
            f.a().b(deviceDeleteNotify.getDevId(), deviceDeleteNotify.getReason());
        } else {
            f.a().a(deviceDeleteNotify.getModule(), deviceDeleteNotify.getDevId(), deviceDeleteNotify.getReason());
        }
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notify device delete msg %s", deviceDeleteNotify);
    }
}
