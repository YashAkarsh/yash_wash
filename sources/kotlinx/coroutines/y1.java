package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37375b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37376c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f37377d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f37378e = 1000000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f37379f = 9223372036854L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f37380g = 4611686018427387903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.internal.r0 f37374a = new kotlinx.coroutines.internal.r0("REMOVED_TASK");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.internal.r0 f37381h = new kotlinx.coroutines.internal.r0("CLOSED_EMPTY");

    public static final long c(long j7) {
        return j7 / f37378e;
    }

    public static final long d(long j7) {
        if (j7 <= 0) {
            return 0L;
        }
        if (j7 >= f37379f) {
            return Long.MAX_VALUE;
        }
        return f37378e * j7;
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }
}
