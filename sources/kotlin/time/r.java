package kotlin.time;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f35481a = a.f35482a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f35482a = new a();

        private a() {
        }
    }

    public static final class b implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final b f35483b = new b();

        @h5.f
        @g1(version = "1.7")
        @k
        public static final class a implements q {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f35484a;

            private /* synthetic */ a(long j7) {
                this.f35484a = j7;
            }

            public static final /* synthetic */ a f(long j7) {
                return new a(j7);
            }

            public static long g(long j7) {
                return j7;
            }

            public static long h(long j7) {
                return o.f35478b.c(j7);
            }

            public static boolean i(long j7, Object obj) {
                return (obj instanceof a) && j7 == ((a) obj).s();
            }

            public static final boolean j(long j7, long j8) {
                return j7 == j8;
            }

            public static boolean k(long j7) {
                return d.a0(h(j7));
            }

            public static boolean l(long j7) {
                return !d.a0(h(j7));
            }

            public static int m(long j7) {
                return (int) (j7 ^ (j7 >>> 32));
            }

            public static long o(long j7, long j8) {
                return o.f35478b.b(j7, d.t0(j8));
            }

            public static long q(long j7, long j8) {
                return o.f35478b.b(j7, j8);
            }

            public static String r(long j7) {
                return "ValueTimeMark(reading=" + j7 + ')';
            }

            @Override // kotlin.time.q
            public boolean a() {
                return l(this.f35484a);
            }

            @Override // kotlin.time.q
            public /* bridge */ /* synthetic */ q b(long j7) {
                return f(n(j7));
            }

            @Override // kotlin.time.q
            public long c() {
                return h(this.f35484a);
            }

            @Override // kotlin.time.q
            public boolean d() {
                return k(this.f35484a);
            }

            @Override // kotlin.time.q
            public /* bridge */ /* synthetic */ q e(long j7) {
                return f(p(j7));
            }

            public boolean equals(Object obj) {
                return i(this.f35484a, obj);
            }

            public int hashCode() {
                return m(this.f35484a);
            }

            public long n(long j7) {
                return o(this.f35484a, j7);
            }

            public long p(long j7) {
                return q(this.f35484a, j7);
            }

            public final /* synthetic */ long s() {
                return this.f35484a;
            }

            public String toString() {
                return r(this.f35484a);
            }
        }

        private b() {
        }

        @Override // kotlin.time.r
        public /* bridge */ /* synthetic */ q a() {
            return a.f(b());
        }

        public long b() {
            return o.f35478b.d();
        }

        @a7.d
        public String toString() {
            return o.f35478b.toString();
        }
    }

    @a7.d
    q a();
}
