package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "DeviceOrientationRequestUpdateDataCreator")
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new c1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequestUpdateData.OPERATION_ADD", id = 1)
    final int f16214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 2)
    final zzj f16215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getDeviceOrientationListenerBinder", id = 3, type = "android.os.IBinder")
    final com.google.android.gms.location.r0 f16216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 4, type = "android.os.IBinder")
    final i f16217d;

    @SafeParcelable.b
    zzl(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) zzj zzjVar, @SafeParcelable.e(id = 3) IBinder iBinder, @SafeParcelable.e(id = 4) IBinder iBinder2) {
        this.f16214a = i7;
        this.f16215b = zzjVar;
        i gVar = null;
        this.f16216c = iBinder == null ? null : com.google.android.gms.location.q0.u0(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            gVar = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new g(iBinder2);
        }
        this.f16217d = gVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16214a);
        e1.b.S(parcel, 2, this.f16215b, i7, false);
        com.google.android.gms.location.r0 r0Var = this.f16216c;
        e1.b.B(parcel, 3, r0Var == null ? null : r0Var.asBinder(), false);
        i iVar = this.f16217d;
        e1.b.B(parcel, 4, iVar != null ? iVar.asBinder() : null, false);
        e1.b.b(parcel, iA);
    }
}
