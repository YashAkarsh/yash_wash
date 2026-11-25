package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class d extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23930d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23931e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23932f = 10;

    d(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws com.google.zxing.m, com.google.zxing.h {
        if (c().o() < 48) {
            throw com.google.zxing.m.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(393");
        sb.append(iF);
        sb.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb.append('0');
        }
        if (iF2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iF2);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
