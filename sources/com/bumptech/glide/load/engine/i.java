package com.bumptech.glide.load.engine;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
class i<Z> implements m<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m<Z> f14408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f14410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private w0.c f14411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14413f;

    interface a {
        void d(w0.c cVar, i<?> iVar);
    }

    i(m<Z> mVar, boolean z7) {
        if (mVar == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f14408a = mVar;
        this.f14409b = z7;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        if (this.f14412e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f14413f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f14413f = true;
        this.f14408a.a();
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return this.f14408a.b();
    }

    void c() {
        if (this.f14413f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.f14412e++;
    }

    boolean d() {
        return this.f14409b;
    }

    void e() {
        if (this.f14412e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i7 = this.f14412e - 1;
        this.f14412e = i7;
        if (i7 == 0) {
            this.f14410c.d(this.f14411d, this);
        }
    }

    void f(w0.c cVar, a aVar) {
        this.f14411d = cVar;
        this.f14410c = aVar;
    }

    @Override // com.bumptech.glide.load.engine.m
    public Z get() {
        return this.f14408a.get();
    }
}
