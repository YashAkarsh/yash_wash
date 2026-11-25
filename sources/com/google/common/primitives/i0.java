package com.google.common.primitives;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f22375a = -128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f22376b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f22377c = 255;

    @s1.d
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f22378a = a.class.getName() + "$UnsafeComparator";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Comparator<byte[]> f22379b = a();

        /* JADX INFO: renamed from: com.google.common.primitives.i0$a$a, reason: collision with other inner class name */
        enum EnumC0285a implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                for (int i7 = 0; i7 < iMin; i7++) {
                    int iB = i0.b(bArr[i7], bArr2[i7]);
                    if (iB != 0) {
                        return iB;
                    }
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        @s1.d
        enum b implements Comparator<byte[]> {
            INSTANCE;


            /* JADX INFO: renamed from: b, reason: collision with root package name */
            static final boolean f22383b = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            static final Unsafe f22384c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            static final int f22385d;

            /* JADX INFO: renamed from: com.google.common.primitives.i0$a$b$a, reason: collision with other inner class name */
            static class C0286a implements PrivilegedExceptionAction<Unsafe> {
                C0286a() {
                }

                @Override // java.security.PrivilegedExceptionAction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            }

            static {
                Unsafe unsafeB = b();
                f22384c = unsafeB;
                int iArrayBaseOffset = unsafeB.arrayBaseOffset(byte[].class);
                f22385d = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafeB.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe b() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e8) {
                        throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new C0286a());
                }
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                int i7 = iMin & (-8);
                int i8 = 0;
                while (i8 < i7) {
                    Unsafe unsafe = f22384c;
                    int i9 = f22385d;
                    long j7 = i8;
                    long j8 = unsafe.getLong(bArr, ((long) i9) + j7);
                    long j9 = unsafe.getLong(bArr2, ((long) i9) + j7);
                    if (j8 != j9) {
                        if (f22383b) {
                            return m0.a(j8, j9);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j8 ^ j9) & (-8);
                        return ((int) ((j8 >>> iNumberOfTrailingZeros) & 255)) - ((int) ((j9 >>> iNumberOfTrailingZeros) & 255));
                    }
                    i8 += 8;
                }
                while (i8 < iMin) {
                    int iB = i0.b(bArr[i8], bArr2[i8]);
                    if (iB != 0) {
                        return iB;
                    }
                    i8++;
                }
                return bArr.length - bArr2.length;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        a() {
        }

        static Comparator<byte[]> a() {
            try {
                return (Comparator) Class.forName(f22378a).getEnumConstants()[0];
            } catch (Throwable unused) {
                return i0.f();
            }
        }
    }

    private i0() {
    }

    @u1.a
    public static byte a(long j7) {
        com.google.common.base.e0.p((j7 >> 8) == 0, "out of range: %s", j7);
        return (byte) j7;
    }

    public static int b(byte b8, byte b9) {
        return p(b8) - p(b9);
    }

    private static byte c(byte b8) {
        return (byte) (b8 ^ 128);
    }

    public static String d(String str, byte... bArr) {
        com.google.common.base.e0.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(p(bArr[0]));
        for (int i7 = 1; i7 < bArr.length; i7++) {
            sb.append(str);
            sb.append(q(bArr[i7]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> e() {
        return a.f22379b;
    }

    @s1.d
    static Comparator<byte[]> f() {
        return a.EnumC0285a.INSTANCE;
    }

    public static byte g(byte... bArr) {
        com.google.common.base.e0.d(bArr.length > 0);
        int iP = p(bArr[0]);
        for (int i7 = 1; i7 < bArr.length; i7++) {
            int iP2 = p(bArr[i7]);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return (byte) iP;
    }

    public static byte h(byte... bArr) {
        com.google.common.base.e0.d(bArr.length > 0);
        int iP = p(bArr[0]);
        for (int i7 = 1; i7 < bArr.length; i7++) {
            int iP2 = p(bArr[i7]);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return (byte) iP;
    }

    @s1.a
    @u1.a
    public static byte i(String str) {
        return j(str, 10);
    }

    @s1.a
    @u1.a
    public static byte j(String str, int i7) {
        int i8 = Integer.parseInt((String) com.google.common.base.e0.E(str), i7);
        if ((i8 >> 8) == 0) {
            return (byte) i8;
        }
        throw new NumberFormatException("out of range: " + i8);
    }

    public static byte k(long j7) {
        if (j7 > p((byte) -1)) {
            return (byte) -1;
        }
        if (j7 < 0) {
            return (byte) 0;
        }
        return (byte) j7;
    }

    public static void l(byte[] bArr) {
        com.google.common.base.e0.E(bArr);
        m(bArr, 0, bArr.length);
    }

    public static void m(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.E(bArr);
        com.google.common.base.e0.f0(i7, i8, bArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            bArr[i9] = c(bArr[i9]);
        }
        Arrays.sort(bArr, i7, i8);
        while (i7 < i8) {
            bArr[i7] = c(bArr[i7]);
            i7++;
        }
    }

    public static void n(byte[] bArr) {
        com.google.common.base.e0.E(bArr);
        o(bArr, 0, bArr.length);
    }

    public static void o(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.E(bArr);
        com.google.common.base.e0.f0(i7, i8, bArr.length);
        for (int i9 = i7; i9 < i8; i9++) {
            bArr[i9] = (byte) (bArr[i9] ^ 127);
        }
        Arrays.sort(bArr, i7, i8);
        while (i7 < i8) {
            bArr[i7] = (byte) (bArr[i7] ^ 127);
            i7++;
        }
    }

    public static int p(byte b8) {
        return b8 & 255;
    }

    @s1.a
    public static String q(byte b8) {
        return r(b8, 10);
    }

    @s1.a
    public static String r(byte b8, int i7) {
        com.google.common.base.e0.k(i7 >= 2 && i7 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i7);
        return Integer.toString(p(b8), i7);
    }
}
