package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class f extends androidx.appcompat.view.menu.g {
    public f(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    @m0
    public SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        androidx.appcompat.view.menu.j jVar = (androidx.appcompat.view.menu.j) a(i7, i8, i9, charSequence);
        h hVar = new h(x(), this, jVar);
        jVar.A(hVar);
        return hVar;
    }
}
