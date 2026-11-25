package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37076a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37077b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37078c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37079d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37080e = -1;

    public static final <T> void a(@a7.d k1<? super T> k1Var, int i7) {
        kotlin.coroutines.d<? super T> dVarF = k1Var.f();
        boolean z7 = i7 == 4;
        if (z7 || !(dVarF instanceof kotlinx.coroutines.internal.l) || c(i7) != c(k1Var.f37063c)) {
            e(k1Var, dVarF, z7);
            return;
        }
        o0 o0Var = ((kotlinx.coroutines.internal.l) dVarF).f36994d;
        kotlin.coroutines.g gVarD = dVarF.d();
        if (o0Var.Y0(gVarD)) {
            o0Var.T0(gVarD, k1Var);
        } else {
            f(k1Var);
        }
    }

    @kotlin.a1
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i7) {
        return i7 == 1 || i7 == 2;
    }

    public static final boolean d(int i7) {
        return i7 == 2;
    }

    public static final <T> void e(@a7.d k1<? super T> k1Var, @a7.d kotlin.coroutines.d<? super T> dVar, boolean z7) {
        Object objH;
        Object objK = k1Var.k();
        Throwable thG = k1Var.g(objK);
        if (thG != null) {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objH = kotlin.e1.a(thG);
        } else {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objH = k1Var.h(objK);
        }
        Object objB = kotlin.d1.b(objH);
        if (!z7) {
            dVar.w(objB);
            return;
        }
        kotlinx.coroutines.internal.l lVar = (kotlinx.coroutines.internal.l) dVar;
        kotlin.coroutines.d<T> dVar2 = lVar.f36995e;
        Object obj = lVar.f36997g;
        kotlin.coroutines.g gVarD = dVar2.d();
        Object objC = kotlinx.coroutines.internal.w0.c(gVarD, obj);
        d4<?> d4VarG = objC != kotlinx.coroutines.internal.w0.f37028a ? n0.g(dVar2, gVarD, objC) : null;
        try {
            lVar.f36995e.w(objB);
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        } finally {
            if (d4VarG == null || d4VarG.G1()) {
                kotlinx.coroutines.internal.w0.a(gVarD, objC);
            }
        }
    }

    private static final void f(k1<?> k1Var) {
        u1 u1VarB = v3.f37337a.b();
        if (u1VarB.N1()) {
            u1VarB.s1(k1Var);
            return;
        }
        u1VarB.z1(true);
        try {
            e(k1Var, k1Var.f(), true);
            do {
            } while (u1VarB.X1());
        } catch (Throwable th) {
            try {
                k1Var.j(th, null);
            } finally {
                u1VarB.e1(true);
            }
        }
    }

    public static final void g(@a7.d kotlin.coroutines.d<?> dVar, @a7.d Throwable th) {
        kotlin.d1.a aVar = kotlin.d1.f34719b;
        dVar.w(kotlin.d1.b(kotlin.e1.a(th)));
    }

    public static final void h(@a7.d k1<?> k1Var, @a7.d u1 u1Var, @a7.d i5.a<kotlin.l2> aVar) {
        u1Var.z1(true);
        try {
            aVar.invoke();
            do {
            } while (u1Var.X1());
            kotlin.jvm.internal.i0.d(1);
        } catch (Throwable th) {
            try {
                k1Var.j(th, null);
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                u1Var.e1(true);
                kotlin.jvm.internal.i0.c(1);
            }
        }
    }
}
