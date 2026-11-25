package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.ResourceEventNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class t extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        ResourceEventNotify resourceEventNotify = (ResourceEventNotify) basicNotify;
        h.a().a(resourceEventNotify.getHandle(), resourceEventNotify.getEvent());
        e3.a.e("notify resource event state %d", Integer.valueOf(resourceEventNotify.getEvent()));
    }
}
