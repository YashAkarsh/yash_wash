package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    private static final String B = "Layer";
    private boolean A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f3781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f3782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ConstraintLayout f3783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f3785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected float f3786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f3787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected float f3788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected float f3789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float f3790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected float f3791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f3792v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    View[] f3793w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f3794x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f3795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f3796z;

    public Layer(Context context) {
        super(context);
        this.f3780j = Float.NaN;
        this.f3781k = Float.NaN;
        this.f3782l = Float.NaN;
        this.f3784n = 1.0f;
        this.f3785o = 1.0f;
        this.f3786p = Float.NaN;
        this.f3787q = Float.NaN;
        this.f3788r = Float.NaN;
        this.f3789s = Float.NaN;
        this.f3790t = Float.NaN;
        this.f3791u = Float.NaN;
        this.f3792v = true;
        this.f3793w = null;
        this.f3794x = 0.0f;
        this.f3795y = 0.0f;
    }

    private void K() {
        int i7;
        if (this.f3783m == null || (i7 = this.f4480b) == 0) {
            return;
        }
        View[] viewArr = this.f3793w;
        if (viewArr == null || viewArr.length != i7) {
            this.f3793w = new View[i7];
        }
        for (int i8 = 0; i8 < this.f4480b; i8++) {
            this.f3793w[i8] = this.f3783m.t(this.f4479a[i8]);
        }
    }

    private void L() {
        if (this.f3783m == null) {
            return;
        }
        if (this.f3793w == null) {
            K();
        }
        J();
        double radians = Float.isNaN(this.f3782l) ? 0.0d : Math.toRadians(this.f3782l);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f8 = this.f3784n;
        float f9 = f8 * fCos;
        float f10 = this.f3785o;
        float f11 = (-f10) * fSin;
        float f12 = f8 * fSin;
        float f13 = f10 * fCos;
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            View view = this.f3793w[i7];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f14 = left - this.f3786p;
            float f15 = top - this.f3787q;
            float f16 = (((f9 * f14) + (f11 * f15)) - f14) + this.f3794x;
            float f17 = (((f14 * f12) + (f13 * f15)) - f15) + this.f3795y;
            view.setTranslationX(f16);
            view.setTranslationY(f17);
            view.setScaleY(this.f3785o);
            view.setScaleX(this.f3784n);
            if (!Float.isNaN(this.f3782l)) {
                view.setRotation(this.f3782l);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void D(ConstraintLayout container) {
        K();
        this.f3786p = Float.NaN;
        this.f3787q = Float.NaN;
        e eVarB = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        eVarB.c2(0);
        eVarB.y1(0);
        J();
        layout(((int) this.f3790t) - getPaddingLeft(), ((int) this.f3791u) - getPaddingTop(), ((int) this.f3788r) + getPaddingRight(), ((int) this.f3789s) + getPaddingBottom());
        L();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void F(ConstraintLayout container) {
        this.f3783m = container;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f3782l = rotation;
        } else {
            if (Float.isNaN(this.f3782l)) {
                return;
            }
            this.f3782l = rotation;
        }
    }

    protected void J() {
        if (this.f3783m == null) {
            return;
        }
        if (this.f3792v || Float.isNaN(this.f3786p) || Float.isNaN(this.f3787q)) {
            if (!Float.isNaN(this.f3780j) && !Float.isNaN(this.f3781k)) {
                this.f3787q = this.f3781k;
                this.f3786p = this.f3780j;
                return;
            }
            View[] viewArrW = w(this.f3783m);
            int left = viewArrW[0].getLeft();
            int top = viewArrW[0].getTop();
            int right = viewArrW[0].getRight();
            int bottom = viewArrW[0].getBottom();
            for (int i7 = 0; i7 < this.f4480b; i7++) {
                View view = viewArrW[i7];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f3788r = right;
            this.f3789s = bottom;
            this.f3790t = left;
            this.f3791u = top;
            if (Float.isNaN(this.f3780j)) {
                this.f3786p = (left + right) / 2;
            } else {
                this.f3786p = this.f3780j;
            }
            if (Float.isNaN(this.f3781k)) {
                this.f3787q = (top + bottom) / 2;
            } else {
                this.f3787q = this.f3781k;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3783m = (ConstraintLayout) getParent();
        if (this.f3796z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i7 = 0; i7 < this.f4480b; i7++) {
                View viewT = this.f3783m.t(this.f4479a[i7]);
                if (viewT != null) {
                    if (this.f3796z) {
                        viewT.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewT.setTranslationZ(viewT.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void r(ConstraintLayout container) {
        q(container);
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        p();
    }

    @Override // android.view.View
    public void setPivotX(float pivotX) {
        this.f3780j = pivotX;
        L();
    }

    @Override // android.view.View
    public void setPivotY(float pivotY) {
        this.f3781k = pivotY;
        L();
    }

    @Override // android.view.View
    public void setRotation(float angle) {
        this.f3782l = angle;
        L();
    }

    @Override // android.view.View
    public void setScaleX(float scaleX) {
        this.f3784n = scaleX;
        L();
    }

    @Override // android.view.View
    public void setScaleY(float scaleY) {
        this.f3785o = scaleY;
        L();
    }

    @Override // android.view.View
    public void setTranslationX(float dx) {
        this.f3794x = dx;
        L();
    }

    @Override // android.view.View
    public void setTranslationY(float dy) {
        this.f3795y = dy;
        L();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        p();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4483e = false;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f3796z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public Layer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3780j = Float.NaN;
        this.f3781k = Float.NaN;
        this.f3782l = Float.NaN;
        this.f3784n = 1.0f;
        this.f3785o = 1.0f;
        this.f3786p = Float.NaN;
        this.f3787q = Float.NaN;
        this.f3788r = Float.NaN;
        this.f3789s = Float.NaN;
        this.f3790t = Float.NaN;
        this.f3791u = Float.NaN;
        this.f3792v = true;
        this.f3793w = null;
        this.f3794x = 0.0f;
        this.f3795y = 0.0f;
    }

    public Layer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3780j = Float.NaN;
        this.f3781k = Float.NaN;
        this.f3782l = Float.NaN;
        this.f3784n = 1.0f;
        this.f3785o = 1.0f;
        this.f3786p = Float.NaN;
        this.f3787q = Float.NaN;
        this.f3788r = Float.NaN;
        this.f3789s = Float.NaN;
        this.f3790t = Float.NaN;
        this.f3791u = Float.NaN;
        this.f3792v = true;
        this.f3793w = null;
        this.f3794x = 0.0f;
        this.f3795y = 0.0f;
    }
}
