package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.a2;

/* JADX INFO: loaded from: classes3.dex */
final class g extends a2 implements l, Executor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37173h = AtomicIntegerFieldUpdater.newUpdater(g.class, "inFlightTasks");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final e f37174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private final String f37176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f37177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final ConcurrentLinkedQueue<Runnable> f37178g = new ConcurrentLinkedQueue<>();

    @a7.d
    private volatile /* synthetic */ int inFlightTasks = 0;

    public g(@a7.d e eVar, int i7, @a7.e String str, int i8) {
        this.f37174c = eVar;
        this.f37175d = i7;
        this.f37176e = str;
        this.f37177f = i8;
    }

    private final void i1(Runnable runnable, boolean z7) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f37173h;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f37175d) {
                this.f37174c.w1(runnable, this, z7);
                return;
            }
            this.f37178g.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f37175d) {
                return;
            } else {
                runnable = this.f37178g.poll();
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.scheduling.l
    public void G() {
        Runnable runnablePoll = this.f37178g.poll();
        if (runnablePoll != null) {
            this.f37174c.w1(runnablePoll, this, true);
            return;
        }
        f37173h.decrementAndGet(this);
        Runnable runnablePoll2 = this.f37178g.poll();
        if (runnablePoll2 == null) {
            return;
        }
        i1(runnablePoll2, true);
    }

    @Override // kotlinx.coroutines.scheduling.l
    public int Q() {
        return this.f37177f;
    }

    @Override // kotlinx.coroutines.o0
    public void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        i1(runnable, false);
    }

    @Override // kotlinx.coroutines.o0
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        i1(runnable, true);
    }

    @Override // kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.a2
    @a7.d
    public Executor e1() {
        return this;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@a7.d Runnable runnable) {
        i1(runnable, false);
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        String str = this.f37176e;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f37174c + ']';
    }
}
