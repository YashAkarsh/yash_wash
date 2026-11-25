package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceBindResultNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindResultNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBindResultNotify deviceBindResultNotify = (DeviceBindResultNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceBindResult(deviceBindResultNotify.getDevId(), deviceBindResultNotify.getSn(), deviceBindResultNotify.getResult(), deviceBindResultNotify.getFrom());
        e3.a.o("notify device bind result msg: " + deviceBindResultNotify.toString(), new Object[0]);
    }
}
