package org.chromium.base;

/* JADX INFO: loaded from: classes3.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f38970a;

    public w() {
        c();
    }

    private void c() {
        if (this.f38970a == null) {
            this.f38970a = Long.valueOf(Thread.currentThread().getId());
        }
    }

    public synchronized boolean a() {
        c();
        return this.f38970a.equals(Long.valueOf(Thread.currentThread().getId()));
    }

    @s0
    public synchronized void b() {
        this.f38970a = null;
    }
}
