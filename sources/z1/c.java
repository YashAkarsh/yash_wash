package z1;

import com.google.zxing.g;
import com.google.zxing.v;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements v {
    private static com.google.zxing.common.b c(String str, com.google.zxing.a aVar, int i7, int i8, Charset charset, int i9, int i10) {
        if (aVar == com.google.zxing.a.AZTEC) {
            return d(com.google.zxing.aztec.encoder.c.e(str.getBytes(charset), i9, i10), i7, i8);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static com.google.zxing.common.b d(com.google.zxing.aztec.encoder.a aVar, int i7, int i8) {
        com.google.zxing.common.b bVarC = aVar.c();
        if (bVarC == null) {
            throw new IllegalStateException();
        }
        int iQ = bVarC.q();
        int iM = bVarC.m();
        int iMax = Math.max(i7, iQ);
        int iMax2 = Math.max(i8, iM);
        int iMin = Math.min(iMax / iQ, iMax2 / iM);
        int i9 = (iMax - (iQ * iMin)) / 2;
        int i10 = (iMax2 - (iM * iMin)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(iMax, iMax2);
        int i11 = 0;
        while (i11 < iM) {
            int i12 = 0;
            int i13 = i9;
            while (i12 < iQ) {
                if (bVarC.j(i12, i11)) {
                    bVar.v(i13, i10, iMin, iMin);
                }
                i12++;
                i13 += iMin;
            }
            i11++;
            i10 += iMin;
        }
        return bVar;
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<g, ?> map) {
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i9 = 33;
        int i10 = 0;
        if (map != null) {
            g gVar = g.CHARACTER_SET;
            if (map.containsKey(gVar)) {
                charsetForName = Charset.forName(map.get(gVar).toString());
            }
            g gVar2 = g.ERROR_CORRECTION;
            i9 = map.containsKey(gVar2) ? Integer.parseInt(map.get(gVar2).toString()) : 33;
            g gVar3 = g.AZTEC_LAYERS;
            if (map.containsKey(gVar3)) {
                i10 = Integer.parseInt(map.get(gVar3).toString());
            }
        }
        return c(str, aVar, i7, i8, charsetForName, i9, i10);
    }
}
