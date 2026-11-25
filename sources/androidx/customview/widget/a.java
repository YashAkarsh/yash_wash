package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.j;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.r0;
import androidx.core.view.accessibility.s0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends androidx.core.view.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7098n = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7099o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f7100p = "android.view.View";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Rect f7101q = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final androidx.customview.widget.b.a<l0> f7102r = new C0085a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final androidx.customview.widget.b.InterfaceC0086b<j<l0>, l0> f7103s = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f7108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f7109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f7110j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f7104d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f7105e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f7106f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f7107g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f7111k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f7112l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7113m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    class C0085a implements androidx.customview.widget.b.a<l0> {
        C0085a() {
        }

        @Override // androidx.customview.widget.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l0 l0Var, Rect rect) {
            l0Var.s(rect);
        }
    }

    class b implements androidx.customview.widget.b.InterfaceC0086b<j<l0>, l0> {
        b() {
        }

        @Override // androidx.customview.widget.b.InterfaceC0086b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l0 a(j<l0> jVar, int i7) {
            return jVar.D(i7);
        }

        @Override // androidx.customview.widget.b.InterfaceC0086b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(j<l0> jVar) {
            return jVar.C();
        }
    }

    private class c extends r0 {
        c() {
        }

        @Override // androidx.core.view.accessibility.r0
        public l0 b(int i7) {
            return l0.F0(a.this.L(i7));
        }

        @Override // androidx.core.view.accessibility.r0
        public l0 d(int i7) {
            int i8 = i7 == 2 ? a.this.f7111k : a.this.f7112l;
            if (i8 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i8);
        }

        @Override // androidx.core.view.accessibility.r0
        public boolean f(int i7, int i8, Bundle bundle) {
            return a.this.T(i7, i8, bundle);
        }
    }

    public a(@m0 View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f7109i = view;
        this.f7108h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (n2.V(view) == 0) {
            n2.R1(view, 1);
        }
    }

    private static Rect E(@m0 View view, int i7, @m0 Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i7 == 17) {
            rect.set(width, 0, width, height);
        } else if (i7 == 33) {
            rect.set(0, height, width, height);
        } else if (i7 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i7 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean I(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f7109i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f7109i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int J(int i7) {
        if (i7 == 19) {
            return 33;
        }
        if (i7 != 21) {
            return i7 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean K(int i7, @o0 Rect rect) {
        l0 l0Var;
        j<l0> jVarY = y();
        int i8 = this.f7112l;
        l0 l0VarM = i8 == Integer.MIN_VALUE ? null : jVarY.m(i8);
        if (i7 == 1 || i7 == 2) {
            l0Var = (l0) androidx.customview.widget.b.d(jVarY, f7103s, f7102r, l0VarM, i7, n2.Z(this.f7109i) == 1, false);
        } else {
            if (i7 != 17 && i7 != 33 && i7 != 66 && i7 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i9 = this.f7112l;
            if (i9 != Integer.MIN_VALUE) {
                z(i9, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                E(this.f7109i, i7, rect2);
            }
            l0Var = (l0) androidx.customview.widget.b.c(jVarY, f7103s, f7102r, l0VarM, rect2, i7);
        }
        return X(l0Var != null ? jVarY.r(jVarY.p(l0Var)) : Integer.MIN_VALUE);
    }

    private boolean U(int i7, int i8, Bundle bundle) {
        if (i8 == 1) {
            return X(i7);
        }
        if (i8 == 2) {
            return o(i7);
        }
        if (i8 != 64) {
            return i8 != 128 ? N(i7, i8, bundle) : n(i7);
        }
        return W(i7);
    }

    private boolean V(int i7, Bundle bundle) {
        return n2.l1(this.f7109i, i7, bundle);
    }

    private boolean W(int i7) {
        int i8;
        if (!this.f7108h.isEnabled() || !this.f7108h.isTouchExplorationEnabled() || (i8 = this.f7111k) == i7) {
            return false;
        }
        if (i8 != Integer.MIN_VALUE) {
            n(i8);
        }
        this.f7111k = i7;
        this.f7109i.invalidate();
        Y(i7, 32768);
        return true;
    }

    private void Z(int i7) {
        int i8 = this.f7113m;
        if (i8 == i7) {
            return;
        }
        this.f7113m = i7;
        Y(i7, 128);
        Y(i8, 256);
    }

    private boolean n(int i7) {
        if (this.f7111k != i7) {
            return false;
        }
        this.f7111k = Integer.MIN_VALUE;
        this.f7109i.invalidate();
        Y(i7, 65536);
        return true;
    }

    private boolean p() {
        int i7 = this.f7112l;
        return i7 != Integer.MIN_VALUE && N(i7, 16, null);
    }

    private AccessibilityEvent q(int i7, int i8) {
        return i7 != -1 ? r(i7, i8) : s(i8);
    }

    private AccessibilityEvent r(int i7, int i8) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i8);
        l0 l0VarL = L(i7);
        accessibilityEventObtain.getText().add(l0VarL.U());
        accessibilityEventObtain.setContentDescription(l0VarL.A());
        accessibilityEventObtain.setScrollable(l0VarL.x0());
        accessibilityEventObtain.setPassword(l0VarL.v0());
        accessibilityEventObtain.setEnabled(l0VarL.o0());
        accessibilityEventObtain.setChecked(l0VarL.i0());
        P(i7, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(l0VarL.w());
        s0.Y(accessibilityEventObtain, this.f7109i, i7);
        accessibilityEventObtain.setPackageName(this.f7109i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i7) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i7);
        this.f7109i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    @m0
    private l0 t(int i7) {
        l0 l0VarC0 = l0.C0();
        l0VarC0.g1(true);
        l0VarC0.i1(true);
        l0VarC0.W0(f7100p);
        Rect rect = f7101q;
        l0VarC0.R0(rect);
        l0VarC0.S0(rect);
        l0VarC0.z1(this.f7109i);
        R(i7, l0VarC0);
        if (l0VarC0.U() == null && l0VarC0.A() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        l0VarC0.s(this.f7105e);
        if (this.f7105e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iP = l0VarC0.p();
        if ((iP & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iP & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        l0VarC0.x1(this.f7109i.getContext().getPackageName());
        l0VarC0.J1(this.f7109i, i7);
        if (this.f7111k == i7) {
            l0VarC0.O0(true);
            l0VarC0.a(128);
        } else {
            l0VarC0.O0(false);
            l0VarC0.a(64);
        }
        boolean z7 = this.f7112l == i7;
        if (z7) {
            l0VarC0.a(2);
        } else if (l0VarC0.p0()) {
            l0VarC0.a(1);
        }
        l0VarC0.j1(z7);
        this.f7109i.getLocationOnScreen(this.f7107g);
        l0VarC0.t(this.f7104d);
        if (this.f7104d.equals(rect)) {
            l0VarC0.s(this.f7104d);
            if (l0VarC0.f6488b != -1) {
                l0 l0VarC1 = l0.C0();
                for (int i8 = l0VarC0.f6488b; i8 != -1; i8 = l0VarC1.f6488b) {
                    l0VarC1.A1(this.f7109i, -1);
                    l0VarC1.R0(f7101q);
                    R(i8, l0VarC1);
                    l0VarC1.s(this.f7105e);
                    Rect rect2 = this.f7104d;
                    Rect rect3 = this.f7105e;
                    rect2.offset(rect3.left, rect3.top);
                }
                l0VarC1.I0();
            }
            this.f7104d.offset(this.f7107g[0] - this.f7109i.getScrollX(), this.f7107g[1] - this.f7109i.getScrollY());
        }
        if (this.f7109i.getLocalVisibleRect(this.f7106f)) {
            this.f7106f.offset(this.f7107g[0] - this.f7109i.getScrollX(), this.f7107g[1] - this.f7109i.getScrollY());
            if (this.f7104d.intersect(this.f7106f)) {
                l0VarC0.S0(this.f7104d);
                if (I(this.f7104d)) {
                    l0VarC0.V1(true);
                }
            }
        }
        return l0VarC0;
    }

    @m0
    private l0 u() {
        l0 l0VarD0 = l0.D0(this.f7109i);
        n2.i1(this.f7109i, l0VarD0);
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        if (l0VarD0.v() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            l0VarD0.d(this.f7109i, ((Integer) arrayList.get(i7)).intValue());
        }
        return l0VarD0;
    }

    private j<l0> y() {
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        j<l0> jVar = new j<>();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            jVar.s(arrayList.get(i7).intValue(), t(arrayList.get(i7).intValue()));
        }
        return jVar;
    }

    private void z(int i7, Rect rect) {
        L(i7).s(rect);
    }

    @Deprecated
    public int A() {
        return x();
    }

    public final int B() {
        return this.f7112l;
    }

    protected abstract int C(float f8, float f9);

    protected abstract void D(List<Integer> list);

    public final void F() {
        H(-1, 1);
    }

    public final void G(int i7) {
        H(i7, 0);
    }

    public final void H(int i7, int i8) {
        ViewParent parent;
        if (i7 == Integer.MIN_VALUE || !this.f7108h.isEnabled() || (parent = this.f7109i.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventQ = q(i7, 2048);
        androidx.core.view.accessibility.b.i(accessibilityEventQ, i8);
        parent.requestSendAccessibilityEvent(this.f7109i, accessibilityEventQ);
    }

    @m0
    l0 L(int i7) {
        return i7 == -1 ? u() : t(i7);
    }

    public final void M(boolean z7, int i7, @o0 Rect rect) {
        int i8 = this.f7112l;
        if (i8 != Integer.MIN_VALUE) {
            o(i8);
        }
        if (z7) {
            K(i7, rect);
        }
    }

    protected abstract boolean N(int i7, int i8, @o0 Bundle bundle);

    protected void O(@m0 AccessibilityEvent accessibilityEvent) {
    }

    protected void P(int i7, @m0 AccessibilityEvent accessibilityEvent) {
    }

    protected void Q(@m0 l0 l0Var) {
    }

    protected abstract void R(int i7, @m0 l0 l0Var);

    protected void S(int i7, boolean z7) {
    }

    boolean T(int i7, int i8, Bundle bundle) {
        return i7 != -1 ? U(i7, i8, bundle) : V(i8, bundle);
    }

    public final boolean X(int i7) {
        int i8;
        if ((!this.f7109i.isFocused() && !this.f7109i.requestFocus()) || (i8 = this.f7112l) == i7) {
            return false;
        }
        if (i8 != Integer.MIN_VALUE) {
            o(i8);
        }
        if (i7 == Integer.MIN_VALUE) {
            return false;
        }
        this.f7112l = i7;
        S(i7, true);
        Y(i7, 8);
        return true;
    }

    public final boolean Y(int i7, int i8) {
        ViewParent parent;
        if (i7 == Integer.MIN_VALUE || !this.f7108h.isEnabled() || (parent = this.f7109i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f7109i, q(i7, i8));
    }

    @Override // androidx.core.view.a
    public r0 b(View view) {
        if (this.f7110j == null) {
            this.f7110j = new c();
        }
        return this.f7110j;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        O(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public void g(View view, l0 l0Var) {
        super.g(view, l0Var);
        Q(l0Var);
    }

    public final boolean o(int i7) {
        if (this.f7112l != i7) {
            return false;
        }
        this.f7112l = Integer.MIN_VALUE;
        S(i7, false);
        Y(i7, 8);
        return true;
    }

    public final boolean v(@m0 MotionEvent motionEvent) {
        if (!this.f7108h.isEnabled() || !this.f7108h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iC = C(motionEvent.getX(), motionEvent.getY());
            Z(iC);
            return iC != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f7113m == Integer.MIN_VALUE) {
            return false;
        }
        Z(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(@m0 KeyEvent keyEvent) {
        int i7 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return K(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return K(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iJ = J(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z7 = false;
                    while (i7 < repeatCount && K(iJ, null)) {
                        i7++;
                        z7 = true;
                    }
                    return z7;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f7111k;
    }
}
