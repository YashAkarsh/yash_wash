package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.CloudStateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        CloudStateNotify cloudStateNotify = (CloudStateNotify) basicNotify;
        h.a().a(cloudStateNotify.getState(), cloudStateNotify.getErrNo());
        e3.a.e("notify cloud state msg %s", cloudStateNotify);
    }
}
