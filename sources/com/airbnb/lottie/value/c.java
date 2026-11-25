package com.airbnb.lottie.value;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class c extends f<Float> {
    public c(Float f8, Float f9) {
        super(f8, f9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float e(Float f8, Float f9, float f10) {
        return Float.valueOf(com.airbnb.lottie.utils.i.j(f8.floatValue(), f9.floatValue(), f10));
    }

    public c(Float f8, Float f9, Interpolator interpolator) {
        super(f8, f9, interpolator);
    }
}
