package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.s2;

/* JADX INFO: loaded from: classes3.dex */
public class j0<T> extends kotlinx.coroutines.flow.internal.b<l0> implements d0<T>, kotlinx.coroutines.flow.c<T>, kotlinx.coroutines.flow.internal.r<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f36413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f36414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.channels.m f36415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.e
    private Object[] f36416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f36417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f36418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f36419k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f36420l;

    private static final class a implements q1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final j0<?> f36421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        public long f36422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Object f36423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlin.coroutines.d<l2> f36424d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@a7.d j0<?> j0Var, long j7, @a7.e Object obj, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36421a = j0Var;
            this.f36422b = j7;
            this.f36423c = obj;
            this.f36424d = dVar;
        }

        @Override // kotlinx.coroutines.q1
        public void F() {
            this.f36421a.F(this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36425a;

        static {
            int[] iArr = new int[kotlinx.coroutines.channels.m.values().length];
            iArr[kotlinx.coroutines.channels.m.SUSPEND.ordinal()] = 1;
            iArr[kotlinx.coroutines.channels.m.DROP_LATEST.ordinal()] = 2;
            iArr[kotlinx.coroutines.channels.m.DROP_OLDEST.ordinal()] = 3;
            f36425a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {373, 380, 383}, m = "collect$suspendImpl", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f36429g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f36430h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ j0<T> f36431i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36432j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(j0<T> j0Var, kotlin.coroutines.d<? super c> dVar) {
            super(dVar);
            this.f36431i = j0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36430h = obj;
            this.f36432j |= Integer.MIN_VALUE;
            return j0.H(this.f36431i, null, this);
        }
    }

    public j0(int i7, int i8, @a7.d kotlinx.coroutines.channels.m mVar) {
        this.f36413e = i7;
        this.f36414f = i8;
        this.f36415g = mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E(l0 l0Var, kotlin.coroutines.d<? super l2> dVar) {
        l2 l2Var;
        kotlinx.coroutines.r rVar = new kotlinx.coroutines.r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        synchronized (this) {
            if (b0(l0Var) < 0) {
                l0Var.f36505b = rVar;
            } else {
                d1.a aVar = d1.f34719b;
                rVar.w(d1.b(l2.f34958a));
            }
            l2Var = l2.f34958a;
        }
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(a aVar) {
        synchronized (this) {
            if (aVar.f36422b < R()) {
                return;
            }
            Object[] objArr = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr);
            if (k0.f(objArr, aVar.f36422b) != aVar) {
                return;
            }
            k0.h(objArr, aVar.f36422b, k0.f36434a);
            G();
            l2 l2Var = l2.f34958a;
        }
    }

    private final void G() {
        if (this.f36414f != 0 || this.f36420l > 1) {
            Object[] objArr = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr);
            while (this.f36420l > 0 && k0.f(objArr, (R() + ((long) X())) - 1) == k0.f36434a) {
                this.f36420l--;
                k0.h(objArr, R() + ((long) X()), null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object H(j0 j0Var, j jVar, kotlin.coroutines.d dVar) throws Throwable {
        c cVar;
        j0 j0Var2;
        Throwable th;
        l0 l0Var;
        j jVar2;
        o2 o2Var;
        j jVar3;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i7 = cVar.f36432j;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                cVar.f36432j = i7 - Integer.MIN_VALUE;
            } else {
                cVar = new c(j0Var, dVar);
            }
        } else {
            cVar = new c(j0Var, dVar);
        }
        Object obj = cVar.f36430h;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = cVar.f36432j;
        if (i8 != 0) {
            if (i8 == 1) {
                l0Var = (l0) cVar.f36428f;
                j jVar4 = (j) cVar.f36427e;
                j0 j0Var3 = (j0) cVar.f36426d;
                try {
                    e1.n(obj);
                    jVar2 = jVar4;
                    j0Var = j0Var3;
                    try {
                        o2Var = (o2) cVar.d().get(o2.f37103s0);
                        jVar3 = jVar2;
                    } catch (Throwable th2) {
                        j0Var2 = j0Var;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    j0Var2 = j0Var3;
                }
            } else {
                if (i8 != 2 && i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o2 o2Var2 = (o2) cVar.f36429g;
                l0Var = (l0) cVar.f36428f;
                j jVar5 = (j) cVar.f36427e;
                j0Var2 = (j0) cVar.f36426d;
                try {
                    e1.n(obj);
                    jVar3 = jVar5;
                    o2Var = o2Var2;
                    j0Var = j0Var2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            j0Var2.n(l0Var);
            throw th;
        }
        e1.n(obj);
        l0 l0VarH = j0Var.h();
        try {
            if (jVar instanceof x0) {
                cVar.f36426d = j0Var;
                cVar.f36427e = jVar;
                cVar.f36428f = l0VarH;
                cVar.f36432j = 1;
                if (((x0) jVar).a(cVar) == objH) {
                    return objH;
                }
            }
            jVar2 = jVar;
            l0Var = l0VarH;
            o2Var = (o2) cVar.d().get(o2.f37103s0);
            jVar3 = jVar2;
        } catch (Throwable th5) {
            j0Var2 = j0Var;
            th = th5;
            l0Var = l0VarH;
        }
        while (true) {
            Object objC0 = j0Var.c0(l0Var);
            if (objC0 != k0.f36434a) {
                if (o2Var != null) {
                    s2.A(o2Var);
                }
                cVar.f36426d = j0Var;
                cVar.f36427e = jVar3;
                cVar.f36428f = l0Var;
                cVar.f36429g = o2Var;
                cVar.f36432j = 3;
                if (jVar3.f(objC0, cVar) == objH) {
                    return objH;
                }
            } else {
                cVar.f36426d = j0Var;
                cVar.f36427e = jVar3;
                cVar.f36428f = l0Var;
                cVar.f36429g = o2Var;
                cVar.f36432j = 2;
                if (j0Var.E(l0Var, cVar) == objH) {
                    return objH;
                }
            }
        }
    }

    private final void I(long j7) {
        kotlinx.coroutines.flow.internal.d[] dVarArr;
        if (((kotlinx.coroutines.flow.internal.b) this).f36263b != 0 && (dVarArr = ((kotlinx.coroutines.flow.internal.b) this).f36262a) != null) {
            int length = dVarArr.length;
            int i7 = 0;
            while (i7 < length) {
                kotlinx.coroutines.flow.internal.d dVar = dVarArr[i7];
                i7++;
                if (dVar != null) {
                    l0 l0Var = (l0) dVar;
                    long j8 = l0Var.f36504a;
                    if (j8 >= 0 && j8 < j7) {
                        l0Var.f36504a = j7;
                    }
                }
            }
        }
        this.f36418j = j7;
    }

    private final void L() {
        Object[] objArr = this.f36416h;
        kotlin.jvm.internal.l0.m(objArr);
        k0.h(objArr, R(), null);
        this.f36419k--;
        long jR = R() + 1;
        if (this.f36417i < jR) {
            this.f36417i = jR;
        }
        if (this.f36418j < jR) {
            I(jR);
        }
    }

    static /* synthetic */ Object M(j0 j0Var, Object obj, kotlin.coroutines.d dVar) {
        if (j0Var.m(obj)) {
            return l2.f34958a;
        }
        Object objN = j0Var.N(obj, dVar);
        return objN == kotlin.coroutines.intrinsics.d.h() ? objN : l2.f34958a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(T t7, kotlin.coroutines.d<? super l2> dVar) {
        kotlin.coroutines.d<l2>[] dVarArrP;
        a aVar;
        kotlinx.coroutines.r rVar = new kotlinx.coroutines.r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        kotlin.coroutines.d<l2>[] dVarArrP2 = kotlinx.coroutines.flow.internal.c.f36272a;
        synchronized (this) {
            if (Z(t7)) {
                d1.a aVar2 = d1.f34719b;
                rVar.w(d1.b(l2.f34958a));
                dVarArrP = P(dVarArrP2);
                aVar = null;
            } else {
                a aVar3 = new a(this, ((long) X()) + R(), t7, rVar);
                O(aVar3);
                this.f36420l++;
                if (this.f36414f == 0) {
                    dVarArrP2 = P(dVarArrP2);
                }
                dVarArrP = dVarArrP2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.t.a(rVar, aVar);
        }
        int length = dVarArrP.length;
        int i7 = 0;
        while (i7 < length) {
            kotlin.coroutines.d<l2> dVar2 = dVarArrP[i7];
            i7++;
            if (dVar2 != null) {
                d1.a aVar4 = d1.f34719b;
                dVar2.w(d1.b(l2.f34958a));
            }
        }
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : l2.f34958a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(Object obj) {
        int iX = X();
        Object[] objArrY = this.f36416h;
        if (objArrY == null) {
            objArrY = Y(null, 0, 2);
        } else if (iX >= objArrY.length) {
            objArrY = Y(objArrY, iX, objArrY.length * 2);
        }
        k0.h(objArrY, R() + ((long) iX), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.d<kotlin.l2>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final kotlin.coroutines.d<l2>[] P(kotlin.coroutines.d<l2>[] dVarArr) {
        kotlinx.coroutines.flow.internal.d[] dVarArr2;
        l0 l0Var;
        kotlin.coroutines.d<? super l2> dVar;
        int length = dVarArr.length;
        if (((kotlinx.coroutines.flow.internal.b) this).f36263b != 0 && (dVarArr2 = ((kotlinx.coroutines.flow.internal.b) this).f36262a) != null) {
            int length2 = dVarArr2.length;
            int i7 = 0;
            while (i7 < length2) {
                kotlinx.coroutines.flow.internal.d dVar2 = dVarArr2[i7];
                i7++;
                if (dVar2 != null && (dVar = (l0Var = (l0) dVar2).f36505b) != null && b0(l0Var) >= 0) {
                    int length3 = dVarArr.length;
                    dVarArr = dVarArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) dVarArr, Math.max(2, dVarArr.length * 2));
                        kotlin.jvm.internal.l0.o(objArrCopyOf, "copyOf(this, newSize)");
                        dVarArr = objArrCopyOf;
                    }
                    ((kotlin.coroutines.d[]) dVarArr)[length] = dVar;
                    l0Var.f36505b = null;
                    length++;
                }
            }
        }
        return (kotlin.coroutines.d[]) dVarArr;
    }

    private final long Q() {
        return R() + ((long) this.f36419k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long R() {
        return Math.min(this.f36418j, this.f36417i);
    }

    protected static /* synthetic */ void T() {
    }

    private final Object U(long j7) {
        Object[] objArr = this.f36416h;
        kotlin.jvm.internal.l0.m(objArr);
        Object objF = k0.f(objArr, j7);
        return objF instanceof a ? ((a) objF).f36423c : objF;
    }

    private final long V() {
        return R() + ((long) this.f36419k) + ((long) this.f36420l);
    }

    private final int W() {
        return (int) ((R() + ((long) this.f36419k)) - this.f36417i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X() {
        return this.f36419k + this.f36420l;
    }

    private final Object[] Y(Object[] objArr, int i7, int i8) {
        if (!(i8 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i8];
        this.f36416h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jR = R();
        for (int i9 = 0; i9 < i7; i9++) {
            long j7 = ((long) i9) + jR;
            k0.h(objArr2, j7, k0.f(objArr, j7));
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z(T t7) {
        if (o() == 0) {
            return a0(t7);
        }
        if (this.f36419k >= this.f36414f && this.f36418j <= this.f36417i) {
            int i7 = b.f36425a[this.f36415g.ordinal()];
            if (i7 == 1) {
                return false;
            }
            if (i7 == 2) {
                return true;
            }
        }
        O(t7);
        int i8 = this.f36419k + 1;
        this.f36419k = i8;
        if (i8 > this.f36414f) {
            L();
        }
        if (W() > this.f36413e) {
            d0(this.f36417i + 1, this.f36418j, Q(), V());
        }
        return true;
    }

    private final boolean a0(T t7) {
        if (this.f36413e == 0) {
            return true;
        }
        O(t7);
        int i7 = this.f36419k + 1;
        this.f36419k = i7;
        if (i7 > this.f36413e) {
            L();
        }
        this.f36418j = R() + ((long) this.f36419k);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b0(l0 l0Var) {
        long j7 = l0Var.f36504a;
        if (j7 < Q()) {
            return j7;
        }
        if (this.f36414f <= 0 && j7 <= R() && this.f36420l != 0) {
            return j7;
        }
        return -1L;
    }

    private final Object c0(l0 l0Var) {
        Object obj;
        kotlin.coroutines.d<l2>[] dVarArrE0 = kotlinx.coroutines.flow.internal.c.f36272a;
        synchronized (this) {
            long jB0 = b0(l0Var);
            if (jB0 < 0) {
                obj = k0.f36434a;
            } else {
                long j7 = l0Var.f36504a;
                Object objU = U(jB0);
                l0Var.f36504a = jB0 + 1;
                dVarArrE0 = e0(j7);
                obj = objU;
            }
        }
        int length = dVarArrE0.length;
        int i7 = 0;
        while (i7 < length) {
            kotlin.coroutines.d<l2> dVar = dVarArrE0[i7];
            i7++;
            if (dVar != null) {
                d1.a aVar = d1.f34719b;
                dVar.w(d1.b(l2.f34958a));
            }
        }
        return obj;
    }

    private final void d0(long j7, long j8, long j9, long j10) {
        long jMin = Math.min(j8, j7);
        for (long jR = R(); jR < jMin; jR = 1 + jR) {
            Object[] objArr = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr);
            k0.h(objArr, jR, null);
        }
        this.f36417i = j7;
        this.f36418j = j8;
        this.f36419k = (int) (j9 - jMin);
        this.f36420l = (int) (j10 - j9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    @a7.d
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public l0 i() {
        return new l0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    @a7.d
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public l0[] k(int i7) {
        return new l0[i7];
    }

    protected final T S() {
        Object[] objArr = this.f36416h;
        kotlin.jvm.internal.l0.m(objArr);
        return (T) k0.f(objArr, (this.f36417i + ((long) W())) - 1);
    }

    @Override // kotlinx.coroutines.flow.i0, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<?> dVar) {
        return H(this, jVar, dVar);
    }

    @Override // kotlinx.coroutines.flow.i0
    @a7.d
    public List<T> b() {
        synchronized (this) {
            int iW = W();
            if (iW == 0) {
                return kotlin.collections.y.F();
            }
            ArrayList arrayList = new ArrayList(iW);
            Object[] objArr = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr);
            int i7 = 0;
            while (i7 < iW) {
                int i8 = i7 + 1;
                arrayList.add(k0.f(objArr, this.f36417i + ((long) i7)));
                i7 = i8;
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.internal.r
    @a7.d
    public i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return k0.e(this, gVar, i7, mVar);
    }

    @a7.d
    public final kotlin.coroutines.d<l2>[] e0(long j7) {
        long j8;
        kotlinx.coroutines.flow.internal.d[] dVarArr;
        if (j7 > this.f36418j) {
            return kotlinx.coroutines.flow.internal.c.f36272a;
        }
        long jR = R();
        long j9 = ((long) this.f36419k) + jR;
        long j10 = 1;
        if (this.f36414f == 0 && this.f36420l > 0) {
            j9++;
        }
        if (((kotlinx.coroutines.flow.internal.b) this).f36263b != 0 && (dVarArr = ((kotlinx.coroutines.flow.internal.b) this).f36262a) != null) {
            int length = dVarArr.length;
            int i7 = 0;
            while (i7 < length) {
                kotlinx.coroutines.flow.internal.d dVar = dVarArr[i7];
                i7++;
                if (dVar != null) {
                    long j11 = ((l0) dVar).f36504a;
                    if (j11 >= 0 && j11 < j9) {
                        j9 = j11;
                    }
                }
            }
        }
        if (j9 <= this.f36418j) {
            return kotlinx.coroutines.flow.internal.c.f36272a;
        }
        long jQ = Q();
        int iMin = o() > 0 ? Math.min(this.f36420l, this.f36414f - ((int) (jQ - j9))) : this.f36420l;
        kotlin.coroutines.d<l2>[] dVarArr2 = kotlinx.coroutines.flow.internal.c.f36272a;
        long j12 = ((long) this.f36420l) + jQ;
        if (iMin > 0) {
            dVarArr2 = new kotlin.coroutines.d[iMin];
            Object[] objArr = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr);
            long j13 = jQ;
            int i8 = 0;
            while (true) {
                if (jQ >= j12) {
                    j8 = j9;
                    break;
                }
                jQ += j10;
                Object objF = k0.f(objArr, jQ);
                kotlinx.coroutines.internal.r0 r0Var = k0.f36434a;
                if (objF != r0Var) {
                    if (objF == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    }
                    a aVar = (a) objF;
                    int i9 = i8 + 1;
                    j8 = j9;
                    dVarArr2[i8] = aVar.f36424d;
                    k0.h(objArr, jQ, r0Var);
                    long j14 = j13;
                    k0.h(objArr, j14, aVar.f36423c);
                    j13 = j14 + 1;
                    if (i9 >= iMin) {
                        break;
                    }
                    i8 = i9;
                    j9 = j8;
                }
                j10 = 1;
            }
            jQ = j13;
        } else {
            j8 = j9;
        }
        int i10 = (int) (jQ - jR);
        long j15 = o() == 0 ? jQ : j8;
        long jMax = Math.max(this.f36417i, jQ - ((long) Math.min(this.f36413e, i10)));
        if (this.f36414f == 0 && jMax < j12) {
            Object[] objArr2 = this.f36416h;
            kotlin.jvm.internal.l0.m(objArr2);
            if (kotlin.jvm.internal.l0.g(k0.f(objArr2, jMax), k0.f36434a)) {
                jQ++;
                jMax++;
            }
        }
        d0(jMax, j15, jQ, j12);
        G();
        return (dVarArr2.length == 0) ^ true ? P(dVarArr2) : dVarArr2;
    }

    @Override // kotlinx.coroutines.flow.d0, kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return M(this, t7, dVar);
    }

    public final long f0() {
        long j7 = this.f36417i;
        if (j7 < this.f36418j) {
            this.f36418j = j7;
        }
        return j7;
    }

    @Override // kotlinx.coroutines.flow.d0
    public void j() {
        synchronized (this) {
            d0(Q(), this.f36418j, Q(), V());
            l2 l2Var = l2.f34958a;
        }
    }

    @Override // kotlinx.coroutines.flow.d0
    public boolean m(T t7) {
        int i7;
        boolean z7;
        kotlin.coroutines.d<l2>[] dVarArrP = kotlinx.coroutines.flow.internal.c.f36272a;
        synchronized (this) {
            i7 = 0;
            if (Z(t7)) {
                dVarArrP = P(dVarArrP);
                z7 = true;
            } else {
                z7 = false;
            }
        }
        int length = dVarArrP.length;
        while (i7 < length) {
            kotlin.coroutines.d<l2> dVar = dVarArrP[i7];
            i7++;
            if (dVar != null) {
                d1.a aVar = d1.f34719b;
                dVar.w(d1.b(l2.f34958a));
            }
        }
        return z7;
    }
}
