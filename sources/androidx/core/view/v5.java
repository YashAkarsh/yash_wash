package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;

/* JADX INFO: loaded from: classes.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f6884a;

    @c.t0(30)
    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimationController f6885a;

        a(@c.m0 WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f6885a = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.v5.b
        void a(boolean z7) {
            this.f6885a.finish(z7);
        }

        @Override // androidx.core.view.v5.b
        public float b() {
            return this.f6885a.getCurrentAlpha();
        }

        @Override // androidx.core.view.v5.b
        public float c() {
            return this.f6885a.getCurrentFraction();
        }

        @Override // androidx.core.view.v5.b
        @c.m0
        public androidx.core.graphics.b2 d() {
            return androidx.core.graphics.b2.g(this.f6885a.getCurrentInsets());
        }

        @Override // androidx.core.view.v5.b
        @c.m0
        public androidx.core.graphics.b2 e() {
            return androidx.core.graphics.b2.g(this.f6885a.getHiddenStateInsets());
        }

        @Override // androidx.core.view.v5.b
        @c.m0
        public androidx.core.graphics.b2 f() {
            return androidx.core.graphics.b2.g(this.f6885a.getShownStateInsets());
        }

        @Override // androidx.core.view.v5.b
        @SuppressLint({"WrongConstant"})
        public int g() {
            return this.f6885a.getTypes();
        }

        @Override // androidx.core.view.v5.b
        boolean h() {
            return this.f6885a.isCancelled();
        }

        @Override // androidx.core.view.v5.b
        boolean i() {
            return this.f6885a.isFinished();
        }

        @Override // androidx.core.view.v5.b
        public boolean j() {
            return this.f6885a.isReady();
        }

        @Override // androidx.core.view.v5.b
        public void k(@c.o0 androidx.core.graphics.b2 b2Var, float f8, float f9) {
            this.f6885a.setInsetsAndAlpha(b2Var == null ? null : b2Var.h(), f8, f9);
        }
    }

    private static class b {
        b() {
        }

        void a(boolean z7) {
        }

        public float b() {
            return 0.0f;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float c() {
            return 0.0f;
        }

        @c.m0
        public androidx.core.graphics.b2 d() {
            return androidx.core.graphics.b2.f5776e;
        }

        @c.m0
        public androidx.core.graphics.b2 e() {
            return androidx.core.graphics.b2.f5776e;
        }

        @c.m0
        public androidx.core.graphics.b2 f() {
            return androidx.core.graphics.b2.f5776e;
        }

        public int g() {
            return 0;
        }

        boolean h() {
            return true;
        }

        boolean i() {
            return false;
        }

        public boolean j() {
            return false;
        }

        public void k(@c.o0 androidx.core.graphics.b2 b2Var, @c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9) {
        }
    }

    @c.t0(30)
    v5(@c.m0 WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f6884a = new a(windowInsetsAnimationController);
    }

    public void a(boolean z7) {
        this.f6884a.a(z7);
    }

    public float b() {
        return this.f6884a.b();
    }

    @c.v(from = 0.0d, to = 1.0d)
    public float c() {
        return this.f6884a.c();
    }

    @c.m0
    public androidx.core.graphics.b2 d() {
        return this.f6884a.d();
    }

    @c.m0
    public androidx.core.graphics.b2 e() {
        return this.f6884a.e();
    }

    @c.m0
    public androidx.core.graphics.b2 f() {
        return this.f6884a.f();
    }

    public int g() {
        return this.f6884a.g();
    }

    public boolean h() {
        return this.f6884a.h();
    }

    public boolean i() {
        return this.f6884a.i();
    }

    public boolean j() {
        return (i() || h()) ? false : true;
    }

    public void k(@c.o0 androidx.core.graphics.b2 b2Var, @c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9) {
        this.f6884a.k(b2Var, f8, f9);
    }
}
