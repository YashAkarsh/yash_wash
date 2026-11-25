package junit.framework;

/* JADX INFO: loaded from: classes2.dex */
public class g implements i, org.junit.runner.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runner.c f34361a;

    g(org.junit.runner.c cVar) {
        this.f34361a = cVar;
    }

    @Override // junit.framework.i
    public int a() {
        return 1;
    }

    @Override // org.junit.runner.b
    public org.junit.runner.c b() {
        return this.f34361a;
    }

    @Override // junit.framework.i
    public void c(m mVar) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    public String toString() {
        return b().toString();
    }
}
