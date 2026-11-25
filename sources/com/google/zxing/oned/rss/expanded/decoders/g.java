package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class g extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23940d = 4;

    g(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws com.google.zxing.m, com.google.zxing.h {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(b().f(4, 4));
        g(sb, 8, length);
        return b().a(sb, 48);
    }
}
