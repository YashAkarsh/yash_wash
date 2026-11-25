package org.hamcrest.internal;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f39731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f39732c;

    public b(String str, int i7, int i8) {
        this.f39730a = str;
        this.f39731b = i7;
        this.f39732c = i8;
    }

    protected boolean a(Method method) {
        return method.getName().equals(this.f39730a) && method.getParameterTypes().length == this.f39731b && !method.isSynthetic();
    }

    protected Class<?> b(Method method) {
        return method.getParameterTypes()[this.f39732c];
    }

    public Class<?> c(Class<?> cls) {
        while (cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (a(method)) {
                    return b(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for " + this.f39730a + "() method.");
    }
}
