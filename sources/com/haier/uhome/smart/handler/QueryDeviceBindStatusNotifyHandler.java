package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.QueryDeviceBindStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class QueryDeviceBindStatusNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        QueryDeviceBindStatusNotify queryDeviceBindStatusNotify = (QueryDeviceBindStatusNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyQueryDeviceBindStatus(queryDeviceBindStatusNotify.getDevId(), queryDeviceBindStatusNotify.getSn(), queryDeviceBindStatusNotify.getErrNo(), queryDeviceBindStatusNotify.getStatus(), queryDeviceBindStatusNotify.getFrom());
        e3.a.o("notify query device bind status msg: " + queryDeviceBindStatusNotify.toString(), new Object[0]);
    }
}
