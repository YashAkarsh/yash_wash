package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.notify.ConfigResultNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigResultNotifyHandler extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        ConfigResultNotify configResultNotify = (ConfigResultNotify) basicNotify;
        SmartDeviceNotifier.getInstance().notifyConfigResult(configResultNotify.getResult(), configResultNotify.getFrom());
        e3.a.o("notify config result msg: " + configResultNotify.toString(), new Object[0]);
    }
}
