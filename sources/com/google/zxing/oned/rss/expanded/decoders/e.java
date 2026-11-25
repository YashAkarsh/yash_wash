package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
final class e extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23933f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f23934g = 20;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f23935h = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23937e;

    e(com.google.zxing.common.a aVar, String str, String str2) {
        super(aVar);
        this.f23936d = str2;
        this.f23937e = str;
    }

    private void k(StringBuilder sb, int i7) {
        int iF = b().f(i7, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f23936d);
        sb.append(')');
        int i8 = iF % 32;
        int i9 = iF / 32;
        int i10 = (i9 % 12) + 1;
        int i11 = i9 / 12;
        if (i11 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i11);
        if (i10 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i10);
        if (i8 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i8);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() throws com.google.zxing.m {
        if (c().o() != 84) {
            throw com.google.zxing.m.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb, int i7) {
        sb.append('(');
        sb.append(this.f23937e);
        sb.append(i7 / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i7) {
        return i7 % 100000;
    }
}
