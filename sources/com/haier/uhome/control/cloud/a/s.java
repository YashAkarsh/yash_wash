package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.ResourceDataNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class s extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        ResourceDataNotify resourceDataNotify = (ResourceDataNotify) basicNotify;
        h.a().a(resourceDataNotify.getHandle(), resourceDataNotify.getResName(), resourceDataNotify.getData(), resourceDataNotify.getVersion());
        e3.a.e("notify resource %s, version = %d", resourceDataNotify.getResName(), Integer.valueOf(resourceDataNotify.getVersion()));
    }
}
