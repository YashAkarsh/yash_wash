package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class k0 {

    static class a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l0<T> f6090a;

        a(l0<T> l0Var) {
            this.f6090a = l0Var;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return this.f6090a.createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i7) {
            return this.f6090a.newArray(i7);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f6090a.createFromParcel(parcel, classLoader);
        }
    }

    private k0() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> a(l0<T> l0Var) {
        return new a(l0Var);
    }
}
