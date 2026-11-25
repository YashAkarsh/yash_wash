package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleCertificatesLookupQueryCreator")
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCallingPackage", id = 1)
    private final String f16003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAllowTestKeys", id = 2)
    private final boolean f16004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = com.paytm.pgsdk.d.G, getter = "getIgnoreTestKeysOverride", id = 3)
    private final boolean f16005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")
    private final Context f16006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getIsChimeraPackage", id = 5)
    private final boolean f16007e;

    @SafeParcelable.b
    zzn(@SafeParcelable.e(id = 1) String str, @SafeParcelable.e(id = 2) boolean z7, @SafeParcelable.e(id = 3) boolean z8, @SafeParcelable.e(id = 4) IBinder iBinder, @SafeParcelable.e(id = 5) boolean z9) {
        this.f16003a = str;
        this.f16004b = z7;
        this.f16005c = z8;
        this.f16006d = (Context) com.google.android.gms.dynamic.f.y0(com.google.android.gms.dynamic.d.a.u0(iBinder));
        this.f16007e = z9;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, com.google.android.gms.dynamic.d] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 1, this.f16003a, false);
        e1.b.g(parcel, 2, this.f16004b);
        e1.b.g(parcel, 3, this.f16005c);
        e1.b.B(parcel, 4, com.google.android.gms.dynamic.f.z3(this.f16006d), false);
        e1.b.g(parcel, 5, this.f16007e);
        e1.b.b(parcel, iA);
    }
}
