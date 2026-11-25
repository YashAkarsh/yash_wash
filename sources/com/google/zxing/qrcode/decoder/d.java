package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f24139a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24140b = 1;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24141a;

        static {
            int[] iArr = new int[h.values().length];
            f24141a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24141a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24141a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24141a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24141a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24141a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24141a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f24141a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f24141a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f24141a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private d() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d8 A[LOOP:0: B:53:0x001e->B:50:0x00d8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    static com.google.zxing.common.e a(byte[] bArr, j jVar, f fVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.h {
        ?? r15;
        ArrayList arrayList;
        String string;
        com.google.zxing.common.c cVar = new com.google.zxing.common.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i7 = 1;
        ArrayList arrayList2 = new ArrayList(1);
        int i8 = -1;
        int iD = -1;
        ?? r16 = 0;
        com.google.zxing.common.d dVarB = null;
        while (true) {
            try {
                h hVarA = cVar.a() < 4 ? h.TERMINATOR : h.a(cVar.d(4));
                int[] iArr = a.f24141a;
                ?? r17 = r16;
                switch (iArr[hVarA.ordinal()]) {
                    case 5:
                        r15 = r17;
                        if (hVarA == h.TERMINATOR) {
                            String string2 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string2, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                    case 6:
                    case 7:
                        r17 = i7;
                        r15 = r17;
                        if (hVarA == h.TERMINATOR) {
                            String string3 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string3, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                    case 8:
                        if (cVar.a() < 16) {
                            throw com.google.zxing.h.a();
                        }
                        int iD2 = cVar.d(8);
                        iD = cVar.d(8);
                        i8 = iD2;
                        r17 = r16;
                        r15 = r17;
                        if (hVarA == h.TERMINATOR) {
                            String string4 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string4, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                        break;
                    case 9:
                        dVarB = com.google.zxing.common.d.b(g(cVar));
                        if (dVarB == null) {
                            throw com.google.zxing.h.a();
                        }
                        r17 = r16;
                        r15 = r17;
                        if (hVarA == h.TERMINATOR) {
                            String string5 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string5, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                        break;
                    case 10:
                        int iD3 = cVar.d(4);
                        int iD4 = cVar.d(hVarA.c(jVar));
                        r17 = r16;
                        if (iD3 == i7) {
                            d(cVar, sb, iD4);
                            r17 = r16;
                        }
                        r15 = r17;
                        if (hVarA == h.TERMINATOR) {
                            String string6 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string6, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                    default:
                        int iD5 = cVar.d(hVarA.c(jVar));
                        int i9 = iArr[hVarA.ordinal()];
                        if (i9 == i7) {
                            f(cVar, sb, iD5);
                            r15 = r16;
                        } else if (i9 == 2) {
                            b(cVar, sb, iD5, r16);
                            r15 = r16;
                        } else if (i9 == 3) {
                            c(cVar, sb, iD5, dVarB, arrayList2, map);
                            r15 = r16;
                        } else {
                            if (i9 != 4) {
                                throw com.google.zxing.h.a();
                            }
                            e(cVar, sb, iD5);
                            r17 = r16;
                            r15 = r17;
                        }
                        if (hVarA == h.TERMINATOR) {
                            String string7 = sb.toString();
                            if (arrayList2.isEmpty()) {
                                arrayList = null;
                            } else {
                                arrayList = arrayList2;
                            }
                            if (fVar == null) {
                                string = null;
                            } else {
                                string = fVar.toString();
                            }
                            return new com.google.zxing.common.e(bArr, string7, arrayList, string, i8, iD);
                        }
                        i7 = 1;
                        r16 = r15;
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw com.google.zxing.h.a();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    private static void b(com.google.zxing.common.c cVar, StringBuilder sb, int i7, boolean z7) throws com.google.zxing.h {
        while (i7 > 1) {
            if (cVar.a() < 11) {
                throw com.google.zxing.h.a();
            }
            int iD = cVar.d(11);
            sb.append(h(iD / 45));
            sb.append(h(iD % 45));
            i7 -= 2;
        }
        if (i7 == 1) {
            if (cVar.a() < 6) {
                throw com.google.zxing.h.a();
            }
            sb.append(h(cVar.d(6)));
        }
        if (z7) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i8 = length + 1;
                        if (sb.charAt(i8) == '%') {
                            sb.deleteCharAt(i8);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static void c(com.google.zxing.common.c cVar, StringBuilder sb, int i7, com.google.zxing.common.d dVar, Collection<byte[]> collection, Map<com.google.zxing.e, ?> map) throws com.google.zxing.h {
        if ((i7 << 3) > cVar.a()) {
            throw com.google.zxing.h.a();
        }
        byte[] bArr = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            bArr[i8] = (byte) cVar.d(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.a();
        }
    }

    private static void d(com.google.zxing.common.c cVar, StringBuilder sb, int i7) throws com.google.zxing.h {
        if (i7 * 13 > cVar.a()) {
            throw com.google.zxing.h.a();
        }
        byte[] bArr = new byte[i7 * 2];
        int i8 = 0;
        while (i7 > 0) {
            int iD = cVar.d(13);
            int i9 = (iD % 96) | ((iD / 96) << 8);
            int i10 = i9 + (i9 < 959 ? 41377 : 42657);
            bArr[i8] = (byte) (i10 >> 8);
            bArr[i8 + 1] = (byte) i10;
            i8 += 2;
            i7--;
        }
        try {
            sb.append(new String(bArr, l.f23594c));
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.a();
        }
    }

    private static void e(com.google.zxing.common.c cVar, StringBuilder sb, int i7) throws com.google.zxing.h {
        if (i7 * 13 > cVar.a()) {
            throw com.google.zxing.h.a();
        }
        byte[] bArr = new byte[i7 * 2];
        int i8 = 0;
        while (i7 > 0) {
            int iD = cVar.d(13);
            int i9 = (iD % com.alibaba.fastjson.asm.j.f12606c0) | ((iD / com.alibaba.fastjson.asm.j.f12606c0) << 8);
            int i10 = i9 + (i9 < 7936 ? 33088 : 49472);
            bArr[i8] = (byte) (i10 >> 8);
            bArr[i8 + 1] = (byte) i10;
            i8 += 2;
            i7--;
        }
        try {
            sb.append(new String(bArr, l.f23593b));
        } catch (UnsupportedEncodingException unused) {
            throw com.google.zxing.h.a();
        }
    }

    private static void f(com.google.zxing.common.c cVar, StringBuilder sb, int i7) throws com.google.zxing.h {
        while (i7 >= 3) {
            if (cVar.a() < 10) {
                throw com.google.zxing.h.a();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw com.google.zxing.h.a();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i7 -= 3;
        }
        if (i7 == 2) {
            if (cVar.a() < 7) {
                throw com.google.zxing.h.a();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw com.google.zxing.h.a();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i7 == 1) {
            if (cVar.a() < 4) {
                throw com.google.zxing.h.a();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw com.google.zxing.h.a();
            }
            sb.append(h(iD3));
        }
    }

    private static int g(com.google.zxing.common.c cVar) throws com.google.zxing.h {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & com.alibaba.fastjson.asm.j.f12606c0) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw com.google.zxing.h.a();
    }

    private static char h(int i7) throws com.google.zxing.h {
        char[] cArr = f24139a;
        if (i7 < cArr.length) {
            return cArr[i7];
        }
        throw com.google.zxing.h.a();
    }
}
