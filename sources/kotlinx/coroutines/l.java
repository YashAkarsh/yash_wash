package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37073a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37074b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37075c = 2;

    @a7.d
    public static final <T> d1<T> a(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, @a7.d x0 x0Var, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) {
        kotlin.coroutines.g gVarE = n0.e(v0Var, gVar);
        e1 y2Var = x0Var.d() ? new y2(gVarE, pVar) : new e1(gVarE, true);
        ((a) y2Var).E1(x0Var, y2Var, pVar);
        return (d1<T>) y2Var;
    }

    public static /* synthetic */ d1 b(v0 v0Var, kotlin.coroutines.g gVar, x0 x0Var, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        if ((i7 & 2) != 0) {
            x0Var = x0.DEFAULT;
        }
        return j.a(v0Var, gVar, x0Var, pVar);
    }

    @a7.e
    public static final <T> Object c(@a7.d o0 o0Var, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return j.h(o0Var, pVar, dVar);
    }

    private static final <T> Object d(o0 o0Var, i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, kotlin.coroutines.d<? super T> dVar) throws Throwable {
        kotlin.jvm.internal.i0.e(0);
        Object objH = j.h(o0Var, pVar, dVar);
        kotlin.jvm.internal.i0.e(1);
        return objH;
    }

    @a7.d
    public static final o2 e(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, @a7.d x0 x0Var, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super kotlin.l2>, ? extends Object> pVar) {
        kotlin.coroutines.g gVarE = n0.e(v0Var, gVar);
        a z2Var = x0Var.d() ? new z2(gVarE, pVar) : new p3(gVarE, true);
        z2Var.E1(x0Var, z2Var, pVar);
        return z2Var;
    }

    public static /* synthetic */ o2 f(v0 v0Var, kotlin.coroutines.g gVar, x0 x0Var, i5.p pVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        if ((i7 & 2) != 0) {
            x0Var = x0.DEFAULT;
        }
        return j.d(v0Var, gVar, x0Var, pVar);
    }

    @a7.e
    public static final <T> Object g(@a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) throws Throwable {
        Object objG1;
        kotlin.coroutines.g gVarD = dVar.d();
        kotlin.coroutines.g gVarD2 = n0.d(gVarD, gVar);
        s2.z(gVarD2);
        if (gVarD2 == gVarD) {
            kotlinx.coroutines.internal.n0 n0Var = new kotlinx.coroutines.internal.n0(gVarD2, dVar);
            objG1 = r5.b.f(n0Var, n0Var, pVar);
        } else {
            kotlin.coroutines.e.b bVar = kotlin.coroutines.e.f34677q0;
            if (kotlin.jvm.internal.l0.g(gVarD2.get(bVar), gVarD.get(bVar))) {
                d4 d4Var = new d4(gVarD2, dVar);
                Object objC = kotlinx.coroutines.internal.w0.c(gVarD2, null);
                try {
                    Object objF = r5.b.f(d4Var, d4Var, pVar);
                    kotlinx.coroutines.internal.w0.a(gVarD2, objC);
                    objG1 = objF;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.w0.a(gVarD2, objC);
                    throw th;
                }
            } else {
                j1 j1Var = new j1(gVarD2, dVar);
                r5.a.f(pVar, j1Var, j1Var, null, 4, null);
                objG1 = j1Var.G1();
            }
        }
        if (objG1 == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objG1;
    }
}
