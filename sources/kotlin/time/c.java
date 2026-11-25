package kotlin.time;

import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
@k
final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final q f35454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35455b;

    public /* synthetic */ c(q qVar, long j7, w wVar) {
        this(qVar, j7);
    }

    @Override // kotlin.time.q
    public boolean a() {
        return q.a.b(this);
    }

    @Override // kotlin.time.q
    @a7.d
    public q b(long j7) {
        return q.a.c(this, j7);
    }

    @Override // kotlin.time.q
    public long c() {
        return d.c0(this.f35454a.c(), this.f35455b);
    }

    @Override // kotlin.time.q
    public boolean d() {
        return q.a.a(this);
    }

    @Override // kotlin.time.q
    @a7.d
    public q e(long j7) {
        return new c(this.f35454a, d.d0(this.f35455b, j7), null);
    }

    public final long f() {
        return this.f35455b;
    }

    @a7.d
    public final q g() {
        return this.f35454a;
    }

    private c(q qVar, long j7) {
        this.f35454a = qVar;
        this.f35455b = j7;
    }
}
