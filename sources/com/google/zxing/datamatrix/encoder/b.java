package com.google.zxing.datamatrix.encoder;

import androidx.core.view.o0;

/* JADX INFO: loaded from: classes2.dex */
final class b implements g {
    b() {
    }

    private static char c(char c8, int i7) {
        int i8 = c8 + ((i7 * com.alibaba.fastjson.asm.j.D) % 255) + 1;
        return i8 <= 255 ? (char) i8 : (char) (i8 + o0.f6793u);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 5;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (hVar.j()) {
            sb.append(hVar.d());
            hVar.f23666f++;
            if (j.o(hVar.e(), hVar.f23666f, a()) != a()) {
                hVar.p(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = hVar.a() + length + 1;
        hVar.r(iA);
        boolean z7 = hVar.h().b() - iA > 0;
        if (hVar.j() || z7) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / androidx.recyclerview.widget.m.f.f9644c) + 249));
                sb.insert(1, (char) (length % androidx.recyclerview.widget.m.f.f9644c));
            }
        }
        int length2 = sb.length();
        for (int i7 = 0; i7 < length2; i7++) {
            hVar.s(c(sb.charAt(i7), hVar.a() + 1));
        }
    }
}
