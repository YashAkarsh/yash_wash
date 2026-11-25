package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.DeviceBindNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class k extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBindNotify deviceBindNotify = (DeviceBindNotify) basicNotify;
        h.a().a(deviceBindNotify.getToken(), deviceBindNotify.getDevId(), deviceBindNotify.getTypeId());
        e3.a.d("notify device bind msg: devId=%s typeId=%s", deviceBindNotify.getDevId(), deviceBindNotify.getTypeId(), new Object[0]);
    }
}
