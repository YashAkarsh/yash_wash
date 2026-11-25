package com.alibaba.fastjson.serializer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<q> f13074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<i> f13075b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<b1> f13076c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<p1> f13077d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<w0> f13078e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected List<c1> f13079f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List<q0> f13080g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected List<a0> f13081h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f13082i = true;

    public void b(h1 h1Var) {
        if (h1Var == null) {
            return;
        }
        if (h1Var instanceof c1) {
            m().add((c1) h1Var);
        }
        if (h1Var instanceof w0) {
            k().add((w0) h1Var);
        }
        if (h1Var instanceof p1) {
            n().add((p1) h1Var);
        }
        if (h1Var instanceof a0) {
            i().add((a0) h1Var);
        }
        if (h1Var instanceof b1) {
            l().add((b1) h1Var);
        }
        if (h1Var instanceof q) {
            h().add((q) h1Var);
        }
        if (h1Var instanceof i) {
            g().add((i) h1Var);
        }
        if (h1Var instanceof q0) {
            j().add((q0) h1Var);
        }
    }

    public boolean e(n0 n0Var, Object obj, String str, Object obj2) {
        List<b1> list = n0Var.f13076c;
        if (list != null) {
            Iterator<b1> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().b(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<b1> list2 = this.f13076c;
        if (list2 == null) {
            return true;
        }
        Iterator<b1> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().b(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f(n0 n0Var, Object obj, String str) {
        List<c1> list = n0Var.f13079f;
        if (list != null) {
            Iterator<c1> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().e(n0Var, obj, str)) {
                    return false;
                }
            }
        }
        List<c1> list2 = this.f13079f;
        if (list2 == null) {
            return true;
        }
        Iterator<c1> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().e(n0Var, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public List<i> g() {
        if (this.f13075b == null) {
            this.f13075b = new ArrayList();
            this.f13082i = false;
        }
        return this.f13075b;
    }

    public List<q> h() {
        if (this.f13074a == null) {
            this.f13074a = new ArrayList();
            this.f13082i = false;
        }
        return this.f13074a;
    }

    public List<a0> i() {
        if (this.f13081h == null) {
            this.f13081h = new ArrayList();
            this.f13082i = false;
        }
        return this.f13081h;
    }

    public List<q0> j() {
        if (this.f13080g == null) {
            this.f13080g = new ArrayList();
            this.f13082i = false;
        }
        return this.f13080g;
    }

    public List<w0> k() {
        if (this.f13078e == null) {
            this.f13078e = new ArrayList();
            this.f13082i = false;
        }
        return this.f13078e;
    }

    public List<b1> l() {
        if (this.f13076c == null) {
            this.f13076c = new ArrayList();
            this.f13082i = false;
        }
        return this.f13076c;
    }

    public List<c1> m() {
        if (this.f13079f == null) {
            this.f13079f = new ArrayList();
            this.f13082i = false;
        }
        return this.f13079f;
    }

    public List<p1> n() {
        if (this.f13077d == null) {
            this.f13077d = new ArrayList();
            this.f13082i = false;
        }
        return this.f13077d;
    }

    protected String o(n0 n0Var, Object obj, String str, Object obj2) {
        List<w0> list = n0Var.f13078e;
        if (list != null) {
            Iterator<w0> it = list.iterator();
            while (it.hasNext()) {
                str = it.next().a(obj, str, obj2);
            }
        }
        List<w0> list2 = this.f13078e;
        if (list2 != null) {
            Iterator<w0> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = it2.next().a(obj, str, obj2);
            }
        }
        return str;
    }

    protected Object p(n0 n0Var, p pVar, Object obj, String str, Object obj2) {
        boolean z7;
        if (obj2 != null) {
            if ((n0Var.f13143k.f13097j || !(pVar == null || (pVar.c() & k1.WriteNonStringValueAsString.f13132a) == 0)) && (((z7 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String strG = (!z7 || pVar == null) ? null : pVar.g();
                obj2 = strG != null ? new DecimalFormat(strG).format(obj2) : obj2.toString();
            } else if (pVar != null && pVar.k()) {
                obj2 = com.alibaba.fastjson.a.l((String) obj2);
            }
        }
        List<p1> list = n0Var.f13077d;
        if (list != null) {
            Iterator<p1> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().a(obj, str, obj2);
            }
        }
        List<p1> list2 = this.f13077d;
        if (list2 != null) {
            Iterator<p1> it2 = list2.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().a(obj, str, obj2);
            }
        }
        List<a0> list3 = n0Var.f13081h;
        if (list3 != null) {
            Iterator<a0> it3 = list3.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().d(pVar, obj, str, obj2);
            }
        }
        List<a0> list4 = this.f13081h;
        if (list4 != null) {
            Iterator<a0> it4 = list4.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().d(pVar, obj, str, obj2);
            }
        }
        return obj2;
    }

    protected boolean q(n0 n0Var) {
        return n0Var.f13143k.f13101n && this.f13082i && n0Var.f13082i;
    }
}
