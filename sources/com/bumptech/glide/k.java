package com.bumptech.glide;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class k<ModelType> extends j<ModelType> {
    private final com.bumptech.glide.load.model.l<ModelType, InputStream> D;
    private final q.e E;

    k(h<ModelType, ?, ?, ?> hVar, com.bumptech.glide.load.model.l<ModelType, InputStream> lVar, q.e eVar) {
        super(M0(hVar.f14143c, lVar, com.bumptech.glide.load.resource.gif.b.class, null), com.bumptech.glide.load.resource.gif.b.class, hVar);
        this.D = lVar;
        this.E = eVar;
        h();
    }

    private static <A, R> a1.e<A, InputStream, com.bumptech.glide.load.resource.gif.b, R> M0(l lVar, com.bumptech.glide.load.model.l<A, InputStream> lVar2, Class<R> cls, y0.f<com.bumptech.glide.load.resource.gif.b, R> fVar) {
        if (lVar2 == null) {
            return null;
        }
        if (fVar == null) {
            fVar = lVar.i(com.bumptech.glide.load.resource.gif.b.class, cls);
        }
        return new a1.e<>(lVar2, fVar, lVar.a(InputStream.class, com.bumptech.glide.load.resource.gif.b.class));
    }

    public h<ModelType, InputStream, com.bumptech.glide.load.resource.gif.b, byte[]> N0() {
        return (h<ModelType, InputStream, com.bumptech.glide.load.resource.gif.b, byte[]>) O0(new y0.d(), byte[].class);
    }

    public <R> h<ModelType, InputStream, com.bumptech.glide.load.resource.gif.b, R> O0(y0.f<com.bumptech.glide.load.resource.gif.b, R> fVar, Class<R> cls) {
        return this.E.a(new h(M0(this.f14143c, this.D, cls, fVar), cls, this));
    }
}
