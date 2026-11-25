package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceOtaDownloadNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceOtaDownloadNotify deviceOtaDownloadNotify = (DeviceOtaDownloadNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyOtaDownload(deviceOtaDownloadNotify.getDevId(), deviceOtaDownloadNotify.getUrl(), deviceOtaDownloadNotify.getFileName(), deviceOtaDownloadNotify.getParam(), deviceOtaDownloadNotify.getFrom());
        e3.a.e("notify device ota download <%s>", deviceOtaDownloadNotify.toString());
    }
}
