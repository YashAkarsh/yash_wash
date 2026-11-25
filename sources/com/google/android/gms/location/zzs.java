package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "DeviceOrientationRequestCreator")
@com.google.android.gms.common.internal.y
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new g2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_SHOULD_USE_MAG", id = 1)
    boolean f16445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_MINIMUM_SAMPLING_PERIOD_MS", id = 2)
    long f16446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_SMALLEST_ANGLE_CHANGE_RADIANS", id = 3)
    float f16447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_EXPIRE_AT_MS", id = 4)
    long f16448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequest.DEFAULT_NUM_UPDATES", id = 5)
    int f16449e;

    public zzs() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.f16445a == zzsVar.f16445a && this.f16446b == zzsVar.f16446b && Float.compare(this.f16447c, zzsVar.f16447c) == 0 && this.f16448d == zzsVar.f16448d && this.f16449e == zzsVar.f16449e;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(Boolean.valueOf(this.f16445a), Long.valueOf(this.f16446b), Float.valueOf(this.f16447c), Long.valueOf(this.f16448d), Integer.valueOf(this.f16449e));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f16445a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f16446b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f16447c);
        long j7 = this.f16448d;
        if (j7 != Long.MAX_VALUE) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j7 - jElapsedRealtime);
            sb.append("ms");
        }
        if (this.f16449e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f16449e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.g(parcel, 1, this.f16445a);
        e1.b.K(parcel, 2, this.f16446b);
        e1.b.w(parcel, 3, this.f16447c);
        e1.b.K(parcel, 4, this.f16448d);
        e1.b.F(parcel, 5, this.f16449e);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    zzs(@SafeParcelable.e(id = 1) boolean z7, @SafeParcelable.e(id = 2) long j7, @SafeParcelable.e(id = 3) float f8, @SafeParcelable.e(id = 4) long j8, @SafeParcelable.e(id = 5) int i7) {
        this.f16445a = z7;
        this.f16446b = j7;
        this.f16447c = f8;
        this.f16448d = j8;
        this.f16449e = i7;
    }
}
