package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.h;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class b<T extends h> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14259b = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f14260a = com.bumptech.glide.util.i.d(20);

    b() {
    }

    protected abstract T a();

    protected T b() {
        T tPoll = this.f14260a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t7) {
        if (this.f14260a.size() < 20) {
            this.f14260a.offer(t7);
        }
    }
}
