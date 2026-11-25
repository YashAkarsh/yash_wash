package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.n2;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements androidx.core.view.v0 {
    private static final String R = "Toolbar";
    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    final androidx.core.view.y0 G;
    private ArrayList<MenuItem> H;
    e I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final ActionMenuView.d f1654J;
    private j1 K;
    private ActionMenuPresenter L;
    private d M;
    private androidx.appcompat.view.menu.n.a N;
    private androidx.appcompat.view.menu.g.a O;
    private boolean P;
    private final Runnable Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ActionMenuView f1655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f1656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f1657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageButton f1658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f1659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f1660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f1661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ImageButton f1662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    View f1663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f1664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f1668n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f1669o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f1670p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f1671q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f1672r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f1673s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private y0 f1674t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f1675u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f1676v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1677w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f1678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private CharSequence f1679y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f1680z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1686d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f1685c);
            parcel.writeInt(this.f1686d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1685c = parcel.readInt();
            this.f1686d = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class a implements ActionMenuView.d {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.d
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.G.j(menuItem)) {
                return true;
            }
            e eVar = Toolbar.this.I;
            if (eVar != null) {
                return eVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.L();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements androidx.appcompat.view.menu.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.g f1690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.j f1691b;

        d() {
        }

        @Override // androidx.appcompat.view.menu.n
        public int a() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.n
        public void d(androidx.appcompat.view.menu.g gVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.n
        public void e(boolean z7) {
            if (this.f1691b != null) {
                androidx.appcompat.view.menu.g gVar = this.f1690a;
                boolean z8 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f1690a.getItem(i7) == this.f1691b) {
                            z8 = true;
                            break;
                        }
                    }
                }
                if (z8) {
                    return;
                }
                g(this.f1690a, this.f1691b);
            }
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean f() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean g(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
            KeyEvent.Callback callback = Toolbar.this.f1663i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1663i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1662h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1663i = null;
            toolbar3.a();
            this.f1691b = null;
            Toolbar.this.requestLayout();
            jVar.t(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean h(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1662h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1662h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1662h);
            }
            Toolbar.this.f1663i = jVar.getActionView();
            this.f1691b = jVar;
            ViewParent parent2 = Toolbar.this.f1663i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1663i);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                layoutParamsGenerateDefaultLayoutParams.f628a = (toolbar4.f1668n & 112) | androidx.core.view.n0.f6717b;
                layoutParamsGenerateDefaultLayoutParams.f1684b = 2;
                toolbar4.f1663i.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1663i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            jVar.t(true);
            KeyEvent.Callback callback = Toolbar.this.f1663i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).b();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.n
        public void i(androidx.appcompat.view.menu.n.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.n
        public void j(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.j jVar;
            androidx.appcompat.view.menu.g gVar2 = this.f1690a;
            if (gVar2 != null && (jVar = this.f1691b) != null) {
                gVar2.g(jVar);
            }
            this.f1690a = gVar;
        }

        @Override // androidx.appcompat.view.menu.n
        public void k(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean m(androidx.appcompat.view.menu.s sVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n
        public androidx.appcompat.view.menu.o n(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.n
        public Parcelable o() {
            return null;
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(@c.m0 Context context) {
        this(context, null);
    }

    private int C(View view, int i7, int[] iArr, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = i7 + Math.max(0, i9);
        iArr[0] = Math.max(0, -i9);
        int iQ = q(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int D(View view, int i7, int[] iArr, int i8) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i7 - Math.max(0, i9);
        iArr[1] = Math.max(0, -i9);
        int iQ = q(view, i8);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int E(View view, int i7, int i8, int i9, int i10, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i11 = marginLayoutParams.leftMargin - iArr[0];
        int i12 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i11) + Math.max(0, i12);
        iArr[0] = Math.max(0, -i11);
        iArr[1] = Math.max(0, -i12);
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + iMax + i8, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i9, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i7, int i8, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i9, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i11 >= 0) {
            if (mode != 0) {
                i11 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i11);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.G.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
        this.G.k(menu);
    }

    private void H() {
        removeCallbacks(this.Q);
        post(this.Q);
    }

    private boolean J() {
        if (!this.P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (K(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean K(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i7) {
        boolean z7 = n2.Z(this) == 1;
        int childCount = getChildCount();
        int iD = androidx.core.view.n0.d(i7, n2.Z(this));
        list.clear();
        if (!z7) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1684b == 0 && K(childAt) && p(layoutParams.f628a) == iD) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i9 = childCount - 1; i9 >= 0; i9--) {
            View childAt2 = getChildAt(i9);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1684b == 0 && K(childAt2) && p(layoutParams2.f628a) == iD) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z7) {
        LayoutParams layoutParamsGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParamsGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        }
        layoutParamsGenerateLayoutParams.f1684b = 1;
        if (!z7 || this.f1663i == null) {
            addView(view, layoutParamsGenerateLayoutParams);
        } else {
            view.setLayoutParams(layoutParamsGenerateLayoutParams);
            this.E.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i7 = 0; i7 < menu.size(); i7++) {
            arrayList.add(menu.getItem(i7));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f1674t == null) {
            this.f1674t = new y0();
        }
    }

    private void i() {
        if (this.f1659e == null) {
            this.f1659e = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.f1655a.Q() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f1655a.getMenu();
            if (this.M == null) {
                this.M = new d();
            }
            this.f1655a.setExpandedActionViewsExclusive(true);
            gVar.c(this.M, this.f1664j);
        }
    }

    private void k() {
        if (this.f1655a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1655a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1665k);
            this.f1655a.setOnMenuItemClickListener(this.f1654J);
            this.f1655a.setMenuCallbacks(this.N, this.O);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f628a = (this.f1668n & 112) | androidx.core.view.n0.f6718c;
            this.f1655a.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            c(this.f1655a, false);
        }
    }

    private void l() {
        if (this.f1658d == null) {
            this.f1658d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f628a = (this.f1668n & 112) | androidx.core.view.n0.f6717b;
            this.f1658d.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    private int p(int i7) {
        int iZ = n2.Z(this);
        int iD = androidx.core.view.n0.d(i7, iZ) & 7;
        if (iD == 1 || iD == 3 || iD == 5) {
            return iD;
        }
        return iZ == 1 ? 5 : 3;
    }

    private int q(View view, int i7) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i7 > 0 ? (measuredHeight - i7) / 2 : 0;
        int iR = r(layoutParams.f628a);
        if (iR == 48) {
            return getPaddingTop() - i8;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i8;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i9) {
            iMax = i9;
        } else {
            int i10 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i10 < i11) {
                iMax = Math.max(0, iMax - (i11 - i10));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i7) {
        int i8 = i7 & 112;
        return (i8 == 16 || i8 == 48 || i8 == 80) ? i8 : this.f1677w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.s0.c(marginLayoutParams) + androidx.core.view.s0.b(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i7 = iArr[0];
        int i8 = iArr[1];
        int size = list.size();
        int i9 = 0;
        int measuredWidth = 0;
        while (i9 < size) {
            View view = list.get(i9);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i7;
            int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i8;
            int iMax = Math.max(0, i10);
            int iMax2 = Math.max(0, i11);
            int iMax3 = Math.max(0, -i10);
            int iMax4 = Math.max(0, -i11);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i9++;
            i8 = iMax4;
            i7 = iMax3;
        }
        return measuredWidth;
    }

    private boolean y(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f1655a;
        return actionMenuView != null && actionMenuView.M();
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean B() {
        Layout layout;
        TextView textView = this.f1656b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i7 = 0; i7 < lineCount; i7++) {
            if (layout.getEllipsisCount(i7) > 0) {
                return true;
            }
        }
        return false;
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).f1684b != 2 && childAt != this.f1655a) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public boolean L() {
        ActionMenuView actionMenuView = this.f1655a;
        return actionMenuView != null && actionMenuView.R();
    }

    void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView(this.E.get(size));
        }
        this.E.clear();
    }

    @Override // androidx.core.view.v0
    @c.j0
    public void addMenuProvider(@c.m0 androidx.core.view.p1 p1Var) {
        this.G.c(p1Var);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1655a) != null && actionMenuView.N();
    }

    public void e() {
        d dVar = this.M;
        androidx.appcompat.view.menu.j jVar = dVar == null ? null : dVar.f1691b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1655a;
        if (actionMenuView != null) {
            actionMenuView.E();
        }
    }

    void g() {
        if (this.f1662h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f1662h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1660f);
            this.f1662h.setContentDescription(this.f1661g);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.f628a = (this.f1668n & 112) | androidx.core.view.n0.f6717b;
            layoutParamsGenerateDefaultLayoutParams.f1684b = 2;
            this.f1662h.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.f1662h.setOnClickListener(new c());
        }
    }

    @c.o0
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1662h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @c.o0
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1662h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        y0 y0Var = this.f1674t;
        if (y0Var != null) {
            return y0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i7 = this.f1676v;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        y0 y0Var = this.f1674t;
        if (y0Var != null) {
            return y0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        y0 y0Var = this.f1674t;
        if (y0Var != null) {
            return y0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        y0 y0Var = this.f1674t;
        if (y0Var != null) {
            return y0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i7 = this.f1675u;
        return i7 != Integer.MIN_VALUE ? i7 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g gVarQ;
        ActionMenuView actionMenuView = this.f1655a;
        return actionMenuView != null && (gVarQ = actionMenuView.Q()) != null && gVarQ.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f1676v, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return n2.Z(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return n2.Z(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1675u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1659e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1659e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f1655a.getMenu();
    }

    @c.o0
    @c.x0({c.x0.a.TESTS})
    View getNavButtonView() {
        return this.f1658d;
    }

    @c.o0
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1658d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @c.o0
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1658d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.L;
    }

    @c.o0
    public Drawable getOverflowIcon() {
        j();
        return this.f1655a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1664j;
    }

    @c.b1
    public int getPopupTheme() {
        return this.f1665k;
    }

    public CharSequence getSubtitle() {
        return this.f1679y;
    }

    @c.o0
    @c.x0({c.x0.a.TESTS})
    final TextView getSubtitleTextView() {
        return this.f1657c;
    }

    public CharSequence getTitle() {
        return this.f1678x;
    }

    public int getTitleMarginBottom() {
        return this.f1673s;
    }

    public int getTitleMarginEnd() {
        return this.f1671q;
    }

    public int getTitleMarginStart() {
        return this.f1670p;
    }

    public int getTitleMarginTop() {
        return this.f1672r;
    }

    @c.o0
    @c.x0({c.x0.a.TESTS})
    final TextView getTitleTextView() {
        return this.f1656b;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public f0 getWrapper() {
        if (this.K == null) {
            this.K = new j1(this, true);
        }
        return this.K;
    }

    @Override // androidx.core.view.v0
    @c.j0
    public void invalidateMenu() {
        Iterator<MenuItem> it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0289  */
    /* JADX WARN: Code duplicated, block: B:102:0x028c  */
    /* JADX WARN: Code duplicated, block: B:105:0x029f A[LOOP:0: B:104:0x029d->B:105:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02c1 A[LOOP:1: B:107:0x02bf->B:108:0x02c1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x02eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:114:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02fa A[LOOP:2: B:116:0x02f8->B:117:0x02fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x011d  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0168  */
    /* JADX WARN: Code duplicated, block: B:68:0x016c  */
    /* JADX WARN: Code duplicated, block: B:70:0x017e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x018c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0198  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x021b  */
    /* JADX WARN: Code duplicated, block: B:89:0x021e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0229  */
    /* JADX WARN: Code duplicated, block: B:93:0x022d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0241  */
    /* JADX WARN: Code duplicated, block: B:97:0x0264  */
    /* JADX WARN: Code duplicated, block: B:99:0x0267  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int iC;
        int iD;
        int iMax;
        int iMin;
        boolean zK;
        boolean zK2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z8;
        int i11;
        int i12;
        int paddingTop;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iMax2;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int size;
        int i25;
        int i26;
        int size2;
        int i27;
        int i28;
        int i29;
        int size3;
        boolean z9 = n2.Z(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i30 = width - paddingRight;
        int[] iArr = this.F;
        iArr[1] = 0;
        iArr[0] = 0;
        int iE0 = n2.e0(this);
        int iMin2 = iE0 >= 0 ? Math.min(iE0, i10 - i8) : 0;
        if (K(this.f1658d)) {
            if (z9) {
                iD = D(this.f1658d, i30, iArr, iMin2);
                iC = paddingLeft;
            } else {
                iC = C(this.f1658d, paddingLeft, iArr, iMin2);
            }
            if (K(this.f1662h)) {
                if (z9) {
                    iD = D(this.f1662h, iD, iArr, iMin2);
                } else {
                    iC = C(this.f1662h, iC, iArr, iMin2);
                }
            }
            if (K(this.f1655a)) {
                if (z9) {
                    iC = C(this.f1655a, iC, iArr, iMin2);
                } else {
                    iD = D(this.f1655a, iD, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iC);
            iArr[1] = Math.max(0, currentContentInsetRight - (i30 - iD));
            iMax = Math.max(iC, currentContentInsetLeft);
            iMin = Math.min(iD, i30 - currentContentInsetRight);
            if (K(this.f1663i)) {
                if (z9) {
                    iMin = D(this.f1663i, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.f1663i, iMax, iArr, iMin2);
                }
            }
            if (K(this.f1659e)) {
                if (z9) {
                    iMin = D(this.f1659e, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.f1659e, iMax, iArr, iMin2);
                }
            }
            zK = K(this.f1656b);
            zK2 = K(this.f1657c);
            if (zK) {
                LayoutParams layoutParams3 = (LayoutParams) this.f1656b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.f1656b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + 0;
            } else {
                measuredHeight = 0;
            }
            if (zK2) {
                LayoutParams layoutParams4 = (LayoutParams) this.f1657c.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + this.f1657c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin;
            }
            if (!zK || zK2) {
                if (zK) {
                    textView = this.f1656b;
                } else {
                    textView = this.f1657c;
                }
                if (zK2) {
                    textView2 = this.f1657c;
                } else {
                    textView2 = this.f1656b;
                }
                layoutParams = (LayoutParams) textView.getLayoutParams();
                layoutParams2 = (LayoutParams) textView2.getLayoutParams();
                z8 = (!zK && this.f1656b.getMeasuredWidth() > 0) || (zK2 && this.f1657c.getMeasuredWidth() > 0);
                i11 = this.f1677w & 112;
                i12 = paddingLeft;
                if (i11 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f1672r;
                } else if (i11 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i20 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i21 = this.f1672r;
                    if (iMax2 < i20 + i21) {
                        iMax2 = i20 + i21;
                    } else {
                        i22 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        i24 = this.f1673s;
                        if (i22 < i23 + i24) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f1673s) - measuredHeight;
                }
                if (z9) {
                    if (z8) {
                        i17 = this.f1670p;
                    } else {
                        i17 = 0;
                    }
                    int i31 = i17 - iArr[1];
                    iMin -= Math.max(0, i31);
                    iArr[1] = Math.max(0, -i31);
                    if (zK) {
                        LayoutParams layoutParams5 = (LayoutParams) this.f1656b.getLayoutParams();
                        int measuredWidth = iMin - this.f1656b.getMeasuredWidth();
                        int measuredHeight2 = this.f1656b.getMeasuredHeight() + paddingTop;
                        this.f1656b.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i18 = measuredWidth - this.f1671q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                    } else {
                        i18 = iMin;
                    }
                    if (zK2) {
                        int i32 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                        this.f1657c.layout(iMin - this.f1657c.getMeasuredWidth(), i32, iMin, this.f1657c.getMeasuredHeight() + i32);
                        i19 = iMin - this.f1671q;
                    } else {
                        i19 = iMin;
                    }
                    if (z8) {
                        iMin = Math.min(i18, i19);
                    }
                    iMax = iMax;
                } else {
                    if (z8) {
                        i14 = this.f1670p;
                        i13 = 0;
                    } else {
                        i13 = 0;
                        i14 = 0;
                    }
                    int i33 = i14 - iArr[i13];
                    iMax += Math.max(i13, i33);
                    iArr[i13] = Math.max(i13, -i33);
                    if (zK) {
                        LayoutParams layoutParams6 = (LayoutParams) this.f1656b.getLayoutParams();
                        int measuredWidth2 = this.f1656b.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.f1656b.getMeasuredHeight() + paddingTop;
                        this.f1656b.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i15 = measuredWidth2 + this.f1671q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                    } else {
                        i15 = iMax;
                    }
                    if (zK2) {
                        int i34 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f1657c.getMeasuredWidth() + iMax;
                        this.f1657c.layout(iMax, i34, measuredWidth3, this.f1657c.getMeasuredHeight() + i34);
                        i16 = measuredWidth3 + this.f1671q;
                    } else {
                        i16 = iMax;
                    }
                    if (z8) {
                        iMax = Math.max(i15, i16);
                    }
                }
                b(this.D, 3);
                size = this.D.size();
                for (i25 = i13; i25 < size; i25++) {
                    iMax = C(this.D.get(i25), iMax, iArr, iMin2);
                }
                i26 = iMin2;
                b(this.D, 5);
                size2 = this.D.size();
                for (i27 = i13; i27 < size2; i27++) {
                    iMin = D(this.D.get(i27), iMin, iArr, i26);
                }
                b(this.D, 1);
                int iU = u(this.D, iArr);
                i28 = (i12 + (((width - i12) - paddingRight) / 2)) - (iU / 2);
                i29 = iU + i28;
                if (i28 >= iMax) {
                    if (i29 > iMin) {
                        iMax = i28 - (i29 - iMin);
                    } else {
                        iMax = i28;
                    }
                }
                size3 = this.D.size();
                while (i13 < size3) {
                    iMax = C(this.D.get(i13), iMax, iArr, i26);
                    i13++;
                }
                this.D.clear();
            }
            i12 = paddingLeft;
            iMin2 = iMin2;
            i13 = 0;
            b(this.D, 3);
            size = this.D.size();
            while (i25 < size) {
                iMax = C(this.D.get(i25), iMax, iArr, iMin2);
            }
            i26 = iMin2;
            b(this.D, 5);
            size2 = this.D.size();
            while (i27 < size2) {
                iMin = D(this.D.get(i27), iMin, iArr, i26);
            }
            b(this.D, 1);
            int iU2 = u(this.D, iArr);
            i28 = (i12 + (((width - i12) - paddingRight) / 2)) - (iU2 / 2);
            i29 = iU2 + i28;
            if (i28 >= iMax) {
                if (i29 > iMin) {
                    iMax = i28 - (i29 - iMin);
                } else {
                    iMax = i28;
                }
            }
            size3 = this.D.size();
            while (i13 < size3) {
                iMax = C(this.D.get(i13), iMax, iArr, i26);
                i13++;
            }
            this.D.clear();
        }
        iC = paddingLeft;
        iD = i30;
        if (K(this.f1662h)) {
            if (z9) {
                iD = D(this.f1662h, iD, iArr, iMin2);
            } else {
                iC = C(this.f1662h, iC, iArr, iMin2);
            }
        }
        if (K(this.f1655a)) {
            if (z9) {
                iC = C(this.f1655a, iC, iArr, iMin2);
            } else {
                iD = D(this.f1655a, iD, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iC);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i30 - iD));
        iMax = Math.max(iC, currentContentInsetLeft2);
        iMin = Math.min(iD, i30 - currentContentInsetRight2);
        if (K(this.f1663i)) {
            if (z9) {
                iMin = D(this.f1663i, iMin, iArr, iMin2);
            } else {
                iMax = C(this.f1663i, iMax, iArr, iMin2);
            }
        }
        if (K(this.f1659e)) {
            if (z9) {
                iMin = D(this.f1659e, iMin, iArr, iMin2);
            } else {
                iMax = C(this.f1659e, iMax, iArr, iMin2);
            }
        }
        zK = K(this.f1656b);
        zK2 = K(this.f1657c);
        if (zK) {
            LayoutParams layoutParams7 = (LayoutParams) this.f1656b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin + this.f1656b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin + 0;
        } else {
            measuredHeight = 0;
        }
        if (zK2) {
            LayoutParams layoutParams8 = (LayoutParams) this.f1657c.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + this.f1657c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin;
        }
        if (zK) {
            if (zK) {
                textView = this.f1656b;
            } else {
                textView = this.f1657c;
            }
            if (zK2) {
                textView2 = this.f1657c;
            } else {
                textView2 = this.f1656b;
            }
            layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams2 = (LayoutParams) textView2.getLayoutParams();
            if (zK) {
            }
            i11 = this.f1677w & 112;
            i12 = paddingLeft;
            if (i11 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f1672r;
            } else if (i11 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i20 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                i21 = this.f1672r;
                if (iMax2 < i20 + i21) {
                    iMax2 = i20 + i21;
                } else {
                    i22 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i24 = this.f1673s;
                    if (i22 < i23 + i24) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f1673s) - measuredHeight;
            }
            if (z9) {
                if (z8) {
                    i17 = this.f1670p;
                } else {
                    i17 = 0;
                }
                int i35 = i17 - iArr[1];
                iMin -= Math.max(0, i35);
                iArr[1] = Math.max(0, -i35);
                if (zK) {
                    LayoutParams layoutParams9 = (LayoutParams) this.f1656b.getLayoutParams();
                    int measuredWidth4 = iMin - this.f1656b.getMeasuredWidth();
                    int measuredHeight4 = this.f1656b.getMeasuredHeight() + paddingTop;
                    this.f1656b.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i18 = measuredWidth4 - this.f1671q;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin;
                } else {
                    i18 = iMin;
                }
                if (zK2) {
                    int i36 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                    this.f1657c.layout(iMin - this.f1657c.getMeasuredWidth(), i36, iMin, this.f1657c.getMeasuredHeight() + i36);
                    i19 = iMin - this.f1671q;
                } else {
                    i19 = iMin;
                }
                if (z8) {
                    iMin = Math.min(i18, i19);
                }
                iMax = iMax;
                i13 = 0;
            } else {
                if (z8) {
                    i14 = this.f1670p;
                    i13 = 0;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i37 = i14 - iArr[i13];
                iMax += Math.max(i13, i37);
                iArr[i13] = Math.max(i13, -i37);
                if (zK) {
                    LayoutParams layoutParams10 = (LayoutParams) this.f1656b.getLayoutParams();
                    int measuredWidth5 = this.f1656b.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.f1656b.getMeasuredHeight() + paddingTop;
                    this.f1656b.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i15 = measuredWidth5 + this.f1671q;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin;
                } else {
                    i15 = iMax;
                }
                if (zK2) {
                    int i38 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.f1657c.getMeasuredWidth() + iMax;
                    this.f1657c.layout(iMax, i38, measuredWidth6, this.f1657c.getMeasuredHeight() + i38);
                    i16 = measuredWidth6 + this.f1671q;
                } else {
                    i16 = iMax;
                }
                if (z8) {
                    iMax = Math.max(i15, i16);
                }
            }
        } else {
            if (zK) {
                textView = this.f1656b;
            } else {
                textView = this.f1657c;
            }
            if (zK2) {
                textView2 = this.f1657c;
            } else {
                textView2 = this.f1656b;
            }
            layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams2 = (LayoutParams) textView2.getLayoutParams();
            if (zK) {
            }
            i11 = this.f1677w & 112;
            i12 = paddingLeft;
            if (i11 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.f1672r;
            } else if (i11 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i20 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                i21 = this.f1672r;
                if (iMax2 < i20 + i21) {
                    iMax2 = i20 + i21;
                } else {
                    i22 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i23 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i24 = this.f1673s;
                    if (i22 < i23 + i24) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24) - i22));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.f1673s) - measuredHeight;
            }
            if (z9) {
                if (z8) {
                    i17 = this.f1670p;
                } else {
                    i17 = 0;
                }
                int i39 = i17 - iArr[1];
                iMin -= Math.max(0, i39);
                iArr[1] = Math.max(0, -i39);
                if (zK) {
                    LayoutParams layoutParams11 = (LayoutParams) this.f1656b.getLayoutParams();
                    int measuredWidth7 = iMin - this.f1656b.getMeasuredWidth();
                    int measuredHeight6 = this.f1656b.getMeasuredHeight() + paddingTop;
                    this.f1656b.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i18 = measuredWidth7 - this.f1671q;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin;
                } else {
                    i18 = iMin;
                }
                if (zK2) {
                    int i310 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                    this.f1657c.layout(iMin - this.f1657c.getMeasuredWidth(), i310, iMin, this.f1657c.getMeasuredHeight() + i310);
                    i19 = iMin - this.f1671q;
                } else {
                    i19 = iMin;
                }
                if (z8) {
                    iMin = Math.min(i18, i19);
                }
                iMax = iMax;
                i13 = 0;
            } else {
                if (z8) {
                    i14 = this.f1670p;
                    i13 = 0;
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                int i311 = i14 - iArr[i13];
                iMax += Math.max(i13, i311);
                iArr[i13] = Math.max(i13, -i311);
                if (zK) {
                    LayoutParams layoutParams12 = (LayoutParams) this.f1656b.getLayoutParams();
                    int measuredWidth8 = this.f1656b.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.f1656b.getMeasuredHeight() + paddingTop;
                    this.f1656b.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i15 = measuredWidth8 + this.f1671q;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin;
                } else {
                    i15 = iMax;
                }
                if (zK2) {
                    int i312 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.f1657c.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.f1657c.getMeasuredWidth() + iMax;
                    this.f1657c.layout(iMax, i312, measuredWidth9, this.f1657c.getMeasuredHeight() + i312);
                    i16 = measuredWidth9 + this.f1671q;
                } else {
                    i16 = iMax;
                }
                if (z8) {
                    iMax = Math.max(i15, i16);
                }
            }
        }
        b(this.D, 3);
        size = this.D.size();
        while (i25 < size) {
            iMax = C(this.D.get(i25), iMax, iArr, iMin2);
        }
        i26 = iMin2;
        b(this.D, 5);
        size2 = this.D.size();
        while (i27 < size2) {
            iMin = D(this.D.get(i27), iMin, iArr, i26);
        }
        b(this.D, 1);
        int iU3 = u(this.D, iArr);
        i28 = (i12 + (((width - i12) - paddingRight) / 2)) - (iU3 / 2);
        i29 = iU3 + i28;
        if (i28 >= iMax) {
            if (i29 > iMin) {
                iMax = i28 - (i29 - iMin);
            } else {
                iMax = i28;
            }
        }
        size3 = this.D.size();
        while (i13 < size3) {
            iMax = C(this.D.get(i13), iMax, iArr, i26);
            i13++;
        }
        this.D.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.F;
        boolean zB = r1.b(this);
        int i9 = !zB ? 1 : 0;
        if (K(this.f1658d)) {
            F(this.f1658d, i7, 0, i8, 0, this.f1669o);
            measuredWidth = this.f1658d.getMeasuredWidth() + s(this.f1658d);
            iMax = Math.max(0, this.f1658d.getMeasuredHeight() + t(this.f1658d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1658d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (K(this.f1662h)) {
            F(this.f1662h, i7, 0, i8, 0, this.f1669o);
            measuredWidth = this.f1662h.getMeasuredWidth() + s(this.f1662h);
            iMax = Math.max(iMax, this.f1662h.getMeasuredHeight() + t(this.f1662h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1662h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (K(this.f1655a)) {
            F(this.f1655a, i7, iMax3, i8, 0, this.f1669o);
            measuredWidth2 = this.f1655a.getMeasuredWidth() + s(this.f1655a);
            iMax = Math.max(iMax, this.f1655a.getMeasuredHeight() + t(this.f1655a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1655a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i9] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (K(this.f1663i)) {
            iMax4 += E(this.f1663i, i7, iMax4, i8, 0, iArr);
            iMax = Math.max(iMax, this.f1663i.getMeasuredHeight() + t(this.f1663i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1663i.getMeasuredState());
        }
        if (K(this.f1659e)) {
            iMax4 += E(this.f1659e, i7, iMax4, i8, 0, iArr);
            iMax = Math.max(iMax, this.f1659e.getMeasuredHeight() + t(this.f1659e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1659e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((LayoutParams) childAt.getLayoutParams()).f1684b == 0 && K(childAt)) {
                iMax4 += E(childAt, i7, iMax4, i8, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i11 = this.f1672r + this.f1673s;
        int i12 = this.f1670p + this.f1671q;
        if (K(this.f1656b)) {
            E(this.f1656b, i7, iMax4 + i12, i8, i11, iArr);
            int measuredWidth3 = this.f1656b.getMeasuredWidth() + s(this.f1656b);
            measuredHeight = this.f1656b.getMeasuredHeight() + t(this.f1656b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1656b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (K(this.f1657c)) {
            iMax2 = Math.max(iMax2, E(this.f1657c, i7, iMax4 + i12, i8, measuredHeight + i11, iArr));
            measuredHeight += this.f1657c.getMeasuredHeight() + t(this.f1657c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1657c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i7, (-16777216) & iCombineMeasuredStates2), J() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i8, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f1655a;
        androidx.appcompat.view.menu.g gVarQ = actionMenuView != null ? actionMenuView.Q() : null;
        int i7 = savedState.f1685c;
        if (i7 != 0 && this.M != null && gVarQ != null && (menuItemFindItem = gVarQ.findItem(i7)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f1686d) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i7) {
        super.onRtlPropertiesChanged(i7);
        h();
        this.f1674t.f(i7 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.j jVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.M;
        if (dVar != null && (jVar = dVar.f1691b) != null) {
            savedState.f1685c = jVar.getItemId();
        }
        savedState.f1686d = A();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    @Override // androidx.core.view.v0
    @c.j0
    public void removeMenuProvider(@c.m0 androidx.core.view.p1 p1Var) {
        this.G.l(p1Var);
    }

    public void setCollapseContentDescription(@c.a1 int i7) {
        setCollapseContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setCollapseIcon(@c.u int i7) {
        setCollapseIcon(e.a.b(getContext(), i7));
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z7) {
        this.P = z7;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.f1676v) {
            this.f1676v = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i7) {
        if (i7 < 0) {
            i7 = Integer.MIN_VALUE;
        }
        if (i7 != this.f1675u) {
            this.f1675u = i7;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i7, int i8) {
        h();
        this.f1674t.e(i7, i8);
    }

    public void setContentInsetsRelative(int i7, int i8) {
        h();
        this.f1674t.g(i7, i8);
    }

    public void setLogo(@c.u int i7) {
        setLogo(e.a.b(getContext(), i7));
    }

    public void setLogoDescription(@c.a1 int i7) {
        setLogoDescription(getContext().getText(i7));
    }

    @c.x0({c.x0.a.LIBRARY})
    public void setMenu(androidx.appcompat.view.menu.g gVar, ActionMenuPresenter actionMenuPresenter) {
        if (gVar == null && this.f1655a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.g gVarQ = this.f1655a.Q();
        if (gVarQ == gVar) {
            return;
        }
        if (gVarQ != null) {
            gVarQ.S(this.L);
            gVarQ.S(this.M);
        }
        if (this.M == null) {
            this.M = new d();
        }
        actionMenuPresenter.L(true);
        if (gVar != null) {
            gVar.c(actionMenuPresenter, this.f1664j);
            gVar.c(this.M, this.f1664j);
        } else {
            actionMenuPresenter.j(this.f1664j, null);
            this.M.j(this.f1664j, null);
            actionMenuPresenter.e(true);
            this.M.e(true);
        }
        this.f1655a.setPopupTheme(this.f1665k);
        this.f1655a.setPresenter(actionMenuPresenter);
        this.L = actionMenuPresenter;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.N = aVar;
        this.O = aVar2;
        ActionMenuView actionMenuView = this.f1655a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(@c.a1 int i7) {
        setNavigationContentDescription(i7 != 0 ? getContext().getText(i7) : null);
    }

    public void setNavigationIcon(@c.u int i7) {
        setNavigationIcon(e.a.b(getContext(), i7));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f1658d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.I = eVar;
    }

    public void setOverflowIcon(@c.o0 Drawable drawable) {
        j();
        this.f1655a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@c.b1 int i7) {
        if (this.f1665k != i7) {
            this.f1665k = i7;
            if (i7 == 0) {
                this.f1664j = getContext();
            } else {
                this.f1664j = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    public void setSubtitle(@c.a1 int i7) {
        setSubtitle(getContext().getText(i7));
    }

    public void setSubtitleTextAppearance(Context context, @c.b1 int i7) {
        this.f1667m = i7;
        TextView textView = this.f1657c;
        if (textView != null) {
            textView.setTextAppearance(context, i7);
        }
    }

    public void setSubtitleTextColor(@c.l int i7) {
        setSubtitleTextColor(ColorStateList.valueOf(i7));
    }

    public void setTitle(@c.a1 int i7) {
        setTitle(getContext().getText(i7));
    }

    public void setTitleMargin(int i7, int i8, int i9, int i10) {
        this.f1670p = i7;
        this.f1672r = i8;
        this.f1671q = i9;
        this.f1673s = i10;
        requestLayout();
    }

    public void setTitleMarginBottom(int i7) {
        this.f1673s = i7;
        requestLayout();
    }

    public void setTitleMarginEnd(int i7) {
        this.f1671q = i7;
        requestLayout();
    }

    public void setTitleMarginStart(int i7) {
        this.f1670p = i7;
        requestLayout();
    }

    public void setTitleMarginTop(int i7) {
        this.f1672r = i7;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @c.b1 int i7) {
        this.f1666l = i7;
        TextView textView = this.f1656b;
        if (textView != null) {
            textView.setTextAppearance(context, i7);
        }
    }

    public void setTitleTextColor(@c.l int i7) {
        setTitleTextColor(ColorStateList.valueOf(i7));
    }

    public boolean v() {
        d dVar = this.M;
        return (dVar == null || dVar.f1691b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f1655a;
        return actionMenuView != null && actionMenuView.K();
    }

    public void x(@c.k0 int i7) {
        getMenuInflater().inflate(i7, getMenu());
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean z() {
        ActionMenuView actionMenuView = this.f1655a;
        return actionMenuView != null && actionMenuView.L();
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f1681c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f1682d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final int f1683e = 2;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1684b;

        public LayoutParams(@c.m0 Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1684b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f1684b = 0;
            this.f628a = 8388627;
        }

        public LayoutParams(int i7, int i8, int i9) {
            super(i7, i8);
            this.f1684b = 0;
            this.f628a = i9;
        }

        public LayoutParams(int i7) {
            this(-2, -1, i7);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1684b = 0;
            this.f1684b = layoutParams.f1684b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1684b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1684b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1684b = 0;
        }
    }

    public Toolbar(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    @Override // androidx.core.view.v0
    @c.j0
    public void addMenuProvider(@c.m0 androidx.core.view.p1 p1Var, @c.m0 androidx.lifecycle.q qVar) {
        this.G.d(p1Var, qVar);
    }

    public void setCollapseContentDescription(@c.o0 CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1662h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@c.o0 Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1662h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f1662h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f1660f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!y(this.f1659e)) {
                c(this.f1659e, true);
            }
        } else {
            ImageView imageView = this.f1659e;
            if (imageView != null && y(imageView)) {
                removeView(this.f1659e);
                this.E.remove(this.f1659e);
            }
        }
        ImageView imageView2 = this.f1659e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f1659e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@c.o0 CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f1658d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            l1.a(this.f1658d, charSequence);
        }
    }

    public void setNavigationIcon(@c.o0 Drawable drawable) {
        if (drawable != null) {
            l();
            if (!y(this.f1658d)) {
                c(this.f1658d, true);
            }
        } else {
            ImageButton imageButton = this.f1658d;
            if (imageButton != null && y(imageButton)) {
                removeView(this.f1658d);
                this.E.remove(this.f1658d);
            }
        }
        ImageButton imageButton2 = this.f1658d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1657c;
            if (textView != null && y(textView)) {
                removeView(this.f1657c);
                this.E.remove(this.f1657c);
            }
        } else {
            if (this.f1657c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1657c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1657c.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f1667m;
                if (i7 != 0) {
                    this.f1657c.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1657c.setTextColor(colorStateList);
                }
            }
            if (!y(this.f1657c)) {
                c(this.f1657c, true);
            }
        }
        TextView textView2 = this.f1657c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1679y = charSequence;
    }

    public void setSubtitleTextColor(@c.m0 ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1657c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f1656b;
            if (textView != null && y(textView)) {
                removeView(this.f1656b);
                this.E.remove(this.f1656b);
            }
        } else {
            if (this.f1656b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1656b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1656b.setEllipsize(TextUtils.TruncateAt.END);
                int i7 = this.f1666l;
                if (i7 != 0) {
                    this.f1656b.setTextAppearance(context, i7);
                }
                ColorStateList colorStateList = this.f1680z;
                if (colorStateList != null) {
                    this.f1656b.setTextColor(colorStateList);
                }
            }
            if (!y(this.f1656b)) {
                c(this.f1656b, true);
            }
        }
        TextView textView2 = this.f1656b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1678x = charSequence;
    }

    public void setTitleTextColor(@c.m0 ColorStateList colorStateList) {
        this.f1680z = colorStateList;
        TextView textView = this.f1656b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1677w = 8388627;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new int[2];
        this.G = new androidx.core.view.y0(new Runnable() { // from class: androidx.appcompat.widget.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.f1852a.invalidateMenu();
            }
        });
        this.H = new ArrayList<>();
        this.f1654J = new a();
        this.Q = new b();
        h1 h1VarG = h1.G(getContext(), attributeSet, R.styleable.Toolbar, i7, 0);
        n2.z1(this, context, R.styleable.Toolbar, attributeSet, h1VarG.B(), i7, 0);
        this.f1666l = h1VarG.u(R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1667m = h1VarG.u(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1677w = h1VarG.p(R.styleable.Toolbar_android_gravity, this.f1677w);
        this.f1668n = h1VarG.p(R.styleable.Toolbar_buttonGravity, 48);
        int iF = h1VarG.f(R.styleable.Toolbar_titleMargin, 0);
        iF = h1VarG.C(R.styleable.Toolbar_titleMargins) ? h1VarG.f(R.styleable.Toolbar_titleMargins, iF) : iF;
        this.f1673s = iF;
        this.f1672r = iF;
        this.f1671q = iF;
        this.f1670p = iF;
        int iF2 = h1VarG.f(R.styleable.Toolbar_titleMarginStart, -1);
        if (iF2 >= 0) {
            this.f1670p = iF2;
        }
        int iF3 = h1VarG.f(R.styleable.Toolbar_titleMarginEnd, -1);
        if (iF3 >= 0) {
            this.f1671q = iF3;
        }
        int iF4 = h1VarG.f(R.styleable.Toolbar_titleMarginTop, -1);
        if (iF4 >= 0) {
            this.f1672r = iF4;
        }
        int iF5 = h1VarG.f(R.styleable.Toolbar_titleMarginBottom, -1);
        if (iF5 >= 0) {
            this.f1673s = iF5;
        }
        this.f1669o = h1VarG.g(R.styleable.Toolbar_maxButtonHeight, -1);
        int iF6 = h1VarG.f(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iF7 = h1VarG.f(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iG = h1VarG.g(R.styleable.Toolbar_contentInsetLeft, 0);
        int iG2 = h1VarG.g(R.styleable.Toolbar_contentInsetRight, 0);
        h();
        this.f1674t.e(iG, iG2);
        if (iF6 != Integer.MIN_VALUE || iF7 != Integer.MIN_VALUE) {
            this.f1674t.g(iF6, iF7);
        }
        this.f1675u = h1VarG.f(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1676v = h1VarG.f(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1660f = h1VarG.h(R.styleable.Toolbar_collapseIcon);
        this.f1661g = h1VarG.x(R.styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceX = h1VarG.x(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceX)) {
            setTitle(charSequenceX);
        }
        CharSequence charSequenceX2 = h1VarG.x(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceX2)) {
            setSubtitle(charSequenceX2);
        }
        this.f1664j = getContext();
        setPopupTheme(h1VarG.u(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawableH = h1VarG.h(R.styleable.Toolbar_navigationIcon);
        if (drawableH != null) {
            setNavigationIcon(drawableH);
        }
        CharSequence charSequenceX3 = h1VarG.x(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceX3)) {
            setNavigationContentDescription(charSequenceX3);
        }
        Drawable drawableH2 = h1VarG.h(R.styleable.Toolbar_logo);
        if (drawableH2 != null) {
            setLogo(drawableH2);
        }
        CharSequence charSequenceX4 = h1VarG.x(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceX4)) {
            setLogoDescription(charSequenceX4);
        }
        if (h1VarG.C(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(h1VarG.d(R.styleable.Toolbar_titleTextColor));
        }
        if (h1VarG.C(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(h1VarG.d(R.styleable.Toolbar_subtitleTextColor));
        }
        if (h1VarG.C(R.styleable.Toolbar_menu)) {
            x(h1VarG.u(R.styleable.Toolbar_menu, 0));
        }
        h1VarG.I();
    }

    @Override // androidx.core.view.v0
    @SuppressLint({"LambdaLast"})
    @c.j0
    public void addMenuProvider(@c.m0 androidx.core.view.p1 p1Var, @c.m0 androidx.lifecycle.q qVar, @c.m0 androidx.lifecycle.m.c cVar) {
        this.G.e(p1Var, qVar, cVar);
    }
}
