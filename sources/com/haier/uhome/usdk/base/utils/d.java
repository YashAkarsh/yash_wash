package com.haier.uhome.usdk.base.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f31393a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<E> f31394b = new LinkedList<>();

    public boolean a() {
        return this.f31393a.get();
    }

    public synchronized List<E> b() {
        return new ArrayList(this.f31394b);
    }

    public synchronized E c() {
        if (this.f31394b.size() <= 0) {
            return null;
        }
        return this.f31394b.getFirst();
    }

    public boolean d() {
        return this.f31393a.compareAndSet(false, true);
    }

    public boolean e() {
        return this.f31393a.compareAndSet(true, false);
    }

    public synchronized void f() {
        this.f31394b.clear();
    }

    public synchronized void a(E e8) {
        this.f31394b.addLast(e8);
    }
}
