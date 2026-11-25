package com.haier.library.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f26599a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static int a(char c8) {
        int i7;
        if (c8 >= 'A' && c8 <= 'Z') {
            return c8 - 'A';
        }
        if (c8 >= 'a' && c8 <= 'z') {
            i7 = c8 - 'a';
        } else {
            if (c8 < '0' || c8 > '9') {
                if (c8 == '+') {
                    return 62;
                }
                if (c8 == '/') {
                    return 63;
                }
                if (c8 == '=') {
                    return 0;
                }
                throw new RuntimeException("unexpected code: " + c8);
            }
            i7 = (c8 - '0') + 26;
        }
        return i7 + 26;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((bArr.length * 3) / 2);
        int i7 = length - 3;
        int i8 = 0;
        int i9 = 0;
        while (i8 <= i7) {
            int i10 = ((bArr[i8] & 255) << 16) | ((bArr[i8 + 1] & 255) << 8) | (bArr[i8 + 2] & 255);
            char[] cArr = f26599a;
            sb.append(cArr[(i10 >> 18) & 63]);
            sb.append(cArr[(i10 >> 12) & 63]);
            sb.append(cArr[(i10 >> 6) & 63]);
            sb.append(cArr[i10 & 63]);
            i8 += 3;
            int i11 = i9 + 1;
            if (i9 >= 14) {
                sb.append("");
                i9 = 0;
            } else {
                i9 = i11;
            }
        }
        int i12 = 0 + length;
        if (i8 == i12 - 2) {
            int i13 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16);
            char[] cArr2 = f26599a;
            sb.append(cArr2[(i13 >> 18) & 63]);
            sb.append(cArr2[(i13 >> 12) & 63]);
            sb.append(cArr2[(i13 >> 6) & 63]);
            sb.append("=");
        } else if (i8 == i12 - 1) {
            int i14 = (bArr[i8] & 255) << 16;
            char[] cArr3 = f26599a;
            sb.append(cArr3[(i14 >> 18) & 63]);
            sb.append(cArr3[(i14 >> 12) & 63]);
            sb.append("==");
        }
        return sb.toString();
    }

    private static void c(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        int i7 = 0;
        while (true) {
            if (i7 < length && str.charAt(i7) <= ' ') {
                i7++;
            } else {
                if (i7 == length) {
                    return;
                }
                int i8 = i7 + 2;
                int i9 = i7 + 3;
                int iA = (a(str.charAt(i7)) << 18) + (a(str.charAt(i7 + 1)) << 12) + (a(str.charAt(i8)) << 6) + a(str.charAt(i9));
                outputStream.write((iA >> 16) & 255);
                if (str.charAt(i8) == '=') {
                    return;
                }
                outputStream.write((iA >> 8) & 255);
                if (str.charAt(i9) == '=') {
                    return;
                }
                outputStream.write(iA & 255);
                i7 += 4;
            }
        }
    }

    public static byte[] d(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c(str, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e8) {
            e3.a.h("Error while decoding BASE64: %s", e8.toString());
            return new byte[0];
        }
    }
}
