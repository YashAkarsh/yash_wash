package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.r0;
import c.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class l implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final ThreadLocal<l> f9592e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Comparator<c> f9593f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f9595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f9596c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<RecyclerView> f9594a = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<c> f9597d = new ArrayList<>();

    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f9605d;
            if ((recyclerView == null) != (cVar2.f9605d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z7 = cVar.f9602a;
            if (z7 != cVar2.f9602a) {
                return z7 ? -1 : 1;
            }
            int i7 = cVar2.f9603b - cVar.f9603b;
            if (i7 != 0) {
                return i7;
            }
            int i8 = cVar.f9604c - cVar2.f9604c;
            if (i8 != 0) {
                return i8;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f9600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9601d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i7, int i8) {
            if (i7 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i8 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i9 = this.f9601d * 2;
            int[] iArr = this.f9600c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f9600c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i9 >= iArr.length) {
                int[] iArr3 = new int[i9 * 2];
                this.f9600c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f9600c;
            iArr4[i9] = i7;
            iArr4[i9 + 1] = i8;
            this.f9601d++;
        }

        void b() {
            int[] iArr = this.f9600c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f9601d = 0;
        }

        void c(RecyclerView recyclerView, boolean z7) {
            this.f9601d = 0;
            int[] iArr = this.f9600c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f9100m;
            if (recyclerView.f9099l == null || oVar == null || !oVar.I0()) {
                return;
            }
            if (z7) {
                if (!recyclerView.f9091d.q()) {
                    oVar.s(recyclerView.f9099l.e(), this);
                }
            } else if (!recyclerView.C0()) {
                oVar.r(this.f9598a, this.f9599b, recyclerView.H0, this);
            }
            int i7 = this.f9601d;
            if (i7 > oVar.f9212m) {
                oVar.f9212m = i7;
                oVar.f9213n = z7;
                recyclerView.f9089b.L();
            }
        }

        boolean d(int i7) {
            if (this.f9600c != null) {
                int i8 = this.f9601d * 2;
                for (int i9 = 0; i9 < i8; i9 += 2) {
                    if (this.f9600c[i9] == i7) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i7, int i8) {
            this.f9598a = i7;
            this.f9599b = i8;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f9605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9606e;

        c() {
        }

        public void a() {
            this.f9602a = false;
            this.f9603b = 0;
            this.f9604c = 0;
            this.f9605d = null;
            this.f9606e = 0;
        }
    }

    l() {
    }

    private void b() {
        c cVar;
        int size = this.f9594a.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView = this.f9594a.get(i8);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.G0.c(recyclerView, false);
                i7 += recyclerView.G0.f9601d;
            }
        }
        this.f9597d.ensureCapacity(i7);
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView2 = this.f9594a.get(i10);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.G0;
                int iAbs = Math.abs(bVar.f9598a) + Math.abs(bVar.f9599b);
                for (int i11 = 0; i11 < bVar.f9601d * 2; i11 += 2) {
                    if (i9 >= this.f9597d.size()) {
                        cVar = new c();
                        this.f9597d.add(cVar);
                    } else {
                        cVar = this.f9597d.get(i9);
                    }
                    int[] iArr = bVar.f9600c;
                    int i12 = iArr[i11 + 1];
                    cVar.f9602a = i12 <= iAbs;
                    cVar.f9603b = iAbs;
                    cVar.f9604c = i12;
                    cVar.f9605d = recyclerView2;
                    cVar.f9606e = iArr[i11];
                    i9++;
                }
            }
        }
        Collections.sort(this.f9597d, f9593f);
    }

    private void c(c cVar, long j7) {
        RecyclerView.d0 d0VarI = i(cVar.f9605d, cVar.f9606e, cVar.f9602a ? Long.MAX_VALUE : j7);
        if (d0VarI == null || d0VarI.f9158b == null || !d0VarI.t() || d0VarI.u()) {
            return;
        }
        h(d0VarI.f9158b.get(), j7);
    }

    private void d(long j7) {
        for (int i7 = 0; i7 < this.f9597d.size(); i7++) {
            c cVar = this.f9597d.get(i7);
            if (cVar.f9605d == null) {
                return;
            }
            c(cVar, j7);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i7) {
        int iJ = recyclerView.f9092e.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            RecyclerView.d0 d0VarT0 = RecyclerView.t0(recyclerView.f9092e.i(i8));
            if (d0VarT0.f9159c == i7 && !d0VarT0.u()) {
                return true;
            }
        }
        return false;
    }

    private void h(@o0 RecyclerView recyclerView, long j7) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.D && recyclerView.f9092e.j() != 0) {
            recyclerView.n1();
        }
        b bVar = recyclerView.G0;
        bVar.c(recyclerView, true);
        if (bVar.f9601d != 0) {
            try {
                r0.b("RV Nested Prefetch");
                recyclerView.H0.k(recyclerView.f9099l);
                for (int i7 = 0; i7 < bVar.f9601d * 2; i7 += 2) {
                    i(recyclerView, bVar.f9600c[i7], j7);
                }
                r0.d();
            } catch (Throwable th) {
                r0.d();
                throw th;
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i7, long j7) {
        if (e(recyclerView, i7)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f9089b;
        try {
            recyclerView.Z0();
            RecyclerView.d0 d0VarJ = vVar.J(i7, false, j7);
            if (d0VarJ != null) {
                if (!d0VarJ.t() || d0VarJ.u()) {
                    vVar.a(d0VarJ, false);
                } else {
                    vVar.C(d0VarJ.f9157a);
                }
            }
            return d0VarJ;
        } finally {
            recyclerView.b1(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f9594a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i7, int i8) {
        if (recyclerView.isAttachedToWindow() && this.f9595b == 0) {
            this.f9595b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.G0.e(i7, i8);
    }

    void g(long j7) {
        b();
        d(j7);
    }

    public void j(RecyclerView recyclerView) {
        this.f9594a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            r0.b("RV Prefetch");
            if (!this.f9594a.isEmpty()) {
                int size = this.f9594a.size();
                long jMax = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    RecyclerView recyclerView = this.f9594a.get(i7);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f9596c);
                }
            }
        } finally {
            this.f9595b = 0L;
            r0.d();
        }
    }
}
