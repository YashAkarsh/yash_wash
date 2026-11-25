package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes.dex */
public class ReactiveGuide extends View implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4629d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f4626a = -1;
        this.f4627b = false;
        this.f4628c = 0;
        this.f4629d = true;
        super.setVisibility(8);
        c(null);
    }

    private void b(int newValue, int id, MotionLayout motionLayout, int currentState) {
        d dVarZ0 = motionLayout.z0(currentState);
        dVarZ0.d1(id, newValue);
        motionLayout.h1(currentState, dVarZ0);
    }

    private void c(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f4626a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4626a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f4627b = typedArrayObtainStyledAttributes.getBoolean(index, this.f4627b);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f4628c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4628c);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f4629d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4629d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f4626a != -1) {
            ConstraintLayout.getSharedValues().a(this.f4626a, this);
        }
    }

    @Override // androidx.constraintlayout.widget.f.a
    public void a(int key, int newValue, int oldValue) {
        setGuidelineBegin(newValue);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i7 = this.f4628c;
            if (i7 != 0) {
                currentState = i7;
            }
            int i8 = 0;
            if (!this.f4627b) {
                if (!this.f4629d) {
                    b(newValue, id, motionLayout, currentState);
                    return;
                }
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                while (i8 < constraintSetIds.length) {
                    b(newValue, id, motionLayout, constraintSetIds[i8]);
                    i8++;
                }
                return;
            }
            if (this.f4629d) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i8 < constraintSetIds2.length) {
                    int i9 = constraintSetIds2[i8];
                    if (i9 != currentState) {
                        b(newValue, id, motionLayout, i9);
                    }
                    i8++;
                }
            }
            d dVarL0 = motionLayout.l0(currentState);
            dVarL0.d1(id, newValue);
            motionLayout.i1(currentState, dVarL0, 1000);
        }
    }

    public boolean d() {
        return this.f4627b;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f4628c;
    }

    public int getAttributeId() {
        return this.f4626a;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean animate) {
        this.f4627b = animate;
    }

    public void setApplyToConstraintSetId(int id) {
        this.f4628c = id;
    }

    public void setAttributeId(int id) {
        f sharedValues = ConstraintLayout.getSharedValues();
        int i7 = this.f4626a;
        if (i7 != -1) {
            sharedValues.e(i7, this);
        }
        this.f4626a = id;
        if (id != -1) {
            sharedValues.a(id, this);
        }
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4518a = margin;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4520b = margin;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4522c = ratio;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }

    public ReactiveGuide(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4626a = -1;
        this.f4627b = false;
        this.f4628c = 0;
        this.f4629d = true;
        super.setVisibility(8);
        c(attrs);
    }

    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4626a = -1;
        this.f4627b = false;
        this.f4628c = 0;
        this.f4629d = true;
        super.setVisibility(8);
        c(attrs);
    }

    public ReactiveGuide(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.f4626a = -1;
        this.f4627b = false;
        this.f4628c = 0;
        this.f4629d = true;
        super.setVisibility(8);
        c(attrs);
    }
}
