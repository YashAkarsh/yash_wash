package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.h1;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements g.b, o, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f1094c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1096b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(j jVar) {
        return this.f1095a.O(jVar, 0);
    }

    @Override // androidx.appcompat.view.menu.o
    public void e(g gVar) {
        this.f1095a = gVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public int getWindowAnimations() {
        return this.f1096b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
        a((j) getAdapter().getItem(i7));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        h1 h1VarG = h1.G(context, attributeSet, f1094c, i7, 0);
        if (h1VarG.C(0)) {
            setBackgroundDrawable(h1VarG.h(0));
        }
        if (h1VarG.C(1)) {
            setDivider(h1VarG.h(1));
        }
        h1VarG.I();
    }
}
