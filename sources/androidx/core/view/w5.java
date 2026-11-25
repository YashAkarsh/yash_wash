package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class w5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6888b = "WindowInsetsCompat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    public static final w5 f6889c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f6890a;

    @c.t0(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f6891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f6892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f6893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f6894d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f6891a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f6892b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f6893c = declaredField3;
                declaredField3.setAccessible(true);
                f6894d = true;
            } catch (ReflectiveOperationException e8) {
                Log.w(w5.f6888b, "Failed to get visible insets from AttachInfo " + e8.getMessage(), e8);
            }
        }

        private a() {
        }

        @c.o0
        public static w5 a(@c.m0 View view) {
            if (f6894d && view.isAttachedToWindow()) {
                try {
                    Object obj = f6891a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f6892b.get(obj);
                        Rect rect2 = (Rect) f6893c.get(obj);
                        if (rect != null && rect2 != null) {
                            w5 w5VarA = new b().f(androidx.core.graphics.b2.e(rect)).h(androidx.core.graphics.b2.e(rect2)).a();
                            w5VarA.H(w5VarA);
                            w5VarA.d(view.getRootView());
                            return w5VarA;
                        }
                    }
                } catch (IllegalAccessException e8) {
                    Log.w(w5.f6888b, "Failed to get insets from AttachInfo. " + e8.getMessage(), e8);
                }
            }
            return null;
        }
    }

    @c.t0(30)
    private static class e extends d {
        e() {
        }

        @Override // androidx.core.view.w5.f
        void d(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setInsets(n.a(i7), b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void e(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setInsetsIgnoringVisibility(n.a(i7), b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void k(int i7, boolean z7) {
            this.f6902c.setVisible(n.a(i7), z7);
        }

        e(@c.m0 w5 w5Var) {
            super(w5Var);
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w5 f6903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b2[] f6904b;

        f() {
            this(new w5((w5) null));
        }

        protected final void a() {
            androidx.core.graphics.b2[] b2VarArr = this.f6904b;
            if (b2VarArr != null) {
                androidx.core.graphics.b2 b2VarF = b2VarArr[m.e(1)];
                androidx.core.graphics.b2 b2VarF2 = this.f6904b[m.e(2)];
                if (b2VarF2 == null) {
                    b2VarF2 = this.f6903a.f(2);
                }
                if (b2VarF == null) {
                    b2VarF = this.f6903a.f(1);
                }
                i(androidx.core.graphics.b2.b(b2VarF, b2VarF2));
                androidx.core.graphics.b2 b2Var = this.f6904b[m.e(16)];
                if (b2Var != null) {
                    h(b2Var);
                }
                androidx.core.graphics.b2 b2Var2 = this.f6904b[m.e(32)];
                if (b2Var2 != null) {
                    f(b2Var2);
                }
                androidx.core.graphics.b2 b2Var3 = this.f6904b[m.e(64)];
                if (b2Var3 != null) {
                    j(b2Var3);
                }
            }
        }

        @c.m0
        w5 b() {
            a();
            return this.f6903a;
        }

        void c(@c.o0 d0 d0Var) {
        }

        void d(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            if (this.f6904b == null) {
                this.f6904b = new androidx.core.graphics.b2[9];
            }
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    this.f6904b[m.e(i8)] = b2Var;
                }
            }
        }

        void e(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            if (i7 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        void f(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void g(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void h(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void i(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void j(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void k(int i7, boolean z7) {
        }

        f(@c.m0 w5 w5Var) {
            this.f6903a = w5Var;
        }
    }

    @c.t0(28)
    private static class i extends h {
        i(@c.m0 w5 w5Var, @c.m0 WindowInsets windowInsets) {
            super(w5Var, windowInsets);
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        w5 a() {
            return w5.K(this.f6910c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f6910c, iVar.f6910c) && Objects.equals(this.f6914g, iVar.f6914g);
        }

        @Override // androidx.core.view.w5.l
        @c.o0
        d0 f() {
            return d0.i(this.f6910c.getDisplayCutout());
        }

        @Override // androidx.core.view.w5.l
        public int hashCode() {
            return this.f6910c.hashCode();
        }

        i(@c.m0 w5 w5Var, @c.m0 i iVar) {
            super(w5Var, iVar);
        }
    }

    @c.t0(30)
    private static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @c.m0
        static final w5 f6919q = w5.K(WindowInsets.CONSUMED);

        k(@c.m0 w5 w5Var, @c.m0 WindowInsets windowInsets) {
            super(w5Var, windowInsets);
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        final void d(@c.m0 View view) {
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        @c.m0
        public androidx.core.graphics.b2 g(int i7) {
            return androidx.core.graphics.b2.g(this.f6910c.getInsets(n.a(i7)));
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        @c.m0
        public androidx.core.graphics.b2 h(int i7) {
            return androidx.core.graphics.b2.g(this.f6910c.getInsetsIgnoringVisibility(n.a(i7)));
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        public boolean q(int i7) {
            return this.f6910c.isVisible(n.a(i7));
        }

        k(@c.m0 w5 w5Var, @c.m0 k kVar) {
            super(w5Var, kVar);
        }
    }

    private static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.m0
        static final w5 f6920b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final w5 f6921a;

        l(@c.m0 w5 w5Var) {
            this.f6921a = w5Var;
        }

        @c.m0
        w5 a() {
            return this.f6921a;
        }

        @c.m0
        w5 b() {
            return this.f6921a;
        }

        @c.m0
        w5 c() {
            return this.f6921a;
        }

        void d(@c.m0 View view) {
        }

        void e(@c.m0 w5 w5Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return p() == lVar.p() && o() == lVar.o() && androidx.core.util.r.a(l(), lVar.l()) && androidx.core.util.r.a(j(), lVar.j()) && androidx.core.util.r.a(f(), lVar.f());
        }

        @c.o0
        d0 f() {
            return null;
        }

        @c.m0
        androidx.core.graphics.b2 g(int i7) {
            return androidx.core.graphics.b2.f5776e;
        }

        @c.m0
        androidx.core.graphics.b2 h(int i7) {
            if ((i7 & 8) == 0) {
                return androidx.core.graphics.b2.f5776e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.r.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        @c.m0
        androidx.core.graphics.b2 i() {
            return l();
        }

        @c.m0
        androidx.core.graphics.b2 j() {
            return androidx.core.graphics.b2.f5776e;
        }

        @c.m0
        androidx.core.graphics.b2 k() {
            return l();
        }

        @c.m0
        androidx.core.graphics.b2 l() {
            return androidx.core.graphics.b2.f5776e;
        }

        @c.m0
        androidx.core.graphics.b2 m() {
            return l();
        }

        @c.m0
        w5 n(int i7, int i8, int i9, int i10) {
            return f6920b;
        }

        boolean o() {
            return false;
        }

        boolean p() {
            return false;
        }

        boolean q(int i7) {
            return true;
        }

        public void r(androidx.core.graphics.b2[] b2VarArr) {
        }

        void s(@c.m0 androidx.core.graphics.b2 b2Var) {
        }

        void t(@c.o0 w5 w5Var) {
        }

        public void u(androidx.core.graphics.b2 b2Var) {
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f6922a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f6923b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f6924c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f6925d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f6926e = 8;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f6927f = 16;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f6928g = 32;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f6929h = 64;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f6930i = 128;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f6931j = 256;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f6932k = 9;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final int f6933l = 256;

        @c.x0({c.x0.a.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        private m() {
        }

        @c.x0({c.x0.a.LIBRARY_GROUP})
        @SuppressLint({"WrongConstant"})
        static int a() {
            return -1;
        }

        public static int b() {
            return 4;
        }

        public static int c() {
            return 128;
        }

        public static int d() {
            return 8;
        }

        static int e(int i7) {
            if (i7 == 1) {
                return 0;
            }
            if (i7 == 2) {
                return 1;
            }
            if (i7 == 4) {
                return 2;
            }
            if (i7 == 8) {
                return 3;
            }
            if (i7 == 16) {
                return 4;
            }
            if (i7 == 32) {
                return 5;
            }
            if (i7 == 64) {
                return 6;
            }
            if (i7 == 128) {
                return 7;
            }
            if (i7 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i7);
        }

        public static int f() {
            return 32;
        }

        public static int g() {
            return 2;
        }

        public static int h() {
            return 1;
        }

        public static int i() {
            return 7;
        }

        public static int j() {
            return 16;
        }

        public static int k() {
            return 64;
        }
    }

    @c.t0(30)
    private static final class n {
        private n() {
        }

        static int a(int i7) {
            int iStatusBars;
            int i8 = 0;
            for (int i9 = 1; i9 <= 256; i9 <<= 1) {
                if ((i7 & i9) != 0) {
                    if (i9 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i9 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i9 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i9 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i9 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i9 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i9 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i9 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i8 |= iStatusBars;
                }
            }
            return i8;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f6889c = k.f6919q;
        } else {
            f6889c = l.f6920b;
        }
    }

    @c.t0(20)
    private w5(@c.m0 WindowInsets windowInsets) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            this.f6890a = new k(this, windowInsets);
            return;
        }
        if (i7 >= 29) {
            this.f6890a = new j(this, windowInsets);
        } else if (i7 >= 28) {
            this.f6890a = new i(this, windowInsets);
        } else {
            this.f6890a = new h(this, windowInsets);
        }
    }

    @c.t0(20)
    @c.m0
    public static w5 K(@c.m0 WindowInsets windowInsets) {
        return L(windowInsets, null);
    }

    @c.t0(20)
    @c.m0
    public static w5 L(@c.m0 WindowInsets windowInsets, @c.o0 View view) {
        w5 w5Var = new w5((WindowInsets) androidx.core.util.w.l(windowInsets));
        if (view != null && n2.O0(view)) {
            w5Var.H(n2.o0(view));
            w5Var.d(view.getRootView());
        }
        return w5Var;
    }

    static androidx.core.graphics.b2 z(@c.m0 androidx.core.graphics.b2 b2Var, int i7, int i8, int i9, int i10) {
        int iMax = Math.max(0, b2Var.f5777a - i7);
        int iMax2 = Math.max(0, b2Var.f5778b - i8);
        int iMax3 = Math.max(0, b2Var.f5779c - i9);
        int iMax4 = Math.max(0, b2Var.f5780d - i10);
        return (iMax == i7 && iMax2 == i8 && iMax3 == i9 && iMax4 == i10) ? b2Var : androidx.core.graphics.b2.d(iMax, iMax2, iMax3, iMax4);
    }

    public boolean A() {
        return this.f6890a.o();
    }

    public boolean B() {
        return this.f6890a.p();
    }

    public boolean C(int i7) {
        return this.f6890a.q(i7);
    }

    @c.m0
    @Deprecated
    public w5 D(int i7, int i8, int i9, int i10) {
        return new b(this).h(androidx.core.graphics.b2.d(i7, i8, i9, i10)).a();
    }

    @c.m0
    @Deprecated
    public w5 E(@c.m0 Rect rect) {
        return new b(this).h(androidx.core.graphics.b2.e(rect)).a();
    }

    void F(androidx.core.graphics.b2[] b2VarArr) {
        this.f6890a.r(b2VarArr);
    }

    void G(@c.m0 androidx.core.graphics.b2 b2Var) {
        this.f6890a.s(b2Var);
    }

    void H(@c.o0 w5 w5Var) {
        this.f6890a.t(w5Var);
    }

    void I(@c.o0 androidx.core.graphics.b2 b2Var) {
        this.f6890a.u(b2Var);
    }

    @c.o0
    @c.t0(20)
    public WindowInsets J() {
        l lVar = this.f6890a;
        if (lVar instanceof g) {
            return ((g) lVar).f6910c;
        }
        return null;
    }

    @c.m0
    @Deprecated
    public w5 a() {
        return this.f6890a.a();
    }

    @c.m0
    @Deprecated
    public w5 b() {
        return this.f6890a.b();
    }

    @c.m0
    @Deprecated
    public w5 c() {
        return this.f6890a.c();
    }

    void d(@c.m0 View view) {
        this.f6890a.d(view);
    }

    @c.o0
    public d0 e() {
        return this.f6890a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w5) {
            return androidx.core.util.r.a(this.f6890a, ((w5) obj).f6890a);
        }
        return false;
    }

    @c.m0
    public androidx.core.graphics.b2 f(int i7) {
        return this.f6890a.g(i7);
    }

    @c.m0
    public androidx.core.graphics.b2 g(int i7) {
        return this.f6890a.h(i7);
    }

    @c.m0
    @Deprecated
    public androidx.core.graphics.b2 h() {
        return this.f6890a.i();
    }

    public int hashCode() {
        l lVar = this.f6890a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f6890a.j().f5780d;
    }

    @Deprecated
    public int j() {
        return this.f6890a.j().f5777a;
    }

    @Deprecated
    public int k() {
        return this.f6890a.j().f5779c;
    }

    @Deprecated
    public int l() {
        return this.f6890a.j().f5778b;
    }

    @c.m0
    @Deprecated
    public androidx.core.graphics.b2 m() {
        return this.f6890a.j();
    }

    @c.m0
    @Deprecated
    public androidx.core.graphics.b2 n() {
        return this.f6890a.k();
    }

    @Deprecated
    public int o() {
        return this.f6890a.l().f5780d;
    }

    @Deprecated
    public int p() {
        return this.f6890a.l().f5777a;
    }

    @Deprecated
    public int q() {
        return this.f6890a.l().f5779c;
    }

    @Deprecated
    public int r() {
        return this.f6890a.l().f5778b;
    }

    @c.m0
    @Deprecated
    public androidx.core.graphics.b2 s() {
        return this.f6890a.l();
    }

    @c.m0
    @Deprecated
    public androidx.core.graphics.b2 t() {
        return this.f6890a.m();
    }

    public boolean u() {
        androidx.core.graphics.b2 b2VarF = f(m.a());
        androidx.core.graphics.b2 b2Var = androidx.core.graphics.b2.f5776e;
        return (b2VarF.equals(b2Var) && g(m.a() ^ m.d()).equals(b2Var) && e() == null) ? false : true;
    }

    @Deprecated
    public boolean v() {
        return !this.f6890a.j().equals(androidx.core.graphics.b2.f5776e);
    }

    @Deprecated
    public boolean w() {
        return !this.f6890a.l().equals(androidx.core.graphics.b2.f5776e);
    }

    @c.m0
    public w5 x(@c.e0(from = 0) int i7, @c.e0(from = 0) int i8, @c.e0(from = 0) int i9, @c.e0(from = 0) int i10) {
        return this.f6890a.n(i7, i8, i9, i10);
    }

    @c.m0
    public w5 y(@c.m0 androidx.core.graphics.b2 b2Var) {
        return x(b2Var.f5777a, b2Var.f5778b, b2Var.f5779c, b2Var.f5780d);
    }

    @c.t0(api = 20)
    private static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Field f6896e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f6897f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f6898g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f6899h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsets f6900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b2 f6901d;

        c() {
            this.f6900c = l();
        }

        @c.o0
        private static WindowInsets l() {
            if (!f6897f) {
                try {
                    f6896e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e8) {
                    Log.i(w5.f6888b, "Could not retrieve WindowInsets.CONSUMED field", e8);
                }
                f6897f = true;
            }
            Field field = f6896e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e9) {
                    Log.i(w5.f6888b, "Could not get value from WindowInsets.CONSUMED field", e9);
                }
            }
            if (!f6899h) {
                try {
                    f6898g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e10) {
                    Log.i(w5.f6888b, "Could not retrieve WindowInsets(Rect) constructor", e10);
                }
                f6899h = true;
            }
            Constructor<WindowInsets> constructor = f6898g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e11) {
                    Log.i(w5.f6888b, "Could not invoke WindowInsets(Rect) constructor", e11);
                }
            }
            return null;
        }

        @Override // androidx.core.view.w5.f
        @c.m0
        w5 b() {
            a();
            w5 w5VarK = w5.K(this.f6900c);
            w5VarK.F(this.f6904b);
            w5VarK.I(this.f6901d);
            return w5VarK;
        }

        @Override // androidx.core.view.w5.f
        void g(@c.o0 androidx.core.graphics.b2 b2Var) {
            this.f6901d = b2Var;
        }

        @Override // androidx.core.view.w5.f
        void i(@c.m0 androidx.core.graphics.b2 b2Var) {
            WindowInsets windowInsets = this.f6900c;
            if (windowInsets != null) {
                this.f6900c = windowInsets.replaceSystemWindowInsets(b2Var.f5777a, b2Var.f5778b, b2Var.f5779c, b2Var.f5780d);
            }
        }

        c(@c.m0 w5 w5Var) {
            super(w5Var);
            this.f6900c = w5Var.J();
        }
    }

    @c.t0(api = 29)
    private static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f6902c;

        d() {
            g6.a();
            this.f6902c = e6.a();
        }

        @Override // androidx.core.view.w5.f
        @c.m0
        w5 b() {
            a();
            w5 w5VarK = w5.K(this.f6902c.build());
            w5VarK.F(this.f6904b);
            return w5VarK;
        }

        @Override // androidx.core.view.w5.f
        void c(@c.o0 d0 d0Var) {
            this.f6902c.setDisplayCutout(d0Var != null ? d0Var.h() : null);
        }

        @Override // androidx.core.view.w5.f
        void f(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setMandatorySystemGestureInsets(b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void g(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setStableInsets(b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void h(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setSystemGestureInsets(b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void i(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setSystemWindowInsets(b2Var.h());
        }

        @Override // androidx.core.view.w5.f
        void j(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6902c.setTappableElementInsets(b2Var.h());
        }

        d(@c.m0 w5 w5Var) {
            WindowInsets.Builder builderA;
            super(w5Var);
            WindowInsets windowInsetsJ = w5Var.J();
            if (windowInsetsJ != null) {
                g6.a();
                builderA = f6.a(windowInsetsJ);
            } else {
                g6.a();
                builderA = e6.a();
            }
            this.f6902c = builderA;
        }
    }

    @c.t0(21)
    private static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.b2 f6915m;

        h(@c.m0 w5 w5Var, @c.m0 WindowInsets windowInsets) {
            super(w5Var, windowInsets);
            this.f6915m = null;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        w5 b() {
            return w5.K(this.f6910c.consumeStableInsets());
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        w5 c() {
            return w5.K(this.f6910c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        final androidx.core.graphics.b2 j() {
            if (this.f6915m == null) {
                this.f6915m = androidx.core.graphics.b2.d(this.f6910c.getStableInsetLeft(), this.f6910c.getStableInsetTop(), this.f6910c.getStableInsetRight(), this.f6910c.getStableInsetBottom());
            }
            return this.f6915m;
        }

        @Override // androidx.core.view.w5.l
        boolean o() {
            return this.f6910c.isConsumed();
        }

        @Override // androidx.core.view.w5.l
        public void u(@c.o0 androidx.core.graphics.b2 b2Var) {
            this.f6915m = b2Var;
        }

        h(@c.m0 w5 w5Var, @c.m0 h hVar) {
            super(w5Var, hVar);
            this.f6915m = null;
            this.f6915m = hVar.f6915m;
        }
    }

    @c.t0(20)
    private static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static boolean f6905h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static Method f6906i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static Class<?> f6907j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static Field f6908k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static Field f6909l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.m0
        final WindowInsets f6910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b2[] f6911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b2 f6912e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private w5 f6913f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b2 f6914g;

        g(@c.m0 w5 w5Var, @c.m0 WindowInsets windowInsets) {
            super(w5Var);
            this.f6912e = null;
            this.f6910c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void A() {
            try {
                f6906i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f6907j = cls;
                f6908k = cls.getDeclaredField("mVisibleInsets");
                f6909l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f6908k.setAccessible(true);
                f6909l.setAccessible(true);
            } catch (ReflectiveOperationException e8) {
                Log.e(w5.f6888b, "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
            }
            f6905h = true;
        }

        @c.m0
        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.b2 v(int i7, boolean z7) {
            androidx.core.graphics.b2 b2VarB = androidx.core.graphics.b2.f5776e;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    b2VarB = androidx.core.graphics.b2.b(b2VarB, w(i8, z7));
                }
            }
            return b2VarB;
        }

        private androidx.core.graphics.b2 x() {
            w5 w5Var = this.f6913f;
            return w5Var != null ? w5Var.m() : androidx.core.graphics.b2.f5776e;
        }

        @c.o0
        private androidx.core.graphics.b2 y(@c.m0 View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f6905h) {
                A();
            }
            Method method = f6906i;
            if (method != null && f6907j != null && f6908k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w(w5.f6888b, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f6908k.get(f6909l.get(objInvoke));
                    if (rect != null) {
                        return androidx.core.graphics.b2.e(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e8) {
                    Log.e(w5.f6888b, "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
                }
            }
            return null;
        }

        @Override // androidx.core.view.w5.l
        void d(@c.m0 View view) {
            androidx.core.graphics.b2 b2VarY = y(view);
            if (b2VarY == null) {
                b2VarY = androidx.core.graphics.b2.f5776e;
            }
            s(b2VarY);
        }

        @Override // androidx.core.view.w5.l
        void e(@c.m0 w5 w5Var) {
            w5Var.H(this.f6913f);
            w5Var.G(this.f6914g);
        }

        @Override // androidx.core.view.w5.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f6914g, ((g) obj).f6914g);
            }
            return false;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        public androidx.core.graphics.b2 g(int i7) {
            return v(i7, false);
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        public androidx.core.graphics.b2 h(int i7) {
            return v(i7, true);
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        final androidx.core.graphics.b2 l() {
            if (this.f6912e == null) {
                this.f6912e = androidx.core.graphics.b2.d(this.f6910c.getSystemWindowInsetLeft(), this.f6910c.getSystemWindowInsetTop(), this.f6910c.getSystemWindowInsetRight(), this.f6910c.getSystemWindowInsetBottom());
            }
            return this.f6912e;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        w5 n(int i7, int i8, int i9, int i10) {
            b bVar = new b(w5.K(this.f6910c));
            bVar.h(w5.z(l(), i7, i8, i9, i10));
            bVar.f(w5.z(j(), i7, i8, i9, i10));
            return bVar.a();
        }

        @Override // androidx.core.view.w5.l
        boolean p() {
            return this.f6910c.isRound();
        }

        @Override // androidx.core.view.w5.l
        @SuppressLint({"WrongConstant"})
        boolean q(int i7) {
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0 && !z(i8)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.w5.l
        public void r(androidx.core.graphics.b2[] b2VarArr) {
            this.f6911d = b2VarArr;
        }

        @Override // androidx.core.view.w5.l
        void s(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6914g = b2Var;
        }

        @Override // androidx.core.view.w5.l
        void t(@c.o0 w5 w5Var) {
            this.f6913f = w5Var;
        }

        @c.m0
        protected androidx.core.graphics.b2 w(int i7, boolean z7) {
            androidx.core.graphics.b2 b2VarM;
            int i8;
            if (i7 == 1) {
                return z7 ? androidx.core.graphics.b2.d(0, Math.max(x().f5778b, l().f5778b), 0, 0) : androidx.core.graphics.b2.d(0, l().f5778b, 0, 0);
            }
            if (i7 == 2) {
                if (z7) {
                    androidx.core.graphics.b2 b2VarX = x();
                    androidx.core.graphics.b2 b2VarJ = j();
                    return androidx.core.graphics.b2.d(Math.max(b2VarX.f5777a, b2VarJ.f5777a), 0, Math.max(b2VarX.f5779c, b2VarJ.f5779c), Math.max(b2VarX.f5780d, b2VarJ.f5780d));
                }
                androidx.core.graphics.b2 b2VarL = l();
                w5 w5Var = this.f6913f;
                b2VarM = w5Var != null ? w5Var.m() : null;
                int iMin = b2VarL.f5780d;
                if (b2VarM != null) {
                    iMin = Math.min(iMin, b2VarM.f5780d);
                }
                return androidx.core.graphics.b2.d(b2VarL.f5777a, 0, b2VarL.f5779c, iMin);
            }
            if (i7 != 8) {
                if (i7 == 16) {
                    return k();
                }
                if (i7 == 32) {
                    return i();
                }
                if (i7 == 64) {
                    return m();
                }
                if (i7 != 128) {
                    return androidx.core.graphics.b2.f5776e;
                }
                w5 w5Var2 = this.f6913f;
                d0 d0VarE = w5Var2 != null ? w5Var2.e() : f();
                return d0VarE != null ? androidx.core.graphics.b2.d(d0VarE.d(), d0VarE.f(), d0VarE.e(), d0VarE.c()) : androidx.core.graphics.b2.f5776e;
            }
            androidx.core.graphics.b2[] b2VarArr = this.f6911d;
            b2VarM = b2VarArr != null ? b2VarArr[m.e(8)] : null;
            if (b2VarM != null) {
                return b2VarM;
            }
            androidx.core.graphics.b2 b2VarL2 = l();
            androidx.core.graphics.b2 b2VarX2 = x();
            int i9 = b2VarL2.f5780d;
            if (i9 > b2VarX2.f5780d) {
                return androidx.core.graphics.b2.d(0, 0, 0, i9);
            }
            androidx.core.graphics.b2 b2Var = this.f6914g;
            return (b2Var == null || b2Var.equals(androidx.core.graphics.b2.f5776e) || (i8 = this.f6914g.f5780d) <= b2VarX2.f5780d) ? androidx.core.graphics.b2.f5776e : androidx.core.graphics.b2.d(0, 0, 0, i8);
        }

        protected boolean z(int i7) {
            if (i7 != 1 && i7 != 2) {
                if (i7 == 4) {
                    return false;
                }
                if (i7 != 8 && i7 != 128) {
                    return true;
                }
            }
            return !w(i7, false).equals(androidx.core.graphics.b2.f5776e);
        }

        g(@c.m0 w5 w5Var, @c.m0 g gVar) {
            this(w5Var, new WindowInsets(gVar.f6910c));
        }
    }

    @c.t0(29)
    private static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.b2 f6916n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.b2 f6917o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.b2 f6918p;

        j(@c.m0 w5 w5Var, @c.m0 WindowInsets windowInsets) {
            super(w5Var, windowInsets);
            this.f6916n = null;
            this.f6917o = null;
            this.f6918p = null;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        androidx.core.graphics.b2 i() {
            if (this.f6917o == null) {
                this.f6917o = androidx.core.graphics.b2.g(this.f6910c.getMandatorySystemGestureInsets());
            }
            return this.f6917o;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        androidx.core.graphics.b2 k() {
            if (this.f6916n == null) {
                this.f6916n = androidx.core.graphics.b2.g(this.f6910c.getSystemGestureInsets());
            }
            return this.f6916n;
        }

        @Override // androidx.core.view.w5.l
        @c.m0
        androidx.core.graphics.b2 m() {
            if (this.f6918p == null) {
                this.f6918p = androidx.core.graphics.b2.g(this.f6910c.getTappableElementInsets());
            }
            return this.f6918p;
        }

        @Override // androidx.core.view.w5.g, androidx.core.view.w5.l
        @c.m0
        w5 n(int i7, int i8, int i9, int i10) {
            return w5.K(this.f6910c.inset(i7, i8, i9, i10));
        }

        @Override // androidx.core.view.w5.h, androidx.core.view.w5.l
        public void u(@c.o0 androidx.core.graphics.b2 b2Var) {
        }

        j(@c.m0 w5 w5Var, @c.m0 j jVar) {
            super(w5Var, jVar);
            this.f6916n = null;
            this.f6917o = null;
            this.f6918p = null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f6895a;

        public b() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                this.f6895a = new e();
            } else if (i7 >= 29) {
                this.f6895a = new d();
            } else {
                this.f6895a = new c();
            }
        }

        @c.m0
        public w5 a() {
            return this.f6895a.b();
        }

        @c.m0
        public b b(@c.o0 d0 d0Var) {
            this.f6895a.c(d0Var);
            return this;
        }

        @c.m0
        public b c(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.d(i7, b2Var);
            return this;
        }

        @c.m0
        public b d(int i7, @c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.e(i7, b2Var);
            return this;
        }

        @c.m0
        @Deprecated
        public b e(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.f(b2Var);
            return this;
        }

        @c.m0
        @Deprecated
        public b f(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.g(b2Var);
            return this;
        }

        @c.m0
        @Deprecated
        public b g(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.h(b2Var);
            return this;
        }

        @c.m0
        @Deprecated
        public b h(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.i(b2Var);
            return this;
        }

        @c.m0
        @Deprecated
        public b i(@c.m0 androidx.core.graphics.b2 b2Var) {
            this.f6895a.j(b2Var);
            return this;
        }

        @c.m0
        public b j(int i7, boolean z7) {
            this.f6895a.k(i7, z7);
            return this;
        }

        public b(@c.m0 w5 w5Var) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                this.f6895a = new e(w5Var);
            } else if (i7 >= 29) {
                this.f6895a = new d(w5Var);
            } else {
                this.f6895a = new c(w5Var);
            }
        }
    }

    public w5(@c.o0 w5 w5Var) {
        if (w5Var != null) {
            l lVar = w5Var.f6890a;
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30 && (lVar instanceof k)) {
                this.f6890a = new k(this, (k) lVar);
            } else if (i7 >= 29 && (lVar instanceof j)) {
                this.f6890a = new j(this, (j) lVar);
            } else if (i7 >= 28 && (lVar instanceof i)) {
                this.f6890a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f6890a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f6890a = new g(this, (g) lVar);
            } else {
                this.f6890a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f6890a = new l(this);
    }
}
