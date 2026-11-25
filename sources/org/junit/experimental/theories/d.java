package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f39791c = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Annotation[] f39793b;

    private d(Class<?> cls, Annotation[] annotationArr) {
        this.f39792a = cls;
        this.f39793b = annotationArr;
    }

    private static Map<Class<?>, Class<?>> a() {
        HashMap map = new HashMap();
        l(map, Boolean.TYPE, Boolean.class);
        l(map, Byte.TYPE, Byte.class);
        l(map, Short.TYPE, Short.class);
        l(map, Character.TYPE, Character.class);
        l(map, Integer.TYPE, Integer.class);
        l(map, Long.TYPE, Long.class);
        l(map, Float.TYPE, Float.class);
        l(map, Double.TYPE, Double.class);
        return Collections.unmodifiableMap(map);
    }

    private <T extends Annotation> T f(Annotation[] annotationArr, Class<T> cls, int i7) {
        if (i7 == 0) {
            return null;
        }
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
            Annotation annotationF = f(annotation.annotationType().getAnnotations(), cls, i7 - 1);
            if (annotationF != null) {
                return cls.cast(annotationF);
            }
        }
        return null;
    }

    private boolean k(Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map = f39791c;
        if (map.containsKey(cls2)) {
            return cls.isAssignableFrom(map.get(cls2));
        }
        return false;
    }

    private static <T> void l(Map<T, T> map, T t7, T t8) {
        map.put(t7, t8);
        map.put(t8, t7);
    }

    public static ArrayList<d> m(Method method) {
        return n(method.getParameterTypes(), method.getParameterAnnotations());
    }

    private static ArrayList<d> n(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<d> arrayList = new ArrayList<>();
        for (int i7 = 0; i7 < clsArr.length; i7++) {
            arrayList.add(new d(clsArr[i7], annotationArr[i7]));
        }
        return arrayList;
    }

    public static List<d> o(Constructor<?> constructor) {
        return n(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    public boolean b(Class<?> cls) {
        return this.f39792a.isAssignableFrom(cls) || k(this.f39792a, cls);
    }

    public boolean c(Object obj) {
        if (obj == null) {
            return !this.f39792a.isPrimitive();
        }
        return b(obj.getClass());
    }

    public boolean d(Class<?> cls) {
        return cls.isAssignableFrom(this.f39792a) || k(cls, this.f39792a) || b(cls);
    }

    public <T extends Annotation> T e(Class<T> cls) {
        return (T) f(this.f39793b, cls, 3);
    }

    public <T extends Annotation> T g(Class<T> cls) {
        for (Annotation annotation : h()) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public List<Annotation> h() {
        return Arrays.asList(this.f39793b);
    }

    public Class<?> i() {
        return this.f39792a;
    }

    public boolean j(Class<? extends Annotation> cls) {
        return g(cls) != null;
    }
}
