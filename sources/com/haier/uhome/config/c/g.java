package com.haier.uhome.config.c;

import com.haier.uhome.config.json.notify.NewDirectLinkBindProgressNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        NewDirectLinkBindProgressNotify newDirectLinkBindProgressNotify = (NewDirectLinkBindProgressNotify) basicNotify;
        c.a().a(newDirectLinkBindProgressNotify.getDevId(), newDirectLinkBindProgressNotify.getProgress(), newDirectLinkBindProgressNotify.getResult(), newDirectLinkBindProgressNotify.getErrNo());
    }
}
