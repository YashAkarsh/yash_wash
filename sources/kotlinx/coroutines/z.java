package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface z<T> extends d1<T> {

    public static final class a {
        public static <T, R> R b(@a7.d z<T> zVar, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) d1.a.b(zVar, r7, pVar);
        }

        @a7.e
        public static <T, E extends kotlin.coroutines.g.b> E c(@a7.d z<T> zVar, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) d1.a.c(zVar, cVar);
        }

        @a7.d
        public static <T> kotlin.coroutines.g d(@a7.d z<T> zVar, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return d1.a.d(zVar, cVar);
        }

        @a7.d
        public static <T> kotlin.coroutines.g e(@a7.d z<T> zVar, @a7.d kotlin.coroutines.g gVar) {
            return d1.a.e(zVar, gVar);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> o2 f(@a7.d z<T> zVar, @a7.d o2 o2Var) {
            return d1.a.f(zVar, o2Var);
        }
    }

    boolean G0(T t7);

    boolean f(@a7.d Throwable th);
}
