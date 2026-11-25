package com.google.zxing.aztec.encoder;

import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
final class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f23387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f23388d;

    e(g gVar, int i7, int i8) {
        super(gVar);
        this.f23387c = (short) i7;
        this.f23388d = (short) i8;
    }

    @Override // com.google.zxing.aztec.encoder.g
    void c(com.google.zxing.common.a aVar, byte[] bArr) {
        aVar.c(this.f23387c, this.f23388d);
    }

    public String toString() {
        short s7 = this.f23387c;
        short s8 = this.f23388d;
        return "<" + Integer.toBinaryString((s7 & ((1 << s8) - 1)) | (1 << s8) | (1 << this.f23388d)).substring(1) + h0.f35380f;
    }
}
