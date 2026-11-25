package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class q implements a1.b<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f14595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f14596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.model.o f14597c = new com.bumptech.glide.load.model.o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.file.c<Bitmap> f14598d;

    public q(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        r rVar = new r(cVar, aVar);
        this.f14595a = rVar;
        this.f14596b = new c();
        this.f14598d = new com.bumptech.glide.load.resource.file.c<>(rVar);
    }

    @Override // a1.b
    public w0.b<InputStream> e() {
        return this.f14597c;
    }

    @Override // a1.b
    public w0.f<Bitmap> i() {
        return this.f14596b;
    }

    @Override // a1.b
    public w0.e<InputStream, Bitmap> j() {
        return this.f14595a;
    }

    @Override // a1.b
    public w0.e<File, Bitmap> k() {
        return this.f14598d;
    }
}
