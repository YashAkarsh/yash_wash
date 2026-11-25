package com.alibaba.fastjson.parser;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class f extends e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ThreadLocal<char[]> f12933x = new ThreadLocal<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Reader f12934u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private char[] f12935v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f12936w;

    public f(String str) {
        this(str, com.alibaba.fastjson.a.f12532f);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final String N2(int i7, int i8) {
        if (i8 >= 0) {
            return new String(this.f12935v, i7, i8);
        }
        throw new StringIndexOutOfBoundsException(i8);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final char[] O2(int i7, int i8) {
        if (i8 < 0) {
            throw new StringIndexOutOfBoundsException(i8);
        }
        if (i7 == 0) {
            return this.f12935v;
        }
        char[] cArr = new char[i8];
        System.arraycopy(this.f12935v, i7, cArr, 0, i8);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final String R1() {
        int i7 = this.f12926i;
        if (i7 == -1) {
            i7 = 0;
        }
        char cM = m((this.f12925h + i7) - 1);
        int i8 = this.f12925h;
        if (cM == 'L' || cM == 'S' || cM == 'B' || cM == 'F' || cM == 'D') {
            i8--;
        }
        return new String(this.f12935v, i7, i8);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final int Y1(char c8, int i7) {
        int i8 = i7 - this.f12922e;
        while (true) {
            char cM = m(this.f12922e + i8);
            if (c8 == cM) {
                return i8 + this.f12922e;
            }
            if (cM == 26) {
                return -1;
            }
            i8++;
        }
    }

    @Override // com.alibaba.fastjson.parser.e
    public boolean Z1() {
        if (this.f12936w == -1) {
            return true;
        }
        int i7 = this.f12922e;
        char[] cArr = this.f12935v;
        if (i7 != cArr.length) {
            return this.f12921d == 26 && i7 + 1 == cArr.length;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.e
    public final String c(int i7, int i8, int i9, k kVar) {
        return kVar.d(this.f12935v, i7, i8, i9);
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.f12935v;
        if (cArr.length <= 65536) {
            f12933x.set(cArr);
        }
        this.f12935v = null;
        com.alibaba.fastjson.util.f.a(this.f12934u);
    }

    @Override // com.alibaba.fastjson.parser.e
    protected final void f(int i7, char[] cArr, int i8, int i9) {
        System.arraycopy(this.f12935v, i7, cArr, i8, i9);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final boolean g(char[] cArr) {
        for (int i7 = 0; i7 < cArr.length; i7++) {
            if (m(this.f12922e + i7) != cArr[i7]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final BigDecimal h0() {
        int i7 = this.f12926i;
        if (i7 == -1) {
            i7 = 0;
        }
        char cM = m((this.f12925h + i7) - 1);
        int i8 = this.f12925h;
        if (cM == 'L' || cM == 'S' || cM == 'B' || cM == 'F' || cM == 'D') {
            i8--;
        }
        return new BigDecimal(this.f12935v, i7, i8);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final char m(int i7) {
        int i8 = this.f12936w;
        if (i7 >= i8) {
            if (i8 == -1) {
                if (i7 < this.f12925h) {
                    return this.f12935v[i7];
                }
                return (char) 26;
            }
            int i9 = this.f12922e;
            if (i9 == 0) {
                char[] cArr = this.f12935v;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i9, cArr2, 0, i8);
                int i10 = this.f12936w;
                try {
                    this.f12936w += this.f12934u.read(cArr2, i10, length - i10);
                    this.f12935v = cArr2;
                } catch (IOException e8) {
                    throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
                }
            } else {
                int i11 = i8 - i9;
                if (i11 > 0) {
                    char[] cArr3 = this.f12935v;
                    System.arraycopy(cArr3, i9, cArr3, 0, i11);
                }
                try {
                    Reader reader = this.f12934u;
                    char[] cArr4 = this.f12935v;
                    int i12 = reader.read(cArr4, i11, cArr4.length - i11);
                    this.f12936w = i12;
                    if (i12 == 0) {
                        throw new com.alibaba.fastjson.d("illegal state, textLength is zero");
                    }
                    if (i12 == -1) {
                        return (char) 26;
                    }
                    this.f12936w = i12 + i11;
                    int i13 = this.f12922e;
                    i7 -= i13;
                    this.f12926i -= i13;
                    this.f12922e = 0;
                } catch (IOException e9) {
                    throw new com.alibaba.fastjson.d(e9.getMessage(), e9);
                }
            }
        }
        return this.f12935v[i7];
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final char next() {
        int i7 = this.f12922e + 1;
        this.f12922e = i7;
        int i8 = this.f12936w;
        if (i7 >= i8) {
            if (i8 == -1) {
                return (char) 26;
            }
            int i9 = this.f12925h;
            if (i9 > 0) {
                int i10 = i8 - i9;
                if (this.f12921d == '\"' && i10 > 0) {
                    i10--;
                }
                char[] cArr = this.f12935v;
                System.arraycopy(cArr, i10, cArr, 0, i9);
            }
            this.f12926i = -1;
            int i11 = this.f12925h;
            this.f12922e = i11;
            try {
                char[] cArr2 = this.f12935v;
                int length = cArr2.length - i11;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.f12935v = cArr3;
                    length = cArr3.length - i11;
                }
                int i12 = this.f12934u.read(this.f12935v, this.f12922e, length);
                this.f12936w = i12;
                if (i12 == 0) {
                    throw new com.alibaba.fastjson.d("illegal stat, textLength is zero");
                }
                if (i12 == -1) {
                    this.f12921d = (char) 26;
                    return (char) 26;
                }
                this.f12936w = i12 + this.f12922e;
                i7 = i11;
            } catch (IOException e8) {
                throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
            }
        }
        char c8 = this.f12935v[i7];
        this.f12921d = c8;
        return c8;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public byte[] o0() {
        if (this.f12918a != 26) {
            return com.alibaba.fastjson.util.f.e(this.f12935v, this.f12926i + 1, this.f12925h);
        }
        throw new com.alibaba.fastjson.d("TODO");
    }

    @Override // com.alibaba.fastjson.parser.e
    protected final void s(int i7, int i8, char[] cArr) {
        System.arraycopy(this.f12935v, i7, cArr, 0, i8);
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final boolean u() {
        int i7 = 0;
        while (true) {
            char c8 = this.f12935v[i7];
            if (c8 == 26) {
                this.f12918a = 20;
                return true;
            }
            if (!e.b2(c8)) {
                return false;
            }
            i7++;
        }
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final String x0() {
        if (this.f12927j) {
            return new String(this.f12924g, 0, this.f12925h);
        }
        int i7 = this.f12926i + 1;
        if (i7 < 0) {
            throw new IllegalStateException();
        }
        char[] cArr = this.f12935v;
        int length = cArr.length;
        int i8 = this.f12925h;
        if (i7 <= length - i8) {
            return new String(cArr, i7, i8);
        }
        throw new IllegalStateException();
    }

    public f(String str, int i7) {
        this(new StringReader(str), i7);
    }

    public f(char[] cArr, int i7) {
        this(cArr, i7, com.alibaba.fastjson.a.f12532f);
    }

    public f(Reader reader) {
        this(reader, com.alibaba.fastjson.a.f12532f);
    }

    public f(Reader reader, int i7) {
        super(i7);
        this.f12934u = reader;
        ThreadLocal<char[]> threadLocal = f12933x;
        char[] cArr = threadLocal.get();
        this.f12935v = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.f12935v == null) {
            this.f12935v = new char[16384];
        }
        try {
            this.f12936w = reader.read(this.f12935v);
            this.f12922e = -1;
            next();
            if (this.f12921d == 65279) {
                next();
            }
        } catch (IOException e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    public f(char[] cArr, int i7, int i8) {
        this(new CharArrayReader(cArr, 0, i7), i8);
    }
}
