package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class n extends c {
    n() {
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (hVar.j()) {
            char cD = hVar.d();
            hVar.f23666f++;
            d(cD, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.o(hVar.e(), hVar.f23666f, a()) != a()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int d(char c8, StringBuilder sb) {
        if (c8 == '\r') {
            sb.append((char) 0);
        } else if (c8 == ' ') {
            sb.append((char) 3);
        } else if (c8 == '*') {
            sb.append((char) 1);
        } else if (c8 == '>') {
            sb.append((char) 2);
        } else if (c8 >= '0' && c8 <= '9') {
            sb.append((char) ((c8 - '0') + 4));
        } else if (c8 < 'A' || c8 > 'Z') {
            j.f(c8);
        } else {
            sb.append((char) ((c8 - 'A') + 14));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void f(h hVar, StringBuilder sb) {
        hVar.q();
        int iB = hVar.h().b() - hVar.a();
        hVar.f23666f -= sb.length();
        if (hVar.g() > 1 || iB > 1 || hVar.g() != iB) {
            hVar.s((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.p(0);
        }
    }
}
