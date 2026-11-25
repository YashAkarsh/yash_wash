package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceRegisterResNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceRegisterResNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceRegisterResNotify deviceRegisterResNotify = (DeviceRegisterResNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyRegisterRes(deviceRegisterResNotify.getDevId(), deviceRegisterResNotify.getResName(), deviceRegisterResNotify.getFrom());
        e3.a.e("notify device register res msg : " + deviceRegisterResNotify.toString(), new Object[0]);
    }
}
