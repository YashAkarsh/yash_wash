package com.google.gson.stream;

import com.google.gson.internal.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.h0;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable {
    private static final int A = 9;
    private static final int B = 10;
    private static final int C = 11;
    private static final int D = 12;
    private static final int E = 13;
    private static final int F = 14;
    private static final int G = 15;
    private static final int H = 16;
    private static final int I = 17;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f23249J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int N = 4;
    private static final int O = 5;
    private static final int P = 6;
    private static final int Q = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final char[] f23250p = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f23251q = -922337203685477580L;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f23252r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f23253s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f23254t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f23255u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f23256v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f23257w = 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f23258x = 6;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f23259y = 7;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f23260z = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f23261a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f23269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f23271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f23272l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f23274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f23275o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23262b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f23263c = new char[1024];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23264d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23265e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23266f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f23267g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f23268h = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23273m = 0 + 1;

    /* JADX INFO: renamed from: com.google.gson.stream.a$a, reason: collision with other inner class name */
    class C0308a extends f {
        C0308a() {
        }

        @Override // com.google.gson.internal.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.a) {
                ((com.google.gson.internal.bind.a) aVar).B1();
                return;
            }
            int iU = aVar.f23268h;
            if (iU == 0) {
                iU = aVar.u();
            }
            if (iU == 13) {
                aVar.f23268h = 9;
                return;
            }
            if (iU == 12) {
                aVar.f23268h = 8;
                return;
            }
            if (iU == 14) {
                aVar.f23268h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.J0() + aVar.g0());
        }
    }

    static {
        f.f23173a = new C0308a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f23272l = iArr;
        iArr[0] = 6;
        this.f23274n = new String[32];
        this.f23275o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f23261a = reader;
    }

    private boolean F(int i7) throws IOException {
        int i8;
        int i9;
        char[] cArr = this.f23263c;
        int i10 = this.f23267g;
        int i11 = this.f23264d;
        this.f23267g = i10 - i11;
        int i12 = this.f23265e;
        if (i12 != i11) {
            int i13 = i12 - i11;
            this.f23265e = i13;
            System.arraycopy(cArr, i11, cArr, 0, i13);
        } else {
            this.f23265e = 0;
        }
        this.f23264d = 0;
        do {
            Reader reader = this.f23261a;
            int i14 = this.f23265e;
            int i15 = reader.read(cArr, i14, cArr.length - i14);
            if (i15 == -1) {
                return false;
            }
            i8 = this.f23265e + i15;
            this.f23265e = i8;
            if (this.f23266f == 0 && (i9 = this.f23267g) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.f23264d++;
                this.f23267g = i9 + 1;
                i7++;
            }
        } while (i8 < i7);
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String I0() throws IOException {
        String string;
        StringBuilder sb = null;
        int i7 = 0;
        while (true) {
            int i8 = 0;
            while (true) {
                int i9 = this.f23264d;
                if (i9 + i8 < this.f23265e) {
                    char c8 = this.f23263c[i9 + i8];
                    if (c8 != '\t' && c8 != '\n' && c8 != '\f' && c8 != '\r' && c8 != ' ') {
                        if (c8 != '#') {
                            if (c8 != ',') {
                                if (c8 != '/' && c8 != '=') {
                                    if (c8 != '{' && c8 != '}' && c8 != ':') {
                                        if (c8 != ';') {
                                            switch (c8) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i8++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        q();
                    }
                    i7 = i8;
                } else if (i8 >= this.f23263c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i8, 16));
                    }
                    sb.append(this.f23263c, this.f23264d, i8);
                    this.f23264d += i8;
                    if (!F(1)) {
                    }
                } else if (!F(i8 + 1)) {
                    i7 = i8;
                }
                if (sb == null) {
                    string = new String(this.f23263c, this.f23264d, i7);
                } else {
                    sb.append(this.f23263c, this.f23264d, i7);
                    string = sb.toString();
                }
                this.f23264d += i7;
                return string;
            }
        }
    }

    private int L0() throws IOException {
        String str;
        String str2;
        int i7;
        char c8 = this.f23263c[this.f23264d];
        if (c8 == 't' || c8 == 'T') {
            str = "true";
            str2 = "TRUE";
            i7 = 5;
        } else if (c8 == 'f' || c8 == 'F') {
            str = com.paytm.pgsdk.d.G;
            str2 = "FALSE";
            i7 = 6;
        } else {
            if (c8 != 'n' && c8 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i7 = 7;
        }
        int length = str.length();
        for (int i8 = 1; i8 < length; i8++) {
            if (this.f23264d + i8 >= this.f23265e && !F(i8 + 1)) {
                return 0;
            }
            char c9 = this.f23263c[this.f23264d + i8];
            if (c9 != str.charAt(i8) && c9 != str2.charAt(i8)) {
                return 0;
            }
        }
        if ((this.f23264d + length < this.f23265e || F(length + 1)) && Q(this.f23263c[this.f23264d + length])) {
            return 0;
        }
        this.f23264d += length;
        this.f23268h = i7;
        return i7;
    }

    private boolean Q(char c8) throws IOException {
        if (c8 == '\t' || c8 == '\n' || c8 == '\f' || c8 == '\r' || c8 == ' ') {
            return false;
        }
        if (c8 != '#') {
            if (c8 == ',') {
                return false;
            }
            if (c8 != '/' && c8 != '=') {
                if (c8 == '{' || c8 == '}' || c8 == ':') {
                    return false;
                }
                if (c8 != ';') {
                    switch (c8) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        q();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:90:0x00df  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:97:0x00eb  */
    private int Q0() throws IOException {
        char c8;
        char c9;
        char[] cArr = this.f23263c;
        int i7 = this.f23264d;
        int i8 = this.f23265e;
        int i9 = 0;
        int i10 = 0;
        char c10 = 0;
        boolean z7 = false;
        boolean z8 = true;
        long j7 = 0;
        while (true) {
            if (i7 + i10 != i8) {
                c8 = cArr[i7 + i10];
                if (c8 != '+') {
                    if (c8 != 'E' || c8 == 'e') {
                        i9 = 0;
                        if (c10 == 2 && c10 != 4) {
                            return 0;
                        }
                        c10 = 5;
                    } else if (c8 != '-') {
                        c9 = 3;
                        if (c8 == '.') {
                            i9 = 0;
                            if (c10 != 2) {
                                return 0;
                            }
                        } else {
                            if (c8 < '0' || c8 > '9') {
                                if (!Q(c8)) {
                                    break;
                                }
                                return 0;
                            }
                            if (c10 == 1 || c10 == 0) {
                                j7 = -(c8 - '0');
                                c10 = 2;
                            } else if (c10 == 2) {
                                if (j7 == 0) {
                                    return 0;
                                }
                                long j8 = (10 * j7) - ((long) (c8 - '0'));
                                z8 &= j7 > -922337203685477580L || (j7 == -922337203685477580L && j8 < j7);
                                j7 = j8;
                            } else if (c10 == 3) {
                                i9 = 0;
                                c10 = 4;
                            } else if (c10 == 5 || c10 == 6) {
                                i9 = 0;
                                c10 = 7;
                            }
                            i9 = 0;
                        }
                    } else {
                        c9 = 6;
                        i9 = 0;
                        if (c10 == 0) {
                            c10 = 1;
                            z7 = true;
                        } else if (c10 != 5) {
                            return 0;
                        }
                    }
                    i10++;
                } else {
                    c9 = 6;
                    i9 = 0;
                    if (c10 != 5) {
                        return 0;
                    }
                }
                c10 = c9;
                i10++;
            } else {
                if (i10 == cArr.length) {
                    return i9;
                }
                if (!F(i10 + 1)) {
                    break;
                }
                i7 = this.f23264d;
                i8 = this.f23265e;
                c8 = cArr[i7 + i10];
                if (c8 != '+') {
                    if (c8 != 'E') {
                        i9 = 0;
                        if (c10 == 2) {
                        }
                        c10 = 5;
                    } else {
                        i9 = 0;
                        if (c10 == 2) {
                        }
                        c10 = 5;
                    }
                    i10++;
                } else {
                    c9 = 6;
                    i9 = 0;
                    if (c10 != 5) {
                        return 0;
                    }
                }
                c10 = c9;
                i10++;
            }
        }
        if (c10 == 2 && z8 && ((j7 != Long.MIN_VALUE || z7) && (j7 != 0 || !z7))) {
            if (!z7) {
                j7 = -j7;
            }
            this.f23269i = j7;
            this.f23264d += i10;
            this.f23268h = 15;
            return 15;
        }
        if (c10 != 2 && c10 != 4 && c10 != 7) {
            return 0;
        }
        this.f23270j = i10;
        this.f23268h = 16;
        return 16;
    }

    private void T0(int i7) {
        int i8 = this.f23273m;
        int[] iArr = this.f23272l;
        if (i8 == iArr.length) {
            int i9 = i8 * 2;
            this.f23272l = Arrays.copyOf(iArr, i9);
            this.f23275o = Arrays.copyOf(this.f23275o, i9);
            this.f23274n = (String[]) Arrays.copyOf(this.f23274n, i9);
        }
        int[] iArr2 = this.f23272l;
        int i10 = this.f23273m;
        this.f23273m = i10 + 1;
        iArr2[i10] = i7;
    }

    private char V0() throws IOException {
        int i7;
        int i8;
        if (this.f23264d == this.f23265e && !F(1)) {
            throw s1("Unterminated escape sequence");
        }
        char[] cArr = this.f23263c;
        int i9 = this.f23264d;
        int i10 = i9 + 1;
        this.f23264d = i10;
        char c8 = cArr[i9];
        if (c8 == '\n') {
            this.f23266f++;
            this.f23267g = i10;
        } else if (c8 != '\"' && c8 != '\'' && c8 != '/' && c8 != '\\') {
            if (c8 == 'b') {
                return '\b';
            }
            if (c8 == 'f') {
                return '\f';
            }
            if (c8 == 'n') {
                return '\n';
            }
            if (c8 == 'r') {
                return CharUtils.CR;
            }
            if (c8 == 't') {
                return '\t';
            }
            if (c8 != 'u') {
                throw s1("Invalid escape sequence");
            }
            if (i10 + 4 > this.f23265e && !F(4)) {
                throw s1("Unterminated escape sequence");
            }
            int i11 = this.f23264d;
            int i12 = i11 + 4;
            char c9 = 0;
            while (i11 < i12) {
                char c10 = this.f23263c[i11];
                char c11 = (char) (c9 << 4);
                if (c10 < '0' || c10 > '9') {
                    if (c10 >= 'a' && c10 <= 'f') {
                        i7 = c10 - 'a';
                    } else {
                        if (c10 < 'A' || c10 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f23263c, this.f23264d, 4));
                        }
                        i7 = c10 - 'A';
                    }
                    i8 = i7 + 10;
                } else {
                    i8 = c10 - '0';
                }
                c9 = (char) (c11 + i8);
                i11++;
            }
            this.f23264d += 4;
            return c9;
        }
        return c8;
    }

    private void a1(char c8) throws IOException {
        char[] cArr = this.f23263c;
        do {
            int i7 = this.f23264d;
            int i8 = this.f23265e;
            while (i7 < i8) {
                int i9 = i7 + 1;
                char c9 = cArr[i7];
                if (c9 == c8) {
                    this.f23264d = i9;
                    return;
                }
                if (c9 == '\\') {
                    this.f23264d = i9;
                    V0();
                    i7 = this.f23264d;
                    i8 = this.f23265e;
                } else {
                    if (c9 == '\n') {
                        this.f23266f++;
                        this.f23267g = i9;
                    }
                    i7 = i9;
                }
            }
            this.f23264d = i7;
        } while (F(1));
        throw s1("Unterminated string");
    }

    private boolean d1(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f23264d + length > this.f23265e && !F(length)) {
                return false;
            }
            char[] cArr = this.f23263c;
            int i7 = this.f23264d;
            if (cArr[i7] != '\n') {
                for (int i8 = 0; i8 < length; i8++) {
                    if (this.f23263c[this.f23264d + i8] == str.charAt(i8)) {
                    }
                }
                return true;
            }
            this.f23266f++;
            this.f23267g = i7 + 1;
            this.f23264d++;
        }
    }

    private void e1() throws IOException {
        char c8;
        do {
            if (this.f23264d >= this.f23265e && !F(1)) {
                return;
            }
            char[] cArr = this.f23263c;
            int i7 = this.f23264d;
            int i8 = i7 + 1;
            this.f23264d = i8;
            c8 = cArr[i7];
            if (c8 == '\n') {
                this.f23266f++;
                this.f23267g = i8;
                return;
            }
        } while (c8 != '\r');
    }

    private void i1() throws IOException {
        do {
            int i7 = 0;
            while (true) {
                int i8 = this.f23264d;
                if (i8 + i7 < this.f23265e) {
                    char c8 = this.f23263c[i8 + i7];
                    if (c8 != '\t' && c8 != '\n' && c8 != '\f' && c8 != '\r' && c8 != ' ') {
                        if (c8 != '#') {
                            if (c8 != ',') {
                                if (c8 != '/' && c8 != '=') {
                                    if (c8 != '{' && c8 != '}' && c8 != ':') {
                                        if (c8 != ';') {
                                            switch (c8) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i7++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        q();
                    }
                    this.f23264d += i7;
                    return;
                }
                this.f23264d = i8 + i7;
            }
        } while (F(1));
    }

    private void q() throws IOException {
        if (!this.f23262b) {
            throw s1("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void r() throws IOException {
        s0(true);
        int i7 = this.f23264d - 1;
        this.f23264d = i7;
        char[] cArr = f23250p;
        if (i7 + cArr.length > this.f23265e && !F(cArr.length)) {
            return;
        }
        int i8 = 0;
        while (true) {
            char[] cArr2 = f23250p;
            if (i8 >= cArr2.length) {
                this.f23264d += cArr2.length;
                return;
            } else if (this.f23263c[this.f23264d + i8] != cArr2[i8]) {
                return;
            } else {
                i8++;
            }
        }
    }

    private int s0(boolean z7) throws IOException {
        char[] cArr = this.f23263c;
        int i7 = this.f23264d;
        int i8 = this.f23265e;
        while (true) {
            if (i7 == i8) {
                this.f23264d = i7;
                if (!F(1)) {
                    if (!z7) {
                        return -1;
                    }
                    throw new EOFException("End of input" + g0());
                }
                i7 = this.f23264d;
                i8 = this.f23265e;
            }
            int i9 = i7 + 1;
            char c8 = cArr[i7];
            if (c8 == '\n') {
                this.f23266f++;
                this.f23267g = i9;
            } else if (c8 != ' ' && c8 != '\r' && c8 != '\t') {
                if (c8 == '/') {
                    this.f23264d = i9;
                    if (i9 == i8) {
                        this.f23264d = i9 - 1;
                        boolean zF = F(2);
                        this.f23264d++;
                        if (!zF) {
                            return c8;
                        }
                    }
                    q();
                    int i10 = this.f23264d;
                    char c9 = cArr[i10];
                    if (c9 == '*') {
                        this.f23264d = i10 + 1;
                        if (!d1("*/")) {
                            throw s1("Unterminated comment");
                        }
                        i7 = this.f23264d + 2;
                        i8 = this.f23265e;
                    } else {
                        if (c9 != '/') {
                            return c8;
                        }
                        this.f23264d = i10 + 1;
                        e1();
                        i7 = this.f23264d;
                        i8 = this.f23265e;
                    }
                } else {
                    if (c8 != '#') {
                        this.f23264d = i9;
                        return c8;
                    }
                    this.f23264d = i9;
                    q();
                    e1();
                    i7 = this.f23264d;
                    i8 = this.f23265e;
                }
            }
            i7 = i9;
        }
    }

    private IOException s1(String str) throws IOException {
        throw new e(str + g0());
    }

    private String x0(char c8) throws IOException {
        int i7;
        char[] cArr = this.f23263c;
        StringBuilder sb = null;
        do {
            int i8 = this.f23264d;
            int i9 = this.f23265e;
            while (true) {
                int i10 = i9;
                i7 = i8;
                while (true) {
                    if (i8 < i10) {
                        int i11 = i8 + 1;
                        char c9 = cArr[i8];
                        if (c9 == c8) {
                            this.f23264d = i11;
                            int i12 = (i11 - i7) - 1;
                            if (sb == null) {
                                return new String(cArr, i7, i12);
                            }
                            sb.append(cArr, i7, i12);
                            return sb.toString();
                        }
                        if (c9 == '\\') {
                            this.f23264d = i11;
                            int i13 = (i11 - i7) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i13 + 1) * 2, 16));
                            }
                            sb.append(cArr, i7, i13);
                            sb.append(V0());
                            i8 = this.f23264d;
                            i9 = this.f23265e;
                        } else {
                            if (c9 == '\n') {
                                this.f23266f++;
                                this.f23267g = i11;
                            }
                            i8 = i11;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i8 - i7) * 2, 16));
            }
            sb.append(cArr, i7, i8 - i7);
            this.f23264d = i8;
        } while (F(1));
        throw s1("Unterminated string");
    }

    public void C() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + J0() + g0());
        }
        int i7 = this.f23273m - 1;
        this.f23273m = i7;
        int[] iArr = this.f23275o;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f23268h = 0;
    }

    public void E() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + J0() + g0());
        }
        int i7 = this.f23273m - 1;
        this.f23273m = i7;
        this.f23274n[i7] = null;
        int[] iArr = this.f23275o;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f23268h = 0;
    }

    public String G() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = this.f23273m;
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = this.f23272l[i8];
            if (i9 == 1 || i9 == 2) {
                sb.append('[');
                sb.append(this.f23275o[i8]);
                sb.append(']');
            } else if (i9 == 3 || i9 == 4 || i9 == 5) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.f23274n[i8];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public String G0() throws IOException {
        String str;
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 10) {
            str = I0();
        } else if (iU == 8) {
            str = x0('\'');
        } else if (iU == 9) {
            str = x0(h0.f35376b);
        } else if (iU == 11) {
            str = this.f23271k;
            this.f23271k = null;
        } else if (iU == 15) {
            str = Long.toString(this.f23269i);
        } else {
            if (iU != 16) {
                throw new IllegalStateException("Expected a string but was " + J0() + g0());
            }
            str = new String(this.f23263c, this.f23264d, this.f23270j);
            this.f23264d += this.f23270j;
        }
        this.f23268h = 0;
        int[] iArr = this.f23275o;
        int i7 = this.f23273m - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    public boolean H() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        return (iU == 2 || iU == 4) ? false : true;
    }

    public c J0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        switch (iU) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final boolean K() {
        return this.f23262b;
    }

    public final void Y0(boolean z7) {
        this.f23262b = z7;
    }

    public void b() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 3) {
            T0(1);
            this.f23275o[this.f23273m - 1] = 0;
            this.f23268h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + J0() + g0());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23268h = 0;
        this.f23272l[0] = 8;
        this.f23273m = 1;
        this.f23261a.close();
    }

    public void e() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 1) {
            T0(3);
            this.f23268h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + J0() + g0());
        }
    }

    String g0() {
        return " at line " + (this.f23266f + 1) + " column " + ((this.f23264d - this.f23267g) + 1) + " path " + G();
    }

    public boolean h0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 5) {
            this.f23268h = 0;
            int[] iArr = this.f23275o;
            int i7 = this.f23273m - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (iU == 6) {
            this.f23268h = 0;
            int[] iArr2 = this.f23275o;
            int i8 = this.f23273m - 1;
            iArr2[i8] = iArr2[i8] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + J0() + g0());
    }

    public double l0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 15) {
            this.f23268h = 0;
            int[] iArr = this.f23275o;
            int i7 = this.f23273m - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f23269i;
        }
        if (iU == 16) {
            this.f23271k = new String(this.f23263c, this.f23264d, this.f23270j);
            this.f23264d += this.f23270j;
        } else if (iU == 8 || iU == 9) {
            this.f23271k = x0(iU == 8 ? '\'' : h0.f35376b);
        } else if (iU == 10) {
            this.f23271k = I0();
        } else if (iU != 11) {
            throw new IllegalStateException("Expected a double but was " + J0() + g0());
        }
        this.f23268h = 11;
        double d8 = Double.parseDouble(this.f23271k);
        if (!this.f23262b && (Double.isNaN(d8) || Double.isInfinite(d8))) {
            throw new e("JSON forbids NaN and infinities: " + d8 + g0());
        }
        this.f23271k = null;
        this.f23268h = 0;
        int[] iArr2 = this.f23275o;
        int i8 = this.f23273m - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return d8;
    }

    public int o0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 15) {
            long j7 = this.f23269i;
            int i7 = (int) j7;
            if (j7 == i7) {
                this.f23268h = 0;
                int[] iArr = this.f23275o;
                int i8 = this.f23273m - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.f23269i + g0());
        }
        if (iU == 16) {
            this.f23271k = new String(this.f23263c, this.f23264d, this.f23270j);
            this.f23264d += this.f23270j;
        } else {
            if (iU != 8 && iU != 9 && iU != 10) {
                throw new IllegalStateException("Expected an int but was " + J0() + g0());
            }
            if (iU == 10) {
                this.f23271k = I0();
            } else {
                this.f23271k = x0(iU == 8 ? '\'' : h0.f35376b);
            }
            try {
                int i9 = Integer.parseInt(this.f23271k);
                this.f23268h = 0;
                int[] iArr2 = this.f23275o;
                int i10 = this.f23273m - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return i9;
            } catch (NumberFormatException unused) {
            }
        }
        this.f23268h = 11;
        double d8 = Double.parseDouble(this.f23271k);
        int i11 = (int) d8;
        if (i11 != d8) {
            throw new NumberFormatException("Expected an int but was " + this.f23271k + g0());
        }
        this.f23271k = null;
        this.f23268h = 0;
        int[] iArr3 = this.f23275o;
        int i12 = this.f23273m - 1;
        iArr3[i12] = iArr3[i12] + 1;
        return i11;
    }

    public long p0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 15) {
            this.f23268h = 0;
            int[] iArr = this.f23275o;
            int i7 = this.f23273m - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f23269i;
        }
        if (iU == 16) {
            this.f23271k = new String(this.f23263c, this.f23264d, this.f23270j);
            this.f23264d += this.f23270j;
        } else {
            if (iU != 8 && iU != 9 && iU != 10) {
                throw new IllegalStateException("Expected a long but was " + J0() + g0());
            }
            if (iU == 10) {
                this.f23271k = I0();
            } else {
                this.f23271k = x0(iU == 8 ? '\'' : h0.f35376b);
            }
            try {
                long j7 = Long.parseLong(this.f23271k);
                this.f23268h = 0;
                int[] iArr2 = this.f23275o;
                int i8 = this.f23273m - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return j7;
            } catch (NumberFormatException unused) {
            }
        }
        this.f23268h = 11;
        double d8 = Double.parseDouble(this.f23271k);
        long j8 = (long) d8;
        if (j8 != d8) {
            throw new NumberFormatException("Expected a long but was " + this.f23271k + g0());
        }
        this.f23271k = null;
        this.f23268h = 0;
        int[] iArr3 = this.f23275o;
        int i9 = this.f23273m - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j8;
    }

    public void q1() throws IOException {
        int i7 = 0;
        do {
            int iU = this.f23268h;
            if (iU == 0) {
                iU = u();
            }
            if (iU == 3) {
                T0(1);
            } else {
                if (iU == 1) {
                    T0(3);
                } else if (iU == 4 || iU == 2) {
                    this.f23273m--;
                    i7--;
                } else if (iU == 14 || iU == 10) {
                    i1();
                } else if (iU == 8 || iU == 12) {
                    a1('\'');
                } else if (iU == 9 || iU == 13) {
                    a1(h0.f35376b);
                } else if (iU == 16) {
                    this.f23264d += this.f23270j;
                }
                this.f23268h = 0;
            }
            i7++;
            this.f23268h = 0;
        } while (i7 != 0);
        int[] iArr = this.f23275o;
        int i8 = this.f23273m;
        int i9 = i8 - 1;
        iArr[i9] = iArr[i9] + 1;
        this.f23274n[i8 - 1] = "null";
    }

    public String r0() throws IOException {
        String strX0;
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 14) {
            strX0 = I0();
        } else if (iU == 12) {
            strX0 = x0('\'');
        } else {
            if (iU != 13) {
                throw new IllegalStateException("Expected a name but was " + J0() + g0());
            }
            strX0 = x0(h0.f35376b);
        }
        this.f23268h = 0;
        this.f23274n[this.f23273m - 1] = strX0;
        return strX0;
    }

    public String toString() {
        return getClass().getSimpleName() + g0();
    }

    int u() throws IOException {
        int iS0;
        int[] iArr = this.f23272l;
        int i7 = this.f23273m;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else if (i8 == 2) {
            int iS1 = s0(true);
            if (iS1 != 44) {
                if (iS1 != 59) {
                    if (iS1 != 93) {
                        throw s1("Unterminated array");
                    }
                    this.f23268h = 4;
                    return 4;
                }
                q();
            }
        } else {
            if (i8 == 3 || i8 == 5) {
                iArr[i7 - 1] = 4;
                if (i8 == 5 && (iS0 = s0(true)) != 44) {
                    if (iS0 != 59) {
                        if (iS0 != 125) {
                            throw s1("Unterminated object");
                        }
                        this.f23268h = 2;
                        return 2;
                    }
                    q();
                }
                int iS2 = s0(true);
                if (iS2 == 34) {
                    this.f23268h = 13;
                    return 13;
                }
                if (iS2 == 39) {
                    q();
                    this.f23268h = 12;
                    return 12;
                }
                if (iS2 == 125) {
                    if (i8 == 5) {
                        throw s1("Expected name");
                    }
                    this.f23268h = 2;
                    return 2;
                }
                q();
                this.f23264d--;
                if (!Q((char) iS2)) {
                    throw s1("Expected name");
                }
                this.f23268h = 14;
                return 14;
            }
            if (i8 == 4) {
                iArr[i7 - 1] = 5;
                int iS3 = s0(true);
                if (iS3 != 58) {
                    if (iS3 != 61) {
                        throw s1("Expected ':'");
                    }
                    q();
                    if (this.f23264d < this.f23265e || F(1)) {
                        char[] cArr = this.f23263c;
                        int i9 = this.f23264d;
                        if (cArr[i9] == '>') {
                            this.f23264d = i9 + 1;
                        }
                    }
                }
            } else if (i8 == 6) {
                if (this.f23262b) {
                    r();
                }
                this.f23272l[this.f23273m - 1] = 7;
            } else if (i8 == 7) {
                if (s0(false) == -1) {
                    this.f23268h = 17;
                    return 17;
                }
                q();
                this.f23264d--;
            } else if (i8 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iS4 = s0(true);
        if (iS4 == 34) {
            this.f23268h = 9;
            return 9;
        }
        if (iS4 == 39) {
            q();
            this.f23268h = 8;
            return 8;
        }
        if (iS4 != 44 && iS4 != 59) {
            if (iS4 == 91) {
                this.f23268h = 3;
                return 3;
            }
            if (iS4 != 93) {
                if (iS4 == 123) {
                    this.f23268h = 1;
                    return 1;
                }
                this.f23264d--;
                int iL0 = L0();
                if (iL0 != 0) {
                    return iL0;
                }
                int iQ0 = Q0();
                if (iQ0 != 0) {
                    return iQ0;
                }
                if (!Q(this.f23263c[this.f23264d])) {
                    throw s1("Expected value");
                }
                q();
                this.f23268h = 10;
                return 10;
            }
            if (i8 == 1) {
                this.f23268h = 4;
                return 4;
            }
        }
        if (i8 != 1 && i8 != 2) {
            throw s1("Unexpected value");
        }
        q();
        this.f23264d--;
        this.f23268h = 7;
        return 7;
    }

    public void v0() throws IOException {
        int iU = this.f23268h;
        if (iU == 0) {
            iU = u();
        }
        if (iU == 7) {
            this.f23268h = 0;
            int[] iArr = this.f23275o;
            int i7 = this.f23273m - 1;
            iArr[i7] = iArr[i7] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + J0() + g0());
    }
}
