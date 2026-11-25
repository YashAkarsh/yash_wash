package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f11368a;

    i(k kVar) {
        this.f11368a = kVar;
    }

    public boolean a() {
        return this.f11368a.u();
    }

    public j b(Runnable runnable) {
        return this.f11368a.C(runnable);
    }

    public void c() throws CancellationException {
        this.f11368a.E();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f11368a.u()));
    }
}
