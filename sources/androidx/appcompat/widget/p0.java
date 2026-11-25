package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public abstract class p0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f1946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f1947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f1948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f1951i = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = p0.this.f1946d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.e();
        }
    }

    public p0(View view) {
        this.f1946d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1943a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1944b = tapTimeout;
        this.f1945c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1948f;
        if (runnable != null) {
            this.f1946d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1947e;
        if (runnable2 != null) {
            this.f1946d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        m0 m0Var;
        View view = this.f1946d;
        androidx.appcompat.view.menu.q qVarB = b();
        if (qVarB == null || !qVarB.c() || (m0Var = (m0) qVarB.l()) == null || !m0Var.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(m0Var, motionEventObtainNoHistory);
        boolean zF = m0Var.f(motionEventObtainNoHistory, this.f1950h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zF && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f1946d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1950h = motionEvent.getPointerId(0);
            if (this.f1947e == null) {
                this.f1947e = new a();
            }
            view.postDelayed(this.f1947e, this.f1944b);
            if (this.f1948f == null) {
                this.f1948f = new b();
            }
            view.postDelayed(this.f1948f, this.f1945c);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f1950h);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f1943a)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
            a();
        }
        return false;
    }

    private static boolean h(View view, float f8, float f9, float f10) {
        float f11 = -f10;
        return f8 >= f11 && f9 >= f11 && f8 < ((float) (view.getRight() - view.getLeft())) + f10 && f9 < ((float) (view.getBottom() - view.getTop())) + f10;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1951i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1951i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.q b();

    protected boolean c() {
        androidx.appcompat.view.menu.q qVarB = b();
        if (qVarB == null || qVarB.c()) {
            return true;
        }
        qVarB.b();
        return true;
    }

    protected boolean d() {
        androidx.appcompat.view.menu.q qVarB = b();
        if (qVarB == null || !qVarB.c()) {
            return true;
        }
        qVarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f1946d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1949g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        boolean z8 = this.f1949g;
        if (z8) {
            z7 = f(motionEvent) || !d();
        } else {
            z7 = g(motionEvent) && c();
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1946d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1949g = z7;
        return z7 || z8;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1949g = false;
        this.f1950h = -1;
        Runnable runnable = this.f1947e;
        if (runnable != null) {
            this.f1946d.removeCallbacks(runnable);
        }
    }
}
