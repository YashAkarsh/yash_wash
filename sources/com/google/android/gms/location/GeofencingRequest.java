package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "GeofencingRequestCreator")
@SafeParcelable.f({1000})
public class GeofencingRequest extends AbstractSafeParcelable {

    @c.m0
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new o0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16254e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16255f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16256g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.c(getter = "getParcelableGeofences", id = 1)
    private final List<zzbe> f16257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b
    @SafeParcelable.c(getter = "getInitialTrigger", id = 2)
    private final int f16258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SafeParcelable.c(defaultValue = "", getter = "getTag", id = 3)
    private final String f16259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @SafeParcelable.c(getter = "getContextAttributionTag", id = 4)
    private final String f16260d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<zzbe> f16261a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b
        private int f16262b = 5;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f16263c = "";

        @c.m0
        public a a(@c.m0 f fVar) {
            com.google.android.gms.common.internal.u.l(fVar, "geofence can't be null.");
            com.google.android.gms.common.internal.u.b(fVar instanceof zzbe, "Geofence must be created using Geofence.Builder.");
            this.f16261a.add((zzbe) fVar);
            return this;
        }

        @c.m0
        public a b(@c.m0 List<f> list) {
            if (list != null && !list.isEmpty()) {
                for (f fVar : list) {
                    if (fVar != null) {
                        a(fVar);
                    }
                }
            }
            return this;
        }

        @c.m0
        public GeofencingRequest c() {
            com.google.android.gms.common.internal.u.b(!this.f16261a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.f16261a, this.f16262b, this.f16263c, null);
        }

        @c.m0
        public a d(@b int i7) {
            this.f16262b = i7 & 7;
            return this;
        }
    }

    public @interface b {
    }

    @SafeParcelable.b
    GeofencingRequest(@SafeParcelable.e(id = 1) List<zzbe> list, @SafeParcelable.e(id = 2) @b int i7, @SafeParcelable.e(id = 3) String str, @c.o0 @SafeParcelable.e(id = 4) String str2) {
        this.f16257a = list;
        this.f16258b = i7;
        this.f16259c = str;
        this.f16260d = str2;
    }

    @c.m0
    public List<f> K() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f16257a);
        return arrayList;
    }

    @b
    public int Q() {
        return this.f16258b;
    }

    @c.m0
    public final GeofencingRequest p0(@c.o0 String str) {
        return new GeofencingRequest(this.f16257a, this.f16258b, this.f16259c, str);
    }

    @c.m0
    public String toString() {
        return "GeofencingRequest[geofences=" + this.f16257a + ", initialTrigger=" + this.f16258b + ", tag=" + this.f16259c + ", attributionTag=" + this.f16260d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.d0(parcel, 1, this.f16257a, false);
        e1.b.F(parcel, 2, Q());
        e1.b.Y(parcel, 3, this.f16259c, false);
        e1.b.Y(parcel, 4, this.f16260d, false);
        e1.b.b(parcel, iA);
    }
}
