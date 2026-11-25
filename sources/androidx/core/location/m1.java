package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f6007h = Long.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6008i = 100;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6009j = 102;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6010k = 104;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f6011l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f6012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f6013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f6014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f6015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f6016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final float f6017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f6018g;

    @c.t0(19)
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Class<?> f6019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f6020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f6021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Method f6022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Method f6023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static Method f6024f;

        private a() {
        }

        public static Object a(m1 m1Var, String str) {
            try {
                if (f6019a == null) {
                    f6019a = Class.forName("android.location.LocationRequest");
                }
                if (f6020b == null) {
                    Method declaredMethod = f6019a.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                    f6020b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object objInvoke = f6020b.invoke(null, str, Long.valueOf(m1Var.b()), Float.valueOf(m1Var.e()), Boolean.FALSE);
                if (objInvoke == null) {
                    return null;
                }
                if (f6021c == null) {
                    Method declaredMethod2 = f6019a.getDeclaredMethod("setQuality", Integer.TYPE);
                    f6021c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f6021c.invoke(objInvoke, Integer.valueOf(m1Var.g()));
                if (f6022d == null) {
                    Method declaredMethod3 = f6019a.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    f6022d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f6022d.invoke(objInvoke, Long.valueOf(m1Var.f()));
                if (m1Var.d() < Integer.MAX_VALUE) {
                    if (f6023e == null) {
                        Method declaredMethod4 = f6019a.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        f6023e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f6023e.invoke(objInvoke, Integer.valueOf(m1Var.d()));
                }
                if (m1Var.a() < Long.MAX_VALUE) {
                    if (f6024f == null) {
                        Method declaredMethod5 = f6019a.getDeclaredMethod("setExpireIn", Long.TYPE);
                        f6024f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f6024f.invoke(objInvoke, Long.valueOf(m1Var.a()));
                }
                return objInvoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @c.t0(31)
    private static class b {
        private b() {
        }

        @c.t
        public static LocationRequest a(m1 m1Var) {
            v1.a();
            return u1.a(m1Var.b()).setQuality(m1Var.g()).setMinUpdateIntervalMillis(m1Var.f()).setDurationMillis(m1Var.a()).setMaxUpdates(m1Var.d()).setMinUpdateDistanceMeters(m1Var.e()).setMaxUpdateDelayMillis(m1Var.c()).build();
        }
    }

    @c.x0({c.x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    m1(long j7, int i7, long j8, int i8, long j9, float f8, long j10) {
        this.f6013b = j7;
        this.f6012a = i7;
        this.f6014c = j9;
        this.f6015d = j8;
        this.f6016e = i8;
        this.f6017f = f8;
        this.f6018g = j10;
    }

    @c.e0(from = 1)
    public long a() {
        return this.f6015d;
    }

    @c.e0(from = 0)
    public long b() {
        return this.f6013b;
    }

    @c.e0(from = 0)
    public long c() {
        return this.f6018g;
    }

    @c.e0(from = 1, to = 2147483647L)
    public int d() {
        return this.f6016e;
    }

    @c.v(from = 0.0d, to = 3.4028234663852886E38d)
    public float e() {
        return this.f6017f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f6012a == m1Var.f6012a && this.f6013b == m1Var.f6013b && this.f6014c == m1Var.f6014c && this.f6015d == m1Var.f6015d && this.f6016e == m1Var.f6016e && Float.compare(m1Var.f6017f, this.f6017f) == 0 && this.f6018g == m1Var.f6018g;
    }

    @c.e0(from = 0)
    public long f() {
        long j7 = this.f6014c;
        return j7 == -1 ? this.f6013b : j7;
    }

    public int g() {
        return this.f6012a;
    }

    @c.t0(31)
    @c.m0
    public LocationRequest h() {
        return b.a(this);
    }

    public int hashCode() {
        int i7 = this.f6012a * 31;
        long j7 = this.f6013b;
        int i8 = (i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.f6014c;
        return i8 + ((int) (j8 ^ (j8 >>> 32)));
    }

    @c.o0
    @c.t0(19)
    @SuppressLint({"NewApi"})
    public LocationRequest i(@c.m0 String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : l1.a(a.a(this, str));
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.f6013b != Long.MAX_VALUE) {
            sb.append("@");
            androidx.core.util.h0.e(this.f6013b, sb);
            int i7 = this.f6012a;
            if (i7 == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i7 == 102) {
                sb.append(" BALANCED");
            } else if (i7 == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.f6015d != Long.MAX_VALUE) {
            sb.append(", duration=");
            androidx.core.util.h0.e(this.f6015d, sb);
        }
        if (this.f6016e != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f6016e);
        }
        long j7 = this.f6014c;
        if (j7 != -1 && j7 < this.f6013b) {
            sb.append(", minUpdateInterval=");
            androidx.core.util.h0.e(this.f6014c, sb);
        }
        if (this.f6017f > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f6017f);
        }
        if (this.f6018g / 2 > this.f6013b) {
            sb.append(", maxUpdateDelay=");
            androidx.core.util.h0.e(this.f6018g, sb);
        }
        sb.append(']');
        return sb.toString();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f6025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f6027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f6028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f6029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f6030f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f6031g;

        public c(long j7) {
            d(j7);
            this.f6026b = 102;
            this.f6027c = Long.MAX_VALUE;
            this.f6028d = Integer.MAX_VALUE;
            this.f6029e = -1L;
            this.f6030f = 0.0f;
            this.f6031g = 0L;
        }

        @c.m0
        public m1 a() {
            androidx.core.util.w.o((this.f6025a == Long.MAX_VALUE && this.f6029e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j7 = this.f6025a;
            return new m1(j7, this.f6026b, this.f6027c, this.f6028d, Math.min(this.f6029e, j7), this.f6030f, this.f6031g);
        }

        @c.m0
        public c b() {
            this.f6029e = -1L;
            return this;
        }

        @c.m0
        public c c(@c.e0(from = 1) long j7) {
            this.f6027c = androidx.core.util.w.h(j7, 1L, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @c.m0
        public c d(@c.e0(from = 0) long j7) {
            this.f6025a = androidx.core.util.w.h(j7, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @c.m0
        public c e(@c.e0(from = 0) long j7) {
            this.f6031g = j7;
            this.f6031g = androidx.core.util.w.h(j7, 0L, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @c.m0
        public c f(@c.e0(from = 1, to = 2147483647L) int i7) {
            this.f6028d = androidx.core.util.w.g(i7, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @c.m0
        public c g(@c.v(from = 0.0d, to = 3.4028234663852886E38d) float f8) {
            this.f6030f = f8;
            this.f6030f = androidx.core.util.w.f(f8, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @c.m0
        public c h(@c.e0(from = 0) long j7) {
            this.f6029e = androidx.core.util.w.h(j7, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @c.m0
        public c i(int i7) {
            androidx.core.util.w.c(i7 == 104 || i7 == 102 || i7 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i7));
            this.f6026b = i7;
            return this;
        }

        public c(@c.m0 m1 m1Var) {
            this.f6025a = m1Var.f6013b;
            this.f6026b = m1Var.f6012a;
            this.f6027c = m1Var.f6015d;
            this.f6028d = m1Var.f6016e;
            this.f6029e = m1Var.f6014c;
            this.f6030f = m1Var.f6017f;
            this.f6031g = m1Var.f6018g;
        }
    }
}
