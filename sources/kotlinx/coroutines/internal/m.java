package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.l2;
import kotlinx.coroutines.d4;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.u1;
import kotlinx.coroutines.v3;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final r0 f36999a = new r0("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final r0 f37000b = new r0("REUSABLE_CLAIMED");

    private static final boolean b(l<?> lVar, Object obj, int i7, boolean z7, i5.a<l2> aVar) {
        u1 u1VarB = v3.f37337a.b();
        if (z7 && u1VarB.R1()) {
            return false;
        }
        if (u1VarB.N1()) {
            lVar.f36996f = obj;
            lVar.f37063c = i7;
            u1VarB.s1(lVar);
            return true;
        }
        u1VarB.z1(true);
        try {
            aVar.invoke();
            do {
            } while (u1VarB.X1());
            kotlin.jvm.internal.i0.d(1);
        } catch (Throwable th) {
            try {
                lVar.j(th, null);
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                u1VarB.e1(true);
                kotlin.jvm.internal.i0.c(1);
            }
        }
        return false;
    }

    static /* synthetic */ boolean c(l lVar, Object obj, int i7, boolean z7, i5.a aVar, int i8, Object obj2) {
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        u1 u1VarB = v3.f37337a.b();
        if (z7 && u1VarB.R1()) {
            return false;
        }
        if (u1VarB.N1()) {
            lVar.f36996f = obj;
            lVar.f37063c = i7;
            u1VarB.s1(lVar);
            return true;
        }
        u1VarB.z1(true);
        try {
            aVar.invoke();
            do {
            } while (u1VarB.X1());
            kotlin.jvm.internal.i0.d(1);
        } catch (Throwable th) {
            try {
                lVar.j(th, null);
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                u1VarB.e1(true);
                kotlin.jvm.internal.i0.c(1);
            }
        }
        return false;
    }

    public static /* synthetic */ void d() {
    }

    private static /* synthetic */ void e() {
    }

    @j2
    public static final <T> void f(@a7.d kotlin.coroutines.d<? super T> dVar, @a7.d Object obj, @a7.e i5.l<? super Throwable, l2> lVar) {
        boolean z7;
        if (!(dVar instanceof l)) {
            dVar.w(obj);
            return;
        }
        l lVar2 = (l) dVar;
        Object objB = kotlinx.coroutines.k0.b(obj, lVar);
        if (lVar2.f36994d.Y0(lVar2.d())) {
            lVar2.f36996f = objB;
            lVar2.f37063c = 1;
            lVar2.f36994d.T0(lVar2.d(), lVar2);
            return;
        }
        u1 u1VarB = v3.f37337a.b();
        if (u1VarB.N1()) {
            lVar2.f36996f = objB;
            lVar2.f37063c = 1;
            u1VarB.s1(lVar2);
            return;
        }
        u1VarB.z1(true);
        try {
            o2 o2Var = (o2) lVar2.d().get(o2.f37103s0);
            if (o2Var == null || o2Var.b()) {
                z7 = false;
            } else {
                CancellationException cancellationExceptionK = o2Var.K();
                lVar2.c(objB, cancellationExceptionK);
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                lVar2.w(kotlin.d1.b(kotlin.e1.a(cancellationExceptionK)));
                z7 = true;
            }
            if (!z7) {
                kotlin.coroutines.d<T> dVar2 = lVar2.f36995e;
                Object obj2 = lVar2.f36997g;
                kotlin.coroutines.g gVarD = dVar2.d();
                Object objC = w0.c(gVarD, obj2);
                d4<?> d4VarG = objC != w0.f37028a ? kotlinx.coroutines.n0.g(dVar2, gVarD, objC) : null;
                try {
                    lVar2.f36995e.w(obj);
                    l2 l2Var = l2.f34958a;
                    if (d4VarG == null || d4VarG.G1()) {
                        w0.a(gVarD, objC);
                    }
                } catch (Throwable th) {
                    if (d4VarG == null || d4VarG.G1()) {
                        w0.a(gVarD, objC);
                    }
                    throw th;
                }
            }
            while (u1VarB.X1()) {
            }
        } catch (Throwable th2) {
            try {
                lVar2.j(th2, null);
            } finally {
                u1VarB.e1(true);
            }
        }
    }

    public static /* synthetic */ void g(kotlin.coroutines.d dVar, Object obj, i5.l lVar, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            lVar = null;
        }
        f(dVar, obj, lVar);
    }

    public static final boolean h(@a7.d l<? super l2> lVar) {
        l2 l2Var = l2.f34958a;
        u1 u1VarB = v3.f37337a.b();
        if (u1VarB.R1()) {
            return false;
        }
        if (u1VarB.N1()) {
            lVar.f36996f = l2Var;
            lVar.f37063c = 1;
            u1VarB.s1(lVar);
            return true;
        }
        u1VarB.z1(true);
        try {
            lVar.run();
            do {
            } while (u1VarB.X1());
        } catch (Throwable th) {
            try {
                lVar.j(th, null);
            } finally {
                u1VarB.e1(true);
            }
        }
        return false;
    }
}
