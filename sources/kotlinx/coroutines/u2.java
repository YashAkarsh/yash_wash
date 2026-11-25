package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u2 {
    public static final boolean A(@a7.d kotlin.coroutines.g gVar) {
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        return o2Var != null && o2Var.b();
    }

    private static final Throwable B(Throwable th, o2 o2Var) {
        return th == null ? new p2("Job was cancelled", null, o2Var) : th;
    }

    @a7.d
    public static final c0 a(@a7.e o2 o2Var) {
        return new r2(o2Var);
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @h5.h(name = "Job")
    public static final /* synthetic */ o2 b(o2 o2Var) {
        return s2.a(o2Var);
    }

    public static /* synthetic */ c0 c(o2 o2Var, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            o2Var = null;
        }
        return s2.a(o2Var);
    }

    public static /* synthetic */ o2 d(o2 o2Var, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            o2Var = null;
        }
        return b(o2Var);
    }

    public static final void f(@a7.d kotlin.coroutines.g gVar, @a7.e CancellationException cancellationException) {
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        if (o2Var == null) {
            return;
        }
        o2Var.c(cancellationException);
    }

    public static final void g(@a7.d o2 o2Var, @a7.d String str, @a7.e Throwable th) {
        o2Var.c(z1.a(str, th));
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean h(kotlin.coroutines.g gVar, Throwable th) throws Throwable {
        kotlin.coroutines.g.b bVar = gVar.get(o2.f37103s0);
        w2 w2Var = bVar instanceof w2 ? (w2) bVar : null;
        if (w2Var == null) {
            return false;
        }
        w2Var.f0(B(th, w2Var));
        return true;
    }

    public static /* synthetic */ void i(kotlin.coroutines.g gVar, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        s2.f(gVar, cancellationException);
    }

    public static /* synthetic */ void j(o2 o2Var, String str, Throwable th, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            th = null;
        }
        s2.g(o2Var, str, th);
    }

    public static /* synthetic */ boolean k(kotlin.coroutines.g gVar, Throwable th, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            th = null;
        }
        return h(gVar, th);
    }

    @a7.e
    public static final Object l(@a7.d o2 o2Var, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        o2.a.b(o2Var, null, 1, null);
        Object objH = o2Var.H(dVar);
        return objH == kotlin.coroutines.intrinsics.d.h() ? objH : kotlin.l2.f34958a;
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void n(kotlin.coroutines.g gVar, Throwable th) throws Throwable {
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        if (o2Var == null) {
            return;
        }
        for (o2 o2Var2 : o2Var.E()) {
            w2 w2Var = o2Var2 instanceof w2 ? (w2) o2Var2 : null;
            if (w2Var != null) {
                w2Var.f0(B(th, o2Var));
            }
        }
    }

    public static final void o(@a7.d kotlin.coroutines.g gVar, @a7.e CancellationException cancellationException) {
        kotlin.sequences.m<o2> mVarE;
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        if (o2Var == null || (mVarE = o2Var.E()) == null) {
            return;
        }
        Iterator<o2> it = mVarE.iterator();
        while (it.hasNext()) {
            it.next().c(cancellationException);
        }
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void q(o2 o2Var, Throwable th) throws Throwable {
        for (o2 o2Var2 : o2Var.E()) {
            w2 w2Var = o2Var2 instanceof w2 ? (w2) o2Var2 : null;
            if (w2Var != null) {
                w2Var.f0(B(th, o2Var));
            }
        }
    }

    public static final void r(@a7.d o2 o2Var, @a7.e CancellationException cancellationException) {
        Iterator<o2> it = o2Var.E().iterator();
        while (it.hasNext()) {
            it.next().c(cancellationException);
        }
    }

    public static /* synthetic */ void s(kotlin.coroutines.g gVar, Throwable th, int i7, Object obj) throws Throwable {
        if ((i7 & 1) != 0) {
            th = null;
        }
        n(gVar, th);
    }

    public static /* synthetic */ void t(kotlin.coroutines.g gVar, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        s2.o(gVar, cancellationException);
    }

    public static /* synthetic */ void u(o2 o2Var, Throwable th, int i7, Object obj) throws Throwable {
        if ((i7 & 1) != 0) {
            th = null;
        }
        q(o2Var, th);
    }

    public static /* synthetic */ void v(o2 o2Var, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        s2.r(o2Var, cancellationException);
    }

    @a7.d
    public static final q1 w(@a7.d o2 o2Var, @a7.d q1 q1Var) {
        return o2Var.g0(new s1(q1Var));
    }

    public static final void x(@a7.d kotlin.coroutines.g gVar) {
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        if (o2Var == null) {
            return;
        }
        s2.A(o2Var);
    }

    public static final void y(@a7.d o2 o2Var) {
        if (!o2Var.b()) {
            throw o2Var.K();
        }
    }

    @a7.d
    public static final o2 z(@a7.d kotlin.coroutines.g gVar) {
        o2 o2Var = (o2) gVar.get(o2.f37103s0);
        if (o2Var != null) {
            return o2Var;
        }
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("Current context doesn't contain Job in it: ", gVar).toString());
    }
}
