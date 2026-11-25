package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class f<T> extends j<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final T f12370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final T f12371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator f12372f;

    f(T t7, T t8) {
        this(t7, t8, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.value.j
    public T a(b<T> bVar) {
        return e(this.f12370d, this.f12371e, this.f12372f.getInterpolation(bVar.e()));
    }

    abstract T e(T t7, T t8, float f8);

    f(T t7, T t8, Interpolator interpolator) {
        this.f12370d = t7;
        this.f12371e = t8;
        this.f12372f = interpolator;
    }
}
