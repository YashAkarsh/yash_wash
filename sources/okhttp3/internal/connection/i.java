package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.l0;
import okhttp3.Route;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Route> f37837a = new LinkedHashSet();

    public final synchronized void a(@a7.d Route route) {
        l0.p(route, "route");
        this.f37837a.remove(route);
    }

    public final synchronized void b(@a7.d Route failedRoute) {
        l0.p(failedRoute, "failedRoute");
        this.f37837a.add(failedRoute);
    }

    public final synchronized boolean c(@a7.d Route route) {
        l0.p(route, "route");
        return this.f37837a.contains(route);
    }
}
