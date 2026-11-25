package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[][] f23805a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f23806b = 0.25f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f23807c = 0.7f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23808d = 98;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23809e = 99;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23810f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f23811g = 101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f23812h = 102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f23813i = 97;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f23814j = 96;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f23815k = 101;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f23816l = 100;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f23817m = 103;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f23818n = 104;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f23819o = 105;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f23820p = 106;

    private static int h(com.google.zxing.common.a aVar, int[] iArr, int i7) throws com.google.zxing.m {
        r.f(aVar, i7, iArr);
        float f8 = f23806b;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int[][] iArr2 = f23805a;
            if (i9 >= iArr2.length) {
                break;
            }
            float fE = r.e(iArr, iArr2[i9], f23807c);
            if (fE < f8) {
                i8 = i9;
                f8 = fE;
            }
            i9++;
        }
        if (i8 >= 0) {
            return i8;
        }
        throw com.google.zxing.m.a();
    }

    private static int[] i(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int iO = aVar.o();
        int iM = aVar.m(0);
        int[] iArr = new int[6];
        boolean z7 = false;
        int i7 = 0;
        int i8 = iM;
        while (iM < iO) {
            if (aVar.k(iM) != z7) {
                iArr[i7] = iArr[i7] + 1;
            } else {
                if (i7 == 5) {
                    int i9 = -1;
                    float f8 = f23806b;
                    for (int i10 = 103; i10 <= 105; i10++) {
                        float fE = r.e(iArr, f23805a[i10], f23807c);
                        if (fE < f8) {
                            i9 = i10;
                            f8 = fE;
                        }
                    }
                    if (i9 >= 0 && aVar.q(Math.max(0, i8 - ((iM - i8) / 2)), i8, false)) {
                        return new int[]{i8, iM, i9};
                    }
                    i8 += iArr[0] + iArr[1];
                    int i11 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i11);
                    iArr[i11] = 0;
                    iArr[i7] = 0;
                    i7--;
                } else {
                    i7++;
                }
                iArr[i7] = 1;
                z7 = !z7;
            }
            iM++;
        }
        throw com.google.zxing.m.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x015e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0164  */
    /* JADX WARN: Code duplicated, block: B:103:0x0168  */
    /* JADX WARN: Code duplicated, block: B:104:0x016e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0172  */
    /* JADX WARN: Code duplicated, block: B:107:0x0174  */
    /* JADX WARN: Code duplicated, block: B:111:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x017f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0181  */
    /* JADX WARN: Code duplicated, block: B:139:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0182 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    /* JADX WARN: Code duplicated, block: B:19:0x006a  */
    /* JADX WARN: Code duplicated, block: B:21:0x006e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0079 A[LOOP:1: B:23:0x0077->B:24:0x0079, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0093  */
    /* JADX WARN: Code duplicated, block: B:33:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00be  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00db  */
    /* JADX WARN: Code duplicated, block: B:51:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:64:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0106  */
    /* JADX WARN: Code duplicated, block: B:67:0x010a  */
    /* JADX WARN: Code duplicated, block: B:69:0x010e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0110  */
    /* JADX WARN: Code duplicated, block: B:72:0x0116  */
    /* JADX WARN: Code duplicated, block: B:73:0x011a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0120  */
    /* JADX WARN: Code duplicated, block: B:75:0x0122  */
    /* JADX WARN: Code duplicated, block: B:76:0x0124 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x0126 A[PHI: r17
      0x0126: PHI (r17v13 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:76:0x0124, B:51:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x012a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:80:0x012c A[PHI: r17
      0x012c: PHI (r17v12 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:79:0x012a, B:54:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x012e A[PHI: r17
      0x012e: PHI (r17v11 boolean) = (r17v6 boolean), (r17v6 boolean), (r17v16 boolean), (r17v16 boolean) binds: [B:78:0x0128, B:79:0x012a, B:53:0x00e0, B:54:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x0131 A[PHI: r17
      0x0131: PHI (r17v10 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:67:0x010a, B:43:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x0137  */
    /* JADX WARN: Code duplicated, block: B:85:0x013b A[PHI: r17
      0x013b: PHI (r17v8 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:66:0x0108, B:42:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x0141  */
    /* JADX WARN: Code duplicated, block: B:90:0x0145  */
    /* JADX WARN: Code duplicated, block: B:92:0x0149  */
    /* JADX WARN: Code duplicated, block: B:94:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0154  */
    /* JADX WARN: Code duplicated, block: B:97:0x0158  */
    /* JADX WARN: Code duplicated, block: B:99:0x015c  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x0093
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int r25, com.google.zxing.common.a r26, java.util.Map<com.google.zxing.e, ?> r27) throws com.google.zxing.m, com.google.zxing.h, com.google.zxing.d {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.c.c(int, com.google.zxing.common.a, java.util.Map):com.google.zxing.r");
    }
}
