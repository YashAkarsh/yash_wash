package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.value.a<PointF>> f11921a;

    public e() {
        this.f11921a = Collections.singletonList(new com.airbnb.lottie.value.a(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public com.airbnb.lottie.animation.keyframe.a<PointF, PointF> a() {
        return this.f11921a.get(0).h() ? new com.airbnb.lottie.animation.keyframe.j(this.f11921a) : new com.airbnb.lottie.animation.keyframe.i(this.f11921a);
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public List<com.airbnb.lottie.value.a<PointF>> b() {
        return this.f11921a;
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public boolean c() {
        return this.f11921a.size() == 1 && this.f11921a.get(0).h();
    }

    public e(List<com.airbnb.lottie.value.a<PointF>> list) {
        this.f11921a = list;
    }
}
