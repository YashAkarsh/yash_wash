package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
@c.t0(24)
@c.x0({c.x0.a.LIBRARY})
class p extends androidx.core.location.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GnssStatus f6032i;

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static float a(GnssStatus gnssStatus, int i7) {
            return gnssStatus.getCarrierFrequencyHz(i7);
        }

        @c.t
        static boolean b(GnssStatus gnssStatus, int i7) {
            return gnssStatus.hasCarrierFrequencyHz(i7);
        }
    }

    @c.t0(30)
    static class b {
        private b() {
        }

        @c.t
        static float a(GnssStatus gnssStatus, int i7) {
            return gnssStatus.getBasebandCn0DbHz(i7);
        }

        @c.t
        static boolean b(GnssStatus gnssStatus, int i7) {
            return gnssStatus.hasBasebandCn0DbHz(i7);
        }
    }

    p(Object obj) {
        this.f6032i = c.a(androidx.core.util.w.l(c.a(obj)));
    }

    @Override // androidx.core.location.a
    public float a(int i7) {
        return this.f6032i.getAzimuthDegrees(i7);
    }

    @Override // androidx.core.location.a
    public float b(int i7) {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.a(this.f6032i, i7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.a
    public float c(int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.a(this.f6032i, i7);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.a
    public float d(int i7) {
        return this.f6032i.getCn0DbHz(i7);
    }

    @Override // androidx.core.location.a
    public int e(int i7) {
        return this.f6032i.getConstellationType(i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return this.f6032i.equals(((p) obj).f6032i);
        }
        return false;
    }

    @Override // androidx.core.location.a
    public float f(int i7) {
        return this.f6032i.getElevationDegrees(i7);
    }

    @Override // androidx.core.location.a
    public int g() {
        return this.f6032i.getSatelliteCount();
    }

    @Override // androidx.core.location.a
    public int h(int i7) {
        return this.f6032i.getSvid(i7);
    }

    public int hashCode() {
        return this.f6032i.hashCode();
    }

    @Override // androidx.core.location.a
    public boolean i(int i7) {
        return this.f6032i.hasAlmanacData(i7);
    }

    @Override // androidx.core.location.a
    public boolean j(int i7) {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.b(this.f6032i, i7);
        }
        return false;
    }

    @Override // androidx.core.location.a
    public boolean k(int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.b(this.f6032i, i7);
        }
        return false;
    }

    @Override // androidx.core.location.a
    public boolean l(int i7) {
        return this.f6032i.hasEphemerisData(i7);
    }

    @Override // androidx.core.location.a
    public boolean m(int i7) {
        return this.f6032i.usedInFix(i7);
    }
}
