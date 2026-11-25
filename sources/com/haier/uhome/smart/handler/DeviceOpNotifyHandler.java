package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceOpNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOpNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceOpNotify deviceOpNotify = (DeviceOpNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceOp(deviceOpNotify.getDevId(), deviceOpNotify.getSn(), deviceOpNotify.getOp(), deviceOpNotify.getArgs(), deviceOpNotify.getFrom());
        e3.a.o("notify device operation msg: " + deviceOpNotify.toString(), new Object[0]);
    }
}
