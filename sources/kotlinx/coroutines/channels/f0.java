package kotlinx.coroutines.channels;

import kotlin.l2;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
final class f0<E> extends o<E> implements g0<E> {
    public f0(@a7.d kotlin.coroutines.g gVar, @a7.d n<E> nVar) {
        super(gVar, nVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    protected void C1(@a7.d Throwable th, boolean z7) {
        if (F1().e(th) || z7) {
            return;
        }
        r0.b(d(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public void D1(@a7.d l2 l2Var) {
        m0.a.a(F1(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.g0
    public /* bridge */ /* synthetic */ m0 a() {
        return a();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public boolean b() {
        return super.b();
    }
}
