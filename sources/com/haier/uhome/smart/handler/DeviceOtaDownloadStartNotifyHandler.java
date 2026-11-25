package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceOtaDownloadStartNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadStartNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceOtaDownloadStartNotify deviceOtaDownloadStartNotify = (DeviceOtaDownloadStartNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyOtaDownloadStart(deviceOtaDownloadStartNotify.getDevId(), deviceOtaDownloadStartNotify.getType(), deviceOtaDownloadStartNotify.getUpgradeSn(), deviceOtaDownloadStartNotify.getParam(), deviceOtaDownloadStartNotify.getFrom());
        e3.a.e("notify device ota download start <%s>", deviceOtaDownloadStartNotify.toString());
    }
}
