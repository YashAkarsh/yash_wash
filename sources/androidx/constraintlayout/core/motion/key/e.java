package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.b0;
import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.w;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {
    static final String L = "KeyPosition";
    protected static final float M = 20.0f;
    public static final int N = 2;
    public static final int O = 1;
    public static final int P = 0;
    static final int Q = 2;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f2711J;
    private float K;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2712y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f2713z;

    public e() {
        int i7 = b.f2683m;
        this.f2712y = i7;
        this.f2713z = null;
        this.A = i7;
        this.B = 0;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = Float.NaN;
        this.H = Float.NaN;
        this.I = 0;
        this.f2711J = Float.NaN;
        this.K = Float.NaN;
        this.f2698k = 2;
    }

    private void v(float f8, float f9, float f10, float f11) {
        float f12 = f10 - f8;
        float f13 = f11 - f9;
        float f14 = Float.isNaN(this.E) ? 0.0f : this.E;
        float f15 = Float.isNaN(this.H) ? 0.0f : this.H;
        float f16 = Float.isNaN(this.F) ? 0.0f : this.F;
        this.f2711J = (int) (f8 + (f14 * f12) + ((Float.isNaN(this.G) ? 0.0f : this.G) * f13));
        this.K = (int) (f9 + (f12 * f15) + (f13 * f16));
    }

    private void w(float f8, float f9, float f10, float f11) {
        float f12 = f10 - f8;
        float f13 = f11 - f9;
        float f14 = this.E;
        float f15 = this.F;
        this.f2711J = f8 + (f12 * f14) + ((-f13) * f15);
        this.K = f9 + (f13 * f14) + (f12 * f15);
    }

    private void y(int i7, int i8) {
        float f8 = this.E;
        float f9 = 0;
        this.f2711J = ((i7 - 0) * f8) + f9;
        this.K = ((i8 - 0) * f8) + f9;
    }

    float A() {
        return this.K;
    }

    public boolean B(int i7, int i8, androidx.constraintlayout.core.motion.utils.e eVar, androidx.constraintlayout.core.motion.utils.e eVar2, float f8, float f9) {
        x(i7, i8, eVar.a(), eVar.b(), eVar2.a(), eVar2.b());
        return Math.abs(f8 - this.f2711J) < M && Math.abs(f9 - this.K) < M;
    }

    public void C(androidx.constraintlayout.core.motion.f fVar, androidx.constraintlayout.core.motion.utils.e eVar, androidx.constraintlayout.core.motion.utils.e eVar2, float f8, float f9, String[] strArr, float[] fArr) {
        int i7 = this.I;
        if (i7 == 1) {
            E(eVar, eVar2, f8, f9, strArr, fArr);
        } else if (i7 != 2) {
            D(eVar, eVar2, f8, f9, strArr, fArr);
        } else {
            F(fVar, eVar, eVar2, f8, f9, strArr, fArr);
        }
    }

    void D(androidx.constraintlayout.core.motion.utils.e eVar, androidx.constraintlayout.core.motion.utils.e eVar2, float f8, float f9, String[] strArr, float[] fArr) {
        float fA = eVar.a();
        float fB = eVar.b();
        float fA2 = eVar2.a() - fA;
        float fB2 = eVar2.b() - fB;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f8 - fA) / fA2;
            strArr[1] = "percentY";
            fArr[1] = (f9 - fB) / fB2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f8 - fA) / fA2;
            fArr[1] = (f9 - fB) / fB2;
        } else {
            fArr[1] = (f8 - fA) / fA2;
            fArr[0] = (f9 - fB) / fB2;
        }
    }

    void E(androidx.constraintlayout.core.motion.utils.e eVar, androidx.constraintlayout.core.motion.utils.e eVar2, float f8, float f9, String[] strArr, float[] fArr) {
        float fA = eVar.a();
        float fB = eVar.b();
        float fA2 = eVar2.a() - fA;
        float fB2 = eVar2.b() - fB;
        float fHypot = (float) Math.hypot(fA2, fB2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f10 = fA2 / fHypot;
        float f11 = fB2 / fHypot;
        float f12 = f9 - fB;
        float f13 = f8 - fA;
        float f14 = ((f10 * f12) - (f13 * f11)) / fHypot;
        float f15 = ((f10 * f13) + (f11 * f12)) / fHypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f15;
                fArr[1] = f14;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f15;
        fArr[1] = f14;
    }

    void F(androidx.constraintlayout.core.motion.f fVar, androidx.constraintlayout.core.motion.utils.e eVar, androidx.constraintlayout.core.motion.utils.e eVar2, float f8, float f9, String[] strArr, float[] fArr) {
        eVar.a();
        eVar.b();
        eVar2.a();
        eVar2.b();
        androidx.constraintlayout.core.motion.f fVarN = fVar.n();
        int iD = fVarN.D();
        int iK = fVarN.k();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f8 / iD;
            strArr[1] = "percentY";
            fArr[1] = f9 / iK;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f8 / iD;
            fArr[1] = f9 / iK;
        } else {
            fArr[1] = f8 / iD;
            fArr[0] = f9 / iK;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 == 100) {
            this.f2695h = i8;
            return true;
        }
        if (i7 == 508) {
            this.f2712y = i8;
            return true;
        }
        if (i7 != 510) {
            return super.a(i7, i8);
        }
        this.I = i8;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        switch (i7) {
            case w.g.f3134k /* 503 */:
                this.C = f8;
                return true;
            case w.g.f3135l /* 504 */:
                this.D = f8;
                return true;
            case w.g.f3136m /* 505 */:
                this.C = f8;
                this.D = f8;
                return true;
            case w.g.f3137n /* 506 */:
                this.E = f8;
                return true;
            case w.g.f3138o /* 507 */:
                this.F = f8;
                return true;
            default:
                return super.b(i7, f8);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 != 501) {
            return super.c(i7, str);
        }
        this.f2713z = str.toString();
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        return b0.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void f(HashMap<String, o> map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return new e().h(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public b h(b bVar) {
        super.h(bVar);
        e eVar = (e) bVar;
        this.f2713z = eVar.f2713z;
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.D = Float.NaN;
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.f2711J = eVar.f2711J;
        this.K = eVar.K;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void i(HashSet<String> hashSet) {
    }

    void x(int i7, int i8, float f8, float f9, float f10, float f11) {
        int i9 = this.I;
        if (i9 == 1) {
            w(f8, f9, f10, f11);
        } else if (i9 != 2) {
            v(f8, f9, f10, f11);
        } else {
            y(i7, i8);
        }
    }

    float z() {
        return this.f2711J;
    }
}
