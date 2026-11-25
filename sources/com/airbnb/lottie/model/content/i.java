package com.airbnb.lottie.model.content;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.m<PointF, PointF> f12011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12017j;

    public enum a {
        STAR(1),
        POLYGON(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12021a;

        a(int i7) {
            this.f12021a = i7;
        }

        public static a a(int i7) {
            for (a aVar : values()) {
                if (aVar.f12021a == i7) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, com.airbnb.lottie.model.animatable.b bVar, com.airbnb.lottie.model.animatable.m<PointF, PointF> mVar, com.airbnb.lottie.model.animatable.b bVar2, com.airbnb.lottie.model.animatable.b bVar3, com.airbnb.lottie.model.animatable.b bVar4, com.airbnb.lottie.model.animatable.b bVar5, com.airbnb.lottie.model.animatable.b bVar6, boolean z7) {
        this.f12008a = str;
        this.f12009b = aVar;
        this.f12010c = bVar;
        this.f12011d = mVar;
        this.f12012e = bVar2;
        this.f12013f = bVar3;
        this.f12014g = bVar4;
        this.f12015h = bVar5;
        this.f12016i = bVar6;
        this.f12017j = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.o(hVar, aVar, this);
    }

    public com.airbnb.lottie.model.animatable.b b() {
        return this.f12013f;
    }

    public com.airbnb.lottie.model.animatable.b c() {
        return this.f12015h;
    }

    public String d() {
        return this.f12008a;
    }

    public com.airbnb.lottie.model.animatable.b e() {
        return this.f12014g;
    }

    public com.airbnb.lottie.model.animatable.b f() {
        return this.f12016i;
    }

    public com.airbnb.lottie.model.animatable.b g() {
        return this.f12010c;
    }

    public com.airbnb.lottie.model.animatable.m<PointF, PointF> h() {
        return this.f12011d;
    }

    public com.airbnb.lottie.model.animatable.b i() {
        return this.f12012e;
    }

    public a j() {
        return this.f12009b;
    }

    public boolean k() {
        return this.f12017j;
    }
}
