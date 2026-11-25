package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.h;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<h> f27028a = new LinkedHashSet();

    public synchronized void a(h hVar) {
        this.f27028a.add(hVar);
    }

    public synchronized void b(h hVar) {
        this.f27028a.remove(hVar);
    }

    public synchronized boolean c(h hVar) {
        return this.f27028a.contains(hVar);
    }
}
