package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "TileCreator")
@SafeParcelable.f({1})
public final class Tile extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<Tile> CREATOR = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    public final int f16657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    public final int f16658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(id = 4)
    public final byte[] f16659c;

    @SafeParcelable.b
    public Tile(@SafeParcelable.e(id = 2) int i7, @SafeParcelable.e(id = 3) int i8, @o0 @SafeParcelable.e(id = 4) byte[] bArr) {
        this.f16657a = i7;
        this.f16658b = i8;
        this.f16659c = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 2, this.f16657a);
        e1.b.F(parcel, 3, this.f16658b);
        e1.b.m(parcel, 4, this.f16659c, false);
        e1.b.b(parcel, iA);
    }
}
