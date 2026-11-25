package com.alibaba.fastjson.parser;

import androidx.constraintlayout.widget.ConstraintLayout;
import easypay.appinvoke.manager.Constants;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.text.h0;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements d, Closeable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected static final long f12915r = -922337203685477580L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static final int f12916s = -214748364;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f12918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f12919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f12920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected char f12921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f12923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected char[] f12924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f12925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f12926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f12927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Calendar f12928k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected TimeZone f12929l = com.alibaba.fastjson.a.f12527a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Locale f12930m = com.alibaba.fastjson.a.f12528b;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12931n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f12932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ThreadLocal<char[]> f12913p = new ThreadLocal<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected static final char[] f12914q = ("\"" + com.alibaba.fastjson.a.f12529c + "\":\"").toCharArray();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final int[] f12917t = new int[Constants.ACTION_SUBMIT_BTN_USER_PWD_NB];

    static {
        for (int i7 = 48; i7 <= 57; i7++) {
            f12917t[i7] = i7 - 48;
        }
        for (int i8 = 97; i8 <= 102; i8++) {
            f12917t[i8] = (i8 - 97) + 10;
        }
        for (int i9 = 65; i9 <= 70; i9++) {
            f12917t[i9] = (i9 - 65) + 10;
        }
    }

    public e(int i7) {
        this.f12932o = null;
        this.f12920c = i7;
        if ((i7 & c.InitStringFieldAsEmpty.f12829a) != 0) {
            this.f12932o = "";
        }
        char[] cArr = f12913p.get();
        this.f12924g = cArr;
        if (cArr == null) {
            this.f12924g = new char[512];
        }
    }

    private void G2() {
        this.f12926i = this.f12922e;
        this.f12927j = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.f12918a = 4;
                next();
                return;
            }
            if (next == 26) {
                if (Z1()) {
                    throw new com.alibaba.fastjson.d("unclosed single-quote string");
                }
                j2((char) 26);
            } else if (next == '\\') {
                if (!this.f12927j) {
                    this.f12927j = true;
                    int i7 = this.f12925h;
                    char[] cArr = this.f12924g;
                    if (i7 > cArr.length) {
                        char[] cArr2 = new char[i7 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f12924g = cArr2;
                    }
                    s(this.f12926i + 1, this.f12925h, this.f12924g);
                }
                char next2 = next();
                if (next2 == '\"') {
                    j2(h0.f35376b);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            j2('\\');
                        } else if (next2 == 'b') {
                            j2('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                j2('\n');
                            } else if (next2 == 'r') {
                                j2(CharUtils.CR);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        j2('/');
                                        break;
                                    case ConstraintLayout.LayoutParams.a.W /* 48 */:
                                        j2((char) 0);
                                        break;
                                    case '1':
                                        j2((char) 1);
                                        break;
                                    case '2':
                                        j2((char) 2);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                                        j2((char) 3);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                                        j2((char) 4);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                                        j2((char) 5);
                                        break;
                                    case '6':
                                        j2((char) 6);
                                        break;
                                    case '7':
                                        j2((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                j2('\t');
                                                break;
                                            case 'u':
                                                j2((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                j2((char) 11);
                                                break;
                                            default:
                                                this.f12921d = next2;
                                                throw new com.alibaba.fastjson.d("unclosed single-quote string");
                                        }
                                        break;
                                }
                            } else {
                                int[] iArr = f12917t;
                                j2((char) ((iArr[next()] * 16) + iArr[next()]));
                            }
                        }
                    }
                    j2('\f');
                } else {
                    j2('\'');
                }
            } else if (this.f12927j) {
                int i8 = this.f12925h;
                char[] cArr3 = this.f12924g;
                if (i8 == cArr3.length) {
                    j2(next);
                } else {
                    this.f12925h = i8 + 1;
                    cArr3[i8] = next;
                }
            } else {
                this.f12925h++;
            }
        }
    }

    public static boolean b2(char c8) {
        return c8 <= ' ' && (c8 == ' ' || c8 == '\n' || c8 == '\r' || c8 == '\t' || c8 == '\f' || c8 == '\b');
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e8  */
    public static String k2(char[] cArr, int i7) {
        int i8;
        char[] cArr2 = new char[i7];
        int i9 = 0;
        int i10 = 0;
        while (i9 < i7) {
            char c8 = cArr[i9];
            if (c8 != '\\') {
                cArr2[i10] = c8;
                i10++;
            } else {
                i9++;
                char c9 = cArr[i9];
                if (c9 == '\"') {
                    i8 = i10 + 1;
                    cArr2[i10] = h0.f35376b;
                } else if (c9 == '\'') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\'';
                } else if (c9 == 'F') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\f';
                } else if (c9 == '\\') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\\';
                } else if (c9 == 'b') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\b';
                } else if (c9 == 'f') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\f';
                } else if (c9 == 'n') {
                    i8 = i10 + 1;
                    cArr2[i10] = '\n';
                } else if (c9 == 'r') {
                    i8 = i10 + 1;
                    cArr2[i10] = CharUtils.CR;
                } else if (c9 != 'x') {
                    switch (c9) {
                        case '/':
                            i8 = i10 + 1;
                            cArr2[i10] = '/';
                            break;
                        case ConstraintLayout.LayoutParams.a.W /* 48 */:
                            i8 = i10 + 1;
                            cArr2[i10] = 0;
                            break;
                        case '1':
                            i8 = i10 + 1;
                            cArr2[i10] = 1;
                            break;
                        case '2':
                            i8 = i10 + 1;
                            cArr2[i10] = 2;
                            break;
                        case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                            i8 = i10 + 1;
                            cArr2[i10] = 3;
                            break;
                        case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                            i8 = i10 + 1;
                            cArr2[i10] = 4;
                            break;
                        case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                            i8 = i10 + 1;
                            cArr2[i10] = 5;
                            break;
                        case '6':
                            i8 = i10 + 1;
                            cArr2[i10] = 6;
                            break;
                        case '7':
                            i8 = i10 + 1;
                            cArr2[i10] = 7;
                            break;
                        default:
                            switch (c9) {
                                case 't':
                                    i8 = i10 + 1;
                                    cArr2[i10] = '\t';
                                    break;
                                case 'u':
                                    i8 = i10 + 1;
                                    int i11 = i9 + 1;
                                    int i12 = i11 + 1;
                                    int i13 = i12 + 1;
                                    i9 = i13 + 1;
                                    cArr2[i10] = (char) Integer.parseInt(new String(new char[]{cArr[i11], cArr[i12], cArr[i13], cArr[i9]}), 16);
                                    break;
                                case 'v':
                                    i8 = i10 + 1;
                                    cArr2[i10] = 11;
                                    break;
                                default:
                                    throw new com.alibaba.fastjson.d("unclosed.str.lit");
                            }
                            break;
                    }
                } else {
                    i8 = i10 + 1;
                    int[] iArr = f12917t;
                    int i14 = i9 + 1;
                    int i15 = iArr[cArr[i14]] * 16;
                    i9 = i14 + 1;
                    cArr2[i10] = (char) (i15 + iArr[cArr[i9]]);
                }
                i10 = i8;
            }
            i9++;
        }
        return new String(cArr2, 0, i10);
    }

    @Override // com.alibaba.fastjson.parser.d
    public final String A1() {
        return h.a(this.f12918a);
    }

    public String[] A2(char[] cArr, int i7, k kVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.d
    public final Number B1(boolean z7) {
        char cM = m((this.f12926i + this.f12925h) - 1);
        try {
            if (cM == 'F') {
                return Float.valueOf(Float.parseFloat(R1()));
            }
            if (cM == 'D') {
                return Double.valueOf(Double.parseDouble(R1()));
            }
            return z7 ? h0() : Double.valueOf(W1());
        } catch (NumberFormatException e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage() + ", " + e());
        }
    }

    public long B2(char[] cArr) {
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i7 = length + 1;
        if (m(this.f12922e + length) != '\"') {
            this.f12931n = -1;
            return 0L;
        }
        long j7 = -3750763034362895579L;
        while (true) {
            int i8 = i7 + 1;
            char cM = m(this.f12922e + i7);
            if (cM == '\"') {
                int i9 = i8 + 1;
                char cM2 = m(this.f12922e + i8);
                if (cM2 == ',') {
                    int i10 = this.f12922e + i9;
                    this.f12922e = i10;
                    this.f12921d = m(i10);
                    this.f12931n = 3;
                    return j7;
                }
                if (cM2 != '}') {
                    this.f12931n = -1;
                    return 0L;
                }
                int i11 = i9 + 1;
                char cM3 = m(this.f12922e + i9);
                if (cM3 == ',') {
                    this.f12918a = 16;
                    int i12 = this.f12922e + i11;
                    this.f12922e = i12;
                    this.f12921d = m(i12);
                } else if (cM3 == ']') {
                    this.f12918a = 15;
                    int i13 = this.f12922e + i11;
                    this.f12922e = i13;
                    this.f12921d = m(i13);
                } else if (cM3 == '}') {
                    this.f12918a = 13;
                    int i14 = this.f12922e + i11;
                    this.f12922e = i14;
                    this.f12921d = m(i14);
                } else {
                    if (cM3 != 26) {
                        this.f12931n = -1;
                        return 0L;
                    }
                    this.f12918a = 20;
                    this.f12922e += i11 - 1;
                    this.f12921d = (char) 26;
                }
                this.f12931n = 4;
                return j7;
            }
            j7 = (j7 ^ ((long) cM)) * 1099511628211L;
            if (cM == '\\') {
                this.f12931n = -1;
                return 0L;
            }
            i7 = i8;
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public final float C(char c8) {
        int i7;
        int i8;
        char cM;
        long j7;
        int i9;
        int i10;
        float f8;
        this.f12931n = 0;
        char cM2 = m(this.f12922e + 0);
        boolean z7 = cM2 == '\"';
        if (z7) {
            cM2 = m(this.f12922e + 1);
            i7 = 2;
        } else {
            i7 = 1;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            cM2 = m(this.f12922e + i7);
            i7++;
        }
        if (cM2 < '0' || cM2 > '9') {
            if (cM2 != 'n' || m(this.f12922e + i7) != 'u' || m(this.f12922e + i7 + 1) != 'l' || m(this.f12922e + i7 + 2) != 'l') {
                this.f12931n = -1;
                return 0.0f;
            }
            this.f12931n = 5;
            int i11 = i7 + 3;
            int i12 = i11 + 1;
            char cM3 = m(this.f12922e + i11);
            if (z7 && cM3 == '\"') {
                cM3 = m(this.f12922e + i12);
                i12++;
            }
            while (cM3 != ',') {
                if (cM3 == ']') {
                    int i13 = this.f12922e + i12;
                    this.f12922e = i13;
                    this.f12921d = m(i13);
                    this.f12931n = 5;
                    this.f12918a = 15;
                    return 0.0f;
                }
                if (!b2(cM3)) {
                    this.f12931n = -1;
                    return 0.0f;
                }
                cM3 = m(this.f12922e + i12);
                i12++;
            }
            int i14 = this.f12922e + i12;
            this.f12922e = i14;
            this.f12921d = m(i14);
            this.f12931n = 5;
            this.f12918a = 16;
            return 0.0f;
        }
        long j8 = cM2 - '0';
        while (true) {
            i8 = i7 + 1;
            cM = m(this.f12922e + i7);
            if (cM < '0' || cM > '9') {
                break;
            }
            j8 = (j8 * 10) + ((long) (cM - '0'));
            i7 = i8;
        }
        if (cM == '.') {
            int i15 = i8 + 1;
            char cM4 = m(this.f12922e + i8);
            if (cM4 < '0' || cM4 > '9') {
                this.f12931n = -1;
                return 0.0f;
            }
            j8 = (j8 * 10) + ((long) (cM4 - '0'));
            j7 = 10;
            while (true) {
                i8 = i15 + 1;
                cM = m(this.f12922e + i15);
                if (cM < '0' || cM > '9') {
                    break;
                }
                j8 = (j8 * 10) + ((long) (cM - '0'));
                j7 *= 10;
                i15 = i8;
            }
        } else {
            j7 = 1;
        }
        boolean z9 = cM == 'e' || cM == 'E';
        if (z9) {
            int i16 = i8 + 1;
            char cM5 = m(this.f12922e + i8);
            if (cM5 == '+' || cM5 == '-') {
                int i17 = i16 + 1;
                cM = m(this.f12922e + i16);
                i8 = i17;
            } else {
                i8 = i16;
                cM = cM5;
            }
            while (cM >= '0' && cM <= '9') {
                int i18 = i8 + 1;
                cM = m(this.f12922e + i8);
                i8 = i18;
            }
        }
        if (!z7) {
            i9 = this.f12922e;
            i10 = ((i9 + i8) - i9) - 1;
        } else {
            if (cM != '\"') {
                this.f12931n = -1;
                return 0.0f;
            }
            int i19 = i8 + 1;
            cM = m(this.f12922e + i8);
            int i20 = this.f12922e;
            i9 = i20 + 1;
            i10 = ((i20 + i19) - i9) - 2;
            i8 = i19;
        }
        if (z9 || i10 >= 17) {
            f8 = Float.parseFloat(N2(i9, i10));
        } else {
            f8 = j8 / j7;
            if (z8) {
                f8 = -f8;
            }
        }
        if (cM != c8) {
            this.f12931n = -1;
            return f8;
        }
        int i21 = this.f12922e + i8;
        this.f12922e = i21;
        this.f12921d = m(i21);
        this.f12931n = 3;
        this.f12918a = 16;
        return f8;
    }

    public UUID C2(char[] cArr) {
        char cM;
        int i7;
        UUID uuid;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = cArr.length;
        int i21 = length + 1;
        char cM2 = m(this.f12922e + length);
        char c8 = 4;
        if (cM2 != '\"') {
            if (cM2 == 'n') {
                int i22 = i21 + 1;
                if (m(this.f12922e + i21) == 'u') {
                    int i23 = i22 + 1;
                    if (m(this.f12922e + i22) == 'l') {
                        int i24 = i23 + 1;
                        if (m(this.f12922e + i23) == 'l') {
                            cM = m(this.f12922e + i24);
                            i7 = i24 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.f12931n = -1;
            return null;
        }
        int iY1 = Y1(h0.f35376b, this.f12922e + cArr.length + 1);
        if (iY1 == -1) {
            throw new com.alibaba.fastjson.d("unclosed str");
        }
        int length2 = this.f12922e + cArr.length + 1;
        int i25 = iY1 - length2;
        char c9 = 'F';
        char c10 = 'f';
        char c11 = 'A';
        char c12 = '0';
        if (i25 == 36) {
            int i26 = 0;
            long j7 = 0;
            while (i26 < 8) {
                char cM3 = m(length2 + i26);
                if (cM3 < '0' || cM3 > '9') {
                    if (cM3 >= 'a' && cM3 <= 'f') {
                        i19 = cM3 - 'a';
                    } else {
                        if (cM3 < 'A' || cM3 > c9) {
                            this.f12931n = -2;
                            return null;
                        }
                        i19 = cM3 - 'A';
                    }
                    i20 = i19 + 10;
                } else {
                    i20 = cM3 - '0';
                }
                j7 = (j7 << 4) | ((long) i20);
                i26++;
                iY1 = iY1;
                c9 = 'F';
            }
            int i27 = iY1;
            int i28 = 9;
            int i29 = 13;
            while (i28 < i29) {
                char cM4 = m(length2 + i28);
                if (cM4 < '0' || cM4 > '9') {
                    if (cM4 >= 'a' && cM4 <= 'f') {
                        i17 = cM4 - 'a';
                    } else {
                        if (cM4 < c11 || cM4 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i17 = cM4 - 'A';
                    }
                    i18 = i17 + 10;
                } else {
                    i18 = cM4 - '0';
                }
                j7 = (j7 << c8) | ((long) i18);
                i28++;
                i29 = 13;
                c11 = 'A';
                c8 = 4;
            }
            long j8 = j7;
            for (int i30 = 14; i30 < 18; i30++) {
                char cM5 = m(length2 + i30);
                if (cM5 < '0' || cM5 > '9') {
                    if (cM5 >= 'a' && cM5 <= 'f') {
                        i15 = cM5 - 'a';
                    } else {
                        if (cM5 < 'A' || cM5 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i15 = cM5 - 'A';
                    }
                    i16 = i15 + 10;
                } else {
                    i16 = cM5 - '0';
                }
                j8 = (j8 << 4) | ((long) i16);
            }
            long j9 = 0;
            for (int i31 = 19; i31 < 23; i31++) {
                char cM6 = m(length2 + i31);
                if (cM6 < '0' || cM6 > '9') {
                    if (cM6 >= 'a' && cM6 <= 'f') {
                        i13 = cM6 - 'a';
                    } else {
                        if (cM6 < 'A' || cM6 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i13 = cM6 - 'A';
                    }
                    i14 = i13 + 10;
                } else {
                    i14 = cM6 - '0';
                }
                j9 = (j9 << 4) | ((long) i14);
            }
            int i32 = 24;
            long j10 = j9;
            int i33 = 36;
            while (i32 < i33) {
                char cM7 = m(length2 + i32);
                if (cM7 < c12 || cM7 > '9') {
                    if (cM7 >= 'a' && cM7 <= c10) {
                        i11 = cM7 - 'a';
                    } else {
                        if (cM7 < 'A' || cM7 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i11 = cM7 - 'A';
                    }
                    i12 = i11 + 10;
                } else {
                    i12 = cM7 - '0';
                }
                j10 = (j10 << 4) | ((long) i12);
                i32++;
                i21 = i21;
                i33 = 36;
                c12 = '0';
                c10 = 'f';
            }
            uuid = new UUID(j8, j10);
            int i34 = this.f12922e;
            int length3 = i21 + (i27 - ((cArr.length + i34) + 1)) + 1;
            i7 = length3 + 1;
            cM = m(i34 + length3);
        } else {
            if (i25 != 32) {
                this.f12931n = -1;
                return null;
            }
            long j11 = 0;
            for (int i35 = 0; i35 < 16; i35++) {
                char cM8 = m(length2 + i35);
                if (cM8 < '0' || cM8 > '9') {
                    if (cM8 >= 'a' && cM8 <= 'f') {
                        i9 = cM8 - 'a';
                    } else {
                        if (cM8 < 'A' || cM8 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i9 = cM8 - 'A';
                    }
                    i10 = i9 + 10;
                } else {
                    i10 = cM8 - '0';
                }
                j11 = (j11 << 4) | ((long) i10);
            }
            int i36 = 16;
            long j12 = 0;
            for (int i37 = 32; i36 < i37; i37 = 32) {
                char cM9 = m(length2 + i36);
                if (cM9 < '0' || cM9 > '9') {
                    if (cM9 >= 'a' && cM9 <= 'f') {
                        i8 = (cM9 - 'a') + 10;
                    } else {
                        if (cM9 < 'A' || cM9 > 'F') {
                            this.f12931n = -2;
                            return null;
                        }
                        i8 = (cM9 - 'A') + 10;
                    }
                    j12 = (j12 << 4) | ((long) i8);
                    i36++;
                } else {
                    i8 = cM9 - '0';
                }
                j12 = (j12 << 4) | ((long) i8);
                i36++;
            }
            uuid = new UUID(j11, j12);
            int i38 = this.f12922e;
            int length4 = i21 + (iY1 - ((cArr.length + i38) + 1)) + 1;
            i7 = length4 + 1;
            cM = m(i38 + length4);
        }
        if (cM == ',') {
            int i39 = this.f12922e + i7;
            this.f12922e = i39;
            this.f12921d = m(i39);
            this.f12931n = 3;
            return uuid;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return null;
        }
        int i40 = i7 + 1;
        char cM10 = m(this.f12922e + i7);
        if (cM10 == ',') {
            this.f12918a = 16;
            int i41 = this.f12922e + i40;
            this.f12922e = i41;
            this.f12921d = m(i41);
        } else if (cM10 == ']') {
            this.f12918a = 15;
            int i42 = this.f12922e + i40;
            this.f12922e = i42;
            this.f12921d = m(i42);
        } else if (cM10 == '}') {
            this.f12918a = 13;
            int i43 = this.f12922e + i40;
            this.f12922e = i43;
            this.f12921d = m(i43);
        } else {
            if (cM10 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12918a = 20;
            this.f12922e += i40 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return uuid;
    }

    public final void D2() {
        char next;
        if (this.f12921d != 'x') {
            throw new com.alibaba.fastjson.d("illegal state. " + this.f12921d);
        }
        next();
        if (this.f12921d != '\'') {
            throw new com.alibaba.fastjson.d("illegal state. " + this.f12921d);
        }
        this.f12926i = this.f12922e;
        next();
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f12925h++;
            }
        }
        if (next == '\'') {
            this.f12925h++;
            next();
            this.f12918a = 26;
        } else {
            throw new com.alibaba.fastjson.d("illegal state. " + next);
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void E() {
        this.f12925h = 0;
        while (true) {
            this.f12919b = this.f12922e;
            char c8 = this.f12921d;
            if (c8 == '/') {
                L2();
            } else {
                if (c8 == '\"') {
                    F();
                    return;
                }
                if (c8 == ',') {
                    next();
                    this.f12918a = 16;
                    return;
                }
                if (c8 >= '0' && c8 <= '9') {
                    K();
                    return;
                }
                if (c8 == '-') {
                    K();
                    return;
                }
                switch (c8) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (!G(c.AllowSingleQuotes)) {
                            throw new com.alibaba.fastjson.d("Feature.AllowSingleQuotes is false");
                        }
                        G2();
                        return;
                    case '(':
                        next();
                        this.f12918a = 10;
                        return;
                    case ')':
                        next();
                        this.f12918a = 11;
                        return;
                    case '+':
                        next();
                        K();
                        return;
                    case '.':
                        next();
                        this.f12918a = 25;
                        return;
                    case com.alibaba.fastjson.asm.j.f12628v /* 58 */:
                        next();
                        this.f12918a = 17;
                        return;
                    case ';':
                        next();
                        this.f12918a = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        E2();
                        return;
                    case '[':
                        next();
                        this.f12918a = 14;
                        return;
                    case ']':
                        next();
                        this.f12918a = 15;
                        return;
                    case 'f':
                        m2();
                        return;
                    case Constants.LOG_ERROR_OTP /* 110 */:
                        F2();
                        return;
                    case 't':
                        H2();
                        return;
                    case 'x':
                        D2();
                        return;
                    case '{':
                        next();
                        this.f12918a = 12;
                        return;
                    case '}':
                        next();
                        this.f12918a = 13;
                        return;
                    default:
                        if (Z1()) {
                            if (this.f12918a == 20) {
                                throw new com.alibaba.fastjson.d("EOF error");
                            }
                            this.f12918a = 20;
                            int i7 = this.f12923f;
                            this.f12922e = i7;
                            this.f12919b = i7;
                            return;
                        }
                        char c9 = this.f12921d;
                        if (c9 > 31 && c9 != 127) {
                            c2("illegal.char", String.valueOf((int) c9));
                            next();
                            return;
                        }
                        next();
                        break;
                        break;
                }
            }
        }
    }

    public final void E2() {
        this.f12926i = this.f12922e - 1;
        this.f12927j = false;
        do {
            this.f12925h++;
            next();
        } while (Character.isLetterOrDigit(this.f12921d));
        String strX0 = x0();
        if ("null".equalsIgnoreCase(strX0)) {
            this.f12918a = 8;
            return;
        }
        if ("new".equals(strX0)) {
            this.f12918a = 9;
            return;
        }
        if ("true".equals(strX0)) {
            this.f12918a = 6;
            return;
        }
        if (com.paytm.pgsdk.d.G.equals(strX0)) {
            this.f12918a = 7;
            return;
        }
        if ("undefined".equals(strX0)) {
            this.f12918a = 23;
            return;
        }
        if ("Set".equals(strX0)) {
            this.f12918a = 21;
        } else if ("TreeSet".equals(strX0)) {
            this.f12918a = 22;
        } else {
            this.f12918a = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void F() {
        this.f12926i = this.f12922e;
        this.f12927j = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.f12918a = 4;
                this.f12921d = next();
                return;
            }
            if (next == 26) {
                if (Z1()) {
                    throw new com.alibaba.fastjson.d("unclosed string : " + next);
                }
                j2((char) 26);
            } else if (next == '\\') {
                if (!this.f12927j) {
                    this.f12927j = true;
                    int i7 = this.f12925h;
                    char[] cArr = this.f12924g;
                    if (i7 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i7 <= length) {
                            i7 = length;
                        }
                        char[] cArr2 = new char[i7];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f12924g = cArr2;
                    }
                    s(this.f12926i + 1, this.f12925h, this.f12924g);
                }
                char next2 = next();
                if (next2 == '\"') {
                    j2(h0.f35376b);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            j2('\\');
                        } else if (next2 == 'b') {
                            j2('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                j2('\n');
                            } else if (next2 == 'r') {
                                j2(CharUtils.CR);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        j2('/');
                                        break;
                                    case ConstraintLayout.LayoutParams.a.W /* 48 */:
                                        j2((char) 0);
                                        break;
                                    case '1':
                                        j2((char) 1);
                                        break;
                                    case '2':
                                        j2((char) 2);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                                        j2((char) 3);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                                        j2((char) 4);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                                        j2((char) 5);
                                        break;
                                    case '6':
                                        j2((char) 6);
                                        break;
                                    case '7':
                                        j2((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                j2('\t');
                                                break;
                                            case 'u':
                                                j2((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                j2((char) 11);
                                                break;
                                            default:
                                                this.f12921d = next2;
                                                throw new com.alibaba.fastjson.d("unclosed string : " + next2);
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = f12917t;
                                j2((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    j2('\f');
                } else {
                    j2('\'');
                }
            } else if (this.f12927j) {
                int i8 = this.f12925h;
                char[] cArr3 = this.f12924g;
                if (i8 == cArr3.length) {
                    j2(next);
                } else {
                    this.f12925h = i8 + 1;
                    cArr3[i8] = next;
                }
            } else {
                this.f12925h++;
            }
        }
    }

    public final void F2() {
        if (this.f12921d != 'n') {
            throw new com.alibaba.fastjson.d("error parse null or new");
        }
        next();
        char c8 = this.f12921d;
        if (c8 != 'u') {
            if (c8 != 'e') {
                throw new com.alibaba.fastjson.d("error parse new");
            }
            next();
            if (this.f12921d != 'w') {
                throw new com.alibaba.fastjson.d("error parse new");
            }
            next();
            char c9 = this.f12921d;
            if (c9 != ' ' && c9 != ',' && c9 != '}' && c9 != ']' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != 26 && c9 != '\f' && c9 != '\b') {
                throw new com.alibaba.fastjson.d("scan new error");
            }
            this.f12918a = 9;
            return;
        }
        next();
        if (this.f12921d != 'l') {
            throw new com.alibaba.fastjson.d("error parse null");
        }
        next();
        if (this.f12921d != 'l') {
            throw new com.alibaba.fastjson.d("error parse null");
        }
        next();
        char c10 = this.f12921d;
        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && c10 != '\f' && c10 != '\b') {
            throw new com.alibaba.fastjson.d("scan null error");
        }
        this.f12918a = 8;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final boolean G(c cVar) {
        return isEnabled(cVar.f12829a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:19:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.d
    public final java.lang.Number G0() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.e.G0():java.lang.Number");
    }

    @Override // com.alibaba.fastjson.parser.d
    public final int H() {
        int i7;
        boolean z7;
        int i8 = 0;
        if (this.f12926i == -1) {
            this.f12926i = 0;
        }
        int i9 = this.f12926i;
        int i10 = this.f12925h + i9;
        if (m(i9) == '-') {
            i9++;
            i7 = Integer.MIN_VALUE;
            z7 = true;
        } else {
            i7 = -2147483647;
            z7 = false;
        }
        if (i9 < i10) {
            i8 = -(m(i9) - '0');
            i9++;
        }
        while (i9 < i10) {
            int i11 = i9 + 1;
            char cM = m(i9);
            if (cM == 'L' || cM == 'S' || cM == 'B') {
                i9 = i11;
                break;
            }
            int i12 = cM - '0';
            if (i8 < -214748364) {
                throw new NumberFormatException(R1());
            }
            int i13 = i8 * 10;
            if (i13 < i7 + i12) {
                throw new NumberFormatException(R1());
            }
            i8 = i13 - i12;
            i9 = i11;
        }
        if (!z7) {
            return -i8;
        }
        if (i9 > this.f12926i + 1) {
            return i8;
        }
        throw new NumberFormatException(R1());
    }

    public final void H2() {
        if (this.f12921d != 't') {
            throw new com.alibaba.fastjson.d("error parse true");
        }
        next();
        if (this.f12921d != 'r') {
            throw new com.alibaba.fastjson.d("error parse true");
        }
        next();
        if (this.f12921d != 'u') {
            throw new com.alibaba.fastjson.d("error parse true");
        }
        next();
        if (this.f12921d != 'e') {
            throw new com.alibaba.fastjson.d("error parse true");
        }
        next();
        char c8 = this.f12921d;
        if (c8 != ' ' && c8 != ',' && c8 != '}' && c8 != ']' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != 26 && c8 != '\f' && c8 != '\b' && c8 != ':' && c8 != '/') {
            throw new com.alibaba.fastjson.d("scan true error");
        }
        this.f12918a = 6;
    }

    @Override // com.alibaba.fastjson.parser.d
    public float I0() {
        char cCharAt;
        String strR1 = R1();
        float f8 = Float.parseFloat(strR1);
        if ((f8 != 0.0f && f8 != Float.POSITIVE_INFINITY) || (cCharAt = strR1.charAt(0)) <= '0' || cCharAt > '9') {
            return f8;
        }
        throw new com.alibaba.fastjson.d("float overflow : " + strR1);
    }

    public final int I2(String str) {
        this.f12931n = 0;
        char[] cArr = f12914q;
        if (!g(cArr)) {
            return -2;
        }
        int length = this.f12922e + cArr.length;
        int length2 = str.length();
        for (int i7 = 0; i7 < length2; i7++) {
            if (str.charAt(i7) != m(length + i7)) {
                return -1;
            }
        }
        int i8 = length + length2;
        if (m(i8) != '\"') {
            return -1;
        }
        int i9 = i8 + 1;
        char cM = m(i9);
        this.f12921d = cM;
        if (cM == ',') {
            int i10 = i9 + 1;
            this.f12921d = m(i10);
            this.f12922e = i10;
            this.f12918a = 16;
            return 3;
        }
        if (cM == '}') {
            i9++;
            char cM2 = m(i9);
            this.f12921d = cM2;
            if (cM2 == ',') {
                this.f12918a = 16;
                i9++;
                this.f12921d = m(i9);
            } else if (cM2 == ']') {
                this.f12918a = 15;
                i9++;
                this.f12921d = m(i9);
            } else if (cM2 == '}') {
                this.f12918a = 13;
                i9++;
                this.f12921d = m(i9);
            } else {
                if (cM2 != 26) {
                    return -1;
                }
                this.f12918a = 20;
            }
            this.f12931n = 4;
        }
        this.f12922e = i9;
        return this.f12931n;
    }

    @Override // com.alibaba.fastjson.parser.d
    public void J0(Collection<String> collection, char c8) {
        int i7;
        char cM;
        int i8;
        char cM2;
        this.f12931n = 0;
        char cM3 = m(this.f12922e + 0);
        char c9 = 'u';
        char c10 = 'l';
        if (cM3 == 'n' && m(this.f12922e + 1) == 'u' && m(this.f12922e + 1 + 1) == 'l' && m(this.f12922e + 1 + 2) == 'l' && m(this.f12922e + 1 + 3) == c8) {
            int i9 = this.f12922e + 5;
            this.f12922e = i9;
            this.f12921d = m(i9);
            this.f12931n = 5;
            return;
        }
        if (cM3 != '[') {
            this.f12931n = -1;
            return;
        }
        char cM4 = m(this.f12922e + 1);
        int i10 = 2;
        while (true) {
            if (cM4 == 'n' && m(this.f12922e + i10) == c9 && m(this.f12922e + i10 + 1) == c10 && m(this.f12922e + i10 + 2) == c10) {
                int i11 = i10 + 3;
                i7 = i11 + 1;
                cM = m(this.f12922e + i11);
                collection.add(null);
            } else {
                if (cM4 == ']' && collection.size() == 0) {
                    i8 = i10 + 1;
                    cM2 = m(this.f12922e + i10);
                    break;
                }
                if (cM4 != '\"') {
                    this.f12931n = -1;
                    return;
                }
                int i12 = this.f12922e + i10;
                int iY1 = Y1(h0.f35376b, i12);
                if (iY1 == -1) {
                    throw new com.alibaba.fastjson.d("unclosed str");
                }
                String strN2 = N2(this.f12922e + i10, iY1 - i12);
                if (strN2.indexOf(92) != -1) {
                    while (true) {
                        int i13 = 0;
                        for (int i14 = iY1 - 1; i14 >= 0 && m(i14) == '\\'; i14--) {
                            i13++;
                        }
                        if (i13 % 2 == 0) {
                            break;
                        } else {
                            iY1 = Y1(h0.f35376b, iY1 + 1);
                        }
                    }
                    int i15 = iY1 - i12;
                    strN2 = k2(O2(this.f12922e + i10, i15), i15);
                }
                int i16 = this.f12922e;
                int i17 = i10 + (iY1 - (i16 + i10)) + 1;
                i7 = i17 + 1;
                cM = m(i16 + i17);
                collection.add(strN2);
            }
            if (cM != ',') {
                if (cM == ']') {
                    i8 = i7 + 1;
                    cM2 = m(this.f12922e + i7);
                    break;
                } else {
                    this.f12931n = -1;
                    return;
                }
            }
            i10 = i7 + 1;
            cM4 = m(this.f12922e + i7);
            c9 = 'u';
            c10 = 'l';
        }
        if (cM2 != c8) {
            this.f12931n = -1;
            return;
        }
        int i18 = this.f12922e + i8;
        this.f12922e = i18;
        this.f12921d = m(i18);
        this.f12931n = 3;
    }

    public UUID J2(char c8) {
        char cM;
        int i7;
        UUID uuid;
        int i8;
        char c9;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        this.f12931n = 0;
        char cM2 = m(this.f12922e + 0);
        int i21 = 13;
        char c10 = 4;
        if (cM2 == '\"') {
            int iY1 = Y1(h0.f35376b, this.f12922e + 1);
            if (iY1 == -1) {
                throw new com.alibaba.fastjson.d("unclosed str");
            }
            int i22 = this.f12922e + 1;
            int i23 = iY1 - i22;
            char c11 = 'f';
            char c12 = '9';
            char c13 = 'A';
            char c14 = 'a';
            if (i23 == 36) {
                int i24 = 0;
                long j7 = 0;
                while (i24 < 8) {
                    char cM3 = m(i22 + i24);
                    if (cM3 < '0' || cM3 > '9') {
                        if (cM3 >= 'a' && cM3 <= c11) {
                            i19 = cM3 - 'a';
                        } else {
                            if (cM3 < 'A' || cM3 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i19 = cM3 - 'A';
                        }
                        i20 = i19 + 10;
                    } else {
                        i20 = cM3 - '0';
                    }
                    j7 = (j7 << 4) | ((long) i20);
                    i24++;
                    c11 = 'f';
                }
                int i25 = 9;
                while (i25 < i21) {
                    char cM4 = m(i22 + i25);
                    if (cM4 < '0' || cM4 > '9') {
                        if (cM4 >= 'a' && cM4 <= 'f') {
                            i17 = cM4 - 'a';
                        } else {
                            if (cM4 < c13 || cM4 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i17 = cM4 - 'A';
                        }
                        i18 = i17 + 10;
                    } else {
                        i18 = cM4 - '0';
                    }
                    j7 = (j7 << 4) | ((long) i18);
                    i25++;
                    i21 = 13;
                    c13 = 'A';
                }
                int i26 = 14;
                long j8 = j7;
                while (i26 < 18) {
                    char cM5 = m(i22 + i26);
                    if (cM5 < '0' || cM5 > '9') {
                        if (cM5 >= c14 && cM5 <= 'f') {
                            i15 = cM5 - 'a';
                        } else {
                            if (cM5 < 'A' || cM5 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i15 = cM5 - 'A';
                        }
                        i16 = i15 + 10;
                    } else {
                        i16 = cM5 - '0';
                    }
                    j8 = (j8 << c10) | ((long) i16);
                    i26++;
                    c14 = 'a';
                    c10 = 4;
                }
                long j9 = 0;
                for (int i27 = 19; i27 < 23; i27++) {
                    char cM6 = m(i22 + i27);
                    if (cM6 < '0' || cM6 > '9') {
                        if (cM6 >= 'a' && cM6 <= 'f') {
                            i13 = cM6 - 'a';
                        } else {
                            if (cM6 < 'A' || cM6 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i13 = cM6 - 'A';
                        }
                        i14 = i13 + 10;
                    } else {
                        i14 = cM6 - '0';
                    }
                    j9 = (j9 << 4) | ((long) i14);
                }
                int i28 = 24;
                long j10 = j9;
                int i29 = 36;
                while (i28 < i29) {
                    char cM7 = m(i22 + i28);
                    if (cM7 < '0' || cM7 > c12) {
                        if (cM7 >= 'a' && cM7 <= 'f') {
                            i11 = cM7 - 'a';
                        } else {
                            if (cM7 < 'A' || cM7 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i11 = cM7 - 'A';
                        }
                        i12 = i11 + 10;
                    } else {
                        i12 = cM7 - '0';
                    }
                    j10 = (j10 << 4) | ((long) i12);
                    i28++;
                    i29 = 36;
                    c12 = '9';
                }
                uuid = new UUID(j8, j10);
                int i30 = this.f12922e;
                int i31 = (iY1 - (i30 + 1)) + 1 + 1;
                i7 = i31 + 1;
                cM = m(i30 + i31);
            } else {
                if (i23 != 32) {
                    this.f12931n = -1;
                    return null;
                }
                long j11 = 0;
                for (int i32 = 0; i32 < 16; i32++) {
                    char cM8 = m(i22 + i32);
                    if (cM8 < '0' || cM8 > '9') {
                        if (cM8 >= 'a' && cM8 <= 'f') {
                            i9 = cM8 - 'a';
                        } else {
                            if (cM8 < 'A' || cM8 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i9 = cM8 - 'A';
                        }
                        i10 = i9 + 10;
                    } else {
                        i10 = cM8 - '0';
                    }
                    j11 = (j11 << 4) | ((long) i10);
                }
                int i33 = 16;
                long j12 = 0;
                for (int i34 = 32; i33 < i34; i34 = 32) {
                    char cM9 = m(i22 + i33);
                    if (cM9 < '0' || cM9 > '9') {
                        if (cM9 >= 'a' && cM9 <= 'f') {
                            i8 = (cM9 - 'a') + 10;
                        } else {
                            if (cM9 < 'A' || cM9 > 'F') {
                                this.f12931n = -2;
                                return null;
                            }
                            i8 = (cM9 - 'A') + 10;
                        }
                        c9 = 4;
                    } else {
                        i8 = cM9 - '0';
                        c9 = 4;
                    }
                    j12 = (j12 << c9) | ((long) i8);
                    i33++;
                }
                uuid = new UUID(j11, j12);
                int i35 = this.f12922e;
                int i36 = (iY1 - (i35 + 1)) + 1 + 1;
                i7 = i36 + 1;
                cM = m(i35 + i36);
            }
        } else {
            if (cM2 != 'n' || m(this.f12922e + 1) != 'u' || m(this.f12922e + 2) != 'l' || m(this.f12922e + 3) != 'l') {
                this.f12931n = -1;
                return null;
            }
            cM = m(this.f12922e + 4);
            i7 = 5;
            uuid = null;
        }
        if (cM == ',') {
            int i37 = this.f12922e + i7;
            this.f12922e = i37;
            this.f12921d = m(i37);
            this.f12931n = 3;
            return uuid;
        }
        if (cM != ']') {
            this.f12931n = -1;
            return null;
        }
        int i38 = i7 + 1;
        char cM10 = m(this.f12922e + i7);
        if (cM10 == ',') {
            this.f12918a = 16;
            int i39 = this.f12922e + i38;
            this.f12922e = i39;
            this.f12921d = m(i39);
        } else if (cM10 == ']') {
            this.f12918a = 15;
            int i40 = this.f12922e + i38;
            this.f12922e = i40;
            this.f12921d = m(i40);
        } else if (cM10 == '}') {
            this.f12918a = 13;
            int i41 = this.f12922e + i38;
            this.f12922e = i41;
            this.f12921d = m(i41);
        } else {
            if (cM10 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12918a = 20;
            this.f12922e += i38 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return uuid;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cb  */
    @Override // com.alibaba.fastjson.parser.d
    public final void K() {
        char c8;
        boolean z7;
        char c9;
        this.f12926i = this.f12922e;
        boolean z8 = true;
        if (this.f12921d == '-') {
            this.f12925h++;
            next();
        }
        while (true) {
            c8 = this.f12921d;
            if (c8 < '0' || c8 > '9') {
                break;
            }
            this.f12925h++;
            next();
        }
        if (c8 == '.') {
            this.f12925h++;
            next();
            while (true) {
                char c10 = this.f12921d;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.f12925h++;
                next();
            }
            z7 = true;
        } else {
            z7 = false;
        }
        char c11 = this.f12921d;
        if (c11 != 'L' && c11 != 'S' && c11 != 'B') {
            if (c11 == 'F' || c11 == 'D') {
                this.f12925h++;
                next();
            } else if (c11 == 'e' || c11 == 'E') {
                this.f12925h++;
                next();
                char c12 = this.f12921d;
                if (c12 == '+' || c12 == '-') {
                    this.f12925h++;
                    next();
                }
                while (true) {
                    c9 = this.f12921d;
                    if (c9 < '0' || c9 > '9') {
                        break;
                    }
                    this.f12925h++;
                    next();
                }
                if (c9 == 'D' || c9 == 'F') {
                    this.f12925h++;
                    next();
                }
            }
            if (z8) {
                this.f12918a = 3;
            } else {
                this.f12918a = 2;
            }
        }
        this.f12925h++;
        next();
        z8 = z7;
        if (z8) {
            this.f12918a = 3;
        } else {
            this.f12918a = 2;
        }
    }

    public void K2(int i7) {
        this.f12918a = i7;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final int L0() {
        return this.f12918a;
    }

    protected void L2() {
        char c8;
        next();
        char c9 = this.f12921d;
        if (c9 == '/') {
            do {
                next();
                c8 = this.f12921d;
                if (c8 == '\n') {
                    next();
                    return;
                }
            } while (c8 != 26);
            return;
        }
        if (c9 != '*') {
            throw new com.alibaba.fastjson.d("invalid comment");
        }
        next();
        while (true) {
            char c10 = this.f12921d;
            if (c10 == 26) {
                return;
            }
            if (c10 == '*') {
                next();
                if (this.f12921d == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    public final String M2() {
        return this.f12932o;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final boolean N1() {
        return this.f12925h == 4 && m(this.f12926i + 1) == '$' && m(this.f12926i + 2) == 'r' && m(this.f12926i + 3) == 'e' && m(this.f12926i + 4) == 'f';
    }

    public abstract String N2(int i7, int i8);

    protected abstract char[] O2(int i7, int i8);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:103:0x0073 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.d
    public final void Q(int i7) {
        this.f12925h = 0;
        while (true) {
            if (i7 == 2) {
                char c8 = this.f12921d;
                if (c8 >= '0' && c8 <= '9') {
                    this.f12919b = this.f12922e;
                    K();
                    return;
                }
                if (c8 == '\"') {
                    this.f12919b = this.f12922e;
                    F();
                    return;
                } else if (c8 == '[') {
                    this.f12918a = 14;
                    next();
                    return;
                } else if (c8 == '{') {
                    this.f12918a = 12;
                    next();
                    return;
                }
            } else if (i7 == 4) {
                char c9 = this.f12921d;
                if (c9 == '\"') {
                    this.f12919b = this.f12922e;
                    F();
                    return;
                }
                if (c9 >= '0' && c9 <= '9') {
                    this.f12919b = this.f12922e;
                    K();
                    return;
                } else if (c9 == '[') {
                    this.f12918a = 14;
                    next();
                    return;
                } else if (c9 == '{') {
                    this.f12918a = 12;
                    next();
                    return;
                }
            } else if (i7 == 12) {
                char c10 = this.f12921d;
                if (c10 == '{') {
                    this.f12918a = 12;
                    next();
                    return;
                } else if (c10 == '[') {
                    this.f12918a = 14;
                    next();
                    return;
                }
            } else {
                if (i7 == 18) {
                    h2();
                    return;
                }
                if (i7 != 20) {
                    switch (i7) {
                        case 14:
                            char c11 = this.f12921d;
                            if (c11 == '[') {
                                this.f12918a = 14;
                                next();
                            } else if (c11 == '{') {
                                this.f12918a = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.f12921d == ']') {
                                this.f12918a = 15;
                                next();
                            }
                            if (this.f12921d == 26) {
                                this.f12918a = 20;
                            }
                            break;
                        case 16:
                            char c12 = this.f12921d;
                            if (c12 == ',') {
                                this.f12918a = 16;
                                next();
                            } else if (c12 == '}') {
                                this.f12918a = 13;
                                next();
                            } else if (c12 == ']') {
                                this.f12918a = 15;
                                next();
                            } else if (c12 == 26) {
                                this.f12918a = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.f12921d == 26) {
                    this.f12918a = 20;
                    return;
                }
            }
            char c13 = this.f12921d;
            if (c13 != ' ' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != '\f' && c13 != '\b') {
                E();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public String Q0(char c8) {
        this.f12931n = 0;
        char cM = m(this.f12922e + 0);
        if (cM == 'n') {
            if (m(this.f12922e + 1) != 'u' || m(this.f12922e + 1 + 1) != 'l' || m(this.f12922e + 1 + 2) != 'l') {
                this.f12931n = -1;
                return null;
            }
            if (m(this.f12922e + 4) != c8) {
                this.f12931n = -1;
                return null;
            }
            int i7 = this.f12922e + 5;
            this.f12922e = i7;
            this.f12921d = m(i7);
            this.f12931n = 3;
            return null;
        }
        int i8 = 1;
        while (cM != '\"') {
            if (!b2(cM)) {
                this.f12931n = -1;
                return M2();
            }
            cM = m(this.f12922e + i8);
            i8++;
        }
        int i9 = this.f12922e + i8;
        int iY1 = Y1(h0.f35376b, i9);
        if (iY1 == -1) {
            throw new com.alibaba.fastjson.d("unclosed str");
        }
        String strN2 = N2(this.f12922e + i8, iY1 - i9);
        if (strN2.indexOf(92) != -1) {
            while (true) {
                int i10 = 0;
                for (int i11 = iY1 - 1; i11 >= 0 && m(i11) == '\\'; i11--) {
                    i10++;
                }
                if (i10 % 2 == 0) {
                    break;
                }
                iY1 = Y1(h0.f35376b, iY1 + 1);
            }
            int i12 = iY1 - i9;
            strN2 = k2(O2(this.f12922e + 1, i12), i12);
        }
        int i13 = i8 + (iY1 - i9) + 1;
        int i14 = i13 + 1;
        char cM2 = m(this.f12922e + i13);
        while (cM2 != c8) {
            if (!b2(cM2)) {
                this.f12931n = -1;
                return strN2;
            }
            cM2 = m(this.f12922e + i14);
            i14++;
        }
        int i15 = this.f12922e + i14;
        this.f12922e = i15;
        this.f12921d = m(i15);
        this.f12931n = 3;
        return strN2;
    }

    @Override // com.alibaba.fastjson.parser.d
    public abstract String R1();

    @Override // com.alibaba.fastjson.parser.d
    public final String T0(k kVar) {
        q1();
        char c8 = this.f12921d;
        if (c8 == '\"') {
            return g0(kVar, h0.f35376b);
        }
        if (c8 == '\'') {
            if (G(c.AllowSingleQuotes)) {
                return g0(kVar, '\'');
            }
            throw new com.alibaba.fastjson.d("syntax error");
        }
        if (c8 == '}') {
            next();
            this.f12918a = 13;
            return null;
        }
        if (c8 == ',') {
            next();
            this.f12918a = 16;
            return null;
        }
        if (c8 == 26) {
            this.f12918a = 20;
            return null;
        }
        if (G(c.AllowUnQuotedFieldNames)) {
            return s0(kVar);
        }
        throw new com.alibaba.fastjson.d("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.d
    public int V0() {
        return this.f12920c;
    }

    public double W1() {
        return Double.parseDouble(R1());
    }

    public Calendar X1() {
        return this.f12928k;
    }

    @Override // com.alibaba.fastjson.parser.d
    public void Y0(Locale locale) {
        this.f12930m = locale;
    }

    public abstract int Y1(char c8, int i7);

    public abstract boolean Z1();

    /* JADX WARN: Code duplicated, block: B:56:0x00ca A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00cc -> B:53:0x00ba). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.d
    public double a1(char r23) {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.e.a1(char):double");
    }

    public final boolean a2(int i7, int i8) {
        return ((this.f12920c & i8) == 0 && (i7 & i8) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final int b() {
        return this.f12919b;
    }

    public abstract String c(int i7, int i8, int i9, k kVar);

    protected void c2(String str, Object... objArr) {
        this.f12918a = 1;
    }

    @Override // com.alibaba.fastjson.parser.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.f12924g;
        if (cArr.length <= 8192) {
            f12913p.set(cArr);
        }
        this.f12924g = null;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final char d1() {
        return this.f12921d;
    }

    public final boolean d2(char[] cArr) {
        while (!g(cArr)) {
            if (!b2(this.f12921d)) {
                return false;
            }
            next();
        }
        int length = this.f12922e + cArr.length;
        this.f12922e = length;
        char cM = m(length);
        this.f12921d = cM;
        if (cM == '{') {
            next();
            this.f12918a = 12;
        } else if (cM == '[') {
            next();
            this.f12918a = 14;
        } else if (cM == 'S' && m(this.f12922e + 1) == 'e' && m(this.f12922e + 2) == 't' && m(this.f12922e + 3) == '[') {
            int i7 = this.f12922e + 3;
            this.f12922e = i7;
            this.f12921d = m(i7);
            this.f12918a = 21;
        } else {
            E();
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.d
    public String e() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.d
    public void e1(TimeZone timeZone) {
        this.f12929l = timeZone;
    }

    public boolean e2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    protected abstract void f(int i7, char[] cArr, int i8, int i9);

    public final int f2() {
        return this.f12931n;
    }

    protected abstract boolean g(char[] cArr);

    @Override // com.alibaba.fastjson.parser.d
    public final String g0(k kVar, char c8) {
        String strD;
        this.f12926i = this.f12922e;
        this.f12925h = 0;
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            char next = next();
            if (next == c8) {
                this.f12918a = 4;
                if (z7) {
                    strD = kVar.d(this.f12924g, 0, this.f12925h, i7);
                } else {
                    int i8 = this.f12926i;
                    strD = c(i8 == -1 ? 0 : i8 + 1, this.f12925h, i7, kVar);
                }
                this.f12925h = 0;
                next();
                return strD;
            }
            if (next == 26) {
                throw new com.alibaba.fastjson.d("unclosed.str");
            }
            if (next == '\\') {
                if (!z7) {
                    int i9 = this.f12925h;
                    char[] cArr = this.f12924g;
                    if (i9 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i9 <= length) {
                            i9 = length;
                        }
                        char[] cArr2 = new char[i9];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f12924g = cArr2;
                    }
                    f(this.f12926i + 1, this.f12924g, 0, this.f12925h);
                    z7 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i7 = (i7 * 31) + 34;
                    j2(h0.f35376b);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i7 = (i7 * 31) + 92;
                            j2('\\');
                        } else if (next2 == 'b') {
                            i7 = (i7 * 31) + 8;
                            j2('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i7 = (i7 * 31) + 10;
                                j2('\n');
                            } else if (next2 == 'r') {
                                i7 = (i7 * 31) + 13;
                                j2(CharUtils.CR);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i7 = (i7 * 31) + 47;
                                        j2('/');
                                        break;
                                    case ConstraintLayout.LayoutParams.a.W /* 48 */:
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 0);
                                        break;
                                    case '1':
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 1);
                                        break;
                                    case '2':
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 2);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 3);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 4);
                                        break;
                                    case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 5);
                                        break;
                                    case '6':
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 6);
                                        break;
                                    case '7':
                                        i7 = (i7 * 31) + next2;
                                        j2((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i7 = (i7 * 31) + 9;
                                                j2('\t');
                                                break;
                                            case 'u':
                                                int i10 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i7 = (i7 * 31) + i10;
                                                j2((char) i10);
                                                break;
                                            case 'v':
                                                i7 = (i7 * 31) + 11;
                                                j2((char) 11);
                                                break;
                                            default:
                                                this.f12921d = next2;
                                                throw new com.alibaba.fastjson.d("unclosed.str.lit");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                this.f12921d = next3;
                                char next4 = next();
                                this.f12921d = next4;
                                int[] iArr = f12917t;
                                char c9 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i7 = (i7 * 31) + c9;
                                j2(c9);
                            }
                        }
                    }
                    i7 = (i7 * 31) + 12;
                    j2('\f');
                } else {
                    i7 = (i7 * 31) + 39;
                    j2('\'');
                }
            } else {
                i7 = (i7 * 31) + next;
                if (z7) {
                    int i11 = this.f12925h;
                    char[] cArr3 = this.f12924g;
                    if (i11 == cArr3.length) {
                        j2(next);
                    } else {
                        this.f12925h = i11 + 1;
                        cArr3[i11] = next;
                    }
                } else {
                    this.f12925h++;
                }
            }
        }
    }

    public Collection<String> g2(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public Locale getLocale() {
        return this.f12930m;
    }

    @Override // com.alibaba.fastjson.parser.d
    public TimeZone getTimeZone() {
        return this.f12929l;
    }

    @Override // com.alibaba.fastjson.parser.d
    public abstract BigDecimal h0();

    public final void h2() {
        while (b2(this.f12921d)) {
            next();
        }
        char c8 = this.f12921d;
        if (c8 == '_' || c8 == '$' || Character.isLetter(c8)) {
            E2();
        } else {
            E();
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00b1 -> B:50:0x009f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.d
    public java.math.BigDecimal i1(char r19) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.e.i1(char):java.math.BigDecimal");
    }

    public final void i2(char c8) {
        this.f12925h = 0;
        while (true) {
            char c9 = this.f12921d;
            if (c9 == c8) {
                next();
                E();
                return;
            }
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                throw new com.alibaba.fastjson.d("not match " + c8 + " - " + this.f12921d + ", info : " + e());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.d
    public final boolean isEnabled(int i7) {
        return (i7 & this.f12920c) != 0;
    }

    protected final void j2(char c8) {
        int i7 = this.f12925h;
        char[] cArr = this.f12924g;
        if (i7 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f12924g = cArr2;
        }
        char[] cArr3 = this.f12924g;
        int i8 = this.f12925h;
        this.f12925h = i8 + 1;
        cArr3[i8] = c8;
    }

    @Override // com.alibaba.fastjson.parser.d
    public int l0(char c8) {
        int i7;
        int i8;
        char cM;
        this.f12931n = 0;
        char cM2 = m(this.f12922e + 0);
        boolean z7 = cM2 == '\"';
        if (z7) {
            cM2 = m(this.f12922e + 1);
            i7 = 2;
        } else {
            i7 = 1;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            cM2 = m(this.f12922e + i7);
            i7++;
        }
        if (cM2 >= '0' && cM2 <= '9') {
            int i9 = cM2 - '0';
            while (true) {
                i8 = i7 + 1;
                cM = m(this.f12922e + i7);
                if (cM < '0' || cM > '9') {
                    break;
                }
                i9 = (i9 * 10) + (cM - '0');
                i7 = i8;
            }
            if (cM == '.') {
                this.f12931n = -1;
                return 0;
            }
            if (i9 < 0) {
                this.f12931n = -1;
                return 0;
            }
            while (cM != c8) {
                if (!b2(cM)) {
                    this.f12931n = -1;
                    return z8 ? -i9 : i9;
                }
                char cM3 = m(this.f12922e + i8);
                i8++;
                cM = cM3;
            }
            int i10 = this.f12922e + i8;
            this.f12922e = i10;
            this.f12921d = m(i10);
            this.f12931n = 3;
            this.f12918a = 16;
            return z8 ? -i9 : i9;
        }
        if (cM2 != 'n' || m(this.f12922e + i7) != 'u' || m(this.f12922e + i7 + 1) != 'l' || m(this.f12922e + i7 + 2) != 'l') {
            this.f12931n = -1;
            return 0;
        }
        this.f12931n = 5;
        int i11 = i7 + 3;
        int i12 = i11 + 1;
        char cM4 = m(this.f12922e + i11);
        if (z7 && cM4 == '\"') {
            int i13 = i12 + 1;
            cM4 = m(this.f12922e + i12);
            i12 = i13;
        }
        while (cM4 != ',') {
            if (cM4 == ']') {
                int i14 = this.f12922e + i12;
                this.f12922e = i14;
                this.f12921d = m(i14);
                this.f12931n = 5;
                this.f12918a = 15;
                return 0;
            }
            if (!b2(cM4)) {
                this.f12931n = -1;
                return 0;
            }
            int i15 = i12 + 1;
            cM4 = m(this.f12922e + i12);
            i12 = i15;
        }
        int i16 = this.f12922e + i12;
        this.f12922e = i16;
        this.f12921d = m(i16);
        this.f12931n = 5;
        this.f12918a = 16;
        return 0;
    }

    public Date l2(char c8) {
        int i7;
        long j7;
        Date date;
        int i8;
        boolean z7 = false;
        this.f12931n = 0;
        char cM = m(this.f12922e + 0);
        if (cM == '\"') {
            int iY1 = Y1(h0.f35376b, this.f12922e + 1);
            if (iY1 == -1) {
                throw new com.alibaba.fastjson.d("unclosed str");
            }
            int i9 = this.f12922e + 1;
            String strN2 = N2(i9, iY1 - i9);
            if (strN2.indexOf(92) != -1) {
                while (true) {
                    int i10 = 0;
                    for (int i11 = iY1 - 1; i11 >= 0 && m(i11) == '\\'; i11--) {
                        i10++;
                    }
                    if (i10 % 2 == 0) {
                        break;
                    }
                    iY1 = Y1(h0.f35376b, iY1 + 1);
                }
                int i12 = this.f12922e;
                int i13 = iY1 - (i12 + 1);
                strN2 = k2(O2(i12 + 1, i13), i13);
            }
            int i14 = this.f12922e;
            int i15 = (iY1 - (i14 + 1)) + 1 + 1;
            i7 = i15 + 1;
            cM = m(i14 + i15);
            g gVar = new g(strN2);
            try {
                if (!gVar.T2(false)) {
                    this.f12931n = -1;
                    gVar.close();
                    return null;
                }
                date = gVar.X1().getTime();
                gVar.close();
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        } else {
            char c9 = '9';
            i7 = 2;
            if (cM == '-' || (cM >= '0' && cM <= '9')) {
                if (cM == '-') {
                    cM = m(this.f12922e + 1);
                    z7 = true;
                } else {
                    i7 = 1;
                }
                if (cM < '0' || cM > '9') {
                    j7 = 0;
                } else {
                    j7 = cM - '0';
                    while (true) {
                        i8 = i7 + 1;
                        cM = m(this.f12922e + i7);
                        if (cM < '0' || cM > c9) {
                            break;
                        }
                        j7 = (j7 * 10) + ((long) (cM - '0'));
                        i7 = i8;
                        c9 = '9';
                    }
                    i7 = i8;
                }
                if (j7 < 0) {
                    this.f12931n = -1;
                    return null;
                }
                if (z7) {
                    j7 = -j7;
                }
                date = new Date(j7);
            } else {
                if (cM != 'n' || m(this.f12922e + 1) != 'u' || m(this.f12922e + 1 + 1) != 'l' || m(this.f12922e + 1 + 2) != 'l') {
                    this.f12931n = -1;
                    return null;
                }
                i7 = 5;
                this.f12931n = 5;
                cM = m(this.f12922e + 4);
                date = null;
            }
        }
        if (cM == ',') {
            int i16 = this.f12922e + i7;
            this.f12922e = i16;
            this.f12921d = m(i16);
            this.f12931n = 3;
            this.f12918a = 16;
            return date;
        }
        if (cM != ']') {
            this.f12931n = -1;
            return null;
        }
        int i17 = i7 + 1;
        char cM2 = m(this.f12922e + i7);
        if (cM2 == ',') {
            this.f12918a = 16;
            int i18 = this.f12922e + i17;
            this.f12922e = i18;
            this.f12921d = m(i18);
        } else if (cM2 == ']') {
            this.f12918a = 15;
            int i19 = this.f12922e + i17;
            this.f12922e = i19;
            this.f12921d = m(i19);
        } else if (cM2 == '}') {
            this.f12918a = 13;
            int i20 = this.f12922e + i17;
            this.f12922e = i20;
            this.f12921d = m(i20);
        } else {
            if (cM2 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12918a = 20;
            this.f12922e += i17 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return date;
    }

    public abstract char m(int i7);

    public final void m2() {
        if (this.f12921d != 'f') {
            throw new com.alibaba.fastjson.d("error parse false");
        }
        next();
        if (this.f12921d != 'a') {
            throw new com.alibaba.fastjson.d("error parse false");
        }
        next();
        if (this.f12921d != 'l') {
            throw new com.alibaba.fastjson.d("error parse false");
        }
        next();
        if (this.f12921d != 's') {
            throw new com.alibaba.fastjson.d("error parse false");
        }
        next();
        if (this.f12921d != 'e') {
            throw new com.alibaba.fastjson.d("error parse false");
        }
        next();
        char c8 = this.f12921d;
        if (c8 != ' ' && c8 != ',' && c8 != '}' && c8 != ']' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != 26 && c8 != '\f' && c8 != '\b' && c8 != ':' && c8 != '/') {
            throw new com.alibaba.fastjson.d("scan false error");
        }
        this.f12918a = 7;
    }

    public BigInteger n2(char[] cArr) {
        int i7;
        char cM;
        int length;
        int i8;
        BigInteger bigIntegerValueOf;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length2 = cArr.length;
        int i9 = length2 + 1;
        char cM2 = m(this.f12922e + length2);
        boolean z7 = cM2 == '\"';
        if (z7) {
            cM2 = m(this.f12922e + i9);
            i9++;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            cM2 = m(this.f12922e + i9);
            i9++;
        }
        if (cM2 >= '0') {
            char c8 = '9';
            if (cM2 <= '9') {
                long j7 = cM2 - '0';
                while (true) {
                    i7 = i9 + 1;
                    cM = m(this.f12922e + i9);
                    if (cM < '0' || cM > c8) {
                        break;
                    }
                    j7 = (j7 * 10) + ((long) (cM - '0'));
                    i9 = i7;
                    c8 = '9';
                }
                if (!z7) {
                    int i10 = this.f12922e;
                    length = cArr.length + i10;
                    i8 = ((i10 + i7) - length) - 1;
                } else {
                    if (cM != '\"') {
                        this.f12931n = -1;
                        return null;
                    }
                    int i11 = i7 + 1;
                    cM = m(this.f12922e + i7);
                    int i12 = this.f12922e;
                    length = cArr.length + i12 + 1;
                    i8 = ((i12 + i11) - length) - 2;
                    i7 = i11;
                }
                if (i8 < 20 || (z8 && i8 < 21)) {
                    if (z8) {
                        j7 = -j7;
                    }
                    bigIntegerValueOf = BigInteger.valueOf(j7);
                } else {
                    bigIntegerValueOf = new BigInteger(N2(length, i8));
                }
                if (cM == ',') {
                    int i13 = this.f12922e + i7;
                    this.f12922e = i13;
                    this.f12921d = m(i13);
                    this.f12931n = 3;
                    this.f12918a = 16;
                    return bigIntegerValueOf;
                }
                if (cM != '}') {
                    this.f12931n = -1;
                    return null;
                }
                int i14 = i7 + 1;
                char cM3 = m(this.f12922e + i7);
                if (cM3 == ',') {
                    this.f12918a = 16;
                    int i15 = this.f12922e + i14;
                    this.f12922e = i15;
                    this.f12921d = m(i15);
                } else if (cM3 == ']') {
                    this.f12918a = 15;
                    int i16 = this.f12922e + i14;
                    this.f12922e = i16;
                    this.f12921d = m(i16);
                } else if (cM3 == '}') {
                    this.f12918a = 13;
                    int i17 = this.f12922e + i14;
                    this.f12922e = i17;
                    this.f12921d = m(i17);
                } else {
                    if (cM3 != 26) {
                        this.f12931n = -1;
                        return null;
                    }
                    this.f12918a = 20;
                    this.f12922e += i14 - 1;
                    this.f12921d = (char) 26;
                }
                this.f12931n = 4;
                return bigIntegerValueOf;
            }
        }
        if (cM2 != 'n' || m(this.f12922e + i9) != 'u' || m(this.f12922e + i9 + 1) != 'l' || m(this.f12922e + i9 + 2) != 'l') {
            this.f12931n = -1;
            return null;
        }
        this.f12931n = 5;
        int i18 = i9 + 3;
        int i19 = i18 + 1;
        char cM4 = m(this.f12922e + i18);
        if (z7 && cM4 == '\"') {
            cM4 = m(this.f12922e + i19);
            i19++;
        }
        while (cM4 != ',') {
            if (cM4 == '}') {
                int i20 = this.f12922e + i19;
                this.f12922e = i20;
                this.f12921d = m(i20);
                this.f12931n = 5;
                this.f12918a = 13;
                return null;
            }
            if (!b2(cM4)) {
                this.f12931n = -1;
                return null;
            }
            cM4 = m(this.f12922e + i19);
            i19++;
        }
        int i21 = this.f12922e + i19;
        this.f12922e = i21;
        this.f12921d = m(i21);
        this.f12931n = 5;
        this.f12918a = 16;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.d
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.d
    public abstract byte[] o0();

    public boolean o2(char[] cArr) {
        boolean z7;
        int i7;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return false;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char cM = m(this.f12922e + length);
        if (cM == 't') {
            int i9 = i8 + 1;
            if (m(this.f12922e + i8) != 'r') {
                this.f12931n = -1;
                return false;
            }
            int i10 = i9 + 1;
            if (m(this.f12922e + i9) != 'u') {
                this.f12931n = -1;
                return false;
            }
            i7 = i10 + 1;
            if (m(this.f12922e + i10) != 'e') {
                this.f12931n = -1;
                return false;
            }
            z7 = true;
        } else {
            if (cM != 'f') {
                this.f12931n = -1;
                return false;
            }
            int i11 = i8 + 1;
            if (m(this.f12922e + i8) != 'a') {
                this.f12931n = -1;
                return false;
            }
            int i12 = i11 + 1;
            if (m(this.f12922e + i11) != 'l') {
                this.f12931n = -1;
                return false;
            }
            int i13 = i12 + 1;
            if (m(this.f12922e + i12) != 's') {
                this.f12931n = -1;
                return false;
            }
            int i14 = i13 + 1;
            if (m(this.f12922e + i13) != 'e') {
                this.f12931n = -1;
                return false;
            }
            z7 = false;
            i7 = i14;
        }
        int i15 = i7 + 1;
        char cM2 = m(this.f12922e + i7);
        if (cM2 == ',') {
            int i16 = this.f12922e + i15;
            this.f12922e = i16;
            this.f12921d = m(i16);
            this.f12931n = 3;
            this.f12918a = 16;
            return z7;
        }
        if (cM2 != '}') {
            this.f12931n = -1;
            return false;
        }
        int i17 = i15 + 1;
        char cM3 = m(this.f12922e + i15);
        if (cM3 == ',') {
            this.f12918a = 16;
            int i18 = this.f12922e + i17;
            this.f12922e = i18;
            this.f12921d = m(i18);
        } else if (cM3 == ']') {
            this.f12918a = 15;
            int i19 = this.f12922e + i17;
            this.f12922e = i19;
            this.f12921d = m(i19);
        } else if (cM3 == '}') {
            this.f12918a = 13;
            int i20 = this.f12922e + i17;
            this.f12922e = i20;
            this.f12921d = m(i20);
        } else {
            if (cM3 != 26) {
                this.f12931n = -1;
                return false;
            }
            this.f12918a = 20;
            this.f12922e += i17 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return z7;
    }

    @Override // com.alibaba.fastjson.parser.d
    public String p0(k kVar, char c8) {
        int i7 = 0;
        this.f12931n = 0;
        char cM = m(this.f12922e + 0);
        if (cM == 'n') {
            if (m(this.f12922e + 1) != 'u' || m(this.f12922e + 1 + 1) != 'l' || m(this.f12922e + 1 + 2) != 'l') {
                this.f12931n = -1;
                return null;
            }
            if (m(this.f12922e + 4) != c8) {
                this.f12931n = -1;
                return null;
            }
            int i8 = this.f12922e + 5;
            this.f12922e = i8;
            this.f12921d = m(i8);
            this.f12931n = 3;
            return null;
        }
        if (cM != '\"') {
            this.f12931n = -1;
            return null;
        }
        int i9 = 1;
        while (true) {
            int i10 = i9 + 1;
            char cM2 = m(this.f12922e + i9);
            if (cM2 == '\"') {
                int i11 = this.f12922e;
                int i12 = i11 + 0 + 1;
                String strC = c(i12, ((i11 + i10) - i12) - 1, i7, kVar);
                int i13 = i10 + 1;
                char cM3 = m(this.f12922e + i10);
                while (cM3 != c8) {
                    if (!b2(cM3)) {
                        this.f12931n = -1;
                        return strC;
                    }
                    cM3 = m(this.f12922e + i13);
                    i13++;
                }
                int i14 = this.f12922e + i13;
                this.f12922e = i14;
                this.f12921d = m(i14);
                this.f12931n = 3;
                return strC;
            }
            i7 = (i7 * 31) + cM2;
            if (cM2 == '\\') {
                this.f12931n = -1;
                return null;
            }
            i9 = i10;
        }
    }

    public Date p2(char[] cArr) {
        int i7;
        long j7;
        Date date;
        int i8;
        char cM;
        boolean z7 = false;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        char cM2 = m(this.f12922e + length);
        if (cM2 == '\"') {
            int iY1 = Y1(h0.f35376b, this.f12922e + cArr.length + 1);
            if (iY1 == -1) {
                throw new com.alibaba.fastjson.d("unclosed str");
            }
            int length2 = this.f12922e + cArr.length + 1;
            String strN2 = N2(length2, iY1 - length2);
            if (strN2.indexOf(92) != -1) {
                while (true) {
                    int i10 = 0;
                    for (int i11 = iY1 - 1; i11 >= 0 && m(i11) == '\\'; i11--) {
                        i10++;
                    }
                    if (i10 % 2 == 0) {
                        break;
                    }
                    iY1 = Y1(h0.f35376b, iY1 + 1);
                }
                int i12 = this.f12922e;
                int length3 = iY1 - ((cArr.length + i12) + 1);
                strN2 = k2(O2(i12 + cArr.length + 1, length3), length3);
            }
            int i13 = this.f12922e;
            int length4 = i9 + (iY1 - ((cArr.length + i13) + 1)) + 1;
            i7 = length4 + 1;
            cM2 = m(i13 + length4);
            g gVar = new g(strN2);
            try {
                if (!gVar.T2(false)) {
                    this.f12931n = -1;
                    gVar.close();
                    return null;
                }
                date = gVar.X1().getTime();
                gVar.close();
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        } else {
            if (cM2 != '-' && (cM2 < '0' || cM2 > '9')) {
                this.f12931n = -1;
                return null;
            }
            if (cM2 == '-') {
                cM2 = m(this.f12922e + i9);
                i9++;
                z7 = true;
            }
            if (cM2 < '0' || cM2 > '9') {
                i7 = i9;
                j7 = 0;
            } else {
                j7 = cM2 - '0';
                while (true) {
                    i8 = i9 + 1;
                    cM = m(this.f12922e + i9);
                    if (cM < '0' || cM > '9') {
                        break;
                    }
                    j7 = (j7 * 10) + ((long) (cM - '0'));
                    i9 = i8;
                }
                cM2 = cM;
                i7 = i8;
            }
            if (j7 < 0) {
                this.f12931n = -1;
                return null;
            }
            if (z7) {
                j7 = -j7;
            }
            date = new Date(j7);
        }
        if (cM2 == ',') {
            int i14 = this.f12922e + i7;
            this.f12922e = i14;
            this.f12921d = m(i14);
            this.f12931n = 3;
            return date;
        }
        if (cM2 != '}') {
            this.f12931n = -1;
            return null;
        }
        int i15 = i7 + 1;
        char cM3 = m(this.f12922e + i7);
        if (cM3 == ',') {
            this.f12918a = 16;
            int i16 = this.f12922e + i15;
            this.f12922e = i16;
            this.f12921d = m(i16);
        } else if (cM3 == ']') {
            this.f12918a = 15;
            int i17 = this.f12922e + i15;
            this.f12922e = i17;
            this.f12921d = m(i17);
        } else if (cM3 == '}') {
            this.f12918a = 13;
            int i18 = this.f12922e + i15;
            this.f12922e = i18;
            this.f12921d = m(i18);
        } else {
            if (cM3 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12918a = 20;
            this.f12922e += i15 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return date;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    /* JADX WARN: Code duplicated, block: B:32:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.d
    public final long q() throws NumberFormatException {
        long j7;
        long j8;
        int i7;
        char cM;
        boolean z7 = false;
        if (this.f12926i == -1) {
            this.f12926i = 0;
        }
        int i8 = this.f12926i;
        int i9 = this.f12925h + i8;
        if (m(i8) == '-') {
            i8++;
            j7 = Long.MIN_VALUE;
            z7 = true;
        } else {
            j7 = -9223372036854775807L;
        }
        if (i8 >= i9) {
            j8 = 0;
            if (i8 < i9) {
                i7 = i8 + 1;
                cM = m(i8);
                if (cM != 'L' || cM == 'S' || cM == 'B') {
                    i8 = i7;
                } else {
                    int i10 = cM - '0';
                    if (j8 < -922337203685477580L) {
                        throw new NumberFormatException(R1());
                    }
                    long j9 = j8 * 10;
                    long j10 = i10;
                    if (j9 < j7 + j10) {
                        throw new NumberFormatException(R1());
                    }
                    j8 = j9 - j10;
                }
            }
            if (z7) {
                return -j8;
            }
            if (i8 > this.f12926i + 1) {
                return j8;
            }
            throw new NumberFormatException(R1());
        }
        i7 = i8 + 1;
        j8 = -(m(i8) - '0');
        i8 = i7;
        if (i8 < i9) {
            i7 = i8 + 1;
            cM = m(i8);
            if (cM != 'L') {
            }
            i8 = i7;
        }
        if (z7) {
            return -j8;
        }
        if (i8 > this.f12926i + 1) {
            return j8;
        }
        throw new NumberFormatException(R1());
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void q1() {
        while (true) {
            char c8 = this.f12921d;
            if (c8 > '/') {
                return;
            }
            if (c8 == ' ' || c8 == '\r' || c8 == '\n' || c8 == '\t' || c8 == '\f' || c8 == '\b') {
                next();
            } else if (c8 != '/') {
                return;
            } else {
                L2();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00be -> B:52:0x00ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public java.math.BigDecimal q2(char[] r19) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.e.q2(char[]):java.math.BigDecimal");
    }

    @Override // com.alibaba.fastjson.parser.d
    public Enum<?> r(Class<?> cls, k kVar, char c8) {
        String strP0 = p0(kVar, c8);
        if (strP0 == null) {
            return null;
        }
        return Enum.valueOf(cls, strP0);
    }

    @Override // com.alibaba.fastjson.parser.d
    public void r0(c cVar, boolean z7) {
        int iA = c.a(this.f12920c, cVar, z7);
        this.f12920c = iA;
        if ((iA & c.InitStringFieldAsEmpty.f12829a) != 0) {
            this.f12932o = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00dc -> B:55:0x00c8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final double r2(char[] r22) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.e.r2(char[]):double");
    }

    protected abstract void s(int i7, int i8, char[] cArr);

    @Override // com.alibaba.fastjson.parser.d
    public final String s0(k kVar) {
        if (this.f12918a == 1 && this.f12919b == 0 && this.f12922e == 1) {
            this.f12922e = 0;
        }
        boolean[] zArr = com.alibaba.fastjson.util.f.f13320g;
        int i7 = this.f12921d;
        if (!(i7 >= zArr.length || zArr[i7])) {
            throw new com.alibaba.fastjson.d("illegal identifier : " + this.f12921d + e());
        }
        boolean[] zArr2 = com.alibaba.fastjson.util.f.f13321h;
        this.f12926i = this.f12922e;
        this.f12925h = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i7 = (i7 * 31) + next;
            this.f12925h++;
        }
        this.f12921d = m(this.f12922e);
        this.f12918a = 18;
        if (this.f12925h == 4 && i7 == 3392903 && m(this.f12926i) == 'n' && m(this.f12926i + 1) == 'u' && m(this.f12926i + 2) == 'l' && m(this.f12926i + 3) == 'l') {
            return null;
        }
        return kVar == null ? N2(this.f12926i, this.f12925h) : c(this.f12926i, this.f12925h, i7, kVar);
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void s1() {
        this.f12925h = 0;
    }

    public final float s2(char[] cArr) {
        int i7;
        char cM;
        int i8;
        int length;
        int i9;
        float f8;
        char cM2;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i10 = length2 + 1;
        char cM3 = m(this.f12922e + length2);
        boolean z7 = cM3 == '\"';
        if (z7) {
            cM3 = m(this.f12922e + i10);
            i10++;
        }
        boolean z8 = cM3 == '-';
        if (z8) {
            cM3 = m(this.f12922e + i10);
            i10++;
        }
        if (cM3 < '0' || cM3 > '9') {
            if (cM3 != 'n' || m(this.f12922e + i10) != 'u' || m(this.f12922e + i10 + 1) != 'l' || m(this.f12922e + i10 + 2) != 'l') {
                this.f12931n = -1;
                return 0.0f;
            }
            this.f12931n = 5;
            int i11 = i10 + 3;
            int i12 = i11 + 1;
            char cM4 = m(this.f12922e + i11);
            if (z7 && cM4 == '\"') {
                cM4 = m(this.f12922e + i12);
                i12++;
            }
            while (cM4 != ',') {
                if (cM4 == '}') {
                    int i13 = this.f12922e + i12;
                    this.f12922e = i13;
                    this.f12921d = m(i13);
                    this.f12931n = 5;
                    this.f12918a = 13;
                    return 0.0f;
                }
                if (!b2(cM4)) {
                    this.f12931n = -1;
                    return 0.0f;
                }
                cM4 = m(this.f12922e + i12);
                i12++;
            }
            int i14 = this.f12922e + i12;
            this.f12922e = i14;
            this.f12921d = m(i14);
            this.f12931n = 5;
            this.f12918a = 16;
            return 0.0f;
        }
        int i15 = cM3 - '0';
        while (true) {
            i7 = i10 + 1;
            cM = m(this.f12922e + i10);
            if (cM < '0' || cM > '9') {
                break;
            }
            i15 = (i15 * 10) + (cM - '0');
            i10 = i7;
        }
        if (cM == '.') {
            int i16 = i7 + 1;
            char cM5 = m(this.f12922e + i7);
            if (cM5 < '0' || cM5 > '9') {
                this.f12931n = -1;
                return 0.0f;
            }
            i15 = (i15 * 10) + (cM5 - '0');
            int i17 = 10;
            while (true) {
                i7 = i16 + 1;
                cM2 = m(this.f12922e + i16);
                if (cM2 < '0' || cM2 > '9') {
                    break;
                }
                i15 = (i15 * 10) + (cM2 - '0');
                i17 *= 10;
                i16 = i7;
            }
            i8 = i17;
            cM = cM2;
        } else {
            i8 = 1;
        }
        boolean z9 = cM == 'e' || cM == 'E';
        if (z9) {
            int i18 = i7 + 1;
            cM = m(this.f12922e + i7);
            if (cM == '+' || cM == '-') {
                int i19 = i18 + 1;
                cM = m(this.f12922e + i18);
                i7 = i19;
            } else {
                i7 = i18;
            }
            while (cM >= '0' && cM <= '9') {
                int i20 = i7 + 1;
                cM = m(this.f12922e + i7);
                i7 = i20;
            }
        }
        if (!z7) {
            int i21 = this.f12922e;
            length = cArr.length + i21;
            i9 = ((i21 + i7) - length) - 1;
        } else {
            if (cM != '\"') {
                this.f12931n = -1;
                return 0.0f;
            }
            int i22 = i7 + 1;
            char cM6 = m(this.f12922e + i7);
            int i23 = this.f12922e;
            length = cArr.length + i23 + 1;
            i9 = ((i23 + i22) - length) - 2;
            i7 = i22;
            cM = cM6;
        }
        if (z9 || i9 >= 17) {
            f8 = Float.parseFloat(N2(length, i9));
        } else {
            f8 = i15 / i8;
            if (z8) {
                f8 = -f8;
            }
        }
        if (cM == ',') {
            int i24 = this.f12922e + i7;
            this.f12922e = i24;
            this.f12921d = m(i24);
            this.f12931n = 3;
            this.f12918a = 16;
            return f8;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return 0.0f;
        }
        int i25 = i7 + 1;
        char cM7 = m(this.f12922e + i7);
        if (cM7 == ',') {
            this.f12918a = 16;
            int i26 = this.f12922e + i25;
            this.f12922e = i26;
            this.f12921d = m(i26);
        } else if (cM7 == ']') {
            this.f12918a = 15;
            int i27 = this.f12922e + i25;
            this.f12922e = i27;
            this.f12921d = m(i27);
        } else if (cM7 == '}') {
            this.f12918a = 13;
            int i28 = this.f12922e + i25;
            this.f12922e = i28;
            this.f12921d = m(i28);
        } else {
            if (cM7 != 26) {
                this.f12931n = -1;
                return 0.0f;
            }
            this.f12922e += i25 - 1;
            this.f12918a = 20;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return f8;
    }

    public final float[] t2(char[] cArr) {
        int i7;
        char cM;
        int i8;
        float f8;
        float[] fArr;
        char c8;
        boolean z7;
        char cM2;
        boolean z8 = false;
        this.f12931n = 0;
        float[] fArr2 = null;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        if (m(this.f12922e + length) != '[') {
            this.f12931n = -2;
            return null;
        }
        int i10 = i9 + 1;
        char cM3 = m(this.f12922e + i9);
        float[] fArr3 = new float[16];
        int i11 = 0;
        while (true) {
            int i12 = this.f12922e;
            int i13 = (i12 + i10) - 1;
            boolean z9 = cM3 == '-' ? true : z8;
            if (z9) {
                int i14 = i10 + 1;
                char cM4 = m(i12 + i10);
                i10 = i14;
                cM3 = cM4;
            }
            if (cM3 < '0' || cM3 > '9') {
                break;
            }
            int i15 = cM3 - '0';
            while (true) {
                i7 = i10 + 1;
                cM = m(this.f12922e + i10);
                if (cM < '0' || cM > '9') {
                    break;
                }
                i15 = (i15 * 10) + (cM - '0');
                i10 = i7;
            }
            if (cM == '.' ? true : z8) {
                int i16 = i7 + 1;
                char cM5 = m(this.f12922e + i7);
                if (cM5 < '0' || cM5 > '9') {
                    this.f12931n = -1;
                    return fArr2;
                }
                i15 = (i15 * 10) + (cM5 - '0');
                int i17 = 10;
                while (true) {
                    i7 = i16 + 1;
                    cM2 = m(this.f12922e + i16);
                    if (cM2 < '0' || cM2 > '9') {
                        break;
                    }
                    i15 = (i15 * 10) + (cM2 - '0');
                    i17 *= 10;
                    i16 = i7;
                }
                int i18 = i17;
                cM = cM2;
                i8 = i18;
            } else {
                i8 = 1;
            }
            boolean z10 = cM == 'e' || cM == 'E';
            if (z10) {
                int i19 = i7 + 1;
                cM = m(this.f12922e + i7);
                if (cM == '+' || cM == '-') {
                    int i20 = i19 + 1;
                    cM = m(this.f12922e + i19);
                    i7 = i20;
                } else {
                    i7 = i19;
                }
                while (cM >= '0' && cM <= '9') {
                    int i21 = i7 + 1;
                    cM = m(this.f12922e + i7);
                    i7 = i21;
                }
            }
            int i22 = ((this.f12922e + i7) - i13) - 1;
            if (z10 || i22 >= 10) {
                f8 = Float.parseFloat(N2(i13, i22));
            } else {
                f8 = i15 / i8;
                if (z9) {
                    f8 = -f8;
                }
            }
            if (i11 >= fArr3.length) {
                float[] fArr4 = new float[(fArr3.length * 3) / 2];
                System.arraycopy(fArr3, 0, fArr4, 0, i11);
                fArr3 = fArr4;
            }
            int i23 = i11 + 1;
            fArr3[i11] = f8;
            if (cM == ',') {
                i10 = i7 + 1;
                c8 = 16;
                z7 = false;
                cM3 = m(this.f12922e + i7);
                fArr = null;
            } else {
                if (cM == ']') {
                    int i24 = i7 + 1;
                    char cM6 = m(this.f12922e + i7);
                    if (i23 != fArr3.length) {
                        float[] fArr5 = new float[i23];
                        System.arraycopy(fArr3, 0, fArr5, 0, i23);
                        fArr3 = fArr5;
                    }
                    if (cM6 == ',') {
                        this.f12922e += i24 - 1;
                        next();
                        this.f12931n = 3;
                        this.f12918a = 16;
                        return fArr3;
                    }
                    if (cM6 != '}') {
                        this.f12931n = -1;
                        return null;
                    }
                    int i25 = i24 + 1;
                    char cM7 = m(this.f12922e + i24);
                    if (cM7 == ',') {
                        this.f12918a = 16;
                        this.f12922e += i25 - 1;
                        next();
                    } else if (cM7 == ']') {
                        this.f12918a = 15;
                        this.f12922e += i25 - 1;
                        next();
                    } else if (cM7 == '}') {
                        this.f12918a = 13;
                        this.f12922e += i25 - 1;
                        next();
                    } else {
                        if (cM7 != 26) {
                            this.f12931n = -1;
                            return null;
                        }
                        this.f12922e += i25 - 1;
                        this.f12918a = 20;
                        this.f12921d = (char) 26;
                    }
                    this.f12931n = 4;
                    return fArr3;
                }
                fArr = null;
                c8 = 16;
                z7 = false;
                cM3 = cM;
                i10 = i7;
            }
            i11 = i23;
            fArr2 = fArr;
            z8 = z7;
        }
        float[] fArr6 = fArr2;
        this.f12931n = -1;
        return fArr6;
    }

    @Override // com.alibaba.fastjson.parser.d
    public boolean u() {
        int i7 = 0;
        while (true) {
            char cM = m(i7);
            if (cM == 26) {
                this.f12918a = 20;
                return true;
            }
            if (!b2(cM)) {
                return false;
            }
            i7++;
        }
    }

    public final float[][] u2(char[] cArr) {
        int i7;
        char cM;
        int i8;
        float f8;
        int i9;
        int i10;
        float[][] fArr;
        int i11;
        char c8;
        float[][] fArr2;
        int i12;
        char cM2;
        int i13 = 0;
        this.f12931n = 0;
        float[][] fArr3 = null;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = cArr.length;
        int i14 = length + 1;
        char c9 = '[';
        if (m(this.f12922e + length) != '[') {
            this.f12931n = -2;
            return null;
        }
        int i15 = i14 + 1;
        char cM3 = m(this.f12922e + i14);
        int i16 = 16;
        float[][] fArr4 = new float[16][];
        int i17 = 0;
        loop0: while (true) {
            if (cM3 == c9) {
                int i18 = i15 + 1;
                char cM4 = m(this.f12922e + i15);
                float[] fArr5 = new float[i16];
                int i19 = i13;
                while (true) {
                    int i20 = this.f12922e;
                    int i21 = (i20 + i18) - 1;
                    int i22 = cM4 == '-' ? 1 : i13;
                    if (i22 != 0) {
                        int i23 = i18 + 1;
                        char cM5 = m(i20 + i18);
                        i18 = i23;
                        cM4 = cM5;
                    }
                    if (cM4 < '0' || cM4 > '9') {
                        break loop0;
                    }
                    int i24 = cM4 - '0';
                    while (true) {
                        i7 = i18 + 1;
                        cM = m(this.f12922e + i18);
                        if (cM < '0' || cM > '9') {
                            break;
                        }
                        i24 = (i24 * 10) + (cM - '0');
                        i18 = i7;
                    }
                    if (cM == '.') {
                        int i25 = i7 + 1;
                        char cM6 = m(this.f12922e + i7);
                        if (cM6 < '0' || cM6 > '9') {
                            this.f12931n = -1;
                            return fArr3;
                        }
                        i24 = (i24 * 10) + (cM6 - '0');
                        int i26 = 10;
                        while (true) {
                            i7 = i25 + 1;
                            cM2 = m(this.f12922e + i25);
                            if (cM2 < '0' || cM2 > '9') {
                                break;
                            }
                            i24 = (i24 * 10) + (cM2 - '0');
                            i26 *= 10;
                            i25 = i7;
                        }
                        i8 = i26;
                        cM = cM2;
                    } else {
                        i8 = 1;
                    }
                    boolean z7 = cM == 'e' || cM == 'E';
                    if (z7) {
                        int i27 = i7 + 1;
                        cM = m(this.f12922e + i7);
                        if (cM == '+' || cM == '-') {
                            int i28 = i27 + 1;
                            cM = m(this.f12922e + i27);
                            i7 = i28;
                        } else {
                            i7 = i27;
                        }
                        while (cM >= '0' && cM <= '9') {
                            int i29 = i7 + 1;
                            cM = m(this.f12922e + i7);
                            i7 = i29;
                        }
                    }
                    int i30 = ((this.f12922e + i7) - i21) - 1;
                    if (z7 || i30 >= 10) {
                        f8 = Float.parseFloat(N2(i21, i30));
                    } else {
                        f8 = i24 / i8;
                        if (i22 != 0) {
                            f8 = -f8;
                        }
                    }
                    if (i19 >= fArr5.length) {
                        float[] fArr6 = new float[(fArr5.length * 3) / 2];
                        System.arraycopy(fArr5, 0, fArr6, 0, i19);
                        fArr5 = fArr6;
                    }
                    int i31 = i19 + 1;
                    fArr5[i19] = f8;
                    if (cM == ',') {
                        i18 = i7 + 1;
                        c8 = 16;
                        fArr2 = null;
                        i12 = 0;
                        cM4 = m(this.f12922e + i7);
                    } else {
                        if (cM == ']') {
                            int i32 = i7 + 1;
                            char cM7 = m(this.f12922e + i7);
                            if (i31 != fArr5.length) {
                                float[] fArr7 = new float[i31];
                                i9 = 0;
                                System.arraycopy(fArr5, 0, fArr7, 0, i31);
                                fArr5 = fArr7;
                            } else {
                                i9 = 0;
                            }
                            if (i17 >= fArr4.length) {
                                fArr4 = new float[(fArr4.length * 3) / 2][];
                                System.arraycopy(fArr5, i9, fArr4, i9, i31);
                            }
                            int i33 = i17 + 1;
                            fArr4[i17] = fArr5;
                            if (cM7 == ',') {
                                i15 = i32 + 1;
                                i10 = 16;
                                fArr = null;
                                i11 = 0;
                                cM3 = m(this.f12922e + i32);
                            } else {
                                if (cM7 == ']') {
                                    int i34 = i32 + 1;
                                    char cM8 = m(this.f12922e + i32);
                                    if (i33 != fArr4.length) {
                                        float[][] fArr8 = new float[i33][];
                                        System.arraycopy(fArr4, 0, fArr8, 0, i33);
                                        fArr4 = fArr8;
                                    }
                                    if (cM8 == ',') {
                                        this.f12922e += i34 - 1;
                                        next();
                                        this.f12931n = 3;
                                        this.f12918a = 16;
                                        return fArr4;
                                    }
                                    if (cM8 != '}') {
                                        this.f12931n = -1;
                                        return null;
                                    }
                                    int i35 = i34 + 1;
                                    char cM9 = m(this.f12922e + i34);
                                    if (cM9 == ',') {
                                        this.f12918a = 16;
                                        this.f12922e += i35 - 1;
                                        next();
                                    } else if (cM9 == ']') {
                                        this.f12918a = 15;
                                        this.f12922e += i35 - 1;
                                        next();
                                    } else if (cM9 == '}') {
                                        this.f12918a = 13;
                                        this.f12922e += i35 - 1;
                                        next();
                                    } else {
                                        if (cM9 != 26) {
                                            this.f12931n = -1;
                                            return null;
                                        }
                                        this.f12922e += i35 - 1;
                                        this.f12918a = 20;
                                        this.f12921d = (char) 26;
                                    }
                                    this.f12931n = 4;
                                    return fArr4;
                                }
                                i10 = 16;
                                fArr = null;
                                i11 = 0;
                                cM3 = cM7;
                                i15 = i32;
                            }
                            i17 = i33;
                            fArr3 = fArr;
                            i13 = i11;
                            i16 = i10;
                            c9 = '[';
                            break;
                        }
                        c8 = 16;
                        fArr2 = null;
                        i12 = 0;
                        cM4 = cM;
                        i18 = i7;
                    }
                    i13 = i12;
                    i19 = i31;
                    fArr3 = fArr2;
                }
            }
        }
        float[][] fArr9 = fArr3;
        this.f12931n = -1;
        return fArr9;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b1 A[LOOP:0: B:34:0x009b->B:39:0x00b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bc A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.d
    public boolean v(char c8) {
        boolean z7 = false;
        this.f12931n = 0;
        char cM = m(this.f12922e + 0);
        int i7 = 5;
        if (cM != 't') {
            if (cM == 'f') {
                if (m(this.f12922e + 1) != 'a' || m(this.f12922e + 1 + 1) != 'l' || m(this.f12922e + 1 + 2) != 's' || m(this.f12922e + 1 + 3) != 'e') {
                    this.f12931n = -1;
                    return false;
                }
                cM = m(this.f12922e + 5);
                i7 = 6;
            } else if (cM == '1') {
                cM = m(this.f12922e + 1);
                i7 = 2;
            } else if (cM == '0') {
                cM = m(this.f12922e + 1);
                i7 = 2;
            } else {
                i7 = 1;
            }
            while (cM != c8) {
                if (b2(cM)) {
                    this.f12931n = -1;
                    return z7;
                }
                cM = m(this.f12922e + i7);
                i7++;
            }
            int i8 = this.f12922e + i7;
            this.f12922e = i8;
            this.f12921d = m(i8);
            this.f12931n = 3;
            return z7;
        }
        if (m(this.f12922e + 1) != 'r' || m(this.f12922e + 1 + 1) != 'u' || m(this.f12922e + 1 + 2) != 'e') {
            this.f12931n = -1;
            return false;
        }
        cM = m(this.f12922e + 4);
        z7 = true;
        while (cM != c8) {
            if (b2(cM)) {
                this.f12931n = -1;
                return z7;
            }
            cM = m(this.f12922e + i7);
            i7++;
        }
        int i9 = this.f12922e + i7;
        this.f12922e = i9;
        this.f12921d = m(i9);
        this.f12931n = 3;
        return z7;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void v0(int i7) {
        i2(':');
    }

    public int v2(char[] cArr) {
        int i7;
        char cM;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return 0;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char cM2 = m(this.f12922e + length);
        boolean z7 = cM2 == '-';
        if (z7) {
            cM2 = m(this.f12922e + i8);
            i8++;
        }
        if (cM2 < '0' || cM2 > '9') {
            this.f12931n = -1;
            return 0;
        }
        int i9 = cM2 - '0';
        while (true) {
            i7 = i8 + 1;
            cM = m(this.f12922e + i8);
            if (cM < '0' || cM > '9') {
                break;
            }
            i9 = (i9 * 10) + (cM - '0');
            i8 = i7;
        }
        if (cM == '.') {
            this.f12931n = -1;
            return 0;
        }
        if ((i9 < 0 || i7 > cArr.length + 14) && !(i9 == Integer.MIN_VALUE && i7 == 17 && z7)) {
            this.f12931n = -1;
            return 0;
        }
        if (cM == ',') {
            int i10 = this.f12922e + i7;
            this.f12922e = i10;
            this.f12921d = m(i10);
            this.f12931n = 3;
            this.f12918a = 16;
            return z7 ? -i9 : i9;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return 0;
        }
        int i11 = i7 + 1;
        char cM3 = m(this.f12922e + i7);
        if (cM3 == ',') {
            this.f12918a = 16;
            int i12 = this.f12922e + i11;
            this.f12922e = i12;
            this.f12921d = m(i12);
        } else if (cM3 == ']') {
            this.f12918a = 15;
            int i13 = this.f12922e + i11;
            this.f12922e = i13;
            this.f12921d = m(i13);
        } else if (cM3 == '}') {
            this.f12918a = 13;
            int i14 = this.f12922e + i11;
            this.f12922e = i14;
            this.f12921d = m(i14);
        } else {
            if (cM3 != 26) {
                this.f12931n = -1;
                return 0;
            }
            this.f12918a = 20;
            this.f12922e += i11 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return z7 ? -i9 : i9;
    }

    @Override // com.alibaba.fastjson.parser.d
    public long w1(char c8) {
        int i7;
        int i8;
        char cM;
        this.f12931n = 0;
        char cM2 = m(this.f12922e + 0);
        boolean z7 = cM2 == '\"';
        if (z7) {
            cM2 = m(this.f12922e + 1);
            i7 = 2;
        } else {
            i7 = 1;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            cM2 = m(this.f12922e + i7);
            i7++;
        }
        if (cM2 >= '0' && cM2 <= '9') {
            long j7 = cM2 - '0';
            while (true) {
                i8 = i7 + 1;
                cM = m(this.f12922e + i7);
                if (cM < '0' || cM > '9') {
                    break;
                }
                j7 = (j7 * 10) + ((long) (cM - '0'));
                i7 = i8;
            }
            if (cM == '.') {
                this.f12931n = -1;
                return 0L;
            }
            if (!(j7 >= 0 || (j7 == Long.MIN_VALUE && z8))) {
                throw new NumberFormatException(N2(this.f12922e, i8 - 1));
            }
            if (z7) {
                if (cM != '\"') {
                    this.f12931n = -1;
                    return 0L;
                }
                cM = m(this.f12922e + i8);
                i8++;
            }
            while (cM != c8) {
                if (!b2(cM)) {
                    this.f12931n = -1;
                    return j7;
                }
                cM = m(this.f12922e + i8);
                i8++;
            }
            int i9 = this.f12922e + i8;
            this.f12922e = i9;
            this.f12921d = m(i9);
            this.f12931n = 3;
            this.f12918a = 16;
            return z8 ? -j7 : j7;
        }
        if (cM2 != 'n' || m(this.f12922e + i7) != 'u' || m(this.f12922e + i7 + 1) != 'l' || m(this.f12922e + i7 + 2) != 'l') {
            this.f12931n = -1;
            return 0L;
        }
        this.f12931n = 5;
        int i10 = i7 + 3;
        int i11 = i10 + 1;
        char cM3 = m(this.f12922e + i10);
        if (z7 && cM3 == '\"') {
            int i12 = i11 + 1;
            cM3 = m(this.f12922e + i11);
            i11 = i12;
        }
        while (cM3 != ',') {
            if (cM3 == ']') {
                int i13 = this.f12922e + i11;
                this.f12922e = i13;
                this.f12921d = m(i13);
                this.f12931n = 5;
                this.f12918a = 15;
                return 0L;
            }
            if (!b2(cM3)) {
                this.f12931n = -1;
                return 0L;
            }
            int i14 = i11 + 1;
            cM3 = m(this.f12922e + i11);
            i11 = i14;
        }
        int i15 = this.f12922e + i11;
        this.f12922e = i15;
        this.f12921d = m(i15);
        this.f12931n = 5;
        this.f12918a = 16;
        return 0L;
    }

    public final int[] w2(char[] cArr) {
        boolean z7;
        int i7;
        char cM;
        int i8;
        int i9;
        char cM2;
        this.f12931n = 0;
        int[] iArr = null;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = cArr.length;
        int i10 = length + 1;
        if (m(this.f12922e + length) != '[') {
            this.f12931n = -2;
            return null;
        }
        int i11 = i10 + 1;
        char cM3 = m(this.f12922e + i10);
        int[] iArr2 = new int[16];
        if (cM3 == ']') {
            i9 = i11 + 1;
            cM2 = m(this.f12922e + i11);
            i8 = 0;
        } else {
            int i12 = 0;
            while (true) {
                if (cM3 == '-') {
                    cM3 = m(this.f12922e + i11);
                    i11++;
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (cM3 < '0' || cM3 > '9') {
                    int[] iArr3 = iArr;
                    this.f12931n = -1;
                    return iArr3;
                }
                int i13 = cM3 - '0';
                while (true) {
                    i7 = i11 + 1;
                    cM = m(this.f12922e + i11);
                    if (cM < '0' || cM > '9') {
                        break;
                    }
                    i13 = (i13 * 10) + (cM - '0');
                    i11 = i7;
                }
                if (i12 >= iArr2.length) {
                    int[] iArr4 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy(iArr2, 0, iArr4, 0, i12);
                    iArr2 = iArr4;
                }
                i8 = i12 + 1;
                if (z7) {
                    i13 = -i13;
                }
                iArr2[i12] = i13;
                if (cM == ',') {
                    char cM4 = m(this.f12922e + i7);
                    i7++;
                    cM = cM4;
                } else if (cM == ']') {
                    i9 = i7 + 1;
                    cM2 = m(this.f12922e + i7);
                    break;
                }
                i12 = i8;
                iArr = null;
                cM3 = cM;
                i11 = i7;
            }
        }
        if (i8 != iArr2.length) {
            int[] iArr5 = new int[i8];
            System.arraycopy(iArr2, 0, iArr5, 0, i8);
            iArr2 = iArr5;
        }
        if (cM2 == ',') {
            this.f12922e += i9 - 1;
            next();
            this.f12931n = 3;
            this.f12918a = 16;
            return iArr2;
        }
        if (cM2 != '}') {
            this.f12931n = -1;
            return null;
        }
        int i14 = i9 + 1;
        char cM5 = m(this.f12922e + i9);
        if (cM5 == ',') {
            this.f12918a = 16;
            this.f12922e += i14 - 1;
            next();
        } else if (cM5 == ']') {
            this.f12918a = 15;
            this.f12922e += i14 - 1;
            next();
        } else if (cM5 == '}') {
            this.f12918a = 13;
            this.f12922e += i14 - 1;
            next();
        } else {
            if (cM5 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12922e += i14 - 1;
            this.f12918a = 20;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return iArr2;
    }

    @Override // com.alibaba.fastjson.parser.d
    public abstract String x0();

    public long x2(char[] cArr) {
        boolean z7;
        int i7;
        char cM;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char cM2 = m(this.f12922e + length);
        if (cM2 == '-') {
            cM2 = m(this.f12922e + i8);
            i8++;
            z7 = true;
        } else {
            z7 = false;
        }
        if (cM2 < '0' || cM2 > '9') {
            this.f12931n = -1;
            return 0L;
        }
        long j7 = cM2 - '0';
        while (true) {
            i7 = i8 + 1;
            cM = m(this.f12922e + i8);
            if (cM < '0' || cM > '9') {
                break;
            }
            j7 = (j7 * 10) + ((long) (cM - '0'));
            i8 = i7;
        }
        if (cM == '.') {
            this.f12931n = -1;
            return 0L;
        }
        if (!(i7 - cArr.length < 21 && (j7 >= 0 || (j7 == Long.MIN_VALUE && z7)))) {
            this.f12931n = -1;
            return 0L;
        }
        if (cM == ',') {
            int i9 = this.f12922e + i7;
            this.f12922e = i9;
            this.f12921d = m(i9);
            this.f12931n = 3;
            this.f12918a = 16;
            return z7 ? -j7 : j7;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return 0L;
        }
        int i10 = i7 + 1;
        char cM3 = m(this.f12922e + i7);
        if (cM3 == ',') {
            this.f12918a = 16;
            int i11 = this.f12922e + i10;
            this.f12922e = i11;
            this.f12921d = m(i11);
        } else if (cM3 == ']') {
            this.f12918a = 15;
            int i12 = this.f12922e + i10;
            this.f12922e = i12;
            this.f12921d = m(i12);
        } else if (cM3 == '}') {
            this.f12918a = 13;
            int i13 = this.f12922e + i10;
            this.f12922e = i13;
            this.f12921d = m(i13);
        } else {
            if (cM3 != 26) {
                this.f12931n = -1;
                return 0L;
            }
            this.f12918a = 20;
            this.f12922e += i10 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return z7 ? -j7 : j7;
    }

    public String y2(char[] cArr) {
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return M2();
        }
        int length = cArr.length;
        int i7 = length + 1;
        if (m(this.f12922e + length) != '\"') {
            this.f12931n = -1;
            return M2();
        }
        int iY1 = Y1(h0.f35376b, this.f12922e + cArr.length + 1);
        if (iY1 == -1) {
            throw new com.alibaba.fastjson.d("unclosed str");
        }
        int length2 = this.f12922e + cArr.length + 1;
        String strN2 = N2(length2, iY1 - length2);
        if (strN2.indexOf(92) != -1) {
            while (true) {
                int i8 = 0;
                for (int i9 = iY1 - 1; i9 >= 0 && m(i9) == '\\'; i9--) {
                    i8++;
                }
                if (i8 % 2 == 0) {
                    break;
                }
                iY1 = Y1(h0.f35376b, iY1 + 1);
            }
            int i10 = this.f12922e;
            int length3 = iY1 - ((cArr.length + i10) + 1);
            strN2 = k2(O2(i10 + cArr.length + 1, length3), length3);
        }
        int i11 = this.f12922e;
        int length4 = i7 + (iY1 - ((cArr.length + i11) + 1)) + 1;
        int i12 = length4 + 1;
        char cM = m(i11 + length4);
        if (cM == ',') {
            int i13 = this.f12922e + i12;
            this.f12922e = i13;
            this.f12921d = m(i13);
            this.f12931n = 3;
            return strN2;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return M2();
        }
        int i14 = i12 + 1;
        char cM2 = m(this.f12922e + i12);
        if (cM2 == ',') {
            this.f12918a = 16;
            int i15 = this.f12922e + i14;
            this.f12922e = i15;
            this.f12921d = m(i15);
        } else if (cM2 == ']') {
            this.f12918a = 15;
            int i16 = this.f12922e + i14;
            this.f12922e = i16;
            this.f12921d = m(i16);
        } else if (cM2 == '}') {
            this.f12918a = 13;
            int i17 = this.f12922e + i14;
            this.f12922e = i17;
            this.f12921d = m(i17);
        } else {
            if (cM2 != 26) {
                this.f12931n = -1;
                return M2();
            }
            this.f12918a = 20;
            this.f12922e += i14 - 1;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return strN2;
    }

    @Override // com.alibaba.fastjson.parser.d
    public final void z1() {
        i2(':');
    }

    public Collection<String> z2(char[] cArr, Class<?> cls) {
        char cM;
        int i7;
        char cM2;
        int i8;
        this.f12931n = 0;
        if (!g(cArr)) {
            this.f12931n = -2;
            return null;
        }
        Collection<String> collectionG2 = g2(cls);
        int length = cArr.length;
        int i9 = length + 1;
        if (m(this.f12922e + length) != '[') {
            this.f12931n = -1;
            return null;
        }
        int i10 = i9 + 1;
        char cM3 = m(this.f12922e + i9);
        while (true) {
            if (cM3 == '\"') {
                int iY1 = Y1(h0.f35376b, this.f12922e + i10);
                if (iY1 == -1) {
                    throw new com.alibaba.fastjson.d("unclosed str");
                }
                int i11 = this.f12922e + i10;
                String strN2 = N2(i11, iY1 - i11);
                if (strN2.indexOf(92) != -1) {
                    while (true) {
                        int i12 = 0;
                        for (int i13 = iY1 - 1; i13 >= 0 && m(i13) == '\\'; i13--) {
                            i12++;
                        }
                        if (i12 % 2 == 0) {
                            break;
                        }
                        iY1 = Y1(h0.f35376b, iY1 + 1);
                    }
                    int i14 = this.f12922e;
                    int i15 = iY1 - (i14 + i10);
                    strN2 = k2(O2(i14 + i10, i15), i15);
                }
                int i16 = this.f12922e;
                int i17 = i10 + (iY1 - (i16 + i10)) + 1;
                i8 = i17 + 1;
                cM2 = m(i16 + i17);
                collectionG2.add(strN2);
            } else {
                if (cM3 != 'n' || m(this.f12922e + i10) != 'u' || m(this.f12922e + i10 + 1) != 'l' || m(this.f12922e + i10 + 2) != 'l') {
                    if (cM3 != ']' || collectionG2.size() != 0) {
                        throw new com.alibaba.fastjson.d("illega str");
                    }
                    cM = m(this.f12922e + i10);
                    i7 = i10 + 1;
                    break;
                }
                int i18 = i10 + 3;
                int i19 = i18 + 1;
                cM2 = m(this.f12922e + i18);
                collectionG2.add(null);
                i8 = i19;
            }
            if (cM2 != ',') {
                if (cM2 != ']') {
                    this.f12931n = -1;
                    return null;
                }
                i7 = i8 + 1;
                cM = m(this.f12922e + i8);
                break;
            }
            int i20 = i8 + 1;
            cM3 = m(this.f12922e + i8);
            i10 = i20;
        }
        if (cM == ',') {
            int i21 = this.f12922e + i7;
            this.f12922e = i21;
            this.f12921d = m(i21);
            this.f12931n = 3;
            return collectionG2;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return null;
        }
        int i22 = i7 + 1;
        char cM4 = m(this.f12922e + i7);
        if (cM4 == ',') {
            this.f12918a = 16;
            int i23 = this.f12922e + i22;
            this.f12922e = i23;
            this.f12921d = m(i23);
        } else if (cM4 == ']') {
            this.f12918a = 15;
            int i24 = this.f12922e + i22;
            this.f12922e = i24;
            this.f12921d = m(i24);
        } else if (cM4 == '}') {
            this.f12918a = 13;
            int i25 = this.f12922e + i22;
            this.f12922e = i25;
            this.f12921d = m(i25);
        } else {
            if (cM4 != 26) {
                this.f12931n = -1;
                return null;
            }
            this.f12922e += i22 - 1;
            this.f12918a = 20;
            this.f12921d = (char) 26;
        }
        this.f12931n = 4;
        return collectionG2;
    }
}
