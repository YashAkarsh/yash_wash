package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f11922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11923b;

    public i(b bVar, b bVar2) {
        this.f11922a = bVar;
        this.f11923b = bVar2;
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public com.airbnb.lottie.animation.keyframe.a<PointF, PointF> a() {
        return new com.airbnb.lottie.animation.keyframe.m(this.f11922a.a(), this.f11923b.a());
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public List<com.airbnb.lottie.value.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public boolean c() {
        return this.f11922a.c() && this.f11923b.c();
    }
}
