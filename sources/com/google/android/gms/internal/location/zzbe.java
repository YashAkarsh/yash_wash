package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ParcelableGeofenceCreator")
@g1.d0
@SafeParcelable.f({1000})
public final class zzbe extends AbstractSafeParcelable implements com.google.android.gms.location.f {
    public static final Parcelable.Creator<zzbe> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRequestId", id = 1)
    private final String f16200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getExpirationTime", id = 2)
    private final long f16201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getType", id = 3)
    private final short f16202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getLatitude", id = 4)
    private final double f16203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getLongitude", id = 5)
    private final double f16204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getRadius", id = 6)
    private final float f16205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransitionTypes", id = 7)
    private final int f16206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0", getter = "getNotificationResponsiveness", id = 8)
    private final int f16207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "-1", getter = "getLoiteringDelay", id = 9)
    private final int f16208i;

    @SafeParcelable.b
    public zzbe(@SafeParcelable.e(id = 1) String str, @SafeParcelable.e(id = 7) int i7, @SafeParcelable.e(id = 3) short s7, @SafeParcelable.e(id = 4) double d8, @SafeParcelable.e(id = 5) double d9, @SafeParcelable.e(id = 6) float f8, @SafeParcelable.e(id = 2) long j7, @SafeParcelable.e(id = 8) int i8, @SafeParcelable.e(id = 9) int i9) {
        if (str == null || str.length() > 100) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "requestId is null or too long: ".concat(strValueOf) : new String("requestId is null or too long: "));
        }
        if (f8 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f8);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d8 > 90.0d || d8 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d8);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d9 > 180.0d || d9 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d9);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i10 = i7 & 7;
        if (i10 == 0) {
            StringBuilder sb4 = new StringBuilder(46);
            sb4.append("No supported transition specified: ");
            sb4.append(i7);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.f16202c = s7;
        this.f16200a = str;
        this.f16203d = d8;
        this.f16204e = d9;
        this.f16205f = f8;
        this.f16201b = j7;
        this.f16206g = i10;
        this.f16207h = i8;
        this.f16208i = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (this.f16205f == zzbeVar.f16205f && this.f16203d == zzbeVar.f16203d && this.f16204e == zzbeVar.f16204e && this.f16202c == zzbeVar.f16202c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f16203d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f16204e);
        return ((((((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f16205f)) * 31) + this.f16202c) * 31) + this.f16206g;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        short s7 = this.f16202c;
        if (s7 != -1) {
            str = s7 != 1 ? "UNKNOWN" : "CIRCLE";
        } else {
            str = "INVALID";
        }
        objArr[0] = str;
        objArr[1] = this.f16200a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f16206g);
        objArr[3] = Double.valueOf(this.f16203d);
        objArr[4] = Double.valueOf(this.f16204e);
        objArr[5] = Float.valueOf(this.f16205f);
        objArr[6] = Integer.valueOf(this.f16207h / 1000);
        objArr[7] = Integer.valueOf(this.f16208i);
        objArr[8] = Long.valueOf(this.f16201b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // com.google.android.gms.location.f
    public final String u() {
        return this.f16200a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 1, this.f16200a, false);
        e1.b.K(parcel, 2, this.f16201b);
        e1.b.U(parcel, 3, this.f16202c);
        e1.b.r(parcel, 4, this.f16203d);
        e1.b.r(parcel, 5, this.f16204e);
        e1.b.w(parcel, 6, this.f16205f);
        e1.b.F(parcel, 7, this.f16206g);
        e1.b.F(parcel, 8, this.f16207h);
        e1.b.F(parcel, 9, this.f16208i);
        e1.b.b(parcel, iA);
    }
}
