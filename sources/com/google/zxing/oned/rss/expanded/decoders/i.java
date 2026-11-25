package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
abstract class i extends h {
    i(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb, int i7);

    protected abstract int i(int i7);

    final void j(StringBuilder sb, int i7, int i8) {
        int iF = b().f(i7, i8);
        h(sb, iF);
        int i9 = i(iF);
        int i10 = 100000;
        for (int i11 = 0; i11 < 5; i11++) {
            if (i9 / i10 == 0) {
                sb.append('0');
            }
            i10 /= 10;
        }
        sb.append(i9);
    }
}
