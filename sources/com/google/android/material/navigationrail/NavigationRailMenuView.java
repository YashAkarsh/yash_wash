package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import c.m0;
import c.x0;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final FrameLayout.LayoutParams f17986x;

    public NavigationRailMenuView(@m0 Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f17986x = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int r(int i7, int i8, int i9) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i7), i8 / Math.max(1, i9)), 0);
    }

    private int s(View view, int i7, int i8) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i7, i8);
        return view.getMeasuredHeight();
    }

    private int t(int i7, int i8, int i9, View view) {
        r(i7, i8, i9);
        int iR = view == null ? r(i7, i8, i9) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iS = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != view) {
                iS += s(childAt, i7, iR);
            }
        }
        return iS;
    }

    private int u(int i7, int i8, int i9) {
        int iS;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iS = s(childAt, i7, r(i7, i8, i9));
            i8 -= iS;
            i9--;
        } else {
            iS = 0;
        }
        return iS + t(i7, i8, i9, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @m0
    protected NavigationBarItemView f(@m0 Context context) {
        return new a(context);
    }

    int getMenuGravity() {
        return this.f17986x.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        int i11 = i9 - i7;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                childAt.layout(0, i12, i11, measuredHeight);
                i12 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int size = View.MeasureSpec.getSize(i8);
        int size2 = getMenu().H().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i7), i7, 0), View.resolveSizeAndState((size2 <= 1 || !j(getLabelVisibilityMode(), size2)) ? t(i7, size, size2, null) : u(i7, size, size2), i8, 0));
    }

    boolean q() {
        return (this.f17986x.gravity & 112) == 48;
    }

    void setMenuGravity(int i7) {
        FrameLayout.LayoutParams layoutParams = this.f17986x;
        if (layoutParams.gravity != i7) {
            layoutParams.gravity = i7;
            setLayoutParams(layoutParams);
        }
    }
}
