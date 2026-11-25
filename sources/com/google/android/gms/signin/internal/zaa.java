package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable implements t {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f16766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConnectionResultCode", id = 2)
    private int f16767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getRawAuthResolutionIntent", id = 3)
    private Intent f16768c;

    public zaa() {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.t
    public final Status G() {
        return this.f16767b == 0 ? Status.f15063f : Status.f15067j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16766a);
        e1.b.F(parcel, 2, this.f16767b);
        e1.b.S(parcel, 3, this.f16768c, i7, false);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    zaa(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @o0 @SafeParcelable.e(id = 3) Intent intent) {
        this.f16766a = i7;
        this.f16767b = i8;
        this.f16768c = intent;
    }
}
