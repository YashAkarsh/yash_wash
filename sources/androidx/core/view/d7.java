package androidx.core.view;

import android.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public final class d7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6551b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6552c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6553d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f6554a;

    /* JADX INFO: Access modifiers changed from: private */
    @c.t0(20)
    static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        protected final Window f6555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.m0
        private final View f6556b;

        a(@c.m0 Window window, @c.m0 View view) {
            this.f6555a = window;
            this.f6556b = view;
        }

        private void m(int i7) {
            if (i7 == 1) {
                o(4);
            } else if (i7 == 2) {
                o(2);
            } else {
                if (i7 != 8) {
                    return;
                }
                ((InputMethodManager) this.f6555a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f6555a.getDecorView().getWindowToken(), 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void n(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        private void q(int i7) {
            if (i7 == 1) {
                r(4);
                s(1024);
                return;
            }
            if (i7 == 2) {
                r(2);
                return;
            }
            if (i7 != 8) {
                return;
            }
            final View viewFindViewById = this.f6556b;
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = this.f6555a.getCurrentFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f6555a.findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.c7
                @Override // java.lang.Runnable
                public final void run() {
                    d7.a.n(viewFindViewById);
                }
            });
        }

        @Override // androidx.core.view.d7.e
        void a(f fVar) {
        }

        @Override // androidx.core.view.d7.e
        void b(int i7, long j7, Interpolator interpolator, CancellationSignal cancellationSignal, j5 j5Var) {
        }

        @Override // androidx.core.view.d7.e
        int c() {
            return 0;
        }

        @Override // androidx.core.view.d7.e
        void d(int i7) {
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    m(i8);
                }
            }
        }

        @Override // androidx.core.view.d7.e
        void g(@c.m0 f fVar) {
        }

        @Override // androidx.core.view.d7.e
        void j(int i7) {
            if (i7 == 0) {
                r(6144);
                return;
            }
            if (i7 == 1) {
                r(4096);
                o(2048);
            } else {
                if (i7 != 2) {
                    return;
                }
                r(2048);
                o(4096);
            }
        }

        @Override // androidx.core.view.d7.e
        void k(int i7) {
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    q(i8);
                }
            }
        }

        protected void o(int i7) {
            View decorView = this.f6555a.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        protected void p(int i7) {
            this.f6555a.addFlags(i7);
        }

        protected void r(int i7) {
            View decorView = this.f6555a.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        protected void s(int i7) {
            this.f6555a.clearFlags(i7);
        }
    }

    @c.t0(23)
    private static class b extends a {
        b(@c.m0 Window window, @c.o0 View view) {
            super(window, view);
        }

        @Override // androidx.core.view.d7.e
        public boolean f() {
            return (this.f6555a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.d7.e
        public void i(boolean z7) {
            if (!z7) {
                r(8192);
                return;
            }
            s(67108864);
            p(Integer.MIN_VALUE);
            o(8192);
        }
    }

    @c.t0(26)
    private static class c extends b {
        c(@c.m0 Window window, @c.o0 View view) {
            super(window, view);
        }

        @Override // androidx.core.view.d7.e
        public boolean e() {
            return (this.f6555a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.d7.e
        public void h(boolean z7) {
            if (!z7) {
                r(16);
                return;
            }
            s(134217728);
            p(Integer.MIN_VALUE);
            o(16);
        }
    }

    private static class e {
        e() {
        }

        void a(f fVar) {
        }

        void b(int i7, long j7, Interpolator interpolator, CancellationSignal cancellationSignal, j5 j5Var) {
        }

        int c() {
            return 0;
        }

        void d(int i7) {
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        void g(@c.m0 f fVar) {
        }

        public void h(boolean z7) {
        }

        public void i(boolean z7) {
        }

        void j(int i7) {
        }

        void k(int i7) {
        }
    }

    public interface f {
        void a(@c.m0 d7 d7Var, int i7);
    }

    @c.t0(30)
    @Deprecated
    private d7(@c.m0 WindowInsetsController windowInsetsController) {
        this.f6554a = new d(windowInsetsController, this);
    }

    @c.t0(30)
    @c.m0
    @Deprecated
    public static d7 l(@c.m0 WindowInsetsController windowInsetsController) {
        return new d7(windowInsetsController);
    }

    public void a(@c.m0 f fVar) {
        this.f6554a.a(fVar);
    }

    public void b(int i7, long j7, @c.o0 Interpolator interpolator, @c.o0 CancellationSignal cancellationSignal, @c.m0 j5 j5Var) {
        this.f6554a.b(i7, j7, interpolator, cancellationSignal, j5Var);
    }

    @SuppressLint({"WrongConstant"})
    public int c() {
        return this.f6554a.c();
    }

    public void d(int i7) {
        this.f6554a.d(i7);
    }

    public boolean e() {
        return this.f6554a.e();
    }

    public boolean f() {
        return this.f6554a.f();
    }

    public void g(@c.m0 f fVar) {
        this.f6554a.g(fVar);
    }

    public void h(boolean z7) {
        this.f6554a.h(z7);
    }

    public void i(boolean z7) {
        this.f6554a.i(z7);
    }

    public void j(int i7) {
        this.f6554a.j(i7);
    }

    public void k(int i7) {
        this.f6554a.k(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @c.t0(30)
    static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d7 f6557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsetsController f6558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.collection.i<f, WindowInsetsController.OnControllableInsetsChangedListener> f6559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected Window f6560d;

        class a implements WindowInsetsAnimationControlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private v5 f6561a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ j5 f6562b;

            a(j5 j5Var) {
                this.f6562b = j5Var;
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onCancelled(@c.o0 WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f6562b.a(windowInsetsAnimationController == null ? null : this.f6561a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onFinished(@c.m0 WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f6562b.c(this.f6561a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onReady(@c.m0 WindowInsetsAnimationController windowInsetsAnimationController, int i7) {
                v5 v5Var = new v5(windowInsetsAnimationController);
                this.f6561a = v5Var;
                this.f6562b.b(v5Var, i7);
            }
        }

        d(@c.m0 Window window, @c.m0 d7 d7Var) {
            this(window.getInsetsController(), d7Var);
            this.f6560d = window;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(f fVar, WindowInsetsController windowInsetsController, int i7) {
            if (this.f6558b == windowInsetsController) {
                fVar.a(this.f6557a, i7);
            }
        }

        @Override // androidx.core.view.d7.e
        void a(@c.m0 final f fVar) {
            if (this.f6559c.containsKey(fVar)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.p7
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i7) {
                    this.f6798a.m(fVar, windowInsetsController, i7);
                }
            };
            this.f6559c.put(fVar, onControllableInsetsChangedListener);
            this.f6558b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
        }

        @Override // androidx.core.view.d7.e
        void b(int i7, long j7, @c.o0 Interpolator interpolator, @c.o0 CancellationSignal cancellationSignal, @c.m0 j5 j5Var) {
            this.f6558b.controlWindowInsetsAnimation(i7, j7, interpolator, cancellationSignal, new a(j5Var));
        }

        @Override // androidx.core.view.d7.e
        @SuppressLint({"WrongConstant"})
        int c() {
            return this.f6558b.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.d7.e
        void d(int i7) {
            this.f6558b.hide(i7);
        }

        @Override // androidx.core.view.d7.e
        public boolean e() {
            return (this.f6558b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.d7.e
        public boolean f() {
            return (this.f6558b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.d7.e
        void g(@c.m0 f fVar) {
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListenerA = g7.a(this.f6559c.remove(fVar));
            if (onControllableInsetsChangedListenerA != null) {
                this.f6558b.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListenerA);
            }
        }

        @Override // androidx.core.view.d7.e
        public void h(boolean z7) {
            if (z7) {
                if (this.f6560d != null) {
                    n(16);
                }
                this.f6558b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f6560d != null) {
                    o(16);
                }
                this.f6558b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.d7.e
        public void i(boolean z7) {
            if (z7) {
                if (this.f6560d != null) {
                    n(8192);
                }
                this.f6558b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f6560d != null) {
                    o(8192);
                }
                this.f6558b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.d7.e
        void j(int i7) {
            this.f6558b.setSystemBarsBehavior(i7);
        }

        @Override // androidx.core.view.d7.e
        void k(int i7) {
            Window window = this.f6560d;
            if (window != null && (i7 & 8) != 0 && Build.VERSION.SDK_INT < 32) {
                ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
            }
            this.f6558b.show(i7);
        }

        protected void n(int i7) {
            View decorView = this.f6560d.getDecorView();
            decorView.setSystemUiVisibility(i7 | decorView.getSystemUiVisibility());
        }

        protected void o(int i7) {
            View decorView = this.f6560d.getDecorView();
            decorView.setSystemUiVisibility((~i7) & decorView.getSystemUiVisibility());
        }

        d(@c.m0 WindowInsetsController windowInsetsController, @c.m0 d7 d7Var) {
            this.f6559c = new androidx.collection.i<>();
            this.f6558b = windowInsetsController;
            this.f6557a = d7Var;
        }
    }

    public d7(@c.m0 Window window, @c.m0 View view) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            this.f6554a = new d(window, this);
        } else if (i7 >= 26) {
            this.f6554a = new c(window, view);
        } else {
            this.f6554a = new b(window, view);
        }
    }
}
