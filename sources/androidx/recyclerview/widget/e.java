package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import c.f1;
import c.h1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class e<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f9377s = "AsyncListUtil";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final boolean f9378t = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Class<T> f9379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f9380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final c<T> f9381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d f9382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final f0<T> f9383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final e0.b<T> f9384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final e0.a<T> f9385g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f9389k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final e0.b<T> f9395q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final e0.a<T> f9396r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int[] f9386h = new int[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int[] f9387i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int[] f9388j = new int[2];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9390l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f9391m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f9392n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f9393o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final SparseIntArray f9394p = new SparseIntArray();

    class a implements e0.b<T> {
        a() {
        }

        private boolean d(int i7) {
            return i7 == e.this.f9393o;
        }

        private void e() {
            for (int i7 = 0; i7 < e.this.f9383e.f(); i7++) {
                e eVar = e.this;
                eVar.f9385g.b(eVar.f9383e.c(i7));
            }
            e.this.f9383e.b();
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void a(int i7, f0.a<T> aVar) {
            if (!d(i7)) {
                e.this.f9385g.b(aVar);
                return;
            }
            f0.a<T> aVarA = e.this.f9383e.a(aVar);
            if (aVarA != null) {
                Log.e(e.f9377s, "duplicate tile @" + aVarA.f9421b);
                e.this.f9385g.b(aVarA);
            }
            int i8 = aVar.f9421b + aVar.f9422c;
            int i9 = 0;
            while (i9 < e.this.f9394p.size()) {
                int iKeyAt = e.this.f9394p.keyAt(i9);
                if (aVar.f9421b > iKeyAt || iKeyAt >= i8) {
                    i9++;
                } else {
                    e.this.f9394p.removeAt(i9);
                    e.this.f9382d.d(iKeyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void b(int i7, int i8) {
            if (d(i7)) {
                f0.a<T> aVarE = e.this.f9383e.e(i8);
                if (aVarE != null) {
                    e.this.f9385g.b(aVarE);
                    return;
                }
                Log.e(e.f9377s, "tile not found @" + i8);
            }
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void c(int i7, int i8) {
            if (d(i7)) {
                e eVar = e.this;
                eVar.f9391m = i8;
                eVar.f9382d.c();
                e eVar2 = e.this;
                eVar2.f9392n = eVar2.f9393o;
                e();
                e eVar3 = e.this;
                eVar3.f9389k = false;
                eVar3.g();
            }
        }
    }

    class b implements e0.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f0.a<T> f9398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SparseBooleanArray f9399b = new SparseBooleanArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f9401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f9403f;

        b() {
        }

        private f0.a<T> e() {
            f0.a<T> aVar = this.f9398a;
            if (aVar != null) {
                this.f9398a = aVar.f9423d;
                return aVar;
            }
            e eVar = e.this;
            return new f0.a<>(eVar.f9379a, eVar.f9380b);
        }

        private void f(f0.a<T> aVar) {
            this.f9399b.put(aVar.f9421b, true);
            e.this.f9384f.a(this.f9400c, aVar);
        }

        private void g(int i7) {
            int iB = e.this.f9381c.b();
            while (this.f9399b.size() >= iB) {
                int iKeyAt = this.f9399b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f9399b;
                int iKeyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i8 = this.f9402e - iKeyAt;
                int i9 = iKeyAt2 - this.f9403f;
                if (i8 > 0 && (i8 >= i9 || i7 == 2)) {
                    k(iKeyAt);
                } else {
                    if (i9 <= 0) {
                        return;
                    }
                    if (i8 >= i9 && i7 != 1) {
                        return;
                    } else {
                        k(iKeyAt2);
                    }
                }
            }
        }

        private int h(int i7) {
            return i7 - (i7 % e.this.f9380b);
        }

        private boolean i(int i7) {
            return this.f9399b.get(i7);
        }

        private void j(String str, Object... objArr) {
            Log.d(e.f9377s, "[BKGR] " + String.format(str, objArr));
        }

        private void k(int i7) {
            this.f9399b.delete(i7);
            e.this.f9384f.b(this.f9400c, i7);
        }

        private void l(int i7, int i8, int i9, boolean z7) {
            int i10 = i7;
            while (i10 <= i8) {
                e.this.f9385g.c(z7 ? (i8 + i7) - i10 : i10, i9);
                i10 += e.this.f9380b;
            }
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void a(int i7, int i8, int i9, int i10, int i11) {
            if (i7 > i8) {
                return;
            }
            int iH = h(i7);
            int iH2 = h(i8);
            this.f9402e = h(i9);
            int iH3 = h(i10);
            this.f9403f = iH3;
            if (i11 == 1) {
                l(this.f9402e, iH2, i11, true);
                l(iH2 + e.this.f9380b, this.f9403f, i11, false);
            } else {
                l(iH, iH3, i11, false);
                l(this.f9402e, iH - e.this.f9380b, i11, true);
            }
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void b(f0.a<T> aVar) {
            e.this.f9381c.c(aVar.f9420a, aVar.f9422c);
            aVar.f9423d = this.f9398a;
            this.f9398a = aVar;
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void c(int i7, int i8) {
            if (i(i7)) {
                return;
            }
            f0.a<T> aVarE = e();
            aVarE.f9421b = i7;
            int iMin = Math.min(e.this.f9380b, this.f9401d - i7);
            aVarE.f9422c = iMin;
            e.this.f9381c.a(aVarE.f9420a, aVarE.f9421b, iMin);
            g(i8);
            f(aVarE);
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void d(int i7) {
            this.f9400c = i7;
            this.f9399b.clear();
            int iD = e.this.f9381c.d();
            this.f9401d = iD;
            e.this.f9384f.c(this.f9400c, iD);
        }
    }

    public static abstract class c<T> {
        @h1
        public abstract void a(@m0 T[] tArr, int i7, int i8);

        @h1
        public int b() {
            return 10;
        }

        @h1
        public void c(@m0 T[] tArr, int i7) {
        }

        @h1
        public abstract int d();
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f9405a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9406b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9407c = 2;

        @f1
        public void a(@m0 int[] iArr, @m0 int[] iArr2, int i7) {
            int i8 = iArr[1];
            int i9 = iArr[0];
            int i10 = (i8 - i9) + 1;
            int i11 = i10 / 2;
            iArr2[0] = i9 - (i7 == 1 ? i10 : i11);
            if (i7 != 2) {
                i10 = i11;
            }
            iArr2[1] = i8 + i10;
        }

        @f1
        public abstract void b(@m0 int[] iArr);

        @f1
        public abstract void c();

        @f1
        public abstract void d(int i7);
    }

    public e(@m0 Class<T> cls, int i7, @m0 c<T> cVar, @m0 d dVar) {
        a aVar = new a();
        this.f9395q = aVar;
        b bVar = new b();
        this.f9396r = bVar;
        this.f9379a = cls;
        this.f9380b = i7;
        this.f9381c = cVar;
        this.f9382d = dVar;
        this.f9383e = new f0<>(i7);
        u uVar = new u();
        this.f9384f = uVar.b(aVar);
        this.f9385g = uVar.a(bVar);
        f();
    }

    private boolean c() {
        return this.f9393o != this.f9392n;
    }

    @o0
    public T a(int i7) {
        if (i7 < 0 || i7 >= this.f9391m) {
            throw new IndexOutOfBoundsException(i7 + " is not within 0 and " + this.f9391m);
        }
        T tD = this.f9383e.d(i7);
        if (tD == null && !c()) {
            this.f9394p.put(i7, 0);
        }
        return tD;
    }

    public int b() {
        return this.f9391m;
    }

    void d(String str, Object... objArr) {
        Log.d(f9377s, "[MAIN] " + String.format(str, objArr));
    }

    public void e() {
        if (c()) {
            return;
        }
        g();
        this.f9389k = true;
    }

    public void f() {
        this.f9394p.clear();
        e0.a<T> aVar = this.f9385g;
        int i7 = this.f9393o + 1;
        this.f9393o = i7;
        aVar.d(i7);
    }

    void g() {
        int i7;
        this.f9382d.b(this.f9386h);
        int[] iArr = this.f9386h;
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (i8 > i9 || i8 < 0 || i9 >= this.f9391m) {
            return;
        }
        if (this.f9389k) {
            int[] iArr2 = this.f9387i;
            if (i8 > iArr2[1] || (i7 = iArr2[0]) > i9) {
                this.f9390l = 0;
            } else if (i8 < i7) {
                this.f9390l = 1;
            } else if (i8 > i7) {
                this.f9390l = 2;
            }
        } else {
            this.f9390l = 0;
        }
        int[] iArr3 = this.f9387i;
        iArr3[0] = i8;
        iArr3[1] = i9;
        this.f9382d.a(iArr, this.f9388j, this.f9390l);
        int[] iArr4 = this.f9388j;
        iArr4[0] = Math.min(this.f9386h[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.f9388j;
        iArr5[1] = Math.max(this.f9386h[1], Math.min(iArr5[1], this.f9391m - 1));
        e0.a<T> aVar = this.f9385g;
        int[] iArr6 = this.f9386h;
        int i10 = iArr6[0];
        int i11 = iArr6[1];
        int[] iArr7 = this.f9388j;
        aVar.a(i10, i11, iArr7[0], iArr7[1], this.f9390l);
    }
}
