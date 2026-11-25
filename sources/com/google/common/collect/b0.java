package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class b0<T> extends ck<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f19948a;

    protected b0(T t7) {
        this.f19948a = t7;
    }

    protected abstract T a(T t7);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19948a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.f19948a;
        } finally {
            this.f19948a = a(this.f19948a);
        }
    }
}
