package com.google.auto.common;

import com.google.common.base.e0;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes.dex */
public final class u implements AnnotationValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeMirror f19269a;

    private u(TypeMirror typeMirror) {
        e0.y(typeMirror.getKind().isPrimitive() || typeMirror.getKind().equals(TypeKind.DECLARED) || typeMirror.getKind().equals(TypeKind.ARRAY), "value must be a primitive, array, or declared type, but was %s (%s)", typeMirror.getKind(), typeMirror);
        if (typeMirror.getKind().equals(TypeKind.DECLARED)) {
            e0.u(n.g(typeMirror).getTypeArguments().isEmpty(), "value must not be a parameterized type: %s", typeMirror);
        }
        this.f19269a = typeMirror;
    }

    public static AnnotationValue d(TypeMirror typeMirror) {
        return new u(typeMirror);
    }

    public <R, P> R a(AnnotationValueVisitor<R, P> annotationValueVisitor, P p7) {
        return (R) annotationValueVisitor.visitType(b(), p7);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TypeMirror b() {
        return this.f19269a;
    }

    public String toString() {
        return this.f19269a + ".class";
    }
}
