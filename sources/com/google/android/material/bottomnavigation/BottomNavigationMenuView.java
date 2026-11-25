package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.core.view.n2;
import c.m0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int A;
    private final int B;
    private boolean C;
    private int[] D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f17115x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f17116y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f17117z;

    public BottomNavigationMenuView(@m0 Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f17115x = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f17116y = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f17117z = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.A = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.B = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.D = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @m0
    protected NavigationBarItemView f(@m0 Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        int measuredWidth = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                if (n2.Z(this) == 1) {
                    int i14 = i11 - measuredWidth;
                    childAt.layout(i14 - childAt.getMeasuredWidth(), 0, i14, i12);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i12);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        g menu = getMenu();
        int size = View.MeasureSpec.getSize(i7);
        int size2 = menu.H().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.B, 1073741824);
        if (j(getLabelVisibilityMode(), size2) && q()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.A;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f17117z, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i9 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f17116y * i9), Math.min(iMax, this.f17117z));
            int i10 = size - iMin;
            int iMin2 = Math.min(i10 / (i9 == 0 ? 1 : i9), this.f17115x);
            int i11 = i10 - (i9 * iMin2);
            int i12 = 0;
            while (i12 < childCount) {
                if (getChildAt(i12).getVisibility() != 8) {
                    this.D[i12] = i12 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i11 > 0) {
                        int[] iArr = this.D;
                        iArr[i12] = iArr[i12] + 1;
                        i11--;
                    }
                } else {
                    this.D[i12] = 0;
                }
                i12++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), this.f17117z);
            int i13 = size - (size2 * iMin3);
            for (int i14 = 0; i14 < childCount; i14++) {
                if (getChildAt(i14).getVisibility() != 8) {
                    int[] iArr2 = this.D;
                    iArr2[i14] = iMin3;
                    if (i13 > 0) {
                        iArr2[i14] = iMin3 + 1;
                        i13--;
                    }
                } else {
                    this.D[i14] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.D[i15], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(this.B, iMakeMeasureSpec, 0));
    }

    public boolean q() {
        return this.C;
    }

    public void setItemHorizontalTranslationEnabled(boolean z7) {
        this.C = z7;
    }
}
