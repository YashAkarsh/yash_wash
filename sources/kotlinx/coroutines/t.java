package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    @j2
    public static final void a(@a7.d q<?> qVar, @a7.d q1 q1Var) {
        qVar.i0(new r1(q1Var));
    }

    @a7.d
    public static final <T> r<T> b(@a7.d kotlin.coroutines.d<? super T> dVar) {
        if (!(dVar instanceof kotlinx.coroutines.internal.l)) {
            return new r<>(dVar, 1);
        }
        r<T> rVarM = ((kotlinx.coroutines.internal.l) dVar).m();
        if (rVarM == null || !rVarM.M()) {
            rVarM = null;
        }
        return rVarM == null ? new r<>(dVar, 2) : rVarM;
    }

    public static final void c(@a7.d q<?> qVar, @a7.d kotlinx.coroutines.internal.y yVar) {
        qVar.i0(new h3(yVar));
    }

    @a7.e
    public static final <T> Object d(@a7.d i5.l<? super q<? super T>, kotlin.l2> lVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        lVar.z(rVar);
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    private static final <T> Object e(i5.l<? super q<? super T>, kotlin.l2> lVar, kotlin.coroutines.d<? super T> dVar) {
        kotlin.jvm.internal.i0.e(0);
        r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        lVar.z(rVar);
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        kotlin.jvm.internal.i0.e(1);
        return objZ;
    }

    @a7.e
    public static final <T> Object f(@a7.d i5.l<? super q<? super T>, kotlin.l2> lVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        r rVarB = b(kotlin.coroutines.intrinsics.c.d(dVar));
        lVar.z(rVarB);
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    private static final <T> Object g(i5.l<? super q<? super T>, kotlin.l2> lVar, kotlin.coroutines.d<? super T> dVar) {
        kotlin.jvm.internal.i0.e(0);
        r rVarB = b(kotlin.coroutines.intrinsics.c.d(dVar));
        lVar.z(rVarB);
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        kotlin.jvm.internal.i0.e(1);
        return objZ;
    }
}
