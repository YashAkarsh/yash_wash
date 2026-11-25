package kotlinx.coroutines.sync;

import i5.l;
import i5.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.q;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s;
import kotlinx.coroutines.t;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements kotlinx.coroutines.sync.c, kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f37248a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_state");

    @a7.d
    volatile /* synthetic */ Object _state;

    private final class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        private final q<l2> f37249g;

        /* JADX INFO: renamed from: kotlinx.coroutines.sync.d$a$a, reason: collision with other inner class name */
        static final class C0493a extends n0 implements l<Throwable, l2> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f37251a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f37252b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0493a(d dVar, a aVar) {
                super(1);
                this.f37251a = dVar;
                this.f37252b = aVar;
            }

            public final void b(@a7.d Throwable th) {
                this.f37251a.d(this.f37252b.f37259d);
            }

            @Override // i5.l
            public /* bridge */ /* synthetic */ l2 z(Throwable th) {
                b(th);
                return l2.f34958a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@a7.d Object obj, q<? super l2> qVar) {
            super(obj);
            this.f37249g = qVar;
        }

        @Override // kotlinx.coroutines.sync.d.c
        public void V0() {
            this.f37249g.t0(s.f37123d);
        }

        @Override // kotlinx.coroutines.sync.d.c
        public boolean X0() {
            return W0() && this.f37249g.c0(l2.f34958a, null, new C0493a(d.this, this)) != null;
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "LockCont[" + this.f37259d + ", " + this.f37249g + "] for " + d.this;
        }
    }

    private final class b<R> extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.selects.f<R> f37253g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @a7.d
        @h5.e
        public final p<kotlinx.coroutines.sync.c, kotlin.coroutines.d<? super R>, Object> f37254h;

        static final class a extends n0 implements l<Throwable, l2> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f37256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b<R> f37257b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, b<R> bVar) {
                super(1);
                this.f37256a = dVar;
                this.f37257b = bVar;
            }

            public final void b(@a7.d Throwable th) {
                this.f37256a.d(this.f37257b.f37259d);
            }

            @Override // i5.l
            public /* bridge */ /* synthetic */ l2 z(Throwable th) {
                b(th);
                return l2.f34958a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@a7.d Object obj, @a7.d kotlinx.coroutines.selects.f<? super R> fVar, p<? super kotlinx.coroutines.sync.c, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            super(obj);
            this.f37253g = fVar;
            this.f37254h = pVar;
        }

        @Override // kotlinx.coroutines.sync.d.c
        public void V0() throws Throwable {
            r5.a.d(this.f37254h, d.this, this.f37253g.G(), new a(d.this, this));
        }

        @Override // kotlinx.coroutines.sync.d.c
        public boolean X0() {
            return W0() && this.f37253g.q();
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "LockSelect[" + this.f37259d + ", " + this.f37253g + "] for " + d.this;
        }
    }

    private abstract class c extends y implements q1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f37258f = AtomicIntegerFieldUpdater.newUpdater(c.class, "isTaken");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Object f37259d;

        @a7.d
        private volatile /* synthetic */ int isTaken = 0;

        public c(Object obj) {
            this.f37259d = obj;
        }

        @Override // kotlinx.coroutines.q1
        public final void F() {
            O0();
        }

        public abstract void V0();

        public final boolean W0() {
            return f37258f.compareAndSet(this, 0, 1);
        }

        public abstract boolean X0();
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.d$d, reason: collision with other inner class name */
    private static final class C0494d extends w {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public Object f37261d;

        public C0494d(@a7.d Object obj) {
            this.f37261d = obj;
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "LockedQueue[" + this.f37261d + ']';
        }
    }

    private static final class e extends kotlinx.coroutines.internal.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final d f37262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Object f37263c;

        private final class a extends j0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @a7.d
            private final kotlinx.coroutines.internal.d<?> f37264a;

            public a(kotlinx.coroutines.internal.d<?> dVar) {
                this.f37264a = dVar;
            }

            @Override // kotlinx.coroutines.internal.j0
            @a7.d
            public kotlinx.coroutines.internal.d<?> a() {
                return this.f37264a;
            }

            @Override // kotlinx.coroutines.internal.j0
            @a7.e
            public Object c(@a7.e Object obj) {
                Object objA = a().h() ? kotlinx.coroutines.sync.e.f37274f : a();
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                }
                androidx.concurrent.futures.b.a(d.f37248a, (d) obj, this, objA);
                return null;
            }
        }

        public e(@a7.d d dVar, @a7.e Object obj) {
            this.f37262b = dVar;
            this.f37263c = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        public void a(@a7.d kotlinx.coroutines.internal.d<?> dVar, @a7.e Object obj) {
            kotlinx.coroutines.sync.b bVar;
            if (obj != null) {
                bVar = kotlinx.coroutines.sync.e.f37274f;
            } else {
                Object obj2 = this.f37263c;
                bVar = obj2 == null ? kotlinx.coroutines.sync.e.f37273e : new kotlinx.coroutines.sync.b(obj2);
            }
            androidx.concurrent.futures.b.a(d.f37248a, this.f37262b, dVar, bVar);
        }

        @Override // kotlinx.coroutines.internal.b
        @a7.e
        public Object c(@a7.d kotlinx.coroutines.internal.d<?> dVar) {
            a aVar = new a(dVar);
            return !androidx.concurrent.futures.b.a(d.f37248a, this.f37262b, kotlinx.coroutines.sync.e.f37274f, aVar) ? kotlinx.coroutines.sync.e.f37269a : aVar.c(this.f37262b);
        }
    }

    private static final class f extends kotlinx.coroutines.internal.d<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final C0494d f37266b;

        public f(@a7.d C0494d c0494d) {
            this.f37266b = c0494d;
        }

        @Override // kotlinx.coroutines.internal.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@a7.d d dVar, @a7.e Object obj) {
            androidx.concurrent.futures.b.a(d.f37248a, dVar, this, obj == null ? kotlinx.coroutines.sync.e.f37274f : this.f37266b);
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@a7.d d dVar) {
            if (this.f37266b.W0()) {
                return null;
            }
            return kotlinx.coroutines.sync.e.f37270b;
        }
    }

    static final class g extends n0 implements l<Throwable, l2> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f37268b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Object obj) {
            super(1);
            this.f37268b = obj;
        }

        public final void b(@a7.d Throwable th) {
            d.this.d(this.f37268b);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    public d(boolean z7) {
        this._state = z7 ? kotlinx.coroutines.sync.e.f37273e : kotlinx.coroutines.sync.e.f37274f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(Object obj, kotlin.coroutines.d<? super l2> dVar) {
        r rVarB = t.b(kotlin.coroutines.intrinsics.c.d(dVar));
        a aVar = new a(obj, rVarB);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj2;
                if (bVar.f37247a != kotlinx.coroutines.sync.e.f37272d) {
                    androidx.concurrent.futures.b.a(f37248a, this, obj2, new C0494d(bVar.f37247a));
                } else {
                    if (androidx.concurrent.futures.b.a(f37248a, this, obj2, obj == null ? kotlinx.coroutines.sync.e.f37273e : new kotlinx.coroutines.sync.b(obj))) {
                        rVarB.x(l2.f34958a, new g(obj));
                        break;
                    }
                }
            } else if (obj2 instanceof C0494d) {
                C0494d c0494d = (C0494d) obj2;
                if (!(c0494d.f37261d != obj)) {
                    throw new IllegalStateException(l0.C("Already locked by ", obj).toString());
                }
                c0494d.v0(aVar);
                if (this._state == obj2 || !aVar.W0()) {
                    t.c(rVarB, aVar);
                    break;
                }
                aVar = new a(obj, rVarB);
            } else {
                if (!(obj2 instanceof j0)) {
                    throw new IllegalStateException(l0.C("Illegal state ", obj2).toString());
                }
                ((j0) obj2).c(this);
            }
        }
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2.f34958a;
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean a(@a7.e Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                if (((kotlinx.coroutines.sync.b) obj2).f37247a != kotlinx.coroutines.sync.e.f37272d) {
                    return false;
                }
                if (androidx.concurrent.futures.b.a(f37248a, this, obj2, obj == null ? kotlinx.coroutines.sync.e.f37273e : new kotlinx.coroutines.sync.b(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof C0494d) {
                    if (((C0494d) obj2).f37261d != obj) {
                        return false;
                    }
                    throw new IllegalStateException(l0.C("Already locked by ", obj).toString());
                }
                if (!(obj2 instanceof j0)) {
                    throw new IllegalStateException(l0.C("Illegal state ", obj2).toString());
                }
                ((j0) obj2).c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean b() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return ((kotlinx.coroutines.sync.b) obj).f37247a != kotlinx.coroutines.sync.e.f37272d;
            }
            if (obj instanceof C0494d) {
                return true;
            }
            if (!(obj instanceof j0)) {
                throw new IllegalStateException(l0.C("Illegal state ", obj).toString());
            }
            ((j0) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.sync.c
    @a7.e
    public Object c(@a7.e Object obj, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        if (a(obj)) {
            return l2.f34958a;
        }
        Object objI = i(obj, dVar);
        return objI == kotlin.coroutines.intrinsics.d.h() ? objI : l2.f34958a;
    }

    @Override // kotlinx.coroutines.sync.c
    public void d(@a7.e Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                if (obj == null) {
                    if (!(((kotlinx.coroutines.sync.b) obj2).f37247a != kotlinx.coroutines.sync.e.f37272d)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj2;
                    if (!(bVar.f37247a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar.f37247a + " but expected " + obj).toString());
                    }
                }
                if (androidx.concurrent.futures.b.a(f37248a, this, obj2, kotlinx.coroutines.sync.e.f37274f)) {
                    return;
                }
            } else if (obj2 instanceof j0) {
                ((j0) obj2).c(this);
            } else {
                if (!(obj2 instanceof C0494d)) {
                    throw new IllegalStateException(l0.C("Illegal state ", obj2).toString());
                }
                if (obj != null) {
                    C0494d c0494d = (C0494d) obj2;
                    if (!(c0494d.f37261d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c0494d.f37261d + " but expected " + obj).toString());
                    }
                }
                C0494d c0494d2 = (C0494d) obj2;
                y yVarQ0 = c0494d2.Q0();
                if (yVarQ0 == null) {
                    f fVar = new f(c0494d2);
                    if (androidx.concurrent.futures.b.a(f37248a, this, obj2, fVar) && fVar.c(this) == null) {
                        return;
                    }
                } else {
                    c cVar = (c) yVarQ0;
                    if (cVar.X0()) {
                        Object obj3 = cVar.f37259d;
                        if (obj3 == null) {
                            obj3 = kotlinx.coroutines.sync.e.f37271c;
                        }
                        c0494d2.f37261d = obj3;
                        cVar.V0();
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean e(@a7.d Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof kotlinx.coroutines.sync.b) {
            if (((kotlinx.coroutines.sync.b) obj2).f37247a == obj) {
                return true;
            }
        } else if ((obj2 instanceof C0494d) && ((C0494d) obj2).f37261d == obj) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.c
    @a7.d
    public kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> f() {
        return this;
    }

    public final boolean h() {
        Object obj = this._state;
        return (obj instanceof C0494d) && ((C0494d) obj).W0();
    }

    @a7.d
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return "Mutex[" + ((kotlinx.coroutines.sync.b) obj).f37247a + ']';
            }
            if (!(obj instanceof j0)) {
                if (!(obj instanceof C0494d)) {
                    throw new IllegalStateException(l0.C("Illegal state ", obj).toString());
                }
                return "Mutex[" + ((C0494d) obj).f37261d + ']';
            }
            ((j0) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.e
    public <R> void y(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.e Object obj, @a7.d p<? super kotlinx.coroutines.sync.c, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        while (!fVar.E()) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj2;
                if (bVar.f37247a != kotlinx.coroutines.sync.e.f37272d) {
                    androidx.concurrent.futures.b.a(f37248a, this, obj2, new C0494d(bVar.f37247a));
                } else {
                    Object objE0 = fVar.e0(new e(this, obj));
                    if (objE0 == null) {
                        r5.b.d(pVar, this, fVar.G());
                        return;
                    } else {
                        if (objE0 == kotlinx.coroutines.selects.g.d()) {
                            return;
                        }
                        if (objE0 != kotlinx.coroutines.sync.e.f37269a && objE0 != kotlinx.coroutines.internal.c.f36965b) {
                            throw new IllegalStateException(l0.C("performAtomicTrySelect(TryLockDesc) returned ", objE0).toString());
                        }
                    }
                }
            } else if (obj2 instanceof C0494d) {
                C0494d c0494d = (C0494d) obj2;
                if (!(c0494d.f37261d != obj)) {
                    throw new IllegalStateException(l0.C("Already locked by ", obj).toString());
                }
                b bVar2 = new b(obj, fVar, pVar);
                c0494d.v0(bVar2);
                if (this._state == obj2 || !bVar2.W0()) {
                    fVar.o0(bVar2);
                    return;
                }
            } else {
                if (!(obj2 instanceof j0)) {
                    throw new IllegalStateException(l0.C("Illegal state ", obj2).toString());
                }
                ((j0) obj2).c(this);
            }
        }
    }
}
