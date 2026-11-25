package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface o2 extends kotlin.coroutines.g.b {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @a7.d
    public static final b f37103s0 = b.f37104a;

    public static final class a {
        public static /* synthetic */ void b(o2 o2Var, CancellationException cancellationException, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                cancellationException = null;
            }
            o2Var.c(cancellationException);
        }

        public static /* synthetic */ boolean c(o2 o2Var, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return o2Var.e(th);
        }

        public static <R> R d(@a7.d o2 o2Var, R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
            return (R) kotlin.coroutines.g.b.a.a(o2Var, r7, pVar);
        }

        @a7.e
        public static <E extends kotlin.coroutines.g.b> E e(@a7.d o2 o2Var, @a7.d kotlin.coroutines.g.c<E> cVar) {
            return (E) kotlin.coroutines.g.b.a.b(o2Var, cVar);
        }

        public static /* synthetic */ q1 f(o2 o2Var, boolean z7, boolean z8, i5.l lVar, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i7 & 1) != 0) {
                z7 = false;
            }
            if ((i7 & 2) != 0) {
                z8 = true;
            }
            return o2Var.J0(z7, z8, lVar);
        }

        @a7.d
        public static kotlin.coroutines.g g(@a7.d o2 o2Var, @a7.d kotlin.coroutines.g.c<?> cVar) {
            return kotlin.coroutines.g.b.a.c(o2Var, cVar);
        }

        @a7.d
        public static kotlin.coroutines.g h(@a7.d o2 o2Var, @a7.d kotlin.coroutines.g gVar) {
            return kotlin.coroutines.g.b.a.d(o2Var, gVar);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static o2 i(@a7.d o2 o2Var, @a7.d o2 o2Var2) {
            return o2Var2;
        }
    }

    public static final class b implements kotlin.coroutines.g.c<o2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f37104a = new b();

        private b() {
        }
    }

    @a7.d
    kotlin.sequences.m<o2> E();

    @a7.e
    Object H(@a7.d kotlin.coroutines.d<? super kotlin.l2> dVar);

    @a7.d
    @j2
    q1 J0(boolean z7, boolean z8, @a7.d i5.l<? super Throwable, kotlin.l2> lVar);

    @a7.d
    @j2
    CancellationException K();

    @a7.d
    @j2
    w Q0(@a7.d y yVar);

    boolean b();

    void c(@a7.e CancellationException cancellationException);

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean e(Throwable th);

    @a7.d
    q1 g0(@a7.d i5.l<? super Throwable, kotlin.l2> lVar);

    boolean isCancelled();

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    o2 o0(@a7.d o2 o2Var);

    boolean r();

    boolean start();

    @a7.d
    kotlinx.coroutines.selects.c x0();
}
