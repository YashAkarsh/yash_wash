package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.h1;
import androidx.core.content.d;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f17118m = 5;

    @Deprecated
    public interface a extends NavigationBarView.d {
    }

    @Deprecated
    public interface b extends NavigationBarView.e {
    }

    public BottomNavigationView(@m0 Context context) {
        this(context, null);
    }

    private void j(@m0 Context context) {
        View view = new View(context);
        view.setBackgroundColor(d.f(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private boolean l() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @x0({x0.a.LIBRARY_GROUP})
    @m0
    protected NavigationBarMenuView e(@m0 Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean k() {
        return ((BottomNavigationMenuView) getMenuView()).q();
    }

    public void setItemHorizontalTranslationEnabled(boolean z7) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.q() != z7) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z7);
            getPresenter().e(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@o0 a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@o0 b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        Context context2 = getContext();
        h1 h1VarK = n.k(context2, attributeSet, R.styleable.BottomNavigationView, i7, i8, new int[0]);
        setItemHorizontalTranslationEnabled(h1VarK.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        h1VarK.I();
        if (l()) {
            j(context2);
        }
    }
}
