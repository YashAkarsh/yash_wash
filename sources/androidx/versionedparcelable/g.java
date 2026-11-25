package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import c.x0;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class g extends e {
    private static final Charset C = Charset.forName(CharEncoding.UTF_16);
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    private static final int G = 3;
    private static final int H = 4;
    private static final int I = 5;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f11038J = 6;
    private static final int K = 7;
    private static final int L = 8;
    private static final int M = 9;
    private static final int N = 10;
    private static final int O = 11;
    private static final int P = 12;
    private static final int Q = 13;
    private static final int R = 14;
    private int A;
    int B;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DataInputStream f11039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DataOutputStream f11040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private DataInputStream f11041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private DataOutputStream f11042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private b f11043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f11044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f11045z;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ByteArrayOutputStream f11047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final DataOutputStream f11048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DataOutputStream f11050d;

        b(int i7, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f11047a = byteArrayOutputStream;
            this.f11048b = new DataOutputStream(byteArrayOutputStream);
            this.f11049c = i7;
            this.f11050d = dataOutputStream;
        }

        void a() throws IOException {
            this.f11048b.flush();
            int size = this.f11047a.size();
            this.f11050d.writeInt((this.f11049c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.f11050d.writeInt(size);
            }
            this.f11047a.writeTo(this.f11050d);
        }
    }

    public g(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    private void o1(int i7, String str, Bundle bundle) {
        switch (i7) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, p());
                return;
            case 2:
                bundle.putBundle(str, p());
                return;
            case 3:
                bundle.putString(str, c0());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) j(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, l());
                return;
            case 6:
                bundle.putBooleanArray(str, n());
                return;
            case 7:
                bundle.putDouble(str, y());
                return;
            case 8:
                bundle.putDoubleArray(str, A());
                return;
            case 9:
                bundle.putInt(str, L());
                return;
            case 10:
                bundle.putIntArray(str, N());
                return;
            case 11:
                bundle.putLong(str, Q());
                return;
            case 12:
                bundle.putLongArray(str, S());
                return;
            case 13:
                bundle.putFloat(str, G());
                return;
            case 14:
                bundle.putFloatArray(str, I());
                return;
            default:
                throw new RuntimeException("Unknown type " + i7);
        }
    }

    private void p1(Object obj) {
        if (obj == null) {
            L0(0);
            return;
        }
        if (obj instanceof Bundle) {
            L0(1);
            q0((Bundle) obj);
            return;
        }
        if (obj instanceof String) {
            L0(3);
            e1((String) obj);
            return;
        }
        if (obj instanceof String[]) {
            L0(4);
            k0((String[]) obj);
            return;
        }
        if (obj instanceof Boolean) {
            L0(5);
            m0(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            L0(6);
            o0((boolean[]) obj);
            return;
        }
        if (obj instanceof Double) {
            L0(7);
            C0(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            L0(8);
            E0((double[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            L0(9);
            L0(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            L0(10);
            N0((int[]) obj);
            return;
        }
        if (obj instanceof Long) {
            L0(11);
            Q0(((Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            L0(12);
            S0((long[]) obj);
            return;
        }
        if (obj instanceof Float) {
            L0(13);
            H0(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            L0(14);
            J0((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.e
    public void C0(double d8) {
        try {
            this.f11042w.writeDouble(d8);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public boolean F(int i7) {
        while (true) {
            try {
                int i8 = this.A;
                if (i8 == i7) {
                    return true;
                }
                if (String.valueOf(i8).compareTo(String.valueOf(i7)) > 0) {
                    return false;
                }
                int i9 = this.f11045z;
                int i10 = this.B;
                if (i9 < i10) {
                    this.f11039t.skip(i10 - i9);
                }
                this.B = -1;
                int i11 = this.f11039t.readInt();
                this.f11045z = 0;
                int i12 = i11 & 65535;
                if (i12 == 65535) {
                    i12 = this.f11039t.readInt();
                }
                this.A = (i11 >> 16) & 65535;
                this.B = i12;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.e
    public float G() {
        try {
            return this.f11041v.readFloat();
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void H0(float f8) {
        try {
            this.f11042w.writeFloat(f8);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public int L() {
        try {
            return this.f11041v.readInt();
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void L0(int i7) {
        try {
            this.f11042w.writeInt(i7);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public long Q() {
        try {
            return this.f11041v.readLong();
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void Q0(long j7) {
        try {
            this.f11042w.writeLong(j7);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public <T extends Parcelable> T V() {
        return null;
    }

    @Override // androidx.versionedparcelable.e
    public void W0(Parcelable parcelable) {
        if (!this.f11044y) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.e
    public void a() {
        b bVar = this.f11043x;
        if (bVar != null) {
            try {
                if (bVar.f11047a.size() != 0) {
                    this.f11043x.a();
                }
                this.f11043x = null;
            } catch (IOException e8) {
                throw new e.b(e8);
            }
        }
    }

    @Override // androidx.versionedparcelable.e
    protected e c() {
        return new g(this.f11041v, this.f11042w, this.f11027a, this.f11028b, this.f11029c);
    }

    @Override // androidx.versionedparcelable.e
    public String c0() {
        try {
            int i7 = this.f11041v.readInt();
            if (i7 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i7];
            this.f11041v.readFully(bArr);
            return new String(bArr, C);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public IBinder e0() {
        return null;
    }

    @Override // androidx.versionedparcelable.e
    public void e1(String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(C);
                this.f11042w.writeInt(bytes.length);
                this.f11042w.write(bytes);
            } else {
                this.f11042w.writeInt(-1);
            }
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void g1(IBinder iBinder) {
        if (!this.f11044y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.e
    public boolean i() {
        return true;
    }

    @Override // androidx.versionedparcelable.e
    public void i0(int i7) {
        a();
        b bVar = new b(i7, this.f11040u);
        this.f11043x = bVar;
        this.f11042w = bVar.f11048b;
    }

    @Override // androidx.versionedparcelable.e
    public void i1(IInterface iInterface) {
        if (!this.f11044y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.e
    public void j0(boolean z7, boolean z8) {
        if (!z7) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.f11044y = z8;
    }

    @Override // androidx.versionedparcelable.e
    public boolean l() {
        try {
            return this.f11041v.readBoolean();
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void m0(boolean z7) {
        try {
            this.f11042w.writeBoolean(z7);
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public Bundle p() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i7 = 0; i7 < iL; i7++) {
            o1(L(), c0(), bundle);
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.e
    public void q0(Bundle bundle) {
        try {
            if (bundle == null) {
                this.f11042w.writeInt(-1);
                return;
            }
            Set<String> setKeySet = bundle.keySet();
            this.f11042w.writeInt(setKeySet.size());
            for (String str : setKeySet) {
                e1(str);
                p1(bundle.get(str));
            }
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public byte[] s() {
        try {
            int i7 = this.f11041v.readInt();
            if (i7 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i7];
            this.f11041v.readFully(bArr);
            return bArr;
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public void t0(byte[] bArr) {
        try {
            if (bArr != null) {
                this.f11042w.writeInt(bArr.length);
                this.f11042w.write(bArr);
            } else {
                this.f11042w.writeInt(-1);
            }
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    protected CharSequence v() {
        return null;
    }

    @Override // androidx.versionedparcelable.e
    public void v0(byte[] bArr, int i7, int i8) {
        try {
            if (bArr != null) {
                this.f11042w.writeInt(i8);
                this.f11042w.write(bArr, i7, i8);
            } else {
                this.f11042w.writeInt(-1);
            }
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    public double y() {
        try {
            return this.f11041v.readDouble();
        } catch (IOException e8) {
            throw new e.b(e8);
        }
    }

    @Override // androidx.versionedparcelable.e
    protected void y0(CharSequence charSequence) {
        if (!this.f11044y) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    private g(InputStream inputStream, OutputStream outputStream, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f11045z = 0;
        this.A = -1;
        this.B = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new a(inputStream)) : null;
        this.f11039t = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.f11040u = dataOutputStream;
        this.f11041v = dataInputStream;
        this.f11042w = dataOutputStream;
    }

    class a extends FilterInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            g gVar = g.this;
            int i7 = gVar.B;
            if (i7 != -1 && gVar.f11045z >= i7) {
                throw new IOException();
            }
            int i8 = super.read();
            g.this.f11045z++;
            return i8;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j7) throws IOException {
            g gVar = g.this;
            int i7 = gVar.B;
            if (i7 != -1 && gVar.f11045z >= i7) {
                throw new IOException();
            }
            long jSkip = super.skip(j7);
            if (jSkip > 0) {
                g.this.f11045z += (int) jSkip;
            }
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            g gVar = g.this;
            int i9 = gVar.B;
            if (i9 != -1 && gVar.f11045z >= i9) {
                throw new IOException();
            }
            int i10 = super.read(bArr, i7, i8);
            if (i10 > 0) {
                g.this.f11045z += i10;
            }
            return i10;
        }
    }
}
