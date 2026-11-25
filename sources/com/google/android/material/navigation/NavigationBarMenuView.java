package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.core.util.v;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.interpolator.view.animation.b;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.z;
import c.b1;
import c.m0;
import c.o0;
import c.q;
import c.x0;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.l;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements o {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f17927t = 115;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f17928u = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[] f17929v = {R.attr.state_checked};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int[] f17930w = {-16842910};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final TransitionSet f17931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final View.OnClickListener f17932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v.a<NavigationBarItemView> f17933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final SparseArray<View.OnTouchListener> f17934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private NavigationBarItemView[] f17936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private ColorStateList f17939i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @q
    private int f17940j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f17941k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private final ColorStateList f17942l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @b1
    private int f17943m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @b1
    private int f17944n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f17945o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f17946p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @m0
    private SparseArray<BadgeDrawable> f17947q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private NavigationBarPresenter f17948r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private g f17949s;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.f17949s.P(itemData, NavigationBarMenuView.this.f17948r, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@m0 Context context) {
        super(context);
        this.f17933c = new v.c(5);
        this.f17934d = new SparseArray<>(5);
        this.f17937g = 0;
        this.f17938h = 0;
        this.f17947q = new SparseArray<>(5);
        this.f17942l = d(R.attr.textColorSecondary);
        AutoTransition autoTransition = new AutoTransition();
        this.f17931a = autoTransition;
        autoTransition.V0(0);
        autoTransition.t0(f17927t);
        autoTransition.v0(new b());
        autoTransition.I0(new l());
        this.f17932b = new a();
        n2.R1(this, 1);
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemViewB = this.f17933c.b();
        return navigationBarItemViewB == null ? f(getContext()) : navigationBarItemViewB;
    }

    private boolean k(int i7) {
        return i7 != -1;
    }

    private void m() {
        HashSet hashSet = new HashSet();
        for (int i7 = 0; i7 < this.f17949s.size(); i7++) {
            hashSet.add(Integer.valueOf(this.f17949s.getItem(i7).getItemId()));
        }
        for (int i8 = 0; i8 < this.f17947q.size(); i8++) {
            int iKeyAt = this.f17947q.keyAt(i8);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.f17947q.delete(iKeyAt);
            }
        }
    }

    private void p(int i7) {
        if (k(i7)) {
            return;
        }
        throw new IllegalArgumentException(i7 + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@m0 NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (k(id) && (badgeDrawable = this.f17947q.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f17933c.a(navigationBarItemView);
                    navigationBarItemView.i();
                }
            }
        }
        if (this.f17949s.size() == 0) {
            this.f17937g = 0;
            this.f17938h = 0;
            this.f17936f = null;
            return;
        }
        m();
        this.f17936f = new NavigationBarItemView[this.f17949s.size()];
        boolean zJ = j(this.f17935e, this.f17949s.H().size());
        for (int i7 = 0; i7 < this.f17949s.size(); i7++) {
            this.f17948r.l(true);
            this.f17949s.getItem(i7).setCheckable(true);
            this.f17948r.l(false);
            NavigationBarItemView newItem = getNewItem();
            this.f17936f[i7] = newItem;
            newItem.setIconTintList(this.f17939i);
            newItem.setIconSize(this.f17940j);
            newItem.setTextColor(this.f17942l);
            newItem.setTextAppearanceInactive(this.f17943m);
            newItem.setTextAppearanceActive(this.f17944n);
            newItem.setTextColor(this.f17941k);
            Drawable drawable = this.f17945o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f17946p);
            }
            newItem.setShifting(zJ);
            newItem.setLabelVisibilityMode(this.f17935e);
            j jVar = (j) this.f17949s.getItem(i7);
            newItem.g(jVar, 0);
            newItem.setItemPosition(i7);
            int itemId = jVar.getItemId();
            newItem.setOnTouchListener(this.f17934d.get(itemId));
            newItem.setOnClickListener(this.f17932b);
            int i8 = this.f17937g;
            if (i8 != 0 && itemId == i8) {
                this.f17938h = i7;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.f17949s.size() - 1, this.f17938h);
        this.f17938h = iMin;
        this.f17949s.getItem(iMin).setChecked(true);
    }

    @o0
    public ColorStateList d(int i7) {
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
        int[] iArr = f17930w;
        return new ColorStateList(new int[][]{iArr, f17929v, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i8, defaultColor});
    }

    @Override // androidx.appcompat.view.menu.o
    public void e(@m0 g gVar) {
        this.f17949s = gVar;
    }

    @m0
    protected abstract NavigationBarItemView f(@m0 Context context);

    @o0
    public NavigationBarItemView g(int i7) {
        p(i7);
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i7) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f17947q;
    }

    @o0
    public ColorStateList getIconTintList() {
        return this.f17939i;
    }

    @o0
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f17945o : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f17946p;
    }

    @q
    public int getItemIconSize() {
        return this.f17940j;
    }

    @b1
    public int getItemTextAppearanceActive() {
        return this.f17944n;
    }

    @b1
    public int getItemTextAppearanceInactive() {
        return this.f17943m;
    }

    @o0
    public ColorStateList getItemTextColor() {
        return this.f17941k;
    }

    public int getLabelVisibilityMode() {
        return this.f17935e;
    }

    @o0
    protected g getMenu() {
        return this.f17949s;
    }

    public int getSelectedItemId() {
        return this.f17937g;
    }

    protected int getSelectedItemPosition() {
        return this.f17938h;
    }

    @Override // androidx.appcompat.view.menu.o
    public int getWindowAnimations() {
        return 0;
    }

    @o0
    public BadgeDrawable h(int i7) {
        return this.f17947q.get(i7);
    }

    BadgeDrawable i(int i7) {
        p(i7);
        BadgeDrawable badgeDrawableD = this.f17947q.get(i7);
        if (badgeDrawableD == null) {
            badgeDrawableD = BadgeDrawable.d(getContext());
            this.f17947q.put(i7, badgeDrawableD);
        }
        NavigationBarItemView navigationBarItemViewG = g(i7);
        if (navigationBarItemViewG != null) {
            navigationBarItemViewG.setBadge(badgeDrawableD);
        }
        return badgeDrawableD;
    }

    protected boolean j(int i7, int i8) {
        if (i7 == -1) {
            if (i8 > 3) {
                return true;
            }
        } else if (i7 == 0) {
            return true;
        }
        return false;
    }

    void l(int i7) {
        p(i7);
        BadgeDrawable badgeDrawable = this.f17947q.get(i7);
        NavigationBarItemView navigationBarItemViewG = g(i7);
        if (navigationBarItemViewG != null) {
            navigationBarItemViewG.i();
        }
        if (badgeDrawable != null) {
            this.f17947q.remove(i7);
        }
    }

    void n(int i7) {
        int size = this.f17949s.size();
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = this.f17949s.getItem(i8);
            if (i7 == item.getItemId()) {
                this.f17937g = i7;
                this.f17938h = i8;
                item.setChecked(true);
                return;
            }
        }
    }

    public void o() {
        g gVar = this.f17949s;
        if (gVar == null || this.f17936f == null) {
            return;
        }
        int size = gVar.size();
        if (size != this.f17936f.length) {
            c();
            return;
        }
        int i7 = this.f17937g;
        for (int i8 = 0; i8 < size; i8++) {
            MenuItem item = this.f17949s.getItem(i8);
            if (item.isChecked()) {
                this.f17937g = item.getItemId();
                this.f17938h = i8;
            }
        }
        if (i7 != this.f17937g) {
            z.b(this, this.f17931a);
        }
        boolean zJ = j(this.f17935e, this.f17949s.H().size());
        for (int i9 = 0; i9 < size; i9++) {
            this.f17948r.l(true);
            this.f17936f[i9].setLabelVisibilityMode(this.f17935e);
            this.f17936f[i9].setShifting(zJ);
            this.f17936f[i9].g((j) this.f17949s.getItem(i9), 0);
            this.f17948r.l(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        l0.X1(accessibilityNodeInfo).Y0(l0.b.f(1, this.f17949s.H().size(), false, 1));
    }

    void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.f17947q = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(@o0 ColorStateList colorStateList) {
        this.f17939i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@o0 Drawable drawable) {
        this.f17945o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i7) {
        this.f17946p = i7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i7);
            }
        }
    }

    public void setItemIconSize(@q int i7) {
        this.f17940j = i7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i7);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i7, @o0 View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f17934d.remove(i7);
        } else {
            this.f17934d.put(i7, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i7) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@b1 int i7) {
        this.f17944n = i7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i7);
                ColorStateList colorStateList = this.f17941k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@b1 int i7) {
        this.f17943m = i7;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i7);
                ColorStateList colorStateList = this.f17941k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@o0 ColorStateList colorStateList) {
        this.f17941k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f17936f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i7) {
        this.f17935e = i7;
    }

    public void setPresenter(@m0 NavigationBarPresenter navigationBarPresenter) {
        this.f17948r = navigationBarPresenter;
    }
}
