package okhttp3.internal.http2;

import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final String f37959e = ":status";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    public static final String f37960f = ":method";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    public static final String f37961g = ":path";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    public static final String f37962h = ":scheme";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    public static final String f37963i = ":authority";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f37968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f37969o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public final int f37970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public final p f37971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final p f37972c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        p.a aVar = p.f38508f;
        f37958d = aVar.l(":");
        f37964j = aVar.l(":status");
        f37965k = aVar.l(":method");
        f37966l = aVar.l(":path");
        f37967m = aVar.l(":scheme");
        f37968n = aVar.l(":authority");
    }

    public c(@a7.d p name, @a7.d p value) {
        l0.p(name, "name");
        l0.p(value, "value");
        this.f37971b = name;
        this.f37972c = value;
        this.f37970a = name.a0() + 32 + value.a0();
    }

    public static /* synthetic */ c d(c cVar, p pVar, p pVar2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            pVar = cVar.f37971b;
        }
        if ((i7 & 2) != 0) {
            pVar2 = cVar.f37972c;
        }
        return cVar.c(pVar, pVar2);
    }

    @a7.d
    public final p a() {
        return this.f37971b;
    }

    @a7.d
    public final p b() {
        return this.f37972c;
    }

    @a7.d
    public final c c(@a7.d p name, @a7.d p value) {
        l0.p(name, "name");
        l0.p(value, "value");
        return new c(name, value);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l0.g(this.f37971b, cVar.f37971b) && l0.g(this.f37972c, cVar.f37972c);
    }

    public int hashCode() {
        p pVar = this.f37971b;
        int iHashCode = (pVar != null ? pVar.hashCode() : 0) * 31;
        p pVar2 = this.f37972c;
        return iHashCode + (pVar2 != null ? pVar2.hashCode() : 0);
    }

    @a7.d
    public String toString() {
        return this.f37971b.l0() + ": " + this.f37972c.l0();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@a7.d String name, @a7.d String value) {
        l0.p(name, "name");
        l0.p(value, "value");
        p.a aVar = p.f38508f;
        this(aVar.l(name), aVar.l(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@a7.d p name, @a7.d String value) {
        this(name, p.f38508f.l(value));
        l0.p(name, "name");
        l0.p(value, "value");
    }
}
