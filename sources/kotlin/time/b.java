package kotlin.time;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public abstract class b implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final g f35450b;

    private static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f35451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final b f35452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f35453c;

        public /* synthetic */ a(long j7, b bVar, long j8, w wVar) {
            this(j7, bVar, j8);
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
            return d.c0(f.n0(this.f35452b.c() - this.f35451a, this.f35452b.b()), this.f35453c);
        }

        @Override // kotlin.time.q
        public boolean d() {
            return q.a.a(this);
        }

        @Override // kotlin.time.q
        @a7.d
        public q e(long j7) {
            return new a(this.f35451a, this.f35452b, d.d0(this.f35453c, j7), null);
        }

        private a(long j7, b bVar, long j8) {
            this.f35451a = j7;
            this.f35452b = bVar;
            this.f35453c = j8;
        }
    }

    public b(@a7.d g unit) {
        l0.p(unit, "unit");
        this.f35450b = unit;
    }

    @Override // kotlin.time.r
    @a7.d
    public q a() {
        return new a(c(), this, d.f35456b.W(), null);
    }

    @a7.d
    protected final g b() {
        return this.f35450b;
    }

    protected abstract long c();
}
