package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f3841l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected View[] f3842m;

    public MotionHelper(Context context) {
        super(context);
        this.f3839j = false;
        this.f3840k = false;
    }

    public void a(MotionLayout motionLayout, int startId, int endId, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public void b(MotionLayout motionLayout) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void c(MotionLayout motionLayout, int startId, int endId) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.l
    public void d(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public boolean e() {
        return this.f3839j;
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public boolean f() {
        return this.f3840k;
    }

    public void g(MotionLayout motionLayout, HashMap<View, o> controllerMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public float getProgress() {
        return this.f3841l;
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public void h(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.p
    public void i(Canvas canvas) {
    }

    public boolean j() {
        return false;
    }

    public void k(MotionLayout motionLayout, int currentId) {
    }

    public void setProgress(View view, float progress) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f3839j = typedArrayObtainStyledAttributes.getBoolean(index, this.f3839j);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f3840k = typedArrayObtainStyledAttributes.getBoolean(index, this.f3840k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.a
    public void setProgress(float progress) {
        this.f3841l = progress;
        int i7 = 0;
        if (this.f4480b > 0) {
            this.f3842m = w((ConstraintLayout) getParent());
            while (i7 < this.f4480b) {
                setProgress(this.f3842m[i7], progress);
                i7++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i7 < childCount) {
            View childAt = viewGroup.getChildAt(i7);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, progress);
            }
            i7++;
        }
    }

    public MotionHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3839j = false;
        this.f3840k = false;
        y(attrs);
    }

    public MotionHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3839j = false;
        this.f3840k = false;
        y(attrs);
    }
}
