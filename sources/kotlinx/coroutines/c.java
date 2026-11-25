package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private static b f35532a;

    @kotlin.internal.f
    private static final long a() {
        b bVarB = b();
        Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.a());
        return lValueOf == null ? System.currentTimeMillis() : lValueOf.longValue();
    }

    @a7.e
    public static final b b() {
        return f35532a;
    }

    @kotlin.internal.f
    private static final long c() {
        b bVarB = b();
        Long lValueOf = bVarB == null ? null : Long.valueOf(bVarB.b());
        return lValueOf == null ? System.nanoTime() : lValueOf.longValue();
    }

    @kotlin.internal.f
    private static final void d(Object obj, long j7) {
        kotlin.l2 l2Var;
        b bVarB = b();
        if (bVarB == null) {
            l2Var = null;
        } else {
            bVarB.c(obj, j7);
            l2Var = kotlin.l2.f34958a;
        }
        if (l2Var == null) {
            LockSupport.parkNanos(obj, j7);
        }
    }

    @kotlin.internal.f
    private static final void e() {
        b bVarB = b();
        if (bVarB == null) {
            return;
        }
        bVarB.d();
    }

    public static final void f(@a7.e b bVar) {
        f35532a = bVar;
    }

    @kotlin.internal.f
    private static final void g() {
        b bVarB = b();
        if (bVarB == null) {
            return;
        }
        bVarB.e();
    }

    @kotlin.internal.f
    private static final void h() {
        b bVarB = b();
        if (bVarB == null) {
            return;
        }
        bVarB.f();
    }

    @kotlin.internal.f
    private static final void i(Thread thread) {
        kotlin.l2 l2Var;
        b bVarB = b();
        if (bVarB == null) {
            l2Var = null;
        } else {
            bVarB.g(thread);
            l2Var = kotlin.l2.f34958a;
        }
        if (l2Var == null) {
            LockSupport.unpark(thread);
        }
    }

    @kotlin.internal.f
    private static final void j() {
        b bVarB = b();
        if (bVarB == null) {
            return;
        }
        bVarB.h();
    }

    @kotlin.internal.f
    private static final Runnable k(Runnable runnable) {
        Runnable runnableI;
        b bVarB = b();
        return (bVarB == null || (runnableI = bVarB.i(runnable)) == null) ? runnable : runnableI;
    }
}
