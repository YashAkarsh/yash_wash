package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<N extends h<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36986a = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36987b = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_prev");

    @a7.d
    private volatile /* synthetic */ Object _next = null;

    @a7.d
    private volatile /* synthetic */ Object _prev;

    public h(@a7.e N n7) {
        this._prev = n7;
    }

    private final N c() {
        N n7 = (N) f();
        while (n7 != null && n7.g()) {
            n7 = (N) n7._prev;
        }
        return n7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        N n7 = (N) d();
        kotlin.jvm.internal.l0.m(n7);
        while (n7.g()) {
            n7 = (N) n7.d();
            kotlin.jvm.internal.l0.m(n7);
        }
        return n7;
    }

    public final void b() {
        f36987b.lazySet(this, null);
    }

    @a7.e
    public final N d() {
        Object objE = e();
        if (objE == g.f36983b) {
            return null;
        }
        return (N) objE;
    }

    @a7.e
    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final boolean j() {
        return androidx.concurrent.futures.b.a(f36986a, this, null, g.f36983b);
    }

    @a7.e
    public final N k(@a7.d i5.a aVar) {
        Object objE = e();
        if (objE != g.f36983b) {
            return (N) objE;
        }
        aVar.invoke();
        throw new kotlin.y();
    }

    public final void l() {
        while (true) {
            h hVarC = c();
            h hVarH = h();
            hVarH._prev = hVarC;
            if (hVarC != null) {
                hVarC._next = hVarH;
            }
            if (!hVarH.g() && (hVarC == null || !hVarC.g())) {
                return;
            }
        }
    }

    public final boolean m(@a7.d N n7) {
        return androidx.concurrent.futures.b.a(f36986a, this, null, n7);
    }
}
