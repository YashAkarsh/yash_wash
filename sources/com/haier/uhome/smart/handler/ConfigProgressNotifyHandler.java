package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.ConfigProgressNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigProgressNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        ConfigProgressNotify configProgressNotify = (ConfigProgressNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyConfigProgress(configProgressNotify.getStatus(), configProgressNotify.getFrom());
        e3.a.o("notify config progress msg: " + configProgressNotify.toString(), new Object[0]);
    }
}
