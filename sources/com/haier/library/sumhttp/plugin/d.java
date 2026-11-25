package com.haier.library.sumhttp.plugin;

/* JADX INFO: loaded from: classes2.dex */
public class d extends l {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f27929q = 10000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.haier.library.okhttp.f f27930n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final h f27931o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f27932p;

    public d(com.haier.library.okhttp.f fVar, h hVar, a aVar, b bVar) {
        this(fVar, hVar, aVar, bVar, 10000L);
    }

    @Override // com.haier.library.sumhttp.plugin.l
    protected h b() {
        g.e(this.f27932p).f(this.f27930n, this.f27931o);
        return this.f27931o;
    }

    public h h() {
        return this.f27931o;
    }

    public d(com.haier.library.okhttp.f fVar, h hVar, a aVar, b bVar, long j7) {
        super(aVar, bVar);
        this.f27930n = fVar;
        this.f27931o = hVar;
        this.f27932p = j7;
    }

    public d(com.haier.library.okhttp.f fVar, h hVar, a aVar, b bVar, long j7, long j8) {
        super(aVar, bVar, j8);
        this.f27930n = fVar;
        this.f27931o = hVar;
        this.f27932p = j7;
    }
}
