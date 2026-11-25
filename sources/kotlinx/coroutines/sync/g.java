package kotlinx.coroutines.sync;

import com.google.common.util.concurrent.h2;
import i5.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r;
import kotlinx.coroutines.t;

/* JADX INFO: loaded from: classes3.dex */
final class g implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37280c = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, com.paytm.pgsdk.d.U);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f37281d = AtomicLongFieldUpdater.newUpdater(g.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37282e = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f37283f = AtomicLongFieldUpdater.newUpdater(g.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f37284g = AtomicIntegerFieldUpdater.newUpdater(g.class, "_availablePermits");

    @a7.d
    volatile /* synthetic */ int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final l<Throwable, l2> f37286b;

    @a7.d
    private volatile /* synthetic */ long deqIdx = 0;

    @a7.d
    private volatile /* synthetic */ long enqIdx = 0;

    @a7.d
    private volatile /* synthetic */ Object head;

    @a7.d
    private volatile /* synthetic */ Object tail;

    static final class a extends n0 implements l<Throwable, l2> {
        a() {
            super(1);
        }

        public final void b(@a7.d Throwable th) {
            g.this.i();
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    public g(int i7, int i8) {
        this.f37285a = i7;
        if (!(i7 > 0)) {
            throw new IllegalArgumentException(l0.C("Semaphore should have at least 1 permit, but had ", Integer.valueOf(i7)).toString());
        }
        if (!(i8 >= 0 && i8 <= i7)) {
            throw new IllegalArgumentException(l0.C("The number of acquired permits should be in 0..", Integer.valueOf(i7)).toString());
        }
        i iVar = new i(0L, null, 2);
        this.head = iVar;
        this.tail = iVar;
        this._availablePermits = i7 - i8;
        this.f37286b = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(kotlin.coroutines.d<? super l2> dVar) {
        r rVarB = t.b(kotlin.coroutines.intrinsics.c.d(dVar));
        while (!h(rVarB)) {
            if (f37284g.getAndDecrement(this) > 0) {
                rVarB.x(l2.f34958a, this.f37286b);
                break;
            }
        }
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2.f34958a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(q<? super l2> qVar) {
        Object objB;
        boolean z7;
        i iVar = (i) this.tail;
        long andIncrement = f37283f.getAndIncrement(this);
        long j7 = andIncrement / ((long) h.f37293f);
        do {
            o0 o0Var = iVar;
            while (true) {
                if (o0Var.o() >= j7 && !o0Var.g()) {
                    objB = p0.b(o0Var);
                    break;
                }
                Object objE = o0Var.e();
                if (objE == kotlinx.coroutines.internal.g.f36983b) {
                    objB = p0.b(kotlinx.coroutines.internal.g.f36983b);
                    break;
                }
                o0 o0VarJ = (o0) ((kotlinx.coroutines.internal.h) objE);
                if (o0VarJ == null) {
                    o0VarJ = h.j(o0Var.o() + 1, (i) o0Var);
                    if (o0Var.m(o0VarJ)) {
                        if (o0Var.g()) {
                            o0Var.l();
                        }
                    }
                }
                o0Var = o0VarJ;
            }
            if (!p0.h(objB)) {
                o0 o0VarF = p0.f(objB);
                while (true) {
                    o0 o0Var2 = (o0) this.tail;
                    if (o0Var2.o() < o0VarF.o()) {
                        if (!o0VarF.r()) {
                            z7 = false;
                            break;
                        }
                        if (androidx.concurrent.futures.b.a(f37282e, this, o0Var2, o0VarF)) {
                            if (o0Var2.n()) {
                                o0Var2.l();
                            }
                        } else if (o0VarF.n()) {
                            o0VarF.l();
                        }
                    }
                    z7 = true;
                    break;
                }
            } else {
                break;
            }
        } while (!z7);
        i iVar2 = (i) p0.f(objB);
        int i7 = (int) (andIncrement % ((long) h.f37293f));
        if (h2.a(iVar2.f37298e, i7, null, qVar)) {
            qVar.i0(new kotlinx.coroutines.sync.a(iVar2, i7));
            return true;
        }
        if (!h2.a(iVar2.f37298e, i7, h.f37289b, h.f37290c)) {
            return false;
        }
        qVar.x(l2.f34958a, this.f37286b);
        return true;
    }

    private final boolean j(q<? super l2> qVar) {
        Object objC0 = qVar.c0(l2.f34958a, null, this.f37286b);
        if (objC0 == null) {
            return false;
        }
        qVar.t0(objC0);
        return true;
    }

    private final boolean k() {
        Object objB;
        int i7;
        boolean z7;
        i iVar = (i) this.head;
        long andIncrement = f37281d.getAndIncrement(this);
        long j7 = andIncrement / ((long) h.f37293f);
        do {
            o0 o0Var = iVar;
            while (true) {
                if (o0Var.o() >= j7 && !o0Var.g()) {
                    objB = p0.b(o0Var);
                    break;
                }
                Object objE = o0Var.e();
                if (objE == kotlinx.coroutines.internal.g.f36983b) {
                    objB = p0.b(kotlinx.coroutines.internal.g.f36983b);
                    break;
                }
                o0 o0VarJ = (o0) ((kotlinx.coroutines.internal.h) objE);
                if (o0VarJ == null) {
                    o0VarJ = h.j(o0Var.o() + 1, (i) o0Var);
                    if (o0Var.m(o0VarJ)) {
                        if (o0Var.g()) {
                            o0Var.l();
                        }
                    }
                }
                o0Var = o0VarJ;
            }
            i7 = 0;
            if (!p0.h(objB)) {
                o0 o0VarF = p0.f(objB);
                while (true) {
                    o0 o0Var2 = (o0) this.head;
                    if (o0Var2.o() < o0VarF.o()) {
                        if (!o0VarF.r()) {
                            z7 = false;
                            break;
                        }
                        if (androidx.concurrent.futures.b.a(f37280c, this, o0Var2, o0VarF)) {
                            if (o0Var2.n()) {
                                o0Var2.l();
                            }
                        } else if (o0VarF.n()) {
                            o0VarF.l();
                        }
                    }
                    z7 = true;
                    break;
                }
            } else {
                break;
            }
        } while (!z7);
        i iVar2 = (i) p0.f(objB);
        iVar2.b();
        if (iVar2.o() > j7) {
            return false;
        }
        int i8 = (int) (andIncrement % ((long) h.f37293f));
        Object andSet = iVar2.f37298e.getAndSet(i8, h.f37289b);
        if (andSet != null) {
            if (andSet == h.f37292e) {
                return false;
            }
            return j((q) andSet);
        }
        int i9 = h.f37288a;
        while (i7 < i9) {
            i7++;
            if (iVar2.f37298e.get(i8) == h.f37290c) {
                return true;
            }
        }
        return !h2.a(iVar2.f37298e, i8, h.f37289b, h.f37291d);
    }

    @Override // kotlinx.coroutines.sync.f
    public int a() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.f
    @a7.e
    public Object b(@a7.d kotlin.coroutines.d<? super l2> dVar) {
        if (f37284g.getAndDecrement(this) > 0) {
            return l2.f34958a;
        }
        Object objG = g(dVar);
        return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
    }

    @Override // kotlinx.coroutines.sync.f
    public boolean c() {
        int i7;
        do {
            i7 = this._availablePermits;
            if (i7 <= 0) {
                return false;
            }
        } while (!f37284g.compareAndSet(this, i7, i7 - 1));
        return true;
    }

    @Override // kotlinx.coroutines.sync.f
    public void i() {
        while (true) {
            int i7 = this._availablePermits;
            int i8 = this.f37285a;
            if (!(i7 < i8)) {
                throw new IllegalStateException(l0.C("The number of released permits cannot be greater than ", Integer.valueOf(i8)).toString());
            }
            if (f37284g.compareAndSet(this, i7, i7 + 1) && (i7 >= 0 || k())) {
                return;
            }
        }
    }
}
