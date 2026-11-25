package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<w0.c, b> f14307a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0165c f14308b = new C0165c();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f14309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14310b;

        private b() {
            this.f14309a = new ReentrantLock();
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.cache.c$c, reason: collision with other inner class name */
    private static class C0165c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f14311b = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<b> f14312a;

        private C0165c() {
            this.f14312a = new ArrayDeque();
        }

        b a() {
            b bVarPoll;
            synchronized (this.f14312a) {
                bVarPoll = this.f14312a.poll();
            }
            return bVarPoll == null ? new b() : bVarPoll;
        }

        void b(b bVar) {
            synchronized (this.f14312a) {
                if (this.f14312a.size() < 10) {
                    this.f14312a.offer(bVar);
                }
            }
        }
    }

    c() {
    }

    void a(w0.c cVar) {
        b bVarA;
        synchronized (this) {
            bVarA = this.f14307a.get(cVar);
            if (bVarA == null) {
                bVarA = this.f14308b.a();
                this.f14307a.put(cVar, bVarA);
            }
            bVarA.f14310b++;
        }
        bVarA.f14309a.lock();
    }

    void b(w0.c cVar) {
        b bVar;
        int i7;
        synchronized (this) {
            bVar = this.f14307a.get(cVar);
            if (bVar != null && (i7 = bVar.f14310b) > 0) {
                int i8 = i7 - 1;
                bVar.f14310b = i8;
                if (i8 == 0) {
                    b bVarRemove = this.f14307a.remove(cVar);
                    if (!bVarRemove.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVarRemove + ", key: " + cVar);
                    }
                    this.f14308b.b(bVarRemove);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot release a lock that is not held, key: ");
            sb.append(cVar);
            sb.append(", interestedThreads: ");
            sb.append(bVar == null ? 0 : bVar.f14310b);
            throw new IllegalArgumentException(sb.toString());
        }
        bVar.f14309a.unlock();
    }
}
