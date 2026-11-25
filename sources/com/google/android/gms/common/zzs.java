package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.l2;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GoogleCertificatesQueryCreator")
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCallingPackage", id = 1)
    private final String f16011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final f0 f16012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "getAllowTestKeys", id = 3)
    private final boolean f16013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = com.paytm.pgsdk.d.G, getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean f16014d;

    zzs(String str, @Nullable f0 f0Var, boolean z7, boolean z8) {
        this.f16011a = str;
        this.f16012b = f0Var;
        this.f16013c = z7;
        this.f16014d = z8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Y(parcel, 1, this.f16011a, false);
        f0 f0Var = this.f16012b;
        if (f0Var == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            f0Var = null;
        }
        e1.b.B(parcel, 2, f0Var, false);
        e1.b.g(parcel, 3, this.f16013c);
        e1.b.g(parcel, 4, this.f16014d);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    zzs(@SafeParcelable.e(id = 1) String str, @SafeParcelable.e(id = 2) @Nullable IBinder iBinder, @SafeParcelable.e(id = 3) boolean z7, @SafeParcelable.e(id = 4) boolean z8) {
        this.f16011a = str;
        g0 g0Var = null;
        if (iBinder != null) {
            try {
                com.google.android.gms.dynamic.d dVarA = l2.u0(iBinder).a();
                byte[] bArr = dVarA == null ? null : (byte[]) com.google.android.gms.dynamic.f.y0(dVarA);
                if (bArr != null) {
                    g0Var = new g0(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e8) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e8);
            }
        }
        this.f16012b = g0Var;
        this.f16013c = z7;
        this.f16014d = z8;
    }
}
