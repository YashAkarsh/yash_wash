package i3;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f34162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f34163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f34167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Type f34168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Class<?> f34169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f34170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final g3.b f34171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final g3.b f34172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final char[] f34173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34174n;

    public a(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i7, int i8) {
        this.f34161a = str;
        this.f34169i = cls;
        this.f34167g = cls2;
        this.f34168h = type;
        this.f34162b = null;
        this.f34163c = field;
        this.f34166f = i7;
        this.f34174n = cls2.isEnum();
        this.f34171k = null;
        this.f34172l = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i9 = modifiers & 1;
            this.f34164d = true;
            this.f34165e = Modifier.isTransient(modifiers);
        } else {
            this.f34164d = false;
            this.f34165e = false;
        }
        this.f34170j = false;
        int length = str.length();
        char[] cArr = new char[length + 3];
        this.f34173m = cArr;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = h0.f35376b;
        cArr[length + 1] = h0.f35376b;
        cArr[length + 2] = ':';
    }

    public static Type e(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<? super Object>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeE = e(cls, type, genericComponentType);
                return genericComponentType != typeE ? Array.newInstance(d.v(typeE), 0).getClass() : type2;
            }
            if (!d.A(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) d.y(type);
                Class<?> clsV = d.v(parameterizedType2);
                TypeVariable typeVariable = (TypeVariable) type2;
                for (int i7 = 0; i7 < clsV.getTypeParameters().length; i7++) {
                    if (clsV.getTypeParameters()[i7].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i7];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                Type[] actualTypeArguments2 = null;
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    typeParameters = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    typeParameters = cls.getSuperclass().getTypeParameters();
                } else {
                    typeParameters = null;
                    parameterizedType = null;
                }
                boolean z7 = false;
                for (int i8 = 0; i8 < actualTypeArguments.length && parameterizedType != null; i8++) {
                    Type type3 = actualTypeArguments[i8];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        for (int i9 = 0; i9 < typeParameters.length; i9++) {
                            if (typeParameters[i9].getName().equals(typeVariable2.getName())) {
                                if (actualTypeArguments2 == null) {
                                    actualTypeArguments2 = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i8] = actualTypeArguments2[i9];
                                z7 = true;
                            }
                        }
                    }
                }
                if (z7) {
                    return new c(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    public static Type f(Class<?> cls, TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        while (true) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            if (genericSuperclass instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                if (parameterizedType.getRawType() == genericDeclaration) {
                    TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i7 = 0; i7 < typeParameters.length; i7++) {
                        if (typeParameters[i7] == typeVariable) {
                            return actualTypeArguments[i7];
                        }
                    }
                    return null;
                }
            }
            cls = d.v(genericSuperclass);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        int i7 = this.f34166f;
        int i8 = aVar.f34166f;
        if (i7 < i8) {
            return -1;
        }
        if (i7 > i8) {
            return 1;
        }
        return this.f34161a.compareTo(aVar.f34161a);
    }

    public boolean b(a aVar) {
        return aVar == this || compareTo(aVar) == 0;
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        return this.f34164d ? this.f34163c.get(obj) : this.f34162b.invoke(obj, new Object[0]);
    }

    public g3.b d() {
        g3.b bVar = this.f34171k;
        return bVar != null ? bVar : this.f34172l;
    }

    public void g(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f34162b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f34163c.set(obj, obj2);
        }
    }

    public String toString() {
        return this.f34161a;
    }

    public a(String str, Method method, Field field, Class<?> cls, Type type, int i7, int i8, g3.b bVar, g3.b bVar2, boolean z7) {
        Type genericType;
        Class<?> clsV;
        Type typeF;
        this.f34161a = str;
        this.f34162b = method;
        this.f34163c = field;
        this.f34166f = i7;
        this.f34172l = bVar;
        this.f34171k = bVar2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f34164d = method == null || ((modifiers & 1) != 0 && method.getReturnType() == field.getType());
            this.f34165e = (modifiers & 128) != 0;
        } else {
            this.f34164d = false;
            this.f34165e = false;
        }
        int length = str.length();
        char[] cArr = new char[length + 3];
        this.f34173m = cArr;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = h0.f35376b;
        cArr[length + 1] = h0.f35376b;
        cArr[length + 2] = ':';
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                clsV = parameterTypes[0];
                genericType = (clsV == Class.class || clsV == String.class || clsV.isPrimitive() || !z7) ? clsV : method.getGenericParameterTypes()[0];
                this.f34170j = false;
            } else {
                clsV = method.getReturnType();
                genericType = (clsV != Class.class && z7) ? method.getGenericReturnType() : clsV;
                this.f34170j = true;
            }
            this.f34169i = method.getDeclaringClass();
        } else {
            Class<?> type2 = field.getType();
            genericType = (type2.isPrimitive() || type2 == String.class || type2.isEnum() || !z7) ? type2 : field.getGenericType();
            this.f34169i = field.getDeclaringClass();
            this.f34170j = Modifier.isFinal(field.getModifiers());
            clsV = type2;
        }
        if (cls != null && clsV == Object.class && (genericType instanceof TypeVariable) && (typeF = f(cls, (TypeVariable) genericType)) != null) {
            this.f34167g = d.v(typeF);
            this.f34168h = typeF;
            this.f34174n = clsV.isEnum();
            return;
        }
        if (!(genericType instanceof Class)) {
            Type typeE = e(cls, type == null ? cls : type, genericType);
            if (typeE != genericType && ((typeE instanceof ParameterizedType) || (typeE instanceof Class))) {
                clsV = d.v(typeE);
            }
            genericType = typeE;
        }
        this.f34168h = genericType;
        this.f34167g = clsV;
        this.f34174n = !clsV.isArray() && clsV.isEnum();
    }
}
