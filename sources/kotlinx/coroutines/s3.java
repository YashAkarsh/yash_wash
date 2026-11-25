package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class s3 {
    @a7.d
    public static final c0 a(@a7.e o2 o2Var) {
        return new r3(o2Var);
    }

    public static /* synthetic */ c0 c(o2 o2Var, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            o2Var = null;
        }
        return a(o2Var);
    }

    public static /* synthetic */ o2 d(o2 o2Var, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            o2Var = null;
        }
        return a(o2Var);
    }

    @a7.e
    public static final <R> Object e(@a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        q3 q3Var = new q3(dVar.d(), dVar);
        Object objF = r5.b.f(q3Var, q3Var, pVar);
        if (objF == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objF;
    }
}
