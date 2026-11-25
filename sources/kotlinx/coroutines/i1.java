package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class i1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f36931a;

    public i1(@a7.d kotlin.coroutines.g gVar) {
        this.f36931a = gVar;
    }

    @Override // java.lang.Throwable
    @a7.d
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    @a7.d
    public String getLocalizedMessage() {
        return this.f36931a.toString();
    }
}
