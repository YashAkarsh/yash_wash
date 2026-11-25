package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f37043a = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f37044b = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37045c = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_removedRef");

    @a7.d
    volatile /* synthetic */ Object _next = this;

    @a7.d
    volatile /* synthetic */ Object _prev = this;

    @a7.d
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends kotlinx.coroutines.internal.b {
        @Override // kotlinx.coroutines.internal.b
        public final void a(@a7.d kotlinx.coroutines.internal.d<?> dVar, @a7.e Object obj) {
            y yVarI;
            boolean z7 = obj == null;
            y yVarH = h();
            if (yVarH == null || (yVarI = i()) == null) {
                return;
            }
            if (androidx.concurrent.futures.b.a(y.f37043a, yVarH, dVar, z7 ? n(yVarH, yVarI) : yVarI) && z7) {
                f(yVarH, yVarI);
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @a7.e
        public final Object c(@a7.d kotlinx.coroutines.internal.d<?> dVar) {
            while (true) {
                y yVarM = m(dVar);
                if (yVarM == null) {
                    return kotlinx.coroutines.internal.c.f36965b;
                }
                Object obj = yVarM._next;
                if (obj == dVar || dVar.h()) {
                    return null;
                }
                if (obj instanceof j0) {
                    j0 j0Var = (j0) obj;
                    if (dVar.b(j0Var)) {
                        return kotlinx.coroutines.internal.c.f36965b;
                    }
                    j0Var.c(yVarM);
                } else {
                    Object objE = e(yVarM);
                    if (objE != null) {
                        return objE;
                    }
                    if (l(yVarM, obj)) {
                        continue;
                    } else {
                        d dVar2 = new d(yVarM, (y) obj, this);
                        if (androidx.concurrent.futures.b.a(y.f37043a, yVarM, obj, dVar2)) {
                            try {
                                if (dVar2.c(yVarM) != z.f37060a) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                androidx.concurrent.futures.b.a(y.f37043a, yVarM, dVar2, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @a7.e
        protected Object e(@a7.d y yVar) {
            return null;
        }

        protected abstract void f(@a7.d y yVar, @a7.d y yVar2);

        public abstract void g(@a7.d d dVar);

        @a7.e
        protected abstract y h();

        @a7.e
        protected abstract y i();

        @a7.e
        public Object j(@a7.d d dVar) {
            g(dVar);
            return null;
        }

        public void k(@a7.d y yVar) {
        }

        protected boolean l(@a7.d y yVar, @a7.d Object obj) {
            return false;
        }

        @a7.e
        protected y m(@a7.d j0 j0Var) {
            y yVarH = h();
            kotlin.jvm.internal.l0.m(yVarH);
            return yVarH;
        }

        @a7.d
        public abstract Object n(@a7.d y yVar, @a7.d y yVar2);
    }

    public static class b<T extends y> extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f37046d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");

        @a7.d
        private volatile /* synthetic */ Object _affectedNode = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y f37047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        @h5.e
        public final T f37048c;

        public b(@a7.d y yVar, @a7.d T t7) {
            this.f37047b = yVar;
            this.f37048c = t7;
        }

        @Override // kotlinx.coroutines.internal.y.a
        protected void f(@a7.d y yVar, @a7.d y yVar2) {
            this.f37048c.F0(this.f37047b);
        }

        @Override // kotlinx.coroutines.internal.y.a
        public void g(@a7.d d dVar) {
            androidx.concurrent.futures.b.a(f37046d, this, null, dVar.f37051a);
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected final y h() {
            return (y) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.d
        protected final y i() {
            return this.f37047b;
        }

        @Override // kotlinx.coroutines.internal.y.a
        protected boolean l(@a7.d y yVar, @a7.d Object obj) {
            return obj != this.f37047b;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected final y m(@a7.d j0 j0Var) {
            return this.f37047b.B0(j0Var);
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.d
        public Object n(@a7.d y yVar, @a7.d y yVar2) {
            T t7 = this.f37048c;
            androidx.concurrent.futures.b.a(y.f37044b, t7, t7, yVar);
            T t8 = this.f37048c;
            androidx.concurrent.futures.b.a(y.f37043a, t8, t8, this.f37047b);
            return this.f37048c;
        }
    }

    @kotlin.a1
    public static abstract class c extends kotlinx.coroutines.internal.d<y> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y f37049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        @a7.e
        public y f37050c;

        public c(@a7.d y yVar) {
            this.f37049b = yVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@a7.d y yVar, @a7.e Object obj) {
            boolean z7 = obj == null;
            y yVar2 = z7 ? this.f37049b : this.f37050c;
            if (yVar2 != null && androidx.concurrent.futures.b.a(y.f37043a, yVar, this, yVar2) && z7) {
                y yVar3 = this.f37049b;
                y yVar4 = this.f37050c;
                kotlin.jvm.internal.l0.m(yVar4);
                yVar3.F0(yVar4);
            }
        }
    }

    public static final class d extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y f37051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y f37052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        @h5.e
        public final a f37053c;

        public d(@a7.d y yVar, @a7.d y yVar2, @a7.d a aVar) {
            this.f37051a = yVar;
            this.f37052b = yVar2;
            this.f37053c = aVar;
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.d
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f37053c.b();
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.e
        public Object c(@a7.e Object obj) {
            Object objN;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            }
            y yVar = (y) obj;
            Object objJ = this.f37053c.j(this);
            Object obj2 = z.f37060a;
            if (objJ == obj2) {
                y yVar2 = this.f37052b;
                if (androidx.concurrent.futures.b.a(y.f37043a, yVar, this, yVar2.S0())) {
                    this.f37053c.k(yVar);
                    yVar2.B0(null);
                }
                return obj2;
            }
            Object objE = objJ != null ? a().e(objJ) : a().f();
            if (objE == kotlinx.coroutines.internal.c.f36964a) {
                objN = a();
            } else {
                objN = objE == null ? this.f37053c.n(yVar, this.f37052b) : this.f37052b;
            }
            androidx.concurrent.futures.b.a(y.f37043a, yVar, this, objN);
            return null;
        }

        public final void d() {
            this.f37053c.g(this);
        }

        @Override // kotlinx.coroutines.internal.j0
        @a7.d
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    public static class e<T> extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f37054c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_affectedNode");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f37055d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_originalNext");

        @a7.d
        private volatile /* synthetic */ Object _affectedNode = null;

        @a7.d
        private volatile /* synthetic */ Object _originalNext = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final y f37056b;

        public e(@a7.d y yVar) {
            this.f37056b = yVar;
        }

        public static /* synthetic */ void p() {
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected Object e(@a7.d y yVar) {
            if (yVar == this.f37056b) {
                return x.d();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.y.a
        protected final void f(@a7.d y yVar, @a7.d y yVar2) {
            yVar2.B0(null);
        }

        @Override // kotlinx.coroutines.internal.y.a
        public void g(@a7.d d dVar) {
            androidx.concurrent.futures.b.a(f37054c, this, null, dVar.f37051a);
            androidx.concurrent.futures.b.a(f37055d, this, null, dVar.f37052b);
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected final y h() {
            return (y) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected final y i() {
            return (y) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.y.a
        protected final boolean l(@a7.d y yVar, @a7.d Object obj) {
            if (!(obj instanceof l0)) {
                return false;
            }
            ((l0) obj).f36998a.K0();
            return true;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected final y m(@a7.d j0 j0Var) {
            y yVar = this.f37056b;
            while (true) {
                Object obj = yVar._next;
                if (!(obj instanceof j0)) {
                    return (y) obj;
                }
                j0 j0Var2 = (j0) obj;
                if (j0Var.b(j0Var2)) {
                    return null;
                }
                j0Var2.c(this.f37056b);
            }
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.d
        public final Object n(@a7.d y yVar, @a7.d y yVar2) {
            return yVar2.S0();
        }

        public final T o() {
            T t7 = (T) h();
            kotlin.jvm.internal.l0.m(t7);
            return t7;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ i5.a<Boolean> f37058e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i5.a<Boolean> aVar) {
            super(y.this);
            this.f37058e = aVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@a7.d y yVar) {
            if (this.f37058e.invoke().booleanValue()) {
                return null;
            }
            return x.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y B0(j0 j0Var) {
        Object obj;
        while (true) {
            y yVar = (y) this._prev;
            y yVar2 = yVar;
            while (true) {
                y yVar3 = null;
                while (true) {
                    obj = yVar2._next;
                    if (obj == this) {
                        if (yVar == yVar2) {
                            return yVar2;
                        }
                        if (!androidx.concurrent.futures.b.a(f37044b, this, yVar, yVar2)) {
                            break;
                        }
                        return yVar2;
                    }
                    if (L0()) {
                        return null;
                    }
                    if (obj == j0Var) {
                        return yVar2;
                    }
                    if (obj instanceof j0) {
                        if (j0Var != null && j0Var.b((j0) obj)) {
                            return null;
                        }
                        ((j0) obj).c(yVar2);
                        break;
                    }
                    if (!(obj instanceof l0)) {
                        yVar3 = yVar2;
                        yVar2 = (y) obj;
                    } else {
                        if (yVar3 != null) {
                            break;
                        }
                        yVar2 = (y) yVar2._prev;
                    }
                }
                if (!androidx.concurrent.futures.b.a(f37043a, yVar3, yVar2, ((l0) obj).f36998a)) {
                    break;
                }
                yVar2 = yVar3;
            }
        }
    }

    private final y E0(y yVar) {
        while (yVar.L0()) {
            yVar = (y) yVar._prev;
        }
        return yVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(y yVar) {
        y yVar2;
        do {
            yVar2 = (y) yVar._prev;
            if (G0() != yVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f37044b, yVar, yVar2, this));
        if (L0()) {
            yVar.B0(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l0 S0() {
        l0 l0Var = (l0) this._removedRef;
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0(this);
        f37045c.lazySet(this, l0Var2);
        return l0Var2;
    }

    public final boolean A0(@a7.d y yVar) {
        f37044b.lazySet(yVar, this);
        f37043a.lazySet(yVar, this);
        while (G0() == this) {
            if (androidx.concurrent.futures.b.a(f37043a, this, this, yVar)) {
                yVar.F0(this);
                return true;
            }
        }
        return false;
    }

    @a7.d
    public final <T extends y> b<T> C0(@a7.d T t7) {
        return new b<>(this, t7);
    }

    @a7.d
    public final e<y> D0() {
        return new e<>(this);
    }

    @a7.d
    public final Object G0() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof j0)) {
                return obj;
            }
            ((j0) obj).c(this);
        }
    }

    @a7.d
    public final y H0() {
        return x.h(G0());
    }

    @a7.d
    public final y I0() {
        y yVarB0 = B0(null);
        return yVarB0 == null ? E0((y) this._prev) : yVarB0;
    }

    public final void J0() {
        ((l0) G0()).f36998a.K0();
    }

    @kotlin.a1
    public final void K0() {
        y yVar = this;
        while (true) {
            Object objG0 = yVar.G0();
            if (!(objG0 instanceof l0)) {
                yVar.B0(null);
                return;
            }
            yVar = ((l0) objG0).f36998a;
        }
    }

    public boolean L0() {
        return G0() instanceof l0;
    }

    @a7.d
    @kotlin.a1
    public final c M0(@a7.d y yVar, @a7.d i5.a<Boolean> aVar) {
        return yVar.new f(aVar);
    }

    @a7.e
    protected y N0() {
        Object objG0 = G0();
        l0 l0Var = objG0 instanceof l0 ? (l0) objG0 : null;
        if (l0Var == null) {
            return null;
        }
        return l0Var.f36998a;
    }

    public boolean O0() {
        return R0() == null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object, kotlinx.coroutines.internal.y] */
    public final /* synthetic */ <T> T P0(i5.l<? super T, Boolean> lVar) {
        while (true) {
            y yVar = (y) G0();
            if (yVar == this) {
                return null;
            }
            kotlin.jvm.internal.l0.y(3, "T");
            if (!(yVar instanceof Object)) {
                return null;
            }
            if (lVar.z(yVar).booleanValue() && !yVar.L0()) {
                return yVar;
            }
            y yVarR0 = yVar.R0();
            if (yVarR0 == null) {
                return yVar;
            }
            yVarR0.K0();
        }
    }

    @a7.e
    public final y Q0() {
        while (true) {
            y yVar = (y) G0();
            if (yVar == this) {
                return null;
            }
            if (yVar.O0()) {
                return yVar;
            }
            yVar.J0();
        }
    }

    @a7.e
    @kotlin.a1
    public final y R0() {
        Object objG0;
        y yVar;
        do {
            objG0 = G0();
            if (objG0 instanceof l0) {
                return ((l0) objG0).f36998a;
            }
            if (objG0 == this) {
                return (y) objG0;
            }
            yVar = (y) objG0;
        } while (!androidx.concurrent.futures.b.a(f37043a, this, objG0, yVar.S0()));
        yVar.B0(null);
        return null;
    }

    @kotlin.a1
    public final int T0(@a7.d y yVar, @a7.d y yVar2, @a7.d c cVar) {
        f37044b.lazySet(yVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f37043a;
        atomicReferenceFieldUpdater.lazySet(yVar, yVar2);
        cVar.f37050c = yVar2;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, yVar2, cVar)) {
            return cVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void U0(@a7.d y yVar, @a7.d y yVar2) {
    }

    @a7.d
    public String toString() {
        return new kotlin.jvm.internal.e1(this) { // from class: kotlinx.coroutines.internal.y.g
            @Override // kotlin.jvm.internal.e1, kotlin.reflect.p
            @a7.e
            public Object get() {
                return kotlinx.coroutines.a1.a(this.f34895b);
            }
        } + '@' + kotlinx.coroutines.a1.b(this);
    }

    public final void v0(@a7.d y yVar) {
        while (!I0().z0(yVar, this)) {
        }
    }

    public final boolean w0(@a7.d y yVar, @a7.d i5.a<Boolean> aVar) {
        int iT0;
        f fVar = yVar.new f(aVar);
        do {
            iT0 = I0().T0(yVar, this, fVar);
            if (iT0 == 1) {
                return true;
            }
        } while (iT0 != 2);
        return false;
    }

    public final boolean x0(@a7.d y yVar, @a7.d i5.l<? super y, Boolean> lVar) {
        y yVarI0;
        do {
            yVarI0 = I0();
            if (!lVar.z(yVarI0).booleanValue()) {
                return false;
            }
        } while (!yVarI0.z0(yVar, this));
        return true;
    }

    public final boolean y0(@a7.d y yVar, @a7.d i5.l<? super y, Boolean> lVar, @a7.d i5.a<Boolean> aVar) {
        int iT0;
        f fVar = yVar.new f(aVar);
        do {
            y yVarI0 = I0();
            if (!lVar.z(yVarI0).booleanValue()) {
                return false;
            }
            iT0 = yVarI0.T0(yVar, this, fVar);
            if (iT0 == 1) {
                return true;
            }
        } while (iT0 != 2);
        return false;
    }

    @kotlin.a1
    public final boolean z0(@a7.d y yVar, @a7.d y yVar2) {
        f37044b.lazySet(yVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f37043a;
        atomicReferenceFieldUpdater.lazySet(yVar, yVar2);
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, yVar2, yVar)) {
            return false;
        }
        yVar.F0(yVar2);
        return true;
    }
}
