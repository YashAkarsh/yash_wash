package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends y {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final y f23970k = new i();

    private static com.google.zxing.r s(com.google.zxing.r rVar) throws com.google.zxing.h {
        String strG = rVar.g();
        if (strG.charAt(0) != '0') {
            throw com.google.zxing.h.a();
        }
        com.google.zxing.r rVar2 = new com.google.zxing.r(strG.substring(1), null, rVar.f(), com.google.zxing.a.UPC_A);
        if (rVar.e() != null) {
            rVar2.i(rVar.e());
        }
        return rVar2;
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.p
    public com.google.zxing.r a(com.google.zxing.c cVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.h {
        return s(this.f23970k.a(cVar, map));
    }

    @Override // com.google.zxing.oned.r, com.google.zxing.p
    public com.google.zxing.r b(com.google.zxing.c cVar) throws com.google.zxing.m, com.google.zxing.h {
        return s(this.f23970k.b(cVar));
    }

    @Override // com.google.zxing.oned.y, com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        return s(this.f23970k.c(i7, aVar, map));
    }

    @Override // com.google.zxing.oned.y
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        return this.f23970k.l(aVar, iArr, sb);
    }

    @Override // com.google.zxing.oned.y
    public com.google.zxing.r m(int i7, com.google.zxing.common.a aVar, int[] iArr, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        return s(this.f23970k.m(i7, aVar, iArr, map));
    }

    @Override // com.google.zxing.oned.y
    com.google.zxing.a q() {
        return com.google.zxing.a.UPC_A;
    }
}
