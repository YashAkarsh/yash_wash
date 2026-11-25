package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class a1 extends androidx.core.view.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f1711k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1712l = "share_history.xml";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f1714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Context f1715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f1716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    a f1717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private androidx.appcompat.widget.c.f f1718j;

    public interface a {
        boolean a(a1 a1Var, Intent intent);
    }

    private class b implements androidx.appcompat.widget.c.f {
        b() {
        }

        @Override // androidx.appcompat.widget.c.f
        public boolean a(androidx.appcompat.widget.c cVar, Intent intent) {
            a1 a1Var = a1.this;
            a aVar = a1Var.f1717i;
            if (aVar == null) {
                return false;
            }
            aVar.a(a1Var, intent);
            return false;
        }
    }

    private class c implements MenuItem.OnMenuItemClickListener {
        c() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            a1 a1Var = a1.this;
            Intent intentB = androidx.appcompat.widget.c.d(a1Var.f1715g, a1Var.f1716h).b(menuItem.getItemId());
            if (intentB == null) {
                return true;
            }
            String action = intentB.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                a1.this.r(intentB);
            }
            a1.this.f1715g.startActivity(intentB);
            return true;
        }
    }

    public a1(Context context) {
        super(context);
        this.f1713e = 4;
        this.f1714f = new c();
        this.f1716h = f1712l;
        this.f1715g = context;
    }

    private void n() {
        if (this.f1717i == null) {
            return;
        }
        if (this.f1718j == null) {
            this.f1718j = new b();
        }
        androidx.appcompat.widget.c.d(this.f1715g, this.f1716h).u(this.f1718j);
    }

    @Override // androidx.core.view.b
    public boolean b() {
        return true;
    }

    @Override // androidx.core.view.b
    public View d() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f1715g);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(androidx.appcompat.widget.c.d(this.f1715g, this.f1716h));
        }
        TypedValue typedValue = new TypedValue();
        this.f1715g.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(e.a.b(this.f1715g, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.b
    public void g(SubMenu subMenu) {
        subMenu.clear();
        androidx.appcompat.widget.c cVarD = androidx.appcompat.widget.c.d(this.f1715g, this.f1716h);
        PackageManager packageManager = this.f1715g.getPackageManager();
        int iF = cVarD.f();
        int iMin = Math.min(iF, this.f1713e);
        for (int i7 = 0; i7 < iMin; i7++) {
            ResolveInfo resolveInfoE = cVarD.e(i7);
            subMenu.add(0, i7, i7, resolveInfoE.loadLabel(packageManager)).setIcon(resolveInfoE.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1714f);
        }
        if (iMin < iF) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.f1715g.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i8 = 0; i8 < iF; i8++) {
                ResolveInfo resolveInfoE2 = cVarD.e(i8);
                subMenuAddSubMenu.add(0, i8, i8, resolveInfoE2.loadLabel(packageManager)).setIcon(resolveInfoE2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1714f);
            }
        }
    }

    public void o(a aVar) {
        this.f1717i = aVar;
        n();
    }

    public void p(String str) {
        this.f1716h = str;
        n();
    }

    public void q(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                r(intent);
            }
        }
        androidx.appcompat.widget.c.d(this.f1715g, this.f1716h).t(intent);
    }

    void r(Intent intent) {
        intent.addFlags(134742016);
    }
}
