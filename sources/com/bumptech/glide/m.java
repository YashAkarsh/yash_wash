package com.bumptech.glide;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bumptech.glide.load.engine.d f14707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.c f14708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.cache.i f14709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f14710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExecutorService f14711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private w0.a f14712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.cache.a.InterfaceC0164a f14713h;

    class a implements com.bumptech.glide.load.engine.cache.a.InterfaceC0164a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.cache.a f14714c;

        a(com.bumptech.glide.load.engine.cache.a aVar) {
            this.f14714c = aVar;
        }

        @Override // com.bumptech.glide.load.engine.cache.a.InterfaceC0164a
        public com.bumptech.glide.load.engine.cache.a build() {
            return this.f14714c;
        }
    }

    public m(Context context) {
        this.f14706a = context.getApplicationContext();
    }

    l a() {
        if (this.f14710e == null) {
            this.f14710e = new com.bumptech.glide.load.engine.executor.a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f14711f == null) {
            this.f14711f = new com.bumptech.glide.load.engine.executor.a(1);
        }
        com.bumptech.glide.load.engine.cache.k kVar = new com.bumptech.glide.load.engine.cache.k(this.f14706a);
        if (this.f14708c == null) {
            this.f14708c = new com.bumptech.glide.load.engine.bitmap_recycle.f(kVar.a());
        }
        if (this.f14709d == null) {
            this.f14709d = new com.bumptech.glide.load.engine.cache.h(kVar.c());
        }
        if (this.f14713h == null) {
            this.f14713h = new com.bumptech.glide.load.engine.cache.g(this.f14706a);
        }
        if (this.f14707b == null) {
            this.f14707b = new com.bumptech.glide.load.engine.d(this.f14709d, this.f14713h, this.f14711f, this.f14710e);
        }
        if (this.f14712g == null) {
            this.f14712g = w0.a.f40489d;
        }
        return new l(this.f14707b, this.f14709d, this.f14708c, this.f14706a, this.f14712g);
    }

    public m b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f14708c = cVar;
        return this;
    }

    public m c(w0.a aVar) {
        this.f14712g = aVar;
        return this;
    }

    public m d(com.bumptech.glide.load.engine.cache.a.InterfaceC0164a interfaceC0164a) {
        this.f14713h = interfaceC0164a;
        return this;
    }

    @Deprecated
    public m e(com.bumptech.glide.load.engine.cache.a aVar) {
        return d(new a(aVar));
    }

    public m f(ExecutorService executorService) {
        this.f14711f = executorService;
        return this;
    }

    m g(com.bumptech.glide.load.engine.d dVar) {
        this.f14707b = dVar;
        return this;
    }

    public m h(com.bumptech.glide.load.engine.cache.i iVar) {
        this.f14709d = iVar;
        return this;
    }

    public m i(ExecutorService executorService) {
        this.f14710e = executorService;
        return this;
    }
}
