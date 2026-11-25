package com.google.auto.common;

import com.google.common.base.a0;
import com.google.common.base.e0;
import com.google.common.base.f0;
import com.google.common.base.g0;
import com.google.common.base.r0;
import com.google.common.base.y;
import com.google.common.collect.d7;
import com.google.common.collect.h5;
import com.google.common.collect.ma;
import com.google.common.collect.u8;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.SimpleTypeVisitor6;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f19231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f19232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19233c = 17;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19234d = 31;

    static class a implements g0<TypeMirror> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Types f19235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TypeMirror f19236b;

        a(Types types, TypeMirror typeMirror) {
            this.f19235a = types;
            this.f19236b = typeMirror;
        }

        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(TypeMirror typeMirror) {
            return typeMirror.getKind().equals(TypeKind.DECLARED) && com.google.auto.common.m.c(n.g(typeMirror).asElement()).getKind().equals(ElementKind.CLASS) && !this.f19235a.isSameType(this.f19236b, typeMirror);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19237a;

        static {
            int[] iArr = new int[TypeKind.values().length];
            f19237a = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19237a[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19237a[TypeKind.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19237a[TypeKind.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19237a[TypeKind.FLOAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19237a[TypeKind.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19237a[TypeKind.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19237a[TypeKind.SHORT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static final class c extends e<ArrayType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final c f19238b = new c();

        c() {
            super("primitive array");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ArrayType d(ArrayType arrayType, Void r7) {
            return arrayType;
        }
    }

    private static final class d extends SimpleTypeVisitor6<Element, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f19239a = new d();

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Element b(TypeMirror typeMirror, Void r7) {
            throw new IllegalArgumentException(typeMirror + " cannot be converted to an Element");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Element d(DeclaredType declaredType, Void r7) {
            return declaredType.asElement();
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Element f(ErrorType errorType, Void r7) {
            return errorType.asElement();
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Element h(TypeVariable typeVariable, Void r7) {
            return typeVariable.asElement();
        }
    }

    private static abstract class e<T> extends SimpleTypeVisitor6<T, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19240a;

        e(String str) {
            this.f19240a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public T a(TypeMirror typeMirror, Void r7) {
            throw new IllegalArgumentException(typeMirror + " does not represent a " + this.f19240a);
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Element f19241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d7<TypeMirror> f19242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Element f19243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final d7<TypeMirror> f19244d;

        f(Element element, d7<TypeMirror> d7Var, Element element2, d7<TypeMirror> d7Var2) {
            this.f19241a = element;
            this.f19242b = d7Var;
            this.f19243c = element2;
            this.f19244d = d7Var2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                int size = this.f19242b.size();
                if (this.f19241a.equals(fVar.f19241a) && this.f19243c.equals(fVar.f19243c) && size == this.f19244d.size()) {
                    for (int i7 = 0; i7 < size; i7++) {
                        if (this.f19242b.get(i7) != this.f19244d.get(i7)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f19241a.hashCode() * 31) + this.f19243c.hashCode();
        }
    }

    private static final class g extends e<DeclaredType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f19245b = new g();

        g() {
            super("declared type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public DeclaredType d(DeclaredType declaredType, Void r7) {
            return declaredType;
        }
    }

    private static final class h extends SimpleTypeVisitor6<Boolean, i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f19246a = new h();

        private h() {
        }

        private Set<f> r(Set<f> set, Element element, List<? extends TypeMirror> list, Element element2, List<? extends TypeMirror> list2) {
            f fVar = new f(element, d7.r(list), element2, d7.r(list2));
            HashSet hashSet = new HashSet(set);
            hashSet.add(fVar);
            return hashSet;
        }

        private Set<f> s(Set<f> set, Element element, Element element2) {
            d7 d7VarX = d7.x();
            return r(set, element, d7VarX, element2, d7VarX);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean c(TypeMirror typeMirror, i iVar) {
            return Boolean.valueOf(typeMirror.getKind().equals(iVar.f19247a.getKind()));
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean e(ArrayType arrayType, i iVar) {
            if (!iVar.f19247a.getKind().equals(TypeKind.ARRAY)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(n.t(arrayType.getComponentType(), iVar.f19247a.getComponentType(), iVar.f19248b));
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean g(DeclaredType declaredType, i iVar) {
            if (!iVar.f19247a.getKind().equals(TypeKind.DECLARED)) {
                return Boolean.FALSE;
            }
            DeclaredType declaredType2 = iVar.f19247a;
            Element elementAsElement = declaredType.asElement();
            Element elementAsElement2 = declaredType2.asElement();
            Set<f> setR = r(iVar.f19248b, elementAsElement, declaredType.getTypeArguments(), elementAsElement2, declaredType2.getTypeArguments());
            if (setR.equals(iVar.f19248b)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(elementAsElement.equals(elementAsElement2) && n.t(n.s(declaredType), n.s(declaredType2), setR) && n.v(declaredType.getTypeArguments(), declaredType2.getTypeArguments(), setR));
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean i(ErrorType errorType, i iVar) {
            return Boolean.valueOf(errorType.equals(iVar.f19247a));
        }

        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean k(ExecutableType executableType, i iVar) {
            if (!iVar.f19247a.getKind().equals(TypeKind.EXECUTABLE)) {
                return Boolean.FALSE;
            }
            ExecutableType executableType2 = iVar.f19247a;
            return Boolean.valueOf(n.v(executableType.getParameterTypes(), executableType2.getParameterTypes(), iVar.f19248b) && n.t(executableType.getReturnType(), executableType2.getReturnType(), iVar.f19248b) && n.v(executableType.getThrownTypes(), executableType2.getThrownTypes(), iVar.f19248b) && n.v(executableType.getTypeVariables(), executableType2.getTypeVariables(), iVar.f19248b));
        }

        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Boolean m(TypeVariable typeVariable, i iVar) {
            if (!iVar.f19247a.getKind().equals(TypeKind.TYPEVAR)) {
                return Boolean.FALSE;
            }
            TypeVariable typeVariable2 = iVar.f19247a;
            TypeParameterElement typeParameterElementAsElement = typeVariable.asElement();
            TypeParameterElement typeParameterElementAsElement2 = typeVariable2.asElement();
            Set<f> setS = s(iVar.f19248b, typeParameterElementAsElement, typeParameterElementAsElement2);
            if (setS.equals(iVar.f19248b)) {
                return Boolean.TRUE;
            }
            return Boolean.valueOf(n.v(typeParameterElementAsElement.getBounds(), typeParameterElementAsElement2.getBounds(), setS) && n.t(typeVariable.getLowerBound(), typeVariable2.getLowerBound(), setS) && typeVariable.asElement().getSimpleName().equals(typeVariable2.asElement().getSimpleName()));
        }

        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Boolean o(TypeMirror typeMirror, i iVar) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Boolean q(WildcardType wildcardType, i iVar) {
            if (!iVar.f19247a.getKind().equals(TypeKind.WILDCARD)) {
                return Boolean.FALSE;
            }
            WildcardType wildcardType2 = iVar.f19247a;
            return Boolean.valueOf(n.t(wildcardType.getExtendsBound(), wildcardType2.getExtendsBound(), iVar.f19248b) && n.t(wildcardType.getSuperBound(), wildcardType2.getSuperBound(), iVar.f19248b));
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TypeMirror f19247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Set<f> f19248b;

        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    private static final class j extends e<ErrorType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final j f19249b = new j();

        j() {
            super("error type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ErrorType d(ErrorType errorType, Void r7) {
            return errorType;
        }
    }

    private static final class k extends e<ExecutableType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final k f19250b = new k();

        k() {
            super("executable type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ExecutableType d(ExecutableType executableType, Void r7) {
            return executableType;
        }
    }

    private static final class l extends SimpleTypeVisitor6<Integer, Set<Element>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f19251a = new l();

        private l() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer c(TypeMirror typeMirror, Set<Element> set) {
            return Integer.valueOf(d(17, typeMirror));
        }

        int d(int i7, TypeMirror typeMirror) {
            return (i7 * 31) + typeMirror.getKind().hashCode();
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer f(ArrayType arrayType, Set<Element> set) {
            return Integer.valueOf((d(17, arrayType) * 31) + ((Integer) arrayType.getComponentType().accept(this, set)).intValue());
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer h(DeclaredType declaredType, Set<Element> set) {
            Element elementAsElement = declaredType.asElement();
            if (set.contains(elementAsElement)) {
                return 0;
            }
            HashSet hashSet = new HashSet(set);
            hashSet.add(elementAsElement);
            return Integer.valueOf((((((d(17, declaredType) * 31) + declaredType.asElement().hashCode()) * 31) + ((Integer) declaredType.getEnclosingType().accept(this, hashSet)).intValue()) * 31) + n.y(declaredType.getTypeArguments(), hashSet));
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer j(ExecutableType executableType, Set<Element> set) {
            return Integer.valueOf((((((((d(17, executableType) * 31) + n.y(executableType.getParameterTypes(), set)) * 31) + ((Integer) executableType.getReturnType().accept(this, set)).intValue()) * 31) + n.y(executableType.getThrownTypes(), set)) * 31) + n.y(executableType.getTypeVariables(), set));
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer l(TypeVariable typeVariable, Set<Element> set) {
            int iD = (d(17, typeVariable) * 31) + ((Integer) typeVariable.getLowerBound().accept(this, set)).intValue();
            Iterator it = typeVariable.asElement().getBounds().iterator();
            while (it.hasNext()) {
                iD = (iD * 31) + ((Integer) ((TypeMirror) it.next()).accept(this, set)).intValue();
            }
            return Integer.valueOf(iD);
        }

        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Integer n(TypeMirror typeMirror, Set<Element> set) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Integer p(WildcardType wildcardType, Set<Element> set) {
            return Integer.valueOf((((d(17, wildcardType) * 31) + (wildcardType.getExtendsBound() == null ? 0 : ((Integer) wildcardType.getExtendsBound().accept(this, set)).intValue())) * 31) + (wildcardType.getSuperBound() != null ? ((Integer) wildcardType.getSuperBound().accept(this, set)).intValue() : 0));
        }
    }

    private static final class m extends SimpleTypeVisitor6<Boolean, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f19252a;

        m(Class<?> cls) {
            this.f19252a = cls;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean b(TypeMirror typeMirror, Void r7) {
            throw new IllegalArgumentException(typeMirror + " cannot be represented as a Class<?>.");
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean d(ArrayType arrayType, Void r7) {
            return Boolean.valueOf(this.f19252a.isArray() && n.B(this.f19252a.getComponentType(), arrayType.getComponentType()));
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean f(DeclaredType declaredType, Void r7) {
            try {
                return Boolean.valueOf(com.google.auto.common.m.c(declaredType.asElement()).getQualifiedName().contentEquals(this.f19252a.getCanonicalName()));
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException(declaredType + " does not represent a class or interface.");
            }
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean h(NoType noType, Void r7) {
            if (noType.getKind().equals(TypeKind.VOID)) {
                return Boolean.valueOf(this.f19252a.equals(Void.TYPE));
            }
            throw new IllegalArgumentException(noType + " cannot be represented as a Class<?>.");
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean j(PrimitiveType primitiveType, Void r7) {
            switch (b.f19237a[primitiveType.getKind().ordinal()]) {
                case 1:
                    return Boolean.valueOf(this.f19252a.equals(Boolean.TYPE));
                case 2:
                    return Boolean.valueOf(this.f19252a.equals(Byte.TYPE));
                case 3:
                    return Boolean.valueOf(this.f19252a.equals(Character.TYPE));
                case 4:
                    return Boolean.valueOf(this.f19252a.equals(Double.TYPE));
                case 5:
                    return Boolean.valueOf(this.f19252a.equals(Float.TYPE));
                case 6:
                    return Boolean.valueOf(this.f19252a.equals(Integer.TYPE));
                case 7:
                    return Boolean.valueOf(this.f19252a.equals(Long.TYPE));
                case 8:
                    return Boolean.valueOf(this.f19252a.equals(Short.TYPE));
                default:
                    throw new IllegalArgumentException(primitiveType + " cannot be represented as a Class<?>.");
            }
        }
    }

    /* JADX INFO: renamed from: com.google.auto.common.n$n, reason: collision with other inner class name */
    private static final class C0220n extends SimpleTypeVisitor6<Boolean, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0220n f19253a = new C0220n();

        private C0220n() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean c(TypeMirror typeMirror, Void r7) {
            return Boolean.FALSE;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean e(ArrayType arrayType, Void r7) {
            return Boolean.TRUE;
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean g(DeclaredType declaredType, Void r7) {
            return Boolean.valueOf(com.google.auto.common.m.n(declaredType.asElement()));
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean i(NoType noType, Void r7) {
            return Boolean.valueOf(noType.getKind().equals(TypeKind.VOID));
        }

        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean k(PrimitiveType primitiveType, Void r7) {
            return Boolean.TRUE;
        }
    }

    private static final class o extends e<NoType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final o f19254b = new o();

        o() {
            super("non-type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NoType d(NoType noType, Void r7) {
            return noType;
        }
    }

    private static final class p extends e<NullType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final p f19255b = new p();

        p() {
            super("null");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NullType d(NullType nullType, Void r7) {
            return nullType;
        }
    }

    private static final class q extends e<PrimitiveType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final q f19256b = new q();

        q() {
            super("primitive type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public PrimitiveType d(PrimitiveType primitiveType, Void r7) {
            return primitiveType;
        }
    }

    private static final class r extends SimpleTypeVisitor6<Void, u8.a<TypeElement>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final r f19257a = new r();

        private r() {
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void b(ArrayType arrayType, u8.a<TypeElement> aVar) {
            arrayType.getComponentType().accept(this, aVar);
            return null;
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void d(DeclaredType declaredType, u8.a<TypeElement> aVar) {
            aVar.a(com.google.auto.common.m.c(declaredType.asElement()));
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                ((TypeMirror) it.next()).accept(this, aVar);
            }
            return null;
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Void f(TypeVariable typeVariable, u8.a<TypeElement> aVar) {
            typeVariable.getLowerBound().accept(this, aVar);
            typeVariable.getUpperBound().accept(this, aVar);
            return null;
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Void h(WildcardType wildcardType, u8.a<TypeElement> aVar) {
            TypeMirror extendsBound = wildcardType.getExtendsBound();
            if (extendsBound != null) {
                extendsBound.accept(this, aVar);
            }
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return null;
            }
            superBound.accept(this, aVar);
            return null;
        }
    }

    private static final class s extends com.google.common.base.l<TypeMirror> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final s f19258a = new s();

        private s() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean a(TypeMirror typeMirror, TypeMirror typeMirror2) {
            return n.t(typeMirror, typeMirror2, u8.A());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public int b(TypeMirror typeMirror) {
            return n.x(typeMirror, u8.A());
        }
    }

    private static final class t extends e<TypeVariable> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final t f19259b = new t();

        t() {
            super("type variable");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public TypeVariable d(TypeVariable typeVariable, Void r7) {
            return typeVariable;
        }
    }

    private static final class u extends e<WildcardType> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final u f19260b = new u();

        u() {
            super("wildcard type");
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public WildcardType d(WildcardType wildcardType, Void r7) {
            return wildcardType;
        }
    }

    static {
        Class<?> cls;
        Method method;
        try {
            cls = Class.forName("javax.lang.model.type.IntersectionType");
            method = cls.getMethod("getBounds", new Class[0]);
        } catch (Exception unused) {
            cls = null;
            method = null;
        }
        f19231a = cls;
        f19232b = method;
    }

    private n() {
    }

    public static boolean A(TypeMirror typeMirror) {
        return ((Boolean) typeMirror.accept(C0220n.f19253a, (Object) null)).booleanValue();
    }

    public static boolean B(Class<?> cls, TypeMirror typeMirror) {
        e0.E(cls);
        return ((Boolean) typeMirror.accept(new m(cls), (Object) null)).booleanValue();
    }

    public static a0<DeclaredType> C(Types types, Elements elements, DeclaredType declaredType) {
        e0.E(types);
        e0.E(elements);
        e0.E(declaredType);
        TypeMirror typeMirror = (TypeMirror) ma.A(h5.v(types.directSupertypes(declaredType)).p(new a(types, elements.getTypeElement(Object.class.getCanonicalName()).asType())), null);
        return typeMirror != null ? a0.g(g(typeMirror)) : a0.a();
    }

    public static u8<TypeElement> D(TypeMirror typeMirror) {
        e0.E(typeMirror);
        u8.a aVarK = u8.k();
        typeMirror.accept(r.f19257a, aVarK);
        return aVarK.e();
    }

    public static ArrayType f(TypeMirror typeMirror) {
        return (ArrayType) typeMirror.accept(c.f19238b, (Object) null);
    }

    public static DeclaredType g(TypeMirror typeMirror) {
        return (DeclaredType) typeMirror.accept(g.f19245b, (Object) null);
    }

    public static Element h(TypeMirror typeMirror) {
        return (Element) typeMirror.accept(d.f19239a, (Object) null);
    }

    public static ErrorType i(TypeMirror typeMirror) {
        return (ErrorType) typeMirror.accept(j.f19249b, (Object) null);
    }

    public static ExecutableType j(TypeMirror typeMirror) {
        return (ExecutableType) typeMirror.accept(k.f19250b, (Object) null);
    }

    public static TypeMirror k(Types types, DeclaredType declaredType, VariableElement variableElement) {
        if (!variableElement.getKind().equals(ElementKind.PARAMETER)) {
            return types.asMemberOf(declaredType, variableElement);
        }
        ExecutableElement executableElementA = com.google.auto.common.m.a(variableElement.getEnclosingElement());
        ExecutableType executableTypeJ = j(types.asMemberOf(declaredType, executableElementA));
        List parameters = executableElementA.getParameters();
        List parameterTypes = executableTypeJ.getParameterTypes();
        e0.g0(parameters.size() == parameterTypes.size());
        for (int i7 = 0; i7 < parameters.size(); i7++) {
            if (((VariableElement) parameters.get(i7)).equals(variableElement)) {
                return (TypeMirror) parameterTypes.get(i7);
            }
        }
        throw new IllegalStateException("Could not find variable: " + variableElement);
    }

    public static NoType l(TypeMirror typeMirror) {
        return (NoType) typeMirror.accept(o.f19254b, (Object) null);
    }

    public static NullType m(TypeMirror typeMirror) {
        return (NullType) typeMirror.accept(p.f19255b, (Object) null);
    }

    public static PrimitiveType n(TypeMirror typeMirror) {
        return (PrimitiveType) typeMirror.accept(q.f19256b, (Object) null);
    }

    public static TypeElement o(TypeMirror typeMirror) {
        return com.google.auto.common.m.c(h(typeMirror));
    }

    public static u8<TypeElement> p(Iterable<? extends TypeMirror> iterable) {
        e0.E(iterable);
        u8.a aVarK = u8.k();
        Iterator<? extends TypeMirror> it = iterable.iterator();
        while (it.hasNext()) {
            aVarK.a(o(it.next()));
        }
        return aVarK.e();
    }

    public static TypeVariable q(TypeMirror typeMirror) {
        return (TypeVariable) typeMirror.accept(t.f19259b, (Object) null);
    }

    public static WildcardType r(TypeMirror typeMirror) {
        return (WildcardType) typeMirror.accept(u.f19260b, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeMirror s(DeclaredType declaredType) {
        TypeMirror enclosingType = declaredType.getEnclosingType();
        if (enclosingType.getKind().equals(TypeKind.NONE) || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
            return null;
        }
        return enclosingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(TypeMirror typeMirror, TypeMirror typeMirror2, Set<f> set) {
        if (y.a(typeMirror, typeMirror2) && !(typeMirror instanceof ExecutableType)) {
            return true;
        }
        i iVar = new i(null);
        iVar.f19247a = typeMirror2;
        iVar.f19248b = set;
        if (f19231a != null) {
            if (z(typeMirror)) {
                return u(typeMirror, typeMirror2, set);
            }
            if (z(typeMirror2)) {
                return false;
            }
        }
        if (typeMirror != typeMirror2) {
            return (typeMirror == null || typeMirror2 == null || !((Boolean) typeMirror.accept(h.f19246a, iVar)).booleanValue()) ? false : true;
        }
        return true;
    }

    private static boolean u(TypeMirror typeMirror, TypeMirror typeMirror2, Set<f> set) {
        if (!z(typeMirror2)) {
            return false;
        }
        try {
            Method method = f19232b;
            return v((List) method.invoke(typeMirror, new Object[0]), (List) method.invoke(typeMirror2, new Object[0]), set);
        } catch (Exception e8) {
            throw r0.q(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(List<? extends TypeMirror> list, List<? extends TypeMirror> list2, Set<f> set) {
        if (list.size() != list2.size()) {
            return false;
        }
        Iterator<? extends TypeMirror> it = list.iterator();
        Iterator<? extends TypeMirror> it2 = list2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext() || !t(it.next(), it2.next(), set)) {
                return false;
            }
        }
        return !it.hasNext();
    }

    public static com.google.common.base.l<TypeMirror> w() {
        return s.f19258a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(TypeMirror typeMirror, Set<Element> set) {
        if (typeMirror == null) {
            return 0;
        }
        return ((Integer) typeMirror.accept(l.f19251a, set)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int y(List<? extends TypeMirror> list, Set<Element> set) {
        Iterator<? extends TypeMirror> it = list.iterator();
        int iX = 17;
        while (it.hasNext()) {
            iX = (iX * 31) + x(it.next(), set);
        }
        return iX;
    }

    private static boolean z(TypeMirror typeMirror) {
        return typeMirror != null && typeMirror.getKind().name().equals("INTERSECTION");
    }
}
