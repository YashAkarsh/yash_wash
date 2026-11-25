package com.airbnb.lottie.animation.keyframe;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends f<com.airbnb.lottie.model.content.c> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.c f11728i;

    public d(List<com.airbnb.lottie.value.a<com.airbnb.lottie.model.content.c>> list) {
        super(list);
        com.airbnb.lottie.model.content.c cVar = list.get(0).f12349b;
        int iC = cVar != null ? cVar.c() : 0;
        this.f11728i = new com.airbnb.lottie.model.content.c(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.content.c i(com.airbnb.lottie.value.a<com.airbnb.lottie.model.content.c> aVar, float f8) {
        this.f11728i.d(aVar.f12349b, aVar.f12350c, f8);
        return this.f11728i;
    }
}
