package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceBindStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBindStatusNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBindStatusNotify deviceBindStatusNotify = (DeviceBindStatusNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceBindStatus(deviceBindStatusNotify.getDevId(), deviceBindStatusNotify.getFrom());
        e3.a.o("notify device bind status msg: " + deviceBindStatusNotify.toString(), new Object[0]);
    }
}
