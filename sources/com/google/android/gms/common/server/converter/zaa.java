package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "ConverterWrapperCreator")
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter f15908b;

    @SafeParcelable.b
    zaa(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) StringToIntConverter stringToIntConverter) {
        this.f15907a = i7;
        this.f15908b = stringToIntConverter;
    }

    public static zaa s(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> K() {
        StringToIntConverter stringToIntConverter = this.f15908b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15907a);
        e1.b.S(parcel, 2, this.f15908b, i7, false);
        e1.b.b(parcel, iA);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f15907a = 1;
        this.f15908b = stringToIntConverter;
    }
}
