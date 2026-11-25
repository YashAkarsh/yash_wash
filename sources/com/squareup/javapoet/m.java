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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.squareup.javapoet.a> f33361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Modifier> f33362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f33363d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f33364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f33365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<com.squareup.javapoet.a> f33366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Modifier> f33367d;

        public b e(com.squareup.javapoet.a aVar) {
            this.f33366c.add(aVar);
            return this;
        }

        public b f(c cVar) {
            this.f33366c.add(com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b g(Class<?> cls) {
            return f(c.w(cls));
        }

        public b h(Iterable<com.squareup.javapoet.a> iterable) {
            r.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33366c.add(it.next());
            }
            return this;
        }

        public b i(Modifier... modifierArr) {
            Collections.addAll(this.f33367d, modifierArr);
            return this;
        }

        public m j() {
            return new m(this);
        }

        private b(o oVar, String str) {
            this.f33366c = new ArrayList();
            this.f33367d = new ArrayList();
            this.f33364a = oVar;
            this.f33365b = str;
        }
    }

    public static b a(o oVar, String str, Modifier... modifierArr) {
        r.c(oVar, "type == null", new Object[0]);
        r.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(oVar, str).i(modifierArr);
    }

    public static b b(Type type, String str, Modifier... modifierArr) {
        return a(o.h(type), str, modifierArr);
    }

    void c(e eVar, boolean z7) throws IOException {
        eVar.e(this.f33361b, true);
        eVar.j(this.f33362c);
        if (z7) {
            eVar.c("$T... $L", o.c(this.f33363d), this.f33360a);
        } else {
            eVar.c("$T $L", this.f33363d, this.f33360a);
        }
    }

    public boolean d(Modifier modifier) {
        return this.f33362c.contains(modifier);
    }

    public b e() {
        return f(this.f33363d, this.f33360a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    b f(o oVar, String str) {
        b bVar = new b(oVar, str);
        bVar.f33366c.addAll(this.f33361b);
        bVar.f33367d.addAll(this.f33362c);
        return bVar;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            c(new e(stringWriter), false);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private m(b bVar) {
        this.f33360a = (String) r.c(bVar.f33365b, "name == null", new Object[0]);
        this.f33361b = r.f(bVar.f33366c);
        this.f33362c = r.i(bVar.f33367d);
        this.f33363d = (o) r.c(bVar.f33364a, "type == null", new Object[0]);
    }
}
