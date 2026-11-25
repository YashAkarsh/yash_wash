package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import c.m0;
import com.airbnb.lottie.model.content.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    private final com.airbnb.lottie.animation.content.d B;

    f(com.airbnb.lottie.h hVar, d dVar) {
        super(hVar, dVar);
        com.airbnb.lottie.animation.content.d dVar2 = new com.airbnb.lottie.animation.content.d(hVar, this, new n("__container", dVar.l(), false));
        this.B = dVar2;
        dVar2.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void E(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        this.B.c(eVar, i7, list, eVar2);
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        this.B.d(rectF, this.f12108m, z7);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(@m0 Canvas canvas, Matrix matrix, int i7) {
        this.B.f(canvas, matrix, i7);
    }
}
