package com.google.auto.common;

import com.google.common.base.e0;
import com.google.common.base.u0;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.ib;
import com.google.common.collect.wb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes.dex */
abstract class o {

    static class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Types f19261a;

        private class a extends SimpleTypeVisitor6<TypeMirror, Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Map<TypeParameterElement, TypeMirror> f19262a;

            private a() {
                this.f19262a = wb.m0();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public TypeMirror a(TypeMirror typeMirror, Void r7) {
                return typeMirror;
            }

            d7<TypeMirror> c(ExecutableElement executableElement, TypeElement typeElement) {
                if (executableElement.getEnclosingElement().equals(typeElement)) {
                    d7.b bVarM = d7.m();
                    Iterator it = executableElement.getParameters().iterator();
                    while (it.hasNext()) {
                        bVarM.a(b.this.f19261a.erasure((TypeMirror) visit(((VariableElement) it.next()).asType())));
                    }
                    return bVarM.e();
                }
                ArrayList arrayListQ = ib.q();
                if (typeElement.getSuperclass().getKind() == TypeKind.DECLARED) {
                    arrayListQ.add(typeElement.getSuperclass());
                }
                arrayListQ.addAll(typeElement.getInterfaces());
                Iterator it2 = arrayListQ.iterator();
                while (it2.hasNext()) {
                    DeclaredType declaredTypeG = n.g((TypeMirror) it2.next());
                    TypeElement typeElementC = m.c(declaredTypeG.asElement());
                    List typeArguments = declaredTypeG.getTypeArguments();
                    List typeParameters = typeElementC.getTypeParameters();
                    u0.a(typeArguments.size() == typeParameters.size());
                    for (int i7 = 0; i7 < typeArguments.size(); i7++) {
                        this.f19262a.put((TypeParameterElement) typeParameters.get(i7), (TypeMirror) typeArguments.get(i7));
                    }
                    d7<TypeMirror> d7VarC = c(executableElement, typeElementC);
                    if (d7VarC != null) {
                        return d7VarC;
                    }
                }
                return null;
            }

            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public TypeMirror d(ArrayType arrayType, Void r7) {
                return b.this.f19261a.getArrayType((TypeMirror) visit(arrayType.getComponentType()));
            }

            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public TypeMirror f(DeclaredType declaredType, Void r7) {
                if (declaredType.getTypeArguments().isEmpty()) {
                    return declaredType;
                }
                ArrayList arrayListQ = ib.q();
                Iterator it = declaredType.getTypeArguments().iterator();
                while (it.hasNext()) {
                    arrayListQ.add(visit((TypeMirror) it.next()));
                }
                return b.this.f19261a.getDeclaredType(b.this.d(declaredType), (TypeMirror[]) arrayListQ.toArray(new TypeMirror[0]));
            }

            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public TypeMirror h(TypeVariable typeVariable, Void r7) {
                TypeParameterElement typeParameterElementAsElement = b.this.f19261a.asElement(typeVariable);
                if (typeParameterElementAsElement instanceof TypeParameterElement) {
                    TypeParameterElement typeParameterElement = typeParameterElementAsElement;
                    if (this.f19262a.containsKey(typeParameterElement)) {
                        return (TypeMirror) visit(this.f19262a.get(typeParameterElement));
                    }
                }
                return (TypeMirror) visit(b.this.f19261a.erasure(typeVariable.getUpperBound()));
            }
        }

