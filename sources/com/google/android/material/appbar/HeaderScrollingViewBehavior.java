package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import c.m0;
import c.o0;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f16979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f16980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16982g;

    public HeaderScrollingViewBehavior() {
        this.f16979d = new Rect();
        this.f16980e = new Rect();
        this.f16981f = 0;
    }

    private static int V(int i7) {
        return i7 == 0 ? BadgeDrawable.f16995r : i7;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void K(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, int i7) {
        View viewP = P(coordinatorLayout.w(view));
        if (viewP == null) {
            super.K(coordinatorLayout, view, i7);
            this.f16981f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f16979d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewP.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewP.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        w5 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && n2.U(coordinatorLayout) && !n2.U(view)) {
            rect.left += lastWindowInsets.p();
            rect.right -= lastWindowInsets.q();
        }
        Rect rect2 = this.f16980e;
        n0.b(V(fVar.f5009c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i7);
        int iQ = Q(viewP);
        view.layout(rect2.left, rect2.top - iQ, rect2.right, rect2.bottom - iQ);
        this.f16981f = rect2.top - viewP.getBottom();
    }

    @o0
    abstract View P(List<View> list);

    final int Q(View view) {
        if (this.f16982g == 0) {
            return 0;
        }
        float fR = R(view);
        int i7 = this.f16982g;
        return m.a.e((int) (fR * i7), 0, i7);
    }

    float R(View view) {
        return 1.0f;
    }

    public final int S() {
        return this.f16982g;
    }

    int T(@m0 View view) {
        return view.getMeasuredHeight();
    }

    final int U() {
        return this.f16981f;
    }

    public final void W(int i7) {
        this.f16982g = i7;
    }

    protected boolean X() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean n(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, int i7, int i8, int i9, int i10) {
        View viewP;
        w5 lastWindowInsets;
        int i11 = view.getLayoutParams().height;
        if ((i11 != -1 && i11 != -2) || (viewP = P(coordinatorLayout.w(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i9);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (n2.U(viewP) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.r() + lastWindowInsets.o();
        }
        int iT = size + T(viewP);
        int measuredHeight = viewP.getMeasuredHeight();
        if (X()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iT -= measuredHeight;
        }
        coordinatorLayout.O(view, i7, i8, View.MeasureSpec.makeMeasureSpec(iT, i11 == -1 ? 1073741824 : Integer.MIN_VALUE), i10);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16979d = new Rect();
        this.f16980e = new Rect();
        this.f16981f = 0;
    }
}
