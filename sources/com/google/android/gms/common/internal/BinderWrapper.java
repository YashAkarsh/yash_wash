package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@KeepName
public final class BinderWrapper implements Parcelable {

    @c.m0
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f15617a;

    @c1.a
    public BinderWrapper(@c.m0 IBinder iBinder) {
        this.f15617a = iBinder;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@c.m0 Parcel parcel, int i7) {
        parcel.writeStrongBinder(this.f15617a);
    }
}
