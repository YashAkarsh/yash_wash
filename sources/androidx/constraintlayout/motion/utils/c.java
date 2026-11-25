package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends androidx.constraintlayout.core.motion.utils.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f3818i = "ViewOscillator";

    static class a extends c {
        a() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setAlpha(a(t7));
        }
    }

    static class b extends c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float[] f3819j = new float[1];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected androidx.constraintlayout.widget.a f3820k;

        b() {
        }

        @Override // androidx.constraintlayout.core.motion.utils.h
        protected void e(Object custom) {
            this.f3820k = (androidx.constraintlayout.widget.a) custom;
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            this.f3819j[0] = a(t7);
            androidx.constraintlayout.motion.utils.a.b(this.f3820k, view, this.f3819j);
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.c$c, reason: collision with other inner class name */
    static class C0043c extends c {
        C0043c() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setElevation(a(t7));
        }
    }

    public static class d extends c {
        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
        }

        public void n(View view, float t7, double dx, double dy) {
            view.setRotation(a(t7) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class e extends c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f3821j = false;

        e() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(t7));
                return;
            }
            if (this.f3821j) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f3821j = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(t7)));
                } catch (IllegalAccessException e8) {
                    Log.e(c.f3818i, "unable to setProgress", e8);
                } catch (InvocationTargetException e9) {
                    Log.e(c.f3818i, "unable to setProgress", e9);
                }
            }
        }
    }

    static class f extends c {
        f() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setRotation(a(t7));
        }
    }

    static class g extends c {
        g() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setRotationX(a(t7));
        }
    }

    static class h extends c {
        h() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setRotationY(a(t7));
        }
    }

    static class i extends c {
        i() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setScaleX(a(t7));
        }
    }

    static class j extends c {
        j() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setScaleY(a(t7));
        }
    }

    static class k extends c {
        k() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setTranslationX(a(t7));
        }
    }

    static class l extends c {
        l() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setTranslationY(a(t7));
        }
    }

    static class m extends c {
        m() {
        }

        @Override // androidx.constraintlayout.motion.utils.c
        public void m(View view, float t7) {
            view.setTranslationZ(a(t7));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static c l(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
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
            case -40300674:
                if (str.equals(androidx.constraintlayout.motion.widget.f.f3954i)) {
                    b8 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b8 = 10;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
        }
        switch (b8) {
            case 0:
                return new g();
            case 1:
                return new h();
            case 2:
                return new k();
            case 3:
                return new l();
            case 4:
                return new m();
            case 5:
                return new e();
            case 6:
                return new i();
            case 7:
                return new j();
            case 8:
                return new a();
            case 9:
                return new f();
            case 10:
                return new C0043c();
            case 11:
                return new d();
            case 12:
                return new a();
            case 13:
                return new a();
            default:
                return null;
        }
    }

    public abstract void m(View view, float t7);
}
