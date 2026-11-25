package com.google.common.util.concurrent;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
@Deprecated
public abstract class b<V, X extends Exception> extends a1.a<V> implements j0<V, X> {
    protected b(l1<V> l1Var) {
        super(l1Var);
    }

    @Override // com.google.common.util.concurrent.j0
    @u1.a
    public V J(long j7, TimeUnit timeUnit) throws Exception {
        try {
            return get(j7, timeUnit);
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw f0(e8);
        } catch (CancellationException e9) {
            e = e9;
            throw f0(e);
        } catch (ExecutionException e10) {
            e = e10;
            throw f0(e);
        }
    }

    protected abstract X f0(Exception exc);

    @Override // com.google.common.util.concurrent.j0
    @u1.a
    public V w() throws Exception {
        try {
            return get();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw f0(e8);
        } catch (CancellationException e9) {
            e = e9;
            throw f0(e);
        } catch (ExecutionException e10) {
            e = e10;
            throw f0(e);
        }
    }
}
