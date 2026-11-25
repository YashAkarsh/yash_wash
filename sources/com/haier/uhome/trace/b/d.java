package com.haier.uhome.trace.b;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f30271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TraceNode f30273e;

    /* JADX INFO: renamed from: com.haier.uhome.trace.b.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30274a;

        static {
            int[] iArr = new int[f.values().length];
            f30274a = iArr;
            try {
                iArr[f.CR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30274a[f.SS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    d(TraceNode traceNode, String str, e eVar) {
        a(traceNode);
        b(str);
        a(eVar);
    }

    private void b(String str) {
        this.f30269a = str;
    }

    private String e() {
        return this.f30269a;
    }

    private String f() {
        return com.haier.uhome.usdk.base.service.e.a().i();
    }

    private long g() {
        return this.f30272d;
    }

    String a() {
        return this.f30270b;
    }

    TraceNode c() {
        return this.f30273e;
    }

    HashMap<String, String> d() {
        HashMap<String, String> map = new HashMap<>();
        a(map, a(), TraceProtocolConst.PRO_SPAN_ID);
        a(map, e(), TraceProtocolConst.PRO_BUSINESS_ID);
        a(map, f(), TraceProtocolConst.PRO_APP_ID);
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        if (!TextUtils.isEmpty(strG)) {
            a(map, strG, TraceProtocolConst.PRO_TOKEN);
        }
        if (g() > 0) {
            a(map, String.valueOf(g()), TraceProtocolConst.PRO_SPAN);
        }
        e eVarB = b();
        if (eVarB == null) {
            e3.a.e("getTraceMap Error, sys is null", new Object[0]);
        } else {
            a(map, eVarB.name(), "sys");
        }
        TraceNode traceNodeC = c();
        if (traceNodeC == null) {
            e3.a.e("getTraceMap Error, traceNode is null", new Object[0]);
        } else {
            a(map, traceNodeC.getTraceId(), TraceProtocolConst.PRO_TRACE_ID);
            a(map, traceNodeC.getType().name(), TraceProtocolConst.PRO_STEP);
            a(map, String.valueOf(traceNodeC.getTimestamp()), TraceProtocolConst.PRO_TIMESTAMP);
            a(map, traceNodeC.getBusinessName(), TraceProtocolConst.PRO_BUSINESS_NAME);
            a(map, traceNodeC.getProtocol(), TraceProtocolConst.PRO_PROTOCOL);
            map.putAll(traceNodeC.getExtendInfo());
        }
        return map;
    }

    void a(String str) {
        this.f30270b = str;
    }

    public e b() {
        return this.f30271c;
    }

    protected void a(e eVar) {
        this.f30271c = eVar;
    }

    private void a(long j7) {
        this.f30272d = j7;
    }

    private void a(TraceNode traceNode) {
        this.f30273e = traceNode;
    }

    public ErrorConst a(e eVar, TraceNode traceNode, TraceNode traceNode2, TraceNode traceNode3) {
        g.a().a(this, eVar, traceNode, traceNode2, traceNode3);
        if (c() != null) {
            long timestamp = c().getTimestamp();
            int i7 = AnonymousClass1.f30274a[c().getType().ordinal()];
            if (i7 != 1) {
                if (i7 == 2 && e.USDK == eVar && traceNode3 != null) {
                    a(timestamp - traceNode3.getTimestamp());
                }
            } else if (e.APP == eVar && traceNode != null) {
                a(timestamp - traceNode.getTimestamp());
            } else if (e.USDK == eVar && traceNode2 != null) {
                a(timestamp - traceNode2.getTimestamp());
            }
        }
        return ErrorConst.RET_USDK_OK;
    }

    private void a(HashMap<String, String> map, String str, String str2) {
        if (str == null) {
            e3.a.h("putItem2map Error, %s is null", str2);
            map.put(str2, "");
        } else {
            map.put(str2, str);
        }
    }
}
