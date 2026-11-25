package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    public static final d f37167h = new d();

    private d() {
        super(o.f37191c, o.f37192d, o.f37193e, o.f37189a);
    }

    public final void A1() {
        super.close();
    }

    @Override // kotlinx.coroutines.scheduling.i, kotlinx.coroutines.a2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public String toString() {
        return "Dispatchers.Default";
    }
}
