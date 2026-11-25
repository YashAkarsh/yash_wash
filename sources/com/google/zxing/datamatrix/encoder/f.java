package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class f implements g {
    f() {
    }

    private static void c(char c8, StringBuilder sb) {
        if (c8 >= ' ' && c8 <= '?') {
            sb.append(c8);
        } else if (c8 < '@' || c8 > '^') {
            j.f(c8);
        } else {
            sb.append((char) (c8 - '@'));
        }
    }

    private static String d(CharSequence charSequence, int i7) {
        int length = charSequence.length() - i7;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i7) << 18) + ((length >= 2 ? charSequence.charAt(i7 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i7 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i7 + 3) : (char) 0);
        char c8 = (char) ((iCharAt >> 16) & 255);
        char c9 = (char) ((iCharAt >> 8) & 255);
        char c10 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c8);
        if (length >= 2) {
            sb.append(c9);
        }
        if (length >= 3) {
            sb.append(c10);
        }
        return sb.toString();
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                hVar.p(0);
                return;
            }
            boolean z7 = true;
            if (length == 1) {
                hVar.q();
                int iB = hVar.h().b() - hVar.a();
                int iG = hVar.g();
                if (iG > iB) {
                    hVar.r(hVar.a() + 1);
                    iB = hVar.h().b() - hVar.a();
                }
                if (iG <= iB && iB <= 2) {
                    hVar.p(0);
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i7 = length - 1;
            String strD = d(charSequence, 0);
            if (!(!hVar.j()) || i7 > 2) {
                z7 = false;
            }
            if (i7 <= 2) {
                hVar.r(hVar.a() + i7);
                if (hVar.h().b() - hVar.a() >= 3) {
                    hVar.r(hVar.a() + strD.length());
                    z7 = false;
                }
            }
            if (z7) {
                hVar.l();
                hVar.f23666f -= i7;
            } else {
                hVar.t(strD);
            }
            hVar.p(0);
        } catch (Throwable th) {
            hVar.p(0);
            throw th;
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int a() {
        return 4;
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void b(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (hVar.j()) {
            c(hVar.d(), sb);
            hVar.f23666f++;
            if (sb.length() >= 4) {
                hVar.t(d(sb, 0));
                sb.delete(0, 4);
                if (j.o(hVar.e(), hVar.f23666f, a()) != a()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }
}
