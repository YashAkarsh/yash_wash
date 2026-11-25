package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import okio.r0;

/* JADX INFO: loaded from: classes.dex */
public class m extends CharsetDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f13400a = Charset.forName("UTF-8");

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f13401a = 65536;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f13402b = 1114111;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f13403c = false;

        private a() {
        }

        public static char a(int i7) {
            return (char) ((((i7 - 65536) >> 10) & 1023) | 55296);
        }

        public static char b(int i7) {
            return (char) (((i7 - 65536) & 1023) | r0.f38532e);
        }

        public static boolean c(int i7) {
            return i7 >= 65536 && i7 <= 1114111;
        }
    }

    public m() {
        super(f13400a, 1.0f, 1.0f);
    }

    private CoderResult a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        int i7;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iArrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] cArrArray = charBuffer.array();
        int iArrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int iArrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int iMin = Math.min(iArrayOffset2 - iArrayOffset, iArrayOffset4 - iArrayOffset3) + iArrayOffset3;
        while (iArrayOffset3 < iMin) {
            byte b8 = bArrArray[iArrayOffset];
            if (b8 < 0) {
                break;
            }
            iArrayOffset++;
            cArrArray[iArrayOffset3] = (char) b8;
            iArrayOffset3++;
        }
        int i8 = iArrayOffset;
        while (true) {
            int i9 = iArrayOffset3;
            while (i8 < iArrayOffset2) {
                byte b9 = bArrArray[i8];
                if (b9 < 0) {
                    if ((b9 >> 5) == -2) {
                        if (iArrayOffset2 - i8 < 2 || i9 >= iArrayOffset4) {
                            return j(byteBuffer, i8, iArrayOffset2, charBuffer, i9, 2);
                        }
                        byte b10 = bArrArray[i8 + 1];
                        if (b(b9, b10)) {
                            return g(byteBuffer, i8, charBuffer, i9, 2);
                        }
                        i7 = i9 + 1;
                        cArrArray[i9] = (char) (((b9 << 6) ^ b10) ^ r0.f38533f);
                        i8 += 2;
                    } else if ((b9 >> 4) == -2) {
                        if (iArrayOffset2 - i8 < 3 || i9 >= iArrayOffset4) {
                            return j(byteBuffer, i8, iArrayOffset2, charBuffer, i9, 3);
                        }
                        byte b11 = bArrArray[i8 + 1];
                        byte b12 = bArrArray[i8 + 2];
                        if (c(b9, b11, b12)) {
                            return g(byteBuffer, i8, charBuffer, i9, 3);
                        }
                        i7 = i9 + 1;
                        cArrArray[i9] = (char) ((((b9 << com.google.common.base.c.f19314n) ^ (b11 << 6)) ^ b12) ^ 8064);
                        i8 += 3;
                    } else {
                        if ((b9 >> 3) != -2) {
                            return g(byteBuffer, i8, charBuffer, i9, 1);
                        }
                        if (iArrayOffset2 - i8 < 4 || iArrayOffset4 - i9 < 2) {
                            return j(byteBuffer, i8, iArrayOffset2, charBuffer, i9, 4);
                        }
                        byte b13 = bArrArray[i8 + 1];
                        byte b14 = bArrArray[i8 + 2];
                        byte b15 = bArrArray[i8 + 3];
                        int i10 = ((b9 & 7) << 18) | ((b13 & r0.f38528a) << 12) | ((b14 & r0.f38528a) << 6) | (b15 & r0.f38528a);
                        if (d(b13, b14, b15) || !a.c(i10)) {
                            return g(byteBuffer, i8, charBuffer, i9, 4);
                        }
                        int i11 = i9 + 1;
                        cArrArray[i9] = a.a(i10);
                        i7 = i11 + 1;
                        cArrArray[i11] = a.b(i10);
                        i8 += 4;
                    }
                    i9 = i7;
                } else {
                    if (i9 >= iArrayOffset4) {
                        return j(byteBuffer, i8, iArrayOffset2, charBuffer, i9, 1);
                    }
                    iArrayOffset3 = i9 + 1;
                    cArrArray[i9] = (char) b9;
                    i8++;
                }
            }
            return j(byteBuffer, i8, iArrayOffset2, charBuffer, i9, 0);
        }
    }

    private static boolean b(int i7, int i8) {
        return (i7 & 30) == 0 || (i8 & com.alibaba.fastjson.asm.j.f12606c0) != 128;
    }

    private static boolean c(int i7, int i8, int i9) {
        return ((i7 != -32 || (i8 & 224) != 128) && (i8 & com.alibaba.fastjson.asm.j.f12606c0) == 128 && (i9 & com.alibaba.fastjson.asm.j.f12606c0) == 128) ? false : true;
    }

    private static boolean d(int i7, int i8, int i9) {
        return ((i7 & com.alibaba.fastjson.asm.j.f12606c0) == 128 && (i8 & com.alibaba.fastjson.asm.j.f12606c0) == 128 && (i9 & com.alibaba.fastjson.asm.j.f12606c0) == 128) ? false : true;
    }

    private static boolean e(int i7) {
        return (i7 & com.alibaba.fastjson.asm.j.f12606c0) != 128;
    }

    private static CoderResult f(ByteBuffer byteBuffer, int i7) {
        for (int i8 = 1; i8 < i7; i8++) {
            if (e(byteBuffer.get())) {
                return CoderResult.malformedForLength(i8);
            }
        }
        return CoderResult.malformedForLength(i7);
    }

    private static CoderResult g(ByteBuffer byteBuffer, int i7, CharBuffer charBuffer, int i8, int i9) {
        byteBuffer.position(i7 - byteBuffer.arrayOffset());
        CoderResult coderResultH = h(byteBuffer, i9);
        i(byteBuffer, i7, charBuffer, i8);
        return coderResultH;
    }

    public static CoderResult h(ByteBuffer byteBuffer, int i7) {
        int i8 = 1;
        if (i7 == 1) {
            byte b8 = byteBuffer.get();
            if ((b8 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : f(byteBuffer, 5);
            }
            if ((b8 >> 1) == -2) {
                return byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : f(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i7 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i7 == 3) {
            byte b9 = byteBuffer.get();
            byte b10 = byteBuffer.get();
            if ((b9 != -32 || (b10 & 224) != 128) && !e(b10)) {
                i8 = 2;
            }
            return CoderResult.malformedForLength(i8);
        }
        if (i7 != 4) {
            throw new IllegalStateException();
        }
        int i9 = byteBuffer.get() & 255;
        int i10 = byteBuffer.get() & 255;
        if (i9 > 244 || ((i9 == 240 && (i10 < 144 || i10 > 191)) || ((i9 == 244 && (i10 & 240) != 128) || e(i10)))) {
            return CoderResult.malformedForLength(1);
        }
        return e(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
    }

    static void i(Buffer buffer, int i7, Buffer buffer2, int i8) {
        buffer.position(i7);
        buffer2.position(i8);
    }

    private static CoderResult j(Buffer buffer, int i7, int i8, Buffer buffer2, int i9, int i10) {
        i(buffer, i7, buffer2, i9);
        return (i10 == 0 || i8 - i7 < i10) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return a(byteBuffer, charBuffer);
    }
}
