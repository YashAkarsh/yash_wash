package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class g<T extends SafeParcelable> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f15558c = {"data"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcelable.Creator<T> f15559b;

    @c1.a
    public g(@m0 DataHolder dataHolder, @m0 Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f15559b = creator;
    }

    @c1.a
    public static <T extends SafeParcelable> void b(@m0 DataHolder.a aVar, @m0 T t7) {
        Parcel parcelObtain = Parcel.obtain();
        t7.writeToParcel(parcelObtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", parcelObtain.marshall());
        aVar.c(contentValues);
        parcelObtain.recycle();
    }

    @c1.a
    @m0
    public static DataHolder.a r() {
        return DataHolder.s(f15558c);
    }

    @Override // com.google.android.gms.common.data.a, com.google.android.gms.common.data.b
    @c1.a
    @m0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public T get(int i7) {
        DataHolder dataHolder = (DataHolder) u.k(this.f15551a);
        byte[] bArrP0 = dataHolder.p0("data", i7, dataHolder.G0(i7));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrP0, 0, bArrP0.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = this.f15559b.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }
}
