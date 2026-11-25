package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
class s extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f6033n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f6034o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f6035p = 33;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f6036q = 64;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f6037r = -87;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f6038s = 64;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f6039t = 24;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f6040u = 193;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f6041v = 200;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f6042w = 200;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f6043x = 35;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GpsStatus f6044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.z("mWrapped")
    private int f6045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.z("mWrapped")
    private Iterator<GpsSatellite> f6046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c.z("mWrapped")
    private int f6047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.z("mWrapped")
    private GpsSatellite f6048m;

    s(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) androidx.core.util.w.l(gpsStatus);
        this.f6044i = gpsStatus2;
        this.f6045j = -1;
        this.f6046k = gpsStatus2.getSatellites().iterator();
        this.f6047l = -1;
        this.f6048m = null;
    }

    private static int p(int i7) {
        if (i7 > 0 && i7 <= 32) {
            return 1;
        }
        if (i7 >= 33 && i7 <= 64) {
            return 2;
        }
        if (i7 > 64 && i7 <= 88) {
            return 3;
        }
        if (i7 <= 200 || i7 > 235) {
            return (i7 < 193 || i7 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite q(int i7) {
        GpsSatellite gpsSatellite;
        synchronized (this.f6044i) {
            if (i7 < this.f6047l) {
                this.f6046k = this.f6044i.getSatellites().iterator();
                this.f6047l = -1;
            }
            while (true) {
                int i8 = this.f6047l;
                if (i8 >= i7) {
                    break;
                }
                this.f6047l = i8 + 1;
                if (!this.f6046k.hasNext()) {
                    this.f6048m = null;
                    break;
                }
                this.f6048m = this.f6046k.next();
            }
            gpsSatellite = this.f6048m;
        }
        return (GpsSatellite) androidx.core.util.w.l(gpsSatellite);
    }

    private static int r(int i7) {
        int iP = p(i7);
        if (iP == 2) {
            return i7 + 87;
        }
        if (iP != 3) {
            return iP != 5 ? i7 : i7 + org.chromium.net.v.D3;
        }
        return i7 - 64;
    }

    @Override // androidx.core.location.a
    public float a(int i7) {
        return q(i7).getAzimuth();
    }

    @Override // androidx.core.location.a
    public float b(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.a
    public float c(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.a
    public float d(int i7) {
        return q(i7).getSnr();
    }

    @Override // androidx.core.location.a
    public int e(int i7) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return p(q(i7).getPrn());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return this.f6044i.equals(((s) obj).f6044i);
        }
        return false;
    }

    @Override // androidx.core.location.a
    public float f(int i7) {
        return q(i7).getElevation();
    }

    @Override // androidx.core.location.a
    public int g() {
        int i7;
        synchronized (this.f6044i) {
            if (this.f6045j == -1) {
                for (GpsSatellite gpsSatellite : this.f6044i.getSatellites()) {
                    this.f6045j++;
                }
                this.f6045j++;
            }
            i7 = this.f6045j;
        }
        return i7;
    }

    @Override // androidx.core.location.a
    public int h(int i7) {
        return Build.VERSION.SDK_INT < 24 ? q(i7).getPrn() : r(q(i7).getPrn());
    }

    public int hashCode() {
        return this.f6044i.hashCode();
    }

    @Override // androidx.core.location.a
    public boolean i(int i7) {
        return q(i7).hasAlmanac();
    }

    @Override // androidx.core.location.a
    public boolean j(int i7) {
        return false;
    }

    @Override // androidx.core.location.a
    public boolean k(int i7) {
        return false;
    }

    @Override // androidx.core.location.a
    public boolean l(int i7) {
        return q(i7).hasEphemeris();
    }

    @Override // androidx.core.location.a
    public boolean m(int i7) {
        return q(i7).usedInFix();
    }
}
