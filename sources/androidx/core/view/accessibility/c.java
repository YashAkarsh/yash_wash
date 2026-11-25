package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    @Deprecated
    public interface a {
        @Deprecated
        void onAccessibilityStateChanged(boolean z7);
    }

    @Deprecated
    public static abstract class b implements a {
    }

    /* JADX INFO: renamed from: androidx.core.view.accessibility.c$c, reason: collision with other inner class name */
    private static class AccessibilityManagerAccessibilityStateChangeListenerC0078c implements AccessibilityManager.AccessibilityStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f6453a;

        AccessibilityManagerAccessibilityStateChangeListenerC0078c(@c.m0 a aVar) {
            this.f6453a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityManagerAccessibilityStateChangeListenerC0078c) {
                return this.f6453a.equals(((AccessibilityManagerAccessibilityStateChangeListenerC0078c) obj).f6453a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6453a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z7) {
            this.f6453a.onAccessibilityStateChanged(z7);
        }
    }

    @c.t0(19)
    static class d {
        private d() {
        }

        @c.t
        static boolean a(AccessibilityManager accessibilityManager, e eVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new f(eVar));
        }

        @c.t
        static boolean b(AccessibilityManager accessibilityManager, e eVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new f(eVar));
        }
    }

    public interface e {
        void onTouchExplorationStateChanged(boolean z7);
    }

    @c.t0(19)
    private static final class f implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f6454a;

        f(@c.m0 e eVar) {
            this.f6454a = eVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                return this.f6454a.equals(((f) obj).f6454a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6454a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z7) {
            this.f6454a.onTouchExplorationStateChanged(z7);
        }
    }

    private c() {
    }

    @Deprecated
    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (aVar == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManagerAccessibilityStateChangeListenerC0078c(aVar));
    }

    public static boolean b(@c.m0 AccessibilityManager accessibilityManager, @c.m0 e eVar) {
        return d.a(accessibilityManager, eVar);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> c(AccessibilityManager accessibilityManager, int i7) {
        return accessibilityManager.getEnabledAccessibilityServiceList(i7);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> d(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean e(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean f(AccessibilityManager accessibilityManager, a aVar) {
        if (aVar == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener(new AccessibilityManagerAccessibilityStateChangeListenerC0078c(aVar));
    }

    public static boolean g(@c.m0 AccessibilityManager accessibilityManager, @c.m0 e eVar) {
        return d.b(accessibilityManager, eVar);
    }
}
