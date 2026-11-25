package com.haier.uhome.control.base.d;

import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.trace.b.e;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Trace f28974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.control.base.api.a f28976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f28978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f28979f;

    public a(Trace trace, String str, com.haier.uhome.control.base.api.a aVar) {
        this(trace, str, aVar, System.currentTimeMillis());
    }

    public void a(String str, Object obj) {
        this.f28979f.put(str, obj);
    }

    public a(Trace trace, String str, com.haier.uhome.control.base.api.a aVar, long j7) {
        this.f28979f = new HashMap(10);
        if (trace == null) {
            return;
        }
        this.f28974a = trace;
        this.f28975b = str;
        this.f28976c = aVar;
        this.f28978e = j7;
        com.haier.uhome.control.base.c.a aVarS = aVar.s();
        this.f28977d = aVarS.k();
        this.f28979f.put(aVarS.i(), aVar.n().getValue());
        e3.a.d("traceId: %s, bName: %s, op: ts = %d", trace.getTraceId(), str, Long.valueOf(j7));
    }

    public void a(uSDKError usdkerror) {
        if (this.f28974a == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        e3.a.d("traceId: %s, bName: %s, opack: ts = %d", this.f28974a.getTraceId(), this.f28975b, Long.valueOf(jCurrentTimeMillis));
        com.haier.uhome.control.base.c.a aVarS = this.f28976c.s();
        this.f28979f.put(aVarS.j(), this.f28976c.n().getValue());
        DITraceNode dITraceNode = new DITraceNode("opack", this.f28975b, this.f28976c.X(), String.valueOf(usdkerror == null ? ErrorConst.ERR_INTERNAL.getErrorId() : usdkerror.getCode()), VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_PIPE, String.valueOf(aVarS.g()));
        dITraceNode.add("sys", e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(jCurrentTimeMillis));
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, aVarS.g(this.f28976c));
        dITraceNode.add(TraceProtocolConst.PRO_SPAN, String.valueOf(jCurrentTimeMillis - this.f28978e));
        if (this.f28979f.size() > 0) {
            dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(this.f28979f));
        }
        dITraceNode.add(TraceProtocolConst.PRO_NETWORK_TYPE, this.f28977d);
        this.f28974a.addDITraceNode(dITraceNode);
    }
}
