package com.haier.uhome.smart.handler;

import android.util.Base64;
import com.haier.uhome.smart.json.notify.DeviceGetLocalKeyNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetLocalKeyNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceGetLocalKeyNotify deviceGetLocalKeyNotify = (DeviceGetLocalKeyNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDeviceGetLocalKey(deviceGetLocalKeyNotify.getDevId(), Base64.encodeToString(deviceGetLocalKeyNotify.getKey().getBytes(), 0), deviceGetLocalKeyNotify.getLen(), deviceGetLocalKeyNotify.getErr(), deviceGetLocalKeyNotify.getSn(), deviceGetLocalKeyNotify.getFrom());
        e3.a.o("notify device get local key msg: " + deviceGetLocalKeyNotify.toString(), new Object[0]);
    }
}
