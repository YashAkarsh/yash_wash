package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FusedLocationProviderResultCreator")
@SafeParcelable.f({1000})
public final class zzaa extends AbstractSafeParcelable implements com.google.android.gms.common.api.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatus", id = 1)
    private final Status f16181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzaa f16180b = new zzaa(Status.f15063f);
    public static final Parcelable.Creator<zzaa> CREATOR = new b();

    @SafeParcelable.b
    public zzaa(@SafeParcelable.e(id = 1) Status status) {
        this.f16181a = status;
    }

    @Override // com.google.android.gms.common.api.t
    public final Status G() {
        return this.f16181a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 1, this.f16181a, i7, false);
        e1.b.b(parcel, iA);
    }
}
