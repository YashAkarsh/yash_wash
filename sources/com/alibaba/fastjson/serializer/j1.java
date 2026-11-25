package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class j1 extends Writer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ThreadLocal<char[]> f13085s = new ThreadLocal<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f13086t = new ThreadLocal<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f13087u = ((((((((k1.UseSingleQuotes.f13132a | 0) | k1.BrowserCompatible.f13132a) | k1.PrettyFormat.f13132a) | k1.WriteEnumUsingToString.f13132a) | k1.WriteNonStringValueAsString.f13132a) | k1.WriteSlashAsSpecial.f13132a) | k1.IgnoreErrorGetter.f13132a) | k1.WriteClassName.f13132a) | k1.NotWriteDefaultValue.f13132a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected char[] f13088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f13089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f13090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Writer f13091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f13092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f13093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f13094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f13095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f13096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f13097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f13098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f13099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f13100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f13101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected char f13102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f13103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f13104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected long f13105r;

    public j1() {
        this((Writer) null);
    }

    private void I0(char c8, String str, String str2) {
        if (this.f13092e) {
            i1(c8, str, str2);
        } else {
            w1(c8, str, str2);
        }
    }

    private void R1(String str) {
        byte[] bArr = com.alibaba.fastjson.util.f.f13323j;
        int length = str.length();
        boolean z7 = true;
        int i7 = this.f13089b + length + 1;
        int i8 = 0;
        if (i7 > this.f13088a.length) {
            if (this.f13091d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i9 = 0;
                while (true) {
                    if (i9 < length) {
                        char cCharAt = str.charAt(i9);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i9++;
                        }
                    } else {
                        z7 = false;
                        break;
                    }
                }
                if (z7) {
                    write(39);
                }
                while (i8 < length) {
                    char cCharAt2 = str.charAt(i8);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f13326m[cCharAt2]);
                    }
                    i8++;
                }
                if (z7) {
                    write(39);
                }
                write(58);
                return;
            }
            v(i7);
        }
        if (length == 0) {
            int i10 = this.f13089b;
            if (i10 + 3 > this.f13088a.length) {
                v(i10 + 3);
            }
            char[] cArr = this.f13088a;
            int i11 = this.f13089b;
            int i12 = i11 + 1;
            cArr[i11] = '\'';
            int i13 = i12 + 1;
            cArr[i12] = '\'';
            this.f13089b = i13 + 1;
            cArr[i13] = ':';
            return;
        }
        int i14 = this.f13089b;
        int i15 = i14 + length;
        str.getChars(0, length, this.f13088a, i14);
        this.f13089b = i7;
        int i16 = i14;
        boolean z8 = false;
        while (i16 < i15) {
            char[] cArr2 = this.f13088a;
            char c8 = cArr2[i16];
            if (c8 < bArr.length && bArr[c8] != 0) {
                if (z8) {
                    i7++;
                    if (i7 > cArr2.length) {
                        v(i7);
                    }
                    this.f13089b = i7;
                    char[] cArr3 = this.f13088a;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr3, i17, cArr3, i16 + 2, i15 - i16);
                    char[] cArr4 = this.f13088a;
                    cArr4[i16] = '\\';
                    cArr4[i17] = com.alibaba.fastjson.util.f.f13326m[c8];
                    i15++;
                    i16 = i17;
                } else {
                    i7 += 3;
                    if (i7 > cArr2.length) {
                        v(i7);
                    }
                    this.f13089b = i7;
                    char[] cArr5 = this.f13088a;
                    int i18 = i16 + 1;
                    System.arraycopy(cArr5, i18, cArr5, i16 + 3, (i15 - i16) - 1);
                    char[] cArr6 = this.f13088a;
                    System.arraycopy(cArr6, i8, cArr6, 1, i16);
                    char[] cArr7 = this.f13088a;
                    cArr7[i14] = '\'';
                    cArr7[i18] = '\\';
                    int i19 = i18 + 1;
                    cArr7[i19] = com.alibaba.fastjson.util.f.f13326m[c8];
                    i15 += 2;
                    cArr7[this.f13089b - 2] = '\'';
                    i16 = i19;
                    z8 = true;
                }
            }
            i16++;
            i8 = 0;
        }
        this.f13088a[i7 - 1] = ':';
    }

    private int s(OutputStream outputStream) throws IOException {
        int i7 = (int) (((double) this.f13089b) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f13086t;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i7) {
            bArr = new byte[i7];
        }
        int iG = com.alibaba.fastjson.util.f.g(this.f13088a, 0, this.f13089b, bArr);
        outputStream.write(bArr, 0, iG);
        return iG;
    }

    private byte[] u() {
        int i7 = (int) (((double) this.f13089b) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f13086t;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i7) {
            bArr = new byte[i7];
        }
        int iG = com.alibaba.fastjson.util.f.g(this.f13088a, 0, this.f13089b, bArr);
        byte[] bArr2 = new byte[iG];
        System.arraycopy(bArr, 0, bArr2, 0, iG);
        return bArr2;
    }

    public void A1(float f8, boolean z7) {
        if (Float.isNaN(f8) || Float.isInfinite(f8)) {
            X1();
            return;
        }
        String string = Float.toString(f8);
        if (G(k1.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        if (z7 && G(k1.WriteClassName)) {
            write(70);
        }
    }

    public void B1(byte[] bArr) {
        int i7 = 2;
        int length = this.f13089b + (bArr.length * 2) + 3;
        int i8 = 0;
        if (length > this.f13088a.length) {
            if (this.f13091d != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i8 < bArr.length) {
                    int i9 = bArr[i8] & 255;
                    int i10 = i9 >> 4;
                    int i11 = i9 & 15;
                    int i12 = i7 + 1;
                    cArr[i7] = (char) (i10 + (i10 < 10 ? 48 : 55));
                    i7 = i12 + 1;
                    cArr[i12] = (char) (i11 + (i11 < 10 ? 48 : 55));
                    i8++;
                }
                cArr[i7] = '\'';
                try {
                    this.f13091d.write(cArr);
                    return;
                } catch (IOException e8) {
                    throw new com.alibaba.fastjson.d("writeBytes error.", e8);
                }
            }
            v(length);
        }
        char[] cArr2 = this.f13088a;
        int i13 = this.f13089b;
        int i14 = i13 + 1;
        cArr2[i13] = 'x';
        this.f13089b = i14 + 1;
        cArr2[i14] = '\'';
        while (i8 < bArr.length) {
            int i15 = bArr[i8] & 255;
            int i16 = i15 >> 4;
            int i17 = i15 & 15;
            char[] cArr3 = this.f13088a;
            int i18 = this.f13089b;
            int i19 = i18 + 1;
            this.f13089b = i19;
            cArr3[i18] = (char) (i16 + (i16 < 10 ? 48 : 55));
            this.f13089b = i19 + 1;
            cArr3[i19] = (char) (i17 + (i17 < 10 ? 48 : 55));
            i8++;
        }
        char[] cArr4 = this.f13088a;
        int i20 = this.f13089b;
        this.f13089b = i20 + 1;
        cArr4[i20] = '\'';
    }

    public int C() {
        return this.f13088a.length;
    }

    public int E() {
        return this.f13103p;
    }

    public boolean F(int i7) {
        return (i7 & this.f13090c) != 0;
    }

    public boolean G(k1 k1Var) {
        return (k1Var.f13132a & this.f13090c) != 0;
    }

    public void G0(Enum<?> r7) {
        String string;
        if (r7 == null) {
            X1();
            return;
        }
        if (!this.f13099l || this.f13100m) {
            string = this.f13100m ? r7.toString() : null;
        } else {
            string = r7.name();
        }
        if (string == null) {
            N1(r7.ordinal());
            return;
        }
        int i7 = G(k1.UseSingleQuotes) ? 39 : 34;
        write(i7);
        write(string);
        write(i7);
    }

    public boolean H() {
        return this.f13098k;
    }

    public void J0(String str) {
        L0(str, false);
    }

    public boolean K() {
        return this.f13094g;
    }

    public void L0(String str, boolean z7) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f13092e) {
            if (!this.f13093f) {
                R1(str);
                return;
            } else {
                f2(str);
                write(58);
                return;
            }
        }
        if (this.f13093f) {
            d2(str, ':');
            return;
        }
        boolean z8 = true;
        boolean z9 = str.length() == 0;
        int i7 = 0;
        while (true) {
            if (i7 >= str.length()) {
                z8 = z9;
                break;
            }
            char cCharAt = str.charAt(i7);
            if ((cCharAt < '@' && (this.f13105r & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                break;
            } else {
                i7++;
            }
        }
        if (z8) {
            d2(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    public void N1(int i7) {
        if (i7 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iQ = i7 < 0 ? com.alibaba.fastjson.util.f.q(-i7) + 1 : com.alibaba.fastjson.util.f.q(i7);
        int i8 = this.f13089b + iQ;
        if (i8 > this.f13088a.length) {
            if (this.f13091d != null) {
                char[] cArr = new char[iQ];
                com.alibaba.fastjson.util.f.j(i7, iQ, cArr);
                write(cArr, 0, iQ);
                return;
            }
            v(i8);
        }
        com.alibaba.fastjson.util.f.j(i7, i8, this.f13088a);
        this.f13089b = i8;
    }

    public void Q(int i7) {
        if (i7 >= this.f13088a.length) {
            this.f13103p = i7;
            return;
        }
        throw new com.alibaba.fastjson.d("must > " + this.f13088a.length);
    }

    public void Q0(String str) {
        int length = str.length();
        int i7 = this.f13089b + length + 3;
        if (i7 > this.f13088a.length) {
            v(i7);
        }
        int i8 = this.f13089b;
        char[] cArr = this.f13088a;
        cArr[i8] = kotlin.text.h0.f35376b;
        str.getChars(0, length, cArr, i8 + 1);
        this.f13089b = i7;
        char[] cArr2 = this.f13088a;
        cArr2[i7 - 2] = kotlin.text.h0.f35376b;
        cArr2[i7 - 1] = ':';
    }

    public void T0(char c8, String str, char c9) {
        write(c8);
        J0(str);
        if (c9 == 0) {
            a2("\u0000");
        } else {
            a2(Character.toString(c9));
        }
    }

    public void V0(char c8, String str, double d8) {
        write(c8);
        J0(str);
        x0(d8, false);
    }

    public void W1(long j7) {
        boolean z7 = G(k1.BrowserCompatible) && !G(k1.WriteClassName) && (j7 > 9007199254740991L || j7 < -9007199254740991L);
        if (j7 == Long.MIN_VALUE) {
            if (z7) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iR = j7 < 0 ? com.alibaba.fastjson.util.f.r(-j7) + 1 : com.alibaba.fastjson.util.f.r(j7);
        int i7 = this.f13089b + iR;
        if (z7) {
            i7 += 2;
        }
        if (i7 > this.f13088a.length) {
            if (this.f13091d != null) {
                char[] cArr = new char[iR];
                com.alibaba.fastjson.util.f.k(j7, iR, cArr);
                if (!z7) {
                    write(cArr, 0, iR);
                    return;
                }
                write(34);
                write(cArr, 0, iR);
                write(34);
                return;
            }
            v(i7);
        }
        if (z7) {
            char[] cArr2 = this.f13088a;
            cArr2[this.f13089b] = kotlin.text.h0.f35376b;
            int i8 = i7 - 1;
            com.alibaba.fastjson.util.f.k(j7, i8, cArr2);
            this.f13088a[i8] = kotlin.text.h0.f35376b;
        } else {
            com.alibaba.fastjson.util.f.k(j7, i7, this.f13088a);
        }
        this.f13089b = i7;
    }

    public void X1() {
        write("null");
    }

    public void Y0(char c8, String str, float f8) {
        write(c8);
        J0(str);
        A1(f8, false);
    }

    public void Y1(int i7, int i8) {
        if ((i7 & i8) == 0 && (this.f13090c & i8) == 0) {
            X1();
            return;
        }
        if (i8 == k1.WriteNullListAsEmpty.f13132a) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        if (i8 == k1.WriteNullStringAsEmpty.f13132a) {
            a2("");
            return;
        }
        if (i8 == k1.WriteNullBooleanAsFalse.f13132a) {
            write(com.paytm.pgsdk.d.G);
        } else if (i8 == k1.WriteNullNumberAsZero.f13132a) {
            write(48);
        } else {
            X1();
        }
    }

    public void Z1(k1 k1Var) {
        Y1(0, k1Var.f13132a);
    }

    public void a1(char c8, String str, int i7) {
        if (i7 == Integer.MIN_VALUE || !this.f13093f) {
            write(c8);
            J0(str);
            N1(i7);
            return;
        }
        int iQ = i7 < 0 ? com.alibaba.fastjson.util.f.q(-i7) + 1 : com.alibaba.fastjson.util.f.q(i7);
        int length = str.length();
        int i8 = this.f13089b + length + 4 + iQ;
        if (i8 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                J0(str);
                N1(i7);
                return;
            }
            v(i8);
        }
        int i9 = this.f13089b;
        this.f13089b = i8;
        char[] cArr = this.f13088a;
        cArr[i9] = c8;
        int i10 = i9 + length + 1;
        cArr[i9 + 1] = this.f13102o;
        str.getChars(0, length, cArr, i9 + 2);
        char[] cArr2 = this.f13088a;
        cArr2[i10 + 1] = this.f13102o;
        cArr2[i10 + 2] = ':';
        com.alibaba.fastjson.util.f.j(i7, this.f13089b, cArr2);
    }

    public void a2(String str) {
        if (this.f13092e) {
            f2(str);
        } else {
            d2(str, (char) 0);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 append(char c8) {
        write(c8);
        return this;
    }

    public void b2(String str, char c8) {
        if (!this.f13092e) {
            d2(str, c8);
        } else {
            f2(str);
            write(c8);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    public void c2(char[] cArr) {
        if (this.f13092e) {
            g2(cArr);
        } else {
            d2(new String(cArr), (char) 0);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f13091d != null && this.f13089b > 0) {
            flush();
        }
        char[] cArr = this.f13088a;
        if (cArr.length <= 131072) {
            f13085s.set(cArr);
        }
        this.f13088a = null;
    }

    public void d1(char c8, String str, long j7) {
        if (j7 == Long.MIN_VALUE || !this.f13093f) {
            write(c8);
            J0(str);
            W1(j7);
            return;
        }
        int iR = j7 < 0 ? com.alibaba.fastjson.util.f.r(-j7) + 1 : com.alibaba.fastjson.util.f.r(j7);
        int length = str.length();
        int i7 = this.f13089b + length + 4 + iR;
        if (i7 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                J0(str);
                W1(j7);
                return;
            }
            v(i7);
        }
        int i8 = this.f13089b;
        this.f13089b = i7;
        char[] cArr = this.f13088a;
        cArr[i8] = c8;
        int i9 = i8 + length + 1;
        cArr[i8 + 1] = this.f13102o;
        str.getChars(0, length, cArr, i8 + 2);
        char[] cArr2 = this.f13088a;
        cArr2[i9 + 1] = this.f13102o;
        cArr2[i9 + 2] = ':';
        com.alibaba.fastjson.util.f.k(j7, this.f13089b, cArr2);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f  */
    public void d2(String str, char c8) {
        if (str == null) {
            X1();
            if (c8 != 0) {
                write(c8);
                return;
            }
            return;
        }
        int length = str.length();
        int i7 = this.f13089b + length + 2;
        if (c8 != 0) {
            i7++;
        }
        int length2 = this.f13088a.length;
        char c9 = kotlin.text.h0.f35380f;
        if (i7 > length2) {
            if (this.f13091d != null) {
                write(34);
                int i8 = 0;
                while (i8 < str.length()) {
                    char cCharAt = str.charAt(i8);
                    if (G(k1.BrowserSecure) && (cCharAt == '(' || cCharAt == ')' || cCharAt == '<' || cCharAt == c9)) {
                        write(92);
                        write(117);
                        char[] cArr = com.alibaba.fastjson.util.f.f13319f;
                        write(cArr[(cCharAt >>> '\f') & 15]);
                        write(cArr[(cCharAt >>> '\b') & 15]);
                        write(cArr[(cCharAt >>> 4) & 15]);
                        write(cArr[cCharAt & 15]);
                    } else if (!G(k1.BrowserCompatible)) {
                        byte[] bArr = com.alibaba.fastjson.util.f.f13322i;
                        if ((cCharAt >= bArr.length || bArr[cCharAt] == 0) && !(cCharAt == '/' && G(k1.WriteSlashAsSpecial))) {
                            write(cCharAt);
                        } else {
                            write(92);
                            if (bArr[cCharAt] == 4) {
                                write(117);
                                char[] cArr2 = com.alibaba.fastjson.util.f.f13319f;
                                write(cArr2[(cCharAt >>> '\f') & 15]);
                                write(cArr2[(cCharAt >>> '\b') & 15]);
                                write(cArr2[(cCharAt >>> 4) & 15]);
                                write(cArr2[cCharAt & 15]);
                            } else {
                                write(com.alibaba.fastjson.util.f.f13326m[cCharAt]);
                            }
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f13326m[cCharAt]);
                    } else if (cCharAt < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr3 = com.alibaba.fastjson.util.f.f13327n;
                        int i9 = cCharAt * 2;
                        write(cArr3[i9]);
                        write(cArr3[i9 + 1]);
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr4 = com.alibaba.fastjson.util.f.f13319f;
                        write(cArr4[(cCharAt >>> '\f') & 15]);
                        write(cArr4[(cCharAt >>> '\b') & 15]);
                        write(cArr4[(cCharAt >>> 4) & 15]);
                        write(cArr4[cCharAt & 15]);
                    } else {
                        write(cCharAt);
                    }
                    i8++;
                    c9 = kotlin.text.h0.f35380f;
                }
                write(34);
                if (c8 != 0) {
                    write(c8);
                    return;
                }
                return;
            }
            v(i7);
        }
        int i10 = this.f13089b;
        int i11 = i10 + 1;
        int i12 = i11 + length;
        char[] cArr5 = this.f13088a;
        cArr5[i10] = kotlin.text.h0.f35376b;
        str.getChars(0, length, cArr5, i11);
        this.f13089b = i7;
        int i13 = -1;
        if (G(k1.BrowserCompatible)) {
            for (int i14 = i11; i14 < i12; i14++) {
                char c10 = this.f13088a[i14];
                if (c10 == '\"' || c10 == '/' || c10 == '\\' || c10 == '\b' || c10 == '\f' || c10 == '\n' || c10 == '\r' || c10 == '\t') {
                    i7++;
                } else {
                    if (c10 < ' ' || c10 >= 127) {
                        i7 += 5;
                    }
                }
                i13 = i14;
            }
            if (i7 > this.f13088a.length) {
                v(i7);
            }
            this.f13089b = i7;
            while (i13 >= i11) {
                char[] cArr6 = this.f13088a;
                char c11 = cArr6[i13];
                if (c11 == '\b' || c11 == '\f' || c11 == '\n' || c11 == '\r' || c11 == '\t') {
                    int i15 = i13 + 1;
                    System.arraycopy(cArr6, i15, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.f13088a;
                    cArr7[i13] = '\\';
                    cArr7[i15] = com.alibaba.fastjson.util.f.f13326m[c11];
                } else {
                    if (c11 == '\"' || c11 == '/' || c11 == '\\') {
                        int i16 = i13 + 1;
                        System.arraycopy(cArr6, i16, cArr6, i13 + 2, (i12 - i13) - 1);
                        char[] cArr8 = this.f13088a;
                        cArr8[i13] = '\\';
                        cArr8[i16] = c11;
                    } else {
                        if (c11 < ' ') {
                            int i17 = i13 + 1;
                            System.arraycopy(cArr6, i17, cArr6, i13 + 6, (i12 - i13) - 1);
                            char[] cArr9 = this.f13088a;
                            cArr9[i13] = '\\';
                            cArr9[i17] = 'u';
                            cArr9[i13 + 2] = '0';
                            cArr9[i13 + 3] = '0';
                            char[] cArr10 = com.alibaba.fastjson.util.f.f13327n;
                            int i18 = c11 * 2;
                            cArr9[i13 + 4] = cArr10[i18];
                            cArr9[i13 + 5] = cArr10[i18 + 1];
                        } else if (c11 >= 127) {
                            int i19 = i13 + 1;
                            System.arraycopy(cArr6, i19, cArr6, i13 + 6, (i12 - i13) - 1);
                            char[] cArr11 = this.f13088a;
                            cArr11[i13] = '\\';
                            cArr11[i19] = 'u';
                            char[] cArr12 = com.alibaba.fastjson.util.f.f13319f;
                            cArr11[i13 + 2] = cArr12[(c11 >>> '\f') & 15];
                            cArr11[i13 + 3] = cArr12[(c11 >>> '\b') & 15];
                            cArr11[i13 + 4] = cArr12[(c11 >>> 4) & 15];
                            cArr11[i13 + 5] = cArr12[c11 & 15];
                        }
                        i12 += 5;
                    }
                    i13--;
                }
                i12++;
                i13--;
            }
            if (c8 == 0) {
                this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
                return;
            }
            char[] cArr13 = this.f13088a;
            int i20 = this.f13089b;
            cArr13[i20 - 2] = kotlin.text.h0.f35376b;
            cArr13[i20 - 1] = c8;
            return;
        }
        int i21 = 0;
        char c12 = 0;
        int i22 = -1;
        int i23 = -1;
        for (int i24 = i11; i24 < i12; i24++) {
            char c13 = this.f13088a[i24];
            if (c13 < ']') {
                if ((c13 < '@' && (this.f13105r & (1 << c13)) != 0) || c13 == '\\') {
                    i21++;
                    if (c13 == '(' || c13 == ')' || c13 == '<' || c13 == '>') {
                        i7 += 4;
                    } else {
                        byte[] bArr2 = com.alibaba.fastjson.util.f.f13322i;
                        if (c13 < bArr2.length && bArr2[c13] == 4) {
                            i7 += 4;
                        }
                    }
                    i13 = -1;
                    if (i22 == -1) {
                        i22 = i24;
                        i23 = i22;
                    } else {
                        i23 = i24;
                    }
                    c12 = c13;
                } else {
                    i13 = -1;
                }
            } else if (c13 >= 127 && (c13 == 8232 || c13 == 8233 || c13 < 160)) {
                if (i22 == i13) {
                    i22 = i24;
                }
                i21++;
                i7 += 4;
                i23 = i24;
                c12 = c13;
            }
        }
        if (i21 > 0) {
            int i25 = i7 + i21;
            if (i25 > this.f13088a.length) {
                v(i25);
            }
            this.f13089b = i25;
            if (i21 == 1) {
                if (c12 == 8232) {
                    int i26 = i23 + 1;
                    char[] cArr14 = this.f13088a;
                    System.arraycopy(cArr14, i26, cArr14, i23 + 6, (i12 - i23) - 1);
                    char[] cArr15 = this.f13088a;
                    cArr15[i23] = '\\';
                    cArr15[i26] = 'u';
                    int i27 = i26 + 1;
                    cArr15[i27] = '2';
                    int i28 = i27 + 1;
                    cArr15[i28] = '0';
                    int i29 = i28 + 1;
                    cArr15[i29] = '2';
                    cArr15[i29 + 1] = '8';
                } else if (c12 == 8233) {
                    int i30 = i23 + 1;
                    char[] cArr16 = this.f13088a;
                    System.arraycopy(cArr16, i30, cArr16, i23 + 6, (i12 - i23) - 1);
                    char[] cArr17 = this.f13088a;
                    cArr17[i23] = '\\';
                    cArr17[i30] = 'u';
                    int i31 = i30 + 1;
                    cArr17[i31] = '2';
                    int i32 = i31 + 1;
                    cArr17[i32] = '0';
                    int i33 = i32 + 1;
                    cArr17[i33] = '2';
                    cArr17[i33 + 1] = '9';
                } else if (c12 == '(' || c12 == ')' || c12 == '<' || c12 == '>') {
                    int i34 = i23 + 1;
                    char[] cArr18 = this.f13088a;
                    System.arraycopy(cArr18, i34, cArr18, i23 + 6, (i12 - i23) - 1);
                    char[] cArr19 = this.f13088a;
                    cArr19[i23] = '\\';
                    cArr19[i34] = 'u';
                    int i35 = i34 + 1;
                    char[] cArr20 = com.alibaba.fastjson.util.f.f13319f;
                    cArr19[i35] = cArr20[(c12 >>> '\f') & 15];
                    int i36 = i35 + 1;
                    cArr19[i36] = cArr20[(c12 >>> '\b') & 15];
                    int i37 = i36 + 1;
                    cArr19[i37] = cArr20[(c12 >>> 4) & 15];
                    cArr19[i37 + 1] = cArr20[c12 & 15];
                } else {
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f13322i;
                    if (c12 >= bArr3.length || bArr3[c12] != 4) {
                        int i38 = i23 + 1;
                        char[] cArr21 = this.f13088a;
                        System.arraycopy(cArr21, i38, cArr21, i23 + 2, (i12 - i23) - 1);
                        char[] cArr22 = this.f13088a;
                        cArr22[i23] = '\\';
                        cArr22[i38] = com.alibaba.fastjson.util.f.f13326m[c12];
                    } else {
                        int i39 = i23 + 1;
                        char[] cArr23 = this.f13088a;
                        System.arraycopy(cArr23, i39, cArr23, i23 + 6, (i12 - i23) - 1);
                        char[] cArr24 = this.f13088a;
                        cArr24[i23] = '\\';
                        int i40 = i39 + 1;
                        cArr24[i39] = 'u';
                        int i41 = i40 + 1;
                        char[] cArr25 = com.alibaba.fastjson.util.f.f13319f;
                        cArr24[i40] = cArr25[(c12 >>> '\f') & 15];
                        int i42 = i41 + 1;
                        cArr24[i41] = cArr25[(c12 >>> '\b') & 15];
                        cArr24[i42] = cArr25[(c12 >>> 4) & 15];
                        cArr24[i42 + 1] = cArr25[c12 & 15];
                    }
                }
            } else if (i21 > 1) {
                for (int i43 = i22 - i11; i43 < str.length(); i43++) {
                    char cCharAt2 = str.charAt(i43);
                    if (this.f13104q) {
                        if (cCharAt2 != '(' && cCharAt2 != ')') {
                            if (cCharAt2 == '<' || cCharAt2 == '>') {
                            }
                        }
                        char[] cArr26 = this.f13088a;
                        int i44 = i22 + 1;
                        cArr26[i22] = '\\';
                        int i45 = i44 + 1;
                        cArr26[i44] = 'u';
                        int i46 = i45 + 1;
                        char[] cArr27 = com.alibaba.fastjson.util.f.f13319f;
                        cArr26[i45] = cArr27[(cCharAt2 >>> '\f') & 15];
                        int i47 = i46 + 1;
                        cArr26[i46] = cArr27[(cCharAt2 >>> '\b') & 15];
                        int i48 = i47 + 1;
                        cArr26[i47] = cArr27[(cCharAt2 >>> 4) & 15];
                        i22 = i48 + 1;
                        cArr26[i48] = cArr27[cCharAt2 & 15];
                    }
                    byte[] bArr4 = com.alibaba.fastjson.util.f.f13322i;
                    if ((cCharAt2 >= bArr4.length || bArr4[cCharAt2] == 0) && !(cCharAt2 == '/' && G(k1.WriteSlashAsSpecial))) {
                        if (cCharAt2 == 8232 || cCharAt2 == 8233) {
                            char[] cArr28 = this.f13088a;
                            int i49 = i22 + 1;
                            cArr28[i22] = '\\';
                            int i50 = i49 + 1;
                            cArr28[i49] = 'u';
                            int i51 = i50 + 1;
                            char[] cArr29 = com.alibaba.fastjson.util.f.f13319f;
                            cArr28[i50] = cArr29[(cCharAt2 >>> '\f') & 15];
                            int i52 = i51 + 1;
                            cArr28[i51] = cArr29[(cCharAt2 >>> '\b') & 15];
                            int i53 = i52 + 1;
                            cArr28[i52] = cArr29[(cCharAt2 >>> 4) & 15];
                            i22 = i53 + 1;
                            cArr28[i53] = cArr29[cCharAt2 & 15];
                        } else {
                            this.f13088a[i22] = cCharAt2;
                            i22++;
                        }
                    } else {
                        char[] cArr30 = this.f13088a;
                        int i54 = i22 + 1;
                        cArr30[i22] = '\\';
                        if (bArr4[cCharAt2] == 4) {
                            int i55 = i54 + 1;
                            cArr30[i54] = 'u';
                            int i56 = i55 + 1;
                            char[] cArr31 = com.alibaba.fastjson.util.f.f13319f;
                            cArr30[i55] = cArr31[(cCharAt2 >>> '\f') & 15];
                            int i57 = i56 + 1;
                            cArr30[i56] = cArr31[(cCharAt2 >>> '\b') & 15];
                            int i58 = i57 + 1;
                            cArr30[i57] = cArr31[(cCharAt2 >>> 4) & 15];
                            i22 = i58 + 1;
                            cArr30[i58] = cArr31[cCharAt2 & 15];
                        } else {
                            i22 = i54 + 1;
                            cArr30[i54] = com.alibaba.fastjson.util.f.f13326m[cCharAt2];
                        }
                    }
                }
            }
        }
        if (c8 == 0) {
            this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
            return;
        }
        char[] cArr32 = this.f13088a;
        int i59 = this.f13089b;
        cArr32[i59 - 2] = kotlin.text.h0.f35376b;
        cArr32[i59 - 1] = c8;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence, int i7, int i8) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i7, i8).toString();
        write(string, 0, string.length());
        return this;
    }

    public void e1(char c8, String str, Enum<?> r7) {
        if (r7 == null) {
            write(c8);
            J0(str);
            X1();
        } else if (this.f13099l && !this.f13100m) {
            I0(c8, str, r7.name());
        } else if (this.f13100m) {
            I0(c8, str, r7.toString());
        } else {
            a1(c8, str, r7.ordinal());
        }
    }

    /* JADX WARN: Code duplicated, block: B:165:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x0147  */
    public void e2(char[] cArr, char c8) {
        int i7;
        int i8;
        if (cArr == null) {
            X1();
            if (c8 != 0) {
                write(c8);
                return;
            }
            return;
        }
        int length = cArr.length;
        int i9 = this.f13089b + length + 2;
        if (c8 != 0) {
            i9++;
        }
        int length2 = this.f13088a.length;
        char c9 = kotlin.text.h0.f35380f;
        if (i9 > length2) {
            if (this.f13091d != null) {
                write(34);
                int i10 = 0;
                while (i10 < cArr.length) {
                    char c10 = cArr[i10];
                    if (G(k1.BrowserSecure) && (c10 == '(' || c10 == ')' || c10 == '<' || c10 == c9)) {
                        write(92);
                        write(117);
                        char[] cArr2 = com.alibaba.fastjson.util.f.f13319f;
                        write(cArr2[(c10 >>> '\f') & 15]);
                        write(cArr2[(c10 >>> '\b') & 15]);
                        write(cArr2[(c10 >>> 4) & 15]);
                        write(cArr2[c10 & 15]);
                    } else if (!G(k1.BrowserCompatible)) {
                        byte[] bArr = com.alibaba.fastjson.util.f.f13322i;
                        if ((c10 >= bArr.length || bArr[c10] == 0) && !(c10 == '/' && G(k1.WriteSlashAsSpecial))) {
                            write(c10);
                        } else {
                            write(92);
                            if (bArr[c10] == 4) {
                                write(117);
                                char[] cArr3 = com.alibaba.fastjson.util.f.f13319f;
                                write(cArr3[(c10 >>> '\f') & 15]);
                                write(cArr3[(c10 >>> '\b') & 15]);
                                write(cArr3[(c10 >>> 4) & 15]);
                                write(cArr3[c10 & 15]);
                            } else {
                                write(com.alibaba.fastjson.util.f.f13326m[c10]);
                            }
                        }
                    } else if (c10 == '\b' || c10 == '\f' || c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == '\"' || c10 == '/' || c10 == '\\') {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f13326m[c10]);
                    } else if (c10 < ' ') {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr4 = com.alibaba.fastjson.util.f.f13327n;
                        int i11 = c10 * 2;
                        write(cArr4[i11]);
                        write(cArr4[i11 + 1]);
                    } else if (c10 >= 127) {
                        write(92);
                        write(117);
                        char[] cArr5 = com.alibaba.fastjson.util.f.f13319f;
                        write(cArr5[(c10 >>> '\f') & 15]);
                        write(cArr5[(c10 >>> '\b') & 15]);
                        write(cArr5[(c10 >>> 4) & 15]);
                        write(cArr5[c10 & 15]);
                    } else {
                        write(c10);
                    }
                    i10++;
                    c9 = kotlin.text.h0.f35380f;
                }
                write(34);
                if (c8 != 0) {
                    write(c8);
                    return;
                }
                return;
            }
            v(i9);
        }
        int i12 = this.f13089b;
        int i13 = i12 + 1;
        int i14 = length + i13;
        char[] cArr6 = this.f13088a;
        cArr6[i12] = kotlin.text.h0.f35376b;
        System.arraycopy(cArr, 0, cArr6, i13, cArr.length);
        this.f13089b = i9;
        int i15 = -1;
        if (G(k1.BrowserCompatible)) {
            for (int i16 = i13; i16 < i14; i16++) {
                char c11 = this.f13088a[i16];
                if (c11 == '\"' || c11 == '/' || c11 == '\\' || c11 == '\b' || c11 == '\f' || c11 == '\n' || c11 == '\r' || c11 == '\t') {
                    i9++;
                } else {
                    if (c11 < ' ' || c11 >= 127) {
                        i9 += 5;
                    }
                }
                i15 = i16;
            }
            if (i9 > this.f13088a.length) {
                v(i9);
            }
            this.f13089b = i9;
            while (i15 >= i13) {
                char[] cArr7 = this.f13088a;
                char c12 = cArr7[i15];
                if (c12 == '\b' || c12 == '\f' || c12 == '\n' || c12 == '\r' || c12 == '\t') {
                    int i17 = i15 + 1;
                    System.arraycopy(cArr7, i17, cArr7, i15 + 2, (i14 - i15) - 1);
                    char[] cArr8 = this.f13088a;
                    cArr8[i15] = '\\';
                    cArr8[i17] = com.alibaba.fastjson.util.f.f13326m[c12];
                } else {
                    if (c12 == '\"' || c12 == '/' || c12 == '\\') {
                        int i18 = i15 + 1;
                        System.arraycopy(cArr7, i18, cArr7, i15 + 2, (i14 - i15) - 1);
                        char[] cArr9 = this.f13088a;
                        cArr9[i15] = '\\';
                        cArr9[i18] = c12;
                    } else {
                        if (c12 < ' ') {
                            int i19 = i15 + 1;
                            System.arraycopy(cArr7, i19, cArr7, i15 + 6, (i14 - i15) - 1);
                            char[] cArr10 = this.f13088a;
                            cArr10[i15] = '\\';
                            cArr10[i19] = 'u';
                            cArr10[i15 + 2] = '0';
                            cArr10[i15 + 3] = '0';
                            char[] cArr11 = com.alibaba.fastjson.util.f.f13327n;
                            int i20 = c12 * 2;
                            cArr10[i15 + 4] = cArr11[i20];
                            cArr10[i15 + 5] = cArr11[i20 + 1];
                        } else if (c12 >= 127) {
                            int i21 = i15 + 1;
                            System.arraycopy(cArr7, i21, cArr7, i15 + 6, (i14 - i15) - 1);
                            char[] cArr12 = this.f13088a;
                            cArr12[i15] = '\\';
                            cArr12[i21] = 'u';
                            char[] cArr13 = com.alibaba.fastjson.util.f.f13319f;
                            cArr12[i15 + 2] = cArr13[(c12 >>> '\f') & 15];
                            cArr12[i15 + 3] = cArr13[(c12 >>> '\b') & 15];
                            cArr12[i15 + 4] = cArr13[(c12 >>> 4) & 15];
                            cArr12[i15 + 5] = cArr13[c12 & 15];
                        }
                        i14 += 5;
                    }
                    i15--;
                }
                i14++;
                i15--;
            }
            if (c8 == 0) {
                this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
                return;
            }
            char[] cArr14 = this.f13088a;
            int i22 = this.f13089b;
            cArr14[i22 - 2] = kotlin.text.h0.f35376b;
            cArr14[i22 - 1] = c8;
            return;
        }
        int i23 = i13;
        int i24 = -1;
        int i25 = 0;
        char c13 = 0;
        int i26 = -1;
        while (i23 < i14) {
            char c14 = this.f13088a[i23];
            if (c14 >= ']') {
                if (c14 >= 127 && (c14 == 8232 || c14 == 8233 || c14 < 160)) {
                    if (i26 == i15) {
                        i26 = i23;
                    }
                    i25++;
                    i9 += 4;
                    i24 = i23;
                    c13 = c14;
                }
                int i27 = i26;
                i8 = i15;
                i7 = i27;
            } else {
                int i28 = i26;
                if ((c14 < '@' && (this.f13105r & (1 << c14)) != 0) || c14 == '\\') {
                    i25++;
                    if (c14 == '(' || c14 == ')' || c14 == '<' || c14 == '>') {
                        i9 += 4;
                    } else {
                        byte[] bArr2 = com.alibaba.fastjson.util.f.f13322i;
                        if (c14 < bArr2.length && bArr2[c14] == 4) {
                            i9 += 4;
                        }
                    }
                    i7 = i28;
                    i8 = -1;
                    if (i7 == -1) {
                        i7 = i23;
                        i24 = i7;
                    } else {
                        i24 = i23;
                    }
                    c13 = c14;
                } else {
                    i7 = i28;
                    i8 = -1;
                }
            }
            i23++;
            int i29 = i8;
            i26 = i7;
            i15 = i29;
        }
        int i30 = i26;
        if (i25 > 0) {
            int i31 = i9 + i25;
            if (i31 > this.f13088a.length) {
                v(i31);
            }
            this.f13089b = i31;
            if (i25 == 1) {
                if (c13 == 8232) {
                    int i32 = i24 + 1;
                    char[] cArr15 = this.f13088a;
                    System.arraycopy(cArr15, i32, cArr15, i24 + 6, (i14 - i24) - 1);
                    char[] cArr16 = this.f13088a;
                    cArr16[i24] = '\\';
                    cArr16[i32] = 'u';
                    int i33 = i32 + 1;
                    cArr16[i33] = '2';
                    int i34 = i33 + 1;
                    cArr16[i34] = '0';
                    int i35 = i34 + 1;
                    cArr16[i35] = '2';
                    cArr16[i35 + 1] = '8';
                } else if (c13 == 8233) {
                    int i36 = i24 + 1;
                    char[] cArr17 = this.f13088a;
                    System.arraycopy(cArr17, i36, cArr17, i24 + 6, (i14 - i24) - 1);
                    char[] cArr18 = this.f13088a;
                    cArr18[i24] = '\\';
                    cArr18[i36] = 'u';
                    int i37 = i36 + 1;
                    cArr18[i37] = '2';
                    int i38 = i37 + 1;
                    cArr18[i38] = '0';
                    int i39 = i38 + 1;
                    cArr18[i39] = '2';
                    cArr18[i39 + 1] = '9';
                } else if (c13 == '(' || c13 == ')' || c13 == '<' || c13 == '>') {
                    int i40 = i24 + 1;
                    char[] cArr19 = this.f13088a;
                    System.arraycopy(cArr19, i40, cArr19, i24 + 6, (i14 - i24) - 1);
                    char[] cArr20 = this.f13088a;
                    cArr20[i24] = '\\';
                    cArr20[i40] = 'u';
                    int i41 = i40 + 1;
                    char[] cArr21 = com.alibaba.fastjson.util.f.f13319f;
                    cArr20[i41] = cArr21[(c13 >>> '\f') & 15];
                    int i42 = i41 + 1;
                    cArr20[i42] = cArr21[(c13 >>> '\b') & 15];
                    int i43 = i42 + 1;
                    cArr20[i43] = cArr21[(c13 >>> 4) & 15];
                    cArr20[i43 + 1] = cArr21[c13 & 15];
                } else {
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f13322i;
                    if (c13 >= bArr3.length || bArr3[c13] != 4) {
                        int i44 = i24 + 1;
                        char[] cArr22 = this.f13088a;
                        System.arraycopy(cArr22, i44, cArr22, i24 + 2, (i14 - i24) - 1);
                        char[] cArr23 = this.f13088a;
                        cArr23[i24] = '\\';
                        cArr23[i44] = com.alibaba.fastjson.util.f.f13326m[c13];
                    } else {
                        int i45 = i24 + 1;
                        char[] cArr24 = this.f13088a;
                        System.arraycopy(cArr24, i45, cArr24, i24 + 6, (i14 - i24) - 1);
                        char[] cArr25 = this.f13088a;
                        cArr25[i24] = '\\';
                        int i46 = i45 + 1;
                        cArr25[i45] = 'u';
                        int i47 = i46 + 1;
                        char[] cArr26 = com.alibaba.fastjson.util.f.f13319f;
                        cArr25[i46] = cArr26[(c13 >>> '\f') & 15];
                        int i48 = i47 + 1;
                        cArr25[i47] = cArr26[(c13 >>> '\b') & 15];
                        cArr25[i48] = cArr26[(c13 >>> 4) & 15];
                        cArr25[i48 + 1] = cArr26[c13 & 15];
                    }
                }
            } else if (i25 > 1) {
                for (int i49 = i30 - i13; i49 < cArr.length; i49++) {
                    char c15 = cArr[i49];
                    if (this.f13104q) {
                        if (c15 != '(' && c15 != ')') {
                            if (c15 == '<' || c15 == '>') {
                            }
                        }
                        char[] cArr27 = this.f13088a;
                        int i50 = i30 + 1;
                        cArr27[i30] = '\\';
                        int i51 = i50 + 1;
                        cArr27[i50] = 'u';
                        int i52 = i51 + 1;
                        char[] cArr28 = com.alibaba.fastjson.util.f.f13319f;
                        cArr27[i51] = cArr28[(c15 >>> '\f') & 15];
                        int i53 = i52 + 1;
                        cArr27[i52] = cArr28[(c15 >>> '\b') & 15];
                        int i54 = i53 + 1;
                        cArr27[i53] = cArr28[(c15 >>> 4) & 15];
                        i30 = i54 + 1;
                        cArr27[i54] = cArr28[c15 & 15];
                    }
                    byte[] bArr4 = com.alibaba.fastjson.util.f.f13322i;
                    if ((c15 >= bArr4.length || bArr4[c15] == 0) && !(c15 == '/' && G(k1.WriteSlashAsSpecial))) {
                        if (c15 == 8232 || c15 == 8233) {
                            char[] cArr29 = this.f13088a;
                            int i55 = i30 + 1;
                            cArr29[i30] = '\\';
                            int i56 = i55 + 1;
                            cArr29[i55] = 'u';
                            int i57 = i56 + 1;
                            char[] cArr30 = com.alibaba.fastjson.util.f.f13319f;
                            cArr29[i56] = cArr30[(c15 >>> '\f') & 15];
                            int i58 = i57 + 1;
                            cArr29[i57] = cArr30[(c15 >>> '\b') & 15];
                            int i59 = i58 + 1;
                            cArr29[i58] = cArr30[(c15 >>> 4) & 15];
                            i30 = i59 + 1;
                            cArr29[i59] = cArr30[c15 & 15];
                        } else {
                            this.f13088a[i30] = c15;
                            i30++;
                        }
                    } else {
                        char[] cArr31 = this.f13088a;
                        int i60 = i30 + 1;
                        cArr31[i30] = '\\';
                        if (bArr4[c15] == 4) {
                            int i61 = i60 + 1;
                            cArr31[i60] = 'u';
                            int i62 = i61 + 1;
                            char[] cArr32 = com.alibaba.fastjson.util.f.f13319f;
                            cArr31[i61] = cArr32[(c15 >>> '\f') & 15];
                            int i63 = i62 + 1;
                            cArr31[i62] = cArr32[(c15 >>> '\b') & 15];
                            int i64 = i63 + 1;
                            cArr31[i63] = cArr32[(c15 >>> 4) & 15];
                            i30 = i64 + 1;
                            cArr31[i64] = cArr32[c15 & 15];
                        } else {
                            i30 = i60 + 1;
                            cArr31[i60] = com.alibaba.fastjson.util.f.f13326m[c15];
                        }
                    }
                }
            }
        }
        if (c8 == 0) {
            this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
            return;
        }
        char[] cArr33 = this.f13088a;
        int i65 = this.f13089b;
        cArr33[i65 - 2] = kotlin.text.h0.f35376b;
        cArr33[i65 - 1] = c8;
    }

    protected void f2(String str) {
        int i7 = 0;
        if (str == null) {
            int i8 = this.f13089b + 4;
            if (i8 > this.f13088a.length) {
                v(i8);
            }
            "null".getChars(0, 4, this.f13088a, this.f13089b);
            this.f13089b = i8;
            return;
        }
        int length = str.length();
        int i9 = this.f13089b + length + 2;
        if (i9 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(39);
                while (i7 < str.length()) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && G(k1.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f13326m[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i7++;
                }
                write(39);
                return;
            }
            v(i9);
        }
        int i10 = this.f13089b;
        int i11 = i10 + 1;
        int i12 = i11 + length;
        char[] cArr = this.f13088a;
        cArr[i10] = '\'';
        str.getChars(0, length, cArr, i11);
        this.f13089b = i9;
        int i13 = -1;
        char c8 = 0;
        for (int i14 = i11; i14 < i12; i14++) {
            char c9 = this.f13088a[i14];
            if (c9 <= '\r' || c9 == '\\' || c9 == '\'' || (c9 == '/' && G(k1.WriteSlashAsSpecial))) {
                i7++;
                i13 = i14;
                c8 = c9;
            }
        }
        int i15 = i9 + i7;
        if (i15 > this.f13088a.length) {
            v(i15);
        }
        this.f13089b = i15;
        if (i7 == 1) {
            char[] cArr2 = this.f13088a;
            int i16 = i13 + 1;
            System.arraycopy(cArr2, i16, cArr2, i13 + 2, (i12 - i13) - 1);
            char[] cArr3 = this.f13088a;
            cArr3[i13] = '\\';
            cArr3[i16] = com.alibaba.fastjson.util.f.f13326m[c8];
        } else if (i7 > 1) {
            char[] cArr4 = this.f13088a;
            int i17 = i13 + 1;
            System.arraycopy(cArr4, i17, cArr4, i13 + 2, (i12 - i13) - 1);
            char[] cArr5 = this.f13088a;
            cArr5[i13] = '\\';
            cArr5[i17] = com.alibaba.fastjson.util.f.f13326m[c8];
            int i18 = i12 + 1;
            for (int i19 = i17 - 2; i19 >= i11; i19--) {
                char c10 = this.f13088a[i19];
                if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && G(k1.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f13088a;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr6, i20, cArr6, i19 + 2, (i18 - i19) - 1);
                    char[] cArr7 = this.f13088a;
                    cArr7[i19] = '\\';
                    cArr7[i20] = com.alibaba.fastjson.util.f.f13326m[c10];
                    i18++;
                }
            }
        }
        this.f13088a[this.f13089b - 1] = '\'';
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.f13091d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f13088a, 0, this.f13089b);
            this.f13091d.flush();
            this.f13089b = 0;
        } catch (IOException e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    public int g0() {
        return this.f13089b;
    }

    protected void g2(char[] cArr) {
        int i7 = 0;
        if (cArr == null) {
            int i8 = this.f13089b + 4;
            if (i8 > this.f13088a.length) {
                v(i8);
            }
            "null".getChars(0, 4, this.f13088a, this.f13089b);
            this.f13089b = i8;
            return;
        }
        int length = cArr.length;
        int i9 = this.f13089b + length + 2;
        if (i9 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(39);
                while (i7 < cArr.length) {
                    char c8 = cArr[i7];
                    if (c8 <= '\r' || c8 == '\\' || c8 == '\'' || (c8 == '/' && G(k1.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f13326m[c8]);
                    } else {
                        write(c8);
                    }
                    i7++;
                }
                write(39);
                return;
            }
            v(i9);
        }
        int i10 = this.f13089b;
        int i11 = i10 + 1;
        int i12 = length + i11;
        char[] cArr2 = this.f13088a;
        cArr2[i10] = '\'';
        System.arraycopy(cArr, 0, cArr2, i11, cArr.length);
        this.f13089b = i9;
        int i13 = -1;
        char c9 = 0;
        for (int i14 = i11; i14 < i12; i14++) {
            char c10 = this.f13088a[i14];
            if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && G(k1.WriteSlashAsSpecial))) {
                i7++;
                i13 = i14;
                c9 = c10;
            }
        }
        int i15 = i9 + i7;
        if (i15 > this.f13088a.length) {
            v(i15);
        }
        this.f13089b = i15;
        if (i7 == 1) {
            char[] cArr3 = this.f13088a;
            int i16 = i13 + 1;
            System.arraycopy(cArr3, i16, cArr3, i13 + 2, (i12 - i13) - 1);
            char[] cArr4 = this.f13088a;
            cArr4[i13] = '\\';
            cArr4[i16] = com.alibaba.fastjson.util.f.f13326m[c9];
        } else if (i7 > 1) {
            char[] cArr5 = this.f13088a;
            int i17 = i13 + 1;
            System.arraycopy(cArr5, i17, cArr5, i13 + 2, (i12 - i13) - 1);
            char[] cArr6 = this.f13088a;
            cArr6[i13] = '\\';
            cArr6[i17] = com.alibaba.fastjson.util.f.f13326m[c9];
            int i18 = i12 + 1;
            for (int i19 = i17 - 2; i19 >= i11; i19--) {
                char c11 = this.f13088a[i19];
                if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && G(k1.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f13088a;
                    int i20 = i19 + 1;
                    System.arraycopy(cArr7, i20, cArr7, i19 + 2, (i18 - i19) - 1);
                    char[] cArr8 = this.f13088a;
                    cArr8[i19] = '\\';
                    cArr8[i20] = com.alibaba.fastjson.util.f.f13326m[c11];
                    i18++;
                }
            }
        }
        this.f13088a[this.f13089b - 1] = '\'';
    }

    public byte[] h0(String str) {
        return l0((str == null || "UTF-8".equals(str)) ? com.alibaba.fastjson.util.f.f13318e : Charset.forName(str));
    }

    public void h2(OutputStream outputStream, String str) throws IOException {
        i2(outputStream, Charset.forName(str));
    }

    public void i1(char c8, String str, String str2) {
        if (!this.f13093f) {
            write(c8);
            J0(str);
            if (str2 == null) {
                X1();
                return;
            } else {
                a2(str2);
                return;
            }
        }
        if (this.f13092e) {
            write(c8);
            J0(str);
            if (str2 == null) {
                X1();
                return;
            } else {
                a2(str2);
                return;
            }
        }
        if (!G(k1.BrowserCompatible)) {
            z1(c8, str, str2);
            return;
        }
        write(c8);
        d2(str, ':');
        d2(str2, (char) 0);
    }

    public void i2(OutputStream outputStream, Charset charset) throws IOException {
        k2(outputStream, charset);
    }

    public void j2(Writer writer) throws IOException {
        if (this.f13091d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.f13088a, 0, this.f13089b);
    }

    public int k2(OutputStream outputStream, Charset charset) throws IOException {
        if (this.f13091d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == com.alibaba.fastjson.util.f.f13318e) {
            return s(outputStream);
        }
        byte[] bytes = new String(this.f13088a, 0, this.f13089b).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public byte[] l0(Charset charset) {
        if (this.f13091d == null) {
            return charset == com.alibaba.fastjson.util.f.f13318e ? u() : new String(this.f13088a, 0, this.f13089b).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] o0() {
        if (this.f13091d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i7 = this.f13089b;
        char[] cArr = new char[i7];
        System.arraycopy(this.f13088a, 0, cArr, 0, i7);
        return cArr;
    }

    public char[] p0() {
        if (this.f13091d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i7 = this.f13089b;
        char[] cArr = new char[i7 - 2];
        System.arraycopy(this.f13088a, 1, cArr, 0, i7 - 2);
        return cArr;
    }

    protected void q() {
        long j7;
        int i7 = this.f13090c;
        boolean z7 = (k1.QuoteFieldNames.f13132a & i7) != 0;
        this.f13093f = z7;
        boolean z8 = (k1.UseSingleQuotes.f13132a & i7) != 0;
        this.f13092e = z8;
        this.f13094g = (k1.SortField.f13132a & i7) != 0;
        this.f13095h = (k1.DisableCircularReferenceDetect.f13132a & i7) != 0;
        boolean z9 = (k1.BeanToArray.f13132a & i7) != 0;
        this.f13096i = z9;
        this.f13097j = (k1.WriteNonStringValueAsString.f13132a & i7) != 0;
        this.f13098k = (k1.NotWriteDefaultValue.f13132a & i7) != 0;
        boolean z10 = (k1.WriteEnumUsingName.f13132a & i7) != 0;
        this.f13099l = z10;
        this.f13100m = (k1.WriteEnumUsingToString.f13132a & i7) != 0;
        this.f13101n = z7 && (f13087u & i7) == 0 && (z9 || z10);
        this.f13102o = z8 ? '\'' : kotlin.text.h0.f35376b;
        boolean z11 = (k1.BrowserSecure.f13132a & i7) != 0;
        this.f13104q = z11;
        if (z11) {
            j7 = 5764610843043954687L;
        } else {
            j7 = (i7 & k1.WriteSlashAsSpecial.f13132a) != 0 ? 140758963191807L : 21474836479L;
        }
        this.f13105r = j7;
    }

    public void q1(char c8, String str, BigDecimal bigDecimal) {
        write(c8);
        J0(str);
        if (bigDecimal == null) {
            X1();
        } else {
            write(bigDecimal.toString());
        }
    }

    public void r(k1 k1Var, boolean z7) {
        if (z7) {
            int iB = this.f13090c | k1Var.b();
            this.f13090c = iB;
            k1 k1Var2 = k1.WriteEnumUsingToString;
            if (k1Var == k1Var2) {
                this.f13090c = (~k1.WriteEnumUsingName.b()) & iB;
            } else if (k1Var == k1.WriteEnumUsingName) {
                this.f13090c = (~k1Var2.b()) & iB;
            }
        } else {
            this.f13090c = (~k1Var.b()) & this.f13090c;
        }
        q();
    }

    public void r0(List<String> list) {
        boolean z7;
        int i7;
        if (list.isEmpty()) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        int i8 = this.f13089b;
        int size = list.size();
        int i9 = i8;
        int i10 = 0;
        while (i10 < size) {
            String str = list.get(i10);
            if (str == null) {
                z7 = true;
            } else {
                int length = str.length();
                z7 = false;
                for (int i11 = 0; i11 < length; i11++) {
                    char cCharAt = str.charAt(i11);
                    z7 = cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\\';
                    if (z7) {
                        break;
                    }
                }
            }
            if (z7) {
                this.f13089b = i8;
                write(91);
                for (int i12 = 0; i12 < list.size(); i12++) {
                    String str2 = list.get(i12);
                    if (i12 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        d2(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i9 + 3;
            if (i10 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.f13088a.length) {
                this.f13089b = i9;
                v(length2);
            }
            if (i10 == 0) {
                i7 = i9 + 1;
                this.f13088a[i9] = '[';
            } else {
                i7 = i9 + 1;
                this.f13088a[i9] = ',';
            }
            int i13 = i7 + 1;
            this.f13088a[i7] = kotlin.text.h0.f35376b;
            str.getChars(0, str.length(), this.f13088a, i13);
            int length3 = i13 + str.length();
            this.f13088a[length3] = kotlin.text.h0.f35376b;
            i10++;
            i9 = length3 + 1;
        }
        this.f13088a[i9] = ']';
        this.f13089b = i9 + 1;
    }

    public void s0(boolean z7) {
        if (z7) {
            write("true");
        } else {
            write(com.paytm.pgsdk.d.G);
        }
    }

    public void s1(char c8, String str, boolean z7) {
        if (!this.f13093f) {
            write(c8);
            J0(str);
            s0(z7);
            return;
        }
        int i7 = z7 ? 4 : 5;
        int length = str.length();
        int i8 = this.f13089b + length + 4 + i7;
        if (i8 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                a2(str);
                write(58);
                s0(z7);
                return;
            }
            v(i8);
        }
        int i9 = this.f13089b;
        this.f13089b = i8;
        char[] cArr = this.f13088a;
        cArr[i9] = c8;
        int i10 = i9 + length + 1;
        cArr[i9 + 1] = this.f13102o;
        str.getChars(0, length, cArr, i9 + 2);
        this.f13088a[i10 + 1] = this.f13102o;
        if (z7) {
            System.arraycopy(":true".toCharArray(), 0, this.f13088a, i10 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.f13088a, i10 + 2, 6);
        }
    }

    public String toString() {
        return new String(this.f13088a, 0, this.f13089b);
    }

    public void v(int i7) {
        int i8 = this.f13103p;
        if (i8 != -1 && i7 >= i8) {
            throw new com.alibaba.fastjson.d("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f13103p + ", minimumCapacity=" + i7);
        }
        char[] cArr = this.f13088a;
        int length = cArr.length + (cArr.length >> 1) + 1;
        if (length >= i7) {
            i7 = length;
        }
        char[] cArr2 = new char[i7];
        System.arraycopy(cArr, 0, cArr2, 0, this.f13089b);
        this.f13088a = cArr2;
    }

    public void v0(byte[] bArr) {
        if (F(k1.WriteClassName.f13132a)) {
            B1(bArr);
            return;
        }
        int length = bArr.length;
        boolean z7 = this.f13092e;
        char c8 = z7 ? '\'' : kotlin.text.h0.f35376b;
        if (length == 0) {
            write(z7 ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.fastjson.util.f.f13332s;
        int i7 = (length / 3) * 3;
        int i8 = length - 1;
        int i9 = this.f13089b;
        int i10 = (((i8 / 3) + 1) << 2) + i9 + 2;
        if (i10 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                int i11 = 0;
                while (i11 < i7) {
                    int i12 = i11 + 1;
                    int i13 = i12 + 1;
                    int i14 = ((bArr[i11] & 255) << 16) | ((bArr[i12] & 255) << 8) | (bArr[i13] & 255);
                    write(cArr[(i14 >>> 18) & 63]);
                    write(cArr[(i14 >>> 12) & 63]);
                    write(cArr[(i14 >>> 6) & 63]);
                    write(cArr[i14 & 63]);
                    i11 = i13 + 1;
                }
                int i15 = length - i7;
                if (i15 > 0) {
                    int i16 = ((bArr[i7] & 255) << 10) | (i15 == 2 ? (bArr[i8] & 255) << 2 : 0);
                    write(cArr[i16 >> 12]);
                    write(cArr[(i16 >>> 6) & 63]);
                    write(i15 == 2 ? cArr[i16 & 63] : '=');
                    write(61);
                }
                write(c8);
                return;
            }
            v(i10);
        }
        this.f13089b = i10;
        int i17 = i9 + 1;
        this.f13088a[i9] = c8;
        int i18 = 0;
        while (i18 < i7) {
            int i19 = i18 + 1;
            int i20 = i19 + 1;
            int i21 = ((bArr[i18] & 255) << 16) | ((bArr[i19] & 255) << 8);
            int i22 = i20 + 1;
            int i23 = i21 | (bArr[i20] & 255);
            char[] cArr2 = this.f13088a;
            int i24 = i17 + 1;
            cArr2[i17] = cArr[(i23 >>> 18) & 63];
            int i25 = i24 + 1;
            cArr2[i24] = cArr[(i23 >>> 12) & 63];
            int i26 = i25 + 1;
            cArr2[i25] = cArr[(i23 >>> 6) & 63];
            i17 = i26 + 1;
            cArr2[i26] = cArr[i23 & 63];
            i18 = i22;
        }
        int i27 = length - i7;
        if (i27 > 0) {
            int i28 = ((bArr[i7] & 255) << 10) | (i27 == 2 ? (bArr[i8] & 255) << 2 : 0);
            char[] cArr3 = this.f13088a;
            cArr3[i10 - 5] = cArr[i28 >> 12];
            cArr3[i10 - 4] = cArr[(i28 >>> 6) & 63];
            cArr3[i10 - 3] = i27 == 2 ? cArr[i28 & 63] : '=';
            cArr3[i10 - 2] = '=';
        }
        this.f13088a[i10 - 1] = c8;
    }

    public void w1(char c8, String str, String str2) {
        int length = str.length();
        int i7 = this.f13089b;
        int length2 = str2.length();
        int i8 = i7 + length + length2 + 6;
        if (i8 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                d2(str, ':');
                d2(str2, (char) 0);
                return;
            }
            v(i8);
        }
        char[] cArr = this.f13088a;
        int i9 = this.f13089b;
        cArr[i9] = c8;
        int i10 = i9 + 2;
        int i11 = i10 + length;
        cArr[i9 + 1] = kotlin.text.h0.f35376b;
        str.getChars(0, length, cArr, i10);
        this.f13089b = i8;
        char[] cArr2 = this.f13088a;
        cArr2[i11] = kotlin.text.h0.f35376b;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        cArr2[i12] = ':';
        cArr2[i13] = kotlin.text.h0.f35376b;
        str2.getChars(0, length2, cArr2, i13 + 1);
        this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
    }

    @Override // java.io.Writer
    public void write(int i7) {
        int i8 = 1;
        int i9 = this.f13089b + 1;
        if (i9 <= this.f13088a.length) {
            i8 = i9;
        } else if (this.f13091d == null) {
            v(i9);
            i8 = i9;
        } else {
            flush();
        }
        this.f13088a[this.f13089b] = (char) i7;
        this.f13089b = i8;
    }

    public void x0(double d8, boolean z7) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            X1();
            return;
        }
        String string = Double.toString(d8);
        if (G(k1.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        if (z7 && G(k1.WriteClassName)) {
            write(68);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d4  */
    public void z1(char c8, String str, String str2) {
        int length;
        int i7;
        int i8;
        int length2 = str.length();
        int i9 = this.f13089b;
        if (str2 == null) {
            i7 = i9 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i7 = i9 + length2 + length + 6;
        }
        if (i7 > this.f13088a.length) {
            if (this.f13091d != null) {
                write(c8);
                d2(str, ':');
                d2(str2, (char) 0);
                return;
            }
            v(i7);
        }
        char[] cArr = this.f13088a;
        int i10 = this.f13089b;
        cArr[i10] = c8;
        int i11 = i10 + 2;
        int i12 = i11 + length2;
        cArr[i10 + 1] = kotlin.text.h0.f35376b;
        str.getChars(0, length2, cArr, i11);
        this.f13089b = i7;
        char[] cArr2 = this.f13088a;
        cArr2[i12] = kotlin.text.h0.f35376b;
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        cArr2[i13] = ':';
        if (str2 == null) {
            int i15 = i14 + 1;
            cArr2[i14] = 'n';
            int i16 = i15 + 1;
            cArr2[i15] = 'u';
            cArr2[i16] = 'l';
            cArr2[i16 + 1] = 'l';
            return;
        }
        int i17 = i14 + 1;
        cArr2[i14] = kotlin.text.h0.f35376b;
        int i18 = i17 + length;
        str2.getChars(0, length, cArr2, i17);
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        int i22 = 0;
        char c9 = 0;
        for (int i23 = i17; i23 < i18; i23++) {
            char c10 = this.f13088a[i23];
            if (c10 < ']') {
                if ((c10 < '@' && (this.f13105r & (1 << c10)) != 0) || c10 == '\\') {
                    i22++;
                    if (c10 == '(' || c10 == ')' || c10 == '<' || c10 == '>') {
                        i7 += 4;
                    } else {
                        byte[] bArr = com.alibaba.fastjson.util.f.f13322i;
                        if (c10 < bArr.length && bArr[c10] == 4) {
                            i7 += 4;
                        }
                    }
                    i19 = -1;
                    if (i20 == -1) {
                        i20 = i23;
                        i21 = i20;
                    } else {
                        i21 = i23;
                    }
                    c9 = c10;
                } else {
                    i19 = -1;
                }
            } else if (c10 >= 127 && (c10 == 8232 || c10 == 8233 || c10 < 160)) {
                if (i20 == i19) {
                    i20 = i23;
                }
                i22++;
                i7 += 4;
                i21 = i23;
                c9 = c10;
            }
        }
        if (i22 > 0) {
            int i24 = i7 + i22;
            if (i24 > this.f13088a.length) {
                v(i24);
            }
            this.f13089b = i24;
            if (i22 == 1) {
                if (c9 == 8232) {
                    int i25 = i21 + 1;
                    char[] cArr3 = this.f13088a;
                    System.arraycopy(cArr3, i25, cArr3, i21 + 6, (i18 - i21) - 1);
                    char[] cArr4 = this.f13088a;
                    cArr4[i21] = '\\';
                    cArr4[i25] = 'u';
                    int i26 = i25 + 1;
                    cArr4[i26] = '2';
                    int i27 = i26 + 1;
                    cArr4[i27] = '0';
                    int i28 = i27 + 1;
                    cArr4[i28] = '2';
                    cArr4[i28 + 1] = '8';
                } else if (c9 == 8233) {
                    int i29 = i21 + 1;
                    char[] cArr5 = this.f13088a;
                    System.arraycopy(cArr5, i29, cArr5, i21 + 6, (i18 - i21) - 1);
                    char[] cArr6 = this.f13088a;
                    cArr6[i21] = '\\';
                    cArr6[i29] = 'u';
                    int i30 = i29 + 1;
                    cArr6[i30] = '2';
                    int i31 = i30 + 1;
                    cArr6[i31] = '0';
                    int i32 = i31 + 1;
                    cArr6[i32] = '2';
                    cArr6[i32 + 1] = '9';
                } else if (c9 == '(' || c9 == ')' || c9 == '<' || c9 == '>') {
                    int i33 = i21 + 1;
                    char[] cArr7 = this.f13088a;
                    System.arraycopy(cArr7, i33, cArr7, i21 + 6, (i18 - i21) - 1);
                    char[] cArr8 = this.f13088a;
                    cArr8[i21] = '\\';
                    int i34 = i33 + 1;
                    cArr8[i33] = 'u';
                    int i35 = i34 + 1;
                    char[] cArr9 = com.alibaba.fastjson.util.f.f13319f;
                    cArr8[i34] = cArr9[(c9 >>> '\f') & 15];
                    int i36 = i35 + 1;
                    cArr8[i35] = cArr9[(c9 >>> '\b') & 15];
                    cArr8[i36] = cArr9[(c9 >>> 4) & 15];
                    cArr8[i36 + 1] = cArr9[c9 & 15];
                } else {
                    byte[] bArr2 = com.alibaba.fastjson.util.f.f13322i;
                    if (c9 >= bArr2.length || bArr2[c9] != 4) {
                        int i37 = i21 + 1;
                        char[] cArr10 = this.f13088a;
                        System.arraycopy(cArr10, i37, cArr10, i21 + 2, (i18 - i21) - 1);
                        char[] cArr11 = this.f13088a;
                        cArr11[i21] = '\\';
                        cArr11[i37] = com.alibaba.fastjson.util.f.f13326m[c9];
                    } else {
                        int i38 = i21 + 1;
                        char[] cArr12 = this.f13088a;
                        System.arraycopy(cArr12, i38, cArr12, i21 + 6, (i18 - i21) - 1);
                        char[] cArr13 = this.f13088a;
                        cArr13[i21] = '\\';
                        int i39 = i38 + 1;
                        cArr13[i38] = 'u';
                        int i40 = i39 + 1;
                        char[] cArr14 = com.alibaba.fastjson.util.f.f13319f;
                        cArr13[i39] = cArr14[(c9 >>> '\f') & 15];
                        int i41 = i40 + 1;
                        cArr13[i40] = cArr14[(c9 >>> '\b') & 15];
                        cArr13[i41] = cArr14[(c9 >>> 4) & 15];
                        cArr13[i41 + 1] = cArr14[c9 & 15];
                    }
                }
            } else if (i22 > 1) {
                for (int i42 = i20 - i17; i42 < str2.length(); i42++) {
                    char cCharAt = str2.charAt(i42);
                    if (this.f13104q) {
                        if (cCharAt != '(' && cCharAt != ')') {
                            if (cCharAt == '<' || cCharAt == '>') {
                            }
                        }
                        char[] cArr15 = this.f13088a;
                        int i43 = i20 + 1;
                        cArr15[i20] = '\\';
                        int i44 = i43 + 1;
                        cArr15[i43] = 'u';
                        int i45 = i44 + 1;
                        char[] cArr16 = com.alibaba.fastjson.util.f.f13319f;
                        cArr15[i44] = cArr16[(cCharAt >>> '\f') & 15];
                        int i46 = i45 + 1;
                        cArr15[i45] = cArr16[(cCharAt >>> '\b') & 15];
                        int i47 = i46 + 1;
                        cArr15[i46] = cArr16[(cCharAt >>> 4) & 15];
                        i20 = i47 + 1;
                        cArr15[i47] = cArr16[cCharAt & 15];
                    }
                    byte[] bArr3 = com.alibaba.fastjson.util.f.f13322i;
                    if ((cCharAt >= bArr3.length || bArr3[cCharAt] == 0) && !(cCharAt == '/' && G(k1.WriteSlashAsSpecial))) {
                        if (cCharAt == 8232 || cCharAt == 8233) {
                            char[] cArr17 = this.f13088a;
                            int i48 = i20 + 1;
                            cArr17[i20] = '\\';
                            int i49 = i48 + 1;
                            cArr17[i48] = 'u';
                            int i50 = i49 + 1;
                            char[] cArr18 = com.alibaba.fastjson.util.f.f13319f;
                            cArr17[i49] = cArr18[(cCharAt >>> '\f') & 15];
                            int i51 = i50 + 1;
                            cArr17[i50] = cArr18[(cCharAt >>> '\b') & 15];
                            int i52 = i51 + 1;
                            cArr17[i51] = cArr18[(cCharAt >>> 4) & 15];
                            i20 = i52 + 1;
                            cArr17[i52] = cArr18[cCharAt & 15];
                        } else {
                            this.f13088a[i20] = cCharAt;
                            i20++;
                        }
                    } else {
                        char[] cArr19 = this.f13088a;
                        int i53 = i20 + 1;
                        cArr19[i20] = '\\';
                        if (bArr3[cCharAt] == 4) {
                            int i54 = i53 + 1;
                            cArr19[i53] = 'u';
                            int i55 = i54 + 1;
                            char[] cArr20 = com.alibaba.fastjson.util.f.f13319f;
                            cArr19[i54] = cArr20[(cCharAt >>> '\f') & 15];
                            int i56 = i55 + 1;
                            cArr19[i55] = cArr20[(cCharAt >>> '\b') & 15];
                            int i57 = i56 + 1;
                            cArr19[i56] = cArr20[(cCharAt >>> 4) & 15];
                            i8 = i57 + 1;
                            cArr19[i57] = cArr20[cCharAt & 15];
                        } else {
                            i8 = i53 + 1;
                            cArr19[i53] = com.alibaba.fastjson.util.f.f13326m[cCharAt];
                        }
                        i20 = i8;
                    }
                }
            }
        }
        this.f13088a[this.f13089b - 1] = kotlin.text.h0.f35376b;
    }

    public j1(Writer writer) {
        this(writer, com.alibaba.fastjson.a.f12533g, k1.F);
    }

    public j1(k1... k1VarArr) {
        this((Writer) null, k1VarArr);
    }

    public j1(Writer writer, k1... k1VarArr) {
        this(writer, 0, k1VarArr);
    }

    public j1(Writer writer, int i7, k1... k1VarArr) {
        this.f13103p = -1;
        this.f13091d = writer;
        ThreadLocal<char[]> threadLocal = f13085s;
        char[] cArr = threadLocal.get();
        this.f13088a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f13088a = new char[2048];
        }
        for (k1 k1Var : k1VarArr) {
            i7 |= k1Var.b();
        }
        this.f13090c = i7;
        q();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        int i9;
        if (i7 < 0 || i7 > cArr.length || i8 < 0 || (i9 = i7 + i8) > cArr.length || i9 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i8 == 0) {
            return;
        }
        int i10 = this.f13089b + i8;
        if (i10 > this.f13088a.length) {
            if (this.f13091d == null) {
                v(i10);
            } else {
                do {
                    char[] cArr2 = this.f13088a;
                    int length = cArr2.length;
                    int i11 = this.f13089b;
                    int i12 = length - i11;
                    System.arraycopy(cArr, i7, cArr2, i11, i12);
                    this.f13089b = this.f13088a.length;
                    flush();
                    i8 -= i12;
                    i7 += i12;
                } while (i8 > this.f13088a.length);
                i10 = i8;
            }
        }
        System.arraycopy(cArr, i7, this.f13088a, this.f13089b, i8);
        this.f13089b = i10;
    }

    public j1(int i7) {
        this((Writer) null, i7);
    }

    public j1(Writer writer, int i7) {
        this.f13103p = -1;
        this.f13091d = writer;
        if (i7 > 0) {
            this.f13088a = new char[i7];
            q();
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i7);
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i7, int i8) {
        int i9;
        int i10 = this.f13089b + i8;
        if (i10 > this.f13088a.length) {
            if (this.f13091d == null) {
                v(i10);
            } else {
                while (true) {
                    char[] cArr = this.f13088a;
                    int length = cArr.length;
                    int i11 = this.f13089b;
                    int i12 = length - i11;
                    i9 = i7 + i12;
                    str.getChars(i7, i9, cArr, i11);
                    this.f13089b = this.f13088a.length;
                    flush();
                    i8 -= i12;
                    if (i8 <= this.f13088a.length) {
                        break;
                    } else {
                        i7 = i9;
                    }
                }
                i10 = i8;
                i7 = i9;
            }
        }
        str.getChars(i7, i8 + i7, this.f13088a, this.f13089b);
        this.f13089b = i10;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            X1();
        } else {
            write(str, 0, str.length());
        }
    }
}
