package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.k(level = kotlin.m.ERROR, message = "This is internal API and may be removed in the future releases")
@j2
public interface y extends o2 {

    public static final class a {
        public static <R> R b(@a7.d y yVar, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) o2.a.d(yVar, r7, pVar);
        }

        @a7.e
        public static <E extends kotlin.coroutines.g.b> E c(@a7.d y yVar, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) o2.a.e(yVar, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g d(@a7.d y yVar, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return o2.a.g(yVar, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g e(@a7.d y yVar, @a7.d kotlin.coroutines.g gVar) {
            return o2.a.h(yVar, gVar);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static o2 f(@a7.d y yVar, @a7.d o2 o2Var) {
            return o2.a.i(yVar, o2Var);
        }
    }

    @j2
    void l0(@a7.d g3 g3Var);
}
