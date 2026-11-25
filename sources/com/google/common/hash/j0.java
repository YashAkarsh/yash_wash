package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class j0 extends Number {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ThreadLocal<int[]> f21801d = new ThreadLocal<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Random f21802e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f21803f = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Unsafe f21804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f21805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f21806i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile transient b[] f21807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile transient long f21808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile transient int f21809c;

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
        private static final Unsafe f21810p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final long f21811q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f21812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile long f21813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile long f21814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f21815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f21816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f21817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile long f21818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f21819h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile long f21820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile long f21821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile long f21822k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile long f21823l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile long f21824m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        volatile long f21825n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile long f21826o;

        static {
            try {
                Unsafe unsafeH = j0.h();
                f21810p = unsafeH;
                f21811q = unsafeH.objectFieldOffset(b.class.getDeclaredField("h"));
            } catch (Exception e8) {
                throw new Error(e8);
            }
        }

        b(long j7) {
            this.f21819h = j7;
        }

        final boolean a(long j7, long j8) {
            return f21810p.compareAndSwapLong(this, f21811q, j7, j8);
        }
    }

    static {
        try {
            Unsafe unsafeH = h();
            f21804g = unsafeH;
            f21805h = unsafeH.objectFieldOffset(j0.class.getDeclaredField("b"));
            f21806i = unsafeH.objectFieldOffset(j0.class.getDeclaredField("c"));
        } catch (Exception e8) {
            throw new Error(e8);
        }
    }

    j0() {
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
        return f21804g.compareAndSwapLong(this, f21805h, j7, j8);
    }

    final boolean f() {
        return f21804g.compareAndSwapInt(this, f21806i, 0, 1);
    }

    abstract long g(long j7, long j8);

    final void i(long j7) {
        b[] bVarArr = this.f21807a;
        this.f21808b = j7;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.f21819h = j7;
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
            f21801d.set(iArr2);
            iNextInt = f21802e.nextInt();
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
            b[] bVarArr = this.f21807a;
            if (bVarArr != null && (length = bVarArr.length) > 0) {
                b bVar = bVarArr[(length - 1) & i7];
                if (bVar == null) {
                    if (this.f21809c == 0) {
                        b bVar2 = new b(j7);
                        if (this.f21809c == 0 && f()) {
                            try {
                                b[] bVarArr2 = this.f21807a;
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
                                this.f21809c = 0;
                                if (z9) {
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f21809c = 0;
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
                        long j8 = bVar.f21819h;
                        if (bVar.a(j8, g(j8, j7))) {
                            return;
                        }
                        if (length >= f21803f || this.f21807a != bVarArr) {
                            z10 = false;
                        } else if (!z10) {
                            z10 = true;
                        } else if (this.f21809c == 0 && f()) {
                            try {
                                if (this.f21807a == bVarArr) {
                                    b[] bVarArr3 = new b[length << 1];
                                    for (int i11 = 0; i11 < length; i11++) {
                                        bVarArr3[i11] = bVarArr[i11];
                                    }
                                    this.f21807a = bVarArr3;
                                }
                                this.f21809c = 0;
                                z10 = false;
                            } catch (Throwable th2) {
                                this.f21809c = 0;
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
            } else if (this.f21809c == 0 && this.f21807a == bVarArr && f()) {
                try {
                    if (this.f21807a == bVarArr) {
                        b[] bVarArr4 = new b[2];
                        bVarArr4[i7 & 1] = new b(j7);
                        this.f21807a = bVarArr4;
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    this.f21809c = 0;
                    if (z8) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.f21809c = 0;
                    throw th3;
                }
            } else {
                long j9 = this.f21808b;
                if (e(j9, g(j9, j7))) {
                    return;
                }
            }
        }
    }
}
