package com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f33334l = "<init>";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final c f33335m = c.w(Override.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f33336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f33337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.squareup.javapoet.a> f33338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Modifier> f33339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<q> f33340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f33341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<m> f33342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f33343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<o> f33344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f33345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f33346k;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f33347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b f33348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<com.squareup.javapoet.a> f33349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Modifier> f33350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<q> f33351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private o f33352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List<m> f33353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Set<o> f33354h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final d.b f33355i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f33356j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private d f33357k;

        public b A(m mVar) {
            this.f33353g.add(mVar);
            return this;
        }

        public b B(o oVar, String str, Modifier... modifierArr) {
            return A(m.a(oVar, str, modifierArr).j());
        }

        public b C(Type type, String str, Modifier... modifierArr) {
            return B(o.h(type), str, modifierArr);
        }

        public b D(Iterable<m> iterable) {
            r.b(iterable != null, "parameterSpecs == null", new Object[0]);
            Iterator<m> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33353g.add(it.next());
            }
            return this;
        }

        public b E(String str, Object... objArr) {
            this.f33355i.c(str, objArr);
            return this;
        }

        public b F(q qVar) {
            this.f33351e.add(qVar);
            return this;
        }

        public b G(Iterable<q> iterable) {
            r.b(iterable != null, "typeVariables == null", new Object[0]);
            Iterator<q> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33351e.add(it.next());
            }
            return this;
        }

        public b H(String str, Object... objArr) {
            this.f33355i.h(str, objArr);
            return this;
        }

        public k I() {
            return new k(this);
        }

        public b J(d dVar) {
            r.d(this.f33357k == null, "defaultValue was already set", new Object[0]);
            this.f33357k = (d) r.c(dVar, "codeBlock == null", new Object[0]);
            return this;
        }

        public b K(String str, Object... objArr) {
            return J(d.c(str, objArr));
        }

        public b L() {
            this.f33355i.j();
            return this;
        }

        public b M(String str, Object... objArr) {
            this.f33355i.k(str, objArr);
            return this;
        }

        public b N(String str, Object... objArr) {
            this.f33355i.m(str, objArr);
            return this;
        }

        public b O(o oVar) {
            r.d(!this.f33347a.equals(k.f33334l), "constructor cannot have return type.", new Object[0]);
            this.f33352f = oVar;
            return this;
        }

        public b P(Type type) {
            return O(o.h(type));
        }

        public b Q() {
            return R(true);
        }

        public b R(boolean z7) {
            this.f33356j = z7;
            return this;
        }

        public b o(com.squareup.javapoet.a aVar) {
            this.f33349c.add(aVar);
            return this;
        }

        public b p(c cVar) {
            this.f33349c.add(com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b q(Class<?> cls) {
            return p(c.w(cls));
        }

        public b r(Iterable<com.squareup.javapoet.a> iterable) {
            r.b(iterable != null, "annotationSpecs == null", new Object[0]);
            Iterator<com.squareup.javapoet.a> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33349c.add(it.next());
            }
            return this;
        }

        public b s(d dVar) {
            this.f33355i.a(dVar);
            return this;
        }

        public b t(String str, Object... objArr) {
            this.f33355i.b(str, objArr);
            return this;
        }

        public b u(o oVar) {
            this.f33354h.add(oVar);
            return this;
        }

        public b v(Type type) {
            return u(o.h(type));
        }

        public b w(Iterable<? extends o> iterable) {
            r.b(iterable != null, "exceptions == null", new Object[0]);
            Iterator<? extends o> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33354h.add(it.next());
            }
            return this;
        }

        public b x(String str, Object... objArr) {
            this.f33348b.b(str, objArr);
            return this;
        }

        public b y(Iterable<Modifier> iterable) {
            r.c(iterable, "modifiers == null", new Object[0]);
            Iterator<Modifier> it = iterable.iterator();
            while (it.hasNext()) {
                this.f33350d.add(it.next());
            }
            return this;
        }

        public b z(Modifier... modifierArr) {
            Collections.addAll(this.f33350d, modifierArr);
            return this;
        }

        private b(String str) {
            this.f33348b = d.a();
            this.f33349c = new ArrayList();
            this.f33350d = new ArrayList();
            this.f33351e = new ArrayList();
            this.f33353g = new ArrayList();
            this.f33354h = new LinkedHashSet();
            this.f33355i = d.a();
            r.b(str.equals(k.f33334l) || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f33347a = str;
            this.f33352f = str.equals(k.f33334l) ? null : o.f33371d;
        }
    }

    public static b a() {
        return new b(f33334l);
    }

    private boolean e(List<m> list) {
        return (list.isEmpty() || o.c(list.get(list.size() - 1).f33363d) == null) ? false : true;
    }

    public static b f(String str) {
        return new b(str);
    }

    public static b g(ExecutableElement executableElement) {
        r.c(executableElement, "method == null", new Object[0]);
        Set modifiers = executableElement.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.FINAL) || modifiers.contains(Modifier.STATIC)) {
            throw new IllegalArgumentException("cannot override method with modifiers: " + modifiers);
        }
        b bVarF = f(executableElement.getSimpleName().toString());
        bVarF.p(f33335m);
        Iterator it = executableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            com.squareup.javapoet.a aVarG = com.squareup.javapoet.a.g((AnnotationMirror) it.next());
            if (!aVarG.f33279a.equals(f33335m)) {
                bVarF.o(aVarG);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(modifiers);
        linkedHashSet.remove(Modifier.ABSTRACT);
        bVarF.y(linkedHashSet);
        Iterator it2 = executableElement.getTypeParameters().iterator();
        while (it2.hasNext()) {
            bVarF.F(q.z(((TypeParameterElement) it2.next()).asType()));
        }
        bVarF.O(o.j(executableElement.getReturnType()));
        for (VariableElement variableElement : executableElement.getParameters()) {
            o oVarJ = o.j(variableElement.asType());
            String string = variableElement.getSimpleName().toString();
            Set modifiers2 = variableElement.getModifiers();
            m.b bVarI = m.a(oVarJ, string, new Modifier[0]).i((Modifier[]) modifiers2.toArray(new Modifier[modifiers2.size()]));
            Iterator it3 = variableElement.getAnnotationMirrors().iterator();
            while (it3.hasNext()) {
                bVarI.e(com.squareup.javapoet.a.g((AnnotationMirror) it3.next()));
            }
            bVarF.A(bVarI.j());
        }
        bVarF.R(executableElement.isVarArgs());
        Iterator it4 = executableElement.getThrownTypes().iterator();
        while (it4.hasNext()) {
            bVarF.u(o.j((TypeMirror) it4.next()));
        }
        return bVarF;
    }

    public static b h(ExecutableElement executableElement, DeclaredType declaredType, Types types) {
        ExecutableType executableTypeAsMemberOf = types.asMemberOf(declaredType, executableElement);
        List parameterTypes = executableTypeAsMemberOf.getParameterTypes();
        TypeMirror returnType = executableTypeAsMemberOf.getReturnType();
        b bVarG = g(executableElement);
        bVarG.O(o.j(returnType));
        int size = bVarG.f33353g.size();
        for (int i7 = 0; i7 < size; i7++) {
            m mVar = (m) bVarG.f33353g.get(i7);
            bVarG.f33353g.set(i7, mVar.f(o.j((TypeMirror) parameterTypes.get(i7)), mVar.f33360a).j());
        }
        return bVarG;
    }

    void b(e eVar, String str, Set<Modifier> set) throws IOException {
        eVar.h(this.f33337b);
        eVar.e(this.f33338c, false);
        eVar.k(this.f33339d, set);
        if (!this.f33340e.isEmpty()) {
            eVar.m(this.f33340e);
            eVar.b(" ");
        }
        if (d()) {
            eVar.c("$L(", str);
        } else {
            eVar.c("$T $L(", this.f33341f, this.f33336a);
        }
        Iterator<m> it = this.f33342g.iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            m next = it.next();
            if (!z7) {
                eVar.b(", ");
            }
            next.c(eVar, !it.hasNext() && this.f33343h);
            z7 = false;
        }
        eVar.b(")");
        d dVar = this.f33346k;
        if (dVar != null && !dVar.b()) {
            eVar.b(" default ");
            eVar.a(this.f33346k);
        }
        if (!this.f33344i.isEmpty()) {
            eVar.b(" throws");
            boolean z8 = true;
            for (o oVar : this.f33344i) {
                if (!z8) {
                    eVar.b(",");
                }
                eVar.c(" $T", oVar);
                z8 = false;
            }
        }
        if (c(Modifier.ABSTRACT)) {
            eVar.b(";\n");
            return;
        }
        if (c(Modifier.NATIVE)) {
            eVar.a(this.f33345j);
            eVar.b(";\n");
            return;
        }
        eVar.b(" {\n");
        eVar.q();
        eVar.a(this.f33345j);
        eVar.A();
        eVar.b("}\n");
    }

    public boolean c(Modifier modifier) {
        return this.f33339d.contains(modifier);
    }

    public boolean d() {
        return this.f33336a.equals(f33334l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public b i() {
        b bVar = new b(this.f33336a);
        bVar.f33348b.a(this.f33337b);
        bVar.f33349c.addAll(this.f33338c);
        bVar.f33350d.addAll(this.f33339d);
        bVar.f33351e.addAll(this.f33340e);
        bVar.f33352f = this.f33341f;
        bVar.f33353g.addAll(this.f33342g);
        bVar.f33354h.addAll(this.f33344i);
        bVar.f33355i.a(this.f33345j);
        bVar.f33356j = this.f33343h;
        bVar.f33357k = this.f33346k;
        return bVar;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), "Constructor", Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private k(b bVar) {
        d dVarI = bVar.f33355i.i();
        r.b(dVarI.b() || !bVar.f33350d.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", bVar.f33347a);
        r.b(!bVar.f33356j || e(bVar.f33353g), "last parameter of varargs method %s must be an array", bVar.f33347a);
        this.f33336a = (String) r.c(bVar.f33347a, "name == null", new Object[0]);
        this.f33337b = bVar.f33348b.i();
        this.f33338c = r.f(bVar.f33349c);
        this.f33339d = r.i(bVar.f33350d);
        this.f33340e = r.f(bVar.f33351e);
        this.f33341f = bVar.f33352f;
        this.f33342g = r.f(bVar.f33353g);
        this.f33343h = bVar.f33356j;
        this.f33344i = r.f(bVar.f33354h);
        this.f33346k = bVar.f33357k;
        this.f33345j = dVarI;
    }
}
