package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class h implements a1.b<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.e<File, Bitmap> f14537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f14538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f14539c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w0.b<ParcelFileDescriptor> f14540d = com.bumptech.glide.load.resource.b.c();

    public h(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.a aVar) {
        this.f14537a = new com.bumptech.glide.load.resource.file.c(new r(cVar, aVar));
        this.f14538b = new i(cVar, aVar);
    }

    @Override // a1.b
    public w0.b<ParcelFileDescriptor> e() {
        return this.f14540d;
    }

    @Override // a1.b
    public w0.f<Bitmap> i() {
        return this.f14539c;
    }

    @Override // a1.b
    public w0.e<ParcelFileDescriptor, Bitmap> j() {
        return this.f14538b;
    }

    @Override // a1.b
    public w0.e<File, Bitmap> k() {
        return this.f14537a;
    }
}
