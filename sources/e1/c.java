package e1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.internal.common.h;
import g1.d0;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.net.impl.CronetUrlRequest;

/* JADX INFO: loaded from: classes.dex */
@d0
@c1.a
public final class c {
    private c() {
    }

    @c1.a
    @m0
    public static <T extends SafeParcelable> T a(@m0 byte[] bArr, @m0 Parcelable.Creator<T> creator) {
        u.k(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    @o0
    @c1.a
    public static <T extends SafeParcelable> T b(@m0 Intent intent, @m0 String str, @m0 Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) a(byteArrayExtra, creator);
    }

    @c1.a
    @m0
    public static <T extends SafeParcelable> T c(@m0 String str, @m0 Parcelable.Creator<T> creator) {
        return (T) a(g1.c.b(str), creator);
    }

    @o0
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> d(@m0 Bundle bundle, @m0 String str, @m0 Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            jVar.add(a((byte[]) arrayList.get(i7), creator));
        }
        return jVar;
    }

    @o0
    @c1.a
    public static <T extends SafeParcelable> ArrayList<T> e(@m0 Bundle bundle, @m0 String str, @m0 Parcelable.Creator<T> creator) {
        return f(bundle.getByteArray(str), creator);
    }

    @o0
    public static <T extends SafeParcelable> ArrayList<T> f(@o0 byte[] bArr, @m0 Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, length);
        parcelObtain.setDataPosition(0);
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            parcelObtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            parcelObtain.recycle();
        }
    }

    @o0
    @c1.a
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> g(@m0 Intent intent, @m0 String str, @m0 Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            jVar.add(a((byte[]) arrayList.get(i7), creator));
        }
        return jVar;
    }

    @o0
    @c1.a
    public static <T extends SafeParcelable> ArrayList<T> h(@m0 Intent intent, @m0 String str, @m0 Parcelable.Creator<T> creator) {
        return f(intent.getByteArrayExtra(str), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> void i(@m0 Iterable<T> iterable, @m0 Bundle bundle, @m0 String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(m(it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <T extends SafeParcelable> void j(@m0 Iterable<T> iterable, @m0 Bundle bundle, @m0 String str) {
        bundle.putByteArray(str, p(iterable));
    }

    @c1.a
    @Deprecated
    public static <T extends SafeParcelable> void k(@m0 Iterable<T> iterable, @m0 Intent intent, @m0 String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(m(it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    @c1.a
    public static <T extends SafeParcelable> void l(@m0 Iterable<T> iterable, @m0 Intent intent, @m0 String str) {
        intent.putExtra(str, p(iterable));
    }

    @c1.a
    @m0
    public static <T extends SafeParcelable> byte[] m(@m0 T t7) {
        Parcel parcelObtain = Parcel.obtain();
        t7.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    @c1.a
    public static <T extends SafeParcelable> void n(@m0 T t7, @m0 Intent intent, @m0 String str) {
        intent.putExtra(str, m(t7));
    }

    @c1.a
    @m0
    public static <T extends SafeParcelable> String o(@m0 T t7) {
        return g1.c.e(m(t7));
    }

    private static <T extends SafeParcelable> byte[] p(Iterable<T> iterable) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeTypedList(h.m(iterable));
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }
}
