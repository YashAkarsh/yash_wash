package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bumptech.glide.load.resource.drawable.a<BitmapDrawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14522b;

    public b(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(bitmapDrawable);
        this.f14522b = cVar;
    }

    @Override // com.bumptech.glide.load.engine.m
    public void a() {
        this.f14522b.b(((BitmapDrawable) this.f14612a).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.m
    public int b() {
        return com.bumptech.glide.util.i.f(((BitmapDrawable) this.f14612a).getBitmap());
    }
}
