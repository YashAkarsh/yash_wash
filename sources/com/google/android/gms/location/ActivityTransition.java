package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ActivityTransitionCreator")
@SafeParcelable.f({1000})
public class ActivityTransition extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new z1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16227c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16228d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getActivityType", id = 1)
    private final int f16229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransitionType", id = 2)
    private final int f16230b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16231a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16232b = -1;

        @c.m0
        public ActivityTransition a() {
            com.google.android.gms.common.internal.u.r(this.f16231a != -1, "Activity type not set.");
            com.google.android.gms.common.internal.u.r(this.f16232b != -1, "Activity transition type not set.");
            return new ActivityTransition(this.f16231a, this.f16232b);
        }

        @c.m0
        public a b(int i7) {
            ActivityTransition.p0(i7);
            this.f16232b = i7;
            return this;
        }

        @c.m0
        public a c(int i7) {
            this.f16231a = i7;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @SafeParcelable.b
    ActivityTransition(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8) {
        this.f16229a = i7;
        this.f16230b = i8;
    }

    public static void p0(int i7) {
        boolean z7 = false;
        if (i7 >= 0 && i7 <= 1) {
            z7 = true;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i7);
        sb.append(" is not valid.");
        com.google.android.gms.common.internal.u.b(z7, sb.toString());
    }

    public int K() {
        return this.f16229a;
    }

    public int Q() {
        return this.f16230b;
    }

    public boolean equals(@c.o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f16229a == activityTransition.f16229a && this.f16230b == activityTransition.f16230b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16229a), Integer.valueOf(this.f16230b));
    }

    @c.m0
    public String toString() {
        int i7 = this.f16229a;
        int i8 = this.f16230b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i7);
        sb.append(", mTransitionType=");
        sb.append(i8);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        com.google.android.gms.common.internal.u.k(parcel);
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, K());
        e1.b.F(parcel, 2, Q());
        e1.b.b(parcel, iA);
    }
}
