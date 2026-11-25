package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.f({3, 4, 1000})
@Deprecated
@SafeParcelable.a(creator = "LocationSettingsConfigurationCreator")
@com.google.android.gms.common.internal.y
public final class zzbj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbj> CREATOR = new e1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "", getter = "getJustificationText", id = 1)
    private final String f16431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "", getter = "getExperimentId", id = 2)
    private final String f16432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "", getter = "getTitleText", id = 5)
    private final String f16433c;

    @SafeParcelable.b
    zzbj(@SafeParcelable.e(id = 5) String str, @SafeParcelable.e(id = 1) String str2, @SafeParcelable.e(id = 2) String str3) {
        this.f16433c = str;
        this.f16431a = str2;
        this.f16432b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 1, this.f16431a, false);
        e1.b.Y(parcel, 2, this.f16432b, false);
        e1.b.Y(parcel, 5, this.f16433c, false);
        e1.b.b(parcel, iA);
    }
}
