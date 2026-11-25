package kotlin.time;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public final class o implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final o f35478b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f35479c = System.nanoTime();

    private o() {
    }

    private final long e() {
        return System.nanoTime() - f35479c;
    }

    @Override // kotlin.time.r
    public /* bridge */ /* synthetic */ q a() {
        return r.b.a.f(d());
    }

    public final long b(long j7, long j8) {
        return r.b.a.g(l.b(j7, j8));
    }

    public final long c(long j7) {
        return l.d(e(), j7);
    }

    public long d() {
        return r.b.a.g(e());
    }

    @a7.d
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
