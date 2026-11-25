package com.haier.uhome.smart.handler;

import android.util.Base64;
import com.haier.uhome.smart.json.notify.DeviceBusinessNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBusinessNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceBusinessNotify deviceBusinessNotify = (DeviceBusinessNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceBusiness(deviceBusinessNotify.getDevId(), deviceBusinessNotify.getType(), Base64.decode(deviceBusinessNotify.getData().getBytes(), 2), deviceBusinessNotify.getFrom());
        e3.a.o("notify device business msg: " + deviceBusinessNotify.toString(), new Object[0]);
    }
}
