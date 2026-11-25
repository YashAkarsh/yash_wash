package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.t;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends t {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f3832p = "ViewTimeCycle";

    static class a extends f {
        a() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setAlpha(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        String f3833q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        SparseArray<androidx.constraintlayout.widget.a> f3834r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        SparseArray<float[]> f3835s = new SparseArray<>();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        float[] f3836t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        float[] f3837u;

        public b(String attribute, SparseArray<androidx.constraintlayout.widget.a> attrList) {
            this.f3833q = attribute.split(",")[1];
            this.f3834r = attrList;
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void c(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.t
        public void f(int curveType) {
            int size = this.f3834r.size();
            int iP = this.f3834r.valueAt(0).p();
            double[] dArr = new double[size];
            int i7 = iP + 2;
            this.f3836t = new float[i7];
            this.f3837u = new float[iP];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i7);
            for (int i8 = 0; i8 < size; i8++) {
                int iKeyAt = this.f3834r.keyAt(i8);
                androidx.constraintlayout.widget.a aVarValueAt = this.f3834r.valueAt(i8);
                float[] fArrValueAt = this.f3835s.valueAt(i8);
                dArr[i8] = ((double) iKeyAt) * 0.01d;
                aVarValueAt.l(this.f3836t);
                int i9 = 0;
                while (true) {
                    float[] fArr = this.f3836t;
                    if (i9 < fArr.length) {
                        dArr2[i8][i9] = fArr[i9];
                        i9++;
                    }
                }
                double[] dArr3 = dArr2[i8];
                dArr3[iP] = fArrValueAt[0];
                dArr3[iP + 1] = fArrValueAt[1];
            }
            this.f2956a = androidx.constraintlayout.core.motion.utils.b.a(curveType, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            this.f2956a.e(t7, this.f3836t);
            float[] fArr = this.f3836t;
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            long j7 = time - this.f2964i;
            if (Float.isNaN(this.f2965j)) {
                float fA = cache.a(view, this.f3833q, 0);
                this.f2965j = fA;
                if (Float.isNaN(fA)) {
                    this.f2965j = 0.0f;
                }
            }
            float f10 = (float) ((((double) this.f2965j) + ((j7 * 1.0E-9d) * ((double) f8))) % 1.0d);
            this.f2965j = f10;
            this.f2964i = time;
            float fA2 = a(f10);
            this.f2963h = false;
            int i7 = 0;
            while (true) {
                float[] fArr2 = this.f3837u;
                if (i7 >= fArr2.length) {
                    break;
                }
                boolean z7 = this.f2963h;
                float f11 = this.f3836t[i7];
                this.f2963h = z7 | (((double) f11) != 0.0d);
                fArr2[i7] = (f11 * fA2) + f9;
                i7++;
            }
            androidx.constraintlayout.motion.utils.a.b(this.f3834r.valueAt(0), view, this.f3837u);
            if (f8 != 0.0f) {
                this.f2963h = true;
            }
            return this.f2963h;
        }

        public void k(int position, androidx.constraintlayout.widget.a value, float period, int shape, float offset) {
            this.f3834r.append(position, value);
            this.f3835s.append(position, new float[]{period, offset});
            this.f2957b = Math.max(this.f2957b, shape);
        }
    }

    static class c extends f {
        c() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setElevation(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    public static class d extends f {
        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            return this.f2963h;
        }

        public boolean k(View view, androidx.constraintlayout.core.motion.utils.g cache, float t7, long time, double dx, double dy) {
            view.setRotation(g(t7, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.f2963h;
        }
    }

    static class e extends f {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f3838q = false;

        e() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(g(t7, time, view, cache));
            } else {
                if (this.f3838q) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f3838q = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(g(t7, time, view, cache)));
                    } catch (IllegalAccessException e8) {
                        Log.e(f.f3832p, "unable to setProgress", e8);
                    } catch (InvocationTargetException e9) {
                        Log.e(f.f3832p, "unable to setProgress", e9);
                    }
                }
            }
            return this.f2963h;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.f$f, reason: collision with other inner class name */
    static class C0045f extends f {
        C0045f() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setRotation(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class g extends f {
        g() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setRotationX(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class h extends f {
        h() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setRotationY(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class i extends f {
        i() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setScaleX(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class j extends f {
        j() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setScaleY(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class k extends f {
        k() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setTranslationX(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class l extends f {
        l() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setTranslationY(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    static class m extends f {
        m() {
        }

        @Override // androidx.constraintlayout.motion.utils.f
        public boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache) {
            view.setTranslationZ(g(t7, time, view, cache));
            return this.f2963h;
        }
    }

    public static f h(String str, SparseArray<androidx.constraintlayout.widget.a> attrList) {
        return new b(str, attrList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static f i(String str, long currentTime) {
        f gVar;
        str.hashCode();
        byte b8 = -1;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    b8 = 0;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b8 = 1;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b8 = 2;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b8 = 3;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b8 = 4;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b8 = 5;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b8 = 6;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b8 = 7;
                }
                break;
            case -40300674:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3954i)) {
                    b8 = 8;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b8 = 9;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b8 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
        }
        switch (b8) {
            case 0:
                gVar = new g();
                break;
            case 1:
                gVar = new h();
                break;
            case 2:
                gVar = new k();
                break;
            case 3:
                gVar = new l();
                break;
            case 4:
                gVar = new m();
                break;
            case 5:
                gVar = new e();
                break;
            case 6:
                gVar = new i();
                break;
            case 7:
                gVar = new j();
                break;
            case 8:
                gVar = new C0045f();
                break;
            case 9:
                gVar = new c();
                break;
            case 10:
                gVar = new d();
                break;
            case 11:
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.d(currentTime);
        return gVar;
    }

    public float g(float pos, long time, View view, androidx.constraintlayout.core.motion.utils.g cache) {
        this.f2956a.e(pos, this.f2962g);
        float[] fArr = this.f2962g;
        float f8 = fArr[1];
        if (f8 == 0.0f) {
            this.f2963h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f2965j)) {
            float fA = cache.a(view, this.f2961f, 0);
            this.f2965j = fA;
            if (Float.isNaN(fA)) {
                this.f2965j = 0.0f;
            }
        }
        float f9 = (float) ((((double) this.f2965j) + (((time - this.f2964i) * 1.0E-9d) * ((double) f8))) % 1.0d);
        this.f2965j = f9;
        cache.b(view, this.f2961f, 0, f9);
        this.f2964i = time;
        float f10 = this.f2962g[0];
        float fA2 = (a(this.f2965j) * f10) + this.f2962g[2];
        this.f2963h = (f10 == 0.0f && f8 == 0.0f) ? false : true;
        return fA2;
    }

    public abstract boolean j(View view, float t7, long time, androidx.constraintlayout.core.motion.utils.g cache);
}
