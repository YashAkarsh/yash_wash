package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.l1;
import androidx.core.graphics.drawable.d;
import androidx.core.view.accessibility.l0;
import androidx.core.view.g2;
import androidx.core.view.n2;
import c.b1;
import c.h0;
import c.m0;
import c.o0;
import c.p;
import c.u;
import c.x0;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements o.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f17908q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f17909r = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f17911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f17916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewGroup f17917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f17918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f17919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private j f17921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private ColorStateList f17922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private Drawable f17923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private Drawable f17924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private BadgeDrawable f17925p;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            if (NavigationBarItemView.this.f17916g.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.n(navigationBarItemView.f17916g);
            }
        }
    }

    public NavigationBarItemView(@m0 Context context) {
        super(context);
        this.f17920k = -1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f17916g = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.f17917h = viewGroup;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.f17918i = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.f17919j = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f17910a = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        n2.R1(textView, 2);
        n2.R1(textView2, 2);
        setFocusable(true);
        c(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f17916g;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void c(float f8, float f9) {
        this.f17911b = f8 - f9;
        this.f17912c = (f9 * 1.0f) / f8;
        this.f17913d = (f8 * 1.0f) / f9;
    }

    @o0
    private FrameLayout e(View view) {
        ImageView imageView = this.f17916g;
        if (view == imageView && com.google.android.material.badge.a.f17037a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i7 = 0;
        for (int i8 = 0; i8 < iIndexOfChild; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i7++;
            }
        }
        return i7;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable = this.f17925p;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.f17916g.getLayoutParams()).topMargin) + this.f17916g.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.f17925p;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.f17925p.q();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17916g.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f17916g.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean h() {
        return this.f17925p != null;
    }

    private static void j(@m0 View view, int i7, int i8) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i7;
        layoutParams.gravity = i8;
        view.setLayoutParams(layoutParams);
    }

    private static void k(@m0 View view, float f8, float f9, int i7) {
        view.setScaleX(f8);
        view.setScaleY(f9);
        view.setVisibility(i7);
    }

    private void l(@o0 View view) {
        if (h() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.b(this.f17925p, view, e(view));
        }
    }

    private void m(@o0 View view) {
        if (h()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.g(this.f17925p, view);
            }
            this.f17925p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        if (h()) {
            com.google.android.material.badge.a.j(this.f17925p, view, e(view));
        }
    }

    private static void o(@m0 View view, int i7) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i7);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean f() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void g(@m0 j jVar, int i7) {
        this.f17921l = jVar;
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setIcon(jVar.getIcon());
        setTitle(jVar.getTitle());
        setId(jVar.getItemId());
        if (!TextUtils.isEmpty(jVar.getContentDescription())) {
            setContentDescription(jVar.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(jVar.getTooltipText()) ? jVar.getTooltipText() : jVar.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            l1.a(this, tooltipText);
        }
        setVisibility(jVar.isVisible() ? 0 : 8);
    }

    @o0
    public BadgeDrawable getBadge() {
        return this.f17925p;
    }

    @u
    protected int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.o.a
    @o0
    public j getItemData() {
        return this.f17921l;
    }

    @p
    protected int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @h0
    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f17920k;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17917h.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f17917h.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17917h.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f17917h.getMeasuredWidth() + layoutParams.rightMargin);
    }

    void i() {
        m(this.f17916g);
    }

    @Override // android.view.ViewGroup, android.view.View
    @m0
    public int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        j jVar = this.f17921l;
        if (jVar != null && jVar.isCheckable() && this.f17921l.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f17909r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.f17925p;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f17921l.getTitle();
            if (!TextUtils.isEmpty(this.f17921l.getContentDescription())) {
                title = this.f17921l.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.f17925p.o()));
        }
        l0 l0VarX1 = l0.X1(accessibilityNodeInfo);
        l0VarX1.Z0(l0.c.h(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            l0VarX1.X0(false);
            l0VarX1.K0(l0.a.f6496j);
        }
        l0VarX1.D1(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    void setBadge(@m0 BadgeDrawable badgeDrawable) {
        this.f17925p = badgeDrawable;
        ImageView imageView = this.f17916g;
        if (imageView != null) {
            l(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setCheckable(boolean z7) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setChecked(boolean z7) {
        TextView textView = this.f17919j;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f17919j;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f17918i;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f17918i;
        textView4.setPivotY(textView4.getBaseline());
        int i7 = this.f17914e;
        if (i7 != -1) {
            if (i7 == 0) {
                if (z7) {
                    j(this.f17916g, this.f17910a, 49);
                    ViewGroup viewGroup = this.f17917h;
                    o(viewGroup, ((Integer) viewGroup.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.f17919j.setVisibility(0);
                } else {
                    j(this.f17916g, this.f17910a, 17);
                    o(this.f17917h, 0);
                    this.f17919j.setVisibility(4);
                }
                this.f17918i.setVisibility(4);
            } else if (i7 == 1) {
                ViewGroup viewGroup2 = this.f17917h;
                o(viewGroup2, ((Integer) viewGroup2.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z7) {
                    j(this.f17916g, (int) (this.f17910a + this.f17911b), 49);
                    k(this.f17919j, 1.0f, 1.0f, 0);
                    TextView textView5 = this.f17918i;
                    float f8 = this.f17912c;
                    k(textView5, f8, f8, 4);
                } else {
                    j(this.f17916g, this.f17910a, 49);
                    TextView textView6 = this.f17919j;
                    float f9 = this.f17913d;
                    k(textView6, f9, f9, 4);
                    k(this.f17918i, 1.0f, 1.0f, 0);
                }
            } else if (i7 == 2) {
                j(this.f17916g, this.f17910a, 17);
                this.f17919j.setVisibility(8);
                this.f17918i.setVisibility(8);
            }
        } else if (this.f17915f) {
            if (z7) {
                j(this.f17916g, this.f17910a, 49);
                ViewGroup viewGroup3 = this.f17917h;
                o(viewGroup3, ((Integer) viewGroup3.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.f17919j.setVisibility(0);
            } else {
                j(this.f17916g, this.f17910a, 17);
                o(this.f17917h, 0);
                this.f17919j.setVisibility(4);
            }
            this.f17918i.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.f17917h;
            o(viewGroup4, ((Integer) viewGroup4.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z7) {
                j(this.f17916g, (int) (this.f17910a + this.f17911b), 49);
                k(this.f17919j, 1.0f, 1.0f, 0);
                TextView textView7 = this.f17918i;
                float f10 = this.f17912c;
                k(textView7, f10, f10, 4);
            } else {
                j(this.f17916g, this.f17910a, 49);
                TextView textView8 = this.f17919j;
                float f11 = this.f17913d;
                k(textView8, f11, f11, 4);
                k(this.f17918i, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z7);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.o.a
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.f17918i.setEnabled(z7);
        this.f17919j.setEnabled(z7);
        this.f17916g.setEnabled(z7);
        if (z7) {
            n2.g2(this, g2.c(getContext(), 1002));
        } else {
            n2.g2(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setIcon(@o0 Drawable drawable) {
        if (drawable == this.f17923n) {
            return;
        }
        this.f17923n = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = d.r(drawable).mutate();
            this.f17924o = drawable;
            ColorStateList colorStateList = this.f17922m;
            if (colorStateList != null) {
                d.o(drawable, colorStateList);
            }
        }
        this.f17916g.setImageDrawable(drawable);
    }

    public void setIconSize(int i7) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17916g.getLayoutParams();
        layoutParams.width = i7;
        layoutParams.height = i7;
        this.f17916g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@o0 ColorStateList colorStateList) {
        Drawable drawable;
        this.f17922m = colorStateList;
        if (this.f17921l == null || (drawable = this.f17924o) == null) {
            return;
        }
        d.o(drawable, colorStateList);
        this.f17924o.invalidateSelf();
    }

    public void setItemBackground(int i7) {
        setItemBackground(i7 == 0 ? null : androidx.core.content.d.i(getContext(), i7));
    }

    public void setItemPosition(int i7) {
        this.f17920k = i7;
    }

    public void setLabelVisibilityMode(int i7) {
        if (this.f17914e != i7) {
            this.f17914e = i7;
            j jVar = this.f17921l;
            if (jVar != null) {
                setChecked(jVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z7) {
        if (this.f17915f != z7) {
            this.f17915f = z7;
            j jVar = this.f17921l;
            if (jVar != null) {
                setChecked(jVar.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setShortcut(boolean z7, char c8) {
    }

    public void setTextAppearanceActive(@b1 int i7) {
        androidx.core.widget.u.E(this.f17919j, i7);
        c(this.f17918i.getTextSize(), this.f17919j.getTextSize());
    }

    public void setTextAppearanceInactive(@b1 int i7) {
        androidx.core.widget.u.E(this.f17918i, i7);
        c(this.f17918i.getTextSize(), this.f17919j.getTextSize());
    }

    public void setTextColor(@o0 ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f17918i.setTextColor(colorStateList);
            this.f17919j.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setTitle(@o0 CharSequence charSequence) {
        this.f17918i.setText(charSequence);
        this.f17919j.setText(charSequence);
        j jVar = this.f17921l;
        if (jVar == null || TextUtils.isEmpty(jVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        j jVar2 = this.f17921l;
        if (jVar2 != null && !TextUtils.isEmpty(jVar2.getTooltipText())) {
            charSequence = this.f17921l.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            l1.a(this, charSequence);
        }
    }

    public void setItemBackground(@o0 Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        n2.I1(this, drawable);
    }
}
