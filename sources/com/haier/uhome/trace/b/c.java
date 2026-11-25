package com.haier.uhome.trace.b;

import android.text.TextUtils;
import c.m0;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, String> f30263f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TraceNode f30266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TraceNode f30267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TraceNode f30268e;

    static {
        HashMap map = new HashMap(4);
        f30263f = map;
        map.put(b.f30244a, b.f30244a);
        f30263f.put("common", b.f30244a);
        f30263f.put(b.f30245b, b.f30245b);
        f30263f.put("net", "net");
    }

    private c() {
        c(com.haier.uhome.trace.c.a.a());
    }

    public static c a(String str) {
        return a((String) null, str);
    }

    public static c b(String str) {
        if (!g.a().b()) {
            e3.a.h("createDITraceImpl error: trace not enable", new Object[0]);
            return null;
        }
        c cVar = TextUtils.isEmpty(str) ? new c() : new c(str);
        cVar.d(null);
        return cVar;
    }

    private void c(String str) {
        this.f30264a = str;
    }

    private void d(String str) {
        this.f30265b = str;
    }

    public static c a(String str, String str2) {
        if (!g.a().b()) {
            e3.a.h("createTraceImpl error: trace not enable", new Object[0]);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            e3.a.h("createTraceImpl error, businessId is null or empty!", new Object[0]);
            str2 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            c cVar = new c(str);
            cVar.d(str2);
            return cVar;
        }
        c cVar2 = new c();
        cVar2.d(str2);
        g.a().a(str2, cVar2);
        return cVar2;
    }

    private String c() {
        return this.f30265b;
    }

    private c(@m0 String str) {
        c(str);
    }

    public String b() {
        return this.f30264a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x004e A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0052 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005d A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0060 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0064 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0016, B:13:0x0020, B:14:0x0024, B:15:0x002b, B:17:0x003f, B:19:0x004e, B:21:0x0052, B:22:0x0055, B:24:0x0059, B:26:0x005d, B:27:0x0060, B:29:0x0064, B:30:0x0066), top: B:36:0x0003 }] */
    private synchronized HashMap<String, String> b(TraceNode traceNode, e eVar) {
        TraceNode traceNode2;
        d dVar;
        f type;
        if (traceNode != null) {
            if (e.APP == eVar && f.CS == traceNode.getType() && (traceNode2 = this.f30266c) != null) {
                traceNode.setRelatedCSNode(traceNode2);
            }
            String customTraceId = traceNode.getCustomTraceId();
            if (!TextUtils.isEmpty(customTraceId)) {
                traceNode.setTraceId(customTraceId);
            } else {
                traceNode.setTraceId(b());
            }
            dVar = new d(traceNode, c(), eVar);
            dVar.a(eVar, this.f30266c, this.f30268e, this.f30267d);
            if (traceNode != null) {
                traceNode.setSpanId(dVar.a());
                type = traceNode.getType();
                if (e.APP == eVar) {
                    if (f.CS == type) {
                        this.f30266c = traceNode;
                    }
                } else if (e.USDK == eVar) {
                    if (f.SR == type) {
                        this.f30267d = traceNode;
                    } else if (f.CS == type) {
                        this.f30268e = traceNode;
                    }
                }
            }
        } else {
            dVar = new d(traceNode, c(), eVar);
            dVar.a(eVar, this.f30266c, this.f30268e, this.f30267d);
            if (traceNode != null) {
                traceNode.setSpanId(dVar.a());
                type = traceNode.getType();
                if (e.APP == eVar) {
                    if (f.CS == type) {
                        this.f30266c = traceNode;
                    }
                } else if (e.USDK == eVar) {
                    if (f.SR == type) {
                        this.f30267d = traceNode;
                    } else if (f.CS == type) {
                        this.f30268e = traceNode;
                    }
                }
            }
        }
        throw th;
        return dVar.d();
    }

    public static c a() {
        return b(null);
    }

    public ErrorConst a(TraceNode traceNode, e eVar) {
        e3.a.e("addTraceNode node: %s, sys: %s", traceNode, eVar);
        if (!g.a().b()) {
            e3.a.h("addTraceNode error: trace not enable", new Object[0]);
            return ErrorConst.ERR_MODULE_UNSTARTED;
        }
        if (traceNode == null) {
            e3.a.h("addTraceNode error: node is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (TextUtils.isEmpty(b()) && TextUtils.isEmpty(traceNode.getCustomTraceId())) {
            e3.a.h("addTraceNode error: traceId is empty!", new Object[0]);
            return ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED;
        }
        String str = f30263f.get(this.f30265b);
        if (TextUtils.isEmpty(str)) {
            e3.a.n("reverse %s to %s for support analysis", b.f30244a, b.f30244a, new Object[0]);
            str = b.f30244a;
        }
        return g.a().a(str, b(traceNode, eVar));
    }

    public ErrorConst a(String str, DITraceNode dITraceNode) {
        a aVar;
        e3.a.e("addDITraceNode node: %s", dITraceNode);
        if (!g.a().b()) {
            e3.a.h("addDITraceNode error: trace not enable", new Object[0]);
            return ErrorConst.ERR_MODULE_UNSTARTED;
        }
        if (dITraceNode == null) {
            e3.a.h("addDITraceNode error: node is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(b())) {
                e3.a.h("addDITraceNode error: traceId is empty!", new Object[0]);
                return ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED;
            }
            aVar = new a(b(), dITraceNode);
        } else {
            e3.a.h("customTraceId = %s", str);
            aVar = new a(str, dITraceNode);
        }
        return g.a().c(aVar.h());
    }
}
