package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    e(com.airbnb.lottie.h hVar, d dVar) {
        super(hVar, dVar);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i7) {
    }
}
