package com.google.zxing.common;

import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f23593b = "SJIS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23594c = "GB2312";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f23595d = "EUC_JP";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f23596e = "UTF8";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f23597f = "ISO8859_1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f23598g;

    static {
        String strName = Charset.defaultCharset().name();
        f23592a = strName;
        f23598g = f23593b.equalsIgnoreCase(strName) || f23595d.equalsIgnoreCase(strName);
    }

    private l() {
    }

    /* JADX WARN: Code duplicated, block: B:42:0x007e A[PHI: r10
      0x007e: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:32:0x0061, B:40:0x0079, B:27:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x00eb  */
    public static String a(byte[] bArr, Map<com.google.zxing.e, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            com.google.zxing.e eVar = com.google.zxing.e.CHARACTER_SET;
            if (map.containsKey(eVar)) {
                return map.get(eVar).toString();
            }
        }
        int length = bArr2.length;
        boolean z7 = true;
        int i7 = 0;
        boolean z8 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z9 = true;
        boolean z10 = true;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i9 < length && (z7 || z9 || z10)) {
            int i19 = bArr2[i9] & 255;
            if (z10) {
                if (i10 > 0) {
                    if ((i19 & 128) != 0) {
                        i10--;
                    } else {
                        z10 = false;
                    }
                } else if ((i19 & 128) != 0) {
                    if ((i19 & 64) != 0) {
                        i10++;
                        if ((i19 & 32) == 0) {
                            i12++;
                        } else {
                            i10++;
                            if ((i19 & 16) == 0) {
                                i13++;
                            } else {
                                i10++;
                                if ((i19 & 8) == 0) {
                                    i14++;
                                } else {
                                    z10 = false;
                                }
                            }
                        }
                    } else {
                        z10 = false;
                    }
                }
            }
            if (z7) {
                if (i19 > 127 && i19 < 160) {
                    z7 = false;
                } else if (i19 > 159 && (i19 < 192 || i19 == 215 || i19 == 247)) {
                    i16++;
                }
            }
            if (z9) {
                if (i11 > 0) {
                    if (i19 < 64 || i19 == 127 || i19 > 252) {
                        z9 = false;
                    } else {
                        i11--;
                    }
                } else if (i19 == 128 || i19 == 160 || i19 > 239) {
                    z9 = false;
                } else if (i19 <= 160 || i19 >= 224) {
                    if (i19 > 127) {
                        i11++;
                        int i20 = i17 + 1;
                        if (i20 > i7) {
                            i7 = i20;
                            i17 = i7;
                        } else {
                            i17 = i20;
                        }
                    } else {
                        i17 = 0;
                    }
                    i18 = 0;
                } else {
                    i8++;
                    int i21 = i18 + 1;
                    if (i21 > i15) {
                        i15 = i21;
                        i18 = i15;
                    } else {
                        i18 = i21;
                    }
                    i17 = 0;
                }
            }
            i9++;
            bArr2 = bArr;
        }
        if (z10 && i10 > 0) {
            z10 = false;
        }
        if (z9 && i11 > 0) {
            z9 = false;
        }
        if (z10 && (z8 || i12 + i13 + i14 > 0)) {
            return f23596e;
        }
        if (z9 && (f23598g || i15 >= 3 || i7 >= 3)) {
            return f23593b;
        }
        if (z7 && z9) {
            return (!(i15 == 2 && i8 == 2) && i16 * 10 < length) ? f23597f : f23593b;
        }
        if (z7) {
            return f23597f;
        }
        if (z9) {
            return f23593b;
        }
        return z10 ? f23596e : f23592a;
    }
}
