package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<Z> implements m<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.c f14875a;

    @Override // com.bumptech.glide.request.target.m
    public void a(com.bumptech.glide.request.c cVar) {
        this.f14875a = cVar;
    }

    @Override // com.bumptech.glide.request.target.m
    public void c(Exception exc, Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.m
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.m
    public com.bumptech.glide.request.c e() {
        return this.f14875a;
    }

    @Override // com.bumptech.glide.request.target.m
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.h
    public void g() {
    }

    @Override // com.bumptech.glide.manager.h
    public void k() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
    }
}
