package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.widget.h1;
import androidx.core.content.d;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.customview.view.AbsSavedState;
import c.b0;
import c.b1;
import c.h0;
import c.m0;
import c.o0;
import c.p;
import c.q;
import c.u;
import c.x0;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;
import com.google.android.material.internal.n;
import com.google.android.material.shape.j;
import com.google.android.material.shape.k;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f17972m = {R.attr.state_checked};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f17973n = {-16842910};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f17974o = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f17975p = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    private final f f17976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f17977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    c f17978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f17979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f17980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MenuInflater f17981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f17982l;

    class a implements androidx.appcompat.view.menu.g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            c cVar = NavigationView.this.f17978h;
            return cVar != null && cVar.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f17980j);
            boolean z7 = NavigationView.this.f17980j[1] == 0;
            NavigationView.this.f17977g.B(z7);
            NavigationView.this.setDrawTopInsetForeground(z7);
            Activity activityA = com.google.android.material.internal.b.a(NavigationView.this.getContext());
            if (activityA != null) {
                NavigationView.this.setDrawBottomInsetForeground((activityA.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0));
            }
        }
    }

    public interface c {
        boolean a(@m0 MenuItem menuItem);
    }

    public NavigationView(@m0 Context context) {
        this(context, null);
    }

    @o0
    private ColorStateList e(int i7) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i7, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = e.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i8 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f17973n;
        return new ColorStateList(new int[][]{iArr, f17972m, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i8, defaultColor});
    }

    @m0
    private final Drawable f(@m0 h1 h1Var) {
        j jVar = new j(o.b(getContext(), h1Var.u(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), h1Var.u(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        jVar.n0(com.google.android.material.resources.c.b(getContext(), h1Var, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) jVar, h1Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), h1Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), h1Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), h1Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.f17981k == null) {
            this.f17981k = new androidx.appcompat.view.g(getContext());
        }
        return this.f17981k;
    }

    private boolean h(@m0 h1 h1Var) {
        return h1Var.C(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || h1Var.C(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void l() {
        this.f17982l = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f17982l);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @x0({x0.a.LIBRARY_GROUP})
    protected void a(@m0 w5 w5Var) {
        this.f17977g.l(w5Var);
    }

    public void d(@m0 View view) {
        this.f17977g.c(view);
    }

    public View g(int i7) {
        return this.f17977g.r(i7);
    }

    @o0
    public MenuItem getCheckedItem() {
        return this.f17977g.p();
    }

    public int getHeaderCount() {
        return this.f17977g.q();
    }

    @o0
    public Drawable getItemBackground() {
        return this.f17977g.s();
    }

    @q
    public int getItemHorizontalPadding() {
        return this.f17977g.t();
    }

    @q
    public int getItemIconPadding() {
        return this.f17977g.u();
    }

    @o0
    public ColorStateList getItemIconTintList() {
        return this.f17977g.x();
    }

    public int getItemMaxLines() {
        return this.f17977g.v();
    }

    @o0
    public ColorStateList getItemTextColor() {
        return this.f17977g.w();
    }

    @m0
    public Menu getMenu() {
        return this.f17976f;
    }

    public View i(@h0 int i7) {
        return this.f17977g.y(i7);
    }

    public void j(int i7) {
        this.f17977g.N(true);
        getMenuInflater().inflate(i7, this.f17976f);
        this.f17977g.N(false);
        this.f17977g.e(false);
    }

    public void k(@m0 View view) {
        this.f17977g.A(view);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f17982l);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        int mode = View.MeasureSpec.getMode(i7);
        if (mode == Integer.MIN_VALUE) {
            i7 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i7), this.f17979i), 1073741824);
        } else if (mode == 0) {
            i7 = View.MeasureSpec.makeMeasureSpec(this.f17979i, 1073741824);
        }
        super.onMeasure(i7, i8);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f17976f.U(savedState.f17983c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f17983c = bundle;
        this.f17976f.W(bundle);
        return savedState;
    }

    public void setCheckedItem(@b0 int i7) {
        MenuItem menuItemFindItem = this.f17976f.findItem(i7);
        if (menuItemFindItem != null) {
            this.f17977g.C((androidx.appcompat.view.menu.j) menuItemFindItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        k.d(this, f8);
    }

    public void setItemBackground(@o0 Drawable drawable) {
        this.f17977g.E(drawable);
    }

    public void setItemBackgroundResource(@u int i7) {
        setItemBackground(d.i(getContext(), i7));
    }

    public void setItemHorizontalPadding(@q int i7) {
        this.f17977g.F(i7);
    }

    public void setItemHorizontalPaddingResource(@p int i7) {
        this.f17977g.F(getResources().getDimensionPixelSize(i7));
    }

    public void setItemIconPadding(@q int i7) {
        this.f17977g.G(i7);
    }

    public void setItemIconPaddingResource(int i7) {
        this.f17977g.G(getResources().getDimensionPixelSize(i7));
    }

    public void setItemIconSize(@q int i7) {
        this.f17977g.H(i7);
    }

    public void setItemIconTintList(@o0 ColorStateList colorStateList) {
        this.f17977g.I(colorStateList);
    }

    public void setItemMaxLines(int i7) {
        this.f17977g.J(i7);
    }

    public void setItemTextAppearance(@b1 int i7) {
        this.f17977g.K(i7);
    }

    public void setItemTextColor(@o0 ColorStateList colorStateList) {
        this.f17977g.L(colorStateList);
    }

    public void setNavigationItemSelectedListener(@o0 c cVar) {
        this.f17978h = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i7) {
        super.setOverScrollMode(i7);
        g gVar = this.f17977g;
        if (gVar != null) {
            gVar.M(i7);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        public Bundle f17983c;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @o0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@m0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(@m0 Parcel parcel, @o0 ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f17983c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeBundle(this.f17983c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        ColorStateList colorStateListE;
        int iU;
        boolean z7;
        int i8 = f17974o;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        g gVar = new g();
        this.f17977g = gVar;
        this.f17980j = new int[2];
        Context context2 = getContext();
        f fVar = new f(context2);
        this.f17976f = fVar;
        h1 h1VarK = n.k(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i7, i8, new int[0]);
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_android_background)) {
            n2.I1(this, h1VarK.h(com.google.android.material.R.styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            o oVarM = o.e(context2, attributeSet, i7, i8).m();
            Drawable background = getBackground();
            j jVar = new j(oVarM);
            if (background instanceof ColorDrawable) {
                jVar.n0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            jVar.Y(context2);
            n2.I1(this, jVar);
        }
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(h1VarK.g(com.google.android.material.R.styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(h1VarK.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f17979i = h1VarK.g(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_itemIconTint)) {
            colorStateListE = h1VarK.d(com.google.android.material.R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListE = e(R.attr.textColorSecondary);
        }
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_itemTextAppearance)) {
            iU = h1VarK.u(com.google.android.material.R.styleable.NavigationView_itemTextAppearance, 0);
            z7 = true;
        } else {
            iU = 0;
            z7 = false;
        }
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_itemIconSize)) {
            setItemIconSize(h1VarK.g(com.google.android.material.R.styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListD = h1VarK.C(com.google.android.material.R.styleable.NavigationView_itemTextColor) ? h1VarK.d(com.google.android.material.R.styleable.NavigationView_itemTextColor) : null;
        if (!z7 && colorStateListD == null) {
            colorStateListD = e(R.attr.textColorPrimary);
        }
        Drawable drawableH = h1VarK.h(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawableH == null && h(h1VarK)) {
            drawableH = f(h1VarK);
        }
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding)) {
            gVar.F(h1VarK.g(com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int iG = h1VarK.g(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(h1VarK.o(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        fVar.X(new a());
        gVar.D(1);
        gVar.j(context2, fVar);
        gVar.I(colorStateListE);
        gVar.M(getOverScrollMode());
        if (z7) {
            gVar.K(iU);
        }
        gVar.L(colorStateListD);
        gVar.E(drawableH);
        gVar.G(iG);
        fVar.b(gVar);
        addView((View) gVar.n(this));
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_menu)) {
            j(h1VarK.u(com.google.android.material.R.styleable.NavigationView_menu, 0));
        }
        if (h1VarK.C(com.google.android.material.R.styleable.NavigationView_headerLayout)) {
            i(h1VarK.u(com.google.android.material.R.styleable.NavigationView_headerLayout, 0));
        }
        h1VarK.I();
        l();
    }

    public void setCheckedItem(@m0 MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f17976f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f17977g.C((androidx.appcompat.view.menu.j) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
