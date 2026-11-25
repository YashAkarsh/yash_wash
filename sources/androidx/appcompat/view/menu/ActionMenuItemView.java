package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.l1;
import androidx.appcompat.widget.p0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements o.a, View.OnClickListener, ActionMenuView.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f1080r = "ActionMenuItemView";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f1081s = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    j f1082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CharSequence f1083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f1084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    g.b f1085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private p0 f1086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    b f1087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f1088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f1089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1092q;

    private class a extends p0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.p0
        public q b() {
            b bVar = ActionMenuItemView.this.f1087l;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.p0
        protected boolean c() {
            q qVarB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f1085j;
            return bVar != null && bVar.a(actionMenuItemView.f1082g) && (qVarB = b()) != null && qVarB.c();
        }
    }

    public static abstract class b {
        public abstract q a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean i() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i7 = configuration.screenWidthDp;
        return i7 >= 480 || (i7 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void j() {
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.f1083h);
        if (this.f1084i != null && (!this.f1082g.E() || (!this.f1088m && !this.f1089n))) {
            z7 = false;
        }
        boolean z9 = z8 & z7;
        setText(z9 ? this.f1083h : null);
        CharSequence contentDescription = this.f1082g.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z9 ? null : this.f1082g.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1082g.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            l1.a(this, z9 ? null : this.f1082g.getTitle());
        } else {
            l1.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return h();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return h() && this.f1082g.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean f() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void g(j jVar, int i7) {
        this.f1082g = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.l(this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.f1086k == null) {
            this.f1086k = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.o.a
    public j getItemData() {
        return this.f1082g;
    }

    public boolean h() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f1085j;
        if (bVar != null) {
            bVar.a(this.f1082g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1088m = i();
        j();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i7, int i8) {
        int i9;
        boolean zH = h();
        if (zH && (i9 = this.f1091p) >= 0) {
            super.setPadding(i9, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i7, i8);
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1090o) : this.f1090o;
        if (mode != 1073741824 && this.f1090o > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i8);
        }
        if (zH || this.f1084i == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1084i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p0 p0Var;
        if (this.f1082g.hasSubMenu() && (p0Var = this.f1086k) != null && p0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setCheckable(boolean z7) {
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setChecked(boolean z7) {
    }

    public void setExpandedFormat(boolean z7) {
        if (this.f1089n != z7) {
            this.f1089n = z7;
            j jVar = this.f1082g;
            if (jVar != null) {
                jVar.e();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setIcon(Drawable drawable) {
        this.f1084i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i7 = this.f1092q;
            if (intrinsicWidth > i7) {
                intrinsicHeight = (int) (intrinsicHeight * (i7 / intrinsicWidth));
                intrinsicWidth = i7;
            }
            if (intrinsicHeight > i7) {
                intrinsicWidth = (int) (intrinsicWidth * (i7 / intrinsicHeight));
            } else {
                i7 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i7);
        }
        setCompoundDrawables(drawable, null, null, null);
        j();
    }

    public void setItemInvoker(g.b bVar) {
        this.f1085j = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i7, int i8, int i9, int i10) {
        this.f1091p = i7;
        super.setPadding(i7, i8, i9, i10);
    }

    public void setPopupCallback(b bVar) {
        this.f1087l = bVar;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setShortcut(boolean z7, char c8) {
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setTitle(CharSequence charSequence) {
        this.f1083h = charSequence;
        j();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        Resources resources = context.getResources();
        this.f1088m = i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i7, 0);
        this.f1090o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1092q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1091p = -1;
        setSaveEnabled(false);
    }
}
