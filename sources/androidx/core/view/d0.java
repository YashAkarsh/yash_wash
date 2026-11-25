package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DisplayCutout f6550a;

    @c.t0(28)
    static class a {
        private a() {
        }

        @c.t
        static DisplayCutout a(Rect rect, List<Rect> list) {
            c0.a();
            return b0.a(rect, list);
        }

        @c.t
        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        @c.t
        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        @c.t
        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        @c.t
        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        @c.t
        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    @c.t0(29)
    static class b {
        private b() {
        }

        @c.t
        static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            c0.a();
            return e0.a(insets, rect, rect2, rect3, rect4);
        }
    }

    @c.t0(30)
    static class c {
        private c() {
        }

        @c.t
        static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
            c0.a();
            return g0.a(insets, rect, rect2, rect3, rect4, insets2);
        }

        @c.t
        static Insets b(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    public d0(@c.o0 Rect rect, @c.o0 List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? a.a(rect, list) : null);
    }

    private static DisplayCutout a(@c.m0 androidx.core.graphics.b2 b2Var, @c.o0 Rect rect, @c.o0 Rect rect2, @c.o0 Rect rect3, @c.o0 Rect rect4, @c.m0 androidx.core.graphics.b2 b2Var2) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            return c.a(b2Var.h(), rect, rect2, rect3, rect4, b2Var2.h());
        }
        if (i7 >= 29) {
            return b.a(b2Var.h(), rect, rect2, rect3, rect4);
        }
        if (i7 < 28) {
            return null;
        }
        Rect rect5 = new Rect(b2Var.f5777a, b2Var.f5778b, b2Var.f5779c, b2Var.f5780d);
        ArrayList arrayList = new ArrayList();
        if (rect != null) {
            arrayList.add(rect);
        }
        if (rect2 != null) {
            arrayList.add(rect2);
        }
        if (rect3 != null) {
            arrayList.add(rect3);
        }
        if (rect4 != null) {
            arrayList.add(rect4);
        }
        return a.a(rect5, arrayList);
    }

    static d0 i(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new d0(displayCutout);
    }

    @c.m0
    public List<Rect> b() {
        return Build.VERSION.SDK_INT >= 28 ? a.b(this.f6550a) : Collections.emptyList();
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(this.f6550a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.d(this.f6550a);
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e(this.f6550a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d0.class != obj.getClass()) {
            return false;
        }
        return androidx.core.util.r.a(this.f6550a, ((d0) obj).f6550a);
    }

    public int f() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.f(this.f6550a);
        }
        return 0;
    }

    @c.m0
    public androidx.core.graphics.b2 g() {
        return Build.VERSION.SDK_INT >= 30 ? androidx.core.graphics.b2.g(c.b(this.f6550a)) : androidx.core.graphics.b2.f5776e;
    }

    @c.t0(28)
    DisplayCutout h() {
        return this.f6550a;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f6550a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    @c.m0
    public String toString() {
        return "DisplayCutoutCompat{" + this.f6550a + com.alipay.sdk.util.j.f13808d;
    }

    public d0(@c.m0 androidx.core.graphics.b2 b2Var, @c.o0 Rect rect, @c.o0 Rect rect2, @c.o0 Rect rect3, @c.o0 Rect rect4, @c.m0 androidx.core.graphics.b2 b2Var2) {
        this(a(b2Var, rect, rect2, rect3, rect4, b2Var2));
    }

    private d0(DisplayCutout displayCutout) {
        this.f6550a = displayCutout;
    }
}
