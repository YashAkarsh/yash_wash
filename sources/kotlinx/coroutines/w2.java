package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.k(level = kotlin.m.ERROR, message = "This is internal API and may be removed in the future releases")
public class w2 implements o2, y, g3, kotlinx.coroutines.selects.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37339a = AtomicReferenceFieldUpdater.newUpdater(w2.class, Object.class, "_state");

    @a7.d
    private volatile /* synthetic */ Object _parentHandle;

    @a7.d
    private volatile /* synthetic */ Object _state;

    private static final class a<T> extends r<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @a7.d
        private final w2 f37340i;

        public a(@a7.d kotlin.coroutines.d<? super T> dVar, @a7.d w2 w2Var) {
            super(dVar, 1);
            this.f37340i = w2Var;
        }

        @Override // kotlinx.coroutines.r
        @a7.d
        protected String G() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.r
        @a7.d
        public Throwable y(@a7.d o2 o2Var) {
            Throwable thE;
            Object objN0 = this.f37340i.N0();
            if (!(objN0 instanceof c) || (thE = ((c) objN0).e()) == null) {
                return objN0 instanceof e0 ? ((e0) objN0).f35988a : o2Var.K();
            }
            return thE;
        }
    }

    private static final class b extends v2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        private final w2 f37341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        private final c f37342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @a7.d
        private final x f37343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @a7.e
        private final Object f37344h;

        public b(@a7.d w2 w2Var, @a7.d c cVar, @a7.d x xVar, @a7.e Object obj) {
            this.f37341e = w2Var;
            this.f37342f = cVar;
            this.f37343g = xVar;
            this.f37344h = obj;
        }

        @Override // kotlinx.coroutines.g0
        public void V0(@a7.e Throwable th) {
            this.f37341e.q0(this.f37342f, this.f37343g, this.f37344h);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
            V0(th);
            return kotlin.l2.f34958a;
        }
    }

    private static final class c implements h2 {

        @a7.d
        private volatile /* synthetic */ Object _exceptionsHolder = null;

        @a7.d
        private volatile /* synthetic */ int _isCompleting;

        @a7.d
        private volatile /* synthetic */ Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final b3 f37345a;

        public c(@a7.d b3 b3Var, boolean z7, @a7.e Throwable th) {
            this.f37345a = b3Var;
            this._isCompleting = z7 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return this._exceptionsHolder;
        }

        private final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // kotlinx.coroutines.h2
        @a7.d
        public b3 D() {
            return this.f37345a;
        }

        public final void a(@a7.d Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th);
                return;
            }
            if (!(objD instanceof Throwable)) {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("State is ", objD).toString());
                }
                ((ArrayList) objD).add(th);
            } else {
                if (th == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                k(arrayListC);
            }
        }

        @Override // kotlinx.coroutines.h2
        public boolean b() {
            return e() == null;
        }

        @a7.e
        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return d() == x2.f37371h;
        }

        @a7.d
        public final List<Throwable> i(@a7.e Throwable th) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("State is ", objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th != null && !kotlin.jvm.internal.l0.g(th, thE)) {
                arrayListC.add(th);
            }
            k(x2.f37371h);
            return arrayListC;
        }

        public final void j(boolean z7) {
            this._isCompleting = z7 ? 1 : 0;
        }

        public final void l(@a7.e Throwable th) {
            this._rootCause = th;
        }

        @a7.d
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + D() + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.y.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.y f37346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ w2 f37347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f37348f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.y yVar, w2 w2Var, Object obj) {
            super(yVar);
            this.f37346d = yVar;
            this.f37347e = w2Var;
            this.f37348f = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        @a7.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@a7.d kotlinx.coroutines.internal.y yVar) {
            if (this.f37347e.N0() == this.f37348f) {
                return null;
            }
            return kotlinx.coroutines.internal.x.a();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class e extends kotlin.coroutines.jvm.internal.k implements i5.p<kotlin.sequences.o<? super o2>, kotlin.coroutines.d<? super kotlin.l2>, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f37349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f37350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f37351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f37352f;

        e(kotlin.coroutines.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<kotlin.l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            e eVar = w2.this.new e(dVar);
            eVar.f37352f = obj;
            return eVar;
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0067  */
        /* JADX WARN: Code duplicated, block: B:25:0x006b  */
        /* JADX WARN: Code duplicated, block: B:27:0x007e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:28:0x007f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007c -> B:28:0x007f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r7.f37351e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r7.f37350d
                kotlinx.coroutines.internal.y r1 = (kotlinx.coroutines.internal.y) r1
                java.lang.Object r3 = r7.f37349c
                kotlinx.coroutines.internal.w r3 = (kotlinx.coroutines.internal.w) r3
                java.lang.Object r4 = r7.f37352f
                kotlin.sequences.o r4 = (kotlin.sequences.o) r4
                kotlin.e1.n(r8)
                r8 = r7
                goto L7f
            L1f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L27:
                kotlin.e1.n(r8)
                goto L84
            L2b:
                kotlin.e1.n(r8)
                java.lang.Object r8 = r7.f37352f
                kotlin.sequences.o r8 = (kotlin.sequences.o) r8
                kotlinx.coroutines.w2 r1 = kotlinx.coroutines.w2.this
                java.lang.Object r1 = r1.N0()
                boolean r4 = r1 instanceof kotlinx.coroutines.x
                if (r4 == 0) goto L49
                kotlinx.coroutines.x r1 = (kotlinx.coroutines.x) r1
                kotlinx.coroutines.y r1 = r1.f37357e
                r7.f37351e = r3
                java.lang.Object r8 = r8.a(r1, r7)
                if (r8 != r0) goto L84
                return r0
            L49:
                boolean r3 = r1 instanceof kotlinx.coroutines.h2
                if (r3 == 0) goto L84
                kotlinx.coroutines.h2 r1 = (kotlinx.coroutines.h2) r1
                kotlinx.coroutines.b3 r1 = r1.D()
                if (r1 != 0) goto L56
                goto L84
            L56:
                java.lang.Object r3 = r1.G0()
                kotlinx.coroutines.internal.y r3 = (kotlinx.coroutines.internal.y) r3
                r4 = r8
                r8 = r7
                r6 = r3
                r3 = r1
                r1 = r6
            L61:
                boolean r5 = kotlin.jvm.internal.l0.g(r1, r3)
                if (r5 != 0) goto L84
                boolean r5 = r1 instanceof kotlinx.coroutines.x
                if (r5 == 0) goto L7f
                r5 = r1
                kotlinx.coroutines.x r5 = (kotlinx.coroutines.x) r5
                kotlinx.coroutines.y r5 = r5.f37357e
                r8.f37352f = r4
                r8.f37349c = r3
                r8.f37350d = r1
                r8.f37351e = r2
                java.lang.Object r5 = r4.a(r5, r8)
                if (r5 != r0) goto L7f
                return r0
            L7f:
                kotlinx.coroutines.internal.y r1 = r1.H0()
                goto L61
            L84:
                kotlin.l2 r8 = kotlin.l2.f34958a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.w2.e.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlin.sequences.o<? super o2> oVar, @a7.e kotlin.coroutines.d<? super kotlin.l2> dVar) {
            return ((e) D(oVar, dVar)).R(kotlin.l2.f34958a);
        }
    }

    public w2(boolean z7) {
        this._state = z7 ? x2.f37373j : x2.f37372i;
        this._parentHandle = null;
    }

    private final Throwable D0(Object obj) {
        e0 e0Var = obj instanceof e0 ? (e0) obj : null;
        if (e0Var == null) {
            return null;
        }
        return e0Var.f35988a;
    }

    private final Throwable E0(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new p2(m0(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof z3) {
            for (Object obj2 : list) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof z3)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final b3 K0(h2 h2Var) {
        b3 b3VarD = h2Var.D();
        if (b3VarD != null) {
            return b3VarD;
        }
        if (h2Var instanceof t1) {
            return new b3();
        }
        if (!(h2Var instanceof v2)) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("State should have list: ", h2Var).toString());
        }
        l1((v2) h2Var);
        return null;
    }

    private final boolean S0(h2 h2Var) {
        return (h2Var instanceof c) && ((c) h2Var).f();
    }

    private final boolean V0() {
        Object objN0;
        do {
            objN0 = N0();
            if (!(objN0 instanceof h2)) {
                return false;
            }
        } while (q1(objN0) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W0(kotlin.coroutines.d<? super kotlin.l2> dVar) {
        r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        t.a(rVar, g0(new j3(rVar)));
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : kotlin.l2.f34958a;
    }

    private final boolean X(Object obj, b3 b3Var, v2 v2Var) {
        int iT0;
        d dVar = new d(v2Var, this, obj);
        do {
            iT0 = b3Var.I0().T0(v2Var, b3Var, dVar);
            if (iT0 == 1) {
                return true;
            }
        } while (iT0 != 2);
        return false;
    }

    private final Void X0(i5.l<Object, kotlin.l2> lVar) {
        while (true) {
            lVar.z(N0());
        }
    }

    private final void Y(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                kotlin.p.a(th, th2);
            }
        }
    }

    private final Object Y0(Object obj) throws Throwable {
        Throwable thS0 = null;
        while (true) {
            Object objN0 = N0();
            if (objN0 instanceof c) {
                synchronized (objN0) {
                    if (((c) objN0).h()) {
                        return x2.f37367d;
                    }
                    boolean zF = ((c) objN0).f();
                    if (obj != null || !zF) {
                        if (thS0 == null) {
                            thS0 = s0(obj);
                        }
                        ((c) objN0).a(thS0);
                    }
                    Throwable thE = zF ^ true ? ((c) objN0).e() : null;
                    if (thE != null) {
                        e1(((c) objN0).D(), thE);
                    }
                    return x2.f37364a;
                }
            }
            if (!(objN0 instanceof h2)) {
                return x2.f37367d;
            }
            if (thS0 == null) {
                thS0 = s0(obj);
            }
            h2 h2Var = (h2) objN0;
            if (!h2Var.b()) {
                Object objX1 = x1(objN0, new e0(thS0, false, 2, null));
                if (objX1 == x2.f37364a) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("Cannot happen in ", objN0).toString());
                }
                if (objX1 != x2.f37366c) {
                    return objX1;
                }
            } else if (w1(h2Var, thS0)) {
                return x2.f37364a;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b0(kotlin.coroutines.d<Object> dVar) {
        a aVar = new a(kotlin.coroutines.intrinsics.c.d(dVar), this);
        aVar.O();
        t.a(aVar, g0(new i3(aVar)));
        Object objZ = aVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    private final v2 b1(i5.l<? super Throwable, kotlin.l2> lVar, boolean z7) {
        v2 n2Var;
        if (z7) {
            n2Var = lVar instanceof q2 ? (q2) lVar : null;
            if (n2Var == null) {
                n2Var = new m2(lVar);
            }
        } else {
            v2 v2Var = lVar instanceof v2 ? (v2) lVar : null;
            n2Var = v2Var != null ? v2Var : null;
            if (n2Var == null) {
                n2Var = new n2(lVar);
            }
        }
        n2Var.X0(this);
        return n2Var;
    }

    private final x d1(kotlinx.coroutines.internal.y yVar) {
        while (yVar.L0()) {
            yVar = yVar.I0();
        }
        while (true) {
            yVar = yVar.H0();
            if (!yVar.L0()) {
                if (yVar instanceof x) {
                    return (x) yVar;
                }
                if (yVar instanceof b3) {
                    return null;
                }
            }
        }
    }

    private final void e1(b3 b3Var, Throwable th) throws Throwable {
        h0 h0Var;
        h1(th);
        h0 h0Var2 = null;
        for (kotlinx.coroutines.internal.y yVarH0 = (kotlinx.coroutines.internal.y) b3Var.G0(); !kotlin.jvm.internal.l0.g(yVarH0, b3Var); yVarH0 = yVarH0.H0()) {
            if (yVarH0 instanceof q2) {
                v2 v2Var = (v2) yVarH0;
                try {
                    v2Var.V0(th);
                } catch (Throwable th2) {
                    if (h0Var2 == null) {
                        h0Var = null;
                    } else {
                        kotlin.p.a(h0Var2, th2);
                        h0Var = h0Var2;
                    }
                    if (h0Var == null) {
                        h0Var2 = new h0("Exception in completion handler " + v2Var + " for " + this, th2);
                    }
                }
            }
        }
        if (h0Var2 != null) {
            P0(h0Var2);
        }
        k0(th);
    }

    private final void f1(b3 b3Var, Throwable th) throws Throwable {
        h0 h0Var;
        h0 h0Var2 = null;
        for (kotlinx.coroutines.internal.y yVarH0 = (kotlinx.coroutines.internal.y) b3Var.G0(); !kotlin.jvm.internal.l0.g(yVarH0, b3Var); yVarH0 = yVarH0.H0()) {
            if (yVarH0 instanceof v2) {
                v2 v2Var = (v2) yVarH0;
                try {
                    v2Var.V0(th);
                } catch (Throwable th2) {
                    if (h0Var2 == null) {
                        h0Var = null;
                    } else {
                        kotlin.p.a(h0Var2, th2);
                        h0Var = h0Var2;
                    }
                    if (h0Var == null) {
                        h0Var2 = new h0("Exception in completion handler " + v2Var + " for " + this, th2);
                    }
                }
            }
        }
        if (h0Var2 == null) {
            return;
        }
        P0(h0Var2);
    }

    private final /* synthetic */ <T extends v2> void g1(b3 b3Var, Throwable th) throws Throwable {
        h0 h0Var;
        h0 h0Var2 = null;
        for (kotlinx.coroutines.internal.y yVarH0 = (kotlinx.coroutines.internal.y) b3Var.G0(); !kotlin.jvm.internal.l0.g(yVarH0, b3Var); yVarH0 = yVarH0.H0()) {
            kotlin.jvm.internal.l0.y(3, "T");
            if (yVarH0 instanceof kotlinx.coroutines.internal.y) {
                v2 v2Var = (v2) yVarH0;
                try {
                    v2Var.V0(th);
                } catch (Throwable th2) {
                    if (h0Var2 == null) {
                        h0Var = null;
                    } else {
                        kotlin.p.a(h0Var2, th2);
                        h0Var = h0Var2;
                    }
                    if (h0Var == null) {
                        h0Var2 = new h0("Exception in completion handler " + v2Var + " for " + this, th2);
                    }
                }
            }
        }
        if (h0Var2 == null) {
            return;
        }
        P0(h0Var2);
    }

    private final Object j0(Object obj) {
        Object objX1;
        do {
            Object objN0 = N0();
            if (!(objN0 instanceof h2) || ((objN0 instanceof c) && ((c) objN0).g())) {
                return x2.f37364a;
            }
            objX1 = x1(objN0, new e0(s0(obj), false, 2, null));
        } while (objX1 == x2.f37366c);
        return objX1;
    }

    private final boolean k0(Throwable th) {
        if (U0()) {
            return true;
        }
        boolean z7 = th instanceof CancellationException;
        w wVarM0 = M0();
        if (wVarM0 == null || wVarM0 == d3.f35894a) {
            return z7;
        }
        return wVarM0.s(th) || z7;
    }

    private final void k1(t1 t1Var) {
        b3 b3Var = new b3();
        Object g2Var = b3Var;
        if (!t1Var.b()) {
            g2Var = new g2(b3Var);
        }
        androidx.concurrent.futures.b.a(f37339a, this, t1Var, g2Var);
    }

    private final void l1(v2 v2Var) {
        v2Var.A0(new b3());
        androidx.concurrent.futures.b.a(f37339a, this, v2Var, v2Var.H0());
    }

    private final void p0(h2 h2Var, Object obj) throws Throwable {
        w wVarM0 = M0();
        if (wVarM0 != null) {
            wVarM0.F();
            p1(d3.f35894a);
        }
        e0 e0Var = obj instanceof e0 ? (e0) obj : null;
        Throwable th = e0Var != null ? e0Var.f35988a : null;
        if (!(h2Var instanceof v2)) {
            b3 b3VarD = h2Var.D();
            if (b3VarD == null) {
                return;
            }
            f1(b3VarD, th);
            return;
        }
        try {
            ((v2) h2Var).V0(th);
        } catch (Throwable th2) {
            P0(new h0("Exception in completion handler " + h2Var + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(c cVar, x xVar, Object obj) {
        x xVarD1 = d1(xVar);
        if (xVarD1 == null || !z1(cVar, xVarD1, obj)) {
            Z(y0(cVar, obj));
        }
    }

    private final int q1(Object obj) {
        if (obj instanceof t1) {
            if (((t1) obj).b()) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f37339a, this, obj, x2.f37373j)) {
                return -1;
            }
            j1();
            return 1;
        }
        if (!(obj instanceof g2)) {
            return 0;
        }
        if (!androidx.concurrent.futures.b.a(f37339a, this, obj, ((g2) obj).D())) {
            return -1;
        }
        j1();
        return 1;
    }

    private final String r1(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof h2) {
                return ((h2) obj).b() ? "Active" : "New";
            }
            return obj instanceof e0 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        c cVar = (c) obj;
        if (cVar.f()) {
            return "Cancelling";
        }
        return cVar.g() ? "Completing" : "Active";
    }

    private final Throwable s0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new p2(m0(), null, this) : th;
        }
        if (obj != null) {
            return ((g3) obj).I0();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public static /* synthetic */ CancellationException t1(w2 w2Var, Throwable th, String str, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i7 & 1) != 0) {
            str = null;
        }
        return w2Var.s1(th, str);
    }

    private final boolean v1(h2 h2Var, Object obj) throws Throwable {
        if (!androidx.concurrent.futures.b.a(f37339a, this, h2Var, x2.g(obj))) {
            return false;
        }
        h1(null);
        i1(obj);
        p0(h2Var, obj);
        return true;
    }

    public static /* synthetic */ p2 w0(w2 w2Var, String str, Throwable th, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i7 & 1) != 0) {
            str = null;
        }
        if ((i7 & 2) != 0) {
            th = null;
        }
        if (str == null) {
            str = w2Var.m0();
        }
        return new p2(str, th, w2Var);
    }

    private final boolean w1(h2 h2Var, Throwable th) throws Throwable {
        b3 b3VarK0 = K0(h2Var);
        if (b3VarK0 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f37339a, this, h2Var, new c(b3VarK0, false, th))) {
            return false;
        }
        e1(b3VarK0, th);
        return true;
    }

    private final Object x1(Object obj, Object obj2) {
        if (!(obj instanceof h2)) {
            return x2.f37364a;
        }
        if ((!(obj instanceof t1) && !(obj instanceof v2)) || (obj instanceof x) || (obj2 instanceof e0)) {
            return y1((h2) obj, obj2);
        }
        return v1((h2) obj, obj2) ? obj2 : x2.f37366c;
    }

    private final Object y0(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thE0;
        e0 e0Var = obj instanceof e0 ? (e0) obj : null;
        Throwable th = e0Var == null ? null : e0Var.f35988a;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th);
            thE0 = E0(cVar, listI);
            if (thE0 != null) {
                Y(thE0, listI);
            }
        }
        if (thE0 != null && thE0 != th) {
            obj = new e0(thE0, false, 2, null);
        }
        if (thE0 != null) {
            if (k0(thE0) || O0(thE0)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((e0) obj).b();
            }
        }
        if (!zF) {
            h1(thE0);
        }
        i1(obj);
        androidx.concurrent.futures.b.a(f37339a, this, cVar, x2.g(obj));
        p0(cVar, obj);
        return obj;
    }

    private final Object y1(h2 h2Var, Object obj) throws Throwable {
        b3 b3VarK0 = K0(h2Var);
        if (b3VarK0 == null) {
            return x2.f37366c;
        }
        c cVar = h2Var instanceof c ? (c) h2Var : null;
        if (cVar == null) {
            cVar = new c(b3VarK0, false, null);
        }
        synchronized (cVar) {
            if (cVar.g()) {
                return x2.f37364a;
            }
            cVar.j(true);
            if (cVar != h2Var && !androidx.concurrent.futures.b.a(f37339a, this, h2Var, cVar)) {
                return x2.f37366c;
            }
            boolean zF = cVar.f();
            e0 e0Var = obj instanceof e0 ? (e0) obj : null;
            if (e0Var != null) {
                cVar.a(e0Var.f35988a);
            }
            Throwable thE = true ^ zF ? cVar.e() : null;
            kotlin.l2 l2Var = kotlin.l2.f34958a;
            if (thE != null) {
                e1(b3VarK0, thE);
            }
            x xVarZ0 = z0(h2Var);
            return (xVarZ0 == null || !z1(cVar, xVarZ0, obj)) ? y0(cVar, obj) : x2.f37365b;
        }
    }

    private final x z0(h2 h2Var) {
        x xVar = h2Var instanceof x ? (x) h2Var : null;
        if (xVar != null) {
            return xVar;
        }
        b3 b3VarD = h2Var.D();
        if (b3VarD == null) {
            return null;
        }
        return d1(b3VarD);
    }

    private final boolean z1(c cVar, x xVar, Object obj) {
        while (o2.a.f(xVar.f37357e, false, false, new b(this, cVar, xVar, obj), 1, null) == d3.f35894a) {
            xVar = d1(xVar);
            if (xVar == null) {
                return false;
            }
        }
        return true;
    }

    @a7.e
    public final Object A0() throws Throwable {
        Object objN0 = N0();
        if (!(!(objN0 instanceof h2))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objN0 instanceof e0) {
            throw ((e0) objN0).f35988a;
        }
        return x2.o(objN0);
    }

    @a7.e
    protected final Throwable B0() {
        Object objN0 = N0();
        if (objN0 instanceof c) {
            Throwable thE = ((c) objN0).e();
            if (thE != null) {
                return thE;
            }
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Job is still new or active: ", this).toString());
        }
        if (objN0 instanceof h2) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Job is still new or active: ", this).toString());
        }
        if (objN0 instanceof e0) {
            return ((e0) objN0).f35988a;
        }
        return null;
    }

    protected final boolean C0() {
        Object objN0 = N0();
        return (objN0 instanceof e0) && ((e0) objN0).a();
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final kotlin.sequences.m<o2> E() {
        return kotlin.sequences.q.b(new e(null));
    }

    @a7.e
    public final Throwable F() {
        Object objN0 = N0();
        if (!(objN0 instanceof h2)) {
            return D0(objN0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean F0() {
        return true;
    }

    @Override // kotlinx.coroutines.o2
    @a7.e
    public final Object H(@a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        if (V0()) {
            Object objW0 = W0(dVar);
            return objW0 == kotlin.coroutines.intrinsics.d.h() ? objW0 : kotlin.l2.f34958a;
        }
        s2.z(dVar.d());
        return kotlin.l2.f34958a;
    }

    public boolean H0() {
        return false;
    }

    @Override // kotlinx.coroutines.g3
    @a7.d
    public CancellationException I0() {
        Throwable thE;
        Object objN0 = N0();
        if (objN0 instanceof c) {
            thE = ((c) objN0).e();
        } else if (objN0 instanceof e0) {
            thE = ((e0) objN0).f35988a;
        } else {
            if (objN0 instanceof h2) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Cannot be cancelling child in this state: ", objN0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        return cancellationException == null ? new p2(kotlin.jvm.internal.l0.C("Parent job is ", r1(objN0)), thE, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final q1 J0(boolean z7, boolean z8, @a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        v2 v2VarB1 = b1(lVar, z7);
        while (true) {
            Object objN0 = N0();
            if (objN0 instanceof t1) {
                t1 t1Var = (t1) objN0;
                if (!t1Var.b()) {
                    k1(t1Var);
                } else if (androidx.concurrent.futures.b.a(f37339a, this, objN0, v2VarB1)) {
                    return v2VarB1;
                }
            } else {
                Throwable thE = null;
                if (!(objN0 instanceof h2)) {
                    if (z8) {
                        e0 e0Var = objN0 instanceof e0 ? (e0) objN0 : null;
                        lVar.z(e0Var != null ? e0Var.f35988a : null);
                    }
                    return d3.f35894a;
                }
                b3 b3VarD = ((h2) objN0).D();
                if (b3VarD != null) {
                    q1 q1Var = d3.f35894a;
                    if (z7 && (objN0 instanceof c)) {
                        synchronized (objN0) {
                            thE = ((c) objN0).e();
                            if (thE == null || ((lVar instanceof x) && !((c) objN0).g())) {
                                if (X(objN0, b3VarD, v2VarB1)) {
                                    if (thE == null) {
                                        return v2VarB1;
                                    }
                                    q1Var = v2VarB1;
                                }
                            }
                            kotlin.l2 l2Var = kotlin.l2.f34958a;
                        }
                    }
                    if (thE != null) {
                        if (z8) {
                            lVar.z(thE);
                        }
                        return q1Var;
                    }
                    if (X(objN0, b3VarD, v2VarB1)) {
                        return v2VarB1;
                    }
                } else {
                    if (objN0 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    l1((v2) objN0);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final CancellationException K() {
        Object objN0 = N0();
        if (!(objN0 instanceof c)) {
            if (objN0 instanceof h2) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Job is still new or active: ", this).toString());
            }
            return objN0 instanceof e0 ? t1(this, ((e0) objN0).f35988a, null, 1, null) : new p2(kotlin.jvm.internal.l0.C(a1.a(this), " has completed normally"), null, this);
        }
        Throwable thE = ((c) objN0).e();
        CancellationException cancellationExceptionS1 = thE != null ? s1(thE, kotlin.jvm.internal.l0.C(a1.a(this), " is cancelling")) : null;
        if (cancellationExceptionS1 != null) {
            return cancellationExceptionS1;
        }
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("Job is still new or active: ", this).toString());
    }

    @a7.e
    public final w M0() {
        return (w) this._parentHandle;
    }

    @a7.e
    public final Object N0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.j0)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.j0) obj).c(this);
        }
    }

    protected boolean O0(@a7.d Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.selects.c
    public final <R> void P(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        Object objN0;
        do {
            objN0 = N0();
            if (fVar.E()) {
                return;
            }
            if (!(objN0 instanceof h2)) {
                if (fVar.q()) {
                    r5.b.c(lVar, fVar.G());
                    return;
                }
                return;
            }
        } while (q1(objN0) != 0);
        fVar.o0(g0(new o3(fVar, lVar)));
    }

    public void P0(@a7.d Throwable th) throws Throwable {
        throw th;
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final w Q0(@a7.d y yVar) {
        return (w) o2.a.f(this, true, false, new x(yVar), 2, null);
    }

    protected final void R0(@a7.e o2 o2Var) {
        if (o2Var == null) {
            p1(d3.f35894a);
            return;
        }
        o2Var.start();
        w wVarQ0 = o2Var.Q0(this);
        p1(wVarQ0);
        if (r()) {
            wVarQ0.F();
            p1(d3.f35894a);
        }
    }

    public final boolean T0() {
        return N0() instanceof e0;
    }

    protected boolean U0() {
        return false;
    }

    protected void Z(@a7.e Object obj) {
    }

    public final boolean Z0(@a7.e Object obj) {
        Object objX1;
        do {
            objX1 = x1(N0(), obj);
            if (objX1 == x2.f37364a) {
                return false;
            }
            if (objX1 == x2.f37365b) {
                return true;
            }
        } while (objX1 == x2.f37366c);
        Z(objX1);
        return true;
    }

    @a7.e
    public final Object a0(@a7.d kotlin.coroutines.d<Object> dVar) throws Throwable {
        Object objN0;
        do {
            objN0 = N0();
            if (!(objN0 instanceof h2)) {
                if (objN0 instanceof e0) {
                    throw ((e0) objN0).f35988a;
                }
                return x2.o(objN0);
            }
        } while (q1(objN0) < 0);
        return b0(dVar);
    }

    @a7.e
    public final Object a1(@a7.e Object obj) {
        Object objX1;
        do {
            objX1 = x1(N0(), obj);
            if (objX1 == x2.f37364a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, D0(obj));
            }
        } while (objX1 == x2.f37366c);
        return objX1;
    }

    @Override // kotlinx.coroutines.o2
    public boolean b() {
        Object objN0 = N0();
        return (objN0 instanceof h2) && ((h2) objN0).b();
    }

    @Override // kotlinx.coroutines.o2
    public void c(@a7.e CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new p2(m0(), null, this);
        }
        f0(cancellationException);
    }

    @a7.d
    public String c1() {
        return a1.a(this);
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        c(null);
    }

    public final boolean d0(@a7.e Throwable th) {
        return e0(th);
    }

    @Override // kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean e(Throwable th) throws Throwable {
        CancellationException cancellationExceptionT1 = th == null ? null : t1(this, th, null, 1, null);
        if (cancellationExceptionT1 == null) {
            cancellationExceptionT1 = new p2(m0(), null, this);
        }
        f0(cancellationExceptionT1);
        return true;
    }

    public final boolean e0(@a7.e Object obj) throws Throwable {
        Object objY0 = x2.f37364a;
        if (H0() && (objY0 = j0(obj)) == x2.f37365b) {
            return true;
        }
        if (objY0 == x2.f37364a) {
            objY0 = Y0(obj);
        }
        if (objY0 == x2.f37364a || objY0 == x2.f37365b) {
            return true;
        }
        if (objY0 == x2.f37367d) {
            return false;
        }
        Z(objY0);
        return true;
    }

    public void f0(@a7.d Throwable th) throws Throwable {
        e0(th);
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
        return (R) o2.a.d(this, r7, pVar);
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final q1 g0(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        return J0(false, true, lVar);
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    public <E extends kotlin.coroutines.g.b> E get(@a7.d kotlin.coroutines.g.c<E> cVar) {
        return (E) o2.a.e(this, cVar);
    }

    @Override // kotlin.coroutines.g.b
    @a7.d
    public final kotlin.coroutines.g.c<?> getKey() {
        return o2.f37103s0;
    }

    protected void h1(@a7.e Throwable th) {
    }

    protected void i1(@a7.e Object obj) {
    }

    @Override // kotlinx.coroutines.o2
    public final boolean isCancelled() {
        Object objN0 = N0();
        return (objN0 instanceof e0) || ((objN0 instanceof c) && ((c) objN0).f());
    }

    protected void j1() {
    }

    @Override // kotlinx.coroutines.y
    public final void l0(@a7.d g3 g3Var) throws Throwable {
        e0(g3Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @a7.d
    public String m0() {
        return "Job was cancelled";
    }

    public final <T, R> void m1(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        Object objN0;
        do {
            objN0 = N0();
            if (fVar.E()) {
                return;
            }
            if (!(objN0 instanceof h2)) {
                if (fVar.q()) {
                    if (objN0 instanceof e0) {
                        fVar.Z(((e0) objN0).f35988a);
                        return;
                    } else {
                        r5.b.d(pVar, x2.o(objN0), fVar.G());
                        return;
                    }
                }
                return;
            }
        } while (q1(objN0) != 0);
        fVar.o0(g0(new n3(fVar, pVar)));
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g minusKey(@a7.d kotlin.coroutines.g.c<?> cVar) {
        return o2.a.g(this, cVar);
    }

    public boolean n0(@a7.d Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return e0(th) && F0();
    }

    public final void n1(@a7.d v2 v2Var) {
        Object objN0;
        do {
            objN0 = N0();
            if (!(objN0 instanceof v2)) {
                if (!(objN0 instanceof h2) || ((h2) objN0).D() == null) {
                    return;
                }
                v2Var.O0();
                return;
            }
            if (objN0 != v2Var) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f37339a, this, objN0, x2.f37373j));
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public o2 o0(@a7.d o2 o2Var) {
        return o2.a.i(this, o2Var);
    }

    public final <T, R> void o1(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) throws Throwable {
        Object objN0 = N0();
        if (objN0 instanceof e0) {
            fVar.Z(((e0) objN0).f35988a);
        } else {
            r5.a.f(pVar, x2.o(objN0), fVar.G(), null, 4, null);
        }
    }

    public final void p1(@a7.e w wVar) {
        this._parentHandle = wVar;
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g plus(@a7.d kotlin.coroutines.g gVar) {
        return o2.a.h(this, gVar);
    }

    @Override // kotlinx.coroutines.o2
    public final boolean r() {
        return !(N0() instanceof h2);
    }

    @a7.d
    protected final CancellationException s1(@a7.d Throwable th, @a7.e String str) {
        CancellationException p2Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (p2Var == null) {
            if (str == null) {
                str = m0();
            }
            p2Var = new p2(str, th, this);
        }
        return p2Var;
    }

    @Override // kotlinx.coroutines.o2
    public final boolean start() {
        int iQ1;
        do {
            iQ1 = q1(N0());
            if (iQ1 == 0) {
                return false;
            }
        } while (iQ1 != 1);
        return true;
    }

    @a7.d
    public String toString() {
        return u1() + '@' + a1.b(this);
    }

    @a7.d
    public final p2 u0(@a7.e String str, @a7.e Throwable th) {
        if (str == null) {
            str = m0();
        }
        return new p2(str, th, this);
    }

    @a7.d
    @j2
    public final String u1() {
        return c1() + '{' + r1(N0()) + '}';
    }

    @Override // kotlinx.coroutines.o2
    @a7.d
    public final kotlinx.coroutines.selects.c x0() {
        return this;
    }
}
