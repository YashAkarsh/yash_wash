package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceAuthTokenNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAuthTokenNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceAuthTokenNotify deviceAuthTokenNotify = (DeviceAuthTokenNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceAuthToken(deviceAuthTokenNotify.getSt(), deviceAuthTokenNotify.getToken(), deviceAuthTokenNotify.getFrom());
        e3.a.o("notify device auth token msg: " + deviceAuthTokenNotify.toString(), new Object[0]);
    }
}
