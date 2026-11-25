package com.google.zxing.oned;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends s {
    private static void g(int i7, int[] iArr) {
        for (int i8 = 0; i8 < 9; i8++) {
            int i9 = 1;
            if (((1 << (8 - i8)) & i7) != 0) {
                i9 = 2;
            }
            iArr[i8] = i9;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ec  */
    private static String h(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == 0) {
                sb.append("%U");
            } else if (cCharAt == ' ') {
                sb.append(cCharAt);
            } else if (cCharAt == '@') {
                sb.append("%V");
            } else if (cCharAt == '`') {
                sb.append("%W");
            } else if (cCharAt == '-' || cCharAt == '.') {
                sb.append(cCharAt);
            } else if (cCharAt <= 26) {
                sb.append('$');
                sb.append((char) ((cCharAt - 1) + 65));
            } else if (cCharAt < ' ') {
                sb.append('%');
                sb.append((char) ((cCharAt - 27) + 65));
            } else if (cCharAt <= ',' || cCharAt == '/' || cCharAt == ':') {
                sb.append('/');
                sb.append((char) ((cCharAt - '!') + 65));
            } else if (cCharAt <= '9') {
                sb.append((char) ((cCharAt - '0') + 48));
            } else if (cCharAt <= '?') {
                sb.append('%');
                sb.append((char) ((cCharAt - ';') + 70));
            } else if (cCharAt <= 'Z') {
                sb.append((char) ((cCharAt - 'A') + 65));
            } else if (cCharAt <= '_') {
                sb.append('%');
                sb.append((char) ((cCharAt - '[') + 75));
            } else if (cCharAt <= 'z') {
                sb.append('+');
                sb.append((char) ((cCharAt - 'a') + 65));
            } else {
                if (cCharAt > 127) {
                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i7) + "'");
                }
                sb.append('%');
                sb.append((char) ((cCharAt - '{') + 80));
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.oned.s, com.google.zxing.v
    public com.google.zxing.common.b b(String str, com.google.zxing.a aVar, int i7, int i8, Map<com.google.zxing.g, ?> map) throws com.google.zxing.w {
        if (aVar == com.google.zxing.a.CODE_39) {
            return super.b(str, aVar, i7, i8, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.oned.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        for (int i7 = 0; i7 < length; i7++) {
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i7)) < 0) {
                str = h(str);
                length = str.length();
                if (length <= 80) {
                    break;
                }
                throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
            }
        }
        int[] iArr = new int[9];
        int i8 = length + 25;
        for (int i9 = 0; i9 < length; i9++) {
            g(e.f23843f["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i9))], iArr);
            for (int i10 = 0; i10 < 9; i10++) {
                i8 += iArr[i10];
            }
        }
        boolean[] zArr = new boolean[i8];
        g(com.alibaba.fastjson.asm.j.C, iArr);
        int iC = s.c(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iC2 = iC + s.c(zArr, iC, iArr2, false);
        for (int i11 = 0; i11 < length; i11++) {
            g(e.f23843f["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11))], iArr);
            int iC3 = iC2 + s.c(zArr, iC2, iArr, true);
            iC2 = iC3 + s.c(zArr, iC3, iArr2, false);
        }
        g(com.alibaba.fastjson.asm.j.C, iArr);
        s.c(zArr, iC2, iArr, true);
        return zArr;
    }
}
