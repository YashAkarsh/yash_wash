package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.BoardFOTAStatusNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        BoardFOTAStatusNotify boardFOTAStatusNotify = (BoardFOTAStatusNotify) basicNotify;
        h.a().b(boardFOTAStatusNotify.getDevId(), boardFOTAStatusNotify.getErrNum(), boardFOTAStatusNotify.getStatus());
        e3.a.e("notify fota status msg %s", boardFOTAStatusNotify);
    }
}
