package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r implements n, com.airbnb.lottie.animation.keyframe.a.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.h f11698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Path> f11699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11700f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11695a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f11701g = new b();

    public r(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.o oVar) {
        this.f11696b = oVar.b();
        this.f11697c = oVar.d();
        this.f11698d = hVar;
        com.airbnb.lottie.animation.keyframe.a<com.airbnb.lottie.model.content.l, Path> aVarA = oVar.c().a();
        this.f11699e = aVarA;
        aVar.j(aVarA);
        aVarA.a(this);
    }

    private void c() {
        this.f11700f = false;
        this.f11698d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        c();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            c cVar = list.get(i7);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.j() == com.airbnb.lottie.model.content.q.a.SIMULTANEOUSLY) {
                    this.f11701g.a(tVar);
                    tVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        if (this.f11700f) {
            return this.f11695a;
        }
        this.f11695a.reset();
        if (this.f11697c) {
            this.f11700f = true;
            return this.f11695a;
        }
        this.f11695a.set(this.f11699e.h());
        this.f11695a.setFillType(Path.FillType.EVEN_ODD);
        this.f11701g.b(this.f11695a);
        this.f11700f = true;
        return this.f11695a;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11696b;
    }
}
