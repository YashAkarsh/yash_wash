package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.CloudTraceCbNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        CloudTraceCbNotify cloudTraceCbNotify = (CloudTraceCbNotify) basicNotify;
        h.a().a(cloudTraceCbNotify.getTraceId(), cloudTraceCbNotify.getBid(), cloudTraceCbNotify.getBname(), cloudTraceCbNotify.getSys(), cloudTraceCbNotify.getCode());
        e3.a.e("notify cloud trace cb notify %s", cloudTraceCbNotify);
    }
}
