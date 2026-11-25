package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;

/* JADX INFO: loaded from: classes.dex */
public class u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f6532b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6533c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6534d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6535e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6536f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6537g = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f6538a;

    @c.t0(21)
    private static class a {
        private a() {
        }

        @c.t
        static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        @c.t
        static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i7) {
            return accessibilityWindowInfo.getChild(i7);
        }

        @c.t
        static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        @c.t
        static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        @c.t
        static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        @c.t
        static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        @c.t
        static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        @c.t
        static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        @c.t
        static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        @c.t
        static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        @c.t
        static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        @c.t
        static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        @c.t
        static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }

        @c.t
        static void n(AccessibilityWindowInfo accessibilityWindowInfo) {
            accessibilityWindowInfo.recycle();
        }
    }

    @c.t0(24)
    private static class b {
        private b() {
        }

        @c.t
        static AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        @c.t
        static CharSequence b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    private u0(Object obj) {
        this.f6538a = obj;
    }

    @c.o0
    public static u0 n() {
        return r(a.l());
    }

    @c.o0
    public static u0 o(@c.o0 u0 u0Var) {
        if (u0Var == null) {
            return null;
        }
        return r(a.m((AccessibilityWindowInfo) u0Var.f6538a));
    }

    private static String q(int i7) {
        if (i7 == 1) {
            return "TYPE_APPLICATION";
        }
        if (i7 == 2) {
            return "TYPE_INPUT_METHOD";
        }
        if (i7 != 3) {
            return i7 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY";
        }
        return "TYPE_SYSTEM";
    }

    static u0 r(Object obj) {
        if (obj != null) {
            return new u0(obj);
        }
        return null;
    }

    @c.o0
    public l0 a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return l0.Y1(b.a((AccessibilityWindowInfo) this.f6538a));
        }
        return null;
    }

    public void b(@c.m0 Rect rect) {
        a.a((AccessibilityWindowInfo) this.f6538a, rect);
    }

    @c.o0
    public u0 c(int i7) {
        return r(a.b((AccessibilityWindowInfo) this.f6538a, i7));
    }

    public int d() {
        return a.c((AccessibilityWindowInfo) this.f6538a);
    }

    public int e() {
        return a.d((AccessibilityWindowInfo) this.f6538a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        Object obj2 = this.f6538a;
        if (obj2 == null) {
            return u0Var.f6538a == null;
        }
        return obj2.equals(u0Var.f6538a);
    }

    public int f() {
        return a.e((AccessibilityWindowInfo) this.f6538a);
    }

    @c.o0
    public u0 g() {
        return r(a.f((AccessibilityWindowInfo) this.f6538a));
    }

    @c.o0
    public l0 h() {
        return l0.Y1(a.g((AccessibilityWindowInfo) this.f6538a));
    }

    public int hashCode() {
        Object obj = this.f6538a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @c.o0
    public CharSequence i() {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.b((AccessibilityWindowInfo) this.f6538a);
        }
        return null;
    }

    public int j() {
        return a.h((AccessibilityWindowInfo) this.f6538a);
    }

    public boolean k() {
        return a.i((AccessibilityWindowInfo) this.f6538a);
    }

    public boolean l() {
        return a.j((AccessibilityWindowInfo) this.f6538a);
    }

    public boolean m() {
        return a.k((AccessibilityWindowInfo) this.f6538a);
    }

    public void p() {
        a.n((AccessibilityWindowInfo) this.f6538a);
    }

    @c.m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        b(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(e());
        sb.append(", type=");
        sb.append(q(j()));
        sb.append(", layer=");
        sb.append(f());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(m());
        sb.append(", active=");
        sb.append(l());
        sb.append(", hasParent=");
        sb.append(g() != null);
        sb.append(", hasChildren=");
        sb.append(d() > 0);
        sb.append(']');
        return sb.toString();
    }
}
