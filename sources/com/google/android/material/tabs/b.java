package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import c.m0;
import c.o0;
import c.q;
import com.google.android.material.internal.v;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @q(unit = 0)
    private static final int f18577a = 24;

    b() {
    }

    static RectF a(TabLayout tabLayout, @o0 View view) {
        if (view == null) {
            return new RectF();
        }
        return (tabLayout.C() || !(view instanceof TabLayout.TabView)) ? new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : b((TabLayout.TabView) view, 24);
    }

    static RectF b(@m0 TabLayout.TabView tabView, @q(unit = 0) int i7) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int iE = (int) v.e(tabView.getContext(), i7);
        if (contentWidth < iE) {
            contentWidth = iE;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i8 = contentWidth / 2;
        return new RectF(left - i8, top - (contentHeight / 2), i8 + left, top + (left / 2));
    }

    void c(TabLayout tabLayout, View view, View view2, @c.v(from = 0.0d, to = 1.0d) float f8, @m0 Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        RectF rectFA2 = a(tabLayout, view2);
        drawable.setBounds(com.google.android.material.animation.a.c((int) rectFA.left, (int) rectFA2.left, f8), drawable.getBounds().top, com.google.android.material.animation.a.c((int) rectFA.right, (int) rectFA2.right, f8), drawable.getBounds().bottom);
    }

    void d(TabLayout tabLayout, View view, @m0 Drawable drawable) {
        RectF rectFA = a(tabLayout, view);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
    }
}
