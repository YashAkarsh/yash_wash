package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<h> f14716a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14718c;

    a() {
    }

    @Override // com.bumptech.glide.manager.g
    public void a(h hVar) {
        this.f14716a.add(hVar);
        if (this.f14718c) {
            hVar.k();
        } else if (this.f14717b) {
            hVar.onStart();
        } else {
            hVar.g();
        }
    }

    void b() {
        this.f14718c = true;
        Iterator it = com.bumptech.glide.util.i.i(this.f14716a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).k();
        }
    }

    void c() {
        this.f14717b = true;
        Iterator it = com.bumptech.glide.util.i.i(this.f14716a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).onStart();
        }
    }

    void d() {
        this.f14717b = false;
        Iterator it = com.bumptech.glide.util.i.i(this.f14716a).iterator();
        while (it.hasNext()) {
            ((h) it.next()).g();
        }
    }
}
