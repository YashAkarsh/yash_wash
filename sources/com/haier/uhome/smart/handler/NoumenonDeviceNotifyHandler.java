package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.NoumenonDeviceNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class NoumenonDeviceNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        NoumenonDeviceNotify noumenonDeviceNotify = (NoumenonDeviceNotify) basicNotify;
        e3.a.o("notify usdk req <%s>", noumenonDeviceNotify.toString());
        SmartDeviceNotifier.getInstance().notifyUSDKReq(noumenonDeviceNotify.getDevId(), noumenonDeviceNotify.getSn(), noumenonDeviceNotify.getType(), noumenonDeviceNotify.getFrom());
    }
}
