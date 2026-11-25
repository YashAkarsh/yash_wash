package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface t3<S> extends kotlin.coroutines.g.b {

    public static final class a {
        public static <S, R> R a(@a7.d t3<S> t3Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) kotlin.coroutines.g.b.a.a(t3Var, r7, pVar);
        }

        @a7.e
        public static <S, E extends kotlin.coroutines.g.b> E b(@a7.d t3<S> t3Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) kotlin.coroutines.g.b.a.b(t3Var, cVar);
        }

        @a7.d
        public static <S> kotlin.coroutines.g c(@a7.d t3<S> t3Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return kotlin.coroutines.g.b.a.c(t3Var, cVar);
        }

        @a7.d
        public static <S> kotlin.coroutines.g d(@a7.d t3<S> t3Var, @a7.d kotlin.coroutines.g gVar) {
            return kotlin.coroutines.g.b.a.d(t3Var, gVar);
        }
    }

    S L0(@a7.d kotlin.coroutines.g gVar);

    void v0(@a7.d kotlin.coroutines.g gVar, S s7);
}
