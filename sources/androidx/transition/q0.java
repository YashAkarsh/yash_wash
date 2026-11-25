package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d1 f10768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10769b = "ViewUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property<View, Float> f10770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Property<View, Rect> f10771d;

    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(q0.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f8) {
            q0.h(view, f8.floatValue());
        }
    }

    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return n2.P(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            n2.M1(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f10768a = new c1();
        } else {
            f10768a = new b1();
        }
        f10770c = new a(Float.class, "translationAlpha");
        f10771d = new b(Rect.class, "clipBounds");
    }

    private q0() {
    }

    static void a(@c.m0 View view) {
        f10768a.a(view);
    }

    static p0 b(@c.m0 View view) {
        return new o0(view);
    }

    static float c(@c.m0 View view) {
        return f10768a.c(view);
    }

    static h1 d(@c.m0 View view) {
        return new g1(view);
    }

    static void e(@c.m0 View view) {
        f10768a.d(view);
    }

    static void f(@c.m0 View view, @c.o0 Matrix matrix) {
        f10768a.e(view, matrix);
    }

    static void g(@c.m0 View view, int i7, int i8, int i9, int i10) {
        f10768a.f(view, i7, i8, i9, i10);
    }

    static void h(@c.m0 View view, float f8) {
        f10768a.g(view, f8);
    }

    static void i(@c.m0 View view, int i7) {
        f10768a.h(view, i7);
    }

    static void j(@c.m0 View view, @c.m0 Matrix matrix) {
        f10768a.i(view, matrix);
    }

    static void k(@c.m0 View view, @c.m0 Matrix matrix) {
        f10768a.j(view, matrix);
    }
}
