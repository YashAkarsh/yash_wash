package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
final class y3 implements i5.l<Throwable, kotlin.l2> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37383d = AtomicIntegerFieldUpdater.newUpdater(y3.class, "_state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final o2 f37384a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private q1 f37386c;

    @a7.d
    private volatile /* synthetic */ int _state = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f37385b = Thread.currentThread();

    public y3(@a7.d o2 o2Var) {
        this.f37384a = o2Var;
    }

    private final Void d(int i7) {
        throw new IllegalStateException(kotlin.jvm.internal.l0.C("Illegal state ", Integer.valueOf(i7)).toString());
    }

    public final void b() {
        while (true) {
            int i7 = this._state;
            if (i7 != 0) {
                if (i7 != 2) {
                    if (i7 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        d(i7);
                        throw new kotlin.y();
                    }
                }
            } else if (f37383d.compareAndSet(this, i7, 1)) {
                q1 q1Var = this.f37386c;
                if (q1Var == null) {
                    return;
                }
                q1Var.F();
                return;
            }
        }
    }

    public void e(@a7.e Throwable th) {
        int i7;
        do {
            i7 = this._state;
            if (i7 != 0) {
                if (i7 == 1 || i7 == 2 || i7 == 3) {
                    return;
                }
                d(i7);
                throw new kotlin.y();
            }
        } while (!f37383d.compareAndSet(this, i7, 2));
        this.f37385b.interrupt();
        this._state = 3;
    }

    public final void f() {
        int i7;
        this.f37386c = this.f37384a.J0(true, true, this);
        do {
            i7 = this._state;
            if (i7 != 0) {
                if (i7 == 2 || i7 == 3) {
                    return;
                }
                d(i7);
                throw new kotlin.y();
            }
        } while (!f37383d.compareAndSet(this, i7, 0));
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        e(th);
        return kotlin.l2.f34958a;
    }
}
