package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6834a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6835b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6836c = 10;

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static void a(@c.m0 Window window, boolean z7) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z7 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    @c.t0(28)
    static class b {
        private b() {
        }

        @c.t
        static <T> T a(Window window, int i7) {
            return (T) window.requireViewById(i7);
        }
    }

    @c.t0(30)
    static class c {
        private c() {
        }

        @c.t
        static void a(@c.m0 Window window, boolean z7) {
            window.setDecorFitsSystemWindows(z7);
        }
    }

    private r4() {
    }

    @c.m0
    public static d7 a(@c.m0 Window window, @c.m0 View view) {
        return new d7(window, view);
    }

    @c.m0
    public static <T extends View> T b(@c.m0 Window window, @c.b0 int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) b.a(window, i7);
        }
        T t7 = (T) window.findViewById(i7);
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void c(@c.m0 Window window, boolean z7) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.a(window, z7);
        } else {
            a.a(window, z7);
        }
    }
}
