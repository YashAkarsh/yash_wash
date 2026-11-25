package kotlin.time;

import kotlin.g1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public final class p extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f35480c;

    public p() {
        super(g.NANOSECONDS);
    }

    private final void d(long j7) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f35480c + "ns is advanced by " + ((Object) d.q0(j7)) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @Override // kotlin.time.b
    protected long c() {
        return this.f35480c;
    }

    public final void e(long j7) {
        long j8;
        long jN0 = d.n0(j7, b());
        if (jN0 == Long.MIN_VALUE || jN0 == Long.MAX_VALUE) {
            double dK0 = this.f35480c + d.k0(j7, b());
            if (dK0 > 9.223372036854776E18d || dK0 < -9.223372036854776E18d) {
                d(j7);
            }
            j8 = (long) dK0;
        } else {
            long j9 = this.f35480c;
            j8 = j9 + jN0;
            if ((jN0 ^ j9) >= 0 && (j9 ^ j8) < 0) {
                d(j7);
            }
        }
        this.f35480c = j8;
    }
}
