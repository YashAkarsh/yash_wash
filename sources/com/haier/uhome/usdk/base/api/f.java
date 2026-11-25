package com.haier.uhome.usdk.base.api;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0378f f31125b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f31127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f31131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f31132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.uhome.usdk.base.utils.f.a f31133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.d f31134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f31135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f31136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f31137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f31138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31140q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f31124a = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f31126c = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f31128e = new b(this);

    /* JADX INFO: renamed from: com.haier.uhome.usdk.base.api.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31141a;

        static {
            int[] iArr = new int[q.values().length];
            f31141a = iArr;
            try {
                iArr[q.COAP_CAE_DEV_STD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31141a[q.COAP_CAE_DEV_STD_SAFE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31141a[q.BLE_CAE_DEV_EPP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31141a[q.BLE_CAE_DEV_EPP_SAFE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31141a[q.UWT_DEV.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31141a[q.UWT_DEV_SAFE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31141a[q.COAP_CAE_DEV_EPP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31141a[q.COAP_CAE_DEV_EPP_SAFE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f31142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f31143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f31144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private q f31145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f31146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f31148g;

        /* synthetic */ a(f fVar, AnonymousClass1 anonymousClass1) {
            this(fVar);
        }

        public int a() {
            return this.f31147f;
        }

        public String b() {
            return this.f31148g;
        }

        public com.haier.uhome.usdk.base.api.d c() {
            return f.a(this.f31145d);
        }

        public q d() {
            return this.f31145d;
        }

        public int e() {
            return this.f31144c;
        }

        public String f() {
            return this.f31143b;
        }

        public String g() {
            return this.f31146e;
        }

        private a(f fVar) {
            this.f31142a = fVar;
        }

        public void a(int i7) {
            int i8 = this.f31147f;
            if (i8 != i7) {
                this.f31147f = i7;
                this.f31142a.f31124a.a(h.SECURITY_VERSION, Integer.valueOf(i8), Integer.valueOf(this.f31147f));
            }
        }

        public void b(int i7) {
            this.f31144c = i7;
        }

        public void c(String str) {
            this.f31146e = str;
        }

        public void b(String str) {
            this.f31143b = str;
        }

        public void a(String str) {
            this.f31148g = str;
            a(f.c(str));
        }

        public void a(q qVar) {
            this.f31145d = qVar;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f31149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f31150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f31151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f31152d;

        public b(f fVar) {
            this.f31149a = fVar;
        }

        public int a() {
            return this.f31152d;
        }

        public String b() {
            return this.f31150b;
        }

        public boolean c() {
            return this.f31151c;
        }

        public void a(int i7) {
            this.f31152d = i7;
        }

        public void a(String str) {
            f fVarA;
            String str2 = this.f31150b;
            if (com.haier.library.common.util.c.c(str2, str)) {
                return;
            }
            this.f31150b = str;
            e3.a.e("setMyGroupDevId myGroupDevId = %s", str);
            g gVar = this.f31149a.f31124a;
            h hVar = h.GROUP;
            Boolean bool = Boolean.FALSE;
            gVar.a(hVar, bool, bool);
            if (TextUtils.isEmpty(str2) || (fVarA = com.haier.uhome.usdk.base.api.g.a().a(str2)) == null) {
                return;
            }
            fVarA.f31124a.a(hVar, bool, bool);
        }

        public void a(boolean z7) {
            boolean z8 = this.f31151c;
            if (z8 != z7) {
                this.f31151c = z7;
                this.f31149a.f31124a.a(h.GROUP, Boolean.valueOf(z8), Boolean.valueOf(this.f31151c));
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f31153a;

        public String a() {
            return this.f31153a;
        }

        public void a(String str) {
            this.f31153a = str;
        }
    }

    public interface d<T> {
        void a(T t7, T t8);
    }

    public interface e {
        void onChange(h hVar);
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.base.api.f$f, reason: collision with other inner class name */
    public static class C0378f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f31154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f31155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f31156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f31158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f31159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f31160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f31161h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f31162i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f31163j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f31164k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f31165l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private q f31166m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private com.haier.uhome.usdk.base.api.d f31167n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f31168o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f31169p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f31170q;

        /* synthetic */ C0378f(f fVar, AnonymousClass1 anonymousClass1) {
            this(fVar);
        }

        public int a() {
            return this.f31169p;
        }

        public String b() {
            return this.f31170q;
        }

        public q c() {
            return this.f31166m;
        }

        public com.haier.uhome.usdk.base.api.d d() {
            return this.f31167n;
        }

        public int e() {
            return this.f31162i;
        }

        public int f() {
            return this.f31163j;
        }

        public String g() {
            return this.f31164k;
        }

        public String h() {
            return this.f31165l;
        }

        public String i() {
            return this.f31161h;
        }

        public int j() {
            return this.f31160g;
        }

        public String k() {
            return this.f31159f;
        }

        public String l() {
            return this.f31155b;
        }

        public String m() {
            return this.f31156c;
        }

        public boolean n() {
            return this.f31157d;
        }

        public int o() {
            return this.f31158e;
        }

        public String p() {
            return this.f31168o;
        }

        private C0378f(f fVar) {
            this.f31154a = fVar;
        }

        public void a(int i7) {
            int i8 = this.f31169p;
            if (i8 != i7) {
                this.f31169p = i7;
                this.f31154a.f31124a.a(h.SECURITY_VERSION, Integer.valueOf(i8), Integer.valueOf(this.f31169p));
            }
        }

        public void b(int i7) {
            this.f31162i = i7;
        }

        public void c(int i7) {
            this.f31163j = i7;
        }

        public void d(String str) {
            this.f31161h = str;
        }

        public void e(String str) {
            this.f31159f = str;
        }

        public void f(String str) {
            this.f31155b = str;
        }

        public void g(String str) {
            this.f31156c = str;
        }

        public void h(String str) {
            this.f31168o = str;
        }

        public void b(String str) {
            this.f31164k = str;
        }

        public void c(String str) {
            this.f31165l = str;
        }

        public void d(int i7) {
            this.f31160g = i7;
        }

        public void e(int i7) {
            this.f31158e = i7;
        }

        public void a(String str) {
            this.f31170q = str;
            a(f.c(str));
        }

        private void a(com.haier.uhome.usdk.base.api.d dVar) {
            com.haier.uhome.usdk.base.api.d dVar2 = this.f31167n;
            if (dVar2 != dVar) {
                this.f31167n = dVar;
                this.f31154a.f31124a.a(h.DEV_PROTOCOL_TYPE, dVar2, dVar);
            }
        }

        public void a(q qVar) {
            this.f31166m = qVar;
            a(f.a(qVar));
        }

        public void a(boolean z7) {
            this.f31157d = z7;
        }
    }

    public class g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<e> f31172b = new CopyOnWriteArraySet();

        g() {
        }

        public void b(e eVar) {
            this.f31172b.remove(eVar);
        }

        public void a(e eVar) {
            this.f31172b.add(eVar);
        }

        void a() {
            this.f31172b.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(h hVar, Object obj, Object obj2) {
            Iterator<e> it = this.f31172b.iterator();
            while (it.hasNext()) {
                it.next().onChange(hVar);
            }
        }
    }

    public enum h {
        BUSY,
        UPLUS_ID,
        IP,
        PORT,
        SHARE_PORT,
        DEV_PROTOCOL_TYPE,
        SECURITY_VERSION,
        GROUP,
        AUX_CONFIG_CAPABILITY
    }

    protected f() {
        AnonymousClass1 anonymousClass1 = null;
        this.f31125b = new C0378f(this, anonymousClass1);
        this.f31127d = new a(this, anonymousClass1);
    }

    public g a() {
        return this.f31124a;
    }

    public String b() {
        return this.f31129f;
    }

    public String c() {
        return this.f31130g;
    }

    public boolean d() {
        return this.f31139p;
    }

    public com.haier.uhome.usdk.base.utils.f.a e() {
        return this.f31133j;
    }

    public com.haier.uhome.usdk.base.api.h f() {
        com.haier.uhome.usdk.base.utils.f.a aVar = this.f31133j;
        if (aVar != null) {
            return aVar.a();
        }
        e3.a.h("getDeviceType fail typeInfo is null", new Object[0]);
        return null;
    }

    public int g() {
        com.haier.uhome.usdk.base.utils.f.a aVar = this.f31133j;
        if (aVar != null) {
            return aVar.b();
        }
        e3.a.h("getMiddleType fail typeInfo is null", new Object[0]);
        return 0;
    }

    public String h() {
        com.haier.uhome.usdk.base.utils.f.a aVar = this.f31133j;
        if (aVar != null) {
            return aVar.c();
        }
        e3.a.h("getSpecialId fail typeInfo is null", new Object[0]);
        return null;
    }

    public String i() {
        return this.f31131h;
    }

    public boolean j() {
        return this.f31132i;
    }

    public long k() {
        return this.f31135l;
    }

    public long l() {
        return this.f31136m;
    }

    public boolean m() {
        return this.f31137n;
    }

    public int n() {
        return this.f31138o;
    }

    public int o() {
        return this.f31140q;
    }

    public C0378f p() {
        return this.f31125b;
    }

    public c q() {
        return this.f31126c;
    }

    public a r() {
        return this.f31127d;
    }

    public b s() {
        return this.f31128e;
    }

    public String toString() {
        return "DeviceInfo{devId=" + this.f31129f + ", uplusId=" + this.f31130g + ", productCode=" + this.f31131h + ", supportNetworkQuality=" + this.f31132i + ", typeInfo=" + this.f31133j + ", devProtocolType=" + this.f31134k + ", bindTimestamp=" + this.f31136m + ", isAuxConfigCapability=" + this.f31140q + ", updatable=" + this.f31137n + ", localInfo=" + this.f31125b + ", cloudInfo=" + this.f31126c + ", bleInfo=" + this.f31127d + ", bleMeshInfo=" + this.f31128e + '}';
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        switch (str) {
            case "psk0":
                return 4;
            case "0.5.0":
            case "1.1.0":
                return 2;
            case "1.0.0":
                return 1;
            case "cert0":
                return 3;
            default:
                return 0;
        }
    }

    public void a(String str) {
        this.f31129f = str;
    }

    public void b(String str) {
        String str2 = this.f31130g;
        if (TextUtils.isEmpty(str)) {
            e3.a.e("set typeId to null so return", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || !str2.equals(str)) {
            this.f31130g = str;
            a(com.haier.uhome.usdk.base.utils.f.a(str));
            this.f31124a.a(h.UPLUS_ID, str2, str);
        }
    }

    public void d(String str) {
        this.f31131h = str;
    }

    public void a(boolean z7) {
        this.f31139p = z7;
    }

    static com.haier.uhome.usdk.base.api.d a(q qVar) {
        if (qVar == null) {
            e3.a.v("getProtocolType, protocol is null so ret DEV_PROT_EPP", new Object[0]);
            return com.haier.uhome.usdk.base.api.d.DEV_PROT_EPP;
        }
        int i7 = AnonymousClass1.f31141a[qVar.ordinal()];
        if (i7 == 1 || i7 == 2) {
            return com.haier.uhome.usdk.base.api.d.DEV_PROT_STD;
        }
        if (i7 != 3 && i7 != 4) {
            return com.haier.uhome.usdk.base.api.d.DEV_PROT_EPP;
        }
        return com.haier.uhome.usdk.base.api.d.DEV_PROT_BT_EPP;
    }

    public void c(boolean z7) {
        this.f31137n = z7;
    }

    public void b(boolean z7) {
        this.f31132i = z7;
    }

    public void a(com.haier.uhome.usdk.base.utils.f.a aVar) {
        this.f31133j = aVar;
    }

    public void b(long j7) {
        if (j7 > this.f31136m) {
            this.f31136m = j7;
        }
    }

    public void a(long j7) {
        this.f31135l = j7;
    }

    public void a(int i7) {
        this.f31138o = i7;
    }

    public void b(int i7) {
        int i8 = this.f31140q;
        if (i8 == i7) {
            return;
        }
        this.f31140q = i7;
        this.f31124a.a(h.AUX_CONFIG_CAPABILITY, Integer.valueOf(i8), Integer.valueOf(i7));
    }
}
