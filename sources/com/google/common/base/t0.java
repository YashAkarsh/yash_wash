package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.a
@s1.b(emulated = true)
public final class t0 {
    private t0() {
    }

    public static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length && charSequence.charAt(i7) < 128) {
            i7++;
        }
        int iB = length;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt >= 2048) {
                iB += b(charSequence, i7);
                break;
            }
            iB += (127 - cCharAt) >>> 31;
            i7++;
        }
        if (iB >= length) {
            return iB;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iB) + 4294967296L));
    }

    private static int b(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt < 2048) {
                i8 += (127 - cCharAt) >>> 31;
            } else {
                i8 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i7) == cCharAt) {
                        throw new IllegalArgumentException(f(i7));
                    }
                    i7++;
                }
            }
            i7++;
        }
        return i8;
    }

    public static boolean c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public static boolean d(byte[] bArr, int i7, int i8) {
        int i9 = i8 + i7;
        e0.f0(i7, i9, bArr.length);
        while (i7 < i9) {
            if (bArr[i7] < 0) {
                return e(bArr, i7, i9);
            }
            i7++;
        }
        return true;
    }

    private static boolean e(byte[] bArr, int i7, int i8) {
        byte b8;
        while (i7 < i8) {
            int i9 = i7 + 1;
            byte b9 = bArr[i7];
            if (b9 < 0) {
                if (b9 < -32) {
                    if (i9 != i8 && b9 >= -62) {
                        i7 = i9 + 1;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return false;
                }
                if (b9 < -16) {
                    int i10 = i9 + 1;
                    if (i10 < i8 && (b8 = bArr[i9]) <= -65 && ((b9 != -32 || b8 >= -96) && (b9 != -19 || -96 > b8))) {
                        i7 = i10 + 1;
                        if (bArr[i10] > -65) {
                        }
                    }
                    return false;
                }
                if (i9 + 2 >= i8) {
                    return false;
                }
                int i11 = i9 + 1;
                byte b10 = bArr[i9];
                if (b10 <= -65 && (((b9 << c.F) + (b10 + 112)) >> 30) == 0) {
                    int i12 = i11 + 1;
                    if (bArr[i11] <= -65) {
                        i9 = i12 + 1;
                        if (bArr[i12] > -65) {
                        }
                    }
                }
                return false;
            }
            i7 = i9;
        }
        return true;
    }

    private static String f(int i7) {
        return "Unpaired surrogate at index " + i7;
    }
}
