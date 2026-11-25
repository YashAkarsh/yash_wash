package okhttp3.internal.concurrent;

import a7.e;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @e
    private c f37718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f37719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final String f37720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f37721d;

    public a(@a7.d String name, boolean z7) {
        l0.p(name, "name");
        this.f37720c = name;
        this.f37721d = z7;
        this.f37719b = -1L;
    }

    public final boolean a() {
        return this.f37721d;
    }

    @a7.d
    public final String b() {
        return this.f37720c;
    }

    public final long c() {
        return this.f37719b;
    }

    @e
    public final c d() {
        return this.f37718a;
    }

    public final void e(@a7.d c queue) {
        l0.p(queue, "queue");
        c cVar = this.f37718a;
        if (cVar == queue) {
            return;
        }
        if (!(cVar == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f37718a = queue;
    }

    public abstract long f();

    public final void g(long j7) {
        this.f37719b = j7;
    }

    public final void h(@e c cVar) {
        this.f37718a = cVar;
    }

    @a7.d
    public String toString() {
        return this.f37720c;
    }

    public /* synthetic */ a(String str, boolean z7, int i7, w wVar) {
        this(str, (i7 & 2) != 0 ? true : z7);
    }
}
