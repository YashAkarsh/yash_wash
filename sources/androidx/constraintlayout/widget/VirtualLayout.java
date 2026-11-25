package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4631k;

    public VirtualLayout(Context context) {
        super(context);
    }

    public void J(n layout, int widthMeasureSpec, int heightMeasureSpec) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4630j || this.f4631k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i7 = 0; i7 < this.f4480b; i7++) {
                    View viewT = constraintLayout.t(this.f4479a[i7]);
                    if (viewT != null) {
                        if (this.f4630j) {
                            viewT.setVisibility(visibility);
                        }
                        if (this.f4631k && elevation > 0.0f) {
                            viewT.setTranslationZ(viewT.getTranslationZ() + elevation);
                        }
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
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        p();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f4630j = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f4631k = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public VirtualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VirtualLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
