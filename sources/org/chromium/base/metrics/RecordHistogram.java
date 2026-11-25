package org.chromium.base.metrics;

import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;
import org.chromium.base.s0;
import x6.c;
import x6.e;

/* JADX INFO: loaded from: classes3.dex */
@c("base::android")
@e
public class RecordHistogram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Throwable f38836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Long> f38837b = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38838c = false;

    private static int a(long j7) {
        if (j7 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j7 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j7;
    }

    private static long b(String str) {
        Long l7 = f38837b.get(str);
        if (l7 == null) {
            return 0L;
        }
        return l7.longValue();
    }

    @s0
    public static int c(String str) {
        return nativeGetHistogramTotalCountForTesting(str);
    }

    @s0
    public static int d(String str, int i7) {
        return nativeGetHistogramValueCountForTesting(str, i7);
    }

    public static void e(String str, boolean z7) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordBooleanHistogram = nativeRecordBooleanHistogram(str, jB, z7);
        if (jNativeRecordBooleanHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordBooleanHistogram));
        }
    }

    public static void f(String str, int i7) {
        i(str, i7, 1, 1000, 50);
    }

    public static void g(String str, int i7) {
        i(str, i7, 1, 100, 50);
    }

    public static void h(String str, int i7) {
        i(str, i7, 1, 1000000, 50);
    }

    public static void i(String str, int i7, int i8, int i9, int i10) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordCustomCountHistogram = nativeRecordCustomCountHistogram(str, jB, i7, i8, i9, i10);
        if (jNativeRecordCustomCountHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordCustomCountHistogram));
        }
    }

    public static void j(String str, long j7, long j8, long j9, int i7) {
        k(str, j7, j8, j9, i7);
    }

    private static void k(String str, long j7, long j8, long j9, int i7) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordCustomTimesHistogramMilliseconds = nativeRecordCustomTimesHistogramMilliseconds(str, jB, a(j7), a(j8), a(j9), i7);
        if (jNativeRecordCustomTimesHistogramMilliseconds != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordCustomTimesHistogramMilliseconds));
        }
    }

    public static void l(String str, int i7, int i8) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordEnumeratedHistogram = nativeRecordEnumeratedHistogram(str, jB, i7, i8);
        if (jNativeRecordEnumeratedHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordEnumeratedHistogram));
        }
    }

    public static void m(String str, int i7, int i8, int i9, int i10) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordLinearCountHistogram = nativeRecordLinearCountHistogram(str, jB, i7, i8, i9, i10);
        if (jNativeRecordLinearCountHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordLinearCountHistogram));
        }
    }

    public static void n(String str, long j7) {
        k(str, j7, 1L, DateUtils.MILLIS_PER_HOUR, 50);
    }

    private static native int nativeGetHistogramTotalCountForTesting(String str);

    private static native int nativeGetHistogramValueCountForTesting(String str, int i7);

    private static native long nativeRecordBooleanHistogram(String str, long j7, boolean z7);

    private static native long nativeRecordCustomCountHistogram(String str, long j7, int i7, int i8, int i9, int i10);

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j7, int i7, int i8, int i9, int i10);

    private static native long nativeRecordEnumeratedHistogram(String str, long j7, int i7, int i8);

    private static native long nativeRecordLinearCountHistogram(String str, long j7, int i7, int i8, int i9, int i10);

    private static native long nativeRecordSparseHistogram(String str, long j7, int i7);

    public static void o(String str, long j7) {
        k(str, j7, 1L, DateUtils.MILLIS_PER_HOUR, 100);
    }

    public static void p(String str, long j7) {
        k(str, j7, 10L, 180000L, 50);
    }

    public static void q(String str, int i7) {
        i(str, i7, 1000, 500000, 50);
    }

    public static void r(String str, int i7) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordEnumeratedHistogram = nativeRecordEnumeratedHistogram(str, jB, i7, 101);
        if (jNativeRecordEnumeratedHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordEnumeratedHistogram));
        }
    }

    public static void s(String str, int i7) {
        if (f38836a != null) {
            return;
        }
        long jB = b(str);
        long jNativeRecordSparseHistogram = nativeRecordSparseHistogram(str, jB, i7);
        if (jNativeRecordSparseHistogram != jB) {
            f38837b.put(str, Long.valueOf(jNativeRecordSparseHistogram));
        }
    }

    public static void t(String str, long j7) {
        k(str, j7, 1L, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT, 50);
    }

    @s0
    public static void u(boolean z7) {
        if (z7 && f38836a != null) {
            throw new IllegalStateException("Histograms are already disabled.", f38836a);
        }
        f38836a = z7 ? new Throwable() : null;
    }
}
