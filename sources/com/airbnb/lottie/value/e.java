package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class e extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PointF f12369g;

    public e(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f12369g = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public PointF e(PointF pointF, PointF pointF2, float f8) {
        this.f12369g.set(com.airbnb.lottie.utils.i.j(pointF.x, pointF2.x, f8), com.airbnb.lottie.utils.i.j(pointF.y, pointF2.y, f8));
        return this.f12369g;
    }

    public e(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f12369g = new PointF();
    }
}
