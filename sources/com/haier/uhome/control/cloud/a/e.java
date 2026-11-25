package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.CloudBusinessNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        CloudBusinessNotify cloudBusinessNotify = (CloudBusinessNotify) basicNotify;
        h.a().a(cloudBusinessNotify.getInfo());
        e3.a.e("notify cloud business msg %s", cloudBusinessNotify.getInfo());
    }
}
