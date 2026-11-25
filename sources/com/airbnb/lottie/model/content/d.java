package com.airbnb.lottie.model.content;

import android.graphics.Path;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f11964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path.FillType f11965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.c f11966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.d f11967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f11968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.f f11969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.b f11971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.b f11972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f11973j;

    public d(String str, f fVar, Path.FillType fillType, com.airbnb.lottie.model.animatable.c cVar, com.airbnb.lottie.model.animatable.d dVar, com.airbnb.lottie.model.animatable.f fVar2, com.airbnb.lottie.model.animatable.f fVar3, com.airbnb.lottie.model.animatable.b bVar, com.airbnb.lottie.model.animatable.b bVar2, boolean z7) {
        this.f11964a = fVar;
        this.f11965b = fillType;
        this.f11966c = cVar;
        this.f11967d = dVar;
        this.f11968e = fVar2;
        this.f11969f = fVar3;
        this.f11970g = str;
        this.f11971h = bVar;
        this.f11972i = bVar2;
        this.f11973j = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.h(hVar, aVar, this);
    }

    public com.airbnb.lottie.model.animatable.f b() {
        return this.f11969f;
    }

    public Path.FillType c() {
        return this.f11965b;
    }

    public com.airbnb.lottie.model.animatable.c d() {
        return this.f11966c;
    }

    public f e() {
        return this.f11964a;
    }

    @o0
    com.airbnb.lottie.model.animatable.b f() {
        return this.f11972i;
    }

    @o0
    com.airbnb.lottie.model.animatable.b g() {
        return this.f11971h;
    }

    public String h() {
        return this.f11970g;
    }

    public com.airbnb.lottie.model.animatable.d i() {
        return this.f11967d;
    }

    public com.airbnb.lottie.model.animatable.f j() {
        return this.f11968e;
    }

    public boolean k() {
        return this.f11973j;
    }
}
