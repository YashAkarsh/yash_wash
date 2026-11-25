package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f14987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getType", id = 2)
    private int f14988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getBundle", id = 3)
    private Bundle f14989c;

    @SafeParcelable.b
    GoogleSignInOptionsExtensionParcelable(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) Bundle bundle) {
        this.f14987a = i7;
        this.f14988b = i8;
        this.f14989c = bundle;
    }

    @c1.a
    public int K() {
        return this.f14988b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f14987a);
        e1.b.F(parcel, 2, K());
        e1.b.k(parcel, 3, this.f14989c, false);
        e1.b.b(parcel, iA);
    }

    public GoogleSignInOptionsExtensionParcelable(@m0 com.google.android.gms.auth.api.signin.a aVar) {
        this(1, aVar.b(), aVar.a());
    }
}
