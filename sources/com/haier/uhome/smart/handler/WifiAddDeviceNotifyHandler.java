package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.WifiAddDeviceNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class WifiAddDeviceNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        WifiAddDeviceNotify wifiAddDeviceNotify = (WifiAddDeviceNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyWifiAddDevice(wifiAddDeviceNotify.getWifiMac(), wifiAddDeviceNotify.getSoftApName(), wifiAddDeviceNotify.getMainType(), wifiAddDeviceNotify.getMiddleType(), wifiAddDeviceNotify.getFrom());
        e3.a.o("notify wifi add device msg: " + wifiAddDeviceNotify.toString(), new Object[0]);
    }
}
