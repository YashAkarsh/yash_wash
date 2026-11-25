package org.junit.internal.runners.statements;

import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f39910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f39911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<org.junit.runners.model.d> f39912c;

    public f(j jVar, List<org.junit.runners.model.d> list, Object obj) {
        this.f39910a = jVar;
        this.f39912c = list;
        this.f39911b = obj;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        Iterator<org.junit.runners.model.d> it = this.f39912c.iterator();
        while (it.hasNext()) {
            it.next().m(this.f39911b, new Object[0]);
        }
        this.f39910a.a();
    }
}
