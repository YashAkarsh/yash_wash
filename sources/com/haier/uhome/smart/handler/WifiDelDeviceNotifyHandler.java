package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.WifiDelDeviceNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDelDeviceNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        WifiDelDeviceNotify wifiDelDeviceNotify = (WifiDelDeviceNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyWifiDelDevice(wifiDelDeviceNotify.getWifiMac(), wifiDelDeviceNotify.getFrom());
        e3.a.o("notify wifi del device msg: " + wifiDelDeviceNotify.toString(), new Object[0]);
    }
}
