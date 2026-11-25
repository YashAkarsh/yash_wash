package org.apache.commons.lang3.concurrent;

import com.facebook.internal.a;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t7 = this.reference.get();
        if (t7 != null) {
            return t7;
        }
        T tInitialize = initialize();
        return !a.a(this.reference, null, tInitialize) ? this.reference.get() : tInitialize;
    }

    protected abstract T initialize() throws ConcurrentException;
}
