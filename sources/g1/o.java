package g1;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class o {
    @o0
    @c1.a
    public static String a(@m0 byte[] bArr, int i7, int i8, boolean z7) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i7 < 0 || i8 <= 0 || i7 + i8 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z7 ? 75 : 57) * ((i8 + 15) / 16));
        int i9 = i8;
        int i10 = 0;
        int i11 = 0;
        while (i9 > 0) {
            if (i10 == 0) {
                if (i8 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i7)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i7)));
                }
                i11 = i7;
            } else if (i10 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i7] & 255)));
            i9--;
            i10++;
            if (z7 && (i10 == 16 || i9 == 0)) {
                int i12 = 16 - i10;
                if (i12 > 0) {
                    for (int i13 = 0; i13 < i12; i13++) {
                        sb.append("   ");
                    }
                }
                if (i12 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i14 = 0; i14 < i10; i14++) {
                    char c8 = (char) bArr[i11 + i14];
                    if (c8 < ' ' || c8 > '~') {
                        c8 = '.';
                    }
                    sb.append(c8);
                }
            }
            if (i10 == 16 || i9 == 0) {
                sb.append('\n');
                i10 = 0;
            }
            i7++;
        }
        return sb.toString();
    }
}
