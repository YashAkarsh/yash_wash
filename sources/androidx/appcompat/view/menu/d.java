package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.t0;
import androidx.core.view.n0;
import androidx.core.view.n2;
import c.b1;
import c.m0;
import c.o0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d extends l implements n, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int B = R.layout.abc_cascading_menu_item_layout;
    static final int C = 0;
    static final int D = 1;
    static final int E = 200;
    boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Handler f1149g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f1157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f1158p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f1161s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1162t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1163u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f1165w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private n.a f1166x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ViewTreeObserver f1167y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1168z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f1150h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final List<C0023d> f1151i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1152j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1153k = new b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final t0 f1154l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1155m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1156n = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1164v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1159q = H();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.c() || d.this.f1151i.size() <= 0 || d.this.f1151i.get(0).f1176a.L()) {
                return;
            }
            View view = d.this.f1158p;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator<C0023d> it = d.this.f1151i.iterator();
            while (it.hasNext()) {
                it.next().f1176a.b();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.f1167y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.f1167y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.f1167y.removeGlobalOnLayoutListener(dVar.f1152j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements t0 {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0023d f1172a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f1173b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ g f1174c;

            a(C0023d c0023d, MenuItem menuItem, g gVar) {
                this.f1172a = c0023d;
                this.f1173b = menuItem;
                this.f1174c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0023d c0023d = this.f1172a;
                if (c0023d != null) {
                    d.this.A = true;
                    c0023d.f1177b.f(false);
                    d.this.A = false;
                }
                if (this.f1173b.isEnabled() && this.f1173b.hasSubMenu()) {
                    this.f1174c.O(this.f1173b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.t0
        public void e(@m0 g gVar, @m0 MenuItem menuItem) {
            d.this.f1149g.removeCallbacksAndMessages(null);
            int size = d.this.f1151i.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                } else if (gVar == d.this.f1151i.get(i7).f1177b) {
                    break;
                } else {
                    i7++;
                }
            }
            if (i7 == -1) {
                return;
            }
            int i8 = i7 + 1;
            d.this.f1149g.postAtTime(new a(i8 < d.this.f1151i.size() ? d.this.f1151i.get(i8) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.t0
        public void h(@m0 g gVar, @m0 MenuItem menuItem) {
            d.this.f1149g.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    private static class C0023d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f1176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f1177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1178c;

        public C0023d(@m0 MenuPopupWindow menuPopupWindow, @m0 g gVar, int i7) {
            this.f1176a = menuPopupWindow;
            this.f1177b = gVar;
            this.f1178c = i7;
        }

        public ListView a() {
            return this.f1176a.l();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public d(@m0 Context context, @m0 View view, @c.f int i7, @b1 int i8, boolean z7) {
        this.f1144b = context;
        this.f1157o = view;
        this.f1146d = i7;
        this.f1147e = i8;
        this.f1148f = z7;
        Resources resources = context.getResources();
        this.f1145c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1149g = new Handler();
    }

    private MenuPopupWindow D() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f1144b, null, this.f1146d, this.f1147e);
        menuPopupWindow.r0(this.f1154l);
        menuPopupWindow.f0(this);
        menuPopupWindow.e0(this);
        menuPopupWindow.S(this.f1157o);
        menuPopupWindow.W(this.f1156n);
        menuPopupWindow.d0(true);
        menuPopupWindow.a0(2);
        return menuPopupWindow;
    }

    private int E(@m0 g gVar) {
        int size = this.f1151i.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (gVar == this.f1151i.get(i7).f1177b) {
                return i7;
            }
        }
        return -1;
    }

    private MenuItem F(@m0 g gVar, @m0 g gVar2) {
        int size = gVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = gVar.getItem(i7);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @o0
    private View G(@m0 C0023d c0023d, @m0 g gVar) {
        f fVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemF = F(c0023d.f1177b, gVar);
        if (menuItemF == null) {
            return null;
        }
        ListView listViewA = c0023d.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i7 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            headersCount = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i7 >= count) {
                i7 = -1;
                break;
            }
            if (menuItemF == fVar.getItem(i7)) {
                break;
            }
            i7++;
        }
        if (i7 != -1 && (firstVisiblePosition = (i7 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int H() {
        return n2.Z(this.f1157o) == 1 ? 0 : 1;
    }

    private int I(int i7) {
        List<C0023d> list = this.f1151i;
        ListView listViewA = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1158p.getWindowVisibleDisplayFrame(rect);
        if (this.f1159q == 1) {
            return (iArr[0] + listViewA.getWidth()) + i7 > rect.right ? 0 : 1;
        }
        return iArr[0] - i7 < 0 ? 1 : 0;
    }

    private void J(@m0 g gVar) {
        C0023d c0023d;
        View viewG;
        int i7;
        int i8;
        int i9;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1144b);
        f fVar = new f(gVar, layoutInflaterFrom, this.f1148f, B);
        if (!c() && this.f1164v) {
            fVar.e(true);
        } else if (c()) {
            fVar.e(l.B(gVar));
        }
        int iS = l.s(fVar, null, this.f1144b, this.f1145c);
        MenuPopupWindow menuPopupWindowD = D();
        menuPopupWindowD.q(fVar);
        menuPopupWindowD.U(iS);
        menuPopupWindowD.W(this.f1156n);
        if (this.f1151i.size() > 0) {
            List<C0023d> list = this.f1151i;
            c0023d = list.get(list.size() - 1);
            viewG = G(c0023d, gVar);
        } else {
            c0023d = null;
            viewG = null;
        }
        if (viewG != null) {
            menuPopupWindowD.s0(false);
            menuPopupWindowD.p0(null);
            int I = I(iS);
            boolean z7 = I == 1;
            this.f1159q = I;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowD.S(viewG);
                i8 = 0;
                i7 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1157o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewG.getLocationOnScreen(iArr2);
                if ((this.f1156n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1157o.getWidth();
                    iArr2[0] = iArr2[0] + viewG.getWidth();
                }
                i7 = iArr2[0] - iArr[0];
                i8 = iArr2[1] - iArr[1];
            }
            if ((this.f1156n & 5) == 5) {
                if (z7) {
                    i9 = i7 + iS;
                } else {
                    iS = viewG.getWidth();
                    i9 = i7 - iS;
                }
            } else if (z7) {
                iS = viewG.getWidth();
                i9 = i7 + iS;
            } else {
                i9 = i7 - iS;
            }
            menuPopupWindowD.f(i9);
            menuPopupWindowD.h0(true);
            menuPopupWindowD.k(i8);
        } else {
            if (this.f1160r) {
                menuPopupWindowD.f(this.f1162t);
            }
            if (this.f1161s) {
                menuPopupWindowD.k(this.f1163u);
            }
            menuPopupWindowD.X(r());
        }
        this.f1151i.add(new C0023d(menuPopupWindowD, gVar, this.f1159q));
        menuPopupWindowD.b();
        ListView listViewL = menuPopupWindowD.l();
        listViewL.setOnKeyListener(this);
        if (c0023d == null && this.f1165w && gVar.A() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewL, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.A());
            listViewL.addHeaderView(frameLayout, null, false);
            menuPopupWindowD.b();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void A(int i7) {
        this.f1161s = true;
        this.f1163u = i7;
    }

    @Override // androidx.appcompat.view.menu.q
    public void b() {
        if (c()) {
            return;
        }
        Iterator<g> it = this.f1150h.iterator();
        while (it.hasNext()) {
            J(it.next());
        }
        this.f1150h.clear();
        View view = this.f1157o;
        this.f1158p = view;
        if (view != null) {
            boolean z7 = this.f1167y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1167y = viewTreeObserver;
            if (z7) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1152j);
            }
            this.f1158p.addOnAttachStateChangeListener(this.f1153k);
        }
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean c() {
        return this.f1151i.size() > 0 && this.f1151i.get(0).f1176a.c();
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(g gVar, boolean z7) {
        int iE = E(gVar);
        if (iE < 0) {
            return;
        }
        int i7 = iE + 1;
        if (i7 < this.f1151i.size()) {
            this.f1151i.get(i7).f1177b.f(false);
        }
        C0023d c0023dRemove = this.f1151i.remove(iE);
        c0023dRemove.f1177b.S(this);
        if (this.A) {
            c0023dRemove.f1176a.q0(null);
            c0023dRemove.f1176a.T(0);
        }
        c0023dRemove.f1176a.dismiss();
        int size = this.f1151i.size();
        if (size > 0) {
            this.f1159q = this.f1151i.get(size - 1).f1178c;
        } else {
            this.f1159q = H();
        }
        if (size != 0) {
            if (z7) {
                this.f1151i.get(0).f1177b.f(false);
                return;
            }
            return;
        }
        dismiss();
        n.a aVar = this.f1166x;
        if (aVar != null) {
            aVar.d(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1167y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1167y.removeGlobalOnLayoutListener(this.f1152j);
            }
            this.f1167y = null;
        }
        this.f1158p.removeOnAttachStateChangeListener(this.f1153k);
        this.f1168z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.q
    public void dismiss() {
        int size = this.f1151i.size();
        if (size > 0) {
            C0023d[] c0023dArr = (C0023d[]) this.f1151i.toArray(new C0023d[size]);
            for (int i7 = size - 1; i7 >= 0; i7--) {
                C0023d c0023d = c0023dArr[i7];
                if (c0023d.f1176a.c()) {
                    c0023d.f1176a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        Iterator<C0023d> it = this.f1151i.iterator();
        while (it.hasNext()) {
            l.C(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(n.a aVar) {
        this.f1166x = aVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.q
    public ListView l() {
        if (this.f1151i.isEmpty()) {
            return null;
        }
        List<C0023d> list = this.f1151i;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean m(s sVar) {
        for (C0023d c0023d : this.f1151i) {
            if (sVar == c0023d.f1177b) {
                c0023d.a().requestFocus();
                return true;
            }
        }
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        p(sVar);
        n.a aVar = this.f1166x;
        if (aVar != null) {
            aVar.e(sVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.n
    public Parcelable o() {
        return null;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0023d c0023d;
        int size = this.f1151i.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                c0023d = null;
                break;
            }
            c0023d = this.f1151i.get(i7);
            if (!c0023d.f1176a.c()) {
                break;
            } else {
                i7++;
            }
        }
        if (c0023d != null) {
            c0023d.f1177b.f(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i7, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i7 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public void p(g gVar) {
        gVar.c(this, this.f1144b);
        if (c()) {
            J(gVar);
        } else {
            this.f1150h.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    protected boolean q() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void t(@m0 View view) {
        if (this.f1157o != view) {
            this.f1157o = view;
            this.f1156n = n0.d(this.f1155m, n2.Z(view));
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void v(boolean z7) {
        this.f1164v = z7;
    }

    @Override // androidx.appcompat.view.menu.l
    public void w(int i7) {
        if (this.f1155m != i7) {
            this.f1155m = i7;
            this.f1156n = n0.d(i7, n2.Z(this.f1157o));
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void x(int i7) {
        this.f1160r = true;
        this.f1162t = i7;
    }

    @Override // androidx.appcompat.view.menu.l
    public void y(PopupWindow.OnDismissListener onDismissListener) {
        this.f1168z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.l
    public void z(boolean z7) {
        this.f1165w = z7;
    }
}
