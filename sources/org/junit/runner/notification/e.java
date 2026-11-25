package org.junit.runner.notification;

import org.junit.runner.j;

/* JADX INFO: loaded from: classes3.dex */
@b.a
final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f40017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f40018b;

    e(b bVar, Object obj) {
        this.f40017a = bVar;
        this.f40018b = obj;
    }

    @Override // org.junit.runner.notification.b
    public void a(a aVar) {
        synchronized (this.f40018b) {
            this.f40017a.a(aVar);
        }
    }

    @Override // org.junit.runner.notification.b
    public void b(a aVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.b(aVar);
        }
    }

    @Override // org.junit.runner.notification.b
    public void c(org.junit.runner.c cVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.c(cVar);
        }
    }

    @Override // org.junit.runner.notification.b
    public void d(org.junit.runner.c cVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.d(cVar);
        }
    }

    @Override // org.junit.runner.notification.b
    public void e(j jVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.e(jVar);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f40017a.equals(((e) obj).f40017a);
        }
        return false;
    }

    @Override // org.junit.runner.notification.b
    public void f(org.junit.runner.c cVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.f(cVar);
        }
    }

    @Override // org.junit.runner.notification.b
    public void g(org.junit.runner.c cVar) throws Exception {
        synchronized (this.f40018b) {
            this.f40017a.g(cVar);
        }
    }

    public int hashCode() {
        return this.f40017a.hashCode();
    }

    public String toString() {
        return this.f40017a.toString() + " (with synchronization wrapper)";
    }
}
