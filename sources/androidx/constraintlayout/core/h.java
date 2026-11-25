package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.constraintlayout.core.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f2449o = 1.0E-4f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final boolean f2450p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final int f2451q = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i[] f2453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private i[] f2454k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    b f2456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    c f2457n;

    class a implements Comparator<i> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f2473c - iVar2.f2473c;
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f2459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h f2460b;

        public b(h hVar) {
            this.f2460b = hVar;
        }

        public void a(i iVar) {
            for (int i7 = 0; i7 < 9; i7++) {
                float[] fArr = this.f2459a.f2479i;
                float f8 = fArr[i7] + iVar.f2479i[i7];
                fArr[i7] = f8;
                if (Math.abs(f8) < 1.0E-4f) {
                    this.f2459a.f2479i[i7] = 0.0f;
                }
            }
        }

        public boolean b(i iVar, float f8) {
            boolean z7 = true;
            if (!this.f2459a.f2471a) {
                for (int i7 = 0; i7 < 9; i7++) {
                    float f9 = iVar.f2479i[i7];
                    if (f9 != 0.0f) {
                        float f10 = f9 * f8;
                        if (Math.abs(f10) < 1.0E-4f) {
                            f10 = 0.0f;
                        }
                        this.f2459a.f2479i[i7] = f10;
                    } else {
                        this.f2459a.f2479i[i7] = 0.0f;
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < 9; i8++) {
                float[] fArr = this.f2459a.f2479i;
                float f11 = fArr[i8] + (iVar.f2479i[i8] * f8);
                fArr[i8] = f11;
                if (Math.abs(f11) < 1.0E-4f) {
                    this.f2459a.f2479i[i8] = 0.0f;
                } else {
                    z7 = false;
                }
            }
            if (z7) {
                h.this.J(this.f2459a);
            }
            return false;
        }

        public void c(i iVar) {
            this.f2459a = iVar;
        }

        public final boolean d() {
            for (int i7 = 8; i7 >= 0; i7--) {
                float f8 = this.f2459a.f2479i[i7];
                if (f8 > 0.0f) {
                    return false;
                }
                if (f8 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean e() {
            for (int i7 = 0; i7 < 9; i7++) {
                if (this.f2459a.f2479i[i7] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean f(i iVar) {
            for (int i7 = 8; i7 >= 0; i7--) {
                float f8 = iVar.f2479i[i7];
                float f9 = this.f2459a.f2479i[i7];
                if (f9 != f8) {
                    if (f9 < f8) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void g() {
            Arrays.fill(this.f2459a.f2479i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f2459a != null) {
                for (int i7 = 0; i7 < 9; i7++) {
                    str = str + this.f2459a.f2479i[i7] + " ";
                }
            }
            return str + "] " + this.f2459a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f2452i = 128;
        this.f2453j = new i[128];
        this.f2454k = new i[128];
        this.f2455l = 0;
        this.f2456m = new b(this);
        this.f2457n = cVar;
    }

    private final void I(i iVar) {
        int i7;
        int i8 = this.f2455l + 1;
        i[] iVarArr = this.f2453j;
        if (i8 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f2453j = iVarArr2;
            this.f2454k = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f2453j;
        int i9 = this.f2455l;
        iVarArr3[i9] = iVar;
        int i10 = i9 + 1;
        this.f2455l = i10;
        if (i10 > 1 && iVarArr3[i10 - 1].f2473c > iVar.f2473c) {
            int i11 = 0;
            while (true) {
                i7 = this.f2455l;
                if (i11 >= i7) {
                    break;
                }
                this.f2454k[i11] = this.f2453j[i11];
                i11++;
            }
            Arrays.sort(this.f2454k, 0, i7, new a());
            for (int i12 = 0; i12 < this.f2455l; i12++) {
                this.f2453j[i12] = this.f2454k[i12];
            }
        }
        iVar.f2471a = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(i iVar) {
        int i7 = 0;
        while (i7 < this.f2455l) {
            if (this.f2453j[i7] == iVar) {
                while (true) {
                    int i8 = this.f2455l;
                    if (i7 >= i8 - 1) {
                        this.f2455l = i8 - 1;
                        iVar.f2471a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f2453j;
                        int i9 = i7 + 1;
                        iVarArr[i7] = iVarArr[i9];
                        i7 = i9;
                    }
                }
            } else {
                i7++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.e.a
    public void c(e eVar, androidx.constraintlayout.core.b bVar, boolean z7) {
        i iVar = bVar.f2382a;
        if (iVar == null) {
            return;
        }
        androidx.constraintlayout.core.b.a aVar = bVar.f2386e;
        int iB = aVar.b();
        for (int i7 = 0; i7 < iB; i7++) {
            i iVarH = aVar.h(i7);
            float fK = aVar.k(i7);
            this.f2456m.c(iVarH);
            if (this.f2456m.b(iVar, fK)) {
                I(iVarH);
            }
            this.f2383b += bVar.f2383b * fK;
        }
        J(iVar);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.e.a
    public void clear() {
        this.f2455l = 0;
        this.f2383b = 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.e.a
    public i e(e eVar, boolean[] zArr) {
        int i7 = -1;
        for (int i8 = 0; i8 < this.f2455l; i8++) {
            i iVar = this.f2453j[i8];
            if (!zArr[iVar.f2473c]) {
                this.f2456m.c(iVar);
                if (i7 == -1) {
                    if (this.f2456m.d()) {
                        i7 = i8;
                    }
                } else if (this.f2456m.f(this.f2453j[i7])) {
                    i7 = i8;
                }
            }
        }
        if (i7 == -1) {
            return null;
        }
        return this.f2453j[i7];
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.e.a
    public void f(i iVar) {
        this.f2456m.c(iVar);
        this.f2456m.g();
        iVar.f2479i[iVar.f2475e] = 1.0f;
        I(iVar);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.e.a
    public boolean isEmpty() {
        return this.f2455l == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f2383b + ") : ";
        for (int i7 = 0; i7 < this.f2455l; i7++) {
            this.f2456m.c(this.f2453j[i7]);
            str = str + this.f2456m + " ";
        }
        return str;
    }
}
