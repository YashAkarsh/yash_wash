package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new a();

    static class a implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @o0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray createFromParcel(@m0 Parcel parcel) {
            return new ParcelableSparseArray(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseArray[] newArray(int i7) {
            return new ParcelableSparseArray[i7];
        }
    }

    public ParcelableSparseArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr[i8] = keyAt(i8);
            parcelableArr[i8] = valueAt(i8);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i7);
    }

    public ParcelableSparseArray(@m0 Parcel parcel, @o0 ClassLoader classLoader) {
        int i7 = parcel.readInt();
        int[] iArr = new int[i7];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i8 = 0; i8 < i7; i8++) {
            put(iArr[i8], parcelableArray[i8]);
        }
    }
}
