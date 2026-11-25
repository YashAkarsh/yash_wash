package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class a implements g {
    a() {
    }

    private static char c(char c8, char c9) {
        if (j.g(c8) && j.g(c9)) {
            return (char) (((c8 - '0') * 10) + (c9 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c8 + c9);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 0;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        if (j.a(hVar.e(), hVar.f23666f) >= 2) {
            hVar.s(c(hVar.e().charAt(hVar.f23666f), hVar.e().charAt(hVar.f23666f + 1)));
            hVar.f23666f += 2;
            return;
        }
        char cD = hVar.d();
        int iO = j.o(hVar.e(), hVar.f23666f, a());
        if (iO == a()) {
            if (!j.h(cD)) {
                hVar.s((char) (cD + 1));
                hVar.f23666f++;
                return;
            } else {
                hVar.s((char) 235);
                hVar.s((char) ((cD - 128) + 1));
                hVar.f23666f++;
                return;
            }
        }
        if (iO == 1) {
            hVar.s((char) 230);
            hVar.p(1);
            return;
        }
        if (iO == 2) {
            hVar.s((char) 239);
            hVar.p(2);
            return;
        }
        if (iO == 3) {
            hVar.s((char) 238);
            hVar.p(3);
        } else if (iO == 4) {
            hVar.s((char) 240);
            hVar.p(4);
        } else {
            if (iO != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iO)));
            }
            hVar.s((char) 231);
            hVar.p(5);
        }
    }
}
