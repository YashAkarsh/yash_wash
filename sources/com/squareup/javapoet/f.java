package com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f33307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f33309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.squareup.javapoet.a> f33310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Modifier> f33311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f33312f;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f33313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f33314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b f33315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<com.squareup.javapoet.a> f33316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<Modifier> f33317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f33318f;

        public b h(com.squareup.javapoet.a aVar) {
            this.f33316d.add(aVar);
            return this;
        }

        public b i(c cVar) {
            this.f33316d.add(com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b j(Class<?> cls) {
            return i(c.w(cls));
        }

        public b k(Iterable<com.squareup.javapoet.a> iterable) {
            r.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33316d.add(it.next());
            }
            return this;
        }

        public b l(String str, Object... objArr) {
            this.f33315c.b(str, objArr);
            return this;
        }

        public b m(Modifier... modifierArr) {
            Collections.addAll(this.f33317e, modifierArr);
            return this;
        }

        public f n() {
            return new f(this);
        }

        public b o(d dVar) {
            r.d(this.f33318f == null, "initializer was already set", new Object[0]);
            this.f33318f = (d) r.c(dVar, "codeBlock == null", new Object[0]);
            return this;
        }

        public b p(String str, Object... objArr) {
            return o(d.c(str, objArr));
        }

        private b(o oVar, String str) {
            this.f33315c = d.a();
            this.f33316d = new ArrayList();
            this.f33317e = new ArrayList();
            this.f33318f = null;
            this.f33313a = oVar;
            this.f33314b = str;
        }
    }

    public static b a(o oVar, String str, Modifier... modifierArr) {
        r.c(oVar, "type == null", new Object[0]);
        r.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(oVar, str).m(modifierArr);
    }

    public static b b(Type type, String str, Modifier... modifierArr) {
        return a(o.h(type), str, modifierArr);
    }

    void c(e eVar, Set<Modifier> set) throws IOException {
        eVar.h(this.f33309c);
        eVar.e(this.f33310d, false);
        eVar.k(this.f33311e, set);
        eVar.c("$T $L", this.f33307a, this.f33308b);
        if (!this.f33312f.b()) {
            eVar.b(" = ");
            eVar.a(this.f33312f);
        }
        eVar.b(";\n");
    }

    public boolean d(Modifier modifier) {
        return this.f33311e.contains(modifier);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b e() {
        b bVar = new b(this.f33307a, this.f33308b);
        bVar.f33315c.a(this.f33309c);
        bVar.f33316d.addAll(this.f33310d);
        bVar.f33317e.addAll(this.f33311e);
        bVar.f33318f = this.f33312f.b() ? null : this.f33312f;
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            c(new e(stringWriter), Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private f(b bVar) {
        this.f33307a = (o) r.c(bVar.f33313a, "type == null", new Object[0]);
        this.f33308b = (String) r.c(bVar.f33314b, "name == null", new Object[0]);
        this.f33309c = bVar.f33315c.i();
        this.f33310d = r.f(bVar.f33316d);
        this.f33311e = r.i(bVar.f33317e);
        this.f33312f = bVar.f33318f == null ? d.a().i() : bVar.f33318f;
    }
}
