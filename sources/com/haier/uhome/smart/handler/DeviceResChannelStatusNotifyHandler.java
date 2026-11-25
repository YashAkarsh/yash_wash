package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceResChannelStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceResChannelStatusNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceResChannelStatusNotify deviceResChannelStatusNotify = (DeviceResChannelStatusNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyResChannelStatus(deviceResChannelStatusNotify.getDevId(), deviceResChannelStatusNotify.getStatus(), deviceResChannelStatusNotify.getFrom());
        e3.a.o("notify device res channel status msg: " + deviceResChannelStatusNotify.toString(), new Object[0]);
    }
}
