package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends x {

    static class a extends IllegalArgumentException {
        a(int i7, int i8) {
            super("Unpaired surrogate at index " + i7 + " of " + i8);
        }
    }

    private static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i7 = 0;
        while (i7 < length && charSequence.charAt(i7) < 128) {
            i7++;
        }
        int iK = length;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt >= 2048) {
                iK += k(charSequence, i7);
                break;
            }
            iK += (127 - cCharAt) >>> 31;
            i7++;
        }
        if (iK >= length) {
            return iK;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iK) + 4294967296L));
    }

    public static String g(byte[] bArr, int i7, int i8) {
        if ((i7 | i8 | ((bArr.length - i7) - i8)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i7), Integer.valueOf(i8)));
        }
        int i9 = i7 + i8;
        char[] cArr = new char[i8];
        int i10 = 0;
        while (i7 < i9) {
            byte b8 = bArr[i7];
            if (!x.a.g(b8)) {
                break;
            }
            i7++;
            x.a.b(b8, cArr, i10);
            i10++;
        }
        int i11 = i10;
        while (i7 < i9) {
            int i12 = i7 + 1;
            byte b9 = bArr[i7];
            if (x.a.g(b9)) {
                int i13 = i11 + 1;
                x.a.b(b9, cArr, i11);
                while (i12 < i9) {
                    byte b10 = bArr[i12];
                    if (!x.a.g(b10)) {
                        break;
                    }
                    i12++;
                    x.a.b(b10, cArr, i13);
                    i13++;
                }
                i7 = i12;
                i11 = i13;
            } else if (x.a.i(b9)) {
                if (i12 >= i9) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                x.a.d(b9, bArr[i12], cArr, i11);
                i7 = i12 + 1;
                i11++;
            } else if (x.a.h(b9)) {
                if (i12 >= i9 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i14 = i12 + 1;
                x.a.c(b9, bArr[i12], bArr[i14], cArr, i11);
                i7 = i14 + 1;
                i11++;
            } else {
                if (i12 >= i9 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i15 = i12 + 1;
                byte b11 = bArr[i12];
                int i16 = i15 + 1;
                x.a.a(b9, b11, bArr[i15], bArr[i16], cArr, i11);
                i7 = i16 + 1;
                i11 = i11 + 1 + 1;
            }
        }
        return new String(cArr, 0, i11);
    }

    public static String h(ByteBuffer byteBuffer, int i7, int i8) {
        if ((i7 | i8 | ((byteBuffer.limit() - i7) - i8)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i7), Integer.valueOf(i8)));
        }
        int i9 = i7 + i8;
        char[] cArr = new char[i8];
        int i10 = 0;
        while (i7 < i9) {
            byte b8 = byteBuffer.get(i7);
            if (!x.a.g(b8)) {
                break;
            }
            i7++;
            x.a.b(b8, cArr, i10);
            i10++;
        }
        int i11 = i10;
        while (i7 < i9) {
            int i12 = i7 + 1;
            byte b9 = byteBuffer.get(i7);
            if (x.a.g(b9)) {
                int i13 = i11 + 1;
                x.a.b(b9, cArr, i11);
                while (i12 < i9) {
                    byte b10 = byteBuffer.get(i12);
                    if (!x.a.g(b10)) {
                        break;
                    }
                    i12++;
                    x.a.b(b10, cArr, i13);
                    i13++;
                }
                i7 = i12;
                i11 = i13;
            } else if (x.a.i(b9)) {
                if (i12 >= i9) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                x.a.d(b9, byteBuffer.get(i12), cArr, i11);
                i7 = i12 + 1;
                i11++;
            } else if (x.a.h(b9)) {
                if (i12 >= i9 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i14 = i12 + 1;
                x.a.c(b9, byteBuffer.get(i12), byteBuffer.get(i14), cArr, i11);
                i7 = i14 + 1;
                i11++;
            } else {
                if (i12 >= i9 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i15 = i12 + 1;
                byte b11 = byteBuffer.get(i12);
                int i16 = i15 + 1;
                x.a.a(b9, b11, byteBuffer.get(i15), byteBuffer.get(i16), cArr, i11);
                i7 = i16 + 1;
                i11 = i11 + 1 + 1;
            }
        }
        return new String(cArr, 0, i11);
    }

    private static int i(CharSequence charSequence, byte[] bArr, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        char cCharAt;
        int length = charSequence.length();
        int i12 = i8 + i7;
        int i13 = 0;
        while (i13 < length && (i11 = i13 + i7) < i12 && (cCharAt = charSequence.charAt(i13)) < 128) {
            bArr[i11] = (byte) cCharAt;
            i13++;
        }
        if (i13 == length) {
            return i7 + length;
        }
        int i14 = i7 + i13;
        while (i13 < length) {
            char cCharAt2 = charSequence.charAt(i13);
            if (cCharAt2 >= 128 || i14 >= i12) {
                if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                    int i15 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                    i14 = i15 + 1;
                    bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                        if (i14 > i12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                                throw new a(i13, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                        }
                        int i16 = i13 + 1;
                        if (i16 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i16);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i17 = i14 + 1;
                                bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                                int i18 = i17 + 1;
                                bArr[i17] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i19 = i18 + 1;
                                bArr[i18] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i14 = i19 + 1;
                                bArr[i19] = (byte) ((codePoint & 63) | 128);
                                i13 = i16;
                            } else {
                                i13 = i16;
                            }
                        }
                        throw new a(i13 - 1, length);
                    }
                    int i20 = i14 + 1;
                    bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i21 = i20 + 1;
                    bArr[i20] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i9 = i21 + 1;
                    bArr[i21] = (byte) ((cCharAt2 & '?') | 128);
                }
                i13++;
            } else {
                i9 = i14 + 1;
                bArr[i14] = (byte) cCharAt2;
            }
            i14 = i9;
            i13++;
        }
        return i14;
    }

    private static void j(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i7 = 0;
        while (i7 < length) {
            try {
                char cCharAt = charSequence.charAt(i7);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i7, (byte) cCharAt);
                i7++;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        if (i7 == length) {
            byteBuffer.position(iPosition + i7);
            return;
        }
        iPosition += i7;
        while (i7 < length) {
            char cCharAt2 = charSequence.charAt(i7);
            if (cCharAt2 < 128) {
                byteBuffer.put(iPosition, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i8 = iPosition + 1;
                try {
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | com.alibaba.fastjson.asm.j.f12606c0));
                    byteBuffer.put(i8, (byte) ((cCharAt2 & '?') | 128));
                    iPosition = i8;
                } catch (IndexOutOfBoundsException unused2) {
                    iPosition = i8;
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    int i9 = i7 + 1;
                    if (i9 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i9);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i10 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                    iPosition = i10 + 1;
                                    byteBuffer.put(i10, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i10 = iPosition + 1;
                                    byteBuffer.put(iPosition, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i10, (byte) ((codePoint & 63) | 128));
                                    iPosition = i10;
                                    i7 = i9;
                                } catch (IndexOutOfBoundsException unused3) {
                                    iPosition = i10;
                                }
                            } else {
                                i7 = i9;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                        }
                        i7 = i9;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i7) + " at index " + (byteBuffer.position() + Math.max(i7, (iPosition - byteBuffer.position()) + 1)));
                    }
                    throw new a(i7, length);
                }
                int i11 = iPosition + 1;
                byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                iPosition = i11 + 1;
                byteBuffer.put(i11, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
            }
            i7++;
            iPosition++;
        }
        byteBuffer.position(iPosition);
    }

    private static int k(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = 0;
        while (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            if (cCharAt < 2048) {
                i8 += (127 - cCharAt) >>> 31;
            } else {
                i8 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i7) < 65536) {
                        throw new a(i7, length);
                    }
                    i7++;
                }
            }
            i7++;
        }
        return i8;
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public String a(ByteBuffer byteBuffer, int i7, int i8) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? g(byteBuffer.array(), byteBuffer.arrayOffset() + i7, i8) : h(byteBuffer, i7, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            j(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(i(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public int c(CharSequence charSequence) {
        return f(charSequence);
    }
}
