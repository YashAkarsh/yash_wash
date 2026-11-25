package com.haier.globalwasher.modle.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.bumptech.glide.load.resource.bitmap.e {
    public l(Context context) {
        super(context);
    }

    private static Bitmap d(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        Bitmap bitmapD = cVar.d(iMin, iMin, Bitmap.Config.ARGB_8888);
        if (bitmapD == null) {
            bitmapD = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapD);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f8 = iMin / 2.0f;
        canvas.drawCircle(f8, f8, f8, paint);
        return bitmapD;
    }

    @Override // w0.g
    public String a() {
        return getClass().getName();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.e
    protected Bitmap c(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i7, int i8) {
        return d(cVar, bitmap);
    }
}
