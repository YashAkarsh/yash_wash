package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class a extends g {

    @m0
    private final Class<?> Q;
    private final int R;

    public a(@m0 Context context, @m0 Class<?> cls, int i7) {
        super(context);
        this.Q = cls;
        this.R = i7;
    }

    @Override // androidx.appcompat.view.menu.g
    @m0
    protected MenuItem a(int i7, int i8, int i9, @m0 CharSequence charSequence) {
        if (size() + 1 <= this.R) {
            m0();
            MenuItem menuItemA = super.a(i7, i8, i9, charSequence);
            if (menuItemA instanceof j) {
                ((j) menuItemA).w(true);
            }
            l0();
            return menuItemA;
        }
        String simpleName = this.Q.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.R + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    @m0
    public SubMenu addSubMenu(int i7, int i8, int i9, @m0 CharSequence charSequence) {
        throw new UnsupportedOperationException(this.Q.getSimpleName() + " does not support submenus");
    }

    public int n0() {
        return this.R;
    }
}
