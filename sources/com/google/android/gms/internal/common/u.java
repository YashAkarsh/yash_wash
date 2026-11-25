package com.google.android.gms.internal.common;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
abstract class u<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    private T f16123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16124b = 2;

    protected u() {
    }

    @CheckForNull
    protected abstract T a();

    @CheckForNull
    protected final T b() {
        this.f16124b = 3;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i7 = this.f16124b;
        if (i7 == 4) {
            throw new IllegalStateException();
        }
        int i8 = i7 - 1;
        if (i7 == 0) {
            throw null;
        }
        if (i8 == 0) {
            return true;
        }
        if (i8 != 2) {
            this.f16124b = 4;
            this.f16123a = a();
            if (this.f16124b != 3) {
                this.f16124b = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f16124b = 2;
        T t7 = this.f16123a;
        this.f16123a = null;
        return t7;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
