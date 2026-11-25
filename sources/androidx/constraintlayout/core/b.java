package androidx.constraintlayout.core;

import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b implements e.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f2380g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f2381h = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f2386e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i f2382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f2383b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f2384c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ArrayList<i> f2385d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f2387f = false;

    public interface a {
        int b();

        int c(i iVar);

        void clear();

        void d();

        boolean e(i iVar);

        float f(b bVar, boolean z7);

        void g(i iVar, float f8);

        i h(int i7);

        void i(i iVar, float f8, boolean z7);

        void j();

        float k(int i7);

        float l(i iVar, boolean z7);

        float m(i iVar);

        int n();

        void o(float f8);
    }

    public b() {
    }

    private i B(boolean[] zArr, i iVar) {
        i.b bVar;
        int iB = this.f2386e.b();
        i iVar2 = null;
        float f8 = 0.0f;
        for (int i7 = 0; i7 < iB; i7++) {
            float fK = this.f2386e.k(i7);
            if (fK < 0.0f) {
                i iVarH = this.f2386e.h(i7);
                if ((zArr == null || !zArr[iVarH.f2473c]) && iVarH != iVar && (((bVar = iVarH.f2480j) == i.b.SLACK || bVar == i.b.ERROR) && fK < f8)) {
                    f8 = fK;
                    iVar2 = iVarH;
                }
            }
        }
        return iVar2;
    }

    private boolean z(i iVar, e eVar) {
        return iVar.f2483m <= 1;
    }

    public i A(i iVar) {
        return B(null, iVar);
    }

    void C(i iVar) {
        i iVar2 = this.f2382a;
        if (iVar2 != null) {
            this.f2386e.g(iVar2, -1.0f);
            this.f2382a.f2474d = -1;
            this.f2382a = null;
        }
        float fL = this.f2386e.l(iVar, true) * (-1.0f);
        this.f2382a = iVar;
        if (fL == 1.0f) {
            return;
        }
        this.f2383b /= fL;
        this.f2386e.o(fL);
    }

    public void D() {
        this.f2382a = null;
        this.f2386e.clear();
        this.f2383b = 0.0f;
        this.f2387f = false;
    }

    int E() {
        return (this.f2382a != null ? 4 : 0) + 4 + 4 + this.f2386e.n();
    }

    String F() {
        boolean z7;
        String str = (this.f2382a == null ? "0" : "" + this.f2382a) + " = ";
        if (this.f2383b != 0.0f) {
            str = str + this.f2383b;
            z7 = true;
        } else {
            z7 = false;
        }
        int iB = this.f2386e.b();
        for (int i7 = 0; i7 < iB; i7++) {
            i iVarH = this.f2386e.h(i7);
            if (iVarH != null) {
                float fK = this.f2386e.k(i7);
                if (fK != 0.0f) {
                    String string = iVarH.toString();
                    if (z7) {
                        if (fK > 0.0f) {
                            str = str + " + ";
                        } else {
                            str = str + " - ";
                            fK *= -1.0f;
                        }
                    } else if (fK < 0.0f) {
                        str = str + "- ";
                        fK *= -1.0f;
                    }
                    str = fK == 1.0f ? str + string : str + fK + " " + string;
                    z7 = true;
                }
            }
        }
        if (z7) {
            return str;
        }
        return str + "0.0";
    }

    public void G(e eVar, i iVar, boolean z7) {
        if (iVar == null || !iVar.f2484n) {
            return;
        }
        float fM = this.f2386e.m(iVar);
        this.f2383b += iVar.f2486p * fM;
        this.f2386e.l(iVar, z7);
        if (z7) {
            iVar.g(this);
        }
        this.f2386e.i(eVar.f2414n.f2391d[iVar.f2485o], fM, z7);
        if (e.f2398x && this.f2386e.b() == 0) {
            this.f2387f = true;
            eVar.f2401a = true;
        }
    }

    @Override // androidx.constraintlayout.core.e.a
    public void a(e eVar, i iVar, boolean z7) {
        if (iVar == null || !iVar.f2477g) {
            return;
        }
        this.f2383b += iVar.f2476f * this.f2386e.m(iVar);
        this.f2386e.l(iVar, z7);
        if (z7) {
            iVar.g(this);
        }
        if (e.f2398x && this.f2386e.b() == 0) {
            this.f2387f = true;
            eVar.f2401a = true;
        }
    }

    @Override // androidx.constraintlayout.core.e.a
    public void b(e eVar) {
        if (eVar.f2407g.length == 0) {
            return;
        }
        boolean z7 = false;
        while (!z7) {
            int iB = this.f2386e.b();
            for (int i7 = 0; i7 < iB; i7++) {
                i iVarH = this.f2386e.h(i7);
                if (iVarH.f2474d != -1 || iVarH.f2477g || iVarH.f2484n) {
                    this.f2385d.add(iVarH);
                }
            }
            int size = this.f2385d.size();
            if (size > 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    i iVar = this.f2385d.get(i8);
                    if (iVar.f2477g) {
                        a(eVar, iVar, true);
                    } else if (iVar.f2484n) {
                        G(eVar, iVar, true);
                    } else {
                        c(eVar, eVar.f2407g[iVar.f2474d], true);
                    }
                }
                this.f2385d.clear();
            } else {
                z7 = true;
            }
        }
        if (e.f2398x && this.f2382a != null && this.f2386e.b() == 0) {
            this.f2387f = true;
            eVar.f2401a = true;
        }
    }

    @Override // androidx.constraintlayout.core.e.a
    public void c(e eVar, b bVar, boolean z7) {
        this.f2383b += bVar.f2383b * this.f2386e.f(bVar, z7);
        if (z7) {
            bVar.f2382a.g(this);
        }
        if (e.f2398x && this.f2382a != null && this.f2386e.b() == 0) {
            this.f2387f = true;
            eVar.f2401a = true;
        }
    }

    @Override // androidx.constraintlayout.core.e.a
    public void clear() {
        this.f2386e.clear();
        this.f2382a = null;
        this.f2383b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.e.a
    public void d(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2382a = null;
            this.f2386e.clear();
            for (int i7 = 0; i7 < bVar.f2386e.b(); i7++) {
                this.f2386e.i(bVar.f2386e.h(i7), bVar.f2386e.k(i7), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.e.a
    public i e(e eVar, boolean[] zArr) {
        return B(zArr, null);
    }

    @Override // androidx.constraintlayout.core.e.a
    public void f(i iVar) {
        int i7 = iVar.f2475e;
        float f8 = 1.0f;
        if (i7 != 1) {
            if (i7 == 2) {
                f8 = 1000.0f;
            } else if (i7 == 3) {
                f8 = 1000000.0f;
            } else if (i7 == 4) {
                f8 = 1.0E9f;
            } else if (i7 == 5) {
                f8 = 1.0E12f;
            }
        }
        this.f2386e.g(iVar, f8);
    }

    public b g(e eVar, int i7) {
        this.f2386e.g(eVar.s(i7, "ep"), 1.0f);
        this.f2386e.g(eVar.s(i7, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.core.e.a
    public i getKey() {
        return this.f2382a;
    }

    b h(i iVar, int i7) {
        this.f2386e.g(iVar, i7);
        return this;
    }

    boolean i(e eVar) {
        boolean z7;
        i iVarJ = j(eVar);
        if (iVarJ == null) {
            z7 = true;
        } else {
            C(iVarJ);
            z7 = false;
        }
        if (this.f2386e.b() == 0) {
            this.f2387f = true;
        }
        return z7;
    }

    @Override // androidx.constraintlayout.core.e.a
    public boolean isEmpty() {
        return this.f2382a == null && this.f2383b == 0.0f && this.f2386e.b() == 0;
    }

    i j(e eVar) {
        int iB = this.f2386e.b();
        i iVar = null;
        float f8 = 0.0f;
        float f9 = 0.0f;
        boolean z7 = false;
        boolean z8 = false;
        i iVar2 = null;
        for (int i7 = 0; i7 < iB; i7++) {
            float fK = this.f2386e.k(i7);
            i iVarH = this.f2386e.h(i7);
            if (iVarH.f2480j == i.b.UNRESTRICTED) {
                if (iVar == null || f8 > fK) {
                    boolean z9 = z(iVarH, eVar);
                    z7 = z9;
                    f8 = fK;
                    iVar = iVarH;
                } else if (!z7 && z(iVarH, eVar)) {
                    f8 = fK;
                    iVar = iVarH;
                    z7 = true;
                }
            } else if (iVar == null && fK < 0.0f) {
                if (iVar2 == null || f9 > fK) {
                    boolean z10 = z(iVarH, eVar);
                    z8 = z10;
                    f9 = fK;
                    iVar2 = iVarH;
                } else if (!z8 && z(iVarH, eVar)) {
                    f9 = fK;
                    iVar2 = iVarH;
                    z8 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    b k(i iVar, i iVar2, int i7, float f8, i iVar3, i iVar4, int i8) {
        if (iVar2 == iVar3) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar4, 1.0f);
            this.f2386e.g(iVar2, -2.0f);
            return this;
        }
        if (f8 == 0.5f) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar3, -1.0f);
            this.f2386e.g(iVar4, 1.0f);
            if (i7 > 0 || i8 > 0) {
                this.f2383b = (-i7) + i8;
            }
        } else if (f8 <= 0.0f) {
            this.f2386e.g(iVar, -1.0f);
            this.f2386e.g(iVar2, 1.0f);
            this.f2383b = i7;
        } else if (f8 >= 1.0f) {
            this.f2386e.g(iVar4, -1.0f);
            this.f2386e.g(iVar3, 1.0f);
            this.f2383b = -i8;
        } else {
            float f9 = 1.0f - f8;
            this.f2386e.g(iVar, f9 * 1.0f);
            this.f2386e.g(iVar2, f9 * (-1.0f));
            this.f2386e.g(iVar3, (-1.0f) * f8);
            this.f2386e.g(iVar4, 1.0f * f8);
            if (i7 > 0 || i8 > 0) {
                this.f2383b = ((-i7) * f9) + (i8 * f8);
            }
        }
        return this;
    }

    b l(i iVar, int i7) {
        this.f2382a = iVar;
        float f8 = i7;
        iVar.f2476f = f8;
        this.f2383b = f8;
        this.f2387f = true;
        return this;
    }

    b m(i iVar, i iVar2, float f8) {
        this.f2386e.g(iVar, -1.0f);
        this.f2386e.g(iVar2, f8);
        return this;
    }

    public b n(i iVar, i iVar2, i iVar3, i iVar4, float f8) {
        this.f2386e.g(iVar, -1.0f);
        this.f2386e.g(iVar2, 1.0f);
        this.f2386e.g(iVar3, f8);
        this.f2386e.g(iVar4, -f8);
        return this;
    }

    public b o(float f8, float f9, float f10, i iVar, int i7, i iVar2, int i8, i iVar3, int i9, i iVar4, int i10) {
        if (f9 == 0.0f || f8 == f10) {
            this.f2383b = ((-i7) - i8) + i9 + i10;
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar4, 1.0f);
            this.f2386e.g(iVar3, -1.0f);
        } else {
            float f11 = (f8 / f9) / (f10 / f9);
            this.f2383b = ((-i7) - i8) + (i9 * f11) + (i10 * f11);
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar4, f11);
            this.f2386e.g(iVar3, -f11);
        }
        return this;
    }

    public b p(float f8, float f9, float f10, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f2383b = 0.0f;
        if (f9 == 0.0f || f8 == f10) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar4, 1.0f);
            this.f2386e.g(iVar3, -1.0f);
        } else if (f8 == 0.0f) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
        } else if (f10 == 0.0f) {
            this.f2386e.g(iVar3, 1.0f);
            this.f2386e.g(iVar4, -1.0f);
        } else {
            float f11 = (f8 / f9) / (f10 / f9);
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar4, f11);
            this.f2386e.g(iVar3, -f11);
        }
        return this;
    }

    public b q(i iVar, int i7) {
        if (i7 < 0) {
            this.f2383b = i7 * (-1);
            this.f2386e.g(iVar, 1.0f);
        } else {
            this.f2383b = i7;
            this.f2386e.g(iVar, -1.0f);
        }
        return this;
    }

    public b r(i iVar, i iVar2, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f2383b = i7;
        }
        if (z7) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
        } else {
            this.f2386e.g(iVar, -1.0f);
            this.f2386e.g(iVar2, 1.0f);
        }
        return this;
    }

    public b s(i iVar, int i7, i iVar2) {
        this.f2383b = i7;
        this.f2386e.g(iVar, -1.0f);
        return this;
    }

    public b t(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f2383b = i7;
        }
        if (z7) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar3, -1.0f);
        } else {
            this.f2386e.g(iVar, -1.0f);
            this.f2386e.g(iVar2, 1.0f);
            this.f2386e.g(iVar3, 1.0f);
        }
        return this;
    }

    public String toString() {
        return F();
    }

    public b u(i iVar, i iVar2, i iVar3, int i7) {
        boolean z7 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z7 = true;
            }
            this.f2383b = i7;
        }
        if (z7) {
            this.f2386e.g(iVar, 1.0f);
            this.f2386e.g(iVar2, -1.0f);
            this.f2386e.g(iVar3, 1.0f);
        } else {
            this.f2386e.g(iVar, -1.0f);
            this.f2386e.g(iVar2, 1.0f);
            this.f2386e.g(iVar3, -1.0f);
        }
        return this;
    }

    public b v(i iVar, i iVar2, i iVar3, i iVar4, float f8) {
        this.f2386e.g(iVar3, 0.5f);
        this.f2386e.g(iVar4, 0.5f);
        this.f2386e.g(iVar, -0.5f);
        this.f2386e.g(iVar2, -0.5f);
        this.f2383b = -f8;
        return this;
    }

    void w() {
        float f8 = this.f2383b;
        if (f8 < 0.0f) {
            this.f2383b = f8 * (-1.0f);
            this.f2386e.j();
        }
    }

    boolean x() {
        i iVar = this.f2382a;
        return iVar != null && (iVar.f2480j == i.b.UNRESTRICTED || this.f2383b >= 0.0f);
    }

    boolean y(i iVar) {
        return this.f2386e.e(iVar);
    }

    public b(c cVar) {
        this.f2386e = new androidx.constraintlayout.core.a(this, cVar);
    }
}
