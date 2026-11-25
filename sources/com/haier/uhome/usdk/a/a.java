package com.haier.uhome.usdk.a;

import com.haier.uhome.usdk.base.service.f;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f30290a = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f30292c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicLong f30294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f30295f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f30291b = new Timer();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30293d = 0;

    public a(AtomicLong atomicLong, boolean z7) {
        this.f30294e = atomicLong;
        this.f30295f = z7;
    }

    public abstract void a();

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return com.haier.uhome.usdk.base.service.a.a().b() && f.a().b();
    }

    public void c() {
        this.f30291b.cancel();
    }

    public long d() {
        return this.f30294e.get() - System.currentTimeMillis();
    }

    public void b() {
        this.f30292c = this.f30294e.get();
        this.f30291b.schedule(new TimerTask() { // from class: com.haier.uhome.usdk.a.a.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (a.this.f30294e.get() < jCurrentTimeMillis) {
                    a.this.a();
                    a.this.c();
                }
                if (a.this.f30295f) {
                    return;
                }
                if (a.this.f30293d == 0) {
                    if (!a.this.e()) {
                        a.this.f30293d = jCurrentTimeMillis;
                        return;
                    } else {
                        a aVar = a.this;
                        aVar.f30292c = aVar.f30294e.get();
                        return;
                    }
                }
                a.this.f30294e.set(a.this.f30292c + (jCurrentTimeMillis - a.this.f30293d));
                e3.a.e("dead line add %d to:%d", Long.valueOf(jCurrentTimeMillis - a.this.f30293d), Long.valueOf(a.this.f30294e.get()));
                if (a.this.e()) {
                    a.this.f30293d = 0L;
                }
            }
        }, 0L, 1000L);
    }
}
