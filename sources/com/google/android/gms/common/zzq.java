package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleCertificatesLookupResponseCreator")
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new m0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getResult", id = 1)
    private final boolean f16008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getErrorMessage", id = 2)
    @Nullable
    private final String f16009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatusValue", id = 3)
    private final int f16010c;

    @SafeParcelable.b
    zzq(@SafeParcelable.e(id = 1) boolean z7, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) int i7) {
        this.f16008a = z7;
        this.f16009b = str;
        this.f16010c = l0.a(i7) - 1;
    }

    @Nullable
    public final String K() {
        return this.f16009b;
    }

    public final boolean Q() {
        return this.f16008a;
    }

    public final int p0() {
        return l0.a(this.f16010c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.g(parcel, 1, this.f16008a);
        e1.b.Y(parcel, 2, this.f16009b, false);
        e1.b.F(parcel, 3, this.f16010c);
        e1.b.b(parcel, iA);
    }
}
