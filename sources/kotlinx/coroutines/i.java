package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends v1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final Thread f36930g;

    public i(@a7.d Thread thread) {
        this.f36930g = thread;
    }

    @Override // kotlinx.coroutines.w1
    @a7.d
    protected Thread Z1() {
        return this.f36930g;
    }
}
