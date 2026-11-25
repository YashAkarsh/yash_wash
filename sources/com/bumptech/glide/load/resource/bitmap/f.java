package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class f extends e {
    public f(Context context) {
        super(context);
    }

    @Override // w0.g
    public String a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.e
    protected Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i7, int i8) {
        Bitmap bitmapD = cVar.d(i7, i8, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap bitmapA = s.a(bitmapD, bitmap, i7, i8);
        if (bitmapD != null && bitmapD != bitmapA && !cVar.b(bitmapD)) {
            bitmapD.recycle();
        }
        return bitmapA;
    }

    public f(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(cVar);
    }
}
