package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.ResourceConnectStateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class r extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        ResourceConnectStateNotify resourceConnectStateNotify = (ResourceConnectStateNotify) basicNotify;
        h.a().a(resourceConnectStateNotify.getHandle(), resourceConnectStateNotify.getTransId(), resourceConnectStateNotify.getStatus());
        e3.a.e("notify resource %s connect state %s", resourceConnectStateNotify.getTransId(), Integer.valueOf(resourceConnectStateNotify.getStatus()));
    }
}
