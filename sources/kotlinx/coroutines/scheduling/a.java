package kotlinx.coroutines.scheduling;

import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.m0;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f37130m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f37131n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f37132o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f37133p = 21;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f37134q = 2097151;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f37135r = 4398044413952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f37136s = 42;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f37137t = 9223367638808264704L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f37138u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f37139v = 2097150;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final long f37140w = 2097151;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final long f37141x = -2097152;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final long f37142y = 2097152;

    @a7.d
    private volatile /* synthetic */ int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public final int f37143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public final int f37144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public final long f37145c;

    @a7.d
    volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public final String f37146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public final f f37147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @h5.e
    public final f f37148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    @h5.e
    public final m0<c> f37149g;

    @a7.d
    private volatile /* synthetic */ long parkedWorkersStack;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    public static final C0490a f37125h = new C0490a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final r0 f37129l = new r0("NOT_IN_STACK");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f37126i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f37127j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37128k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    public static final class C0490a {
        public /* synthetic */ C0490a(w wVar) {
            this();
        }

        private C0490a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37150a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f37150a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i7, int i8, long j7, @a7.d String str) {
        this.f37143a = i7;
        this.f37144b = i8;
        this.f37145c = j7;
        this.f37146d = str;
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i7 + " should be at least 1").toString());
        }
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("Max pool size " + i8 + " should be greater than or equals to core pool size " + i7).toString());
        }
        if (!(i8 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i8 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j7 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j7 + " must be positive").toString());
        }
        this.f37147e = new f();
        this.f37148f = new f();
        this.parkedWorkersStack = 0L;
        this.f37149g = new m0<>(i7 + 1);
        this.controlState = ((long) i7) << 42;
        this._isTerminated = 0;
    }

    private final void C() {
        f37127j.addAndGet(this, f37141x);
    }

    private final int E() {
        return (int) (f37127j.getAndDecrement(this) & 2097151);
    }

    public static /* synthetic */ void G(a aVar, Runnable runnable, l lVar, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            lVar = o.f37197i;
        }
        if ((i7 & 4) != 0) {
            z7 = false;
        }
        aVar.F(runnable, lVar, z7);
    }

    private final int H() {
        return (int) ((this.controlState & f37137t) >> 42);
    }

    private final k I0(c cVar, k kVar, boolean z7) {
        if (cVar == null || cVar.f37153b == d.TERMINATED) {
            return kVar;
        }
        if (kVar.f37186b.Q() == 0 && cVar.f37153b == d.BLOCKING) {
            return kVar;
        }
        cVar.f37157f = true;
        return cVar.f37152a.a(kVar, z7);
    }

    private final boolean J0() {
        long j7;
        do {
            j7 = this.controlState;
            if (((int) ((f37137t & j7) >> 42)) == 0) {
                return false;
            }
        } while (!f37127j.compareAndSet(this, j7, j7 - 4398046511104L));
        return true;
    }

    private final int K() {
        return (int) (this.controlState & 2097151);
    }

    private final boolean L0(long j7) {
        if (kotlin.ranges.q.n(((int) (2097151 & j7)) - ((int) ((j7 & f37135r) >> 21)), 0) < this.f37143a) {
            int iQ = q();
            if (iQ == 1 && this.f37143a > 1) {
                q();
            }
            if (iQ > 0) {
                return true;
            }
        }
        return false;
    }

    private final long Q() {
        return f37127j.addAndGet(this, 2097152L);
    }

    static /* synthetic */ boolean Q0(a aVar, long j7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            j7 = aVar.controlState;
        }
        return aVar.L0(j7);
    }

    private final boolean T0() {
        c cVarL0;
        do {
            cVarL0 = l0();
            if (cVarL0 == null) {
                return false;
            }
        } while (!c.f37151h.compareAndSet(cVarL0, -1, 0));
        LockSupport.unpark(cVarL0);
        return true;
    }

    private final boolean b(k kVar) {
        return kVar.f37186b.Q() == 1 ? this.f37148f.a(kVar) : this.f37147e.a(kVar);
    }

    private final int e(long j7) {
        return (int) ((j7 & f37135r) >> 21);
    }

    private final int g0() {
        return (int) (f37127j.incrementAndGet(this) & 2097151);
    }

    private final int h0(c cVar) {
        Object objH = cVar.h();
        while (objH != f37129l) {
            if (objH == null) {
                return 0;
            }
            c cVar2 = (c) objH;
            int iG = cVar2.g();
            if (iG != 0) {
                return iG;
            }
            objH = cVar2.h();
        }
        return -1;
    }

    private final c l0() {
        while (true) {
            long j7 = this.parkedWorkersStack;
            c cVarB = this.f37149g.b((int) (2097151 & j7));
            if (cVarB == null) {
                return null;
            }
            long j8 = (2097152 + j7) & f37141x;
            int iH0 = h0(cVarB);
            if (iH0 >= 0 && f37126i.compareAndSet(this, j7, ((long) iH0) | j8)) {
                cVarB.q(f37129l);
                return cVarB;
            }
        }
    }

    private final int q() {
        synchronized (this.f37149g) {
            if (isTerminated()) {
                return -1;
            }
            long j7 = this.controlState;
            int i7 = (int) (j7 & 2097151);
            int iN = kotlin.ranges.q.n(i7 - ((int) ((j7 & f37135r) >> 21)), 0);
            if (iN >= this.f37143a) {
                return 0;
            }
            if (i7 >= this.f37144b) {
                return 0;
            }
            int i8 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i8 > 0 && this.f37149g.b(i8) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(i8);
            this.f37149g.c(i8, cVar);
            if (!(i8 == ((int) (2097151 & f37127j.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return iN + 1;
        }
    }

    private final long r0() {
        return f37127j.addAndGet(this, 4398046511104L);
    }

    private final int s(long j7) {
        return (int) (j7 & 2097151);
    }

    private final c u() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar != null && l0.g(a.this, this)) {
            return cVar;
        }
        return null;
    }

    private final void x0(boolean z7) {
        long jAddAndGet = f37127j.addAndGet(this, 2097152L);
        if (z7 || T0() || L0(jAddAndGet)) {
            return;
        }
        T0();
    }

    public final void F(@a7.d Runnable runnable, @a7.d l lVar, boolean z7) {
        kotlinx.coroutines.b bVarB = kotlinx.coroutines.c.b();
        if (bVarB != null) {
            bVarB.e();
        }
        k kVarR = r(runnable, lVar);
        c cVarU = u();
        k kVarI0 = I0(cVarU, kVarR, z7);
        if (kVarI0 != null && !b(kVarI0)) {
            throw new RejectedExecutionException(l0.C(this.f37146d, " was terminated"));
        }
        boolean z8 = z7 && cVarU != null;
        if (kVarR.f37186b.Q() != 0) {
            x0(z8);
        } else {
            if (z8) {
                return;
            }
            G0();
        }
    }

    public final void G0() {
        if (T0() || Q0(this, 0L, 1, null)) {
            return;
        }
        T0();
    }

    public final int c(long j7) {
        return (int) ((j7 & f37137t) >> 42);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        v0(RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@a7.d Runnable runnable) {
        G(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean o0(@a7.d c cVar) {
        long j7;
        long j8;
        int iG;
        if (cVar.h() != f37129l) {
            return false;
        }
        do {
            j7 = this.parkedWorkersStack;
            j8 = (2097152 + j7) & f37141x;
            iG = cVar.g();
            cVar.q(this.f37149g.b((int) (2097151 & j7)));
        } while (!f37126i.compareAndSet(this, j7, j8 | ((long) iG)));
        return true;
    }

    public final void p0(@a7.d c cVar, int i7, int i8) {
        while (true) {
            long j7 = this.parkedWorkersStack;
            int iH0 = (int) (2097151 & j7);
            long j8 = (2097152 + j7) & f37141x;
            if (iH0 == i7) {
                iH0 = i8 == 0 ? h0(cVar) : i8;
            }
            if (iH0 >= 0 && f37126i.compareAndSet(this, j7, j8 | ((long) iH0))) {
                return;
            }
        }
    }

    @a7.d
    public final k r(@a7.d Runnable runnable, @a7.d l lVar) {
        long jA = o.f37194f.a();
        if (!(runnable instanceof k)) {
            return new n(runnable, jA, lVar);
        }
        k kVar = (k) runnable;
        kVar.f37185a = jA;
        kVar.f37186b = lVar;
        return kVar;
    }

    public final void s0(@a7.d k kVar) {
        kotlinx.coroutines.b bVarB;
        try {
            kVar.run();
            bVarB = kotlinx.coroutines.c.b();
            if (bVarB == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                bVarB = kotlinx.coroutines.c.b();
                if (bVarB == null) {
                    return;
                }
            } catch (Throwable th2) {
                kotlinx.coroutines.b bVarB2 = kotlinx.coroutines.c.b();
                if (bVarB2 != null) {
                    bVarB2.f();
                }
                throw th2;
            }
        }
        bVarB.f();
    }

    @a7.d
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f37149g.a();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i12 < iA) {
            int i13 = i12 + 1;
            c cVarB = this.f37149g.b(i12);
            if (cVarB != null) {
                int iF = cVarB.f37152a.f();
                int i14 = b.f37150a[cVarB.f37153b.ordinal()];
                if (i14 == 1) {
                    i9++;
                } else if (i14 == 2) {
                    i8++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i14 == 3) {
                    i7++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i14 == 4) {
                    i10++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i14 == 5) {
                    i11++;
                }
            }
            i12 = i13;
        }
        long j7 = this.controlState;
        return this.f37146d + '@' + a1.b(this) + "[Pool Size {core = " + this.f37143a + ", max = " + this.f37144b + "}, Worker States {CPU = " + i7 + ", blocking = " + i8 + ", parked = " + i9 + ", dormant = " + i10 + ", terminated = " + i11 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f37147e.c() + ", global blocking queue size = " + this.f37148f.c() + ", Control State {created workers= " + ((int) (2097151 & j7)) + ", blocking tasks = " + ((int) ((f37135r & j7) >> 21)) + ", CPUs acquired = " + (this.f37143a - ((int) ((f37137t & j7) >> 42))) + "}]";
    }

    public final void v0(long j7) throws InterruptedException {
        int i7;
        if (f37128k.compareAndSet(this, 0, 1)) {
            c cVarU = u();
            synchronized (this.f37149g) {
                i7 = (int) (this.controlState & 2097151);
            }
            if (1 <= i7) {
                int i8 = 1;
                while (true) {
                    int i9 = i8 + 1;
                    c cVarB = this.f37149g.b(i8);
                    l0.m(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarU) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j7);
                        }
                        cVar.f37152a.g(this.f37148f);
                    }
                    if (i8 == i7) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            this.f37148f.b();
            this.f37147e.b();
            while (true) {
                k kVarF = cVarU == null ? null : cVarU.f(true);
                if (kVarF == null && (kVarF = this.f37147e.g()) == null && (kVarF = this.f37148f.g()) == null) {
                    break;
                } else {
                    s0(kVarF);
                }
            }
            if (cVarU != null) {
                cVarU.t(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f37151h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final q f37152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public d f37153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f37154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f37155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @h5.e
        public boolean f37157f;
        private volatile int indexInArray;

        @a7.e
        private volatile Object nextParkedWorker;

        @a7.d
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f37152a = new q();
            this.f37153b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f37129l;
            this.f37156e = kotlin.random.f.f34998a.l();
        }

        private final void b(int i7) {
            if (i7 == 0) {
                return;
            }
            a.f37127j.addAndGet(a.this, a.f37141x);
            if (this.f37153b != d.TERMINATED) {
                this.f37153b = d.DORMANT;
            }
        }

        private final void c(int i7) {
            if (i7 != 0 && t(d.BLOCKING)) {
                a.this.G0();
            }
        }

        private final void d(k kVar) {
            int iQ = kVar.f37186b.Q();
            j(iQ);
            c(iQ);
            a.this.s0(kVar);
            b(iQ);
        }

        private final k e(boolean z7) {
            k kVarN;
            k kVarN2;
            if (z7) {
                boolean z8 = l(a.this.f37143a * 2) == 0;
                if (z8 && (kVarN2 = n()) != null) {
                    return kVarN2;
                }
                k kVarH = this.f37152a.h();
                if (kVarH != null) {
                    return kVarH;
                }
                if (!z8 && (kVarN = n()) != null) {
                    return kVarN;
                }
            } else {
                k kVarN3 = n();
                if (kVarN3 != null) {
                    return kVarN3;
                }
            }
            return u(false);
        }

        private final void j(int i7) {
            this.f37154c = 0L;
            if (this.f37153b == d.PARKING) {
                this.f37153b = d.BLOCKING;
            }
        }

        private final boolean k() {
            return this.nextParkedWorker != a.f37129l;
        }

        private final void m() {
            if (this.f37154c == 0) {
                this.f37154c = System.nanoTime() + a.this.f37145c;
            }
            LockSupport.parkNanos(a.this.f37145c);
            if (System.nanoTime() - this.f37154c >= 0) {
                this.f37154c = 0L;
                v();
            }
        }

        private final k n() {
            if (l(2) == 0) {
                k kVarG = a.this.f37147e.g();
                return kVarG == null ? a.this.f37148f.g() : kVarG;
            }
            k kVarG2 = a.this.f37148f.g();
            return kVarG2 == null ? a.this.f37147e.g() : kVarG2;
        }

        private final void o() {
            loop0: while (true) {
                boolean z7 = false;
                while (true) {
                    if (a.this.isTerminated() || this.f37153b == d.TERMINATED) {
                        break loop0;
                    }
                    k kVarF = f(this.f37157f);
                    if (kVarF != null) {
                        this.f37155d = 0L;
                        d(kVarF);
                        break;
                    }
                    this.f37157f = false;
                    if (this.f37155d == 0) {
                        s();
                    } else {
                        if (z7) {
                            t(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f37155d);
                            this.f37155d = 0L;
                            break;
                        }
                        z7 = true;
                    }
                }
            }
            t(d.TERMINATED);
        }

        private final boolean r() {
            boolean z7;
            if (this.f37153b == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            while (true) {
                long j7 = aVar.controlState;
                if (((int) ((a.f37137t & j7) >> 42)) == 0) {
                    z7 = false;
                    break;
                }
                if (a.f37127j.compareAndSet(aVar, j7, j7 - 4398046511104L)) {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                return false;
            }
            this.f37153b = d.CPU_ACQUIRED;
            return true;
        }

        private final void s() {
            if (!k()) {
                a.this.o0(this);
                return;
            }
            this.workerCtl = -1;
            while (k() && this.workerCtl == -1 && !a.this.isTerminated() && this.f37153b != d.TERMINATED) {
                t(d.PARKING);
                Thread.interrupted();
                m();
            }
        }

        private final k u(boolean z7) {
            int i7 = (int) (a.this.controlState & 2097151);
            if (i7 < 2) {
                return null;
            }
            int iL = l(i7);
            a aVar = a.this;
            int i8 = 0;
            long jMin = Long.MAX_VALUE;
            while (i8 < i7) {
                i8++;
                iL++;
                if (iL > i7) {
                    iL = 1;
                }
                c cVarB = aVar.f37149g.b(iL);
                if (cVarB != null && cVarB != this) {
                    long jK = z7 ? this.f37152a.k(cVarB.f37152a) : this.f37152a.l(cVarB.f37152a);
                    if (jK == -1) {
                        return this.f37152a.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f37155d = jMin;
            return null;
        }

        private final void v() {
            a aVar = a.this;
            synchronized (aVar.f37149g) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f37143a) {
                    return;
                }
                if (f37151h.compareAndSet(this, -1, 1)) {
                    int iG = g();
                    p(0);
                    aVar.p0(this, iG, 0);
                    int andDecrement = (int) (a.f37127j.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != iG) {
                        c cVarB = aVar.f37149g.b(andDecrement);
                        l0.m(cVarB);
                        c cVar = cVarB;
                        aVar.f37149g.c(iG, cVar);
                        cVar.p(iG);
                        aVar.p0(cVar, andDecrement, iG);
                    }
                    aVar.f37149g.c(andDecrement, null);
                    l2 l2Var = l2.f34958a;
                    this.f37153b = d.TERMINATED;
                }
            }
        }

        @a7.e
        public final k f(boolean z7) {
            k kVarG;
            if (r()) {
                return e(z7);
            }
            if (!z7 || (kVarG = this.f37152a.h()) == null) {
                kVarG = a.this.f37148f.g();
            }
            return kVarG == null ? u(true) : kVarG;
        }

        public final int g() {
            return this.indexInArray;
        }

        @a7.e
        public final Object h() {
            return this.nextParkedWorker;
        }

        @a7.d
        public final a i() {
            return a.this;
        }

        public final int l(int i7) {
            int i8 = this.f37156e;
            int i9 = i8 ^ (i8 << 13);
            int i10 = i9 ^ (i9 >> 17);
            int i11 = i10 ^ (i10 << 5);
            this.f37156e = i11;
            int i12 = i7 - 1;
            return (i12 & i7) == 0 ? i11 & i12 : (i11 & Integer.MAX_VALUE) % i7;
        }

        public final void p(int i7) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f37146d);
            sb.append("-worker-");
            sb.append(i7 == 0 ? "TERMINATED" : String.valueOf(i7));
            setName(sb.toString());
            this.indexInArray = i7;
        }

        public final void q(@a7.e Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            o();
        }

        public final boolean t(@a7.d d dVar) {
            d dVar2 = this.f37153b;
            boolean z7 = dVar2 == d.CPU_ACQUIRED;
            if (z7) {
                a.f37127j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f37153b = dVar;
            }
            return z7;
        }

        public c(int i7) {
            this();
            p(i7);
        }
    }

    public /* synthetic */ a(int i7, int i8, long j7, String str, int i9, w wVar) {
        this(i7, i8, (i9 & 4) != 0 ? o.f37193e : j7, (i9 & 8) != 0 ? o.f37189a : str);
    }
}
