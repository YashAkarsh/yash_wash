package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.m;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f39877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f39878b;

    public k(Method method, j jVar) {
        this.f39877a = method;
        this.f39878b = jVar;
    }

    boolean a() {
        return d() != null;
    }

    List<Method> b() {
        return this.f39878b.b(org.junit.a.class);
    }

    List<Method> c() {
        return this.f39878b.b(org.junit.f.class);
    }

    protected Class<? extends Throwable> d() {
        m mVar = (m) this.f39877a.getAnnotation(m.class);
        if (mVar == null || mVar.expected() == m.a.class) {
            return null;
        }
        return mVar.expected();
    }

    public long e() {
        m mVar = (m) this.f39877a.getAnnotation(m.class);
        if (mVar == null) {
            return 0L;
        }
        return mVar.timeout();
    }

    public void f(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f39877a.invoke(obj, new Object[0]);
    }

    public boolean g() {
        return this.f39877a.getAnnotation(org.junit.k.class) != null;
    }

    boolean h(Throwable th) {
        return !d().isAssignableFrom(th.getClass());
    }
}
