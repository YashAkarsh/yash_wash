package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.c> f14741a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.request.c> f14742b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14743c;

    void a(com.bumptech.glide.request.c cVar) {
        this.f14741a.add(cVar);
    }

    public void b() {
        Iterator it = com.bumptech.glide.util.i.i(this.f14741a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.c) it.next()).clear();
        }
        this.f14742b.clear();
    }

    public boolean c() {
        return this.f14743c;
    }

    public void d() {
        this.f14743c = true;
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.util.i.i(this.f14741a)) {
            if (cVar.isRunning()) {
                cVar.pause();
                this.f14742b.add(cVar);
            }
        }
    }

    public void e(com.bumptech.glide.request.c cVar) {
        this.f14741a.remove(cVar);
        this.f14742b.remove(cVar);
    }

    public void f() {
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.util.i.i(this.f14741a)) {
            if (!cVar.j() && !cVar.isCancelled()) {
                cVar.pause();
                if (this.f14743c) {
                    this.f14742b.add(cVar);
                } else {
                    cVar.i();
                }
            }
        }
    }

    public void g() {
        this.f14743c = false;
        for (com.bumptech.glide.request.c cVar : com.bumptech.glide.util.i.i(this.f14741a)) {
            if (!cVar.j() && !cVar.isCancelled() && !cVar.isRunning()) {
                cVar.i();
            }
        }
        this.f14742b.clear();
    }

    public void h(com.bumptech.glide.request.c cVar) {
        this.f14741a.add(cVar);
        if (this.f14743c) {
            this.f14742b.add(cVar);
        } else {
            cVar.i();
        }
    }
}
