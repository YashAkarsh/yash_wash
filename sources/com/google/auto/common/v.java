package com.google.auto.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractElementVisitor6;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.lang.model.util.SimpleTypeVisitor6;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ElementVisitor<Boolean, Void> f19270a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TypeVisitor<Boolean, Void> f19271b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AnnotationValueVisitor<Boolean, TypeMirror> f19272c = new c();

    static class a extends AbstractElementVisitor6<Boolean, Void> {
        a() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(ExecutableElement executableElement, Void r7) {
            AnnotationValue defaultValue = executableElement.getDefaultValue();
            return Boolean.valueOf(v.g(executableElement) && (defaultValue == null || v.i(defaultValue, executableElement.getReturnType())) && v.n(executableElement.getReturnType()) && v.o(executableElement.getThrownTypes()) && v.m(executableElement.getTypeParameters()) && v.m(executableElement.getParameters()));
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean d(PackageElement packageElement, Void r7) {
            return Boolean.valueOf(v.k(packageElement.getAnnotationMirrors()));
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean f(TypeElement typeElement, Void r7) {
            return Boolean.valueOf(v.g(typeElement) && v.m(typeElement.getTypeParameters()) && v.o(typeElement.getInterfaces()) && v.n(typeElement.getSuperclass()));
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean h(TypeParameterElement typeParameterElement, Void r7) {
            return Boolean.valueOf(v.g(typeParameterElement) && v.o(typeParameterElement.getBounds()));
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean j(Element element, Void r7) {
            return Boolean.TRUE;
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean l(VariableElement variableElement, Void r7) {
            return Boolean.valueOf(v.g(variableElement));
        }
    }

    static class b extends SimpleTypeVisitor6<Boolean, Void> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(TypeMirror typeMirror, Void r7) {
            return Boolean.TRUE;
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean d(ArrayType arrayType, Void r7) {
            return Boolean.valueOf(v.n(arrayType.getComponentType()));
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean f(DeclaredType declaredType, Void r7) {
            return Boolean.valueOf(v.o(declaredType.getTypeArguments()));
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean h(ErrorType errorType, Void r7) {
            return Boolean.FALSE;
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean j(ExecutableType executableType, Void r7) {
            return Boolean.valueOf(v.o(executableType.getParameterTypes()) && v.n(executableType.getReturnType()) && v.o(executableType.getThrownTypes()) && v.o(executableType.getTypeVariables()));
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean l(TypeMirror typeMirror, Void r7) {
            return b(typeMirror, r7);
        }

        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Boolean n(WildcardType wildcardType, Void r7) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            TypeMirror superBound = wildcardType.getSuperBound();
            return Boolean.valueOf((extendsBound == null || v.n(extendsBound)) && (superBound == null || v.n(superBound)));
        }
    }

    static class c extends SimpleAnnotationValueVisitor6<Boolean, TypeMirror> {
        c() {
        }

        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public Boolean B(AnnotationValue annotationValue, TypeMirror typeMirror) {
            return b(annotationValue, typeMirror);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(Object obj, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(obj.getClass(), typeMirror));
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean d(AnnotationMirror annotationMirror, TypeMirror typeMirror) {
            return Boolean.valueOf(n.w().d(annotationMirror.getAnnotationType(), typeMirror) && v.h(annotationMirror));
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean f(List<? extends AnnotationValue> list, TypeMirror typeMirror) {
            if (!typeMirror.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.FALSE;
            }
            try {
                TypeMirror componentType = n.f(typeMirror).getComponentType();
                Iterator<? extends AnnotationValue> it = list.iterator();
                while (it.hasNext()) {
                    if (!((Boolean) it.next().accept(this, componentType)).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            } catch (IllegalArgumentException unused) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean h(boolean z7, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Boolean.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean j(byte b8, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Byte.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean l(char c8, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Character.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Boolean n(double d8, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Double.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Boolean p(VariableElement variableElement, TypeMirror typeMirror) {
            return Boolean.valueOf(n.w().d(variableElement.asType(), typeMirror) && v.l(variableElement));
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean r(float f8, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Float.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Boolean t(int i7, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Integer.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Boolean v(long j7, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Long.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public Boolean x(short s7, TypeMirror typeMirror) {
            return Boolean.valueOf(n.B(Short.TYPE, typeMirror));
        }

        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public Boolean z(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return Boolean.valueOf(v.n(typeMirror));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Element element) {
        return n(element.asType()) && k(element.getAnnotationMirrors()) && m(element.getEnclosedElements());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(AnnotationMirror annotationMirror) {
        return n(annotationMirror.getAnnotationType()) && j(annotationMirror.getElementValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(AnnotationValue annotationValue, TypeMirror typeMirror) {
        return ((Boolean) annotationValue.accept(f19272c, typeMirror)).booleanValue();
    }

    private static boolean j(Map<? extends ExecutableElement, ? extends AnnotationValue> map) {
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : map.entrySet()) {
            if (!i(entry.getValue(), entry.getKey().getReturnType())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(Iterable<? extends AnnotationMirror> iterable) {
        Iterator<? extends AnnotationMirror> it = iterable.iterator();
        while (it.hasNext()) {
            if (!h(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(Element element) {
        return ((Boolean) element.accept(f19270a, (Object) null)).booleanValue();
    }

    public static boolean m(Iterable<? extends Element> iterable) {
        Iterator<? extends Element> it = iterable.iterator();
        while (it.hasNext()) {
            if (!l(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(f19271b, (Object) null)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Iterable<? extends TypeMirror> iterable) {
        Iterator<? extends TypeMirror> it = iterable.iterator();
        while (it.hasNext()) {
            if (!n(it.next())) {
                return false;
            }
        }
        return true;
    }
}
