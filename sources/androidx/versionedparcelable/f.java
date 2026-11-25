package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import c.x0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class f extends e {
    private static final boolean B = false;
    private static final String C = "VersionedParcelParcel";
    private int A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final SparseIntArray f11031t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Parcel f11032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f11033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f11034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f11035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f11036y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11037z;

    f(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.e
    public void C0(double d8) {
        this.f11032u.writeDouble(d8);
    }

    @Override // androidx.versionedparcelable.e
    public boolean F(int i7) {
        while (this.f11037z < this.f11034w) {
            int i8 = this.A;
            if (i8 == i7) {
                return true;
            }
            if (String.valueOf(i8).compareTo(String.valueOf(i7)) > 0) {
                return false;
            }
            this.f11032u.setDataPosition(this.f11037z);
            int i9 = this.f11032u.readInt();
            this.A = this.f11032u.readInt();
            this.f11037z += i9;
        }
        return this.A == i7;
    }

    @Override // androidx.versionedparcelable.e
    public float G() {
        return this.f11032u.readFloat();
    }

    @Override // androidx.versionedparcelable.e
    public void H0(float f8) {
        this.f11032u.writeFloat(f8);
    }

    @Override // androidx.versionedparcelable.e
    public int L() {
        return this.f11032u.readInt();
    }

    @Override // androidx.versionedparcelable.e
    public void L0(int i7) {
        this.f11032u.writeInt(i7);
    }

    @Override // androidx.versionedparcelable.e
    public long Q() {
        return this.f11032u.readLong();
    }

    @Override // androidx.versionedparcelable.e
    public void Q0(long j7) {
        this.f11032u.writeLong(j7);
    }

    @Override // androidx.versionedparcelable.e
    public <T extends Parcelable> T V() {
        return (T) this.f11032u.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.e
    public void W0(Parcelable parcelable) {
        this.f11032u.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.e
    public void a() {
        int i7 = this.f11036y;
        if (i7 >= 0) {
            int i8 = this.f11031t.get(i7);
            int iDataPosition = this.f11032u.dataPosition();
            this.f11032u.setDataPosition(i8);
            this.f11032u.writeInt(iDataPosition - i8);
            this.f11032u.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.e
    protected e c() {
        Parcel parcel = this.f11032u;
        int iDataPosition = parcel.dataPosition();
        int i7 = this.f11037z;
        if (i7 == this.f11033v) {
            i7 = this.f11034w;
        }
        return new f(parcel, iDataPosition, i7, this.f11035x + "  ", this.f11027a, this.f11028b, this.f11029c);
    }

    @Override // androidx.versionedparcelable.e
    public String c0() {
        return this.f11032u.readString();
    }

    @Override // androidx.versionedparcelable.e
    public IBinder e0() {
        return this.f11032u.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.e
    public void e1(String str) {
        this.f11032u.writeString(str);
    }

    @Override // androidx.versionedparcelable.e
    public void g1(IBinder iBinder) {
        this.f11032u.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.e
    public void i0(int i7) {
        a();
        this.f11036y = i7;
        this.f11031t.put(i7, this.f11032u.dataPosition());
        L0(0);
        L0(i7);
    }

    @Override // androidx.versionedparcelable.e
    public void i1(IInterface iInterface) {
        this.f11032u.writeStrongInterface(iInterface);
    }

    @Override // androidx.versionedparcelable.e
    public boolean l() {
        return this.f11032u.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.e
    public void m0(boolean z7) {
        this.f11032u.writeInt(z7 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.e
    public Bundle p() {
        return this.f11032u.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.e
    public void q0(Bundle bundle) {
        this.f11032u.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.e
    public byte[] s() {
        int i7 = this.f11032u.readInt();
        if (i7 < 0) {
            return null;
        }
        byte[] bArr = new byte[i7];
        this.f11032u.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.e
    public void t0(byte[] bArr) {
        if (bArr == null) {
            this.f11032u.writeInt(-1);
        } else {
            this.f11032u.writeInt(bArr.length);
            this.f11032u.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.e
    protected CharSequence v() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f11032u);
    }

    @Override // androidx.versionedparcelable.e
    public void v0(byte[] bArr, int i7, int i8) {
        if (bArr == null) {
            this.f11032u.writeInt(-1);
        } else {
            this.f11032u.writeInt(bArr.length);
            this.f11032u.writeByteArray(bArr, i7, i8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public double y() {
        return this.f11032u.readDouble();
    }

    @Override // androidx.versionedparcelable.e
    protected void y0(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f11032u, 0);
    }

    private f(Parcel parcel, int i7, int i8, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f11031t = new SparseIntArray();
        this.f11036y = -1;
        this.A = -1;
        this.f11032u = parcel;
        this.f11033v = i7;
        this.f11034w = i8;
        this.f11037z = i7;
        this.f11035x = str;
    }
}
