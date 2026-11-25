package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DevicePairingNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DevicePairingNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DevicePairingNotify devicePairingNotify = (DevicePairingNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyDevicePairing(devicePairingNotify.getTraceId(), devicePairingNotify.getSn(), devicePairingNotify.getUplusId(), devicePairingNotify.getUpCode(), devicePairingNotify.getBindSn(), devicePairingNotify.getFrom());
        e3.a.e("notify device pairing msg <%s>", devicePairingNotify.toString());
    }
}
