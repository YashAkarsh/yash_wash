package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f7729o = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f7730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<String> f7731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f7732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f7733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f7734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f7735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f7736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f7737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final CharSequence f7738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f7739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final CharSequence f7740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final ArrayList<String> f7741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ArrayList<String> f7742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f7743n;

    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i7) {
            return new BackStackState[i7];
        }
    }

    public BackStackState(androidx.fragment.app.a aVar) {
        int size = aVar.f8074c.size();
        this.f7730a = new int[size * 5];
        if (!aVar.f8080i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f7731b = new ArrayList<>(size);
        this.f7732c = new int[size];
        this.f7733d = new int[size];
        int i7 = 0;
        int i8 = 0;
        while (i7 < size) {
            v.a aVar2 = aVar.f8074c.get(i7);
            int i9 = i8 + 1;
            this.f7730a[i8] = aVar2.f8091a;
            ArrayList<String> arrayList = this.f7731b;
            Fragment fragment = aVar2.f8092b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f7730a;
            int i10 = i9 + 1;
            iArr[i9] = aVar2.f8093c;
            int i11 = i10 + 1;
            iArr[i10] = aVar2.f8094d;
            int i12 = i11 + 1;
            iArr[i11] = aVar2.f8095e;
            iArr[i12] = aVar2.f8096f;
            this.f7732c[i7] = aVar2.f8097g.ordinal();
            this.f7733d[i7] = aVar2.f8098h.ordinal();
            i7++;
            i8 = i12 + 1;
        }
        this.f7734e = aVar.f8079h;
        this.f7735f = aVar.f8082k;
        this.f7736g = aVar.N;
        this.f7737h = aVar.f8083l;
        this.f7738i = aVar.f8084m;
        this.f7739j = aVar.f8085n;
        this.f7740k = aVar.f8086o;
        this.f7741l = aVar.f8087p;
        this.f7742m = aVar.f8088q;
        this.f7743n = aVar.f8089r;
    }

    public androidx.fragment.app.a a(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.f7730a.length) {
            v.a aVar2 = new v.a();
            int i9 = i7 + 1;
            aVar2.f8091a = this.f7730a[i7];
            if (FragmentManager.T0(2)) {
                Log.v(f7729o, "Instantiate " + aVar + " op #" + i8 + " base fragment #" + this.f7730a[i9]);
            }
            String str = this.f7731b.get(i8);
            if (str != null) {
                aVar2.f8092b = fragmentManager.n0(str);
            } else {
                aVar2.f8092b = null;
            }
            aVar2.f8097g = androidx.lifecycle.m.c.values()[this.f7732c[i8]];
            aVar2.f8098h = androidx.lifecycle.m.c.values()[this.f7733d[i8]];
            int[] iArr = this.f7730a;
            int i10 = i9 + 1;
            int i11 = iArr[i9];
            aVar2.f8093c = i11;
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            aVar2.f8094d = i13;
            int i14 = i12 + 1;
            int i15 = iArr[i12];
            aVar2.f8095e = i15;
            int i16 = iArr[i14];
            aVar2.f8096f = i16;
            aVar.f8075d = i11;
            aVar.f8076e = i13;
            aVar.f8077f = i15;
            aVar.f8078g = i16;
            aVar.n(aVar2);
            i8++;
            i7 = i14 + 1;
        }
        aVar.f8079h = this.f7734e;
        aVar.f8082k = this.f7735f;
        aVar.N = this.f7736g;
        aVar.f8080i = true;
        aVar.f8083l = this.f7737h;
        aVar.f8084m = this.f7738i;
        aVar.f8085n = this.f7739j;
        aVar.f8086o = this.f7740k;
        aVar.f8087p = this.f7741l;
        aVar.f8088q = this.f7742m;
        aVar.f8089r = this.f7743n;
        aVar.V(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeIntArray(this.f7730a);
        parcel.writeStringList(this.f7731b);
        parcel.writeIntArray(this.f7732c);
        parcel.writeIntArray(this.f7733d);
        parcel.writeInt(this.f7734e);
        parcel.writeString(this.f7735f);
        parcel.writeInt(this.f7736g);
        parcel.writeInt(this.f7737h);
        TextUtils.writeToParcel(this.f7738i, parcel, 0);
        parcel.writeInt(this.f7739j);
        TextUtils.writeToParcel(this.f7740k, parcel, 0);
        parcel.writeStringList(this.f7741l);
        parcel.writeStringList(this.f7742m);
        parcel.writeInt(this.f7743n ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f7730a = parcel.createIntArray();
        this.f7731b = parcel.createStringArrayList();
        this.f7732c = parcel.createIntArray();
        this.f7733d = parcel.createIntArray();
        this.f7734e = parcel.readInt();
        this.f7735f = parcel.readString();
        this.f7736g = parcel.readInt();
        this.f7737h = parcel.readInt();
        this.f7738i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f7739j = parcel.readInt();
        this.f7740k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f7741l = parcel.createStringArrayList();
        this.f7742m = parcel.createStringArrayList();
        this.f7743n = parcel.readInt() != 0;
    }
}
