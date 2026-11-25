package com.google.common.net;

import com.google.common.base.a0;
import com.google.common.base.e0;
import com.google.common.base.k0;
import com.google.common.base.w;
import com.google.common.collect.d7;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import u1.j;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@j
@s1.b
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.common.base.e f22202e = com.google.common.base.e.d(".。．｡");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final k0 f22203f = k0.h(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final w f22204g = w.o(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f22205h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f22206i = 127;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f22207j = 253;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f22208k = 63;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final com.google.common.base.e f22209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final com.google.common.base.e f22210m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d7<String> f22212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22214d;

    static {
        com.google.common.base.e eVarD = com.google.common.base.e.d("-_");
        f22209l = eVarD;
        f22210m = com.google.common.base.e.x().I(eVarD);
    }

    e(String str) {
        String strG = com.google.common.base.c.g(f22202e.N(str, ClassUtils.PACKAGE_SEPARATOR_CHAR));
        strG = strG.endsWith(com.alibaba.android.arouter.utils.b.f12515h) ? strG.substring(0, strG.length() - 1) : strG;
        e0.u(strG.length() <= f22207j, "Domain name too long: '%s':", strG);
        this.f22211a = strG;
        d7<String> d7VarP = d7.p(f22203f.n(strG));
        this.f22212b = d7VarP;
        e0.u(d7VarP.size() <= 127, "Domain has too many parts: '%s'", strG);
        e0.u(x(d7VarP), "Not a valid domain name: '%s'", strG);
        this.f22213c = c(a0.a());
        this.f22214d = c(a0.g(com.google.thirdparty.publicsuffix.b.REGISTRY));
    }

    private e a(int i7) {
        w wVar = f22204g;
        d7<String> d7Var = this.f22212b;
        return d(wVar.k(d7Var.subList(i7, d7Var.size())));
    }

    private int c(a0<com.google.thirdparty.publicsuffix.b> a0Var) {
        int size = this.f22212b.size();
        for (int i7 = 0; i7 < size; i7++) {
            String strK = f22204g.k(this.f22212b.subList(i7, size));
            if (o(a0Var, a0.d(com.google.thirdparty.publicsuffix.a.f23314a.get(strK)))) {
                return i7;
            }
            if (com.google.thirdparty.publicsuffix.a.f23316c.containsKey(strK)) {
                return i7 + 1;
            }
            if (p(a0Var, strK)) {
                return i7;
            }
        }
        return -1;
    }

    public static e d(String str) {
        return new e((String) e0.E(str));
    }

    public static boolean n(String str) {
        try {
            d(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private static boolean o(a0<com.google.thirdparty.publicsuffix.b> a0Var, a0<com.google.thirdparty.publicsuffix.b> a0Var2) {
        return a0Var.f() ? a0Var.equals(a0Var2) : a0Var2.f();
    }

    private static boolean p(a0<com.google.thirdparty.publicsuffix.b> a0Var, String str) {
        List<String> listO = f22203f.f(2).o(str);
        return listO.size() == 2 && o(a0Var, a0.d(com.google.thirdparty.publicsuffix.a.f23315b.get(listO.get(1))));
    }

    private static boolean w(String str, boolean z7) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!f22210m.C(com.google.common.base.e.f().P(str))) {
                return false;
            }
            com.google.common.base.e eVar = f22209l;
            if (!eVar.B(str.charAt(0)) && !eVar.B(str.charAt(str.length() - 1))) {
                return (z7 && com.google.common.base.e.j().B(str.charAt(0))) ? false : true;
            }
        }
        return false;
    }

    private static boolean x(List<String> list) {
        int size = list.size() - 1;
        if (!w(list.get(size), true)) {
            return false;
        }
        for (int i7 = 0; i7 < size; i7++) {
            if (!w(list.get(i7), false)) {
                return false;
            }
        }
        return true;
    }

    public e b(String str) {
        return d(((String) e0.E(str)) + com.alibaba.android.arouter.utils.b.f12515h + this.f22211a);
    }

    public boolean e() {
        return this.f22212b.size() > 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f22211a.equals(((e) obj).f22211a);
        }
        return false;
    }

    public boolean f() {
        return this.f22213c != -1;
    }

    public boolean g() {
        return this.f22214d != -1;
    }

    public boolean h() {
        return this.f22213c == 0;
    }

    public int hashCode() {
        return this.f22211a.hashCode();
    }

    public boolean i() {
        return this.f22214d == 0;
    }

    public boolean j() {
        return this.f22214d == 1;
    }

    public boolean k() {
        return this.f22213c == 1;
    }

    public boolean l() {
        return this.f22213c > 0;
    }

    public boolean m() {
        return this.f22214d > 0;
    }

    public e q() {
        e0.x0(e(), "Domain '%s' has no parent", this.f22211a);
        return a(1);
    }

    public d7<String> r() {
        return this.f22212b;
    }

    public e s() {
        if (f()) {
            return a(this.f22213c);
        }
        return null;
    }

    public e t() {
        if (g()) {
            return a(this.f22214d);
        }
        return null;
    }

    public String toString() {
        return this.f22211a;
    }

    public e u() {
        if (j()) {
            return this;
        }
        e0.x0(m(), "Not under a registry suffix: %s", this.f22211a);
        return a(this.f22214d - 1);
    }

    public e v() {
        if (k()) {
            return this;
        }
        e0.x0(l(), "Not under a public suffix: %s", this.f22211a);
        return a(this.f22213c - 1);
    }
}
