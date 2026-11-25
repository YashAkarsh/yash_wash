package org.junit.experimental.results;

import java.util.Iterator;
import java.util.List;
import org.junit.runner.j;

/* JADX INFO: loaded from: classes3.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<org.junit.runner.notification.a> f39786a;

    public a(List<org.junit.runner.notification.a> list) {
        this.f39786a = list;
    }

    public j a() {
        j jVar = new j();
        org.junit.runner.notification.b bVarF = jVar.f();
        Iterator<org.junit.runner.notification.a> it = this.f39786a.iterator();
        while (it.hasNext()) {
            try {
                bVarF.b(it.next());
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return jVar;
    }
}
