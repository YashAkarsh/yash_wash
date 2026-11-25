package androidx.test.runner.internal.deps.aidl;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Codecs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ClassLoader f10480a = Codecs.class.getClassLoader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f10481b = 0;

    private Codecs() {
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static CharSequence b(Parcel parcel) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public static ArrayList c(Parcel parcel) {
        return parcel.readArrayList(f10480a);
    }

    public static HashMap d(Parcel parcel) {
        return parcel.readHashMap(f10480a);
    }

    public static <T extends Parcelable> T e(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void f(Parcel parcel, List<?> list) {
        parcel.readList(list, f10480a);
    }

    public static void g(Parcel parcel, Map<?, ?> map) {
        parcel.readMap(map, f10480a);
    }

    public static void h(Parcel parcel, boolean z7) {
        parcel.writeInt(z7 ? 1 : 0);
    }

    public static void i(Parcel parcel, CharSequence charSequence) {
        if (charSequence == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            TextUtils.writeToParcel(charSequence, parcel, 0);
        }
    }

    public static void j(Parcel parcel, CharSequence charSequence) {
        if (charSequence == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            TextUtils.writeToParcel(charSequence, parcel, 1);
        }
    }

    public static void k(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void l(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 1);
        }
    }

    public static void m(Parcel parcel, IInterface iinterface) {
        if (iinterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iinterface.asBinder());
        }
    }
}
