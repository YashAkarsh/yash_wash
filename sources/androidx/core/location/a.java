package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.GpsStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5940a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5941b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5942c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5943d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5944e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5945f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5946g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f5947h = 7;

    /* JADX INFO: renamed from: androidx.core.location.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0065a {
        public void a(@c.e0(from = 0) int i7) {
        }

        public void b(@c.m0 a aVar) {
        }

        public void c() {
        }

        public void d() {
        }
    }

    @c.x0({c.x0.a.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    a() {
    }

    @c.t0(24)
    @c.m0
    public static a n(@c.m0 GnssStatus gnssStatus) {
        return new p(gnssStatus);
    }

    @c.m0
    @SuppressLint({"ReferencesDeprecated"})
    public static a o(@c.m0 GpsStatus gpsStatus) {
        return new s(gpsStatus);
    }

    @c.v(from = 0.0d, to = 360.0d)
    public abstract float a(@c.e0(from = 0) int i7);

    @c.v(from = 0.0d, to = 63.0d)
    public abstract float b(@c.e0(from = 0) int i7);

    @c.v(from = 0.0d)
    public abstract float c(@c.e0(from = 0) int i7);

    @c.v(from = 0.0d, to = 63.0d)
    public abstract float d(@c.e0(from = 0) int i7);

    public abstract int e(@c.e0(from = 0) int i7);

    @c.v(from = -90.0d, to = 90.0d)
    public abstract float f(@c.e0(from = 0) int i7);

    @c.e0(from = 0)
    public abstract int g();

    @c.e0(from = 1, to = 200)
    public abstract int h(@c.e0(from = 0) int i7);

    public abstract boolean i(@c.e0(from = 0) int i7);

    public abstract boolean j(@c.e0(from = 0) int i7);

    public abstract boolean k(@c.e0(from = 0) int i7);

    public abstract boolean l(@c.e0(from = 0) int i7);

    public abstract boolean m(@c.e0(from = 0) int i7);
}
