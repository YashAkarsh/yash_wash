package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.y;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "FieldMappingDictionaryEntryCreator")
@y
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(id = 2)
    final String f15951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    @SafeParcelable.c(id = 3)
    final ArrayList<zam> f15952c;

    @SafeParcelable.b
    zal(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) ArrayList<zam> arrayList) {
        this.f15950a = i7;
        this.f15951b = str;
        this.f15952c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15950a);
        e1.b.Y(parcel, 2, this.f15951b, false);
        e1.b.d0(parcel, 3, this.f15952c, false);
        e1.b.b(parcel, iA);
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f15950a = 1;
        this.f15951b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.f15952c = arrayList;
    }
}
