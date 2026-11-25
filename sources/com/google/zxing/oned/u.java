package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements com.google.zxing.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f23971a = new j();

    @Override // com.google.zxing.v
    public com.google.zxing.common.b a(String str, com.google.zxing.a aVar, int i7, int i8) throws com.google.zxing.w {
        return b(str, aVar, i7, i8, null);
    }

    @Override // com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.UPC_A) {
            return this.f23971a.b("0".concat(String.valueOf(str)), com.google.zxing.a.EAN_13, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
