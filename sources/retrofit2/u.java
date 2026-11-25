package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f40289a = new Type[0];

    private static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f40290a;

        a(Type type) {
            this.f40290a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && u.f(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f40290a;
        }

        public int hashCode() {
            return this.f40290a.hashCode();
        }

        public String toString() {
            return u.r(this.f40290a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    private static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f40291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f40292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type[] f40293c;

        b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                u.b(type3, "typeArgument == null");
                u.c(type3);
            }
            this.f40291a = type;
            this.f40292b = type2;
            this.f40293c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && u.f(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f40293c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f40291a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f40292b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f40293c) ^ this.f40292b.hashCode()) ^ u.m(this.f40291a);
        }

        public String toString() {
            Type[] typeArr = this.f40293c;
            if (typeArr.length == 0) {
                return u.r(this.f40292b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(u.r(this.f40292b));
            sb.append("<");
            sb.append(u.r(this.f40293c[0]));
            for (int i7 = 1; i7 < this.f40293c.length; i7++) {
                sb.append(", ");
                sb.append(u.r(this.f40293c[i7]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    private static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f40294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f40295b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                Type type = typeArr[0];
                type.getClass();
                u.c(type);
                this.f40295b = null;
                this.f40294a = typeArr[0];
                return;
            }
            Type type2 = typeArr2[0];
            type2.getClass();
            u.c(type2);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f40295b = typeArr2[0];
            this.f40294a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && u.f(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f40295b;
            return type != null ? new Type[]{type} : u.f40289a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f40294a};
        }

        public int hashCode() {
            Type type = this.f40295b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f40294a.hashCode() + 31);
        }

        public String toString() {
            if (this.f40295b != null) {
                return "? super " + u.r(this.f40295b);
            }
            if (this.f40294a == Object.class) {
                return "?";
            }
            return "? extends " + u.r(this.f40294a);
        }
    }

    private u() {
    }

    static ResponseBody a(ResponseBody responseBody) throws IOException {
        okio.m mVar = new okio.m();
        responseBody.source().x1(mVar);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), mVar);
    }

    static <T> T b(@Nullable T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    static void c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    private static Class<?> d(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    private static boolean e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static boolean f(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return e(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return f(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    static Type g(Type type) {
        if (type instanceof ParameterizedType) {
            return i(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    static Type h(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i7 = 0; i7 < length; i7++) {
                Class<?> cls3 = interfaces[i7];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i7];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return h(cls.getGenericInterfaces()[i7], interfaces[i7], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return h(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static Type i(int i7, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i7 >= 0 && i7 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i7];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i7 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    static Class<?> j(Type type) {
        b(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(j(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return j(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    static Type k(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return p(type, cls, h(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static boolean l(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (l(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return l(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    static int m(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static int n(Object[] objArr, Object obj) {
        for (int i7 = 0; i7 < objArr.length; i7++) {
            if (obj.equals(objArr[i7])) {
                return i7;
            }
        }
        throw new NoSuchElementException();
    }

    static boolean o(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    static Type p(Type type, Class<?> cls, Type type2) {
        Type type3;
        WildcardType wildcardType;
        Type type4 = type2;
        while (type4 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type4;
            Type typeQ = q(type, cls, typeVariable);
            if (typeQ == typeVariable) {
                return typeQ;
            }
            type4 = typeQ;
        }
        if (type4 instanceof Class) {
            Class cls2 = (Class) type4;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeP = p(type, cls, componentType);
                return componentType == typeP ? cls2 : new a(typeP);
            }
        }
        if (type4 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type4;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeP2 = p(type, cls, genericComponentType);
            return genericComponentType == typeP2 ? genericArrayType : new a(typeP2);
        }
        if (type4 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type4;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeP3 = p(type, cls, ownerType);
            boolean z7 = typeP3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i7 = 0; i7 < length; i7++) {
                Type typeP4 = p(type, cls, actualTypeArguments[i7]);
                if (typeP4 != actualTypeArguments[i7]) {
                    if (!z7) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z7 = true;
                    }
                    actualTypeArguments[i7] = typeP4;
                }
            }
            return z7 ? new b(typeP3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        if (type4 instanceof WildcardType) {
            wildcardType = (WildcardType) type4;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeP5 = p(type, cls, lowerBounds[0]);
                if (typeP5 != lowerBounds[0]) {
                    type3 = type4;
                    type3 = wildcardType;
                    return new c(new Type[]{Object.class}, new Type[]{typeP5});
                }
            } else if (upperBounds.length == 1) {
                type3 = type4;
                type3 = wildcardType;
                Type typeP6 = p(type, cls, upperBounds[0]);
                type3 = wildcardType;
                if (typeP6 != upperBounds[0]) {
                    return new c(new Type[]{typeP6}, f40289a);
                }
            }
        }
        type3 = type4;
        type3 = wildcardType;
        type3 = type4;
        type3 = wildcardType;
        type3 = type4;
        return type3;
    }

    private static Type q(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsD = d(typeVariable);
        if (clsD == null) {
            return typeVariable;
        }
        Type typeH = h(type, cls, clsD);
        if (!(typeH instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeH).getActualTypeArguments()[n(clsD.getTypeParameters(), typeVariable)];
    }

    static String r(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static <T> void s(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }
}
