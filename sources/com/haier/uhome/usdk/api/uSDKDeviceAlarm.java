package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDeviceAlarm extends com.haier.uhome.control.base.api.b {
    public uSDKDeviceAlarm(com.haier.uhome.control.base.api.b bVar) {
        super(bVar.getName(), bVar.getValue(), bVar.getUniqueId());
        a(bVar.getTimestamp());
    }
}
