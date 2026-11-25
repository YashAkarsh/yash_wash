package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class v {
    private static final String G = "TouchResponse";
    private static final boolean H = false;
    private static final int I = 1000;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final float f4295J = 1.0E-7f;
    private static final float[][] K = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] L = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int P = 3;
    private static final int Q = 4;
    private static final int R = 5;
    private static final int S = 0;
    private static final int T = 1;
    private static final int U = 2;
    private static final int V = 3;
    private static final int W = 4;
    private static final int X = 5;
    private static final int Y = 6;
    static final int Z = 1;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    static final int f4296a0 = 2;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    static final int f4297b0 = 4;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f4298c0 = 0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f4299d0 = 1;
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f4306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f4308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f4309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f4311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float[] f4315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f4316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f4317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f4318s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MotionLayout f4319t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f4320u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4321v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f4322w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4323x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4324y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f4325z;

    class a implements View.OnTouchListener {
        a(final v this$0) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class b implements NestedScrollView.c {
        b(final v this$0) {
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView v7, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        }
    }

    v(Context context, MotionLayout layout, XmlPullParser parser) {
        this.f4300a = 0;
        this.f4301b = 0;
        this.f4302c = 0;
        this.f4303d = -1;
        this.f4304e = -1;
        this.f4305f = -1;
        this.f4306g = 0.5f;
        this.f4307h = 0.5f;
        this.f4308i = 0.5f;
        this.f4309j = 0.5f;
        this.f4310k = -1;
        this.f4311l = false;
        this.f4312m = 0.0f;
        this.f4313n = 1.0f;
        this.f4314o = false;
        this.f4315p = new float[2];
        this.f4316q = new int[2];
        this.f4320u = 4.0f;
        this.f4321v = 1.2f;
        this.f4322w = true;
        this.f4323x = 1.0f;
        this.f4324y = 0;
        this.f4325z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.f4319t = layout;
        c(context, Xml.asAttributeSet(parser));
    }

    private void b(TypedArray a8) {
        int indexCount = a8.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = a8.getIndex(i7);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f4303d = a8.getResourceId(index, this.f4303d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i8 = a8.getInt(index, this.f4300a);
                this.f4300a = i8;
                float[] fArr = K[i8];
                this.f4307h = fArr[0];
                this.f4306g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i9 = a8.getInt(index, this.f4301b);
                this.f4301b = i9;
                float[][] fArr2 = L;
                if (i9 < fArr2.length) {
                    float[] fArr3 = fArr2[i9];
                    this.f4312m = fArr3[0];
                    this.f4313n = fArr3[1];
                } else {
                    this.f4313n = Float.NaN;
                    this.f4312m = Float.NaN;
                    this.f4311l = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f4320u = a8.getFloat(index, this.f4320u);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f4321v = a8.getFloat(index, this.f4321v);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f4322w = a8.getBoolean(index, this.f4322w);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f4323x = a8.getFloat(index, this.f4323x);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f4325z = a8.getFloat(index, this.f4325z);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f4304e = a8.getResourceId(index, this.f4304e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f4302c = a8.getInt(index, this.f4302c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f4324y = a8.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f4305f = a8.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.f4310k = a8.getResourceId(index, this.f4310k);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.A = a8.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.B = a8.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.C = a8.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.D = a8.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.E = a8.getInt(index, this.E);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.F = a8.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.OnSwipe);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    void A(float lastTouchX, float lastTouchY) {
        this.f4317r = lastTouchX;
        this.f4318s = lastTouchY;
    }

    public void B(float acceleration) {
        this.f4321v = acceleration;
    }

    public void C(float velocity) {
        this.f4320u = velocity;
    }

    public void D(boolean rtl) {
        if (rtl) {
            float[][] fArr = L;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = K;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = L;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = K;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = K[this.f4300a];
        this.f4307h = fArr5[0];
        this.f4306g = fArr5[1];
        int i7 = this.f4301b;
        float[][] fArr6 = L;
        if (i7 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i7];
        this.f4312m = fArr7[0];
        this.f4313n = fArr7[1];
    }

    public void E(float x7, float y7) {
        this.f4307h = x7;
        this.f4306g = y7;
    }

    public void F(int touchUpMode) {
        this.f4302c = touchUpMode;
    }

    void G(float lastTouchX, float lastTouchY) {
        this.f4317r = lastTouchX;
        this.f4318s = lastTouchY;
        this.f4314o = false;
    }

    void H() {
        View viewFindViewById;
        int i7 = this.f4303d;
        if (i7 != -1) {
            viewFindViewById = this.f4319t.findViewById(i7);
            if (viewFindViewById == null) {
                Log.e(G, "cannot find TouchAnchorId @id/" + c.i(this.f4319t.getContext(), this.f4303d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    float a(float dx, float dy) {
        return (dx * this.f4312m) + (dy * this.f4313n);
    }

    public int d() {
        return this.f4303d;
    }

    public int e() {
        return this.F;
    }

    public int f() {
        return this.f4324y;
    }

    RectF g(ViewGroup layout, RectF rect) {
        View viewFindViewById;
        int i7 = this.f4305f;
        if (i7 == -1 || (viewFindViewById = layout.findViewById(i7)) == null) {
            return null;
        }
        rect.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rect;
    }

    int h() {
        return this.f4305f;
    }

    float i() {
        return this.f4321v;
    }

    public float j() {
        return this.f4320u;
    }

    boolean k() {
        return this.f4322w;
    }

    float l(float dx, float dy) {
        this.f4319t.y0(this.f4303d, this.f4319t.getProgress(), this.f4307h, this.f4306g, this.f4315p);
        float f8 = this.f4312m;
        if (f8 != 0.0f) {
            float[] fArr = this.f4315p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (dx * f8) / fArr[0];
        }
        float[] fArr2 = this.f4315p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (dy * this.f4313n) / fArr2[1];
    }

    public int m() {
        return this.E;
    }

    public float n() {
        return this.A;
    }

    public float o() {
        return this.B;
    }

    public float p() {
        return this.C;
    }

    public float q() {
        return this.D;
    }

    RectF r(ViewGroup layout, RectF rect) {
        View viewFindViewById;
        int i7 = this.f4304e;
        if (i7 == -1 || (viewFindViewById = layout.findViewById(i7)) == null) {
            return null;
        }
        rect.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rect;
    }

    int s() {
        return this.f4304e;
    }

    boolean t() {
        return this.f4314o;
    }

    public String toString() {
        if (Float.isNaN(this.f4312m)) {
            return f.f3954i;
        }
        return this.f4312m + " , " + this.f4313n;
    }

    void u(MotionEvent event, MotionLayout.i velocityTracker, int currentState, s motionScene) {
        int i7;
        if (this.f4311l) {
            v(event, velocityTracker, currentState, motionScene);
            return;
        }
        velocityTracker.e(event);
        int action = event.getAction();
        if (action == 0) {
            this.f4317r = event.getRawX();
            this.f4318s = event.getRawY();
            this.f4314o = false;
            return;
        }
        if (action == 1) {
            this.f4314o = false;
            velocityTracker.h(1000);
            float fG = velocityTracker.g();
            float f8 = velocityTracker.f();
            float progress = this.f4319t.getProgress();
            int i8 = this.f4303d;
            if (i8 != -1) {
                this.f4319t.y0(i8, progress, this.f4307h, this.f4306g, this.f4315p);
            } else {
                float fMin = Math.min(this.f4319t.getWidth(), this.f4319t.getHeight());
                float[] fArr = this.f4315p;
                fArr[1] = this.f4313n * fMin;
                fArr[0] = fMin * this.f4312m;
            }
            float f9 = this.f4312m;
            float[] fArr2 = this.f4315p;
            float fAbs = f9 != 0.0f ? fG / fArr2[0] : f8 / fArr2[1];
            float f10 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f10 == 0.0f || f10 == 1.0f || (i7 = this.f4302c) == 3) {
                if (0.0f >= f10 || 1.0f <= f10) {
                    this.f4319t.setState(MotionLayout.m.FINISHED);
                    return;
                }
                return;
            }
            float f11 = ((double) f10) < 0.5d ? 0.0f : 1.0f;
            if (i7 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f11 = 1.0f;
            }
            if (this.f4302c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f11 = 0.0f;
            }
            this.f4319t.X0(this.f4302c, f11, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f4319t.setState(MotionLayout.m.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = event.getRawY() - this.f4318s;
        float rawX = event.getRawX() - this.f4317r;
        if (Math.abs((this.f4312m * rawX) + (this.f4313n * rawY)) > this.f4325z || this.f4314o) {
            float progress2 = this.f4319t.getProgress();
            if (!this.f4314o) {
                this.f4314o = true;
                this.f4319t.setProgress(progress2);
            }
            int i9 = this.f4303d;
            if (i9 != -1) {
                this.f4319t.y0(i9, progress2, this.f4307h, this.f4306g, this.f4315p);
            } else {
                float fMin2 = Math.min(this.f4319t.getWidth(), this.f4319t.getHeight());
                float[] fArr3 = this.f4315p;
                fArr3[1] = this.f4313n * fMin2;
                fArr3[0] = fMin2 * this.f4312m;
            }
            float f12 = this.f4312m;
            float[] fArr4 = this.f4315p;
            if (Math.abs(((f12 * fArr4[0]) + (this.f4313n * fArr4[1])) * this.f4323x) < 0.01d) {
                float[] fArr5 = this.f4315p;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float fMax = Math.max(Math.min(progress2 + (this.f4312m != 0.0f ? rawX / this.f4315p[0] : rawY / this.f4315p[1]), 1.0f), 0.0f);
            if (this.f4302c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.f4302c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.f4319t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f4319t.r0(progress3 == 0.0f);
                }
                this.f4319t.setProgress(fMax);
                velocityTracker.h(1000);
                this.f4319t.L = this.f4312m != 0.0f ? velocityTracker.g() / this.f4315p[0] : velocityTracker.f() / this.f4315p[1];
            } else {
                this.f4319t.L = 0.0f;
            }
            this.f4317r = event.getRawX();
            this.f4318s = event.getRawY();
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0270  */
    /* JADX WARN: Code duplicated, block: B:58:0x0294  */
    /* JADX WARN: Code duplicated, block: B:61:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x02bd  */
    void v(MotionEvent event, MotionLayout.i velocityTracker, int currentState, s motionScene) {
        float left;
        float f8;
        int top;
        int bottom;
        int i7;
        float degrees;
        float f9;
        int i8;
        velocityTracker.e(event);
        int action = event.getAction();
        if (action == 0) {
            this.f4317r = event.getRawX();
            this.f4318s = event.getRawY();
            this.f4314o = false;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            event.getRawY();
            event.getRawX();
            float width = this.f4319t.getWidth() / 2.0f;
            float height = this.f4319t.getHeight() / 2.0f;
            int i9 = this.f4310k;
            if (i9 != -1) {
                View viewFindViewById = this.f4319t.findViewById(i9);
                this.f4319t.getLocationOnScreen(this.f4316q);
                float left2 = this.f4316q[0] + ((viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f);
                height = ((viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f) + this.f4316q[1];
                width = left2;
            } else {
                int i10 = this.f4303d;
                if (i10 != -1) {
                    View viewFindViewById2 = this.f4319t.findViewById(this.f4319t.C0(i10).k());
                    if (viewFindViewById2 == null) {
                        Log.e(G, "could not find view to animate to");
                    } else {
                        this.f4319t.getLocationOnScreen(this.f4316q);
                        width = this.f4316q[0] + ((viewFindViewById2.getLeft() + viewFindViewById2.getRight()) / 2.0f);
                        height = this.f4316q[1] + ((viewFindViewById2.getTop() + viewFindViewById2.getBottom()) / 2.0f);
                    }
                }
            }
            float rawX = event.getRawX() - width;
            float rawY = event.getRawY() - height;
            double dAtan2 = Math.atan2(event.getRawY() - height, event.getRawX() - width);
            float fAtan2 = (float) (((dAtan2 - Math.atan2(this.f4318s - height, this.f4317r - width)) * 180.0d) / 3.141592653589793d);
            if (fAtan2 > 330.0f) {
                fAtan2 -= 360.0f;
            } else if (fAtan2 < -330.0f) {
                fAtan2 += 360.0f;
            }
            if (Math.abs(fAtan2) > 0.01d || this.f4314o) {
                float progress = this.f4319t.getProgress();
                if (!this.f4314o) {
                    this.f4314o = true;
                    this.f4319t.setProgress(progress);
                }
                int i11 = this.f4303d;
                if (i11 != -1) {
                    this.f4319t.y0(i11, progress, this.f4307h, this.f4306g, this.f4315p);
                    float[] fArr = this.f4315p;
                    fArr[1] = (float) Math.toDegrees(fArr[1]);
                } else {
                    this.f4315p[1] = 360.0f;
                }
                float fMax = Math.max(Math.min(progress + ((fAtan2 * this.f4323x) / this.f4315p[1]), 1.0f), 0.0f);
                float progress2 = this.f4319t.getProgress();
                if (fMax != progress2) {
                    if (progress2 == 0.0f || progress2 == 1.0f) {
                        this.f4319t.r0(progress2 == 0.0f);
                    }
                    this.f4319t.setProgress(fMax);
                    velocityTracker.h(1000);
                    float fG = velocityTracker.g();
                    double dF = velocityTracker.f();
                    double d8 = fG;
                    this.f4319t.L = (float) Math.toDegrees((float) ((Math.hypot(dF, d8) * Math.sin(Math.atan2(dF, d8) - dAtan2)) / Math.hypot(rawX, rawY)));
                } else {
                    this.f4319t.L = 0.0f;
                }
                this.f4317r = event.getRawX();
                this.f4318s = event.getRawY();
                return;
            }
            return;
        }
        this.f4314o = false;
        velocityTracker.h(16);
        float fG2 = velocityTracker.g();
        float f10 = velocityTracker.f();
        float progress3 = this.f4319t.getProgress();
        float width2 = this.f4319t.getWidth() / 2.0f;
        float height2 = this.f4319t.getHeight() / 2.0f;
        int i12 = this.f4310k;
        if (i12 == -1) {
            int i13 = this.f4303d;
            if (i13 != -1) {
                View viewFindViewById3 = this.f4319t.findViewById(this.f4319t.C0(i13).k());
                this.f4319t.getLocationOnScreen(this.f4316q);
                left = this.f4316q[0] + ((viewFindViewById3.getLeft() + viewFindViewById3.getRight()) / 2.0f);
                f8 = this.f4316q[1];
                top = viewFindViewById3.getTop();
                bottom = viewFindViewById3.getBottom();
            }
            float rawX2 = event.getRawX() - width2;
            float rawY2 = event.getRawY() - height2;
            double degrees2 = Math.toDegrees(Math.atan2(rawY2, rawX2));
            i7 = this.f4303d;
            if (i7 != -1) {
                this.f4319t.y0(i7, progress3, this.f4307h, this.f4306g, this.f4315p);
                float[] fArr2 = this.f4315p;
                fArr2[1] = (float) Math.toDegrees(fArr2[1]);
            } else {
                this.f4315p[1] = 360.0f;
            }
            degrees = ((float) (Math.toDegrees(Math.atan2(f10 + rawY2, fG2 + rawX2)) - degrees2)) * 62.5f;
            if (Float.isNaN(degrees)) {
                f9 = progress3;
            } else {
                f9 = (((degrees * 3.0f) * this.f4323x) / this.f4315p[1]) + progress3;
            }
            if (f9 != 0.0f || f9 == 1.0f || (i8 = this.f4302c) == 3) {
                if (0.0f < f9 || 1.0f <= f9) {
                    this.f4319t.setState(MotionLayout.m.FINISHED);
                }
                return;
            }
            float fAbs = (degrees * this.f4323x) / this.f4315p[1];
            float f11 = ((double) f9) < 0.5d ? 0.0f : 1.0f;
            if (i8 == 6) {
                if (progress3 + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f11 = 1.0f;
            }
            if (this.f4302c == 7) {
                if (progress3 + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f11 = 0.0f;
            }
            this.f4319t.X0(this.f4302c, f11, fAbs * 3.0f);
            if (0.0f >= progress3 || 1.0f <= progress3) {
                this.f4319t.setState(MotionLayout.m.FINISHED);
                return;
            }
            return;
        }
        View viewFindViewById4 = this.f4319t.findViewById(i12);
        this.f4319t.getLocationOnScreen(this.f4316q);
        left = this.f4316q[0] + ((viewFindViewById4.getLeft() + viewFindViewById4.getRight()) / 2.0f);
        f8 = this.f4316q[1];
        top = viewFindViewById4.getTop();
        bottom = viewFindViewById4.getBottom();
        height2 = f8 + ((top + bottom) / 2.0f);
        width2 = left;
        float rawX3 = event.getRawX() - width2;
        float rawY3 = event.getRawY() - height2;
        double degrees3 = Math.toDegrees(Math.atan2(rawY3, rawX3));
        i7 = this.f4303d;
        if (i7 != -1) {
            this.f4319t.y0(i7, progress3, this.f4307h, this.f4306g, this.f4315p);
            float[] fArr3 = this.f4315p;
            fArr3[1] = (float) Math.toDegrees(fArr3[1]);
        } else {
            this.f4315p[1] = 360.0f;
        }
        degrees = ((float) (Math.toDegrees(Math.atan2(f10 + rawY3, fG2 + rawX3)) - degrees3)) * 62.5f;
        if (Float.isNaN(degrees)) {
            f9 = (((degrees * 3.0f) * this.f4323x) / this.f4315p[1]) + progress3;
        } else {
            f9 = progress3;
        }
        if (f9 != 0.0f) {
        }
        if (0.0f < f9) {
        }
        this.f4319t.setState(MotionLayout.m.FINISHED);
    }

    void w(float dx, float dy) {
        float progress = this.f4319t.getProgress();
        if (!this.f4314o) {
            this.f4314o = true;
            this.f4319t.setProgress(progress);
        }
        this.f4319t.y0(this.f4303d, progress, this.f4307h, this.f4306g, this.f4315p);
        float f8 = this.f4312m;
        float[] fArr = this.f4315p;
        if (Math.abs((f8 * fArr[0]) + (this.f4313n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f4315p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f9 = this.f4312m;
        float fMax = Math.max(Math.min(progress + (f9 != 0.0f ? (dx * f9) / this.f4315p[0] : (dy * this.f4313n) / this.f4315p[1]), 1.0f), 0.0f);
        if (fMax != this.f4319t.getProgress()) {
            this.f4319t.setProgress(fMax);
        }
    }

    void x(float dx, float dy) {
        this.f4314o = false;
        float progress = this.f4319t.getProgress();
        this.f4319t.y0(this.f4303d, progress, this.f4307h, this.f4306g, this.f4315p);
        float f8 = this.f4312m;
        float[] fArr = this.f4315p;
        float f9 = f8 != 0.0f ? (dx * f8) / fArr[0] : (dy * this.f4313n) / fArr[1];
        if (!Float.isNaN(f9)) {
            progress += f9 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z7 = progress != 1.0f;
            int i7 = this.f4302c;
            if ((i7 != 3) && z7) {
                this.f4319t.X0(i7, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f9);
            }
        }
    }

    public void y(int id) {
        this.f4303d = id;
    }

    void z(int autoCompleteMode) {
        this.F = autoCompleteMode;
    }

    public v(MotionLayout layout, t onSwipe) {
        this.f4300a = 0;
        this.f4301b = 0;
        this.f4302c = 0;
        this.f4303d = -1;
        this.f4304e = -1;
        this.f4305f = -1;
        this.f4306g = 0.5f;
        this.f4307h = 0.5f;
        this.f4308i = 0.5f;
        this.f4309j = 0.5f;
        this.f4310k = -1;
        this.f4311l = false;
        this.f4312m = 0.0f;
        this.f4313n = 1.0f;
        this.f4314o = false;
        this.f4315p = new float[2];
        this.f4316q = new int[2];
        this.f4320u = 4.0f;
        this.f4321v = 1.2f;
        this.f4322w = true;
        this.f4323x = 1.0f;
        this.f4324y = 0;
        this.f4325z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.f4319t = layout;
        this.f4303d = onSwipe.q();
        int iR = onSwipe.r();
        this.f4300a = iR;
        if (iR != -1) {
            float[] fArr = K[iR];
            this.f4307h = fArr[0];
            this.f4306g = fArr[1];
        }
        int iB = onSwipe.b();
        this.f4301b = iB;
        float[][] fArr2 = L;
        if (iB < fArr2.length) {
            float[] fArr3 = fArr2[iB];
            this.f4312m = fArr3[0];
            this.f4313n = fArr3[1];
        } else {
            this.f4313n = Float.NaN;
            this.f4312m = Float.NaN;
            this.f4311l = true;
        }
        this.f4320u = onSwipe.g();
        this.f4321v = onSwipe.f();
        this.f4322w = onSwipe.h();
        this.f4323x = onSwipe.c();
        this.f4325z = onSwipe.d();
        this.f4304e = onSwipe.s();
        this.f4302c = onSwipe.j();
        this.f4324y = onSwipe.i();
        this.f4305f = onSwipe.e();
        this.f4310k = onSwipe.k();
        this.E = onSwipe.l();
        this.A = onSwipe.m();
        this.B = onSwipe.n();
        this.C = onSwipe.o();
        this.D = onSwipe.p();
        this.F = onSwipe.a();
    }
}
