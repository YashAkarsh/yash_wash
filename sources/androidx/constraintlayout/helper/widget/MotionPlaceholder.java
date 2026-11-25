package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.core.widgets.l;
import androidx.constraintlayout.core.widgets.n;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f3810m = "MotionPlaceholder";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    l f3811l;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void G(f container, i helper, SparseArray<e> map) {
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void J(n layout, int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (layout == null) {
            setMeasuredDimension(0, 0);
        } else {
            layout.v2(mode, size, mode2, size2);
            setMeasuredDimension(layout.q2(), layout.p2());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        J(this.f3811l, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4482d = new l();
        I();
    }

    public MotionPlaceholder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionPlaceholder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MotionPlaceholder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }
}
