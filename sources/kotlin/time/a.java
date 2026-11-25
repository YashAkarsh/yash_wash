package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public abstract class a implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final g f35446b;

    /* JADX INFO: renamed from: kotlin.time.a$a, reason: collision with other inner class name */
    private static final class C0442a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f35447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final a f35448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f35449c;

        public /* synthetic */ C0442a(double d8, a aVar, long j7, w wVar) {
            this(d8, aVar, j7);
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
            return d.c0(f.l0(this.f35448b.c() - this.f35447a, this.f35448b.b()), this.f35449c);
        }

        @Override // kotlin.time.q
        public boolean d() {
            return q.a.a(this);
        }

        @Override // kotlin.time.q
        @a7.d
        public q e(long j7) {
            return new C0442a(this.f35447a, this.f35448b, d.d0(this.f35449c, j7), null);
        }

        private C0442a(double d8, a aVar, long j7) {
            this.f35447a = d8;
            this.f35448b = aVar;
            this.f35449c = j7;
        }
    }

    public a(@a7.d g unit) {
        l0.p(unit, "unit");
        this.f35446b = unit;
    }

    @Override // kotlin.time.r
    @a7.d
    public q a() {
        return new C0442a(c(), this, d.f35456b.W(), null);
    }

    @a7.d
    protected final g b() {
        return this.f35446b;
    }

    protected abstract double c();
}
