package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
final class r extends l implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, n, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f1264v = R.layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f1266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f1267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f1270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final MenuPopupWindow f1272i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f1276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    View f1277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private n.a f1278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ViewTreeObserver f1279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f1280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f1281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1282s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1284u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1273j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1274k = new b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1283t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!r.this.c() || r.this.f1272i.L()) {
                return;
            }
            View view = r.this.f1277n;
            if (view == null || !view.isShown()) {
                r.this.dismiss();
            } else {
                r.this.f1272i.b();
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
            ViewTreeObserver viewTreeObserver = r.this.f1279p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    r.this.f1279p = view.getViewTreeObserver();
                }
                r rVar = r.this;
                rVar.f1279p.removeGlobalOnLayoutListener(rVar.f1273j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public r(Context context, g gVar, View view, int i7, int i8, boolean z7) {
        this.f1265b = context;
        this.f1266c = gVar;
        this.f1268e = z7;
        this.f1267d = new f(gVar, LayoutInflater.from(context), z7, f1264v);
        this.f1270g = i7;
        this.f1271h = i8;
        Resources resources = context.getResources();
        this.f1269f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1276m = view;
        this.f1272i = new MenuPopupWindow(context, null, i7, i8);
        gVar.c(this, context);
    }

    private boolean D() {
        View view;
        if (c()) {
            return true;
        }
        if (this.f1280q || (view = this.f1276m) == null) {
            return false;
        }
        this.f1277n = view;
        this.f1272i.e0(this);
        this.f1272i.f0(this);
        this.f1272i.d0(true);
        View view2 = this.f1277n;
        boolean z7 = this.f1279p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1279p = viewTreeObserver;
        if (z7) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1273j);
        }
        view2.addOnAttachStateChangeListener(this.f1274k);
        this.f1272i.S(view2);
        this.f1272i.W(this.f1283t);
        if (!this.f1281r) {
            this.f1282s = l.s(this.f1267d, null, this.f1265b, this.f1269f);
            this.f1281r = true;
        }
        this.f1272i.U(this.f1282s);
        this.f1272i.a0(2);
        this.f1272i.X(r());
        this.f1272i.b();
        ListView listViewL = this.f1272i.l();
        listViewL.setOnKeyListener(this);
        if (this.f1284u && this.f1266c.A() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1265b).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewL, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f1266c.A());
            }
            frameLayout.setEnabled(false);
            listViewL.addHeaderView(frameLayout, null, false);
        }
        this.f1272i.q(this.f1267d);
        this.f1272i.b();
        return true;
    }

    @Override // androidx.appcompat.view.menu.l
    public void A(int i7) {
        this.f1272i.k(i7);
    }

    @Override // androidx.appcompat.view.menu.q
    public void b() {
        if (!D()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean c() {
        return !this.f1280q && this.f1272i.c();
    }

    @Override // androidx.appcompat.view.menu.n
    public void d(g gVar, boolean z7) {
        if (gVar != this.f1266c) {
            return;
        }
        dismiss();
        n.a aVar = this.f1278o;
        if (aVar != null) {
            aVar.d(gVar, z7);
        }
    }

    @Override // androidx.appcompat.view.menu.q
    public void dismiss() {
        if (c()) {
            this.f1272i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void e(boolean z7) {
        this.f1281r = false;
        f fVar = this.f1267d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public void i(n.a aVar) {
        this.f1278o = aVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void k(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.q
    public ListView l() {
        return this.f1272i.l();
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean m(s sVar) {
        if (sVar.hasVisibleItems()) {
            m mVar = new m(this.f1265b, sVar, this.f1277n, this.f1268e, this.f1270g, this.f1271h);
            mVar.a(this.f1278o);
            mVar.i(l.B(sVar));
            mVar.k(this.f1275l);
            this.f1275l = null;
            this.f1266c.f(false);
            int iD = this.f1272i.d();
            int iO = this.f1272i.o();
            if ((Gravity.getAbsoluteGravity(this.f1283t, n2.Z(this.f1276m)) & 7) == 5) {
                iD += this.f1276m.getWidth();
            }
            if (mVar.p(iD, iO)) {
                n.a aVar = this.f1278o;
                if (aVar == null) {
                    return true;
                }
                aVar.e(sVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public Parcelable o() {
        return null;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1280q = true;
        this.f1266c.close();
        ViewTreeObserver viewTreeObserver = this.f1279p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1279p = this.f1277n.getViewTreeObserver();
            }
            this.f1279p.removeGlobalOnLayoutListener(this.f1273j);
            this.f1279p = null;
        }
        this.f1277n.removeOnAttachStateChangeListener(this.f1274k);
        PopupWindow.OnDismissListener onDismissListener = this.f1275l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
    }

    @Override // androidx.appcompat.view.menu.l
    public void t(View view) {
        this.f1276m = view;
    }

    @Override // androidx.appcompat.view.menu.l
    public void v(boolean z7) {
        this.f1267d.e(z7);
    }

    @Override // androidx.appcompat.view.menu.l
    public void w(int i7) {
        this.f1283t = i7;
    }

    @Override // androidx.appcompat.view.menu.l
    public void x(int i7) {
        this.f1272i.f(i7);
    }

    @Override // androidx.appcompat.view.menu.l
    public void y(PopupWindow.OnDismissListener onDismissListener) {
        this.f1275l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.l
    public void z(boolean z7) {
        this.f1284u = z7;
    }
}
