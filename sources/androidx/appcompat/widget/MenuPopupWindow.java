package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow extends ListPopupWindow implements t0 {
    private static final String U = "MenuPopupWindow";
    private static Method V;
    private t0 T;

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends m0 {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final int f1562q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final int f1563r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private t0 f1564s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private MenuItem f1565t;

        @c.t0(17)
        static class a {
            private a() {
            }

            @c.t
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z7) {
            super(context, z7);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f1562q = 21;
                this.f1563r = 22;
            } else {
                this.f1562q = 22;
                this.f1563r = 21;
            }
        }

        @Override // androidx.appcompat.widget.m0
        public /* bridge */ /* synthetic */ int d(int i7, boolean z7) {
            return super.d(i7, z7);
        }

        @Override // androidx.appcompat.widget.m0
        public /* bridge */ /* synthetic */ int e(int i7, int i8, int i9, int i10, int i11) {
            return super.e(i7, i8, i9, i10, i11);
        }

        @Override // androidx.appcompat.widget.m0
        public /* bridge */ /* synthetic */ boolean f(MotionEvent motionEvent, int i7) {
            return super.f(motionEvent, i7);
        }

        @Override // androidx.appcompat.widget.m0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.m0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.m0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.m0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public void n() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.m0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.f fVar;
            int headersCount;
            int iPointToPosition;
            int i7;
            if (this.f1564s != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.j item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i7 = iPointToPosition - headersCount) < 0 || i7 >= fVar.getCount()) ? null : fVar.getItem(i7);
                MenuItem menuItem = this.f1565t;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.g gVarB = fVar.b();
                    if (menuItem != null) {
                        this.f1564s.h(gVarB, menuItem);
                    }
                    this.f1565t = item;
                    if (item != null) {
                        this.f1564s.e(gVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i7, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i7 == this.f1562q) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i7 != this.f1563r) {
                return super.onKeyDown(i7, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.f) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.f) adapter).b().f(false);
            return true;
        }

        @Override // androidx.appcompat.widget.m0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(t0 t0Var) {
            this.f1564s = t0Var;
        }

        @Override // androidx.appcompat.widget.m0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    @c.t0(23)
    static class a {
        private a() {
        }

        @c.t
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        @c.t
        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    @c.t0(29)
    static class b {
        private b() {
        }

        @c.t
        static void a(PopupWindow popupWindow, boolean z7) {
            popupWindow.setTouchModal(z7);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                V = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i(U, "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
    }

    @Override // androidx.appcompat.widget.t0
    public void e(@c.m0 androidx.appcompat.view.menu.g gVar, @c.m0 MenuItem menuItem) {
        t0 t0Var = this.T;
        if (t0Var != null) {
            t0Var.e(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.t0
    public void h(@c.m0 androidx.appcompat.view.menu.g gVar, @c.m0 MenuItem menuItem) {
        t0 t0Var = this.T;
        if (t0Var != null) {
            t0Var.h(gVar, menuItem);
        }
    }

    public void p0(Object obj) {
        a.a(this.F, (Transition) obj);
    }

    public void q0(Object obj) {
        a.b(this.F, (Transition) obj);
    }

    public void r0(t0 t0Var) {
        this.T = t0Var;
    }

    public void s0(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.F, z7);
            return;
        }
        Method method = V;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i(U, "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    @c.m0
    m0 u(Context context, boolean z7) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z7);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
