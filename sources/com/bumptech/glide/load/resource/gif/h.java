package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
class h implements w0.e<com.bumptech.glide.gifdecoder.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14668a;

    public h(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f14668a = cVar;
    }

    @Override // w0.e
    public String a() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }

    @Override // w0.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m<Bitmap> b(com.bumptech.glide.gifdecoder.a aVar, int i7, int i8) {
        return com.bumptech.glide.load.resource.bitmap.d.d(aVar.n(), this.f14668a);
    }
}
