package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.m;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39876a;

    public j(Class<?> cls) {
        this.f39876a = cls;
    }

    private List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private boolean i(Method method, Method method2) {
        if (!method2.getName().equals(method.getName()) || method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i7 = 0; i7 < method2.getParameterTypes().length; i7++) {
            if (!method2.getParameterTypes()[i7].equals(method.getParameterTypes()[i7])) {
                return false;
            }
        }
        return true;
    }

    private boolean j(Method method, List<Method> list) {
        Iterator<Method> it = list.iterator();
        while (it.hasNext()) {
            if (i(method, it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean k(Class<? extends Annotation> cls) {
        return cls.equals(org.junit.f.class) || cls.equals(org.junit.g.class);
    }

    List<Method> a() {
        return b(org.junit.b.class);
    }

    public List<Method> b(Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = g(this.f39876a).iterator();
        while (it.hasNext()) {
            for (Method method : org.junit.internal.h.a(it.next())) {
                if (method.getAnnotation(cls) != null && !j(method, arrayList)) {
                    arrayList.add(method);
                }
            }
        }
        if (k(cls)) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    List<Method> c() {
        return b(org.junit.g.class);
    }

    public Constructor<?> d() throws NoSuchMethodException, SecurityException {
        return this.f39876a.getConstructor(new Class[0]);
    }

    public Class<?> e() {
        return this.f39876a;
    }

    public String f() {
        return this.f39876a.getName();
    }

    public List<Method> h() {
        return b(m.class);
    }
}
