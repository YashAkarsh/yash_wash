package com.airbnb.lottie.model.content;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.m<PointF, PointF> f12023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f12024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f12026e;

    public j(String str, com.airbnb.lottie.model.animatable.m<PointF, PointF> mVar, com.airbnb.lottie.model.animatable.f fVar, com.airbnb.lottie.model.animatable.b bVar, boolean z7) {
        this.f12022a = str;
        this.f12023b = mVar;
        this.f12024c = fVar;
        this.f12025d = bVar;
        this.f12026e = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.p(hVar, aVar, this);
    }

    public com.airbnb.lottie.model.animatable.b b() {
        return this.f12025d;
    }

    public String c() {
        return this.f12022a;
    }

    public com.airbnb.lottie.model.animatable.m<PointF, PointF> d() {
        return this.f12023b;
    }

    public com.airbnb.lottie.model.animatable.f e() {
        return this.f12024c;
    }

    public boolean f() {
        return this.f12026e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f12023b + ", size=" + this.f12024c + '}';
    }
}
