package com.airbnb.lottie.value;

import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<T> f12374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.a<?, ?> f12375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    protected T f12376c;

    public j() {
        this.f12374a = new b<>();
        this.f12376c = null;
    }

    @o0
    public T a(b<T> bVar) {
        return this.f12376c;
    }

    @o0
    @x0({x0.a.LIBRARY})
    public final T b(float f8, float f9, T t7, T t8, float f10, float f11, float f12) {
        return a(this.f12374a.h(f8, f9, t7, t8, f10, f11, f12));
    }

    @x0({x0.a.LIBRARY})
    public final void c(@o0 com.airbnb.lottie.animation.keyframe.a<?, ?> aVar) {
        this.f12375b = aVar;
    }

    public final void d(@o0 T t7) {
        this.f12376c = t7;
        com.airbnb.lottie.animation.keyframe.a<?, ?> aVar = this.f12375b;
        if (aVar != null) {
            aVar.j();
        }
    }

    public j(@o0 T t7) {
        this.f12374a = new b<>();
        this.f12376c = t7;
    }
}
