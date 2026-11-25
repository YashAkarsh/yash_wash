package com.haier.library.okhttp.b.l;

import com.alibaba.fastjson.asm.j;
import javax.security.auth.x500.X500Principal;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f27398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f27401g;

    d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f27395a = name;
        this.f27396b = name.length();
    }

    private int a(int i7) {
        int i8;
        int i9;
        int i10 = i7 + 1;
        if (i10 >= this.f27396b) {
            throw new IllegalStateException("Malformed DN: " + this.f27395a);
        }
        char[] cArr = this.f27401g;
        char c8 = cArr[i7];
        if (c8 >= '0' && c8 <= '9') {
            i8 = c8 - '0';
        } else if (c8 >= 'a' && c8 <= 'f') {
            i8 = c8 - 'W';
        } else {
            if (c8 < 'A' || c8 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f27395a);
            }
            i8 = c8 - '7';
        }
        char c9 = cArr[i10];
        if (c9 >= '0' && c9 <= '9') {
            i9 = c9 - '0';
        } else if (c9 >= 'a' && c9 <= 'f') {
            i9 = c9 - 'W';
        } else {
            if (c9 < 'A' || c9 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f27395a);
            }
            i9 = c9 - '7';
        }
        return (i8 << 4) + i9;
    }

    private String b() {
        int i7;
        int i8;
        int i9;
        int i10;
        char c8;
        int i11;
        int i12;
        char c9;
        char c10;
        while (true) {
            i7 = this.f27397c;
            i8 = this.f27396b;
            if (i7 >= i8 || this.f27401g[i7] != ' ') {
                break;
            }
            this.f27397c = i7 + 1;
        }
        if (i7 == i8) {
            return null;
        }
        this.f27398d = i7;
        this.f27397c = i7 + 1;
        while (true) {
            i9 = this.f27397c;
            i10 = this.f27396b;
            if (i9 >= i10 || (c10 = this.f27401g[i9]) == '=' || c10 == ' ') {
                break;
            }
            this.f27397c = i9 + 1;
        }
        if (i9 >= i10) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
        }
        this.f27399e = i9;
        if (this.f27401g[i9] == ' ') {
            while (true) {
                i11 = this.f27397c;
                i12 = this.f27396b;
                if (i11 >= i12 || (c9 = this.f27401g[i11]) == '=' || c9 != ' ') {
                    break;
                }
                this.f27397c = i11 + 1;
            }
            if (this.f27401g[i11] != '=' || i11 == i12) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
            }
        }
        this.f27397c++;
        while (true) {
            int i13 = this.f27397c;
            if (i13 >= this.f27396b || this.f27401g[i13] != ' ') {
                break;
            }
            this.f27397c = i13 + 1;
        }
        int i14 = this.f27399e;
        int i15 = this.f27398d;
        if (i14 - i15 > 4) {
            char[] cArr = this.f27401g;
            if (cArr[i15 + 3] == '.' && (((c8 = cArr[i15]) == 'O' || c8 == 'o') && ((cArr[i15 + 1] == 'I' || cArr[i15 + 1] == 'i') && (cArr[i15 + 2] == 'D' || cArr[i15 + 2] == 'd')))) {
                this.f27398d = i15 + 4;
            }
        }
        char[] cArr2 = this.f27401g;
        int i16 = this.f27398d;
        return new String(cArr2, i16, i14 - i16);
    }

    private String d() {
        int i7 = this.f27397c + 1;
        this.f27397c = i7;
        this.f27398d = i7;
        this.f27399e = i7;
        while (true) {
            int i8 = this.f27397c;
            if (i8 == this.f27396b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
            }
            char[] cArr = this.f27401g;
            char c8 = cArr[i8];
            if (c8 == '\"') {
                this.f27397c = i8 + 1;
                while (true) {
                    int i9 = this.f27397c;
                    if (i9 >= this.f27396b || this.f27401g[i9] != ' ') {
                        break;
                    }
                    this.f27397c = i9 + 1;
                }
                char[] cArr2 = this.f27401g;
                int i10 = this.f27398d;
                return new String(cArr2, i10, this.f27399e - i10);
            }
            if (c8 == '\\') {
                cArr[this.f27399e] = g();
            } else {
                cArr[this.f27399e] = c8;
            }
            this.f27397c++;
            this.f27399e++;
        }
    }

    private String e() {
        char[] cArr;
        char c8;
        int i7 = this.f27397c;
        if (i7 + 4 >= this.f27396b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
        }
        this.f27398d = i7;
        this.f27397c = i7 + 1;
        while (true) {
            int i8 = this.f27397c;
            if (i8 == this.f27396b || (c8 = (cArr = this.f27401g)[i8]) == '+' || c8 == ',' || c8 == ';') {
                this.f27399e = i8;
                break;
            }
            if (c8 == ' ') {
                this.f27399e = i8;
                this.f27397c = i8 + 1;
                while (true) {
                    int i9 = this.f27397c;
                    if (i9 >= this.f27396b || this.f27401g[i9] != ' ') {
                        break;
                    }
                    this.f27397c = i9 + 1;
                }
            } else {
                if (c8 >= 'A' && c8 <= 'F') {
                    cArr[i8] = (char) (c8 + ' ');
                }
                this.f27397c = i8 + 1;
            }
        }
        int i10 = this.f27399e;
        int i11 = this.f27398d;
        int i12 = i10 - i11;
        if (i12 < 5 || (i12 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
        }
        int i13 = i12 / 2;
        byte[] bArr = new byte[i13];
        int i14 = i11 + 1;
        for (int i15 = 0; i15 < i13; i15++) {
            bArr[i15] = (byte) a(i14);
            i14 += 2;
        }
        return new String(this.f27401g, this.f27398d, i12);
    }

    private String f() {
        int i7;
        int i8;
        char c8;
        int i9 = this.f27397c;
        this.f27398d = i9;
        this.f27399e = i9;
        while (true) {
            int i10 = this.f27397c;
            if (i10 >= this.f27396b) {
                char[] cArr = this.f27401g;
                int i11 = this.f27398d;
                return new String(cArr, i11, this.f27399e - i11);
            }
            char[] cArr2 = this.f27401g;
            char c9 = cArr2[i10];
            if (c9 != ' ') {
                if (c9 != ';') {
                    if (c9 == '\\') {
                        int i12 = this.f27399e;
                        this.f27399e = i12 + 1;
                        cArr2[i12] = g();
                        this.f27397c++;
                    } else if (c9 != '+' && c9 != ',') {
                        int i13 = this.f27399e;
                        this.f27399e = i13 + 1;
                        cArr2[i13] = c9;
                        this.f27397c = i10 + 1;
                    }
                }
                int i14 = this.f27398d;
                return new String(cArr2, i14, this.f27399e - i14);
            }
            int i15 = this.f27399e;
            this.f27400f = i15;
            this.f27397c = i10 + 1;
            this.f27399e = i15 + 1;
            cArr2[i15] = ' ';
            while (true) {
                i7 = this.f27397c;
                i8 = this.f27396b;
                if (i7 >= i8) {
                    break;
                }
                char[] cArr3 = this.f27401g;
                if (cArr3[i7] != ' ') {
                    break;
                }
                int i16 = this.f27399e;
                this.f27399e = i16 + 1;
                cArr3[i16] = ' ';
                this.f27397c = i7 + 1;
            }
            if (i7 == i8 || (c8 = this.f27401g[i7]) == ',' || c8 == '+' || c8 == ';') {
                char[] cArr4 = this.f27401g;
                int i17 = this.f27398d;
                return new String(cArr4, i17, this.f27400f - i17);
            }
        }
    }

    private char g() {
        int i7 = this.f27397c + 1;
        this.f27397c = i7;
        if (i7 == this.f27396b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f27395a);
        }
        char c8 = this.f27401g[i7];
        if (c8 == ' ' || c8 == '%' || c8 == '\\' || c8 == '_' || c8 == '\"' || c8 == '#') {
            return c8;
        }
        switch (c8) {
            case '*':
            case '+':
            case ',':
                return c8;
            default:
                switch (c8) {
                    case ';':
                    case '<':
                    case b0.f36952q /* 61 */:
                    case '>':
                        return c8;
                    default:
                        return h();
                }
        }
    }

    private char h() {
        int i7;
        int i8;
        int iA = a(this.f27397c);
        this.f27397c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i7 = iA & 31;
            i8 = 1;
        } else if (iA <= 239) {
            i7 = iA & 15;
            i8 = 2;
        } else {
            i7 = iA & 7;
            i8 = 3;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = this.f27397c + 1;
            this.f27397c = i10;
            if (i10 == this.f27396b || this.f27401g[i10] != '\\') {
                return '?';
            }
            int i11 = i10 + 1;
            this.f27397c = i11;
            int iA2 = a(i11);
            this.f27397c++;
            if ((iA2 & j.f12606c0) != 128) {
                return '?';
            }
            i7 = (i7 << 6) + (iA2 & 63);
        }
        return (char) i7;
    }

    public String c(String str) {
        String strD;
        this.f27397c = 0;
        this.f27398d = 0;
        this.f27399e = 0;
        this.f27400f = 0;
        this.f27401g = this.f27395a.toCharArray();
        String strB = b();
        if (strB == null) {
            return null;
        }
        do {
            int i7 = this.f27397c;
            if (i7 == this.f27396b) {
                return null;
            }
            char c8 = this.f27401g[i7];
            if (c8 == '\"') {
                strD = d();
            } else if (c8 != '#') {
                strD = (c8 == '+' || c8 == ',' || c8 == ';') ? "" : f();
            } else {
                strD = e();
            }
            if (str.equalsIgnoreCase(strB)) {
                return strD;
            }
            int i8 = this.f27397c;
            if (i8 >= this.f27396b) {
                return null;
            }
            char c9 = this.f27401g[i8];
            if (c9 != ',' && c9 != ';' && c9 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f27395a);
            }
            this.f27397c = i8 + 1;
            strB = b();
        } while (strB != null);
        throw new IllegalStateException("Malformed DN: " + this.f27395a);
    }
}
