package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.nostra13.universalimageloader.core.display.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f32765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f32766b;

    protected static class a extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final float f32767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f32768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final RectF f32769c = new RectF();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final BitmapShader f32770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final Paint f32771e;

        a(Bitmap bitmap, int i7, int i8) {
            this.f32767a = i7;
            this.f32768b = i8;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f32770d = bitmapShader;
            Paint paint = new Paint();
            this.f32771e = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.f32769c;
            float f8 = this.f32767a;
            canvas.drawRoundRect(rectF, f8, f8, this.f32771e);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.f32769c;
            int i7 = this.f32768b;
            rectF.set(i7, i7, rect.width() - this.f32768b, rect.height() - this.f32768b);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i7) {
            this.f32771e.setAlpha(i7);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f32771e.setColorFilter(colorFilter);
        }
    }

    public c(int i7) {
        this(i7, 0);
    }

    @Override // com.nostra13.universalimageloader.core.display.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.imageaware.a aVar, f fVar) {
        if (!(aVar instanceof com.nostra13.universalimageloader.core.imageaware.c)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.c(new a(bitmap, this.f32765a, this.f32766b));
    }

    public c(int i7, int i8) {
        this.f32765a = i7;
        this.f32766b = i8;
    }
}
