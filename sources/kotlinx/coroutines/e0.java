package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f35987b = AtomicIntegerFieldUpdater.newUpdater(e0.class, "_handled");

    @a7.d
    private volatile /* synthetic */ int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final Throwable f35988a;

    public e0(@a7.d Throwable th, boolean z7) {
        this.f35988a = th;
        this._handled = z7 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f35987b.compareAndSet(this, 0, 1);
    }

    @a7.d
    public String toString() {
        return a1.a(this) + '[' + this.f35988a + ']';
    }

    public /* synthetic */ e0(Throwable th, boolean z7, int i7, kotlin.jvm.internal.w wVar) {
        this(th, (i7 & 2) != 0 ? false : z7);
    }
}
