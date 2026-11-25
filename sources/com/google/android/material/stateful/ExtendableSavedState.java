package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.i;
import androidx.customview.view.AbsSavedState;
import c.m0;
import c.o0;
import com.alipay.sdk.util.j;

/* JADX INFO: loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    public final i<String, Bundle> f18504c;

    static class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @o0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@m0 Parcel parcel) {
            return new ExtendableSavedState(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @m0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @m0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExtendableSavedState[] newArray(int i7) {
            return new ExtendableSavedState[i7];
        }
    }

    /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    @m0
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f18504c + j.f13808d;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@m0 Parcel parcel, int i7) {
        super.writeToParcel(parcel, i7);
        int size = this.f18504c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i8 = 0; i8 < size; i8++) {
            strArr[i8] = this.f18504c.k(i8);
            bundleArr[i8] = this.f18504c.o(i8);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f18504c = new i<>();
    }

    private ExtendableSavedState(@m0 Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i7 = parcel.readInt();
        String[] strArr = new String[i7];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i7];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f18504c = new i<>(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            this.f18504c.put(strArr[i8], bundleArr[i8]);
        }
    }
}
