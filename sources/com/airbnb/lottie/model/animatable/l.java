package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class l implements com.airbnb.lottie.animation.content.m, com.airbnb.lottie.model.content.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final e f11928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final m<PointF, PointF> f11929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final g f11930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private final b f11931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private final d f11932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private final b f11933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private final b f11934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private final b f11935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private final b f11936i;

    public l() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.b
    @o0
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public com.airbnb.lottie.animation.keyframe.o b() {
        return new com.airbnb.lottie.animation.keyframe.o(this);
    }

    @o0
    public e c() {
        return this.f11928a;
    }

    @o0
    public b d() {
        return this.f11936i;
    }

    @o0
    public d e() {
        return this.f11932e;
    }

    @o0
    public m<PointF, PointF> f() {
        return this.f11929b;
    }

    @o0
    public b g() {
        return this.f11931d;
    }

    @o0
    public g h() {
        return this.f11930c;
    }

    @o0
    public b i() {
        return this.f11933f;
    }

    @o0
    public b j() {
        return this.f11934g;
    }

    @o0
    public b k() {
        return this.f11935h;
    }

    public l(@o0 e eVar, @o0 m<PointF, PointF> mVar, @o0 g gVar, @o0 b bVar, @o0 d dVar, @o0 b bVar2, @o0 b bVar3, @o0 b bVar4, @o0 b bVar5) {
        this.f11928a = eVar;
        this.f11929b = mVar;
        this.f11930c = gVar;
        this.f11931d = bVar;
        this.f11932e = dVar;
        this.f11935h = bVar2;
        this.f11936i = bVar3;
        this.f11933f = bVar4;
        this.f11934g = bVar5;
    }
}
