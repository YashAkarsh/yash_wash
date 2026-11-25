package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionEffect extends MotionHelper {
    public static final int A = 3;
    private static final int B = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f3797v = "FadeMove";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3798w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3799x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3800y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3801z = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f3802n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f3803o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3804p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3805q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3806r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3807s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f3808t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3809u;

    public MotionEffect(Context context) {
        super(context);
        this.f3802n = 0.1f;
        this.f3803o = 49;
        this.f3804p = 50;
        this.f3805q = 0;
        this.f3806r = 0;
        this.f3807s = true;
        this.f3808t = -1;
        this.f3809u = -1;
    }

    private void J(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i8 = typedArrayObtainStyledAttributes.getInt(index, this.f3803o);
                    this.f3803o = i8;
                    this.f3803o = Math.max(Math.min(i8, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i9 = typedArrayObtainStyledAttributes.getInt(index, this.f3804p);
                    this.f3804p = i9;
                    this.f3804p = Math.max(Math.min(i9, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.f3805q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3805q);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.f3806r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3806r);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.f3802n = typedArrayObtainStyledAttributes.getFloat(index, this.f3802n);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.f3809u = typedArrayObtainStyledAttributes.getInt(index, this.f3809u);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.f3807s = typedArrayObtainStyledAttributes.getBoolean(index, this.f3807s);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f3808t = typedArrayObtainStyledAttributes.getResourceId(index, this.f3808t);
                }
            }
            int i10 = this.f3803o;
            int i11 = this.f3804p;
            if (i10 == i11) {
                if (i10 > 0) {
                    this.f3803o = i10 - 1;
                } else {
                    this.f3804p = i11 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0162  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0186, code lost:
    
        if (r14 == 0.0f) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x019a, code lost:
    
        if (r14 == 0.0f) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01aa, code lost:
    
        if (r15 == 0.0f) goto L56;
     */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.motion.widget.MotionLayout r22, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.o> r23) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.g(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.p
    public boolean j() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3802n = 0.1f;
        this.f3803o = 49;
        this.f3804p = 50;
        this.f3805q = 0;
        this.f3806r = 0;
        this.f3807s = true;
        this.f3808t = -1;
        this.f3809u = -1;
        J(context, attrs);
    }

    public MotionEffect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3802n = 0.1f;
        this.f3803o = 49;
        this.f3804p = 50;
        this.f3805q = 0;
        this.f3806r = 0;
        this.f3807s = true;
        this.f3808t = -1;
        this.f3809u = -1;
        J(context, attrs);
    }
}
