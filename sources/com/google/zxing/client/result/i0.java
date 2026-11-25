package com.google.zxing.client.result;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f23461f = Pattern.compile("[IOQ]");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f23462g = Pattern.compile("[A-Z0-9]{17}");

    private static char q(int i7) {
        if (i7 < 10) {
            return (char) (i7 + 48);
        }
        if (i7 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static boolean r(CharSequence charSequence) {
        int i7 = 0;
        int iW = 0;
        while (i7 < charSequence.length()) {
            int i8 = i7 + 1;
            iW += w(i8) * v(charSequence.charAt(i7));
            i7 = i8;
        }
        return charSequence.charAt(8) == q(iW % 11);
    }

    private static String s(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        if (cCharAt == '9') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                return "BR";
            }
            if (cCharAt2 < '3' || cCharAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (cCharAt == 'S') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'M') {
                return "UK";
            }
            if (cCharAt2 < 'N' || cCharAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (cCharAt == 'Z') {
            if (cCharAt2 < 'A' || cCharAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (cCharAt) {
            case '1':
            case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
            case ConstraintLayout.LayoutParams.a.f4571b0 /* 53 */:
                return "US";
            case '2':
                return "CA";
            case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                if (cCharAt2 < 'A' || cCharAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (cCharAt) {
                    case 'J':
                        if (cCharAt2 < 'A' || cCharAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (cCharAt2 < 'L' || cCharAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case f4.d.f33920j /* 76 */:
                        return "CN";
                    case 'M':
                        if (cCharAt2 < 'A' || cCharAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (cCharAt) {
                            case 'V':
                                if (cCharAt2 >= 'F' && cCharAt2 <= 'R') {
                                    return "FR";
                                }
                                if (cCharAt2 < 'S' || cCharAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case com.alibaba.fastjson.asm.j.f12630x /* 87 */:
                                return "DE";
                            case 'X':
                                if (cCharAt2 == '0') {
                                    return "RU";
                                }
                                if (cCharAt2 < '3' || cCharAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    private static int t(char c8) {
        if (c8 >= 'E' && c8 <= 'H') {
            return (c8 - 'E') + 1984;
        }
        if (c8 >= 'J' && c8 <= 'N') {
            return (c8 - 'J') + 1988;
        }
        if (c8 == 'P') {
            return 1993;
        }
        if (c8 >= 'R' && c8 <= 'T') {
            return (c8 - 'R') + 1994;
        }
        if (c8 >= 'V' && c8 <= 'Y') {
            return (c8 - 'V') + 1997;
        }
        if (c8 >= '1' && c8 <= '9') {
            return (c8 - '1') + com.haier.uhome.config.service.a.a.c_;
        }
        if (c8 < 'A' || c8 > 'D') {
            throw new IllegalArgumentException();
        }
        return (c8 - 'A') + 2010;
    }

    private static int v(char c8) {
        if (c8 >= 'A' && c8 <= 'I') {
            return (c8 - 'A') + 1;
        }
        if (c8 >= 'J' && c8 <= 'R') {
            return (c8 - 'J') + 1;
        }
        if (c8 >= 'S' && c8 <= 'Z') {
            return (c8 - 'S') + 2;
        }
        if (c8 < '0' || c8 > '9') {
            throw new IllegalArgumentException();
        }
        return c8 - '0';
    }

    private static int w(int i7) {
        if (i7 > 0 && i7 <= 7) {
            return 9 - i7;
        }
        if (i7 == 8) {
            return 10;
        }
        if (i7 == 9) {
            return 0;
        }
        if (i7 < 10 || i7 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i7;
    }

    @Override // com.google.zxing.client.result.u
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public h0 k(com.google.zxing.r rVar) {
        if (rVar.b() != com.google.zxing.a.CODE_39) {
            return null;
        }
        String strTrim = f23461f.matcher(rVar.g()).replaceAll("").trim();
        if (!f23462g.matcher(strTrim).matches()) {
            return null;
        }
        try {
            if (!r(strTrim)) {
                return null;
            }
            String strSubstring = strTrim.substring(0, 3);
            return new h0(strTrim, strSubstring, strTrim.substring(3, 9), strTrim.substring(9, 17), s(strSubstring), strTrim.substring(3, 8), t(strTrim.charAt(9)), strTrim.charAt(10), strTrim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
