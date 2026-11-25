package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class b extends f {
    b(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i7) {
        if (i7 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i7) {
        return i7 < 10000 ? i7 : i7 - com.haier.library.sumhttp.plugin.h.f27948e;
    }
}
