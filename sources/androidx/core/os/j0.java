package androidx.core.os;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {
    private j0() {
    }

    public static boolean a(@c.m0 Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void b(@c.m0 Parcel parcel, boolean z7) {
        parcel.writeInt(z7 ? 1 : 0);
    }
}
