package com.alibaba.fastjson.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f13294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f13295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class<?> f13297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Type f13298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f13299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f13303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final e0.b f13304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final e0.b f13305m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f13306n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13307o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final char[] f13308p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f13309q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f13310r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f13311s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f13312t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String[] f13313u;

    public e(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i7, int i8, int i9) {
        this.f13293a = str;
        this.f13299g = cls;
        this.f13297e = cls2;
        this.f13298f = type;
        this.f13294b = null;
        this.f13295c = field;
        this.f13296d = i7;
        this.f13301i = i8;
        this.f13302j = i9;
        this.f13309q = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            int i10 = modifiers & 1;
            this.f13306n = true;
            this.f13307o = Modifier.isTransient(modifiers);
        } else {
            this.f13307o = false;
            this.f13306n = false;
        }
        this.f13308p = b();
        if (field != null) {
            l.p0(field);
        }
        this.f13303k = "";
        this.f13304l = null;
        this.f13305m = null;
        this.f13300h = false;
        this.f13310r = false;
        this.f13311s = false;
        this.f13312t = null;
        this.f13313u = new String[0];
    }

    private static boolean f(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z7 = false;
        for (int i7 = 0; i7 < typeArr.length; i7++) {
            Type type = typeArr[i7];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (f(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i7] = new i(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z7 = true;
                }
            } else if (type instanceof TypeVariable) {
                for (int i8 = 0; i8 < typeVariableArr.length; i8++) {
                    if (type.equals(typeVariableArr[i8])) {
                        typeArr[i7] = typeArr2[i8];
                        z7 = true;
                    }
                }
            }
        }
        return z7;
    }

    public static Type h(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type typeH = h(cls, type, genericComponentType);
                return genericComponentType != typeH ? Array.newInstance(l.N(typeH), 0).getClass() : type2;
            }
            if (!l.d0(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) l.T(type);
                TypeVariable typeVariable = (TypeVariable) type2;
                TypeVariable<Class<?>>[] typeParameters2 = l.N(parameterizedType2).getTypeParameters();
                for (int i7 = 0; i7 < typeParameters2.length; i7++) {
                    if (typeParameters2[i7].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i7];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    typeParameters = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    typeParameters = cls.getSuperclass().getTypeParameters();
                } else {
                    typeParameters = type.getClass().getTypeParameters();
                    parameterizedType = parameterizedType3;
                }
                if (f(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments())) {
                    return new i(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    private static Type j(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] actualTypeArguments;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            actualTypeArguments = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    f(actualTypeArguments2, cls.getTypeParameters(), typeArr);
                    typeArr = actualTypeArguments2;
                }
                cls = cls.getSuperclass();
            }
            actualTypeArguments = typeArr;
        }
        if (actualTypeArguments == null || cls2 == null) {
            return null;
        }
        TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
        for (int i7 = 0; i7 < typeParameters.length; i7++) {
            if (typeVariable.equals(typeParameters[i7])) {
                return actualTypeArguments[i7];
            }
        }
        return null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int i7 = this.f13296d;
        int i8 = eVar.f13296d;
        if (i7 < i8) {
            return -1;
        }
        if (i7 > i8) {
            return 1;
        }
        int iCompareTo = this.f13293a.compareTo(eVar.f13293a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        Class<?> clsG = g();
        Class<?> clsG2 = eVar.g();
        if (clsG != null && clsG2 != null && clsG != clsG2) {
            if (clsG.isAssignableFrom(clsG2)) {
                return -1;
            }
            if (clsG2.isAssignableFrom(clsG)) {
                return 1;
            }
        }
        Field field = this.f13295c;
        boolean z7 = false;
        boolean z8 = field != null && field.getType() == this.f13297e;
        Field field2 = eVar.f13295c;
        if (field2 != null && field2.getType() == eVar.f13297e) {
            z7 = true;
        }
        if (z8 && !z7) {
            return 1;
        }
        if (z7 && !z8) {
            return -1;
        }
        if (eVar.f13297e.isPrimitive() && !this.f13297e.isPrimitive()) {
            return 1;
        }
        if (this.f13297e.isPrimitive() && !eVar.f13297e.isPrimitive()) {
            return -1;
        }
        if (eVar.f13297e.getName().startsWith("java.") && !this.f13297e.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f13297e.getName().startsWith("java.") || eVar.f13297e.getName().startsWith("java.")) {
            return this.f13297e.getName().compareTo(eVar.f13297e.getName());
        }
        return -1;
    }

    protected char[] b() {
        int length = this.f13293a.length();
        char[] cArr = new char[length + 3];
        String str = this.f13293a;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = h0.f35376b;
        cArr[length + 1] = h0.f35376b;
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f13294b;
        return method != null ? method.invoke(obj, new Object[0]) : this.f13295c.get(obj);
    }

    public <T extends Annotation> T d(Class<T> cls) {
        Field field;
        if (cls == e0.b.class) {
            return e();
        }
        Method method = this.f13294b;
        T t7 = method != null ? (T) method.getAnnotation(cls) : null;
        return (t7 != null || (field = this.f13295c) == null) ? t7 : (T) field.getAnnotation(cls);
    }

    public e0.b e() {
        e0.b bVar = this.f13304l;
        return bVar != null ? bVar : this.f13305m;
    }

    protected Class<?> g() {
        Method method = this.f13294b;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f13295c;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String i() {
        return this.f13312t;
    }

    public Member k() {
        Method method = this.f13294b;
        return method != null ? method : this.f13295c;
    }

    public void l(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f13294b;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.f13295c.set(obj, obj2);
        }
    }

    public void m() throws SecurityException {
        Method method = this.f13294b;
        if (method != null) {
            l.p0(method);
        } else {
            l.p0(this.f13295c);
        }
    }

    public String toString() {
        return this.f13293a;
    }

    public e(String str, Method method, Field field, Class<?> cls, Type type, int i7, int i8, int i9, e0.b bVar, e0.b bVar2, String str2) {
        boolean zJsonDirect;
        boolean zIsFinal;
        Class<?> cls2;
        Type type2;
        Type typeJ;
        Class<?> cls3;
        Class<?> cls4;
        Type genericReturnType;
        Class<?> returnType;
        Type type3;
        boolean z7 = false;
        this.f13296d = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        this.f13293a = str;
        this.f13294b = method;
        this.f13295c = field;
        this.f13296d = i7;
        this.f13301i = i8;
        this.f13302j = i9;
        this.f13304l = bVar;
        this.f13305m = bVar2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.f13306n = (modifiers & 1) != 0 || method == null;
            this.f13307o = Modifier.isTransient(modifiers) || l.l0(method);
        } else {
            this.f13306n = false;
            this.f13307o = false;
        }
        if (str2 != null && str2.length() > 0) {
            this.f13303k = str2;
        } else {
            this.f13303k = "";
        }
        e0.b bVarE = e();
        String str3 = null;
        if (bVarE != null) {
            String str4 = bVarE.format();
            str3 = str4.trim().length() != 0 ? str4 : null;
            zJsonDirect = bVarE.jsonDirect();
            this.f13311s = bVarE.unwrapped();
            this.f13313u = bVarE.alternateNames();
        } else {
            this.f13311s = false;
            this.f13313u = new String[0];
            zJsonDirect = false;
        }
        this.f13312t = str3;
        this.f13308p = b();
        if (method != null) {
            l.p0(method);
        }
        if (field != null) {
            l.p0(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls4 = parameterTypes[0];
                type3 = method.getGenericParameterTypes()[0];
            } else {
                if (parameterTypes.length == 2 && (cls3 = parameterTypes[0]) == String.class && parameterTypes[1] == Object.class) {
                    cls4 = cls3;
                    type3 = cls3;
                } else {
                    zIsFinal = true;
                    returnType = method.getReturnType();
                    genericReturnType = method.getGenericReturnType();
                }
                this.f13299g = method.getDeclaringClass();
                cls2 = returnType;
                type2 = genericReturnType;
            }
            zIsFinal = false;
            returnType = cls4;
            genericReturnType = type3;
            this.f13299g = method.getDeclaringClass();
            cls2 = returnType;
            type2 = genericReturnType;
        } else {
            Class<?> type4 = field.getType();
            Type genericType = field.getGenericType();
            this.f13299g = field.getDeclaringClass();
            zIsFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type4;
            type2 = genericType;
        }
        this.f13300h = zIsFinal;
        if (zJsonDirect && cls2 == String.class) {
            z7 = true;
        }
        this.f13310r = z7;
        if (cls != null && cls2 == Object.class && (type2 instanceof TypeVariable) && (typeJ = j(cls, type, (TypeVariable) type2)) != null) {
            this.f13297e = l.N(typeJ);
            this.f13298f = typeJ;
            this.f13309q = cls2.isEnum();
            return;
        }
        boolean z8 = type2 instanceof Class;
        Class<?> cls5 = cls2;
        Type type5 = type2;
        if (!z8) {
            Type typeH = h(cls, type == null ? cls : type, type2);
            Class<?> clsN = cls2;
            if (typeH != type2) {
                if (typeH instanceof ParameterizedType) {
                    clsN = l.N(typeH);
                } else if (typeH instanceof Class) {
                    clsN = cls2;
                    clsN = l.N(typeH);
                }
            }
            clsN = cls2;
            type5 = typeH;
            cls5 = clsN;
        }
        this.f13298f = type5;
        this.f13297e = cls5;
        this.f13309q = cls5.isEnum();
    }
}
