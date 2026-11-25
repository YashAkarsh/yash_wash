package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
final class h<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Thread f36927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private final u1 f36928d;

    public h(@a7.d kotlin.coroutines.g gVar, @a7.d Thread thread, @a7.e u1 u1Var) {
        super(gVar, true, true);
        this.f36927c = thread;
        this.f36928d = u1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T F1() throws Throwable {
        kotlin.l2 l2Var;
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            u1 u1Var = this.f36928d;
            if (u1Var != null) {
                u1.A1(u1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    u1 u1Var2 = this.f36928d;
                    long jW1 = u1Var2 == null ? Long.MAX_VALUE : u1Var2.W1();
                    if (r()) {
                        u1 u1Var3 = this.f36928d;
                        if (u1Var3 != null) {
                            u1.i1(u1Var3, false, 1, null);
                        }
                        b bVarB2 = c.b();
                        if (bVarB2 != null) {
                            bVarB2.h();
                        }
                        T t7 = (T) x2.o(N0());
                        e0 e0Var = t7 instanceof e0 ? (e0) t7 : null;
                        if (e0Var == null) {
                            return t7;
                        }
                        throw e0Var.f35988a;
                    }
                    b bVarB3 = c.b();
                    if (bVarB3 == null) {
                        l2Var = null;
                    } else {
                        bVarB3.c(this, jW1);
                        l2Var = kotlin.l2.f34958a;
                    }
                    if (l2Var == null) {
                        LockSupport.parkNanos(this, jW1);
                    }
                } catch (Throwable th) {
                    u1 u1Var4 = this.f36928d;
                    if (u1Var4 != null) {
                        u1.i1(u1Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            d0(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            b bVarB4 = c.b();
            if (bVarB4 != null) {
                bVarB4.h();
            }
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.w2
    protected boolean U0() {
        return true;
    }

    @Override // kotlinx.coroutines.w2
    protected void Z(@a7.e Object obj) {
        kotlin.l2 l2Var;
        if (kotlin.jvm.internal.l0.g(Thread.currentThread(), this.f36927c)) {
            return;
        }
        Thread thread = this.f36927c;
        b bVarB = c.b();
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
}
