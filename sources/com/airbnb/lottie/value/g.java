package com.airbnb.lottie.value;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class g extends j<Float> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float e(b<Float> bVar) {
        T t7 = this.f12376c;
        if (t7 != 0) {
            return (Float) t7;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.airbnb.lottie.value.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float a(b<Float> bVar) {
        return Float.valueOf(com.airbnb.lottie.utils.i.j(bVar.g().floatValue(), bVar.b().floatValue(), bVar.c()) + e(bVar).floatValue());
    }

    public g(@m0 Float f8) {
        super(f8);
    }
}
