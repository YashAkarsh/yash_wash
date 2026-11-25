package com.bumptech.glide.request.animation;

/* JADX INFO: loaded from: classes.dex */
public class k<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j.a f14818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j<R> f14819b;

    public k(j.a aVar) {
        this.f14818a = aVar;
    }

    @Override // com.bumptech.glide.request.animation.f
    public e<R> a(boolean z7, boolean z8) {
        if (z7 || !z8) {
            return g.c();
        }
        if (this.f14819b == null) {
            this.f14819b = new j<>(this.f14818a);
        }
        return this.f14819b;
    }
}
