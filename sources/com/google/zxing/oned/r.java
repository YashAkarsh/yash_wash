package com.google.zxing.oned;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements com.google.zxing.p {
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    private com.google.zxing.r d(com.google.zxing.c cVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m {
        Map<com.google.zxing.e, ?> map2;
        int i7;
        int i8;
        Map<com.google.zxing.e, ?> map3 = map;
        int iE = cVar.e();
        int iD = cVar.d();
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(iE);
        int i9 = 0;
        int i10 = 1;
        boolean z7 = map3 != null && map3.containsKey(com.google.zxing.e.TRY_HARDER);
        int iMax = Math.max(1, iD >> (z7 ? 8 : 5));
        int i11 = z7 ? iD : 15;
        int i12 = iD / 2;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = i13 + 1;
            int i15 = i14 / 2;
            if (((i13 & 1) == 0 ? i10 : i9) == 0) {
                i15 = -i15;
            }
            int i16 = (i15 * iMax) + i12;
            if (i16 < 0 || i16 >= iD) {
                break;
            }
            try {
                aVar = cVar.c(i16, aVar);
                int i17 = i9;
                while (i17 < 2) {
                    if (i17 == i10) {
                        aVar.s();
                        if (map3 != null) {
                            com.google.zxing.e eVar = com.google.zxing.e.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(eVar)) {
                                EnumMap enumMap = new EnumMap(com.google.zxing.e.class);
                                enumMap.putAll(map3);
                                enumMap.remove(eVar);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        com.google.zxing.r rVarC = c(i16, aVar, map3);
                        if (i17 == i10) {
                            try {
                                rVarC.j(com.google.zxing.s.ORIENTATION, 180);
                                com.google.zxing.t[] tVarArrF = rVarC.f();
                                if (tVarArrF != null) {
                                    map2 = map3;
                                    float f8 = iE;
                                    try {
                                        i7 = iE;
                                        try {
                                            tVarArrF[0] = new com.google.zxing.t((f8 - tVarArrF[i9].c()) - 1.0f, tVarArrF[i9].d());
                                            i8 = 1;
                                            try {
                                                tVarArrF[1] = new com.google.zxing.t((f8 - tVarArrF[1].c()) - 1.0f, tVarArrF[1].d());
                                            } catch (com.google.zxing.q unused) {
                                                continue;
                                                i17++;
                                                i10 = i8;
                                                map3 = map2;
                                                iE = i7;
                                                i9 = 0;
                                            }
                                        } catch (com.google.zxing.q unused2) {
                                            i8 = 1;
                                            i17++;
                                            i10 = i8;
                                            map3 = map2;
                                            iE = i7;
                                            i9 = 0;
                                        }
                                    } catch (com.google.zxing.q unused3) {
                                        i7 = iE;
                                        i8 = 1;
                                        i17++;
                                        i10 = i8;
                                        map3 = map2;
                                        iE = i7;
                                        i9 = 0;
                                    }
                                }
                            } catch (com.google.zxing.q unused4) {
                                map2 = map3;
                            }
                        }
                        return rVarC;
                    } catch (com.google.zxing.q unused5) {
                        map2 = map3;
                        i7 = iE;
                        i8 = i10;
                    }
                }
            } catch (com.google.zxing.m unused6) {
            }
            i13 = i14;
            i10 = i10;
            iE = iE;
            i9 = 0;
        }
        throw com.google.zxing.m.a();
    }

    protected static float e(int[] iArr, int[] iArr2, float f8) {
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i7 += iArr[i9];
            i8 += iArr2[i9];
        }
        if (i7 < i8) {
            return Float.POSITIVE_INFINITY;
        }
        float f9 = i7;
        float f10 = f9 / i8;
        float f11 = f8 * f10;
        float f12 = 0.0f;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            float f13 = iArr2[i10] * f10;
            float f14 = i11;
            float f15 = f14 > f13 ? f14 - f13 : f13 - f14;
            if (f15 > f11) {
                return Float.POSITIVE_INFINITY;
            }
            f12 += f15;
        }
        return f12 / f9;
    }

    protected static void f(com.google.zxing.common.a aVar, int i7, int[] iArr) throws com.google.zxing.m {
        int length = iArr.length;
        int i8 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iO = aVar.o();
        if (i7 >= iO) {
            throw com.google.zxing.m.a();
        }
        boolean z7 = !aVar.k(i7);
        while (i7 < iO) {
            if (aVar.k(i7) == z7) {
                i8++;
                if (i8 == length) {
                    break;
                }
                iArr[i8] = 1;
                z7 = !z7;
            } else {
                iArr[i8] = iArr[i8] + 1;
            }
            i7++;
        }
        if (i8 != length) {
            if (i8 != length - 1 || i7 != iO) {
                throw com.google.zxing.m.a();
            }
        }
    }

    protected static void g(com.google.zxing.common.a aVar, int i7, int[] iArr) throws com.google.zxing.m {
        int length = iArr.length;
        boolean zK = aVar.k(i7);
        while (i7 > 0 && length >= 0) {
            i7--;
            if (aVar.k(i7) != zK) {
                length--;
                zK = !zK;
            }
        }
        if (length >= 0) {
            throw com.google.zxing.m.a();
        }
        f(aVar, i7 + 1, iArr);
    }

    @Override // com.google.zxing.p
    public com.google.zxing.r a(com.google.zxing.c cVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.h {
        try {
            return d(cVar, map);
        } catch (com.google.zxing.m e8) {
            if (!(map != null && map.containsKey(com.google.zxing.e.TRY_HARDER)) || !cVar.g()) {
                throw e8;
            }
            com.google.zxing.c cVarH = cVar.h();
            com.google.zxing.r rVarD = d(cVarH, map);
            Map<com.google.zxing.s, Object> mapE = rVarD.e();
            int iIntValue = 270;
            if (mapE != null) {
                com.google.zxing.s sVar = com.google.zxing.s.ORIENTATION;
                if (mapE.containsKey(sVar)) {
                    iIntValue = (((Integer) mapE.get(sVar)).intValue() + 270) % 360;
                }
            }
            rVarD.j(com.google.zxing.s.ORIENTATION, Integer.valueOf(iIntValue));
            com.google.zxing.t[] tVarArrF = rVarD.f();
            if (tVarArrF != null) {
                int iD = cVarH.d();
                for (int i7 = 0; i7 < tVarArrF.length; i7++) {
                    tVarArrF[i7] = new com.google.zxing.t((iD - tVarArrF[i7].d()) - 1.0f, tVarArrF[i7].c());
                }
            }
            return rVarD;
        }
    }

    @Override // com.google.zxing.p
    public com.google.zxing.r b(com.google.zxing.c cVar) throws com.google.zxing.m, com.google.zxing.h {
        return a(cVar, null);
    }

    public abstract com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h;

    @Override // com.google.zxing.p
    public void reset() {
    }
}
