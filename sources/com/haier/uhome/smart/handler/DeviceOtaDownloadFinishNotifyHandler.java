package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.DeviceOtaDownloadFinishNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadFinishNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceOtaDownloadFinishNotify deviceOtaDownloadFinishNotify = (DeviceOtaDownloadFinishNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyOtaDownloadFinish(deviceOtaDownloadFinishNotify.getDevId(), deviceOtaDownloadFinishNotify.getFileName(), deviceOtaDownloadFinishNotify.getErrNo(), deviceOtaDownloadFinishNotify.getParam(), deviceOtaDownloadFinishNotify.getFrom());
        e3.a.e("notify device ota download finish<%s>", deviceOtaDownloadFinishNotify.toString());
    }
}
