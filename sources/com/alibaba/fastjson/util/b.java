package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13259b;

    static {
        String property = System.getProperty("java.vm.name");
        f13258a = property;
        f13259b = f(property);
    }

    public static boolean a(String str) {
        for (int i7 = 0; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < 1 || cCharAt > 127 || cCharAt == '.') {
                return false;
            }
        }
        return true;
    }

    public static String b(Class<?> cls) {
        if (cls.isPrimitive()) {
            return e(cls);
        }
        if (cls.isArray()) {
            return "[" + b(cls.getComponentType());
        }
        return "L" + h(cls) + com.alipay.sdk.util.j.f13806b;
    }

    public static String c(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder((parameterTypes.length + 1) << 4);
        sb.append('(');
        for (Class<?> cls : parameterTypes) {
            sb.append(b(cls));
        }
        sb.append(')');
        sb.append(b(method.getReturnType()));
        return sb.toString();
    }

    public static Type d(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]).getGenericReturnType();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String e(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return "I";
        }
        if (Void.TYPE == cls) {
            return "V";
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return "B";
        }
        if (Short.TYPE == cls) {
            return "S";
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return "J";
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("dalvik") || lowerCase.contains("lemur");
    }

    public static String[] g(AccessibleObject accessibleObject) {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        Annotation[][] parameterAnnotations;
        String name;
        String strName;
        if (f13259b) {
            return new String[0];
        }
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
            parameterAnnotations = method.getParameterAnnotations();
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            parameterAnnotations = constructor.getParameterAnnotations();
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return new String[0];
        }
        ClassLoader classLoader = declaringClass.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(declaringClass.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ".class");
        try {
            if (resourceAsStream == null) {
                return new String[0];
            }
            com.alibaba.fastjson.asm.b bVar = new com.alibaba.fastjson.asm.b(resourceAsStream, false);
            com.alibaba.fastjson.asm.l lVar = new com.alibaba.fastjson.asm.l(name, parameterTypes);
            bVar.a(lVar);
            String[] strArrB = lVar.b();
            for (int i7 = 0; i7 < strArrB.length; i7++) {
                Annotation[] annotationArr = parameterAnnotations[i7];
                if (annotationArr != null) {
                    for (Annotation annotation : annotationArr) {
                        if ((annotation instanceof e0.b) && (strName = ((e0.b) annotation).name()) != null && strName.length() > 0) {
                            strArrB[i7] = strName;
                        }
                    }
                }
            }
            return strArrB;
        } catch (IOException unused) {
            return new String[0];
        } finally {
            f.a(resourceAsStream);
        }
    }

    public static String h(Class<?> cls) {
        if (!cls.isArray()) {
            return !cls.isPrimitive() ? cls.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') : e(cls);
        }
        return "[" + b(cls.getComponentType());
    }
}
