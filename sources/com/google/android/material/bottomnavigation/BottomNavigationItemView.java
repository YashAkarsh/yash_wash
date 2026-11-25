package com.google.android.material.bottomnavigation;

import android.content.Context;
import c.h0;
import c.m0;
import c.p;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(@m0 Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @p
    protected int getItemDefaultMarginResId() {
        return R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @h0
    protected int getItemLayoutResId() {
        return R.layout.design_bottom_navigation_item;
    }
}
