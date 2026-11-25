package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k1<T> extends kotlinx.coroutines.scheduling.k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public int f37063c;

    public k1(int i7) {
        this.f37063c = i7;
    }

    public void c(@a7.e Object obj, @a7.d Throwable th) {
    }

    @a7.d
    public abstract kotlin.coroutines.d<T> f();

    @a7.e
    public Throwable g(@a7.e Object obj) {
        e0 e0Var = obj instanceof e0 ? (e0) obj : null;
        if (e0Var == null) {
            return null;
        }
        return e0Var.f35988a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T h(@a7.e Object obj) {
        return obj;
    }

    public final void j(@a7.e Throwable th, @a7.e Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.p.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.l0.m(th);
        r0.b(f().d(), new y0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @a7.e
    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() {
        Object objB;
        Object objB2;
        kotlinx.coroutines.scheduling.l lVar = this.f37186b;
        try {
            kotlinx.coroutines.internal.l lVar2 = (kotlinx.coroutines.internal.l) f();
            kotlin.coroutines.d<T> dVar = lVar2.f36995e;
            Object obj = lVar2.f36997g;
            kotlin.coroutines.g gVarD = dVar.d();
            Object objC = kotlinx.coroutines.internal.w0.c(gVarD, obj);
            d4<?> d4VarG = objC != kotlinx.coroutines.internal.w0.f37028a ? n0.g(dVar, gVarD, objC) : null;
            try {
                kotlin.coroutines.g gVarD2 = dVar.d();
                Object objK = k();
                Throwable thG = g(objK);
                o2 o2Var = (thG == null && l1.c(this.f37063c)) ? (o2) gVarD2.get(o2.f37103s0) : null;
                if (o2Var != null && !o2Var.b()) {
                    CancellationException cancellationExceptionK = o2Var.K();
                    c(objK, cancellationExceptionK);
                    kotlin.d1.a aVar = kotlin.d1.f34719b;
                    dVar.w(kotlin.d1.b(kotlin.e1.a(cancellationExceptionK)));
                } else if (thG != null) {
                    kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                    dVar.w(kotlin.d1.b(kotlin.e1.a(thG)));
                } else {
                    T tH = h(objK);
                    kotlin.d1.a aVar3 = kotlin.d1.f34719b;
                    dVar.w(kotlin.d1.b(tH));
                }
                kotlin.l2 l2Var = kotlin.l2.f34958a;
                if (d4VarG == null || d4VarG.G1()) {
                    kotlinx.coroutines.internal.w0.a(gVarD, objC);
                }
                try {
                    kotlin.d1.a aVar4 = kotlin.d1.f34719b;
                    lVar.G();
                    objB2 = kotlin.d1.b(l2Var);
                } catch (Throwable th) {
                    kotlin.d1.a aVar5 = kotlin.d1.f34719b;
                    objB2 = kotlin.d1.b(kotlin.e1.a(th));
                }
                j(null, kotlin.d1.e(objB2));
            } catch (Throwable th2) {
                if (d4VarG == null || d4VarG.G1()) {
                    kotlinx.coroutines.internal.w0.a(gVarD, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                kotlin.d1.a aVar6 = kotlin.d1.f34719b;
                lVar.G();
                objB = kotlin.d1.b(kotlin.l2.f34958a);
            } catch (Throwable th4) {
                kotlin.d1.a aVar7 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th4));
            }
            j(th3, kotlin.d1.e(objB));
        }
    }
}
