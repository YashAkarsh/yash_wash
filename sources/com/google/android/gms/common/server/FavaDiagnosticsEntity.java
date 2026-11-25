package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e1.b;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FavaDiagnosticsEntityCreator")
@c1.a
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @c1.a
    @m0
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    @SafeParcelable.c(id = 2)
    public final String f15902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final int f15903c;

    @SafeParcelable.b
    public FavaDiagnosticsEntity(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) @m0 String str, @SafeParcelable.e(id = 3) int i8) {
        this.f15901a = i7;
        this.f15902b = str;
        this.f15903c = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = b.a(parcel);
        b.F(parcel, 1, this.f15901a);
        b.Y(parcel, 2, this.f15902b, false);
        b.F(parcel, 3, this.f15903c);
        b.b(parcel, iA);
    }

    @c1.a
    public FavaDiagnosticsEntity(@m0 String str, int i7) {
        this.f15901a = 1;
        this.f15902b = str;
        this.f15903c = i7;
    }
}
