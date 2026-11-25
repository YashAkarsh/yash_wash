package kotlinx.coroutines.channels;

import kotlin.l2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w2;
import kotlinx.coroutines.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @a7.d
    @f3
    public static final <E> m0<E> a(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d x0 x0Var, @a7.e i5.l<? super Throwable, l2> lVar, @a7.d i5.p<? super f<E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        kotlin.coroutines.g gVarE = kotlinx.coroutines.n0.e(v0Var, gVar);
        n nVarD = q.d(i7, null, null, 6, null);
        d b0Var = x0Var.d() ? new b0(gVarE, nVarD, pVar) : new d(gVarE, nVarD, true);
        if (lVar != null) {
            ((w2) b0Var).g0(lVar);
        }
        ((kotlinx.coroutines.a) b0Var).E1(x0Var, b0Var, pVar);
        return (m0<E>) b0Var;
    }

    public static /* synthetic */ m0 b(v0 v0Var, kotlin.coroutines.g gVar, int i7, x0 x0Var, i5.l lVar, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        kotlin.coroutines.g gVar2 = gVar;
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        int i9 = i7;
        if ((i8 & 4) != 0) {
            x0Var = x0.DEFAULT;
        }
        x0 x0Var2 = x0Var;
        if ((i8 & 8) != 0) {
            lVar = null;
        }
        return a(v0Var, gVar2, i9, x0Var2, lVar, pVar);
    }
}
