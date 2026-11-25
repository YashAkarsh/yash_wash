package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceDepairingNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceDepairingNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceDepairingNotify deviceDepairingNotify = (DeviceDepairingNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceDepairing(deviceDepairingNotify.getTraceId(), deviceDepairingNotify.getDevId(), deviceDepairingNotify.getFrom());
        e3.a.e("notify device depairing msg <%s>", deviceDepairingNotify.toString());
    }
}
