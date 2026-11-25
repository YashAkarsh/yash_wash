package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CatchAndRethrowClosure<E> implements Closure<E> {
    @Override // org.apache.commons.collections4.Closure
    public void execute(E e8) {
        try {
            executeAndThrow(e8);
        } catch (RuntimeException e9) {
            throw e9;
        } catch (Throwable th) {
            throw new FunctorException(th);
        }
    }

    protected abstract void executeAndThrow(E e8) throws Throwable;
}
