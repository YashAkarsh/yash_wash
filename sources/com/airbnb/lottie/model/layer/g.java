package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c.o0;
import com.airbnb.lottie.animation.keyframe.p;
import com.airbnb.lottie.m;
import com.airbnb.lottie.value.j;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    private final RectF B;
    private final Paint C;
    private final float[] D;
    private final Path E;
    private final d F;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> G;

    g(com.airbnb.lottie.h hVar, d dVar) {
        super(hVar, dVar);
        this.B = new RectF();
        com.airbnb.lottie.animation.a aVar = new com.airbnb.lottie.animation.a();
        this.C = aVar;
        this.D = new float[8];
        this.E = new Path();
        this.F = dVar;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(dVar.m());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        this.B.set(0.0f, 0.0f, this.F.o(), this.F.n());
        this.f12108m.mapRect(this.B);
        rectF.set(this.B);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == m.C) {
            if (jVar == null) {
                this.G = null;
            } else {
                this.G = new p(jVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void u(Canvas canvas, Matrix matrix, int i7) {
        int iAlpha = Color.alpha(this.F.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i7 / 255.0f) * (((iAlpha / 255.0f) * (this.f12117v.h() == null ? 100 : this.f12117v.h().h().intValue())) / 100.0f) * 255.0f);
        this.C.setAlpha(iIntValue);
        com.airbnb.lottie.animation.keyframe.a<ColorFilter, ColorFilter> aVar = this.G;
        if (aVar != null) {
            this.C.setColorFilter(aVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.D;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.F.o();
            float[] fArr2 = this.D;
            fArr2[3] = 0.0f;
            fArr2[4] = this.F.o();
            this.D[5] = this.F.n();
            float[] fArr3 = this.D;
            fArr3[6] = 0.0f;
            fArr3[7] = this.F.n();
            matrix.mapPoints(this.D);
            this.E.reset();
            Path path = this.E;
            float[] fArr4 = this.D;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.E;
            float[] fArr5 = this.D;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.E;
            float[] fArr6 = this.D;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.E;
            float[] fArr7 = this.D;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.E;
            float[] fArr8 = this.D;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.E.close();
            canvas.drawPath(this.E, this.C);
        }
    }
}
