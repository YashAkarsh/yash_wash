package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class h0 {
    private h0() {
    }

    public static <V> AtomicReference<V> a() {
        return new AtomicReference<>();
    }

    public static <V> AtomicReference<V> b(V v7) {
        return new AtomicReference<>(v7);
    }

    public static <E> AtomicReferenceArray<E> c(int i7) {
        return new AtomicReferenceArray<>(i7);
    }

    public static <E> AtomicReferenceArray<E> d(E[] eArr) {
        return new AtomicReferenceArray<>(eArr);
    }
}
