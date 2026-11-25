package r5;

import a7.d;
import a7.e;
import i5.l;
import i5.p;
import kotlin.coroutines.g;
import kotlin.coroutines.jvm.internal.h;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.t1;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.internal.n0;
import kotlinx.coroutines.internal.w0;
import kotlinx.coroutines.x2;
import kotlinx.coroutines.z3;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final <T> void a(@d l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar, @d kotlin.coroutines.d<? super T> dVar) {
        kotlin.coroutines.d dVarA = h.a(dVar);
        try {
            g gVarD = dVar.d();
            Object objC = w0.c(gVarD, null);
            try {
                Object objZ = ((l) t1.q(lVar, 1)).z(dVarA);
                w0.a(gVarD, objC);
                if (objZ != kotlin.coroutines.intrinsics.d.h()) {
                    d1.a aVar = d1.f34719b;
                    dVarA.w(d1.b(objZ));
                }
            } catch (Throwable th) {
                w0.a(gVarD, objC);
                throw th;
            }
        } catch (Throwable th2) {
            d1.a aVar2 = d1.f34719b;
            dVarA.w(d1.b(e1.a(th2)));
        }
    }

    public static final <R, T> void b(@d p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, R r7, @d kotlin.coroutines.d<? super T> dVar) {
        kotlin.coroutines.d dVarA = h.a(dVar);
        try {
            g gVarD = dVar.d();
            Object objC = w0.c(gVarD, null);
            try {
                Object objA0 = ((p) t1.q(pVar, 2)).a0(r7, dVarA);
                w0.a(gVarD, objC);
                if (objA0 != kotlin.coroutines.intrinsics.d.h()) {
                    d1.a aVar = d1.f34719b;
                    dVarA.w(d1.b(objA0));
                }
            } catch (Throwable th) {
                w0.a(gVarD, objC);
                throw th;
            }
        } catch (Throwable th2) {
            d1.a aVar2 = d1.f34719b;
            dVarA.w(d1.b(e1.a(th2)));
        }
    }

    public static final <T> void c(@d l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar, @d kotlin.coroutines.d<? super T> dVar) {
        kotlin.coroutines.d dVarA = h.a(dVar);
        try {
            Object objZ = ((l) t1.q(lVar, 1)).z(dVarA);
            if (objZ != kotlin.coroutines.intrinsics.d.h()) {
                d1.a aVar = d1.f34719b;
                dVarA.w(d1.b(objZ));
            }
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            dVarA.w(d1.b(e1.a(th)));
        }
    }

    public static final <R, T> void d(@d p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, R r7, @d kotlin.coroutines.d<? super T> dVar) {
        kotlin.coroutines.d dVarA = h.a(dVar);
        try {
            Object objA0 = ((p) t1.q(pVar, 2)).a0(r7, dVarA);
            if (objA0 != kotlin.coroutines.intrinsics.d.h()) {
                d1.a aVar = d1.f34719b;
                dVarA.w(d1.b(objA0));
            }
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            dVarA.w(d1.b(e1.a(th)));
        }
    }

    private static final <T> void e(kotlin.coroutines.d<? super T> dVar, l<? super kotlin.coroutines.d<? super T>, ? extends Object> lVar) {
        kotlin.coroutines.d dVarA = h.a(dVar);
        try {
            Object objZ = lVar.z(dVarA);
            if (objZ != kotlin.coroutines.intrinsics.d.h()) {
                d1.a aVar = d1.f34719b;
                dVarA.w(d1.b(objZ));
            }
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            dVarA.w(d1.b(e1.a(th)));
        }
    }

    @e
    public static final <T, R> Object f(@d n0<? super T> n0Var, R r7, @d p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) {
        Object e0Var;
        try {
            e0Var = ((p) t1.q(pVar, 2)).a0(r7, n0Var);
        } catch (Throwable th) {
            e0Var = new e0(th, false, 2, null);
        }
        if (e0Var == kotlin.coroutines.intrinsics.d.h()) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        Object objA1 = n0Var.a1(e0Var);
        if (objA1 == x2.f37365b) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        if (objA1 instanceof e0) {
            throw ((e0) objA1).f35988a;
        }
        return x2.o(objA1);
    }

    @e
    public static final <T, R> Object g(@d n0<? super T> n0Var, R r7, @d p<? super R, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) throws Throwable {
        Object e0Var;
        try {
            e0Var = ((p) t1.q(pVar, 2)).a0(r7, n0Var);
        } catch (Throwable th) {
            e0Var = new e0(th, false, 2, null);
        }
        if (e0Var == kotlin.coroutines.intrinsics.d.h()) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        Object objA1 = n0Var.a1(e0Var);
        if (objA1 == x2.f37365b) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        if (objA1 instanceof e0) {
            Throwable th2 = ((e0) objA1).f35988a;
            if (((th2 instanceof z3) && ((z3) th2).f37397a == n0Var) ? false : true) {
                throw th2;
            }
            if (e0Var instanceof e0) {
                throw ((e0) e0Var).f35988a;
            }
        } else {
            e0Var = x2.o(objA1);
        }
        return e0Var;
    }

    private static final <T> Object h(n0<? super T> n0Var, l<? super Throwable, Boolean> lVar, i5.a<? extends Object> aVar) throws Throwable {
        Object e0Var;
        try {
            e0Var = aVar.invoke();
        } catch (Throwable th) {
            e0Var = new e0(th, false, 2, null);
        }
        if (e0Var == kotlin.coroutines.intrinsics.d.h()) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        Object objA1 = n0Var.a1(e0Var);
        if (objA1 == x2.f37365b) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        if (!(objA1 instanceof e0)) {
            return x2.o(objA1);
        }
        e0 e0Var2 = (e0) objA1;
        if (lVar.z(e0Var2.f35988a).booleanValue()) {
            throw e0Var2.f35988a;
        }
        if (e0Var instanceof e0) {
            throw ((e0) e0Var).f35988a;
        }
        return e0Var;
    }
}
