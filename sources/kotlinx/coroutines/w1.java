package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w1 extends u1 {
    @a7.d
    protected abstract Thread Z1();

    protected void a2(long j7, @a7.d v1.c cVar) {
        b1.f35517g.j2(j7, cVar);
    }

    protected final void b2() {
        kotlin.l2 l2Var;
        Thread threadZ1 = Z1();
        if (Thread.currentThread() != threadZ1) {
            b bVarB = c.b();
            if (bVarB == null) {
                l2Var = null;
            } else {
                bVarB.g(threadZ1);
                l2Var = kotlin.l2.f34958a;
            }
            if (l2Var == null) {
                LockSupport.unpark(threadZ1);
            }
        }
    }
}
