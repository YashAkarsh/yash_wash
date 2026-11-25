package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o0<S extends o0<S>> extends h<S> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37012d = AtomicIntegerFieldUpdater.newUpdater(o0.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f37013c;

    @a7.d
    private volatile /* synthetic */ int cleanedAndPointers;

    public o0(long j7, @a7.e S s7, int i7) {
        super(s7);
        this.f37013c = j7;
        this.cleanedAndPointers = i7 << 16;
    }

    @Override // kotlinx.coroutines.internal.h
    public boolean g() {
        return this.cleanedAndPointers == p() && !i();
    }

    public final boolean n() {
        return f37012d.addAndGet(this, k.a.f34390c) == p() && !i();
    }

    public final long o() {
        return this.f37013c;
    }

    public abstract int p();

    public final void q() {
        if (f37012d.incrementAndGet(this) != p() || i()) {
            return;
        }
        l();
    }

    public final boolean r() {
        int i7;
        do {
            i7 = this.cleanedAndPointers;
            if (!(i7 != p() || i())) {
                return false;
            }
        } while (!f37012d.compareAndSet(this, i7, 65536 + i7));
        return true;
    }
}
