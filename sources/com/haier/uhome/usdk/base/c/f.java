package com.haier.uhome.usdk.base.c;

import com.haier.uhome.usdk.base.json.BasicReq;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, BasicReq> f31245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f31246b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f31247a = new f();

        private a() {
        }
    }

    public static f a() {
        return a.f31247a;
    }

    public void b() {
        for (BasicReq basicReq : this.f31245a.values()) {
            synchronized (basicReq) {
                basicReq.notifyAll();
            }
        }
        this.f31245a.clear();
        this.f31246b.set(0);
    }

    public int c() {
        if (this.f31246b.get() == Integer.MAX_VALUE) {
            this.f31246b.set(0);
        }
        return this.f31246b.incrementAndGet();
    }

    private f() {
        this.f31245a = new ConcurrentHashMap<>();
        this.f31246b = new AtomicInteger(0);
    }

    public void a(BasicReq basicReq) {
        basicReq.init();
        this.f31245a.put(Integer.valueOf(basicReq.getSn()), basicReq);
    }

    public BasicReq a(int i7) {
        BasicReq basicReqRemove = this.f31245a.remove(Integer.valueOf(i7));
        if (basicReqRemove != null) {
            return basicReqRemove;
        }
        e3.a.o("request <" + i7 + "> already handled,so give up this request", new Object[0]);
        return null;
    }
}
