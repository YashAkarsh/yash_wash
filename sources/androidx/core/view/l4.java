package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6683a = "ViewParentCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int[] f6684b;

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static void a(ViewParent viewParent, View view, View view2, int i7) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i7);
        }
    }

    @c.t0(21)
    static class b {
        private b() {
        }

        @c.t
        static boolean a(ViewParent viewParent, View view, float f8, float f9, boolean z7) {
            return viewParent.onNestedFling(view, f8, f9, z7);
        }

        @c.t
        static boolean b(ViewParent viewParent, View view, float f8, float f9) {
            return viewParent.onNestedPreFling(view, f8, f9);
        }

        @c.t
        static void c(ViewParent viewParent, View view, int i7, int i8, int[] iArr) {
            viewParent.onNestedPreScroll(view, i7, i8, iArr);
        }

        @c.t
        static void d(ViewParent viewParent, View view, int i7, int i8, int i9, int i10) {
            viewParent.onNestedScroll(view, i7, i8, i9, i10);
        }

        @c.t
        static void e(ViewParent viewParent, View view, View view2, int i7) {
            viewParent.onNestedScrollAccepted(view, view2, i7);
        }

        @c.t
        static boolean f(ViewParent viewParent, View view, View view2, int i7) {
            return viewParent.onStartNestedScroll(view, view2, i7);
        }

        @c.t
        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private l4() {
    }

    private static int[] a() {
        int[] iArr = f6684b;
        if (iArr == null) {
            f6684b = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return f6684b;
    }

    public static void b(@c.m0 ViewParent viewParent, @c.m0 View view, @c.m0 View view2, int i7) {
        a.a(viewParent, view, view2, i7);
    }

    public static boolean c(@c.m0 ViewParent viewParent, @c.m0 View view, float f8, float f9, boolean z7) {
        try {
            return b.a(viewParent, view, f8, f9, z7);
        } catch (AbstractMethodError e8) {
            Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e8);
            return false;
        }
    }

    public static boolean d(@c.m0 ViewParent viewParent, @c.m0 View view, float f8, float f9) {
        try {
            return b.b(viewParent, view, f8, f9);
        } catch (AbstractMethodError e8) {
            Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e8);
            return false;
        }
    }

    public static void e(@c.m0 ViewParent viewParent, @c.m0 View view, int i7, int i8, @c.m0 int[] iArr) {
        f(viewParent, view, i7, i8, iArr, 0);
    }

    public static void f(@c.m0 ViewParent viewParent, @c.m0 View view, int i7, int i8, @c.m0 int[] iArr, int i9) {
        if (viewParent instanceof v1) {
            ((v1) viewParent).s(view, i7, i8, iArr, i9);
            return;
        }
        if (i9 == 0) {
            try {
                b.c(viewParent, view, i7, i8, iArr);
            } catch (AbstractMethodError e8) {
                Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e8);
            }
        }
    }

    public static void g(@c.m0 ViewParent viewParent, @c.m0 View view, int i7, int i8, int i9, int i10) {
        i(viewParent, view, i7, i8, i9, i10, 0, a());
    }

    public static void h(@c.m0 ViewParent viewParent, @c.m0 View view, int i7, int i8, int i9, int i10, int i11) {
        i(viewParent, view, i7, i8, i9, i10, i11, a());
    }

    public static void i(@c.m0 ViewParent viewParent, @c.m0 View view, int i7, int i8, int i9, int i10, int i11, @c.m0 int[] iArr) {
        if (viewParent instanceof w1) {
            ((w1) viewParent).e(view, i7, i8, i9, i10, i11, iArr);
            return;
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (viewParent instanceof v1) {
            ((v1) viewParent).f(view, i7, i8, i9, i10, i11);
            return;
        }
        if (i11 == 0) {
            try {
                b.d(viewParent, view, i7, i8, i9, i10);
            } catch (AbstractMethodError e8) {
                Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e8);
            }
        }
    }

    public static void j(@c.m0 ViewParent viewParent, @c.m0 View view, @c.m0 View view2, int i7) {
        k(viewParent, view, view2, i7, 0);
    }

    public static void k(@c.m0 ViewParent viewParent, @c.m0 View view, @c.m0 View view2, int i7, int i8) {
        if (viewParent instanceof v1) {
            ((v1) viewParent).q(view, view2, i7, i8);
            return;
        }
        if (i8 == 0) {
            try {
                b.e(viewParent, view, view2, i7);
            } catch (AbstractMethodError e8) {
                Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e8);
            }
        }
    }

    public static boolean l(@c.m0 ViewParent viewParent, @c.m0 View view, @c.m0 View view2, int i7) {
        return m(viewParent, view, view2, i7, 0);
    }

    public static boolean m(@c.m0 ViewParent viewParent, @c.m0 View view, @c.m0 View view2, int i7, int i8) {
        if (viewParent instanceof v1) {
            return ((v1) viewParent).p(view, view2, i7, i8);
        }
        if (i8 != 0) {
            return false;
        }
        try {
            return b.f(viewParent, view, view2, i7);
        } catch (AbstractMethodError e8) {
            Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e8);
            return false;
        }
    }

    public static void n(@c.m0 ViewParent viewParent, @c.m0 View view) {
        o(viewParent, view, 0);
    }

    public static void o(@c.m0 ViewParent viewParent, @c.m0 View view, int i7) {
        if (viewParent instanceof v1) {
            ((v1) viewParent).r(view, i7);
            return;
        }
        if (i7 == 0) {
            try {
                b.g(viewParent, view);
            } catch (AbstractMethodError e8) {
                Log.e(f6683a, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e8);
            }
        }
    }

    @Deprecated
    public static boolean p(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
