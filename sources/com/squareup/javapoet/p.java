package com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f33395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f33397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f33398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.squareup.javapoet.a> f33399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Modifier> f33400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<q> f33401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f33402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<o> f33403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, p> f33404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<f> f33405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f33406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f33407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<k> f33408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<p> f33409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Element> f33410p;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f33411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f33412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f33413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.b f33414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<com.squareup.javapoet.a> f33415e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List<Modifier> f33416f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List<q> f33417g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private o f33418h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final List<o> f33419i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Map<String, p> f33420j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final List<f> f33421k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final d.b f33422l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final d.b f33423m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final List<k> f33424n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final List<p> f33425o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final List<Element> f33426p;

        public b A(Iterable<f> iterable) {
            r.b(iterable != null, "fieldSpecs == null", new Object[0]);
            Iterator<f> it = iterable.iterator();
            while (it.hasNext()) {
                x(it.next());
            }
            return this;
        }

        public b B(d dVar) {
            c cVar = this.f33411a;
            if (cVar == c.CLASS || cVar == c.ENUM) {
                this.f33423m.b("{\n", new Object[0]).l().a(dVar).n().b("}\n", new Object[0]);
                return this;
            }
            throw new UnsupportedOperationException(this.f33411a + " can't have initializer blocks");
        }

        public b C(String str, Object... objArr) {
            this.f33414d.b(str, objArr);
            return this;
        }

        public b D(k kVar) {
            c cVar = this.f33411a;
            c cVar2 = c.INTERFACE;
            if (cVar == cVar2) {
                r.k(kVar.f33339d, Modifier.ABSTRACT, Modifier.STATIC, r.f33438a);
                r.k(kVar.f33339d, Modifier.PUBLIC, Modifier.PRIVATE);
            } else if (cVar == c.ANNOTATION) {
                boolean zEquals = kVar.f33339d.equals(cVar.f33433b);
                c cVar3 = this.f33411a;
                r.d(zEquals, "%s %s.%s requires modifiers %s", cVar3, this.f33412b, kVar.f33336a, cVar3.f33433b);
            }
            c cVar4 = this.f33411a;
            if (cVar4 != c.ANNOTATION) {
                r.d(kVar.f33346k == null, "%s %s.%s cannot have a default value", cVar4, this.f33412b, kVar.f33336a);
            }
            if (this.f33411a != cVar2) {
                r.d(!r.e(kVar.f33339d), "%s %s.%s cannot be default", this.f33411a, this.f33412b, kVar.f33336a);
            }
            this.f33424n.add(kVar);
            return this;
        }

        public b E(Iterable<k> iterable) {
            r.b(iterable != null, "methodSpecs == null", new Object[0]);
            Iterator<k> it = iterable.iterator();
            while (it.hasNext()) {
                D(it.next());
            }
            return this;
        }

        public b F(Modifier... modifierArr) {
            r.d(this.f33413c == null, "forbidden on anonymous types.", new Object[0]);
            Collections.addAll(this.f33416f, modifierArr);
            return this;
        }

        public b G(Element element) {
            this.f33426p.add(element);
            return this;
        }

        public b H(d dVar) {
            this.f33422l.h("static", new Object[0]).a(dVar).j();
            return this;
        }

        public b I(o oVar) {
            this.f33419i.add(oVar);
            return this;
        }

        public b J(Type type) {
            return I(o.h(type));
        }

        public b K(Iterable<? extends o> iterable) {
            r.b(iterable != null, "superinterfaces == null", new Object[0]);
            Iterator<? extends o> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33419i.add(it.next());
            }
            return this;
        }

        public b L(p pVar) {
            boolean zContainsAll = pVar.f33400f.containsAll(this.f33411a.f33434c);
            c cVar = this.f33411a;
            r.b(zContainsAll, "%s %s.%s requires modifiers %s", cVar, this.f33412b, pVar.f33396b, cVar.f33434c);
            this.f33425o.add(pVar);
            return this;
        }

        public b M(q qVar) {
            r.d(this.f33413c == null, "forbidden on anonymous types.", new Object[0]);
            this.f33417g.add(qVar);
            return this;
        }

        public b N(Iterable<q> iterable) {
            r.d(this.f33413c == null, "forbidden on anonymous types.", new Object[0]);
            r.b(iterable != null, "typeVariables == null", new Object[0]);
            Iterator<q> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33417g.add(it.next());
            }
            return this;
        }

        public b O(Iterable<p> iterable) {
            r.b(iterable != null, "typeSpecs == null", new Object[0]);
            Iterator<p> it = iterable.iterator();
            while (it.hasNext()) {
                L(it.next());
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public p P() {
            boolean z7 = true;
            r.b((this.f33411a == c.ENUM && this.f33420j.isEmpty()) ? false : true, "at least one enum constant is required for %s", this.f33412b);
            Object[] objArr = this.f33416f.contains(Modifier.ABSTRACT) || this.f33411a != c.CLASS;
            for (k kVar : this.f33424n) {
                r.b(objArr == true || !kVar.c(Modifier.ABSTRACT), "non-abstract type %s cannot declare abstract method %s", this.f33412b, kVar.f33336a);
            }
            int size = (!this.f33418h.equals(com.squareup.javapoet.c.f33285y) ? 1 : 0) + this.f33419i.size();
            if (this.f33413c != null && size > 1) {
                z7 = false;
            }
            r.b(z7, "anonymous type has too many supertypes", new Object[0]);
            return new p(this);
        }

        public b Q(o oVar) {
            r.d(this.f33418h == com.squareup.javapoet.c.f33285y, "superclass already set to " + this.f33418h, new Object[0]);
            r.b(oVar.n() ^ true, "superclass may not be a primitive", new Object[0]);
            this.f33418h = oVar;
            return this;
        }

        public b R(Type type) {
            return Q(o.h(type));
        }

        public b r(com.squareup.javapoet.a aVar) {
            this.f33415e.add(aVar);
            return this;
        }

        public b s(com.squareup.javapoet.c cVar) {
            return r(com.squareup.javapoet.a.a(cVar).f());
        }

        public b t(Class<?> cls) {
            return s(com.squareup.javapoet.c.w(cls));
        }

        public b u(Iterable<com.squareup.javapoet.a> iterable) {
            r.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33415e.add(it.next());
            }
            return this;
        }

        public b v(String str) {
            return w(str, p.c("", new Object[0]).P());
        }

        public b w(String str, p pVar) {
            r.d(this.f33411a == c.ENUM, "%s is not enum", this.f33412b);
            r.b(pVar.f33397c != null, "enum constants must have anonymous type arguments", new Object[0]);
            r.b(SourceVersion.isName(str), "not a valid enum constant: %s", str);
            this.f33420j.put(str, pVar);
            return this;
        }

        public b x(f fVar) {
            c cVar = this.f33411a;
            r.d(cVar != c.ANNOTATION, "%s %s cannot have fields", cVar, this.f33412b);
            if (this.f33411a == c.INTERFACE) {
                r.k(fVar.f33311e, Modifier.PUBLIC, Modifier.PRIVATE);
                EnumSet enumSetOf = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
                r.d(fVar.f33311e.containsAll(enumSetOf), "%s %s.%s requires modifiers %s", this.f33411a, this.f33412b, fVar.f33308b, enumSetOf);
            }
            this.f33421k.add(fVar);
            return this;
        }

        public b y(o oVar, String str, Modifier... modifierArr) {
            return x(f.a(oVar, str, modifierArr).n());
        }

        public b z(Type type, String str, Modifier... modifierArr) {
            return y(o.h(type), str, modifierArr);
        }

        private b(c cVar, String str, d dVar) {
            this.f33414d = d.a();
            this.f33415e = new ArrayList();
            this.f33416f = new ArrayList();
            this.f33417g = new ArrayList();
            this.f33418h = com.squareup.javapoet.c.f33285y;
            this.f33419i = new ArrayList();
            this.f33420j = new LinkedHashMap();
            this.f33421k = new ArrayList();
            this.f33422l = d.a();
            this.f33423m = d.a();
            this.f33424n = new ArrayList();
            this.f33425o = new ArrayList();
            this.f33426p = new ArrayList();
            r.b(str == null || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f33411a = cVar;
            this.f33412b = str;
            this.f33413c = dVar;
        }
    }

    public enum c {
        CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
        INTERFACE(r.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), r.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), r.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), r.i(Arrays.asList(Modifier.STATIC))),
        ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
        ANNOTATION(r.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), r.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), r.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), r.i(Arrays.asList(Modifier.STATIC)));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Modifier> f33432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<Modifier> f33433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<Modifier> f33434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set<Modifier> f33435d;

        c(Set set, Set set2, Set set3, Set set4) {
            this.f33432a = set;
            this.f33433b = set2;
            this.f33434c = set3;
            this.f33435d = set4;
        }
    }

    public static b a(com.squareup.javapoet.c cVar) {
        return b(((com.squareup.javapoet.c) r.c(cVar, "className == null", new Object[0])).E());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(String str) {
        return new b(c.ANNOTATION, (String) r.c(str, "name == null", new Object[0]), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b c(String str, Object... objArr) {
        return new b(c.CLASS, null, d.a().b(str, objArr).i());
    }

    public static b d(com.squareup.javapoet.c cVar) {
        return e(((com.squareup.javapoet.c) r.c(cVar, "className == null", new Object[0])).E());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b e(String str) {
        return new b(c.CLASS, (String) r.c(str, "name == null", new Object[0]), null);
    }

    public static b g(com.squareup.javapoet.c cVar) {
        return h(((com.squareup.javapoet.c) r.c(cVar, "className == null", new Object[0])).E());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b h(String str) {
        return new b(c.ENUM, (String) r.c(str, "name == null", new Object[0]), null);
    }

    public static b j(com.squareup.javapoet.c cVar) {
        return k(((com.squareup.javapoet.c) r.c(cVar, "className == null", new Object[0])).E());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b k(String str) {
        return new b(c.INTERFACE, (String) r.c(str, "name == null", new Object[0]), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    void f(e eVar, String str, Set<Modifier> set) throws IOException {
        List<o> listEmptyList;
        List<o> listEmptyList2;
        int i7 = eVar.f33306n;
        eVar.f33306n = -1;
        boolean z7 = true;
        try {
            if (str != null) {
                eVar.h(this.f33398d);
                eVar.e(this.f33399e, false);
                eVar.c("$L", str);
                if (!this.f33397c.f33288a.isEmpty()) {
                    eVar.b("(");
                    eVar.a(this.f33397c);
                    eVar.b(")");
                }
                if (this.f33405k.isEmpty() && this.f33408n.isEmpty() && this.f33409o.isEmpty()) {
                    eVar.f33306n = i7;
                    return;
                }
                eVar.b(" {\n");
            } else if (this.f33397c != null) {
                eVar.c("new $T(", !this.f33403i.isEmpty() ? this.f33403i.get(0) : this.f33402h);
                eVar.a(this.f33397c);
                eVar.b(") {\n");
            } else {
                eVar.h(this.f33398d);
                eVar.e(this.f33399e, false);
                eVar.k(this.f33400f, r.m(set, this.f33395a.f33435d));
                c cVar = this.f33395a;
                if (cVar == c.ANNOTATION) {
                    eVar.c("$L $L", "@interface", this.f33396b);
                } else {
                    eVar.c("$L $L", cVar.name().toLowerCase(Locale.US), this.f33396b);
                }
                eVar.m(this.f33401g);
                if (this.f33395a == c.INTERFACE) {
                    listEmptyList = this.f33403i;
                    listEmptyList2 = Collections.emptyList();
                } else {
                    listEmptyList = this.f33402h.equals(com.squareup.javapoet.c.f33285y) ? Collections.emptyList() : Collections.singletonList(this.f33402h);
                    listEmptyList2 = this.f33403i;
                }
                if (!listEmptyList.isEmpty()) {
                    eVar.b(" extends");
                    boolean z8 = true;
                    for (o oVar : listEmptyList) {
                        if (!z8) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", oVar);
                        z8 = false;
                    }
                }
                if (!listEmptyList2.isEmpty()) {
                    eVar.b(" implements");
                    boolean z9 = true;
                    for (o oVar2 : listEmptyList2) {
                        if (!z9) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", oVar2);
                        z9 = false;
                    }
                }
                eVar.b(" {\n");
            }
            eVar.w(this);
            eVar.q();
            Iterator<Map.Entry<String, p>> it = this.f33404j.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, p> next = it.next();
                if (!z7) {
                    eVar.b("\n");
                }
                next.getValue().f(eVar, next.getKey(), Collections.emptySet());
                if (it.hasNext()) {
                    eVar.b(",\n");
                } else if (this.f33405k.isEmpty() && this.f33408n.isEmpty() && this.f33409o.isEmpty()) {
                    eVar.b("\n");
                } else {
                    eVar.b(";\n");
                }
                z7 = false;
            }
            for (f fVar : this.f33405k) {
                if (fVar.d(Modifier.STATIC)) {
                    if (!z7) {
                        eVar.b("\n");
                    }
                    fVar.c(eVar, this.f33395a.f33432a);
                    z7 = false;
                }
            }
            if (!this.f33406l.b()) {
                if (!z7) {
                    eVar.b("\n");
                }
                eVar.a(this.f33406l);
                z7 = false;
            }
            for (f fVar2 : this.f33405k) {
                if (!fVar2.d(Modifier.STATIC)) {
                    if (!z7) {
                        eVar.b("\n");
                    }
                    fVar2.c(eVar, this.f33395a.f33432a);
                    z7 = false;
                }
            }
            if (!this.f33407m.b()) {
                if (!z7) {
                    eVar.b("\n");
                }
                eVar.a(this.f33407m);
                z7 = false;
            }
            for (k kVar : this.f33408n) {
                if (kVar.d()) {
                    if (!z7) {
                        eVar.b("\n");
                    }
                    kVar.b(eVar, this.f33396b, this.f33395a.f33433b);
                    z7 = false;
                }
            }
            for (k kVar2 : this.f33408n) {
                if (!kVar2.d()) {
                    if (!z7) {
                        eVar.b("\n");
                    }
                    kVar2.b(eVar, this.f33396b, this.f33395a.f33433b);
                    z7 = false;
                }
            }
            for (p pVar : this.f33409o) {
                if (!z7) {
                    eVar.b("\n");
                }
                pVar.f(eVar, null, this.f33395a.f33434c);
                z7 = false;
            }
            eVar.A();
            eVar.u();
            eVar.b(com.alipay.sdk.util.j.f13808d);
            if (str == null && this.f33397c == null) {
                eVar.b("\n");
            }
            eVar.f33306n = i7;
        } catch (Throwable th) {
            eVar.f33306n = i7;
            throw th;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean i(Modifier modifier) {
        return this.f33400f.contains(modifier);
    }

    public b l() {
        b bVar = new b(this.f33395a, this.f33396b, this.f33397c);
        bVar.f33414d.a(this.f33398d);
        bVar.f33415e.addAll(this.f33399e);
        bVar.f33416f.addAll(this.f33400f);
        bVar.f33417g.addAll(this.f33401g);
        bVar.f33418h = this.f33402h;
        bVar.f33419i.addAll(this.f33403i);
        bVar.f33420j.putAll(this.f33404j);
        bVar.f33421k.addAll(this.f33405k);
        bVar.f33424n.addAll(this.f33408n);
        bVar.f33425o.addAll(this.f33409o);
        bVar.f33423m.a(this.f33407m);
        bVar.f33422l.a(this.f33406l);
        return bVar;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            f(new e(stringWriter), null, Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private p(b bVar) {
        this.f33395a = bVar.f33411a;
        this.f33396b = bVar.f33412b;
        this.f33397c = bVar.f33413c;
        this.f33398d = bVar.f33414d.i();
        this.f33399e = r.f(bVar.f33415e);
        this.f33400f = r.i(bVar.f33416f);
        this.f33401g = r.f(bVar.f33417g);
        this.f33402h = bVar.f33418h;
        this.f33403i = r.f(bVar.f33419i);
        this.f33404j = r.g(bVar.f33420j);
        this.f33405k = r.f(bVar.f33421k);
        this.f33406l = bVar.f33422l.i();
        this.f33407m = bVar.f33423m.i();
        this.f33408n = r.f(bVar.f33424n);
        this.f33409o = r.f(bVar.f33425o);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.f33426p);
        Iterator it = bVar.f33425o.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((p) it.next()).f33410p);
        }
        this.f33410p = r.f(arrayList);
    }
}
