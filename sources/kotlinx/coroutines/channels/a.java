package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.q1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E> extends kotlinx.coroutines.channels.c<E> implements n<E> {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.a$a, reason: collision with other inner class name */
    private static final class C0445a<E> implements p<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final a<E> f35538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private Object f35539b = kotlinx.coroutines.channels.b.f35565f;

        public C0445a(@a7.d a<E> aVar) {
            this.f35538a = aVar;
        }

        private final boolean e(Object obj) throws Throwable {
            if (!(obj instanceof w)) {
                return true;
            }
            w wVar = (w) obj;
            if (wVar.f35875d == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.q0.p(wVar.c1());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object f(kotlin.coroutines.d<? super Boolean> dVar) {
            kotlinx.coroutines.r rVarB = kotlinx.coroutines.t.b(kotlin.coroutines.intrinsics.c.d(dVar));
            d dVar2 = new d(this, rVarB);
            while (true) {
                if (this.f35538a.b0(dVar2)) {
                    this.f35538a.q0(rVarB, dVar2);
                    break;
                }
                Object objM0 = this.f35538a.m0();
                g(objM0);
                if (objM0 instanceof w) {
                    w wVar = (w) objM0;
                    if (wVar.f35875d != null) {
                        d1.a aVar = d1.f34719b;
                        rVarB.w(d1.b(e1.a(wVar.c1())));
                        break;
                    }
                    d1.a aVar2 = d1.f34719b;
                    rVarB.w(d1.b(kotlin.coroutines.jvm.internal.b.a(false)));
                    break;
                }
                if (objM0 != kotlinx.coroutines.channels.b.f35565f) {
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(true);
                    i5.l<E, l2> lVar = this.f35538a.f35570a;
                    rVarB.x(boolA, lVar == null ? null : kotlinx.coroutines.internal.i0.a(lVar, objM0, rVarB.d()));
                    break;
                }
            }
            Object objZ = rVarB.z();
            if (objZ == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ;
        }

        @Override // kotlinx.coroutines.channels.p
        @a7.e
        public Object a(@a7.d kotlin.coroutines.d<? super Boolean> dVar) {
            Object objD = d();
            r0 r0Var = kotlinx.coroutines.channels.b.f35565f;
            if (objD != r0Var) {
                return kotlin.coroutines.jvm.internal.b.a(e(d()));
            }
            g(this.f35538a.m0());
            return d() != r0Var ? kotlin.coroutines.jvm.internal.b.a(e(d())) : f(dVar);
        }

        @Override // kotlinx.coroutines.channels.p
        @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @h5.h(name = "next")
        public /* synthetic */ Object b(kotlin.coroutines.d dVar) {
            return p.a.a(this, dVar);
        }

        @a7.e
        public final Object d() {
            return this.f35539b;
        }

        public final void g(@a7.e Object obj) {
            this.f35539b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.p
        public E next() throws Throwable {
            E e8 = (E) this.f35539b;
            if (e8 instanceof w) {
                throw kotlinx.coroutines.internal.q0.p(((w) e8).c1());
            }
            r0 r0Var = kotlinx.coroutines.channels.b.f35565f;
            if (e8 == r0Var) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f35539b = r0Var;
            return e8;
        }
    }

    private static class b<E> extends h0<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.q<Object> f35540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @h5.e
        public final int f35541e;

        public b(@a7.d kotlinx.coroutines.q<Object> qVar, int i7) {
            this.f35540d = qVar;
            this.f35541e = i7;
        }

        @Override // kotlinx.coroutines.channels.j0
        public void R(E e8) {
            this.f35540d.t0(kotlinx.coroutines.s.f37123d);
        }

        @Override // kotlinx.coroutines.channels.h0
        public void X0(@a7.d w<?> wVar) {
            if (this.f35541e == 1) {
                kotlinx.coroutines.q<Object> qVar = this.f35540d;
                d1.a aVar = d1.f34719b;
                qVar.w(d1.b(r.b(r.f35656b.a(wVar.f35875d))));
            } else {
                kotlinx.coroutines.q<Object> qVar2 = this.f35540d;
                d1.a aVar2 = d1.f34719b;
                qVar2.w(d1.b(e1.a(wVar.c1())));
            }
        }

        @a7.e
        public final Object Y0(E e8) {
            return this.f35541e == 1 ? r.b(r.f35656b.c(e8)) : e8;
        }

        @Override // kotlinx.coroutines.channels.j0
        @a7.e
        public r0 m0(E e8, @a7.e kotlinx.coroutines.internal.y.d dVar) {
            if (this.f35540d.c0(Y0(e8), dVar == null ? null : dVar.f37053c, W0(e8)) == null) {
                return null;
            }
            if (dVar != null) {
                dVar.d();
            }
            return kotlinx.coroutines.s.f37123d;
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "ReceiveElement@" + a1.b(this) + "[receiveMode=" + this.f35541e + ']';
        }
    }

    private static final class c<E> extends b<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        @h5.e
        public final i5.l<E, l2> f35542f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@a7.d kotlinx.coroutines.q<Object> qVar, int i7, @a7.d i5.l<? super E, l2> lVar) {
            super(qVar, i7);
            this.f35542f = lVar;
        }

        @Override // kotlinx.coroutines.channels.h0
        @a7.e
        public i5.l<Throwable, l2> W0(E e8) {
            return kotlinx.coroutines.internal.i0.a(this.f35542f, e8, this.f35540d.d());
        }
    }

    private static class d<E> extends h0<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public final C0445a<E> f35543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.q<Boolean> f35544e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@a7.d C0445a<E> c0445a, @a7.d kotlinx.coroutines.q<? super Boolean> qVar) {
            this.f35543d = c0445a;
            this.f35544e = qVar;
        }

        @Override // kotlinx.coroutines.channels.j0
        public void R(E e8) {
            this.f35543d.g(e8);
            this.f35544e.t0(kotlinx.coroutines.s.f37123d);
        }

        @Override // kotlinx.coroutines.channels.h0
        @a7.e
        public i5.l<Throwable, l2> W0(E e8) {
            i5.l<E, l2> lVar = this.f35543d.f35538a.f35570a;
            if (lVar == null) {
                return null;
            }
            return kotlinx.coroutines.internal.i0.a(lVar, e8, this.f35544e.d());
        }

        @Override // kotlinx.coroutines.channels.h0
        public void X0(@a7.d w<?> wVar) {
            Object objB = wVar.f35875d == null ? kotlinx.coroutines.q.a.b(this.f35544e, Boolean.FALSE, null, 2, null) : this.f35544e.J(wVar.c1());
            if (objB != null) {
                this.f35543d.g(wVar);
                this.f35544e.t0(objB);
            }
        }

        @Override // kotlinx.coroutines.channels.j0
        @a7.e
        public r0 m0(E e8, @a7.e kotlinx.coroutines.internal.y.d dVar) {
            if (this.f35544e.c0(Boolean.TRUE, dVar == null ? null : dVar.f37053c, W0(e8)) == null) {
                return null;
            }
            if (dVar != null) {
                dVar.d();
            }
            return kotlinx.coroutines.s.f37123d;
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return kotlin.jvm.internal.l0.C("ReceiveHasNext@", a1.b(this));
        }
    }

    private static final class e<R, E> extends h0<E> implements q1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public final a<E> f35545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.selects.f<R> f35546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        @h5.e
        public final i5.p<Object, kotlin.coroutines.d<? super R>, Object> f35547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @h5.e
        public final int f35548g;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@a7.d a<E> aVar, @a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<Object, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, int i7) {
            this.f35545d = aVar;
            this.f35546e = fVar;
            this.f35547f = pVar;
            this.f35548g = i7;
        }

        @Override // kotlinx.coroutines.q1
        public void F() {
            if (O0()) {
                this.f35545d.k0();
            }
        }

        @Override // kotlinx.coroutines.channels.j0
        public void R(E e8) throws Throwable {
            r5.a.d(this.f35547f, this.f35548g == 1 ? r.b(r.f35656b.c(e8)) : e8, this.f35546e.G(), W0(e8));
        }

        @Override // kotlinx.coroutines.channels.h0
        @a7.e
        public i5.l<Throwable, l2> W0(E e8) {
            i5.l<E, l2> lVar = this.f35545d.f35570a;
            if (lVar == null) {
                return null;
            }
            return kotlinx.coroutines.internal.i0.a(lVar, e8, this.f35546e.G().d());
        }

        @Override // kotlinx.coroutines.channels.h0
        public void X0(@a7.d w<?> wVar) throws Throwable {
            if (this.f35546e.q()) {
                int i7 = this.f35548g;
                if (i7 == 0) {
                    this.f35546e.Z(wVar.c1());
                } else {
                    if (i7 != 1) {
                        return;
                    }
                    r5.a.f(this.f35547f, r.b(r.f35656b.a(wVar.f35875d)), this.f35546e.G(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.channels.j0
        @a7.e
        public r0 m0(E e8, @a7.e kotlinx.coroutines.internal.y.d dVar) {
            return (r0) this.f35546e.g(dVar);
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "ReceiveSelect@" + a1.b(this) + '[' + this.f35546e + ",receiveMode=" + this.f35548g + ']';
        }
    }

    private final class f extends kotlinx.coroutines.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final h0<?> f35549a;

        public f(h0<?> h0Var) {
            this.f35549a = h0Var;
        }

        @Override // kotlinx.coroutines.p
        public void b(@a7.e Throwable th) {
            if (this.f35549a.O0()) {
                a.this.k0();
            }
        }

        @a7.d
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f35549a + ']';
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    protected static final class g<E> extends kotlinx.coroutines.internal.y.e<l0> {
        public g(@a7.d kotlinx.coroutines.internal.w wVar) {
            super(wVar);
        }

        @Override // kotlinx.coroutines.internal.y.e, kotlinx.coroutines.internal.y.a
        @a7.e
        protected Object e(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (yVar instanceof w) {
                return yVar;
            }
            if (yVar instanceof l0) {
                return null;
            }
            return kotlinx.coroutines.channels.b.f35565f;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        public Object j(@a7.d kotlinx.coroutines.internal.y.d dVar) {
            r0 r0VarY0 = ((l0) dVar.f37051a).Y0(dVar);
            if (r0VarY0 == null) {
                return kotlinx.coroutines.internal.z.f37060a;
            }
            Object obj = kotlinx.coroutines.internal.c.f36965b;
            if (r0VarY0 == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.y.a
        public void k(@a7.d kotlinx.coroutines.internal.y yVar) {
            ((l0) yVar).Z0();
        }
    }

    public static final class h extends kotlinx.coroutines.internal.y.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.y f35551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f35552e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(kotlinx.coroutines.internal.y yVar, a aVar) {
            super(yVar);
            this.f35551d = yVar;
            this.f35552e = aVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (this.f35552e.g0()) {
                return null;
            }
            return kotlinx.coroutines.internal.x.a();
        }
    }

    public static final class i implements kotlinx.coroutines.selects.d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<E> f35553a;

        i(a<E> aVar) {
            this.f35553a = aVar;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void h(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
            this.f35553a.p0(fVar, 0, pVar);
        }
    }

    public static final class j implements kotlinx.coroutines.selects.d<r<? extends E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a<E> f35554a;

        j(a<E> aVar) {
            this.f35554a = aVar;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void h(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super r<? extends E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
            this.f35554a.p0(fVar, 1, pVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {}, l = {633}, m = "receiveCatching-JP2dKIU", n = {}, s = {})
    static final class k extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f35555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a<E> f35556e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f35557f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(a<E> aVar, kotlin.coroutines.d<? super k> dVar) {
            super(dVar);
            this.f35556e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35555d = obj;
            this.f35557f |= Integer.MIN_VALUE;
            Object objS = this.f35556e.s(this);
            return objS == kotlin.coroutines.intrinsics.d.h() ? objS : r.b(objS);
        }
    }

    public a(@a7.e i5.l<? super E, l2> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b0(h0<? super E> h0Var) {
        boolean zC0 = c0(h0Var);
        if (zC0) {
            l0();
        }
        return zC0;
    }

    private final <R> boolean d0(kotlinx.coroutines.selects.f<? super R> fVar, i5.p<Object, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, int i7) {
        e eVar = new e(this, fVar, pVar, i7);
        boolean zB0 = b0(eVar);
        if (zB0) {
            fVar.o0(eVar);
        }
        return zB0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Object o0(int i7, kotlin.coroutines.d<? super R> dVar) {
        kotlinx.coroutines.r rVarB = kotlinx.coroutines.t.b(kotlin.coroutines.intrinsics.c.d(dVar));
        b bVar = this.f35570a == null ? new b(rVarB, i7) : new c(rVarB, i7, this.f35570a);
        while (true) {
            if (b0(bVar)) {
                q0(rVarB, bVar);
                break;
            }
            Object objM0 = m0();
            if (objM0 instanceof w) {
                bVar.X0((w) objM0);
                break;
            }
            if (objM0 != kotlinx.coroutines.channels.b.f35565f) {
                rVarB.x(bVar.Y0(objM0), bVar.W0(objM0));
                break;
            }
        }
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void p0(kotlinx.coroutines.selects.f<? super R> fVar, int i7, i5.p<Object, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
        while (!fVar.E()) {
            if (!h0()) {
                Object objN0 = n0(fVar);
                if (objN0 == kotlinx.coroutines.selects.g.d()) {
                    return;
                }
                if (objN0 != kotlinx.coroutines.channels.b.f35565f && objN0 != kotlinx.coroutines.internal.c.f36965b) {
                    r0(pVar, fVar, i7, objN0);
                }
            } else if (d0(fVar, pVar, i7)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(kotlinx.coroutines.q<?> qVar, h0<?> h0Var) {
        qVar.i0(new f(h0Var));
    }

    private final <R> void r0(i5.p<Object, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlinx.coroutines.selects.f<? super R> fVar, int i7, Object obj) throws Throwable {
        boolean z7 = obj instanceof w;
        if (!z7) {
            if (i7 != 1) {
                r5.b.d(pVar, obj, fVar.G());
                return;
            } else {
                r.b bVar = r.f35656b;
                r5.b.d(pVar, r.b(z7 ? bVar.a(((w) obj).f35875d) : bVar.c(obj)), fVar.G());
                return;
            }
        }
        if (i7 == 0) {
            throw kotlinx.coroutines.internal.q0.p(((w) obj).c1());
        }
        if (i7 == 1 && fVar.q()) {
            r5.b.d(pVar, r.b(r.f35656b.a(((w) obj).f35875d)), fVar.G());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.i0
    @a7.e
    public final Object A(@a7.d kotlin.coroutines.d<? super E> dVar) {
        Object objM0 = m0();
        return (objM0 == kotlinx.coroutines.channels.b.f35565f || (objM0 instanceof w)) ? o0(0, dVar) : objM0;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.e
    protected j0<E> T() {
        j0<E> j0VarT = super.T();
        if (j0VarT != null && !(j0VarT instanceof w)) {
            k0();
        }
        return j0VarT;
    }

    @Override // kotlinx.coroutines.channels.i0
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final boolean e(@a7.e Throwable th) {
        boolean zB = B(th);
        i0(zB);
        return zB;
    }

    @a7.d
    protected final g<E> a0() {
        return new g<>(v());
    }

    @Override // kotlinx.coroutines.channels.i0
    public final void c(@a7.e CancellationException cancellationException) {
        if (j()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(kotlin.jvm.internal.l0.C(a1.a(this), " was cancelled"));
        }
        e(cancellationException);
    }

    protected boolean c0(@a7.d h0<? super E> h0Var) {
        int iT0;
        kotlinx.coroutines.internal.y yVarI0;
        if (!f0()) {
            kotlinx.coroutines.internal.y yVarV = v();
            h hVar = new h(h0Var, this);
            do {
                kotlinx.coroutines.internal.y yVarI1 = yVarV.I0();
                if (!(!(yVarI1 instanceof l0))) {
                    return false;
                }
                iT0 = yVarI1.T0(h0Var, yVarV, hVar);
                if (iT0 != 1) {
                }
            } while (iT0 != 2);
            return false;
        }
        kotlinx.coroutines.internal.y yVarV2 = v();
        do {
            yVarI0 = yVarV2.I0();
            if (!(!(yVarI0 instanceof l0))) {
                return false;
            }
        } while (!yVarI0.z0(h0Var, yVarV2));
        return true;
    }

    @Override // kotlinx.coroutines.channels.i0
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        c(null);
    }

    protected final boolean e0() {
        return v().H0() instanceof j0;
    }

    protected abstract boolean f0();

    protected abstract boolean g0();

    protected final boolean h0() {
        return !(v().H0() instanceof l0) && g0();
    }

    protected void i0(boolean z7) {
        w<?> wVarU = u();
        if (wVarU == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objC = kotlinx.coroutines.internal.q.c(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.y yVarI0 = wVarU.I0();
            if (yVarI0 instanceof kotlinx.coroutines.internal.w) {
                j0(objC, wVarU);
                return;
            } else if (yVarI0.O0()) {
                objC = kotlinx.coroutines.internal.q.h(objC, (l0) yVarI0);
            } else {
                yVarI0.J0();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.i0
    public boolean isEmpty() {
        return h0();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public final p<E> iterator() {
        return new C0445a(this);
    }

    @Override // kotlinx.coroutines.channels.i0
    public boolean j() {
        return t() != null && g0();
    }

    protected void j0(@a7.d Object obj, @a7.d w<?> wVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((l0) obj).X0(wVar);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i7 = size - 1;
            ((l0) arrayList.get(size)).X0(wVar);
            if (i7 < 0) {
                return;
            } else {
                size = i7;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public final kotlinx.coroutines.selects.d<E> k() {
        return new i(this);
    }

    protected void k0() {
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public final kotlinx.coroutines.selects.d<r<E>> l() {
        return new j(this);
    }

    protected void l0() {
    }

    @a7.e
    protected Object m0() {
        while (true) {
            l0 l0VarU = U();
            if (l0VarU == null) {
                return kotlinx.coroutines.channels.b.f35565f;
            }
            if (l0VarU.Y0(null) != null) {
                l0VarU.V0();
                return l0VarU.W0();
            }
            l0VarU.Z0();
        }
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public kotlinx.coroutines.selects.d<E> n() {
        return n.a.b(this);
    }

    @a7.e
    protected Object n0(@a7.d kotlinx.coroutines.selects.f<?> fVar) {
        g<E> gVarA0 = a0();
        Object objE0 = fVar.e0(gVarA0);
        if (objE0 != null) {
            return objE0;
        }
        gVarA0.o().V0();
        return gVarA0.o().W0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public final Object o() {
        Object objM0 = m0();
        if (objM0 == kotlinx.coroutines.channels.b.f35565f) {
            return r.f35656b.b();
        }
        return objM0 instanceof w ? r.f35656b.a(((w) objM0).f35875d) : r.f35656b.c(objM0);
    }

    @Override // kotlinx.coroutines.channels.i0
    @kotlin.internal.h
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
    @a7.e
    public Object p(@a7.d kotlin.coroutines.d<? super E> dVar) {
        return n.a.e(this, dVar);
    }

    @Override // kotlinx.coroutines.channels.i0
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
    @a7.e
    public E poll() {
        return (E) n.a.d(this);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.i0
    @a7.e
    public final Object s(@a7.d kotlin.coroutines.d<? super r<? extends E>> dVar) {
        k kVar;
        if (dVar instanceof k) {
            kVar = (k) dVar;
            int i7 = kVar.f35557f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                kVar.f35557f = i7 - Integer.MIN_VALUE;
            } else {
                kVar = new k(this, dVar);
            }
        } else {
            kVar = new k(this, dVar);
        }
        Object objO0 = kVar.f35555d;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = kVar.f35557f;
        if (i8 == 0) {
            e1.n(objO0);
            Object objM0 = m0();
            if (objM0 != kotlinx.coroutines.channels.b.f35565f) {
                return objM0 instanceof w ? r.f35656b.a(((w) objM0).f35875d) : r.f35656b.c(objM0);
            }
            kVar.f35557f = 1;
            objO0 = o0(1, kVar);
            if (objO0 == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(objO0);
        }
        return ((r) objO0).o();
    }
}
