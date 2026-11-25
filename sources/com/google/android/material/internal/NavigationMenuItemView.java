package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.l1;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements androidx.appcompat.view.menu.o.a {
    private static final int[] R = {R.attr.state_checked};
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    boolean f17746J;
    private final CheckedTextView K;
    private FrameLayout L;
    private androidx.appcompat.view.menu.j M;
    private ColorStateList N;
    private boolean O;
    private Drawable P;
    private final androidx.core.view.a Q;

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.U0(NavigationMenuItemView.this.f17746J);
        }
    }

    public NavigationMenuItemView(@m0 Context context) {
        this(context, null);
    }

    private void E() {
        if (H()) {
            this.K.setVisibility(8);
            FrameLayout frameLayout = this.L;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.L.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.K.setVisibility(0);
        FrameLayout frameLayout2 = this.L;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.L.setLayoutParams(layoutParams2);
        }
    }

    @o0
    private StateListDrawable F() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(R, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean H() {
        return this.M.getTitle() == null && this.M.getIcon() == null && this.M.getActionView() != null;
    }

    private void setActionView(@o0 View view) {
        if (view != null) {
            if (this.L == null) {
                this.L = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.L.removeAllViews();
            this.L.addView(view);
        }
    }

    public void G() {
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.K.setCompoundDrawables(null, null, null, null);
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
    public void g(@m0 androidx.appcompat.view.menu.j jVar, int i7) {
        this.M = jVar;
        if (jVar.getItemId() > 0) {
            setId(jVar.getItemId());
        }
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            n2.I1(this, F());
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        l1.a(this, jVar.getTooltipText());
        E();
    }

    @Override // androidx.appcompat.view.menu.o.a
    public androidx.appcompat.view.menu.j getItemData() {
        return this.M;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        androidx.appcompat.view.menu.j jVar = this.M;
        if (jVar != null && jVar.isCheckable() && this.M.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, R);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setCheckable(boolean z7) {
        refreshDrawableState();
        if (this.f17746J != z7) {
            this.f17746J = z7;
            this.Q.l(this.K, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setChecked(boolean z7) {
        refreshDrawableState();
        this.K.setChecked(z7);
    }

    public void setHorizontalPadding(int i7) {
        setPadding(i7, 0, i7, 0);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setIcon(@o0 Drawable drawable) {
        if (drawable != null) {
            if (this.O) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.d.r(drawable).mutate();
                androidx.core.graphics.drawable.d.o(drawable, this.N);
            }
            int i7 = this.H;
            drawable.setBounds(0, 0, i7, i7);
        } else if (this.I) {
            if (this.P == null) {
                Drawable drawableG = androidx.core.content.res.i.g(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.P = drawableG;
                if (drawableG != null) {
                    int i8 = this.H;
                    drawableG.setBounds(0, 0, i8, i8);
                }
            }
            drawable = this.P;
        }
        androidx.core.widget.u.w(this.K, drawable, null, null, null);
    }

    public void setIconPadding(int i7) {
        this.K.setCompoundDrawablePadding(i7);
    }

    public void setIconSize(@c.q int i7) {
        this.H = i7;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.N = colorStateList;
        this.O = colorStateList != null;
        androidx.appcompat.view.menu.j jVar = this.M;
        if (jVar != null) {
            setIcon(jVar.getIcon());
        }
    }

    public void setMaxLines(int i7) {
        this.K.setMaxLines(i7);
    }

    public void setNeedsEmptyIcon(boolean z7) {
        this.I = z7;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setShortcut(boolean z7, char c8) {
    }

    public void setTextAppearance(int i7) {
        androidx.core.widget.u.E(this.K, i7);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.K.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setTitle(CharSequence charSequence) {
        this.K.setText(charSequence);
    }

    public NavigationMenuItemView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        a aVar = new a();
        this.Q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.K = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        n2.B1(checkedTextView, aVar);
    }
}
