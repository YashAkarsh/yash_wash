package com.google.android.material.transition.platform;

import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.material.transition.platform.a f19000a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.android.material.transition.platform.a f19001b = new C0213b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.android.material.transition.platform.a f19002c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.android.material.transition.platform.a f19003d = new d();

    static class a implements com.google.android.material.transition.platform.a {
        a() {
        }

        @Override // com.google.android.material.transition.platform.a
        public com.google.android.material.transition.platform.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.platform.c.a(255, v.q(0, 255, f9, f10, f8));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.b$b, reason: collision with other inner class name */
    static class C0213b implements com.google.android.material.transition.platform.a {
        C0213b() {
        }

        @Override // com.google.android.material.transition.platform.a
        public com.google.android.material.transition.platform.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.platform.c.b(v.q(255, 0, f9, f10, f8), 255);
        }
    }

    static class c implements com.google.android.material.transition.platform.a {
        c() {
        }

        @Override // com.google.android.material.transition.platform.a
        public com.google.android.material.transition.platform.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.platform.c.b(v.q(255, 0, f9, f10, f8), v.q(0, 255, f9, f10, f8));
        }
    }

    static class d implements com.google.android.material.transition.platform.a {
        d() {
        }

        @Override // com.google.android.material.transition.platform.a
        public com.google.android.material.transition.platform.c a(float f8, float f9, float f10, float f11) {
            float f12 = ((f10 - f9) * f11) + f9;
            return com.google.android.material.transition.platform.c.b(v.q(255, 0, f9, f12, f8), v.q(0, 255, f12, f10, f8));
        }
    }

    private b() {
    }

    static com.google.android.material.transition.platform.a a(int i7, boolean z7) {
        if (i7 == 0) {
            return z7 ? f19000a : f19001b;
        }
        if (i7 == 1) {
            return z7 ? f19001b : f19000a;
        }
        if (i7 == 2) {
            return f19002c;
        }
        if (i7 == 3) {
            return f19003d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i7);
    }
}
