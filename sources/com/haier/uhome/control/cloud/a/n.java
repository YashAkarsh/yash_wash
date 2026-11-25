package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.DeviceUnbindNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class n extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceUnbindNotify deviceUnbindNotify = (DeviceUnbindNotify) basicNotify;
        h.a().a(deviceUnbindNotify.getToken(), deviceUnbindNotify.getDevId());
        e3.a.e("notify device unbind msg: devId=%s", deviceUnbindNotify.getDevId());
    }
}
