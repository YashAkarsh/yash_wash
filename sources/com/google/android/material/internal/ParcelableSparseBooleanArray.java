package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new a();

    static class a implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray createFromParcel(@m0 Parcel parcel) {
            int i7 = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i7);
            int[] iArr = new int[i7];
            boolean[] zArr = new boolean[i7];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i8 = 0; i8 < i7; i8++) {
                parcelableSparseBooleanArray.put(iArr[i8], zArr[i8]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray[] newArray(int i7) {
            return new ParcelableSparseBooleanArray[i7];
        }
    }

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i8 = 0; i8 < size(); i8++) {
            iArr[i8] = keyAt(i8);
            zArr[i8] = valueAt(i8);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }

    public ParcelableSparseBooleanArray(int i7) {
        super(i7);
    }

    public ParcelableSparseBooleanArray(@m0 SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i7 = 0; i7 < sparseBooleanArray.size(); i7++) {
            put(sparseBooleanArray.keyAt(i7), sparseBooleanArray.valueAt(i7));
        }
    }
}
