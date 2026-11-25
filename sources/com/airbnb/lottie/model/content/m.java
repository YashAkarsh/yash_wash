package com.airbnb.lottie.model.content;

import android.graphics.Path;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path.FillType f12036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.a f12038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.d f12039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12040f;

    public m(String str, boolean z7, Path.FillType fillType, @o0 com.airbnb.lottie.model.animatable.a aVar, @o0 com.airbnb.lottie.model.animatable.d dVar, boolean z8) {
        this.f12037c = str;
        this.f12035a = z7;
        this.f12036b = fillType;
        this.f12038d = aVar;
        this.f12039e = dVar;
        this.f12040f = z8;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.g(hVar, aVar, this);
    }

    @o0
    public com.airbnb.lottie.model.animatable.a b() {
        return this.f12038d;
    }

    public Path.FillType c() {
        return this.f12036b;
    }

    public String d() {
        return this.f12037c;
    }

    @o0
    public com.airbnb.lottie.model.animatable.d e() {
        return this.f12039e;
    }

    public boolean f() {
        return this.f12040f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f12035a + '}';
    }
}
