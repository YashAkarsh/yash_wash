package com.google.zxing.aztec.encoder;

import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
final class b extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f23369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f23370d;

    b(g gVar, int i7, int i8) {
        super(gVar);
        this.f23369c = (short) i7;
        this.f23370d = (short) i8;
    }

    @Override // com.google.zxing.aztec.encoder.g
    public void c(com.google.zxing.common.a aVar, byte[] bArr) {
        int i7 = 0;
        while (true) {
            short s7 = this.f23370d;
            if (i7 >= s7) {
                return;
            }
            if (i7 == 0 || (i7 == 31 && s7 <= 62)) {
                aVar.c(31, 5);
                short s8 = this.f23370d;
                if (s8 > 62) {
                    aVar.c(s8 - 31, 16);
                } else if (i7 == 0) {
                    aVar.c(Math.min((int) s8, 31), 5);
                } else {
                    aVar.c(s8 - 31, 5);
                }
            }
            aVar.c(bArr[this.f23369c + i7], 8);
            i7++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f23369c);
        sb.append("::");
        sb.append((this.f23369c + this.f23370d) - 1);
        sb.append(h0.f35380f);
        return sb.toString();
    }
}
