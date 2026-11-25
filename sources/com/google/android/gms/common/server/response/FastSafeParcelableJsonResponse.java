package com.google.android.gms.common.server.response;

import android.os.Parcel;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.y;
import g1.d0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@y
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @c1.a
    public FastSafeParcelableJsonResponse() {
    }

    @c1.a
    @m0
    public byte[] c0() {
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @c1.a
    public boolean equals(@o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field<?, ?> field : d().values()) {
            if (g(field)) {
                if (!fastJsonResponse.g(field) || !s.b(e(field), fastJsonResponse.e(field))) {
                    return false;
                }
            } else if (fastJsonResponse.g(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @o0
    @d0
    public Object f(@m0 String str) {
        return null;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    @d0
    public boolean h(@m0 String str) {
        return false;
    }

    @c1.a
    public int hashCode() {
        int iHashCode = 0;
        for (FastJsonResponse.Field<?, ?> field : d().values()) {
            if (g(field)) {
                iHashCode = (iHashCode * 31) + u.k(e(field)).hashCode();
            }
        }
        return iHashCode;
    }
}
