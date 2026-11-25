package p0;

import java.io.UnsupportedEncodingException;
import okio.r0;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f40072a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f40073b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, r0.f38528a, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, com.google.common.base.c.f19313m, com.google.common.base.c.f19314n, com.google.common.base.c.f19315o, com.google.common.base.c.f19316p, com.google.common.base.c.f19317q, com.google.common.base.c.f19318r, 17, com.google.common.base.c.f19321u, 19, com.google.common.base.c.f19324x, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.C, -1, -1, -1, -1, -1, -1, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.F, com.google.common.base.c.G, com.google.common.base.c.H, com.google.common.base.c.I, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] a(String str) throws UnsupportedEncodingException {
        int i7;
        byte b8;
        int i8;
        byte b9;
        int i9;
        byte b10;
        int i10;
        byte b11;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes(CharEncoding.US_ASCII);
        int length = bytes.length;
        int i11 = 0;
        loop0: while (i11 < length) {
            while (true) {
                i7 = i11 + 1;
                b8 = f40073b[bytes[i11]];
                if (i7 >= length || b8 != -1) {
                    break;
                }
                i11 = i7;
            }
            if (b8 == -1) {
                break;
            }
            while (true) {
                i8 = i7 + 1;
                b9 = f40073b[bytes[i7]];
                if (i8 >= length || b9 != -1) {
                    break;
                }
                i7 = i8;
            }
            if (b9 == -1) {
                break;
            }
            stringBuffer.append((char) ((b8 << 2) | ((b9 & 48) >>> 4)));
            while (true) {
                i9 = i8 + 1;
                byte b12 = bytes[i8];
                if (b12 == 61) {
                    break loop0;
                }
                b10 = f40073b[b12];
                if (i9 >= length || b10 != -1) {
                    break;
                }
                i8 = i9;
            }
            if (b10 == -1) {
                break;
            }
            stringBuffer.append((char) (((b9 & com.google.common.base.c.f19317q) << 4) | ((b10 & 60) >>> 2)));
            while (true) {
                i10 = i9 + 1;
                byte b13 = bytes[i9];
                if (b13 == 61) {
                    break loop0;
                }
                b11 = f40073b[b13];
                if (i10 >= length || b11 != -1) {
                    break;
                }
                i9 = i10;
            }
            if (b11 == -1) {
                break;
            }
            stringBuffer.append((char) (b11 | ((b10 & 3) << 6)));
            i11 = i10;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
