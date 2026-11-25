package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.InvalidTokenNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class q extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        InvalidTokenNotify invalidTokenNotify = (InvalidTokenNotify) basicNotify;
        h.a().b(invalidTokenNotify.getToken());
        e3.a.e("notify invalid token msg %s", invalidTokenNotify.getToken());
    }
}
