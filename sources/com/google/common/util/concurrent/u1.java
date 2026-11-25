package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f22907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @v1.a("lock")
    private b f22908c;

    class a extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ BooleanSupplier f22909e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u1 u1Var, BooleanSupplier booleanSupplier) {
            super(u1Var);
            this.f22909e = booleanSupplier;
        }

        @Override // com.google.common.util.concurrent.u1.b
        public boolean a() {
            return this.f22909e.getAsBoolean();
        }
    }

    @s1.a
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final u1 f22911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Condition f22912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.a("monitor.lock")
        int f22913c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @v1.a("monitor.lock")
        b f22914d;

        protected b(u1 u1Var) {
            this.f22911a = (u1) com.google.common.base.e0.F(u1Var, "monitor");
            this.f22912b = u1Var.f22907b.newCondition();
        }

        public abstract boolean a();
    }

    public u1() {
        this(false);
    }

    @v1.a("lock")
    private boolean C(b bVar) {
        try {
            return bVar.a();
        } catch (Throwable th) {
            G();
            throw th;
        }
    }

    private static long F(long j7, long j8) {
        if (j8 <= 0) {
            return 0L;
        }
        return j8 - (System.nanoTime() - j7);
    }

    @v1.a("lock")
    private void G() {
        for (b bVar = this.f22908c; bVar != null; bVar = bVar.f22914d) {
            bVar.f22912b.signalAll();
        }
    }

    @v1.a("lock")
    private void H() {
        for (b bVar = this.f22908c; bVar != null; bVar = bVar.f22914d) {
            if (C(bVar)) {
                bVar.f22912b.signal();
                return;
            }
        }
    }

    private static long I(long j7, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j7);
        long j8 = 0;
        if (nanos > 0) {
            j8 = 6917529027641081853L;
            if (nanos <= 6917529027641081853L) {
                return nanos;
            }
        }
        return j8;
    }

    @v1.a("lock")
    private void b(b bVar, boolean z7) throws InterruptedException {
        if (z7) {
            H();
        }
        e(bVar);
        do {
            try {
                bVar.f22912b.await();
            } finally {
                f(bVar);
            }
        } while (!bVar.a());
    }

    @v1.a("lock")
    private boolean c(b bVar, long j7, boolean z7) throws InterruptedException {
        boolean z8 = true;
        while (j7 > 0) {
            if (z8) {
                if (z7) {
                    try {
                        H();
                    } catch (Throwable th) {
                        if (!z8) {
                            f(bVar);
                        }
                        throw th;
                    }
                }
                e(bVar);
                z8 = false;
            }
            j7 = bVar.f22912b.awaitNanos(j7);
            if (bVar.a()) {
                if (!z8) {
                    f(bVar);
                }
                return true;
            }
        }
        if (!z8) {
            f(bVar);
        }
        return false;
    }

    @v1.a("lock")
    private void d(b bVar, boolean z7) {
        if (z7) {
            H();
        }
        e(bVar);
        do {
            try {
                bVar.f22912b.awaitUninterruptibly();
            } finally {
                f(bVar);
            }
        } while (!bVar.a());
    }

    @v1.a("lock")
    private void e(b bVar) {
        int i7 = bVar.f22913c;
        bVar.f22913c = i7 + 1;
        if (i7 == 0) {
            bVar.f22914d = this.f22908c;
            this.f22908c = bVar;
        }
    }

    @v1.a("lock")
    private void f(b bVar) {
        int i7 = bVar.f22913c - 1;
        bVar.f22913c = i7;
        if (i7 == 0) {
            b bVar2 = this.f22908c;
            b bVar3 = null;
            while (bVar2 != bVar) {
                bVar3 = bVar2;
                bVar2 = bVar2.f22914d;
            }
            if (bVar3 == null) {
                this.f22908c = bVar2.f22914d;
            } else {
                bVar3.f22914d = bVar2.f22914d;
            }
            bVar2.f22914d = null;
        }
    }

    private static long y(long j7) {
        if (j7 <= 0) {
            return 0L;
        }
        long jNanoTime = System.nanoTime();
        if (jNanoTime == 0) {
            return 1L;
        }
        return jNanoTime;
    }

    public boolean A() {
        return this.f22907b.isLocked();
    }

    public boolean B() {
        return this.f22907b.isHeldByCurrentThread();
    }

    public void D() {
        ReentrantLock reentrantLock = this.f22907b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                H();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public b E(BooleanSupplier booleanSupplier) {
        com.google.common.base.e0.F(booleanSupplier, "isSatisfied");
        return new a(this, booleanSupplier);
    }

    public boolean J() {
        return this.f22907b.tryLock();
    }

    public boolean K(b bVar) {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean zA = bVar.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void L(b bVar) throws InterruptedException {
        if (!(bVar.f22911a == this) || !this.f22907b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (bVar.a()) {
            return;
        }
        b(bVar, true);
    }

    public boolean M(b bVar, long j7, TimeUnit timeUnit) throws InterruptedException {
        long jI = I(j7, timeUnit);
        if (!(bVar.f22911a == this) || !this.f22907b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (bVar.a()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return c(bVar, jI, true);
    }

    public void N(b bVar) {
        if (!(bVar.f22911a == this) || !this.f22907b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (bVar.a()) {
            return;
        }
        d(bVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    public boolean O(b bVar, long j7, TimeUnit timeUnit) throws Throwable {
        long jI = I(j7, timeUnit);
        boolean z7 = true;
        if (!(bVar.f22911a == this) || !this.f22907b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (bVar.a()) {
            return true;
        }
        long jY = y(jI);
        boolean zInterrupted = Thread.interrupted();
        long jF = jI;
        boolean z8 = true;
        while (true) {
            try {
                try {
                    boolean zC = c(bVar, jF, z8);
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return zC;
                } catch (Throwable th) {
                    th = th;
                    if (z7) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (bVar.a()) {
                    Thread.currentThread().interrupt();
                    return true;
                }
                jF = F(jY, jI);
                z8 = false;
                zInterrupted = true;
            } catch (Throwable th2) {
                th = th2;
                z7 = zInterrupted;
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    public void g() {
        this.f22907b.lock();
    }

    public boolean h(long j7, TimeUnit timeUnit) throws Throwable {
        boolean zTryLock;
        long jI = I(j7, timeUnit);
        ReentrantLock reentrantLock = this.f22907b;
        boolean z7 = true;
        if (!this.f22906a && reentrantLock.tryLock()) {
            return true;
        }
        boolean zInterrupted = Thread.interrupted();
        try {
            long jNanoTime = System.nanoTime();
            long jF = jI;
            while (true) {
                try {
                    try {
                        zTryLock = reentrantLock.tryLock(jF, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th) {
                        th = th;
                        if (z7) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    jF = F(jNanoTime, jI);
                    zInterrupted = true;
                }
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zTryLock;
        } catch (Throwable th2) {
            th = th2;
            z7 = zInterrupted;
        }
    }

    public boolean i(b bVar) {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        reentrantLock.lock();
        try {
            boolean zA = bVar.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean j(b bVar, long j7, TimeUnit timeUnit) {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        if (!h(j7, timeUnit)) {
            return false;
        }
        try {
            boolean zA = bVar.a();
            if (!zA) {
                this.f22907b.unlock();
            }
            return zA;
        } catch (Throwable th) {
            this.f22907b.unlock();
            throw th;
        }
    }

    public boolean k(b bVar) throws InterruptedException {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        reentrantLock.lockInterruptibly();
        try {
            boolean zA = bVar.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean l(b bVar, long j7, TimeUnit timeUnit) throws InterruptedException {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        if (!reentrantLock.tryLock(j7, timeUnit)) {
            return false;
        }
        try {
            boolean zA = bVar.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void m() throws InterruptedException {
        this.f22907b.lockInterruptibly();
    }

    public boolean n(long j7, TimeUnit timeUnit) throws InterruptedException {
        return this.f22907b.tryLock(j7, timeUnit);
    }

    public void o(b bVar) throws InterruptedException {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (bVar.a()) {
                return;
            }
            b(bVar, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            D();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    public boolean p(b bVar, long j7, TimeUnit timeUnit) throws InterruptedException {
        long jY;
        boolean z7;
        long jI = I(j7, timeUnit);
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        if (this.f22906a) {
            jY = y(jI);
            if (!reentrantLock.tryLock(j7, timeUnit)) {
                return false;
            }
        } else {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (reentrantLock.tryLock()) {
                jY = 0;
            } else {
                jY = y(jI);
                if (!reentrantLock.tryLock(j7, timeUnit)) {
                    return false;
                }
            }
        }
        try {
            if (!bVar.a()) {
                if (jY != 0) {
                    jI = F(jY, jI);
                }
                z7 = c(bVar, jI, zIsHeldByCurrentThread);
            }
            if (!z7) {
                reentrantLock.unlock();
            }
            return z7;
        } catch (Throwable th) {
            if (!zIsHeldByCurrentThread) {
                try {
                    H();
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw th;
        }
    }

    public void q(b bVar) {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (bVar.a()) {
                return;
            }
            d(bVar, zIsHeldByCurrentThread);
        } catch (Throwable th) {
            D();
            throw th;
        }
    }

    public boolean r(b bVar, long j7, TimeUnit timeUnit) throws Throwable {
        long jY;
        long jF;
        long jI = I(j7, timeUnit);
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f22907b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        boolean zInterrupted = Thread.interrupted();
        try {
            boolean zC = true;
            if (this.f22906a || !reentrantLock.tryLock()) {
                jY = y(jI);
                long jF2 = jI;
                while (true) {
                    try {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                            zInterrupted = true;
                            if (zInterrupted) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused) {
                        jF2 = F(jY, jI);
                        zInterrupted = true;
                    }
                }
                if (!reentrantLock.tryLock(jF2, TimeUnit.NANOSECONDS)) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
            } else {
                jY = 0;
            }
            while (!bVar.a()) {
                try {
                    if (jY == 0) {
                        jY = y(jI);
                        jF = jI;
                    } else {
                        jF = F(jY, jI);
                    }
                    zC = c(bVar, jF, zIsHeldByCurrentThread);
                } catch (InterruptedException unused2) {
                    zIsHeldByCurrentThread = false;
                    zInterrupted = zC;
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            if (!zC) {
                reentrantLock.unlock();
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zC;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public int s() {
        return this.f22907b.getHoldCount();
    }

    public int t() {
        return this.f22907b.getQueueLength();
    }

    public int u(b bVar) {
        if (bVar.f22911a != this) {
            throw new IllegalMonitorStateException();
        }
        this.f22907b.lock();
        try {
            return bVar.f22913c;
        } finally {
            this.f22907b.unlock();
        }
    }

    public boolean v(Thread thread) {
        return this.f22907b.hasQueuedThread(thread);
    }

    public boolean w() {
        return this.f22907b.hasQueuedThreads();
    }

    public boolean x(b bVar) {
        return u(bVar) > 0;
    }

    public boolean z() {
        return this.f22906a;
    }

    public u1(boolean z7) {
        this.f22908c = null;
        this.f22906a = z7;
        this.f22907b = new ReentrantLock(z7);
    }
}
