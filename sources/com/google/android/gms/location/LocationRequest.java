package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationRequestCreator")
@SafeParcelable.f({1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @c.m0
    public static final Parcelable.Creator<LocationRequest> CREATOR = new a1();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16269j = 100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16270k = 102;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f16271l = 104;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f16272m = 105;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_PRIORITY", id = 1)
    int f16273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_INTERVAL", id = 2)
    long f16274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_FASTEST_INTERVAL", id = 3)
    long f16275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPLICIT_FASTEST_INTERVAL", id = 4)
    boolean f16276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPIRE_AT", id = 5)
    long f16277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_NUM_UPDATES", id = 6)
    int f16278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_SMALLEST_DISPLACEMENT", id = 7)
    float f16279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequest.DEFAULT_MAX_WAIT_TIME", id = 8)
    long f16280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = com.paytm.pgsdk.d.G, id = 9)
    boolean f16281i;

    @Deprecated
    public LocationRequest() {
        this.f16273a = 102;
        this.f16274b = DateUtils.MILLIS_PER_HOUR;
        this.f16275c = 600000L;
        this.f16276d = false;
        this.f16277e = Long.MAX_VALUE;
        this.f16278f = Integer.MAX_VALUE;
        this.f16279g = 0.0f;
        this.f16280h = 0L;
        this.f16281i = false;
    }

    @c.m0
    public static LocationRequest K() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.i1(true);
        return locationRequest;
    }

    private static void q1(long j7) {
        if (j7 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j7);
        throw new IllegalArgumentException(sb.toString());
    }

    public float G0() {
        return this.f16279g;
    }

    public boolean I0() {
        return this.f16276d;
    }

    public boolean J0() {
        return this.f16281i;
    }

    @c.m0
    public LocationRequest L0(long j7) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j8 = j7 <= Long.MAX_VALUE - jElapsedRealtime ? j7 + jElapsedRealtime : Long.MAX_VALUE;
        this.f16277e = j8;
        if (j8 < 0) {
            this.f16277e = 0L;
        }
        return this;
    }

    public long Q() {
        return this.f16277e;
    }

    @c.m0
    public LocationRequest Q0(long j7) {
        this.f16277e = j7;
        if (j7 < 0) {
            this.f16277e = 0L;
        }
        return this;
    }

    @c.m0
    public LocationRequest T0(long j7) {
        q1(j7);
        this.f16276d = true;
        this.f16275c = j7;
        return this;
    }

    @c.m0
    public LocationRequest V0(long j7) {
        q1(j7);
        this.f16274b = j7;
        if (!this.f16276d) {
            this.f16275c = (long) (j7 / 6.0d);
        }
        return this;
    }

    @c.m0
    public LocationRequest Y0(long j7) {
        q1(j7);
        this.f16280h = j7;
        return this;
    }

    @c.m0
    public LocationRequest a1(int i7) {
        if (i7 > 0) {
            this.f16278f = i7;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i7);
        throw new IllegalArgumentException(sb.toString());
    }

    @c.m0
    public LocationRequest d1(int i7) {
        if (i7 == 100 || i7 == 102 || i7 == 104 || i7 == 105) {
            this.f16273a = i7;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i7);
        throw new IllegalArgumentException(sb.toString());
    }

    @c.m0
    public LocationRequest e1(float f8) {
        if (f8 >= 0.0f) {
            this.f16279g = f8;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f8);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean equals(@c.o0 Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f16273a == locationRequest.f16273a && this.f16274b == locationRequest.f16274b && this.f16275c == locationRequest.f16275c && this.f16276d == locationRequest.f16276d && this.f16277e == locationRequest.f16277e && this.f16278f == locationRequest.f16278f && this.f16279g == locationRequest.f16279g && s0() == locationRequest.s0() && this.f16281i == locationRequest.f16281i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16273a), Long.valueOf(this.f16274b), Float.valueOf(this.f16279g), Long.valueOf(this.f16280h));
    }

    @c.m0
    public LocationRequest i1(boolean z7) {
        this.f16281i = z7;
        return this;
    }

    public long p0() {
        return this.f16275c;
    }

    public long r0() {
        return this.f16274b;
    }

    public long s0() {
        long j7 = this.f16280h;
        long j8 = this.f16274b;
        return j7 < j8 ? j8 : j7;
    }

    @c.m0
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i7 = this.f16273a;
        if (i7 == 100) {
            str = "PRIORITY_HIGH_ACCURACY";
        } else if (i7 == 102) {
            str = "PRIORITY_BALANCED_POWER_ACCURACY";
        } else if (i7 != 104) {
            str = i7 != 105 ? "???" : "PRIORITY_NO_POWER";
        } else {
            str = "PRIORITY_LOW_POWER";
        }
        sb.append(str);
        if (this.f16273a != 105) {
            sb.append(" requested=");
            sb.append(this.f16274b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f16275c);
        sb.append("ms");
        if (this.f16280h > this.f16274b) {
            sb.append(" maxWait=");
            sb.append(this.f16280h);
            sb.append("ms");
        }
        if (this.f16279g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f16279g);
            sb.append("m");
        }
        long j7 = this.f16277e;
        if (j7 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j7 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f16278f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f16278f);
        }
        sb.append(']');
        return sb.toString();
    }

    public int v0() {
        return this.f16278f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16273a);
        e1.b.K(parcel, 2, this.f16274b);
        e1.b.K(parcel, 3, this.f16275c);
        e1.b.g(parcel, 4, this.f16276d);
        e1.b.K(parcel, 5, this.f16277e);
        e1.b.F(parcel, 6, this.f16278f);
        e1.b.w(parcel, 7, this.f16279g);
        e1.b.K(parcel, 8, this.f16280h);
        e1.b.g(parcel, 9, this.f16281i);
        e1.b.b(parcel, iA);
    }

    public int x0() {
        return this.f16273a;
    }

    @SafeParcelable.b
    LocationRequest(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) long j7, @SafeParcelable.e(id = 3) long j8, @SafeParcelable.e(id = 4) boolean z7, @SafeParcelable.e(id = 5) long j9, @SafeParcelable.e(id = 6) int i8, @SafeParcelable.e(id = 7) float f8, @SafeParcelable.e(id = 8) long j10, @SafeParcelable.e(id = 9) boolean z8) {
        this.f16273a = i7;
        this.f16274b = j7;
        this.f16275c = j8;
        this.f16276d = z7;
        this.f16277e = j9;
        this.f16278f = i8;
        this.f16279g = f8;
        this.f16280h = j10;
        this.f16281i = z8;
    }
}
