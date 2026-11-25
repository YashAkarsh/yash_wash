package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements w0.g<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.load.engine.bitmap_recycle.c f14529a;

    public e(Context context) {
        this(com.bumptech.glide.l.o(context).r());
    }

    @Override // w0.g
    public final com.bumptech.glide.load.engine.m<Bitmap> b(com.bumptech.glide.load.engine.m<Bitmap> mVar, int i7, int i8) {
        if (com.bumptech.glide.util.i.m(i7, i8)) {
            Bitmap bitmap = mVar.get();
            if (i7 == Integer.MIN_VALUE) {
                i7 = bitmap.getWidth();
            }
            if (i8 == Integer.MIN_VALUE) {
                i8 = bitmap.getHeight();
            }
            Bitmap bitmapC = c(this.f14529a, bitmap, i7, i8);
            return bitmap.equals(bitmapC) ? mVar : d.d(bitmapC, this.f14529a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i7 + " or height: " + i8 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i7, int i8);

    public e(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.f14529a = cVar;
    }
}
