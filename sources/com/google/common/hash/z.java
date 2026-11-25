package com.google.common.hash;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f21888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f21889b = false;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ b[] f21891b;

        static enum a extends b {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.hash.z.c
            public long a(byte[] bArr, int i7) {
                return com.google.common.primitives.d0.j(bArr[i7 + 7], bArr[i7 + 6], bArr[i7 + 5], bArr[i7 + 4], bArr[i7 + 3], bArr[i7 + 2], bArr[i7 + 1], bArr[i7]);
            }

            @Override // com.google.common.hash.z.c
            public void b(byte[] bArr, int i7, long j7) {
                long j8 = 255;
                for (int i8 = 0; i8 < 8; i8++) {
                    bArr[i7 + i8] = (byte) ((j7 & j8) >> (i8 * 8));
                    j8 <<= 8;
                }
            }
        }

        static {
            a aVar = new a("INSTANCE", 0);
            f21890a = aVar;
            f21891b = new b[]{aVar};
        }

        private b(String str, int i7) {
            super(str, i7);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f21891b.clone();
        }
    }

    private interface c {
        long a(byte[] bArr, int i7);

        void b(byte[] bArr, int i7, long j7);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f21892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f21893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Unsafe f21894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f21895d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d[] f21896e;

        static enum a extends d {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.hash.z.c
            public long a(byte[] bArr, int i7) {
                return d.f21894c.getLong(bArr, ((long) i7) + ((long) d.f21895d));
            }

            @Override // com.google.common.hash.z.c
            public void b(byte[] bArr, int i7, long j7) {
                d.f21894c.putLong(bArr, ((long) i7) + ((long) d.f21895d), j7);
            }
        }

        static enum b extends d {
            b(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.hash.z.c
            public long a(byte[] bArr, int i7) {
                return Long.reverseBytes(d.f21894c.getLong(bArr, ((long) i7) + ((long) d.f21895d)));
            }

            @Override // com.google.common.hash.z.c
            public void b(byte[] bArr, int i7, long j7) {
                d.f21894c.putLong(bArr, ((long) i7) + ((long) d.f21895d), Long.reverseBytes(j7));
            }
        }

        static class c implements PrivilegedExceptionAction<Unsafe> {
            c() {
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
            a aVar = new a("UNSAFE_LITTLE_ENDIAN", 0);
            f21892a = aVar;
            b bVar = new b("UNSAFE_BIG_ENDIAN", 1);
            f21893b = bVar;
            f21896e = new d[]{aVar, bVar};
            Unsafe unsafeE = e();
            f21894c = unsafeE;
            f21895d = unsafeE.arrayBaseOffset(byte[].class);
            if (unsafeE.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        private d(String str, int i7) {
            super(str, i7);
        }

        private static Unsafe e() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e8) {
                    throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new c());
            }
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f21896e.clone();
        }
    }

    static {
        c cVar = b.f21890a;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                cVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? d.f21892a : d.f21893b;
            }
        } catch (Throwable unused) {
        }
        f21888a = cVar;
    }

    private z() {
    }

    static int a(byte[] bArr, int i7) {
        return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
    }

    static long b(byte[] bArr, int i7) {
        return f21888a.a(bArr, i7);
    }

    static long c(byte[] bArr, int i7, int i8) {
        int iMin = Math.min(i8, 8);
        long j7 = 0;
        for (int i9 = 0; i9 < iMin; i9++) {
            j7 |= (((long) bArr[i7 + i9]) & 255) << (i9 * 8);
        }
        return j7;
    }

    static void d(byte[] bArr, int i7, long j7) {
        f21888a.b(bArr, i7, j7);
    }

    static boolean e() {
        return f21888a instanceof d;
    }
}
