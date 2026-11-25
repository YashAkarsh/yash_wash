package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class q5<T> extends b6 implements Iterator<T> {
    protected q5() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public abstract Iterator<T> c0();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return c0().hasNext();
    }

    @u1.a
    public T next() {
        return c0().next();
    }

    public void remove() {
        c0().remove();
    }
}
