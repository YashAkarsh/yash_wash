package com.google.common.reflect;

import com.google.common.base.e0;
import com.google.common.base.s;
import com.google.common.base.w;
import com.google.common.base.y;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.ma;
import com.google.common.collect.v7;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.h0;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s<Type, String> f22500a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w f22501b = w.p(", ").s("null");

    static class a implements s<Type, String> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(Type type) {
            return e.f22513e.c(type);
        }
    }

    static class b extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f22502b;

        b(AtomicReference atomicReference) {
            this.f22502b = atomicReference;
        }

        @Override // com.google.common.reflect.n
        void b(Class<?> cls) {
            this.f22502b.set(cls.getComponentType());
        }

        @Override // com.google.common.reflect.n
        void c(GenericArrayType genericArrayType) {
            this.f22502b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.n
        void e(TypeVariable<?> typeVariable) {
            this.f22502b.set(o.q(typeVariable.getBounds()));
        }

        @Override // com.google.common.reflect.n
        void f(WildcardType wildcardType) {
            this.f22502b.set(o.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f22503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f22504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f22505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ c[] f22506d;

        static enum a extends c {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.c
            Class<?> b(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        class b<T> {
            b() {
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.o$c$c, reason: collision with other inner class name */
        static enum C0289c extends c {
            C0289c(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.c
            Class<?> b(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        static class d extends b<String> {
            d() {
            }
        }

        static {
            a aVar = new a("OWNED_BY_ENCLOSING_CLASS", 0);
            f22503a = aVar;
            C0289c c0289c = new C0289c("LOCAL_CLASS_HAS_NO_OWNER", 1);
            f22504b = c0289c;
            f22506d = new c[]{aVar, c0289c};
            f22505c = a();
        }

        private c(String str, int i7) {
            super(str, i7);
        }

        private static c a() {
            new d();
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            for (c cVar : values()) {
                if (cVar.b(b.class) == parameterizedType.getOwnerType()) {
                    return cVar;
                }
            }
            throw new AssertionError();
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f22506d.clone();
        }

        abstract Class<?> b(Class<?> cls);

        /* synthetic */ c(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    private static final class d implements GenericArrayType, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f22507b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f22508a;

        d(Type type) {
            this.f22508a = e.f22513e.e(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return y.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f22508a;
        }

        public int hashCode() {
            return this.f22508a.hashCode();
        }

        public String toString() {
            return o.t(this.f22508a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f22509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f22510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f22511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f22512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final e f22513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ e[] f22514f;

        static enum a extends e {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.e
            Type e(Type type) {
                e0.E(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new d(cls.getComponentType()) : type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.o.e
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public GenericArrayType b(Type type) {
                return new d(type);
            }
        }

        static enum b extends e {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.e
            Type b(Type type) {
                return type instanceof Class ? o.i((Class) type) : new d(type);
            }

            @Override // com.google.common.reflect.o.e
            Type e(Type type) {
                return (Type) e0.E(type);
            }
        }

        static enum c extends e {
            c(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.e
            Type b(Type type) {
                return e.f22510b.b(type);
            }

            @Override // com.google.common.reflect.o.e
            String c(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e8) {
                    e = e8;
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e9) {
                    e = e9;
                    throw new RuntimeException(e);
                }
            }

            @Override // com.google.common.reflect.o.e
            Type e(Type type) {
                return e.f22510b.e(type);
            }
        }

        static enum d extends e {
            d(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.reflect.o.e
            boolean a() {
                return false;
            }

            @Override // com.google.common.reflect.o.e
            Type b(Type type) {
                return e.f22511c.b(type);
            }

            @Override // com.google.common.reflect.o.e
            String c(Type type) {
                return e.f22511c.c(type);
            }

            @Override // com.google.common.reflect.o.e
            Type e(Type type) {
                return e.f22511c.e(type);
            }
        }

        /* JADX INFO: renamed from: com.google.common.reflect.o$e$e, reason: collision with other inner class name */
        static class C0290e extends com.google.common.reflect.i<Map.Entry<String, int[][]>> {
            C0290e() {
            }
        }

        static class f extends com.google.common.reflect.i<int[]> {
            f() {
            }
        }

        static {
            a aVar = new a("JAVA6", 0);
            f22509a = aVar;
            b bVar = new b("JAVA7", 1);
            f22510b = bVar;
            c cVar = new c("JAVA8", 2);
            f22511c = cVar;
            d dVar = new d("JAVA9", 3);
            f22512d = dVar;
            f22514f = new e[]{aVar, bVar, cVar, dVar};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new C0290e().a().toString().contains("java.util.Map.java.util.Map")) {
                    f22513e = cVar;
                    return;
                } else {
                    f22513e = dVar;
                    return;
                }
            }
            if (new f().a() instanceof Class) {
                f22513e = bVar;
            } else {
                f22513e = aVar;
            }
        }

        private e(String str, int i7) {
            super(str, i7);
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) f22514f.clone();
        }

        boolean a() {
            return true;
        }

        abstract Type b(Type type);

        String c(Type type) {
            return o.t(type);
        }

        final d7<Type> d(Type[] typeArr) {
            d7.b bVarM = d7.m();
            for (Type type : typeArr) {
                bVarM.a(e(type));
            }
            return bVarM.e();
        }

        abstract Type e(Type type);

        /* synthetic */ e(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    static final class f<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final boolean f22515a = !f.class.getTypeParameters()[0].equals(o.l(f.class, "X", new Type[0]));

        f() {
        }
    }

    private static final class g implements ParameterizedType, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22516d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f22517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d7<Type> f22518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f22519c;

        g(Type type, Class<?> cls, Type[] typeArr) {
            e0.E(cls);
            e0.d(typeArr.length == cls.getTypeParameters().length);
            o.g(typeArr, "type parameter");
            this.f22517a = type;
            this.f22519c = cls;
            this.f22518b = e.f22513e.d(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && y.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return o.s(this.f22518b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f22517a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f22519c;
        }

        public int hashCode() {
            Type type = this.f22517a;
            return ((type == null ? 0 : type.hashCode()) ^ this.f22518b.hashCode()) ^ this.f22519c.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f22517a != null) {
                e eVar = e.f22513e;
                if (eVar.a()) {
                    sb.append(eVar.c(this.f22517a));
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
            }
            sb.append(this.f22519c.getName());
            sb.append(h0.f35379e);
            sb.append(o.f22501b.k(ma.S(this.f22518b, o.f22500a)));
            sb.append(h0.f35380f);
            return sb.toString();
        }
    }

    private static final class h<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final D f22520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d7<Type> f22522c;

        h(D d8, String str, Type[] typeArr) {
            o.g(typeArr, "bound for type variable");
            this.f22520a = (D) e0.E(d8);
            this.f22521b = (String) e0.E(str);
            this.f22522c = d7.u(typeArr);
        }

        public Type[] a() {
            return o.s(this.f22522c);
        }

        public D b() {
            return this.f22520a;
        }

        public String c() {
            return this.f22521b;
        }

        public String d() {
            return this.f22521b;
        }

        public boolean equals(Object obj) {
            if (!f.f22515a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f22521b.equals(typeVariable.getName()) && this.f22520a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof i)) {
                return false;
            }
            h hVar = ((i) Proxy.getInvocationHandler(obj)).f22524a;
            return this.f22521b.equals(hVar.c()) && this.f22520a.equals(hVar.b()) && this.f22522c.equals(hVar.f22522c);
        }

        public int hashCode() {
            return this.f22520a.hashCode() ^ this.f22521b.hashCode();
        }

        public String toString() {
            return this.f22521b;
        }
    }

    private static final class i implements InvocationHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final v7<String, Method> f22523b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h<?> f22524a;

        static {
            v7.b bVarB = v7.b();
            for (Method method : h.class.getMethods()) {
                if (method.getDeclaringClass().equals(h.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    bVarB.f(method.getName(), method);
                }
            }
            f22523b = bVarB.a();
        }

        i(h<?> hVar) {
            this.f22524a = hVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f22523b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f22524a, objArr);
            } catch (InvocationTargetException e8) {
                throw e8.getCause();
            }
        }
    }

    static final class j implements WildcardType, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f22525c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d7<Type> f22526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d7<Type> f22527b;

        j(Type[] typeArr, Type[] typeArr2) {
            o.g(typeArr, "lower bound for wildcard");
            o.g(typeArr2, "upper bound for wildcard");
            e eVar = e.f22513e;
            this.f22526a = eVar.d(typeArr);
            this.f22527b = eVar.d(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.f22526a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.f22527b.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return o.s(this.f22526a);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return o.s(this.f22527b);
        }

        public int hashCode() {
            return this.f22526a.hashCode() ^ this.f22527b.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            ck<Type> it = this.f22526a.iterator();
            while (it.hasNext()) {
                Type next = it.next();
                sb.append(" super ");
                sb.append(e.f22513e.c(next));
            }
            for (Type type : o.h(this.f22527b)) {
                sb.append(" extends ");
                sb.append(e.f22513e.c(type));
            }
            return sb.toString();
        }
    }

    private o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                e0.y(!cls.isPrimitive(), "Primitive type '%s' used as %s", cls, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> h(Iterable<Type> iterable) {
        return ma.o(iterable, com.google.common.base.h0.q(com.google.common.base.h0.m(Object.class)));
    }

    static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    static Type j(Type type) {
        e0.E(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return e.f22513e.b(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        e0.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        e0.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    static <D extends GenericDeclaration> TypeVariable<D> l(D d8, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d8, str, typeArr);
    }

    static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new g(c.f22505c.b(cls), cls, typeArr);
    }

    static ParameterizedType n(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        e0.E(typeArr);
        e0.u(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new g(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> o(D d8, String str, Type[] typeArr) {
        return (TypeVariable) com.google.common.reflect.h.d(TypeVariable.class, new i(new h(d8, str, typeArr)));
    }

    @s1.d
    static WildcardType p(Type type) {
        return new j(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeJ = j(type);
            if (typeJ != null) {
                if (typeJ instanceof Class) {
                    Class cls = (Class) typeJ;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(typeJ);
            }
        }
        return null;
    }

    @s1.d
    static WildcardType r(Type type) {
        return new j(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
