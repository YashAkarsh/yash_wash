package com.haier.uhome.trace.b;

import android.text.TextUtils;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f30235a = "DI";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f30237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f30238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f30239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f30240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f30241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DITraceNode f30242h;

    /* JADX INFO: renamed from: com.haier.uhome.trace.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30243a;

        static {
            int[] iArr = new int[e.values().length];
            f30243a = iArr;
            try {
                iArr[e.MODULE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30243a[e.APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30243a[e.USDK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    a(String str, DITraceNode dITraceNode) {
        a(str);
        a(dITraceNode);
        a(e.a(dITraceNode.getExtendInfo().get("sys")));
        a(System.currentTimeMillis());
    }

    public String a() {
        return this.f30236b;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30237c)) {
            b(com.haier.uhome.usdk.base.service.e.a().i());
        }
        return this.f30237c;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f30238d)) {
            c(com.haier.uhome.usdk.base.service.e.a().g());
        }
        return this.f30238d;
    }

    public e d() {
        return this.f30239e;
    }

    public long e() {
        return this.f30240f;
    }

    public long f() {
        return this.f30241g;
    }

    public DITraceNode g() {
        return this.f30242h;
    }

    public HashMap<String, String> h() {
        HashMap<String, String> map = new HashMap<>();
        a(map, a(), TraceProtocolConst.PRO_TRACE_ID);
        a(map, f30235a, TraceProtocolConst.PRO_STEP);
        a(map, this.f30242h.getBusinessId(), TraceProtocolConst.PRO_BUSINESS_ID);
        if ("opack".equals(this.f30242h.getBusinessId())) {
            a(map, com.haier.uhome.usdk.base.service.e.a().j(), TraceProtocolConst.PRO_PVER);
        }
        e eVarD = d();
        if (eVarD == null) {
            eVarD = e.APP;
        }
        a(map, eVarD.name(), "sys");
        int i7 = AnonymousClass1.f30243a[eVarD.ordinal()];
        if (i7 == 1) {
            a(map, String.valueOf(f()), TraceProtocolConst.PRO_SPAN);
        } else if (i7 == 2 || i7 == 3) {
            a(map, String.valueOf(e()), TraceProtocolConst.PRO_TIMESTAMP);
            a(map, b(), TraceProtocolConst.PRO_APP_ID);
            a(map, this.f30242h.getVersion(), TraceProtocolConst.PRO_VERSION);
            a(map, c(), TraceProtocolConst.PRO_TOKEN);
        }
        a(map, this.f30242h.getCode(), "code");
        a(map, this.f30242h.getDeviceId(), TraceProtocolConst.PRO_DEVICE_ID);
        a(map, this.f30242h.getBusinessName(), TraceProtocolConst.PRO_BUSINESS_NAME);
        map.putAll(this.f30242h.getExtendInfo());
        return map;
    }

    public void a(String str) {
        this.f30236b = str;
    }

    public void a(e eVar) {
        this.f30239e = eVar;
    }

    public void a(long j7) {
        this.f30240f = j7;
    }

    public void b(String str) {
        this.f30237c = str;
    }

    public void c(String str) {
        this.f30238d = str;
    }

    public void a(DITraceNode dITraceNode) {
        this.f30242h = dITraceNode;
    }

    public void b(long j7) {
        this.f30241g = j7;
    }

    private void a(HashMap<String, String> map, String str, String str2) {
        if (str == null) {
            e3.a.h("putItem2map Error, %s is null", str2);
        } else {
            map.put(str2, str);
        }
    }
}
