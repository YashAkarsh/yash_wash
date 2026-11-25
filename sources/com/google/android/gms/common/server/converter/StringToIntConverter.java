package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "StringToIntConverterCreator")
@c1.a
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {

    @m0
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1)
    final int f15904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, Integer> f15905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<String> f15906c;

    @c1.a
    public StringToIntConverter() {
        this.f15904a = 1;
        this.f15905b = new HashMap<>();
        this.f15906c = new SparseArray<>();
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final int b() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final int e() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    @m0
    public final /* bridge */ /* synthetic */ String f(@m0 Integer num) {
        String str = this.f15906c.get(num.intValue());
        return (str == null && this.f15905b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    @o0
    public final /* bridge */ /* synthetic */ Integer g(@m0 String str) {
        Integer num = this.f15905b.get(str);
        return num == null ? this.f15905b.get("gms_unknown") : num;
    }

    @c1.a
    @m0
    public StringToIntConverter s(@m0 String str, int i7) {
        this.f15905b.put(str, Integer.valueOf(i7));
        this.f15906c.put(i7, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.F(parcel, 1, this.f15904a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f15905b.keySet()) {
            arrayList.add(new zac(str, this.f15905b.get(str).intValue()));
        }
        e1.b.d0(parcel, 2, arrayList, false);
        e1.b.b(parcel, iA);
    }

    @SafeParcelable.b
    StringToIntConverter(@SafeParcelable.e(id = 1) int i7, @SafeParcelable.e(id = 2) ArrayList<zac> arrayList) {
        this.f15904a = i7;
        this.f15905b = new HashMap<>();
        this.f15906c = new SparseArray<>();
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            zac zacVar = arrayList.get(i8);
            s(zacVar.f15910b, zacVar.f15911c);
        }
    }
}
