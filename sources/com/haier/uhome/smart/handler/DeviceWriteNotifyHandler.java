package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceWriteNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceWriteNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceWriteNotify deviceWriteNotify = (DeviceWriteNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceWrite(deviceWriteNotify.getDevId(), deviceWriteNotify.getSn(), deviceWriteNotify.getName(), deviceWriteNotify.getValue(), deviceWriteNotify.getFrom());
        e3.a.o("notify device write msg: " + deviceWriteNotify.toString(), new Object[0]);
    }
}
