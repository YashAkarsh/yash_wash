package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<com.airbnb.lottie.model.content.l, Path>> f11729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a<Integer, Integer>> f11730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.content.g> f11731c;

    public g(List<com.airbnb.lottie.model.content.g> list) {
        this.f11731c = list;
        this.f11729a = new ArrayList(list.size());
        this.f11730b = new ArrayList(list.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            this.f11729a.add(list.get(i7).b().a());
            this.f11730b.add(list.get(i7).c().a());
        }
    }

    public List<a<com.airbnb.lottie.model.content.l, Path>> a() {
        return this.f11729a;
    }

    public List<com.airbnb.lottie.model.content.g> b() {
        return this.f11731c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f11730b;
    }
}
