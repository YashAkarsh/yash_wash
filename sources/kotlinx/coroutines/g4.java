package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class g4 {
    @a7.e
    public static final Object a(@a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        Object objH;
        kotlin.coroutines.g gVarD = dVar.d();
        s2.z(gVarD);
        kotlin.coroutines.d dVarD = kotlin.coroutines.intrinsics.c.d(dVar);
        kotlinx.coroutines.internal.l lVar = dVarD instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) dVarD : null;
        if (lVar == null) {
            objH = kotlin.l2.f34958a;
        } else {
            if (lVar.f36994d.Y0(gVarD)) {
                lVar.n(gVarD, kotlin.l2.f34958a);
            } else {
                f4 f4Var = new f4();
                kotlin.coroutines.g gVarPlus = gVarD.plus(f4Var);
                kotlin.l2 l2Var = kotlin.l2.f34958a;
                lVar.n(gVarPlus, l2Var);
                objH = (!f4Var.f36002a || kotlinx.coroutines.internal.m.h(lVar)) ? kotlin.coroutines.intrinsics.d.h() : l2Var;
            }
            objH = kotlin.coroutines.intrinsics.d.h();
        }
        if (objH == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objH == kotlin.coroutines.intrinsics.d.h() ? objH : kotlin.l2.f34958a;
    }
}
