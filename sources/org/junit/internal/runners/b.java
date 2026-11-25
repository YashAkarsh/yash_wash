package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Throwable> f39853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f39854b;

    public b(Class<?> cls, Throwable th) {
        if (cls == null) {
            throw new NullPointerException("Test class cannot be null");
        }
        this.f39854b = cls;
        this.f39853a = g(th);
    }

    private org.junit.runner.c f(Throwable th) {
        return org.junit.runner.c.f(this.f39854b, "initializationError");
    }

    private List<Throwable> g(Throwable th) {
        if (th instanceof InvocationTargetException) {
            return g(th.getCause());
        }
        if (th instanceof org.junit.runners.model.e) {
            return ((org.junit.runners.model.e) th).a();
        }
        return th instanceof d ? ((d) th).a() : Arrays.asList(th);
    }

    private void h(Throwable th, org.junit.runner.notification.c cVar) {
        org.junit.runner.c cVarF = f(th);
        cVar.l(cVarF);
        cVar.f(new org.junit.runner.notification.a(cVarF, th));
        cVar.h(cVarF);
    }

    @Override // org.junit.runner.l
    public void a(org.junit.runner.notification.c cVar) {
        Iterator<Throwable> it = this.f39853a.iterator();
        while (it.hasNext()) {
            h(it.next(), cVar);
        }
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        org.junit.runner.c cVarC = org.junit.runner.c.c(this.f39854b);
        Iterator<Throwable> it = this.f39853a.iterator();
        while (it.hasNext()) {
            cVarC.a(f(it.next()));
        }
        return cVarC;
    }
}
