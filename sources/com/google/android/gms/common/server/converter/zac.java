package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StringToIntConverterEntryCreator")
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    final String f15910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    final int f15911c;

    @SafeParcelable.b
    zac(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) int i8) {
        this.f15909a = i7;
        this.f15910b = str;
        this.f15911c = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15909a);
        e1.b.Y(parcel, 2, this.f15910b, false);
        e1.b.F(parcel, 3, this.f15911c);
        e1.b.b(parcel, iA);
    }

    zac(String str, int i7) {
        this.f15909a = 1;
        this.f15910b = str;
        this.f15911c = i7;
    }
}
