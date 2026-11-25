package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface d1<T> extends o2 {

    public static final class a {
        public static <T, R> R b(@a7.d d1<? extends T> d1Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) o2.a.d(d1Var, r7, pVar);
        }

        @a7.e
        public static <T, E extends kotlin.coroutines.g.b> E c(@a7.d d1<? extends T> d1Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) o2.a.e(d1Var, cVar);
        }

        @a7.d
        public static <T> kotlin.coroutines.g d(@a7.d d1<? extends T> d1Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return o2.a.g(d1Var, cVar);
        }

        @a7.d
        public static <T> kotlin.coroutines.g e(@a7.d d1<? extends T> d1Var, @a7.d kotlin.coroutines.g gVar) {
            return o2.a.h(d1Var, gVar);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> o2 f(@a7.d d1<? extends T> d1Var, @a7.d o2 o2Var) {
            return o2.a.i(d1Var, o2Var);
        }
    }

    @a7.d
    kotlinx.coroutines.selects.d<T> C();

    @d2
    @a7.e
    Throwable F();

    @a7.e
    Object h0(@a7.d kotlin.coroutines.d<? super T> dVar);

    @d2
    T u();
}
