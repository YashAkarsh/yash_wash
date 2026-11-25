package com.google.android.gms.common.api;

import c.m0;
import com.google.android.gms.common.api.t;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class n<R extends t> {

    @c1.a
    public interface a {
        @c1.a
        void a(@m0 Status status);
    }

    @c1.a
    public void c(@m0 a aVar) {
        throw new UnsupportedOperationException();
    }

    @m0
    public abstract R d();

    @m0
    public abstract R e(long j7, @m0 TimeUnit timeUnit);

    public abstract void f();

    public abstract boolean g();

    public abstract void h(@m0 u<? super R> uVar);

    public abstract void i(@m0 u<? super R> uVar, long j7, @m0 TimeUnit timeUnit);

    @m0
    public <S extends t> x<S> j(@m0 w<? super R, ? extends S> wVar) {
        throw new UnsupportedOperationException();
    }
}
