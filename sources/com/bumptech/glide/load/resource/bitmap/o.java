package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class o implements a1.b<com.bumptech.glide.load.model.g, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f14584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w0.e<File, Bitmap> f14585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.f<Bitmap> f14586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.model.h f14587d;

    public o(a1.b<InputStream, Bitmap> bVar, a1.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.f14586c = bVar.i();
        this.f14587d = new com.bumptech.glide.load.model.h(bVar.e(), bVar2.e());
        this.f14585b = bVar.k();
        this.f14584a = new n(bVar.j(), bVar2.j());
    }

    @Override // a1.b
    public w0.b<com.bumptech.glide.load.model.g> e() {
        return this.f14587d;
    }

    @Override // a1.b
    public w0.f<Bitmap> i() {
        return this.f14586c;
    }

    @Override // a1.b
    public w0.e<com.bumptech.glide.load.model.g, Bitmap> j() {
        return this.f14584a;
    }

    @Override // a1.b
    public w0.e<File, Bitmap> k() {
        return this.f14585b;
    }
}
