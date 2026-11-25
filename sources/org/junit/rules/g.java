package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class g implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f39928b = new g(Collections.emptyList());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<l> f39929a;

    private g(List<l> list) {
        this.f39929a = list;
    }

    public static g c() {
        return f39928b;
    }

    public static g d(l lVar) {
        return c().b(lVar);
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        Iterator<l> it = this.f39929a.iterator();
        while (it.hasNext()) {
            jVar = it.next().a(jVar, cVar);
        }
        return jVar;
    }

    public g b(l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.addAll(this.f39929a);
        return new g(arrayList);
    }
}
