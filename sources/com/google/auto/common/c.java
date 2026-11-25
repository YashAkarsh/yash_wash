package com.google.auto.common;

import com.google.common.base.a0;
import com.google.common.base.e0;
import com.google.common.base.h0;
import com.google.common.collect.af;
import com.google.common.collect.cb;
import com.google.common.collect.cd;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.e9;
import com.google.common.collect.ma;
import com.google.common.collect.u8;
import com.google.common.collect.ue;
import com.google.common.collect.v7;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.tools.Diagnostic;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends AbstractProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<C0219c> f19209a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ue<d, C0219c> f19210b = cb.b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Elements f19211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Messager f19212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d7<? extends d> f19213e;

    class a implements com.google.common.base.s<Element, C0219c> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0219c apply(Element element) {
            return C0219c.a(element);
        }
    }

    static class b extends SimpleElementVisitor6<TypeElement, Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TypeElement a(Element element, Void r7) {
            return (TypeElement) element.getEnclosingElement().accept(this, r7);
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public TypeElement c(PackageElement packageElement, Void r7) {
            throw new IllegalArgumentException();
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public TypeElement e(TypeElement typeElement, Void r7) {
            return typeElement;
        }
    }

    /* JADX INFO: renamed from: com.google.auto.common.c$c, reason: collision with other inner class name */
    private static final class C0219c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f19215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19216b;

        /* JADX INFO: renamed from: com.google.auto.common.c$c$a */
        private enum a {
            PACKAGE_NAME,
            TYPE_NAME
        }

        private C0219c(a aVar, String str) {
            this.f19215a = (a) e0.E(aVar);
            this.f19216b = (String) e0.E(str);
        }

        static C0219c a(Element element) {
            return element.getKind() == ElementKind.PACKAGE ? b(((PackageElement) element).getQualifiedName().toString()) : c(c.d(element).getQualifiedName().toString());
        }

        static C0219c b(String str) {
            return new C0219c(a.PACKAGE_NAME, str);
        }

        static C0219c c(String str) {
            return new C0219c(a.TYPE_NAME, str);
        }

        a0<? extends Element> d(Elements elements) {
            return a0.d(this.f19215a == a.PACKAGE_NAME ? elements.getPackageElement(this.f19216b) : elements.getTypeElement(this.f19216b));
        }

        String e() {
            return this.f19216b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0219c)) {
                return false;
            }
            C0219c c0219c = (C0219c) obj;
            return this.f19215a == c0219c.f19215a && this.f19216b.equals(c0219c.f19216b);
        }

        public int hashCode() {
            return Objects.hash(this.f19215a, this.f19216b);
        }
    }

    public interface d {
        Set<? extends Class<? extends Annotation>> a();

        Set<? extends Element> b(ue<Class<? extends Annotation>, Element> ueVar);
    }

    private v7<String, a0<? extends Element>> b() {
        v7.b bVarB = v7.b();
        for (C0219c c0219c : this.f19209a) {
            bVarB.f(c0219c.e(), c0219c.d(this.f19211c));
        }
        return bVarB.a();
    }

    private static void c(Element element, u8<? extends Class<? extends Annotation>> u8Var, e9.a<Class<? extends Annotation>, Element> aVar) {
        for (Element element2 : element.getEnclosedElements()) {
            if (!element2.getKind().isClass() && !element2.getKind().isInterface()) {
                c(element2, u8Var, aVar);
            }
        }
        if (element instanceof ExecutableElement) {
            Iterator it = ((ExecutableElement) element).getParameters().iterator();
            while (it.hasNext()) {
                c((Element) it.next(), u8Var, aVar);
            }
        }
        ck<? extends Class<? extends Annotation>> it2 = u8Var.iterator();
        while (it2.hasNext()) {
            Class<? extends Annotation> next = it2.next();
            if (m.m(element, next)) {
                aVar.f(next, element);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeElement d(Element element) {
        return (TypeElement) element.accept(new b(), (Object) null);
    }

    private u8<? extends Class<? extends Annotation>> e() {
        e0.g0(this.f19213e != null);
        u8.a aVarK = u8.k();
        ck<? extends d> it = this.f19213e.iterator();
        while (it.hasNext()) {
            aVarK.c(it.next().a());
        }
        return aVarK.e();
    }

    private e9<Class<? extends Annotation>, Element> h(Set<C0219c> set) {
        u8<? extends Class<? extends Annotation>> u8VarE = e();
        e9.a aVarB0 = e9.b0();
        Iterator<C0219c> it = set.iterator();
        while (it.hasNext()) {
            a0<? extends Element> a0VarD = it.next().d(this.f19211c);
            if (a0VarD.f()) {
                c(a0VarD.e(), u8VarE, aVarB0);
            }
        }
        return aVarB0.a();
    }

    private void m(e9<Class<? extends Annotation>, Element> e9Var) {
        ck<? extends d> it = this.f19213e.iterator();
        while (it.hasNext()) {
            d next = it.next();
            e9 e9VarA = new e9.a().h(h(this.f19210b.get(next))).h(cd.r(e9Var, h0.n(next.a()))).a();
            if (e9VarA.isEmpty()) {
                this.f19210b.a((Object) next);
            } else {
                this.f19210b.b(next, ma.S(next.b(e9VarA), new a()));
            }
        }
    }

    private String o(String str) {
        return String.format("[%s:MiscError] %s was unable to process %s because not all of its dependencies could be resolved. Check for compilation errors or a circular dependency with generated code.", getClass().getSimpleName(), getClass().getCanonicalName(), str);
    }

    private void p(Map<String, ? extends a0<? extends Element>> map, Collection<C0219c> collection) {
        if (!collection.isEmpty()) {
            v7.b bVarB = v7.b();
            bVarB.i(map);
            for (C0219c c0219c : collection) {
                if (!map.containsKey(c0219c.e())) {
                    bVarB.f(c0219c.e(), c0219c.d(this.f19211c));
                }
            }
            map = bVarB.a();
        }
        for (Map.Entry<String, ? extends a0<? extends Element>> entry : map.entrySet()) {
            a0<? extends Element> value = entry.getValue();
            if (value.f()) {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, o("this " + com.google.common.base.c.g(value.e().getKind().name())), value.e());
            } else {
                this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, o(entry.getKey()));
            }
        }
    }

    private e9<Class<? extends Annotation>, Element> q(v7<String, a0<? extends Element>> v7Var, RoundEnvironment roundEnvironment) {
        e9.a aVarB0 = e9.b0();
        ck<Map.Entry<String, a0<? extends Element>>> it = v7Var.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, a0<? extends Element>> next = it.next();
            a0<? extends Element> value = next.getValue();
            if (value.f()) {
                c(value.e(), e(), aVarB0);
            } else {
                this.f19209a.add(C0219c.c(next.getKey()));
            }
        }
        e9 e9VarA = aVarB0.a();
        e9.a aVarB1 = e9.b0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ck<? extends Class<? extends Annotation>> it2 = e().iterator();
        while (it2.hasNext()) {
            Class<? extends Annotation> next2 = it2.next();
            TypeElement typeElement = this.f19211c.getTypeElement(next2.getCanonicalName());
            ck it3 = af.O(typeElement == null ? u8.A() : roundEnvironment.getElementsAnnotatedWith(typeElement), e9VarA.A(next2)).iterator();
            while (it3.hasNext()) {
                PackageElement packageElement = (Element) it3.next();
                boolean z7 = false;
                if (packageElement.getKind().equals(ElementKind.PACKAGE)) {
                    PackageElement packageElement2 = packageElement;
                    C0219c c0219cB = C0219c.b(packageElement2.getQualifiedName().toString());
                    if (linkedHashSet.contains(c0219cB) || (!this.f19209a.contains(c0219cB) && v.l(packageElement2))) {
                        z7 = true;
                    }
                    if (z7) {
                        aVarB1.f(next2, packageElement2);
                        linkedHashSet.add(c0219cB);
                    } else {
                        this.f19209a.add(c0219cB);
                    }
                } else {
                    TypeElement typeElementD = d(packageElement);
                    C0219c c0219cC = C0219c.c(typeElementD.getQualifiedName().toString());
                    if (linkedHashSet.contains(c0219cC) || (!this.f19209a.contains(c0219cC) && v.l(typeElementD))) {
                        z7 = true;
                    }
                    if (z7) {
                        aVarB1.f(next2, packageElement);
                        linkedHashSet.add(c0219cC);
                    } else {
                        this.f19209a.add(c0219cC);
                    }
                }
            }
        }
        return aVarB1.a();
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final u8<String> g() {
        u8.a aVarK = u8.k();
        ck<? extends Class<? extends Annotation>> it = e().iterator();
        while (it.hasNext()) {
            aVarK.a(it.next().getCanonicalName());
        }
        return aVarK.e();
    }

    public final synchronized void i(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.f19211c = processingEnvironment.getElementUtils();
        this.f19212d = processingEnvironment.getMessager();
        this.f19213e = d7.p(j());
    }

    protected abstract Iterable<? extends d> j();

    @Deprecated
    protected void k() {
    }

    protected void l(RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            return;
        }
        k();
    }

    public final boolean n(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        e0.g0(this.f19211c != null);
        e0.g0(this.f19212d != null);
        e0.g0(this.f19213e != null);
        v7<String, a0<? extends Element>> v7VarB = b();
        this.f19209a.clear();
        if (roundEnvironment.processingOver()) {
            l(roundEnvironment);
            p(v7VarB, this.f19210b.values());
            return false;
        }
        m(q(v7VarB, roundEnvironment));
        l(roundEnvironment);
        return false;
    }
}
