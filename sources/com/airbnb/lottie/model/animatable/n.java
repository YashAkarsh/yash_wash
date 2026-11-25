package com.airbnb.lottie.model.animatable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<com.airbnb.lottie.value.a<V>> f11937a;

    n(V v7) {
        this(Collections.singletonList(new com.airbnb.lottie.value.a(v7)));
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public List<com.airbnb.lottie.value.a<V>> b() {
        return this.f11937a;
    }

    @Override // com.airbnb.lottie.model.animatable.m
    public boolean c() {
        if (this.f11937a.isEmpty()) {
            return true;
        }
        return this.f11937a.size() == 1 && this.f11937a.get(0).h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f11937a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f11937a.toArray()));
        }
        return sb.toString();
    }

    n(List<com.airbnb.lottie.value.a<V>> list) {
        this.f11937a = list;
    }
}
