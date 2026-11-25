package com.airbnb.lottie.model.content;

import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.l f12030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f12031e;

    public k(String str, com.airbnb.lottie.model.animatable.b bVar, com.airbnb.lottie.model.animatable.b bVar2, com.airbnb.lottie.model.animatable.l lVar, boolean z7) {
        this.f12027a = str;
        this.f12028b = bVar;
        this.f12029c = bVar2;
        this.f12030d = lVar;
        this.f12031e = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    @o0
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.q(hVar, aVar, this);
    }

    public com.airbnb.lottie.model.animatable.b b() {
        return this.f12028b;
    }

    public String c() {
        return this.f12027a;
    }

    public com.airbnb.lottie.model.animatable.b d() {
        return this.f12029c;
    }

    public com.airbnb.lottie.model.animatable.l e() {
        return this.f12030d;
    }

    public boolean f() {
        return this.f12031e;
    }
}
