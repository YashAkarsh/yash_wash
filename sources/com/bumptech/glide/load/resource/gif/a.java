package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class a implements com.bumptech.glide.gifdecoder.a.InterfaceC0161a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14622a;

    public a(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f14622a = cVar;
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0161a
    public Bitmap a(int i7, int i8, Bitmap.Config config) {
        return this.f14622a.g(i7, i8, config);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0161a
    public void b(Bitmap bitmap) {
        if (this.f14622a.b(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
