package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f1487d = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1490c;

    public ButtonBarLayout(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1490c = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        n2.z1(this, context, R.styleable.ButtonBarLayout, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f1488a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1488a);
        }
    }

    private int a(int i7) {
        int childCount = getChildCount();
        while (i7 < childCount) {
            if (getChildAt(i7).getVisibility() == 0) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1489b;
    }

    private void setStacked(boolean z7) {
        if (this.f1489b != z7) {
            if (!z7 || this.f1488a) {
                this.f1489b = z7;
                setOrientation(z7 ? 1 : 0);
                setGravity(z7 ? androidx.core.view.n0.f6718c : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z7 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        int iMakeMeasureSpec;
        boolean z7;
        int size = View.MeasureSpec.getSize(i7);
        int paddingBottom = 0;
        if (this.f1488a) {
            if (size > this.f1490c && b()) {
                setStacked(false);
            }
            this.f1490c = size;
        }
        if (b() || View.MeasureSpec.getMode(i7) != 1073741824) {
            iMakeMeasureSpec = i7;
            z7 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z7 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i8);
        if (this.f1488a && !b()) {
            if ((getMeasuredWidthAndState() & n2.f6743t) == 16777216) {
                setStacked(true);
                z7 = true;
            }
        }
        if (z7) {
            super.onMeasure(i7, i8);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (n2.e0(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i8 == 0) {
                super.onMeasure(i7, i8);
            }
        }
    }

    public void setAllowStacking(boolean z7) {
        if (this.f1488a != z7) {
            this.f1488a = z7;
            if (!z7 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
