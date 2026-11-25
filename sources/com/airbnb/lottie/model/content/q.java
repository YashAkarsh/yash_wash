package com.airbnb.lottie.model.content;

import com.airbnb.lottie.animation.content.t;

/* JADX INFO: loaded from: classes.dex */
public class q implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f12073f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i7) {
            if (i7 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i7 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i7);
        }
    }

    public q(String str, a aVar, com.airbnb.lottie.model.animatable.b bVar, com.airbnb.lottie.model.animatable.b bVar2, com.airbnb.lottie.model.animatable.b bVar3, boolean z7) {
        this.f12068a = str;
        this.f12069b = aVar;
        this.f12070c = bVar;
        this.f12071d = bVar2;
        this.f12072e = bVar3;
        this.f12073f = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new t(aVar, this);
    }

    public com.airbnb.lottie.model.animatable.b b() {
        return this.f12071d;
    }

    public String c() {
        return this.f12068a;
    }

    public com.airbnb.lottie.model.animatable.b d() {
        return this.f12072e;
    }

    public com.airbnb.lottie.model.animatable.b e() {
        return this.f12070c;
    }

    public a f() {
        return this.f12069b;
    }

    public boolean g() {
        return this.f12073f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f12070c + ", end: " + this.f12071d + ", offset: " + this.f12072e + com.alipay.sdk.util.j.f13808d;
    }
}
