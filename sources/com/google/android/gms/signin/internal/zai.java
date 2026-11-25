package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SignInRequestCreator")
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f16771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getResolveAccountRequest", id = 2)
    final zat f16772b;

    @SafeParcelable.b
    zai(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) zat zatVar) {
        this.f16771a = i7;
        this.f16772b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16771a);
        e1.b.S(parcel, 2, this.f16772b, i7, false);
        e1.b.b(parcel, iA);
    }
}
