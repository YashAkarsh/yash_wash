package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.y;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FieldMapPairCreator")
@y
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    final String f15954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(id = 3)
    final FastJsonResponse.Field<?, ?> f15955c;

    @SafeParcelable.b
    zam(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.f15953a = i7;
        this.f15954b = str;
        this.f15955c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15953a);
        e1.b.Y(parcel, 2, this.f15954b, false);
        e1.b.S(parcel, 3, this.f15955c, i7, false);
        e1.b.b(parcel, iA);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f15953a = 1;
        this.f15954b = str;
        this.f15955c = field;
    }
}
