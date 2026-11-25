package com.haier.uhome.search.b;

import com.haier.uhome.search.json.notify.UnconnectedDevSearchNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.haier.uhome.usdk.base.c.e {
    private com.haier.uhome.search.service.entity.i a(UnconnectedDevSearchNotify unconnectedDevSearchNotify) {
        com.haier.uhome.search.service.entity.i iVar = new com.haier.uhome.search.service.entity.i();
        iVar.a(unconnectedDevSearchNotify.getIp());
        iVar.a(unconnectedDevSearchNotify.getErrNo());
        iVar.a(unconnectedDevSearchNotify.getInfos() == null ? new ArrayList<>() : unconnectedDevSearchNotify.getInfos());
        return iVar;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        if (basicNotify.getClass() != UnconnectedDevSearchNotify.class) {
            e3.a.h("current notify is not UnconnectedDevSearchNotify", new Object[0]);
            return;
        }
        com.haier.uhome.search.service.entity.i iVarA = a((UnconnectedDevSearchNotify) basicNotify);
        f.a().a(iVarA);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29686g, "notify unconnected dev search %s", iVarA);
    }
}
