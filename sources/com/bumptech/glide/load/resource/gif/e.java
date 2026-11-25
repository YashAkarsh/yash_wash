package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.m;

/* JADX INFO: loaded from: classes.dex */
public class e implements w0.g<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0.g<Bitmap> f14649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14650b;

    public e(w0.g<Bitmap> gVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f14649a = gVar;
        this.f14650b = cVar;
    }

    @Override // w0.g
    public String a() {
        return this.f14649a.a();
    }

    @Override // w0.g
    public m<b> b(m<b> mVar, int i7, int i8) {
        b bVar = mVar.get();
        Bitmap bitmapI = mVar.get().i();
        Bitmap bitmap = this.f14649a.b(new com.bumptech.glide.load.resource.bitmap.d(bitmapI, this.f14650b), i7, i8).get();
        return !bitmap.equals(bitmapI) ? new d(new b(bVar, bitmap, this.f14649a)) : mVar;
    }
}
