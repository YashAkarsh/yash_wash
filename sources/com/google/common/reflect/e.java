package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.collect.d7;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public abstract class e<T, R> extends c implements GenericDeclaration {

    static class a<T> extends e<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Constructor<?> f22443c;

        a(Constructor<?> constructor) {
            super(constructor);
            this.f22443c = constructor;
        }

        private boolean D() {
            Class<?> declaringClass = this.f22443c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.e
        public final boolean A() {
            return this.f22443c.isVarArgs();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f22443c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.e
        AnnotatedType[] o() {
            return this.f22443c.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.e
        public AnnotatedType p() {
            return this.f22443c.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.e
        Type[] r() {
            return this.f22443c.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.e
        Type[] s() {
            Type[] genericParameterTypes = this.f22443c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !D()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f22443c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // com.google.common.reflect.e
        Type t() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? o.m(declaringClass, typeParameters) : declaringClass;
        }

        @Override // com.google.common.reflect.e
        final Annotation[][] u() {
            return this.f22443c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.e
        final Object y(Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            try {
                return this.f22443c.newInstance(objArr);
            } catch (InstantiationException e8) {
                throw new RuntimeException(this.f22443c + " failed.", e8);
            }
        }

        @Override // com.google.common.reflect.e
        public final boolean z() {
            return false;
        }
    }

    static class b<T> extends e<T, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Method f22444c;

        b(Method method) {
            super(method);
            this.f22444c = method;
        }

        @Override // com.google.common.reflect.e
        public final boolean A() {
            return this.f22444c.isVarArgs();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f22444c.getTypeParameters();
        }

        @Override // com.google.common.reflect.e
        AnnotatedType[] o() {
            return this.f22444c.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.e
        public AnnotatedType p() {
            return this.f22444c.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.e
        Type[] r() {
            return this.f22444c.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.e
        Type[] s() {
            return this.f22444c.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.e
        Type t() {
            return this.f22444c.getGenericReturnType();
        }

        @Override // com.google.common.reflect.e
        final Annotation[][] u() {
            return this.f22444c.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.e
        final Object y(Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            return this.f22444c.invoke(obj, objArr);
        }

        @Override // com.google.common.reflect.e
        public final boolean z() {
            return (c() || f() || i() || Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }
    }

    <M extends AccessibleObject & Member> e(M m7) {
        super(m7);
    }

    public static <T> e<T, T> m(Constructor<T> constructor) {
        return new a(constructor);
    }

    public static e<?, Object> n(Method method) {
        return new b(method);
    }

    public abstract boolean A();

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> e<T, R1> B(m<R1> mVar) {
        if (mVar.O(w())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + w() + ", not " + mVar);
    }

    public final <R1 extends R> e<T, R1> C(Class<R1> cls) {
        return B(m.V(cls));
    }

    @Override // com.google.common.reflect.c
    public m<T> a() {
        return m.V(getDeclaringClass());
    }

    @Override // com.google.common.reflect.c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.c, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.common.reflect.c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    abstract AnnotatedType[] o();

    public abstract AnnotatedType p();

    public final d7<m<? extends Throwable>> q() {
        d7.b bVarM = d7.m();
        for (Type type : r()) {
            bVarM.a(m.W(type));
        }
        return bVarM.e();
    }

    abstract Type[] r();

    abstract Type[] s();

    abstract Type t();

    @Override // com.google.common.reflect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    abstract Annotation[][] u();

    public final d7<g> v() {
        Type[] typeArrS = s();
        Annotation[][] annotationArrU = u();
        AnnotatedType[] annotatedTypeArrO = o();
        d7.b bVarM = d7.m();
        for (int i7 = 0; i7 < typeArrS.length; i7++) {
            bVarM.a(new g(this, i7, m.W(typeArrS[i7]), annotationArrU[i7], annotatedTypeArrO[i7]));
        }
        return bVarM.e();
    }

    public final m<? extends R> w() {
        return (m<? extends R>) m.W(t());
    }

    @u1.a
    public final R x(T t7, Object... objArr) throws IllegalAccessException, InvocationTargetException {
        return (R) y(t7, (Object[]) e0.E(objArr));
    }

    abstract Object y(Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException;

    public abstract boolean z();
}
