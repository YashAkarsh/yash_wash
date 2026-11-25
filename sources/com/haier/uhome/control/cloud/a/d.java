package com.haier.uhome.control.cloud.a;

import com.haier.uhome.control.cloud.json.notify.BusinessMsgNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.usdk.base.c.e {
    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        BusinessMsgNotify businessMsgNotify = (BusinessMsgNotify) basicNotify;
        h.a().a(businessMsgNotify.getInfo().getBindingReport().getDev(), businessMsgNotify.getInfo().getBindingReport().getUpid(), businessMsgNotify.getInfo().getBindingReport().getUpCodeT(), businessMsgNotify.getInfo().getBindingReport().getStatus(), businessMsgNotify.getInfo().getBindingReport().getErrNo(), businessMsgNotify.getInfo().getBindingReport().getBindSn());
        e3.a.e("notify business msg %s", businessMsgNotify);
    }
}
