package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.airbnb.lottie.value.a<PointF> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private Path f11732q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.airbnb.lottie.value.a<PointF> f11733r;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.value.a<PointF> aVar) {
        super(fVar, aVar.f12349b, aVar.f12350c, aVar.f12351d, aVar.f12352e, aVar.f12353f);
        this.f11733r = aVar;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t7;
        T t8 = this.f12350c;
        boolean z7 = (t8 == 0 || (t7 = this.f12349b) == 0 || !((PointF) t7).equals(((PointF) t8).x, ((PointF) t8).y)) ? false : true;
        T t9 = this.f12350c;
        if (t9 == 0 || z7) {
            return;
        }
        com.airbnb.lottie.value.a<PointF> aVar = this.f11733r;
        this.f11732q = com.airbnb.lottie.utils.j.d((PointF) this.f12349b, (PointF) t9, aVar.f12360m, aVar.f12361n);
    }

    @o0
    Path j() {
        return this.f11732q;
    }
}
