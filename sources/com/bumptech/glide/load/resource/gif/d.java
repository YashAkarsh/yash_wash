package com.bumptech.glide.load.resource.gif;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.bumptech.glide.load.resource.drawable.a<b> {
    public d(b bVar) {
        super(bVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        ((b) this.f14612a).stop();
        ((b) this.f14612a).m();
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return ((b) this.f14612a).g().length + com.bumptech.glide.util.i.f(((b) this.f14612a).i());
    }
}
