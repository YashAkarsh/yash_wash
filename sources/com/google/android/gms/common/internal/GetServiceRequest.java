package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GetServiceRequestCreator")
@c1.a
@SafeParcelable.f({9})
public class GetServiceRequest extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new z1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    final int f15629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    int f15630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(id = 4)
    String f15631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(id = 5)
    IBinder f15632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(id = 6)
    Scope[] f15633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.c(id = 7)
    Bundle f15634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(id = 8)
    Account f15635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(id = 10)
    Feature[] f15636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.c(id = 11)
    Feature[] f15637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.c(id = 12)
    boolean f15638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "0", id = 13)
    int f15639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SafeParcelable.c(getter = "isRequestingTelemetryConfiguration", id = 14)
    boolean f15640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getAttributionTag", id = 15)
    private String f15641n;

    @SafeParcelable.b
    GetServiceRequest(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) int i9, @SafeParcelable.e(id = 4) String str, @SafeParcelable.e(id = 5) IBinder iBinder, @SafeParcelable.e(id = 6) Scope[] scopeArr, @SafeParcelable.e(id = 7) Bundle bundle, @SafeParcelable.e(id = 8) Account account, @SafeParcelable.e(id = 10) Feature[] featureArr, @SafeParcelable.e(id = 11) Feature[] featureArr2, @SafeParcelable.e(id = 12) boolean z7, @SafeParcelable.e(id = 13) int i10, @SafeParcelable.e(id = 14) boolean z8, @c.o0 @SafeParcelable.e(id = 15) String str2) {
        this.f15628a = i7;
        this.f15629b = i8;
        this.f15630c = i9;
        if ("com.google.android.gms".equals(str)) {
            this.f15631d = "com.google.android.gms";
        } else {
            this.f15631d = str;
        }
        if (i7 < 2) {
            this.f15635h = iBinder != null ? a.y0(m.a.u0(iBinder)) : null;
        } else {
            this.f15632e = iBinder;
            this.f15635h = account;
        }
        this.f15633f = scopeArr;
        this.f15634g = bundle;
        this.f15636i = featureArr;
        this.f15637j = featureArr2;
        this.f15638k = z7;
        this.f15639l = i10;
        this.f15640m = z8;
        this.f15641n = str2;
    }

    @c1.a
    @c.m0
    public Bundle K() {
        return this.f15634g;
    }

    @c.o0
    public final String Q() {
        return this.f15641n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        z1.a(this, parcel, i7);
    }

    public GetServiceRequest(int i7, @c.o0 String str) {
        this.f15628a = 6;
        this.f15630c = com.google.android.gms.common.h.f15574a;
        this.f15629b = i7;
        this.f15638k = true;
        this.f15641n = str;
    }
}
