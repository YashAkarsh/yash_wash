package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import c.m0;
import c.t;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    @t0(21)
    static class a {
        private a() {
        }

        @t
        static PathInterpolator a(float f8, float f9) {
            return new PathInterpolator(f8, f9);
        }

        @t
        static PathInterpolator b(float f8, float f9, float f10, float f11) {
            return new PathInterpolator(f8, f9, f10, f11);
        }

        @t
        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private b() {
    }

    @m0
    public static Interpolator a(float f8, float f9) {
        return a.a(f8, f9);
    }

    @m0
    public static Interpolator b(float f8, float f9, float f10, float f11) {
        return a.b(f8, f9, f10, f11);
    }

    @m0
    public static Interpolator c(@m0 Path path) {
        return a.c(path);
    }
}
