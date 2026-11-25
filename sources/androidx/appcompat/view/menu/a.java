package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class a implements k.c {
    private static final int F = 1;
    private static final int G = 2;
    private static final int H = 4;
    private static final int I = 8;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f1115J = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f1116l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f1117m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f1118n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CharSequence f1119o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f1120p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Intent f1121q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private char f1122r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private char f1124t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f1126v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Context f1127w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1128x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f1129y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CharSequence f1130z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1123s = 4096;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1125u = 4096;
    private ColorStateList A = null;
    private PorterDuff.Mode B = null;
    private boolean C = false;
    private boolean D = false;
    private int E = 16;

    public a(Context context, int i7, int i8, int i9, int i10, CharSequence charSequence) {
        this.f1127w = context;
        this.f1116l = i8;
        this.f1117m = i7;
        this.f1118n = i10;
        this.f1119o = charSequence;
    }

    private void e() {
        Drawable drawable = this.f1126v;
        if (drawable != null) {
            if (this.C || this.D) {
                Drawable drawableR = androidx.core.graphics.drawable.d.r(drawable);
                this.f1126v = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f1126v = drawableMutate;
                if (this.C) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, this.A);
                }
                if (this.D) {
                    androidx.core.graphics.drawable.d.p(this.f1126v, this.B);
                }
            }
        }
    }

    @Override // k.c
    @m0
    public k.c a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // k.c
    public androidx.core.view.b b() {
        return null;
    }

    @Override // k.c
    public boolean c() {
        return false;
    }

    @Override // k.c, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // k.c
    public boolean d() {
        return true;
    }

    @Override // k.c, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    public boolean f() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1128x;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.f1121q;
        if (intent == null) {
            return false;
        }
        this.f1127w.startActivity(intent);
        return true;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public k.c setActionView(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // k.c, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // k.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1125u;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1124t;
    }

    @Override // k.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1129y;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1117m;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1126v;
    }

    @Override // k.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.A;
    }

    @Override // k.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.B;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1121q;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1116l;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // k.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1123s;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1122r;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1118n;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1119o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1120p;
        return charSequence != null ? charSequence : this.f1119o;
    }

    @Override // k.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1130z;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public k.c setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public a i(boolean z7) {
        this.E = (z7 ? 4 : 0) | (this.E & (-5));
        return this;
    }

    @Override // k.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.E & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.E & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.E & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.E & 8) == 0;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public k.c setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        this.f1124t = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.E = (z7 ? 1 : 0) | (this.E & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.E = (z7 ? 2 : 0) | (this.E & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.E = (z7 ? 16 : 0) | (this.E & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1126v = drawable;
        e();
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setIconTintList(@o0 ColorStateList colorStateList) {
        this.A = colorStateList;
        this.C = true;
        e();
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.B = mode;
        this.D = true;
        e();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1121q = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        this.f1122r = c8;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1128x = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f1122r = c8;
        this.f1124t = Character.toLowerCase(c9);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    public void setShowAsAction(int i7) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1119o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1120p = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        this.E = (this.E & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setAlphabeticShortcut(char c8, int i7) {
        this.f1124t = Character.toLowerCase(c8);
        this.f1125u = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public k.c setContentDescription(CharSequence charSequence) {
        this.f1129y = charSequence;
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setNumericShortcut(char c8, int i7) {
        this.f1122r = c8;
        this.f1123s = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f1119o = this.f1127w.getResources().getString(i7);
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public k.c setTooltipText(CharSequence charSequence) {
        this.f1130z = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f1126v = androidx.core.content.d.i(this.f1127w, i7);
        e();
        return this;
    }

    @Override // k.c, android.view.MenuItem
    @m0
    public MenuItem setShortcut(char c8, char c9, int i7, int i8) {
        this.f1122r = c8;
        this.f1123s = KeyEvent.normalizeMetaState(i7);
        this.f1124t = Character.toLowerCase(c9);
        this.f1125u = KeyEvent.normalizeMetaState(i8);
        return this;
    }
}
