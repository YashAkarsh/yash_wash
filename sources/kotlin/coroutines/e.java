package kotlin.coroutines;

import i5.p;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public interface e extends g.b {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @a7.d
    public static final b f34677q0 = b.f34678a;

    public static final class a {
        public static <R> R a(@a7.d e eVar, R r7, @a7.d p<? super R, ? super g.b, ? extends R> operation) {
            l0.p(operation, "operation");
            return (R) g.b.a.a(eVar, r7, operation);
        }

        @a7.e
        public static <E extends g.b> E b(@a7.d e eVar, @a7.d g.c<E> key) {
            l0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                if (e.f34677q0 != key) {
                    return null;
                }
                l0.n(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e8 = (E) bVar.b(eVar);
            if (e8 instanceof g.b) {
                return e8;
            }
            return null;
        }

        @a7.d
        public static g c(@a7.d e eVar, @a7.d g.c<?> key) {
            l0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return e.f34677q0 == key ? i.f34682a : eVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : i.f34682a;
        }

        @a7.d
        public static g d(@a7.d e eVar, @a7.d g context) {
            l0.p(context, "context");
            return g.b.a.d(eVar, context);
        }

        public static void e(@a7.d e eVar, @a7.d d<?> continuation) {
            l0.p(continuation, "continuation");
        }
    }

    public static final class b implements g.c<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f34678a = new b();

        private b() {
        }
    }

    void g(@a7.d d<?> dVar);

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    <E extends g.b> E get(@a7.d g.c<E> cVar);

    @a7.d
    <T> d<T> m(@a7.d d<? super T> dVar);

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    g minusKey(@a7.d g.c<?> cVar);
}
