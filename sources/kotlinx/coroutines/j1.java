package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class j1<T> extends kotlinx.coroutines.internal.n0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37061d = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_decision");

    @a7.d
    private volatile /* synthetic */ int _decision;

    public j1(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        super(gVar, dVar);
        this._decision = 0;
    }

    private final boolean H1() {
        do {
            int i7 = this._decision;
            if (i7 != 0) {
                if (i7 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f37061d.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean I1() {
        do {
            int i7 = this._decision;
            if (i7 != 0) {
                if (i7 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f37061d.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.n0, kotlinx.coroutines.a
    protected void A1(@a7.e Object obj) {
        if (H1()) {
            return;
        }
        kotlinx.coroutines.internal.m.g(kotlin.coroutines.intrinsics.c.d(this.f37009c), k0.a(obj, this.f37009c), null, 2, null);
    }

    @a7.e
    public final Object G1() {
        if (I1()) {
            return kotlin.coroutines.intrinsics.d.h();
        }
        Object objO = x2.o(N0());
        if (objO instanceof e0) {
            throw ((e0) objO).f35988a;
        }
        return objO;
    }

    @Override // kotlinx.coroutines.internal.n0, kotlinx.coroutines.w2
    protected void Z(@a7.e Object obj) {
        A1(obj);
    }
}
