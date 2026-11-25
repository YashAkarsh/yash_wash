package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f6848b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6849c = "WindowInsetsAnimCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f6850a;

    public static abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6853c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6854d = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WindowInsets f6855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6856b;

        @c.x0({c.x0.a.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public b(int i7) {
            this.f6856b = i7;
        }

        public final int a() {
            return this.f6856b;
        }

        public void b(@c.m0 u4 u4Var) {
        }

        public void c(@c.m0 u4 u4Var) {
        }

        @c.m0
        public abstract w5 d(@c.m0 w5 w5Var, @c.m0 List<u4> list);

        @c.m0
        public a e(@c.m0 u4 u4Var, @c.m0 a aVar) {
            return aVar;
        }
    }

    @c.t0(21)
    private static class c extends e {

        @c.t0(21)
        private static class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final int f6857c = 160;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final b f6858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private w5 f6859b;

            /* JADX INFO: renamed from: androidx.core.view.u4$c$a$a, reason: collision with other inner class name */
            class C0080a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ u4 f6860a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ w5 f6861b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ w5 f6862c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f6863d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f6864e;

                C0080a(u4 u4Var, w5 w5Var, w5 w5Var2, int i7, View view) {
                    this.f6860a = u4Var;
                    this.f6861b = w5Var;
                    this.f6862c = w5Var2;
                    this.f6863d = i7;
                    this.f6864e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f6860a.i(valueAnimator.getAnimatedFraction());
                    c.n(this.f6864e, c.r(this.f6861b, this.f6862c, this.f6860a.d(), this.f6863d), Collections.singletonList(this.f6860a));
                }
            }

            class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ u4 f6866a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ View f6867b;

                b(u4 u4Var, View view) {
                    this.f6866a = u4Var;
                    this.f6867b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f6866a.i(1.0f);
                    c.l(this.f6867b, this.f6866a);
                }
            }

            /* JADX INFO: renamed from: androidx.core.view.u4$c$a$c, reason: collision with other inner class name */
            class RunnableC0081c implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ View f6869a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ u4 f6870b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ a f6871c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ValueAnimator f6872d;

                RunnableC0081c(View view, u4 u4Var, a aVar, ValueAnimator valueAnimator) {
                    this.f6869a = view;
                    this.f6870b = u4Var;
                    this.f6871c = aVar;
                    this.f6872d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.o(this.f6869a, this.f6870b, this.f6871c);
                    this.f6872d.start();
                }
            }

            a(@c.m0 View view, @c.m0 b bVar) {
                this.f6858a = bVar;
                w5 w5VarO0 = n2.o0(view);
                this.f6859b = w5VarO0 != null ? new w5.b(w5VarO0).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.f6859b = w5.L(windowInsets, view);
                    return c.p(view, windowInsets);
                }
                w5 w5VarL = w5.L(windowInsets, view);
                if (this.f6859b == null) {
                    this.f6859b = n2.o0(view);
                }
                if (this.f6859b == null) {
                    this.f6859b = w5VarL;
                    return c.p(view, windowInsets);
                }
                b bVarQ = c.q(view);
                if (bVarQ != null && Objects.equals(bVarQ.f6855a, windowInsets)) {
                    return c.p(view, windowInsets);
                }
                int i7 = c.i(w5VarL, this.f6859b);
                if (i7 == 0) {
                    return c.p(view, windowInsets);
                }
                w5 w5Var = this.f6859b;
                u4 u4Var = new u4(i7, new DecelerateInterpolator(), 160L);
                u4Var.i(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(u4Var.b());
                a aVarJ = c.j(w5VarL, w5Var, i7);
                c.m(view, u4Var, windowInsets, false);
                duration.addUpdateListener(new C0080a(u4Var, w5VarL, w5Var, i7, view));
                duration.addListener(new b(u4Var, view));
                c2.a(view, new RunnableC0081c(view, u4Var, aVarJ, duration));
                this.f6859b = w5VarL;
                return c.p(view, windowInsets);
            }
        }

        c(int i7, @c.o0 Interpolator interpolator, long j7) {
            super(i7, interpolator, j7);
        }

        @SuppressLint({"WrongConstant"})
        static int i(@c.m0 w5 w5Var, @c.m0 w5 w5Var2) {
            int i7 = 0;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if (!w5Var.f(i8).equals(w5Var2.f(i8))) {
                    i7 |= i8;
                }
            }
            return i7;
        }

        @c.m0
        static a j(@c.m0 w5 w5Var, @c.m0 w5 w5Var2, int i7) {
            androidx.core.graphics.b2 b2VarF = w5Var.f(i7);
            androidx.core.graphics.b2 b2VarF2 = w5Var2.f(i7);
            return new a(androidx.core.graphics.b2.d(Math.min(b2VarF.f5777a, b2VarF2.f5777a), Math.min(b2VarF.f5778b, b2VarF2.f5778b), Math.min(b2VarF.f5779c, b2VarF2.f5779c), Math.min(b2VarF.f5780d, b2VarF2.f5780d)), androidx.core.graphics.b2.d(Math.max(b2VarF.f5777a, b2VarF2.f5777a), Math.max(b2VarF.f5778b, b2VarF2.f5778b), Math.max(b2VarF.f5779c, b2VarF2.f5779c), Math.max(b2VarF.f5780d, b2VarF2.f5780d)));
        }

        @c.m0
        private static View.OnApplyWindowInsetsListener k(@c.m0 View view, @c.m0 b bVar) {
            return new a(view, bVar);
        }

        static void l(@c.m0 View view, @c.m0 u4 u4Var) {
            b bVarQ = q(view);
            if (bVarQ != null) {
                bVarQ.b(u4Var);
                if (bVarQ.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    l(viewGroup.getChildAt(i7), u4Var);
                }
            }
        }

        static void m(View view, u4 u4Var, WindowInsets windowInsets, boolean z7) {
            b bVarQ = q(view);
            if (bVarQ != null) {
                bVarQ.f6855a = windowInsets;
                if (!z7) {
                    bVarQ.c(u4Var);
                    z7 = bVarQ.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    m(viewGroup.getChildAt(i7), u4Var, windowInsets, z7);
                }
            }
        }

        static void n(@c.m0 View view, @c.m0 w5 w5Var, @c.m0 List<u4> list) {
            b bVarQ = q(view);
            if (bVarQ != null) {
                w5Var = bVarQ.d(w5Var, list);
                if (bVarQ.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    n(viewGroup.getChildAt(i7), w5Var, list);
                }
            }
        }

        static void o(View view, u4 u4Var, a aVar) {
            b bVarQ = q(view);
            if (bVarQ != null) {
                bVarQ.e(u4Var, aVar);
                if (bVarQ.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    o(viewGroup.getChildAt(i7), u4Var, aVar);
                }
            }
        }

        @c.m0
        static WindowInsets p(@c.m0 View view, @c.m0 WindowInsets windowInsets) {
            return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        @c.o0
        static b q(View view) {
            Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).f6858a;
            }
            return null;
        }

        @SuppressLint({"WrongConstant"})
        static w5 r(w5 w5Var, w5 w5Var2, float f8, int i7) {
            w5.b bVar = new w5.b(w5Var);
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) == 0) {
                    bVar.c(i8, w5Var.f(i8));
                } else {
                    androidx.core.graphics.b2 b2VarF = w5Var.f(i8);
                    androidx.core.graphics.b2 b2VarF2 = w5Var2.f(i8);
                    float f9 = 1.0f - f8;
                    bVar.c(i8, w5.z(b2VarF, (int) (((double) ((b2VarF.f5777a - b2VarF2.f5777a) * f9)) + 0.5d), (int) (((double) ((b2VarF.f5778b - b2VarF2.f5778b) * f9)) + 0.5d), (int) (((double) ((b2VarF.f5779c - b2VarF2.f5779c) * f9)) + 0.5d), (int) (((double) ((b2VarF.f5780d - b2VarF2.f5780d) * f9)) + 0.5d)));
                }
            }
            return bVar.a();
        }

        static void s(@c.m0 View view, @c.o0 b bVar) {
            Object tag = view.getTag(R.id.tag_on_apply_window_listener);
            if (bVar == null) {
                view.setTag(R.id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerK = k(view, bVar);
            view.setTag(R.id.tag_window_insets_animation_callback, onApplyWindowInsetsListenerK);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerK);
            }
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f6880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        private final Interpolator f6881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f6882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f6883e;

        e(int i7, @c.o0 Interpolator interpolator, long j7) {
            this.f6879a = i7;
            this.f6881c = interpolator;
            this.f6882d = j7;
        }

        public float a() {
            return this.f6883e;
        }

        public long b() {
            return this.f6882d;
        }

        public float c() {
            return this.f6880b;
        }

        public float d() {
            Interpolator interpolator = this.f6881c;
            return interpolator != null ? interpolator.getInterpolation(this.f6880b) : this.f6880b;
        }

        @c.o0
        public Interpolator e() {
            return this.f6881c;
        }

        public int f() {
            return this.f6879a;
        }

        public void g(float f8) {
            this.f6883e = f8;
        }

        public void h(float f8) {
            this.f6880b = f8;
        }
    }

    public u4(int i7, @c.o0 Interpolator interpolator, long j7) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f6850a = new d(i7, interpolator, j7);
        } else {
            this.f6850a = new c(i7, interpolator, j7);
        }
    }

    static void h(@c.m0 View view, @c.o0 b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.l(view, bVar);
        } else {
            c.s(view, bVar);
        }
    }

    @c.t0(30)
    static u4 j(WindowInsetsAnimation windowInsetsAnimation) {
        return new u4(windowInsetsAnimation);
    }

    @c.v(from = 0.0d, to = 1.0d)
    public float a() {
        return this.f6850a.a();
    }

    public long b() {
        return this.f6850a.b();
    }

    @c.v(from = 0.0d, to = 1.0d)
    public float c() {
        return this.f6850a.c();
    }

    public float d() {
        return this.f6850a.d();
    }

    @c.o0
    public Interpolator e() {
        return this.f6850a.e();
    }

    public int f() {
        return this.f6850a.f();
    }

    public void g(@c.v(from = 0.0d, to = 1.0d) float f8) {
        this.f6850a.g(f8);
    }

    public void i(@c.v(from = 0.0d, to = 1.0d) float f8) {
        this.f6850a.h(f8);
    }

    @c.t0(30)
    private static class d extends e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @c.m0
        private final WindowInsetsAnimation f6874f;

        @c.t0(30)
        private static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final b f6875a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List<u4> f6876b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private ArrayList<u4> f6877c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final HashMap<WindowInsetsAnimation, u4> f6878d;

            a(@c.m0 b bVar) {
                super(bVar.a());
                this.f6878d = new HashMap<>();
                this.f6875a = bVar;
            }

            @c.m0
            private u4 a(@c.m0 WindowInsetsAnimation windowInsetsAnimation) {
                u4 u4Var = this.f6878d.get(windowInsetsAnimation);
                if (u4Var != null) {
                    return u4Var;
                }
                u4 u4VarJ = u4.j(windowInsetsAnimation);
                this.f6878d.put(windowInsetsAnimation, u4VarJ);
                return u4VarJ;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@c.m0 WindowInsetsAnimation windowInsetsAnimation) {
                this.f6875a.b(a(windowInsetsAnimation));
                this.f6878d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@c.m0 WindowInsetsAnimation windowInsetsAnimation) {
                this.f6875a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @c.m0
            public WindowInsets onProgress(@c.m0 WindowInsets windowInsets, @c.m0 List<WindowInsetsAnimation> list) {
                ArrayList<u4> arrayList = this.f6877c;
                if (arrayList == null) {
                    ArrayList<u4> arrayList2 = new ArrayList<>(list.size());
                    this.f6877c = arrayList2;
                    this.f6876b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = i5.a(list.get(size));
                    u4 u4VarA = a(windowInsetsAnimationA);
                    u4VarA.i(windowInsetsAnimationA.getFraction());
                    this.f6877c.add(u4VarA);
                }
                return this.f6875a.d(w5.K(windowInsets), this.f6876b).J();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @c.m0
            public WindowInsetsAnimation.Bounds onStart(@c.m0 WindowInsetsAnimation windowInsetsAnimation, @c.m0 WindowInsetsAnimation.Bounds bounds) {
                return this.f6875a.e(a(windowInsetsAnimation), a.e(bounds)).d();
            }
        }

        d(@c.m0 WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f6874f = windowInsetsAnimation;
        }

        @c.m0
        public static WindowInsetsAnimation.Bounds i(@c.m0 a aVar) {
            y4.a();
            return x4.a(aVar.a().h(), aVar.b().h());
        }

        @c.m0
        public static androidx.core.graphics.b2 j(@c.m0 WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.b2.g(bounds.getUpperBound());
        }

        @c.m0
        public static androidx.core.graphics.b2 k(@c.m0 WindowInsetsAnimation.Bounds bounds) {
            return androidx.core.graphics.b2.g(bounds.getLowerBound());
        }

        public static void l(@c.m0 View view, @c.o0 b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // androidx.core.view.u4.e
        public long b() {
            return this.f6874f.getDurationMillis();
        }

        @Override // androidx.core.view.u4.e
        public float c() {
            return this.f6874f.getFraction();
        }

        @Override // androidx.core.view.u4.e
        public float d() {
            return this.f6874f.getInterpolatedFraction();
        }

        @Override // androidx.core.view.u4.e
        @c.o0
        public Interpolator e() {
            return this.f6874f.getInterpolator();
        }

        @Override // androidx.core.view.u4.e
        public int f() {
            return this.f6874f.getTypeMask();
        }

        @Override // androidx.core.view.u4.e
        public void h(float f8) {
            this.f6874f.setFraction(f8);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        d(int i7, Interpolator interpolator, long j7) {
            this(h5.a(i7, interpolator, j7));
            w4.a();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.core.graphics.b2 f6851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.graphics.b2 f6852b;

        public a(@c.m0 androidx.core.graphics.b2 b2Var, @c.m0 androidx.core.graphics.b2 b2Var2) {
            this.f6851a = b2Var;
            this.f6852b = b2Var2;
        }

        @c.t0(30)
        @c.m0
        public static a e(@c.m0 WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        @c.m0
        public androidx.core.graphics.b2 a() {
            return this.f6851a;
        }

        @c.m0
        public androidx.core.graphics.b2 b() {
            return this.f6852b;
        }

        @c.m0
        public a c(@c.m0 androidx.core.graphics.b2 b2Var) {
            return new a(w5.z(this.f6851a, b2Var.f5777a, b2Var.f5778b, b2Var.f5779c, b2Var.f5780d), w5.z(this.f6852b, b2Var.f5777a, b2Var.f5778b, b2Var.f5779c, b2Var.f5780d));
        }

        @c.t0(30)
        @c.m0
        public WindowInsetsAnimation.Bounds d() {
            return d.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f6851a + " upper=" + this.f6852b + com.alipay.sdk.util.j.f13808d;
        }

        @c.t0(30)
        private a(@c.m0 WindowInsetsAnimation.Bounds bounds) {
            this.f6851a = d.k(bounds);
            this.f6852b = d.j(bounds);
        }
    }

    @c.t0(30)
    private u4(@c.m0 WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f6850a = new d(windowInsetsAnimation);
        }
    }
}
