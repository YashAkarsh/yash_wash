package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public class h implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f14867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f14868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f14869c;

    public h() {
        this(null);
    }

    private boolean k() {
        d dVar = this.f14869c;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f14869c;
        return dVar == null || dVar.e(this);
    }

    private boolean m() {
        d dVar = this.f14869c;
        return dVar != null && dVar.b();
    }

    @Override // com.bumptech.glide.request.c
    public void a() {
        this.f14867a.a();
        this.f14868b.a();
    }

    @Override // com.bumptech.glide.request.d
    public boolean b() {
        return m() || c();
    }

    @Override // com.bumptech.glide.request.c
    public boolean c() {
        return this.f14867a.c() || this.f14868b.c();
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        this.f14868b.clear();
        this.f14867a.clear();
    }

    @Override // com.bumptech.glide.request.d
    public boolean d(c cVar) {
        return k() && cVar.equals(this.f14867a) && !b();
    }

    @Override // com.bumptech.glide.request.d
    public boolean e(c cVar) {
        return l() && (cVar.equals(this.f14867a) || !this.f14867a.c());
    }

    @Override // com.bumptech.glide.request.d
    public void f(c cVar) {
        if (cVar.equals(this.f14868b)) {
            return;
        }
        d dVar = this.f14869c;
        if (dVar != null) {
            dVar.f(this);
        }
        if (this.f14868b.j()) {
            return;
        }
        this.f14868b.clear();
    }

    @Override // com.bumptech.glide.request.c
    public boolean g() {
        return this.f14867a.g();
    }

    @Override // com.bumptech.glide.request.c
    public boolean h() {
        return this.f14867a.h();
    }

    @Override // com.bumptech.glide.request.c
    public void i() {
        if (!this.f14868b.isRunning()) {
            this.f14868b.i();
        }
        if (this.f14867a.isRunning()) {
            return;
        }
        this.f14867a.i();
    }

    @Override // com.bumptech.glide.request.c
    public boolean isCancelled() {
        return this.f14867a.isCancelled();
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        return this.f14867a.isRunning();
    }

    @Override // com.bumptech.glide.request.c
    public boolean j() {
        return this.f14867a.j() || this.f14868b.j();
    }

    public void n(c cVar, c cVar2) {
        this.f14867a = cVar;
        this.f14868b = cVar2;
    }

    @Override // com.bumptech.glide.request.c
    public void pause() {
        this.f14867a.pause();
        this.f14868b.pause();
    }

    public h(d dVar) {
        this.f14869c = dVar;
    }
}
