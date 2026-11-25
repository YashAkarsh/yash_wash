package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class f extends l implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Method> f39860a = j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f39861b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.c f39862a;

        a(org.junit.runner.notification.c cVar) {
            this.f39862a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.m(this.f39862a);
        }
    }

    class b implements Comparator<Method> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.manipulation.e f39864a;

        b(org.junit.runner.manipulation.e eVar) {
            this.f39864a = eVar;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            return this.f39864a.compare(f.this.l(method), f.this.l(method2));
        }
    }

    public f(Class<?> cls) throws d {
        this.f39861b = new j(cls);
        q();
    }

    private void n(org.junit.runner.notification.c cVar, org.junit.runner.c cVar2, Throwable th) {
        cVar.l(cVar2);
        cVar.f(new org.junit.runner.notification.a(cVar2, th));
        cVar.h(cVar2);
    }

    @Override // org.junit.runner.l
    public void a(org.junit.runner.notification.c cVar) {
        new org.junit.internal.runners.a(cVar, this.f39861b, b(), new a(cVar)).d();
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        org.junit.runner.c cVarE = org.junit.runner.c.e(h(), f());
        Iterator<Method> it = this.f39860a.iterator();
        while (it.hasNext()) {
            cVarE.a(l(it.next()));
        }
        return cVarE;
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a aVar) throws org.junit.runner.manipulation.c {
        Iterator<Method> it = this.f39860a.iterator();
        while (it.hasNext()) {
            if (!aVar.e(l(it.next()))) {
                it.remove();
            }
        }
        if (this.f39860a.isEmpty()) {
            throw new org.junit.runner.manipulation.c();
        }
    }

    @Override // org.junit.runner.manipulation.d
    public void e(org.junit.runner.manipulation.e eVar) {
        Collections.sort(this.f39860a, new b(eVar));
    }

    protected Annotation[] f() {
        return this.f39861b.e().getAnnotations();
    }

    protected Object g() throws Exception {
        return i().d().newInstance(new Object[0]);
    }

    protected String h() {
        return i().f();
    }

    protected j i() {
        return this.f39861b;
    }

    protected List<Method> j() {
        return this.f39861b.h();
    }

    protected void k(Method method, org.junit.runner.notification.c cVar) {
        org.junit.runner.c cVarL = l(method);
        try {
            new g(g(), r(method), cVar, cVarL).b();
        } catch (InvocationTargetException e8) {
            n(cVar, cVarL, e8.getCause());
        } catch (Exception e9) {
            n(cVar, cVarL, e9);
        }
    }

    protected org.junit.runner.c l(Method method) {
        return org.junit.runner.c.g(i().e(), p(method), o(method));
    }

    protected void m(org.junit.runner.notification.c cVar) {
        Iterator<Method> it = this.f39860a.iterator();
        while (it.hasNext()) {
            k(it.next(), cVar);
        }
    }

    protected Annotation[] o(Method method) {
        return method.getAnnotations();
    }

    protected String p(Method method) {
        return method.getName();
    }

    protected void q() throws d {
        h hVar = new h(this.f39861b);
        hVar.c();
        hVar.a();
    }

    protected k r(Method method) {
        return new k(method, this.f39861b);
    }
}
