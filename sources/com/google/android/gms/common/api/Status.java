package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StatusCreator")
@c1.a
public final class Status extends AbstractSafeParcelable implements t, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1000)
    final int f15070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatusCode", id = 1)
    private final int f15071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getStatusMessage", id = 2)
    private final String f15072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getPendingIntent", id = 3)
    private final PendingIntent f15073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getConnectionResult", id = 4)
    private final ConnectionResult f15074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g1.d0
    @m0
    @c1.a
    @com.google.android.gms.common.internal.y
    public static final Status f15063f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c1.a
    @com.google.android.gms.common.internal.y
    @m0
    public static final Status f15064g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c1.a
    @com.google.android.gms.common.internal.y
    @m0
    public static final Status f15065h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c1.a
    @com.google.android.gms.common.internal.y
    @m0
    public static final Status f15066i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c1.a
    @com.google.android.gms.common.internal.y
    @m0
    public static final Status f15067j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @com.google.android.gms.common.internal.y
    @m0
    public static final Status f15069l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c1.a
    @m0
    public static final Status f15068k = new Status(18);

    @m0
    public static final Parcelable.Creator<Status> CREATOR = new i0();

    @c1.a
    @SafeParcelable.b
    Status(@SafeParcelable.e(id = 1000) int i7, @SafeParcelable.e(id = 1) int i8, @o0 @SafeParcelable.e(id = 2) String str, @o0 @SafeParcelable.e(id = 3) PendingIntent pendingIntent, @o0 @SafeParcelable.e(id = 4) ConnectionResult connectionResult) {
        this.f15070a = i7;
        this.f15071b = i8;
        this.f15072c = str;
        this.f15073d = pendingIntent;
        this.f15074e = connectionResult;
    }

    @Override // com.google.android.gms.common.api.t
    @c1.a
    @m0
    public Status G() {
        return this;
    }

    public boolean G0() {
        return this.f15071b <= 0;
    }

    public void I0(@m0 Activity activity, int i7) throws IntentSender.SendIntentException {
        if (s0()) {
            PendingIntent pendingIntent = this.f15073d;
            com.google.android.gms.common.internal.u.k(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i7, null, 0, 0, 0);
        }
    }

    @m0
    public final String J0() {
        String str = this.f15072c;
        return str != null ? str : h.a(this.f15071b);
    }

    @o0
    public ConnectionResult K() {
        return this.f15074e;
    }

    @o0
    public PendingIntent Q() {
        return this.f15073d;
    }

    public boolean equals(@o0 Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f15070a == status.f15070a && this.f15071b == status.f15071b && com.google.android.gms.common.internal.s.b(this.f15072c, status.f15072c) && com.google.android.gms.common.internal.s.b(this.f15073d, status.f15073d) && com.google.android.gms.common.internal.s.b(this.f15074e, status.f15074e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f15070a), Integer.valueOf(this.f15071b), this.f15072c, this.f15073d, this.f15074e);
    }

    public int p0() {
        return this.f15071b;
    }

    @o0
    public String r0() {
        return this.f15072c;
    }

    @g1.d0
    public boolean s0() {
        return this.f15073d != null;
    }

    @m0
    public String toString() {
        com.google.android.gms.common.internal.s.a aVarD = com.google.android.gms.common.internal.s.d(this);
        aVarD.a("statusCode", J0());
        aVarD.a("resolution", this.f15073d);
        return aVarD.toString();
    }

    public boolean v0() {
        return this.f15071b == 16;
    }

    @Override // android.os.Parcelable
    @c1.a
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, p0());
        e1.b.Y(parcel, 2, r0(), false);
        e1.b.S(parcel, 3, this.f15073d, i7, false);
        e1.b.S(parcel, 4, K(), i7, false);
        e1.b.F(parcel, 1000, this.f15070a);
        e1.b.b(parcel, iA);
    }

    public boolean x0() {
        return this.f15071b == 14;
    }

    @c1.a
    public Status(int i7) {
        this(i7, (String) null);
    }

    @c1.a
    Status(int i7, int i8, @o0 String str, @o0 PendingIntent pendingIntent) {
        this(i7, i8, str, pendingIntent, null);
    }

    @c1.a
    public Status(int i7, @o0 String str) {
        this(1, i7, str, null);
    }

    @c1.a
    public Status(int i7, @o0 String str, @o0 PendingIntent pendingIntent) {
        this(1, i7, str, pendingIntent);
    }

    public Status(@m0 ConnectionResult connectionResult, @m0 String str) {
        this(connectionResult, str, 17);
    }

    @c1.a
    @Deprecated
    public Status(@m0 ConnectionResult connectionResult, @m0 String str, int i7) {
        this(1, i7, str, connectionResult.p0(), connectionResult);
    }
}
