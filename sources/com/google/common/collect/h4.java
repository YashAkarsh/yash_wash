package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
class h4<T> extends e<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<T> f20362c;

    h4(T... tArr) {
        ArrayDeque arrayDeque = new ArrayDeque(tArr.length);
        this.f20362c = arrayDeque;
        Collections.addAll(arrayDeque, tArr);
    }

    @Override // com.google.common.collect.e
    public T a() {
        return this.f20362c.isEmpty() ? b() : this.f20362c.remove();
    }

    h4(Queue<T> queue) {
        this.f20362c = (Queue) com.google.common.base.e0.E(queue);
    }
}
