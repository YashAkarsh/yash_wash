package kotlinx.coroutines.selects;

import i5.l;
import kotlin.jvm.internal.i0;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    @a7.e
    public static final <R> Object a(@a7.d l<? super a<? super R>, l2> lVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        j jVar = new j(dVar);
        try {
            lVar.z(jVar);
        } catch (Throwable th) {
            jVar.c(th);
        }
        Object objD = jVar.d();
        if (objD == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objD;
    }

    private static final <R> Object b(l<? super a<? super R>, l2> lVar, kotlin.coroutines.d<? super R> dVar) {
        i0.e(0);
        j jVar = new j(dVar);
        try {
            lVar.z(jVar);
        } catch (Throwable th) {
            jVar.c(th);
        }
        Object objD = jVar.d();
        if (objD == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        i0.e(1);
        return objD;
    }
}
