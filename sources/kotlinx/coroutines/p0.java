package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface p0 extends kotlin.coroutines.g.b {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    @a7.d
    public static final b f37107r0 = b.f37108a;

    public static final class a {
        public static <R> R a(@a7.d p0 p0Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) kotlin.coroutines.g.b.a.a(p0Var, r7, pVar);
        }

        @a7.e
        public static <E extends kotlin.coroutines.g.b> E b(@a7.d p0 p0Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) kotlin.coroutines.g.b.a.b(p0Var, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g c(@a7.d p0 p0Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return kotlin.coroutines.g.b.a.c(p0Var, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g d(@a7.d p0 p0Var, @a7.d kotlin.coroutines.g gVar) {
            return kotlin.coroutines.g.b.a.d(p0Var, gVar);
        }
    }

    public static final class b implements kotlin.coroutines.g.c<p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f37108a = new b();

        private b() {
        }
    }

    void handleException(@a7.d kotlin.coroutines.g gVar, @a7.d Throwable th);
}
