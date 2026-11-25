package com.haier.uhome.trace.b;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.VersionManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, c> f30284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f30285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f30286c;

    /* JADX INFO: renamed from: com.haier.uhome.trace.b.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f30288b;

        static {
            int[] iArr = new int[f.values().length];
            f30288b = iArr;
            try {
                iArr[f.CS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30288b[f.CR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30288b[f.SR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30288b[f.SS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.values().length];
            f30287a = iArr2;
            try {
                iArr2[e.APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30287a[e.USDK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30287a[e.MODULE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f30289a = new g(null);

        private a() {
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a() {
        return a.f30289a;
    }

    public boolean b() {
        return this.f30285b.get();
    }

    public boolean c() {
        return this.f30286c.get();
    }

    private g() {
        this.f30284a = new HashMap<>();
        this.f30285b = new AtomicBoolean(true);
        this.f30286c = new AtomicBoolean(true);
    }

    public void a(String str, c cVar) {
        this.f30284a.put(str, cVar);
    }

    public void b(boolean z7) {
        this.f30286c.set(z7);
    }

    public ErrorConst c(HashMap<String, String> map) {
        if (!c()) {
            e3.a.o("addDINode error : MODULE_UNSTARTED", new Object[0]);
            return ErrorConst.ERR_MODULE_UNSTARTED;
        }
        if (map == null) {
            e3.a.o("addDINode error : map is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        int iHashCode = map.hashCode();
        e3.a.e("addDINode map<%d> is : <%s>", Integer.valueOf(iHashCode), map);
        ErrorConst errorConstB = b("op", map);
        e3.a.e("addDINode sendEvent map<%d> ret %s", Integer.valueOf(iHashCode), errorConstB);
        return errorConstB;
    }

    private void b(d dVar, TraceNode traceNode, TraceNode traceNode2) {
        if (dVar != null) {
            f type = dVar.c().getType();
            TraceNode relatedCSNode = dVar.c().getRelatedCSNode();
            TraceNode relatedSRNode = dVar.c().getRelatedSRNode();
            TraceNode innerSRNode = dVar.c().getInnerSRNode();
            if (type != null) {
                int i7 = AnonymousClass1.f30288b[type.ordinal()];
                if (i7 == 1) {
                    if (relatedSRNode != null) {
                        dVar.a(relatedSRNode.getSpanId().concat(".1"));
                        return;
                    } else {
                        if (relatedCSNode != null) {
                            String spanId = relatedCSNode.getSpanId();
                            int iLastIndexOf = spanId.lastIndexOf(46) + 1;
                            dVar.a(spanId.substring(0, iLastIndexOf).concat(String.valueOf(Integer.parseInt(spanId.substring(iLastIndexOf)) + 1)));
                            return;
                        }
                        return;
                    }
                }
                if (i7 == 2) {
                    if (relatedCSNode != null) {
                        dVar.a(relatedCSNode.getSpanId());
                        return;
                    } else {
                        e3.a.h("genSDKSpanId CR, but csNode is null!", new Object[0]);
                        return;
                    }
                }
                if (i7 != 3) {
                    if (i7 != 4) {
                        e3.a.h("genSDKSpanId type error!", new Object[0]);
                        return;
                    } else if (relatedSRNode != null) {
                        dVar.a(relatedSRNode.getSpanId());
                        return;
                    } else {
                        e3.a.h("genSDKSpanId SS, but srNode is null!", new Object[0]);
                        return;
                    }
                }
                if (innerSRNode != null) {
                    String spanId2 = innerSRNode.getSpanId();
                    int iLastIndexOf2 = spanId2.lastIndexOf(46) + 1;
                    dVar.a(spanId2.substring(0, iLastIndexOf2).concat(String.valueOf(Integer.parseInt(spanId2.substring(iLastIndexOf2)) + 1)));
                    return;
                }
                if (relatedCSNode != null) {
                    dVar.a(relatedCSNode.getSpanId());
                    return;
                }
                if (traceNode2 == null) {
                    dVar.a("0.1");
                    return;
                }
                String spanId3 = traceNode2.getSpanId();
                int iLastIndexOf3 = spanId3.lastIndexOf(46) + 1;
                dVar.a(spanId3.substring(0, iLastIndexOf3).concat(String.valueOf(Integer.parseInt(spanId3.substring(iLastIndexOf3)) + 1)));
            }
        }
    }

    public void a(boolean z7) {
        this.f30285b.set(z7);
    }

    public c a(String str) {
        c cVar = this.f30284a.get(str);
        if (cVar == null) {
            e3.a.h("no TraceImpl found in traceImplHashMap, App must call Trace.createTrace(businessId) first !!!", new Object[0]);
        }
        return cVar;
    }

    void a(d dVar, e eVar, TraceNode traceNode, TraceNode traceNode2, TraceNode traceNode3) {
        int i7 = AnonymousClass1.f30287a[eVar.ordinal()];
        if (i7 == 1) {
            a(dVar, traceNode, traceNode3);
        } else if (i7 == 2) {
            b(dVar, traceNode2, traceNode3);
        } else if (i7 != 3) {
            e3.a.v("genSpanId error with wrong sys <%s>", eVar);
        }
    }

    private synchronized void a(d dVar, TraceNode traceNode, TraceNode traceNode2) {
        if (dVar != null) {
            f type = dVar.c().getType();
            if (type != null) {
                int i7 = AnonymousClass1.f30288b[type.ordinal()];
                if (i7 != 1) {
                    if (i7 != 2) {
                        e3.a.h("genAppSpanId type error!", new Object[0]);
                    } else {
                        TraceNode relatedCSNode = dVar.c().getRelatedCSNode();
                        if (relatedCSNode != null) {
                            dVar.a(relatedCSNode.getSpanId());
                        } else {
                            e3.a.h("genAppSpanId CR, but csNode is null!", new Object[0]);
                        }
                    }
                } else if (traceNode == null) {
                    if (traceNode2 == null) {
                        dVar.a("0.1");
                    } else {
                        String spanId = traceNode2.getSpanId();
                        int iLastIndexOf = spanId.lastIndexOf(46) + 1;
                        dVar.a(spanId.substring(0, iLastIndexOf).concat(String.valueOf(Integer.parseInt(spanId.substring(iLastIndexOf)) + 1)));
                    }
                } else if (traceNode2 == null) {
                    String spanId2 = traceNode.getSpanId();
                    int iLastIndexOf2 = spanId2.lastIndexOf(46) + 1;
                    dVar.a(spanId2.substring(0, iLastIndexOf2).concat(String.valueOf(Integer.parseInt(spanId2.substring(iLastIndexOf2)) + 1)));
                } else {
                    String spanId3 = traceNode.getSpanId();
                    String spanId4 = traceNode2.getSpanId();
                    if (spanId3.compareTo(spanId4) <= 0) {
                        spanId3 = spanId4;
                    }
                    int iLastIndexOf3 = spanId3.lastIndexOf(46) + 1;
                    dVar.a(spanId3.substring(0, iLastIndexOf3).concat(String.valueOf(Integer.parseInt(spanId3.substring(iLastIndexOf3)) + 1)));
                }
            }
        }
    }

    public ErrorConst b(HashMap<String, String> map) {
        if (map == null) {
            e3.a.o("addNetNode error : map is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        map.put(TraceProtocolConst.PRO_TRACE_ID, com.haier.uhome.trace.c.a.a());
        map.put(TraceProtocolConst.PRO_BUSINESS_ID, "net");
        map.put(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        map.put("sys", e.USDK.name());
        map.put(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        map.put(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        int iHashCode = map.hashCode();
        e3.a.e("addNetNode map<%d> is : <%s>", Integer.valueOf(iHashCode), map);
        ErrorConst errorConstB = b("net", map);
        e3.a.e("addNetNode sendEvent map<%d> ret %s", Integer.valueOf(iHashCode), errorConstB);
        return errorConstB;
    }

    public ErrorConst a(HashMap<String, String> map) {
        if (map == null) {
            e3.a.o("addDNSNode error : map is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        map.put(TraceProtocolConst.PRO_BUSINESS_ID, b.f30245b);
        map.put(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        if (strG == null) {
            strG = "";
        }
        map.put(TraceProtocolConst.PRO_TOKEN, strG);
        map.put(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        int iHashCode = map.hashCode();
        e3.a.e("addDNSNode map<%d> is : <%s>", Integer.valueOf(iHashCode), map);
        ErrorConst errorConstB = b(b.f30245b, map);
        e3.a.e("addDNSNode sendEvent map<%d> ret %s", Integer.valueOf(iHashCode), errorConstB);
        return errorConstB;
    }

    private ErrorConst b(String str, HashMap<String, String> map) {
        return com.haier.uhome.trace.a.a.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, map) ? ErrorConst.RET_USDK_OK : ErrorConst.ERR_INTERNAL;
    }

    public ErrorConst a(String str, HashMap<String, String> map) {
        if (!b()) {
            e3.a.o("addTraceNode error : MODULE_UNSTARTED", new Object[0]);
            return ErrorConst.ERR_MODULE_UNSTARTED;
        }
        if (map == null) {
            e3.a.o("addTraceNode error : map is null", new Object[0]);
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        int iHashCode = map.hashCode();
        e3.a.e("addTraceNode map<%d> is : <%s>", Integer.valueOf(iHashCode), map);
        ErrorConst errorConstB = b(str, map);
        e3.a.e("addTraceNode sendEvent map<%d> ret %s", Integer.valueOf(iHashCode), errorConstB);
        return errorConstB;
    }
}
