package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f9424d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9425e = "ChildrenHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f9426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f9427b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<View> f9428c = new ArrayList();

    static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f9429c = 64;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f9430d = Long.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f9431a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f9432b;

        a() {
        }

        private void c() {
            if (this.f9432b == null) {
                this.f9432b = new a();
            }
        }

        void a(int i7) {
            if (i7 < 64) {
                this.f9431a &= ~(1 << i7);
                return;
            }
            a aVar = this.f9432b;
            if (aVar != null) {
                aVar.a(i7 - 64);
            }
        }

        int b(int i7) {
            a aVar = this.f9432b;
            if (aVar == null) {
                return i7 >= 64 ? Long.bitCount(this.f9431a) : Long.bitCount(this.f9431a & ((1 << i7) - 1));
            }
            return i7 < 64 ? Long.bitCount(this.f9431a & ((1 << i7) - 1)) : aVar.b(i7 - 64) + Long.bitCount(this.f9431a);
        }

        boolean d(int i7) {
            if (i7 < 64) {
                return (this.f9431a & (1 << i7)) != 0;
            }
            c();
            return this.f9432b.d(i7 - 64);
        }

        void e(int i7, boolean z7) {
            if (i7 >= 64) {
                c();
                this.f9432b.e(i7 - 64, z7);
                return;
            }
            long j7 = this.f9431a;
            boolean z8 = (Long.MIN_VALUE & j7) != 0;
            long j8 = (1 << i7) - 1;
            this.f9431a = ((j7 & (~j8)) << 1) | (j7 & j8);
            if (z7) {
                h(i7);
            } else {
                a(i7);
            }
            if (z8 || this.f9432b != null) {
                c();
                this.f9432b.e(0, z8);
            }
        }

        boolean f(int i7) {
            if (i7 >= 64) {
                c();
                return this.f9432b.f(i7 - 64);
            }
            long j7 = 1 << i7;
            long j8 = this.f9431a;
            boolean z7 = (j8 & j7) != 0;
            long j9 = j8 & (~j7);
            this.f9431a = j9;
            long j10 = j7 - 1;
            this.f9431a = (j9 & j10) | Long.rotateRight((~j10) & j9, 1);
            a aVar = this.f9432b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f9432b.f(0);
            }
            return z7;
        }

        void g() {
            this.f9431a = 0L;
            a aVar = this.f9432b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i7) {
            if (i7 < 64) {
                this.f9431a |= 1 << i7;
            } else {
                c();
                this.f9432b.h(i7 - 64);
            }
        }

        public String toString() {
            if (this.f9432b == null) {
                return Long.toBinaryString(this.f9431a);
            }
            return this.f9432b.toString() + "xx" + Long.toBinaryString(this.f9431a);
        }
    }

    interface b {
        View a(int i7);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.d0 f(View view);

        void g(int i7);

        void h(View view);

        void i(View view, int i7);

        void j(int i7);

        void k(View view, int i7, ViewGroup.LayoutParams layoutParams);
    }

    g(b bVar) {
        this.f9426a = bVar;
    }

    private int h(int i7) {
        if (i7 < 0) {
            return -1;
        }
        int iC = this.f9426a.c();
        int i8 = i7;
        while (i8 < iC) {
            int iB = i7 - (i8 - this.f9427b.b(i8));
            if (iB == 0) {
                while (this.f9427b.d(i8)) {
                    i8++;
                }
                return i8;
            }
            i8 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f9428c.add(view);
        this.f9426a.b(view);
    }

    private boolean t(View view) {
        if (!this.f9428c.remove(view)) {
            return false;
        }
        this.f9426a.h(view);
        return true;
    }

    void a(View view, int i7, boolean z7) {
        int iC = i7 < 0 ? this.f9426a.c() : h(i7);
        this.f9427b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f9426a.i(view, iC);
    }

    void b(View view, boolean z7) {
        a(view, -1, z7);
    }

    void c(View view, int i7, ViewGroup.LayoutParams layoutParams, boolean z7) {
        int iC = i7 < 0 ? this.f9426a.c() : h(i7);
        this.f9427b.e(iC, z7);
        if (z7) {
            l(view);
        }
        this.f9426a.k(view, iC, layoutParams);
    }

    void d(int i7) {
        int iH = h(i7);
        this.f9427b.f(iH);
        this.f9426a.g(iH);
    }

    View e(int i7) {
        int size = this.f9428c.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = this.f9428c.get(i8);
            RecyclerView.d0 d0VarF = this.f9426a.f(view);
            if (d0VarF.m() == i7 && !d0VarF.u() && !d0VarF.w()) {
                return view;
            }
        }
        return null;
    }

    View f(int i7) {
        return this.f9426a.a(h(i7));
    }

    int g() {
        return this.f9426a.c() - this.f9428c.size();
    }

    View i(int i7) {
        return this.f9426a.a(i7);
    }

    int j() {
        return this.f9426a.c();
    }

    void k(View view) {
        int iE = this.f9426a.e(view);
        if (iE >= 0) {
            this.f9427b.h(iE);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iE = this.f9426a.e(view);
        if (iE == -1 || this.f9427b.d(iE)) {
            return -1;
        }
        return iE - this.f9427b.b(iE);
    }

    boolean n(View view) {
        return this.f9428c.contains(view);
    }

    void o() {
        this.f9427b.g();
        for (int size = this.f9428c.size() - 1; size >= 0; size--) {
            this.f9426a.h(this.f9428c.get(size));
            this.f9428c.remove(size);
        }
        this.f9426a.d();
    }

    void p(View view) {
        int iE = this.f9426a.e(view);
        if (iE < 0) {
            return;
        }
        if (this.f9427b.f(iE)) {
            t(view);
        }
        this.f9426a.j(iE);
    }

    void q(int i7) {
        int iH = h(i7);
        View viewA = this.f9426a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f9427b.f(iH)) {
            t(viewA);
        }
        this.f9426a.j(iH);
    }

    boolean r(View view) {
        int iE = this.f9426a.e(view);
        if (iE == -1) {
            t(view);
            return true;
        }
        if (!this.f9427b.d(iE)) {
            return false;
        }
        this.f9427b.f(iE);
        t(view);
        this.f9426a.j(iE);
        return true;
    }

    void s(View view) {
        int iE = this.f9426a.e(view);
        if (iE < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f9427b.d(iE)) {
            this.f9427b.a(iE);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f9427b.toString() + ", hidden list:" + this.f9428c.size();
    }
}
