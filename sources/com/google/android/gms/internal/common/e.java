package com.google.android.gms.internal.common;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e<E> extends b<E> {
    public e() {
        super(4);
    }

    public final e<E> c(E e8) {
        super.a(e8);
        return this;
    }

    public final e<E> d(Iterator<? extends E> it) {
        while (it.hasNext()) {
            super.a(it.next());
        }
        return this;
    }

    e(int i7) {
        super(4);
    }
}
