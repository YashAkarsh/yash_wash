package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.h1;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.customview.view.AbsSavedState;
import c.b0;
import c.b1;
import c.f;
import c.m0;
import c.o0;
import c.p;
import c.q;
import c.u;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.shape.j;
import com.google.android.material.shape.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17957h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17958i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17959j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17960k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f17961l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final com.google.android.material.navigation.a f17962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final NavigationBarMenuView f17963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final NavigationBarPresenter f17964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private ColorStateList f17965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MenuInflater f17966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f17967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f17968g;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        Bundle f17969c;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@m0 Parcel parcel, ClassLoader classLoader) {
            this.f17969c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeBundle(this.f17969c);
        }

        public SavedState(@m0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, @m0 MenuItem menuItem) {
            if (NavigationBarView.this.f17968g == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                return (NavigationBarView.this.f17967f == null || NavigationBarView.this.f17967f.a(menuItem)) ? false : true;
            }
            NavigationBarView.this.f17968g.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
        }
    }

    class b implements v.e {
        b() {
        }

        @Override // com.google.android.material.internal.v.e
        @m0
        public w5 a(View view, @m0 w5 w5Var, @m0 v.f fVar) {
            fVar.f17907d += w5Var.o();
            boolean z7 = n2.Z(view) == 1;
            int iP = w5Var.p();
            int iQ = w5Var.q();
            fVar.f17904a += z7 ? iQ : iP;
            int i7 = fVar.f17906c;
            if (!z7) {
                iP = iQ;
            }
            fVar.f17906c = i7 + iP;
            fVar.a(view);
            return w5Var;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public interface d {
        void a(@m0 MenuItem menuItem);
    }

    public interface e {
        boolean a(@m0 MenuItem menuItem);
    }

    public NavigationBarView(@m0 Context context, @o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f17964c = navigationBarPresenter;
        Context context2 = getContext();
        h1 h1VarK = n.k(context2, attributeSet, R.styleable.NavigationBarView, i7, i8, R.styleable.NavigationBarView_itemTextAppearanceInactive, R.styleable.NavigationBarView_itemTextAppearanceActive);
        com.google.android.material.navigation.a aVar = new com.google.android.material.navigation.a(context2, getClass(), getMaxItemCount());
        this.f17962a = aVar;
        NavigationBarMenuView navigationBarMenuViewE = e(context2);
        this.f17963b = navigationBarMenuViewE;
        navigationBarPresenter.c(navigationBarMenuViewE);
        navigationBarPresenter.b(1);
        navigationBarMenuViewE.setPresenter(navigationBarPresenter);
        aVar.b(navigationBarPresenter);
        navigationBarPresenter.j(getContext(), aVar);
        if (h1VarK.C(R.styleable.NavigationBarView_itemIconTint)) {
            navigationBarMenuViewE.setIconTintList(h1VarK.d(R.styleable.NavigationBarView_itemIconTint));
        } else {
            navigationBarMenuViewE.setIconTintList(navigationBarMenuViewE.d(android.R.attr.textColorSecondary));
        }
        setItemIconSize(h1VarK.g(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (h1VarK.C(R.styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(h1VarK.u(R.styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (h1VarK.C(R.styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(h1VarK.u(R.styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        if (h1VarK.C(R.styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(h1VarK.d(R.styleable.NavigationBarView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            n2.I1(this, d(context2));
        }
        if (h1VarK.C(R.styleable.NavigationBarView_elevation)) {
            setElevation(h1VarK.g(R.styleable.NavigationBarView_elevation, 0));
        }
        androidx.core.graphics.drawable.d.o(getBackground().mutate(), com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(h1VarK.p(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int iU = h1VarK.u(R.styleable.NavigationBarView_itemBackground, 0);
        if (iU != 0) {
            navigationBarMenuViewE.setItemBackgroundRes(iU);
        } else {
            setItemRippleColor(com.google.android.material.resources.c.b(context2, h1VarK, R.styleable.NavigationBarView_itemRippleColor));
        }
        if (h1VarK.C(R.styleable.NavigationBarView_menu)) {
            h(h1VarK.u(R.styleable.NavigationBarView_menu, 0));
        }
        h1VarK.I();
        addView(navigationBarMenuViewE);
        aVar.X(new a());
        c();
    }

    private void c() {
        v.d(this, new b());
    }

    @m0
    private j d(Context context) {
        j jVar = new j();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            jVar.n0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        jVar.Y(context);
        return jVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f17966e == null) {
            this.f17966e = new androidx.appcompat.view.g(getContext());
        }
        return this.f17966e;
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    protected abstract NavigationBarMenuView e(@m0 Context context);

    @o0
    public BadgeDrawable f(int i7) {
        return this.f17963b.h(i7);
    }

    @m0
    public BadgeDrawable g(int i7) {
        return this.f17963b.i(i7);
    }

    @o0
    public Drawable getItemBackground() {
        return this.f17963b.getItemBackground();
    }

    @u
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f17963b.getItemBackgroundRes();
    }

    @q
    public int getItemIconSize() {
        return this.f17963b.getItemIconSize();
    }

    @o0
    public ColorStateList getItemIconTintList() {
        return this.f17963b.getIconTintList();
    }

    @o0
    public ColorStateList getItemRippleColor() {
        return this.f17965d;
    }

    @b1
    public int getItemTextAppearanceActive() {
        return this.f17963b.getItemTextAppearanceActive();
    }

    @b1
    public int getItemTextAppearanceInactive() {
        return this.f17963b.getItemTextAppearanceInactive();
    }

    @o0
    public ColorStateList getItemTextColor() {
        return this.f17963b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f17963b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @m0
    public Menu getMenu() {
        return this.f17962a;
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public o getMenuView() {
        return this.f17963b;
    }

    @m0
    protected NavigationBarPresenter getPresenter() {
        return this.f17964c;
    }

    @b0
    public int getSelectedItemId() {
        return this.f17963b.getSelectedItemId();
    }

    public void h(int i7) {
        this.f17964c.l(true);
        getMenuInflater().inflate(i7, this.f17962a);
        this.f17964c.l(false);
        this.f17964c.e(true);
    }

    public void i(int i7) {
        this.f17963b.l(i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@o0 Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f17962a.U(savedState.f17969c);
    }

    @Override // android.view.View
    @m0
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f17969c = bundle;
        this.f17962a.W(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        k.d(this, f8);
    }

    public void setItemBackground(@o0 Drawable drawable) {
        this.f17963b.setItemBackground(drawable);
        this.f17965d = null;
    }

    public void setItemBackgroundResource(@u int i7) {
        this.f17963b.setItemBackgroundRes(i7);
        this.f17965d = null;
    }

    public void setItemIconSize(@q int i7) {
        this.f17963b.setItemIconSize(i7);
    }

    public void setItemIconSizeRes(@p int i7) {
        setItemIconSize(getResources().getDimensionPixelSize(i7));
    }

    public void setItemIconTintList(@o0 ColorStateList colorStateList) {
        this.f17963b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i7, @o0 View.OnTouchListener onTouchListener) {
        this.f17963b.setItemOnTouchListener(i7, onTouchListener);
    }

    public void setItemRippleColor(@o0 ColorStateList colorStateList) {
        if (this.f17965d == colorStateList) {
            if (colorStateList != null || this.f17963b.getItemBackground() == null) {
                return;
            }
            this.f17963b.setItemBackground(null);
            return;
        }
        this.f17965d = colorStateList;
        if (colorStateList == null) {
            this.f17963b.setItemBackground(null);
        } else {
            this.f17963b.setItemBackground(new RippleDrawable(com.google.android.material.ripple.b.a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(@b1 int i7) {
        this.f17963b.setItemTextAppearanceActive(i7);
    }

    public void setItemTextAppearanceInactive(@b1 int i7) {
        this.f17963b.setItemTextAppearanceInactive(i7);
    }

    public void setItemTextColor(@o0 ColorStateList colorStateList) {
        this.f17963b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i7) {
        if (this.f17963b.getLabelVisibilityMode() != i7) {
            this.f17963b.setLabelVisibilityMode(i7);
            this.f17964c.e(false);
        }
    }

    public void setOnItemReselectedListener(@o0 d dVar) {
        this.f17968g = dVar;
    }

    public void setOnItemSelectedListener(@o0 e eVar) {
        this.f17967f = eVar;
    }

    public void setSelectedItemId(@b0 int i7) {
        MenuItem menuItemFindItem = this.f17962a.findItem(i7);
        if (menuItemFindItem == null || this.f17962a.P(menuItemFindItem, this.f17964c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
