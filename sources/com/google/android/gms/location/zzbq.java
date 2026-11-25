package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "RemoveGeofencingRequestCreator")
@SafeParcelable.f({1000})
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new j1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getGeofenceIds", id = 1)
    private final List<String> f16438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getPendingIntent", id = 2)
    private final PendingIntent f16439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "", getter = "getTag", id = 3)
    private final String f16440c;

    @SafeParcelable.b
    zzbq(@c.o0 @SafeParcelable.e(id = 1) List<String> list, @c.o0 @SafeParcelable.e(id = 2) PendingIntent pendingIntent, @SafeParcelable.e(id = 3) String str) {
        this.f16438a = list == null ? com.google.android.gms.internal.location.q0.l() : com.google.android.gms.internal.location.q0.m(list);
        this.f16439b = pendingIntent;
        this.f16440c = str;
    }

    public static zzbq K(PendingIntent pendingIntent) {
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent can not be null.");
        return new zzbq(null, pendingIntent, "");
    }

    public static zzbq s(List<String> list) {
        com.google.android.gms.common.internal.u.l(list, "geofence can't be null.");
        com.google.android.gms.common.internal.u.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzbq(list, null, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.a0(parcel, 1, this.f16438a, false);
        e1.b.S(parcel, 2, this.f16439b, i7, false);
        e1.b.Y(parcel, 3, this.f16440c, false);
        e1.b.b(parcel, iA);
    }
}
