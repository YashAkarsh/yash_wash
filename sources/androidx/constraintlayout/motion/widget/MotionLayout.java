package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.view.n2;
import androidx.core.view.w1;
import c.m0;
import c.o0;
import c.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements w1 {
    public static final int M1 = 0;
    public static final int N1 = 1;
    public static final int O1 = 2;
    public static final int P1 = 3;
    public static final int Q1 = 4;
    public static final int R1 = 5;
    public static final int S1 = 6;
    public static final int T1 = 7;
    static final String U1 = "MotionLayout";
    private static final boolean V1 = false;
    public static boolean W1 = false;
    public static final int X1 = 0;
    public static final int Y1 = 1;
    public static final int Z1 = 2;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    static final int f3843a2 = 50;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final int f3844b2 = 0;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final int f3845c2 = 1;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final int f3846d2 = 2;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final int f3847e2 = 3;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    private static final float f3848f2 = 1.0E-5f;
    private long A0;
    private int A1;
    float B0;
    private int B1;
    private boolean C0;
    private int C1;
    boolean D0;
    Rect D1;
    boolean E0;
    private boolean E1;
    private l F0;
    m F1;
    private float G0;
    h G1;
    private float H0;
    private boolean H1;
    s I;
    int I0;
    private RectF I1;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    Interpolator f3849J;
    g J0;
    private View J1;
    Interpolator K;
    private boolean K0;
    private Matrix K1;
    float L;
    private androidx.constraintlayout.motion.utils.b L0;
    ArrayList<Integer> L1;
    private int M;
    private f M0;
    int N;
    private androidx.constraintlayout.motion.widget.d N0;
    private int O;
    boolean O0;
    private int P;
    int P0;
    private int Q;
    int Q0;
    private boolean R;
    int R0;
    HashMap<View, o> S;
    int S0;
    private long T;
    boolean T0;
    private float U;
    float U0;
    float V;
    float V0;
    float W;
    long W0;
    float X0;
    private boolean Y0;
    private ArrayList<MotionHelper> Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private ArrayList<MotionHelper> f3850a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private ArrayList<MotionHelper> f3851b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private CopyOnWriteArrayList<l> f3852c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f3853d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private long f3854e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private float f3855f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private int f3856g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private float f3857h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    boolean f3858i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    protected boolean f3859j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    int f3860k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    int f3861l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    int f3862m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    int f3863n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    int f3864o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    int f3865p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    float f3866q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.g f3867r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private boolean f3868s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private k f3869t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private Runnable f3870u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private int[] f3871v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    int f3872w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private boolean f3873x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    int f3874y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    HashMap<View, androidx.constraintlayout.motion.utils.e> f3875z1;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f3869t1.a();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f3873x1 = false;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3878a;

        c(final MotionLayout this$0, final View val$target) {
            this.f3878a = val$target;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3878a.setNestedScrollingEnabled(true);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f3869t1.a();
        }
    }

    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3880a;

        static {
            int[] iArr = new int[m.values().length];
            f3880a = iArr;
            try {
                iArr[m.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3880a[m.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3880a[m.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3880a[m.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class f extends q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f3881a = 0.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f3882b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3883c;

        f() {
        }

        @Override // androidx.constraintlayout.motion.widget.q
        public float a() {
            return MotionLayout.this.L;
        }

        public void b(float velocity, float position, float maxAcceleration) {
            this.f3881a = velocity;
            this.f3882b = position;
            this.f3883c = maxAcceleration;
        }

        @Override // androidx.constraintlayout.motion.widget.q, android.animation.TimeInterpolator
        public float getInterpolation(float time) {
            float f8;
            float f9;
            float f10 = this.f3881a;
            if (f10 > 0.0f) {
                float f11 = this.f3883c;
                if (f10 / f11 < time) {
                    time = f10 / f11;
                }
                MotionLayout.this.L = f10 - (f11 * time);
                f8 = (f10 * time) - (((f11 * time) * time) / 2.0f);
                f9 = this.f3882b;
            } else {
                float f12 = this.f3883c;
                if ((-f10) / f12 < time) {
                    time = (-f10) / f12;
                }
                MotionLayout.this.L = (f12 * time) + f10;
                f8 = (f10 * time) + (((f12 * time) * time) / 2.0f);
                f9 = this.f3882b;
            }
            return f8 + f9;
        }
    }

    private class g {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final int f3885v = 16;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f3886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f3887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float[] f3888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Path f3889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f3890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Paint f3891f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Paint f3892g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Paint f3893h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Paint f3894i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float[] f3895j;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        DashPathEffect f3901p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f3902q;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f3905t;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f3896k = -21965;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f3897l = -2067046;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final int f3898m = -13391360;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final int f3899n = 1996488704;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final int f3900o = 10;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Rect f3903r = new Rect();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f3904s = false;

        public g() {
            this.f3905t = 1;
            Paint paint = new Paint();
            this.f3890e = paint;
            paint.setAntiAlias(true);
            this.f3890e.setColor(-21965);
            this.f3890e.setStrokeWidth(2.0f);
            this.f3890e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f3891f = paint2;
            paint2.setAntiAlias(true);
            this.f3891f.setColor(-2067046);
            this.f3891f.setStrokeWidth(2.0f);
            this.f3891f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f3892g = paint3;
            paint3.setAntiAlias(true);
            this.f3892g.setColor(-13391360);
            this.f3892g.setStrokeWidth(2.0f);
            this.f3892g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f3893h = paint4;
            paint4.setAntiAlias(true);
            this.f3893h.setColor(-13391360);
            this.f3893h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f3895j = new float[8];
            Paint paint5 = new Paint();
            this.f3894i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f3901p = dashPathEffect;
            this.f3892g.setPathEffect(dashPathEffect);
            this.f3888c = new float[100];
            this.f3887b = new int[50];
            if (this.f3904s) {
                this.f3890e.setStrokeWidth(8.0f);
                this.f3894i.setStrokeWidth(8.0f);
                this.f3891f.setStrokeWidth(8.0f);
                this.f3905t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f3886a, this.f3890e);
        }

        private void d(Canvas canvas) {
            boolean z7 = false;
            boolean z8 = false;
            for (int i7 = 0; i7 < this.f3902q; i7++) {
                int i8 = this.f3887b[i7];
                if (i8 == 1) {
                    z7 = true;
                }
                if (i8 == 0) {
                    z8 = true;
                }
            }
            if (z7) {
                g(canvas);
            }
            if (z8) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f3886a;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f8, f10), Math.max(f9, f11), Math.max(f8, f10), Math.max(f9, f11), this.f3892g);
            canvas.drawLine(Math.min(f8, f10), Math.min(f9, f11), Math.min(f8, f10), Math.max(f9, f11), this.f3892g);
        }

        private void f(Canvas canvas, float x7, float y7) {
            float[] fArr = this.f3886a;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            float fMin = Math.min(f8, f10);
            float fMax = Math.max(f9, f11);
            float fMin2 = x7 - Math.min(f8, f10);
            float fMax2 = Math.max(f9, f11) - y7;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f10 - f8))) + 0.5d)) / 100.0f);
            m(str, this.f3893h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f3903r.width() / 2)) + fMin, y7 - 20.0f, this.f3893h);
            canvas.drawLine(x7, y7, Math.min(f8, f10), y7, this.f3892g);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f11 - f9))) + 0.5d)) / 100.0f);
            m(str2, this.f3893h);
            canvas.drawText(str2, x7 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f3903r.height() / 2)), this.f3893h);
            canvas.drawLine(x7, y7, x7, Math.max(f9, f11), this.f3892g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f3886a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f3892g);
        }

        private void h(Canvas canvas, float x7, float y7) {
            float[] fArr = this.f3886a;
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f8 - f10, f9 - f11);
            float f12 = f10 - f8;
            float f13 = f11 - f9;
            float f14 = (((x7 - f8) * f12) + ((y7 - f9) * f13)) / (fHypot * fHypot);
            float f15 = f8 + (f12 * f14);
            float f16 = f9 + (f14 * f13);
            Path path = new Path();
            path.moveTo(x7, y7);
            path.lineTo(f15, f16);
            float fHypot2 = (float) Math.hypot(f15 - x7, f16 - y7);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            m(str, this.f3893h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f3903r.width() / 2), -20.0f, this.f3893h);
            canvas.drawLine(x7, y7, f15, f16, this.f3892g);
        }

        private void i(Canvas canvas, float x7, float y7, int viewWidth, int viewHeight) {
            String str = "" + (((int) (((double) (((x7 - (viewWidth / 2)) * 100.0f) / (MotionLayout.this.getWidth() - viewWidth))) + 0.5d)) / 100.0f);
            m(str, this.f3893h);
            canvas.drawText(str, ((x7 / 2.0f) - (this.f3903r.width() / 2)) + 0.0f, y7 - 20.0f, this.f3893h);
            canvas.drawLine(x7, y7, Math.min(0.0f, 1.0f), y7, this.f3892g);
            String str2 = "" + (((int) (((double) (((y7 - (viewHeight / 2)) * 100.0f) / (MotionLayout.this.getHeight() - viewHeight))) + 0.5d)) / 100.0f);
            m(str2, this.f3893h);
            canvas.drawText(str2, x7 + 5.0f, 0.0f - ((y7 / 2.0f) - (this.f3903r.height() / 2)), this.f3893h);
            canvas.drawLine(x7, y7, x7, Math.max(0.0f, 1.0f), this.f3892g);
        }

        private void j(Canvas canvas, o motionController) {
            this.f3889d.reset();
            for (int i7 = 0; i7 <= 50; i7++) {
                motionController.g(i7 / 50, this.f3895j, 0);
                Path path = this.f3889d;
                float[] fArr = this.f3895j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f3889d;
                float[] fArr2 = this.f3895j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f3889d;
                float[] fArr3 = this.f3895j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f3889d;
                float[] fArr4 = this.f3895j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f3889d.close();
            }
            this.f3890e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f3889d, this.f3890e);
            canvas.translate(-2.0f, -2.0f);
            this.f3890e.setColor(k.a.f34390c);
            canvas.drawPath(this.f3889d, this.f3890e);
        }

        private void k(Canvas canvas, int mode, int keyFrames, o motionController) {
            int width;
            int height;
            View view = motionController.f4154b;
            if (view != null) {
                width = view.getWidth();
                height = motionController.f4154b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i7 = 1; i7 < keyFrames - 1; i7++) {
                if (mode != 4 || this.f3887b[i7 - 1] != 0) {
                    float[] fArr = this.f3888c;
                    int i8 = i7 * 2;
                    float f8 = fArr[i8];
                    float f9 = fArr[i8 + 1];
                    this.f3889d.reset();
                    this.f3889d.moveTo(f8, f9 + 10.0f);
                    this.f3889d.lineTo(f8 + 10.0f, f9);
                    this.f3889d.lineTo(f8, f9 - 10.0f);
                    this.f3889d.lineTo(f8 - 10.0f, f9);
                    this.f3889d.close();
                    int i9 = i7 - 1;
                    motionController.w(i9);
                    if (mode == 4) {
                        int i10 = this.f3887b[i9];
                        if (i10 == 1) {
                            h(canvas, f8 - 0.0f, f9 - 0.0f);
                        } else if (i10 == 0) {
                            f(canvas, f8 - 0.0f, f9 - 0.0f);
                        } else {
                            if (i10 == 2) {
                                i(canvas, f8 - 0.0f, f9 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.f3889d, this.f3894i);
                        }
                        canvas.drawPath(this.f3889d, this.f3894i);
                    } else {
                        f9 = f9;
                        f8 = f8;
                    }
                    if (mode == 2) {
                        h(canvas, f8 - 0.0f, f9 - 0.0f);
                    }
                    if (mode == 3) {
                        f(canvas, f8 - 0.0f, f9 - 0.0f);
                    }
                    if (mode == 6) {
                        i(canvas, f8 - 0.0f, f9 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f3889d, this.f3894i);
                }
            }
            float[] fArr2 = this.f3886a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f3891f);
                float[] fArr3 = this.f3886a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f3891f);
            }
        }

        private void l(Canvas canvas, float x7, float y7, float x8, float y8) {
            canvas.drawRect(x7, y7, x8, y8, this.f3892g);
            canvas.drawLine(x7, y7, x8, y8, this.f3892g);
        }

        public void a(Canvas canvas, HashMap<View, o> frameArrayList, int duration, int debugPath) {
            if (frameArrayList == null || frameArrayList.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (debugPath & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.O) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f3893h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f3890e);
            }
            for (o oVar : frameArrayList.values()) {
                int iQ = oVar.q();
                if (debugPath > 0 && iQ == 0) {
                    iQ = 1;
                }
                if (iQ != 0) {
                    this.f3902q = oVar.e(this.f3888c, this.f3887b);
                    if (iQ >= 1) {
                        int i7 = duration / 16;
                        float[] fArr = this.f3886a;
                        if (fArr == null || fArr.length != i7 * 2) {
                            this.f3886a = new float[i7 * 2];
                            this.f3889d = new Path();
                        }
                        int i8 = this.f3905t;
                        canvas.translate(i8, i8);
                        this.f3890e.setColor(1996488704);
                        this.f3894i.setColor(1996488704);
                        this.f3891f.setColor(1996488704);
                        this.f3892g.setColor(1996488704);
                        oVar.f(this.f3886a, i7);
                        b(canvas, iQ, this.f3902q, oVar);
                        this.f3890e.setColor(-21965);
                        this.f3891f.setColor(-2067046);
                        this.f3894i.setColor(-2067046);
                        this.f3892g.setColor(-13391360);
                        int i9 = this.f3905t;
                        canvas.translate(-i9, -i9);
                        b(canvas, iQ, this.f3902q, oVar);
                        if (iQ == 5) {
                            j(canvas, oVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int mode, int keyFrames, o motionController) {
            if (mode == 4) {
                d(canvas);
            }
            if (mode == 2) {
                g(canvas);
            }
            if (mode == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, mode, keyFrames, motionController);
        }

        void m(String text, Paint paint) {
            paint.getTextBounds(text, 0, text.length(), this.f3903r);
        }
    }

    class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.constraintlayout.core.widgets.f f3907a = new androidx.constraintlayout.core.widgets.f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.constraintlayout.core.widgets.f f3908b = new androidx.constraintlayout.core.widgets.f();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.constraintlayout.widget.d f3909c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.widget.d f3910d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3912f;

        h() {
        }

        private void b(int widthMeasureSpec, int heightMeasureSpec) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.N == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.f fVar = this.f3908b;
                androidx.constraintlayout.widget.d dVar = this.f3910d;
                motionLayout2.B(fVar, optimizationLevel, (dVar == null || dVar.f4761d == 0) ? widthMeasureSpec : heightMeasureSpec, (dVar == null || dVar.f4761d == 0) ? heightMeasureSpec : widthMeasureSpec);
                androidx.constraintlayout.widget.d dVar2 = this.f3909c;
                if (dVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.f fVar2 = this.f3907a;
                    int i7 = dVar2.f4761d;
                    int i8 = i7 == 0 ? widthMeasureSpec : heightMeasureSpec;
                    if (i7 == 0) {
                        widthMeasureSpec = heightMeasureSpec;
                    }
                    motionLayout3.B(fVar2, optimizationLevel, i8, widthMeasureSpec);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.d dVar3 = this.f3909c;
            if (dVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.f fVar3 = this.f3907a;
                int i9 = dVar3.f4761d;
                motionLayout4.B(fVar3, optimizationLevel, i9 == 0 ? widthMeasureSpec : heightMeasureSpec, i9 == 0 ? heightMeasureSpec : widthMeasureSpec);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.f fVar4 = this.f3908b;
            androidx.constraintlayout.widget.d dVar4 = this.f3910d;
            int i10 = (dVar4 == null || dVar4.f4761d == 0) ? widthMeasureSpec : heightMeasureSpec;
            if (dVar4 == null || dVar4.f4761d == 0) {
                widthMeasureSpec = heightMeasureSpec;
            }
            motionLayout5.B(fVar4, optimizationLevel, i10, widthMeasureSpec);
        }

        @SuppressLint({"LogConditional"})
        private void d(String title, androidx.constraintlayout.core.widgets.f c8) {
            String str = title + " " + androidx.constraintlayout.motion.widget.c.k((View) c8.w());
            Log.v(MotionLayout.U1, str + "  ========= " + c8);
            int size = c8.l2().size();
            for (int i7 = 0; i7 < size; i7++) {
                String str2 = str + "[" + i7 + "] ";
                androidx.constraintlayout.core.widgets.e eVar = c8.l2().get(i7);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(eVar.R.f3558f != null ? "T" : "_");
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(eVar.T.f3558f != null ? "B" : "_");
                String string2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(eVar.Q.f3558f != null ? "L" : "_");
                String string3 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(eVar.S.f3558f != null ? "R" : "_");
                String string4 = sb4.toString();
                View view = (View) eVar.w();
                String strK = androidx.constraintlayout.motion.widget.c.k(view);
                if (view instanceof TextView) {
                    strK = strK + "(" + ((Object) ((TextView) view).getText()) + ")";
                }
                Log.v(MotionLayout.U1, str2 + "  " + strK + " " + eVar + " " + string4);
            }
            Log.v(MotionLayout.U1, str + " done. ");
        }

        @SuppressLint({"LogConditional"})
        private void e(String str, ConstraintLayout.LayoutParams params) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            sb.append(params.f4556t != -1 ? "SS" : "__");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(params.f4554s != -1 ? "|SE" : "|__");
            String string2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string2);
            sb3.append(params.f4558u != -1 ? "|ES" : "|__");
            String string3 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string3);
            sb4.append(params.f4560v != -1 ? "|EE" : "|__");
            String string4 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string4);
            sb5.append(params.f4526e != -1 ? "|LL" : "|__");
            String string5 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(string5);
            sb6.append(params.f4528f != -1 ? "|LR" : "|__");
            String string6 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string6);
            sb7.append(params.f4530g != -1 ? "|RL" : "|__");
            String string7 = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string7);
            sb8.append(params.f4532h != -1 ? "|RR" : "|__");
            String string8 = sb8.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(string8);
            sb9.append(params.f4534i != -1 ? "|TT" : "|__");
            String string9 = sb9.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(string9);
            sb10.append(params.f4536j != -1 ? "|TB" : "|__");
            String string10 = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(string10);
            sb11.append(params.f4538k != -1 ? "|BT" : "|__");
            String string11 = sb11.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append(string11);
            sb12.append(params.f4540l != -1 ? "|BB" : "|__");
            Log.v(MotionLayout.U1, str + sb12.toString());
        }

        @SuppressLint({"LogConditional"})
        private void f(String str, androidx.constraintlayout.core.widgets.e child) {
            String string;
            String string2;
            String string3;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            String string4 = "__";
            if (child.R.f3558f != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("T");
                sb2.append(child.R.f3558f.f3557e == androidx.constraintlayout.core.widgets.d.b.TOP ? "T" : "B");
                string = sb2.toString();
            } else {
                string = "__";
            }
            sb.append(string);
            String string5 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string5);
            if (child.T.f3558f != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("B");
                sb4.append(child.T.f3558f.f3557e == androidx.constraintlayout.core.widgets.d.b.TOP ? "T" : "B");
                string2 = sb4.toString();
            } else {
                string2 = "__";
            }
            sb3.append(string2);
            String string6 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string6);
            if (child.Q.f3558f != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("L");
                sb6.append(child.Q.f3558f.f3557e == androidx.constraintlayout.core.widgets.d.b.LEFT ? "L" : "R");
                string3 = sb6.toString();
            } else {
                string3 = "__";
            }
            sb5.append(string3);
            String string7 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string7);
            if (child.S.f3558f != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("R");
                sb8.append(child.S.f3558f.f3557e == androidx.constraintlayout.core.widgets.d.b.LEFT ? "L" : "R");
                string4 = sb8.toString();
            }
            sb7.append(string4);
            Log.v(MotionLayout.U1, str + sb7.toString() + " ---  " + child);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m(androidx.constraintlayout.core.widgets.f base, androidx.constraintlayout.widget.d cSet) {
            SparseArray<androidx.constraintlayout.core.widgets.e> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, base);
            sparseArray.put(MotionLayout.this.getId(), base);
            if (cSet != null && cSet.f4761d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.B(this.f3908b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            for (androidx.constraintlayout.core.widgets.e eVar : base.l2()) {
                eVar.f1(true);
                sparseArray.put(((View) eVar.w()).getId(), eVar);
            }
            for (androidx.constraintlayout.core.widgets.e eVar2 : base.l2()) {
                View view = (View) eVar2.w();
                cSet.u(view.getId(), layoutParams);
                eVar2.c2(cSet.u0(view.getId()));
                eVar2.y1(cSet.n0(view.getId()));
                if (view instanceof ConstraintHelper) {
                    cSet.s((ConstraintHelper) view, eVar2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).I();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.j(false, view, eVar2, layoutParams, sparseArray);
                if (cSet.t0(view.getId()) == 1) {
                    eVar2.b2(view.getVisibility());
                } else {
                    eVar2.b2(cSet.s0(view.getId()));
                }
            }
            for (androidx.constraintlayout.core.widgets.e eVar3 : base.l2()) {
                if (eVar3 instanceof androidx.constraintlayout.core.widgets.n) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) eVar3.w();
                    androidx.constraintlayout.core.widgets.i iVar = (androidx.constraintlayout.core.widgets.i) eVar3;
                    constraintHelper.G(base, iVar, sparseArray);
                    ((androidx.constraintlayout.core.widgets.n) iVar).n2();
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:26:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:27:0x0109  */
        /* JADX WARN: Code duplicated, block: B:29:0x010f  */
        /* JADX WARN: Code duplicated, block: B:42:0x013d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:44:0x013d A[SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:29:0x010f, please report this as an issue */
        public void a() {
            androidx.constraintlayout.core.widgets.e eVarG;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.S.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = MotionLayout.this.getChildAt(i7);
                o oVar = new o(childAt);
                int id = childAt.getId();
                iArr[i7] = id;
                sparseArray.put(id, oVar);
                MotionLayout.this.S.put(childAt, oVar);
            }
            int i8 = 0;
            while (i8 < childCount) {
                View childAt2 = MotionLayout.this.getChildAt(i8);
                o oVar2 = MotionLayout.this.S.get(childAt2);
                if (oVar2 == null) {
                    sparseArray = sparseArray;
                } else {
                    if (this.f3909c != null) {
                        androidx.constraintlayout.core.widgets.e eVarG2 = g(this.f3907a, childAt2);
                        if (eVarG2 != null) {
                            oVar2.W(MotionLayout.this.W0(eVarG2), this.f3909c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.I0 != 0) {
                            Log.e(MotionLayout.U1, androidx.constraintlayout.motion.widget.c.g() + "no widget for  " + androidx.constraintlayout.motion.widget.c.k(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    } else {
                        if (MotionLayout.this.f3873x1) {
                            androidx.constraintlayout.motion.utils.e eVar = MotionLayout.this.f3875z1.get(childAt2);
                            MotionLayout motionLayout = MotionLayout.this;
                            oVar2.X(eVar, childAt2, motionLayout.f3874y1, motionLayout.A1, MotionLayout.this.B1);
                        }
                        if (this.f3910d == null) {
                            eVarG = g(this.f3908b, childAt2);
                            if (eVarG != null) {
                                oVar2.T(MotionLayout.this.W0(eVarG), this.f3910d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                            } else if (MotionLayout.this.I0 != 0) {
                                Log.e(MotionLayout.U1, androidx.constraintlayout.motion.widget.c.g() + "no widget for  " + androidx.constraintlayout.motion.widget.c.k(childAt2) + " (" + childAt2.getClass().getName() + ")");
                            }
                        }
                    }
                    if (this.f3910d == null) {
                        eVarG = g(this.f3908b, childAt2);
                        if (eVarG != null) {
                            oVar2.T(MotionLayout.this.W0(eVarG), this.f3910d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.I0 != 0) {
                            Log.e(MotionLayout.U1, androidx.constraintlayout.motion.widget.c.g() + "no widget for  " + androidx.constraintlayout.motion.widget.c.k(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
                i8++;
                sparseArray = sparseArray;
            }
            SparseArray sparseArray2 = sparseArray;
            int i9 = 0;
            while (i9 < childCount) {
                SparseArray sparseArray3 = sparseArray2;
                o oVar3 = (o) sparseArray3.get(iArr[i9]);
                int iK = oVar3.k();
                if (iK != -1) {
                    oVar3.b0((o) sparseArray3.get(iK));
                }
                i9++;
                sparseArray2 = sparseArray3;
            }
        }

        void c(androidx.constraintlayout.core.widgets.f src, androidx.constraintlayout.core.widgets.f dest) {
            androidx.constraintlayout.core.widgets.e jVar;
            ArrayList<androidx.constraintlayout.core.widgets.e> arrayListL2 = src.l2();
            HashMap<androidx.constraintlayout.core.widgets.e, androidx.constraintlayout.core.widgets.e> map = new HashMap<>();
            map.put(src, dest);
            dest.l2().clear();
            dest.n(src, map);
            for (androidx.constraintlayout.core.widgets.e eVar : arrayListL2) {
                if (eVar instanceof androidx.constraintlayout.core.widgets.a) {
                    jVar = new androidx.constraintlayout.core.widgets.a();
                } else if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
                    jVar = new androidx.constraintlayout.core.widgets.h();
                } else if (eVar instanceof androidx.constraintlayout.core.widgets.g) {
                    jVar = new androidx.constraintlayout.core.widgets.g();
                } else if (eVar instanceof androidx.constraintlayout.core.widgets.l) {
                    jVar = new androidx.constraintlayout.core.widgets.l();
                } else {
                    jVar = eVar instanceof androidx.constraintlayout.core.widgets.i ? new androidx.constraintlayout.core.widgets.j() : new androidx.constraintlayout.core.widgets.e();
                }
                dest.b(jVar);
                map.put(eVar, jVar);
            }
            for (androidx.constraintlayout.core.widgets.e eVar2 : arrayListL2) {
                map.get(eVar2).n(eVar2, map);
            }
        }

        androidx.constraintlayout.core.widgets.e g(androidx.constraintlayout.core.widgets.f container, View view) {
            if (container.w() == view) {
                return container;
            }
            ArrayList<androidx.constraintlayout.core.widgets.e> arrayListL2 = container.l2();
            int size = arrayListL2.size();
            for (int i7 = 0; i7 < size; i7++) {
                androidx.constraintlayout.core.widgets.e eVar = arrayListL2.get(i7);
                if (eVar.w() == view) {
                    return eVar;
                }
            }
            return null;
        }

        void h(androidx.constraintlayout.core.widgets.f baseLayout, androidx.constraintlayout.widget.d start, androidx.constraintlayout.widget.d end) {
            this.f3909c = start;
            this.f3910d = end;
            this.f3907a = new androidx.constraintlayout.core.widgets.f();
            this.f3908b = new androidx.constraintlayout.core.widgets.f();
            this.f3907a.U2(((ConstraintLayout) MotionLayout.this).f4491c.G2());
            this.f3908b.U2(((ConstraintLayout) MotionLayout.this).f4491c.G2());
            this.f3907a.p2();
            this.f3908b.p2();
            c(((ConstraintLayout) MotionLayout.this).f4491c, this.f3907a);
            c(((ConstraintLayout) MotionLayout.this).f4491c, this.f3908b);
            if (MotionLayout.this.W > 0.5d) {
                if (start != null) {
                    m(this.f3907a, start);
                }
                m(this.f3908b, end);
            } else {
                m(this.f3908b, end);
                if (start != null) {
                    m(this.f3907a, start);
                }
            }
            this.f3907a.Y2(MotionLayout.this.w());
            this.f3907a.a3();
            this.f3908b.Y2(MotionLayout.this.w());
            this.f3908b.a3();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.f fVar = this.f3907a;
                    androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                    fVar.D1(bVar);
                    this.f3908b.D1(bVar);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.f fVar2 = this.f3907a;
                    androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
                    fVar2.Y1(bVar2);
                    this.f3908b.Y1(bVar2);
                }
            }
        }

        public boolean i(int startId, int endId) {
            return (startId == this.f3911e && endId == this.f3912f) ? false : true;
        }

        public void j(int widthMeasureSpec, int heightMeasureSpec) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f3864o1 = mode;
            motionLayout.f3865p1 = mode2;
            motionLayout.getOptimizationLevel();
            b(widthMeasureSpec, heightMeasureSpec);
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                b(widthMeasureSpec, heightMeasureSpec);
                MotionLayout.this.f3860k1 = this.f3907a.m0();
                MotionLayout.this.f3861l1 = this.f3907a.D();
                MotionLayout.this.f3862m1 = this.f3908b.m0();
                MotionLayout.this.f3863n1 = this.f3908b.D();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f3859j1 = (motionLayout2.f3860k1 == motionLayout2.f3862m1 && motionLayout2.f3861l1 == motionLayout2.f3863n1) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i7 = motionLayout3.f3860k1;
            int i8 = motionLayout3.f3861l1;
            int i9 = motionLayout3.f3864o1;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                i7 = (int) (i7 + (motionLayout3.f3866q1 * (motionLayout3.f3862m1 - i7)));
            }
            int i10 = i7;
            int i11 = motionLayout3.f3865p1;
            if (i11 == Integer.MIN_VALUE || i11 == 0) {
                i8 = (int) (i8 + (motionLayout3.f3866q1 * (motionLayout3.f3863n1 - i8)));
            }
            MotionLayout.this.A(widthMeasureSpec, heightMeasureSpec, i10, i8, this.f3907a.P2() || this.f3908b.P2(), this.f3907a.N2() || this.f3908b.N2());
        }

        public void k() {
            j(MotionLayout.this.P, MotionLayout.this.Q);
            MotionLayout.this.V0();
        }

        public void l(int startId, int endId) {
            this.f3911e = startId;
            this.f3912f = endId;
        }
    }

    protected interface i {
        void a();

        void b(int units, float maxVelocity);

        float c(int id);

        void clear();

        float d(int id);

        void e(MotionEvent event);

        float f();

        float g();

        void h(int units);
    }

    private static class j implements i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static j f3914b = new j();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        VelocityTracker f3915a;

        private j() {
        }

        public static j i() {
            f3914b.f3915a = VelocityTracker.obtain();
            return f3914b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void a() {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3915a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void b(int units, float maxVelocity) {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(units, maxVelocity);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float c(int id) {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(id);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void clear() {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float d(int id) {
            if (this.f3915a != null) {
                return d(id);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void e(MotionEvent event) {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(event);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float f() {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float g() {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void h(int units) {
            VelocityTracker velocityTracker = this.f3915a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(units);
            }
        }
    }

    class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f3916a = Float.NaN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f3917b = Float.NaN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3918c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3919d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final String f3920e = "motion.progress";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f3921f = "motion.velocity";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final String f3922g = "motion.StartState";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final String f3923h = "motion.EndState";

        k() {
        }

        void a() {
            int i7 = this.f3918c;
            if (i7 != -1 || this.f3919d != -1) {
                if (i7 == -1) {
                    MotionLayout.this.c1(this.f3919d);
                } else {
                    int i8 = this.f3919d;
                    if (i8 == -1) {
                        MotionLayout.this.setState(i7, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i7, i8);
                    }
                }
                MotionLayout.this.setState(m.SETUP);
            }
            if (Float.isNaN(this.f3917b)) {
                if (Float.isNaN(this.f3916a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f3916a);
            } else {
                MotionLayout.this.setProgress(this.f3916a, this.f3917b);
                this.f3916a = Float.NaN;
                this.f3917b = Float.NaN;
                this.f3918c = -1;
                this.f3919d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f3916a);
            bundle.putFloat("motion.velocity", this.f3917b);
            bundle.putInt("motion.StartState", this.f3918c);
            bundle.putInt("motion.EndState", this.f3919d);
            return bundle;
        }

        public void c() {
            this.f3919d = MotionLayout.this.O;
            this.f3918c = MotionLayout.this.M;
            this.f3917b = MotionLayout.this.getVelocity();
            this.f3916a = MotionLayout.this.getProgress();
        }

        public void d(int endState) {
            this.f3919d = endState;
        }

        public void e(float progress) {
            this.f3916a = progress;
        }

        public void f(int startState) {
            this.f3918c = startState;
        }

        public void g(Bundle bundle) {
            this.f3916a = bundle.getFloat("motion.progress");
            this.f3917b = bundle.getFloat("motion.velocity");
            this.f3918c = bundle.getInt("motion.StartState");
            this.f3919d = bundle.getInt("motion.EndState");
        }

        public void h(float mVelocity) {
            this.f3917b = mVelocity;
        }
    }

    public interface l {
        void a(MotionLayout motionLayout, int startId, int endId, float progress);

        void c(MotionLayout motionLayout, int startId, int endId);

        void d(MotionLayout motionLayout, int triggerId, boolean positive, float progress);

        void k(MotionLayout motionLayout, int currentId);
    }

    enum m {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@m0 Context context) {
        super(context);
        this.K = null;
        this.L = 0.0f;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.S = new HashMap<>();
        this.T = 0L;
        this.U = 1.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.B0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.I0 = 0;
        this.K0 = false;
        this.L0 = new androidx.constraintlayout.motion.utils.b();
        this.M0 = new f();
        this.O0 = true;
        this.T0 = false;
        this.Y0 = false;
        this.Z0 = null;
        this.f3850a1 = null;
        this.f3851b1 = null;
        this.f3852c1 = null;
        this.f3853d1 = 0;
        this.f3854e1 = -1L;
        this.f3855f1 = 0.0f;
        this.f3856g1 = 0;
        this.f3857h1 = 0.0f;
        this.f3858i1 = false;
        this.f3859j1 = false;
        this.f3867r1 = new androidx.constraintlayout.core.motion.utils.g();
        this.f3868s1 = false;
        this.f3870u1 = null;
        this.f3871v1 = null;
        this.f3872w1 = 0;
        this.f3873x1 = false;
        this.f3874y1 = 0;
        this.f3875z1 = new HashMap<>();
        this.D1 = new Rect();
        this.E1 = false;
        this.F1 = m.UNDEFINED;
        this.G1 = new h();
        this.H1 = false;
        this.I1 = new RectF();
        this.J1 = null;
        this.K1 = null;
        this.L1 = new ArrayList<>();
        G0(null);
    }

    private boolean F0(float x7, float y7, View view, MotionEvent event) {
        boolean z7;
        if (!(view instanceof ViewGroup)) {
            z7 = false;
            break;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                z7 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(childCount);
            if (F0((childAt.getLeft() + x7) - view.getScrollX(), (childAt.getTop() + y7) - view.getScrollY(), childAt, event)) {
                z7 = true;
                break;
            }
            childCount--;
        }
        if (!z7) {
            this.I1.set(x7, y7, (view.getRight() + x7) - view.getLeft(), (view.getBottom() + y7) - view.getTop());
            if ((event.getAction() != 0 || this.I1.contains(event.getX(), event.getY())) && h0(view, event, -x7, -y7)) {
                return true;
            }
        }
        return z7;
    }

    private void G0(AttributeSet attrs) {
        s sVar;
        W1 = isInEditMode();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z7 = true;
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.I = new s(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.N = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.B0 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.D0 = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z7 = typedArrayObtainStyledAttributes.getBoolean(index, z7);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.I0 == 0) {
                        this.I0 = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.I == null) {
                Log.e(U1, "WARNING NO app:layoutDescription tag");
            }
            if (!z7) {
                this.I = null;
            }
        }
        if (this.I0 != 0) {
            i0();
        }
        if (this.N != -1 || (sVar = this.I) == null) {
            return;
        }
        this.N = sVar.N();
        this.M = this.I.N();
        this.O = this.I.u();
    }

    private void P0() {
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if (this.F0 == null && ((copyOnWriteArrayList = this.f3852c1) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f3858i1 = false;
        for (Integer num : this.L1) {
            l lVar = this.F0;
            if (lVar != null) {
                lVar.k(this, num.intValue());
            }
            CopyOnWriteArrayList<l> copyOnWriteArrayList2 = this.f3852c1;
            if (copyOnWriteArrayList2 != null) {
                Iterator<l> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().k(this, num.intValue());
                }
            }
        }
        this.L1.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        int childCount = getChildCount();
        this.G1.a();
        boolean z7 = true;
        this.D0 = true;
        SparseArray sparseArray = new SparseArray();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            sparseArray.put(childAt.getId(), this.S.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iM = this.I.m();
        if (iM != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                o oVar = this.S.get(getChildAt(i9));
                if (oVar != null) {
                    oVar.U(iM);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.S.size()];
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            o oVar2 = this.S.get(getChildAt(i11));
            if (oVar2.k() != -1) {
                sparseBooleanArray.put(oVar2.k(), true);
                iArr[i10] = oVar2.k();
                i10++;
            }
        }
        if (this.f3851b1 != null) {
            for (int i12 = 0; i12 < i10; i12++) {
                o oVar3 = this.S.get(findViewById(iArr[i12]));
                if (oVar3 != null) {
                    this.I.z(oVar3);
                }
            }
            Iterator<MotionHelper> it = this.f3851b1.iterator();
            while (it.hasNext()) {
                it.next().g(this, this.S);
            }
            for (int i13 = 0; i13 < i10; i13++) {
                o oVar4 = this.S.get(findViewById(iArr[i13]));
                if (oVar4 != null) {
                    oVar4.a0(width, height, this.U, getNanoTime());
                }
            }
        } else {
            for (int i14 = 0; i14 < i10; i14++) {
                o oVar5 = this.S.get(findViewById(iArr[i14]));
                if (oVar5 != null) {
                    this.I.z(oVar5);
                    oVar5.a0(width, height, this.U, getNanoTime());
                }
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            o oVar6 = this.S.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && oVar6 != null) {
                this.I.z(oVar6);
                oVar6.a0(width, height, this.U, getNanoTime());
            }
        }
        float fM = this.I.M();
        if (fM != 0.0f) {
            boolean z8 = ((double) fM) < 0.0d;
            float fAbs = Math.abs(fM);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            int i16 = 0;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            while (true) {
                if (i16 >= childCount) {
                    z7 = false;
                    break;
                }
                o oVar7 = this.S.get(getChildAt(i16));
                if (!Float.isNaN(oVar7.f4165m)) {
                    break;
                }
                float fT = oVar7.t();
                float fU = oVar7.u();
                float f8 = z8 ? fU - fT : fU + fT;
                fMin2 = Math.min(fMin2, f8);
                fMax2 = Math.max(fMax2, f8);
                i16++;
            }
            if (!z7) {
                while (i7 < childCount) {
                    o oVar8 = this.S.get(getChildAt(i7));
                    float fT2 = oVar8.t();
                    float fU2 = oVar8.u();
                    float f9 = z8 ? fU2 - fT2 : fU2 + fT2;
                    oVar8.f4167o = 1.0f / (1.0f - fAbs);
                    oVar8.f4166n = fAbs - (((f9 - fMin2) * fAbs) / (fMax2 - fMin2));
                    i7++;
                }
                return;
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                o oVar9 = this.S.get(getChildAt(i17));
                if (!Float.isNaN(oVar9.f4165m)) {
                    fMin = Math.min(fMin, oVar9.f4165m);
                    fMax = Math.max(fMax, oVar9.f4165m);
                }
            }
            while (i7 < childCount) {
                o oVar10 = this.S.get(getChildAt(i7));
                if (!Float.isNaN(oVar10.f4165m)) {
                    oVar10.f4167o = 1.0f / (1.0f - fAbs);
                    if (z8) {
                        oVar10.f4166n = fAbs - (((fMax - oVar10.f4165m) / (fMax - fMin)) * fAbs);
                    } else {
                        oVar10.f4166n = fAbs - (((oVar10.f4165m - fMin) * fAbs) / (fMax - fMin));
                    }
                }
                i7++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect W0(androidx.constraintlayout.core.widgets.e cw) {
        this.D1.top = cw.p0();
        this.D1.left = cw.o0();
        Rect rect = this.D1;
        int iM0 = cw.m0();
        Rect rect2 = this.D1;
        rect.right = iM0 + rect2.left;
        int iD = cw.D();
        Rect rect3 = this.D1;
        rect2.bottom = iD + rect3.top;
        return rect3;
    }

    private boolean h0(View view, MotionEvent event, float offsetX, float offsetY) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            event.offsetLocation(offsetX, offsetY);
            boolean zOnTouchEvent = view.onTouchEvent(event);
            event.offsetLocation(-offsetX, -offsetY);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        motionEventObtain.offsetLocation(offsetX, offsetY);
        if (this.K1 == null) {
            this.K1 = new Matrix();
        }
        matrix.invert(this.K1);
        motionEventObtain.transform(this.K1);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void i0() {
        s sVar = this.I;
        if (sVar == null) {
            Log.e(U1, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iN = sVar.N();
        s sVar2 = this.I;
        j0(iN, sVar2.o(sVar2.N()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (s.b bVar : this.I.s()) {
            if (bVar == this.I.f4214c) {
                Log.v(U1, "CHECK: CURRENT");
            }
            k0(bVar);
            int I = bVar.I();
            int iB = bVar.B();
            String strI = androidx.constraintlayout.motion.widget.c.i(getContext(), I);
            String strI2 = androidx.constraintlayout.motion.widget.c.i(getContext(), iB);
            if (sparseIntArray.get(I) == iB) {
                Log.e(U1, "CHECK: two transitions with the same start and end " + strI + "->" + strI2);
            }
            if (sparseIntArray2.get(iB) == I) {
                Log.e(U1, "CHECK: you can't have reverse transitions" + strI + "->" + strI2);
            }
            sparseIntArray.put(I, iB);
            sparseIntArray2.put(iB, I);
            if (this.I.o(I) == null) {
                Log.e(U1, " no such constraintSetStart " + strI);
            }
            if (this.I.o(iB) == null) {
                Log.e(U1, " no such constraintSetEnd " + strI);
            }
        }
    }

    private void j0(int csetId, androidx.constraintlayout.widget.d set) {
        String strI = androidx.constraintlayout.motion.widget.c.i(getContext(), csetId);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(U1, "CHECK: " + strI + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (set.k0(id) == null) {
                Log.w(U1, "CHECK: " + strI + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.c.k(childAt));
            }
        }
        int[] iArrO0 = set.o0();
        for (int i8 = 0; i8 < iArrO0.length; i8++) {
            int i9 = iArrO0[i8];
            String strI2 = androidx.constraintlayout.motion.widget.c.i(getContext(), i9);
            if (findViewById(iArrO0[i8]) == null) {
                Log.w(U1, "CHECK: " + strI + " NO View matches id " + strI2);
            }
            if (set.n0(i9) == -1) {
                Log.w(U1, "CHECK: " + strI + "(" + strI2 + ") no LAYOUT_HEIGHT");
            }
            if (set.u0(i9) == -1) {
                Log.w(U1, "CHECK: " + strI + "(" + strI2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void k0(s.b transition) {
        if (transition.I() == transition.B()) {
            Log.e(U1, "CHECK: start and end constraint set should not be the same!");
        }
    }

    private static boolean k1(float velocity, float position, float maxAcceleration) {
        if (velocity > 0.0f) {
            float f8 = velocity / maxAcceleration;
            return position + ((velocity * f8) - (((maxAcceleration * f8) * f8) / 2.0f)) > 1.0f;
        }
        float f9 = (-velocity) / maxAcceleration;
        return position + ((velocity * f9) + (((maxAcceleration * f9) * f9) / 2.0f)) < 0.0f;
    }

    private void m0() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            o oVar = this.S.get(childAt);
            if (oVar != null) {
                oVar.V(childAt);
            }
        }
    }

    @SuppressLint({"LogConditional"})
    private void n0() {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            Log.v(U1, " " + androidx.constraintlayout.motion.widget.c.g() + " " + androidx.constraintlayout.motion.widget.c.k(this) + " " + androidx.constraintlayout.motion.widget.c.i(getContext(), this.N) + " " + androidx.constraintlayout.motion.widget.c.k(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void t0() {
        boolean z7;
        float fSignum = Math.signum(this.B0 - this.W);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f3849J;
        float interpolation = this.W + (!(interpolator instanceof androidx.constraintlayout.motion.utils.b) ? (((nanoTime - this.A0) * fSignum) * 1.0E-9f) / this.U : 0.0f);
        if (this.C0) {
            interpolation = this.B0;
        }
        if ((fSignum <= 0.0f || interpolation < this.B0) && (fSignum > 0.0f || interpolation > this.B0)) {
            z7 = false;
        } else {
            interpolation = this.B0;
            z7 = true;
        }
        if (interpolator != null && !z7) {
            interpolation = this.K0 ? interpolator.getInterpolation((nanoTime - this.T) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.B0) || (fSignum <= 0.0f && interpolation <= this.B0)) {
            interpolation = this.B0;
        }
        this.f3866q1 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.K;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            o oVar = this.S.get(childAt);
            if (oVar != null) {
                oVar.L(childAt, interpolation, nanoTime2, this.f3867r1);
            }
        }
        if (this.f3859j1) {
            requestLayout();
        }
    }

    private void u0() {
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if ((this.F0 == null && ((copyOnWriteArrayList = this.f3852c1) == null || copyOnWriteArrayList.isEmpty())) || this.f3857h1 == this.V) {
            return;
        }
        if (this.f3856g1 != -1) {
            l lVar = this.F0;
            if (lVar != null) {
                lVar.c(this, this.M, this.O);
            }
            CopyOnWriteArrayList<l> copyOnWriteArrayList2 = this.f3852c1;
            if (copyOnWriteArrayList2 != null) {
                Iterator<l> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().c(this, this.M, this.O);
                }
            }
            this.f3858i1 = true;
        }
        this.f3856g1 = -1;
        float f8 = this.V;
        this.f3857h1 = f8;
        l lVar2 = this.F0;
        if (lVar2 != null) {
            lVar2.a(this, this.M, this.O, f8);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList3 = this.f3852c1;
        if (copyOnWriteArrayList3 != null) {
            Iterator<l> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.M, this.O, this.V);
            }
        }
        this.f3858i1 = true;
    }

    private void w0(MotionLayout motionLayout, int mBeginState, int mEndState) {
        l lVar = this.F0;
        if (lVar != null) {
            lVar.c(this, mBeginState, mEndState);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3852c1;
        if (copyOnWriteArrayList != null) {
            Iterator<l> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().c(motionLayout, mBeginState, mEndState);
            }
        }
    }

    String A0(int id) {
        s sVar = this.I;
        if (sVar == null) {
            return null;
        }
        return sVar.X(id);
    }

    public void B0(boolean showPaths) {
        this.I0 = showPaths ? 2 : 1;
        invalidate();
    }

    o C0(int mTouchAnchorId) {
        return this.S.get(findViewById(mTouchAnchorId));
    }

    public s.b D0(int id) {
        return this.I.O(id);
    }

    public void E0(View view, float posOnViewX, float posOnViewY, float[] returnVelocity, int type) {
        float interpolation;
        float fA = this.L;
        float f8 = this.W;
        if (this.f3849J != null) {
            float fSignum = Math.signum(this.B0 - f8);
            float interpolation2 = this.f3849J.getInterpolation(this.W + f3848f2);
            interpolation = this.f3849J.getInterpolation(this.W);
            fA = (fSignum * ((interpolation2 - interpolation) / f3848f2)) / this.U;
        } else {
            interpolation = f8;
        }
        Interpolator interpolator = this.f3849J;
        if (interpolator instanceof q) {
            fA = ((q) interpolator).a();
        }
        o oVar = this.S.get(view);
        if ((type & 1) == 0) {
            oVar.C(interpolation, view.getWidth(), view.getHeight(), posOnViewX, posOnViewY, returnVelocity);
        } else {
            oVar.p(interpolation, posOnViewX, posOnViewY, returnVelocity);
        }
        if (type < 2) {
            returnVelocity[0] = returnVelocity[0] * fA;
            returnVelocity[1] = returnVelocity[1] * fA;
        }
    }

    public boolean H0() {
        return this.E1;
    }

    public boolean I0() {
        return this.f3873x1;
    }

    public boolean J0() {
        return this.R;
    }

    public boolean K0(int viewTransitionId) {
        s sVar = this.I;
        if (sVar != null) {
            return sVar.U(viewTransitionId);
        }
        return false;
    }

    public void L0(int id) {
        if (!isAttachedToWindow()) {
            this.N = id;
        }
        if (this.M == id) {
            setProgress(0.0f);
        } else if (this.O == id) {
            setProgress(1.0f);
        } else {
            setTransition(id, id);
        }
    }

    int M0(String id) {
        s sVar = this.I;
        if (sVar == null) {
            return 0;
        }
        return sVar.W(id);
    }

    protected i N0() {
        return j.i();
    }

    void O0() {
        s sVar = this.I;
        if (sVar == null) {
            return;
        }
        if (sVar.i(this, this.N)) {
            requestLayout();
            return;
        }
        int i7 = this.N;
        if (i7 != -1) {
            this.I.f(this, i7);
        }
        if (this.I.r0()) {
            this.I.p0();
        }
    }

    @Deprecated
    public void Q0() {
        Log.e(U1, "This method is deprecated. Please call rebuildScene() instead.");
        R0();
    }

    public void R0() {
        this.G1.k();
        invalidate();
    }

    public boolean S0(l listener) {
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3852c1;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(listener);
    }

    @t0(api = 17)
    public void T0(int id, int duration) {
        this.f3873x1 = true;
        this.A1 = getWidth();
        this.B1 = getHeight();
        int rotation = getDisplay().getRotation();
        this.f3874y1 = (rotation + 1) % 4 <= (this.C1 + 1) % 4 ? 2 : 1;
        this.C1 = rotation;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            androidx.constraintlayout.motion.utils.e eVar = this.f3875z1.get(childAt);
            if (eVar == null) {
                eVar = new androidx.constraintlayout.motion.utils.e();
                this.f3875z1.put(childAt, eVar);
            }
            eVar.a(childAt);
        }
        this.M = -1;
        this.O = id;
        this.I.n0(-1, id);
        this.G1.h(this.f4491c, null, this.I.o(this.O));
        this.V = 0.0f;
        this.W = 0.0f;
        invalidate();
        a1(new b());
        if (duration > 0) {
            this.U = duration / 1000.0f;
        }
    }

    public void U0(int id) {
        if (getCurrentState() == -1) {
            c1(id);
            return;
        }
        int[] iArr = this.f3871v1;
        if (iArr == null) {
            this.f3871v1 = new int[4];
        } else if (iArr.length <= this.f3872w1) {
            this.f3871v1 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f3871v1;
        int i7 = this.f3872w1;
        this.f3872w1 = i7 + 1;
        iArr2[i7] = id;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0  */
    public void X0(int touchUpMode, float position, float currentVelocity) {
        if (this.I == null || this.W == position) {
            return;
        }
        this.K0 = true;
        this.T = getNanoTime();
        this.U = this.I.t() / 1000.0f;
        this.B0 = position;
        this.D0 = true;
        if (touchUpMode == 0 || touchUpMode == 1 || touchUpMode == 2) {
            if (touchUpMode != 1 || touchUpMode == 7) {
                position = 0.0f;
            } else if (touchUpMode == 2 || touchUpMode == 6) {
                position = 1.0f;
            }
            if (this.I.n() == 0) {
                this.L0.b(this.W, position, currentVelocity, this.U, this.I.B(), this.I.C());
            } else {
                this.L0.f(this.W, position, currentVelocity, this.I.J(), this.I.K(), this.I.I(), this.I.L(), this.I.H());
            }
            int i7 = this.N;
            this.B0 = position;
            this.N = i7;
            this.f3849J = this.L0;
        } else if (touchUpMode == 4) {
            this.M0.b(currentVelocity, this.W, this.I.B());
            this.f3849J = this.M0;
        } else if (touchUpMode != 5) {
            if (touchUpMode == 6 || touchUpMode == 7) {
                if (touchUpMode != 1) {
                    position = 0.0f;
                } else {
                    position = 0.0f;
                }
                if (this.I.n() == 0) {
                    this.L0.b(this.W, position, currentVelocity, this.U, this.I.B(), this.I.C());
                } else {
                    this.L0.f(this.W, position, currentVelocity, this.I.J(), this.I.K(), this.I.I(), this.I.L(), this.I.H());
                }
                int i8 = this.N;
                this.B0 = position;
                this.N = i8;
                this.f3849J = this.L0;
            }
        } else if (k1(currentVelocity, this.W, this.I.B())) {
            this.M0.b(currentVelocity, this.W, this.I.B());
            this.f3849J = this.M0;
        } else {
            this.L0.b(this.W, position, currentVelocity, this.U, this.I.B(), this.I.C());
            this.L = 0.0f;
            int i9 = this.N;
            this.B0 = position;
            this.N = i9;
            this.f3849J = this.L0;
        }
        this.C0 = false;
        this.T = getNanoTime();
        invalidate();
    }

    public void Y0(float position, float currentVelocity) {
        if (this.I == null || this.W == position) {
            return;
        }
        this.K0 = true;
        this.T = getNanoTime();
        this.U = this.I.t() / 1000.0f;
        this.B0 = position;
        this.D0 = true;
        this.L0.f(this.W, position, currentVelocity, this.I.J(), this.I.K(), this.I.I(), this.I.L(), this.I.H());
        int i7 = this.N;
        this.B0 = position;
        this.N = i7;
        this.f3849J = this.L0;
        this.C0 = false;
        this.T = getNanoTime();
        invalidate();
    }

    public void Z0() {
        f0(1.0f);
        this.f3870u1 = null;
    }

    public void a1(Runnable onComplete) {
        f0(1.0f);
        this.f3870u1 = onComplete;
    }

    public void b1() {
        f0(0.0f);
    }

    public void c1(int id) {
        if (isAttachedToWindow()) {
            e1(id, -1, -1);
            return;
        }
        if (this.f3869t1 == null) {
            this.f3869t1 = new k();
        }
        this.f3869t1.d(id);
    }

    public void d1(int id, int duration) {
        if (isAttachedToWindow()) {
            f1(id, -1, -1, duration);
            return;
        }
        if (this.f3869t1 == null) {
            this.f3869t1 = new k();
        }
        this.f3869t1.d(id);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a0 a0Var;
        ArrayList<MotionHelper> arrayList = this.f3851b1;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().h(canvas);
            }
        }
        s0(false);
        s sVar = this.I;
        if (sVar != null && (a0Var = sVar.f4230s) != null) {
            a0Var.d();
        }
        super.dispatchDraw(canvas);
        if (this.I == null) {
            return;
        }
        if ((this.I0 & 1) == 1 && !isInEditMode()) {
            this.f3853d1++;
            long nanoTime = getNanoTime();
            long j7 = this.f3854e1;
            if (j7 != -1) {
                long j8 = nanoTime - j7;
                if (j8 > 200000000) {
                    this.f3855f1 = ((int) ((this.f3853d1 / (j8 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f3853d1 = 0;
                    this.f3854e1 = nanoTime;
                }
            } else {
                this.f3854e1 = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            String str = this.f3855f1 + " fps " + androidx.constraintlayout.motion.widget.c.l(this, this.M) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(androidx.constraintlayout.motion.widget.c.l(this, this.O));
            sb.append(" (progress: ");
            sb.append(progress);
            sb.append(" ) state=");
            int i7 = this.N;
            sb.append(i7 == -1 ? "undefined" : androidx.constraintlayout.motion.widget.c.l(this, i7));
            String string = sb.toString();
            paint.setColor(n2.f6743t);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.I0 > 1) {
            if (this.J0 == null) {
                this.J0 = new g();
            }
            this.J0.a(canvas, this.S, this.I.t(), this.I0);
        }
        ArrayList<MotionHelper> arrayList2 = this.f3851b1;
        if (arrayList2 != null) {
            Iterator<MotionHelper> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().i(canvas);
            }
        }
    }

    @Override // androidx.core.view.w1
    public void e(@m0 View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (this.T0 || dxConsumed != 0 || dyConsumed != 0) {
            consumed[0] = consumed[0] + dxUnconsumed;
            consumed[1] = consumed[1] + dyUnconsumed;
        }
        this.T0 = false;
    }

    public void e0(l listener) {
        if (this.f3852c1 == null) {
            this.f3852c1 = new CopyOnWriteArrayList<>();
        }
        this.f3852c1.add(listener);
    }

    public void e1(int id, int screenWidth, int screenHeight) {
        f1(id, screenWidth, screenHeight, -1);
    }

    @Override // androidx.core.view.v1
    public void f(@m0 View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
    }

    void f0(float position) {
        s sVar = this.I;
        if (sVar == null) {
            return;
        }
        float f8 = this.W;
        float f9 = this.V;
        if (f8 != f9 && this.C0) {
            this.W = f9;
        }
        float f10 = this.W;
        if (f10 == position) {
            return;
        }
        this.K0 = false;
        this.B0 = position;
        this.U = sVar.t() / 1000.0f;
        setProgress(this.B0);
        this.f3849J = null;
        this.K = this.I.x();
        this.C0 = false;
        this.T = getNanoTime();
        this.D0 = true;
        this.V = f10;
        this.W = f10;
        invalidate();
    }

    public void f1(int id, int screenWidth, int screenHeight, int duration) {
        androidx.constraintlayout.widget.g gVar;
        int iA;
        s sVar = this.I;
        if (sVar != null && (gVar = sVar.f4213b) != null && (iA = gVar.a(this.N, id, screenWidth, screenHeight)) != -1) {
            id = iA;
        }
        int i7 = this.N;
        if (i7 == id) {
            return;
        }
        if (this.M == id) {
            f0(0.0f);
            if (duration > 0) {
                this.U = duration / 1000.0f;
                return;
            }
            return;
        }
        if (this.O == id) {
            f0(1.0f);
            if (duration > 0) {
                this.U = duration / 1000.0f;
                return;
            }
            return;
        }
        this.O = id;
        if (i7 != -1) {
            setTransition(i7, id);
            f0(1.0f);
            this.W = 0.0f;
            Z0();
            if (duration > 0) {
                this.U = duration / 1000.0f;
                return;
            }
            return;
        }
        this.K0 = false;
        this.B0 = 1.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.A0 = getNanoTime();
        this.T = getNanoTime();
        this.C0 = false;
        this.f3849J = null;
        if (duration == -1) {
            this.U = this.I.t() / 1000.0f;
        }
        this.M = -1;
        this.I.n0(-1, this.O);
        SparseArray sparseArray = new SparseArray();
        if (duration == 0) {
            this.U = this.I.t() / 1000.0f;
        } else if (duration > 0) {
            this.U = duration / 1000.0f;
        }
        int childCount = getChildCount();
        this.S.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            this.S.put(childAt, new o(childAt));
            sparseArray.put(childAt.getId(), this.S.get(childAt));
        }
        this.D0 = true;
        this.G1.h(this.f4491c, null, this.I.o(id));
        R0();
        this.G1.a();
        m0();
        int width = getWidth();
        int height = getHeight();
        if (this.f3851b1 != null) {
            for (int i9 = 0; i9 < childCount; i9++) {
                o oVar = this.S.get(getChildAt(i9));
                if (oVar != null) {
                    this.I.z(oVar);
                }
            }
            Iterator<MotionHelper> it = this.f3851b1.iterator();
            while (it.hasNext()) {
                it.next().g(this, this.S);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                o oVar2 = this.S.get(getChildAt(i10));
                if (oVar2 != null) {
                    oVar2.a0(width, height, this.U, getNanoTime());
                }
            }
        } else {
            for (int i11 = 0; i11 < childCount; i11++) {
                o oVar3 = this.S.get(getChildAt(i11));
                if (oVar3 != null) {
                    this.I.z(oVar3);
                    oVar3.a0(width, height, this.U, getNanoTime());
                }
            }
        }
        float fM = this.I.M();
        if (fM != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i12 = 0; i12 < childCount; i12++) {
                o oVar4 = this.S.get(getChildAt(i12));
                float fU = oVar4.u() + oVar4.t();
                fMin = Math.min(fMin, fU);
                fMax = Math.max(fMax, fU);
            }
            for (int i13 = 0; i13 < childCount; i13++) {
                o oVar5 = this.S.get(getChildAt(i13));
                float fT = oVar5.t();
                float fU2 = oVar5.u();
                oVar5.f4167o = 1.0f / (1.0f - fM);
                oVar5.f4166n = fM - ((((fT + fU2) - fMin) * fM) / (fMax - fMin));
            }
        }
        this.V = 0.0f;
        this.W = 0.0f;
        this.D0 = true;
        invalidate();
    }

    public boolean g0(int viewTransitionId, o motionController) {
        s sVar = this.I;
        if (sVar != null) {
            return sVar.h(viewTransitionId, motionController);
        }
        return false;
    }

    public void g1() {
        this.G1.h(this.f4491c, this.I.o(this.M), this.I.o(this.O));
        R0();
    }

    public int[] getConstraintSetIds() {
        s sVar = this.I;
        if (sVar == null) {
            return null;
        }
        return sVar.r();
    }

    public int getCurrentState() {
        return this.N;
    }

    public ArrayList<s.b> getDefinedTransitions() {
        s sVar = this.I;
        if (sVar == null) {
            return null;
        }
        return sVar.s();
    }

    public androidx.constraintlayout.motion.widget.d getDesignTool() {
        if (this.N0 == null) {
            this.N0 = new androidx.constraintlayout.motion.widget.d(this);
        }
        return this.N0;
    }

    public int getEndState() {
        return this.O;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.W;
    }

    public s getScene() {
        return this.I;
    }

    public int getStartState() {
        return this.M;
    }

    public float getTargetPosition() {
        return this.B0;
    }

    public Bundle getTransitionState() {
        if (this.f3869t1 == null) {
            this.f3869t1 = new k();
        }
        this.f3869t1.c();
        return this.f3869t1.b();
    }

    public long getTransitionTimeMs() {
        s sVar = this.I;
        if (sVar != null) {
            this.U = sVar.t() / 1000.0f;
        }
        return (long) (this.U * 1000.0f);
    }

    public float getVelocity() {
        return this.L;
    }

    public void h1(int stateId, androidx.constraintlayout.widget.d set) {
        s sVar = this.I;
        if (sVar != null) {
            sVar.j0(stateId, set);
        }
        g1();
        if (this.N == stateId) {
            set.r(this);
        }
    }

    public void i1(int stateId, androidx.constraintlayout.widget.d set, int duration) {
        if (this.I != null && this.N == stateId) {
            h1(R.id.view_transition, z0(stateId));
            setState(R.id.view_transition, -1, -1);
            h1(stateId, set);
            s.b bVar = new s.b(-1, this.I, R.id.view_transition, stateId);
            bVar.O(duration);
            setTransition(bVar);
            Z0();
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j1(int viewTransitionId, View... view) {
        s sVar = this.I;
        if (sVar != null) {
            sVar.t0(viewTransitionId, view);
        } else {
            Log.e(U1, " no motionScene");
        }
    }

    public androidx.constraintlayout.widget.d l0(int id) {
        s sVar = this.I;
        if (sVar == null) {
            return null;
        }
        androidx.constraintlayout.widget.d dVarO = sVar.o(id);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.I(dVarO);
        return dVar;
    }

    void o0(boolean disable) {
        s sVar = this.I;
        if (sVar == null) {
            return;
        }
        sVar.k(disable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        s.b bVar;
        int i7;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.C1 = display.getRotation();
        }
        s sVar = this.I;
        if (sVar != null && (i7 = this.N) != -1) {
            androidx.constraintlayout.widget.d dVarO = sVar.o(i7);
            this.I.h0(this);
            ArrayList<MotionHelper> arrayList = this.f3851b1;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().b(this);
                }
            }
            if (dVarO != null) {
                dVarO.r(this);
            }
            this.M = this.N;
        }
        O0();
        k kVar = this.f3869t1;
        if (kVar != null) {
            if (this.E1) {
                post(new d());
                return;
            } else {
                kVar.a();
                return;
            }
        }
        s sVar2 = this.I;
        if (sVar2 == null || (bVar = sVar2.f4214c) == null || bVar.z() != 4) {
            return;
        }
        Z0();
        setState(m.SETUP);
        setState(m.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        v vVarJ;
        int iS;
        RectF rectFR;
        s sVar = this.I;
        if (sVar != null && this.R) {
            a0 a0Var = sVar.f4230s;
            if (a0Var != null) {
                a0Var.l(event);
            }
            s.b bVar = this.I.f4214c;
            if (bVar != null && bVar.K() && (vVarJ = bVar.J()) != null && ((event.getAction() != 0 || (rectFR = vVarJ.r(this, new RectF())) == null || rectFR.contains(event.getX(), event.getY())) && (iS = vVarJ.s()) != -1)) {
                View view = this.J1;
                if (view == null || view.getId() != iS) {
                    this.J1 = findViewById(iS);
                }
                View view2 = this.J1;
                if (view2 != null) {
                    this.I1.set(view2.getLeft(), this.J1.getTop(), this.J1.getRight(), this.J1.getBottom());
                    if (this.I1.contains(event.getX(), event.getY()) && !F0(this.J1.getLeft(), this.J1.getTop(), this.J1, event)) {
                        return onTouchEvent(event);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f3868s1 = true;
        try {
            if (this.I == null) {
                super.onLayout(changed, left, top, right, bottom);
                return;
            }
            int i7 = right - left;
            int i8 = bottom - top;
            if (this.R0 != i7 || this.S0 != i8) {
                R0();
                s0(true);
            }
            this.R0 = i7;
            this.S0 = i8;
            this.P0 = i7;
            this.Q0 = i8;
        } finally {
            this.f3868s1 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.I == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        boolean z7 = false;
        boolean z8 = (this.P == widthMeasureSpec && this.Q == heightMeasureSpec) ? false : true;
        if (this.H1) {
            this.H1 = false;
            O0();
            P0();
            z8 = true;
        }
        if (this.f4496h) {
            z8 = true;
        }
        this.P = widthMeasureSpec;
        this.Q = heightMeasureSpec;
        int iN = this.I.N();
        int iU = this.I.u();
        if ((z8 || this.G1.i(iN, iU)) && this.M != -1) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.G1.h(this.f4491c, this.I.o(iN), this.I.o(iU));
            this.G1.k();
            this.G1.l(iN, iU);
        } else {
            if (z8) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
            z7 = true;
        }
        if (this.f3859j1 || z7) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iM0 = this.f4491c.m0() + getPaddingLeft() + getPaddingRight();
            int iD = this.f4491c.D() + paddingTop;
            int i7 = this.f3864o1;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                int i8 = this.f3860k1;
                iM0 = (int) (i8 + (this.f3866q1 * (this.f3862m1 - i8)));
                requestLayout();
            }
            int i9 = this.f3865p1;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                int i10 = this.f3861l1;
                iD = (int) (i10 + (this.f3866q1 * (this.f3863n1 - i10)));
                requestLayout();
            }
            setMeasuredDimension(iM0, iD);
        }
        t0();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedFling(@m0 View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.x1
    public boolean onNestedPreFling(@m0 View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        s sVar = this.I;
        if (sVar != null) {
            sVar.m0(w());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        s sVar = this.I;
        if (sVar == null || !this.R || !sVar.r0()) {
            return super.onTouchEvent(event);
        }
        s.b bVar = this.I.f4214c;
        if (bVar != null && !bVar.K()) {
            return super.onTouchEvent(event);
        }
        this.I.f0(event, getCurrentState(), this);
        if (this.I.f4214c.L(4)) {
            return this.I.f4214c.J().t();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f3852c1 == null) {
                this.f3852c1 = new CopyOnWriteArrayList<>();
            }
            this.f3852c1.add(motionHelper);
            if (motionHelper.e()) {
                if (this.Z0 == null) {
                    this.Z0 = new ArrayList<>();
                }
                this.Z0.add(motionHelper);
            }
            if (motionHelper.f()) {
                if (this.f3850a1 == null) {
                    this.f3850a1 = new ArrayList<>();
                }
                this.f3850a1.add(motionHelper);
            }
            if (motionHelper.j()) {
                if (this.f3851b1 == null) {
                    this.f3851b1 = new ArrayList<>();
                }
                this.f3851b1.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.Z0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f3850a1;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.core.view.v1
    public boolean p(@m0 View child, @m0 View target, int axes, int type) {
        s.b bVar;
        s sVar = this.I;
        return (sVar == null || (bVar = sVar.f4214c) == null || bVar.J() == null || (this.I.f4214c.J().f() & 2) != 0) ? false : true;
    }

    public void p0(int transitionID, boolean enable) {
        s.b bVarD0 = D0(transitionID);
        if (enable) {
            bVarD0.Q(true);
            return;
        }
        s sVar = this.I;
        if (bVarD0 == sVar.f4214c) {
            for (s.b bVar : sVar.Q(this.N)) {
                if (bVar.K()) {
                    this.I.f4214c = bVar;
                    break;
                }
            }
        }
        bVarD0.Q(false);
    }

    @Override // androidx.core.view.v1
    public void q(@m0 View child, @m0 View target, int axes, int type) {
        this.W0 = getNanoTime();
        this.X0 = 0.0f;
        this.U0 = 0.0f;
        this.V0 = 0.0f;
    }

    public void q0(int viewTransitionId, boolean enable) {
        s sVar = this.I;
        if (sVar != null) {
            sVar.l(viewTransitionId, enable);
        }
    }

    @Override // androidx.core.view.v1
    public void r(@m0 View target, int type) {
        s sVar = this.I;
        if (sVar != null) {
            float f8 = this.X0;
            if (f8 == 0.0f) {
                return;
            }
            sVar.e0(this.U0 / f8, this.V0 / f8);
        }
    }

    void r0(boolean start) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            o oVar = this.S.get(getChildAt(i7));
            if (oVar != null) {
                oVar.i(start);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        s sVar;
        s.b bVar;
        if (!this.f3859j1 && this.N == -1 && (sVar = this.I) != null && (bVar = sVar.f4214c) != null) {
            int iE = bVar.E();
            if (iE == 0) {
                return;
            }
            if (iE == 2) {
                int childCount = getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    this.S.get(getChildAt(i7)).P();
                }
                return;
            }
        }
        super.requestLayout();
    }

    @Override // androidx.core.view.v1
    public void s(@m0 View target, int dx, int dy, @m0 int[] consumed, int type) {
        s.b bVar;
        v vVarJ;
        int iS;
        s sVar = this.I;
        if (sVar == null || (bVar = sVar.f4214c) == null || !bVar.K()) {
            return;
        }
        int i7 = -1;
        if (!bVar.K() || (vVarJ = bVar.J()) == null || (iS = vVarJ.s()) == -1 || target.getId() == iS) {
            if (sVar.D()) {
                v vVarJ2 = bVar.J();
                if (vVarJ2 != null && (vVarJ2.f() & 4) != 0) {
                    i7 = dy;
                }
                float f8 = this.V;
                if ((f8 == 1.0f || f8 == 0.0f) && target.canScrollVertically(i7)) {
                    return;
                }
            }
            if (bVar.J() != null && (bVar.J().f() & 1) != 0) {
                float F = sVar.F(dx, dy);
                float f9 = this.W;
                if ((f9 <= 0.0f && F < 0.0f) || (f9 >= 1.0f && F > 0.0f)) {
                    target.setNestedScrollingEnabled(false);
                    target.post(new c(this, target));
                    return;
                }
            }
            float f10 = this.V;
            long nanoTime = getNanoTime();
            float f11 = dx;
            this.U0 = f11;
            float f12 = dy;
            this.V0 = f12;
            this.X0 = (float) ((nanoTime - this.W0) * 1.0E-9d);
            this.W0 = nanoTime;
            sVar.d0(f11, f12);
            if (f10 != this.V) {
                consumed[0] = dx;
                consumed[1] = dy;
            }
            s0(false);
            if (consumed[0] == 0 && consumed[1] == 0) {
                return;
            }
            this.T0 = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:127:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:143:0x0221  */
    /* JADX WARN: Code duplicated, block: B:180:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ab, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x0110  */
    /* JADX WARN: Code duplicated, block: B:74:0x0117  */
    /* JADX WARN: Code duplicated, block: B:86:0x0137  */
    /* JADX WARN: Code duplicated, block: B:89:0x014e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0150  */
    /* JADX WARN: Code duplicated, block: B:93:0x0158  */
    /* JADX WARN: Code duplicated, block: B:96:0x016f  */
    /* JADX WARN: Code duplicated, block: B:98:0x017f  */
    void s0(boolean force) {
        boolean z7;
        char c8;
        int childCount;
        long nanoTime;
        Interpolator interpolator;
        float interpolation;
        Interpolator interpolator2;
        int i7;
        int i8;
        int i9;
        int i10;
        View childAt;
        o oVar;
        boolean z8;
        if (this.A0 == -1) {
            this.A0 = getNanoTime();
        }
        float f8 = this.W;
        if (f8 > 0.0f && f8 < 1.0f) {
            this.N = -1;
        }
        boolean z9 = false;
        if (this.Y0 || (this.D0 && (force || this.B0 != f8))) {
            float fSignum = Math.signum(this.B0 - f8);
            long nanoTime2 = getNanoTime();
            Interpolator interpolator3 = this.f3849J;
            float f9 = !(interpolator3 instanceof q) ? (((nanoTime2 - this.A0) * fSignum) * 1.0E-9f) / this.U : 0.0f;
            float f10 = this.W + f9;
            if (this.C0) {
                f10 = this.B0;
            }
            if ((fSignum <= 0.0f || f10 < this.B0) && (fSignum > 0.0f || f10 > this.B0)) {
                z7 = false;
            } else {
                f10 = this.B0;
                this.D0 = false;
                z7 = true;
            }
            this.W = f10;
            this.V = f10;
            this.A0 = nanoTime2;
            if (interpolator3 == null || z7) {
                this.L = f9;
            } else {
                if (this.K0) {
                    float interpolation2 = interpolator3.getInterpolation((nanoTime2 - this.T) * 1.0E-9f);
                    Interpolator interpolator4 = this.f3849J;
                    androidx.constraintlayout.motion.utils.b bVar = this.L0;
                    c8 = interpolator4 == bVar ? bVar.e() ? (char) 2 : (char) 1 : (char) 0;
                    this.W = interpolation2;
                    this.A0 = nanoTime2;
                    Interpolator interpolator5 = this.f3849J;
                    if (interpolator5 instanceof q) {
                        float fA = ((q) interpolator5).a();
                        this.L = fA;
                        if (Math.abs(fA) * this.U <= f3848f2 && c8 == 2) {
                            this.D0 = false;
                        }
                        if (fA > 0.0f && interpolation2 >= 1.0f) {
                            this.W = 1.0f;
                            this.D0 = false;
                            interpolation2 = 1.0f;
                        }
                        if (fA >= 0.0f || interpolation2 > 0.0f) {
                            f10 = interpolation2;
                        } else {
                            this.W = 0.0f;
                            this.D0 = false;
                            f10 = 0.0f;
                        }
                    } else {
                        f10 = interpolation2;
                    }
                } else {
                    float interpolation3 = interpolator3.getInterpolation(f10);
                    Interpolator interpolator6 = this.f3849J;
                    if (interpolator6 instanceof q) {
                        this.L = ((q) interpolator6).a();
                    } else {
                        this.L = ((interpolator6.getInterpolation(f10 + f9) - interpolation3) * fSignum) / f9;
                    }
                    f10 = interpolation3;
                }
                if (Math.abs(this.L) > f3848f2) {
                    setState(m.MOVING);
                }
                if (c8 != 1) {
                    if ((fSignum <= 0.0f && f10 >= this.B0) || (fSignum <= 0.0f && f10 <= this.B0)) {
                        f10 = this.B0;
                        this.D0 = false;
                    }
                    if (f10 < 1.0f || f10 <= 0.0f) {
                        this.D0 = false;
                        setState(m.FINISHED);
                    }
                }
                childCount = getChildCount();
                this.Y0 = false;
                nanoTime = getNanoTime();
                this.f3866q1 = f10;
                interpolator = this.K;
                if (interpolator == null) {
                    interpolation = f10;
                } else {
                    interpolation = interpolator.getInterpolation(f10);
                }
                interpolator2 = this.K;
                if (interpolator2 != null) {
                    float interpolation4 = interpolator2.getInterpolation((fSignum / this.U) + f10);
                    this.L = interpolation4;
                    this.L = interpolation4 - this.K.getInterpolation(f10);
                }
                for (i7 = 0; i7 < childCount; i7++) {
                    childAt = getChildAt(i7);
                    oVar = this.S.get(childAt);
                    if (oVar != null) {
                        this.Y0 = oVar.L(childAt, interpolation, nanoTime, this.f3867r1) | this.Y0;
                    }
                }
                boolean z10 = (fSignum <= 0.0f && f10 >= this.B0) || (fSignum <= 0.0f && f10 <= this.B0);
                if (!this.Y0 && !this.D0 && z10) {
                    setState(m.FINISHED);
                }
                if (this.f3859j1) {
                    requestLayout();
                }
                this.Y0 = (!z10) | this.Y0;
                if (f10 <= 0.0f && (i10 = this.M) != -1 && this.N != i10) {
                    this.N = i10;
                    this.I.o(i10).p(this);
                    setState(m.FINISHED);
                    z9 = true;
                }
                if (f10 >= 1.0d) {
                    i8 = this.N;
                    i9 = this.O;
                    if (i8 != i9) {
                        this.N = i9;
                        this.I.o(i9).p(this);
                        setState(m.FINISHED);
                        z9 = true;
                    }
                }
                if (!this.Y0 || this.D0) {
                    invalidate();
                } else if ((fSignum > 0.0f && f10 == 1.0f) || (fSignum < 0.0f && f10 == 0.0f)) {
                    setState(m.FINISHED);
                }
                if (!this.Y0 && !this.D0 && ((fSignum > 0.0f && f10 == 1.0f) || (fSignum < 0.0f && f10 == 0.0f))) {
                    O0();
                }
            }
            c8 = 0;
            if (Math.abs(this.L) > f3848f2) {
                setState(m.MOVING);
            }
            if (c8 != 1) {
                if (fSignum <= 0.0f) {
                    f10 = this.B0;
                    this.D0 = false;
                } else {
                    f10 = this.B0;
                    this.D0 = false;
                }
                if (f10 < 1.0f) {
                    this.D0 = false;
                    setState(m.FINISHED);
                } else {
                    this.D0 = false;
                    setState(m.FINISHED);
                }
            }
            childCount = getChildCount();
            this.Y0 = false;
            nanoTime = getNanoTime();
            this.f3866q1 = f10;
            interpolator = this.K;
            if (interpolator == null) {
                interpolation = f10;
            } else {
                interpolation = interpolator.getInterpolation(f10);
            }
            interpolator2 = this.K;
            if (interpolator2 != null) {
                float interpolation5 = interpolator2.getInterpolation((fSignum / this.U) + f10);
                this.L = interpolation5;
                this.L = interpolation5 - this.K.getInterpolation(f10);
            }
            while (i7 < childCount) {
                childAt = getChildAt(i7);
                oVar = this.S.get(childAt);
                if (oVar != null) {
                    this.Y0 = oVar.L(childAt, interpolation, nanoTime, this.f3867r1) | this.Y0;
                }
            }
            if (fSignum <= 0.0f) {
            }
            if (!this.Y0) {
                setState(m.FINISHED);
            }
            if (this.f3859j1) {
                requestLayout();
            }
            this.Y0 = (!z10) | this.Y0;
            if (f10 <= 0.0f) {
                this.N = i10;
                this.I.o(i10).p(this);
                setState(m.FINISHED);
                z9 = true;
            }
            if (f10 >= 1.0d) {
                i8 = this.N;
                i9 = this.O;
                if (i8 != i9) {
                    this.N = i9;
                    this.I.o(i9).p(this);
                    setState(m.FINISHED);
                    z9 = true;
                }
            }
            if (this.Y0) {
                invalidate();
            } else {
                invalidate();
            }
            if (!this.Y0) {
                O0();
            }
        }
        float f11 = this.W;
        if (f11 < 1.0f) {
            if (f11 <= 0.0f) {
                int i11 = this.N;
                int i12 = this.M;
                z8 = i11 == i12 ? z9 : true;
                this.N = i12;
            }
            this.H1 |= z9;
            if (z9 && !this.f3868s1) {
                requestLayout();
            }
            this.V = this.W;
        }
        int i13 = this.N;
        int i14 = this.O;
        z8 = i13 == i14 ? z9 : true;
        this.N = i14;
        z9 = z8;
        this.H1 |= z9;
        if (z9) {
            requestLayout();
        }
        this.V = this.W;
    }

    public void setDebugMode(int debugMode) {
        this.I0 = debugMode;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean delayedApply) {
        this.E1 = delayedApply;
    }

    public void setInteractionEnabled(boolean enabled) {
        this.R = enabled;
    }

    public void setInterpolatedProgress(float pos) {
        if (this.I != null) {
            setState(m.MOVING);
            Interpolator interpolatorX = this.I.x();
            if (interpolatorX != null) {
                setProgress(interpolatorX.getInterpolation(pos));
                return;
            }
        }
        setProgress(pos);
    }

    public void setOnHide(float progress) {
        ArrayList<MotionHelper> arrayList = this.f3850a1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f3850a1.get(i7).setProgress(progress);
            }
        }
    }

    public void setOnShow(float progress) {
        ArrayList<MotionHelper> arrayList = this.Z0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.Z0.get(i7).setProgress(progress);
            }
        }
    }

    public void setProgress(float pos, float velocity) {
        if (!isAttachedToWindow()) {
            if (this.f3869t1 == null) {
                this.f3869t1 = new k();
            }
            this.f3869t1.e(pos);
            this.f3869t1.h(velocity);
            return;
        }
        setProgress(pos);
        setState(m.MOVING);
        this.L = velocity;
        if (velocity != 0.0f) {
            f0(velocity > 0.0f ? 1.0f : 0.0f);
        } else {
            if (pos == 0.0f || pos == 1.0f) {
                return;
            }
            f0(pos > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void setScene(s scene) {
        this.I = scene;
        scene.m0(w());
        R0();
    }

    void setStartState(int beginId) {
        if (isAttachedToWindow()) {
            this.N = beginId;
            return;
        }
        if (this.f3869t1 == null) {
            this.f3869t1 = new k();
        }
        this.f3869t1.f(beginId);
        this.f3869t1.d(beginId);
    }

    void setState(m newState) {
        m mVar = m.FINISHED;
        if (newState == mVar && this.N == -1) {
            return;
        }
        m mVar2 = this.F1;
        this.F1 = newState;
        m mVar3 = m.MOVING;
        if (mVar2 == mVar3 && newState == mVar3) {
            u0();
        }
        int i7 = e.f3880a[mVar2.ordinal()];
        if (i7 != 1 && i7 != 2) {
            if (i7 == 3 && newState == mVar) {
                v0();
                return;
            }
            return;
        }
        if (newState == mVar3) {
            u0();
        }
        if (newState == mVar) {
            v0();
        }
    }

    public void setTransition(int beginId, int endId) {
        if (!isAttachedToWindow()) {
            if (this.f3869t1 == null) {
                this.f3869t1 = new k();
            }
            this.f3869t1.f(beginId);
            this.f3869t1.d(endId);
            return;
        }
        s sVar = this.I;
        if (sVar != null) {
            this.M = beginId;
            this.O = endId;
            sVar.n0(beginId, endId);
            this.G1.h(this.f4491c, this.I.o(beginId), this.I.o(endId));
            R0();
            this.W = 0.0f;
            b1();
        }
    }

    public void setTransitionDuration(int milliseconds) {
        s sVar = this.I;
        if (sVar == null) {
            Log.e(U1, "MotionScene not defined");
        } else {
            sVar.k0(milliseconds);
        }
    }

    public void setTransitionListener(l listener) {
        this.F0 = listener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f3869t1 == null) {
            this.f3869t1 = new k();
        }
        this.f3869t1.g(bundle);
        if (isAttachedToWindow()) {
            this.f3869t1.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.c.i(context, this.M) + "->" + androidx.constraintlayout.motion.widget.c.i(context, this.O) + " (pos:" + this.W + " Dpos/Dt:" + this.L;
    }

    protected void v0() {
        int iIntValue;
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if ((this.F0 != null || ((copyOnWriteArrayList = this.f3852c1) != null && !copyOnWriteArrayList.isEmpty())) && this.f3856g1 == -1) {
            this.f3856g1 = this.N;
            if (this.L1.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.L1;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i7 = this.N;
            if (iIntValue != i7 && i7 != -1) {
                this.L1.add(Integer.valueOf(i7));
            }
        }
        P0();
        Runnable runnable = this.f3870u1;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f3871v1;
        if (iArr == null || this.f3872w1 <= 0) {
            return;
        }
        c1(iArr[0]);
        int[] iArr2 = this.f3871v1;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f3872w1--;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void x(int motionScene) {
        s.b bVar;
        if (motionScene == 0) {
            this.I = null;
            return;
        }
        try {
            s sVar = new s(getContext(), this, motionScene);
            this.I = sVar;
            if (this.N == -1) {
                this.N = sVar.N();
                this.M = this.I.N();
                this.O = this.I.u();
            }
            if (!isAttachedToWindow()) {
                this.I = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.C1 = display == null ? 0 : display.getRotation();
                s sVar2 = this.I;
                if (sVar2 != null) {
                    androidx.constraintlayout.widget.d dVarO = sVar2.o(this.N);
                    this.I.h0(this);
                    ArrayList<MotionHelper> arrayList = this.f3851b1;
                    if (arrayList != null) {
                        Iterator<MotionHelper> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().b(this);
                        }
                    }
                    if (dVarO != null) {
                        dVarO.r(this);
                    }
                    this.M = this.N;
                }
                O0();
                k kVar = this.f3869t1;
                if (kVar != null) {
                    if (this.E1) {
                        post(new a());
                        return;
                    } else {
                        kVar.a();
                        return;
                    }
                }
                s sVar3 = this.I;
                if (sVar3 == null || (bVar = sVar3.f4214c) == null || bVar.z() != 4) {
                    return;
                }
                Z0();
                setState(m.SETUP);
                setState(m.MOVING);
            } catch (Exception e8) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e8);
            }
        } catch (Exception e9) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e9);
        }
    }

    public void x0(int triggerId, boolean positive, float progress) {
        l lVar = this.F0;
        if (lVar != null) {
            lVar.d(this, triggerId, positive, progress);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3852c1;
        if (copyOnWriteArrayList != null) {
            Iterator<l> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().d(this, triggerId, positive, progress);
            }
        }
    }

    void y0(int mTouchAnchorId, float pos, float locationX, float locationY, float[] mAnchorDpDt) {
        String resourceName;
        HashMap<View, o> map = this.S;
        View viewT = t(mTouchAnchorId);
        o oVar = map.get(viewT);
        if (oVar != null) {
            oVar.p(pos, locationX, locationY, mAnchorDpDt);
            float y7 = viewT.getY();
            this.G0 = pos;
            this.H0 = y7;
            return;
        }
        if (viewT == null) {
            resourceName = "" + mTouchAnchorId;
        } else {
            resourceName = viewT.getContext().getResources().getResourceName(mTouchAnchorId);
        }
        Log.w(U1, "WARNING could not find view id " + resourceName);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void z(int id) {
        this.f4499k = null;
    }

    public androidx.constraintlayout.widget.d z0(int id) {
        s sVar = this.I;
        if (sVar == null) {
            return null;
        }
        return sVar.o(id);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int id, int screenWidth, int screenHeight) {
        setState(m.SETUP);
        this.N = id;
        this.M = -1;
        this.O = -1;
        androidx.constraintlayout.widget.b bVar = this.f4499k;
        if (bVar != null) {
            bVar.e(id, screenWidth, screenHeight);
            return;
        }
        s sVar = this.I;
        if (sVar != null) {
            sVar.o(id).r(this);
        }
    }

    public void setProgress(float pos) {
        if (pos < 0.0f || pos > 1.0f) {
            Log.w(U1, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f3869t1 == null) {
                this.f3869t1 = new k();
            }
            this.f3869t1.e(pos);
            return;
        }
        if (pos <= 0.0f) {
            if (this.W == 1.0f && this.N == this.O) {
                setState(m.MOVING);
            }
            this.N = this.M;
            if (this.W == 0.0f) {
                setState(m.FINISHED);
            }
        } else if (pos >= 1.0f) {
            if (this.W == 0.0f && this.N == this.M) {
                setState(m.MOVING);
            }
            this.N = this.O;
            if (this.W == 1.0f) {
                setState(m.FINISHED);
            }
        } else {
            this.N = -1;
            setState(m.MOVING);
        }
        if (this.I == null) {
            return;
        }
        this.C0 = true;
        this.B0 = pos;
        this.V = pos;
        this.A0 = -1L;
        this.T = -1L;
        this.f3849J = null;
        this.D0 = true;
        invalidate();
    }

    public void setTransition(int transitionId) {
        float f8;
        if (this.I != null) {
            s.b bVarD0 = D0(transitionId);
            this.M = bVarD0.I();
            this.O = bVarD0.B();
            if (!isAttachedToWindow()) {
                if (this.f3869t1 == null) {
                    this.f3869t1 = new k();
                }
                this.f3869t1.f(this.M);
                this.f3869t1.d(this.O);
                return;
            }
            int i7 = this.N;
            if (i7 == this.M) {
                f8 = 0.0f;
            } else {
                f8 = i7 == this.O ? 1.0f : Float.NaN;
            }
            this.I.o0(bVarD0);
            this.G1.h(this.f4491c, this.I.o(this.M), this.I.o(this.O));
            R0();
            if (this.W != f8) {
                if (f8 == 0.0f) {
                    r0(true);
                    this.I.o(this.M).r(this);
                } else if (f8 == 1.0f) {
                    r0(false);
                    this.I.o(this.O).r(this);
                }
            }
            this.W = Float.isNaN(f8) ? 0.0f : f8;
            if (Float.isNaN(f8)) {
                Log.v(U1, androidx.constraintlayout.motion.widget.c.g() + " transitionToStart ");
                b1();
                return;
            }
            setProgress(f8);
        }
    }

    protected void setTransition(s.b transition) {
        this.I.o0(transition);
        setState(m.SETUP);
        if (this.N == this.I.u()) {
            this.W = 1.0f;
            this.V = 1.0f;
            this.B0 = 1.0f;
        } else {
            this.W = 0.0f;
            this.V = 0.0f;
            this.B0 = 0.0f;
        }
        this.A0 = transition.L(1) ? -1L : getNanoTime();
        int iN = this.I.N();
        int iU = this.I.u();
        if (iN == this.M && iU == this.O) {
            return;
        }
        this.M = iN;
        this.O = iU;
        this.I.n0(iN, iU);
        this.G1.h(this.f4491c, this.I.o(this.M), this.I.o(this.O));
        this.G1.l(this.M, this.O);
        this.G1.k();
        R0();
    }

    public MotionLayout(@m0 Context context, @o0 AttributeSet attrs) {
        super(context, attrs);
        this.K = null;
        this.L = 0.0f;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.S = new HashMap<>();
        this.T = 0L;
        this.U = 1.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.B0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.I0 = 0;
        this.K0 = false;
        this.L0 = new androidx.constraintlayout.motion.utils.b();
        this.M0 = new f();
        this.O0 = true;
        this.T0 = false;
        this.Y0 = false;
        this.Z0 = null;
        this.f3850a1 = null;
        this.f3851b1 = null;
        this.f3852c1 = null;
        this.f3853d1 = 0;
        this.f3854e1 = -1L;
        this.f3855f1 = 0.0f;
        this.f3856g1 = 0;
        this.f3857h1 = 0.0f;
        this.f3858i1 = false;
        this.f3859j1 = false;
        this.f3867r1 = new androidx.constraintlayout.core.motion.utils.g();
        this.f3868s1 = false;
        this.f3870u1 = null;
        this.f3871v1 = null;
        this.f3872w1 = 0;
        this.f3873x1 = false;
        this.f3874y1 = 0;
        this.f3875z1 = new HashMap<>();
        this.D1 = new Rect();
        this.E1 = false;
        this.F1 = m.UNDEFINED;
        this.G1 = new h();
        this.H1 = false;
        this.I1 = new RectF();
        this.J1 = null;
        this.K1 = null;
        this.L1 = new ArrayList<>();
        G0(attrs);
    }

    public MotionLayout(@m0 Context context, @o0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.K = null;
        this.L = 0.0f;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.S = new HashMap<>();
        this.T = 0L;
        this.U = 1.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.B0 = 0.0f;
        this.D0 = false;
        this.E0 = false;
        this.I0 = 0;
        this.K0 = false;
        this.L0 = new androidx.constraintlayout.motion.utils.b();
        this.M0 = new f();
        this.O0 = true;
        this.T0 = false;
        this.Y0 = false;
        this.Z0 = null;
        this.f3850a1 = null;
        this.f3851b1 = null;
        this.f3852c1 = null;
        this.f3853d1 = 0;
        this.f3854e1 = -1L;
        this.f3855f1 = 0.0f;
        this.f3856g1 = 0;
        this.f3857h1 = 0.0f;
        this.f3858i1 = false;
        this.f3859j1 = false;
        this.f3867r1 = new androidx.constraintlayout.core.motion.utils.g();
        this.f3868s1 = false;
        this.f3870u1 = null;
        this.f3871v1 = null;
        this.f3872w1 = 0;
        this.f3873x1 = false;
        this.f3874y1 = 0;
        this.f3875z1 = new HashMap<>();
        this.D1 = new Rect();
        this.E1 = false;
        this.F1 = m.UNDEFINED;
        this.G1 = new h();
        this.H1 = false;
        this.I1 = new RectF();
        this.J1 = null;
        this.K1 = null;
        this.L1 = new ArrayList<>();
        G0(attrs);
    }
}
