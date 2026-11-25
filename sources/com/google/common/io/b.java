package com.google.common.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f21902a = new h("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f21903b = new h("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f21904c = new k("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f21905d = new k("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b f21906e = new g("base16()", "0123456789ABCDEF");

    class a extends com.google.common.io.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.io.j f21907a;

        a(com.google.common.io.j jVar) {
            this.f21907a = jVar;
        }

        @Override // com.google.common.io.f
        public OutputStream c() throws IOException {
            return b.this.p(this.f21907a.b());
        }
    }

    /* JADX INFO: renamed from: com.google.common.io.b$b, reason: collision with other inner class name */
    class C0279b extends com.google.common.io.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f21909a;

        C0279b(p pVar) {
            this.f21909a = pVar;
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return b.this.k(this.f21909a.q());
        }
    }

    static class e extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Appendable f21917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Writer f21918b;

        e(Appendable appendable, Writer writer) {
            this.f21917a = appendable;
            this.f21918b = writer;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f21918b.close();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.f21918b.flush();
        }

        @Override // java.io.Writer
        public void write(int i7) throws IOException {
            this.f21917a.append((char) i7);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f21920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f21921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f21922d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f21923e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f21924f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final byte[] f21925g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean[] f21926h;

        f(String str, char[] cArr) {
            this.f21919a = (String) com.google.common.base.e0.E(str);
            this.f21920b = (char[]) com.google.common.base.e0.E(cArr);
            try {
                int iP = com.google.common.math.d.p(cArr.length, RoundingMode.UNNECESSARY);
                this.f21922d = iP;
                int iMin = Math.min(8, Integer.lowestOneBit(iP));
                try {
                    this.f21923e = 8 / iMin;
                    this.f21924f = iP / iMin;
                    this.f21921c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i7 = 0; i7 < cArr.length; i7++) {
                        char c8 = cArr[i7];
                        com.google.common.base.e0.f(c8 < 128, "Non-ASCII character: %s", c8);
                        com.google.common.base.e0.f(bArr[c8] == -1, "Duplicate character: %s", c8);
                        bArr[c8] = (byte) i7;
                    }
                    this.f21925g = bArr;
                    boolean[] zArr = new boolean[this.f21923e];
                    for (int i8 = 0; i8 < this.f21924f; i8++) {
                        zArr[com.google.common.math.d.g(i8 * 8, this.f21922d, RoundingMode.CEILING)] = true;
                    }
                    this.f21926h = zArr;
                } catch (ArithmeticException e8) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e8);
                }
            } catch (ArithmeticException e9) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e9);
            }
        }

        private boolean e() {
            for (char c8 : this.f21920b) {
                if (com.google.common.base.c.c(c8)) {
                    return true;
                }
            }
            return false;
        }

        private boolean f() {
            for (char c8 : this.f21920b) {
                if (com.google.common.base.c.d(c8)) {
                    return true;
                }
            }
            return false;
        }

        boolean b(char c8) {
            return c8 <= 127 && this.f21925g[c8] != -1;
        }

        int c(char c8) throws i {
            if (c8 > 127) {
                throw new i("Unrecognized character: 0x" + Integer.toHexString(c8));
            }
            byte b8 = this.f21925g[c8];
            if (b8 != -1) {
                return b8;
            }
            if (c8 <= ' ' || c8 == 127) {
                throw new i("Unrecognized character: 0x" + Integer.toHexString(c8));
            }
            throw new i("Unrecognized character: " + c8);
        }

        char d(int i7) {
            return this.f21920b[i7];
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return Arrays.equals(this.f21920b, ((f) obj).f21920b);
            }
            return false;
        }

        boolean g(int i7) {
            return this.f21926h[i7 % this.f21923e];
        }

        f h() {
            if (!f()) {
                return this;
            }
            com.google.common.base.e0.h0(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f21920b.length];
            int i7 = 0;
            while (true) {
                char[] cArr2 = this.f21920b;
                if (i7 >= cArr2.length) {
                    return new f(this.f21919a + ".lowerCase()", cArr);
                }
                cArr[i7] = com.google.common.base.c.e(cArr2[i7]);
                i7++;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.f21920b);
        }

        public boolean i(char c8) {
            byte[] bArr = this.f21925g;
            return c8 < bArr.length && bArr[c8] != -1;
        }

        f j() {
            if (!e()) {
                return this;
            }
            com.google.common.base.e0.h0(!f(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f21920b.length];
            int i7 = 0;
            while (true) {
                char[] cArr2 = this.f21920b;
                if (i7 >= cArr2.length) {
                    return new f(this.f21919a + ".upperCase()", cArr);
                }
                cArr[i7] = com.google.common.base.c.h(cArr2[i7]);
                i7++;
            }
        }

        public String toString() {
            return this.f21919a;
        }
    }

    static final class g extends k {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final char[] f21927j;

        g(String str, String str2) {
            this(new f(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.b.k
        b D(f fVar, Character ch) {
            return new g(fVar);
        }

        @Override // com.google.common.io.b.k, com.google.common.io.b
        int i(byte[] bArr, CharSequence charSequence) throws i {
            com.google.common.base.e0.E(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new i("Invalid input length " + charSequence.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequence.length()) {
                bArr[i8] = (byte) ((this.f21931f.c(charSequence.charAt(i7)) << 4) | this.f21931f.c(charSequence.charAt(i7 + 1)));
                i7 += 2;
                i8++;
            }
            return i8;
        }

        @Override // com.google.common.io.b.k, com.google.common.io.b
        void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            com.google.common.base.e0.E(appendable);
            com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = bArr[i7 + i9] & 255;
                appendable.append(this.f21927j[i10]);
                appendable.append(this.f21927j[i10 | 256]);
            }
        }

        private g(f fVar) {
            super(fVar, null);
            this.f21927j = new char[512];
            com.google.common.base.e0.d(fVar.f21920b.length == 16);
            for (int i7 = 0; i7 < 256; i7++) {
                this.f21927j[i7] = fVar.d(i7 >>> 4);
                this.f21927j[i7 | 256] = fVar.d(i7 & 15);
            }
        }
    }

    static final class h extends k {
        h(String str, String str2, Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.b.k
        b D(f fVar, Character ch) {
            return new h(fVar, ch);
        }

        @Override // com.google.common.io.b.k, com.google.common.io.b
        int i(byte[] bArr, CharSequence charSequence) throws i {
            com.google.common.base.e0.E(bArr);
            CharSequence charSequenceY = y(charSequence);
            if (!this.f21931f.g(charSequenceY.length())) {
                throw new i("Invalid input length " + charSequenceY.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceY.length()) {
                int i9 = i7 + 1;
                int i10 = i9 + 1;
                int iC = (this.f21931f.c(charSequenceY.charAt(i7)) << 18) | (this.f21931f.c(charSequenceY.charAt(i9)) << 12);
                int i11 = i8 + 1;
                bArr[i8] = (byte) (iC >>> 16);
                if (i10 < charSequenceY.length()) {
                    int i12 = i10 + 1;
                    int iC2 = iC | (this.f21931f.c(charSequenceY.charAt(i10)) << 6);
                    i8 = i11 + 1;
                    bArr[i11] = (byte) ((iC2 >>> 8) & 255);
                    if (i12 < charSequenceY.length()) {
                        i10 = i12 + 1;
                        i11 = i8 + 1;
                        bArr[i8] = (byte) ((iC2 | this.f21931f.c(charSequenceY.charAt(i12))) & 255);
                    } else {
                        i7 = i12;
                    }
                }
                i8 = i11;
                i7 = i10;
            }
            return i8;
        }

        @Override // com.google.common.io.b.k, com.google.common.io.b
        void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            com.google.common.base.e0.E(appendable);
            int i9 = i7 + i8;
            com.google.common.base.e0.f0(i7, i9, bArr.length);
            while (i8 >= 3) {
                int i10 = i7 + 1;
                int i11 = i10 + 1;
                int i12 = ((bArr[i7] & 255) << 16) | ((bArr[i10] & 255) << 8) | (bArr[i11] & 255);
                appendable.append(this.f21931f.d(i12 >>> 18));
                appendable.append(this.f21931f.d((i12 >>> 12) & 63));
                appendable.append(this.f21931f.d((i12 >>> 6) & 63));
                appendable.append(this.f21931f.d(i12 & 63));
                i8 -= 3;
                i7 = i11 + 1;
            }
            if (i7 < i9) {
                C(appendable, bArr, i7, i9 - i7);
            }
        }

        private h(f fVar, Character ch) {
            super(fVar, ch);
            com.google.common.base.e0.d(fVar.f21920b.length == 64);
        }
    }

    public static final class i extends IOException {
        i(String str) {
            super(str);
        }

        i(Throwable th) {
            super(th);
        }
    }

    static final class j extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f21928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f21929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f21930h;

        j(b bVar, String str, int i7) {
            this.f21928f = (b) com.google.common.base.e0.E(bVar);
            this.f21929g = (String) com.google.common.base.e0.E(str);
            this.f21930h = i7;
            com.google.common.base.e0.k(i7 > 0, "Cannot add a separator after every %s chars", i7);
        }

        @Override // com.google.common.io.b
        public b A(char c8) {
            return this.f21928f.A(c8).B(this.f21929g, this.f21930h);
        }

        @Override // com.google.common.io.b
        public b B(String str, int i7) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.b
        public boolean f(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < charSequence.length(); i7++) {
                char cCharAt = charSequence.charAt(i7);
                if (this.f21929g.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.f21928f.f(sb);
        }

        @Override // com.google.common.io.b
        int i(byte[] bArr, CharSequence charSequence) throws i {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i7 = 0; i7 < charSequence.length(); i7++) {
                char cCharAt = charSequence.charAt(i7);
                if (this.f21929g.indexOf(cCharAt) < 0) {
                    sb.append(cCharAt);
                }
            }
            return this.f21928f.i(bArr, sb);
        }

        @Override // com.google.common.io.b
        @s1.c
        public InputStream k(Reader reader) {
            return this.f21928f.k(b.r(reader, this.f21929g));
        }

        @Override // com.google.common.io.b
        void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            this.f21928f.n(b.w(appendable, this.f21929g, this.f21930h), bArr, i7, i8);
        }

        @Override // com.google.common.io.b
        @s1.c
        public OutputStream p(Writer writer) {
            return this.f21928f.p(b.x(writer, this.f21929g, this.f21930h));
        }

        @Override // com.google.common.io.b
        public b s() {
            return this.f21928f.s().B(this.f21929g, this.f21930h);
        }

        @Override // com.google.common.io.b
        int t(int i7) {
            return this.f21928f.t(i7);
        }

        public String toString() {
            return this.f21928f + ".withSeparator(\"" + this.f21929g + "\", " + this.f21930h + ")";
        }

        @Override // com.google.common.io.b
        int u(int i7) {
            int iU = this.f21928f.u(i7);
            return iU + (this.f21929g.length() * com.google.common.math.d.g(Math.max(0, iU - 1), this.f21930h, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.b
        public b v() {
            return this.f21928f.v().B(this.f21929g, this.f21930h);
        }

        @Override // com.google.common.io.b
        CharSequence y(CharSequence charSequence) {
            return this.f21928f.y(charSequence);
        }

        @Override // com.google.common.io.b
        public b z() {
            return this.f21928f.z().B(this.f21929g, this.f21930h);
        }
    }

    static class k extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f f21931f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Character f21932g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private transient b f21933h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private transient b f21934i;

        class a extends OutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21935a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f21936b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f21937c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Writer f21938d;

            a(Writer writer) {
                this.f21938d = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i7 = this.f21936b;
                if (i7 > 0) {
                    int i8 = this.f21935a;
                    f fVar = k.this.f21931f;
                    this.f21938d.write(fVar.d((i8 << (fVar.f21922d - i7)) & fVar.f21921c));
                    this.f21937c++;
                    if (k.this.f21932g != null) {
                        while (true) {
                            int i9 = this.f21937c;
                            k kVar = k.this;
                            if (i9 % kVar.f21931f.f21923e == 0) {
                                break;
                            }
                            this.f21938d.write(kVar.f21932g.charValue());
                            this.f21937c++;
                        }
                    }
                }
                this.f21938d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f21938d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i7) throws IOException {
                this.f21935a = (i7 & 255) | (this.f21935a << 8);
                this.f21936b += 8;
                while (true) {
                    int i8 = this.f21936b;
                    f fVar = k.this.f21931f;
                    int i9 = fVar.f21922d;
                    if (i8 < i9) {
                        return;
                    }
                    this.f21938d.write(fVar.d((this.f21935a >> (i8 - i9)) & fVar.f21921c));
                    this.f21937c++;
                    this.f21936b -= k.this.f21931f.f21922d;
                }
            }
        }

        /* JADX INFO: renamed from: com.google.common.io.b$k$b, reason: collision with other inner class name */
        class C0280b extends InputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f21940a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f21941b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f21942c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            boolean f21943d = false;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Reader f21944e;

            C0280b(Reader reader) {
                this.f21944e = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f21944e.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i7;
                while (true) {
                    int i8 = this.f21944e.read();
                    if (i8 == -1) {
                        if (this.f21943d || k.this.f21931f.g(this.f21942c)) {
                            return -1;
                        }
                        throw new i("Invalid input length " + this.f21942c);
                    }
                    this.f21942c++;
                    char c8 = (char) i8;
                    Character ch = k.this.f21932g;
                    if (ch == null || ch.charValue() != c8) {
                        if (this.f21943d) {
                            throw new i("Expected padding character but found '" + c8 + "' at index " + this.f21942c);
                        }
                        int i9 = this.f21940a;
                        f fVar = k.this.f21931f;
                        int i10 = i9 << fVar.f21922d;
                        this.f21940a = i10;
                        int iC = fVar.c(c8) | i10;
                        this.f21940a = iC;
                        int i11 = this.f21941b + k.this.f21931f.f21922d;
                        this.f21941b = i11;
                        if (i11 >= 8) {
                            int i12 = i11 - 8;
                            this.f21941b = i12;
                            return (iC >> i12) & 255;
                        }
                    } else {
                        if (!this.f21943d && ((i7 = this.f21942c) == 1 || !k.this.f21931f.g(i7 - 1))) {
                            throw new i("Padding cannot start at index " + this.f21942c);
                        }
                        this.f21943d = true;
                    }
                }
            }
        }

        k(String str, String str2, Character ch) {
            this(new f(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.b
        public b A(char c8) {
            Character ch;
            return (8 % this.f21931f.f21922d == 0 || ((ch = this.f21932g) != null && ch.charValue() == c8)) ? this : D(this.f21931f, Character.valueOf(c8));
        }

        @Override // com.google.common.io.b
        public b B(String str, int i7) {
            for (int i8 = 0; i8 < str.length(); i8++) {
                com.google.common.base.e0.u(!this.f21931f.i(str.charAt(i8)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.f21932g;
            if (ch != null) {
                com.google.common.base.e0.u(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new j(this, str, i7);
        }

        void C(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            com.google.common.base.e0.E(appendable);
            com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
            int i9 = 0;
            com.google.common.base.e0.d(i8 <= this.f21931f.f21924f);
            long j7 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                j7 = (j7 | ((long) (bArr[i7 + i10] & 255))) << 8;
            }
            int i11 = ((i8 + 1) * 8) - this.f21931f.f21922d;
            while (i9 < i8 * 8) {
                f fVar = this.f21931f;
                appendable.append(fVar.d(((int) (j7 >>> (i11 - i9))) & fVar.f21921c));
                i9 += this.f21931f.f21922d;
            }
            if (this.f21932g != null) {
                while (i9 < this.f21931f.f21924f * 8) {
                    appendable.append(this.f21932g.charValue());
                    i9 += this.f21931f.f21922d;
                }
            }
        }

        b D(f fVar, Character ch) {
            return new k(fVar, ch);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f21931f.equals(kVar.f21931f) && com.google.common.base.y.a(this.f21932g, kVar.f21932g);
        }

        @Override // com.google.common.io.b
        public boolean f(CharSequence charSequence) {
            com.google.common.base.e0.E(charSequence);
            CharSequence charSequenceY = y(charSequence);
            if (!this.f21931f.g(charSequenceY.length())) {
                return false;
            }
            for (int i7 = 0; i7 < charSequenceY.length(); i7++) {
                if (!this.f21931f.b(charSequenceY.charAt(i7))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f21931f.hashCode() ^ com.google.common.base.y.b(this.f21932g);
        }

        @Override // com.google.common.io.b
        int i(byte[] bArr, CharSequence charSequence) throws i {
            f fVar;
            com.google.common.base.e0.E(bArr);
            CharSequence charSequenceY = y(charSequence);
            if (!this.f21931f.g(charSequenceY.length())) {
                throw new i("Invalid input length " + charSequenceY.length());
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < charSequenceY.length()) {
                long jC = 0;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    fVar = this.f21931f;
                    if (i9 >= fVar.f21923e) {
                        break;
                    }
                    jC <<= fVar.f21922d;
                    if (i7 + i9 < charSequenceY.length()) {
                        jC |= (long) this.f21931f.c(charSequenceY.charAt(i10 + i7));
                        i10++;
                    }
                    i9++;
                }
                int i11 = fVar.f21924f;
                int i12 = (i11 * 8) - (i10 * fVar.f21922d);
                int i13 = (i11 - 1) * 8;
                while (i13 >= i12) {
                    bArr[i8] = (byte) ((jC >>> i13) & 255);
                    i13 -= 8;
                    i8++;
                }
                i7 += this.f21931f.f21923e;
            }
            return i8;
        }

        @Override // com.google.common.io.b
        @s1.c
        public InputStream k(Reader reader) {
            com.google.common.base.e0.E(reader);
            return new C0280b(reader);
        }

        @Override // com.google.common.io.b
        void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException {
            com.google.common.base.e0.E(appendable);
            com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
            int i9 = 0;
            while (i9 < i8) {
                C(appendable, bArr, i7 + i9, Math.min(this.f21931f.f21924f, i8 - i9));
                i9 += this.f21931f.f21924f;
            }
        }

        @Override // com.google.common.io.b
        @s1.c
        public OutputStream p(Writer writer) {
            com.google.common.base.e0.E(writer);
            return new a(writer);
        }

        @Override // com.google.common.io.b
        public b s() {
            b bVarD = this.f21934i;
            if (bVarD == null) {
                f fVarH = this.f21931f.h();
                bVarD = fVarH == this.f21931f ? this : D(fVarH, this.f21932g);
                this.f21934i = bVarD;
            }
            return bVarD;
        }

        @Override // com.google.common.io.b
        int t(int i7) {
            return (int) (((((long) this.f21931f.f21922d) * ((long) i7)) + 7) / 8);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f21931f.toString());
            if (8 % this.f21931f.f21922d != 0) {
                if (this.f21932g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f21932g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.b
        int u(int i7) {
            f fVar = this.f21931f;
            return fVar.f21923e * com.google.common.math.d.g(i7, fVar.f21924f, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.b
        public b v() {
            return this.f21932g == null ? this : D(this.f21931f, null);
        }

        @Override // com.google.common.io.b
        CharSequence y(CharSequence charSequence) {
            com.google.common.base.e0.E(charSequence);
            Character ch = this.f21932g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.b
        public b z() {
            b bVarD = this.f21933h;
            if (bVarD == null) {
                f fVarJ = this.f21931f.j();
                bVarD = fVarJ == this.f21931f ? this : D(fVarJ, this.f21932g);
                this.f21933h = bVarD;
            }
            return bVarD;
        }

        k(f fVar, Character ch) {
            this.f21931f = (f) com.google.common.base.e0.E(fVar);
            com.google.common.base.e0.u(ch == null || !fVar.i(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f21932g = ch;
        }
    }

    b() {
    }

    public static b a() {
        return f21906e;
    }

    public static b b() {
        return f21904c;
    }

    public static b c() {
        return f21905d;
    }

    public static b d() {
        return f21902a;
    }

    public static b e() {
        return f21903b;
    }

    private static byte[] q(byte[] bArr, int i7) {
        if (i7 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, 0, bArr2, 0, i7);
        return bArr2;
    }

    @s1.c
    static Reader r(Reader reader, String str) {
        com.google.common.base.e0.E(reader);
        com.google.common.base.e0.E(str);
        return new c(reader, str);
    }

    static Appendable w(Appendable appendable, String str, int i7) {
        com.google.common.base.e0.E(appendable);
        com.google.common.base.e0.E(str);
        com.google.common.base.e0.d(i7 > 0);
        return new d(i7, appendable, str);
    }

    @s1.c
    static Writer x(Writer writer, String str, int i7) {
        return new e(w(writer, str, i7), writer);
    }

    public abstract b A(char c8);

    public abstract b B(String str, int i7);

    public abstract boolean f(CharSequence charSequence);

    public final byte[] g(CharSequence charSequence) {
        try {
            return h(charSequence);
        } catch (i e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    final byte[] h(CharSequence charSequence) throws i {
        CharSequence charSequenceY = y(charSequence);
        byte[] bArr = new byte[t(charSequenceY.length())];
        return q(bArr, i(bArr, charSequenceY));
    }

    abstract int i(byte[] bArr, CharSequence charSequence) throws i;

    @s1.c
    public final com.google.common.io.g j(p pVar) {
        com.google.common.base.e0.E(pVar);
        return new C0279b(pVar);
    }

    @s1.c
    public abstract InputStream k(Reader reader);

    public String l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public final String m(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, bArr.length);
        StringBuilder sb = new StringBuilder(u(i8));
        try {
            n(sb, bArr, i7, i8);
            return sb.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    abstract void n(Appendable appendable, byte[] bArr, int i7, int i8) throws IOException;

    @s1.c
    public final com.google.common.io.f o(com.google.common.io.j jVar) {
        com.google.common.base.e0.E(jVar);
        return new a(jVar);
    }

    @s1.c
    public abstract OutputStream p(Writer writer);

    public abstract b s();

    abstract int t(int i7);

    abstract int u(int i7);

    public abstract b v();

    CharSequence y(CharSequence charSequence) {
        return (CharSequence) com.google.common.base.e0.E(charSequence);
    }

    public abstract b z();

    static class c extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Reader f21911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21912b;

        c(Reader reader, String str) {
            this.f21911a = reader;
            this.f21912b = str;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f21911a.close();
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            int i7;
            do {
                i7 = this.f21911a.read();
                if (i7 == -1) {
                    break;
                }
            } while (this.f21912b.indexOf((char) i7) >= 0);
            return i7;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    static class d implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Appendable f21915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21916d;

        d(int i7, Appendable appendable, String str) {
            this.f21914b = i7;
            this.f21915c = appendable;
            this.f21916d = str;
            this.f21913a = i7;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c8) throws IOException {
            if (this.f21913a == 0) {
                this.f21915c.append(this.f21916d);
                this.f21913a = this.f21914b;
            }
            this.f21915c.append(c8);
            this.f21913a--;
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i7, int i8) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            throw new UnsupportedOperationException();
        }
    }
}
