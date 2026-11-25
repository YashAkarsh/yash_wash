package com.airbnb.lottie.model.content;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.m<PointF, PointF> f11958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f11959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11961e;

    public a(String str, com.airbnb.lottie.model.animatable.m<PointF, PointF> mVar, com.airbnb.lottie.model.animatable.f fVar, boolean z7, boolean z8) {
        this.f11957a = str;
        this.f11958b = mVar;
        this.f11959c = fVar;
        this.f11960d = z7;
        this.f11961e = z8;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.f(hVar, aVar, this);
    }

    public String b() {
        return this.f11957a;
    }

    public com.airbnb.lottie.model.animatable.m<PointF, PointF> c() {
        return this.f11958b;
    }

    public com.airbnb.lottie.model.animatable.f d() {
        return this.f11959c;
    }

    public boolean e() {
        return this.f11961e;
    }

    public boolean f() {
        return this.f11960d;
    }
}
