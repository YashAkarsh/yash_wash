package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "TileOverlayOptionsCreator")
@SafeParcelable.f({1})
public final class TileOverlayOptions extends AbstractSafeParcelable {

    @m0
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getTileProviderDelegate", id = 2, type = "android.os.IBinder")
    private com.google.android.gms.internal.maps.k f16660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private m f16661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "isVisible", id = 3)
    private boolean f16662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getZIndex", id = 4)
    private float f16663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "true", getter = "getFadeIn", id = 5)
    private boolean f16664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(getter = "getTransparency", id = 6)
    private float f16665f;

    public TileOverlayOptions() {
        this.f16662c = true;
        this.f16664e = true;
        this.f16665f = 0.0f;
    }

    @m0
    public TileOverlayOptions G0(boolean z7) {
        this.f16662c = z7;
        return this;
    }

    @m0
    public TileOverlayOptions I0(float f8) {
        this.f16663d = f8;
        return this;
    }

    public boolean K() {
        return this.f16664e;
    }

    @o0
    public m Q() {
        return this.f16661b;
    }

    public float p0() {
        return this.f16665f;
    }

    public float r0() {
        return this.f16663d;
    }

    @m0
    public TileOverlayOptions s(boolean z7) {
        this.f16664e = z7;
        return this;
    }

    public boolean s0() {
        return this.f16662c;
    }

    @m0
    public TileOverlayOptions v0(@m0 m mVar) {
        this.f16661b = (m) com.google.android.gms.common.internal.u.l(mVar, "tileProvider must not be null.");
        this.f16660a = new i0(this, mVar);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        com.google.android.gms.internal.maps.k kVar = this.f16660a;
        e1.b.B(parcel, 2, kVar == null ? null : kVar.asBinder(), false);
        e1.b.g(parcel, 3, s0());
        e1.b.w(parcel, 4, r0());
        e1.b.g(parcel, 5, K());
        e1.b.w(parcel, 6, p0());
        e1.b.b(parcel, iA);
    }

    @m0
    public TileOverlayOptions x0(float f8) {
        boolean z7 = false;
        if (f8 >= 0.0f && f8 <= 1.0f) {
            z7 = true;
        }
        com.google.android.gms.common.internal.u.b(z7, "Transparency must be in the range [0..1]");
        this.f16665f = f8;
        return this;
    }

    @SafeParcelable.b
    TileOverlayOptions(@SafeParcelable.e(id = 2) IBinder iBinder, @SafeParcelable.e(id = 3) boolean z7, @SafeParcelable.e(id = 4) float f8, @SafeParcelable.e(id = 5) boolean z8, @SafeParcelable.e(id = 6) float f9) {
        this.f16662c = true;
        this.f16664e = true;
        this.f16665f = 0.0f;
        com.google.android.gms.internal.maps.k kVarU0 = com.google.android.gms.internal.maps.j.u0(iBinder);
        this.f16660a = kVarU0;
        this.f16661b = kVarU0 == null ? null : new h0(this);
        this.f16662c = z7;
        this.f16663d = f8;
        this.f16664e = z8;
        this.f16665f = f9;
    }
}
