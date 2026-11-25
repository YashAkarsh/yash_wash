package com.google.auto.common;

import com.google.common.base.a0;
import com.google.common.base.f0;
import com.google.common.base.g0;
import com.google.common.collect.cb;
import com.google.common.collect.d7;
import com.google.common.collect.u8;
import com.google.common.collect.ue;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleElementVisitor6;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes.dex */
@s1.a
public final class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f19224a;

        a(Set set) {
            this.f19224a = set;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(Element element) {
            return element.getModifiers().containsAll(this.f19224a);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19225a;

        static {
            int[] iArr = new int[w.values().length];
            f19225a = iArr;
            try {
                iArr[w.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19225a[w.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static abstract class c<T> extends SimpleElementVisitor6<T, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19226a;

        c(String str) {
            this.f19226a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T a(Element element, Void r7) {
            throw new IllegalArgumentException(element + " does not represent a " + this.f19226a);
        }
    }

    private static final class d extends c<ExecutableElement> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d f19227b = new d();

        d() {
            super("executable element");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ExecutableElement d(ExecutableElement executableElement, Void r7) {
            return executableElement;
        }
    }

    private static final class e extends c<PackageElement> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final e f19228b = new e();

        e() {
            super("package element");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public PackageElement d(PackageElement packageElement, Void r7) {
            return packageElement;
        }
    }

    private static final class f extends c<TypeElement> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final f f19229b = new f();

        f() {
            super("type element");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public TypeElement d(TypeElement typeElement, Void r7) {
            return typeElement;
        }
    }

    private static final class g extends c<VariableElement> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f19230b = new g();

        g() {
            super("variable element");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public VariableElement d(VariableElement variableElement, Void r7) {
            return variableElement;
        }
    }

    private m() {
    }

    public static ExecutableElement a(Element element) {
        return (ExecutableElement) element.accept(d.f19227b, (Object) null);
    }

    public static PackageElement b(Element element) {
        return (PackageElement) element.accept(e.f19228b, (Object) null);
    }

    public static TypeElement c(Element element) {
        return (TypeElement) element.accept(f.f19229b, (Object) null);
    }

    public static VariableElement d(Element element) {
        return (VariableElement) element.accept(g.f19230b, (Object) null);
    }

    public static a0<AnnotationMirror> e(Element element, Class<? extends Annotation> cls) {
        String canonicalName = cls.getCanonicalName();
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (c(annotationMirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(canonicalName)) {
                return a0.g(annotationMirror);
            }
        }
        return a0.a();
    }

    private static u8<ExecutableElement> f(TypeElement typeElement, o oVar) {
        cb cbVarB0 = cb.b0();
        i(j(typeElement), typeElement, cbVarB0);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = cbVarB0.asMap().values().iterator();
        while (it.hasNext()) {
            d7 d7VarR = d7.r((Collection) it.next());
            int i7 = 0;
            while (i7 < d7VarR.size()) {
                ExecutableElement executableElement = (ExecutableElement) d7VarR.get(i7);
                i7++;
                for (int i8 = i7; i8 < d7VarR.size(); i8++) {
                    if (oVar.a((ExecutableElement) d7VarR.get(i8), executableElement, typeElement)) {
                        linkedHashSet.add(executableElement);
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(cbVarB0.values());
        linkedHashSet2.removeAll(linkedHashSet);
        return u8.p(linkedHashSet2);
    }

    @Deprecated
    public static u8<ExecutableElement> g(TypeElement typeElement, Elements elements) {
        return f(typeElement, new o.c(elements));
    }

    public static u8<ExecutableElement> h(TypeElement typeElement, Types types, Elements elements) {
        return f(typeElement, new o.b(types));
    }

    private static void i(PackageElement packageElement, TypeElement typeElement, ue<String, ExecutableElement> ueVar) {
        Iterator it = typeElement.getInterfaces().iterator();
        while (it.hasNext()) {
            i(packageElement, n.o((TypeMirror) it.next()), ueVar);
        }
        if (typeElement.getSuperclass().getKind() != TypeKind.NONE) {
            i(packageElement, n.o(typeElement.getSuperclass()), ueVar);
        }
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            if (!executableElement.getModifiers().contains(Modifier.STATIC) && o(executableElement, packageElement)) {
                ueVar.put(executableElement.getSimpleName().toString(), executableElement);
            }
        }
    }

    public static PackageElement j(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public static <T extends Element> g0<T> k(Set<Modifier> set) {
        return new a(set);
    }

    public static <T extends Element> g0<T> l(Modifier... modifierArr) {
        return k(u8.t(modifierArr));
    }

    public static boolean m(Element element, Class<? extends Annotation> cls) {
        return e(element, cls).f();
    }

    public static boolean n(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    static boolean o(ExecutableElement executableElement, PackageElement packageElement) {
        int i7 = b.f19225a[w.b(executableElement).ordinal()];
        if (i7 == 1) {
            return false;
        }
        if (i7 != 2) {
            return true;
        }
        return j(executableElement).equals(packageElement);
    }
}
