package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SleepSegmentRequestCreator")
@SafeParcelable.f({1000})
public class SleepSegmentRequest extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new o1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16316c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16317d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16318e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getUserPreferredSleepWindow", id = 1)
    private final List<zzbx> f16319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0", getter = "getRequestedDataType", id = 2)
    private final int f16320b;

    public SleepSegmentRequest(int i7) {
        this(null, i7);
    }

    @c.m0
    public static SleepSegmentRequest K() {
        return new SleepSegmentRequest(null, 0);
    }

    public int Q() {
        return this.f16320b;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return com.google.android.gms.common.internal.s.b(this.f16319a, sleepSegmentRequest.f16319a) && this.f16320b == sleepSegmentRequest.f16320b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f16319a, Integer.valueOf(this.f16320b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, this.f16319a, false);
        e1.b.F(parcel, 2, Q());
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    @com.google.android.gms.common.internal.y
    public SleepSegmentRequest(@c.o0 @SafeParcelable.e(id = 1) List<zzbx> list, @SafeParcelable.e(id = 2) int i7) {
        this.f16319a = list;
        this.f16320b = i7;
    }
}
