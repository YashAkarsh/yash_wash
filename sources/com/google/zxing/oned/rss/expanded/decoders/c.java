package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class c extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23928d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f23929e = 2;

    c(com.google.zxing.common.a aVar) {
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
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
