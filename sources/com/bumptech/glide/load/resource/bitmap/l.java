package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class l extends com.bumptech.glide.load.resource.drawable.a<k> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14556b;

    public l(k kVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(kVar);
        this.f14556b = cVar;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        this.f14556b.b(((k) this.f14612a).g());
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return com.bumptech.glide.util.i.f(((k) this.f14612a).g());
    }
}
