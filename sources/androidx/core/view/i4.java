package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6591a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6592b = 1;

    @c.t0(18)
    static class a {
        private a() {
        }

        @c.t
        static int a(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        @c.t
        static void b(ViewGroup viewGroup, int i7) {
            viewGroup.setLayoutMode(i7);
        }
    }

    @c.t0(21)
    static class b {
        private b() {
        }

        @c.t
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        @c.t
        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        @c.t
        static void c(ViewGroup viewGroup, boolean z7) {
            viewGroup.setTransitionGroup(z7);
        }
    }

    private i4() {
    }

    public static int a(@c.m0 ViewGroup viewGroup) {
        return a.a(viewGroup);
    }

    public static int b(@c.m0 ViewGroup viewGroup) {
        return b.a(viewGroup);
    }

    public static boolean c(@c.m0 ViewGroup viewGroup) {
        return b.b(viewGroup);
    }

    @Deprecated
    public static boolean d(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void e(@c.m0 ViewGroup viewGroup, int i7) {
        a.b(viewGroup, i7);
    }

    @Deprecated
    public static void f(ViewGroup viewGroup, boolean z7) {
        viewGroup.setMotionEventSplittingEnabled(z7);
    }

    public static void g(@c.m0 ViewGroup viewGroup, boolean z7) {
        b.c(viewGroup, z7);
    }
}
