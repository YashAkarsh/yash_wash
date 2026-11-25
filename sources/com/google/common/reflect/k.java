package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.base.w;
import com.google.common.base.y;
import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f22454a;

    static class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f22455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f22456c;

        a(Map map, Type type) {
            this.f22455b = map;
            this.f22456c = type;
        }

        @Override // com.google.common.reflect.n
        void b(Class<?> cls) {
            if (this.f22456c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f22456c);
        }

        @Override // com.google.common.reflect.n
        void c(GenericArrayType genericArrayType) {
            Type type = this.f22456c;
            if (type instanceof WildcardType) {
                return;
            }
            Type typeJ = o.j(type);
            e0.u(typeJ != null, "%s is not an array type.", this.f22456c);
            k.g(this.f22455b, genericArrayType.getGenericComponentType(), typeJ);
        }

        @Override // com.google.common.reflect.n
        void d(ParameterizedType parameterizedType) {
            Type type = this.f22456c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) k.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                k.g(this.f22455b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            e0.y(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f22456c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            e0.y(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i7 = 0; i7 < actualTypeArguments.length; i7++) {
                k.g(this.f22455b, actualTypeArguments[i7], actualTypeArguments2[i7]);
            }
        }

        @Override // com.google.common.reflect.n
        void e(TypeVariable<?> typeVariable) {
            this.f22455b.put(new d(typeVariable), this.f22456c);
        }

        @Override // com.google.common.reflect.n
        void f(WildcardType wildcardType) {
            Type type = this.f22456c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                e0.y(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f22456c);
                for (int i7 = 0; i7 < upperBounds.length; i7++) {
                    k.g(this.f22455b, upperBounds[i7], upperBounds2[i7]);
                }
                for (int i8 = 0; i8 < lowerBounds.length; i8++) {
                    k.g(this.f22455b, lowerBounds[i8], lowerBounds2[i8]);
                }
            }
        }
    }

    private static final class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<d, Type> f22457b = wb.i0();

        private b() {
        }

        static v7<d, Type> g(Type type) {
            e0.E(type);
            b bVar = new b();
            bVar.a(type);
            return v7.g(bVar.f22457b);
        }

        private void h(d dVar, Type type) {
            if (this.f22457b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f22457b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f22457b.get(d.c(type2));
            }
            this.f22457b.put(dVar, type);
        }

        @Override // com.google.common.reflect.n
        void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.n
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            e0.g0(typeParameters.length == actualTypeArguments.length);
            for (int i7 = 0; i7 < typeParameters.length; i7++) {
                h(new d(typeParameters[i7]), actualTypeArguments[i7]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.n
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.n
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeVariable<?> f22462a;

        d(TypeVariable<?> typeVariable) {
            this.f22462a = (TypeVariable) e0.E(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.f22462a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f22462a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f22462a);
            }
            return false;
        }

        public int hashCode() {
            return y.b(this.f22462a.getGenericDeclaration(), this.f22462a.getName());
        }

        public String toString() {
            return this.f22462a.toString();
        }
    }

    private static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final e f22463b = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f22464a;

        class a extends e {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ TypeVariable f22465c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f22465c = typeVariable;
            }

            @Override // com.google.common.reflect.k.e
            TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f22465c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private e d(TypeVariable<?> typeVariable) {
            return new a(this.f22464a, typeVariable);
        }

        private e e() {
            return new e(this.f22464a);
        }

        final Type a(Type type) {
            e0.E(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return o.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (!(type instanceof ParameterizedType)) {
                if (!(type instanceof WildcardType)) {
                    throw new AssertionError("must have been one of the known types");
                }
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<?>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i7 = 0; i7 < actualTypeArguments.length; i7++) {
                actualTypeArguments[i7] = d(typeParameters[i7]).a(actualTypeArguments[i7]);
            }
            return o.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
        }

        TypeVariable<?> b(Type[] typeArr) {
            return o.l(e.class, "capture#" + this.f22464a.incrementAndGet() + "-of ? extends " + w.o(h0.f35378d).n(typeArr), typeArr);
        }

        private e() {
            this(new AtomicInteger());
        }

        private e(AtomicInteger atomicInteger) {
            this.f22464a = atomicInteger;
        }
    }

    /* synthetic */ k(c cVar, a aVar) {
        this(cVar);
    }

    static k d(Type type) {
        return new k().o(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    static k f(Type type) {
        return new k().o(b.g(e.f22463b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    private Type h(GenericArrayType genericArrayType) {
        return o.k(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return o.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i7 = 0; i7 < typeArr.length; i7++) {
            typeArr2[i7] = j(typeArr[i7]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new o.j(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        e0.E(type);
        if (type instanceof TypeVariable) {
            return this.f22454a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    Type[] l(Type[] typeArr) {
        for (int i7 = 0; i7 < typeArr.length; i7++) {
            typeArr[i7] = j(typeArr[i7]);
        }
        return typeArr;
    }

    public k n(Type type, Type type2) {
        HashMap mapI0 = wb.i0();
        g(mapI0, (Type) e0.E(type), (Type) e0.E(type2));
        return o(mapI0);
    }

    k o(Map<d, ? extends Type> map) {
        return new k(this.f22454a.c(map));
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7<d, Type> f22458a;

        class a extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TypeVariable f22459b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f22460c;

            a(TypeVariable typeVariable, c cVar) {
                this.f22459b = typeVariable;
                this.f22460c = cVar;
            }

            @Override // com.google.common.reflect.k.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f22459b.getGenericDeclaration()) ? typeVariable : this.f22460c.b(typeVariable, cVar);
            }
        }

        c() {
            this.f22458a = v7.y();
        }

        final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(typeVariable, this));
        }

        Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f22458a.get(new d(typeVariable));
            a aVar = null;
            if (type != null) {
                return new k(cVar, aVar).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] typeArrK = new k(cVar, aVar).k(bounds);
            return (o.f.f22515a && Arrays.equals(bounds, typeArrK)) ? typeVariable : o.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrK);
        }

        final c c(Map<d, ? extends Type> map) {
            v7.b bVarB = v7.b();
            bVarB.i(this.f22458a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                e0.u(!key.a(value), "Type variable %s bound to itself", key);
                bVarB.f(key, value);
            }
            return new c(bVarB.a());
        }

        private c(v7<d, Type> v7Var) {
            this.f22458a = v7Var;
        }
    }

    public k() {
        this.f22454a = new c();
    }

    private k(c cVar) {
        this.f22454a = cVar;
    }
}
