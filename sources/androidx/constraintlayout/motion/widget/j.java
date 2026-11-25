package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class j extends k {
    private static final String R = "KeyPosition";
    static final String S = "KeyPosition";
    public static final int T = 2;
    public static final int U = 1;
    public static final int V = 0;
    public static final String W = "transitionEasing";
    public static final String X = "drawPath";
    public static final String Y = "percentWidth";
    public static final String Z = "percentHeight";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f4037a0 = "sizePercent";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f4038b0 = "percentX";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f4039c0 = "percentY";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    static final int f4040d0 = 2;
    String F = null;
    int G = f.f3951f;
    int H = 0;
    float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    float f4041J = Float.NaN;
    float K = Float.NaN;
    float L = Float.NaN;
    float M = Float.NaN;
    float N = Float.NaN;
    int O = 0;
    private float P = Float.NaN;
    private float Q = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f4042a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f4043b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f4044c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f4045d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f4046e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f4047f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f4048g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f4049h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f4050i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f4051j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f4052k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f4053l = 12;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static SparseIntArray f4054m;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4054m = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f4054m.append(R.styleable.KeyPosition_framePosition, 2);
            f4054m.append(R.styleable.KeyPosition_transitionEasing, 3);
            f4054m.append(R.styleable.KeyPosition_curveFit, 4);
            f4054m.append(R.styleable.KeyPosition_drawPath, 5);
            f4054m.append(R.styleable.KeyPosition_percentX, 6);
            f4054m.append(R.styleable.KeyPosition_percentY, 7);
            f4054m.append(R.styleable.KeyPosition_keyPositionType, 9);
            f4054m.append(R.styleable.KeyPosition_sizePercent, 8);
            f4054m.append(R.styleable.KeyPosition_percentWidth, 11);
            f4054m.append(R.styleable.KeyPosition_percentHeight, 12);
            f4054m.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(j c8, TypedArray a8) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                switch (f4054m.get(index)) {
                    case 1:
                        if (MotionLayout.W1) {
                            int resourceId = a8.getResourceId(index, c8.f3973b);
                            c8.f3973b = resourceId;
                            if (resourceId == -1) {
                                c8.f3974c = a8.getString(index);
                            }
                        } else if (a8.peekValue(index).type == 3) {
                            c8.f3974c = a8.getString(index);
                        } else {
                            c8.f3973b = a8.getResourceId(index, c8.f3973b);
                        }
                        break;
                    case 2:
                        c8.f3972a = a8.getInt(index, c8.f3972a);
                        break;
                    case 3:
                        if (a8.peekValue(index).type == 3) {
                            c8.F = a8.getString(index);
                        } else {
                            c8.F = androidx.constraintlayout.core.motion.utils.d.f2786o[a8.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        c8.D = a8.getInteger(index, c8.D);
                        break;
                    case 5:
                        c8.H = a8.getInt(index, c8.H);
                        break;
                    case 6:
                        c8.K = a8.getFloat(index, c8.K);
                        break;
                    case 7:
                        c8.L = a8.getFloat(index, c8.L);
                        break;
                    case 8:
                        float f8 = a8.getFloat(index, c8.f4041J);
                        c8.I = f8;
                        c8.f4041J = f8;
                        break;
                    case 9:
                        c8.O = a8.getInt(index, c8.O);
                        break;
                    case 10:
                        c8.G = a8.getInt(index, c8.G);
                        break;
                    case 11:
                        c8.I = a8.getFloat(index, c8.I);
                        break;
                    case 12:
                        c8.f4041J = a8.getFloat(index, c8.f4041J);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4054m.get(index));
                        break;
                }
            }
            if (c8.f3972a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public j() {
        this.f3975d = 2;
    }

    private void t(float start_x, float start_y, float end_x, float end_y) {
        float f8 = end_x - start_x;
        float f9 = end_y - start_y;
        float f10 = Float.isNaN(this.K) ? 0.0f : this.K;
        float f11 = Float.isNaN(this.N) ? 0.0f : this.N;
        float f12 = Float.isNaN(this.L) ? 0.0f : this.L;
        this.P = (int) (start_x + (f10 * f8) + ((Float.isNaN(this.M) ? 0.0f : this.M) * f9));
        this.Q = (int) (start_y + (f8 * f11) + (f9 * f12));
    }

    private void u(float start_x, float start_y, float end_x, float end_y) {
        float f8 = end_x - start_x;
        float f9 = end_y - start_y;
        float f10 = this.K;
        float f11 = this.L;
        this.P = start_x + (f8 * f10) + ((-f9) * f11);
        this.Q = start_y + (f9 * f10) + (f8 * f11);
    }

    private void v(int layoutWidth, int layoutHeight) {
        float f8 = this.K;
        float f9 = 0;
        this.P = ((layoutWidth - 0) * f8) + f9;
        this.Q = ((layoutHeight - 0) * f8) + f9;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new j().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        j jVar = (j) src;
        this.F = jVar.F;
        this.G = jVar.G;
        this.H = jVar.H;
        this.I = jVar.I;
        this.f4041J = Float.NaN;
        this.K = jVar.K;
        this.L = jVar.L;
        this.M = jVar.M;
        this.N = jVar.N;
        this.P = jVar.P;
        this.Q = jVar.Q;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.b(this, context.obtainStyledAttributes(attrs, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        switch (tag) {
            case "transitionEasing":
                this.F = value.toString();
                break;
            case "percentWidth":
                this.I = m(value);
                break;
            case "percentHeight":
                this.f4041J = m(value);
                break;
            case "drawPath":
                this.H = n(value);
                break;
            case "sizePercent":
                float fM = m(value);
                this.I = fM;
                this.f4041J = fM;
                break;
            case "percentX":
                this.K = m(value);
                break;
            case "percentY":
                this.L = m(value);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.k
    void o(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y) {
        int i7 = this.O;
        if (i7 == 1) {
            u(start_x, start_y, end_x, end_y);
        } else if (i7 != 2) {
            t(start_x, start_y, end_x, end_y);
        } else {
            v(layoutWidth, layoutHeight);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.k
    float p() {
        return this.P;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    float q() {
        return this.Q;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public boolean r(int layoutWidth, int layoutHeight, RectF start, RectF end, float x7, float y7) {
        o(layoutWidth, layoutHeight, start.centerX(), start.centerY(), end.centerX(), end.centerY());
        return Math.abs(x7 - this.P) < 20.0f && Math.abs(y7 - this.Q) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public void s(View view, RectF start, RectF end, float x7, float y7, String[] attribute, float[] value) {
        int i7 = this.O;
        if (i7 == 1) {
            x(start, end, x7, y7, attribute, value);
        } else if (i7 != 2) {
            w(start, end, x7, y7, attribute, value);
        } else {
            y(view, start, end, x7, y7, attribute, value);
        }
    }

    void w(RectF start, RectF end, float x7, float y7, String[] attribute, float[] value) {
        float fCenterX = start.centerX();
        float fCenterY = start.centerY();
        float fCenterX2 = end.centerX() - fCenterX;
        float fCenterY2 = end.centerY() - fCenterY;
        String str = attribute[0];
        if (str == null) {
            attribute[0] = "percentX";
            value[0] = (x7 - fCenterX) / fCenterX2;
            attribute[1] = "percentY";
            value[1] = (y7 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(str)) {
            value[0] = (x7 - fCenterX) / fCenterX2;
            value[1] = (y7 - fCenterY) / fCenterY2;
        } else {
            value[1] = (x7 - fCenterX) / fCenterX2;
            value[0] = (y7 - fCenterY) / fCenterY2;
        }
    }

    void x(RectF start, RectF end, float x7, float y7, String[] attribute, float[] value) {
        float fCenterX = start.centerX();
        float fCenterY = start.centerY();
        float fCenterX2 = end.centerX() - fCenterX;
        float fCenterY2 = end.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            value[0] = 0.0f;
            value[1] = 0.0f;
            return;
        }
        float f8 = fCenterX2 / fHypot;
        float f9 = fCenterY2 / fHypot;
        float f10 = y7 - fCenterY;
        float f11 = x7 - fCenterX;
        float f12 = ((f8 * f10) - (f11 * f9)) / fHypot;
        float f13 = ((f8 * f11) + (f9 * f10)) / fHypot;
        String str = attribute[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                value[0] = f13;
                value[1] = f12;
                return;
            }
            return;
        }
        attribute[0] = "percentX";
        attribute[1] = "percentY";
        value[0] = f13;
        value[1] = f12;
    }

    void y(View view, RectF start, RectF end, float x7, float y7, String[] attribute, float[] value) {
        start.centerX();
        start.centerY();
        end.centerX();
        end.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = attribute[0];
        if (str == null) {
            attribute[0] = "percentX";
            value[0] = x7 / width;
            attribute[1] = "percentY";
            value[1] = y7 / height;
            return;
        }
        if ("percentX".equals(str)) {
            value[0] = x7 / width;
            value[1] = y7 / height;
        } else {
            value[1] = x7 / width;
            value[0] = y7 / height;
        }
    }

    public void z(int type) {
        this.O = type;
    }
}
