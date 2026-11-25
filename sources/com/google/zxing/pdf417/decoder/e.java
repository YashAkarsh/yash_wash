package com.google.zxing.pdf417.decoder;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class e {
    private static final char[] A = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] B = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] C;
    private static final int D = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24011a = 900;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24012b = 901;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24013c = 902;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24014d = 924;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24015e = 925;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24016f = 926;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24017g = 927;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f24018h = 928;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f24019i = 923;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f24020j = 922;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f24021k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f24022l = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f24023m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f24024n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f24025o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f24026p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f24027q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f24028r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f24029s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f24030t = 25;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f24031u = 27;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f24032v = 27;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f24033w = 28;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f24034x = 28;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f24035y = 29;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f24036z = 29;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24037a;

        static {
            int[] iArr = new int[b.values().length];
            f24037a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24037a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24037a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24037a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24037a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24037a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        C = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i7 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = C;
            if (i7 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i7] = bigIntegerArr2[i7 - 1].multiply(bigIntegerValueOf);
            i7++;
        }
    }

    private e() {
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0021 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0077. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x007a. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:29:0x0064 for B:34:0x0077 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:29:0x0064 for B:35:0x007a already processed. Defaulting to fallback option. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.e.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    static com.google.zxing.common.e b(int[] iArr, String str) throws com.google.zxing.h {
        int iG;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i7 = iArr[1];
        e2.c cVar = new e2.c();
        int i8 = 2;
        while (i8 < iArr[0]) {
            if (i7 != f24021k) {
                switch (i7) {
                    case 900:
                        iG = g(iArr, i8, sb);
                        break;
                    case 901:
                        iG = a(i7, iArr, charsetForName, i8, sb);
                        break;
                    case 902:
                        iG = f(iArr, i8, sb);
                        break;
                    default:
                        switch (i7) {
                            case f24020j /* 922 */:
                            case f24019i /* 923 */:
                                throw com.google.zxing.h.a();
                            case f24014d /* 924 */:
                                iG = a(i7, iArr, charsetForName, i8, sb);
                                break;
                            case f24015e /* 925 */:
                                iG = i8 + 1;
                                break;
                            case f24016f /* 926 */:
                                iG = i8 + 2;
                                break;
                            case f24017g /* 927 */:
                                iG = i8 + 1;
                                charsetForName = Charset.forName(com.google.zxing.common.d.b(iArr[i8]).name());
                                break;
                            case 928:
                                iG = d(iArr, i8, cVar);
                                break;
                            default:
                                iG = g(iArr, i8 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                iG = i8 + 1;
                sb.append((char) iArr[i8]);
            }
            if (iG >= iArr.length) {
                throw com.google.zxing.h.a();
            }
            i8 = iG + 1;
            i7 = iArr[iG];
        }
        if (sb.length() == 0) {
            throw com.google.zxing.h.a();
        }
        com.google.zxing.common.e eVar = new com.google.zxing.common.e(null, sb.toString(), null, str);
        eVar.o(cVar);
        return eVar;
    }

    private static String c(int[] iArr, int i7) throws com.google.zxing.h {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i8 = 0; i8 < i7; i8++) {
            bigIntegerAdd = bigIntegerAdd.add(C[(i7 - i8) - 1].multiply(BigInteger.valueOf(iArr[i8])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw com.google.zxing.h.a();
    }

    static int d(int[] iArr, int i7, e2.c cVar) throws com.google.zxing.h {
        if (i7 + 2 > iArr[0]) {
            throw com.google.zxing.h.a();
        }
        int[] iArr2 = new int[2];
        int i8 = 0;
        while (i8 < 2) {
            iArr2[i8] = iArr[i7];
            i8++;
            i7++;
        }
        cVar.t(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iG = g(iArr, i7, sb);
        cVar.n(sb.toString());
        int i9 = iArr[iG] == f24019i ? iG + 1 : -1;
        while (iG < iArr[0]) {
            int i10 = iArr[iG];
            if (i10 == f24020j) {
                iG++;
                cVar.q(true);
            } else {
                if (i10 != f24019i) {
                    throw com.google.zxing.h.a();
                }
                int i11 = iG + 1;
                switch (iArr[i11]) {
                    case 0:
                        StringBuilder sb2 = new StringBuilder();
                        iG = g(iArr, i11 + 1, sb2);
                        cVar.o(sb2.toString());
                        break;
                    case 1:
                        StringBuilder sb3 = new StringBuilder();
                        iG = f(iArr, i11 + 1, sb3);
                        cVar.s(Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        StringBuilder sb4 = new StringBuilder();
                        iG = f(iArr, i11 + 1, sb4);
                        cVar.v(Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        StringBuilder sb5 = new StringBuilder();
                        iG = g(iArr, i11 + 1, sb5);
                        cVar.u(sb5.toString());
                        break;
                    case 4:
                        StringBuilder sb6 = new StringBuilder();
                        iG = g(iArr, i11 + 1, sb6);
                        cVar.l(sb6.toString());
                        break;
                    case 5:
                        StringBuilder sb7 = new StringBuilder();
                        iG = f(iArr, i11 + 1, sb7);
                        cVar.p(Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        StringBuilder sb8 = new StringBuilder();
                        iG = f(iArr, i11 + 1, sb8);
                        cVar.m(Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw com.google.zxing.h.a();
                }
            }
        }
        if (i9 != -1) {
            int i12 = iG - i9;
            if (cVar.k()) {
                i12--;
            }
            cVar.r(Arrays.copyOfRange(iArr, i9, i12 + i9));
        }
        return iG;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i7, StringBuilder sb) {
        b bVar;
        int i8;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = iArr[i9];
            char c8 = ' ';
            switch (a.f24037a[bVar2.ordinal()]) {
                case 1:
                    if (i10 < 26) {
                        i8 = i10 + 65;
                        c8 = (char) i8;
                    } else {
                        if (i10 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i10 != f24021k) {
                            switch (i10) {
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c8 = 0;
                                    b bVar4 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i9]);
                        }
                        c8 = 0;
                    }
                    break;
                case 2:
                    if (i10 < 26) {
                        i8 = i10 + 97;
                        c8 = (char) i8;
                    } else {
                        if (i10 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i10 != f24021k) {
                            switch (i10) {
                                case 27:
                                    bVar = b.ALPHA_SHIFT;
                                    c8 = 0;
                                    b bVar5 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar5;
                                    break;
                                case 28:
                                    bVar2 = b.MIXED;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c8 = 0;
                                    b bVar6 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar6;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i9]);
                        }
                        c8 = 0;
                    }
                    break;
                case 3:
                    if (i10 < 25) {
                        c8 = B[i10];
                    } else {
                        if (i10 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i10 != f24021k) {
                            switch (i10) {
                                case 25:
                                    bVar2 = b.PUNCT;
                                    break;
                                case 27:
                                    bVar2 = b.LOWER;
                                    break;
                                case 28:
                                    bVar2 = b.ALPHA;
                                    break;
                                case 29:
                                    bVar = b.PUNCT_SHIFT;
                                    c8 = 0;
                                    b bVar7 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar7;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i9]);
                        }
                        c8 = 0;
                    }
                    break;
                case 4:
                    if (i10 < 29) {
                        c8 = A[i10];
                    } else {
                        if (i10 == 29 || i10 == 900) {
                            bVar2 = b.ALPHA;
                        } else if (i10 == f24021k) {
                            sb.append((char) iArr2[i9]);
                        }
                        c8 = 0;
                    }
                    break;
                case 5:
                    if (i10 < 26) {
                        c8 = (char) (i10 + 65);
                    } else if (i10 != 26) {
                        bVar2 = i10 != 900 ? bVar3 : b.ALPHA;
                        c8 = 0;
                    }
                    bVar2 = bVar3;
                    break;
                case 6:
                    if (i10 < 29) {
                        c8 = A[i10];
                    } else if (i10 == 29 || i10 == 900) {
                        bVar2 = b.ALPHA;
                        c8 = 0;
                    } else {
                        if (i10 == f24021k) {
                            sb.append((char) iArr2[i9]);
                        }
                        c8 = 0;
                    }
                    bVar2 = bVar3;
                    break;
                default:
                    c8 = 0;
                    break;
            }
            if (c8 != 0) {
                sb.append(c8);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    private static int f(int[] iArr, int i7, StringBuilder sb) throws com.google.zxing.h {
        int[] iArr2 = new int[15];
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            int i9 = iArr[0];
            if (i7 < i9 && !z7) {
                int i10 = i7 + 1;
                int i11 = iArr[i7];
                if (i10 == i9) {
                    z7 = true;
                }
                if (i11 >= 900) {
                    if (i11 != 900 && i11 != 901 && i11 != 928) {
                        switch (i11) {
                            case f24020j /* 922 */:
                            case f24019i /* 923 */:
                            case f24014d /* 924 */:
                                i10--;
                                z7 = true;
                                break;
                        }
                    } else {
                        i10--;
                        z7 = true;
                    }
                } else {
                    iArr2[i8] = i11;
                    i8++;
                }
                if ((i8 % 15 == 0 || i11 == 902 || z7) && i8 > 0) {
                    sb.append(c(iArr2, i8));
                    i8 = 0;
                }
                i7 = i10;
            }
        }
        return i7;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    private static int g(int[] iArr, int i7, StringBuilder sb) {
        int i8 = iArr[0];
        int[] iArr2 = new int[(i8 - i7) << 1];
        int[] iArr3 = new int[(i8 - i7) << 1];
        boolean z7 = false;
        int i9 = 0;
        while (i7 < iArr[0] && !z7) {
            int i10 = i7 + 1;
            int i11 = iArr[i7];
            if (i11 < 900) {
                iArr2[i9] = i11 / 30;
                iArr2[i9 + 1] = i11 % 30;
                i9 += 2;
            } else if (i11 != f24021k) {
                if (i11 != 928) {
                    switch (i11) {
                        case 900:
                            iArr2[i9] = 900;
                            i9++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i11) {
                                case f24020j /* 922 */:
                                case f24019i /* 923 */:
                                case f24014d /* 924 */:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                i7 = i10 - 1;
                z7 = true;
            } else {
                iArr2[i9] = f24021k;
                i7 = i10 + 1;
                iArr3[i9] = iArr[i10];
                i9++;
            }
            i7 = i10;
        }
        e(iArr2, iArr3, i9, sb);
        return i7;
    }
}
