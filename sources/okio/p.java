package okio;

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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
public class p implements Serializable, Comparable<p> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f38506d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int f38509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private transient String f38510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final byte[] f38511c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f38508f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f38507e = new p(new byte[0]);

    public static final class a {
        private a() {
        }

        public static /* synthetic */ p k(a aVar, String str, Charset charset, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                charset = kotlin.text.f.f35353b;
            }
            return aVar.j(str, charset);
        }

        public static /* synthetic */ p p(a aVar, byte[] bArr, int i7, int i8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                i7 = 0;
            }
            if ((i9 & 2) != 0) {
                i8 = bArr.length;
            }
            return aVar.o(bArr, i7, i8);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @a7.e
        @h5.h(name = "-deprecated_decodeBase64")
        public final p a(@a7.d String string) {
            kotlin.jvm.internal.l0.p(string, "string");
            return h(string);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @h5.h(name = "-deprecated_decodeHex")
        public final p b(@a7.d String string) {
            kotlin.jvm.internal.l0.p(string, "string");
            return i(string);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @h5.h(name = "-deprecated_encodeString")
        public final p c(@a7.d String string, @a7.d Charset charset) {
            kotlin.jvm.internal.l0.p(string, "string");
            kotlin.jvm.internal.l0.p(charset, "charset");
            return j(string, charset);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @h5.h(name = "-deprecated_encodeUtf8")
        public final p d(@a7.d String string) {
            kotlin.jvm.internal.l0.p(string, "string");
            return l(string);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @h5.h(name = "-deprecated_of")
        public final p e(@a7.d ByteBuffer buffer) {
            kotlin.jvm.internal.l0.p(buffer, "buffer");
            return m(buffer);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @h5.h(name = "-deprecated_of")
        public final p f(@a7.d byte[] array, int i7, int i8) {
            kotlin.jvm.internal.l0.p(array, "array");
            return o(array, i7, i8);
        }

        @a7.d
        @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @h5.h(name = "-deprecated_read")
        public final p g(@a7.d InputStream inputstream, int i7) {
            kotlin.jvm.internal.l0.p(inputstream, "inputstream");
            return q(inputstream, i7);
        }

        @a7.e
        @h5.l
        public final p h(@a7.d String decodeBase64) {
            kotlin.jvm.internal.l0.p(decodeBase64, "$this$decodeBase64");
            byte[] bArrA = okio.a.a(decodeBase64);
            if (bArrA != null) {
                return new p(bArrA);
            }
            return null;
        }

        @a7.d
        @h5.l
        public final p i(@a7.d String decodeHex) {
            kotlin.jvm.internal.l0.p(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            int length = decodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = i7 * 2;
                bArr[i7] = (byte) ((v5.b.H(decodeHex.charAt(i8)) << 4) + v5.b.H(decodeHex.charAt(i8 + 1)));
            }
            return new p(bArr);
        }

        @a7.d
        @h5.h(name = "encodeString")
        @h5.l
        public final p j(@a7.d String encode, @a7.d Charset charset) {
            kotlin.jvm.internal.l0.p(encode, "$this$encode");
            kotlin.jvm.internal.l0.p(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            kotlin.jvm.internal.l0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new p(bytes);
        }

        @a7.d
        @h5.l
        public final p l(@a7.d String encodeUtf8) {
            kotlin.jvm.internal.l0.p(encodeUtf8, "$this$encodeUtf8");
            p pVar = new p(i.a(encodeUtf8));
            pVar.W(encodeUtf8);
            return pVar;
        }

        @a7.d
        @h5.h(name = "of")
        @h5.l
        public final p m(@a7.d ByteBuffer toByteString) {
            kotlin.jvm.internal.l0.p(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new p(bArr);
        }

        @a7.d
        @h5.l
        public final p n(@a7.d byte... data) {
            kotlin.jvm.internal.l0.p(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new p(bArrCopyOf);
        }

        @a7.d
        @h5.h(name = "of")
        @h5.l
        public final p o(@a7.d byte[] toByteString, int i7, int i8) {
            kotlin.jvm.internal.l0.p(toByteString, "$this$toByteString");
            j.e(toByteString.length, i7, i8);
            return new p(kotlin.collections.o.G1(toByteString, i7, i8 + i7));
        }

        @a7.d
        @h5.h(name = "read")
        @h5.l
        public final p q(@a7.d InputStream readByteString, int i7) throws IOException {
            kotlin.jvm.internal.l0.p(readByteString, "$this$readByteString");
            int i8 = 0;
            if (!(i7 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i7).toString());
            }
            byte[] bArr = new byte[i7];
            while (i8 < i7) {
                int i9 = readByteString.read(bArr, i8, i7 - i8);
                if (i9 == -1) {
                    throw new EOFException();
                }
                i8 += i9;
            }
            return new p(bArr);
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }
    }

    public p(@a7.d byte[] data) {
        kotlin.jvm.internal.l0.p(data, "data");
        this.f38511c = data;
    }

    public static /* synthetic */ int C(p pVar, p pVar2, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return pVar.z(pVar2, i7);
    }

    public static /* synthetic */ int D(p pVar, byte[] bArr, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return pVar.B(bArr, i7);
    }

    public static /* synthetic */ int L(p pVar, p pVar2, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = pVar.a0();
        }
        return pVar.I(pVar2, i7);
    }

    public static /* synthetic */ int M(p pVar, byte[] bArr, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i8 & 2) != 0) {
            i7 = pVar.a0();
        }
        return pVar.K(bArr, i7);
    }

    @a7.d
    @h5.h(name = "of")
    @h5.l
    public static final p O(@a7.d ByteBuffer byteBuffer) {
        return f38508f.m(byteBuffer);
    }

    @a7.d
    @h5.l
    public static final p P(@a7.d byte... bArr) {
        return f38508f.n(bArr);
    }

    @a7.d
    @h5.h(name = "of")
    @h5.l
    public static final p R(@a7.d byte[] bArr, int i7, int i8) {
        return f38508f.o(bArr, i7, i8);
    }

    @a7.d
    @h5.h(name = "read")
    @h5.l
    public static final p U(@a7.d InputStream inputStream, int i7) throws IOException {
        return f38508f.q(inputStream, i7);
    }

    @a7.e
    @h5.l
    public static final p g(@a7.d String str) {
        return f38508f.h(str);
    }

    @a7.d
    @h5.l
    public static final p h(@a7.d String str) {
        return f38508f.i(str);
    }

    public static /* synthetic */ p h0(p pVar, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = pVar.a0();
        }
        return pVar.g0(i7, i8);
    }

    @a7.d
    @h5.h(name = "encodeString")
    @h5.l
    public static final p j(@a7.d String str, @a7.d Charset charset) {
        return f38508f.j(str, charset);
    }

    @a7.d
    @h5.l
    public static final p k(@a7.d String str) {
        return f38508f.l(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        p pVarQ = f38508f.q(objectInputStream, objectInputStream.readInt());
        Field field = p.class.getDeclaredField("c");
        kotlin.jvm.internal.l0.o(field, "field");
        field.setAccessible(true);
        field.set(this, pVarQ.f38511c);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f38511c.length);
        objectOutputStream.write(this.f38511c);
    }

    @h5.i
    public final int A(@a7.d byte[] bArr) {
        return D(this, bArr, 0, 2, null);
    }

    @h5.i
    public int B(@a7.d byte[] other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        int length = o().length - other.length;
        int iMax = Math.max(i7, 0);
        if (iMax <= length) {
            while (!j.d(o(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @a7.d
    public byte[] E() {
        return o();
    }

    public byte F(int i7) {
        return o()[i7];
    }

    @h5.i
    public final int H(@a7.d p pVar) {
        return L(this, pVar, 0, 2, null);
    }

    @h5.i
    public final int I(@a7.d p other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        return K(other.E(), i7);
    }

    @h5.i
    public final int J(@a7.d byte[] bArr) {
        return M(this, bArr, 0, 2, null);
    }

    @h5.i
    public int K(@a7.d byte[] other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        for (int iMin = Math.min(i7, o().length - other.length); iMin >= 0; iMin--) {
            if (j.d(o(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    @a7.d
    public p N() {
        return i("MD5");
    }

    public boolean S(int i7, @a7.d p other, int i8, int i9) {
        kotlin.jvm.internal.l0.p(other, "other");
        return other.T(i8, o(), i7, i9);
    }

    public boolean T(int i7, @a7.d byte[] other, int i8, int i9) {
        kotlin.jvm.internal.l0.p(other, "other");
        return i7 >= 0 && i7 <= o().length - i9 && i8 >= 0 && i8 <= other.length - i9 && j.d(o(), i7, other, i8, i9);
    }

    public final void V(int i7) {
        this.f38509a = i7;
    }

    public final void W(@a7.e String str) {
        this.f38510b = str;
    }

    @a7.d
    public p X() {
        return i("SHA-1");
    }

    @a7.d
    public p Y() {
        return i("SHA-256");
    }

    @a7.d
    public p Z() {
        return i("SHA-512");
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to operator function", replaceWith = @b1(expression = "this[index]", imports = {}))
    @h5.h(name = "-deprecated_getByte")
    public final byte a(int i7) {
        return n(i7);
    }

    @h5.h(name = "size")
    public final int a0() {
        return q();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to val", replaceWith = @b1(expression = "size", imports = {}))
    @h5.h(name = "-deprecated_size")
    public final int b() {
        return a0();
    }

    public final boolean b0(@a7.d p prefix) {
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        return S(0, prefix, 0, prefix.a0());
    }

    @a7.d
    public ByteBuffer c() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.f38511c).asReadOnlyBuffer();
        kotlin.jvm.internal.l0.o(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public final boolean c0(@a7.d byte[] prefix) {
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        return T(0, prefix, 0, prefix.length);
    }

    @a7.d
    public String d() {
        return okio.a.c(o(), null, 1, null);
    }

    @a7.d
    public String d0(@a7.d Charset charset) {
        kotlin.jvm.internal.l0.p(charset, "charset");
        return new String(this.f38511c, charset);
    }

    @a7.d
    public String e() {
        return okio.a.b(o(), okio.a.e());
    }

    @a7.d
    @h5.i
    public final p e0() {
        return h0(this, 0, 0, 3, null);
    }

    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.a0() == o().length && pVar.T(0, o(), 0, o().length)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r0 < r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L13;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(@a7.d okio.p r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.l0.p(r10, r0)
            int r0 = r9.a0()
            int r1 = r10.a0()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.n(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.n(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = r5
            goto L33
        L32:
            r3 = r6
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.p.compareTo(okio.p):int");
    }

    @a7.d
    @h5.i
    public final p f0(int i7) {
        return h0(this, i7, 0, 2, null);
    }

    @a7.d
    @h5.i
    public p g0(int i7, int i8) {
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i8 <= o().length) {
            if (i8 - i7 >= 0) {
                return (i7 == 0 && i8 == o().length) ? this : new p(kotlin.collections.o.G1(o(), i7, i8));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + o().length + ')').toString());
    }

    public int hashCode() {
        int iP = p();
        if (iP != 0) {
            return iP;
        }
        int iHashCode = Arrays.hashCode(o());
        V(iHashCode);
        return iHashCode;
    }

    @a7.d
    public p i(@a7.d String algorithm) {
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(this.f38511c);
        kotlin.jvm.internal.l0.o(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new p(bArrDigest);
    }

    @a7.d
    public p i0() {
        byte b8;
        for (int i7 = 0; i7 < o().length; i7++) {
            byte b9 = o()[i7];
            byte b10 = (byte) 65;
            if (b9 >= b10 && b9 <= (b8 = (byte) 90)) {
                byte[] bArrO = o();
                byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
                kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b9 + 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b11 = bArrCopyOf[i8];
                    if (b11 >= b10 && b11 <= b8) {
                        bArrCopyOf[i8] = (byte) (b11 + 32);
                    }
                }
                return new p(bArrCopyOf);
            }
        }
        return this;
    }

    @a7.d
    public p j0() {
        byte b8;
        for (int i7 = 0; i7 < o().length; i7++) {
            byte b9 = o()[i7];
            byte b10 = (byte) 97;
            if (b9 >= b10 && b9 <= (b8 = (byte) 122)) {
                byte[] bArrO = o();
                byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
                kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i7] = (byte) (b9 - 32);
                for (int i8 = i7 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b11 = bArrCopyOf[i8];
                    if (b11 >= b10 && b11 <= b8) {
                        bArrCopyOf[i8] = (byte) (b11 - 32);
                    }
                }
                return new p(bArrCopyOf);
            }
        }
        return this;
    }

    @a7.d
    public byte[] k0() {
        byte[] bArrO = o();
        byte[] bArrCopyOf = Arrays.copyOf(bArrO, bArrO.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    public final boolean l(@a7.d p suffix) {
        kotlin.jvm.internal.l0.p(suffix, "suffix");
        return S(a0() - suffix.a0(), suffix, 0, suffix.a0());
    }

    @a7.d
    public String l0() {
        String strR = r();
        if (strR != null) {
            return strR;
        }
        String strC = i.c(E());
        W(strC);
        return strC;
    }

    public final boolean m(@a7.d byte[] suffix) {
        kotlin.jvm.internal.l0.p(suffix, "suffix");
        return T(a0() - suffix.length, suffix, 0, suffix.length);
    }

    public void m0(@a7.d OutputStream out) throws IOException {
        kotlin.jvm.internal.l0.p(out, "out");
        out.write(this.f38511c);
    }

    @h5.h(name = "getByte")
    public final byte n(int i7) {
        return F(i7);
    }

    public void n0(@a7.d m buffer, int i7, int i8) {
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        v5.b.G(this, buffer, i7, i8);
    }

    @a7.d
    public final byte[] o() {
        return this.f38511c;
    }

    public final int p() {
        return this.f38509a;
    }

    public int q() {
        return o().length;
    }

    @a7.e
    public final String r() {
        return this.f38510b;
    }

    @a7.d
    public String t() {
        char[] cArr = new char[o().length * 2];
        int i7 = 0;
        for (byte b8 : o()) {
            int i8 = i7 + 1;
            cArr[i7] = v5.b.I()[(b8 >> 4) & 15];
            i7 = i8 + 1;
            cArr[i8] = v5.b.I()[b8 & com.google.common.base.c.f19317q];
        }
        return new String(cArr);
    }

    @a7.d
    public String toString() {
        if (o().length == 0) {
            return "[size=0]";
        }
        int iC = v5.b.c(o(), 64);
        if (iC == -1) {
            if (o().length <= 64) {
                return "[hex=" + t() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(o().length);
            sb.append(" hex=");
            if (64 <= o().length) {
                sb.append((64 == o().length ? this : new p(kotlin.collections.o.G1(o(), 0, 64))).t());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + o().length + ')').toString());
        }
        String strL0 = l0();
        if (strL0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strL0.substring(0, iC);
        kotlin.jvm.internal.l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strK2 = kotlin.text.b0.k2(kotlin.text.b0.k2(kotlin.text.b0.k2(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (iC >= strL0.length()) {
            return "[text=" + strK2 + ']';
        }
        return "[size=" + o().length + " text=" + strK2 + "…]";
    }

    @a7.d
    public p u(@a7.d String algorithm, @a7.d p key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.l0.p(algorithm, "algorithm");
        kotlin.jvm.internal.l0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.k0(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.f38511c);
            kotlin.jvm.internal.l0.o(bArrDoFinal, "mac.doFinal(data)");
            return new p(bArrDoFinal);
        } catch (InvalidKeyException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @a7.d
    public p v(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return u("HmacSHA1", key);
    }

    @a7.d
    public p w(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return u("HmacSHA256", key);
    }

    @a7.d
    public p x(@a7.d p key) {
        kotlin.jvm.internal.l0.p(key, "key");
        return u("HmacSHA512", key);
    }

    @h5.i
    public final int y(@a7.d p pVar) {
        return C(this, pVar, 0, 2, null);
    }

    @h5.i
    public final int z(@a7.d p other, int i7) {
        kotlin.jvm.internal.l0.p(other, "other");
        return B(other.E(), i7);
    }
}
