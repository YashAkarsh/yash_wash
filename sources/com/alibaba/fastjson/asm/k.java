package com.alibaba.fastjson.asm;

import androidx.constraintlayout.core.motion.utils.w;
import androidx.constraintlayout.widget.ConstraintLayout;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f12633e = new k(0, null, 1443168256, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f12634f = new k(1, null, 1509950721, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f12635g = new k(2, null, 1124075009, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f12636h = new k(3, null, 1107297537, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f12637i = new k(4, null, 1392510721, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f12638j = new k(5, null, 1224736769, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k f12639k = new k(6, null, 1174536705, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k f12640l = new k(7, null, 1241579778, 1);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final k f12641m = new k(8, null, 1141048066, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f12642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f12643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12645d;

    private k(int i7, char[] cArr, int i8, int i9) {
        this.f12642a = i7;
        this.f12643b = cArr;
        this.f12644c = i8;
        this.f12645d = i9;
    }

    static k[] a(String str) {
        char[] charArray = str.toCharArray();
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        while (true) {
            int i10 = i8 + 1;
            char c8 = charArray[i8];
            if (c8 == ')') {
                break;
            }
            if (c8 == 'L') {
                while (true) {
                    i8 = i10 + 1;
                    if (charArray[i10] == ';') {
                        break;
                    }
                    i10 = i8;
                }
                i9++;
            } else {
                if (c8 != '[') {
                    i9++;
                }
                i8 = i10;
            }
        }
        k[] kVarArr = new k[i9];
        int i11 = 0;
        while (charArray[i7] != ')') {
            k kVarH = h(charArray, i7);
            kVarArr[i11] = kVarH;
            i7 += kVarH.f12645d + (kVarH.f12642a == 10 ? 2 : 0);
            i11++;
        }
        return kVarArr;
    }

    public static int b(String str) {
        int i7;
        int i8 = 1;
        int i9 = 1;
        int i10 = 1;
        while (true) {
            i7 = i9 + 1;
            char cCharAt = str.charAt(i9);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt == 'L') {
                while (true) {
                    i9 = i7 + 1;
                    if (str.charAt(i7) == ';') {
                        break;
                    }
                    i7 = i9;
                }
                i10++;
            } else {
                i10 = (cCharAt == 'D' || cCharAt == 'J') ? i10 + 2 : i10 + 1;
                i9 = i7;
            }
        }
        char cCharAt2 = str.charAt(i7);
        int i11 = i10 << 2;
        if (cCharAt2 == 'V') {
            i8 = 0;
        } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
            i8 = 2;
        }
        return i11 | i8;
    }

    private int e() {
        int i7 = 1;
        while (this.f12643b[this.f12644c + i7] == '[') {
            i7++;
        }
        return i7;
    }

    public static k g(String str) {
        return h(str.toCharArray(), 0);
    }

    private static k h(char[] cArr, int i7) {
        char c8;
        char c9 = cArr[i7];
        if (c9 == 'F') {
            return f12639k;
        }
        if (c9 == 'S') {
            return f12637i;
        }
        if (c9 == 'V') {
            return f12633e;
        }
        if (c9 == 'I') {
            return f12638j;
        }
        if (c9 == 'J') {
            return f12640l;
        }
        if (c9 == 'Z') {
            return f12634f;
        }
        if (c9 != '[') {
            switch (c9) {
                case 'B':
                    return f12636h;
                case ConstraintLayout.LayoutParams.a.f4583h0 /* 67 */:
                    return f12635g;
                case f4.d.f33912b /* 68 */:
                    return f12641m;
                default:
                    int i8 = 1;
                    while (cArr[i7 + i8] != ';') {
                        i8++;
                    }
                    return new k(10, cArr, i7 + 1, i8 - 1);
            }
        }
        int i9 = 1;
        while (true) {
            c8 = cArr[i7 + i9];
            if (c8 != '[') {
                break;
            }
            i9++;
        }
        if (c8 == 'L') {
            do {
                i9++;
            } while (cArr[i7 + i9] != ';');
        }
        return new k(9, cArr, i7, i9 + 1);
    }

    protected String c() {
        switch (this.f12642a) {
            case 0:
                return "void";
            case 1:
                return w.b.f3031f;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return w.b.f3028c;
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer = new StringBuffer(h(this.f12643b, this.f12644c + e()).c());
                for (int iE = e(); iE > 0; iE--) {
                    stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return stringBuffer.toString();
            default:
                return new String(this.f12643b, this.f12644c, this.f12645d).replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }

    String d() {
        return new String(this.f12643b, this.f12644c, this.f12645d);
    }

    public String f() {
        return new String(this.f12643b, this.f12644c, this.f12645d);
    }
}
