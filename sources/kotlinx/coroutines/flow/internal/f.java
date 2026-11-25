package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.t1;
import kotlinx.coroutines.internal.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    @a7.d
    public static final <T> e<T> b(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar) {
        e<T> eVar = iVar instanceof e ? (e) iVar : null;
        return eVar == null ? new i(iVar, null, 0, null, 14, null) : eVar;
    }

    @a7.e
    public static final <T, V> Object c(@a7.d kotlin.coroutines.g gVar, V v7, @a7.d Object obj, @a7.d i5.p<? super V, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        Object objC = w0.c(gVar, obj);
        try {
            Object objA0 = ((i5.p) t1.q(pVar, 2)).a0(v7, new z(dVar, gVar));
            w0.a(gVar, objC);
            if (objA0 == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objA0;
        } catch (Throwable th) {
            w0.a(gVar, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object d(kotlin.coroutines.g gVar, Object obj, Object obj2, i5.p pVar, kotlin.coroutines.d dVar, int i7, Object obj3) {
        if ((i7 & 4) != 0) {
            obj2 = w0.b(gVar);
        }
        return c(gVar, obj, obj2, pVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.j<T> e(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.g gVar) {
        return jVar instanceof y ? true : jVar instanceof t ? jVar : new b0(jVar, gVar);
    }
}
