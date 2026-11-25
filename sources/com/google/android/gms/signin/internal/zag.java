package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "RecordConsentByConsentResultResponseCreator")
public final class zag extends AbstractSafeParcelable implements t {
    public static final Parcelable.Creator<zag> CREATOR = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getGrantedScopes", id = 1)
    private final List<String> f16769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getToken", id = 2)
    private final String f16770b;

    @SafeParcelable.b
    public zag(@SafeParcelable.e(id = 1) List<String> list, @o0 @SafeParcelable.e(id = 2) String str) {
        this.f16769a = list;
        this.f16770b = str;
    }

    @Override // com.google.android.gms.common.api.t
    public final Status G() {
        return this.f16770b != null ? Status.f15063f : Status.f15067j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.a0(parcel, 1, this.f16769a, false);
        e1.b.Y(parcel, 2, this.f16770b, false);
        e1.b.b(parcel, iA);
    }
}
