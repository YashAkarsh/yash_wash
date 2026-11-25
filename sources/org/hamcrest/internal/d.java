package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.m;

/* JADX INFO: loaded from: classes3.dex */
public class d<T> implements Iterator<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator<T> f39734a;

    public d(Iterator<T> it) {
        this.f39734a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public m next() {
        return new c(this.f39734a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f39734a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f39734a.remove();
    }
}
