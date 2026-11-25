package com.google.zxing.qrcode.encoder;

import com.alibaba.fastjson.asm.j;
import com.google.zxing.g;
import com.google.zxing.qrcode.decoder.h;
import com.google.zxing.w;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f24210a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f24211b = "ISO-8859-1";

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24212a;

        static {
            int[] iArr = new int[h.values().length];
            f24212a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24212a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24212a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24212a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private c() {
    }

    static void a(String str, com.google.zxing.common.a aVar, String str2) throws w {
        try {
            for (byte b8 : str.getBytes(str2)) {
                aVar.c(b8, 8);
            }
        } catch (UnsupportedEncodingException e8) {
            throw new w(e8);
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) throws w {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length) {
            int iR = r(charSequence.charAt(i7));
            if (iR == -1) {
                throw new w();
            }
            int i8 = i7 + 1;
            if (i8 < length) {
                int iR2 = r(charSequence.charAt(i8));
                if (iR2 == -1) {
                    throw new w();
                }
                aVar.c((iR * 45) + iR2, 11);
                i7 += 2;
            } else {
                aVar.c(iR, 6);
                i7 = i8;
            }
        }
    }

    static void c(String str, h hVar, com.google.zxing.common.a aVar, String str2) throws w {
        int i7 = a.f24212a[hVar.ordinal()];
        if (i7 == 1) {
            h(str, aVar);
            return;
        }
        if (i7 == 2) {
            b(str, aVar);
        } else if (i7 == 3) {
            a(str, aVar, str2);
        } else {
            if (i7 != 4) {
                throw new w("Invalid mode: ".concat(String.valueOf(hVar)));
            }
            e(str, aVar);
        }
    }

    private static void d(com.google.zxing.common.d dVar, com.google.zxing.common.a aVar) {
        aVar.c(h.ECI.b(), 4);
        aVar.c(dVar.c(), 8);
    }

    static void e(String str, com.google.zxing.common.a aVar) throws w {
        int i7;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i8 = 0; i8 < length; i8 += 2) {
                int i9 = ((bytes[i8] & 255) << 8) | (bytes[i8 + 1] & 255);
                int i10 = 33088;
                if (i9 >= 33088 && i9 <= 40956) {
                    i7 = i9 - i10;
                } else if (i9 < 57408 || i9 > 60351) {
                    i7 = -1;
                } else {
                    i10 = 49472;
                    i7 = i9 - i10;
                }
                if (i7 == -1) {
                    throw new w("Invalid byte sequence");
                }
                aVar.c(((i7 >> 8) * j.f12606c0) + (i7 & 255), 13);
            }
        } catch (UnsupportedEncodingException e8) {
            throw new w(e8);
        }
    }

    static void f(int i7, com.google.zxing.qrcode.decoder.j jVar, h hVar, com.google.zxing.common.a aVar) throws w {
        int iC = hVar.c(jVar);
        int i8 = 1 << iC;
        if (i7 < i8) {
            aVar.c(i7, iC);
            return;
        }
        throw new w(i7 + " is bigger than " + (i8 - 1));
    }

    static void g(h hVar, com.google.zxing.common.a aVar) {
        aVar.c(hVar.b(), 4);
    }

    static void h(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length) {
            int iCharAt = charSequence.charAt(i7) - '0';
            int i8 = i7 + 2;
            if (i8 < length) {
                aVar.c((iCharAt * 100) + ((charSequence.charAt(i7 + 1) - '0') * 10) + (charSequence.charAt(i8) - '0'), 10);
                i7 += 3;
            } else {
                i7++;
                if (i7 < length) {
                    aVar.c((iCharAt * 10) + (charSequence.charAt(i7) - '0'), 7);
                    i7 = i8;
                } else {
                    aVar.c(iCharAt, 4);
                }
            }
        }
    }

    private static int i(h hVar, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2, com.google.zxing.qrcode.decoder.j jVar) {
        return aVar.o() + hVar.c(jVar) + aVar2.o();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(com.google.zxing.common.a aVar, com.google.zxing.qrcode.decoder.f fVar, com.google.zxing.qrcode.decoder.j jVar, b bVar) throws w {
        int i7 = Integer.MAX_VALUE;
        int i8 = -1;
        for (int i9 = 0; i9 < 8; i9++) {
            e.a(aVar, fVar, jVar, i9, bVar);
            int iJ = j(bVar);
            if (iJ < i7) {
                i8 = i9;
                i7 = iJ;
            }
        }
        return i8;
    }

    public static h l(String str) {
        return m(str, null);
    }

    private static h m(String str, String str2) {
        if ("Shift_JIS".equals(str2) && u(str)) {
            return h.KANJI;
        }
        boolean z7 = false;
        boolean z8 = false;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z8 = true;
            } else {
                if (r(cCharAt) == -1) {
                    return h.BYTE;
                }
                z7 = true;
            }
        }
        if (z7) {
            return h.ALPHANUMERIC;
        }
        return z8 ? h.NUMERIC : h.BYTE;
    }

    private static com.google.zxing.qrcode.decoder.j n(int i7, com.google.zxing.qrcode.decoder.f fVar) throws w {
        for (int i8 = 1; i8 <= 40; i8++) {
            com.google.zxing.qrcode.decoder.j jVarI = com.google.zxing.qrcode.decoder.j.i(i8);
            if (x(i7, jVarI, fVar)) {
                return jVarI;
            }
        }
        throw new w("Data too big");
    }

    public static f o(String str, com.google.zxing.qrcode.decoder.f fVar) throws w {
        return p(str, fVar, null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    public static f p(String str, com.google.zxing.qrcode.decoder.f fVar, Map<g, ?> map) throws w {
        com.google.zxing.qrcode.decoder.j jVarV;
        com.google.zxing.common.d dVarA;
        boolean z7 = map != null && map.containsKey(g.CHARACTER_SET);
        String string = z7 ? map.get(g.CHARACTER_SET).toString() : "ISO-8859-1";
        h hVarM = m(str, string);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        h hVar = h.BYTE;
        if (hVarM == hVar && z7 && (dVarA = com.google.zxing.common.d.a(string)) != null) {
            d(dVarA, aVar);
        }
        if ((map != null && map.containsKey(g.GS1_FORMAT)) && Boolean.valueOf(map.get(g.GS1_FORMAT).toString()).booleanValue()) {
            g(h.FNC1_FIRST_POSITION, aVar);
        }
        g(hVarM, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        c(str, hVarM, aVar2, string);
        if (map != null) {
            g gVar = g.QR_VERSION;
            if (map.containsKey(gVar)) {
                jVarV = com.google.zxing.qrcode.decoder.j.i(Integer.parseInt(map.get(gVar).toString()));
                if (!x(i(hVarM, aVar, aVar2, jVarV), jVarV, fVar)) {
                    throw new w("Data too big for requested version");
                }
            } else {
                jVarV = v(fVar, hVarM, aVar, aVar2);
            }
        } else {
            jVarV = v(fVar, hVarM, aVar, aVar2);
        }
        com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
        aVar3.b(aVar);
        f(hVarM == hVar ? aVar2.p() : str.length(), jVarV, hVarM, aVar3);
        aVar3.b(aVar2);
        com.google.zxing.qrcode.decoder.j.b bVarF = jVarV.f(fVar);
        int iH = jVarV.h() - bVarF.d();
        w(iH, aVar3);
        com.google.zxing.common.a aVarT = t(aVar3, jVarV.h(), iH, bVarF.c());
        f fVar2 = new f();
        fVar2.g(fVar);
        fVar2.j(hVarM);
        fVar2.k(jVarV);
        int iE = jVarV.e();
        b bVar = new b(iE, iE);
        int iK = k(aVarT, fVar, jVarV, bVar);
        fVar2.h(iK);
        e.a(aVarT, fVar, jVarV, iK, bVar);
        fVar2.i(bVar);
        return fVar2;
    }

    static byte[] q(byte[] bArr, int i7) {
        int length = bArr.length;
        int[] iArr = new int[length + i7];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = bArr[i8] & 255;
        }
        new com.google.zxing.common.reedsolomon.d(com.google.zxing.common.reedsolomon.a.f23603l).b(iArr, i7);
        byte[] bArr2 = new byte[i7];
        for (int i9 = 0; i9 < i7; i9++) {
            bArr2[i9] = (byte) iArr[length + i9];
        }
        return bArr2;
    }

    static int r(int i7) {
        int[] iArr = f24210a;
        if (i7 < iArr.length) {
            return iArr[i7];
        }
        return -1;
    }

    static void s(int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2) throws w {
        if (i10 >= i9) {
            throw new w("Block ID too large");
        }
        int i11 = i7 % i9;
        int i12 = i9 - i11;
        int i13 = i7 / i9;
        int i14 = i13 + 1;
        int i15 = i8 / i9;
        int i16 = i15 + 1;
        int i17 = i13 - i15;
        int i18 = i14 - i16;
        if (i17 != i18) {
            throw new w("EC bytes mismatch");
        }
        if (i9 != i12 + i11) {
            throw new w("RS blocks mismatch");
        }
        if (i7 != ((i15 + i17) * i12) + ((i16 + i18) * i11)) {
            throw new w("Total bytes mismatch");
        }
        if (i10 < i12) {
            iArr[0] = i15;
            iArr2[0] = i17;
        } else {
            iArr[0] = i16;
            iArr2[0] = i18;
        }
    }

    static com.google.zxing.common.a t(com.google.zxing.common.a aVar, int i7, int i8, int i9) throws w {
        if (aVar.p() != i8) {
            throw new w("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i9);
        int i10 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            s(i7, i8, i9, i11, iArr, iArr2);
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            aVar.w(i10 << 3, bArr, 0, i12);
            byte[] bArrQ = q(bArr, iArr2[0]);
            arrayList.add(new com.google.zxing.qrcode.encoder.a(bArr, bArrQ));
            iMax = Math.max(iMax, i12);
            iMax2 = Math.max(iMax2, bArrQ.length);
            i10 += iArr[0];
        }
        if (i8 != i10) {
            throw new w("Data bytes does not match offset");
        }
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        for (int i13 = 0; i13 < iMax; i13++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((com.google.zxing.qrcode.encoder.a) it.next()).a();
                if (i13 < bArrA.length) {
                    aVar2.c(bArrA[i13], 8);
                }
            }
        }
        for (int i14 = 0; i14 < iMax2; i14++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((com.google.zxing.qrcode.encoder.a) it2.next()).b();
                if (i14 < bArrB.length) {
                    aVar2.c(bArrB[i14], 8);
                }
            }
        }
        if (i7 == aVar2.p()) {
            return aVar2;
        }
        throw new w("Interleaving error: " + i7 + " and " + aVar2.p() + " differ.");
    }

    private static boolean u(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i7 = 0; i7 < length; i7 += 2) {
                int i8 = bytes[i7] & 255;
                if ((i8 < 129 || i8 > 159) && (i8 < 224 || i8 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static com.google.zxing.qrcode.decoder.j v(com.google.zxing.qrcode.decoder.f fVar, h hVar, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2) throws w {
        return n(i(hVar, aVar, aVar2, n(i(hVar, aVar, aVar2, com.google.zxing.qrcode.decoder.j.i(1)), fVar)), fVar);
    }

    static void w(int i7, com.google.zxing.common.a aVar) throws w {
        int i8 = i7 << 3;
        if (aVar.o() > i8) {
            throw new w("data bits cannot fit in the QR Code" + aVar.o() + " > " + i8);
        }
        for (int i9 = 0; i9 < 4 && aVar.o() < i8; i9++) {
            aVar.a(false);
        }
        int iO = aVar.o() & 7;
        if (iO > 0) {
            while (iO < 8) {
                aVar.a(false);
                iO++;
            }
        }
        int iP = i7 - aVar.p();
        for (int i10 = 0; i10 < iP; i10++) {
            aVar.c((i10 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.o() != i8) {
            throw new w("Bits size does not equal capacity");
        }
    }

    private static boolean x(int i7, com.google.zxing.qrcode.decoder.j jVar, com.google.zxing.qrcode.decoder.f fVar) {
        return jVar.h() - jVar.f(fVar).d() >= (i7 + 7) / 8;
    }
}
