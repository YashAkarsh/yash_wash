package com.haier.uhome.config.c;

import com.haier.uhome.config.json.notify.ConfigStateNotify;
import com.haier.uhome.config.json.notify.ModuleConfigStateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        if (basicNotify.getClass() == ConfigStateNotify.class) {
            c.a().a(com.haier.uhome.config.entity.d.a((ConfigStateNotify) basicNotify, 1));
        }
        if (basicNotify.getClass() == ModuleConfigStateNotify.class) {
            c.a().a(com.haier.uhome.config.entity.d.a((ModuleConfigStateNotify) basicNotify, 2));
        }
        e3.a.e("config state notify %s", basicNotify);
    }
}
