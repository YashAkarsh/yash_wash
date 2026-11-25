package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class k6<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator<? super T> f20543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f20545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s0 f20546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f20547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T f20548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s0 f20549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient k6<T> f20550h;

    /* JADX WARN: Multi-variable type inference failed */
    private k6(Comparator<? super T> comparator, boolean z7, T t7, s0 s0Var, boolean z8, T t8, s0 s0Var2) {
        this.f20543a = (Comparator) com.google.common.base.e0.E(comparator);
        this.f20544b = z7;
        this.f20547e = z8;
        this.f20545c = t7;
        this.f20546d = (s0) com.google.common.base.e0.E(s0Var);
        this.f20548f = t8;
        this.f20549g = (s0) com.google.common.base.e0.E(s0Var2);
        if (z7) {
            comparator.compare(t7, t7);
        }
        if (z8) {
            comparator.compare(t8, t8);
        }
        if (z7 && z8) {
            int iCompare = comparator.compare(t7, t8);
            com.google.common.base.e0.y(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t7, t8);
            if (iCompare == 0) {
                s0 s0Var3 = s0.OPEN;
                com.google.common.base.e0.d((s0Var != s0Var3) | (s0Var2 != s0Var3));
            }
        }
    }

    static <T> k6<T> a(Comparator<? super T> comparator) {
        s0 s0Var = s0.OPEN;
        return new k6<>(comparator, false, null, s0Var, false, null, s0Var);
    }

    static <T> k6<T> d(Comparator<? super T> comparator, T t7, s0 s0Var) {
        return new k6<>(comparator, true, t7, s0Var, false, null, s0.OPEN);
    }

    static <T extends Comparable> k6<T> e(xd<T> xdVar) {
        return new k6<>(td.A(), xdVar.r(), xdVar.r() ? xdVar.A() : null, xdVar.r() ? xdVar.z() : s0.OPEN, xdVar.t(), xdVar.t() ? xdVar.M() : null, xdVar.t() ? xdVar.L() : s0.OPEN);
    }

    static <T> k6<T> n(Comparator<? super T> comparator, T t7, s0 s0Var, T t8, s0 s0Var2) {
        return new k6<>(comparator, true, t7, s0Var, true, t8, s0Var2);
    }

    static <T> k6<T> r(Comparator<? super T> comparator, T t7, s0 s0Var) {
        return new k6<>(comparator, false, null, s0.OPEN, true, t7, s0Var);
    }

    Comparator<? super T> b() {
        return this.f20543a;
    }

    boolean c(T t7) {
        return (q(t7) || p(t7)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k6)) {
            return false;
        }
        k6 k6Var = (k6) obj;
        return this.f20543a.equals(k6Var.f20543a) && this.f20544b == k6Var.f20544b && this.f20547e == k6Var.f20547e && f().equals(k6Var.f()) && h().equals(k6Var.h()) && com.google.common.base.y.a(g(), k6Var.g()) && com.google.common.base.y.a(i(), k6Var.i());
    }

    s0 f() {
        return this.f20546d;
    }

    T g() {
        return this.f20545c;
    }

    s0 h() {
        return this.f20549g;
    }

    public int hashCode() {
        return com.google.common.base.y.b(this.f20543a, g(), f(), i(), h());
    }

    T i() {
        return this.f20548f;
    }

    boolean j() {
        return this.f20544b;
    }

    boolean k() {
        return this.f20547e;
    }

    k6<T> l(k6<T> k6Var) {
        int iCompare;
        int iCompare2;
        T t7;
        s0 s0Var;
        s0 s0Var2;
        int iCompare3;
        s0 s0Var3;
        com.google.common.base.e0.E(k6Var);
        com.google.common.base.e0.d(this.f20543a.equals(k6Var.f20543a));
        boolean z7 = this.f20544b;
        T tG = g();
        s0 s0VarF = f();
        if (!j()) {
            z7 = k6Var.f20544b;
            tG = k6Var.g();
            s0VarF = k6Var.f();
        } else if (k6Var.j() && ((iCompare = this.f20543a.compare(g(), k6Var.g())) < 0 || (iCompare == 0 && k6Var.f() == s0.OPEN))) {
            tG = k6Var.g();
            s0VarF = k6Var.f();
        }
        boolean z8 = z7;
        boolean z9 = this.f20547e;
        T tI = i();
        s0 s0VarH = h();
        if (!k()) {
            z9 = k6Var.f20547e;
            tI = k6Var.i();
            s0VarH = k6Var.h();
        } else if (k6Var.k() && ((iCompare2 = this.f20543a.compare(i(), k6Var.i())) > 0 || (iCompare2 == 0 && k6Var.h() == s0.OPEN))) {
            tI = k6Var.i();
            s0VarH = k6Var.h();
        }
        boolean z10 = z9;
        T t8 = tI;
        if (z8 && z10 && ((iCompare3 = this.f20543a.compare(tG, t8)) > 0 || (iCompare3 == 0 && s0VarF == (s0Var3 = s0.OPEN) && s0VarH == s0Var3))) {
            s0Var = s0.OPEN;
            s0Var2 = s0.CLOSED;
            t7 = t8;
        } else {
            t7 = tG;
            s0Var = s0VarF;
            s0Var2 = s0VarH;
        }
        return new k6<>(this.f20543a, z8, t7, s0Var, z10, t8, s0Var2);
    }

    boolean m() {
        return (k() && q(i())) || (j() && p(g()));
    }

    k6<T> o() {
        k6<T> k6Var = this.f20550h;
        if (k6Var != null) {
            return k6Var;
        }
        k6<T> k6Var2 = new k6<>(td.i(this.f20543a).F(), this.f20547e, i(), h(), this.f20544b, g(), f());
        k6Var2.f20550h = this;
        this.f20550h = k6Var2;
        return k6Var2;
    }

    boolean p(T t7) {
        if (!k()) {
            return false;
        }
        int iCompare = this.f20543a.compare(t7, i());
        return ((iCompare == 0) & (h() == s0.OPEN)) | (iCompare > 0);
    }

    boolean q(T t7) {
        if (!j()) {
            return false;
        }
        int iCompare = this.f20543a.compare(t7, g());
        return ((iCompare == 0) & (f() == s0.OPEN)) | (iCompare < 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20543a);
        sb.append(":");
        s0 s0Var = this.f20546d;
        s0 s0Var2 = s0.CLOSED;
        sb.append(s0Var == s0Var2 ? '[' : '(');
        sb.append(this.f20544b ? this.f20545c : "-∞");
        sb.append(',');
        sb.append(this.f20547e ? this.f20548f : "∞");
        sb.append(this.f20549g == s0Var2 ? ']' : ')');
        return sb.toString();
    }
}
