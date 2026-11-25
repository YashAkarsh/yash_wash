package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c.m0;
import c.o0;
import com.airbnb.lottie.animation.keyframe.p;
import com.airbnb.lottie.m;
import com.airbnb.lottie.utils.j;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private final Paint B;
    private final Rect C;
    private final Rect D;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> E;

    c(com.airbnb.lottie.h hVar, d dVar) {
        super(hVar, dVar);
        this.B = new com.airbnb.lottie.animation.a(3);
        this.C = new Rect();
        this.D = new Rect();
    }

    @o0
    private Bitmap K() {
        return this.f12109n.x(this.f12110o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        Bitmap bitmapK = K();
        if (bitmapK != null) {
            rectF.set(0.0f, 0.0f, bitmapK.getWidth() * j.e(), bitmapK.getHeight() * j.e());
            this.f12108m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == m.C) {
            if (jVar == null) {
                this.E = null;
            } else {
                this.E = new p(jVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void u(@m0 Canvas canvas, Matrix matrix, int i7) {
        Bitmap bitmapK = K();
        if (bitmapK == null || bitmapK.isRecycled()) {
            return;
        }
        float fE = j.e();
        this.B.setAlpha(i7);
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.E;
        if (aVar != null) {
            this.B.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.C.set(0, 0, bitmapK.getWidth(), bitmapK.getHeight());
        this.D.set(0, 0, (int) (bitmapK.getWidth() * fE), (int) (bitmapK.getHeight() * fE));
        canvas.drawBitmap(bitmapK, this.C, this.D, this.B);
        canvas.restore();
    }
}
