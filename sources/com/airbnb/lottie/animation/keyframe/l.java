package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.model.content.l, Path> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.l f11740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f11741j;

    public l(List<com.airbnb.lottie.value.a<com.airbnb.lottie.model.content.l>> list) {
        super(list);
        this.f11740i = new com.airbnb.lottie.model.content.l();
        this.f11741j = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Path i(com.airbnb.lottie.value.a<com.airbnb.lottie.model.content.l> aVar, float f8) {
        this.f11740i.c(aVar.f12349b, aVar.f12350c, f8);
        com.airbnb.lottie.utils.i.h(this.f11740i, this.f11741j);
        return this.f11741j;
    }
}
