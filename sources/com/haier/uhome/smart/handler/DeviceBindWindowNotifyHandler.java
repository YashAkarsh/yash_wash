package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceBindWindowNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindWindowNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBindWindowNotify deviceBindWindowNotify = (DeviceBindWindowNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceBindWindow(deviceBindWindowNotify.getDevId(), deviceBindWindowNotify.getSn(), deviceBindWindowNotify.getErr(), deviceBindWindowNotify.getFrom());
        e3.a.o("notify device bindwind msg: " + deviceBindWindowNotify.toString(), new Object[0]);
    }
}
