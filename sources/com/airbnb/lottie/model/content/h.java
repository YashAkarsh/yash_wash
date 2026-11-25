package com.airbnb.lottie.model.content;

import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f12000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12001c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i7) {
            if (i7 == 1) {
                return MERGE;
            }
            if (i7 == 2) {
                return ADD;
            }
            if (i7 == 3) {
                return SUBTRACT;
            }
            if (i7 != 4) {
                return i7 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public h(String str, a aVar, boolean z7) {
        this.f11999a = str;
        this.f12000b = aVar;
        this.f12001c = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    @o0
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        if (hVar.r()) {
            return new com.airbnb.lottie.animation.content.l(this);
        }
        com.airbnb.lottie.utils.f.e("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f12000b;
    }

    public String c() {
        return this.f11999a;
    }

    public boolean d() {
        return this.f12001c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f12000b + '}';
    }
}
