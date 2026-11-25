package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 {
    @d2
    public static /* synthetic */ void a() {
    }

    @a7.d
    public static final Executor b(@a7.d o0 o0Var) {
        a2 a2Var = o0Var instanceof a2 ? (a2) o0Var : null;
        Executor executorE1 = a2Var != null ? a2Var.e1() : null;
        return executorE1 == null ? new m1(o0Var) : executorE1;
    }

    @a7.d
    @h5.h(name = androidx.constraintlayout.core.motion.utils.w.h.f3145c)
    public static final o0 c(@a7.d Executor executor) {
        m1 m1Var = executor instanceof m1 ? (m1) executor : null;
        o0 o0Var = m1Var != null ? m1Var.f37084a : null;
        return o0Var == null ? new b2(executor) : o0Var;
    }

    @a7.d
    @h5.h(name = androidx.constraintlayout.core.motion.utils.w.h.f3145c)
    public static final a2 d(@a7.d ExecutorService executorService) {
        return new b2(executorService);
    }
}
