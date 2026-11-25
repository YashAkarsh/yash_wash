package org.junit.internal.runners.model;

import java.util.Iterator;
import org.junit.runners.model.f;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runner.notification.c f39879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.junit.runner.c f39880b;

    public a(org.junit.runner.notification.c cVar, org.junit.runner.c cVar2) {
        this.f39879a = cVar;
        this.f39880b = cVar2;
    }

    private void c(f fVar) {
        Iterator<Throwable> it = fVar.b().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public void a(org.junit.internal.b bVar) {
        this.f39879a.e(new org.junit.runner.notification.a(this.f39880b, bVar));
    }

    public void b(Throwable th) {
        if (th instanceof f) {
            c((f) th);
        } else {
            this.f39879a.f(new org.junit.runner.notification.a(this.f39880b, th));
        }
    }

    public void d() {
        this.f39879a.h(this.f39880b);
    }

    public void e() {
        this.f39879a.i(this.f39880b);
    }

    public void f() {
        this.f39879a.l(this.f39880b);
    }
}
