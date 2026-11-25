package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.h f12046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f12047d;

    public o(String str, int i7, com.airbnb.lottie.model.animatable.h hVar, boolean z7) {
        this.f12044a = str;
        this.f12045b = i7;
        this.f12046c = hVar;
        this.f12047d = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.r(hVar, aVar, this);
    }

    public String b() {
        return this.f12044a;
    }

    public com.airbnb.lottie.model.animatable.h c() {
        return this.f12046c;
    }

    public boolean d() {
        return this.f12047d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f12044a + ", index=" + this.f12045b + '}';
    }
}
