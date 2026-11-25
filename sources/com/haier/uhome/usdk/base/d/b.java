package com.haier.uhome.usdk.base.d;

import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.InComing;
import com.haier.uhome.usdk.base.json.ProtocolProcessor;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.haier.uhome.usdk.base.a.a {
    @Override // com.haier.uhome.usdk.base.a.a
    public void a(InComing inComing) {
        ProtocolProcessor.handleInComing(inComing);
    }

    @Override // com.haier.uhome.usdk.base.a.a
    public void b(BasicReq basicReq) {
        e3.a.h("onSendError : %s", basicReq);
    }

    @Override // com.haier.uhome.usdk.base.a.a
    public void a(String str) {
        e3.a.h("onParsePacketError : %s", str);
    }

    @Override // com.haier.uhome.usdk.base.a.a
    public void a(BasicReq basicReq) {
        e3.a.e("onSendFinished : %s", basicReq);
    }
}
