package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(Context context) {
        super(context);
    }

    @Override // w0.g
    public String a() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.e
    protected Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i7, int i8) {
        return s.b(bitmap, cVar, i7, i8);
    }

    public j(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(cVar);
    }
}
