package com.haier.uhome.control.local.a;

import com.haier.uhome.control.local.json.notify.ConfigFileReadyNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("config file ready: %s", basicNotify);
        com.haier.uhome.control.local.e.g.a().a(((ConfigFileReadyNotify) basicNotify).getUplusId());
    }
}
