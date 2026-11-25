package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
@d2
@h1
public interface l0<S> extends t3<S> {

    public static final class a {
        public static <S, R> R a(@a7.d l0<S> l0Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) t3.a.a(l0Var, r7, pVar);
        }

        @a7.e
        public static <S, E extends kotlin.coroutines.g.b> E b(@a7.d l0<S> l0Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) t3.a.b(l0Var, cVar);
        }

        @a7.d
        public static <S> kotlin.coroutines.g c(@a7.d l0<S> l0Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return t3.a.c(l0Var, cVar);
        }

        @a7.d
        public static <S> kotlin.coroutines.g d(@a7.d l0<S> l0Var, @a7.d kotlin.coroutines.g gVar) {
            return t3.a.d(l0Var, gVar);
        }
    }

    @a7.d
    l0<S> r0();

    @a7.d
    kotlin.coroutines.g v(@a7.d kotlin.coroutines.g.b bVar);
}
