package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzs;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "DeviceOrientationRequestInternalCreator")
public final class zzj extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_DEVICE_ORIENTATION_REQUEST", id = 1)
    final zzs f16211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "DeviceOrientationRequestInternal.DEFAULT_CLIENTS", id = 2)
    final List<ClientIdentity> f16212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 3)
    final String f16213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g1.d0
    static final List<ClientIdentity> f16209d = Collections.emptyList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final zzs f16210e = new zzs();
    public static final Parcelable.Creator<zzj> CREATOR = new b1();

    @SafeParcelable.b
    zzj(@SafeParcelable.e(id = 1) zzs zzsVar, @SafeParcelable.e(id = 2) List<ClientIdentity> list, @SafeParcelable.e(id = 3) String str) {
        this.f16211a = zzsVar;
        this.f16212b = list;
        this.f16213c = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return com.google.android.gms.common.internal.s.b(this.f16211a, zzjVar.f16211a) && com.google.android.gms.common.internal.s.b(this.f16212b, zzjVar.f16212b) && com.google.android.gms.common.internal.s.b(this.f16213c, zzjVar.f16213c);
    }

    public final int hashCode() {
        return this.f16211a.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f16211a);
        String strValueOf2 = String.valueOf(this.f16212b);
        String str = this.f16213c;
        int length = strValueOf.length();
        StringBuilder sb = new StringBuilder(length + 77 + strValueOf2.length() + String.valueOf(str).length());
        sb.append("DeviceOrientationRequestInternal{deviceOrientationRequest=");
        sb.append(strValueOf);
        sb.append(", clients=");
        sb.append(strValueOf2);
        sb.append(", tag='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 1, this.f16211a, i7, false);
        e1.b.d0(parcel, 2, this.f16212b, false);
        e1.b.Y(parcel, 3, this.f16213c, false);
        e1.b.b(parcel, iA);
    }
}
