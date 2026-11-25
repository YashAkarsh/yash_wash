package com.haier.uhome.qrcode.bind.a;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f29559a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Timer f29560b = new Timer();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicLong f29561c;

    public c(AtomicLong atomicLong) {
        this.f29561c = atomicLong;
    }

    public abstract void a();

    public void b() {
        this.f29560b.schedule(new TimerTask() { // from class: com.haier.uhome.qrcode.bind.a.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (c.this.f29561c.get() < System.currentTimeMillis()) {
                    c.this.a();
                    c.this.d();
                }
            }
        }, 0L, 1000L);
    }

    public long c() {
        return this.f29561c.get() - System.currentTimeMillis();
    }

    public void d() {
        this.f29560b.cancel();
    }
}
