package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ClientIdentityCreator")
@c1.a
@SafeParcelable.f({1000})
public class ClientIdentity extends AbstractSafeParcelable {

    @c1.a
    @c.m0
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @SafeParcelable.c(defaultValueUnchecked = "0", id = 1)
    public final int f15618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @c1.a
    @SafeParcelable.c(defaultValueUnchecked = "null", id = 2)
    public final String f15619b;

    @SafeParcelable.b
    public ClientIdentity(@SafeParcelable.e(id = 1) int i7, @c.o0 @SafeParcelable.e(id = 2) String str) {
        this.f15618a = i7;
        this.f15619b = str;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f15618a == this.f15618a && s.b(clientIdentity.f15619b, this.f15619b);
    }

    public final int hashCode() {
        return this.f15618a;
    }

    @c.m0
    public final String toString() {
        int i7 = this.f15618a;
        String str = this.f15619b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i7);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15618a);
        e1.b.Y(parcel, 2, this.f15619b, false);
        e1.b.b(parcel, iA);
    }
}
