package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class NavigationMenuView extends RecyclerView implements androidx.appcompat.view.menu.o {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.view.menu.o
    public void e(androidx.appcompat.view.menu.g gVar) {
    }

    @Override // androidx.appcompat.view.menu.o
    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
