package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import okio.r0;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static x f7619a;

    static class a {
        a() {
        }

        static void a(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i7) throws IllegalArgumentException {
            if (f(b9) || (((b8 << com.google.common.base.c.F) + (b9 + 112)) >> 30) != 0 || f(b10) || f(b11)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int iK = ((b8 & 7) << 18) | (k(b9) << 12) | (k(b10) << 6) | k(b11);
            cArr[i7] = e(iK);
            cArr[i7 + 1] = j(iK);
        }

        static void b(byte b8, char[] cArr, int i7) {
            cArr[i7] = (char) b8;
        }

        static void c(byte b8, byte b9, byte b10, char[] cArr, int i7) throws IllegalArgumentException {
            if (f(b9) || ((b8 == -32 && b9 < -96) || ((b8 == -19 && b9 >= -96) || f(b10)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i7] = (char) (((b8 & com.google.common.base.c.f19317q) << 12) | (k(b9) << 6) | k(b10));
        }

        static void d(byte b8, byte b9, char[] cArr, int i7) throws IllegalArgumentException {
            if (b8 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (f(b9)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i7] = (char) (((b8 & com.google.common.base.c.I) << 6) | k(b9));
        }

        private static char e(int i7) {
            return (char) ((i7 >>> 10) + r0.f38531d);
        }

        private static boolean f(byte b8) {
            return b8 > -65;
        }

        static boolean g(byte b8) {
            return b8 >= 0;
        }

        static boolean h(byte b8) {
            return b8 < -16;
        }

        static boolean i(byte b8) {
            return b8 < -32;
        }

        private static char j(int i7) {
            return (char) ((i7 & 1023) + r0.f38532e);
        }

        private static int k(byte b8) {
            return b8 & r0.f38528a;
        }
    }

    static class b extends IllegalArgumentException {
        b(int i7, int i8) {
            super("Unpaired surrogate at index " + i7 + " of " + i8);
        }
    }

    public static x d() {
        if (f7619a == null) {
            f7619a = new b0();
        }
        return f7619a;
    }

    public static void e(x xVar) {
        f7619a = xVar;
    }

    public abstract String a(ByteBuffer byteBuffer, int i7, int i8);

    public abstract void b(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int c(CharSequence charSequence);
}
