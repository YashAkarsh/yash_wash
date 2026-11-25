package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.DeviceBindStateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBindStateNotify deviceBindStateNotify = (DeviceBindStateNotify) basicNotify;
        b.a().a(deviceBindStateNotify.getState(), deviceBindStateNotify.getStateCode());
        e3.a.e("notify device bind state msg: %s", basicNotify);
    }
}
