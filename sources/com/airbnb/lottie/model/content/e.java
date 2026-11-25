package com.airbnb.lottie.model.content;

import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f11975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.c f11976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.d f11977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f11978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f11979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f11980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final p.b f11981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final p.c f11982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f11983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.animatable.b> f11984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.b f11985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f11986m;

    public e(String str, f fVar, com.airbnb.lottie.model.animatable.c cVar, com.airbnb.lottie.model.animatable.d dVar, com.airbnb.lottie.model.animatable.f fVar2, com.airbnb.lottie.model.animatable.f fVar3, com.airbnb.lottie.model.animatable.b bVar, p.b bVar2, p.c cVar2, float f8, List<com.airbnb.lottie.model.animatable.b> list, @o0 com.airbnb.lottie.model.animatable.b bVar3, boolean z7) {
        this.f11974a = str;
        this.f11975b = fVar;
        this.f11976c = cVar;
        this.f11977d = dVar;
        this.f11978e = fVar2;
        this.f11979f = fVar3;
        this.f11980g = bVar;
        this.f11981h = bVar2;
        this.f11982i = cVar2;
        this.f11983j = f8;
        this.f11984k = list;
        this.f11985l = bVar3;
        this.f11986m = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.i(hVar, aVar, this);
    }

    public p.b b() {
        return this.f11981h;
    }

    @o0
    public com.airbnb.lottie.model.animatable.b c() {
        return this.f11985l;
    }

    public com.airbnb.lottie.model.animatable.f d() {
        return this.f11979f;
    }

    public com.airbnb.lottie.model.animatable.c e() {
        return this.f11976c;
    }

    public f f() {
        return this.f11975b;
    }

    public p.c g() {
        return this.f11982i;
    }

    public List<com.airbnb.lottie.model.animatable.b> h() {
        return this.f11984k;
    }

    public float i() {
        return this.f11983j;
    }

    public String j() {
        return this.f11974a;
    }

    public com.airbnb.lottie.model.animatable.d k() {
        return this.f11977d;
    }

    public com.airbnb.lottie.model.animatable.f l() {
        return this.f11978e;
    }

    public com.airbnb.lottie.model.animatable.b m() {
        return this.f11980g;
    }

    public boolean n() {
        return this.f11986m;
    }
}
