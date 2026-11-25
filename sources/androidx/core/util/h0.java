package androidx.core.util;

import c.x0;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static final int f6368a = 19;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f6369b = 60;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f6370c = 3600;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f6371d = 86400;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f6372e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static char[] f6373f = new char[24];

    private h0() {
    }

    private static int a(int i7, int i8, boolean z7, int i9) {
        if (i7 > 99 || (z7 && i9 >= 3)) {
            return i8 + 3;
        }
        if (i7 > 9 || (z7 && i9 >= 2)) {
            return i8 + 2;
        }
        if (z7 || i7 > 0) {
            return i8 + 1;
        }
        return 0;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static void b(long j7, long j8, PrintWriter printWriter) {
        if (j7 == 0) {
            printWriter.print("--");
        } else {
            d(j7 - j8, printWriter, 0);
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static void c(long j7, PrintWriter printWriter) {
        d(j7, printWriter, 0);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static void d(long j7, PrintWriter printWriter, int i7) {
        synchronized (f6372e) {
            printWriter.print(new String(f6373f, 0, f(j7, i7)));
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static void e(long j7, StringBuilder sb) {
        synchronized (f6372e) {
            sb.append(f6373f, 0, f(j7, 0));
        }
    }

    private static int f(long j7, int i7) {
        char c8;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j8 = j7;
        if (f6373f.length < i7) {
            f6373f = new char[i7];
        }
        char[] cArr = f6373f;
        if (j8 == 0) {
            int i13 = i7 - 1;
            while (i13 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j8 > 0) {
            c8 = '+';
        } else {
            j8 = -j8;
            c8 = '-';
        }
        int i14 = (int) (j8 % 1000);
        int iFloor = (int) Math.floor(j8 / 1000);
        if (iFloor > 86400) {
            i8 = iFloor / 86400;
            iFloor -= 86400 * i8;
        } else {
            i8 = 0;
        }
        if (iFloor > 3600) {
            i9 = iFloor / 3600;
            iFloor -= i9 * 3600;
        } else {
            i9 = 0;
        }
        if (iFloor > 60) {
            int i15 = iFloor / 60;
            i10 = iFloor - (i15 * 60);
            i11 = i15;
        } else {
            i10 = iFloor;
            i11 = 0;
        }
        if (i7 != 0) {
            int iA = a(i8, 1, false, 0);
            int iA2 = iA + a(i9, 1, iA > 0, 2);
            int iA3 = iA2 + a(i11, 1, iA2 > 0, 2);
            int iA4 = iA3 + a(i10, 1, iA3 > 0, 2);
            i12 = 0;
            for (int iA5 = iA4 + a(i14, 2, true, iA4 > 0 ? 3 : 0) + 1; iA5 < i7; iA5++) {
                cArr[i12] = ' ';
                i12++;
            }
        } else {
            i12 = 0;
        }
        cArr[i12] = c8;
        int i16 = i12 + 1;
        boolean z7 = i7 != 0;
        int iG = g(cArr, i8, 'd', i16, false, 0);
        int iG2 = g(cArr, i9, 'h', iG, iG != i16, z7 ? 2 : 0);
        int iG3 = g(cArr, i11, 'm', iG2, iG2 != i16, z7 ? 2 : 0);
        int iG4 = g(cArr, i10, 's', iG3, iG3 != i16, z7 ? 2 : 0);
        int iG5 = g(cArr, i14, 'm', iG4, true, (!z7 || iG4 == i16) ? 0 : 3);
        cArr[iG5] = 's';
        return iG5 + 1;
    }

    private static int g(char[] cArr, int i7, char c8, int i8, boolean z7, int i9) {
        int i10;
        if (!z7 && i7 <= 0) {
            return i8;
        }
        if ((!z7 || i9 < 3) && i7 <= 99) {
            i10 = i8;
        } else {
            int i11 = i7 / 100;
            cArr[i8] = (char) (i11 + 48);
            i10 = i8 + 1;
            i7 -= i11 * 100;
        }
        if ((z7 && i9 >= 2) || i7 > 9 || i8 != i10) {
            int i12 = i7 / 10;
            cArr[i10] = (char) (i12 + 48);
            i10++;
            i7 -= i12 * 10;
        }
        cArr[i10] = (char) (i7 + 48);
        int i13 = i10 + 1;
        cArr[i13] = c8;
        return i13 + 1;
    }
}
