package com.haier.library.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Serializable, Comparable<j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f26266e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f26268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient int f26269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient String f26270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final char[] f26265d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f26267f = m(new byte[0]);

    j(byte[] bArr) {
        this.f26268a = bArr;
    }

    @Nullable
    public static j B(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrC = f.c(str);
        if (bArrC != null) {
            return new j(bArrC);
        }
        return null;
    }

    public static j H(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) ((a(str.charAt(i8)) << 4) + a(str.charAt(i8 + 1)));
        }
        return m(bArr);
    }

    private j L(String str) {
        try {
            return m(MessageDigest.getInstance(str).digest(this.f26268a));
        } catch (NoSuchAlgorithmException e8) {
            throw new AssertionError(e8);
        }
    }

    private static int a(char c8) {
        if (c8 >= '0' && c8 <= '9') {
            return c8 - '0';
        }
        char c9 = 'a';
        if (c8 < 'a' || c8 > 'f') {
            c9 = 'A';
            if (c8 < 'A' || c8 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c8);
            }
        }
        return (c8 - c9) + 10;
    }

    static int c(String str, int i7) {
        int length = str.length();
        int iCharCount = 0;
        int i8 = 0;
        while (iCharCount < length) {
            if (i8 == i7) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i8++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    public static j h(InputStream inputStream, int i7) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i7);
        }
        byte[] bArr = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            int i9 = inputStream.read(bArr, i8, i7 - i8);
            if (i9 == -1) {
                throw new EOFException();
            }
            i8 += i9;
        }
        return new j(bArr);
    }

    public static j i(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        j jVar = new j(str.getBytes(c.f26245a));
        jVar.f26270c = str;
        return jVar;
    }

    private j j(String str, j jVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(jVar.a0(), str));
            return m(mac.doFinal(this.f26268a));
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        } catch (NoSuchAlgorithmException e9) {
            throw new AssertionError(e9);
        }
    }

    public static j k(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new j(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    public static j l(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new j(bArr);
    }

    public static j m(byte... bArr) {
        if (bArr != null) {
            return new j((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static j n(byte[] bArr, int i7, int i8) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        c.d(bArr.length, i7, i8);
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i7, bArr2, 0, i8);
        return new j(bArr2);
    }

    private void r(ObjectInputStream objectInputStream) throws IOException {
        j jVarH = h(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = j.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            declaredField.set(this, jVarH.f26268a);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void t(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f26268a.length);
        objectOutputStream.write(this.f26268a);
    }

    public j A(j jVar) {
        return j("HmacSHA256", jVar);
    }

    public String C() {
        return f.a(this.f26268a);
    }

    public final boolean D(byte[] bArr) {
        return w(0, bArr, 0, bArr.length);
    }

    public j E() {
        return L("MD5");
    }

    public j F(j jVar) {
        return j("HmacSHA512", jVar);
    }

    public final boolean I(byte[] bArr) {
        return w(Z() - bArr.length, bArr, 0, bArr.length);
    }

    public final int J(byte[] bArr) {
        return d(bArr, 0);
    }

    public j K() {
        return L("SHA-1");
    }

    public final boolean M(j jVar) {
        return v(0, jVar, 0, jVar.Z());
    }

    public final int N(byte[] bArr) {
        return z(bArr, Z());
    }

    public j O() {
        return L("SHA-256");
    }

    public final boolean P(j jVar) {
        return v(Z() - jVar.Z(), jVar, 0, jVar.Z());
    }

    public final int R(j jVar) {
        return d(jVar.b0(), 0);
    }

    public j S() {
        return L("SHA-512");
    }

    public final int T(j jVar) {
        return z(jVar.b0(), Z());
    }

    public String U() {
        return f.d(this.f26268a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        int iZ = Z();
        int iZ2 = jVar.Z();
        int iMin = Math.min(iZ, iZ2);
        for (int i7 = 0; i7 < iMin; i7++) {
            int iX = x(i7) & 255;
            int iX2 = jVar.x(i7) & 255;
            if (iX != iX2) {
                return iX < iX2 ? -1 : 1;
            }
        }
        if (iZ == iZ2) {
            return 0;
        }
        return iZ < iZ2 ? -1 : 1;
    }

    public String W() {
        byte[] bArr = this.f26268a;
        char[] cArr = new char[bArr.length * 2];
        int i7 = 0;
        for (byte b8 : bArr) {
            int i8 = i7 + 1;
            char[] cArr2 = f26265d;
            cArr[i7] = cArr2[(b8 >> 4) & 15];
            i7 = i8 + 1;
            cArr[i8] = cArr2[b8 & com.google.common.base.c.f19317q];
        }
        return new String(cArr);
    }

    public j X() {
        int i7 = 0;
        while (true) {
            byte[] bArr = this.f26268a;
            if (i7 >= bArr.length) {
                return this;
            }
            byte b8 = bArr[i7];
            if (b8 >= 65 && b8 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i7] = (byte) (b8 + 32);
                for (int i8 = i7 + 1; i8 < bArr2.length; i8++) {
                    byte b9 = bArr2[i8];
                    if (b9 >= 65 && b9 <= 90) {
                        bArr2[i8] = (byte) (b9 + 32);
                    }
                }
                return new j(bArr2);
            }
            i7++;
        }
    }

    public j Y() {
        int i7 = 0;
        while (true) {
            byte[] bArr = this.f26268a;
            if (i7 >= bArr.length) {
                return this;
            }
            byte b8 = bArr[i7];
            if (b8 >= 97 && b8 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i7] = (byte) (b8 - 32);
                for (int i8 = i7 + 1; i8 < bArr2.length; i8++) {
                    byte b9 = bArr2[i8];
                    if (b9 >= 97 && b9 <= 122) {
                        bArr2[i8] = (byte) (b9 - 32);
                    }
                }
                return new j(bArr2);
            }
            i7++;
        }
    }

    public int Z() {
        return this.f26268a.length;
    }

    public byte[] a0() {
        return (byte[]) this.f26268a.clone();
    }

    public final int b(j jVar, int i7) {
        return d(jVar.b0(), i7);
    }

    byte[] b0() {
        return this.f26268a;
    }

    public ByteBuffer c0() {
        return ByteBuffer.wrap(this.f26268a).asReadOnlyBuffer();
    }

    public int d(byte[] bArr, int i7) {
        int length = this.f26268a.length - bArr.length;
        for (int iMax = Math.max(i7, 0); iMax <= length; iMax++) {
            if (c.f(this.f26268a, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public j e(int i7) {
        return f(i7, this.f26268a.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            int iZ = jVar.Z();
            byte[] bArr = this.f26268a;
            if (iZ == bArr.length && jVar.w(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public j f(int i7, int i8) {
        if (i7 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f26268a;
        if (i8 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f26268a.length + ")");
        }
        int i9 = i8 - i7;
        if (i9 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i7 == 0 && i8 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i7, bArr2, 0, i9);
        return new j(bArr2);
    }

    public j g(j jVar) {
        return j("HmacSHA1", jVar);
    }

    public int hashCode() {
        int i7 = this.f26269b;
        if (i7 != 0) {
            return i7;
        }
        int iHashCode = Arrays.hashCode(this.f26268a);
        this.f26269b = iHashCode;
        return iHashCode;
    }

    public String o() {
        String str = this.f26270c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f26268a, c.f26245a);
        this.f26270c = str2;
        return str2;
    }

    public String p(Charset charset) {
        if (charset != null) {
            return new String(this.f26268a, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    void q(g gVar) {
        byte[] bArr = this.f26268a;
        gVar.T1(bArr, 0, bArr.length);
    }

    public String toString() {
        StringBuilder sb;
        if (this.f26268a.length == 0) {
            return "[size=0]";
        }
        String strO = o();
        int iC = c(strO, 64);
        if (iC == -1) {
            if (this.f26268a.length <= 64) {
                return "[hex=" + W() + "]";
            }
            return "[size=" + this.f26268a.length + " hex=" + f(0, 64).W() + "…]";
        }
        String strReplace = strO.substring(0, iC).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iC < strO.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f26268a.length);
            sb.append(" text=");
            sb.append(strReplace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(strReplace);
            sb.append("]");
        }
        return sb.toString();
    }

    public void u(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.f26268a);
    }

    public boolean v(int i7, j jVar, int i8, int i9) {
        return jVar.w(i8, this.f26268a, i7, i9);
    }

    public boolean w(int i7, byte[] bArr, int i8, int i9) {
        if (i7 >= 0) {
            byte[] bArr2 = this.f26268a;
            if (i7 <= bArr2.length - i9 && i8 >= 0 && i8 <= bArr.length - i9 && c.f(bArr2, i7, bArr, i8, i9)) {
                return true;
            }
        }
        return false;
    }

    public byte x(int i7) {
        return this.f26268a[i7];
    }

    public final int y(j jVar, int i7) {
        return z(jVar.b0(), i7);
    }

    public int z(byte[] bArr, int i7) {
        for (int iMin = Math.min(i7, this.f26268a.length - bArr.length); iMin >= 0; iMin--) {
            if (c.f(this.f26268a, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }
}
