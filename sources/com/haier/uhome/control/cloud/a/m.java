package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.DeviceDelNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceDelNotify deviceDelNotify = (DeviceDelNotify) basicNotify;
        if (com.haier.uhome.usdk.base.a.ao.equals(deviceDelNotify.getModule())) {
            com.haier.uhome.usdk.base.api.g.a().c(deviceDelNotify.getDevId());
            h.a().a(deviceDelNotify.getDevId(), deviceDelNotify.getErrNo(), deviceDelNotify.getReason());
            e3.a.e("notify cloud device del (deviceId = %s, errNo = %d, reason = %d", deviceDelNotify.getDevId(), Integer.valueOf(deviceDelNotify.getErrNo()), Integer.valueOf(deviceDelNotify.getReason()));
        }
    }
}
