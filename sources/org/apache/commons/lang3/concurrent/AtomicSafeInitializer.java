package org.apache.commons.lang3.concurrent;

import com.facebook.internal.a;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public final T get() throws ConcurrentException {
        while (true) {
            T t7 = this.reference.get();
            if (t7 != null) {
                return t7;
            }
            if (a.a(this.factory, null, this)) {
                this.reference.set(initialize());
            }
        }
    }

    protected abstract T initialize() throws ConcurrentException;
}
