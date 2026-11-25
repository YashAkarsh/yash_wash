package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n2;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f16968k = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private Runnable f16969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f16970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private VelocityTracker f16975j;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f16976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f16977b;

        a(CoordinatorLayout coordinatorLayout, V v7) {
            this.f16976a = coordinatorLayout;
            this.f16977b = v7;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f16977b == null || (overScroller = HeaderBehavior.this.f16970e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.V(this.f16976a, this.f16977b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.X(this.f16976a, this.f16977b, headerBehavior.f16970e.getCurrY());
            n2.p1(this.f16977b, this);
        }
    }

    public HeaderBehavior() {
        this.f16972g = -1;
        this.f16974i = -1;
    }

    private void Q() {
        if (this.f16975j == null) {
            this.f16975j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean E(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
        boolean z7;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f16975j;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f16975j.computeCurrentVelocity(1000);
                R(coordinatorLayout, v7, -T(v7), 0, this.f16975j.getYVelocity(this.f16972g));
                z7 = true;
            }
            this.f16971f = false;
            this.f16972g = -1;
            velocityTracker = this.f16975j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f16975j = null;
            }
            velocityTracker2 = this.f16975j;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            if (this.f16971f) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f16972g);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            int i7 = this.f16973h - y7;
            this.f16973h = y7;
            W(coordinatorLayout, v7, i7, S(v7), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i8 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f16972g = motionEvent.getPointerId(i8);
                this.f16973h = (int) (motionEvent.getY(i8) + 0.5f);
            }
        }
        z7 = false;
        velocityTracker2 = this.f16975j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f16971f || z7;
        z7 = false;
        this.f16971f = false;
        this.f16972g = -1;
        velocityTracker = this.f16975j;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f16975j = null;
        }
        velocityTracker2 = this.f16975j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f16971f) {
            return true;
        }
    }

    boolean P(V v7) {
        return false;
    }

    final boolean R(CoordinatorLayout coordinatorLayout, @m0 V v7, int i7, int i8, float f8) {
        Runnable runnable = this.f16969d;
        if (runnable != null) {
            v7.removeCallbacks(runnable);
            this.f16969d = null;
        }
        if (this.f16970e == null) {
            this.f16970e = new OverScroller(v7.getContext());
        }
        this.f16970e.fling(0, H(), 0, Math.round(f8), 0, 0, i7, i8);
        if (!this.f16970e.computeScrollOffset()) {
            V(coordinatorLayout, v7);
            return false;
        }
        a aVar = new a(coordinatorLayout, v7);
        this.f16969d = aVar;
        n2.p1(v7, aVar);
        return true;
    }

    int S(@m0 V v7) {
        return -v7.getHeight();
    }

    int T(@m0 V v7) {
        return v7.getHeight();
    }

    int U() {
        return H();
    }

    void V(CoordinatorLayout coordinatorLayout, V v7) {
    }

    final int W(CoordinatorLayout coordinatorLayout, V v7, int i7, int i8, int i9) {
        return Y(coordinatorLayout, v7, U() - i7, i8, i9);
    }

    int X(CoordinatorLayout coordinatorLayout, V v7, int i7) {
        return Y(coordinatorLayout, v7, i7, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int Y(CoordinatorLayout coordinatorLayout, V v7, int i7, int i8, int i9) {
        int iE;
        int iH = H();
        if (i8 == 0 || iH < i8 || iH > i9 || iH == (iE = m.a.e(i7, i8, i9))) {
            return 0;
        }
        N(iE);
        return iH - iE;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f16974i < 0) {
            this.f16974i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f16971f) {
            int i7 = this.f16972g;
            if (i7 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i7)) == -1) {
                return false;
            }
            int y7 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y7 - this.f16973h) > this.f16974i) {
                this.f16973h = y7;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f16972g = -1;
            int x7 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            boolean z7 = P(v7) && coordinatorLayout.G(v7, x7, y8);
            this.f16971f = z7;
            if (z7) {
                this.f16973h = y8;
                this.f16972g = motionEvent.getPointerId(0);
                Q();
                OverScroller overScroller = this.f16970e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f16970e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f16975j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16972g = -1;
        this.f16974i = -1;
    }
}
