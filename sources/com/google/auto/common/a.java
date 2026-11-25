package com.google.auto.common;

import com.google.common.base.e0;
import com.google.common.base.f0;
import com.google.common.base.g0;
import com.google.common.collect.ck;
import com.google.common.collect.h5;
import com.google.common.collect.u8;
import com.google.common.collect.v7;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.util.ElementFilter;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.base.l<AnnotationMirror> f19200a = new C0214a();

    /* JADX INFO: renamed from: com.google.auto.common.a$a, reason: collision with other inner class name */
    static class C0214a extends com.google.common.base.l<AnnotationMirror> {
        C0214a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean a(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
            return n.w().d(annotationMirror.getAnnotationType(), annotationMirror2.getAnnotationType()) && com.google.auto.common.b.a().i().d(a.e(annotationMirror).values(), a.e(annotationMirror2).values());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public int b(AnnotationMirror annotationMirror) {
            return Arrays.hashCode(new int[]{n.w().f(annotationMirror.getAnnotationType()), com.google.auto.common.b.a().i().f(a.e(annotationMirror).values())});
        }
    }

    static class b implements g0<AnnotationMirror> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f19201a;

        b(Class cls) {
            this.f19201a = cls;
        }

        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(AnnotationMirror annotationMirror) {
            return m.m(annotationMirror.getAnnotationType().asElement(), this.f19201a);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }
    }

    private a() {
    }

    public static com.google.common.base.l<AnnotationMirror> a() {
        return f19200a;
    }

    public static u8<? extends AnnotationMirror> b(Element element, Class<? extends Annotation> cls) {
        return h5.v(element.getAnnotationMirrors()).p(new b(cls)).M();
    }

    public static Map.Entry<ExecutableElement, AnnotationValue> c(AnnotationMirror annotationMirror, String str) {
        e0.E(annotationMirror);
        e0.E(str);
        ck<Map.Entry<ExecutableElement, AnnotationValue>> it = e(annotationMirror).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ExecutableElement, AnnotationValue> next = it.next();
            if (next.getKey().getSimpleName().contentEquals(str)) {
                return next;
            }
        }
        throw new IllegalArgumentException(String.format("@%s does not define an element %s()", m.c(annotationMirror.getAnnotationType().asElement()).getQualifiedName(), str));
    }

    public static AnnotationValue d(AnnotationMirror annotationMirror, String str) {
        return c(annotationMirror, str).getValue();
    }

    public static v7<ExecutableElement, AnnotationValue> e(AnnotationMirror annotationMirror) {
        v7.b bVarB = v7.b();
        Map elementValues = annotationMirror.getElementValues();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(annotationMirror.getAnnotationType().asElement().getEnclosedElements())) {
            if (elementValues.containsKey(executableElement)) {
                bVarB.f(executableElement, elementValues.get(executableElement));
            } else {
                if (executableElement.getDefaultValue() == null) {
                    throw new IllegalStateException("Unset annotation value without default should never happen: " + m.c(executableElement.getEnclosingElement()).getQualifiedName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + executableElement.getSimpleName() + "()");
                }
                bVarB.f(executableElement, executableElement.getDefaultValue());
            }
        }
        return bVarB.a();
    }
}
