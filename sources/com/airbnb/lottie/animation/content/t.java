package com.airbnb.lottie.animation.content;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t implements c, com.airbnb.lottie.animation.keyframe.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.animation.keyframe.a.b> f11709c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.q.a f11710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11713g;

    public t(com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.q qVar) {
        this.f11707a = qVar.c();
        this.f11708b = qVar.g();
        this.f11710d = qVar.f();
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA = qVar.e().a();
        this.f11711e = aVarA;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA2 = qVar.b().a();
        this.f11712f = aVarA2;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA3 = qVar.d().a();
        this.f11713g = aVarA3;
        aVar.j(aVarA);
        aVar.j(aVarA2);
        aVar.j(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        for (int i7 = 0; i7 < this.f11709c.size(); i7++) {
            this.f11709c.get(i7).a();
        }
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
    }

    void c(com.airbnb.lottie.animation.keyframe.a.b bVar) {
        this.f11709c.add(bVar);
    }

    public com.airbnb.lottie.animation.keyframe.a<?, Float> e() {
        return this.f11712f;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11707a;
    }

    public com.airbnb.lottie.animation.keyframe.a<?, Float> h() {
        return this.f11713g;
    }

    public com.airbnb.lottie.animation.keyframe.a<?, Float> i() {
        return this.f11711e;
    }

    com.airbnb.lottie.model.content.q.a j() {
        return this.f11710d;
    }

    public boolean k() {
        return this.f11708b;
    }
}
