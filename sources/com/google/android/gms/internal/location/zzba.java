package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationRequestInternalCreator")
@SafeParcelable.f({1000, 2, 3, 4})
public final class zzba extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 1)
    final LocationRequest f16183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_CLIENTS", id = 5)
    final List<ClientIdentity> f16184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 6)
    final String f16185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_HIDE_FROM_APP_OPS", id = 7)
    final boolean f16186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_FORCE_COARSE_LOCATION", id = 8)
    final boolean f16187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_EXEMPT_FROM_THROTTLE", id = 9)
    final boolean f16188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 10)
    final String f16189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = com.paytm.pgsdk.d.G, id = 11)
    final boolean f16190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = com.paytm.pgsdk.d.G, id = 12)
    boolean f16191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 13)
    String f16192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.c(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_MAX_LOCATION_AGE_MILLIS", id = 14)
    long f16193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final List<ClientIdentity> f16182l = Collections.emptyList();
    public static final Parcelable.Creator<zzba> CREATOR = new b0();

    @SafeParcelable.b
    zzba(@SafeParcelable.e(id = 1) LocationRequest locationRequest, @SafeParcelable.e(id = 5) List<ClientIdentity> list, @c.o0 @SafeParcelable.e(id = 6) String str, @SafeParcelable.e(id = 7) boolean z7, @SafeParcelable.e(id = 8) boolean z8, @SafeParcelable.e(id = 9) boolean z9, @c.o0 @SafeParcelable.e(id = 10) String str2, @SafeParcelable.e(id = 11) boolean z10, @SafeParcelable.e(id = 12) boolean z11, @c.o0 @SafeParcelable.e(id = 13) String str3, @SafeParcelable.e(id = 14) long j7) {
        this.f16183a = locationRequest;
        this.f16184b = list;
        this.f16185c = str;
        this.f16186d = z7;
        this.f16187e = z8;
        this.f16188f = z9;
        this.f16189g = str2;
        this.f16190h = z10;
        this.f16191i = z11;
        this.f16192j = str3;
        this.f16193k = j7;
    }

    public static zzba s(@c.o0 String str, LocationRequest locationRequest) {
        return new zzba(locationRequest, f16182l, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
    }

    public final zzba K(long j7) {
        if (this.f16183a.s0() <= this.f16183a.r0()) {
            this.f16193k = RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT;
            return this;
        }
        long jR0 = this.f16183a.r0();
        long jS0 = this.f16183a.s0();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(jR0);
        sb.append("maxWaitTime=");
        sb.append(jS0);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba Q(@c.o0 String str) {
        this.f16192j = str;
        return this;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (com.google.android.gms.common.internal.s.b(this.f16183a, zzbaVar.f16183a) && com.google.android.gms.common.internal.s.b(this.f16184b, zzbaVar.f16184b) && com.google.android.gms.common.internal.s.b(this.f16185c, zzbaVar.f16185c) && this.f16186d == zzbaVar.f16186d && this.f16187e == zzbaVar.f16187e && this.f16188f == zzbaVar.f16188f && com.google.android.gms.common.internal.s.b(this.f16189g, zzbaVar.f16189g) && this.f16190h == zzbaVar.f16190h && this.f16191i == zzbaVar.f16191i && com.google.android.gms.common.internal.s.b(this.f16192j, zzbaVar.f16192j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f16183a.hashCode();
    }

    public final zzba p0(boolean z7) {
        this.f16191i = true;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f16183a);
        if (this.f16185c != null) {
            sb.append(" tag=");
            sb.append(this.f16185c);
        }
        if (this.f16189g != null) {
            sb.append(" moduleId=");
            sb.append(this.f16189g);
        }
        if (this.f16192j != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.f16192j);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f16186d);
        sb.append(" clients=");
        sb.append(this.f16184b);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f16187e);
        if (this.f16188f) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.f16190h) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.f16191i) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.S(parcel, 1, this.f16183a, i7, false);
        e1.b.d0(parcel, 5, this.f16184b, false);
        e1.b.Y(parcel, 6, this.f16185c, false);
        e1.b.g(parcel, 7, this.f16186d);
        e1.b.g(parcel, 8, this.f16187e);
        e1.b.g(parcel, 9, this.f16188f);
        e1.b.Y(parcel, 10, this.f16189g, false);
        e1.b.g(parcel, 11, this.f16190h);
        e1.b.g(parcel, 12, this.f16191i);
        e1.b.Y(parcel, 13, this.f16192j, false);
        e1.b.K(parcel, 14, this.f16193k);
        e1.b.b(parcel, iA);
    }
}
