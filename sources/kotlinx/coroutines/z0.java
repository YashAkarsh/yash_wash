package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final String f37387a = "kotlinx.coroutines.debug";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final String f37388b = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final String f37389c = "auto";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final String f37390d = "on";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final String f37391e = "off";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f37392f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f37393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f37394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private static final AtomicLong f37395i;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (r0.equals(kotlinx.coroutines.z0.f37390d) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.t0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L63
            int r3 = r0.hashCode()
            if (r3 == 0) goto L39
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L30
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L43
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L63
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L63
        L30:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
            goto L41
        L39:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L43
        L41:
            r0 = r1
            goto L64
        L43:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L63:
            r0 = r2
        L64:
            kotlinx.coroutines.z0.f37393g = r0
            if (r0 == 0) goto L71
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.t0.e(r0, r1)
            if (r0 == 0) goto L71
            goto L72
        L71:
            r1 = r2
        L72:
            kotlinx.coroutines.z0.f37394h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.z0.f37395i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.z0.<clinit>():void");
    }

    @kotlin.internal.f
    private static final void a(i5.a<Boolean> aVar) {
    }

    public static final boolean b() {
        return f37392f;
    }

    @a7.d
    public static final AtomicLong c() {
        return f37395i;
    }

    public static final boolean d() {
        return f37393g;
    }

    public static final boolean e() {
        return f37394h;
    }

    public static final void f() {
        f37395i.set(0L);
    }
}
