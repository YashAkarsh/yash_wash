package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d extends c<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f40044a;

    class a extends org.junit.internal.runners.model.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f40045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object[] f40046b;

        a(Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
            this.f40045a = obj;
            this.f40046b = objArr;
        }

        @Override // org.junit.internal.runners.model.c
        protected Object b() throws Throwable {
            return d.this.f40044a.invoke(this.f40045a, this.f40046b);
        }
    }

    public d(Method method) {
        if (method == null) {
            throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
        }
        this.f40044a = method;
    }

    private Class<?>[] k() {
        return this.f40044a.getParameterTypes();
    }

    @Override // org.junit.runners.model.c
    public Class<?> a() {
        return this.f40044a.getDeclaringClass();
    }

    @Override // org.junit.runners.model.c
    protected int b() {
        return this.f40044a.getModifiers();
    }

    @Override // org.junit.runners.model.c
    public String c() {
        return this.f40044a.getName();
    }

    @Override // org.junit.runners.model.c
    public Class<?> d() {
        return l();
    }

    public boolean equals(Object obj) {
        if (d.class.isInstance(obj)) {
            return ((d) obj).f40044a.equals(this.f40044a);
        }
        return false;
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.f40044a.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        return this.f40044a.getAnnotations();
    }

    public int hashCode() {
        return this.f40044a.hashCode();
    }

    public Method j() {
        return this.f40044a;
    }

    public Class<?> l() {
        return this.f40044a.getReturnType();
    }

    public Object m(Object obj, Object... objArr) throws Throwable {
        return new a(obj, objArr).a();
    }

    @Override // org.junit.runners.model.c
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean g(d dVar) {
        if (!dVar.c().equals(c()) || dVar.k().length != k().length) {
            return false;
        }
        for (int i7 = 0; i7 < dVar.k().length; i7++) {
            if (!dVar.k()[i7].equals(k()[i7])) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public boolean o(Type type) {
        return k().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.f40044a.getReturnType());
    }

    public void p(List<Throwable> list) {
        new g(this.f40044a).a(list);
    }

    public void q(boolean z7, List<Throwable> list) {
        if (h() != z7) {
            list.add(new Exception("Method " + this.f40044a.getName() + "() " + (z7 ? "should" : "should not") + " be static"));
        }
        if (!e()) {
            list.add(new Exception("Method " + this.f40044a.getName() + "() should be public"));
        }
        if (this.f40044a.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.f40044a.getName() + "() should be void"));
        }
    }

    public void r(boolean z7, List<Throwable> list) {
        q(z7, list);
        if (this.f40044a.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.f40044a.getName() + " should have no parameters"));
        }
    }

    public String toString() {
        return this.f40044a.toString();
    }
}
