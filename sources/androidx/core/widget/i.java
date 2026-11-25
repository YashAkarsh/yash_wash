package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EdgeEffect f7045a;

    @t0(21)
    static class a {
        private a() {
        }

        @c.t
        static void a(EdgeEffect edgeEffect, float f8, float f9) {
            edgeEffect.onPull(f8, f9);
        }
    }

    @t0(31)
    private static class b {
        private b() {
        }

        @c.t
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                m.a();
                return l.a(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        @c.t
        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        @c.t
        public static float c(EdgeEffect edgeEffect, float f8, float f9) {
            try {
                return edgeEffect.onPullDistance(f8, f9);
            } catch (Throwable unused) {
                edgeEffect.onPull(f8, f9);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public i(Context context) {
        this.f7045a = new EdgeEffect(context);
    }

    @m0
    public static EdgeEffect a(@m0 Context context, @o0 AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float d(@m0 EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void g(@m0 EdgeEffect edgeEffect, float f8, float f9) {
        a.a(edgeEffect, f8, f9);
    }

    public static float j(@m0 EdgeEffect edgeEffect, float f8, float f9) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, f8, f9);
        }
        g(edgeEffect, f8, f9);
        return f8;
    }

    @Deprecated
    public boolean b(Canvas canvas) {
        return this.f7045a.draw(canvas);
    }

    @Deprecated
    public void c() {
        this.f7045a.finish();
    }

    @Deprecated
    public boolean e() {
        return this.f7045a.isFinished();
    }

    @Deprecated
    public boolean f(int i7) {
        this.f7045a.onAbsorb(i7);
        return true;
    }

    @Deprecated
    public boolean h(float f8) {
        this.f7045a.onPull(f8);
        return true;
    }

    @Deprecated
    public boolean i(float f8, float f9) {
        g(this.f7045a, f8, f9);
        return true;
    }

    @Deprecated
    public boolean k() {
        this.f7045a.onRelease();
        return this.f7045a.isFinished();
    }

    @Deprecated
    public void l(int i7, int i8) {
        this.f7045a.setSize(i7, i8);
    }
}
