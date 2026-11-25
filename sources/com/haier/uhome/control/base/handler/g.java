package com.haier.uhome.control.base.handler;

import android.os.Build;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.control.base.json.notify.UcomTraceCbNotify;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.uhome.usdk.base.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f28985a = "common";

    private void a(UcomTraceCbNotify ucomTraceCbNotify) {
        Trace traceCreateDITrace;
        if (ucomTraceCbNotify == null || (traceCreateDITrace = Trace.createDITrace()) == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("common", ucomTraceCbNotify.getModule(), ucomTraceCbNotify.getDevId(), null, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_BUSINESS_ID, "common");
        dITraceNode.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        dITraceNode.add("mver", Build.VERSION.RELEASE);
        dITraceNode.add(TraceProtocolConst.PRO_SUB_SYSTEM, ucomTraceCbNotify.getSubSys());
        dITraceNode.add(TraceProtocolConst.PRO_BUSINESS_NAME, ucomTraceCbNotify.getModule());
        dITraceNode.add(TraceProtocolConst.PRO_DEVICE_ID, ucomTraceCbNotify.getDevId());
        dITraceNode.add(TraceProtocolConst.PRO_EXCEPTION, ucomTraceCbNotify.getSysErrInfo());
        dITraceNode.add("code", String.valueOf(ucomTraceCbNotify.getUcomErrno()));
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(RetInfoContent.TYPEID_ISNULL, ucomTraceCbNotify.getUplusId());
        dITraceNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        e3.a.e("UcomTraceCbNotifyHandler : %s", basicNotify);
        a((UcomTraceCbNotify) basicNotify);
    }
}
