package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f11742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a<Float, Float> f11743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a<Float, Float> f11744k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f11742i = new PointF();
        this.f11743j = aVar;
        this.f11744k = aVar2;
        l(f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    public void l(float f8) {
        this.f11743j.l(f8);
        this.f11744k.l(f8);
        this.f11742i.set(this.f11743j.h().floatValue(), this.f11744k.h().floatValue());
        for (int i7 = 0; i7 < this.f11714a.size(); i7++) {
            this.f11714a.get(i7).a();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(com.airbnb.lottie.value.a<PointF> aVar, float f8) {
        return this.f11742i;
    }
}
