package com.haier.library.okhttp.b.i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f27375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f27377c;

    e(Class<?> cls, String str, Class... clsArr) {
        this.f27375a = cls;
        this.f27376b = str;
        this.f27377c = clsArr;
    }

    private Method b(Class<?> cls) {
        Class<?> cls2;
        String str = this.f27376b;
        if (str == null) {
            return null;
        }
        Method methodC = c(cls, str, this.f27377c);
        if (methodC == null || (cls2 = this.f27375a) == null || cls2.isAssignableFrom(methodC.getReturnType())) {
            return methodC;
        }
        return null;
    }

    private static Method c(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object a(T t7, Object... objArr) throws InvocationTargetException {
        Method methodB = b(t7.getClass());
        if (methodB == null) {
            return null;
        }
        try {
            return methodB.invoke(t7, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public boolean d(T t7) {
        return b(t7.getClass()) != null;
    }

    public Object e(T t7, Object... objArr) {
        try {
            return a(t7, objArr);
        } catch (InvocationTargetException e8) {
            Throwable targetException = e8.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(T t7, Object... objArr) throws InvocationTargetException {
        Method methodB = b(t7.getClass());
        if (methodB == null) {
            throw new AssertionError("Method " + this.f27376b + " not supported for object " + t7);
        }
        try {
            return methodB.invoke(t7, objArr);
        } catch (IllegalAccessException e8) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodB);
            assertionError.initCause(e8);
            throw assertionError;
        }
    }

    public Object g(T t7, Object... objArr) {
        try {
            return f(t7, objArr);
        } catch (InvocationTargetException e8) {
            Throwable targetException = e8.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
