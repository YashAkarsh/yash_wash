package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f4462s = "MotionTelltales";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f4463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    MotionLayout f4464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float[] f4465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Matrix f4466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f4467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f4468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f4469r;

    public MotionTelltales(Context context) {
        super(context);
        this.f4463l = new Paint();
        this.f4465n = new float[2];
        this.f4466o = new Matrix();
        this.f4467p = 0;
        this.f4468q = -65281;
        this.f4469r = 0.25f;
        a(context, null);
    }

    private void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f4468q = typedArrayObtainStyledAttributes.getColor(index, this.f4468q);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f4467p = typedArrayObtainStyledAttributes.getInt(index, this.f4467p);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f4469r = typedArrayObtainStyledAttributes.getFloat(index, this.f4469r);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4463l.setColor(this.f4468q);
        this.f4463l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f4466o);
        if (this.f4464m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f4464m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i7 = 0; i7 < 5; i7++) {
            float f8 = fArr[i7];
            for (int i8 = 0; i8 < 5; i8++) {
                float f9 = fArr[i8];
                this.f4464m.E0(this, f9, f8, this.f4465n, this.f4467p);
                this.f4466o.mapVectors(this.f4465n);
                float f10 = width * f9;
                float f11 = height * f8;
                float[] fArr2 = this.f4465n;
                float f12 = fArr2[0];
                float f13 = this.f4469r;
                float f14 = f11 - (fArr2[1] * f13);
                this.f4466o.mapVectors(fArr2);
                canvas.drawLine(f10, f11, f10 - (f12 * f13), f14, this.f4463l);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        postInvalidate();
    }

    public void setText(CharSequence text) {
        this.f4420f = text.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4463l = new Paint();
        this.f4465n = new float[2];
        this.f4466o = new Matrix();
        this.f4467p = 0;
        this.f4468q = -65281;
        this.f4469r = 0.25f;
        a(context, attrs);
    }

    public MotionTelltales(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4463l = new Paint();
        this.f4465n = new float[2];
        this.f4466o = new Matrix();
        this.f4467p = 0;
        this.f4468q = -65281;
        this.f4469r = 0.25f;
        a(context, attrs);
    }
}
