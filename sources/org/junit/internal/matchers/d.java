package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.junit.internal.h;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class d<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f39848a;

    protected d() {
        this.f39848a = e(getClass());
    }

    private static Class<?> e(Class<?> cls) {
        while (cls != Object.class) {
            for (Method method : h.a(cls)) {
                if (f(method)) {
                    return method.getParameterTypes()[0];
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    private static boolean f(Method method) {
        return method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.k
    public final boolean c(Object obj) {
        return obj != 0 && this.f39848a.isInstance(obj) && g(obj);
    }

    public abstract boolean g(T t7);

    /* JADX WARN: Multi-variable type inference failed */
    protected d(Class<T> cls) {
        this.f39848a = cls;
    }
}
