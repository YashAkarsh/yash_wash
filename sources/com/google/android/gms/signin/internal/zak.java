package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f16773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getConnectionResult", id = 2)
    private final ConnectionResult f16774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getResolveAccountResponse", id = 3)
    private final zav f16775c;

    @SafeParcelable.b
    zak(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) ConnectionResult connectionResult, @o0 @SafeParcelable.e(id = 3) zav zavVar) {
        this.f16773a = i7;
        this.f16774b = connectionResult;
        this.f16775c = zavVar;
    }

    public final ConnectionResult K() {
        return this.f16774b;
    }

    @o0
    public final zav Q() {
        return this.f16775c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16773a);
        e1.b.S(parcel, 2, this.f16774b, i7, false);
        e1.b.S(parcel, 3, this.f16775c, i7, false);
        e1.b.b(parcel, iA);
    }
}
