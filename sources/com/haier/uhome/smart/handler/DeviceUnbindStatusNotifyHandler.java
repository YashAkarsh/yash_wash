package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceUnbindStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUnbindStatusNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceUnbindStatusNotify deviceUnbindStatusNotify = (DeviceUnbindStatusNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceUnbindStatus(deviceUnbindStatusNotify.getDevId(), deviceUnbindStatusNotify.getFrom());
        e3.a.o("notify device unbind status msg: " + deviceUnbindStatusNotify.toString(), new Object[0]);
    }
}
