package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
abstract class h extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f23941c = 40;

    h(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    private static void e(StringBuilder sb, int i7) {
        int i8 = 0;
        for (int i9 = 0; i9 < 13; i9++) {
            int iCharAt = sb.charAt(i9 + i7) - '0';
            if ((i9 & 1) == 0) {
                iCharAt *= 3;
            }
            i8 += iCharAt;
        }
        int i10 = 10 - (i8 % 10);
        sb.append(i10 != 10 ? i10 : 0);
    }

    final void f(StringBuilder sb, int i7) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i7, length);
    }

    final void g(StringBuilder sb, int i7, int i8) {
        for (int i9 = 0; i9 < 4; i9++) {
            int iF = b().f((i9 * 10) + i7, 10);
            if (iF / 100 == 0) {
                sb.append('0');
            }
            if (iF / 10 == 0) {
                sb.append('0');
            }
            sb.append(iF);
        }
        e(sb, i8);
    }
}
