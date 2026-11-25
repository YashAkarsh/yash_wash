package com.google.auto.common;

import com.google.common.base.e0;
import com.google.common.collect.v7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;

/* JADX INFO: loaded from: classes.dex */
public final class t implements AnnotationMirror {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeElement f19266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v7<String, ? extends AnnotationValue> f19267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v7<ExecutableElement, ? extends AnnotationValue> f19268c;

    private t(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        e0.u(typeElement.getKind().equals(ElementKind.ANNOTATION_TYPE), "annotationType must be an annotation: %s", typeElement);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
            String string = executableElement.getSimpleName().toString();
            if (linkedHashMap2.containsKey(string)) {
                linkedHashMap.put(string, linkedHashMap2.remove(string));
            } else if (executableElement.getDefaultValue() != null) {
                linkedHashMap.put(string, executableElement.getDefaultValue());
            } else {
                arrayList.add(string);
            }
        }
        e0.y(linkedHashMap2.isEmpty(), "namedValues has entries for members that are not in %s: %s", typeElement, linkedHashMap2);
        e0.u(arrayList.isEmpty(), "namedValues is missing entries for: %s", arrayList);
        this.f19266a = typeElement;
        this.f19267b = v7.g(map);
        this.f19268c = (v7) ElementFilter.methodsIn(typeElement.getEnclosedElements()).stream().collect(v7.H(new Function() { // from class: com.google.auto.common.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return t.e((ExecutableElement) obj);
            }
        }, new Function() { // from class: com.google.auto.common.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return t.f(linkedHashMap, (ExecutableElement) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ExecutableElement e(ExecutableElement executableElement) {
        return executableElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotationValue f(Map map, ExecutableElement executableElement) {
        return (AnnotationValue) map.get(executableElement.getSimpleName().toString());
    }

    public static AnnotationMirror g(TypeElement typeElement) {
        return h(typeElement, v7.y());
    }

    public static AnnotationMirror h(TypeElement typeElement, Map<String, ? extends AnnotationValue> map) {
        return new t(typeElement, map);
    }

    public DeclaredType c() {
        return n.g(this.f19266a.asType());
    }

    public Map<ExecutableElement, ? extends AnnotationValue> d() {
        return this.f19268c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AnnotationMirror) && a.a().d(this, (AnnotationMirror) obj);
    }

    public int hashCode() {
        return a.a().f(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("@");
        sb.append((CharSequence) this.f19266a.getQualifiedName());
        if (!this.f19267b.isEmpty()) {
            sb.append('(');
            sb.append(com.google.common.base.w.p(", ").u(" = ").i(this.f19267b));
            sb.append(')');
        }
        return sb.toString();
    }
}
