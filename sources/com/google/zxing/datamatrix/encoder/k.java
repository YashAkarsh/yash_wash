package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final k[] f23695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static k[] f23696j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f23702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f23703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f23704h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, com.alibaba.fastjson.asm.j.f12606c0, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f23695i = kVarArr;
        f23696j = kVarArr;
    }

    public k(boolean z7, int i7, int i8, int i9, int i10, int i11) {
        this(z7, i7, i8, i9, i10, i11, i7, i8);
    }

    private int f() {
        int i7 = this.f23702f;
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2 && i7 != 4) {
                if (i7 == 16) {
                    return 4;
                }
                if (i7 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i8;
    }

    private int l() {
        int i7 = this.f23702f;
        if (i7 == 1 || i7 == 2) {
            return 1;
        }
        if (i7 == 4) {
            return 2;
        }
        if (i7 == 16) {
            return 4;
        }
        if (i7 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static k m(int i7) {
        return p(i7, l.FORCE_NONE, true);
    }

    public static k n(int i7, l lVar) {
        return p(i7, lVar, true);
    }

    public static k o(int i7, l lVar, com.google.zxing.f fVar, com.google.zxing.f fVar2, boolean z7) {
        for (k kVar : f23696j) {
            if (!(lVar == l.FORCE_SQUARE && kVar.f23697a) && ((lVar != l.FORCE_RECTANGLE || kVar.f23697a) && ((fVar == null || (kVar.k() >= fVar.b() && kVar.j() >= fVar.a())) && ((fVar2 == null || (kVar.k() <= fVar2.b() && kVar.j() <= fVar2.a())) && i7 <= kVar.f23698b)))) {
                return kVar;
            }
        }
        if (z7) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i7)));
        }
        return null;
    }

    private static k p(int i7, l lVar, boolean z7) {
        return o(i7, lVar, null, null, z7);
    }

    public static k q(int i7, boolean z7, boolean z8) {
        return p(i7, z7 ? l.FORCE_NONE : l.FORCE_SQUARE, z8);
    }

    public static void r(k[] kVarArr) {
        f23696j = kVarArr;
    }

    public int a() {
        return this.f23698b + this.f23699c;
    }

    public final int b() {
        return this.f23698b;
    }

    public int c(int i7) {
        return this.f23703g;
    }

    public final int d() {
        return this.f23699c;
    }

    public final int e(int i7) {
        return this.f23704h;
    }

    public int g() {
        return this.f23698b / this.f23703g;
    }

    public final int h() {
        return l() * this.f23701e;
    }

    public final int i() {
        return f() * this.f23700d;
    }

    public final int j() {
        return h() + (l() << 1);
    }

    public final int k() {
        return i() + (f() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23697a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f23700d);
        sb.append('x');
        sb.append(this.f23701e);
        sb.append(", symbol size ");
        sb.append(k());
        sb.append('x');
        sb.append(j());
        sb.append(", symbol data size ");
        sb.append(i());
        sb.append('x');
        sb.append(h());
        sb.append(", codewords ");
        sb.append(this.f23698b);
        sb.append('+');
        sb.append(this.f23699c);
        return sb.toString();
    }

    k(boolean z7, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f23697a = z7;
        this.f23698b = i7;
        this.f23699c = i8;
        this.f23700d = i9;
        this.f23701e = i10;
        this.f23702f = i11;
        this.f23703g = i12;
        this.f23704h = i13;
    }
}
