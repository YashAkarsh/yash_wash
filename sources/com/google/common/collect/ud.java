package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface ud<E> extends Iterator<E> {
    @u1.a
    E next();

    E peek();

    @Override // java.util.Iterator
    void remove();
}
