package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.e1;
import kotlin.jvm.internal.t1;
import kotlin.l2;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.d1;
import kotlinx.coroutines.internal.r0;
import kotlinx.coroutines.q1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<E> implements m0<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f35569c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    @a7.e
    protected final i5.l<E, l2> f35570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.internal.w f35571b = new kotlinx.coroutines.internal.w();

    @a7.d
    private volatile /* synthetic */ Object onCloseHandler = null;

    public static final class a<E> extends l0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @h5.e
        public final E f35572d;

        public a(E e8) {
            this.f35572d = e8;
        }

        @Override // kotlinx.coroutines.channels.l0
        public void V0() {
        }

        @Override // kotlinx.coroutines.channels.l0
        @a7.e
        public Object W0() {
            return this.f35572d;
        }

        @Override // kotlinx.coroutines.channels.l0
        public void X0(@a7.d w<?> wVar) {
        }

        @Override // kotlinx.coroutines.channels.l0
        @a7.e
        public r0 Y0(@a7.e kotlinx.coroutines.internal.y.d dVar) {
            r0 r0Var = kotlinx.coroutines.s.f37123d;
            if (dVar != null) {
                dVar.d();
            }
            return r0Var;
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "SendBuffered@" + a1.b(this) + '(' + this.f35572d + ')';
        }
    }

    private static class b<E> extends kotlinx.coroutines.internal.y.b<a<? extends E>> {
        public b(@a7.d kotlinx.coroutines.internal.w wVar, E e8) {
            super(wVar, new a(e8));
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        protected Object e(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (yVar instanceof w) {
                return yVar;
            }
            if (yVar instanceof j0) {
                return kotlinx.coroutines.channels.b.f35564e;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.c$c, reason: collision with other inner class name */
    private static final class C0446c<E, R> extends l0 implements q1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final E f35573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        @h5.e
        public final c<E> f35574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.selects.f<R> f35575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        @h5.e
        public final i5.p<m0<? super E>, kotlin.coroutines.d<? super R>, Object> f35576g;

        /* JADX WARN: Multi-variable type inference failed */
        public C0446c(E e8, @a7.d c<E> cVar, @a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            this.f35573d = e8;
            this.f35574e = cVar;
            this.f35575f = fVar;
            this.f35576g = pVar;
        }

        @Override // kotlinx.coroutines.q1
        public void F() {
            if (O0()) {
                Z0();
            }
        }

        @Override // kotlinx.coroutines.channels.l0
        public void V0() throws Throwable {
            r5.a.f(this.f35576g, this.f35574e, this.f35575f.G(), null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.l0
        public E W0() {
            return this.f35573d;
        }

        @Override // kotlinx.coroutines.channels.l0
        public void X0(@a7.d w<?> wVar) {
            if (this.f35575f.q()) {
                this.f35575f.Z(wVar.d1());
            }
        }

        @Override // kotlinx.coroutines.channels.l0
        @a7.e
        public r0 Y0(@a7.e kotlinx.coroutines.internal.y.d dVar) {
            return (r0) this.f35575f.g(dVar);
        }

        @Override // kotlinx.coroutines.channels.l0
        public void Z0() {
            i5.l<E, l2> lVar = this.f35574e.f35570a;
            if (lVar == null) {
                return;
            }
            kotlinx.coroutines.internal.i0.b(lVar, W0(), this.f35575f.G().d());
        }

        @Override // kotlinx.coroutines.internal.y
        @a7.d
        public String toString() {
            return "SendSelect@" + a1.b(this) + '(' + W0() + ")[" + this.f35574e + ", " + this.f35575f + ']';
        }
    }

    protected static final class d<E> extends kotlinx.coroutines.internal.y.e<j0<? super E>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @h5.e
        public final E f35577e;

        public d(E e8, @a7.d kotlinx.coroutines.internal.w wVar) {
            super(wVar);
            this.f35577e = e8;
        }

        @Override // kotlinx.coroutines.internal.y.e, kotlinx.coroutines.internal.y.a
        @a7.e
        protected Object e(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (yVar instanceof w) {
                return yVar;
            }
            if (yVar instanceof j0) {
                return null;
            }
            return kotlinx.coroutines.channels.b.f35564e;
        }

        @Override // kotlinx.coroutines.internal.y.a
        @a7.e
        public Object j(@a7.d kotlinx.coroutines.internal.y.d dVar) {
            r0 r0VarM0 = ((j0) dVar.f37051a).m0(this.f35577e, dVar);
            if (r0VarM0 == null) {
                return kotlinx.coroutines.internal.z.f37060a;
            }
            Object obj = kotlinx.coroutines.internal.c.f36965b;
            if (r0VarM0 == obj) {
                return obj;
            }
            return null;
        }
    }

    public static final class e extends kotlinx.coroutines.internal.y.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.y f35578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f35579e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kotlinx.coroutines.internal.y yVar, c cVar) {
            super(yVar);
            this.f35578d = yVar;
            this.f35579e = cVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (this.f35579e.H()) {
                return null;
            }
            return kotlinx.coroutines.internal.x.a();
        }
    }

    public static final class f implements kotlinx.coroutines.selects.e<E, m0<? super E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<E> f35580a;

        f(c<E> cVar) {
            this.f35580a = cVar;
        }

        @Override // kotlinx.coroutines.selects.e
        public <R> void y(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, E e8, @a7.d i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
            this.f35580a.N(fVar, e8, pVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@a7.e i5.l<? super E, l2> lVar) {
        this.f35570a = lVar;
    }

    private final Throwable C(w<?> wVar) {
        x(wVar);
        return wVar.d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(kotlin.coroutines.d<?> dVar, E e8, w<?> wVar) {
        d1 d1VarD;
        x(wVar);
        Throwable thD1 = wVar.d1();
        i5.l<E, l2> lVar = this.f35570a;
        if (lVar == null || (d1VarD = kotlinx.coroutines.internal.i0.d(lVar, e8, null, 2, null)) == null) {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            dVar.w(kotlin.d1.b(e1.a(thD1)));
        } else {
            kotlin.p.a(d1VarD, thD1);
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            dVar.w(kotlin.d1.b(e1.a(d1VarD)));
        }
    }

    private final void E(Throwable th) {
        r0 r0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (r0Var = kotlinx.coroutines.channels.b.f35567h) || !androidx.concurrent.futures.b.a(f35569c, this, obj, r0Var)) {
            return;
        }
        ((i5.l) t1.q(obj, 1)).z(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I() {
        return !(this.f35571b.H0() instanceof j0) && H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void N(kotlinx.coroutines.selects.f<? super R> fVar, E e8, i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
        while (!fVar.E()) {
            if (I()) {
                C0446c c0446c = new C0446c(e8, this, fVar, pVar);
                Object objQ = q(c0446c);
                if (objQ == null) {
                    fVar.o0(c0446c);
                    return;
                }
                if (objQ instanceof w) {
                    throw kotlinx.coroutines.internal.q0.p(y(e8, (w) objQ));
                }
                if (objQ != kotlinx.coroutines.channels.b.f35566g && !(objQ instanceof h0)) {
                    throw new IllegalStateException(("enqueueSend returned " + objQ + ' ').toString());
                }
            }
            Object objK = K(e8, fVar);
            if (objK == kotlinx.coroutines.selects.g.d()) {
                return;
            }
            if (objK != kotlinx.coroutines.channels.b.f35564e && objK != kotlinx.coroutines.internal.c.f36965b) {
                if (objK == kotlinx.coroutines.channels.b.f35563d) {
                    r5.b.d(pVar, this, fVar.G());
                    return;
                } else {
                    if (!(objK instanceof w)) {
                        throw new IllegalStateException(kotlin.jvm.internal.l0.C("offerSelectInternal returned ", objK).toString());
                    }
                    throw kotlinx.coroutines.internal.q0.p(y(e8, (w) objK));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a A[EDGE_INSN: B:31:0x006a->B:32:0x006f BREAK  A[LOOP:0: B:3:0x0008->B:47:?]] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:3:0x0008->B:47:?, LOOP_END, SYNTHETIC] */
    public final Object P(E e8, kotlin.coroutines.d<? super l2> dVar) {
        Object objJ;
        kotlinx.coroutines.r rVarB = kotlinx.coroutines.t.b(kotlin.coroutines.intrinsics.c.d(dVar));
        while (true) {
            if (I()) {
                l0 n0Var = this.f35570a == null ? new n0(e8, rVarB) : new o0(e8, rVarB, this.f35570a);
                Object objQ = q(n0Var);
                if (objQ == null) {
                    kotlinx.coroutines.t.c(rVarB, n0Var);
                    break;
                }
                if (objQ instanceof w) {
                    D(rVarB, e8, (w) objQ);
                    break;
                }
                if (objQ != kotlinx.coroutines.channels.b.f35566g && !(objQ instanceof h0)) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("enqueueSend returned ", objQ).toString());
                }
                objJ = J(e8);
                if (objJ == kotlinx.coroutines.channels.b.f35563d) {
                    kotlin.d1.a aVar = kotlin.d1.f34719b;
                    rVarB.w(kotlin.d1.b(l2.f34958a));
                    break;
                }
                if (objJ == kotlinx.coroutines.channels.b.f35564e) {
                    if (objJ instanceof w) {
                        throw new IllegalStateException(kotlin.jvm.internal.l0.C("offerInternal returned ", objJ).toString());
                    }
                    D(rVarB, e8, (w) objJ);
                    break;
                }
            } else {
                objJ = J(e8);
                if (objJ == kotlinx.coroutines.channels.b.f35563d) {
                    kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                    rVarB.w(kotlin.d1.b(l2.f34958a));
                    break;
                }
                if (objJ == kotlinx.coroutines.channels.b.f35564e) {
                    if (objJ instanceof w) {
                        throw new IllegalStateException(kotlin.jvm.internal.l0.C("offerInternal returned ", objJ).toString());
                    }
                    D(rVarB, e8, (w) objJ);
                    break;
                }
            }
        }
        Object objZ = rVarB.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2.f34958a;
    }

    private final int h() {
        kotlinx.coroutines.internal.w wVar = this.f35571b;
        int i7 = 0;
        for (kotlinx.coroutines.internal.y yVarH0 = (kotlinx.coroutines.internal.y) wVar.G0(); !kotlin.jvm.internal.l0.g(yVarH0, wVar); yVarH0 = yVarH0.H0()) {
            if (yVarH0 instanceof kotlinx.coroutines.internal.y) {
                i7++;
            }
        }
        return i7;
    }

    private final String w() {
        String strC;
        kotlinx.coroutines.internal.y yVarH0 = this.f35571b.H0();
        if (yVarH0 == this.f35571b) {
            return "EmptyQueue";
        }
        if (yVarH0 instanceof w) {
            strC = yVarH0.toString();
        } else if (yVarH0 instanceof h0) {
            strC = "ReceiveQueued";
        } else {
            strC = yVarH0 instanceof l0 ? "SendQueued" : kotlin.jvm.internal.l0.C("UNEXPECTED:", yVarH0);
        }
        kotlinx.coroutines.internal.y yVarI0 = this.f35571b.I0();
        if (yVarI0 == yVarH0) {
            return strC;
        }
        String str = strC + ",queueSize=" + h();
        if (!(yVarI0 instanceof w)) {
            return str;
        }
        return str + ",closedForSend=" + yVarI0;
    }

    private final void x(w<?> wVar) {
        Object objC = kotlinx.coroutines.internal.q.c(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.y yVarI0 = wVar.I0();
            h0 h0Var = yVarI0 instanceof h0 ? (h0) yVarI0 : null;
            if (h0Var == null) {
                break;
            } else if (h0Var.O0()) {
                objC = kotlinx.coroutines.internal.q.h(objC, h0Var);
            } else {
                h0Var.J0();
            }
        }
        if (objC != null) {
            if (objC instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objC;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i7 = size - 1;
                        ((h0) arrayList.get(size)).X0(wVar);
                        if (i7 < 0) {
                            break;
                        } else {
                            size = i7;
                        }
                    }
                }
            } else {
                ((h0) objC).X0(wVar);
            }
        }
        L(wVar);
    }

    private final Throwable y(E e8, w<?> wVar) {
        d1 d1VarD;
        x(wVar);
        i5.l<E, l2> lVar = this.f35570a;
        if (lVar == null || (d1VarD = kotlinx.coroutines.internal.i0.d(lVar, e8, null, 2, null)) == null) {
            return wVar.d1();
        }
        kotlin.p.a(d1VarD, wVar.d1());
        throw d1VarD;
    }

    @Override // kotlinx.coroutines.channels.m0
    /* JADX INFO: renamed from: B */
    public boolean e(@a7.e Throwable th) {
        kotlinx.coroutines.internal.y yVarI0;
        boolean z7;
        w<?> wVar = new w<>(th);
        kotlinx.coroutines.internal.y yVar = this.f35571b;
        do {
            yVarI0 = yVar.I0();
            z7 = true;
            if (!(!(yVarI0 instanceof w))) {
                z7 = false;
                break;
            }
        } while (!yVarI0.z0(wVar, yVar));
        if (!z7) {
            wVar = (w) this.f35571b.I0();
        }
        x(wVar);
        if (z7) {
            E(th);
        }
        return z7;
    }

    protected abstract boolean F();

    protected abstract boolean H();

    @a7.d
    protected Object J(E e8) {
        j0<E> j0VarT;
        do {
            j0VarT = T();
            if (j0VarT == null) {
                return kotlinx.coroutines.channels.b.f35564e;
            }
        } while (j0VarT.m0(e8, null) == null);
        j0VarT.R(e8);
        return j0VarT.j();
    }

    @a7.d
    protected Object K(E e8, @a7.d kotlinx.coroutines.selects.f<?> fVar) {
        d<E> dVarM = m(e8);
        Object objE0 = fVar.e0(dVarM);
        if (objE0 != null) {
            return objE0;
        }
        j0<? super E> j0VarO = dVarM.o();
        j0VarO.R(e8);
        return j0VarO.j();
    }

    protected void L(@a7.d kotlinx.coroutines.internal.y yVar) {
    }

    @Override // kotlinx.coroutines.channels.m0
    public void M(@a7.d i5.l<? super Throwable, l2> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f35569c;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj != kotlinx.coroutines.channels.b.f35567h) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        w<?> wVarU = u();
        if (wVarU == null || !androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, lVar, kotlinx.coroutines.channels.b.f35567h)) {
            return;
        }
        lVar.z(wVarU.f35875d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.e
    protected final j0<?> O(E e8) {
        kotlinx.coroutines.internal.y yVarI0;
        kotlinx.coroutines.internal.w wVar = this.f35571b;
        a aVar = new a(e8);
        do {
            yVarI0 = wVar.I0();
            if (yVarI0 instanceof j0) {
                return (j0) yVarI0;
            }
        } while (!yVarI0.z0(aVar, wVar));
        return null;
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public final Object Q(E e8) {
        Object objJ = J(e8);
        if (objJ == kotlinx.coroutines.channels.b.f35563d) {
            return r.f35656b.c(l2.f34958a);
        }
        if (objJ == kotlinx.coroutines.channels.b.f35564e) {
            w<?> wVarU = u();
            return wVarU == null ? r.f35656b.b() : r.f35656b.a(C(wVarU));
        }
        if (objJ instanceof w) {
            return r.f35656b.a(C((w) objJ));
        }
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("trySend returned ", objJ).toString());
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.e
    public final Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        if (J(e8) == kotlinx.coroutines.channels.b.f35563d) {
            return l2.f34958a;
        }
        Object objP = P(e8, dVar);
        return objP == kotlin.coroutines.intrinsics.d.h() ? objP : l2.f34958a;
    }

    @Override // kotlinx.coroutines.channels.m0
    public final boolean S() {
        return u() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.y] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @a7.e
    protected j0<E> T() {
        ?? r7;
        kotlinx.coroutines.internal.y yVarR0;
        kotlinx.coroutines.internal.w wVar = this.f35571b;
        while (true) {
            r7 = (kotlinx.coroutines.internal.y) wVar.G0();
            if (r7 == wVar || !(r7 instanceof j0)) {
                break;
            }
            if ((!(((j0) r7) instanceof w) || r7.L0()) && (yVarR0 = r7.R0()) != null) {
                yVarR0.K0();
            }
            return (j0) r7;
        }
        r7 = 0;
        return (j0) r7;
    }

    @a7.e
    protected final l0 U() {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVarR0;
        kotlinx.coroutines.internal.w wVar = this.f35571b;
        while (true) {
            yVar = (kotlinx.coroutines.internal.y) wVar.G0();
            if (yVar == wVar || !(yVar instanceof l0)) {
                break;
            }
            if ((!(((l0) yVar) instanceof w) || yVar.L0()) && (yVarR0 = yVar.R0()) != null) {
                yVarR0.K0();
            }
            return (l0) yVar;
        }
        yVar = null;
        return (l0) yVar;
    }

    @a7.d
    protected final kotlinx.coroutines.internal.y.b<?> i(E e8) {
        return new b(this.f35571b, e8);
    }

    @a7.d
    protected final d<E> m(E e8) {
        return new d<>(e8, this.f35571b);
    }

    @Override // kotlinx.coroutines.channels.m0
    public boolean offer(E e8) {
        d1 d1VarD;
        try {
            return m0.a.c(this, e8);
        } catch (Throwable th) {
            i5.l<E, l2> lVar = this.f35570a;
            if (lVar == null || (d1VarD = kotlinx.coroutines.internal.i0.d(lVar, e8, null, 2, null)) == null) {
                throw th;
            }
            kotlin.p.a(d1VarD, th);
            throw d1VarD;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x0039 A[ORIG_RETURN, RETURN] */
    @a7.e
    protected Object q(@a7.d l0 l0Var) {
        int iT0;
        boolean z7;
        kotlinx.coroutines.internal.y yVarI0;
        if (F()) {
            kotlinx.coroutines.internal.y yVar = this.f35571b;
            do {
                yVarI0 = yVar.I0();
                if (yVarI0 instanceof j0) {
                    return yVarI0;
                }
            } while (!yVarI0.z0(l0Var, yVar));
            return null;
        }
        kotlinx.coroutines.internal.y yVar2 = this.f35571b;
        e eVar = new e(l0Var, this);
        do {
            kotlinx.coroutines.internal.y yVarI1 = yVar2.I0();
            if (yVarI1 instanceof j0) {
                return yVarI1;
            }
            iT0 = yVarI1.T0(l0Var, yVar2, eVar);
            z7 = true;
            if (iT0 != 1) {
            }
            if (z7) {
                return null;
            }
            return kotlinx.coroutines.channels.b.f35566g;
        } while (iT0 != 2);
        z7 = false;
        if (z7) {
            return kotlinx.coroutines.channels.b.f35566g;
        }
        return null;
    }

    @a7.d
    protected String r() {
        return "";
    }

    @a7.e
    protected final w<?> t() {
        kotlinx.coroutines.internal.y yVarH0 = this.f35571b.H0();
        w<?> wVar = yVarH0 instanceof w ? (w) yVarH0 : null;
        if (wVar == null) {
            return null;
        }
        x(wVar);
        return wVar;
    }

    @a7.d
    public String toString() {
        return a1.a(this) + '@' + a1.b(this) + '{' + w() + '}' + r();
    }

    @a7.e
    protected final w<?> u() {
        kotlinx.coroutines.internal.y yVarI0 = this.f35571b.I0();
        w<?> wVar = yVarI0 instanceof w ? (w) yVarI0 : null;
        if (wVar == null) {
            return null;
        }
        x(wVar);
        return wVar;
    }

    @a7.d
    protected final kotlinx.coroutines.internal.w v() {
        return this.f35571b;
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public final kotlinx.coroutines.selects.e<E, m0<E>> z() {
        return new f(this);
    }
}
