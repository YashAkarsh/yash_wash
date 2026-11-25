package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private org.junit.runner.notification.c f39849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f39850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private org.junit.runner.c f39851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f39852d;

    public a(org.junit.runner.notification.c cVar, j jVar, org.junit.runner.c cVar2, Runnable runnable) {
        this.f39849a = cVar;
        this.f39850b = jVar;
        this.f39851c = cVar2;
        this.f39852d = runnable;
    }

    private void b() {
        Iterator<Method> it = this.f39850b.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(null, new Object[0]);
            } catch (InvocationTargetException e8) {
                a(e8.getTargetException());
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    private void c() throws c {
        try {
            try {
                Iterator<Method> it = this.f39850b.c().iterator();
                while (it.hasNext()) {
                    it.next().invoke(null, new Object[0]);
                }
            } catch (InvocationTargetException e8) {
                throw e8.getTargetException();
            }
        } catch (org.junit.internal.b unused) {
            throw new c();
        } catch (Throwable th) {
            a(th);
            throw new c();
        }
    }

    protected void a(Throwable th) {
        this.f39849a.f(new org.junit.runner.notification.a(this.f39851c, th));
    }

    public void d() {
        try {
            c();
            e();
        } catch (c unused) {
        } finally {
            b();
        }
    }

    protected void e() {
        this.f39852d.run();
    }
}
