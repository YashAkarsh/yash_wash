package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.o {
    private static final String N = "ActionMenuView";
    static final int O = 56;
    static final int P = 4;
    private androidx.appcompat.view.menu.g B;
    private Context C;
    private int D;
    private boolean E;
    private ActionMenuPresenter F;
    private androidx.appcompat.view.menu.n.a G;
    androidx.appcompat.view.menu.g.a H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f1367J;
    private int K;
    private int L;
    d M;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public int f1370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f1372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1373f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f1368a = layoutParams.f1368a;
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f1368a = false;
        }

        LayoutParams(int i7, int i8, boolean z7) {
            super(i7, i8);
            this.f1368a = z7;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean a();

        boolean c();
    }

    private static class b implements androidx.appcompat.view.menu.n.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void d(@c.m0 androidx.appcompat.view.menu.g gVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean e(@c.m0 androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    private class c implements androidx.appcompat.view.menu.g.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(@c.m0 androidx.appcompat.view.menu.g gVar, @c.m0 MenuItem menuItem) {
            d dVar = ActionMenuView.this.M;
            return dVar != null && dVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(@c.m0 androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.g.a aVar = ActionMenuView.this.H;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@c.m0 Context context) {
        this(context, null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    static int O(View view, int i7, int i8, int i9, int i10) {
        int i11;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i9) - i10, View.MeasureSpec.getMode(i9));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z7 = actionMenuItemView != null && actionMenuItemView.h();
        if (i8 > 0) {
            i11 = 2;
            if (!z7 || i8 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i8 * i7, Integer.MIN_VALUE), iMakeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i12 = measuredWidth / i7;
                if (measuredWidth % i7 != 0) {
                    i12++;
                }
                if (!z7 || i12 >= 2) {
                    i11 = i12;
                }
            } else {
                i11 = 0;
            }
        } else {
            i11 = 0;
        }
        layoutParams.f1371d = !layoutParams.f1368a && z7;
        layoutParams.f1369b = i11;
        view.measure(View.MeasureSpec.makeMeasureSpec(i7 * i11, 1073741824), iMakeMeasureSpec);
        return i11;
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void P(int i7, int i8) {
        boolean z7;
        int i9;
        int i10;
        boolean z8;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i7);
        int size2 = View.MeasureSpec.getSize(i8);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingTop, -2);
        int i11 = size - paddingLeft;
        int i12 = this.K;
        int i13 = i11 / i12;
        int i14 = i11 % i12;
        if (i13 == 0) {
            setMeasuredDimension(i11, 0);
            return;
        }
        int i15 = i12 + (i14 / i13);
        int childCount = getChildCount();
        int iMax = 0;
        int i16 = 0;
        boolean z9 = false;
        int i17 = 0;
        int iMax2 = 0;
        int i18 = 0;
        long j7 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            int i19 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z10 = childAt instanceof ActionMenuItemView;
                int i20 = i17 + 1;
                if (z10) {
                    int i21 = this.L;
                    r14 = 0;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    r14 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1373f = r14;
                layoutParams.f1370c = r14;
                layoutParams.f1369b = r14;
                layoutParams.f1371d = r14;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r14;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r14;
                layoutParams.f1372e = z10 && ((ActionMenuItemView) childAt).h();
                int iO = O(childAt, i15, layoutParams.f1368a ? 1 : i13, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iO);
                if (layoutParams.f1371d) {
                    i18++;
                }
                if (layoutParams.f1368a) {
                    z9 = true;
                }
                i13 -= iO;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iO == 1) {
                    j7 |= (long) (1 << i16);
                    iMax = iMax;
                }
                i17 = i20;
            }
            i16++;
            size2 = i19;
        }
        int i22 = size2;
        boolean z11 = z9 && i17 == 2;
        boolean z12 = false;
        while (true) {
            if (i18 <= 0 || i13 <= 0) {
                z7 = z12;
                i9 = iMax;
                break;
            }
            int i23 = Integer.MAX_VALUE;
            int i24 = 0;
            int i25 = 0;
            long j8 = 0;
            while (i25 < childCount) {
                boolean z13 = z12;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i25).getLayoutParams();
                int i26 = iMax;
                if (layoutParams2.f1371d) {
                    int i27 = layoutParams2.f1369b;
                    if (i27 < i23) {
                        j8 = 1 << i25;
                        i23 = i27;
                        i24 = 1;
                    } else if (i27 == i23) {
                        i24++;
                        j8 |= 1 << i25;
                    }
                }
                i25++;
                iMax = i26;
                z12 = z13;
            }
            z7 = z12;
            i9 = iMax;
            j7 |= j8;
            if (i24 > i13) {
                break;
            }
            int i28 = i23 + 1;
            int i29 = 0;
            while (i29 < childCount) {
                View childAt2 = getChildAt(i29);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i30 = i11;
                int i31 = mode;
                long j9 = 1 << i29;
                if ((j8 & j9) == 0) {
                    if (layoutParams3.f1369b == i28) {
                        j7 |= j9;
                    }
                    z11 = z11;
                } else {
                    if (z11 && layoutParams3.f1372e && i13 == 1) {
                        int i32 = this.L;
                        childAt2.setPadding(i32 + i15, 0, i32, 0);
                    }
                    layoutParams3.f1369b++;
                    layoutParams3.f1373f = true;
                    i13--;
                }
                i29++;
                mode = i31;
                i11 = i30;
                z11 = z11;
            }
            iMax = i9;
            z12 = true;
        }
        boolean z14 = !z9 && i17 == 1;
        if (i13 <= 0 || j7 == 0 || (i13 >= i17 - 1 && !z14 && iMax2 <= 1)) {
            i10 = 0;
            z8 = z7;
        } else {
            float fBitCount = Long.bitCount(j7);
            if (z14) {
                i10 = 0;
            } else {
                i10 = 0;
                if ((j7 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1372e) {
                    fBitCount -= 0.5f;
                }
                int i33 = childCount - 1;
                if ((j7 & ((long) (1 << i33))) != 0 && !((LayoutParams) getChildAt(i33).getLayoutParams()).f1372e) {
                    fBitCount -= 0.5f;
                }
            }
            int i34 = fBitCount > 0.0f ? (int) ((i13 * i15) / fBitCount) : i10;
            z8 = z7;
            for (int i35 = i10; i35 < childCount; i35++) {
                if ((j7 & ((long) (1 << i35))) != 0) {
                    View childAt3 = getChildAt(i35);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1370c = i34;
                        layoutParams4.f1373f = true;
                        if (i35 == 0 && !layoutParams4.f1372e) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i34) / 2;
                        }
                        z8 = true;
                    } else if (layoutParams4.f1368a) {
                        layoutParams4.f1370c = i34;
                        layoutParams4.f1373f = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i34) / 2;
                        z8 = true;
                    } else {
                        if (i35 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i34 / 2;
                        }
                        if (i35 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i34 / 2;
                        }
                    }
                }
            }
        }
        if (z8) {
            for (int i36 = i10; i36 < childCount; i36++) {
                View childAt4 = getChildAt(i36);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1373f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1369b * i15) + layoutParams5.f1370c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i11, mode != 1073741824 ? i9 : i22);
    }

    public void E() {
        ActionMenuPresenter actionMenuPresenter = this.F;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
        }
        return layoutParams2;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public LayoutParams I() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f1368a = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected boolean J(int i7) {
        boolean zA = false;
        if (i7 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i7 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i7);
        if (i7 < getChildCount() && (childAt instanceof a)) {
            zA = false | ((a) childAt).a();
        }
        return (i7 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).c();
    }

    public boolean K() {
        ActionMenuPresenter actionMenuPresenter = this.F;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean L() {
        ActionMenuPresenter actionMenuPresenter = this.F;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    public boolean M() {
        ActionMenuPresenter actionMenuPresenter = this.F;
        return actionMenuPresenter != null && actionMenuPresenter.I();
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean N() {
        return this.E;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public androidx.appcompat.view.menu.g Q() {
        return this.B;
    }

    public boolean R() {
        ActionMenuPresenter actionMenuPresenter = this.F;
        return actionMenuPresenter != null && actionMenuPresenter.R();
    }

    @Override // androidx.appcompat.view.menu.g.b
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean a(androidx.appcompat.view.menu.j jVar) {
        return this.B.O(jVar, 0);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void e(androidx.appcompat.view.menu.g gVar) {
        this.B = gVar;
    }

    public Menu getMenu() {
        if (this.B == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.B = gVar;
            gVar.X(new c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.F = actionMenuPresenter;
            actionMenuPresenter.P(true);
            ActionMenuPresenter actionMenuPresenter2 = this.F;
            androidx.appcompat.view.menu.n.a bVar = this.G;
            if (bVar == null) {
                bVar = new b();
            }
            actionMenuPresenter2.i(bVar);
            this.B.c(this.F, this.C);
            this.F.N(this);
        }
        return this.B;
    }

    @c.o0
    public Drawable getOverflowIcon() {
        getMenu();
        return this.F.E();
    }

    public int getPopupTheme() {
        return this.D;
    }

    @Override // androidx.appcompat.view.menu.o
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.F;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.e(false);
            if (this.F.I()) {
                this.F.F();
                this.F.R();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int width;
        int paddingLeft;
        if (!this.I) {
            super.onLayout(z7, i7, i8, i9, i10);
            return;
        }
        int childCount = getChildCount();
        int i11 = (i10 - i8) / 2;
        int dividerWidth = getDividerWidth();
        int i12 = i9 - i7;
        int paddingRight = (i12 - getPaddingRight()) - getPaddingLeft();
        boolean zB = r1.b(this);
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1368a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (J(i15)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i16 = i11 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i16, width, measuredHeight + i16);
                    paddingRight -= measuredWidth;
                    i13 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    J(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i12 / 2) - (measuredWidth2 / 2);
            int i18 = i11 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        int iMax = Math.max(0, i19 > 0 ? paddingRight / i19 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt3 = getChildAt(i20);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1368a) {
                    int i21 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i22 = i11 - (measuredHeight3 / 2);
                    childAt3.layout(i21 - measuredWidth3, i22, i21, measuredHeight3 + i22);
                    width2 = i21 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt4 = getChildAt(i23);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1368a) {
                int i24 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i11 - (measuredHeight4 / 2);
                childAt4.layout(i24, i25, i24 + measuredWidth4, measuredHeight4 + i25);
                paddingLeft2 = i24 + measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i7, int i8) {
        androidx.appcompat.view.menu.g gVar;
        boolean z7 = this.I;
        boolean z8 = View.MeasureSpec.getMode(i7) == 1073741824;
        this.I = z8;
        if (z7 != z8) {
            this.f1367J = 0;
        }
        int size = View.MeasureSpec.getSize(i7);
        if (this.I && (gVar = this.B) != null && size != this.f1367J) {
            this.f1367J = size;
            gVar.N(true);
        }
        int childCount = getChildCount();
        if (this.I && childCount > 0) {
            P(i7, i8);
            return;
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i9).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i7, i8);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z7) {
        this.F.L(z7);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.G = aVar;
        this.H = aVar2;
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.M = dVar;
    }

    public void setOverflowIcon(@c.o0 Drawable drawable) {
        getMenu();
        this.F.O(drawable);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z7) {
        this.E = z7;
    }

    public void setPopupTheme(@c.b1 int i7) {
        if (this.D != i7) {
            this.D = i7;
            if (i7 == 0) {
                this.C = getContext();
            } else {
                this.C = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.F = actionMenuPresenter;
        actionMenuPresenter.N(this);
    }

    public ActionMenuView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.K = (int) (56.0f * f8);
        this.L = (int) (f8 * 4.0f);
        this.C = context;
        this.D = 0;
    }
}
