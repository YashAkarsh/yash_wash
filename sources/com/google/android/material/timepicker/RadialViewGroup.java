package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.n2;
import c.l;
import c.m0;
import c.o0;
import c.q;
import com.google.android.material.R;
import com.google.android.material.shape.m;

/* JADX INFO: loaded from: classes.dex */
class RadialViewGroup extends ConstraintLayout {
    private static final String L = "skip";
    private final Runnable I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f18786J;
    private com.google.android.material.shape.j K;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialViewGroup.this.K();
        }
    }

    public RadialViewGroup(@m0 Context context) {
        this(context, null);
    }

    private Drawable G() {
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
        this.K = jVar;
        jVar.k0(new m(0.5f));
        this.K.n0(ColorStateList.valueOf(-1));
        return this.K;
    }

    private static boolean J(View view) {
        return L.equals(view.getTag());
    }

    private void L() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.I);
            handler.post(this.I);
        }
    }

    @q
    public int H() {
        return this.f18786J;
    }

    public void I(@q int i7) {
        this.f18786J = i7;
        K();
    }

    protected void K() {
        int childCount = getChildCount();
        int i7 = 1;
        for (int i8 = 0; i8 < childCount; i8++) {
            if (J(getChildAt(i8))) {
                i7++;
            }
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.H(this);
        float f8 = 0.0f;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getId() != R.id.circle_center && !J(childAt)) {
                dVar.M(childAt.getId(), R.id.circle_center, this.f18786J, f8);
                f8 += 360.0f / (childCount - i7);
            }
        }
        dVar.r(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
        if (view.getId() == -1) {
            view.setId(n2.D());
        }
        L();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        K();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        L();
    }

    @Override // android.view.View
    public void setBackgroundColor(@l int i7) {
        this.K.n0(ColorStateList.valueOf(i7));
    }

    public RadialViewGroup(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        n2.I1(this, G());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i7, 0);
        this.f18786J = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.I = new a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
