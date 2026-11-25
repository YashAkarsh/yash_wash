package androidx.constraintlayout.core.state;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f3265i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f3266j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f3267k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f3268l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f3269m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f3270n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f3274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f3276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f3277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f3278h;

    public enum a {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private b() {
        this.f3271a = -2;
        this.f3272b = 0;
        this.f3273c = Integer.MAX_VALUE;
        this.f3274d = 1.0f;
        this.f3275e = 0;
        this.f3276f = null;
        this.f3277g = f3266j;
        this.f3278h = false;
    }

    public static b a(int i7) {
        b bVar = new b(f3265i);
        bVar.l(i7);
        return bVar;
    }

    public static b b(Object obj) {
        b bVar = new b(f3265i);
        bVar.m(obj);
        return bVar;
    }

    public static b c() {
        return new b(f3268l);
    }

    public static b d(Object obj, float f8) {
        b bVar = new b(f3269m);
        bVar.s(obj, f8);
        return bVar;
    }

    public static b e(String str) {
        b bVar = new b(f3270n);
        bVar.t(str);
        return bVar;
    }

    public static b f() {
        return new b(f3267k);
    }

    public static b g(int i7) {
        b bVar = new b();
        bVar.v(i7);
        return bVar;
    }

    public static b h(Object obj) {
        b bVar = new b();
        bVar.w(obj);
        return bVar;
    }

    public static b i() {
        return new b(f3266j);
    }

    public void j(h hVar, androidx.constraintlayout.core.widgets.e eVar, int i7) {
        String str = this.f3276f;
        if (str != null) {
            eVar.n1(str);
        }
        int i8 = 2;
        if (i7 == 0) {
            if (this.f3278h) {
                eVar.D1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
                Object obj = this.f3277g;
                if (obj == f3266j) {
                    i8 = 1;
                } else if (obj != f3269m) {
                    i8 = 0;
                }
                eVar.E1(i8, this.f3272b, this.f3273c, this.f3274d);
                return;
            }
            int i9 = this.f3272b;
            if (i9 > 0) {
                eVar.P1(i9);
            }
            int i10 = this.f3273c;
            if (i10 < Integer.MAX_VALUE) {
                eVar.M1(i10);
            }
            Object obj2 = this.f3277g;
            if (obj2 == f3266j) {
                eVar.D1(androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT);
                return;
            }
            if (obj2 == f3268l) {
                eVar.D1(androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    eVar.D1(androidx.constraintlayout.core.widgets.e.b.FIXED);
                    eVar.c2(this.f3275e);
                    return;
                }
                return;
            }
        }
        if (this.f3278h) {
            eVar.Y1(androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT);
            Object obj3 = this.f3277g;
            if (obj3 == f3266j) {
                i8 = 1;
            } else if (obj3 != f3269m) {
                i8 = 0;
            }
            eVar.Z1(i8, this.f3272b, this.f3273c, this.f3274d);
            return;
        }
        int i11 = this.f3272b;
        if (i11 > 0) {
            eVar.O1(i11);
        }
        int i12 = this.f3273c;
        if (i12 < Integer.MAX_VALUE) {
            eVar.L1(i12);
        }
        Object obj4 = this.f3277g;
        if (obj4 == f3266j) {
            eVar.Y1(androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT);
            return;
        }
        if (obj4 == f3268l) {
            eVar.Y1(androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT);
        } else if (obj4 == null) {
            eVar.Y1(androidx.constraintlayout.core.widgets.e.b.FIXED);
            eVar.y1(this.f3275e);
        }
    }

    public boolean k(int i7) {
        return this.f3277g == null && this.f3275e == i7;
    }

    public b l(int i7) {
        this.f3277g = null;
        this.f3275e = i7;
        return this;
    }

    public b m(Object obj) {
        this.f3277g = obj;
        if (obj instanceof Integer) {
            this.f3275e = ((Integer) obj).intValue();
            this.f3277g = null;
        }
        return this;
    }

    int n() {
        return this.f3275e;
    }

    public b o(int i7) {
        if (this.f3273c >= 0) {
            this.f3273c = i7;
        }
        return this;
    }

    public b p(Object obj) {
        Object obj2 = f3266j;
        if (obj == obj2 && this.f3278h) {
            this.f3277g = obj2;
            this.f3273c = Integer.MAX_VALUE;
        }
        return this;
    }

    public b q(int i7) {
        if (i7 >= 0) {
            this.f3272b = i7;
        }
        return this;
    }

    public b r(Object obj) {
        if (obj == f3266j) {
            this.f3272b = -2;
        }
        return this;
    }

    public b s(Object obj, float f8) {
        this.f3274d = f8;
        return this;
    }

    public b t(String str) {
        this.f3276f = str;
        return this;
    }

    void u(int i7) {
        this.f3278h = false;
        this.f3277g = null;
        this.f3275e = i7;
    }

    public b v(int i7) {
        this.f3278h = true;
        if (i7 >= 0) {
            this.f3273c = i7;
        }
        return this;
    }

    public b w(Object obj) {
        this.f3277g = obj;
        this.f3278h = true;
        return this;
    }

    private b(Object obj) {
        this.f3271a = -2;
        this.f3272b = 0;
        this.f3273c = Integer.MAX_VALUE;
        this.f3274d = 1.0f;
        this.f3275e = 0;
        this.f3276f = null;
        this.f3278h = false;
        this.f3277g = obj;
    }
}
