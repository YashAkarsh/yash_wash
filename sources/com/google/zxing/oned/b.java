package com.google.zxing.oned;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f23800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f23801b = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f23802c = {'/', ':', '+', ClassUtils.PACKAGE_SEPARATOR_CHAR};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f23803d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f23800a = cArr;
        f23803d = cArr[0];
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int i7;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c8 = f23803d;
            sb.append(c8);
            sb.append(str);
            sb.append(c8);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f23800a;
            boolean zH = a.h(cArr, upperCase);
            boolean zH2 = a.h(cArr, upperCase2);
            char[] cArr2 = f23801b;
            boolean zH3 = a.h(cArr2, upperCase);
            boolean zH4 = a.h(cArr2, upperCase2);
            if (zH) {
                if (!zH2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!zH3) {
                if (zH2 || zH4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
                StringBuilder sb2 = new StringBuilder();
                char c9 = f23803d;
                sb2.append(c9);
                sb2.append(str);
                sb2.append(c9);
                str = sb2.toString();
            } else if (!zH4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i8 = 20;
        for (int i9 = 1; i9 < str.length() - 1; i9++) {
            if (Character.isDigit(str.charAt(i9)) || str.charAt(i9) == '-' || str.charAt(i9) == '$') {
                i8 += 9;
            } else {
                if (!a.h(f23802c, str.charAt(i9))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i9) + '\'');
                }
                i8 += 10;
            }
        }
        boolean[] zArr = new boolean[i8 + (str.length() - 1)];
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i11));
            if (i11 == 0 || i11 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i12 = 0;
            while (true) {
                char[] cArr3 = a.f23790g;
                if (i12 >= cArr3.length) {
                    i7 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i12]) {
                    i7 = a.f23791h[i12];
                    break;
                }
                i12++;
            }
            int i13 = 0;
            int i14 = 0;
            boolean z7 = true;
            while (i13 < 7) {
                zArr[i10] = z7;
                i10++;
                if (((i7 >> (6 - i13)) & 1) == 0 || i14 == 1) {
                    z7 = !z7;
                    i13++;
                    i14 = 0;
                } else {
                    i14++;
                }
            }
            if (i11 < str.length() - 1) {
                zArr[i10] = false;
                i10++;
            }
        }
        return zArr;
    }
}
