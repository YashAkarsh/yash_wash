package com.google.android.material.transition;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.material.transition.a f18907a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.android.material.transition.a f18908b = new C0212b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.android.material.transition.a f18909c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.android.material.transition.a f18910d = new d();

    static class a implements com.google.android.material.transition.a {
        a() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.c.a(255, u.q(0, 255, f9, f10, f8));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.b$b, reason: collision with other inner class name */
    static class C0212b implements com.google.android.material.transition.a {
        C0212b() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.c.b(u.q(255, 0, f9, f10, f8), 255);
        }
    }

    static class c implements com.google.android.material.transition.a {
        c() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float f8, float f9, float f10, float f11) {
            return com.google.android.material.transition.c.b(u.q(255, 0, f9, f10, f8), u.q(0, 255, f9, f10, f8));
        }
    }

    static class d implements com.google.android.material.transition.a {
        d() {
        }

        @Override // com.google.android.material.transition.a
        public com.google.android.material.transition.c a(float f8, float f9, float f10, float f11) {
            float f12 = ((f10 - f9) * f11) + f9;
            return com.google.android.material.transition.c.b(u.q(255, 0, f9, f12, f8), u.q(0, 255, f12, f10, f8));
        }
    }

    private b() {
    }

    static com.google.android.material.transition.a a(int i7, boolean z7) {
        if (i7 == 0) {
            return z7 ? f18907a : f18908b;
        }
        if (i7 == 1) {
            return z7 ? f18908b : f18907a;
        }
        if (i7 == 2) {
            return f18909c;
        }
        if (i7 == 3) {
            return f18910d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i7);
    }
}
