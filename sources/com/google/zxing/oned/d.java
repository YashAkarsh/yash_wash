package com.google.zxing.oned;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23821a = 103;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f23822b = 104;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23823c = 105;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23824d = 101;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23825e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23826f = 99;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f23827g = 106;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f23828h = 241;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f23829i = 242;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char f23830j = 243;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char f23831k = 244;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f23832l = 102;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f23833m = 97;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f23834n = 96;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f23835o = 101;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f23836p = 100;

    private enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int g(CharSequence charSequence, int i7, int i8) {
        a aVarH;
        a aVarH2;
        char cCharAt;
        a aVarH3 = h(charSequence, i7);
        a aVar = a.ONE_DIGIT;
        if (aVarH3 == aVar) {
            return 100;
        }
        a aVar2 = a.UNCODABLE;
        if (aVarH3 == aVar2) {
            return (i7 >= charSequence.length() || ((cCharAt = charSequence.charAt(i7)) >= ' ' && (i8 != 101 || cCharAt >= '`'))) ? 100 : 101;
        }
        if (i8 == 99) {
            return 99;
        }
        if (i8 != 100) {
            if (aVarH3 == a.FNC_1) {
                aVarH3 = h(charSequence, i7 + 1);
            }
            return aVarH3 == a.TWO_DIGITS ? 99 : 100;
        }
        a aVar3 = a.FNC_1;
        if (aVarH3 == aVar3 || (aVarH = h(charSequence, i7 + 2)) == aVar2 || aVarH == aVar) {
            return 100;
        }
        if (aVarH == aVar3) {
            return h(charSequence, i7 + 3) == a.TWO_DIGITS ? 99 : 100;
        }
        int i9 = i7 + 4;
        while (true) {
            aVarH2 = h(charSequence, i9);
            if (aVarH2 != a.TWO_DIGITS) {
                break;
            }
            i9 += 2;
        }
        return aVarH2 == a.ONE_DIGIT ? 100 : 99;
    }

    private static a h(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        if (i7 >= length) {
            return a.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i7);
        if (cCharAt == 241) {
            return a.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return a.UNCODABLE;
        }
        int i8 = i7 + 1;
        if (i8 >= length) {
            return a.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i8);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.CODE_128) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int iC = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt)));
                    }
                    break;
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        while (true) {
            int i12 = 103;
            if (i8 >= length) {
                int[][] iArr = c.f23805a;
                arrayList.add(iArr[i9 % 103]);
                arrayList.add(iArr[106]);
                int i13 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i14 : iArr2) {
                        i13 += i14;
                    }
                }
                boolean[] zArr = new boolean[i13];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iC += s.c(zArr, iC, (int[]) it.next(), true);
                }
                return zArr;
            }
            int iG = g(str, i8, i10);
            int iCharAt = 100;
            if (iG == i10) {
                switch (str.charAt(i8)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = f23833m;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i10 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i10 == 100) {
                            iCharAt = str.charAt(i8) - ' ';
                        } else if (i10 != 101) {
                            iCharAt = Integer.parseInt(str.substring(i8, i8 + 2));
                            i8++;
                        } else {
                            iCharAt = str.charAt(i8) - ' ';
                            if (iCharAt < 0) {
                                iCharAt += 96;
                            }
                        }
                        break;
                }
                i8++;
            } else {
                if (i10 != 0) {
                    i12 = iG;
                } else if (iG == 100) {
                    i12 = 104;
                } else if (iG != 101) {
                    i12 = 105;
                }
                iCharAt = i12;
                i10 = iG;
            }
            arrayList.add(c.f23805a[iCharAt]);
            i9 += iCharAt * i11;
            if (i8 != 0) {
                i11++;
            }
        }
    }
}
