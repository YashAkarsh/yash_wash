package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {
    @a7.d
    public static final v0 a(@a7.d kotlin.coroutines.g gVar) {
        if (gVar.get(o2.f37103s0) == null) {
            gVar = gVar.plus(u2.c(null, 1, null));
        }
        return new kotlinx.coroutines.internal.j(gVar);
    }

    @a7.d
    public static final v0 b() {
        return new kotlinx.coroutines.internal.j(s3.c(null, 1, null).plus(n1.e()));
    }

    public static final void c(@a7.d v0 v0Var, @a7.d String str, @a7.e Throwable th) {
        d(v0Var, z1.a(str, th));
    }

    public static final void d(@a7.d v0 v0Var, @a7.e CancellationException cancellationException) {
        o2 o2Var = (o2) v0Var.D().get(o2.f37103s0);
        if (o2Var == null) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Scope cannot be cancelled because it does not have a job: ", v0Var).toString());
        }
        o2Var.c(cancellationException);
    }

    public static /* synthetic */ void e(v0 v0Var, String str, Throwable th, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            th = null;
        }
        c(v0Var, str, th);
    }

    public static /* synthetic */ void f(v0 v0Var, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        d(v0Var, cancellationException);
    }

    @a7.e
    public static final <R> Object g(@a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        kotlinx.coroutines.internal.n0 n0Var = new kotlinx.coroutines.internal.n0(dVar.d(), dVar);
        Object objF = r5.b.f(n0Var, n0Var, pVar);
        if (objF == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objF;
    }

    @a7.e
    public static final Object h(@a7.d kotlin.coroutines.d<? super kotlin.coroutines.g> dVar) {
        return dVar.d();
    }

    private static final Object i(kotlin.coroutines.d<? super kotlin.coroutines.g> dVar) {
        kotlin.jvm.internal.i0.e(3);
        throw null;
    }

    public static final void j(@a7.d v0 v0Var) {
        s2.z(v0Var.D());
    }

    public static final boolean k(@a7.d v0 v0Var) {
        o2 o2Var = (o2) v0Var.D().get(o2.f37103s0);
        if (o2Var == null) {
            return true;
        }
        return o2Var.b();
    }

    public static /* synthetic */ void l(v0 v0Var) {
    }

    @a7.d
    public static final v0 m(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar) {
        return new kotlinx.coroutines.internal.j(v0Var.D().plus(gVar));
    }
}
