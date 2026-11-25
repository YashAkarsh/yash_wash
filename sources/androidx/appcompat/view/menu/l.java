package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import c.m0;
import c.o0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements q, n, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f1248a;

    l() {
    }

    protected static boolean B(g gVar) {
        int size = gVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = gVar.getItem(i7);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static f C(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (f) listAdapter;
    }

    protected static int s(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i7) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i8 = 0;
        int i9 = 0;
        View view = null;
        for (int i10 = 0; i10 < count; i10++) {
            int itemViewType = listAdapter.getItemViewType(i10);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i10, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i7) {
                return i7;
            }
            if (measuredWidth > i8) {
                i8 = measuredWidth;
            }
        }
        return i8;
    }

    public abstract void A(int i7);

    @Override // androidx.appcompat.view.menu.n
    public int a() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean g(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean h(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void j(@m0 Context context, @o0 g gVar) {
    }

    @Override // androidx.appcompat.view.menu.n
    public o n(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C(listAdapter).f1193a.P((MenuItem) listAdapter.getItem(i7), this, q() ? 0 : 4);
    }

    public abstract void p(g gVar);

    protected boolean q() {
        return true;
    }

    public Rect r() {
        return this.f1248a;
    }

    public abstract void t(View view);

    public void u(Rect rect) {
        this.f1248a = rect;
    }

    public abstract void v(boolean z7);

    public abstract void w(int i7);

    public abstract void x(int i7);

    public abstract void y(PopupWindow.OnDismissListener onDismissListener);

    public abstract void z(boolean z7);
}
