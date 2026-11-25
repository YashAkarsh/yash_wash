package com.airbnb.lottie.model.content;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f12042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12043c;

    public n(String str, List<b> list, boolean z7) {
        this.f12041a = str;
        this.f12042b = list;
        this.f12043c = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.d(hVar, aVar, this);
    }

    public List<b> b() {
        return this.f12042b;
    }

    public String c() {
        return this.f12041a;
    }

    public boolean d() {
        return this.f12043c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f12041a + "' Shapes: " + Arrays.toString(this.f12042b.toArray()) + '}';
    }
}
