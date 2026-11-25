package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.WifiScanStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class WifiScanStatusNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        WifiScanStatusNotify wifiScanStatusNotify = (WifiScanStatusNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyWifiScanStatus(wifiScanStatusNotify.getStatus(), wifiScanStatusNotify.getFrom());
        e3.a.o("notify wifi scan status msg: " + wifiScanStatusNotify.toString(), new Object[0]);
    }
}
