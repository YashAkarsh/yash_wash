package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import c.h0;
import c.m0;
import c.p;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
final class a extends NavigationBarItemView {
    public a(@m0 Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @p
    protected int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @h0
    protected int getItemLayoutResId() {
        return R.layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (View.MeasureSpec.getMode(i8) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i8)), i8, 0));
        }
    }
}
