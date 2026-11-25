package kotlinx.coroutines.scheduling;

import com.google.common.util.concurrent.h2;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f37200b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37201c = AtomicIntegerFieldUpdater.newUpdater(q.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37202d = AtomicIntegerFieldUpdater.newUpdater(q.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37203e = AtomicIntegerFieldUpdater.newUpdater(q.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final AtomicReferenceArray<k> f37204a = new AtomicReferenceArray<>(128);

    @a7.d
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @a7.d
    private volatile /* synthetic */ int producerIndex = 0;

    @a7.d
    private volatile /* synthetic */ int consumerIndex = 0;

    @a7.d
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ k b(q qVar, k kVar, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return qVar.a(kVar, z7);
    }

    private final k c(k kVar) {
        if (kVar.f37186b.Q() == 1) {
            f37203e.incrementAndGet(this);
        }
        if (e() == 127) {
            return kVar;
        }
        int i7 = this.producerIndex & 127;
        while (this.f37204a.get(i7) != null) {
            Thread.yield();
        }
        this.f37204a.lazySet(i7, kVar);
        f37201c.incrementAndGet(this);
        return null;
    }

    private final void d(k kVar) {
        if (kVar != null) {
            if (kVar.f37186b.Q() == 1) {
                f37203e.decrementAndGet(this);
            }
        }
    }

    private final k i() {
        k andSet;
        while (true) {
            int i7 = this.consumerIndex;
            if (i7 - this.producerIndex == 0) {
                return null;
            }
            int i8 = i7 & 127;
            if (f37202d.compareAndSet(this, i7, i7 + 1) && (andSet = this.f37204a.getAndSet(i8, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(f fVar) {
        k kVarI = i();
        if (kVarI == null) {
            return false;
        }
        fVar.a(kVarI);
        return true;
    }

    private final long m(q qVar, boolean z7) {
        k kVar;
        do {
            kVar = (k) qVar.lastScheduledTask;
            if (kVar == null) {
                return -2L;
            }
            if (z7) {
                if (!(kVar.f37186b.Q() == 1)) {
                    return -2L;
                }
            }
            long jA = o.f37194f.a() - kVar.f37185a;
            long j7 = o.f37190b;
            if (jA < j7) {
                return j7 - jA;
            }
        } while (!androidx.concurrent.futures.b.a(f37200b, qVar, kVar, null));
        b(this, kVar, false, 2, null);
        return -1L;
    }

    @a7.e
    public final k a(@a7.d k kVar, boolean z7) {
        if (z7) {
            return c(kVar);
        }
        k kVar2 = (k) f37200b.getAndSet(this, kVar);
        if (kVar2 == null) {
            return null;
        }
        return c(kVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@a7.d f fVar) {
        k kVar = (k) f37200b.getAndSet(this, null);
        if (kVar != null) {
            fVar.a(kVar);
        }
        while (j(fVar)) {
        }
    }

    @a7.e
    public final k h() {
        k kVar = (k) f37200b.getAndSet(this, null);
        return kVar == null ? i() : kVar;
    }

    public final long k(@a7.d q qVar) {
        int i7 = qVar.consumerIndex;
        int i8 = qVar.producerIndex;
        AtomicReferenceArray<k> atomicReferenceArray = qVar.f37204a;
        while (true) {
            if (i7 == i8) {
                break;
            }
            int i9 = i7 & 127;
            if (qVar.blockingTasksInBuffer == 0) {
                break;
            }
            k kVar = atomicReferenceArray.get(i9);
            if (kVar != null) {
                if ((kVar.f37186b.Q() == 1) && h2.a(atomicReferenceArray, i9, kVar, null)) {
                    f37203e.decrementAndGet(qVar);
                    b(this, kVar, false, 2, null);
                    return -1L;
                }
            }
            i7++;
        }
        return m(qVar, true);
    }

    public final long l(@a7.d q qVar) {
        k kVarI = qVar.i();
        if (kVarI == null) {
            return m(qVar, false);
        }
        b(this, kVarI, false, 2, null);
        return -1L;
    }
}
