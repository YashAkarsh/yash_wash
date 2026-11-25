package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.f0;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 6;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f4138a0 = 1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f4139b0 = 2;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final String f4140c0 = "MotionController";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final boolean f4141d0 = false;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final boolean f4142e0 = false;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    static final int f4143f0 = 0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    static final int f4144g0 = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    static final int f4145h0 = 2;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    static final int f4146i0 = 3;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    static final int f4147j0 = 4;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    static final int f4148k0 = 5;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final int f4149l0 = -1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final int f4150m0 = -2;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final int f4151n0 = -3;
    private HashMap<String, androidx.constraintlayout.motion.utils.f> B;
    private HashMap<String, androidx.constraintlayout.motion.utils.d> C;
    private HashMap<String, androidx.constraintlayout.motion.utils.c> D;
    private m[] E;
    private int F;
    private int G;
    private View H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f4152J;
    private Interpolator K;
    private boolean L;
    String[] M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f4154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4155c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f4157e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b[] f4163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f4164l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f4168p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f4169q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int[] f4170r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double[] f4171s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private double[] f4172t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String[] f4173u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int[] f4174v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Rect f4153a = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f4156d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4158f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r f4159g = new r();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private r f4160h = new r();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n f4161i = new n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private n f4162j = new n();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f4165m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f4166n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f4167o = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4175w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float[] f4176x = new float[4];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ArrayList<r> f4177y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float[] f4178z = new float[1];
    private ArrayList<f> A = new ArrayList<>();

    class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.d f4179a;

        a(final androidx.constraintlayout.core.motion.utils.d val$easing) {
            this.f4179a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v7) {
            return (float) this.f4179a.a(v7);
        }
    }

    o(View view) {
        int i7 = f.f3951f;
        this.F = i7;
        this.G = i7;
        this.H = null;
        this.I = i7;
        this.f4152J = Float.NaN;
        this.K = null;
        this.L = false;
        Z(view);
    }

    private float D() {
        char c8;
        float fHypot;
        float[] fArr = new float[2];
        float f8 = 1.0f / 99;
        double d8 = 0.0d;
        double d9 = 0.0d;
        float f9 = 0.0f;
        int i7 = 0;
        while (i7 < 100) {
            float f10 = i7 * f8;
            double dA = f10;
            androidx.constraintlayout.core.motion.utils.d dVar = this.f4159g.f4187a;
            float f11 = Float.NaN;
            float f12 = 0.0f;
            for (r rVar : this.f4177y) {
                androidx.constraintlayout.core.motion.utils.d dVar2 = rVar.f4187a;
                if (dVar2 != null) {
                    float f13 = rVar.f4189c;
                    if (f13 < f10) {
                        dVar = dVar2;
                        f12 = f13;
                    } else if (Float.isNaN(f11)) {
                        f11 = rVar.f4189c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                float f14 = f11 - f12;
                dA = (((float) dVar.a((f10 - f12) / f14)) * f14) + f12;
            }
            this.f4163k[0].d(dA, this.f4171s);
            float f15 = f9;
            int i8 = i7;
            this.f4159g.h(dA, this.f4170r, this.f4171s, fArr, 0);
            if (i8 > 0) {
                c8 = 0;
                fHypot = (float) (((double) f15) + Math.hypot(d9 - ((double) fArr[1]), d8 - ((double) fArr[0])));
            } else {
                c8 = 0;
                fHypot = f15;
            }
            d8 = fArr[c8];
            i7 = i8 + 1;
            f9 = fHypot;
            d9 = fArr[1];
        }
        return f9;
    }

    private void K(r point) {
        int iBinarySearch = Collections.binarySearch(this.f4177y, point);
        if (iBinarySearch == 0) {
            Log.e(f4140c0, " KeyPath position \"" + point.f4190d + "\" outside of range");
        }
        this.f4177y.add((-iBinarySearch) - 1, point);
    }

    private void O(r motionPaths) {
        motionPaths.s((int) this.f4154b.getX(), (int) this.f4154b.getY(), this.f4154b.getWidth(), this.f4154b.getHeight());
    }

    private float j(float position, float[] velocity) {
        float f8 = 0.0f;
        if (velocity != null) {
            velocity[0] = 1.0f;
        } else {
            float f9 = this.f4167o;
            if (f9 != 1.0d) {
                float f10 = this.f4166n;
                if (position < f10) {
                    position = 0.0f;
                }
                if (position > f10 && position < 1.0d) {
                    position = Math.min((position - f10) * f9, 1.0f);
                }
            }
        }
        androidx.constraintlayout.core.motion.utils.d dVar = this.f4159g.f4187a;
        float f11 = Float.NaN;
        for (r rVar : this.f4177y) {
            androidx.constraintlayout.core.motion.utils.d dVar2 = rVar.f4187a;
            if (dVar2 != null) {
                float f12 = rVar.f4189c;
                if (f12 < position) {
                    dVar = dVar2;
                    f8 = f12;
                } else if (Float.isNaN(f11)) {
                    f11 = rVar.f4189c;
                }
            }
        }
        if (dVar != null) {
            float f13 = (Float.isNaN(f11) ? 1.0f : f11) - f8;
            double d8 = (position - f8) / f13;
            position = (((float) dVar.a(d8)) * f13) + f8;
            if (velocity != null) {
                velocity[0] = (float) dVar.b(d8);
            }
        }
        return position;
    }

    private static Interpolator v(Context context, int type, String interpolatorString, int id) {
        if (type == -2) {
            return AnimationUtils.loadInterpolator(context, id);
        }
        if (type == -1) {
            return new a(androidx.constraintlayout.core.motion.utils.d.c(interpolatorString));
        }
        if (type == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (type == 1) {
            return new AccelerateInterpolator();
        }
        if (type == 2) {
            return new DecelerateInterpolator();
        }
        if (type == 4) {
            return new BounceInterpolator();
        }
        if (type != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    double[] A(double position) {
        this.f4163k[0].d(position, this.f4171s);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
        if (bVar != null) {
            double[] dArr = this.f4171s;
            if (dArr.length > 0) {
                bVar.d(position, dArr);
            }
        }
        return this.f4171s;
    }

    k B(int layoutWidth, int layoutHeight, float x7, float y7) {
        RectF rectF = new RectF();
        r rVar = this.f4159g;
        float f8 = rVar.f4191e;
        rectF.left = f8;
        float f9 = rVar.f4192f;
        rectF.top = f9;
        rectF.right = f8 + rVar.f4193g;
        rectF.bottom = f9 + rVar.f4194h;
        RectF rectF2 = new RectF();
        r rVar2 = this.f4160h;
        float f10 = rVar2.f4191e;
        rectF2.left = f10;
        float f11 = rVar2.f4192f;
        rectF2.top = f11;
        rectF2.right = f10 + rVar2.f4193g;
        rectF2.bottom = f11 + rVar2.f4194h;
        for (f fVar : this.A) {
            if (fVar instanceof k) {
                k kVar = (k) fVar;
                if (kVar.r(layoutWidth, layoutHeight, rectF, rectF2, x7, y7)) {
                    return kVar;
                }
            }
        }
        return null;
    }

    void C(float position, int width, int height, float locationX, float locationY, float[] mAnchorDpDt) {
        float fJ = j(position, this.f4178z);
        HashMap<String, androidx.constraintlayout.motion.utils.d> map = this.C;
        androidx.constraintlayout.motion.utils.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, androidx.constraintlayout.motion.utils.d> map2 = this.C;
        androidx.constraintlayout.motion.utils.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, androidx.constraintlayout.motion.utils.d> map3 = this.C;
        androidx.constraintlayout.motion.utils.d dVar3 = map3 == null ? null : map3.get(f.f3954i);
        HashMap<String, androidx.constraintlayout.motion.utils.d> map4 = this.C;
        androidx.constraintlayout.motion.utils.d dVar4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, androidx.constraintlayout.motion.utils.d> map5 = this.C;
        androidx.constraintlayout.motion.utils.d dVar5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map6 = this.D;
        androidx.constraintlayout.motion.utils.c cVar = map6 == null ? null : map6.get("translationX");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map7 = this.D;
        androidx.constraintlayout.motion.utils.c cVar2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map8 = this.D;
        androidx.constraintlayout.motion.utils.c cVar3 = map8 == null ? null : map8.get(f.f3954i);
        HashMap<String, androidx.constraintlayout.motion.utils.c> map9 = this.D;
        androidx.constraintlayout.motion.utils.c cVar4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map10 = this.D;
        androidx.constraintlayout.motion.utils.c cVar5 = map10 != null ? map10.get("scaleY") : null;
        f0 f0Var = new f0();
        f0Var.b();
        f0Var.d(dVar3, fJ);
        f0Var.h(dVar, dVar2, fJ);
        f0Var.f(dVar4, dVar5, fJ);
        f0Var.c(cVar3, fJ);
        f0Var.g(cVar, cVar2, fJ);
        f0Var.e(cVar4, cVar5, fJ);
        androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
        if (bVar != null) {
            double[] dArr = this.f4171s;
            if (dArr.length > 0) {
                double d8 = fJ;
                bVar.d(d8, dArr);
                this.f4164l.g(d8, this.f4172t);
                this.f4159g.t(locationX, locationY, mAnchorDpDt, this.f4170r, this.f4172t, this.f4171s);
            }
            f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
            return;
        }
        int i7 = 0;
        if (this.f4163k == null) {
            r rVar = this.f4160h;
            float f8 = rVar.f4191e;
            r rVar2 = this.f4159g;
            float f9 = f8 - rVar2.f4191e;
            androidx.constraintlayout.motion.utils.c cVar6 = cVar5;
            float f10 = rVar.f4192f - rVar2.f4192f;
            androidx.constraintlayout.motion.utils.c cVar7 = cVar4;
            float f11 = (rVar.f4193g - rVar2.f4193g) + f9;
            float f12 = (rVar.f4194h - rVar2.f4194h) + f10;
            mAnchorDpDt[0] = (f9 * (1.0f - locationX)) + (f11 * locationX);
            mAnchorDpDt[1] = (f10 * (1.0f - locationY)) + (f12 * locationY);
            f0Var.b();
            f0Var.d(dVar3, fJ);
            f0Var.h(dVar, dVar2, fJ);
            f0Var.f(dVar4, dVar5, fJ);
            f0Var.c(cVar3, fJ);
            f0Var.g(cVar, cVar2, fJ);
            f0Var.e(cVar7, cVar6, fJ);
            f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
            return;
        }
        double dJ = j(fJ, this.f4178z);
        this.f4163k[0].g(dJ, this.f4172t);
        this.f4163k[0].d(dJ, this.f4171s);
        float f13 = this.f4178z[0];
        while (true) {
            double[] dArr2 = this.f4172t;
            if (i7 >= dArr2.length) {
                this.f4159g.t(locationX, locationY, mAnchorDpDt, this.f4170r, dArr2, this.f4171s);
                f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
                return;
            } else {
                dArr2[i7] = dArr2[i7] * ((double) f13);
                i7++;
            }
        }
    }

    public float E() {
        return this.f4159g.f4194h;
    }

    public float F() {
        return this.f4159g.f4193g;
    }

    public float G() {
        return this.f4159g.f4191e;
    }

    public float H() {
        return this.f4159g.f4192f;
    }

    public int I() {
        return this.G;
    }

    public View J() {
        return this.f4154b;
    }

    boolean L(View child, float global_position, long time, androidx.constraintlayout.core.motion.utils.g keyCache) {
        androidx.constraintlayout.motion.utils.f.d dVar;
        boolean zK;
        float fJ = j(global_position, null);
        int i7 = this.I;
        if (i7 != f.f3951f) {
            float f8 = 1.0f / i7;
            float fFloor = ((float) Math.floor(fJ / f8)) * f8;
            float f9 = (fJ % f8) / f8;
            if (!Float.isNaN(this.f4152J)) {
                f9 = (f9 + this.f4152J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            fJ = ((interpolator != null ? interpolator.getInterpolation(f9) : ((double) f9) > 0.5d ? 1.0f : 0.0f) * f8) + fFloor;
        }
        float f10 = fJ;
        HashMap<String, androidx.constraintlayout.motion.utils.d> map = this.C;
        if (map != null) {
            Iterator<androidx.constraintlayout.motion.utils.d> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m(child, f10);
            }
        }
        HashMap<String, androidx.constraintlayout.motion.utils.f> map2 = this.B;
        if (map2 != null) {
            androidx.constraintlayout.motion.utils.f.d dVar2 = null;
            boolean zJ = false;
            for (androidx.constraintlayout.motion.utils.f fVar : map2.values()) {
                if (fVar instanceof androidx.constraintlayout.motion.utils.f.d) {
                    dVar2 = (androidx.constraintlayout.motion.utils.f.d) fVar;
                } else {
                    zJ |= fVar.j(child, f10, time, keyCache);
                }
            }
            zK = zJ;
            dVar = dVar2;
        } else {
            dVar = null;
            zK = false;
        }
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f4163k;
        int i8 = 1;
        if (bVarArr != null) {
            double d8 = f10;
            bVarArr[0].d(d8, this.f4171s);
            this.f4163k[0].g(d8, this.f4172t);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
            if (bVar != null) {
                double[] dArr = this.f4171s;
                if (dArr.length > 0) {
                    bVar.d(d8, dArr);
                    this.f4164l.g(d8, this.f4172t);
                }
            }
            if (!this.L) {
                this.f4159g.u(f10, child, this.f4170r, this.f4171s, this.f4172t, null, this.f4156d);
                this.f4156d = false;
            }
            if (this.G != f.f3951f) {
                if (this.H == null) {
                    this.H = ((View) child.getParent()).findViewById(this.G);
                }
                View view = this.H;
                if (view != null) {
                    float top = (view.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (child.getRight() - child.getLeft() > 0 && child.getBottom() - child.getTop() > 0) {
                        float left2 = left - child.getLeft();
                        float top2 = top - child.getTop();
                        child.setPivotX(left2);
                        child.setPivotY(top2);
                    }
                }
            }
            HashMap<String, androidx.constraintlayout.motion.utils.d> map3 = this.C;
            if (map3 != null) {
                for (androidx.constraintlayout.motion.utils.d dVar3 : map3.values()) {
                    if (dVar3 instanceof androidx.constraintlayout.motion.utils.d.C0044d) {
                        double[] dArr2 = this.f4172t;
                        if (dArr2.length > 1) {
                            ((androidx.constraintlayout.motion.utils.d.C0044d) dVar3).n(child, f10, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.f4172t;
                zK |= dVar.k(child, keyCache, f10, time, dArr3[0], dArr3[1]);
            }
            int i9 = i8;
            while (true) {
                androidx.constraintlayout.core.motion.utils.b[] bVarArr2 = this.f4163k;
                if (i9 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i9].e(d8, this.f4176x);
                androidx.constraintlayout.motion.utils.a.b(this.f4159g.f4201o.get(this.f4173u[i9 - 1]), child, this.f4176x);
                i9++;
            }
            n nVar = this.f4161i;
            if (nVar.f4113b == 0) {
                if (f10 <= 0.0f) {
                    child.setVisibility(nVar.f4114c);
                } else if (f10 >= 1.0f) {
                    child.setVisibility(this.f4162j.f4114c);
                } else if (this.f4162j.f4114c != nVar.f4114c) {
                    child.setVisibility(0);
                }
            }
            if (this.E != null) {
                int i10 = 0;
                while (true) {
                    m[] mVarArr = this.E;
                    if (i10 >= mVarArr.length) {
                        break;
                    }
                    mVarArr[i10].A(f10, child);
                    i10++;
                }
            }
        } else {
            i8 = 1;
            r rVar = this.f4159g;
            float f11 = rVar.f4191e;
            r rVar2 = this.f4160h;
            float f12 = f11 + ((rVar2.f4191e - f11) * f10);
            float f13 = rVar.f4192f;
            float f14 = f13 + ((rVar2.f4192f - f13) * f10);
            float f15 = rVar.f4193g;
            float f16 = rVar2.f4193g;
            float f17 = rVar.f4194h;
            float f18 = rVar2.f4194h;
            float f19 = f12 + 0.5f;
            int i11 = (int) f19;
            float f20 = f14 + 0.5f;
            int i12 = (int) f20;
            int i13 = (int) (f19 + ((f16 - f15) * f10) + f15);
            int i14 = (int) (f20 + ((f18 - f17) * f10) + f17);
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (f16 != f15 || f18 != f17 || this.f4156d) {
                child.measure(View.MeasureSpec.makeMeasureSpec(i15, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
                this.f4156d = false;
            }
            child.layout(i11, i12, i13, i14);
        }
        HashMap<String, androidx.constraintlayout.motion.utils.c> map4 = this.D;
        if (map4 != null) {
            for (androidx.constraintlayout.motion.utils.c cVar : map4.values()) {
                if (cVar instanceof androidx.constraintlayout.motion.utils.c.d) {
                    double[] dArr4 = this.f4172t;
                    ((androidx.constraintlayout.motion.utils.c.d) cVar).n(child, f10, dArr4[0], dArr4[i8]);
                } else {
                    cVar.m(child, f10);
                }
            }
        }
        return zK;
    }

    String M() {
        return this.f4154b.getContext().getResources().getResourceEntryName(this.f4154b.getId());
    }

    void N(View view, k key, float x7, float y7, String[] attribute, float[] value) {
        RectF rectF = new RectF();
        r rVar = this.f4159g;
        float f8 = rVar.f4191e;
        rectF.left = f8;
        float f9 = rVar.f4192f;
        rectF.top = f9;
        rectF.right = f8 + rVar.f4193g;
        rectF.bottom = f9 + rVar.f4194h;
        RectF rectF2 = new RectF();
        r rVar2 = this.f4160h;
        float f10 = rVar2.f4191e;
        rectF2.left = f10;
        float f11 = rVar2.f4192f;
        rectF2.top = f11;
        rectF2.right = f10 + rVar2.f4193g;
        rectF2.bottom = f11 + rVar2.f4194h;
        key.s(view, rectF, rectF2, x7, y7, attribute, value);
    }

    public void P() {
        this.f4156d = true;
    }

    void Q(Rect rect, Rect out, int rotation, int preHeight, int preWidth) {
        if (rotation == 1) {
            int i7 = rect.left + rect.right;
            out.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            out.top = preWidth - ((i7 + rect.height()) / 2);
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation == 2) {
            int i8 = rect.left + rect.right;
            out.left = preHeight - (((rect.top + rect.bottom) + rect.width()) / 2);
            out.top = (i8 - rect.height()) / 2;
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation == 3) {
            int i9 = rect.left + rect.right;
            out.left = ((rect.height() / 2) + rect.top) - (i9 / 2);
            out.top = preWidth - ((i9 + rect.height()) / 2);
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation != 4) {
            return;
        }
        int i10 = rect.left + rect.right;
        out.left = preHeight - (((rect.bottom + rect.top) + rect.width()) / 2);
        out.top = (i10 - rect.height()) / 2;
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
    }

    void R(View v7) {
        r rVar = this.f4159g;
        rVar.f4189c = 0.0f;
        rVar.f4190d = 0.0f;
        this.L = true;
        rVar.s(v7.getX(), v7.getY(), v7.getWidth(), v7.getHeight());
        this.f4160h.s(v7.getX(), v7.getY(), v7.getWidth(), v7.getHeight());
        this.f4161i.o(v7);
        this.f4162j.o(v7);
    }

    public void S(int debugMode) {
        this.f4159g.f4188b = debugMode;
    }

    void T(Rect cw, androidx.constraintlayout.widget.d constraintSet, int parentWidth, int parentHeight) {
        int i7 = constraintSet.f4761d;
        if (i7 != 0) {
            Q(cw, this.f4153a, i7, parentWidth, parentHeight);
            cw = this.f4153a;
        }
        r rVar = this.f4160h;
        rVar.f4189c = 1.0f;
        rVar.f4190d = 1.0f;
        O(rVar);
        this.f4160h.s(cw.left, cw.top, cw.width(), cw.height());
        this.f4160h.a(constraintSet.q0(this.f4155c));
        this.f4162j.n(cw, constraintSet, i7, this.f4155c);
    }

    public void U(int arc) {
        this.F = arc;
    }

    void V(View v7) {
        r rVar = this.f4159g;
        rVar.f4189c = 0.0f;
        rVar.f4190d = 0.0f;
        rVar.s(v7.getX(), v7.getY(), v7.getWidth(), v7.getHeight());
        this.f4161i.o(v7);
    }

    void W(Rect cw, androidx.constraintlayout.widget.d constraintSet, int parentWidth, int parentHeight) {
        int i7 = constraintSet.f4761d;
        if (i7 != 0) {
            Q(cw, this.f4153a, i7, parentWidth, parentHeight);
        }
        r rVar = this.f4159g;
        rVar.f4189c = 0.0f;
        rVar.f4190d = 0.0f;
        O(rVar);
        this.f4159g.s(cw.left, cw.top, cw.width(), cw.height());
        androidx.constraintlayout.widget.d.a aVarQ0 = constraintSet.q0(this.f4155c);
        this.f4159g.a(aVarQ0);
        this.f4165m = aVarQ0.f4768d.f4886g;
        this.f4161i.n(cw, constraintSet, i7, this.f4155c);
        this.G = aVarQ0.f4770f.f4919i;
        androidx.constraintlayout.widget.d.c cVar = aVarQ0.f4768d;
        this.I = cVar.f4890k;
        this.f4152J = cVar.f4889j;
        Context context = this.f4154b.getContext();
        androidx.constraintlayout.widget.d.c cVar2 = aVarQ0.f4768d;
        this.K = v(context, cVar2.f4892m, cVar2.f4891l, cVar2.f4893n);
    }

    public void X(androidx.constraintlayout.motion.utils.e rect, View v7, int rotation, int preWidth, int preHeight) {
        r rVar = this.f4159g;
        rVar.f4189c = 0.0f;
        rVar.f4190d = 0.0f;
        Rect rect2 = new Rect();
        if (rotation == 1) {
            int i7 = rect.f3828b + rect.f3830d;
            rect2.left = ((rect.f3829c + rect.f3831e) - rect.c()) / 2;
            rect2.top = preWidth - ((i7 + rect.b()) / 2);
            rect2.right = rect2.left + rect.c();
            rect2.bottom = rect2.top + rect.b();
        } else if (rotation == 2) {
            int i8 = rect.f3828b + rect.f3830d;
            rect2.left = preHeight - (((rect.f3829c + rect.f3831e) + rect.c()) / 2);
            rect2.top = (i8 - rect.b()) / 2;
            rect2.right = rect2.left + rect.c();
            rect2.bottom = rect2.top + rect.b();
        }
        this.f4159g.s(rect2.left, rect2.top, rect2.width(), rect2.height());
        this.f4161i.m(rect2, v7, rotation, rect.f3827a);
    }

    public void Y(int transformPivotTarget) {
        this.G = transformPivotTarget;
        this.H = null;
    }

    public void Z(View view) {
        this.f4154b = view;
        this.f4155c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f4157e = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    public void a(f key) {
        this.A.add(key);
    }

    public void a0(int parentWidth, int parentHeight, float transitionDuration, long currentTime) {
        ArrayList arrayList;
        String[] strArr;
        androidx.constraintlayout.widget.a aVar;
        androidx.constraintlayout.motion.utils.f fVarI;
        androidx.constraintlayout.widget.a aVar2;
        Integer num;
        androidx.constraintlayout.motion.utils.d dVarL;
        androidx.constraintlayout.widget.a aVar3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i7 = this.F;
        if (i7 != f.f3951f) {
            this.f4159g.f4197k = i7;
        }
        this.f4161i.f(this.f4162j, hashSet2);
        ArrayList<f> arrayList2 = this.A;
        if (arrayList2 != null) {
            arrayList = null;
            for (f fVar : arrayList2) {
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    K(new r(parentWidth, parentHeight, jVar, this.f4159g, this.f4160h));
                    int i8 = jVar.D;
                    if (i8 != f.f3951f) {
                        this.f4158f = i8;
                    }
                } else if (fVar instanceof h) {
                    fVar.d(hashSet3);
                } else if (fVar instanceof l) {
                    fVar.d(hashSet);
                } else if (fVar instanceof m) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((m) fVar);
                } else {
                    fVar.i(map);
                    fVar.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        int i9 = 0;
        if (arrayList != null) {
            this.E = (m[]) arrayList.toArray(new m[0]);
        }
        char c8 = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    for (f fVar2 : this.A) {
                        HashMap<String, androidx.constraintlayout.widget.a> map2 = fVar2.f3976e;
                        if (map2 != null && (aVar3 = map2.get(str2)) != null) {
                            sparseArray.append(fVar2.f3972a, aVar3);
                        }
                    }
                    dVarL = androidx.constraintlayout.motion.utils.d.k(str, sparseArray);
                } else {
                    dVarL = androidx.constraintlayout.motion.utils.d.l(str);
                }
                if (dVarL != null) {
                    dVarL.i(str);
                    this.C.put(str, dVarL);
                }
            }
            ArrayList<f> arrayList3 = this.A;
            if (arrayList3 != null) {
                for (f fVar3 : arrayList3) {
                    if (fVar3 instanceof g) {
                        fVar3.a(this.C);
                    }
                }
            }
            this.f4161i.a(this.C, 0);
            this.f4162j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                androidx.constraintlayout.motion.utils.d dVar = this.C.get(str3);
                if (dVar != null) {
                    dVar.j(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        for (f fVar4 : this.A) {
                            HashMap<String, androidx.constraintlayout.widget.a> map3 = fVar4.f3976e;
                            if (map3 != null && (aVar2 = map3.get(str5)) != null) {
                                sparseArray2.append(fVar4.f3972a, aVar2);
                            }
                        }
                        fVarI = androidx.constraintlayout.motion.utils.f.h(str4, sparseArray2);
                    } else {
                        fVarI = androidx.constraintlayout.motion.utils.f.i(str4, currentTime);
                    }
                    if (fVarI != null) {
                        fVarI.e(str4);
                        this.B.put(str4, fVarI);
                    }
                }
            }
            ArrayList<f> arrayList4 = this.A;
            if (arrayList4 != null) {
                for (f fVar5 : arrayList4) {
                    if (fVar5 instanceof l) {
                        ((l) fVar5).W(this.B);
                    }
                }
            }
            for (String str6 : this.B.keySet()) {
                this.B.get(str6).f(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int i10 = 2;
        int size = this.f4177y.size() + 2;
        r[] rVarArr = new r[size];
        rVarArr[0] = this.f4159g;
        rVarArr[size - 1] = this.f4160h;
        if (this.f4177y.size() > 0 && this.f4158f == -1) {
            this.f4158f = 0;
        }
        Iterator<r> it = this.f4177y.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            rVarArr[i11] = it.next();
            i11++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f4160h.f4201o.keySet()) {
            if (this.f4159g.f4201o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f4173u = strArr2;
        this.f4174v = new int[strArr2.length];
        int i12 = 0;
        while (true) {
            strArr = this.f4173u;
            if (i12 >= strArr.length) {
                break;
            }
            String str8 = strArr[i12];
            this.f4174v[i12] = 0;
            for (int i13 = 0; i13 < size; i13++) {
                if (rVarArr[i13].f4201o.containsKey(str8) && (aVar = rVarArr[i13].f4201o.get(str8)) != null) {
                    int[] iArr = this.f4174v;
                    iArr[i12] = iArr[i12] + aVar.p();
                    break;
                }
            }
            i12++;
        }
        boolean z7 = rVarArr[0].f4197k != f.f3951f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i14 = 1; i14 < size; i14++) {
            rVarArr[i14].e(rVarArr[i14 - 1], zArr, this.f4173u, z7);
        }
        int i15 = 0;
        for (int i16 = 1; i16 < length; i16++) {
            if (zArr[i16]) {
                i15++;
            }
        }
        this.f4170r = new int[i15];
        int iMax = Math.max(2, i15);
        this.f4171s = new double[iMax];
        this.f4172t = new double[iMax];
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                this.f4170r[i17] = i18;
                i17++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, this.f4170r.length);
        double[] dArr2 = new double[size];
        for (int i19 = 0; i19 < size; i19++) {
            rVarArr[i19].f(dArr[i19], this.f4170r);
            dArr2[i19] = rVarArr[i19].f4189c;
        }
        int i20 = 0;
        while (true) {
            int[] iArr2 = this.f4170r;
            if (i20 >= iArr2.length) {
                break;
            }
            if (iArr2[i20] < r.F.length) {
                String str9 = r.F[this.f4170r[i20]] + " [";
                for (int i21 = 0; i21 < size; i21++) {
                    str9 = str9 + dArr[i21][i20];
                }
            }
            i20++;
        }
        this.f4163k = new androidx.constraintlayout.core.motion.utils.b[this.f4173u.length + 1];
        int i22 = 0;
        while (true) {
            String[] strArr3 = this.f4173u;
            if (i22 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i22];
            int i23 = i9;
            int i24 = i23;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i23 < size) {
                if (rVarArr[i23].n(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i10];
                        iArr3[c8] = rVarArr[i23].l(str10);
                        iArr3[i9] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    r rVar = rVarArr[i23];
                    dArr3[i24] = rVar.f4189c;
                    rVar.k(str10, dArr4[i24], 0);
                    i24++;
                }
                i23++;
                i10 = 2;
                i9 = 0;
                c8 = 1;
            }
            i22++;
            this.f4163k[i22] = androidx.constraintlayout.core.motion.utils.b.a(this.f4158f, Arrays.copyOf(dArr3, i24), (double[][]) Arrays.copyOf(dArr4, i24));
            i10 = 2;
            i9 = 0;
            c8 = 1;
        }
        this.f4163k[0] = androidx.constraintlayout.core.motion.utils.b.a(this.f4158f, dArr2, dArr);
        if (rVarArr[0].f4197k != f.f3951f) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
            for (int i25 = 0; i25 < size; i25++) {
                r rVar2 = rVarArr[i25];
                iArr4[i25] = rVar2.f4197k;
                dArr5[i25] = rVar2.f4189c;
                double[] dArr7 = dArr6[i25];
                dArr7[0] = rVar2.f4191e;
                dArr7[1] = rVar2.f4192f;
            }
            this.f4164l = androidx.constraintlayout.core.motion.utils.b.b(iArr4, dArr5, dArr6);
        }
        this.D = new HashMap<>();
        if (this.A != null) {
            float fD = Float.NaN;
            for (String str11 : hashSet3) {
                androidx.constraintlayout.motion.utils.c cVarL = androidx.constraintlayout.motion.utils.c.l(str11);
                if (cVarL != null) {
                    if (cVarL.k() && Float.isNaN(fD)) {
                        fD = D();
                    }
                    cVarL.i(str11);
                    this.D.put(str11, cVarL);
                }
            }
            for (f fVar6 : this.A) {
                if (fVar6 instanceof h) {
                    ((h) fVar6).a0(this.D);
                }
            }
            Iterator<androidx.constraintlayout.motion.utils.c> it2 = this.D.values().iterator();
            while (it2.hasNext()) {
                it2.next().j(fD);
            }
        }
    }

    void b(ArrayList<f> list) {
        this.A.addAll(list);
    }

    public void b0(o motionController) {
        this.f4159g.v(motionController, motionController.f4159g);
        this.f4160h.v(motionController, motionController.f4160h);
    }

    void c(float[] bounds, int pointCount) {
        float f8 = 1.0f / (pointCount - 1);
        HashMap<String, androidx.constraintlayout.motion.utils.d> map = this.C;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, androidx.constraintlayout.motion.utils.d> map2 = this.C;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, androidx.constraintlayout.motion.utils.c> map3 = this.D;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, androidx.constraintlayout.motion.utils.c> map4 = this.D;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i7 = 0; i7 < pointCount; i7++) {
            float fMin = i7 * f8;
            float f9 = this.f4167o;
            float f10 = 0.0f;
            if (f9 != 1.0f) {
                float f11 = this.f4166n;
                if (fMin < f11) {
                    fMin = 0.0f;
                }
                if (fMin > f11 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f11) * f9, 1.0f);
                }
            }
            double dA = fMin;
            androidx.constraintlayout.core.motion.utils.d dVar = this.f4159g.f4187a;
            float f12 = Float.NaN;
            for (r rVar : this.f4177y) {
                androidx.constraintlayout.core.motion.utils.d dVar2 = rVar.f4187a;
                if (dVar2 != null) {
                    float f13 = rVar.f4189c;
                    if (f13 < fMin) {
                        dVar = dVar2;
                        f10 = f13;
                    } else if (Float.isNaN(f12)) {
                        f12 = rVar.f4189c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                float f14 = f12 - f10;
                dA = (((float) dVar.a((fMin - f10) / f14)) * f14) + f10;
            }
            this.f4163k[0].d(dA, this.f4171s);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
            if (bVar != null) {
                double[] dArr = this.f4171s;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            this.f4159g.g(this.f4170r, this.f4171s, bounds, i7 * 2);
        }
    }

    int d(float[] keyBounds, int[] mode) {
        if (keyBounds == null) {
            return 0;
        }
        double[] dArrH = this.f4163k[0].h();
        if (mode != null) {
            Iterator<r> it = this.f4177y.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                mode[i7] = it.next().f4202p;
                i7++;
            }
        }
        int i8 = 0;
        for (double d8 : dArrH) {
            this.f4163k[0].d(d8, this.f4171s);
            this.f4159g.g(this.f4170r, this.f4171s, keyBounds, i8);
            i8 += 2;
        }
        return i8 / 2;
    }

    int e(float[] keyFrames, int[] mode) {
        if (keyFrames == null) {
            return 0;
        }
        double[] dArrH = this.f4163k[0].h();
        if (mode != null) {
            Iterator<r> it = this.f4177y.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                mode[i7] = it.next().f4202p;
                i7++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < dArrH.length; i9++) {
            this.f4163k[0].d(dArrH[i9], this.f4171s);
            this.f4159g.h(dArrH[i9], this.f4170r, this.f4171s, keyFrames, i8);
            i8 += 2;
        }
        return i8 / 2;
    }

    void f(float[] points, int pointCount) {
        double dA;
        float f8 = 1.0f;
        float f9 = 1.0f / (pointCount - 1);
        HashMap<String, androidx.constraintlayout.motion.utils.d> map = this.C;
        androidx.constraintlayout.motion.utils.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, androidx.constraintlayout.motion.utils.d> map2 = this.C;
        androidx.constraintlayout.motion.utils.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map3 = this.D;
        androidx.constraintlayout.motion.utils.c cVar = map3 == null ? null : map3.get("translationX");
        HashMap<String, androidx.constraintlayout.motion.utils.c> map4 = this.D;
        androidx.constraintlayout.motion.utils.c cVar2 = map4 != null ? map4.get("translationY") : null;
        int i7 = 0;
        while (i7 < pointCount) {
            float fMin = i7 * f9;
            float f10 = this.f4167o;
            float f11 = 0.0f;
            if (f10 != f8) {
                float f12 = this.f4166n;
                if (fMin < f12) {
                    fMin = 0.0f;
                }
                if (fMin > f12 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f12) * f10, f8);
                }
            }
            float f13 = fMin;
            double d8 = f13;
            androidx.constraintlayout.core.motion.utils.d dVar3 = this.f4159g.f4187a;
            float f14 = Float.NaN;
            for (r rVar : this.f4177y) {
                androidx.constraintlayout.core.motion.utils.d dVar4 = rVar.f4187a;
                double d9 = d8;
                if (dVar4 != null) {
                    float f15 = rVar.f4189c;
                    if (f15 < f13) {
                        f11 = f15;
                        dVar3 = dVar4;
                    } else if (Float.isNaN(f14)) {
                        f14 = rVar.f4189c;
                    }
                }
                d8 = d9;
            }
            double d10 = d8;
            if (dVar3 != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                float f16 = f14 - f11;
                dA = (((float) dVar3.a((f13 - f11) / f16)) * f16) + f11;
            } else {
                dA = d10;
            }
            this.f4163k[0].d(dA, this.f4171s);
            androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
            if (bVar != null) {
                double[] dArr = this.f4171s;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            int i8 = i7 * 2;
            int i9 = i7;
            this.f4159g.h(dA, this.f4170r, this.f4171s, points, i8);
            if (cVar != null) {
                points[i8] = points[i8] + cVar.a(f13);
            } else if (dVar != null) {
                points[i8] = points[i8] + dVar.a(f13);
            }
            if (cVar2 != null) {
                int i10 = i8 + 1;
                points[i10] = points[i10] + cVar2.a(f13);
            } else if (dVar2 != null) {
                int i11 = i8 + 1;
                points[i11] = points[i11] + dVar2.a(f13);
            }
            i7 = i9 + 1;
            f8 = 1.0f;
        }
    }

    void g(float p7, float[] path, int offset) {
        this.f4163k[0].d(j(p7, null), this.f4171s);
        this.f4159g.m(this.f4170r, this.f4171s, path, offset);
    }

    void h(float[] path, int pointCount) {
        float f8 = 1.0f / (pointCount - 1);
        for (int i7 = 0; i7 < pointCount; i7++) {
            this.f4163k[0].d(j(i7 * f8, null), this.f4171s);
            this.f4159g.m(this.f4170r, this.f4171s, path, i7 * 8);
        }
    }

    void i(boolean start) {
        if (!"button".equals(c.k(this.f4154b)) || this.E == null) {
            return;
        }
        int i7 = 0;
        while (true) {
            m[] mVarArr = this.E;
            if (i7 >= mVarArr.length) {
                return;
            }
            mVarArr[i7].A(start ? -100.0f : 100.0f, this.f4154b);
            i7++;
        }
    }

    public int k() {
        return this.f4159g.f4198l;
    }

    int l(String attributeType, float[] points, int pointCount) {
        androidx.constraintlayout.motion.utils.d dVar = this.C.get(attributeType);
        if (dVar == null) {
            return -1;
        }
        for (int i7 = 0; i7 < points.length; i7++) {
            points[i7] = dVar.a(i7 / (points.length - 1));
        }
        return points.length;
    }

    public void m(double p7, float[] pos, float[] vel) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f4163k[0].d(p7, dArr);
        this.f4163k[0].g(p7, dArr2);
        Arrays.fill(vel, 0.0f);
        this.f4159g.i(p7, this.f4170r, dArr, pos, dArr2, vel);
    }

    public float n() {
        return this.f4168p;
    }

    public float o() {
        return this.f4169q;
    }

    void p(float position, float locationX, float locationY, float[] mAnchorDpDt) {
        double[] dArr;
        float fJ = j(position, this.f4178z);
        androidx.constraintlayout.core.motion.utils.b[] bVarArr = this.f4163k;
        int i7 = 0;
        if (bVarArr == null) {
            r rVar = this.f4160h;
            float f8 = rVar.f4191e;
            r rVar2 = this.f4159g;
            float f9 = f8 - rVar2.f4191e;
            float f10 = rVar.f4192f - rVar2.f4192f;
            float f11 = (rVar.f4193g - rVar2.f4193g) + f9;
            float f12 = (rVar.f4194h - rVar2.f4194h) + f10;
            mAnchorDpDt[0] = (f9 * (1.0f - locationX)) + (f11 * locationX);
            mAnchorDpDt[1] = (f10 * (1.0f - locationY)) + (f12 * locationY);
            return;
        }
        double d8 = fJ;
        bVarArr[0].g(d8, this.f4172t);
        this.f4163k[0].d(d8, this.f4171s);
        float f13 = this.f4178z[0];
        while (true) {
            dArr = this.f4172t;
            if (i7 >= dArr.length) {
                break;
            }
            dArr[i7] = dArr[i7] * ((double) f13);
            i7++;
        }
        androidx.constraintlayout.core.motion.utils.b bVar = this.f4164l;
        if (bVar == null) {
            this.f4159g.t(locationX, locationY, mAnchorDpDt, this.f4170r, dArr, this.f4171s);
            return;
        }
        double[] dArr2 = this.f4171s;
        if (dArr2.length > 0) {
            bVar.d(d8, dArr2);
            this.f4164l.g(d8, this.f4172t);
            this.f4159g.t(locationX, locationY, mAnchorDpDt, this.f4170r, this.f4172t, this.f4171s);
        }
    }

    public int q() {
        int iMax = this.f4159g.f4188b;
        Iterator<r> it = this.f4177y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f4188b);
        }
        return Math.max(iMax, this.f4160h.f4188b);
    }

    public float r() {
        return this.f4160h.f4194h;
    }

    public float s() {
        return this.f4160h.f4193g;
    }

    public float t() {
        return this.f4160h.f4191e;
    }

    public String toString() {
        return " start: x: " + this.f4159g.f4191e + " y: " + this.f4159g.f4192f + " end: x: " + this.f4160h.f4191e + " y: " + this.f4160h.f4192f;
    }

    public float u() {
        return this.f4160h.f4192f;
    }

    r w(int i7) {
        return this.f4177y.get(i7);
    }

    public int x(int type, int[] info) {
        float[] fArr = new float[2];
        int i7 = 0;
        int i8 = 0;
        for (f fVar : this.A) {
            int i9 = fVar.f3975d;
            if (i9 == type || type != -1) {
                info[i8] = 0;
                int i10 = i8 + 1;
                info[i10] = i9;
                int i11 = i10 + 1;
                int i12 = fVar.f3972a;
                info[i11] = i12;
                double d8 = i12 / 100.0f;
                this.f4163k[0].d(d8, this.f4171s);
                this.f4159g.h(d8, this.f4170r, this.f4171s, fArr, 0);
                int i13 = i11 + 1;
                info[i13] = Float.floatToIntBits(fArr[0]);
                int i14 = i13 + 1;
                info[i14] = Float.floatToIntBits(fArr[1]);
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i15 = i14 + 1;
                    info[i15] = jVar.O;
                    int i16 = i15 + 1;
                    info[i16] = Float.floatToIntBits(jVar.K);
                    i14 = i16 + 1;
                    info[i14] = Float.floatToIntBits(jVar.L);
                }
                int i17 = i14 + 1;
                info[i8] = i17 - i8;
                i7++;
                i8 = i17;
            }
        }
        return i7;
    }

    float y(int type, float x7, float y7) {
        r rVar = this.f4160h;
        float f8 = rVar.f4191e;
        r rVar2 = this.f4159g;
        float f9 = rVar2.f4191e;
        float f10 = f8 - f9;
        float f11 = rVar.f4192f;
        float f12 = rVar2.f4192f;
        float f13 = f11 - f12;
        float f14 = f9 + (rVar2.f4193g / 2.0f);
        float f15 = f12 + (rVar2.f4194h / 2.0f);
        float fHypot = (float) Math.hypot(f10, f13);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f16 = x7 - f14;
        float f17 = y7 - f15;
        if (((float) Math.hypot(f16, f17)) == 0.0f) {
            return 0.0f;
        }
        float f18 = (f16 * f10) + (f17 * f13);
        if (type == 0) {
            return f18 / fHypot;
        }
        if (type == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f18 * f18));
        }
        if (type == 2) {
            return f16 / f10;
        }
        if (type == 3) {
            return f17 / f10;
        }
        if (type == 4) {
            return f16 / f13;
        }
        if (type != 5) {
            return 0.0f;
        }
        return f17 / f13;
    }

    public int z(int[] type, float[] pos) {
        int i7 = 0;
        int i8 = 0;
        for (f fVar : this.A) {
            int i9 = fVar.f3972a;
            type[i7] = (fVar.f3975d * 1000) + i9;
            double d8 = i9 / 100.0f;
            this.f4163k[0].d(d8, this.f4171s);
            this.f4159g.h(d8, this.f4170r, this.f4171s, pos, i8);
            i8 += 2;
            i7++;
        }
        return i7;
    }
}
