package com.haier.library.json.parser;

import androidx.constraintlayout.widget.ConstraintLayout;
import easypay.appinvoke.manager.Constants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.h0;
import org.apache.commons.lang3.CharUtils;
import org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final char[] B;
    static final int[] C;
    public static final boolean[] D;
    public static final boolean[] E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final char f26697s = 26;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f26698t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f26699u = -2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f26700v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f26701w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f26702x = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f26705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f26706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeZone f26708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Locale f26709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected char f26710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f26711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f26712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected char[] f26713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f26714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f26715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f26716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Calendar f26717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f26718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected final String f26719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected final int f26720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f26721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f26722r;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f26703y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final ThreadLocal<char[]> f26704z = new ThreadLocal<>();
    protected static final int[] A = new int[Constants.ACTION_SUBMIT_BTN_USER_PWD_NB];

    static {
        for (int i7 = 48; i7 <= 57; i7++) {
            A[i7] = i7 - 48;
        }
        for (int i8 = 97; i8 <= 102; i8++) {
            A[i8] = (i8 - 97) + 10;
        }
        for (int i9 = 65; i9 <= 70; i9++) {
            A[i9] = (i9 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        B = charArray;
        int[] iArr = new int[256];
        C = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        char c8 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            C[B[i10]] = i10;
        }
        C[61] = 0;
        D = new boolean[256];
        char c9 = 0;
        while (true) {
            boolean[] zArr = D;
            if (c9 >= zArr.length) {
                break;
            }
            if (c9 >= 'A' && c9 <= 'Z') {
                zArr[c9] = true;
            } else if (c9 >= 'a' && c9 <= 'z') {
                zArr[c9] = true;
            } else if (c9 == '_') {
                zArr[c9] = true;
            }
            c9 = (char) (c9 + 1);
        }
        E = new boolean[256];
        while (true) {
            boolean[] zArr2 = E;
            if (c8 >= zArr2.length) {
                return;
            }
            if (c8 >= 'A' && c8 <= 'Z') {
                zArr2[c8] = true;
            } else if (c8 >= 'a' && c8 <= 'z') {
                zArr2[c8] = true;
            } else if (c8 == '_') {
                zArr2[c8] = true;
            } else if (c8 >= '0' && c8 <= '9') {
                zArr2[c8] = true;
            }
            c8 = (char) (c8 + 1);
        }
    }

    public e(String str) {
        this(str, com.haier.library.json.a.f26648e);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e8  */
    private static String B(char[] cArr, int i7) {
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
                                    throw new com.haier.library.json.d("unclosed.str.lit");
                            }
                            break;
                    }
                } else {
                    i8 = i10 + 1;
                    int[] iArr = A;
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

    private void D() {
        if (this.f26719o.startsWith(com.paytm.pgsdk.d.G, this.f26711g)) {
            int i7 = this.f26711g + 5;
            this.f26711g = i7;
            char c8 = c(i7);
            this.f26710f = c8;
            if (c8 == ' ' || c8 == ',' || c8 == '}' || c8 == ']' || c8 == '\n' || c8 == '\r' || c8 == '\t' || c8 == 26 || c8 == '\f' || c8 == '\b' || c8 == ':') {
                this.f26705a = 7;
                return;
            }
        }
        throw new com.haier.library.json.d("scan false error");
    }

    private void M() {
        this.f26715k = this.f26711g - 1;
        this.f26716l = false;
        do {
            this.f26714j++;
            v();
        } while (Character.isLetterOrDigit(this.f26710f));
        String strA0 = a0();
        if (strA0.equals("null")) {
            this.f26705a = 8;
            return;
        }
        if (strA0.equals("true")) {
            this.f26705a = 6;
            return;
        }
        if (strA0.equals(com.paytm.pgsdk.d.G)) {
            this.f26705a = 7;
            return;
        }
        if (strA0.equals("new")) {
            this.f26705a = 9;
            return;
        }
        if (strA0.equals("undefined")) {
            this.f26705a = 23;
            return;
        }
        if (strA0.equals("Set")) {
            this.f26705a = 21;
        } else if (strA0.equals("TreeSet")) {
            this.f26705a = 22;
        } else {
            this.f26705a = 18;
        }
    }

    private void O() {
        int i7;
        if (this.f26719o.startsWith("null", this.f26711g)) {
            this.f26711g += 4;
            i7 = 8;
        } else if (this.f26719o.startsWith("new", this.f26711g)) {
            this.f26711g += 3;
            i7 = 9;
        } else {
            i7 = 0;
        }
        if (i7 != 0) {
            char c8 = c(this.f26711g);
            this.f26710f = c8;
            if (c8 == ' ' || c8 == ',' || c8 == '}' || c8 == ']' || c8 == '\n' || c8 == '\r' || c8 == '\t' || c8 == 26 || c8 == '\f' || c8 == '\b') {
                this.f26705a = i7;
                return;
            }
        }
        throw new com.haier.library.json.d("scan null/new error");
    }

    private void W() {
        if (this.f26719o.startsWith("true", this.f26711g)) {
            int i7 = this.f26711g + 4;
            this.f26711g = i7;
            char c8 = c(i7);
            this.f26710f = c8;
            if (c8 == ' ' || c8 == ',' || c8 == '}' || c8 == ']' || c8 == '\n' || c8 == '\r' || c8 == '\t' || c8 == 26 || c8 == '\f' || c8 == '\b' || c8 == ':') {
                this.f26705a = 6;
                return;
            }
        }
        throw new com.haier.library.json.d("scan true error");
    }

    private void X(char c8, char c9, char c10, char c11, char c12, char c13, char c14, char c15) {
        Calendar calendar = Calendar.getInstance(this.f26708d, this.f26709e);
        this.f26717m = calendar;
        calendar.set(1, ((c8 - '0') * 1000) + ((c9 - '0') * 100) + ((c10 - '0') * 10) + (c11 - '0'));
        this.f26717m.set(2, (((c12 - '0') * 10) + (c13 - '0')) - 1);
        this.f26717m.set(5, ((c14 - '0') * 10) + (c15 - '0'));
    }

    private boolean b(char[] cArr) {
        int length = cArr.length;
        if (this.f26711g + length > this.f26720p) {
            return false;
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (cArr[i7] != this.f26719o.charAt(this.f26711g + i7)) {
                return false;
            }
        }
        return true;
    }

    private final String b0(int i7, int i8) {
        char[] cArr = this.f26713i;
        if (i8 < cArr.length) {
            this.f26719o.getChars(i7, i7 + i8, cArr, 0);
            return new String(this.f26713i, 0, i8);
        }
        char[] cArr2 = new char[i8];
        this.f26719o.getChars(i7, i8 + i7, cArr2, 0);
        return new String(cArr2);
    }

    static boolean d(char c8, char c9, char c10, char c11, char c12, char c13, int i7, int i8) {
        if ((c8 == '1' || c8 == '2') && c9 >= '0' && c9 <= '9' && c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9') {
            if (c12 == '0') {
                if (c13 < '1' || c13 > '9') {
                    return false;
                }
            } else if (c12 != '1' || (c13 != '0' && c13 != '1' && c13 != '2')) {
                return false;
            }
            if (i7 == 48) {
                return i8 >= 49 && i8 <= 57;
            }
            if (i7 != 49 && i7 != 50) {
                return i7 == 51 && (i8 == 48 || i8 == 49);
            }
            if (i8 >= 48 && i8 <= 57) {
                return true;
            }
        }
        return false;
    }

    static boolean e(char c8, char c9, char c10, char c11, char c12, char c13) {
        if (c8 == '0') {
            if (c9 < '0' || c9 > '9') {
                return false;
            }
        } else {
            if (c8 != '1') {
                if (c8 == '2' && c9 >= '0' && c9 <= '4') {
                }
                return false;
            }
            if (c9 < '0' || c9 > '9') {
                return false;
            }
        }
        if (c10 < '0' || c10 > '5') {
            if (c10 != '6' || c11 != '0') {
                return false;
            }
        } else if (c11 < '0' || c11 > '9') {
            return false;
        }
        if (c12 < '0' || c12 > '5') {
            return c12 == '6' && c13 == '0';
        }
        return c13 >= '0' && c13 <= '9';
    }

    public static final byte[] j(String str) {
        int i7;
        int i8;
        int length = str.length();
        int i9 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i10 = length - 1;
        int i11 = 0;
        while (i11 < i10 && C[str.charAt(i11) & 255] < 0) {
            i11++;
        }
        while (i10 > 0 && C[str.charAt(i10) & 255] < 0) {
            i10--;
        }
        if (str.charAt(i10) == '=') {
            i7 = str.charAt(i10 + (-1)) == '=' ? 2 : 1;
        } else {
            i7 = 0;
        }
        int i12 = (i10 - i11) + 1;
        if (length > 76) {
            i8 = (str.charAt(76) == '\r' ? i12 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i13 = (((i12 - i8) * 6) >> 3) - i7;
        byte[] bArr = new byte[i13];
        int i14 = (i13 / 3) * 3;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr = C;
            int i17 = i11 + 1;
            int i18 = i17 + 1;
            int i19 = (iArr[str.charAt(i11)] << 18) | (iArr[str.charAt(i17)] << 12);
            int i20 = i18 + 1;
            int i21 = i19 | (iArr[str.charAt(i18)] << 6);
            int i22 = i20 + 1;
            int i23 = i21 | iArr[str.charAt(i20)];
            int i24 = i15 + 1;
            bArr[i15] = (byte) (i23 >> 16);
            int i25 = i24 + 1;
            bArr[i24] = (byte) (i23 >> 8);
            int i26 = i25 + 1;
            bArr[i25] = (byte) i23;
            if (i8 > 0 && (i16 = i16 + 1) == 19) {
                i22 += 2;
                i16 = 0;
            }
            i11 = i22;
            i15 = i26;
        }
        if (i15 < i13) {
            int i27 = 0;
            while (i11 <= i10 - i7) {
                i9 |= C[str.charAt(i11)] << (18 - (i27 * 6));
                i27++;
                i11++;
            }
            int i28 = 16;
            while (i15 < i13) {
                bArr[i15] = (byte) (i9 >> i28);
                i28 -= 8;
                i15++;
            }
        }
        return bArr;
    }

    public static final byte[] k(String str, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && C[str.charAt(i7)] < 0) {
            i7++;
        }
        while (i12 > 0 && C[str.charAt(i12)] < 0) {
            i12--;
        }
        if (str.charAt(i12) == '=') {
            i9 = str.charAt(i12 + (-1)) == '=' ? 2 : 1;
        } else {
            i9 = 0;
        }
        int i13 = (i12 - i7) + 1;
        if (i8 > 76) {
            i10 = (str.charAt(76) == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i9;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = C;
            int i18 = i7 + 1;
            int i19 = i18 + 1;
            int i20 = (iArr[str.charAt(i7)] << 18) | (iArr[str.charAt(i18)] << 12);
            int i21 = i19 + 1;
            int i22 = i20 | (iArr[str.charAt(i19)] << 6);
            int i23 = i21 + 1;
            int i24 = i22 | iArr[str.charAt(i21)];
            int i25 = i16 + 1;
            bArr[i16] = (byte) (i24 >> 16);
            int i26 = i25 + 1;
            bArr[i25] = (byte) (i24 >> 8);
            int i27 = i26 + 1;
            bArr[i26] = (byte) i24;
            if (i10 > 0 && (i17 = i17 + 1) == 19) {
                i23 += 2;
                i17 = 0;
            }
            i7 = i23;
            i16 = i27;
        }
        if (i16 < i14) {
            int i28 = 0;
            while (i7 <= i12 - i9) {
                i11 |= C[str.charAt(i7)] << (18 - (i28 * 6));
                i28++;
                i7++;
            }
            int i29 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i11 >> i29);
                i29 -= 8;
                i16++;
            }
        }
        return bArr;
    }

    public static final byte[] l(char[] cArr, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && C[cArr[i7]] < 0) {
            i7++;
        }
        while (i12 > 0 && C[cArr[i12]] < 0) {
            i12--;
        }
        if (cArr[i12] == '=') {
            i9 = cArr[i12 + (-1)] == '=' ? 2 : 1;
        } else {
            i9 = 0;
        }
        int i13 = (i12 - i7) + 1;
        if (i8 > 76) {
            i10 = (cArr[76] == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i9;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = C;
            int i18 = i7 + 1;
            int i19 = i18 + 1;
            int i20 = (iArr[cArr[i7]] << 18) | (iArr[cArr[i18]] << 12);
            int i21 = i19 + 1;
            int i22 = i20 | (iArr[cArr[i19]] << 6);
            int i23 = i21 + 1;
            int i24 = i22 | iArr[cArr[i21]];
            int i25 = i16 + 1;
            bArr[i16] = (byte) (i24 >> 16);
            int i26 = i25 + 1;
            bArr[i25] = (byte) (i24 >> 8);
            int i27 = i26 + 1;
            bArr[i26] = (byte) i24;
            if (i10 > 0 && (i17 = i17 + 1) == 19) {
                i23 += 2;
                i17 = 0;
            }
            i7 = i23;
            i16 = i27;
        }
        if (i16 < i14) {
            int i28 = 0;
            while (i7 <= i12 - i9) {
                i11 |= C[cArr[i7]] << (18 - (i28 * 6));
                i28++;
                i7++;
            }
            int i29 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i11 >> i29);
                i29 -= 8;
                i16++;
            }
        }
        return bArr;
    }

    public final String A() {
        char cCharAt = this.f26719o.charAt((this.f26715k + this.f26714j) - 1);
        int i7 = this.f26714j;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i7--;
        }
        return b0(this.f26715k, i7);
    }

    public boolean C() {
        int i7;
        boolean z7 = false;
        if (this.f26719o.startsWith(com.paytm.pgsdk.d.G, this.f26711g)) {
            i7 = 5;
        } else if (this.f26719o.startsWith("true", this.f26711g)) {
            i7 = 4;
            z7 = true;
        } else {
            char c8 = this.f26710f;
            if (c8 == '1') {
                i7 = 1;
                z7 = true;
            } else {
                if (c8 != '0') {
                    this.f26718n = -1;
                    return false;
                }
                i7 = 1;
            }
        }
        int i8 = this.f26711g + i7;
        this.f26711g = i8;
        this.f26710f = c(i8);
        return z7;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:31:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
    public boolean E(char[] cArr) {
        int i7;
        boolean z7;
        int i8;
        char c8;
        int i9;
        char c9;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return false;
        }
        int length = cArr.length;
        if (!this.f26719o.startsWith(com.paytm.pgsdk.d.G, this.f26711g + length)) {
            if (this.f26719o.startsWith("true", this.f26711g + length)) {
                i7 = length + 4;
            } else if (this.f26719o.startsWith("\"false\"", this.f26711g + length)) {
                i7 = length + 7;
            } else {
                if (!this.f26719o.startsWith("\"true\"", this.f26711g + length)) {
                    this.f26718n = -1;
                    return false;
                }
                i7 = length + 6;
            }
            z7 = true;
            i8 = i7 + 1;
            c8 = c(this.f26711g + i7);
            if (c8 == ',') {
                this.f26711g += i8 - 1;
                v();
                this.f26718n = 3;
                this.f26705a = 16;
                return z7;
            }
            if (c8 == '}') {
                this.f26718n = -1;
                return false;
            }
            i9 = i8 + 1;
            c9 = c(this.f26711g + i8);
            if (c9 == ',') {
                this.f26705a = 16;
                this.f26711g += i9 - 1;
                v();
            } else if (c9 == ']') {
                this.f26705a = 15;
                this.f26711g += i9 - 1;
                v();
            } else if (c9 == '}') {
                this.f26705a = 13;
                this.f26711g += i9 - 1;
                v();
            } else {
                if (c9 == 26) {
                    this.f26718n = -1;
                    return false;
                }
                this.f26705a = 20;
                this.f26711g += i9 - 1;
                this.f26710f = (char) 26;
            }
            this.f26718n = 4;
            return z7;
        }
        i7 = length + 5;
        z7 = false;
        i8 = i7 + 1;
        c8 = c(this.f26711g + i7);
        if (c8 == ',') {
            this.f26711g += i8 - 1;
            v();
            this.f26718n = 3;
            this.f26705a = 16;
            return z7;
        }
        if (c8 == '}') {
            this.f26718n = -1;
            return false;
        }
        i9 = i8 + 1;
        c9 = c(this.f26711g + i8);
        if (c9 == ',') {
            this.f26705a = 16;
            this.f26711g += i9 - 1;
            v();
        } else if (c9 == ']') {
            this.f26705a = 15;
            this.f26711g += i9 - 1;
            v();
        } else if (c9 == '}') {
            this.f26705a = 13;
            this.f26711g += i9 - 1;
            v();
        } else {
            if (c9 == 26) {
                this.f26718n = -1;
                return false;
            }
            this.f26705a = 20;
            this.f26711g += i9 - 1;
            this.f26710f = (char) 26;
        }
        this.f26718n = 4;
        return z7;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x007d -> B:34:0x006e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final double F(char[] r11) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haier.library.json.parser.e.F(char[]):double");
    }

    public final float G(char[] cArr) {
        int i7;
        char c8;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char c9 = c(this.f26711g + length);
        if (c9 < '0' || c9 > '9') {
            this.f26718n = -1;
            return 0.0f;
        }
        while (true) {
            i7 = i8 + 1;
            c8 = c(this.f26711g + i8);
            if (c8 < '0' || c8 > '9') {
                break;
            }
            i8 = i7;
        }
        if (c8 == '.') {
            int i9 = i7 + 1;
            char c10 = c(this.f26711g + i7);
            if (c10 < '0' || c10 > '9') {
                this.f26718n = -1;
                return 0.0f;
            }
            while (true) {
                i7 = i9 + 1;
                c8 = c(this.f26711g + i9);
                if (c8 < '0' || c8 > '9') {
                    break;
                }
                i9 = i7;
            }
        }
        int i10 = this.f26711g;
        int length2 = cArr.length + i10;
        float f8 = Float.parseFloat(b0(length2, ((i10 + i7) - length2) - 1));
        if (c8 == ',') {
            this.f26711g += i7 - 1;
            v();
            this.f26718n = 3;
            this.f26705a = 16;
            return f8;
        }
        if (c8 != '}') {
            this.f26718n = -1;
            return 0.0f;
        }
        int i11 = i7 + 1;
        char c11 = c(this.f26711g + i7);
        if (c11 == ',') {
            this.f26705a = 16;
            this.f26711g += i11 - 1;
            v();
        } else if (c11 == ']') {
            this.f26705a = 15;
            this.f26711g += i11 - 1;
            v();
        } else if (c11 == '}') {
            this.f26705a = 13;
            this.f26711g += i11 - 1;
            v();
        } else {
            if (c11 != 26) {
                this.f26718n = -1;
                return 0.0f;
            }
            this.f26711g += i11 - 1;
            this.f26705a = 20;
            this.f26710f = (char) 26;
        }
        this.f26718n = 4;
        return f8;
    }

    public int H(char[] cArr) {
        boolean z7;
        int i7;
        char c8;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return 0;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char c9 = c(this.f26711g + length);
        if (c9 == '\"') {
            int i9 = i8 + 1;
            int i10 = this.f26711g + i8;
            c9 = i10 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i10);
            i8 = i9;
            z7 = true;
        } else {
            z7 = false;
        }
        if (c9 < '0' || c9 > '9') {
            this.f26718n = -1;
            return 0;
        }
        int i11 = c9 - '0';
        while (true) {
            i7 = i8 + 1;
            c8 = c(this.f26711g + i8);
            if (c8 < '0' || c8 > '9') {
                break;
            }
            i11 = (i11 * 10) + (c8 - '0');
            i8 = i7;
        }
        if (c8 == '.') {
            this.f26718n = -1;
            return 0;
        }
        if (c8 == '\"') {
            if (!z7) {
                this.f26718n = -1;
                return 0;
            }
            int i12 = i7 + 1;
            int i13 = this.f26711g + i7;
            i7 = i12;
            c8 = i13 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i13);
        }
        if (i11 < 0) {
            this.f26718n = -1;
            return 0;
        }
        if (c8 == ',') {
            this.f26711g += i7 - 1;
            v();
            this.f26718n = 3;
            this.f26705a = 16;
            return i11;
        }
        if (c8 != '}') {
            this.f26718n = -1;
            return 0;
        }
        int i14 = i7 + 1;
        char c10 = c(this.f26711g + i7);
        if (c10 == ',') {
            this.f26705a = 16;
            this.f26711g += i14 - 1;
            v();
        } else if (c10 == ']') {
            this.f26705a = 15;
            this.f26711g += i14 - 1;
            v();
        } else if (c10 == '}') {
            this.f26705a = 13;
            this.f26711g += i14 - 1;
            v();
        } else {
            if (c10 != 26) {
                this.f26718n = -1;
                return 0;
            }
            this.f26705a = 20;
            this.f26711g += i14 - 1;
            this.f26710f = (char) 26;
        }
        this.f26718n = 4;
        return i11;
    }

    public long I(char[] cArr) {
        int i7;
        char c8;
        boolean z7 = false;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return 0L;
        }
        int length = cArr.length;
        int i8 = length + 1;
        char c9 = c(this.f26711g + length);
        if (c9 == '\"') {
            int i9 = i8 + 1;
            int i10 = this.f26711g + i8;
            i8 = i9;
            c9 = i10 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i10);
            z7 = true;
        }
        if (c9 < '0' || c9 > '9') {
            this.f26718n = -1;
            return 0L;
        }
        long j7 = c9 - '0';
        while (true) {
            i7 = i8 + 1;
            c8 = c(this.f26711g + i8);
            if (c8 < '0' || c8 > '9') {
                break;
            }
            j7 = (j7 * 10) + ((long) (c8 - '0'));
            i8 = i7;
        }
        if (c8 == '.') {
            this.f26718n = -1;
            return 0L;
        }
        if (c8 == '\"') {
            if (!z7) {
                this.f26718n = -1;
                return 0L;
            }
            int i11 = i7 + 1;
            int i12 = this.f26711g + i7;
            i7 = i11;
            c8 = i12 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i12);
        }
        if (j7 < 0) {
            this.f26718n = -1;
            return 0L;
        }
        if (c8 == ',') {
            this.f26711g += i7 - 1;
            v();
            this.f26718n = 3;
            this.f26705a = 16;
            return j7;
        }
        if (c8 != '}') {
            this.f26718n = -1;
            return 0L;
        }
        int i13 = i7 + 1;
        char c10 = c(this.f26711g + i7);
        if (c10 == ',') {
            this.f26705a = 16;
            this.f26711g += i13 - 1;
            v();
        } else if (c10 == ']') {
            this.f26705a = 15;
            this.f26711g += i13 - 1;
            v();
        } else if (c10 == '}') {
            this.f26705a = 13;
            this.f26711g += i13 - 1;
            v();
        } else {
            if (c10 != 26) {
                this.f26718n = -1;
                return 0L;
            }
            this.f26705a = 20;
            this.f26711g += i13 - 1;
            this.f26710f = (char) 26;
        }
        this.f26718n = 4;
        return j7;
    }

    public String J(char[] cArr) {
        String str;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return this.f26721q;
        }
        int length = cArr.length;
        int i7 = length + 1;
        int i8 = this.f26711g + length;
        if (i8 >= this.f26720p) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        if (this.f26719o.charAt(i8) != '\"') {
            this.f26718n = -1;
            return this.f26721q;
        }
        int i9 = this.f26711g + i7;
        int iIndexOf = this.f26719o.indexOf(34, i9);
        if (iIndexOf == -1) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        if (f26703y) {
            str = this.f26719o.substring(i9, iIndexOf);
        } else {
            int i10 = iIndexOf - i9;
            str = new String(c0(this.f26711g + i7, i10), 0, i10);
        }
        if (str.indexOf(92) != -1) {
            boolean z7 = false;
            while (true) {
                int i11 = iIndexOf - 1;
                int i12 = 0;
                while (i11 >= 0 && this.f26719o.charAt(i11) == '\\') {
                    i12++;
                    i11--;
                    z7 = true;
                }
                if (i12 % 2 == 0) {
                    break;
                }
                iIndexOf = this.f26719o.indexOf(34, iIndexOf + 1);
            }
            int i13 = iIndexOf - i9;
            char[] cArrC0 = c0(this.f26711g + i7, i13);
            if (z7) {
                str = B(cArrC0, i13);
            } else {
                str = new String(cArrC0, 0, i13);
                if (str.indexOf(92) != -1) {
                    str = B(cArrC0, i13);
                }
            }
        }
        int i14 = iIndexOf + 1;
        char cCharAt = i14 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i14);
        if (cCharAt == ',') {
            this.f26711g = i14;
            v();
            this.f26718n = 3;
            this.f26705a = 16;
            return str;
        }
        if (cCharAt != '}') {
            this.f26718n = -1;
            return this.f26721q;
        }
        int i15 = i14 + 1;
        char c8 = c(i15);
        if (c8 == ',') {
            this.f26705a = 16;
            this.f26711g = i15;
            v();
        } else if (c8 == ']') {
            this.f26705a = 15;
            this.f26711g = i15;
            v();
        } else if (c8 == '}') {
            this.f26705a = 13;
            this.f26711g = i15;
            v();
        } else {
            if (c8 != 26) {
                this.f26718n = -1;
                return this.f26721q;
            }
            this.f26705a = 20;
            this.f26711g = i15;
            this.f26710f = (char) 26;
        }
        this.f26718n = 4;
        return str;
    }

    public String K(char[] cArr, o oVar) {
        int i7 = 0;
        this.f26718n = 0;
        if (!b(cArr)) {
            this.f26718n = -2;
            return null;
        }
        int length = cArr.length;
        int i8 = length + 1;
        if (c(this.f26711g + length) != '\"') {
            this.f26718n = -1;
            return null;
        }
        while (true) {
            int i9 = i8 + 1;
            char c8 = c(this.f26711g + i8);
            if (c8 == '\"') {
                int i10 = this.f26711g;
                int length2 = cArr.length + i10 + 1;
                String strA = oVar.a(this.f26719o, length2, ((i10 + i9) - length2) - 1, i7);
                int i11 = i9 + 1;
                char c9 = c(this.f26711g + i9);
                if (c9 == ',') {
                    this.f26711g += i11 - 1;
                    v();
                    this.f26718n = 3;
                    return strA;
                }
                if (c9 != '}') {
                    this.f26718n = -1;
                    return null;
                }
                int i12 = i11 + 1;
                char c10 = c(this.f26711g + i11);
                if (c10 == ',') {
                    this.f26705a = 16;
                    this.f26711g += i12 - 1;
                    v();
                } else if (c10 == ']') {
                    this.f26705a = 15;
                    this.f26711g += i12 - 1;
                    v();
                } else if (c10 == '}') {
                    this.f26705a = 13;
                    this.f26711g += i12 - 1;
                    v();
                } else {
                    if (c10 != 26) {
                        this.f26718n = -1;
                        return null;
                    }
                    this.f26705a = 20;
                    this.f26711g += i12 - 1;
                    this.f26710f = (char) 26;
                }
                this.f26718n = 4;
                return strA;
            }
            i7 = (i7 * 31) + c8;
            if (c8 == '\\') {
                this.f26718n = -1;
                return null;
            }
            i8 = i9;
        }
    }

    public boolean L(boolean z7) {
        int i7;
        int i8;
        int i9;
        char c8;
        char c9;
        int i10;
        char c10;
        int i11;
        int i12;
        char c11;
        int length = this.f26719o.length();
        int i13 = this.f26711g;
        int i14 = length - i13;
        if (!z7 && i14 > 13 && this.f26719o.startsWith("/Date(", i13) && c((this.f26711g + i14) - 1) == '/' && c((this.f26711g + i14) - 2) == ')') {
            int i15 = -1;
            for (int i16 = 6; i16 < i14; i16++) {
                char c12 = c(this.f26711g + i16);
                if (c12 != '+') {
                    if (c12 < '0' || c12 > '9') {
                        break;
                    }
                } else {
                    i15 = i16;
                }
            }
            if (i15 == -1) {
                return false;
            }
            int i17 = this.f26711g + 6;
            long j7 = Long.parseLong(b0(i17, i15 - i17));
            Calendar calendar = Calendar.getInstance(this.f26708d, this.f26709e);
            this.f26717m = calendar;
            calendar.setTimeInMillis(j7);
            this.f26705a = 5;
            return true;
        }
        if (i14 == 8 || i14 == 14 || i14 == 17) {
            int i18 = 0;
            if (z7) {
                return false;
            }
            char c13 = c(this.f26711g);
            char c14 = c(this.f26711g + 1);
            char c15 = c(this.f26711g + 2);
            char c16 = c(this.f26711g + 3);
            char c17 = c(this.f26711g + 4);
            char c18 = c(this.f26711g + 5);
            char c19 = c(this.f26711g + 6);
            char c20 = c(this.f26711g + 7);
            if (!d(c13, c14, c15, c16, c17, c18, c19, c20)) {
                return false;
            }
            X(c13, c14, c15, c16, c17, c18, c19, c20);
            if (i14 != 8) {
                char c21 = c(this.f26711g + 8);
                char c22 = c(this.f26711g + 9);
                char c23 = c(this.f26711g + 10);
                char c24 = c(this.f26711g + 11);
                char c25 = c(this.f26711g + 12);
                char c26 = c(this.f26711g + 13);
                if (!e(c21, c22, c23, c24, c25, c26)) {
                    return false;
                }
                if (i14 == 17) {
                    char c27 = c(this.f26711g + 14);
                    char c28 = c(this.f26711g + 15);
                    char c29 = c(this.f26711g + 16);
                    c8 = '0';
                    if (c27 < '0' || c27 > '9' || c28 < '0' || c28 > '9' || c29 < '0' || c29 > '9') {
                        return false;
                    }
                    i18 = ((c27 - '0') * 100) + ((c28 - '0') * 10) + (c29 - '0');
                } else {
                    c8 = '0';
                }
                i9 = (c22 - c8) + ((c21 - c8) * 10);
                i8 = ((c25 - '0') * 10) + (c26 - '0');
                int i19 = i18;
                i18 = ((c23 - c8) * 10) + (c24 - c8);
                i7 = i19;
            } else {
                i7 = 0;
                i8 = 0;
                i9 = 0;
            }
            this.f26717m.set(11, i9);
            this.f26717m.set(12, i18);
            this.f26717m.set(13, i8);
            this.f26717m.set(14, i7);
            this.f26705a = 5;
            return true;
        }
        if (i14 < 10 || c(this.f26711g + 4) != '-' || c(this.f26711g + 7) != '-') {
            return false;
        }
        char c30 = c(this.f26711g);
        char c31 = c(this.f26711g + 1);
        char c32 = c(this.f26711g + 2);
        char c33 = c(this.f26711g + 3);
        char c34 = c(this.f26711g + 5);
        char c35 = c(this.f26711g + 6);
        char c36 = c(this.f26711g + 8);
        char c37 = c(this.f26711g + 9);
        if (!d(c30, c31, c32, c33, c34, c35, c36, c37)) {
            return false;
        }
        X(c30, c31, c32, c33, c34, c35, c36, c37);
        char c38 = c(this.f26711g + 10);
        if (c38 != 'T' && (c38 != ' ' || z7)) {
            if (c38 != '\"' && c38 != 26) {
                return false;
            }
            this.f26717m.set(11, 0);
            this.f26717m.set(12, 0);
            this.f26717m.set(13, 0);
            this.f26717m.set(14, 0);
            int i20 = this.f26711g + 10;
            this.f26711g = i20;
            this.f26710f = c(i20);
            this.f26705a = 5;
            return true;
        }
        if (i14 < 19 || c(this.f26711g + 13) != ':' || c(this.f26711g + 16) != ':') {
            return false;
        }
        char c39 = c(this.f26711g + 11);
        char c40 = c(this.f26711g + 12);
        char c41 = c(this.f26711g + 14);
        char c42 = c(this.f26711g + 15);
        char c43 = c(this.f26711g + 17);
        char c44 = c(this.f26711g + 18);
        if (!e(c39, c40, c41, c42, c43, c44)) {
            return false;
        }
        this.f26717m.set(11, ((c39 - '0') * 10) + (c40 - '0'));
        this.f26717m.set(12, ((c41 - '0') * 10) + (c42 - '0'));
        this.f26717m.set(13, ((c43 - '0') * 10) + (c44 - '0'));
        char c45 = c(this.f26711g + 19);
        if (c45 != '.') {
            this.f26717m.set(14, 0);
            int i21 = this.f26711g + 19;
            this.f26711g = i21;
            this.f26710f = c(i21);
            this.f26705a = 5;
            if (c45 == 'Z' && this.f26717m.getTimeZone().getRawOffset() != 0) {
                String[] availableIDs = TimeZone.getAvailableIDs(0);
                if (availableIDs.length > 0) {
                    this.f26717m.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                }
            }
            return true;
        }
        if (i14 >= 23 && (c9 = c(this.f26711g + 20)) >= '0' && c9 <= '9') {
            int[] iArr = A;
            int i22 = iArr[c9];
            char c46 = c(this.f26711g + 21);
            if (c46 < '0' || c46 > '9') {
                i10 = 1;
            } else {
                i22 = (i22 * 10) + iArr[c46];
                i10 = 2;
            }
            if (i10 == 2 && (c11 = c(this.f26711g + 22)) >= '0' && c11 <= '9') {
                i22 = (i22 * 10) + iArr[c11];
                i10 = 3;
            }
            this.f26717m.set(14, i22);
            char c47 = c(this.f26711g + 20 + i10);
            if (c47 == '+' || c47 == '-') {
                char c48 = c(this.f26711g + 20 + i10 + 1);
                if (c48 >= '0' && c48 <= '1' && (c10 = c(this.f26711g + 20 + i10 + 2)) >= '0' && c10 <= '9') {
                    char c49 = c(this.f26711g + 20 + i10 + 3);
                    if (c49 == ':') {
                        if (c(this.f26711g + 20 + i10 + 4) != '0' || c(this.f26711g + 20 + i10 + 5) != '0') {
                            return false;
                        }
                        i11 = 6;
                    } else if (c49 != '0') {
                        i11 = 3;
                    } else {
                        if (c(this.f26711g + 20 + i10 + 4) != '0') {
                            return false;
                        }
                        i11 = 5;
                    }
                    int i23 = ((iArr[c48] * 10) + iArr[c10]) * TimeUtils.f38737c * 1000;
                    if (c47 == '-') {
                        i23 = -i23;
                    }
                    if (this.f26717m.getTimeZone().getRawOffset() != i23) {
                        String[] availableIDs2 = TimeZone.getAvailableIDs(i23);
                        if (availableIDs2.length > 0) {
                            this.f26717m.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                        }
                    }
                    i12 = i11;
                }
            } else if (c47 == 'Z') {
                if (this.f26717m.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs3 = TimeZone.getAvailableIDs(0);
                    if (availableIDs3.length > 0) {
                        this.f26717m.setTimeZone(TimeZone.getTimeZone(availableIDs3[0]));
                    }
                }
                i12 = 1;
            } else {
                i12 = 0;
            }
            int i24 = i10 + 20 + i12;
            char c50 = c(this.f26711g + i24);
            if (c50 != 26 && c50 != '\"') {
                return false;
            }
            int i25 = this.f26711g + i24;
            this.f26711g = i25;
            this.f26710f = c(i25);
            this.f26705a = 5;
            return true;
        }
        return false;
    }

    public final long N() {
        long j7;
        boolean z7 = false;
        this.f26715k = 0;
        if (this.f26710f == '-') {
            this.f26715k = 0 + 1;
            v();
            j7 = Long.MIN_VALUE;
            z7 = true;
        } else {
            j7 = -9223372036854775807L;
        }
        long j8 = 0;
        while (true) {
            char c8 = this.f26710f;
            if (c8 < '0' || c8 > '9') {
                break;
            }
            int i7 = c8 - '0';
            if (j8 < v5.a.f40434c) {
                throw new com.haier.library.json.d("error long value, " + j8 + ", " + n());
            }
            long j9 = j8 * 10;
            long j10 = i7;
            if (j9 < j7 + j10) {
                throw new com.haier.library.json.d("error long value, " + j9 + ", " + n());
            }
            j8 = j9 - j10;
            this.f26715k++;
            v();
        }
        return !z7 ? -j8 : j8;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cb  */
    public final void P() {
        char c8;
        boolean z7;
        char c9;
        this.f26715k = this.f26711g;
        boolean z8 = true;
        if (this.f26710f == '-') {
            this.f26714j++;
            v();
        }
        while (true) {
            c8 = this.f26710f;
            if (c8 < '0' || c8 > '9') {
                break;
            }
            this.f26714j++;
            v();
        }
        if (c8 == '.') {
            this.f26714j++;
            v();
            while (true) {
                char c10 = this.f26710f;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.f26714j++;
                v();
            }
            z7 = true;
        } else {
            z7 = false;
        }
        char c11 = this.f26710f;
        if (c11 != 'L' && c11 != 'S' && c11 != 'B') {
            if (c11 == 'F' || c11 == 'D') {
                this.f26714j++;
                v();
            } else if (c11 == 'e' || c11 == 'E') {
                this.f26714j++;
                v();
                char c12 = this.f26710f;
                if (c12 == '+' || c12 == '-') {
                    this.f26714j++;
                    v();
                }
                while (true) {
                    c9 = this.f26710f;
                    if (c9 < '0' || c9 > '9') {
                        break;
                    }
                    this.f26714j++;
                    v();
                }
                if (c9 == 'D' || c9 == 'F') {
                    this.f26714j++;
                    v();
                }
            }
            if (z8) {
                this.f26705a = 3;
            } else {
                this.f26705a = 2;
            }
        }
        this.f26714j++;
        v();
        z8 = z7;
        if (z8) {
            this.f26705a = 3;
        } else {
            this.f26705a = 2;
        }
    }

    public final Number Q() {
        long j7;
        boolean z7;
        char c8;
        Number numberValueOf;
        boolean z8;
        char c9;
        int i7 = this.f26711g;
        this.f26715k = 0;
        boolean z9 = true;
        if (this.f26710f == '-') {
            this.f26715k = 0 + 1;
            v();
            j7 = Long.MIN_VALUE;
            z7 = true;
        } else {
            j7 = -9223372036854775807L;
            z7 = false;
        }
        long j8 = 0;
        boolean z10 = false;
        while (true) {
            c8 = this.f26710f;
            if (c8 < '0' || c8 > '9') {
                break;
            }
            int i8 = c8 - '0';
            if (j8 < v5.a.f40434c) {
                z10 = true;
            }
            long j9 = j8 * 10;
            long j10 = i8;
            if (j9 < j7 + j10) {
                z10 = true;
            }
            j8 = j9 - j10;
            this.f26715k++;
            v();
        }
        if (!z7) {
            j8 = -j8;
        }
        if (c8 == 'L') {
            this.f26715k++;
            v();
            numberValueOf = Long.valueOf(j8);
        } else if (c8 == 'S') {
            this.f26715k++;
            v();
            numberValueOf = Short.valueOf((short) j8);
        } else if (c8 == 'B') {
            this.f26715k++;
            v();
            numberValueOf = Byte.valueOf((byte) j8);
        } else if (c8 == 'F') {
            this.f26715k++;
            v();
            numberValueOf = Float.valueOf(j8);
        } else if (c8 == 'D') {
            this.f26715k++;
            v();
            numberValueOf = Double.valueOf(j8);
        } else {
            numberValueOf = null;
        }
        if (this.f26710f == '.') {
            this.f26715k++;
            v();
            while (true) {
                char c10 = this.f26710f;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.f26715k++;
                v();
            }
            z8 = true;
        } else {
            z8 = false;
        }
        char c11 = this.f26710f;
        if (c11 == 'e' || c11 == 'E') {
            this.f26715k++;
            v();
            char c12 = this.f26710f;
            if (c12 == '+' || c12 == '-') {
                this.f26715k++;
                v();
            }
            while (true) {
                c9 = this.f26710f;
                if (c9 < '0' || c9 > '9') {
                    break;
                }
                this.f26715k++;
                v();
            }
            if (c9 == 'D' || c9 == 'F') {
                this.f26715k++;
                v();
            } else {
                c9 = 0;
            }
        } else {
            z9 = false;
            c9 = 0;
        }
        if (!z8 && !z9) {
            if (z10) {
                int i9 = this.f26711g;
                char[] cArr = new char[i9 - i7];
                this.f26719o.getChars(i7, i9, cArr, 0);
                numberValueOf = new BigInteger(new String(cArr));
            }
            if (numberValueOf == null) {
                return (j8 <= -2147483648L || j8 >= 2147483647L) ? Long.valueOf(j8) : Integer.valueOf((int) j8);
            }
            return numberValueOf;
        }
        int i10 = this.f26711g - i7;
        if (c9 != 0) {
            i10--;
        }
        char[] cArr2 = new char[i10];
        this.f26719o.getChars(i7, i10 + i7, cArr2, 0);
        if (!z9 && (this.f26707c & d.UseBigDecimal.f26696a) != 0) {
            return new BigDecimal(cArr2);
        }
        String str = new String(cArr2);
        try {
            return c9 == 'F' ? Float.valueOf(str) : Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e8) {
            throw new com.haier.library.json.d(e8.getMessage() + ", " + n(), e8);
        }
    }

    public final void R() {
        char c8 = this.f26710f;
        int i7 = this.f26711g + 1;
        int iIndexOf = this.f26719o.indexOf(c8, i7);
        if (iIndexOf == -1) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        int i8 = iIndexOf - i7;
        char[] cArrC0 = c0(this.f26711g + 1, i8);
        boolean z7 = false;
        while (i8 > 0 && cArrC0[i8 - 1] == '\\') {
            int i9 = 1;
            for (int i10 = i8 - 2; i10 >= 0 && cArrC0[i10] == '\\'; i10--) {
                i9++;
            }
            if (i9 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.f26719o.indexOf(c8, iIndexOf + 1);
            int i11 = (iIndexOf2 - iIndexOf) + i8;
            if (i11 >= cArrC0.length) {
                int length = (cArrC0.length * 3) / 2;
                if (length < i11) {
                    length = i11;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrC0, 0, cArr, 0, cArrC0.length);
                cArrC0 = cArr;
            }
            this.f26719o.getChars(iIndexOf, iIndexOf2, cArrC0, i8);
            iIndexOf = iIndexOf2;
            i8 = i11;
            z7 = true;
        }
        if (!z7) {
            for (int i12 = 0; i12 < i8; i12++) {
                if (cArrC0[i12] == '\\') {
                    z7 = true;
                }
            }
        }
        this.f26713i = cArrC0;
        this.f26714j = i8;
        this.f26715k = this.f26711g;
        this.f26716l = z7;
        int i13 = iIndexOf + 1;
        this.f26711g = i13;
        this.f26710f = c(i13);
        this.f26705a = 4;
    }

    public String S(char c8) {
        String str;
        int i7 = this.f26711g + 1;
        int iIndexOf = this.f26719o.indexOf(c8, i7);
        if (iIndexOf == -1) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        if (f26703y) {
            str = this.f26719o.substring(i7, iIndexOf);
        } else {
            int i8 = iIndexOf - i7;
            str = new String(c0(this.f26711g + 1, i8), 0, i8);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i9 = 0;
                for (int i10 = iIndexOf - 1; i10 >= 0 && this.f26719o.charAt(i10) == '\\'; i10--) {
                    i9++;
                }
                if (i9 % 2 == 0) {
                    break;
                }
                iIndexOf = this.f26719o.indexOf(c8, iIndexOf + 1);
            }
            int i11 = iIndexOf - i7;
            str = B(c0(this.f26711g + 1, i11), i11);
        }
        int i12 = iIndexOf + 1;
        this.f26711g = i12;
        this.f26710f = c(i12);
        return str;
    }

    public final String T(o oVar) {
        char c8;
        while (true) {
            c8 = this.f26710f;
            if (c8 != ' ' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != '\f' && c8 != '\b') {
                break;
            }
            v();
        }
        if (c8 == '\"') {
            return U(oVar, h0.f35376b);
        }
        if (c8 == '\'') {
            if ((this.f26707c & d.AllowSingleQuotes.f26696a) != 0) {
                return U(oVar, '\'');
            }
            throw new com.haier.library.json.d("syntax error");
        }
        if (c8 == '}') {
            v();
            this.f26705a = 13;
            return null;
        }
        if (c8 == ',') {
            v();
            this.f26705a = 16;
            return null;
        }
        if (c8 == 26) {
            this.f26705a = 20;
            return null;
        }
        if ((this.f26707c & d.AllowUnQuotedFieldNames.f26696a) != 0) {
            return V(oVar);
        }
        throw new com.haier.library.json.d("syntax error");
    }

    public String U(o oVar, char c8) {
        String strB;
        int i7 = this.f26711g + 1;
        int iIndexOf = this.f26719o.indexOf(c8, i7);
        if (iIndexOf == -1) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        int i8 = iIndexOf - i7;
        char[] cArrC0 = c0(this.f26711g + 1, i8);
        boolean z7 = false;
        while (i8 > 0 && cArrC0[i8 - 1] == '\\') {
            int i9 = 1;
            for (int i10 = i8 - 2; i10 >= 0 && cArrC0[i10] == '\\'; i10--) {
                i9++;
            }
            if (i9 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.f26719o.indexOf(c8, iIndexOf + 1);
            int i11 = (iIndexOf2 - iIndexOf) + i8;
            if (i11 >= cArrC0.length) {
                int length = (cArrC0.length * 3) / 2;
                if (length < i11) {
                    length = i11;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrC0, 0, cArr, 0, cArrC0.length);
                cArrC0 = cArr;
            }
            this.f26719o.getChars(iIndexOf, iIndexOf2, cArrC0, i8);
            iIndexOf = iIndexOf2;
            i8 = i11;
            z7 = true;
        }
        if (z7) {
            strB = B(cArrC0, i8);
        } else {
            int i12 = 0;
            for (int i13 = 0; i13 < i8; i13++) {
                char c9 = cArrC0[i13];
                i12 = (i12 * 31) + c9;
                if (c9 == '\\') {
                    z7 = true;
                }
            }
            strB = z7 ? B(cArrC0, i8) : i8 < 20 ? oVar.b(cArrC0, 0, i8, i12) : new String(cArrC0, 0, i8);
        }
        int i14 = iIndexOf + 1;
        this.f26711g = i14;
        this.f26710f = c(i14);
        return strB;
    }

    public final String V(o oVar) {
        int i7 = this.f26710f;
        boolean[] zArr = D;
        if (!(i7 >= zArr.length || zArr[i7])) {
            throw new com.haier.library.json.d("illegal identifier : " + this.f26710f + ", " + n());
        }
        this.f26715k = this.f26711g;
        this.f26714j = 1;
        while (true) {
            char cV = v();
            boolean[] zArr2 = E;
            if (cV < zArr2.length && !zArr2[cV]) {
                break;
            }
            i7 = (i7 * 31) + cV;
            this.f26714j++;
        }
        this.f26710f = c(this.f26711g);
        this.f26705a = 18;
        if (this.f26714j == 4 && this.f26719o.startsWith("null", this.f26715k)) {
            return null;
        }
        return oVar.a(this.f26719o, this.f26715k, this.f26714j, i7);
    }

    protected void Y() {
        v();
        char c8 = this.f26710f;
        if (c8 == '/') {
            do {
                v();
            } while (this.f26710f != '\n');
            v();
        } else {
            if (c8 != '*') {
                throw new com.haier.library.json.d("invalid comment");
            }
            v();
            while (true) {
                char c9 = this.f26710f;
                if (c9 == 26) {
                    return;
                }
                if (c9 == '*') {
                    v();
                    if (this.f26710f == '/') {
                        v();
                        return;
                    }
                } else {
                    v();
                }
            }
        }
    }

    final void Z() {
        while (true) {
            char c8 = this.f26710f;
            if (c8 > '/') {
                return;
            }
            if (c8 == ' ' || c8 == '\r' || c8 == '\n' || c8 == '\t' || c8 == '\f' || c8 == '\b') {
                v();
            } else if (c8 != '/') {
                return;
            } else {
                Y();
            }
        }
    }

    public byte[] a() {
        return k(this.f26719o, this.f26715k + 1, this.f26714j);
    }

    public final String a0() {
        return this.f26716l ? B(this.f26713i, this.f26714j) : b0(this.f26715k + 1, this.f26714j);
    }

    protected char c(int i7) {
        if (i7 >= this.f26720p) {
            return (char) 26;
        }
        return this.f26719o.charAt(i7);
    }

    final char[] c0(int i7, int i8) {
        char[] cArr = this.f26713i;
        if (i8 < cArr.length) {
            this.f26719o.getChars(i7, i8 + i7, cArr, 0);
            return this.f26713i;
        }
        char[] cArr2 = new char[i8];
        this.f26713i = cArr2;
        this.f26719o.getChars(i7, i8 + i7, cArr2, 0);
        return cArr2;
    }

    public final int d0() {
        return this.f26705a;
    }

    public final String e0() {
        return f.a(this.f26705a);
    }

    public void f() {
        char[] cArr = this.f26713i;
        if (cArr.length <= 8196) {
            f26704z.set(cArr);
        }
        this.f26713i = null;
    }

    public final void g(d dVar, boolean z7) {
        if (z7) {
            this.f26707c |= dVar.f26696a;
        } else {
            this.f26707c &= ~dVar.f26696a;
        }
        if (dVar == d.InitStringFieldAsEmpty) {
            this.f26721q = z7 ? "" : null;
        }
        this.f26722r = (this.f26707c & d.DisableCircularReferenceDetect.f26696a) != 0;
    }

    public final Number h(boolean z7) {
        char c8 = c((this.f26715k + this.f26714j) - 1);
        try {
            if (c8 == 'F') {
                return Float.valueOf(Float.parseFloat(A()));
            }
            if (c8 == 'D') {
                return Double.valueOf(Double.parseDouble(A()));
            }
            return z7 ? i() : Double.valueOf(Double.parseDouble(A()));
        } catch (NumberFormatException e8) {
            throw new com.haier.library.json.d(e8.getMessage() + ", " + n());
        }
    }

    public final BigDecimal i() {
        return new BigDecimal(A());
    }

    public Calendar m() {
        return this.f26717m;
    }

    public String n() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.f26711g);
        sb.append(", json : ");
        sb.append(this.f26719o.length() < 65536 ? this.f26719o : this.f26719o.substring(0, 65536));
        return sb.toString();
    }

    public final int o() {
        int i7;
        boolean z7;
        int i8 = this.f26715k;
        int i9 = this.f26714j + i8;
        int i10 = 0;
        if (c(i8) == '-') {
            i8++;
            i7 = Integer.MIN_VALUE;
            z7 = true;
        } else {
            i7 = -2147483647;
            z7 = false;
        }
        if (i8 < i9) {
            i10 = -(c(i8) - '0');
            i8++;
        }
        while (i8 < i9) {
            int i11 = i8 + 1;
            char c8 = c(i8);
            if (c8 == 'L' || c8 == 'S' || c8 == 'B') {
                i8 = i11;
                break;
            }
            int i12 = c8 - '0';
            if (i10 < -214748364) {
                throw new NumberFormatException(A());
            }
            int i13 = i10 * 10;
            if (i13 < i7 + i12) {
                throw new NumberFormatException(A());
            }
            i10 = i13 - i12;
            i8 = i11;
        }
        if (!z7) {
            return -i10;
        }
        if (i8 > this.f26715k + 1) {
            return i10;
        }
        throw new NumberFormatException(A());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0080 -> B:16:0x004b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Number p() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haier.library.json.parser.e.p():java.lang.Number");
    }

    public final boolean q() {
        int i7 = 0;
        while (true) {
            char c8 = c(i7);
            boolean z7 = true;
            if (c8 == 26) {
                return true;
            }
            if (c8 > ' ' || (c8 != ' ' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != '\f' && c8 != '\b')) {
                z7 = false;
            }
            if (!z7) {
                return false;
            }
            i7++;
        }
    }

    public final boolean r(d dVar) {
        return (dVar.f26696a & this.f26707c) != 0;
    }

    public final boolean s() {
        return this.f26714j == 4 && this.f26719o.startsWith("$ref", this.f26715k + 1);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:29:0x006e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0074  */
    /* JADX WARN: Code duplicated, block: B:34:0x007e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0055 -> B:8:0x0027). Please report as a decompilation issue!!! */
    public final long t() throws NumberFormatException {
        boolean z7;
        long j7;
        long j8;
        int i7;
        char c8;
        int i8 = this.f26715k;
        int i9 = this.f26714j + i8;
        if (c(i8) == '-') {
            i8++;
            j7 = Long.MIN_VALUE;
            z7 = true;
        } else {
            z7 = false;
            j7 = -9223372036854775807L;
        }
        if (i8 >= i9) {
            j8 = 0;
            if (i8 < i9) {
                i7 = i8 + 1;
                c8 = c(i8);
                if (c8 != 'L' || c8 == 'S' || c8 == 'B') {
                    i8 = i7;
                } else {
                    int i10 = c8 - '0';
                    if (j8 < v5.a.f40434c) {
                        throw new NumberFormatException(A());
                    }
                    long j9 = j8 * 10;
                    long j10 = i10;
                    if (j9 < j7 + j10) {
                        throw new NumberFormatException(A());
                    }
                    j8 = j9 - j10;
                }
            }
            if (z7) {
                return -j8;
            }
            if (i8 > this.f26715k + 1) {
                return j8;
            }
            throw new NumberFormatException(A());
        }
        i7 = i8 + 1;
        j8 = -(c(i8) - '0');
        i8 = i7;
        if (i8 < i9) {
            i7 = i8 + 1;
            c8 = c(i8);
            if (c8 != 'L') {
            }
            i8 = i7;
        }
        if (z7) {
            return -j8;
        }
        if (i8 > this.f26715k + 1) {
            return j8;
        }
        throw new NumberFormatException(A());
    }

    public boolean u(char[] cArr) {
        if (!b(cArr)) {
            return false;
        }
        int length = this.f26711g + cArr.length;
        this.f26711g = length;
        if (length >= this.f26720p) {
            throw new com.haier.library.json.d("unclosed str, " + n());
        }
        char cCharAt = this.f26719o.charAt(length);
        this.f26710f = cCharAt;
        if (cCharAt == '{') {
            int i7 = this.f26711g + 1;
            this.f26711g = i7;
            this.f26710f = i7 < this.f26720p ? this.f26719o.charAt(i7) : (char) 26;
            this.f26705a = 12;
        } else if (cCharAt == '[') {
            int i8 = this.f26711g + 1;
            this.f26711g = i8;
            this.f26710f = i8 < this.f26720p ? this.f26719o.charAt(i8) : (char) 26;
            this.f26705a = 14;
        } else {
            x();
        }
        return true;
    }

    public char v() {
        int i7 = this.f26711g + 1;
        this.f26711g = i7;
        char cCharAt = i7 >= this.f26720p ? (char) 26 : this.f26719o.charAt(i7);
        this.f26710f = cCharAt;
        return cCharAt;
    }

    public final void w() {
        char c8;
        while (true) {
            c8 = this.f26710f;
            if (!(c8 <= ' ' && (c8 == ' ' || c8 == '\n' || c8 == '\r' || c8 == '\t' || c8 == '\f' || c8 == '\b'))) {
                break;
            } else {
                v();
            }
        }
        if (c8 == '_' || Character.isLetter(c8)) {
            M();
        } else {
            x();
        }
    }

    public final void x() {
        this.f26714j = 0;
        while (true) {
            int i7 = this.f26711g;
            this.f26706b = i7;
            char c8 = this.f26710f;
            if (c8 == '/') {
                Y();
            } else {
                if (c8 == '\"') {
                    R();
                    return;
                }
                if ((c8 >= '0' && c8 <= '9') || c8 == '-') {
                    P();
                    return;
                }
                if (c8 == ',') {
                    v();
                    this.f26705a = 16;
                    return;
                }
                if (c8 != '\f' && c8 != '\r' && c8 != ' ') {
                    if (c8 == ':') {
                        v();
                        this.f26705a = 17;
                        return;
                    }
                    if (c8 == '[') {
                        v();
                        this.f26705a = 14;
                        return;
                    }
                    if (c8 == ']') {
                        v();
                        this.f26705a = 15;
                        return;
                    }
                    if (c8 == 'f') {
                        D();
                        return;
                    }
                    if (c8 == 'n') {
                        O();
                        return;
                    }
                    if (c8 == '{') {
                        v();
                        this.f26705a = 12;
                        return;
                    }
                    if (c8 == '}') {
                        v();
                        this.f26705a = 13;
                        return;
                    }
                    if (c8 != 'S' && c8 != 'T') {
                        if (c8 == 't') {
                            W();
                            return;
                        }
                        if (c8 != 'u') {
                            switch (c8) {
                                case '\b':
                                case '\t':
                                case '\n':
                                    break;
                                default:
                                    switch (c8) {
                                        case '\'':
                                            if ((this.f26707c & d.AllowSingleQuotes.f26696a) == 0) {
                                                throw new com.haier.library.json.d("Feature.AllowSingleQuotes is false");
                                            }
                                            R();
                                            return;
                                        case '(':
                                            v();
                                            this.f26705a = 10;
                                            return;
                                        case ')':
                                            v();
                                            this.f26705a = 11;
                                            return;
                                        default:
                                            int i8 = this.f26720p;
                                            if (i7 == i8 || (c8 == 26 && i7 + 1 == i8)) {
                                                if (this.f26705a == 20) {
                                                    throw new com.haier.library.json.d("EOF error");
                                                }
                                                this.f26705a = 20;
                                                int i9 = this.f26712h;
                                                this.f26711g = i9;
                                                this.f26706b = i9;
                                                return;
                                            }
                                            if (c8 > 31 && c8 != 127) {
                                                this.f26705a = 1;
                                                v();
                                                return;
                                            } else {
                                                v();
                                                continue;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                    }
                    M();
                    return;
                }
                v();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0073 A[SYNTHETIC] */
    public final void y(int i7) {
        this.f26714j = 0;
        while (true) {
            if (i7 == 2) {
                char c8 = this.f26710f;
                if (c8 >= '0' && c8 <= '9') {
                    this.f26706b = this.f26711g;
                    P();
                    return;
                }
                if (c8 == '\"') {
                    this.f26706b = this.f26711g;
                    R();
                    return;
                } else if (c8 == '[') {
                    this.f26705a = 14;
                    v();
                    return;
                } else if (c8 == '{') {
                    this.f26705a = 12;
                    v();
                    return;
                }
            } else if (i7 == 4) {
                char c9 = this.f26710f;
                if (c9 == '\"') {
                    this.f26706b = this.f26711g;
                    R();
                    return;
                } else if (c9 >= '0' && c9 <= '9') {
                    this.f26706b = this.f26711g;
                    P();
                    return;
                } else if (c9 == '{') {
                    this.f26705a = 12;
                    v();
                    return;
                }
            } else if (i7 == 12) {
                char c10 = this.f26710f;
                if (c10 == '{') {
                    this.f26705a = 12;
                    v();
                    return;
                } else if (c10 == '[') {
                    this.f26705a = 14;
                    v();
                    return;
                }
            } else {
                if (i7 == 18) {
                    w();
                    return;
                }
                if (i7 != 20) {
                    switch (i7) {
                        case 14:
                            char c11 = this.f26710f;
                            if (c11 == '[') {
                                this.f26705a = 14;
                                v();
                            } else if (c11 == '{') {
                                this.f26705a = 12;
                                v();
                            }
                            break;
                        case 15:
                            if (this.f26710f == ']') {
                                this.f26705a = 15;
                                v();
                            }
                            if (this.f26710f == 26) {
                                this.f26705a = 20;
                            }
                            break;
                        case 16:
                            char c12 = this.f26710f;
                            if (c12 == ',') {
                                this.f26705a = 16;
                                v();
                            } else if (c12 == '}') {
                                this.f26705a = 13;
                                v();
                            } else if (c12 == ']') {
                                this.f26705a = 15;
                                v();
                            } else if (c12 == 26) {
                                this.f26705a = 20;
                            }
                            break;
                    }
                    return;
                }
                if (this.f26710f == 26) {
                    this.f26705a = 20;
                    return;
                }
            }
            char c13 = this.f26710f;
            if (c13 != ' ' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != '\f' && c13 != '\b') {
                x();
                return;
            }
            v();
        }
    }

    public final void z(char c8) {
        this.f26714j = 0;
        while (true) {
            char c9 = this.f26710f;
            if (c9 == c8) {
                v();
                x();
                return;
            }
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                throw new com.haier.library.json.d("not match " + c8 + " - " + this.f26710f);
            }
            v();
        }
    }

    public e(char[] cArr, int i7) {
        this(cArr, i7, com.haier.library.json.a.f26648e);
    }

    public e(char[] cArr, int i7, int i8) {
        this(new String(cArr, 0, i7), i8);
    }

    public e(String str, int i7) {
        this.f26707c = com.haier.library.json.a.f26648e;
        this.f26708d = com.haier.library.json.a.f26644a;
        this.f26709e = com.haier.library.json.a.f26645b;
        this.f26717m = null;
        this.f26718n = 0;
        char[] cArr = f26704z.get();
        this.f26713i = cArr;
        if (cArr == null) {
            this.f26713i = new char[512];
        }
        this.f26707c = i7;
        this.f26719o = str;
        this.f26720p = str.length();
        this.f26711g = -1;
        v();
        if (this.f26710f == 65279) {
            v();
        }
        this.f26721q = (d.InitStringFieldAsEmpty.f26696a & i7) != 0 ? "" : null;
        this.f26722r = (d.DisableCircularReferenceDetect.f26696a & i7) != 0;
    }
}
