package com.haier.uhome.usdk.api.a;

import com.haier.library.common.util.a0;
import com.haier.library.common.util.b0;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f30378a = 15;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b0 f30379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.haier.uhome.search.service.entity.d f30380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.haier.uhome.search.service.entity.d f30381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile com.haier.uhome.search.service.entity.d f30382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.search.service.entity.d f30383f;

    private void b() {
        b0 b0Var = this.f30379b;
        if (b0Var != null && b0Var.b()) {
            this.f30379b.f();
        }
        this.f30379b = a0.a(15L, TimeUnit.SECONDS, new Runnable() { // from class: com.haier.uhome.usdk.api.a.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f30416a.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f30380c != null) {
            this.f30380c.b(0);
        }
    }

    private com.haier.uhome.search.service.entity.d d() {
        if (this.f30380c == null && this.f30381d == null) {
            e3.a.v("Ble event handler: adv and conn event has no newest one!", new Object[0]);
            return null;
        }
        if (this.f30380c == null) {
            return this.f30381d;
        }
        if (this.f30381d == null) {
            return this.f30380c;
        }
        if (this.f30380c.h() == 0 && this.f30381d.h() == 0) {
            return this.f30380c;
        }
        if (this.f30380c.h() == 0 && this.f30381d.h() != 0) {
            return this.f30381d;
        }
        if (this.f30380c.h() == 0 || this.f30381d.h() != 0) {
            return this.f30380c.m() >= this.f30381d.m() ? this.f30380c : this.f30381d;
        }
        return this.f30380c;
    }

    private void e() {
        com.haier.uhome.search.service.entity.d dVar;
        if (this.f30382e == null && (dVar = this.f30383f) != null) {
            b(dVar);
        } else if (this.f30382e != null) {
            b(this.f30382e);
        }
    }

    public void a(com.haier.uhome.search.service.entity.d dVar) {
        e3.a.e("Ble event handler: event = %s", dVar);
        if (dVar.h() == 1000) {
            e3.a.v("Ble event handler: device recover so clear all state codes", new Object[0]);
            a();
            return;
        }
        if (dVar.b() == 1 && !dVar.equals(this.f30381d)) {
            this.f30381d = dVar;
        }
        if (dVar.b() == 0 && !dVar.equals(this.f30380c)) {
            synchronized (this) {
                this.f30380c = dVar;
                b();
            }
        }
        com.haier.uhome.search.service.entity.d dVarD = d();
        if (dVarD != null && !dVarD.equals(this.f30382e)) {
            this.f30382e = dVarD;
            e();
        }
        if (dVar.l() != 34 || dVar.equals(this.f30383f)) {
            return;
        }
        this.f30383f = dVar;
        e();
    }

    private void b(com.haier.uhome.search.service.entity.d dVar) {
        setChanged();
        notifyObservers(dVar);
    }

    public synchronized void a() {
        a(true);
    }

    public synchronized void a(boolean z7) {
        this.f30380c = null;
        this.f30381d = null;
        this.f30382e = null;
        this.f30383f = null;
        if (z7) {
            b(new com.haier.uhome.search.service.entity.d(0));
        }
    }
}
