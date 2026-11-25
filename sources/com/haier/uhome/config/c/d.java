package com.haier.uhome.config.c;

import com.haier.uhome.config.json.notify.ConfigProcessNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        com.haier.uhome.config.entity.c cVarA = com.haier.uhome.config.entity.c.a((ConfigProcessNotify) basicNotify);
        c.a().a(cVarA);
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "notify config process msg %s", cVarA);
    }
}
