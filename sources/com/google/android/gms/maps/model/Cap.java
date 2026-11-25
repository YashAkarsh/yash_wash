package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "CapCreator")
@SafeParcelable.f({1})
public class Cap extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<Cap> CREATOR = new p();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16555d = "Cap";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getType", id = 2)
    private final int f16556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getWrappedBitmapDescriptorImplBinder", id = 3, type = "android.os.IBinder")
    private final a f16557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getBitmapRefWidth", id = 4)
    private final Float f16558c;

    protected Cap(int i7) {
        this(i7, (a) null, (Float) null);
    }

    final Cap K() {
        int i7 = this.f16556a;
        if (i7 == 0) {
            return new ButtCap();
        }
        if (i7 == 1) {
            return new SquareCap();
        }
        if (i7 == 2) {
            return new RoundCap();
        }
        if (i7 == 3) {
            com.google.android.gms.common.internal.u.r(this.f16557b != null, "bitmapDescriptor must not be null");
            com.google.android.gms.common.internal.u.r(this.f16558c != null, "bitmapRefWidth must not be null");
            return new CustomCap(this.f16557b, this.f16558c.floatValue());
        }
        String str = f16555d;
        StringBuilder sb = new StringBuilder(29);
        sb.append("Unknown Cap type: ");
        sb.append(i7);
        Log.w(str, sb.toString());
        return this;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f16556a == cap.f16556a && com.google.android.gms.common.internal.s.b(this.f16557b, cap.f16557b) && com.google.android.gms.common.internal.s.b(this.f16558c, cap.f16558c);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.s.c(Integer.valueOf(this.f16556a), this.f16557b, this.f16558c);
    }

    @m0
    public String toString() {
        int i7 = this.f16556a;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i7);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 2, this.f16556a);
        a aVar = this.f16557b;
        e1.b.B(parcel, 3, aVar == null ? null : aVar.a().asBinder(), false);
        e1.b.z(parcel, 4, this.f16558c, false);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    Cap(@SafeParcelable.e(id = 2) int i7, @o0 @SafeParcelable.e(id = 3) IBinder iBinder, @o0 @SafeParcelable.e(id = 4) Float f8) {
        this(i7, iBinder == null ? null : new a(com.google.android.gms.dynamic.d.a.u0(iBinder)), f8);
    }

    private Cap(int i7, @o0 a aVar, @o0 Float f8) {
        boolean z7;
        boolean z8 = f8 != null && f8.floatValue() > 0.0f;
        if (i7 == 3) {
            z7 = aVar != null && z8;
            i7 = 3;
        } else {
            z7 = true;
        }
        com.google.android.gms.common.internal.u.b(z7, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i7), aVar, f8));
        this.f16556a = i7;
        this.f16557b = aVar;
        this.f16558c = f8;
    }

    protected Cap(@m0 a aVar, float f8) {
        this(3, aVar, Float.valueOf(f8));
    }
}
