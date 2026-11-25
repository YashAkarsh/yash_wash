package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class c0 extends Number {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ThreadLocal<int[]> f19593d = new ThreadLocal<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Random f19594e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f19595f = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Unsafe f19596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f19597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f19598i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile transient b[] f19599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile transient long f19600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile transient int f19601c;

    static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
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

    static final class b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final Unsafe f19602p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final long f19603q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f19604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile long f19605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile long f19606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f19607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f19608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f19609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile long f19610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f19611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile long f19612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile long f19613j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile long f19614k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile long f19615l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile long f19616m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        volatile long f19617n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile long f19618o;

        static {
            try {
                Unsafe unsafeH = c0.h();
                f19602p = unsafeH;
                f19603q = unsafeH.objectFieldOffset(b.class.getDeclaredField("h"));
            } catch (Exception e8) {
                throw new Error(e8);
            }
        }

        b(long j7) {
            this.f19611h = j7;
        }

        final boolean a(long j7, long j8) {
            return f19602p.compareAndSwapLong(this, f19603q, j7, j8);
        }
    }

    static {
        try {
            Unsafe unsafeH = h();
            f19596g = unsafeH;
            f19597h = unsafeH.objectFieldOffset(c0.class.getDeclaredField("b"));
            f19598i = unsafeH.objectFieldOffset(c0.class.getDeclaredField("c"));
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }

    c0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe h() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e8) {
                throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new a());
        }
    }

    final boolean e(long j7, long j8) {
        return f19596g.compareAndSwapLong(this, f19597h, j7, j8);
    }

    final boolean f() {
        return f19596g.compareAndSwapInt(this, f19598i, 0, 1);
    }

    abstract long g(long j7, long j8);

    final void i(long j7) {
        b[] bVarArr = this.f19599a;
        this.f19600b = j7;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f19611h = j7;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    final void j(long j7, int[] iArr, boolean z7) {
        int iNextInt;
        int[] iArr2;
        boolean z8;
        int length;
        boolean z9;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            f19593d.set(iArr2);
            iNextInt = f19594e.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        boolean z10 = false;
        int i7 = iNextInt;
        boolean z11 = z7;
        while (true) {
            b[] bVarArr = this.f19599a;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i7];
                if (bVar == null) {
                    if (this.f19601c == 0) {
                        b bVar2 = new b(j7);
                        if (this.f19601c == 0 && f()) {
                            try {
                                b[] bVarArr2 = this.f19599a;
                                if (bVarArr2 == null || (length2 = bVarArr2.length) <= 0) {
                                    z9 = false;
                                } else {
                                    int i8 = (length2 - 1) & i7;
                                    if (bVarArr2[i8] == null) {
                                        bVarArr2[i8] = bVar2;
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                }
                                this.f19601c = 0;
                                if (z9) {
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f19601c = 0;
                                throw th;
                            }
                        }
                    }
                    z10 = false;
                    int i9 = i7 ^ (i7 << 13);
                    int i10 = i9 ^ (i9 >>> 17);
                    i7 = i10 ^ (i10 << 5);
                    iArr2[0] = i7;
                } else {
                    if (z11) {
                        long j8 = bVar.f19611h;
                        if (bVar.a(j8, g(j8, j7))) {
                            return;
                        }
                        if (length >= f19595f || this.f19599a != bVarArr) {
                            z10 = false;
                        } else if (!z10) {
                            z10 = true;
                        } else if (this.f19601c == 0 && f()) {
                            try {
                                if (this.f19599a == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i11 = 0; i11 < length; i11++) {
                                        bVarArr3[i11] = bVarArr[i11];
                                    }
                                    this.f19599a = bVarArr3;
                                }
                                this.f19601c = 0;
                                z10 = false;
                            } catch (Throwable th2) {
                                this.f19601c = 0;
                                throw th2;
                            }
                        }
                    } else {
                        z11 = true;
                    }
                    int i12 = i7 ^ (i7 << 13);
                    int i13 = i12 ^ (i12 >>> 17);
                    i7 = i13 ^ (i13 << 5);
                    iArr2[0] = i7;
                }
            } else if (this.f19601c == 0 && this.f19599a == bVarArr && f()) {
                try {
                    if (this.f19599a == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i7 & 1] = new b(j7);
                        this.f19599a = bVarArr4;
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    this.f19601c = 0;
                    if (z8) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.f19601c = 0;
                    throw th3;
                }
            } else {
                long j9 = this.f19600b;
                if (e(j9, g(j9, j7))) {
                    return;
                }
            }
        }
    }
}
