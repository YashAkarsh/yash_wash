package com.haier.uhome.control.local.a;

import com.haier.uhome.control.local.json.notify.ModuleOTAProgressNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("notify ota progress %s", basicNotify);
        ModuleOTAProgressNotify moduleOTAProgressNotify = (ModuleOTAProgressNotify) basicNotify;
        e.a().a(moduleOTAProgressNotify.getDevId(), moduleOTAProgressNotify.getProgress());
    }
}
