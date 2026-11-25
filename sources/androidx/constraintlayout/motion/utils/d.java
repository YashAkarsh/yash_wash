package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends androidx.constraintlayout.core.motion.utils.o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f3822g = "ViewSpline";

    static class a extends d {
        a() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setAlpha(a(t7));
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f3823h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        SparseArray<androidx.constraintlayout.widget.a> f3824i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float[] f3825j;

        public b(String attribute, SparseArray<androidx.constraintlayout.widget.a> attrList) {
            this.f3823h = attribute.split(",")[1];
            this.f3824i = attrList;
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void g(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.o
        public void j(int curveType) {
            int size = this.f3824i.size();
            int iP = this.f3824i.valueAt(0).p();
            double[] dArr = new double[size];
            this.f3825j = new float[iP];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iP);
            for (int i7 = 0; i7 < size; i7++) {
                int iKeyAt = this.f3824i.keyAt(i7);
                androidx.constraintlayout.widget.a aVarValueAt = this.f3824i.valueAt(i7);
                dArr[i7] = ((double) iKeyAt) * 0.01d;
                aVarValueAt.l(this.f3825j);
                int i8 = 0;
                while (true) {
                    float[] fArr = this.f3825j;
                    if (i8 < fArr.length) {
                        dArr2[i7][i8] = fArr[i8];
                        i8++;
                    }
                }
            }
            this.f2908a = androidx.constraintlayout.core.motion.utils.b.a(curveType, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            this.f2908a.e(t7, this.f3825j);
            androidx.constraintlayout.motion.utils.a.b(this.f3824i.valueAt(0), view, this.f3825j);
        }

        public void n(int position, androidx.constraintlayout.widget.a value) {
            this.f3824i.append(position, value);
        }
    }

    static class c extends d {
        c() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setElevation(a(t7));
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.d$d, reason: collision with other inner class name */
    public static class C0044d extends d {
        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
        }

        public void n(View view, float t7, double dx, double dy) {
            view.setRotation(a(t7) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class e extends d {
        e() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setPivotX(a(t7));
        }
    }

    static class f extends d {
        f() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setPivotY(a(t7));
        }
    }

    static class g extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f3826h = false;

        g() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(t7));
                return;
            }
            if (this.f3826h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f3826h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(t7)));
                } catch (IllegalAccessException e8) {
                    Log.e(d.f3822g, "unable to setProgress", e8);
                } catch (InvocationTargetException e9) {
                    Log.e(d.f3822g, "unable to setProgress", e9);
                }
            }
        }
    }

    static class h extends d {
        h() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setRotation(a(t7));
        }
    }

    static class i extends d {
        i() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setRotationX(a(t7));
        }
    }

    static class j extends d {
        j() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setRotationY(a(t7));
        }
    }

    static class k extends d {
        k() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setScaleX(a(t7));
        }
    }

    static class l extends d {
        l() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setScaleY(a(t7));
        }
    }

    static class m extends d {
        m() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setTranslationX(a(t7));
        }
    }

    static class n extends d {
        n() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setTranslationY(a(t7));
        }
    }

    static class o extends d {
        o() {
        }

        @Override // androidx.constraintlayout.motion.utils.d
        public void m(View view, float t7) {
            view.setTranslationZ(a(t7));
        }
    }

    public static d k(String str, SparseArray<androidx.constraintlayout.widget.a> attrList) {
        return new b(str, attrList);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static d l(String str) {
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
            case -797520672:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3965t)) {
                    b8 = 8;
                }
                break;
            case -760884510:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3957l)) {
                    b8 = 9;
                }
                break;
            case -760884509:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3958m)) {
                    b8 = 10;
                }
                break;
            case -40300674:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3954i)) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b8 = com.google.common.base.c.f19316p;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b8 = com.google.common.base.c.f19317q;
                }
                break;
        }
        switch (b8) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case 8:
                return new a();
            case 9:
                return new e();
            case 10:
                return new f();
            case 11:
                return new h();
            case 12:
                return new c();
            case 13:
                return new C0044d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public abstract void m(View view, float t7);
}