        b(Types types) {
            this.f19261a = types;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TypeElement d(TypeMirror typeMirror) {
            return m.c(n.g(typeMirror).asElement());
        }

        private boolean f(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            DeclaredType declaredTypeG = n.g(typeElement.asType());
            try {
                return this.f19261a.isSubsignature(n.j(this.f19261a.asMemberOf(declaredTypeG, executableElement)), n.j(this.f19261a.asMemberOf(declaredTypeG, executableElement2)));
            } catch (IllegalArgumentException unused) {
                int size = executableElement.getParameters().size();
                if (executableElement2.getParameters().size() != size) {
                    return false;
                }
                d7<TypeMirror> d7VarE = e(executableElement, typeElement);
                d7<TypeMirror> d7VarE2 = e(executableElement2, typeElement);
                if (d7VarE == null || d7VarE2 == null) {
                    return false;
                }
                for (int i7 = 0; i7 < size; i7++) {
                    if (!this.f19261a.isSameType(d7VarE.get(i7), d7VarE2.get(i7))) {
                        return false;
                    }
                }
                return true;
            }
        }

        private ExecutableElement i(TypeElement typeElement, ExecutableElement executableElement) {
            int size = executableElement.getParameters().size();
            d7<TypeMirror> d7VarE = e(executableElement, typeElement);
            if (d7VarE == null) {
                return null;
            }
            for (ExecutableElement executableElement2 : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
                if (executableElement2.getSimpleName().equals(executableElement.getSimpleName()) && executableElement2.getParameters().size() == size) {
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f19261a.isSameType(d7VarE.get(i7), this.f19261a.erasure(((VariableElement) executableElement2.getParameters().get(i7)).asType()))) {
                        }
                    }
                    return executableElement2;
                }
            }
            return null;
        }

        private TypeElement j(TypeElement typeElement) {
            TypeMirror superclass = typeElement.getSuperclass();
            if (superclass.getKind() == TypeKind.DECLARED) {
                return m.c(this.f19261a.asElement(superclass));
            }
            return null;
        }

        private d7<TypeElement> k(TypeElement typeElement) {
            d7.b bVarM = d7.m();
            Iterator it = typeElement.getInterfaces().iterator();
            while (it.hasNext()) {
                bVarM.a(m.c(this.f19261a.asElement((TypeMirror) it.next())));
            }
            return bVarM.e();
        }

        @Override // com.google.auto.common.o
        public boolean a(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            if (!executableElement.getSimpleName().equals(executableElement2.getSimpleName()) || executableElement.getEnclosingElement().equals(executableElement2.getEnclosingElement()) || executableElement2.getModifiers().contains(Modifier.STATIC)) {
                return false;
            }
            w wVarB = w.b(executableElement2);
            w wVarB2 = w.b(executableElement);
            if (wVarB.equals(w.PRIVATE) || wVarB2.compareTo(wVarB) < 0 || !f(executableElement, executableElement2, typeElement) || !m.o(executableElement2, m.j(executableElement)) || !(executableElement2.getEnclosingElement() instanceof TypeElement)) {
                return false;
            }
            TypeElement typeElementC = m.c(executableElement2.getEnclosingElement());
            Types types = this.f19261a;
            if (!types.isSubtype(types.erasure(typeElement.asType()), this.f19261a.erasure(typeElementC.asType()))) {
                return false;
            }
            if (!typeElement.getKind().isClass()) {
                return typeElement.getKind().isInterface();
            }
            if (typeElementC.getKind().isClass()) {
                return !executableElement2.getEnclosingElement().equals(g(typeElement, executableElement2).getEnclosingElement());
            }
            if (!typeElementC.getKind().isInterface()) {
                return false;
            }
            if (!executableElement.getModifiers().contains(Modifier.ABSTRACT)) {
                return true;
            }
            return !executableElement2.getEnclosingElement().equals(h(typeElement, executableElement2).getEnclosingElement());
        }

        d7<TypeMirror> e(ExecutableElement executableElement, TypeElement typeElement) {
            return executableElement.getParameters().isEmpty() ? d7.x() : new a().c(executableElement, typeElement);
        }

        ExecutableElement g(TypeElement typeElement, ExecutableElement executableElement) {
            while (typeElement != null) {
                ExecutableElement executableElementI = i(typeElement, executableElement);
                if (executableElementI != null) {
                    return executableElementI;
                }
                typeElement = j(typeElement);
            }
            return null;
        }

        ExecutableElement h(TypeElement typeElement, ExecutableElement executableElement) {
            TypeElement typeElementJ;
            TypeElement typeElementC = m.c(executableElement.getEnclosingElement());
            e0.d(typeElementC.getKind().isInterface());
            TypeMirror typeMirrorErasure = this.f19261a.erasure(typeElementC.asType());
            d7 d7VarZ = d7.z(typeElement);
            while (!d7VarZ.isEmpty()) {
                d7.b bVarM = d7.m();
                ck it = d7VarZ.iterator();
                while (it.hasNext()) {
                    TypeElement typeElement2 = (TypeElement) it.next();
                    if (this.f19261a.isAssignable(this.f19261a.erasure(typeElement2.asType()), typeMirrorErasure)) {
                        ExecutableElement executableElementI = i(typeElement2, executableElement);
                        if (executableElementI != null) {
                            return executableElementI;
                        }
                        bVarM.c(k(typeElement2));
                    }
                    if (typeElement2.getKind().isClass() && (typeElementJ = j(typeElement2)) != null) {
                        bVarM.a(typeElementJ);
                    }
                }
                d7VarZ = bVarM.e();
            }
            return null;
        }
    }

    static class c extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Elements f19264a;

        c(Elements elements) {
            this.f19264a = elements;
        }

        @Override // com.google.auto.common.o
        boolean a(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement) {
            return this.f19264a.overrides(executableElement, executableElement2, typeElement);
        }
    }

    o() {
    }

    abstract boolean a(ExecutableElement executableElement, ExecutableElement executableElement2, TypeElement typeElement);
}
