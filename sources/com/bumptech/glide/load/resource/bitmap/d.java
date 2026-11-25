package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.m<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f14527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14528b;

    public d(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (cVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.f14527a = bitmap;
        this.f14528b = cVar;
    }

    public static d d(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, cVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        if (this.f14528b.b(this.f14527a)) {
            return;
        }
        this.f14527a.recycle();
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return com.bumptech.glide.util.i.f(this.f14527a);
    }

    @Override // com.bumptech.glide.load.engine.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f14527a;
    }
}
