package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class a4<U, T extends U> extends kotlinx.coroutines.internal.n0<T> implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    public final long f35502d;

    public a4(long j7, @a7.d kotlin.coroutines.d<? super U> dVar) {
        super(dVar.d(), dVar);
        this.f35502d = j7;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.w2
    @a7.d
    public String c1() {
        return super.c1() + "(timeMillis=" + this.f35502d + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        d0(b4.a(this.f35502d, this));
    }
}
