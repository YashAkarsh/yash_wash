package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.m;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Throwable> f39874a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f39875b;

    public h(j jVar) {
        this.f39875b = jVar;
    }

    private void f(Class<? extends Annotation> cls, boolean z7) {
        for (Method method : this.f39875b.b(cls)) {
            if (Modifier.isStatic(method.getModifiers()) != z7) {
                String str = z7 ? "should" : "should not";
                this.f39874a.add(new Exception("Method " + method.getName() + "() " + str + " be static"));
            }
            if (!Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                this.f39874a.add(new Exception("Class " + method.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                this.f39874a.add(new Exception("Method " + method.getName() + " should be public"));
            }
            if (method.getReturnType() != Void.TYPE) {
                this.f39874a.add(new Exception("Method " + method.getName() + " should be void"));
            }
            if (method.getParameterTypes().length != 0) {
                this.f39874a.add(new Exception("Method " + method.getName() + " should have no parameters"));
            }
        }
    }

    public void a() throws d {
        if (!this.f39874a.isEmpty()) {
            throw new d(this.f39874a);
        }
    }

    public void b() {
        f(org.junit.a.class, false);
        f(org.junit.f.class, false);
        f(m.class, false);
        if (this.f39875b.b(m.class).size() == 0) {
            this.f39874a.add(new Exception("No runnable methods"));
        }
    }

    public List<Throwable> c() {
        d();
        e();
        b();
        return this.f39874a;
    }

    public void d() {
        try {
            this.f39875b.d();
        } catch (Exception e8) {
            this.f39874a.add(new Exception("Test class should have public zero-argument constructor", e8));
        }
    }

    public void e() {
        f(org.junit.g.class, true);
        f(org.junit.b.class, true);
    }
}
