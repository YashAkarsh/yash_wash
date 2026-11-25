package e2;

import com.google.zxing.g;
import com.google.zxing.pdf417.encoder.e;
import com.google.zxing.v;
import com.google.zxing.w;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f33535a = 30;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f33536b = 2;

    private static com.google.zxing.common.b c(byte[][] bArr, int i7) {
        int i8 = i7 * 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(bArr[0].length + i8, bArr.length + i8);
        bVar.e();
        int iM = (bVar.m() - i7) - 1;
        int i9 = 0;
        while (i9 < bArr.length) {
            byte[] bArr2 = bArr[i9];
            for (int i10 = 0; i10 < bArr[0].length; i10++) {
                if (bArr2[i10] == 1) {
                    bVar.u(i10 + i7, iM);
                }
            }
            i9++;
            iM--;
        }
        return bVar;
    }

    private static com.google.zxing.common.b d(e eVar, String str, int i7, int i8, int i9, int i10) throws w {
        boolean z7;
        eVar.e(str, i7);
        byte[][] bArrC = eVar.f().c(1, 4);
        if ((i9 > i8) != (bArrC[0].length < bArrC.length)) {
            bArrC = e(bArrC);
            z7 = true;
        } else {
            z7 = false;
        }
        int length = i8 / bArrC[0].length;
        int length2 = i9 / bArrC.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return c(bArrC, i10);
        }
        byte[][] bArrC2 = eVar.f().c(length, length << 2);
        if (z7) {
            bArrC2 = e(bArrC2);
        }
        return c(bArrC2, i10);
    }

    private static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i7 = 0; i7 < bArr.length; i7++) {
            int length = (bArr.length - i7) - 1;
            for (int i8 = 0; i8 < bArr[0].length; i8++) {
                bArr2[i8][length] = bArr[i7][i8];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) throws w {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<g, ?> map) throws w {
        if (aVar != com.google.zxing.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
        }
        e eVar = new e();
        int i9 = 30;
        int i10 = 2;
        if (map != null) {
            g gVar = g.PDF417_COMPACT;
            if (map.containsKey(gVar)) {
                eVar.h(Boolean.valueOf(map.get(gVar).toString()).booleanValue());
            }
            g gVar2 = g.PDF417_COMPACTION;
            if (map.containsKey(gVar2)) {
                eVar.i(com.google.zxing.pdf417.encoder.c.valueOf(map.get(gVar2).toString()));
            }
            g gVar3 = g.PDF417_DIMENSIONS;
            if (map.containsKey(gVar3)) {
                com.google.zxing.pdf417.encoder.d dVar = (com.google.zxing.pdf417.encoder.d) map.get(gVar3);
                eVar.j(dVar.a(), dVar.c(), dVar.b(), dVar.d());
            }
            g gVar4 = g.MARGIN;
            i9 = map.containsKey(gVar4) ? Integer.parseInt(map.get(gVar4).toString()) : 30;
            g gVar5 = g.ERROR_CORRECTION;
            i10 = map.containsKey(gVar5) ? Integer.parseInt(map.get(gVar5).toString()) : 2;
            g gVar6 = g.CHARACTER_SET;
            if (map.containsKey(gVar6)) {
                eVar.k(Charset.forName(map.get(gVar6).toString()));
            }
        }
        return d(eVar, str, i10, i7, i8, i9);
    }
}
