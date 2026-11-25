package com.haier.uhome.search.b;

import com.haier.uhome.search.json.notify.SmartConfigAckNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        SmartConfigAckNotify smartConfigAckNotify = (SmartConfigAckNotify) basicNotify;
        f.a().a(smartConfigAckNotify.getDevId(), smartConfigAckNotify.getSeed(), smartConfigAckNotify.getUplusId(), smartConfigAckNotify.getSecVer(), smartConfigAckNotify.getConfigMode());
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "notify smartconfig ack %s", smartConfigAckNotify);
    }
}
