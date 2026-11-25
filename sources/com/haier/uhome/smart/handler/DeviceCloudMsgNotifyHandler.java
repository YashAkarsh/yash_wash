package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceCloudMsgNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceCloudMsgNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceCloudMsgNotify deviceCloudMsgNotify = (DeviceCloudMsgNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceCloudMsg(deviceCloudMsgNotify.getDevId(), deviceCloudMsgNotify.getErr(), deviceCloudMsgNotify.getSn(), deviceCloudMsgNotify.getFrom());
        e3.a.o("notify device cloud msg msg: " + deviceCloudMsgNotify.toString(), new Object[0]);
    }
}
