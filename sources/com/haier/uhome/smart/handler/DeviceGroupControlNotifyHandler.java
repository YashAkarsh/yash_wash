package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceGroupControlNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGroupControlNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceGroupControlNotify deviceGroupControlNotify = (DeviceGroupControlNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceGroupControl(deviceGroupControlNotify.getType(), deviceGroupControlNotify.getSn(), deviceGroupControlNotify.getGroupId(), deviceGroupControlNotify.getDevId());
        e3.a.o("notify device group control msg: " + deviceGroupControlNotify.toString(), new Object[0]);
    }
}
