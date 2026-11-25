package com.airbnb.lottie.animation.keyframe;

import c.o0;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.value.b<A> f11759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final A f11760j;

    public p(com.airbnb.lottie.value.j<A> jVar) {
        this(jVar, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    public A h() {
        com.airbnb.lottie.value.j<A> jVar = this.f11718e;
        A a8 = this.f11760j;
        return jVar.b(0.0f, 0.0f, a8, a8, f(), f(), f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    A i(com.airbnb.lottie.value.a<K> aVar, float f8) {
        return h();
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    public void j() {
        if (this.f11718e != null) {
            super.j();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    public void l(float f8) {
        this.f11717d = f8;
    }

    public p(com.airbnb.lottie.value.j<A> jVar, @o0 A a8) {
        super(Collections.emptyList());
        this.f11759i = new com.airbnb.lottie.value.b<>();
        m(jVar);
        this.f11760j = a8;
    }
}
