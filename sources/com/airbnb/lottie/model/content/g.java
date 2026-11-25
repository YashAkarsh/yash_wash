package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.h f11991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.d f11992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11993d;

    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, com.airbnb.lottie.model.animatable.h hVar, com.airbnb.lottie.model.animatable.d dVar, boolean z7) {
        this.f11990a = aVar;
        this.f11991b = hVar;
        this.f11992c = dVar;
        this.f11993d = z7;
    }

    public a a() {
        return this.f11990a;
    }

    public com.airbnb.lottie.model.animatable.h b() {
        return this.f11991b;
    }

    public com.airbnb.lottie.model.animatable.d c() {
        return this.f11992c;
    }

    public boolean d() {
        return this.f11993d;
    }
}
