package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z1;

/* JADX INFO: loaded from: classes2.dex */
class d<E> extends o<E> implements f<E> {
    public d(@a7.d kotlin.coroutines.g gVar, @a7.d n<E> nVar, boolean z7) {
        super(gVar, nVar, false, z7);
        R0((o2) gVar.get(o2.f37103s0));
    }

    @Override // kotlinx.coroutines.w2
    protected boolean O0(@a7.d Throwable th) {
        r0.b(d(), th);
        return true;
    }

    @Override // kotlinx.coroutines.w2
    protected void h1(@a7.e Throwable th) {
        n<E> nVarF1 = F1();
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = z1.a(kotlin.jvm.internal.l0.C(a1.a(this), " was cancelled"), th);
            }
        }
        nVarF1.c(cancellationExceptionA);
    }
}
