package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.f4;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class o1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f1927k = "TooltipCompatHandler";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f1928l = 2500;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f1929m = 15000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f1930n = 3000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static o1 f1931o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static o1 f1932p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f1934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f1936d = new Runnable() { // from class: androidx.appcompat.widget.m1
        @Override // java.lang.Runnable
        public final void run() {
            this.f1918a.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f1937e = new Runnable() { // from class: androidx.appcompat.widget.n1
        @Override // java.lang.Runnable
        public final void run() {
            this.f1920a.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p1 f1940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1942j;

    private o1(View view, CharSequence charSequence) {
        this.f1933a = view;
        this.f1934b = charSequence;
        this.f1935c = f4.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f1933a.removeCallbacks(this.f1936d);
    }

    private void c() {
        this.f1942j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f1933a.postDelayed(this.f1936d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(o1 o1Var) {
        o1 o1Var2 = f1931o;
        if (o1Var2 != null) {
            o1Var2.b();
        }
        f1931o = o1Var;
        if (o1Var != null) {
            o1Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        o1 o1Var = f1931o;
        if (o1Var != null && o1Var.f1933a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new o1(view, charSequence);
            return;
        }
        o1 o1Var2 = f1932p;
        if (o1Var2 != null && o1Var2.f1933a == view) {
            o1Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f1942j && Math.abs(x7 - this.f1938f) <= this.f1935c && Math.abs(y7 - this.f1939g) <= this.f1935c) {
            return false;
        }
        this.f1938f = x7;
        this.f1939g = y7;
        this.f1942j = false;
        return true;
    }

    void d() {
        if (f1932p == this) {
            f1932p = null;
            p1 p1Var = this.f1940h;
            if (p1Var != null) {
                p1Var.c();
                this.f1940h = null;
                c();
                this.f1933a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e(f1927k, "sActiveHandler.mPopup == null");
            }
        }
        if (f1931o == this) {
            g(null);
        }
        this.f1933a.removeCallbacks(this.f1937e);
    }

    void i(boolean z7) {
        long longPressTimeout;
        long j7;
        long j8;
        if (n2.O0(this.f1933a)) {
            g(null);
            o1 o1Var = f1932p;
            if (o1Var != null) {
                o1Var.d();
            }
            f1932p = this;
            this.f1941i = z7;
            p1 p1Var = new p1(this.f1933a.getContext());
            this.f1940h = p1Var;
            p1Var.e(this.f1933a, this.f1938f, this.f1939g, this.f1941i, this.f1934b);
            this.f1933a.addOnAttachStateChangeListener(this);
            if (this.f1941i) {
                j8 = f1928l;
            } else {
                if ((n2.C0(this.f1933a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = f1930n;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j7 = f1929m;
                }
                j8 = j7 - longPressTimeout;
            }
            this.f1933a.removeCallbacks(this.f1937e);
            this.f1933a.postDelayed(this.f1937e, j8);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1940h != null && this.f1941i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1933a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f1933a.isEnabled() && this.f1940h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1938f = view.getWidth() / 2;
        this.f1939g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
