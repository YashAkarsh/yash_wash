package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public interface o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f36535a = a.f36536a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f36536a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private static final o0 f36537b = new q0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        private static final o0 f36538c = new r0();

        private a() {
        }

        public static /* synthetic */ o0 b(a aVar, long j7, long j8, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                j7 = 0;
            }
            if ((i7 & 2) != 0) {
                j8 = Long.MAX_VALUE;
            }
            return aVar.a(j7, j8);
        }

        @a7.d
        public final o0 a(long j7, long j8) {
            return new s0(j7, j8);
        }

        @a7.d
        public final o0 c() {
            return f36537b;
        }

        @a7.d
        public final o0 d() {
            return f36538c;
        }
    }

    @a7.d
    i<m0> a(@a7.d t0<Integer> t0Var);
}
