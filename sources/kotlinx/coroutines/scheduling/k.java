package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public long f37185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @h5.e
    public l f37186b;

    public k(long j7, @a7.d l lVar) {
        this.f37185a = j7;
        this.f37186b = lVar;
    }

    public final int a() {
        return this.f37186b.Q();
    }

    public k() {
        this(0L, o.f37197i);
    }
}
