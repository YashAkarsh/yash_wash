package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final View.AccessibilityDelegate f6419c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View.AccessibilityDelegate f6420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f6421b;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    static final class C0076a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f6422a;

        C0076a(a aVar) {
            this.f6422a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f6422a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        @c.t0(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.accessibility.r0 r0VarB = this.f6422a.b(view);
            if (r0VarB != null) {
                return (AccessibilityNodeProvider) r0VarB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6422a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.accessibility.l0 l0VarX1 = androidx.core.view.accessibility.l0.X1(accessibilityNodeInfo);
            l0VarX1.E1(n2.Z0(view));
            l0VarX1.k1(n2.N0(view));
            l0VarX1.y1(n2.J(view));
            l0VarX1.K1(n2.v0(view));
            this.f6422a.g(view, l0VarX1);
            l0VarX1.f(accessibilityNodeInfo.getText(), view);
            List<androidx.core.view.accessibility.l0.a> listC = a.c(view);
            for (int i7 = 0; i7 < listC.size(); i7++) {
                l0VarX1.b(listC.get(i7));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f6422a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f6422a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i7, Bundle bundle) {
            return this.f6422a.j(view, i7, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i7) {
            this.f6422a.l(view, i7);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f6422a.m(view, accessibilityEvent);
        }
    }

    @c.t0(16)
    static class b {
        private b() {
        }

        @c.t
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        @c.t
        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i7, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i7, bundle);
        }
    }

    public a() {
        this(f6419c);
    }

    static List<androidx.core.view.accessibility.l0.a> c(View view) {
        List<androidx.core.view.accessibility.l0.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrX = androidx.core.view.accessibility.l0.x(view.createAccessibilityNodeInfo().getText());
            for (int i7 = 0; clickableSpanArrX != null && i7 < clickableSpanArrX.length; i7++) {
                if (clickableSpan.equals(clickableSpanArrX[i7])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i7, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i7)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(@c.m0 View view, @c.m0 AccessibilityEvent accessibilityEvent) {
        return this.f6420a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @c.o0
    public androidx.core.view.accessibility.r0 b(@c.m0 View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = b.a(this.f6420a, view);
        if (accessibilityNodeProviderA != null) {
            return new androidx.core.view.accessibility.r0(accessibilityNodeProviderA);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f6421b;
    }

    public void f(@c.m0 View view, @c.m0 AccessibilityEvent accessibilityEvent) {
        this.f6420a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@c.m0 View view, @c.m0 androidx.core.view.accessibility.l0 l0Var) {
        this.f6420a.onInitializeAccessibilityNodeInfo(view, l0Var.W1());
    }

    public void h(@c.m0 View view, @c.m0 AccessibilityEvent accessibilityEvent) {
        this.f6420a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@c.m0 ViewGroup viewGroup, @c.m0 View view, @c.m0 AccessibilityEvent accessibilityEvent) {
        return this.f6420a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@c.m0 View view, int i7, @c.o0 Bundle bundle) {
        List<androidx.core.view.accessibility.l0.a> listC = c(view);
        boolean zB = false;
        for (int i8 = 0; i8 < listC.size(); i8++) {
            androidx.core.view.accessibility.l0.a aVar = listC.get(i8);
            if (aVar.b() == i7) {
                zB = aVar.d(view, bundle);
                break;
            }
        }
        if (!zB) {
            zB = b.b(this.f6420a, view, i7, bundle);
        }
        return (zB || i7 != R.id.accessibility_action_clickable_span || bundle == null) ? zB : k(bundle.getInt(androidx.core.view.accessibility.a.f6423d, -1), view);
    }

    public void l(@c.m0 View view, int i7) {
        this.f6420a.sendAccessibilityEvent(view, i7);
    }

    public void m(@c.m0 View view, @c.m0 AccessibilityEvent accessibilityEvent) {
        this.f6420a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public a(@c.m0 View.AccessibilityDelegate accessibilityDelegate) {
        this.f6420a = accessibilityDelegate;
        this.f6421b = new C0076a(this);
    }
}
