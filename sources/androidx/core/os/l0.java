package androidx.core.os;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface l0<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i7);
}
