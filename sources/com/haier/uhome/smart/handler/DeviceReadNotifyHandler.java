package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceReadNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceReadNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceReadNotify deviceReadNotify = (DeviceReadNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceRead(deviceReadNotify.getDevId(), deviceReadNotify.getSn(), deviceReadNotify.getName(), deviceReadNotify.getFrom());
        e3.a.o("notify device read msg: " + deviceReadNotify.toString(), new Object[0]);
    }
}
