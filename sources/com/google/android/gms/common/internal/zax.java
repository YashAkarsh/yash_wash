package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "SignInButtonConfigCreator")
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new c1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getButtonSize", id = 2)
    private final int f15837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getColorScheme", id = 3)
    private final int f15838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] f15839d;

    @SafeParcelable.b
    zax(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) int i8, @SafeParcelable.e(id = 3) int i9, @c.o0 @SafeParcelable.e(id = 4) Scope[] scopeArr) {
        this.f15836a = i7;
        this.f15837b = i8;
        this.f15838c = i9;
        this.f15839d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15836a);
        e1.b.F(parcel, 2, this.f15837b);
        e1.b.F(parcel, 3, this.f15838c);
        e1.b.c0(parcel, 4, this.f15839d, i7, false);
        e1.b.b(parcel, iA);
    }
}
