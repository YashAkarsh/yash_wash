package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.view.n0;
import androidx.core.view.n2;
import c.b1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class m implements i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f1249m = 48;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f1252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f1255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n.a f1258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l f1259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1261l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m.this.g();
        }
    }

    @t0(17)
    static class b {
        private b() {
        }

        @c.t
        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public m(@m0 Context context, @m0 g gVar) {
        this(context, gVar, null, false, R.attr.popupMenuStyle, 0);
    }

    @m0
    private l b() {
        Display defaultDisplay = ((WindowManager) this.f1250a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        b.a(defaultDisplay, point);
        l dVar = Math.min(point.x, point.y) >= this.f1250a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new d(this.f1250a, this.f1255f, this.f1253d, this.f1254e, this.f1252c) : new r(this.f1250a, this.f1251b, this.f1255f, this.f1253d, this.f1254e, this.f1252c);
        dVar.p(this.f1251b);
        dVar.y(this.f1261l);
        dVar.t(this.f1255f);
        dVar.i(this.f1258i);
        dVar.v(this.f1257h);
        dVar.w(this.f1256g);
        return dVar;
    }

    private void n(int i7, int i8, boolean z7, boolean z8) {
        l lVarE = e();
        lVarE.z(z8);
        if (z7) {
            if ((n0.d(this.f1256g, n2.Z(this.f1255f)) & 7) == 5) {
                i7 -= this.f1255f.getWidth();
            }
            lVarE.x(i7);
            lVarE.A(i8);
            int i9 = (int) ((this.f1250a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            lVarE.u(new Rect(i7 - i9, i8 - i9, i7 + i9, i8 + i9));
        }
        lVarE.b();
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(@o0 n.a aVar) {
        this.f1258i = aVar;
        l lVar = this.f1259j;
        if (lVar != null) {
            lVar.i(aVar);
        }
    }

    public int c() {
        return this.f1256g;
    }

    public ListView d() {
        return e().l();
    }

    @Override // androidx.appcompat.view.menu.i
    public void dismiss() {
        if (f()) {
            this.f1259j.dismiss();
        }
    }

    @x0({x0.a.LIBRARY})
    @m0
    public l e() {
        if (this.f1259j == null) {
            this.f1259j = b();
        }
        return this.f1259j;
    }

    public boolean f() {
        l lVar = this.f1259j;
        return lVar != null && lVar.c();
    }

    protected void g() {
        this.f1259j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1260k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void h(@m0 View view) {
        this.f1255f = view;
    }

    public void i(boolean z7) {
        this.f1257h = z7;
        l lVar = this.f1259j;
        if (lVar != null) {
            lVar.v(z7);
        }
    }

    public void j(int i7) {
        this.f1256g = i7;
    }

    public void k(@o0 PopupWindow.OnDismissListener onDismissListener) {
        this.f1260k = onDismissListener;
    }

    public void l() {
        if (!o()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m(int i7, int i8) {
        if (!p(i7, i8)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean o() {
        if (f()) {
            return true;
        }
        if (this.f1255f == null) {
            return false;
        }
        n(0, 0, false, false);
        return true;
    }

    public boolean p(int i7, int i8) {
        if (f()) {
            return true;
        }
        if (this.f1255f == null) {
            return false;
        }
        n(i7, i8, true, true);
        return true;
    }

    public m(@m0 Context context, @m0 g gVar, @m0 View view) {
        this(context, gVar, view, false, R.attr.popupMenuStyle, 0);
    }

    public m(@m0 Context context, @m0 g gVar, @m0 View view, boolean z7, @c.f int i7) {
        this(context, gVar, view, z7, i7, 0);
    }

    public m(@m0 Context context, @m0 g gVar, @m0 View view, boolean z7, @c.f int i7, @b1 int i8) {
        this.f1256g = n0.f6717b;
        this.f1261l = new a();
        this.f1250a = context;
        this.f1251b = gVar;
        this.f1255f = view;
        this.f1252c = z7;
        this.f1253d = i7;
        this.f1254e = i8;
    }
}
