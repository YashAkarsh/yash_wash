package com.airbnb.lottie.value;

import android.graphics.PointF;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class i extends j<PointF> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f12373d;

    public i() {
        this.f12373d = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF e(b<PointF> bVar) {
        T t7 = this.f12376c;
        if (t7 != 0) {
            return (PointF) t7;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.airbnb.lottie.value.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final PointF a(b<PointF> bVar) {
        this.f12373d.set(com.airbnb.lottie.utils.i.j(bVar.g().x, bVar.b().x, bVar.c()), com.airbnb.lottie.utils.i.j(bVar.g().y, bVar.b().y, bVar.c()));
        PointF pointFE = e(bVar);
        this.f12373d.offset(pointFE.x, pointFE.y);
        return this.f12373d;
    }

    public i(@m0 PointF pointF) {
        super(pointF);
        this.f12373d = new PointF();
    }
}
