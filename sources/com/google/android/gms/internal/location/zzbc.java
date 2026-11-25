package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.f({1000})
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestUpdateData.OPERATION_ADD", id = 1)
    final int f16194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 2)
    final zzba f16195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getLocationListenerBinder", id = 3, type = "android.os.IBinder")
    final com.google.android.gms.location.y0 f16196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 4)
    final PendingIntent f16197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getLocationCallbackBinder", id = 5, type = "android.os.IBinder")
    final com.google.android.gms.location.v0 f16198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 6, type = "android.os.IBinder")
    final i f16199f;

    @SafeParcelable.b
    zzbc(@SafeParcelable.e(id = 1) int i7, @c.o0 @SafeParcelable.e(id = 2) zzba zzbaVar, @c.o0 @SafeParcelable.e(id = 3) IBinder iBinder, @c.o0 @SafeParcelable.e(id = 4) PendingIntent pendingIntent, @c.o0 @SafeParcelable.e(id = 5) IBinder iBinder2, @c.o0 @SafeParcelable.e(id = 6) IBinder iBinder3) {
        this.f16194a = i7;
        this.f16195b = zzbaVar;
        i gVar = null;
        this.f16196c = iBinder == null ? null : com.google.android.gms.location.x0.u0(iBinder);
        this.f16197d = pendingIntent;
        this.f16198e = iBinder2 == null ? null : com.google.android.gms.location.t0.u0(iBinder2);
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            gVar = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new g(iBinder3);
        }
        this.f16199f = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzbc K(zzba zzbaVar, PendingIntent pendingIntent, @c.o0 i iVar) {
        return new zzbc(1, zzbaVar, null, pendingIntent, null, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, com.google.android.gms.location.v0] */
    public static zzbc Q(com.google.android.gms.location.v0 v0Var, @c.o0 i iVar) {
        if (iVar == null) {
            iVar = null;
        }
        return new zzbc(2, null, null, null, v0Var, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, com.google.android.gms.location.y0] */
    public static zzbc s(com.google.android.gms.location.y0 y0Var, @c.o0 i iVar) {
        if (iVar == null) {
            iVar = null;
        }
        return new zzbc(2, null, y0Var, null, null, iVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f16194a);
        e1.b.S(parcel, 2, this.f16195b, i7, false);
        com.google.android.gms.location.y0 y0Var = this.f16196c;
        e1.b.B(parcel, 3, y0Var == null ? null : y0Var.asBinder(), false);
        e1.b.S(parcel, 4, this.f16197d, i7, false);
        com.google.android.gms.location.v0 v0Var = this.f16198e;
        e1.b.B(parcel, 5, v0Var == null ? null : v0Var.asBinder(), false);
        i iVar = this.f16199f;
        e1.b.B(parcel, 6, iVar != null ? iVar.asBinder() : null, false);
        e1.b.b(parcel, iA);
    }
}
