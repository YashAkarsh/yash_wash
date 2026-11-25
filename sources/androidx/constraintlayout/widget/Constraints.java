package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4612b = "Constraints";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f4613a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void c(AttributeSet attrs) {
        Log.v(f4612b, " ################# init");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public d getConstraintSet() {
        if (this.f4613a == null) {
            this.f4613a = new d();
        }
        this.f4613a.J(this);
        return this.f4613a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l7, int t7, int r7, int b8) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p7) {
        return new ConstraintLayout.LayoutParams(p7);
    }

    public Constraints(Context context, AttributeSet attrs) {
        super(context, attrs);
        c(attrs);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c(attrs);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float V0;
        public boolean W0;
        public float X0;
        public float Y0;
        public float Z0;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public float f4614a1;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public float f4615b1;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public float f4616c1;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public float f4617d1;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public float f4618e1;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public float f4619f1;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public float f4620g1;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public float f4621h1;

        public LayoutParams(int width, int height) {
            super(width, height);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4614a1 = 0.0f;
            this.f4615b1 = 1.0f;
            this.f4616c1 = 1.0f;
            this.f4617d1 = 0.0f;
            this.f4618e1 = 0.0f;
            this.f4619f1 = 0.0f;
            this.f4620g1 = 0.0f;
            this.f4621h1 = 0.0f;
        }

        public LayoutParams(LayoutParams source) {
            super((ConstraintLayout.LayoutParams) source);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4614a1 = 0.0f;
            this.f4615b1 = 1.0f;
            this.f4616c1 = 1.0f;
            this.f4617d1 = 0.0f;
            this.f4618e1 = 0.0f;
            this.f4619f1 = 0.0f;
            this.f4620g1 = 0.0f;
            this.f4621h1 = 0.0f;
        }

        public LayoutParams(Context c8, AttributeSet attrs) {
            super(c8, attrs);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.f4614a1 = 0.0f;
            this.f4615b1 = 1.0f;
            this.f4616c1 = 1.0f;
            this.f4617d1 = 0.0f;
            this.f4618e1 = 0.0f;
            this.f4619f1 = 0.0f;
            this.f4620g1 = 0.0f;
            this.f4621h1 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = c8.obtainStyledAttributes(attrs, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.V0 = typedArrayObtainStyledAttributes.getFloat(index, this.V0);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.X0 = typedArrayObtainStyledAttributes.getFloat(index, this.X0);
                    this.W0 = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.Z0 = typedArrayObtainStyledAttributes.getFloat(index, this.Z0);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f4614a1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4614a1);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.Y0 = typedArrayObtainStyledAttributes.getFloat(index, this.Y0);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f4615b1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4615b1);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f4616c1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4616c1);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f4617d1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4617d1);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.f4618e1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4618e1);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.f4619f1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4619f1);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.f4620g1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4620g1);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.f4621h1 = typedArrayObtainStyledAttributes.getFloat(index, this.f4621h1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
