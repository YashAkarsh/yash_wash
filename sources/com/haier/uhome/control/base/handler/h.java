package com.haier.uhome.control.base.handler;

import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.notify.UpdateRouterSsidPasswordNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.haier.uhome.usdk.base.c.e {
    private RouterSsidPasswordEvent a(UpdateRouterSsidPasswordNotify updateRouterSsidPasswordNotify) {
        RouterSsidPasswordEvent routerSsidPasswordEvent = new RouterSsidPasswordEvent();
        routerSsidPasswordEvent.setBleDevId(updateRouterSsidPasswordNotify.getBleDevId());
        routerSsidPasswordEvent.setDevId(updateRouterSsidPasswordNotify.getDevId());
        routerSsidPasswordEvent.setProgress(updateRouterSsidPasswordNotify.getProgress());
        routerSsidPasswordEvent.setResult(updateRouterSsidPasswordNotify.getResult());
        routerSsidPasswordEvent.setState(updateRouterSsidPasswordNotify.getState());
        routerSsidPasswordEvent.setStateCode(updateRouterSsidPasswordNotify.getStateCode());
        return routerSsidPasswordEvent;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        UpdateRouterSsidPasswordNotify updateRouterSsidPasswordNotify = (UpdateRouterSsidPasswordNotify) basicNotify;
        e3.a.e("ble notify router ssid password msg %s", updateRouterSsidPasswordNotify);
        ControlBaseNotifier.getInstance().notifyBleUpdateProgress(a(updateRouterSsidPasswordNotify));
    }
}
