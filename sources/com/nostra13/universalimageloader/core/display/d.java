package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.nostra13.universalimageloader.core.assist.f;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    protected static class a extends c.a {
        a(Bitmap bitmap, int i7, int i8) {
            super(bitmap, i7, i8);
        }

        @Override // com.nostra13.universalimageloader.core.display.c.a, android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.f32769c.centerX(), (this.f32769c.centerY() * 1.0f) / 0.7f, 1.3f * this.f32769c.centerX(), new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.f32771e.setShader(new ComposeShader(this.f32770d, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public d(int i7, int i8) {
        super(i7, i8);
    }

    @Override // com.nostra13.universalimageloader.core.display.c, com.nostra13.universalimageloader.core.display.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.imageaware.a aVar, f fVar) {
        if (!(aVar instanceof com.nostra13.universalimageloader.core.imageaware.c)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.c(new a(bitmap, this.f32765a, this.f32766b));
    }
}
