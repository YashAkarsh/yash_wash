package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.t0;
import kotlinx.coroutines.internal.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final String f37189a = "DefaultDispatcher";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f37195g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f37196h = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public static final long f37190b = v0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public static final int f37191c = v0.d("kotlinx.coroutines.scheduler.core.pool.size", kotlin.ranges.q.n(t0.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    public static final int f37192d = v0.d("kotlinx.coroutines.scheduler.max.pool.size", a.f37139v, 0, a.f37139v, 4, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    public static final long f37193e = TimeUnit.SECONDS.toNanos(v0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @h5.e
    public static j f37194f = h.f37179a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final l f37197i = new m(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final l f37198j = new m(1);

    public static final boolean a(@a7.d k kVar) {
        return kVar.f37186b.Q() == 1;
    }
}
