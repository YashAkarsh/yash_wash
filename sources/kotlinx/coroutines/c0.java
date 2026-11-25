package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public interface c0 extends o2 {

    public static final class a {
        public static <R> R b(@a7.d c0 c0Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) o2.a.d(c0Var, r7, pVar);
        }

        @a7.e
        public static <E extends kotlin.coroutines.g.b> E c(@a7.d c0 c0Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) o2.a.e(c0Var, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g d(@a7.d c0 c0Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return o2.a.g(c0Var, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g e(@a7.d c0 c0Var, @a7.d kotlin.coroutines.g gVar) {
            return o2.a.h(c0Var, gVar);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static o2 f(@a7.d c0 c0Var, @a7.d o2 o2Var) {
            return o2.a.i(c0Var, o2Var);
        }
    }

    boolean f(@a7.d Throwable th);

    boolean q();
}
