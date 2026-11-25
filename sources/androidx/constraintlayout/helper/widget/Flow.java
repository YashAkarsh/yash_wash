package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.j;
import androidx.constraintlayout.core.widgets.n;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.d;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int A = 2;
    public static final int B = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f3765m = "Flow";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f3766n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3767o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f3768p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3769q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f3770r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f3771s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3772t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f3773u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f3774v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3775w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3776x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3777y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3778z = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f3779l;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void B(e widget, boolean isRtl) {
        this.f3779l.m2(isRtl);
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
        J(this.f3779l, widthMeasureSpec, heightMeasureSpec);
    }

    public void setFirstHorizontalBias(float bias) {
        this.f3779l.k3(bias);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int style) {
        this.f3779l.l3(style);
        requestLayout();
    }

    public void setFirstVerticalBias(float bias) {
        this.f3779l.m3(bias);
        requestLayout();
    }

    public void setFirstVerticalStyle(int style) {
        this.f3779l.n3(style);
        requestLayout();
    }

    public void setHorizontalAlign(int align) {
        this.f3779l.o3(align);
        requestLayout();
    }

    public void setHorizontalBias(float bias) {
        this.f3779l.p3(bias);
        requestLayout();
    }

    public void setHorizontalGap(int gap) {
        this.f3779l.q3(gap);
        requestLayout();
    }

    public void setHorizontalStyle(int style) {
        this.f3779l.r3(style);
        requestLayout();
    }

    public void setLastHorizontalBias(float bias) {
        this.f3779l.s3(bias);
        requestLayout();
    }

    public void setLastHorizontalStyle(int style) {
        this.f3779l.t3(style);
        requestLayout();
    }

    public void setLastVerticalBias(float bias) {
        this.f3779l.u3(bias);
        requestLayout();
    }

    public void setLastVerticalStyle(int style) {
        this.f3779l.v3(style);
        requestLayout();
    }

    public void setMaxElementsWrap(int max) {
        this.f3779l.w3(max);
        requestLayout();
    }

    public void setOrientation(int orientation) {
        this.f3779l.x3(orientation);
        requestLayout();
    }

    public void setPadding(int padding) {
        this.f3779l.B2(padding);
        requestLayout();
    }

    public void setPaddingBottom(int paddingBottom) {
        this.f3779l.C2(paddingBottom);
        requestLayout();
    }

    public void setPaddingLeft(int paddingLeft) {
        this.f3779l.E2(paddingLeft);
        requestLayout();
    }

    public void setPaddingRight(int paddingRight) {
        this.f3779l.F2(paddingRight);
        requestLayout();
    }

    public void setPaddingTop(int paddingTop) {
        this.f3779l.H2(paddingTop);
        requestLayout();
    }

    public void setVerticalAlign(int align) {
        this.f3779l.y3(align);
        requestLayout();
    }

    public void setVerticalBias(float bias) {
        this.f3779l.z3(bias);
        requestLayout();
    }

    public void setVerticalGap(int gap) {
        this.f3779l.A3(gap);
        requestLayout();
    }

    public void setVerticalStyle(int style) {
        this.f3779l.B3(style);
        requestLayout();
    }

    public void setWrapMode(int mode) {
        this.f3779l.C3(mode);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        this.f3779l = new g();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f3779l.x3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f3779l.B2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f3779l.G2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f3779l.D2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f3779l.E2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f3779l.H2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f3779l.F2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f3779l.C2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f3779l.C3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f3779l.r3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f3779l.B3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f3779l.l3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f3779l.t3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f3779l.n3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f3779l.v3(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f3779l.p3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f3779l.k3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f3779l.s3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f3779l.m3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f3779l.u3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f3779l.z3(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f3779l.o3(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f3779l.y3(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f3779l.q3(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f3779l.A3(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f3779l.w3(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4482d = this.f3779l;
        I();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void z(d.a constraint, j child, ConstraintLayout.LayoutParams layoutParams, SparseArray<e> mapIdToWidget) {
        super.z(constraint, child, layoutParams, mapIdToWidget);
        if (child instanceof g) {
            g gVar = (g) child;
            int i7 = layoutParams.Z;
            if (i7 != -1) {
                gVar.x3(i7);
            }
        }
    }

    public Flow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Flow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
