package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final boolean f2365l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f2366m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final boolean f2367n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static float f2368o = 0.001f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f2371c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2369a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2372d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f2373e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f2374f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f2375g = new int[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f2376h = new float[8];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2377i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2378j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2379k = false;

    a(b bVar, c cVar) {
        this.f2370b = bVar;
        this.f2371c = cVar;
    }

    public int a() {
        return this.f2377i;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int b() {
        return this.f2369a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int c(i iVar) {
        int i7 = this.f2377i;
        if (i7 == -1) {
            return -1;
        }
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            if (this.f2374f[i7] == iVar.f2473c) {
                return i7;
            }
            i7 = this.f2375g[i7];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i7 = this.f2377i;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            i iVar = this.f2371c.f2391d[this.f2374f[i7]];
            if (iVar != null) {
                iVar.g(this.f2370b);
            }
            i7 = this.f2375g[i7];
        }
        this.f2377i = -1;
        this.f2378j = -1;
        this.f2379k = false;
        this.f2369a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i7 = this.f2369a;
        System.out.print("{ ");
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarH = h(i8);
            if (iVarH != null) {
                System.out.print(iVarH + " = " + k(i8) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean e(i iVar) {
        int i7 = this.f2377i;
        if (i7 == -1) {
            return false;
        }
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            if (this.f2374f[i7] == iVar.f2473c) {
                return true;
            }
            i7 = this.f2375g[i7];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z7) {
        float fM = m(bVar.f2382a);
        l(bVar.f2382a, z7);
        b.a aVar = bVar.f2386e;
        int iB = aVar.b();
        for (int i7 = 0; i7 < iB; i7++) {
            i iVarH = aVar.h(i7);
            i(iVarH, aVar.m(iVarH) * fM, z7);
        }
        return fM;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void g(i iVar, float f8) {
        if (f8 == 0.0f) {
            l(iVar, true);
            return;
        }
        int i7 = this.f2377i;
        if (i7 == -1) {
            this.f2377i = 0;
            this.f2376h[0] = f8;
            this.f2374f[0] = iVar.f2473c;
            this.f2375g[0] = -1;
            iVar.f2483m++;
            iVar.a(this.f2370b);
            this.f2369a++;
            if (this.f2379k) {
                return;
            }
            int i8 = this.f2378j + 1;
            this.f2378j = i8;
            int[] iArr = this.f2374f;
            if (i8 >= iArr.length) {
                this.f2379k = true;
                this.f2378j = iArr.length - 1;
                return;
            }
            return;
        }
        int i9 = -1;
        for (int i10 = 0; i7 != -1 && i10 < this.f2369a; i10++) {
            int i11 = this.f2374f[i7];
            int i12 = iVar.f2473c;
            if (i11 == i12) {
                this.f2376h[i7] = f8;
                return;
            }
            if (i11 < i12) {
                i9 = i7;
            }
            i7 = this.f2375g[i7];
        }
        int length = this.f2378j;
        int i13 = length + 1;
        if (this.f2379k) {
            int[] iArr2 = this.f2374f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i13;
        }
        int[] iArr3 = this.f2374f;
        if (length >= iArr3.length && this.f2369a < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.f2374f;
                if (i14 >= iArr4.length) {
                    break;
                }
                if (iArr4[i14] == -1) {
                    length = i14;
                    break;
                }
                i14++;
            }
        }
        int[] iArr5 = this.f2374f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i15 = this.f2372d * 2;
            this.f2372d = i15;
            this.f2379k = false;
            this.f2378j = length - 1;
            this.f2376h = Arrays.copyOf(this.f2376h, i15);
            this.f2374f = Arrays.copyOf(this.f2374f, this.f2372d);
            this.f2375g = Arrays.copyOf(this.f2375g, this.f2372d);
        }
        this.f2374f[length] = iVar.f2473c;
        this.f2376h[length] = f8;
        if (i9 != -1) {
            int[] iArr6 = this.f2375g;
            iArr6[length] = iArr6[i9];
            iArr6[i9] = length;
        } else {
            this.f2375g[length] = this.f2377i;
            this.f2377i = length;
        }
        iVar.f2483m++;
        iVar.a(this.f2370b);
        int i16 = this.f2369a + 1;
        this.f2369a = i16;
        if (!this.f2379k) {
            this.f2378j++;
        }
        int[] iArr7 = this.f2374f;
        if (i16 >= iArr7.length) {
            this.f2379k = true;
        }
        if (this.f2378j >= iArr7.length) {
            this.f2379k = true;
            this.f2378j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public i h(int i7) {
        int i8 = this.f2377i;
        for (int i9 = 0; i8 != -1 && i9 < this.f2369a; i9++) {
            if (i9 == i7) {
                return this.f2371c.f2391d[this.f2374f[i8]];
            }
            i8 = this.f2375g[i8];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void i(i iVar, float f8, boolean z7) {
        float f9 = f2368o;
        if (f8 <= (-f9) || f8 >= f9) {
            int i7 = this.f2377i;
            if (i7 == -1) {
                this.f2377i = 0;
                this.f2376h[0] = f8;
                this.f2374f[0] = iVar.f2473c;
                this.f2375g[0] = -1;
                iVar.f2483m++;
                iVar.a(this.f2370b);
                this.f2369a++;
                if (this.f2379k) {
                    return;
                }
                int i8 = this.f2378j + 1;
                this.f2378j = i8;
                int[] iArr = this.f2374f;
                if (i8 >= iArr.length) {
                    this.f2379k = true;
                    this.f2378j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i9 = -1;
            for (int i10 = 0; i7 != -1 && i10 < this.f2369a; i10++) {
                int i11 = this.f2374f[i7];
                int i12 = iVar.f2473c;
                if (i11 == i12) {
                    float[] fArr = this.f2376h;
                    float f10 = fArr[i7] + f8;
                    float f11 = f2368o;
                    if (f10 > (-f11) && f10 < f11) {
                        f10 = 0.0f;
                    }
                    fArr[i7] = f10;
                    if (f10 == 0.0f) {
                        if (i7 == this.f2377i) {
                            this.f2377i = this.f2375g[i7];
                        } else {
                            int[] iArr2 = this.f2375g;
                            iArr2[i9] = iArr2[i7];
                        }
                        if (z7) {
                            iVar.g(this.f2370b);
                        }
                        if (this.f2379k) {
                            this.f2378j = i7;
                        }
                        iVar.f2483m--;
                        this.f2369a--;
                        return;
                    }
                    return;
                }
                if (i11 < i12) {
                    i9 = i7;
                }
                i7 = this.f2375g[i7];
            }
            int length = this.f2378j;
            int i13 = length + 1;
            if (this.f2379k) {
                int[] iArr3 = this.f2374f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i13;
            }
            int[] iArr4 = this.f2374f;
            if (length >= iArr4.length && this.f2369a < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.f2374f;
                    if (i14 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i14] == -1) {
                        length = i14;
                        break;
                    }
                    i14++;
                }
            }
            int[] iArr6 = this.f2374f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i15 = this.f2372d * 2;
                this.f2372d = i15;
                this.f2379k = false;
                this.f2378j = length - 1;
                this.f2376h = Arrays.copyOf(this.f2376h, i15);
                this.f2374f = Arrays.copyOf(this.f2374f, this.f2372d);
                this.f2375g = Arrays.copyOf(this.f2375g, this.f2372d);
            }
            this.f2374f[length] = iVar.f2473c;
            this.f2376h[length] = f8;
            if (i9 != -1) {
                int[] iArr7 = this.f2375g;
                iArr7[length] = iArr7[i9];
                iArr7[i9] = length;
            } else {
                this.f2375g[length] = this.f2377i;
                this.f2377i = length;
            }
            iVar.f2483m++;
            iVar.a(this.f2370b);
            this.f2369a++;
            if (!this.f2379k) {
                this.f2378j++;
            }
            int i16 = this.f2378j;
            int[] iArr8 = this.f2374f;
            if (i16 >= iArr8.length) {
                this.f2379k = true;
                this.f2378j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j() {
        int i7 = this.f2377i;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            float[] fArr = this.f2376h;
            fArr[i7] = fArr[i7] * (-1.0f);
            i7 = this.f2375g[i7];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float k(int i7) {
        int i8 = this.f2377i;
        for (int i9 = 0; i8 != -1 && i9 < this.f2369a; i9++) {
            if (i9 == i7) {
                return this.f2376h[i8];
            }
            i8 = this.f2375g[i8];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float l(i iVar, boolean z7) {
        if (this.f2373e == iVar) {
            this.f2373e = null;
        }
        int i7 = this.f2377i;
        if (i7 == -1) {
            return 0.0f;
        }
        int i8 = 0;
        int i9 = -1;
        while (i7 != -1 && i8 < this.f2369a) {
            if (this.f2374f[i7] == iVar.f2473c) {
                if (i7 == this.f2377i) {
                    this.f2377i = this.f2375g[i7];
                } else {
                    int[] iArr = this.f2375g;
                    iArr[i9] = iArr[i7];
                }
                if (z7) {
                    iVar.g(this.f2370b);
                }
                iVar.f2483m--;
                this.f2369a--;
                this.f2374f[i7] = -1;
                if (this.f2379k) {
                    this.f2378j = i7;
                }
                return this.f2376h[i7];
            }
            i8++;
            i9 = i7;
            i7 = this.f2375g[i7];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float m(i iVar) {
        int i7 = this.f2377i;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            if (this.f2374f[i7] == iVar.f2473c) {
                return this.f2376h[i7];
            }
            i7 = this.f2375g[i7];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int n() {
        return (this.f2374f.length * 4 * 3) + 0 + 36;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void o(float f8) {
        int i7 = this.f2377i;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            float[] fArr = this.f2376h;
            fArr[i7] = fArr[i7] / f8;
            i7 = this.f2375g[i7];
        }
    }

    public final int p(int i7) {
        return this.f2374f[i7];
    }

    public final int q(int i7) {
        return this.f2375g[i7];
    }

    i r() {
        i iVar = this.f2373e;
        if (iVar != null) {
            return iVar;
        }
        int i7 = this.f2377i;
        i iVar2 = null;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            if (this.f2376h[i7] < 0.0f) {
                i iVar3 = this.f2371c.f2391d[this.f2374f[i7]];
                if (iVar2 == null || iVar2.f2475e < iVar3.f2475e) {
                    iVar2 = iVar3;
                }
            }
            i7 = this.f2375g[i7];
        }
        return iVar2;
    }

    public final float s(int i7) {
        return this.f2376h[i7];
    }

    boolean t() {
        int i7 = this.f2377i;
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            if (this.f2376h[i7] > 0.0f) {
                return true;
            }
            i7 = this.f2375g[i7];
        }
        return false;
    }

    public String toString() {
        int i7 = this.f2377i;
        String str = "";
        for (int i8 = 0; i7 != -1 && i8 < this.f2369a; i8++) {
            str = ((str + " -> ") + this.f2376h[i7] + " : ") + this.f2371c.f2391d[this.f2374f[i7]];
            i7 = this.f2375g[i7];
        }
        return str;
    }
}
