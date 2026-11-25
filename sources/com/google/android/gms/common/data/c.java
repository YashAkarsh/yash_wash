package com.google.android.gms.common.data;

import c.m0;
import com.google.android.gms.common.internal.u;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class c<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    protected final b<T> f15552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15553b = -1;

    public c(@m0 b<T> bVar) {
        this.f15552a = (b) u.k(bVar);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15553b < this.f15552a.getCount() + (-1);
    }

    @Override // java.util.Iterator
    @m0
    public T next() {
        if (hasNext()) {
            b<T> bVar = this.f15552a;
            int i7 = this.f15553b + 1;
            this.f15553b = i7;
            return bVar.get(i7);
        }
        int i8 = this.f15553b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i8);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
