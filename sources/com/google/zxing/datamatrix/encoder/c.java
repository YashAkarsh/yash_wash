package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
class c implements g {
    c() {
    }

    private int c(h hVar, StringBuilder sb, StringBuilder sb2, int i7) {
        int length = sb.length();
        sb.delete(length - i7, length);
        hVar.f23666f--;
        int iD = d(hVar.d(), sb2);
        hVar.l();
        return iD;
    }

    private static String e(CharSequence charSequence, int i7) {
        int iCharAt = (charSequence.charAt(i7) * 1600) + (charSequence.charAt(i7 + 1) * '(') + charSequence.charAt(i7 + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    static void g(h hVar, StringBuilder sb) {
        hVar.t(e(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (hVar.j()) {
            char cD = hVar.d();
            hVar.f23666f++;
            int iD = d(cD, sb);
            int iA = hVar.a() + ((sb.length() / 3) << 1);
            hVar.r(iA);
            int iB = hVar.h().b() - iA;
            if (!hVar.j()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iB < 2 || iB > 2)) {
                    iD = c(hVar, sb, sb2, iD);
                }
                while (sb.length() % 3 == 1 && ((iD <= 3 && iB != 1) || iD > 3)) {
                    iD = c(hVar, sb, sb2, iD);
                }
                break;
            }
            if (sb.length() % 3 == 0 && j.o(hVar.e(), hVar.f23666f, a()) != a()) {
                hVar.p(0);
                break;
            }
        }
        f(hVar, sb);
    }

    int d(char c8, StringBuilder sb) {
        if (c8 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c8 >= '0' && c8 <= '9') {
            sb.append((char) ((c8 - '0') + 4));
            return 1;
        }
        if (c8 >= 'A' && c8 <= 'Z') {
            sb.append((char) ((c8 - 'A') + 14));
            return 1;
        }
        if (c8 < ' ') {
            sb.append((char) 0);
            sb.append(c8);
            return 2;
        }
        if (c8 >= '!' && c8 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c8 - '!'));
            return 2;
        }
        if (c8 >= ':' && c8 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c8 - ':') + 15));
            return 2;
        }
        if (c8 >= '[' && c8 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c8 - '[') + 22));
            return 2;
        }
        if (c8 < '`' || c8 > 127) {
            sb.append("\u0001\u001e");
            return d((char) (c8 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c8 - '`'));
        return 2;
    }

    void f(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = hVar.a() + length;
        hVar.r(iA);
        int iB = hVar.h().b() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
        } else if (iB == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
            hVar.f23666f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (iB > 0 || hVar.j()) {
                hVar.s((char) 254);
            }
        }
        hVar.p(0);
    }
}
