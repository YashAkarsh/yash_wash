package com.haier.uhome.control.base.handler;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.notify.DeviceStateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceStateNotify deviceStateNotify = (DeviceStateNotify) basicNotify;
        DeviceStatus deviceStatus = DeviceStatus.getInstance(deviceStateNotify.getState());
        ControlBaseNotifier.getInstance().notifyDevStateChange(deviceStateNotify.getModule(), deviceStateNotify.getDevId(), deviceStateNotify.getElementAddr(), deviceStatus, deviceStateNotify.getErrNo());
        e3.a.d("%s notify device %s state msg %s", deviceStateNotify.getModule(), deviceStateNotify.getDevId(), deviceStatus);
    }
}
