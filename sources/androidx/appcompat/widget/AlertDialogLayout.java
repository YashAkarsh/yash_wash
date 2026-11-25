package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@c.o0 Context context) {
        super(context);
    }

    private void D(View view, int i7, int i8, int i9, int i10) {
        view.layout(i7, i8, i9 + i7, i10 + i8);
    }

    private static int E(View view) {
        int iE0 = n2.e0(view);
        if (iE0 > 0) {
            return iE0;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return E(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean F(int i7, int i8) {
        int iCombineMeasuredStates;
        int iE;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i7);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i7, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i7, 0);
            iE = E(view2);
            measuredHeight = view2.getMeasuredHeight() - iE;
            paddingTop += iE;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iE = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i7, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i10 = size - paddingTop;
        if (view2 != null) {
            int i11 = paddingTop - iE;
            int iMin = Math.min(i10, measuredHeight);
            if (iMin > 0) {
                i10 -= iMin;
                iE += iMin;
            }
            view2.measure(i7, View.MeasureSpec.makeMeasureSpec(iE, 1073741824));
            paddingTop = i11 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i10 > 0) {
            view3.measure(i7, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i10, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i7, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i8, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        m(childCount, i8);
        return true;
    }

    private void m(int i7, int i8) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i9 = 0; i9 < i7; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i10 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i8, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i10;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft();
        int i14 = i9 - i7;
        int paddingRight = i14 - getPaddingRight();
        int paddingRight2 = (i14 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i15 = gravity & 112;
        int i16 = gravity & androidx.core.view.n0.f6719d;
        int paddingTop = i15 != 16 ? i15 != 80 ? getPaddingTop() : ((getPaddingTop() + i10) - i8) - measuredHeight : getPaddingTop() + (((i10 - i8) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i18 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i18 < 0) {
                    i18 = i16;
                }
                int iD = androidx.core.view.n0.d(i18, n2.Z(this)) & 7;
                if (iD != 1) {
                    if (iD != 5) {
                        i13 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    } else {
                        i11 = paddingRight - measuredWidth;
                        i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    if (u(i17)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i19 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    D(childAt, i13, i19, measuredWidth, measuredHeight2);
                    paddingTop = i19 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else {
                    i11 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i13 = i11 - i12;
                if (u(i17)) {
                    paddingTop += intrinsicHeight;
                }
                int i110 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                D(childAt, i13, i110, measuredWidth, measuredHeight2);
                paddingTop = i110 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i7, int i8) {
        if (F(i7, i8)) {
            return;
        }
        super.onMeasure(i7, i8);
    }

    public AlertDialogLayout(@c.o0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
