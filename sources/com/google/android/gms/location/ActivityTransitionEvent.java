package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ActivityTransitionEventCreator")
@SafeParcelable.f({1000})
public class ActivityTransitionEvent extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new a2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getActivityType", id = 1)
    private final int f16233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransitionType", id = 2)
    private final int f16234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getElapsedRealTimeNanos", id = 3)
    private final long f16235c;

    @SafeParcelable.b
    public ActivityTransitionEvent(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) long j7) {
        ActivityTransition.p0(i8);
        this.f16233a = i7;
        this.f16234b = i8;
        this.f16235c = j7;
    }

    public int K() {
        return this.f16233a;
    }

    public long Q() {
        return this.f16235c;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f16233a == activityTransitionEvent.f16233a && this.f16234b == activityTransitionEvent.f16234b && this.f16235c == activityTransitionEvent.f16235c;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16233a), Integer.valueOf(this.f16234b), Long.valueOf(this.f16235c));
    }

    public int p0() {
        return this.f16234b;
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i7 = this.f16233a;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i7);
        sb.append(sb2.toString());
        sb.append(" ");
        int i8 = this.f16234b;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i8);
        sb.append(sb3.toString());
        sb.append(" ");
        long j7 = this.f16235c;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j7);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, K());
        e1.b.F(parcel, 2, p0());
        e1.b.K(parcel, 3, Q());
        e1.b.b(parcel, iA);
    }
}
