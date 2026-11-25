package kotlinx.coroutines.internal;

import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.q1;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends kotlinx.coroutines.o0 implements Runnable, f1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.o0 f37022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ f1 f37024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final a0<Runnable> f37025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final Object f37026f;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public s(@a7.d kotlinx.coroutines.o0 o0Var, int i7) {
        this.f37022b = o0Var;
        this.f37023c = i7;
        f1 f1Var = o0Var instanceof f1 ? (f1) o0Var : null;
        this.f37024d = f1Var == null ? kotlinx.coroutines.c1.a() : f1Var;
        this.f37025e = new a0<>(false);
        this.f37026f = new Object();
    }

    private final boolean e1(Runnable runnable) {
        this.f37025e.a(runnable);
        return this.runningWorkers >= this.f37023c;
    }

    private final void i1(Runnable runnable, i5.a<l2> aVar) {
        if (!e1(runnable) && q1()) {
            aVar.invoke();
        }
    }

    private final boolean q1() {
        synchronized (this.f37026f) {
            if (this.runningWorkers >= this.f37023c) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        if (!e1(runnable) && q1()) {
            this.f37022b.T0(this, this);
        }
    }

    @Override // kotlinx.coroutines.o0
    @j2
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        if (!e1(runnable) && q1()) {
            this.f37022b.V0(this, this);
        }
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    @d2
    public kotlinx.coroutines.o0 a1(int i7) {
        t.a(i7);
        return i7 >= this.f37023c ? this : super.a1(i7);
    }

    @Override // kotlinx.coroutines.f1
    @a7.d
    public q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
        return this.f37024d.p0(j7, runnable, gVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            int i7 = 0;
            while (true) {
                Runnable runnableG = this.f37025e.g();
                if (runnableG != null) {
                    try {
                        runnableG.run();
                    } catch (Throwable th) {
                        kotlinx.coroutines.r0.b(kotlin.coroutines.i.f34682a, th);
                    }
                    i7++;
                    if (i7 >= 16 && this.f37022b.Y0(this)) {
                        this.f37022b.T0(this, this);
                        return;
                    }
                }
            }
            synchronized (this.f37026f) {
                this.runningWorkers--;
                if (this.f37025e.c() == 0) {
                    return;
                }
                this.runningWorkers++;
                l2 l2Var = l2.f34958a;
            }
        }
    }

    @Override // kotlinx.coroutines.f1
    public void s(long j7, @a7.d kotlinx.coroutines.q<? super l2> qVar) {
        this.f37024d.s(j7, qVar);
    }

    @Override // kotlinx.coroutines.f1
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @a7.e
    public Object s0(long j7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return this.f37024d.s0(j7, dVar);
    }
}
