package org.junit.rules;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class h extends org.junit.runners.model.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runners.model.j f39930a;

    public h(org.junit.runners.model.j jVar, Iterable<l> iterable, org.junit.runner.c cVar) {
        this.f39930a = b(jVar, iterable, cVar);
    }

    private static org.junit.runners.model.j b(org.junit.runners.model.j jVar, Iterable<l> iterable, org.junit.runner.c cVar) {
        Iterator<l> it = iterable.iterator();
        while (it.hasNext()) {
            jVar = it.next().a(jVar, cVar);
        }
        return jVar;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        this.f39930a.a();
    }
}
