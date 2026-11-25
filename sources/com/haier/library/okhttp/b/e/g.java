package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.v;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements i0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i0> f27067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.haier.library.okhttp.b.d.g f27068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f27069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.haier.library.okhttp.b.d.c f27070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f27071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.haier.library.okhttp.f f27072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q f27073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d0 f27074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f27075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f27076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f27077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f27078l;

    public g(List<i0> list, com.haier.library.okhttp.b.d.g gVar, c cVar, com.haier.library.okhttp.b.d.c cVar2, int i7, com.haier.library.okhttp.f fVar, q qVar, d0 d0Var, int i8, int i9, int i10) {
        this.f27067a = list;
        this.f27070d = cVar2;
        this.f27068b = gVar;
        this.f27069c = cVar;
        this.f27071e = i7;
        this.f27072f = fVar;
        this.f27073g = qVar;
        this.f27074h = d0Var;
        this.f27075i = i8;
        this.f27076j = i9;
        this.f27077k = i10;
    }

    @Override // com.haier.library.okhttp.i0.a
    public int K() {
        return this.f27076j;
    }

    @Override // com.haier.library.okhttp.i0.a
    public com.haier.library.okhttp.f a() {
        return this.f27072f;
    }

    @Override // com.haier.library.okhttp.i0.a
    public v b() {
        return this.f27070d;
    }

    @Override // com.haier.library.okhttp.i0.a
    public i0.a c(int i7, TimeUnit timeUnit) {
        return new g(this.f27067a, this.f27068b, this.f27069c, this.f27070d, this.f27071e, this.f27072f, this.f27073g, this.f27074h, n.d.e(com.alipay.sdk.data.a.f13674p, i7, timeUnit), this.f27076j, this.f27077k);
    }

    @Override // com.haier.library.okhttp.i0.a
    public int d() {
        return this.f27075i;
    }

    public com.haier.library.okhttp.a e(com.haier.library.okhttp.f fVar, com.haier.library.okhttp.b.d.g gVar, c cVar, com.haier.library.okhttp.b.d.c cVar2) throws IOException {
        if (this.f27071e >= this.f27067a.size()) {
            throw new AssertionError();
        }
        this.f27078l++;
        if (this.f27069c != null && !this.f27070d.n(fVar.a())) {
            throw new IllegalStateException("network interceptor " + this.f27067a.get(this.f27071e - 1) + " must retain the same host and port");
        }
        if (this.f27069c != null && this.f27078l > 1) {
            throw new IllegalStateException("network interceptor " + this.f27067a.get(this.f27071e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f27067a, gVar, cVar, cVar2, this.f27071e + 1, fVar, this.f27073g, this.f27074h, this.f27075i, this.f27076j, this.f27077k);
        i0 i0Var = this.f27067a.get(this.f27071e);
        com.haier.library.okhttp.a aVarA = i0Var.a(gVar2);
        if (cVar != null && this.f27071e + 1 < this.f27067a.size() && gVar2.f27078l != 1) {
            throw new IllegalStateException("network interceptor " + i0Var + " must call proceed() exactly once");
        }
        if (aVarA == null) {
            throw new NullPointerException("interceptor " + i0Var + " returned null");
        }
        if (aVarA.b() != null) {
            return aVarA;
        }
        throw new IllegalStateException("interceptor " + i0Var + " returned a response with no body");
    }

    @Override // com.haier.library.okhttp.i0.a
    public int f() {
        return this.f27077k;
    }

    public com.haier.library.okhttp.b.d.g g() {
        return this.f27068b;
    }

    public c h() {
        return this.f27069c;
    }

    public d0 i() {
        return this.f27074h;
    }

    @Override // com.haier.library.okhttp.i0.a
    public com.haier.library.okhttp.a a(com.haier.library.okhttp.f fVar) throws IOException {
        return e(fVar, this.f27068b, this.f27069c, this.f27070d);
    }

    @Override // com.haier.library.okhttp.i0.a
    public i0.a b(int i7, TimeUnit timeUnit) {
        return new g(this.f27067a, this.f27068b, this.f27069c, this.f27070d, this.f27071e, this.f27072f, this.f27073g, this.f27074h, this.f27075i, this.f27076j, n.d.e(com.alipay.sdk.data.a.f13674p, i7, timeUnit));
    }

    @Override // com.haier.library.okhttp.i0.a
    public i0.a d(int i7, TimeUnit timeUnit) {
        return new g(this.f27067a, this.f27068b, this.f27069c, this.f27070d, this.f27071e, this.f27072f, this.f27073g, this.f27074h, this.f27075i, n.d.e(com.alipay.sdk.data.a.f13674p, i7, timeUnit), this.f27077k);
    }

    @Override // com.haier.library.okhttp.i0.a
    public q c() {
        return this.f27073g;
    }
}
