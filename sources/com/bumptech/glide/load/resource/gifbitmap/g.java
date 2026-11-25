package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class g implements a1.b<com.bumptech.glide.load.model.g, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.e<File, a> f14702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.e<com.bumptech.glide.load.model.g, a> f14703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.f<a> f14704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w0.b<com.bumptech.glide.load.model.g> f14705d;

    public g(a1.b<com.bumptech.glide.load.model.g, Bitmap> bVar, a1.b<InputStream, com.bumptech.glide.load.resource.gif.b> bVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        c cVar2 = new c(bVar.j(), bVar2.j(), cVar);
        this.f14702a = new com.bumptech.glide.load.resource.file.c(new e(cVar2));
        this.f14703b = cVar2;
        this.f14704c = new d(bVar.i(), bVar2.i());
        this.f14705d = bVar.e();
    }

    @Override // a1.b
    public w0.b<com.bumptech.glide.load.model.g> e() {
        return this.f14705d;
    }

    @Override // a1.b
    public w0.f<a> i() {
        return this.f14704c;
    }

    @Override // a1.b
    public w0.e<com.bumptech.glide.load.model.g, a> j() {
        return this.f14703b;
    }

    @Override // a1.b
    public w0.e<File, a> k() {
        return this.f14702a;
    }
}
