package kotlinx.coroutines.channels;

import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
final class c0<E> extends k<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<l2> f35581d;

    public c0(@a7.d kotlin.coroutines.g gVar, @a7.d i<E> iVar, @a7.d i5.p<? super g0<? super E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        super(gVar, iVar, false);
        this.f35581d = kotlin.coroutines.intrinsics.c.c(pVar, this, this);
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.i
    @a7.d
    public i0<E> G() {
        i0<E> i0VarG = F1().G();
        start();
        return i0VarG;
    }

    @Override // kotlinx.coroutines.w2
    protected void j1() throws Throwable {
        r5.a.e(this.f35581d, this);
    }
}
