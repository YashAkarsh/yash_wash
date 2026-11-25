package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
final class m2 extends q2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37085f = AtomicIntegerFieldUpdater.newUpdater(m2.class, "_invoked");

    @a7.d
    private volatile /* synthetic */ int _invoked = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final i5.l<Throwable, kotlin.l2> f37086e;

    /* JADX WARN: Multi-variable type inference failed */
    public m2(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        this.f37086e = lVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        if (f37085f.compareAndSet(this, 0, 1)) {
            this.f37086e.z(th);
        }
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
