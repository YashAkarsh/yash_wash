package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "DetectedActivityCreator")
@SafeParcelable.f({1000})
public class DetectedActivity extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16243c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16244d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16245e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16246f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16247g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16248h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16249i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16250j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 1)
    int f16252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    int f16253b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.m0
    public static final Comparator<DetectedActivity> f16251k = new e2();

    @c.m0
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new f2();

    @SafeParcelable.b
    public DetectedActivity(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8) {
        this.f16252a = i7;
        this.f16253b = i8;
    }

    public int K() {
        return this.f16253b;
    }

    public int Q() {
        int i7 = this.f16252a;
        if (i7 > 22 || i7 < 0) {
            return 4;
        }
        return i7;
    }

    @com.google.android.gms.common.internal.y
    public final boolean equals(@c.o0 Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f16252a == detectedActivity.f16252a && this.f16253b == detectedActivity.f16253b) {
                return true;
            }
        }
        return false;
    }

    @com.google.android.gms.common.internal.y
    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16252a), Integer.valueOf(this.f16253b));
    }

    @c.m0
    public String toString() {
        String string;
        int iQ = Q();
        if (iQ == 0) {
            string = "IN_VEHICLE";
        } else if (iQ == 1) {
            string = "ON_BICYCLE";
        } else if (iQ == 2) {
            string = "ON_FOOT";
        } else if (iQ == 3) {
            string = "STILL";
        } else if (iQ == 4) {
            string = "UNKNOWN";
        } else if (iQ == 5) {
            string = "TILTING";
        } else if (iQ == 7) {
            string = "WALKING";
        } else if (iQ == 8) {
            string = kotlinx.coroutines.debug.internal.f.f35948b;
        } else if (iQ != 16) {
            string = iQ != 17 ? Integer.toString(iQ) : "IN_RAIL_VEHICLE";
        } else {
            string = "IN_ROAD_VEHICLE";
        }
        int i7 = this.f16253b;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(string);
        sb.append(", confidence=");
        sb.append(i7);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16252a);
        e1.b.F(parcel, 2, this.f16253b);
        e1.b.b(parcel, iA);
    }
}
