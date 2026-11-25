package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.h1;
import c.h0;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f17987o = 49;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f17988p = 7;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f17989q = 49;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f17990m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private View f17991n;

    public NavigationRailView(@m0 Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean m() {
        View view = this.f17991n;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int n(int i7) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i7) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i7;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i7), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    @o0
    public View getHeaderView() {
        return this.f17991n;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void j(@h0 int i7) {
        k(LayoutInflater.from(getContext()).inflate(i7, (ViewGroup) this, false));
    }

    public void k(@m0 View view) {
        o();
        this.f17991n = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f17990m;
        addView(view, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @x0({x0.a.LIBRARY_GROUP})
    @m0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView e(@m0 Context context) {
        return new NavigationRailMenuView(context);
    }

    public void o() {
        View view = this.f17991n;
        if (view != null) {
            removeView(view);
            this.f17991n = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i11 = 0;
        if (m()) {
            int bottom = this.f17991n.getBottom() + this.f17990m;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i11 = bottom - top;
            }
        } else if (navigationRailMenuView.q()) {
            i11 = this.f17990m;
        }
        if (i11 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i11, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i11);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        int iN = n(i7);
        super.onMeasure(iN, i8);
        if (m()) {
            measureChild(getNavigationRailMenuView(), iN, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f17991n.getMeasuredHeight()) - this.f17990m, Integer.MIN_VALUE));
        }
    }

    public void setMenuGravity(int i7) {
        getNavigationRailMenuView().setMenuGravity(i7);
    }

    public NavigationRailView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f17990m = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        h1 h1VarK = n.k(getContext(), attributeSet, R.styleable.NavigationRailView, i7, i8, new int[0]);
        int iU = h1VarK.u(R.styleable.NavigationRailView_headerLayout, 0);
        if (iU != 0) {
            j(iU);
        }
        setMenuGravity(h1VarK.o(R.styleable.NavigationRailView_menuGravity, 49));
        h1VarK.I();
    }
}
