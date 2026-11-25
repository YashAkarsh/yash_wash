package com.google.android.gms.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class m<TResult> {
    @c.m0
    public m<TResult> a(@c.m0 Activity activity, @c.m0 e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @c.m0
    public m<TResult> b(@c.m0 e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @c.m0
    public m<TResult> c(@c.m0 Executor executor, @c.m0 e eVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @c.m0
    public m<TResult> d(@c.m0 Activity activity, @c.m0 f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @c.m0
    public m<TResult> e(@c.m0 f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @c.m0
    public m<TResult> f(@c.m0 Executor executor, @c.m0 f<TResult> fVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @c.m0
    public abstract m<TResult> g(@c.m0 Activity activity, @c.m0 g gVar);

    @c.m0
    public abstract m<TResult> h(@c.m0 g gVar);

    @c.m0
    public abstract m<TResult> i(@c.m0 Executor executor, @c.m0 g gVar);

    @c.m0
    public abstract m<TResult> j(@c.m0 Activity activity, @c.m0 h<? super TResult> hVar);

    @c.m0
    public abstract m<TResult> k(@c.m0 h<? super TResult> hVar);

    @c.m0
    public abstract m<TResult> l(@c.m0 Executor executor, @c.m0 h<? super TResult> hVar);

    @c.m0
    public <TContinuationResult> m<TContinuationResult> m(@c.m0 c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @c.m0
    public <TContinuationResult> m<TContinuationResult> n(@c.m0 Executor executor, @c.m0 c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @c.m0
    public <TContinuationResult> m<TContinuationResult> o(@c.m0 c<TResult, m<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @c.m0
    public <TContinuationResult> m<TContinuationResult> p(@c.m0 Executor executor, @c.m0 c<TResult, m<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @c.o0
    public abstract Exception q();

    public abstract TResult r();

    public abstract <X extends Throwable> TResult s(@c.m0 Class<X> cls) throws Throwable;

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    @c.m0
    public <TContinuationResult> m<TContinuationResult> w(@c.m0 l<TResult, TContinuationResult> lVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @c.m0
    public <TContinuationResult> m<TContinuationResult> x(@c.m0 Executor executor, @c.m0 l<TResult, TContinuationResult> lVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
