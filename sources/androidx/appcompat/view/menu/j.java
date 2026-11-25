package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class j implements k.c {
    private static final String Q = "MenuItemImpl";
    private static final int R = 3;
    private static final int S = 1;
    private static final int T = 2;
    private static final int U = 4;
    private static final int V = 8;
    private static final int W = 16;
    private static final int X = 32;
    static final int Y = 0;
    private Runnable A;
    private MenuItem.OnMenuItemClickListener B;
    private CharSequence C;
    private CharSequence D;
    private int K;
    private View L;
    private androidx.core.view.b M;
    private MenuItem.OnActionExpandListener N;
    private ContextMenu.ContextMenuInfo P;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f1220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f1221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f1222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f1223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f1224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f1225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Intent f1226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private char f1227s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private char f1229u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f1231w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    g f1233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private s f1234z;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1228t = 4096;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1230v = 4096;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1232x = 0;
    private ColorStateList E = null;
    private PorterDuff.Mode F = null;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f1219J = 16;
    private boolean O = false;

    class a implements androidx.core.view.b.InterfaceC0079b {
        a() {
        }

        @Override // androidx.core.view.b.InterfaceC0079b
        public void onActionProviderVisibilityChanged(boolean z7) {
            j jVar = j.this;
            jVar.f1233y.M(jVar);
        }
    }

    j(g gVar, int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        this.f1233y = gVar;
        this.f1220l = i8;
        this.f1221m = i7;
        this.f1222n = i9;
        this.f1223o = i10;
        this.f1224p = charSequence;
        this.K = i11;
    }

    private static void f(StringBuilder sb, int i7, int i8, String str) {
        if ((i7 & i8) == i8) {
            sb.append(str);
        }
    }

    private Drawable g(Drawable drawable) {
        if (drawable != null && this.I && (this.G || this.H)) {
            drawable = androidx.core.graphics.drawable.d.r(drawable).mutate();
            if (this.G) {
                androidx.core.graphics.drawable.d.o(drawable, this.E);
            }
            if (this.H) {
                androidx.core.graphics.drawable.d.p(drawable, this.F);
            }
            this.I = false;
        }
        return drawable;
    }

    public void A(s sVar) {
        this.f1234z = sVar;
        sVar.setHeaderTitle(getTitle());
    }

    boolean B(boolean z7) {
        int i7 = this.f1219J;
        int i8 = (z7 ? 0 : 8) | (i7 & (-9));
        this.f1219J = i8;
        return i7 != i8;
    }

    public boolean C() {
        return this.f1233y.D();
    }

    boolean D() {
        return this.f1233y.K() && j() != 0;
    }

    public boolean E() {
        return (this.K & 4) == 4;
    }

    @Override // k.c
    @m0
    public k.c a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.M;
        if (bVar2 != null) {
            bVar2.j();
        }
        this.L = null;
        this.M = bVar;
        this.f1233y.N(true);
        androidx.core.view.b bVar3 = this.M;
        if (bVar3 != null) {
            bVar3.l(new a());
        }
        return this;
    }

    @Override // k.c
    public androidx.core.view.b b() {
        return this.M;
    }

    @Override // k.c
    public boolean c() {
        return (d() || q()) ? false : true;
    }

    @Override // k.c, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1233y.g(this);
        }
        return false;
    }

    @Override // k.c
    public boolean d() {
        return (this.K & 2) == 2;
    }

    public void e() {
        this.f1233y.L(this);
    }

    @Override // k.c, android.view.MenuItem
    public boolean expandActionView() {
        if (!m()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1233y.n(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // k.c, android.view.MenuItem
    public View getActionView() {
        View view = this.L;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.M;
        if (bVar == null) {
            return null;
        }
        View viewE = bVar.e(this);
        this.L = viewE;
        return viewE;
    }

    @Override // k.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1230v;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1229u;
    }

    @Override // k.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1221m;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1231w;
        if (drawable != null) {
            return g(drawable);
        }
        if (this.f1232x == 0) {
            return null;
        }
        Drawable drawableB = e.a.b(this.f1233y.x(), this.f1232x);
        this.f1232x = 0;
        this.f1231w = drawableB;
        return g(drawableB);
    }

    @Override // k.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.E;
    }

    @Override // k.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.F;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1226r;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1220l;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.P;
    }

    @Override // k.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1228t;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1227s;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1222n;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1234z;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1224p;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1225q;
        return charSequence != null ? charSequence : this.f1224p;
    }

    @Override // k.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.D;
    }

    Runnable h() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1234z != null;
    }

    public int i() {
        return this.f1223o;
    }

    @Override // k.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.O;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1219J & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1219J & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1219J & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.M;
        if (bVar == null || !bVar.h()) {
            return (this.f1219J & 8) == 0;
        }
        return (this.f1219J & 8) == 0 && this.M.c();
    }

    char j() {
        return this.f1233y.J() ? this.f1229u : this.f1227s;
    }

    String k() {
        char cJ = j();
        if (cJ == 0) {
            return "";
        }
        Resources resources = this.f1233y.x().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1233y.x()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i7 = this.f1233y.J() ? this.f1230v : this.f1228t;
        f(sb, i7, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        f(sb, i7, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        f(sb, i7, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        f(sb, i7, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        f(sb, i7, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        f(sb, i7, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cJ == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cJ == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cJ != ' ') {
            sb.append(cJ);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    CharSequence l(o.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    public boolean m() {
        androidx.core.view.b bVar;
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null && (bVar = this.M) != null) {
            this.L = bVar.e(this);
        }
        return this.L != null;
    }

    public boolean n() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.B;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f1233y;
        if (gVar.i(gVar, this)) {
            return true;
        }
        Runnable runnable = this.A;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1226r != null) {
            try {
                this.f1233y.x().startActivity(this.f1226r);
                return true;
            } catch (ActivityNotFoundException e8) {
                Log.e(Q, "Can't find activity to handle intent; ignoring", e8);
            }
        }
        androidx.core.view.b bVar = this.M;
        return bVar != null && bVar.f();
    }

    public boolean o() {
        return (this.f1219J & 32) == 32;
    }

    public boolean p() {
        return (this.f1219J & 4) != 0;
    }

    public boolean q() {
        return (this.K & 1) == 1;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public k.c setActionView(int i7) {
        Context contextX = this.f1233y.x();
        setActionView(LayoutInflater.from(contextX).inflate(i7, (ViewGroup) new LinearLayout(contextX), false));
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public k.c setActionView(View view) {
        int i7;
        this.L = view;
        this.M = null;
        if (view != null && view.getId() == -1 && (i7 = this.f1220l) > 0) {
            view.setId(i7);
        }
        this.f1233y.L(this);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        if (this.f1229u == c8) {
            return this;
        }
        this.f1229u = Character.toLowerCase(c8);
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        int i7 = this.f1219J;
        int i8 = (z7 ? 1 : 0) | (i7 & (-2));
        this.f1219J = i8;
        if (i7 != i8) {
            this.f1233y.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        if ((this.f1219J & 4) != 0) {
            this.f1233y.a0(this);
        } else {
            v(z7);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        if (z7) {
            this.f1219J |= 16;
        } else {
            this.f1219J &= -17;
        }
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1232x = 0;
        this.f1231w = drawable;
        this.I = true;
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setIconTintList(@o0 ColorStateList colorStateList) {
        this.E = colorStateList;
        this.G = true;
        this.I = true;
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.F = mode;
        this.H = true;
        this.I = true;
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1226r = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        if (this.f1227s == c8) {
            return this;
        }
        this.f1227s = c8;
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.N = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.B = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f1227s = c8;
        this.f1229u = Character.toLowerCase(c9);
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    public void setShowAsAction(int i7) {
        int i8 = i7 & 3;
        if (i8 != 0 && i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.K = i7;
        this.f1233y.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1224p = charSequence;
        this.f1233y.N(false);
        s sVar = this.f1234z;
        if (sVar != null) {
            sVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1225q = charSequence;
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        if (B(z7)) {
            this.f1233y.M(this);
        }
        return this;
    }

    public void t(boolean z7) {
        this.O = z7;
        this.f1233y.N(false);
    }

    public String toString() {
        CharSequence charSequence = this.f1224p;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public MenuItem u(Runnable runnable) {
        this.A = runnable;
        return this;
    }

    void v(boolean z7) {
        int i7 = this.f1219J;
        int i8 = (z7 ? 2 : 0) | (i7 & (-3));
        this.f1219J = i8;
        if (i7 != i8) {
            this.f1233y.N(false);
        }
    }

    public void w(boolean z7) {
        this.f1219J = (z7 ? 4 : 0) | (this.f1219J & (-5));
    }

    public void x(boolean z7) {
        if (z7) {
            this.f1219J |= 32;
        } else {
            this.f1219J &= -33;
        }
    }

    void y(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.P = contextMenuInfo;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public k.c setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public k.c setContentDescription(CharSequence charSequence) {
        this.C = charSequence;
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public k.c setTooltipText(CharSequence charSequence) {
        this.D = charSequence;
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setAlphabeticShortcut(char c8, int i7) {
        if (this.f1229u == c8 && this.f1230v == i7) {
            return this;
        }
        this.f1229u = Character.toLowerCase(c8);
        this.f1230v = KeyEvent.normalizeMetaState(i7);
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setNumericShortcut(char c8, int i7) {
        if (this.f1227s == c8 && this.f1228t == i7) {
            return this;
        }
        this.f1227s = c8;
        this.f1228t = KeyEvent.normalizeMetaState(i7);
        this.f1233y.N(false);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setShortcut(char c8, char c9, int i7, int i8) {
        this.f1227s = c8;
        this.f1228t = KeyEvent.normalizeMetaState(i7);
        this.f1229u = Character.toLowerCase(c9);
        this.f1230v = KeyEvent.normalizeMetaState(i8);
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f1231w = null;
        this.f1232x = i7;
        this.I = true;
        this.f1233y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        return setTitle(this.f1233y.x().getString(i7));
    }
}
