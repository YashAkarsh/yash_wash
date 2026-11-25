package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "LocationSettingsRequestCreator")
@SafeParcelable.f({1000})
public final class LocationSettingsRequest extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new f1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getLocationRequests", id = 1)
    private final List<LocationRequest> f16284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = com.paytm.pgsdk.d.G, getter = "alwaysShow", id = 2)
    private final boolean f16285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(getter = "needBle", id = 3)
    private final boolean f16286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getConfiguration", id = 5)
    private zzbj f16287d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<LocationRequest> f16288a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16289b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f16290c = false;

        @c.m0
        public a a(@c.m0 Collection<LocationRequest> collection) {
            for (LocationRequest locationRequest : collection) {
                if (locationRequest != null) {
                    this.f16288a.add(locationRequest);
                }
            }
            return this;
        }

        @c.m0
        public a b(@c.m0 LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f16288a.add(locationRequest);
            }
            return this;
        }

        @c.m0
        public LocationSettingsRequest c() {
            return new LocationSettingsRequest(this.f16288a, this.f16289b, this.f16290c, null);
        }

        @c.m0
        public a d(boolean z7) {
            this.f16289b = z7;
            return this;
        }

        @c.m0
        public a e(boolean z7) {
            this.f16290c = z7;
            return this;
        }
    }

    @SafeParcelable.b
    LocationSettingsRequest(@SafeParcelable.e(id = 1) List<LocationRequest> list, @SafeParcelable.e(id = 2) boolean z7, @SafeParcelable.e(id = 3) boolean z8, @c.o0 @SafeParcelable.e(id = 5) zzbj zzbjVar) {
        this.f16284a = list;
        this.f16285b = z7;
        this.f16286c = z8;
        this.f16287d = zzbjVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, Collections.unmodifiableList(this.f16284a), false);
        e1.b.g(parcel, 2, this.f16285b);
        e1.b.g(parcel, 3, this.f16286c);
        e1.b.S(parcel, 5, this.f16287d, i7, false);
        e1.b.b(parcel, iA);
    }
}
