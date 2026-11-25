package bolts;

/* JADX INFO: loaded from: classes.dex */
public class q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p<TResult> f11454a = new p<>();

    public p<TResult> a() {
        return this.f11454a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(TResult tresult) {
        if (!g(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.f11454a.V();
    }

    public boolean f(Exception exc) {
        return this.f11454a.W(exc);
    }

    public boolean g(TResult tresult) {
        return this.f11454a.X(tresult);
    }
}
