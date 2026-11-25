package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f2976m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f2977n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f2978o = 10;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f2979p = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f2980a = new int[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f2981b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2982c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f2983d = new int[10];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float[] f2984e = new float[10];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2985f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f2986g = new int[5];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f2987h = new String[5];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f2988i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int[] f2989j = new int[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean[] f2990k = new boolean[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2991l = 0;

    public void a(int i7, float f8) {
        int i8 = this.f2985f;
        int[] iArr = this.f2983d;
        if (i8 >= iArr.length) {
            this.f2983d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2984e;
            this.f2984e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f2983d;
        int i9 = this.f2985f;
        iArr2[i9] = i7;
        float[] fArr2 = this.f2984e;
        this.f2985f = i9 + 1;
        fArr2[i9] = f8;
    }

    public void b(int i7, int i8) {
        int i9 = this.f2982c;
        int[] iArr = this.f2980a;
        if (i9 >= iArr.length) {
            this.f2980a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f2981b;
            this.f2981b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2980a;
        int i10 = this.f2982c;
        iArr3[i10] = i7;
        int[] iArr4 = this.f2981b;
        this.f2982c = i10 + 1;
        iArr4[i10] = i8;
    }

    public void c(int i7, String str) {
        int i8 = this.f2988i;
        int[] iArr = this.f2986g;
        if (i8 >= iArr.length) {
            this.f2986g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f2987h;
            this.f2987h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f2986g;
        int i9 = this.f2988i;
        iArr2[i9] = i7;
        String[] strArr2 = this.f2987h;
        this.f2988i = i9 + 1;
        strArr2[i9] = str;
    }

    public void d(int i7, boolean z7) {
        int i8 = this.f2991l;
        int[] iArr = this.f2989j;
        if (i8 >= iArr.length) {
            this.f2989j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f2990k;
            this.f2990k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f2989j;
        int i9 = this.f2991l;
        iArr2[i9] = i7;
        boolean[] zArr2 = this.f2990k;
        this.f2991l = i9 + 1;
        zArr2[i9] = z7;
    }

    public void e(int i7, String str) {
        if (str != null) {
            c(i7, str);
        }
    }

    public void f(u uVar) {
        for (int i7 = 0; i7 < this.f2982c; i7++) {
            uVar.b(this.f2980a[i7], this.f2981b[i7]);
        }
        for (int i8 = 0; i8 < this.f2985f; i8++) {
            uVar.a(this.f2983d[i8], this.f2984e[i8]);
        }
        for (int i9 = 0; i9 < this.f2988i; i9++) {
            uVar.c(this.f2986g[i9], this.f2987h[i9]);
        }
        for (int i10 = 0; i10 < this.f2991l; i10++) {
            uVar.d(this.f2989j[i10], this.f2990k[i10]);
        }
    }

    public void g(w wVar) {
        for (int i7 = 0; i7 < this.f2982c; i7++) {
            wVar.a(this.f2980a[i7], this.f2981b[i7]);
        }
        for (int i8 = 0; i8 < this.f2985f; i8++) {
            wVar.b(this.f2983d[i8], this.f2984e[i8]);
        }
        for (int i9 = 0; i9 < this.f2988i; i9++) {
            wVar.c(this.f2986g[i9], this.f2987h[i9]);
        }
        for (int i10 = 0; i10 < this.f2991l; i10++) {
            wVar.d(this.f2989j[i10], this.f2990k[i10]);
        }
    }

    public void h() {
        this.f2991l = 0;
        this.f2988i = 0;
        this.f2985f = 0;
        this.f2982c = 0;
    }

    public int i(int i7) {
        for (int i8 = 0; i8 < this.f2982c; i8++) {
            if (this.f2980a[i8] == i7) {
                return this.f2981b[i8];
            }
        }
        return -1;
    }
}
