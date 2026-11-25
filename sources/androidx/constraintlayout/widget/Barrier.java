package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.j;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4470m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4471n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4472o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4473p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4474q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4475r = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.a f4478l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void K(androidx.constraintlayout.core.widgets.e widget, int type, boolean isRtl) {
        this.f4477k = type;
        if (isRtl) {
            int i7 = this.f4476j;
            if (i7 == 5) {
                this.f4477k = 1;
            } else if (i7 == 6) {
                this.f4477k = 0;
            }
        } else {
            int i8 = this.f4476j;
            if (i8 == 5) {
                this.f4477k = 0;
            } else if (i8 == 6) {
                this.f4477k = 1;
            }
        }
        if (widget instanceof androidx.constraintlayout.core.widgets.a) {
            ((androidx.constraintlayout.core.widgets.a) widget).u2(this.f4477k);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void B(androidx.constraintlayout.core.widgets.e widget, boolean isRtl) {
        K(widget, this.f4476j, isRtl);
    }

    @Deprecated
    public boolean J() {
        return this.f4478l.o2();
    }

    public boolean getAllowsGoneWidget() {
        return this.f4478l.o2();
    }

    public int getMargin() {
        return this.f4478l.q2();
    }

    public int getType() {
        return this.f4476j;
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.f4478l.t2(supportGone);
    }

    public void setDpMargin(int margin) {
        this.f4478l.v2((int) ((margin * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int margin) {
        this.f4478l.v2(margin);
    }

    public void setType(int type) {
        this.f4476j = type;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        this.f4478l = new androidx.constraintlayout.core.widgets.a();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f4478l.t2(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f4478l.v2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4482d = this.f4478l;
        I();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void z(d.a constraint, j child, ConstraintLayout.LayoutParams layoutParams, SparseArray<androidx.constraintlayout.core.widgets.e> mapIdToWidget) {
        super.z(constraint, child, layoutParams, mapIdToWidget);
        if (child instanceof androidx.constraintlayout.core.widgets.a) {
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) child;
            K(aVar, constraint.f4769e.f4840h0, ((androidx.constraintlayout.core.widgets.f) child.U()).O2());
            aVar.t2(constraint.f4769e.f4856p0);
            aVar.v2(constraint.f4769e.f4842i0);
        }
    }

    public Barrier(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        super.setVisibility(8);
    }
}
