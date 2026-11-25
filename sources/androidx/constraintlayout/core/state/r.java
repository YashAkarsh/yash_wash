package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f3391u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f3392v = Float.NaN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.e f3393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3409q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3410r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, androidx.constraintlayout.core.motion.b> f3411s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3412t;

    public r() {
        this.f3393a = null;
        this.f3394b = 0;
        this.f3395c = 0;
        this.f3396d = 0;
        this.f3397e = 0;
        this.f3398f = Float.NaN;
        this.f3399g = Float.NaN;
        this.f3400h = Float.NaN;
        this.f3401i = Float.NaN;
        this.f3402j = Float.NaN;
        this.f3403k = Float.NaN;
        this.f3404l = Float.NaN;
        this.f3405m = Float.NaN;
        this.f3406n = Float.NaN;
        this.f3407o = Float.NaN;
        this.f3408p = Float.NaN;
        this.f3409q = Float.NaN;
        this.f3410r = 0;
        this.f3411s = new HashMap<>();
        this.f3412t = null;
    }

    private static void a(StringBuilder sb, String str, float f8) {
        if (Float.isNaN(f8)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f8);
        sb.append(",\n");
    }

    private static void b(StringBuilder sb, String str, int i7) {
        sb.append(str);
        sb.append(": ");
        sb.append(i7);
        sb.append(",\n");
    }

    private static float m(float f8, float f9, float f10, float f11) {
        boolean zIsNaN = Float.isNaN(f8);
        boolean zIsNaN2 = Float.isNaN(f9);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f8 = f10;
        }
        if (zIsNaN2) {
            f9 = f10;
        }
        return f8 + (f11 * (f9 - f8));
    }

    public static void n(int i7, int i8, r rVar, r rVar2, r rVar3, q qVar, float f8) {
        int i9;
        float f9;
        int i10;
        int i11;
        int i12;
        float f10;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f11 = 100.0f * f8;
        int i18 = (int) f11;
        int i19 = rVar2.f3394b;
        int i20 = rVar2.f3395c;
        int i21 = rVar3.f3394b;
        int i22 = rVar3.f3395c;
        int i23 = rVar2.f3396d - i19;
        int i24 = rVar2.f3397e - i20;
        int i25 = rVar3.f3396d - i21;
        int i26 = rVar3.f3397e - i22;
        float f12 = rVar2.f3408p;
        float f13 = rVar3.f3408p;
        if (rVar2.f3410r == 8) {
            i20 = (int) (i20 - (i26 / 2.0f));
            i11 = (int) (i19 - (i25 / 2.0f));
            if (Float.isNaN(f12)) {
                i10 = i26;
                i9 = i25;
                f9 = 0.0f;
            } else {
                f9 = f12;
                i9 = i25;
                i10 = i26;
            }
        } else {
            i9 = i23;
            f9 = f12;
            i10 = i24;
            i11 = i19;
        }
        if (rVar3.f3410r == 8) {
            i21 = (int) (i21 - (i9 / 2.0f));
            i22 = (int) (i22 - (i10 / 2.0f));
            i25 = i9;
            i26 = i10;
            if (Float.isNaN(f13)) {
                f13 = 0.0f;
            }
        }
        if (Float.isNaN(f9) && !Float.isNaN(f13)) {
            f9 = 1.0f;
        }
        if (!Float.isNaN(f9) && Float.isNaN(f13)) {
            f13 = 1.0f;
        }
        float f14 = rVar2.f3410r == 4 ? 0.0f : f9;
        float f15 = rVar3.f3410r == 4 ? 0.0f : f13;
        if (rVar.f3393a == null || !qVar.N()) {
            i12 = i20;
            f10 = f8;
            i13 = i11;
            i14 = i21;
        } else {
            q.a aVarX = qVar.x(rVar.f3393a.f3628o, i18);
            i12 = i20;
            q.a aVarW = qVar.w(rVar.f3393a.f3628o, i18);
            if (aVarX == aVarW) {
                aVarW = null;
            }
            if (aVarX != null) {
                i11 = (int) (aVarX.f3379d * i7);
                i15 = i8;
                i12 = (int) (aVarX.f3380e * i15);
                i16 = aVarX.f3376a;
            } else {
                i15 = i8;
                i16 = 0;
            }
            i13 = i11;
            if (aVarW != null) {
                int i27 = (int) (aVarW.f3379d * i7);
                int i28 = (int) (aVarW.f3380e * i15);
                i17 = aVarW.f3376a;
                i14 = i27;
                i22 = i28;
            } else {
                i17 = 100;
                i14 = i21;
            }
            f10 = (f11 - i16) / (i17 - i16);
        }
        int i29 = i12;
        rVar.f3393a = rVar2.f3393a;
        int i30 = (int) (i13 + ((i14 - i13) * f10));
        rVar.f3394b = i30;
        int i31 = (int) (i29 + (f10 * (i22 - i29)));
        rVar.f3395c = i31;
        float f16 = 1.0f - f8;
        rVar.f3396d = i30 + ((int) ((i9 * f16) + (i25 * f8)));
        rVar.f3397e = i31 + ((int) ((f16 * i10) + (i26 * f8)));
        rVar.f3398f = m(rVar2.f3398f, rVar3.f3398f, 0.5f, f8);
        rVar.f3399g = m(rVar2.f3399g, rVar3.f3399g, 0.5f, f8);
        rVar.f3400h = m(rVar2.f3400h, rVar3.f3400h, 0.0f, f8);
        rVar.f3401i = m(rVar2.f3401i, rVar3.f3401i, 0.0f, f8);
        rVar.f3402j = m(rVar2.f3402j, rVar3.f3402j, 0.0f, f8);
        rVar.f3406n = m(rVar2.f3406n, rVar3.f3406n, 1.0f, f8);
        rVar.f3407o = m(rVar2.f3407o, rVar3.f3407o, 1.0f, f8);
        rVar.f3403k = m(rVar2.f3403k, rVar3.f3403k, 0.0f, f8);
        rVar.f3404l = m(rVar2.f3404l, rVar3.f3404l, 0.0f, f8);
        rVar.f3405m = m(rVar2.f3405m, rVar3.f3405m, 0.0f, f8);
        rVar.f3408p = m(f14, f15, 1.0f, f8);
        Set<String> setKeySet = rVar3.f3411s.keySet();
        rVar.f3411s.clear();
        for (String str : setKeySet) {
            if (rVar2.f3411s.containsKey(str)) {
                androidx.constraintlayout.core.motion.b bVar = rVar2.f3411s.get(str);
                androidx.constraintlayout.core.motion.b bVar2 = rVar3.f3411s.get(str);
                androidx.constraintlayout.core.motion.b bVar3 = new androidx.constraintlayout.core.motion.b(bVar);
                rVar.f3411s.put(str, bVar3);
                if (bVar.r() == 1) {
                    bVar3.y(Float.valueOf(m(bVar.n(), bVar2.n(), 0.0f, f8)));
                } else {
                    int iR = bVar.r();
                    float[] fArr = new float[iR];
                    float[] fArr2 = new float[iR];
                    bVar.o(fArr);
                    bVar2.o(fArr2);
                    for (int i32 = 0; i32 < iR; i32++) {
                        fArr[i32] = m(fArr[i32], fArr2[i32], 0.0f, f8);
                        bVar3.z(fArr);
                    }
                }
            }
        }
    }

    private void u(StringBuilder sb, androidx.constraintlayout.core.widgets.d.b bVar) {
        androidx.constraintlayout.core.widgets.d dVarR = this.f3393a.r(bVar);
        if (dVarR == null || dVarR.f3558f == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(bVar.name());
        sb.append(": ['");
        String str = dVarR.f3558f.i().f3628o;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(dVarR.f3558f.l().name());
        sb.append("', '");
        sb.append(dVarR.f3559g);
        sb.append("'],\n");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean A(String str, androidx.constraintlayout.core.parser.c cVar) throws androidx.constraintlayout.core.parser.h {
        str.hashCode();
        byte b8 = -1;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    b8 = 0;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    b8 = 1;
                }
                break;
            case -1349088399:
                if (str.equals("custom")) {
                    b8 = 2;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    b8 = 3;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b8 = 4;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    b8 = 5;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b8 = 6;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b8 = 7;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b8 = 8;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    b8 = 9;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    b8 = 10;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 115029:
                if (str.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
            case 3317767:
                if (str.equals(ViewHierarchyConstants.DIMENSION_LEFT_KEY)) {
                    b8 = com.google.common.base.c.f19316p;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b8 = com.google.common.base.c.f19317q;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b8 = com.google.common.base.c.f19318r;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    b8 = 17;
                }
                break;
        }
        switch (b8) {
            case 0:
                f3392v = cVar.h();
                return true;
            case 1:
                this.f3397e = cVar.j();
                return true;
            case 2:
                q(cVar);
                return true;
            case 3:
                this.f3400h = cVar.h();
                return true;
            case 4:
                this.f3401i = cVar.h();
                return true;
            case 5:
                this.f3402j = cVar.h();
                return true;
            case 6:
                this.f3403k = cVar.h();
                return true;
            case 7:
                this.f3404l = cVar.h();
                return true;
            case 8:
                this.f3405m = cVar.h();
                return true;
            case 9:
                this.f3398f = cVar.h();
                return true;
            case 10:
                this.f3399g = cVar.h();
                return true;
            case 11:
                this.f3406n = cVar.h();
                return true;
            case 12:
                this.f3407o = cVar.h();
                return true;
            case 13:
                this.f3395c = cVar.j();
                return true;
            case 14:
                this.f3394b = cVar.j();
                return true;
            case 15:
                this.f3408p = cVar.h();
                return true;
            case 16:
                this.f3396d = cVar.j();
                return true;
            case 17:
                this.f3409q = cVar.h();
                return true;
            default:
                return false;
        }
    }

    public r B() {
        androidx.constraintlayout.core.widgets.e eVar = this.f3393a;
        if (eVar != null) {
            this.f3394b = eVar.L();
            this.f3395c = this.f3393a.e0();
            this.f3396d = this.f3393a.X();
            this.f3397e = this.f3393a.v();
            D(this.f3393a.f3626n);
        }
        return this;
    }

    public r C(androidx.constraintlayout.core.widgets.e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f3393a = eVar;
        B();
        return this;
    }

    public void D(r rVar) {
        this.f3398f = rVar.f3398f;
        this.f3399g = rVar.f3399g;
        this.f3400h = rVar.f3400h;
        this.f3401i = rVar.f3401i;
        this.f3402j = rVar.f3402j;
        this.f3403k = rVar.f3403k;
        this.f3404l = rVar.f3404l;
        this.f3405m = rVar.f3405m;
        this.f3406n = rVar.f3406n;
        this.f3407o = rVar.f3407o;
        this.f3408p = rVar.f3408p;
        this.f3410r = rVar.f3410r;
        this.f3411s.clear();
        for (androidx.constraintlayout.core.motion.b bVar : rVar.f3411s.values()) {
            this.f3411s.put(bVar.k(), bVar.d());
        }
    }

    public int E() {
        return Math.max(0, this.f3396d - this.f3394b);
    }

    public void c(String str, int i7) {
        w(str, w.b.f3037l, i7);
    }

    public void d(String str, float f8) {
        v(str, w.b.f3036k, f8);
    }

    public float e() {
        int i7 = this.f3394b;
        return i7 + ((this.f3396d - i7) / 2.0f);
    }

    public float f() {
        int i7 = this.f3395c;
        return i7 + ((this.f3397e - i7) / 2.0f);
    }

    public androidx.constraintlayout.core.motion.b g(String str) {
        return this.f3411s.get(str);
    }

    public Set<String> h() {
        return this.f3411s.keySet();
    }

    public int i(String str) {
        if (this.f3411s.containsKey(str)) {
            return this.f3411s.get(str).g();
        }
        return -21880;
    }

    public float j(String str) {
        if (this.f3411s.containsKey(str)) {
            return this.f3411s.get(str).h();
        }
        return Float.NaN;
    }

    public String k() {
        androidx.constraintlayout.core.widgets.e eVar = this.f3393a;
        return eVar == null ? "unknown" : eVar.f3628o;
    }

    public int l() {
        return Math.max(0, this.f3397e - this.f3395c);
    }

    public boolean o() {
        return Float.isNaN(this.f3400h) && Float.isNaN(this.f3401i) && Float.isNaN(this.f3402j) && Float.isNaN(this.f3403k) && Float.isNaN(this.f3404l) && Float.isNaN(this.f3405m) && Float.isNaN(this.f3406n) && Float.isNaN(this.f3407o) && Float.isNaN(this.f3408p);
    }

    void p(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.f3393a != null) {
            str2 = str3 + "/" + (this.f3393a.hashCode() % 1000);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + " " + str);
    }

    void q(androidx.constraintlayout.core.parser.c cVar) throws androidx.constraintlayout.core.parser.h {
        androidx.constraintlayout.core.parser.f fVar = (androidx.constraintlayout.core.parser.f) cVar;
        int size = fVar.size();
        for (int i7 = 0; i7 < size; i7++) {
            androidx.constraintlayout.core.parser.d dVar = (androidx.constraintlayout.core.parser.d) fVar.A(i7);
            dVar.b();
            androidx.constraintlayout.core.parser.c cVarF0 = dVar.f0();
            String strB = cVarF0.b();
            if (strB.matches("#[0-9a-fA-F]+")) {
                w(dVar.b(), w.b.f3037l, Integer.parseInt(strB.substring(1), 16));
            } else if (cVarF0 instanceof androidx.constraintlayout.core.parser.e) {
                v(dVar.b(), w.b.f3036k, cVarF0.h());
            } else {
                x(dVar.b(), w.b.f3038m, strB);
            }
        }
    }

    void r() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        String str2 = this.f3393a != null ? str + "/" + (this.f3393a.hashCode() % 1000) + " " : str + "/NULL ";
        HashMap<String, androidx.constraintlayout.core.motion.b> map = this.f3411s;
        if (map != null) {
            for (String str3 : map.keySet()) {
                System.out.println(str2 + this.f3411s.get(str3).toString());
            }
        }
    }

    public StringBuilder s(StringBuilder sb) {
        return t(sb, false);
    }

    public StringBuilder t(StringBuilder sb, boolean z7) {
        sb.append("{\n");
        b(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.f3394b);
        b(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.f3395c);
        b(sb, "right", this.f3396d);
        b(sb, "bottom", this.f3397e);
        a(sb, "pivotX", this.f3398f);
        a(sb, "pivotY", this.f3399g);
        a(sb, "rotationX", this.f3400h);
        a(sb, "rotationY", this.f3401i);
        a(sb, "rotationZ", this.f3402j);
        a(sb, "translationX", this.f3403k);
        a(sb, "translationY", this.f3404l);
        a(sb, "translationZ", this.f3405m);
        a(sb, "scaleX", this.f3406n);
        a(sb, "scaleY", this.f3407o);
        a(sb, "alpha", this.f3408p);
        b(sb, "visibility", this.f3410r);
        a(sb, "interpolatedPos", this.f3409q);
        if (this.f3393a != null) {
            for (androidx.constraintlayout.core.widgets.d.b bVar : androidx.constraintlayout.core.widgets.d.b.values()) {
                u(sb, bVar);
            }
        }
        if (z7) {
            a(sb, "phone_orientation", f3392v);
        }
        if (z7) {
            a(sb, "phone_orientation", f3392v);
        }
        if (this.f3411s.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.f3411s.keySet()) {
                androidx.constraintlayout.core.motion.b bVar2 = this.f3411s.get(str);
                sb.append(str);
                sb.append(": ");
                switch (bVar2.m()) {
                    case w.b.f3035j /* 900 */:
                        sb.append(bVar2.i());
                        sb.append(",\n");
                        break;
                    case w.b.f3036k /* 901 */:
                    case w.b.f3040o /* 905 */:
                        sb.append(bVar2.h());
                        sb.append(",\n");
                        break;
                    case w.b.f3037l /* 902 */:
                        sb.append("'");
                        sb.append(androidx.constraintlayout.core.motion.b.c(bVar2.i()));
                        sb.append("',\n");
                        break;
                    case w.b.f3038m /* 903 */:
                        sb.append("'");
                        sb.append(bVar2.l());
                        sb.append("',\n");
                        break;
                    case w.b.f3039n /* 904 */:
                        sb.append("'");
                        sb.append(bVar2.f());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void v(String str, int i7, float f8) {
        if (this.f3411s.containsKey(str)) {
            this.f3411s.get(str).u(f8);
        } else {
            this.f3411s.put(str, new androidx.constraintlayout.core.motion.b(str, i7, f8));
        }
    }

    public void w(String str, int i7, int i8) {
        if (this.f3411s.containsKey(str)) {
            this.f3411s.get(str).v(i8);
        } else {
            this.f3411s.put(str, new androidx.constraintlayout.core.motion.b(str, i7, i8));
        }
    }

    public void x(String str, int i7, String str2) {
        if (this.f3411s.containsKey(str)) {
            this.f3411s.get(str).x(str2);
        } else {
            this.f3411s.put(str, new androidx.constraintlayout.core.motion.b(str, i7, str2));
        }
    }

    public void y(String str, int i7, boolean z7) {
        if (this.f3411s.containsKey(str)) {
            this.f3411s.get(str).t(z7);
        } else {
            this.f3411s.put(str, new androidx.constraintlayout.core.motion.b(str, i7, z7));
        }
    }

    public void z(androidx.constraintlayout.core.motion.a aVar, float[] fArr) {
    }

    public r(androidx.constraintlayout.core.widgets.e eVar) {
        this.f3393a = null;
        this.f3394b = 0;
        this.f3395c = 0;
        this.f3396d = 0;
        this.f3397e = 0;
        this.f3398f = Float.NaN;
        this.f3399g = Float.NaN;
        this.f3400h = Float.NaN;
        this.f3401i = Float.NaN;
        this.f3402j = Float.NaN;
        this.f3403k = Float.NaN;
        this.f3404l = Float.NaN;
        this.f3405m = Float.NaN;
        this.f3406n = Float.NaN;
        this.f3407o = Float.NaN;
        this.f3408p = Float.NaN;
        this.f3409q = Float.NaN;
        this.f3410r = 0;
        this.f3411s = new HashMap<>();
        this.f3412t = null;
        this.f3393a = eVar;
    }

    public r(r rVar) {
        this.f3393a = null;
        this.f3394b = 0;
        this.f3395c = 0;
        this.f3396d = 0;
        this.f3397e = 0;
        this.f3398f = Float.NaN;
        this.f3399g = Float.NaN;
        this.f3400h = Float.NaN;
        this.f3401i = Float.NaN;
        this.f3402j = Float.NaN;
        this.f3403k = Float.NaN;
        this.f3404l = Float.NaN;
        this.f3405m = Float.NaN;
        this.f3406n = Float.NaN;
        this.f3407o = Float.NaN;
        this.f3408p = Float.NaN;
        this.f3409q = Float.NaN;
        this.f3410r = 0;
        this.f3411s = new HashMap<>();
        this.f3412t = null;
        this.f3393a = rVar.f3393a;
        this.f3394b = rVar.f3394b;
        this.f3395c = rVar.f3395c;
        this.f3396d = rVar.f3396d;
        this.f3397e = rVar.f3397e;
        D(rVar);
    }
}
